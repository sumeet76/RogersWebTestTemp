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
 * TC13 - Regression - Tablet HUP-E2E-ML Shared-Validate the HUP by selecting Fin plan_Chrome_EN_ON
 */
public class RogersBFA_TC13_Consumer_TabletHUPFinMLSEStandardShipping_Test extends BaseTestClass{

        @Test(groups = {"RegressionBFA","HUPBFA"})
        public void tc13_rogersTabletHUPFinMLSEStandardShippingTest() {
            //reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
            //reporter.reportLogWithScreenshot("Home Page");
            //getRogersHomePage().clkSignIn();
            //getRogersLoginPage().switchToSignInIFrame();
            getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc13TabletHUPFinMLSEStandardShipping.getUsername());
            getRogersLoginPage().clkContinueSignIn();
            getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc13TabletHUPFinMLSEStandardShipping.getPassword());
            reporter.reportLogWithScreenshot("Login Page");
            getRogersLoginPage().clkSignInIFrame();
            reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
            reporter.reportLogWithScreenshot("Account Overview page");
            getDriver().get(System.getProperty("AWSUrl")+"?flowType=hup");
            reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed() , "CTN selection Modal window displayed on the screen " ,"CTN selection Modal window not displayed on the screen");
            reporter.reportLogWithScreenshot("CTN Modal window displayed on the screen");
            getRogersDeviceCataloguePage().selectCTN(TestDataHandler.tc13TabletHUPFinMLSEStandardShipping.getCtn());
            getRogersDeviceCataloguePage().clickContinueBtn();
            String deviceName = TestDataHandler.tc13TabletHUPFinMLSEStandardShipping.getDeviceName();
            reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
            getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
            reporter.reportLogPassWithScreenshot("Tablet "+deviceName+" selected");
            reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
                    "Continue button on the device config page is present",
                    "Continue button on the device config page is not present");
            getRogersDeviceConfigPage().clickContinueButton();
            reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName),
                    "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
            //getRogersPlanConfigPage().setCheckBoxKeepMyCurrentPlan();
            //reporter.reportLogPassWithScreenshot("Checkbox for keep my current plan selected");
            //getRogersPlanConfigPage().clkDownPaymentChkBox();
            getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
            reporter.reportLogPassWithScreenshot("Plan config page device cost selected");
            reporter.reportLogPassWithScreenshot("Plan config page device cost selected");
            getRogersPlanConfigPage().clickContinueOnModalToDoWithOldPhone();
            //getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
            reporter.reportLogPassWithScreenshot("Plan config page data option selected");
            /*getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
            reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
            getRogersPlanConfigPage().skipBPOOffer();*/
            getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
            getRogersPlanConfigPage().clkContinueDeviceProtection();
            reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
            getRogersPlanConfigPage().clickCartSummaryContinueButton();
//            reporter.hardAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
//                    "Billing Address is not selected");
            reporter.reportLogPassWithScreenshot("On Checkout page");
//            getRogersCheckoutPage().clkDeliveryMethod("PRO");
//            reporter.reportLogPassWithScreenshot("Pro on the go Delivery selected");
//            reporter.hardAssert(getRogersCheckoutPage().verifyAppointmentLabel(),"Appointment label is available","Appointment label is not available");
            getRogersCheckoutPage().clickSkipAutopay();
            getRogersCheckoutPage().clkDeliveryMethod("STANDARD");
            reporter.reportLogPassWithScreenshot("Standard Delivery selected");
            getRogersCheckoutPage().clkContinueBtnShipping();
            reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
            getRogersCheckoutPage().clksubmitBtnCheckoutPage();
            reporter.reportLogPass("Clicked submit button below cart summary");
            reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                    "Order Review Page Title is not Present");
            reporter.reportLogPass("Order Review Page");
            getRogersReviewOrderPage().clkFinancingConsentCheckbox();
            getRogersReviewOrderPage().clkAgreementConsentCheckbox();
            //getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
            //getRogersReviewOrderPage().clkReturningUEDeviceConsentCheckbox();
            getRogersReviewOrderPage().clkEmailConsentCheckbox();
            reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
            //getRogersOrderReviewPage().clkSubmitOrder();
            if(getRogersOrderReviewPage().isPaymentRequired()) {
                getRogersOrderReviewPage().clkContinue();
            reporter.reportLogWithScreenshot("Rogers Payment Page");
            reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentTitle(),
                        "One Time Payment Page displayed","One Time Payment Page Not displayed");
            String otpAmount = getRogersOneTimePaymentPage().getOneTimePaymentAmount();
            reporter.reportLogWithScreenshot("One Time Payment Amount = " +otpAmount);
            reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),"Payment page displayed successfully","Payment page did not display");
            getRogersOneTimePaymentPage().setNameonCard();
            getRogersOneTimePaymentPage().switchToCreditCardIFrame();
            getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc17AALNoTermStandardShipping.getCcNumberOTP());
            getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
            getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc17AALNoTermStandardShipping.getExpiryDateOTP());
            getRogersOneTimePaymentPage().setCVV();
            reporter.reportLogPassWithScreenshot("Credit Card Details Entered Successfully");
            getRogersOneTimePaymentPage().clkSubmitOrderBtn();
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

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
    }