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
 * TC41 - SOHOHUP - MultiLine Account_HUP flow with PPC on Main line_Selecting VDP and POTG shipping option
 * @author praveen.kumar7
 *
 */
public class RogersBFA_TC41_SOHO_ML_SE_HUPWithPPCOnMainLine_VDP_BOPIS_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","SOHOHUPBFA"})
    public void tc41_sohoHUP_ML_SE_HUPWithPPCOnMainLine_VDP_BOPIS_Test() {
        //reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        //reporter.reportLogWithScreenshot("Home Page");
        //getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc41_SOHO_HUP_ML_SE_HUPWithPPCOnMainLine_VDP_BOPIS.getUsername());
        getRogersLoginPage().clkContinueSignIn();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc41_SOHO_HUP_ML_SE_HUPWithPPCOnMainLine_VDP_BOPIS.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
//        getRogersLoginPage().clkSkipIFrame();
//        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl"));
        String deviceName = TestDataHandler.tc41_SOHO_HUP_ML_SE_HUPWithPPCOnMainLine_VDP_BOPIS.getDeviceName();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(TestDataHandler.tc41_SOHO_HUP_ML_SE_HUPWithPPCOnMainLine_VDP_BOPIS.getDeviceName());
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen",
                "Modal element is not present on the screen");
        reporter.reportLogWithScreenshot("Modal window Popup");
        getRogersDeviceCataloguePage().clickUpgradeMyPhoneButtonOnModal();
        reporter.reportLogWithScreenshot("upgrade myphone clicked on Modal window Popup");
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed() , "CTN selection Modal window displayed on the screen " ,"CTN selection Modal window not displayed on the screen");
        reporter.reportLogWithScreenshot("CTN Modal window displayed on the screen");
        getRogersDeviceCataloguePage().selectCTN(TestDataHandler.tc41_SOHO_HUP_ML_SE_HUPWithPPCOnMainLine_VDP_BOPIS.getCtn());
        getRogersDeviceCataloguePage().clkContinueBtnHupCtnSelectionModal();
        reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
                "Continue button on the device config page is present",
                "Continue button on the device config page is not present");
        reporter.reportLogPassWithScreenshot("Device config page displayed");
        getRogersDeviceConfigPage().clickContinueButton();

        reporter.hardAssert(getRogersPlanConfigPage().verifyPlanConfigPage(), "Plan config page is loaded", "Plan config page is not loaded");
        getRogersPlanConfigPage().clkDownPaymentChkBox();
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page device cost selected");
        getRogersPlanConfigPage().clickContinueOnModalToDoWithOldPhone();

        //getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc41_SOHO_HUP_ML_SE_HUPWithPPCOnMainLine_VDP_BOPIS.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Plan config page data option selected");
        getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
        getRogersPlanConfigPage().skipBPOOffer();
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersPlanConfigPage().clkContinueDeviceProtection();
        reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        getRogersPlanConfigPage().selectAdditionalLinePlanOptions();
        getRogersCheckoutPage().clickSkipAutopay();
//        getRogersCheckoutPage().clkDeliveryMethod("PRO");
//        reporter.reportLogPassWithScreenshot("Pro on the go Delivery selected");
//        reporter.hardAssert(getRogersCheckoutPage().verifyAppointmentLabel(),"Appointment label is available","Appointment label is not available");
        reporter.reportLogPassWithScreenshot("On Checkout page");
        getRogersCheckoutPage().clkDeliveryMethod("EXPRESS");
        reporter.reportLogPassWithScreenshot("Bopis Delivery selected");
        reporter.hardAssert(getRogersCheckoutPage().verifyExpressLocationMapPresent(), "Express Location Map is available",
                "Express Location Map is not available");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
        //getRogersPlanConfigPage().clkContinueOnExistingAddonModal();

        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        getRogersReviewOrderPage().clkFinancingConsentCheckbox();
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        getRogersReviewOrderPage().clkReturningUEDeviceConsentCheckbox();
        getRogersReviewOrderPage().clkBopisConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkEmailConsentCheckbox();
        getRogersOrderReviewPage().clkSubmitOrder();

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