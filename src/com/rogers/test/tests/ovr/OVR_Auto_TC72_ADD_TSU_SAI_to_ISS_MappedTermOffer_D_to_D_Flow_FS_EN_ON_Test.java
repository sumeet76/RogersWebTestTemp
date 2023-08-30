package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC72_ADD_TSU_SAI_to_ISS_MappedTermOffer_D_to_D_Flow_FS_EN_ON_Test extends BaseTestClass {
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
    public void ovr_Auto_TC72_ADD_TSU_SAI_to_ISS_MappedTermOffer_D_to_D_Flow_FS_EN_ON_Test() {
        getChampLoginPage().logIntoCorpChamp(System.getenv("PR_GSA_username"), System.getenv("PR_GSA_password"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        //Use OSRCP as dealer code for ExistingIgniteAccounts.
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspIgniteDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        reporter.reportLogWithScreenshot("Account Search Page");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.tc_72_AddTSU_SAI_to_SAI_MappedTerm_Data.getBanNumber(), TestDataHandler.tc_72_AddTSU_SAI_to_SAI_MappedTerm_Data.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("Account Overview page has Launched");

        getOvrDashboardPage().clkInternetDashboard();
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard page");
        reporter.softAssert(getInternetDashboardPage().verifyHeader(), "Header is available", "Verification of Header failed");

        getInternetDashboardPage().clickViewOffers();
        reporter.reportLogWithScreenshot("view offers link clicked");
        reporter.hardAssert(getInternetDashboardPage().verifyRecommendedOffer(),"Recommended offer available ","no Recommended offer displayed");
        getInternetDashboardPage().selectRecommendedOffer();
        reporter.reportLogWithScreenshot("Recommended offer selected");

        getInternetDashboardPage().clickSelectbutton();
        reporter.reportLogWithScreenshot("New Internet Package selected");
        getInternetDashboardPage().clickContinue();
        reporter.reportLogWithScreenshot("Clicked Continue");

        getInternetDashboardPage().clickImmediateBill();
        reporter.reportLogWithScreenshot("Immediate Billing Cycle Selected");
        getTVDashboardPage().continueFromChangeDate();

        reporter.hardAssert(getOVROrderReviewPage().verifyReviewYourOrderHeader(), "Order Review Page Loaded", "Order Review Page Not loaded");
        getOVROrderReviewPage().clkContinue();
        reporter.reportLogWithScreenshot("Sign Agreement Page");
        reporter.hardAssert(getOVRAgreementPage().verifySignAgreementPage(), "Agreement page displayed", "Agreement page not displayed");
        getOVRAgreementPage().signAgreement();
        reporter.reportLogWithScreenshot("Back to Agreement Page");
        getOVRAgreementPage().clkAgreementCheckbox();
        getOVRAgreementPage().clkCompleteOrder();
        reporter.reportLogWithScreenshot("Order Confirmation Page");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderConfirmation(), "Order Confirmation displayed", "Order not Confirmed");

    }

}
