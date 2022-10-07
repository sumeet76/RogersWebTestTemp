package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC23_Validate_CheckAvailability_Modal_NAC_and_ExistingCx_Dealer_EN_Test extends BaseTestClass {
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
    public void ovr_Auto_TC23_Validate_CheckAvailability_Modal_NAC_Dealer_EN_Test() {
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"), System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        reporter.reportLogWithScreenshot("Account Search Page");
        getAccountSearchPage().selectNewCustomerEnv(TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("QA Env selected for new customer");
        reporter.hardAssert(getCheckAvailabilityPage().verifyCheckAvailabilityPopup(),"Check Availability Popup present","Check Availability Popup not present" );
        getCheckAvailabilityPage().checkAvailability("642 ABANA RD. MISSISSAUGA, ON L5A1H4", "chrome");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),"Address is serviceable","Address is not serviceable");
        reporter.reportLogWithScreenshot("Service Availability");
        getCheckAvailabilityPage().clickCheckAnotherAddressBtn();
        reporter.reportLogWithScreenshot("Check another address");
        reporter.hardAssert(getCheckAvailabilityPage().verifyCheckAvailabilityPopupForExitingCx(),"Check Availability popup for existing Cx","Check Availability popup for existing Cx failed");
        getCheckAvailabilityPage().clickCloseCheckAvailabilityPopup();
        reporter.reportLogWithScreenshot("Close Popup and move to SSP Page");
        //Validate SSP Page
        getReporter().hardAssert(getAccountSearchPage().validateAccountSearchPage(),"Account search page loaded","Account search page not loaded");



    }

    @Test(groups = {"OVR", "RegressionOVR"})
    public void ovr_Auto_TC23_Validate_CheckAvailability_Modal_ExistingCx_Dealer_EN_Test() {
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"), System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
//        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspDealerCode());
//        reporter.reportLogWithScreenshot("Searching with dealer code");
//        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
//        reporter.reportLogWithScreenshot("Select SSP environment");
//        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.ovrMigrationData1pINTtoISSATL.getBanNumber(), TestDataHandler.ovrMigrationData1pINTtoISSATL.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
//        reporter.reportLogWithScreenshot("search for account and select environment ");

        //Use OSRCP as dealer code for ExistingIgniteAccounts.
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspIgniteDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        reporter.reportLogWithScreenshot("Account Search Page");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.tc_35_DashboardValidation_Ignite_3P.getBanNumber(), TestDataHandler.tc_35_DashboardValidation_Ignite_3P.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("Proceed to Account Overview Page");

        getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("Open IgniteLink from dashboard");
        reporter.hardAssert(getCheckAvailabilityPage().verifyCheckAvailabilityPopupForExitingCx(),"Check Availability popup for existing Cx","Check Availability popup for existing Cx failed");
        getCheckAvailabilityPage().clickCloseCheckAvailabilityPopup();
        reporter.reportLogWithScreenshot("Close Popup and move to SSP Page");
        //Validate Existing Cx dashboard
        getReporter().hardAssert(getOVROrderConfirmationPage().verifyOverviewPage(),"Account overview page loaded","Account overview page not loaded");

    }
}
