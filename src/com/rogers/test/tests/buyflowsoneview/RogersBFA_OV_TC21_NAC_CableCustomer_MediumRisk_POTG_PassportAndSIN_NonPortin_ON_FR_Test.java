package com.rogers.test.tests.buyflowsoneview;

import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC21 - Validate OV NAC TERM flow for Outbound-CABLE customer_Nonportin_Passport + SIN_ON_FR
 * @author Praveen.Kumar7
 */

public class RogersBFA_OV_TC21_NAC_CableCustomer_MediumRisk_POTG_PassportAndSIN_NonPortin_ON_FR_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(),"", "","", "", method);
    }

    @Test(groups = {"RegressionBFA","RegressionOVBFA","OVNACBFA"})
    public void ovNacCableCustomerMediumRiskPotgONTest() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.buyFlowsOVtestCase21.getBanNo(), TestDataHandler.buyFlowsOVtestCase21.getContactID());
        reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Rogers Account overview page");
        getAccountOverViewPage().setSkipNotification();
        getNacDashboardPage().selectFrenchLanguage();
        getAccountOverViewPage().selectAddAWirelessLineButton();
        //-------------------------------------NAC Dashboard page---------------------------------------------
        reporter.reportLogWithScreenshot("Active Wireless Service Modal");
        getNacDashboardPage().clkGetANewPhoneButton();
        //-------------------------------------Choose Phone page---------------------------------------------
        reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase21.getDeviceName()), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        String deviceName = TestDataHandler.buyFlowsOVtestCase21.getDeviceName();
        getRogersOVChoosePhonePage().clickDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase21.getDeviceName());
        //-------------------------------------Device Config page--------------------------------------------
        getRogersOVChoosePhonePage().selectDeviceColor(TestDataHandler.buyFlowsOVtestCase21.getDeviceColor());
        reporter.reportLogPassWithScreenshot("Device config page displayed");
        String deviceCost = getRogersOVChoosePhonePage().getDeviceFullPriceFrench();
        getRogersOVChoosePhonePage().clickContinueButton();
        //-------------------------------------Plan config page---------------------------------------------
        reporter.softAssert(getRogersOVPlanConfigPage().verifyBreadCrumb(deviceName),
                "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        reporter.hardAssert(getRogersOVPlanConfigPage().verifySelectedDeviceSection(deviceName), "Plan Config loaded", "Plan config page not loaded");
        reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");
        getRogersOVPlanConfigPage().clkPreCartDeviceCostContinueButtonForNac();
        reporter.reportLogPassWithScreenshot("Device cost option selected");
        getRogersOVPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersOVPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.buyFlowsOVtestCase21.getDataOptionIndex()));
        reporter.reportLogPassWithScreenshot("Data option selected");
        reporter.hardAssert(getRogersOVPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersOVPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.buyFlowsOVtestCase21.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersOVPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersOVPlanConfigPage().clickCartSummaryContinueButton();
        //-------------------------------------------Create Profile Stepper----------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().verifyCreateProfileTitle(),"Create profile Title Present","Create profile Title not present");
        getRogersOVCheckoutPage().setContactNumberCreateProfile(TestDataHandler.buyFlowsOVtestCase21.getContactNumber());
        reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
        reporter.reportLogPassWithScreenshot("Create Profile Page details provided for Address,Shipping Address & Language Selected");
        getRogersOVCheckoutPage().clkBtnGotoCreditEvalStepper();
        //-----------------------------------------Credit Evaluation Stepper------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
        getRogersOVCheckoutPage().selectYearDropdownOption(TestDataHandler.buyFlowsOVtestCase21.getDateOfBirthYear());
        getRogersOVCheckoutPage().selectMonthDropdownOption(TestDataHandler.buyFlowsOVtestCase21.getDateOfBirthMonth());
        getRogersOVCheckoutPage().selectDayDropdownOption(TestDataHandler.buyFlowsOVtestCase21.getDateOfBirthDay());
        getRogersOVCheckoutPage().selectPrimaryDropdownOption(TestDataHandler.buyFlowsOVtestCase21.getSelectYourPrimaryIdOption(), TestDataHandler.buyFlowsOVtestCase21.getNumber());
        reporter.reportLogPassWithScreenshot("Passport details Entered Successfully");
        getRogersOVCheckoutPage().selectSecondDropdownOption(TestDataHandler.buyFlowsOVtestCase21.getSelectYourSecondIdOption(),TestDataHandler.buyFlowsOVtestCase21.getSecondNumber());
        getRogersOVCheckoutPage().clkCreditAuthorizationChkBox();
        getRogersOVCheckoutPage().clkCreditEvalContinue();
        reporter.reportLogWithScreenshot("Credit Evaluation modal displayed");
        reporter.hardAssert(getRogersOVChoosePhonePage().checkAcceptAndContinueOnCreditEvalModal() ,
                "Credit Evaluation modal with credit information displayed","Credit Evaluation modal doesn't contain credit info");
        reporter.hardAssert(getRogersOVCheckoutPage().verifyDownPayment(deviceCost,TestDataHandler.buyFlowsOVtestCase21.getCustomerRiskLevel()),
                "Downpayment amount is displayed correctly", "Downpayment amount not displayed correctly");
        //reporter.hardAssert(getRogersOVCheckoutPage().verifyCLMAmount(TestDataHandler.buyFlowsOVtestCase21.getCustomerRiskLevel()),
                //"CLM amount verified successfully", "Invalid CLM amount");
        getRogersOVChoosePhonePage().clickAcceptAndContinueOnCreditEvalModal();
        reporter.reportLogWithScreenshot("clicked on Accept and Continue button");
        //--------------------------------------------Choose a Number Stepper------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
        reporter.softAssert(getRogersOVCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose phone number page loaded successfully");
        getRogersOVCheckoutPage().selectCityDropdownOption(TestDataHandler.buyFlowsOVtestCase21.getCtnCity());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
        getRogersOVCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        reporter.softAssert(getRogersOVCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
        getRogersOVCheckoutPage().clkChooseNumberbutton();
        reporter.hardAssert(getRogersOVCheckoutPage().isChooseaNumberLabelDisplayed(), "Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
        //--------------------------------------------Billing option stepper----------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().isBillingOptionsTitleDisplayed(), "Billing Options Title Displayed", "Billing Options Title Not Present");
        reporter.softAssert(getRogersOVCheckoutPage().isPaymentMethodDropdownPresent(),
                "Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not disaplayed");
        getRogersOVCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.buyFlowsOVtestCase21.getPaymentMethod());
        reporter.reportLogWithScreenshot("Invoice option is selected");
        getRogersOVCheckoutPage().clkBillingContinueButton();
        //----------------------------------------------Shipping Stepper----------------------------------------------------------
        /*reporter.hardAssert(getRogersOVCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
                "Billing Address is not selected");*/
        getRogersOVCheckoutPage().clkDeliveryMethod("PRO");
        reporter.reportLogPassWithScreenshot("Pro on the go Delivery selected");
        reporter.hardAssert(getRogersOVCheckoutPage().verifyAppointmentLabel(),"Appointment label is available","Appointment label is not available");
        getRogersOVCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
        getRogersOVCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
        //---------------------------------------------Review Order page----------------------------------------------------------
        reporter.hardAssert(getRogersOVReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        boolean isPaymentRequired = getRogersOVReviewOrderPage().verifyPaymentRequired();
        getRogersOVReviewOrderPage().clkPointsToMentionCheckbox();
        getRogersOVReviewOrderPage().clkEmailConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersOVReviewOrderPage().clkSubmitOrderBtn();
        reporter.reportLogWithScreenshot("Submit Order Button Pressed");
        if(getRogersOVOrderReviewPage().isPaymentRequired()) {
            //getRogersOVOrderReviewPage().clkContinue();
            getRogersOVOneTimePaymentPage().clkPreAuthorizedCreditCardTokenButton();
            getRogersOVOneTimePaymentPage().setNameonCard();
            getRogersOVOneTimePaymentPage().setTokenDetails(TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getNumber1(),
                    TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getExpiryMonth1(),
                    TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getExpiryYear1());
            reporter.reportLogWithScreenshot("Rogers Payment Page");
            getRogersOVPaymentPage().clkSubmit();
        }
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        //reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        //reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyBANOrderConfirmationPage(), "BAN displayed is the same as the given BAN", "BAN displayed isn't the same as the given BAN");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}
