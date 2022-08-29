package com.rogers.test.tests.choneview;


import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_REG_Auto_TC054_Account_Overview_Page_Make_a_Payment_ON_EN extends BaseTestClass {

    @Test(groups = {"RegressionCHOV"})
    public void oneViewCH_REG_Auto_TC054_Account_Overview_Page_Make_a_Payment_ON_EN (){
        // getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Make_a_Payment_EN.getAccountNo(),TestDataHandler.Make_a_Payment_EN.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().clickBillinglink();
        reporter.reportLogWithScreenshot("Launched the Billing dashboard page");
        getDashboardBillingPage().clickMakePayment();
        reporter.reportLogWithScreenshot("Make Payment Button clicked");
        getDashboardBillingPage().selectDigitalFrontLine();
        reporter.reportLogWithScreenshot("Changed Channel from voice frontline to Digital");
        getDashboardBillingPage().enterPaymentAmount(TestDataHandler.anonymousData.getcontactDetails().getPaymentAmount());
        getDashboardBillingPage().SelectTokenNumber(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
        reporter.reportLogWithScreenshot("Token Entered");
        getDashboardBillingPage().selectExpiryMonth();
        reporter.reportLogWithScreenshot("Expiry Month of Credit card selected");
        getDashboardBillingPage().selectExpiryYear();
        reporter.reportLogWithScreenshot("Expiry Year of Credit card selected");
        getDashboardBillingPage().selectSecurityCode(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
        reporter.reportLogWithScreenshot("Credit Card Security Code Entered");
        getDashboardBillingPage().selectSignUp();
        reporter.reportLogWithScreenshot("Sign Up Checkbox Selected");
        getDashboardBillingPage().continuePayment();
       reporter.reportLogWithScreenshot("Continue Button clicked");
       getDashboardBillingPage().clickPayNow();
        reporter.reportLogWithScreenshot("Pay Now button clicked");
        getDashboardBillingPage().clickDone();  /*optional step*/
        reporter.reportLogWithScreenshot("Done Button Clicked");  /*optional step*/
       reporter.reportLogWithScreenshot("Payment made");



    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","", "", method);
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }
}

