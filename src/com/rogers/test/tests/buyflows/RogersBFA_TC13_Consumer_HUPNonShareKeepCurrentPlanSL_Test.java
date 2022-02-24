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
 * TC13 - Regression - HUP-E2E-SL Non Shared-Validate the HUP by selecting Keep current plan _Chrome_EN_ON
 */
public class RogersBFA_TC13_Consumer_HUPNonShareKeepCurrentPlanSL_Test extends BaseTestClass{

        @Test(groups = {"RegressionBFA","HUPBFA"})
        public void rogersHUPNonShareKeepCurrentPlanSLTest() {
            reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
            reporter.reportLogWithScreenshot("Home Page");
            getRogersHomePage().clkSignIn();
            //getRogersLoginPage().switchToSignInIFrame();
            getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc13HUPNonShareKeepCurrentPlanSL.getUsername());
            getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc13HUPNonShareKeepCurrentPlanSL.getPassword());
            reporter.reportLogWithScreenshot("Login Page");
            getRogersLoginPage().clkSignInIFrame();
            reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
            getRogersLoginPage().clkSkipIFrame();
            getRogersLoginPage().switchOutOfSignInIFrame();
            reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
            reporter.reportLogWithScreenshot("Account Overview page");
            getDriver().get(System.getProperty("AWSUrl"));
            String deviceName = TestDataHandler.tc13HUPNonShareKeepCurrentPlanSL.getDeviceName();
            reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
            getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
            reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen",
                    "Modal element is not present on the screen");
            getRogersDeviceCataloguePage().clickUpgradeMyPhoneButtonOnModal();
            reporter.reportLogWithScreenshot("Upgrade button clicked on Modal window Popup");
            reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
                    "Continue button on the device config page is present",
                    "Continue button on the device config page is not present");
            getRogersDeviceConfigPage().clickContinueButton();
            reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName),
                    "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
            getRogersPlanConfigPage().setCheckBoxKeepMyCurrentPlan();
            reporter.reportLogPassWithScreenshot("Checkbox for keep my current plan selected");
            getRogersPlanConfigPage().clkDownPaymentChkBox();
            getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
            reporter.reportLogPassWithScreenshot("Plan config page device cost selected");
            getRogersPlanConfigPage().clickContinueOnModalToDoWithOldPhone();
            getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
            reporter.reportLogPassWithScreenshot("Plan config page data option selected");
            /*getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
            reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
            getRogersPlanConfigPage().skipBPOOffer();*/
            getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
            getRogersPlanConfigPage().clkContinueDeviceProtection();
            reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
            getRogersPlanConfigPage().clickCartSummaryContinueButton();
            reporter.hardAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
                    "Billing Address is not selected");
            reporter.reportLogPassWithScreenshot("On Checkout page");
            getRogersCheckoutPage().clkDeliveryMethod("PRO");
            reporter.reportLogPassWithScreenshot("Pro on the go Delivery selected");
            reporter.hardAssert(getRogersCheckoutPage().verifyAppointmentLabel(),"Appointment label is available","Appointment label is not available");
            getRogersCheckoutPage().clkContinueBtnShipping();
            reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
            getRogersCheckoutPage().clksubmitBtnCheckoutPage();
            reporter.reportLogPass("Clicked submit button below cart summary");
            reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                    "Order Review Page Title is not Present");
            reporter.reportLogPass("Order Review Page");
            getRogersReviewOrderPage().clkFinancingConsentCheckbox();
            getRogersReviewOrderPage().clkAgreementConsentCheckbox();
            getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
            getRogersReviewOrderPage().clkReturningUEDeviceConsentCheckbox();
            getRogersReviewOrderPage().clkEmailConsentCheckbox();
            reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
            getRogersOrderReviewPage().clkSubmitOrder();
            reporter.reportLogWithScreenshot("Rogers Payment Page");
            reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),"Payment page displayed successfully","Payment page did not display");
            getRogersOneTimePaymentPage().setNameonCard();
            getRogersOneTimePaymentPage().switchToCreditCardIFrame();
            getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc17AALNoTermStandardShipping.getCcNumberOTP());
            getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
            getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc17AALNoTermStandardShipping.getExpiryDateOTP());
            getRogersOneTimePaymentPage().setCVV();
            reporter.reportLogPassWithScreenshot("Credit Card Details Entered Successfully");
            getRogersOneTimePaymentPage().clkSubmitOrderBtn();
            reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
            reporter.hardAssert(getRogersOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
            reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");

        }

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows , method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
    }