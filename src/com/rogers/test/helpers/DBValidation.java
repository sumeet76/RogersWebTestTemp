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
    public DBValidation executeDBQuery(String sqlQuery, boolean commit) {
        resultMap = new HashMap<>();
        try {
            ResultSet result = statement.executeQuery(sqlQuery);
            if (commit) {
                connect.commit();
            }
            int columnCount = result.getMetaData().getColumnCount();
            ResultSetMetaData meta = result.getMetaData();
            while (result.next()) {
                for (int count = 1; count < columnCount; count++) {
                    System.out.println(meta.getColumnLabel(count) + ":" + result.getString(count));
                    resultMap.put(meta.getColumnLabel(count), result.getString(count));
                }
            }
            statement.close();
            connect.close();
        } catch (SQLException e) {
            new BaseTestClass().reporter.reportLog("Exception occurred while executing the Query, please " +
                    "check the query" + e.getMessage());
            e.printStackTrace();
        }

        return this;
    }

    /**
     * Method to return the single value retrieved from the Database.
     *
     * @param key - Table Column value
     * @return String
     */
    public String getDBValue(String key) {
        return resultMap.get(key).toString();
    }

    /**
     * Method to return the list of values from the Database. User has to send the column values as a list in the parameters.
     *
     * @param keyList - List of column values
     * @return List<Object> - results are returned as List
     */
    public List<Object> getDBValues(String[] keyList) {
        List<Object> objects = new ArrayList<>();
        for (String key : keyList) {
            objects.add(resultMap.get(key).toString());
        }
        return objects;
    }

    public DBValidation connectionMethod(String dbEnv) {
        System.out.println("DB Environment details" + dbEnv);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            switch (dbEnv.toLowerCase()) {
                case "sft04":
                    connect = DriverManager.getConnection("jdbc:oracle:thin:@BHPDB473:1526:V21QA4",System.getenv("SFT04"),System.getenv("SFT04"));
                    break;
                case "sft06":
                    connect = DriverManager.getConnection("jdbc:oracle:thin:@BHPDB474:1526:V21QA6", System.getenv("SFT06"), System.getenv("SFT06"));
                    break;
                case "sft02":
                    connect = DriverManager.getConnection("jdbc:oracle:thin:@BHPDB471:1526:V21QA2", System.getenv("SFT02"), System.getenv("SFT02"));
                    break;
            }
            connect.setAutoCommit(false);
            statement = connect.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            new BaseTestClass().reporter.reportLog("DB Connection error" + e.getMessage());
        }
        return this;
    }
}

