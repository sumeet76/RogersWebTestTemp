package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC68_Fido_Footer_validations_Footerlinks_and_signout_Flow_OVC_EN_ON_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startOVSession(System.getProperty("OVFidoUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
    @Test(groups = {"OVR", "RegressionOVR"})
    public void ovr_Auto_TC68_Fido_Footer_validations_Footerlinks_and_signout_Flow_OVC_EN_ON_Test(){
        getEnvironmentSelectionPage().launchOneViewFido(TestDataHandler.tc_67_FidoToRogers_FooterValidations_Data.getBanNumber(), "CO2100013754");
        reporter.reportLogWithScreenshot("OneView Fido Interface has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        reporter.reportLogWithScreenshot("Account dashboard loaded");

        getOvrDashboardPage().openFooter();
        reporter.reportLogWithScreenshot("Footer Expanded");
        getOvrDashboardPage().openLink("Address Verification Tool");
        reporter.reportLogWithScreenshot("Address Verification Tool");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Device Protection");
        reporter.reportLogWithScreenshot("Device protection tool");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Email Confirmation viewer");
        reporter.reportLogWithScreenshot("Email Confirmation viewer link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Find a store");
        reporter.reportLogWithScreenshot("Find a store Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Local Calling Areas");
        reporter.reportLogWithScreenshot("Local Calling Areas link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Manage My Account (GAM)");
        reporter.reportLogWithScreenshot("Manage My Account (GAM) link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Network Coverage Map");
        reporter.reportLogWithScreenshot("Network Coverage Map Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Prorata Calculator Tool");
        reporter.reportLogWithScreenshot("Prorata Calculator Tool Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("SMS Messaging Tool");
        reporter.reportLogWithScreenshot("SMS Messaging Tool Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Troubleshooting Tool");
        reporter.reportLogWithScreenshot("Troubleshooting Tool Link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().openLink("Shaw Discount/Plan Lookup Tool");
        reporter.reportLogWithScreenshot("Shaw Discount/Plan Lookup tool");
        getBundleBuilderPage().switchToMainTab();

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
        getOvrDashboardPage().openLink("Wireless contingency activation form");
        reporter.reportLogWithScreenshot("Wireless contingency activation form link");
        getBundleBuilderPage().switchToMainTab();

        getOvrDashboardPage().closeFooter();
        getOvrDashboardPage().openFeedbackForm();
        reporter.reportLogWithScreenshot("Feedback form popup");
        getOvrDashboardPage().closeFeedbackForm();

        getOvrDashboardPage().logoutOfCare();
        reporter.hardAssert(getOvrDashboardPage().verifylogoutOfCare(),"Successfully Logged Out of care", "Logout of care Link issue");

    }
}
