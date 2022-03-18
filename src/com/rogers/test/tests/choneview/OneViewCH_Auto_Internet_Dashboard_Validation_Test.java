package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_Internet_Dashboard_Validation_Test extends BaseTestClass {
    @Test(groups = {"RegressionCHOV", "SanityCHOV", "SanityCHOVTemp"})
    public void oneViewCH_Auto_Internet_Dashboard_Validation_Test() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Internet_Dashboard_Validation.accountDetails.getBan(),TestDataHandler.Internet_Dashboard_Validation.getContactID());
        reporter.reportLogWithScreenshot("One view page launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched the internet dashboard page");
        reporter.softAssert(getInternetDashboardPage().verifyHeader(), "Header is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Header available on internet Dashboard page");
        reporter.softAssert(getInternetDashboardPage().verifyFooter(), "Footer is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Footer available on internet Dashboard page");
        reporter.hardAssert(getInternetDashboardPage().verifyUsageAndAlerts(), "Usage and Alerts link Available","Usage and Alerts link not Available");
        reporter.reportLogWithScreenshot("View Usgae and Alert link displayed");
        reporter.hardAssert(getInternetDashboardPage().verifyChangePackageButton(), "Change Package Button Available","Change Package Button not Available");
        reporter.reportLogWithScreenshot("Change package buton displayed");
        reporter.hardAssert(getInternetDashboardPage().verifyAddPodsButton(), "Add Pods Button Available","Add Pods Button not Available");
        reporter.reportLogWithScreenshot("Add Pods button displayed");


    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","", method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
