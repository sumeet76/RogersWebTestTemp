package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * TC30 - RPP_AAL TERM_Share Everything_Selecting Upfront edge cost option, Voluntary Down payment and BOPIS shipping
 * @author praveen.kumar7
 */

public class RogersBFA_TC30_Consumer_to_RPP_Migration_AALTerm_VDP_UpfrontEdge_Bopis_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows, method);
    }

    @Test(groups = {"RegressionBFA","RPPTEST"})
    public void tc30_ConToRPP_AALTerm_VDP_UpfronEdge_BopisTest() {
        //reporter.reportLog("URL:" + System.getProperty("QaUrl"));
        //reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        //reporter.reportLogWithScreenshot("Home Page");
        //getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        // **************************Device catalog page*****************************************
        getDriver().get(System.getProperty("AWSUrl")+"/?type=rpp");
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyRppPasscodeModal(),"RPP Passcode modal is displayed", "RPP passcode modal is not displayed");
        getRogersDeviceCataloguePage().enterPasscodeInPasscodeModal(TestDataHandler.tc30_RPP_AALTERM_VDP_UpfronEdge_BOPIS.getPasscode());
        reporter.reportLogWithScreenshot("Passcode entered successfully in passcode modal");
        getRogersDeviceCataloguePage().clkContinueBtnPassCodeMoodal();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyPasscode(),"Passcode is verified successfully", "Invalid Passcode");
        getRogersDeviceCataloguePage().clickAddALineButtonOnModal();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc30_RPP_AALTERM_VDP_UpfronEdge_BOPIS.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc30_RPP_AALTERM_VDP_UpfronEdge_BOPIS.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
//        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
//        reporter.reportLogWithScreenshot("Account Overview Page");
//        getDriver().get(System.getProperty("AWSUrl"));
        //------------------------------------Device Catalog page--------------------------------------------
        reporter.reportLogPassWithScreenshot("RPP Migration Fee Modal");
        getRogersDeviceCataloguePage().clkContinueBtnMigrationFeeRpp();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifySharedNonSharedModalPresent(), "Shared/Nonshared modal displayed", "Shared/Nonshared modal not displayed");
        reporter.reportLogWithScreenshot("Shared/Nonshared modal popup");
        String aalSharingType = TestDataHandler.tc30_RPP_AALTERM_VDP_UpfronEdge_BOPIS.getSharingType();
        getRogersDeviceCataloguePage().selectAALSharingType(aalSharingType);
        reporter.reportLogPassWithScreenshot(aalSharingType+ " option selected successfully");
        getRogersDeviceCataloguePage().clickContinueButtonOnModal();
        String deviceName = TestDataHandler.tc30_RPP_AALTERM_VDP_UpfronEdge_BOPIS.getNewDevice();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName),
                "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        reporter.reportLogWithScreenshot("Device Catalog Page");
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
//        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(),
//                "Existing Customer Modal element is present on the screen", "Existing Customer Modal element is not present on the screen");
//        reporter.reportLogWithScreenshot("Existing Customer Modal window Popup");
//        reporter.hardAssert(getRogersDeviceCataloguePage().verifyAddALineButtonOnModal(), "Add a line button displayed", "Add a line button not displayed");
//        getRogersDeviceCataloguePage().clickAddALineButtonOnModal();

        //------------------------------------Device Config page--------------------------------------------
        getRogersDeviceConfigPage().selectDeviceColor(TestDataHandler.tc30_RPP_AALTERM_VDP_UpfronEdge_BOPIS.getDeviceColor());
        reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
                "Continue button on the device config page is present", "Continue button on the device config page is not present");
        reporter.reportLogPassWithScreenshot("Device config page displayed");
        getRogersDeviceConfigPage().clickContinueButton();
        //-------------------------------------Plan config page---------------------------------------------
        reporter.hardAssert(getRogersPlanConfigPage().verifyPlanConfigPage(), "Plan config page is displayed", "Plan config page is not displayed");
        reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");
        reporter.hardAssert(getRogersPlanConfigPage().isMigratedToRppFin(),"Consumer User Migrated to RPP Financing successfully","Not Migrated to RPP Financing");
        getRogersPlanConfigPage().selectDeviceCostAndClickOnContinueButton(getRogersPlanConfigPage().getUpdatedDeviceCostIndex(TestDataHandler.tc30_RPP_AALTERM_VDP_UpfronEdge_BOPIS.getDeviceCostIndex()));
        reporter.reportLogPassWithScreenshot("Device cost option selected");
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc30_RPP_AALTERM_VDP_UpfronEdge_BOPIS.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Data option selected");
        reporter.hardAssert(getRogersPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.tc30_RPP_AALTERM_VDP_UpfronEdge_BOPIS.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersPlanConfigPage().clkContinueDeviceProtection();
        getRogersPlanConfigPage().setUserNameCallerID();
        reporter.reportLogWithScreenshot("CalledID details entered");
        String monthlyFeesAmountWithTax = getRogersPlanConfigPage().getMonthlyFeesAmount();
        String oneTimeFeesAmountWithTax = getRogersPlanConfigPage().getOneTimeFeesAmount();
        reporter.reportLog("Checkout page Cart Summary Info" + "1. Total Monthly Fees " + monthlyFeesAmountWithTax + "2. oneTimeFee " + oneTimeFeesAmountWithTax);
        String isSelectedDeviceTier = getRogersPlanConfigPage().getDeviceCostTierSelected();
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        //---------------------------------------Checkout pages---------------------------------------------------------
        reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
        getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc30_RPP_AALTERM_VDP_UpfronEdge_BOPIS.getCtnCity());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
        getRogersCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        getRogersCheckoutPage().clkChooseNumberbutton();
        reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(), "Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
        reporter.hardAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
                "Billing Address is not selected");
        getRogersCheckoutPage().clkDeliveryMethod("Express");
        reporter.reportLogPassWithScreenshot("Bopis Delivery selected");
        getRogersCheckoutPage().setEmailShippingPage();
        reporter.hardAssert(getRogersCheckoutPage().verifyExpressLocationMapPresent(), "Express pickup location map is present",
                "Express pickup location map is not available");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
        //--------------------------------------Review Order Page-------------------------------------------------------
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        getRogersReviewOrderPage().clkAllAgreementConsentCheckbox(isSelectedDeviceTier);
        getRogersReviewOrderPage().clkBopisConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkSubmitOrderBtn();
        //---------------------One Time Payment page------------------------------//
        reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),
                "Pay with Credit card details are present on OneTime payment page", "Pay with Credit card details are not present on OneTime payment page");
        getRogersOneTimePaymentPage().setNameonCard();
        getRogersOneTimePaymentPage().switchToCreditCardIFrame();
        getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc01NACTermNpotgSS.getCreditCardDetailsOTP());
        getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
        getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc01NACTermNpotgSS.getExpiryDateOTP());
        getRogersOneTimePaymentPage().setCVV();
        reporter.reportLogPassWithScreenshot("Credit Card Details Entered Successfully");
        getRogersOneTimePaymentPage().clkSubmitOrderBtn();
        //************Order Confirmation Page****************//
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyBopisContentDisplayed(),
                "Express pickup details displayed and device image displayed", "Express pickup details and device details not displayed");
        reporter.reportLogWithScreenshot("BOPIS contents displayed in order confirmation page");

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }
}

