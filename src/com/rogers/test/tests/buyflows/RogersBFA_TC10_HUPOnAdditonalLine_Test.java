package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC10 - Regression - Rogers HUP on Additional line e2e
 * @author Saurav.Goyal
 */
public class RogersBFA_TC10_HUPOnAdditonalLine_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","HUPBFA"})
    public void rogersHUPOnAdditonalLineTest() {
        reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        reporter.reportLogWithScreenshot("Home Page");
        getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc10HUPAdditionalLine.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc10HUPAdditionalLine.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl"));
        String deviceName = TestDataHandler.tc10HUPAdditionalLine.getDeviceName();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen",
                "Modal element is not present on the screen");
        getRogersDeviceCataloguePage().clickUpgradeMyPhoneButtonOnModal();
        reporter.reportLogWithScreenshot("Upgrade button clicked on Modal window Popup");
        /*
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc10HUPAdditionalLine.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc10HUPAdditionalLine.getPassword());
        reporter.reportLogWithScreenshot("Rogers Login Page");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
        //getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
         */
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed() , "CTN selection Modal window displayed on the screen " ,"CTN selection Modal window not displayed on the screen");
        reporter.reportLogWithScreenshot("CTN Modal window displayed on the screen");
        getRogersDeviceCataloguePage().selectCTN(TestDataHandler.tc10HUPAdditionalLine.getCtn());
        getRogersDeviceCataloguePage().clickContinueBtn();
        reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
                "Continue button on the device config page is present",
                "Continue button on the device config page is not present");
        reporter.reportLogPassWithScreenshot("Device config page displayed");
        getRogersDeviceConfigPage().clickContinueButton();
        reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName),
                "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page device cost selected");
        getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page data option selected");
        getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
        getRogersPlanConfigPage().skipBPOOffer();
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        reporter.hardAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
                "Billing Address is not selected");
        getRogersCheckoutPage().clkDeliveryMethodStandard();
        reporter.reportLogPass("Standard Delivery selected");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPass("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPass("Clicked submit button below cart summary");
        getRogersPlanConfigPage().clkContinueOnExistingAddonModal();
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPass("Order Review Page");
        getRogersReviewOrderPage().clkFinancingConsentCheckbox();
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        getRogersReviewOrderPage().clkReturningUEDeviceConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        if(getRogersOrderReviewPage().isPaymentRequired()) {
            getRogersOrderReviewPage().clkContinue();
            getRogersPaymentPage().setCreditCardDetails(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber(),
                    TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth(),
                    TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear(),
                    TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCVV());
            reporter.reportLogWithScreenshot("Rogers Payment Page");
            getRogersPaymentPage().clkSubmit();
        } else {
            getRogersOrderReviewPage().clkSubmitOrder();
        }
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
    }

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows , method);
    }

    /*@AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }*/
    
}