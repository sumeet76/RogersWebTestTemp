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
     * @param dbEnv
     * @return
     */
    public synchronized DBValidation connectionMethod(String dbEnv) {
        System.out.println("DB Environment details" + dbEnv);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            switch (dbEnv.toLowerCase()) {
                case "sft04":
                    connect = DriverManager.getConnection("jdbc:oracle:thin:@BHPDB473:1526:V21QA4","QA4APPBL19","QA4APPBL19");
                    break;
                case "sft06":
                    connect = DriverManager.getConnection("jdbc:oracle:thin:@BHPDB474:1526:V21QA6", "QA6APPBL26", "QA6APPBL26");
                    break;
                case "sft02":
                    connect = DriverManager.getConnection("jdbc:oracle:thin:@BHPDB471:1526:V21QA2", "QA2APPBL02", "QA2APPBL02");
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
}

