package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC35_SelfServe_DashboardValidation_3P_TV_INT_RHP_Dealer_ON_EN_Test extends BaseTestClass {
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
    public void ovr_Auto_TC35_SelfServe_DashboardValidation_3P_TV_INT_RHP_Dealer_ON_EN_Test() {
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"), System.getenv("champLoginPassword"));
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
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
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

        //TV Dashboard
        getOvrDashboardPage().clkTVDashboard();
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        reporter.reportLogWithScreenshot("Launched the TV dashboard page");
        reporter.softAssert(getTVDashboardPage().verifyHeader(), "Header is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Header available on TV Dashboard page");
        reporter.softAssert(getTVDashboardPage().verifyFooter(), "Footer is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Footer available on TV Dashboard page");

        reporter.hardAssert(getTVDashboardPage().verifyExchangeFlexChannels(), "Exchange Flex channels Available","Exchange Flex channels not Available");
        reporter.reportLogWithScreenshot("Exchange Flex channels button displayed");
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

        getInternetDashboardPage().clickBacktoAccountOverview();
        reporter.reportLogWithScreenshot("Back to account Over view Page");
        getInternetDashboardPage().clickContinue();

        //RHP Dashboard
        getOvrDashboardPage().clkHomePhoneDashboard();
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        reporter.reportLogWithScreenshot("Launch Home Phone dashboard page");

        getHomePhonedashboard().clickResetVoiceMail();
        reporter.reportLogWithScreenshot("Clicked on Reset Voicemail");
        reporter.hardAssert(getHomePhonedashboard().verifyResetVoicemailPasswordImage(),"Reset Voicemail Password link works", "Reset Voicemail Password link is not working");
        getHomePhonedashboard().clickCancel();
        reporter.reportLogWithScreenshot("Closing Reset Voicemail Password image");
        getHomePhonedashboard().clickYesResetPassword();;
        reporter.reportLogWithScreenshot("Yes clicked on the reset voicemail link pop up to continue");
        reporter.hardAssert(getHomePhonedashboard().verifySuccess(),"Verification of reset success","Reset has Failed with a technical error");
        reporter.reportLogWithScreenshot("reset success");

        getHomePhonedashboard().clickChangeCallDisplayName();
        reporter.hardAssert(getHomePhonedashboard().verifyChangeCallNameDisplayPopUp(),"Pop Up Displayed","Pop up not loaded");
        reporter.reportLogWithScreenshot("The current caller name is "+ getHomePhonedashboard().currentCallerName());
        getHomePhonedashboard().enterCallername("bbbdb","duhh");
        reporter.reportLogWithScreenshot("The new caller name are entered");
        getHomePhonedashboard().clickSubmit();
        reporter.reportLogWithScreenshot("The call display name changed successfully");
        reporter.hardAssert(getHomePhonedashboard().verifySuccess(),"Call Display name changed successfully","Call display name is not changed");
        getHomePhonedashboard().clickBackToDashboard();
        reporter.reportLogWithScreenshot("Back to Dashboard button is clicked");

        getInternetDashboardPage().clickBacktoAccountOverview();
        reporter.reportLogWithScreenshot("Back to account Overview Page");
        getInternetDashboardPage().clickContinue();

    }
}

