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
 * TC19 - Validate OV NAC TERM flow for Outbound-New customer by selecting a plan with multiple autodeploy discount_NonPortin_NonPOTG-
 * Invoice payment option_Passport + Credit Card combination in Credit Evaluation_HighRisk_QC_FR
 * @author Praveen.Kumar7
 */

public class RogersBFA_OV_TC19_NAC_ValidateOutboundCustomerWithMultipleADMSFDiscount_NonPOTG_NonPortin_HighRisk_QC_FR_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("fr") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVNACSession(System.getProperty("QaOVUrl"),strBrowser, strLanguage, RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase18.getContactID(),TestDataHandler.bfaOneViewLogin.getUsrID(), TestDataHandler.bfaOneViewLogin.getLoginID(),  method);
    }

    @Test(groups = {"RegressionBFA","RegressionOVBFA","OVNACBFA"})
    public void rogersNACOutboundPlanWithMsfDiscountHighRiskQCTest() {
        reporter.hardAssert(getEnvironmentSelectionPage().presenceOfTheGoButton(), "Rogers OV environment selection page displayed", "Rogers OV environment selection page not displayed");
        reporter.reportLogWithScreenshot("Rogers OV environment selection page loaded");
        getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
        reporter.reportLogWithScreenshot("Rogers OV environment selected" + TestDataHandler.bfaOneViewConfig.getEnvironmentName());
        //-------------------------------------NAC Dashboard page---------------------------------------------
      //  getNacDashboardPage().selectFrenchLanguage();
        reporter.hardAssert(getNacDashboardPage().verifyNewCustomerDashboard(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Rogers OV NAC Dashboard page");
        getAccountOverViewPage().changeFidoDealerToRogers();
        getNacDashboardPage().clkCustomerButton();
        reporter.reportLogWithScreenshot("Services under customer button");
        getNacDashboardPage().clkWirelessButton();
        reporter.reportLogWithScreenshot("Active Wireless Service Modal");
        getNacDashboardPage().fillShippingAddressField(TestDataHandler.buyFlowsOVtestCase19.getShippingAddress());
        getNacDashboardPage().clkGetANewPhoneButton();
        //-------------------------------------Choose Phone page---------------------------------------------
        reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase19.getDeviceName()), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        String deviceName = TestDataHandler.buyFlowsOVtestCase19.getDeviceName();
        getRogersOVChoosePhonePage().clickDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase19.getDeviceName());
        //-------------------------------------Device Config page--------------------------------------------
        getRogersOVChoosePhonePage().selectDeviceColor(TestDataHandler.buyFlowsOVtestCase19.getDeviceColor());
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
        getRogersOVPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersOVPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.buyFlowsOVtestCase19.getDataOptionIndex()));
        reporter.reportLogPassWithScreenshot("Data option selected");
        reporter.hardAssert(getRogersOVPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersOVPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.buyFlowsOVtestCase19.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersOVPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersOVPlanConfigPage().clickCartSummaryContinueButton();
        //-------------------------------------------Create Profile Stepper----------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().verifyCreateProfileTitle(),"Create profile Title Present","Create profile Title not present");
        String emailCreateProfile=getRogersOVCheckoutPage().setEmailCreateProfile();
        String firstName = getRogersOVCheckoutPage().setFirstNameCreateProfile();
        String lastName = getRogersOVCheckoutPage().setLastNameCreateProfile();
        String fullNameCreateProfile=firstName+" "+lastName;
        getRogersOVCheckoutPage().setContactNumberCreateProfile(TestDataHandler.buyFlowsOVtestCase19.getContactNumber());
        reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
        reporter.reportLogPassWithScreenshot("Create Profile Page details provided for Address,Shipping Address & Language Selected");
        getRogersOVCheckoutPage().clkBtnGotoCreditEvalStepper();
        //-----------------------------------------Credit Evaluation Stepper------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
        getRogersOVCheckoutPage().selectYearDropdownOption(TestDataHandler.buyFlowsOVtestCase19.getDateOfBirthYear());
        getRogersOVCheckoutPage().selectMonthDropdownOption(TestDataHandler.buyFlowsOVtestCase19.getDateOfBirthMonth());
        getRogersOVCheckoutPage().selectDayDropdownOption(TestDataHandler.buyFlowsOVtestCase19.getDateOfBirthDay());
        getRogersOVCheckoutPage().selectPrimaryDropdownOption(TestDataHandler.buyFlowsOVtestCase19.getSelectYourPrimaryIdOption(), TestDataHandler.buyFlowsOVtestCase19.getNumber());
        reporter.reportLogPassWithScreenshot("Passport details Entered Successfully");
        getRogersOVCheckoutPage().selectSecondDropdownOption(TestDataHandler.buyFlowsOVtestCase19.getSelectYourSecondIdOption(),TestDataHandler.buyFlowsOVtestCase19.getSecondNumber());
        getRogersOVCheckoutPage().clkCreditAuthorizationChkBox();
        getRogersOVCheckoutPage().clkCreditEvalContinue();
        reporter.reportLogWithScreenshot("Credit Evaluation modal displayed");
        reporter.hardAssert(getRogersOVChoosePhonePage().checkAcceptAndContinueOnCreditEvalModal() ,
                "Credit Evaluation modal with credit information displayed","Credit Evaluation modal doesn't contain credit info");
        reporter.hardAssert(getRogersOVCheckoutPage().verifyDownPayment(deviceCost,TestDataHandler.buyFlowsOVtestCase19.getCustomerRiskLevel()),
                "Downpayment amount is displayed correctly", "Downpayment amount not displayed correctly");
        //reporter.hardAssert(getRogersOVCheckoutPage().verifyCLMAmount(TestDataHandler.buyFlowsOVtestCase19.getCustomerRiskLevel()),
                //"CLM amount verified successfully", "Invalid CLM amount");
        getRogersOVChoosePhonePage().clickAcceptAndContinueOnCreditEvalModal();
        reporter.reportLogWithScreenshot("clicked on Accept and Continue button");
        //--------------------------------------------Choose a Number Stepper------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
        reporter.softAssert(getRogersOVCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose phone number page loaded successfully");
        getRogersOVCheckoutPage().selectCityDropdownOption(TestDataHandler.buyFlowsOVtestCase19.getCtnCity());
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
        getRogersOVCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.buyFlowsOVtestCase19.getPaymentMethod());
        reporter.reportLogWithScreenshot("Invoice option is selected");
        getRogersOVCheckoutPage().clkBillingContinueButton();
        //----------------------------------------------Shipping Stepper----------------------------------------------------------
        getRogersOVCheckoutPage().clkDeliveryMethod("STANDARD");
        reporter.reportLogPassWithScreenshot("Standard Delivery selected");
        getRogersOVCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
        getRogersOVCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
        //---------------------------------------------Review Order page----------------------------------------------------------
        reporter.hardAssert(getRogersOVReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        getRogersOVReviewOrderPage().clkPointsToMentionCheckbox();
        getRogersOVReviewOrderPage().clkEmailConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersOVReviewOrderPage().clkSubmitOrderBtn();
        reporter.reportLogWithScreenshot("Submit Order Button Pressed");
        if(getRogersOVOrderReviewPage().isPaymentRequired()) {
            //getRogersOVOrderReviewPage().clkContinue();
            getRogersOVOneTimePaymentPage().clkPreAuthorizedCreditCardTokenButton();
            getRogersOVOneTimePaymentPage().setNameonCard();
            getRogersOVOneTimePaymentPage().setTokenDetails(TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getNumber3(),
                    TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getExpiryMonth3(),
                    TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getExpiryYear3());
            reporter.reportLogWithScreenshot("Rogers Payment Page");
            getRogersOVPaymentPage().clkSubmit();
        } /*else {
			getRogersOVOrderReviewPage().clkSubmitOrder();
		}*/
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
