package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC55_SelfServe_DashboardValidation_ISS_SmartStream_PR_WESA_ON_EN_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("OVRURL"), strBrowser, strLanguage, RogersEnums.GroupName.ovr, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

    @Test(groups = {"OVR", "RegressionOVR"})
    public void ovr_Auto_TC55_SelfServe_DashboardValidation_ISS_SmartStream_PR_WESA_ON_EN_Test() {
        getChampLoginPage().logIntoCorpChamp(System.getenv("PR_WESA_username"), System.getenv("FS_password"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        //Use OSRCP as dealer code for ExistingIgniteAccounts.
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspIgniteDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        reporter.reportLogWithScreenshot("Account Search Page");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.tc_36_DashboardValidation_Ignite_ISS.getBanNumber(), TestDataHandler.tc_36_DashboardValidation_Ignite_ISS.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("Proceed to Account Overview Page");

        //Internet Dashboard Validation
        getOvrDashboardPage().clkInternetDashboard();
        reporter.reportLogWithScreenshot("Launched the internet dashboard page");
        reporter.reportLogWithScreenshot("Launched the internet dashboard page");
        reporter.softAssert(getInternetDashboardPage().verifyHeader(), "Header is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Header available on internet Dashboard page");
        reporter.softAssert(getInternetDashboardPage().verifyFooter(), "Footer is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Footer available on internet Dashboard page");
        reporter.softAssert(getInternetDashboardPage().verifyInternetSpeedDisplayed(),"Internet Speed Displayed", "Internet Speed not displayed");
        reporter.softAssert(getInternetDashboardPage().verifyUsageAndAlerts(), "Usage and Alerts link Available","Usage and Alerts link not Available");
        reporter.reportLogWithScreenshot("View Usgae and Alert link displayed");

        getInternetDashboardPage().clickBacktoAccountOverview();
        reporter.reportLogWithScreenshot("Back to account Over view Page");
        getInternetDashboardPage().clickContinue();

        getOvrDashboardPage().clkIgniteStreamingDashboard();
        reporter.reportLogWithScreenshot("Launched the Ignite streaming dashboard page");
        reporter.hardAssert(getOvrDashboardPage().verifyRestartSetUpBox(), "Restart Setup Box link Available","Restart Setup Box link not Available");
        reporter.reportLogWithScreenshot("Restart setup box link displayed");
        getOvrDashboardPage().clickRestartSetupbox();
        reporter.reportLogWithScreenshot("Restart setup box link clicked");
        getTVDashboardPage().clickCancel();
        reporter.reportLogWithScreenshot("Closing Restart setup box");
        reporter.hardAssert(getTVDashboardPage().verifyResetPurchasePin(), "Reset Purchase pin Available","Reset Purchase pin not Available");
        reporter.reportLogWithScreenshot("Reset purchase pin displayed");
        getTVDashboardPage().clickResetPurchasePin();
        reporter.reportLogWithScreenshot("Reset purchase pin clicked");
        getTVDashboardPage().clickCancel();
        reporter.reportLogWithScreenshot("Closing Reset Parent control");
        reporter.hardAssert(getOvrDashboardPage().verifyResetParentalControl(), "Reset Parental Control & pin Available","Reset Parental Control & pin not Available");
        reporter.reportLogWithScreenshot("Reset Parent control link displayed");
        getOvrDashboardPage().clickResetParentalControl();
        reporter.reportLogWithScreenshot("Reset Parent control clicked");
        getTVDashboardPage().clickCancel();
        reporter.reportLogWithScreenshot("Closing Reset Parent control");

        getInternetDashboardPage().clickBacktoAccountOverview();
        reporter.reportLogWithScreenshot("Back to account Over view Page");
        getInternetDashboardPage().clickContinue();

    }
}
