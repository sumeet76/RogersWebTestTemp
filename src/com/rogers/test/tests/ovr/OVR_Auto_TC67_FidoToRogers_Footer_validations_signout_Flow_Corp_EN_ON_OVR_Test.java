package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC67_FidoToRogers_Footer_validations_signout_Flow_Corp_EN_ON_OVR_Test extends BaseTestClass {
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
    public void ovr_Auto_TC67_FidoToRogers_Footer_validations_signout_Flow_Corp_EN_ON_OVR_Test() throws InterruptedException {
        getChampLoginPage().logIntoCorpChamp(System.getenv("champCorpUserName"), System.getenv("champCorpPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getFidoDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectFidoSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.tc_67_FidoToRogers_FooterValidations_Data.getBanNumber(), TestDataHandler.tc_67_FidoToRogers_FooterValidations_Data.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("search for account and select environment ");

        getOvrDashboardPage().openFooterAndNavigateToLNPPage();
        reporter.reportLogWithScreenshot("LNP Page");
        getOvrDashboardPage().goBackToOneview();
        reporter.reportLogWithScreenshot("back to Oneview page");
        getOvrDashboardPage().openFooterAndNavigateToOfflineAgreementPage();
        reporter.reportLogWithScreenshot("Offline agreement Page");
        getOvrDashboardPage().goBackToOneview();
        reporter.reportLogWithScreenshot("back to Oneview page");
        getOvrDashboardPage().openRetailCampaignTool();
        reporter.reportLogWithScreenshot("Retail campaign tool");
        getOvrDashboardPage().goBackToOneview();
        reporter.reportLogWithScreenshot("back to Oneview page");
        String currentWindow = getOvrDashboardPage().getCurrentWindowHandle();
        getOvrDashboardPage().openFidoTradeTool();
        reporter.reportLogWithScreenshot("Fido Trade tool");
        getBundleBuilderPage().switchToTab(currentWindow);

        getOvrDashboardPage().openLink("Getting Started");
        reporter.reportLogWithScreenshot("Getting Started tool");
        getBundleBuilderPage().switchToTab(currentWindow);

        getOvrDashboardPage().openLink("The Loop");
        reporter.reportLogWithScreenshot("the Loop tool");
        getBundleBuilderPage().switchToTab(currentWindow);

        getOvrDashboardPage().openLink("Coverage Maps");
        reporter.reportLogWithScreenshot("Coverage maps tool");
        getBundleBuilderPage().switchToTab(currentWindow);

        getOvrDashboardPage().openSIMValidationTool();
        reporter.reportLogWithScreenshot("Sim Validation tool");
        getOvrDashboardPage().clickCancelOnPopup();

        getOvrDashboardPage().openDeviceEligibilityTool();
        reporter.reportLogWithScreenshot("Device Eligibility tool");
        getOvrDashboardPage().clickCancelOnPopup();

        getOvrDashboardPage().openLink("Device Tune-Up");
        reporter.reportLogWithScreenshot("device tune up tool");
        getBundleBuilderPage().switchToTab(currentWindow);

        getOvrDashboardPage().openLink("Shaw Discount/Plan Lookup Tool");
        reporter.reportLogWithScreenshot("Shaw Discount/Plan Lookup tool");
        getBundleBuilderPage().switchToTab(currentWindow);

        getOvrDashboardPage().closeFooter();
        getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("Open IgniteLink from dashboard");
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        reporter.hardAssert(getCheckAvailabilityPage().verifyCheckAvailabilityPopup(), "Check Availability Popup present", "Check Availability Popup not present");
        getCheckAvailabilityPage().checkAvailability("642 ABANA RD. MISSISSAUGA, ON L5A1H4", "chrome");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(), "Address is serviceable", "Address is not serviceable");
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getBundleBuilderPage().verifyBundleBuilderPage(), "Bundle Builder page is displayed", "Bundle Builder page is not displayed");

        getOvrDashboardPage().openFooter();
        reporter.reportLogWithScreenshot("footer");
        getOvrDashboardPage().closeFooter();

        getOvrDashboardPage().openLiveChat();
        reporter.reportLogWithScreenshot("live chat popup");
        getOvrDashboardPage().closeLiveChatWindow();

        getOvrDashboardPage().openFeedbackForm();
        reporter.reportLogWithScreenshot("Feedback form popup");
        getOvrDashboardPage().closeFeedbackForm();

        getOvrDashboardPage().openLogoutOptions();
        reporter.reportLogWithScreenshot("Logout links and options");
        getBundleBuilderPage().clickLogoutOneviewAndSSP();
        reporter.hardAssert(getOvrDashboardPage().verifySuccessfulLogout(),"Successfully logged out of Oneview and SSP","Successfully logged out of Oneview and SSP");

    }
}
