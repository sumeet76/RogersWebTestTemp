package com.rogers.test.helpers;

import com.rogers.test.base.BaseTestClass;
import org.apache.xmlbeans.soap.SOAPArrayType;

import java.sql.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestDBValidation extends BaseTestClass {

    protected static Connection connect;
    protected static Statement statement;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

//        DBValidation db = new DBValidation();
//        db.connectionMethod("sft04");
//        db.executeDBQuery("select * from subscriber where customer_id=947824371", false);
//        System.out.println(" DB Value retrieved from the list : " + db.getDBValue("CUSTOMER_BAN"));
//        List<Object> dbValues = db.getDBValues(new String[]{"CUSTOMER_ID", "SUBSCRIBER_NO", "CTN_SEQ_NO", "EFFECTIVE_DATE"});
//        System.out.println(dbValues);

        System.out.println("Base Class");
        getDbConnection().connectionMethod("sft04")
                .executeDBQuery("select * from subscriber where customer_id='947824371'", false);
                //.getDBValues(new String[]{"CUSTOMER_ID", "SUBSCRIBER_NO", "CTN_SEQ_NO", "EFFECTIVE_DATE"});


    }
}
