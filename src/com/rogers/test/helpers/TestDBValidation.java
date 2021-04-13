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

        DBValidation db = new DBValidation();
        db.connectionMethod("sft02");
        db.executeDBQuery("select * from subscriber where SUBSCRIBER_NO='2042272133'", false);
        System.out.println(" DB Value retrieved from the list : " + db.getDBValue("CUSTOMER_BAN"));
        List<Object> dbValues = db.getDBValues(new String[]{"CUSTOMER_ID", "SUBSCRIBER_NO", "CTN_SEQ_NO", "EFFECTIVE_DATE"});
        System.out.println(dbValues);

        System.out.println("Base Class");
        List<Object> sft02 = getDbConnection().connectionMethod("sft02")
                .executeDBQuery("select * from subscriber where SUBSCRIBER_NO='2042272133'", false)
                .getDBValues(new String[]{"CUSTOMER_ID", "SUBSCRIBER_NO", "CTN_SEQ_NO", "EFFECTIVE_DATE"});


    }
}
