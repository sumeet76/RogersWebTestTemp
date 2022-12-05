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
 * TC11 - Regression - HUP-E2E-SL Shared(Noterm)-Validate the HUP flow selecting the Noterm_Chrome_EN_ON
 */
public class RogersBFA_TC11_Consumer_HUPShareNoTermSL_Test extends BaseTestClass{

        @Test(groups = {"RegressionBFA","SanityBFA","HUPBFA"})
        public void tc11_rogersHUPShareKeepCurrentPlanNoTermSLTest() {
            //reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
            reporter.reportLogWithScreenshot("Home Page");
            //getRogersHomePage().clkSignIn();
            //getRogersLoginPage().switchToSignInIFrame();
            getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc11HUPShareNoTermSL.getUsername());
            getRogersLoginPage().clkContinueSignIn();
            getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc11HUPShareNoTermSL.getPassword());
            reporter.reportLogWithScreenshot("Login Page");
            getRogersLoginPage().clkSignInIFrame();
            //reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
            //getRogersLoginPage().clkSkipIFrame();
            //getRogersLoginPage().switchOutOfSignInIFrame();
            reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
            reporter.reportLogWithScreenshot("Account Overview page");
            getDriver().get(System.getProperty("AWSUrl"));
            String deviceName = TestDataHandler.tc11HUPShareNoTermSL.getDeviceName();
            reporter.reportLogWithScreenshot("Moving to device catalogue page");
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
            reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");

            getRogersPlanConfigPage().clkRadioButtonNoTerm();
            reporter.reportLogPassWithScreenshot("No term selected");
            getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
            reporter.reportLogPassWithScreenshot("Plan config page device cost selected");
            getRogersPlanConfigPage().clickContinueOnModalToDoWithOldPhone();
            reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
            getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
            getRogersPlanConfigPage().clkContinueDeviceProtection();
            reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
            getRogersPlanConfigPage().clickCartSummaryContinueButton();
            getRogersCheckoutPage().clickSkipAutopay();
            getRogersCheckoutPage().clkDeliveryMethod("standard");
            reporter.reportLogPass("Standard Delivery selected");
            getRogersCheckoutPage().clkContinueBtnShipping();
            reporter.reportLogPass("Clicked continue button in shipping stepper");
            getRogersCheckoutPage().clksubmitBtnCheckoutPage();
            reporter.reportLogPass("Clicked submit button below cart summary");
            reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                    "Order Review Page Title is not Present");
            reporter.reportLogPass("Order Review Page");
            getRogersReviewOrderPage().clkAgreementConsentCheckbox();
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
            reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),
                    "Pay with Credit card details are present on OneTime payment page", "Pay with Credit card details are not present on OneTime payment page");
            getRogersOneTimePaymentPage().setNameonCard();
            getRogersOneTimePaymentPage().switchToCreditCardIFrame();
            getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc11HUPShareNoTermSL.getCreditCardDetails());
            getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
            getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc11HUPShareNoTermSL.getExpiryDate());
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