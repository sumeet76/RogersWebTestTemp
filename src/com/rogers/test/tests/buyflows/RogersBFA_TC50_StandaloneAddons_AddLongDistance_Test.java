package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class RogersBFA_TC50_StandaloneAddons_AddLongDistance_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows , method);
    }

    @Test(groups = {"RegressionBFA","SAABFA"})
    public void tc50_rogersSAAAddLongDistanceTest() {
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc50SAA_AddLongDistance.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc50SAA_AddLongDistance.getPassword());
        getReporter().reportLogWithScreenshot("Login Popup");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        getReporter().hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Error");
        getReporter().reportLogWithScreenshot("Account Overview page");
        getRogersAccountOverviewPage().clickManageButton();
        getReporter().reportLogPassWithScreenshot("Dashboard Page");
        getDriver().get(System.getProperty("AWSUrl") + "/manage-addons");
        getReporter().hardAssert(getRogersCheckoutPage().verifyAddonsPage(),
                "Rogers Standalone Addons Page Displayed","Rogers Standalone Addons Page not Displayed");
        String newAddon = TestDataHandler.tc50SAA_AddLongDistance.getAddonName();
        getRogersCheckoutPage().selectAddon(newAddon);
        getReporter().reportLogPassWithScreenshot(  "New " +newAddon +"Addon Selected");
        getReporter().hardAssert(getRogersReviewOrderPage().isAddonReviewPageDisplayed(),
                "Addons Order Review Page Displayed","Addons Order Review Page Not Displayed");
        String addonOrderSummary = getRogersReviewOrderPage().addonOrderSummary();
        getReporter().reportLogPassWithScreenshot("Addons Order Summary: " +addonOrderSummary);
        getRogersReviewOrderPage().clkAddonsAgreementConsent();
        getReporter().reportLogPassWithScreenshot("Addon Agreement clicked");
        getRogersReviewOrderPage().clkAddToPlanBtn();
        getReporter().hardAssert(getRogersOrderConfirmationPage().verifyAddonOrderConfirm(),
                "Addons Order Confirmation Page Displayed","Addons Order Confirmation Page Not Displayed");
        String OrderConfirmMessage = getRogersOrderConfirmationPage().getOrderConfirmMsg();
        getReporter().reportLogPassWithScreenshot("Addons Order Confirmation Message: " +OrderConfirmMessage);
        getRogersOrderConfirmationPage().clickBackToAddonBtn();
        getReporter().hardAssert(getRogersCheckoutPage().verifyAddonsPage(),
                "Rogers Standalone Addons Page Displayed","Rogers Standalone Addons Page not Displayed");
        String selectedAddon = getRogersCheckoutPage().getSelectedAddon();
        getReporter().hardAssert(selectedAddon.contains(newAddon),
                "Selected Addon is reflected in Addons page after submission","Selected Addon is not reflected");
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
