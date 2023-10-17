package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC70_ChangePackage_IPTV_to_IPTV_D_To_D_Flow_Corp_EN_ON_Test extends BaseTestClass {
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
    public void ovr_Auto_TC70_ChangePackage_IPTV_to_IPTV_Corp_EN_ON_Test() {
        getChampLoginPage().logIntoCorpChamp(System.getenv("champCorpUserName"), System.getenv("champCorpPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        //Use OSRCP as dealer code for ExistingIgniteAccounts.
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspIgniteDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        reporter.reportLogWithScreenshot("Account Search Page");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.tc_70_Ovr_ChangePackage_Data.getBanNumber(), TestDataHandler.tc_70_Ovr_ChangePackage_Data.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("Proceed to Account Overview Page");
        reporter.reportLogWithScreenshot("Account Overview page has Launched");

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

        getTVDashboardPage().clickChangePackage();
        reporter.reportLogWithScreenshot("Changed TV Package clicked");
        getTVDashboardPage().selectTVPackage(TestDataHandler.ovrConfigData.getFlexChannelsPackageEN(),TestDataHandler.ovrConfigData.getFlexChannelsPackageFR());
        reporter.reportLogWithScreenshot("Upgrade TV Package selected");

        /*For Flex Channels - Exchange Later*/
        getTVDashboardPage().clickContinueChangeTVPackage();
        reporter.reportLogWithScreenshot("Continue clicked on change TV Package");
        getTVDashboardPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Exchange later is selected");

        getTVDashboardPage().clickContinueChannelsAndThemePacks();
        reporter.reportLogWithScreenshot("click continue at channels and themepack");
        getRogersIgniteBundlesPage().fourKTVPopup();
        getRogersIgniteBundlesPage().fourKContinue();
        reporter.reportLogWithScreenshot("Continue clicked on 4k TV dailog");

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
