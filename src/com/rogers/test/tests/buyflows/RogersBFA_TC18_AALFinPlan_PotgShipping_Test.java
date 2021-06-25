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
 * TC18 - Rogers Add a line by selecting financing plan with PRO ON THE GO shipping option - E2E
 * @author praveen.kumar7
 */

public class RogersBFA_TC18_AALFinPlan_PotgShipping_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows, method);
    }

    @Test(groups = {"RegressionBFA","SanityBFA","AALBFA"})
    public void rogersAalFinPlanPotgTest() {
        reporter.reportLog("URL:" + System.getProperty("QaUrl"));
        reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        reporter.reportLogWithScreenshot("Home Page");
        getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc18AALFinPlanPotgShipping.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc18AALFinPlanPotgShipping.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");
        getDriver().get(System.getProperty("AWSUrl")+"?province=on");
        //------------------------------------Device Catalog page--------------------------------------------
        reporter.softAssert(getRogersDeviceCataloguePage().isRpotgBannerPresent(),
                "RPOTG Banner is present in the Device Catalog Page, verified by promo text",
                "RPOTG Banner is not present in the Device Catalog Page, verified by promo text");
        getRogersDeviceCataloguePage().clickRpotgBannerLearnMore();
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "RPOTG Learn More Modal is displayed",
                "Learn More Modal is not present");
        reporter.reportLogPassWithScreenshot("RPOTG Learn More Model");
        getRogersDeviceCataloguePage().clickCloseButtonOnModal();
        getRogersDeviceCataloguePage().clickCheckEligibilityRpotgBanner();
        reporter.reportLogPassWithScreenshot("RPOTG Check Eligibility Banner");
        getRogersDeviceCataloguePage().validateRpotgPostalCode(TestDataHandler.tc18AALFinPlanPotgShipping.getPostalCode());
        getRogersDeviceCataloguePage().clickCheckBtn();
        reporter.reportLogPassWithScreenshot("RPOTG: Postal Code & Check Eligibility Success");
        getRogersDeviceCataloguePage().clickContinueBtn();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyeligiblePostalCodeinBanner().contains(TestDataHandler.tc18AALFinPlanPotgShipping.getPostalCode()),
                "RPOTG Banner has the eligible postal code displayed", "RPOTG Banner not displayed in banner");
        String deviceName = TestDataHandler.tc18AALFinPlanPotgShipping.getNewDevice();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName),
                "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        reporter.reportLogWithScreenshot("Device Catalog Page");
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(),
                "Existing Customer Modal element is present on the screen",
                "Existing Customer Modal element is not present on the screen");
        reporter.reportLogWithScreenshot("Existing Customer Modal window Popup");
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyAddALineButtonOnModal(), "Add a line button displayed", "Add a line button not displayed");
        getRogersDeviceCataloguePage().clickAddALineButtonOnModal();
        /*reporter.softAssert(getRogersDeviceCataloguePage().verifyCreditEvaluationPopupPresent(),
                "Credit Evaluation Popup Displayed", "Credit Evaluation popup not disaplayed");
        reporter.softAssert(getRogersDeviceCataloguePage().verifyCreditEvalTextOnModalPresent(),
                "Credit Evaluation Text Displayed", "Credit Evaluation Text not disaplayed on Modal");*/
        reporter.hardAssert(getRogersDeviceCataloguePage().verifySharedNonSharedModalPresent(),
                "Shared/Nonshared modal displayed", "Shared/Nonshared modal not displayed");
        reporter.reportLogWithScreenshot("Shared/Nonshared modal popup");
        String aalSharingType = TestDataHandler.tc18AALFinPlanPotgShipping.getSharingType();
        getRogersDeviceCataloguePage().selectAALSharingType(aalSharingType);
        reporter.reportLogPassWithScreenshot(aalSharingType+ " option selected successfully");
        getRogersDeviceCataloguePage().clickContinueButtonOnModal();
        //------------------------------------Device Config page--------------------------------------------
        reporter.softAssert(getRogersDeviceConfigPage().verifyeligiblePostalCodeinBanner().contains(TestDataHandler.tc18AALFinPlanPotgShipping.getPostalCode()),
                "Eligible postal code verified in Device Catalog page Banner is carried on to Device Config Page Banner as expected",
                "Postal Code not matching");
        getRogersDeviceConfigPage().selectDeviceColor(TestDataHandler.tc18AALFinPlanPotgShipping.getDeviceColor());
        reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
                "Continue button on the device config page is present",
                "Continue button on the device config page is not present");
        reporter.reportLogPassWithScreenshot("Device config page displayed");
        getRogersDeviceConfigPage().clickContinueButton();
        //-------------------------------------Plan config page---------------------------------------------
        reporter.softAssert(getRogersDeviceConfigPage().verifyeligiblePostalCodeinBanner().contains(TestDataHandler.tc18AALFinPlanPotgShipping.getPostalCode()),
                "Eligible postal code verified in Device Catalog & Device Config page POTG Banner is carried on to Plan Config Page Banner as expected",
                "Postal code not matching in Plan Config page");
        reporter.reportLogWithScreenshot(
                "RPOTG Label and subcopy verified in Plan Config Page verified as" + "--->" + getRogersPlanConfigPage().getRpotgLabelPlanConfigPage());
        reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName),
                "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        reporter.hardAssert(getRogersPlanConfigPage().verifySelectedDeviceSection(deviceName), "Plan Config loaded", "Plan config page not loaded");
        reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");
        //getRogersPlanConfigPage().clickViewMoreOptions();
        //getRogersPlanConfigPage().clkDownPaymentChkBox();
        getRogersPlanConfigPage().selectDeviceCostAndClickOnContinueButton(getRogersPlanConfigPage().getUpdatedDeviceCostIndex(TestDataHandler.tc18AALFinPlanPotgShipping.getDeviceCostIndex()));
        reporter.reportLogPassWithScreenshot("Device cost option selected");
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc18AALFinPlanPotgShipping.getDataOptionIndex()));
        reporter.reportLogPassWithScreenshot("Data option selected");
        reporter.hardAssert(getRogersPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.tc18AALFinPlanPotgShipping.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersPlanConfigPage().setUserNameCallerID();
        reporter.reportLogWithScreenshot("CalledID details entered");
        String monthlyFeesAmountWithTax = getRogersPlanConfigPage().getMonthlyFeesAmount();
        String oneTimeFeesAmountWithTax = getRogersPlanConfigPage().getOneTimeFeesAmount();
        reporter.reportLog("Checkout page Cart Summary Info" + "1. Total Monthly Fees " + monthlyFeesAmountWithTax + "2. oneTimeFee " + oneTimeFeesAmountWithTax);
        String isSelectedDeviceTier = getRogersPlanConfigPage().getDeviceCostTierSelected();
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        //---------------------------------------Checkout pages---------------------------------------------------------
        reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
        reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc18AALFinPlanPotgShipping.getCtnCity());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
        getRogersCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
        getRogersCheckoutPage().clkChooseNumberbutton();
        reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(), "Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
        reporter.hardAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
                "Billing Address is not selected");
        getRogersCheckoutPage().clkDeliveryMethod("PRO");
        reporter.reportLogPassWithScreenshot("Pro on the go Delivery selected");
        reporter.hardAssert(getRogersCheckoutPage().verifyAppointmentLabel(),"Appointment label is available","Appointment label is not available");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
        //--------------------------------------Review Order Page-------------------------------------------------------
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        getRogersReviewOrderPage().clkAllAgreementConsentCheckbox(isSelectedDeviceTier);
        getRogersReviewOrderPage().clkEmailConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersOrderReviewPage().clkSubmitOrder();
        //----------------------------------OTP Page------------------------------------------------
        /*reporter.reportLogWithScreenshot("Rogers Payment Page");
        reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),"Payment page displayed successfully","Payment page did not display");
        getRogersOneTimePaymentPage().setNameonCard();
        getRogersOneTimePaymentPage().switchToCreditCardIFrame();
        getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc18AALFinPlanPotgShipping.getCcNumberOTP());
        getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
        getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc18AALFinPlanPotgShipping.getExpiryDateOTP());
        getRogersOneTimePaymentPage().setCVV();
        reporter.reportLogPassWithScreenshot("Credit Card Details Entered Successfully");
        getRogersOneTimePaymentPage().clkSubmitOrderBtn();*/
        //---------------------------Order Confirmation Page--------------------------------------
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(),
                "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.reportLogPassWithScreenshot("Order Confirmation Page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyRpotgTitle(), "RPOTG Title verified",
                "RPOTG Title Not Present");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyAppointmentDetailsTitle(),
                "Appointment Details Title verified", "Your Appointment Details Title Not present");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyAppointmentDateTitle(),
                "Appointment Date Title Verified", "Appointment Date Title not Present");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyAppointmentAddressTitle(),
                "Appointment Address Title Verified", "Appointment Address Title not present");
        String appointmentAddress = getRogersOrderConfirmationPage().getAppointmentAddressText();
        reporter.reportLogWithScreenshot("Appointment Address Details" + "-->" + appointmentAddress);
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyDeviceImage(),
                "Device Image Present in Confirmation Page", "Device Image not present");
        String totalMonthlyFeesConfirmationPage = getRogersOrderConfirmationPage().getMonthlyFeeAfterTax();
        reporter.reportLogWithScreenshot("Cart summary of Order confirmation page");
        reporter.hardAssert(monthlyFeesAmountWithTax.equals(totalMonthlyFeesConfirmationPage),
                "Total Monthly Fee after tax matches with checkout page", "Total Monthly Fee after tax not matches with checkout page");
        String oneTimeFeesConfirmationPage = getRogersOrderConfirmationPage().getOneTimeFeeAfterTax();
        reporter.hardAssert(oneTimeFeesAmountWithTax.equals(oneTimeFeesConfirmationPage),
                "Total One time fee after tax matches with checkout page", "Total One time fee after tax not matches with checkout page");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }
}

