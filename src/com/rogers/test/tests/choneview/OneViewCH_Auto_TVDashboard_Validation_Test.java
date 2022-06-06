package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TVDashboard_Validation_Test extends BaseTestClass {
    @Test(groups = {"RegressionCHOV", "SanityCHOV", "SanityCHOVTemp","MaySanity"})
    public void oneViewCH_Auto_TVDashboard_Validation_Test(){
        //getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Tv_Dashboard_Validation.accountDetails.getBan(), TestDataHandler.Tv_Dashboard_Validation.getContactID());
        //reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().selectTVBadage();
        reporter.reportLogWithScreenshot("Launched the TV dashboard page");

        reporter.softAssert(getTVDashboardPage().verifyHeader(), "Header is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Header available on TV Dashboard page");
        reporter.softAssert(getTVDashboardPage().verifyFooter(), "Footer is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Footer available on TV Dashboard page");
        reporter.hardAssert(getTVDashboardPage().verifyExchangeFlexChannels(), "View My Flex Channels Available","View My Flex Channels not Available");
        reporter.reportLogWithScreenshot("View my fles Channels link displayed");
        reporter.hardAssert(getTVDashboardPage().verifyViewMyChannelLineUpLink(), "View My channel lineup link Available","View My channel lineup link not Available");
        reporter.reportLogWithScreenshot("View my channel lineup displayed");
        reporter.hardAssert(getTVDashboardPage().verifyManageChannelsAndThemePacks(), "Manage Channels and Theme Packs Available","manage Channels and Themepacks not available");
        reporter.reportLogWithScreenshot("Manage channels and theme pack button displayed");
        reporter.hardAssert(getTVDashboardPage().verifyExchangeFlexChannels(), "Exchange Flex channels Available","Exchange Flex channels not Available");
        reporter.reportLogWithScreenshot("Exchange Flex channels button displayed");
        reporter.hardAssert(getTVDashboardPage().verifyChangeTvPackage(), "Change Tv Package Available","Change Tv Package not Available");
        reporter.reportLogWithScreenshot("Change TV package button displayed ");
        reporter.hardAssert(getTVDashboardPage().verifyRestartSetUpBox(), "Restart Setup Box link Available","Restart Setup Box link not Available");
        reporter.reportLogWithScreenshot("Restart setup box link displayed");
        getTVDashboardPage().clickRestartSetupbox();
        reporter.reportLogWithScreenshot("Restart setup box link clicked");
        getTVDashboardPage().clickCancel();
        reporter.reportLogWithScreenshot("Closing Restart setup box");
        reporter.hardAssert(getTVDashboardPage().verifyResetPurchasePin(), "Reset Purchase pin Available","Reset Purchase pin not Available");
        reporter.reportLogWithScreenshot("Reset purchase pin displayed");
        getTVDashboardPage().clickResetPurchasePin();
        reporter.reportLogWithScreenshot("Reset purchase pin clicked");
        getTVDashboardPage().clickCancel();
        reporter.reportLogWithScreenshot("Closing Reset Parent control");
        reporter.hardAssert(getTVDashboardPage().verifyResetParentalControl(), "Reset Parental Control & pin Available","Reset Parental Control & pin not Available");
        reporter.reportLogWithScreenshot("Reset Parent control link displayed");
        getTVDashboardPage().clickResetParentalControl();
        reporter.reportLogWithScreenshot("Reset Parent control clicked");
        getTVDashboardPage().clickCancel();
        reporter.reportLogWithScreenshot("Closing Reset Parent control");

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
