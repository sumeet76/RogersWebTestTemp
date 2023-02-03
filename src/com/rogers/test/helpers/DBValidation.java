package com.rogers.test.helpers;


import com.rogers.test.base.BaseTestClass;

import java.sql.*;
import java.util.*;

public class DBValidation extends BaseTestClass{

    public static Connection connect;
    public static Statement statement;
    public static Map<Object, Object> resultMap;
    /**
     * Method will execute the query in the DB, if commit is true then the executed code will be committed.
     *
     * @param sqlQuery sql query which has to be executed
     * @param commit   set true if you want to commit the changes in the data base.
     * @return Map - Results are returned as map
     */
    public synchronized Map<Object, Object> executeDBQuery(String sqlQuery, boolean commit) {
        resultMap = new HashMap<>();
        try {
            ResultSet result = statement.executeQuery(sqlQuery);
            if (commit) {
                connect.commit();
            }
            int columnCount = result.getMetaData().getColumnCount();
            ResultSetMetaData meta = result.getMetaData();
            while (result.next()) {
                for (int count = 1; count <= columnCount; count++) {
                    System.out.println(meta.getColumnLabel(count) + ":" + result.getString(count));
                    resultMap.put(meta.getColumnLabel(count), result.getString(count));
                }
            }
            statement.close();
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
            reporter.reportLog("Exception occurred while executing the Query, please " +
                    "check the query" + e.getMessage());
        }

        return resultMap;
    }


    /**
     * This method will create a connection and return DBValidation object
     * @param dbEnv database environment details like sft02 / sft04 / sft06
     * @return DBValidation object after creating statement.
     */
    public synchronized DBValidation connectionMethod(String dbEnv) {
        System.out.println("DB Environment details" + dbEnv);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            switch (dbEnv.toLowerCase()) {
                case "sft04":
                    connect = DriverManager.getConnection("jdbc:oracle:thin:@exa010ldcs-npe.rci.rogers.com:1526/V21QA4_SN.rci.rogers.com","qa4sel","qa4sel");
                    break;
                case "sft06":
                    connect = DriverManager.getConnection("jdbc:oracle:thin:@ex010ldcnp:1526/V21QA6_SN.rci.rogers.com", "qa6sel", "qa6sel");
                    break;
                case "sft02":
                    connect = DriverManager.getConnection("jdbc:oracle:thin:@ex010ldcnp:1526/V21QA2_SN.rci.rogers.com", "qa2sel", "qa2sel");
                    break;
            }
            connect.setAutoCommit(false);
            statement = connect.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            getReporter().reportLog("DB Connection error" + e.getMessage());
        }
        return this;
    }

    public String getSchemaName(String dbEnvUrl) {
        HashMap<String, String> map = new HashMap<>();
        map.put("sft04", "QA4APPBL19");
        map.put("sft06", "QA6APPBL26");
        map.put("sft02", "QA2APPBL02");

        String dbEnvUrlStr = dbEnvUrl.toLowerCase();
        return map.getOrDefault(dbEnvUrlStr, "QA2APPBL02");
    }
}

