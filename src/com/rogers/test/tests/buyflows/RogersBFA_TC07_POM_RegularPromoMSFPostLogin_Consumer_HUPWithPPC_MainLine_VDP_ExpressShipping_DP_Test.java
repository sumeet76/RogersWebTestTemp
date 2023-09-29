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
 * TC07 - Regression - Rogers HUP on POTG device on main line e2e
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TC07_POM_RegularPromoMSFPostLogin_Consumer_HUPWithPPC_MainLine_VDP_ExpressShipping_DP_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","POMHUPBFA"})
    public void tc07_PomRegularPromoMSFRogersHUPMainLineVdpExpressTest() {
        //reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        reporter.reportLogWithScreenshot("Home Page");
        //getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc07POMHupPpcBopisSharedML.getUsername());
        getRogersLoginPage().clkContinueSignIn();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc07POMHupPpcBopisSharedML.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
        //getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl"));
        String deviceName = TestDataHandler.tc07POMHupPpcBopisSharedML.getDeviceName();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(TestDataHandler.tc07POMHupPpcBopisSharedML.getDeviceName());
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen",
                "Modal element is not present on the screen");
        reporter.reportLogWithScreenshot("Modal window Popup");
        getRogersDeviceCataloguePage().clickUpgradeMyPhoneButtonOnModal();
        reporter.reportLogWithScreenshot("upgrade myphone clicked on Modal window Popup");
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed() , "CTN selection Modal window displayed on the screen " ,"CTN selection Modal window not displayed on the screen");
        reporter.reportLogWithScreenshot("CTN Modal window displayed on the screen");
        getRogersDeviceCataloguePage().selectCTN(TestDataHandler.tc07POMHupPpcBopisSharedML.getCtn());
        getRogersDeviceCataloguePage().clkContinueBtnHupCtnSelectionModal();
        reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
                "Continue button on the device config page is present",
                "Continue button on the device config page is not present");
        reporter.hardAssert(getRogersDeviceConfigPage().verifyRegularPromoRibbon(),
                "Regular Promo - MSF Offer Displayed","Regular Promo - MSF Offer not Displayed");
        String regularPromoDetails = getRogersDeviceConfigPage().getRegularPromoDetails();
        reporter.reportLogPassWithScreenshot("Regular Promo Details " +regularPromoDetails);
        reporter.reportLogPassWithScreenshot("Device config page displayed");
        getRogersDeviceConfigPage().clickContinueButton();
        reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName),
                "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        // ***************************Promo Section************************************
        reporter.hardAssert(getRogersPlanConfigPage().verifyPromoSuccessMsg(),
                "Promotion Successfully", "Promotion Not Applied");
        String regularPromoName = getRogersPlanConfigPage().getRegularPromoName();
        getReporter().reportLogPassWithScreenshot("Regular Promo Name " +regularPromoName);
        getRogersPlanConfigPage().clkDownPaymentChkBox();
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page device cost selected");
        getRogersPlanConfigPage().clickContinueOnModalToDoWithOldPhone();
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc07POMHupPpcBopisSharedML.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Data option selected");
        getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
        getRogersPlanConfigPage().selectDeviceProtectionAddon();
        reporter.reportLogPassWithScreenshot("Device Protection Addon is selected");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page Add-ons Continue button clicked");
        reporter.hardAssert(getRogersPlanConfigPage().verifyDPCartLineItem(),
                "DP Addon added to cart","DP Addon not added to cart");
        String dpAddon = getRogersPlanConfigPage().getDeviceProtectionAddon();
        reporter.reportLogPassWithScreenshot("Device Protection - " +dpAddon);
        reporter.hardAssert(getRogersPlanConfigPage().verifyCartLineItem(),
                "Promo Discount amount Line Item displayed","Promo line item not displayed");
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        getRogersPlanConfigPage().selectAdditionalLinePlanOptions();
        getRogersCheckoutPage().clickSkipAutopay();
        reporter.reportLogPassWithScreenshot("On Checkout page");
//        getRogersCheckoutPage().clkDeliveryMethod("PRO");
//        reporter.reportLogPassWithScreenshot("Pro on the go Delivery selected");
//        reporter.hardAssert(getRogersCheckoutPage().verifyAppointmentLabel(),"Appointment label is available","Appointment label is not available");
        getRogersCheckoutPage().clkDeliveryMethod("Express");
        reporter.reportLogPassWithScreenshot("Bopis Delivery selected");
        reporter.hardAssert(getRogersCheckoutPage().verifyExpressLocationMapPresent(), "Express Pickup Location Map is available",
                "Express Pickup Location Map is not available");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPass("Clicked submit button below cart summary");
        //getRogersPlanConfigPage().clkContinueOnExistingAddonModal();
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        reporter.hardAssert(getRogersReviewOrderPage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
        String deviceProtectionAddon = getRogersReviewOrderPage().getDeviceProtectionAddon();
        getReporter().reportLogPassWithScreenshot("Device Protection - " +deviceProtectionAddon);
        reporter.hardAssert(getRogersReviewOrderPage().verifyCartLineItem(),
                "Promo Discount amount Line Item displayed","Promo line item not displayed");
        getRogersReviewOrderPage().clkFinancingConsentCheckbox();
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        getRogersReviewOrderPage().clkReturningUEDeviceConsentCheckbox();
        getRogersReviewOrderPage().clkBopisConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkEmailConsentCheckbox();
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
        reporter.reportLogWithScreenshot("Rogers Payment Page");
        reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentTitle(),
                "One Time Payment Page displayed","One Time Payment Page Not displayed");
        String otpAmount = getRogersOneTimePaymentPage().getOneTimePaymentAmount();
        reporter.reportLogWithScreenshot("One Time Payment Amount = " +otpAmount);
        reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),"Payment page displayed successfully","Payment page did not display");
        getRogersOneTimePaymentPage().setNameonCard();
        getRogersOneTimePaymentPage().switchToCreditCardIFrame();
        getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc07POMHupPpcBopisSharedML.getCcNumberOTP());
        getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
        getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc07POMHupPpcBopisSharedML.getExpiryDateOTP());
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