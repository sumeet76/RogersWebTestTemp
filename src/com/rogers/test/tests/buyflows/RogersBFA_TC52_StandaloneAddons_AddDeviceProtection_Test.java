package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class RogersBFA_TC52_StandaloneAddons_AddDeviceProtection_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows , method);
    }

    @Test(groups = {"RegressionBFA","SAABFA"})
    public void tc52_RogersSAA_AddDeviceProtectionTest() {
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc52SAA_AddDeviceProtection.getUsername());
        getRogersLoginPage().clkContinueSignIn();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc52SAA_AddDeviceProtection.getPassword());
        reporter.reportLogWithScreenshot("Login Popup");
        getRogersLoginPage().clkSignInIFrame();
        //getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        reporter.reportLogWithScreenshot("Account Overview page");
        getRogersAccountOverviewPage().clickManageButton();
        reporter.reportLogPassWithScreenshot("Dashboard Page");
        getDriver().get(System.getProperty("AWSUrl") + "/manage-addons");
        reporter.hardAssert(getRogersCheckoutPage().verifyAddonsPage(),
                "Rogers Standalone Addons Page Displayed","Rogers Standalone Addons Page not Displayed");
        String newAddon = TestDataHandler.tc52SAA_AddDeviceProtection.getAddonName();
        getRogersCheckoutPage().selectAddon(newAddon);
        reporter.reportLogPassWithScreenshot(  "New " +newAddon +"Addon Selected");
        reporter.hardAssert(getRogersCheckoutPage().verifyDpAddonPage(),
                "DP Addon Page Displayed","DP Addon Page Not Displayed");
        getRogersCheckoutPage().enterDPIMEI(TestDataHandler.tc52SAA_AddDeviceProtection.getDpIMEI());
        reporter.reportLogPassWithScreenshot("DP Addon IMEI Entered");
        reporter.hardAssert(getRogersCheckoutPage().clkDpAddonContinue(),
                "Continue Btn clicked","Continue btn not clicked");
        reporter.hardAssert(getRogersReviewOrderPage().isAddonReviewPageDisplayed(),
                "Addons Order Review Page Displayed","Addons Order Review Page Not Displayed");
        reporter.hardAssert(getRogersPlanConfigPage().verifyEligibilityMsg(),"Entered IMEI is eligible for Device Protection Addon","Entered IMEI is not eligible");
        String addonOrderSummary = getRogersReviewOrderPage().addonOrderSummary();
        reporter.reportLogPassWithScreenshot("Addons Order Summary: " +addonOrderSummary);
        getRogersReviewOrderPage().clkAddonsAgreementConsent();
        reporter.reportLogPassWithScreenshot("Addon Agreement clicked");
        getRogersReviewOrderPage().clkAddToPlanBtn();
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyAddonOrderConfirm(),
                "Addons Order Confirmation Page Displayed","Addons Order Confirmation Page Not Displayed");
        String OrderConfirmMessage = getRogersOrderConfirmationPage().getOrderConfirmMsg();
        reporter.reportLogPassWithScreenshot("Addons Order Confirmation Message: " +OrderConfirmMessage);
        getRogersOrderConfirmationPage().clickBackToAddonBtn();
        reporter.hardAssert(getRogersCheckoutPage().verifyAddonsPage(),
                "Rogers Standalone Addons Page Displayed","Rogers Standalone Addons Page not Displayed");
        String selectedAddon = getRogersCheckoutPage().getSelectedAddon();
        reporter.reportLogPassWithScreenshot("Active Addons: " +selectedAddon);
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}

