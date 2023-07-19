package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC25_SelfServe_DashboardValidation_3P_TV_INT_RHP_FTO_ON_EN_Test extends BaseTestClass {
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
    public void ovr_Auto_TC25_SelfServe_DashboardValidation_3P_TV_INT_RHP_FTO_ON_EN_Test() {
        getChampLoginPage().logIntoCorpChamp(System.getenv("FS_FTO_username"), System.getenv("FS_FTO_password"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        //Use OSRCP as dealer code for ExistingIgniteAccounts.
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspIgniteDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        reporter.reportLogWithScreenshot("Account Search Page");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.tc_35_DashboardValidation_Ignite_3P.getBanNumber(), TestDataHandler.tc_35_DashboardValidation_Ignite_3P.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("Proceed to Account Overview Page");

        reporter.reportLogWithScreenshot("Account Overview page has Launched");

        //Internet Dashboard Validation
        getOvrDashboardPage().clkInternetDashboard();
        reporter.reportLogWithScreenshot("Launched the internet dashboard page");
        reporter.softAssert(getInternetDashboardPage().verifyHeader(), "Header is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Header available on internet Dashboard page");
        reporter.softAssert(getInternetDashboardPage().verifyFooter(), "Footer is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Footer available on internet Dashboard page");
        reporter.softAssert(getInternetDashboardPage().verifyInternetSpeedDisplayed(), "Internet Speed Displayed", "Internet Speed not displayed");
        reporter.softAssert(getInternetDashboardPage().verifyUsageAndAlerts(), "Usage and Alerts link Available", "Usage and Alerts link not Available");
        reporter.reportLogWithScreenshot("View Usage and Alert link displayed");

        getInternetDashboardPage().clickBacktoAccountOverview();
        reporter.reportLogWithScreenshot("Back to account Over view Page");
        getInternetDashboardPage().clickContinue();

        //TV Dashboard
        getOvrDashboardPage().clkTVDashboard();
        reporter.reportLogWithScreenshot("Launched the TV dashboard page");
        reporter.softAssert(getTVDashboardPage().verifyHeader(), "Header is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Header available on TV Dashboard page");
        reporter.softAssert(getTVDashboardPage().verifyFooter(), "Footer is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Footer available on TV Dashboard page");

        getInternetDashboardPage().clickBacktoAccountOverview();
        reporter.reportLogWithScreenshot("Back to account Over view Page");
        getInternetDashboardPage().clickContinue();

        //RHP Dashboard
        getOvrDashboardPage().clkHomePhoneDashboard();
        reporter.reportLogWithScreenshot("Launch Home Phone dashboard page");


        getInternetDashboardPage().clickBacktoAccountOverview();
        reporter.reportLogWithScreenshot("Back to account Over view Page");
        getInternetDashboardPage().clickContinue();
    }
}
