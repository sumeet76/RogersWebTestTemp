package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC76_Rogers_Footer_validations_Footerlinks_and_signout_Flow_OVC_EN_ON_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
    @Test(groups = {"OVR", "RegressionOVR"})
    public void ovr_Auto_TC76_Rogers_Footer_validations_Footerlinks_and_signout_Flow_OVC_EN_ON_Test(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.tc_75_Rogers_FooterValidations.getBanNumber(), "CO2100013754");
        reporter.reportLogWithScreenshot("OneView Interface has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        reporter.reportLogWithScreenshot("Account dashboard loaded");

        getOvrDashboardPage().openFooter();
        reporter.reportLogWithScreenshot("Footer Expanded");
        getOvrDashboardPage().openLink("Store Locator");
        reporter.reportLogWithScreenshot("Store Locator Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Coconut Rogers");
        reporter.reportLogWithScreenshot("Coconut Rogers Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Coconut Fido");
        reporter.reportLogWithScreenshot("Coconut Fido Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("OASYS");
        reporter.reportLogWithScreenshot("OASYS Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("TV Channel Lineup");
        reporter.reportLogWithScreenshot("TV Channel Lineup Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Email Confirmation Viewer");
        reporter.reportLogWithScreenshot("Email Confirmation viewer link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Phone Claim");
        reporter.reportLogWithScreenshot("Phone Claim Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("SMS Messaging Tool");
        reporter.reportLogWithScreenshot("SMS Messaging Tool Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Network Coverage");
        reporter.reportLogWithScreenshot("Network Coverage Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Competitive eye");
        reporter.reportLogWithScreenshot("Competitive eye Link");
        getBundleBuilderPage().switchToMainTab();

//        getOvrDashboardPage().openLink("Device unlock");
//        reporter.reportLogWithScreenshot("Device unlock Link");
//        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openRogersLink(" Device Guides - Ozmo ");
        reporter.reportLogWithScreenshot("Device Guides - Ozmo Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Shaw Discount/Plan Lookup Tool");
        reporter.reportLogWithScreenshot("Shaw Discount/Plan Lookup Tool Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("MyView");
        reporter.reportLogWithScreenshot("MyView Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().closeFooter();
        getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("Open IgniteLink from dashboard");
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        getCheckAvailabilityPage().useThisAddress();
        reporter.hardAssert(getBundleBuilderPage().verifyBundleBuilderPage(), "Bundle Builder page is displayed", "Bundle Builder page is not displayed");

        getOvrDashboardPage().openFooter();
        reporter.reportLogWithScreenshot("footer");

        getOvrDashboardPage().closeFooter();
        getOvrDashboardPage().openFeedbackForm();
        reporter.reportLogWithScreenshot("Feedback form popup");
        getOvrDashboardPage().closeFeedbackForm();

        getOvrDashboardPage().logoutOfCare();
        reporter.hardAssert(getOvrDashboardPage().verifylogoutOfCare(),"Successfully Logged Out of care", "Logout of care Link issue");

    }
}
