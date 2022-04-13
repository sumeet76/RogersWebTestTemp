package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_2557_TC02_View_Bill_Test extends BaseTestClass {
    @Test (groups = {"Regression"})
    public void oneViewCH_Auto_2557_TC02_View_Bill_Test() {
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.ViewBill.getAccountNo(),TestDataHandler.ViewBill.getContactID());
        getAccountOverViewPage().clickBillinglink();
//        reporter.hardAssert(getAccountOverViewPage().verifyProfilePage(),"Profile page is displaye","profile Page is not displayed");
        reporter.reportLogWithScreenshot("Billing link is opened");
        getAccountOverViewPage().scrollToViewBill();
        reporter.reportLogWithScreenshot("scroll To View Bill");
        getAccountOverViewPage().moveToiframe();
        reporter.hardAssert(getAccountOverViewPage().verifyRequiredMessage(),"Header displayed","Header not displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyBillAmount(),"Bill amount is displayed","Bill amount is not displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyWelcomeText(),"Welcome text is displayed","Welcome text is not displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyBillMessage(),"Bill message is displayed","Bill message is not displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyProductDisplayed(),"Product is displayed","Product is not displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyAccountMessages(),"Account message is displayed","Account message is not displayed");

        reporter.reportLogWithScreenshot("Test Passed");
    }

        @BeforeMethod(alwaysRun=true)
        @Parameters({"strBrowser","strLanguage"})
        public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext
        testContext, Method method)throws ClientProtocolException, IOException {
            startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
        }

        @AfterMethod(alwaysRun=true)
        public void afterTest(){
            closeSession();
    }
}