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
 * TC20 - Validate OV NAC TERM flow for Outbound-Low Risk customer by selecting T&T plan_Port-in_Passport + Safe Send combination in Credit Evaluation_MB_EN
 * @author Praveen.Kumar7
 */

public class RogersBFA_OV_TC20_NAC_ValidateOutboundLowRisk_BasicPhoneWithTalkAndTexPlan_NonPOTG_Portin_MB_EN_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("fr") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVNACSession(System.getProperty("QaOVUrl"),strBrowser, strLanguage, RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase18.getContactID(),TestDataHandler.bfaOneViewLogin.getUsrID(), TestDataHandler.bfaOneViewLogin.getLoginID(),  method);
    }

    @Test(groups = {"RegressionBFA","RegressionOVBFA","OVNACBFA"})
    public void rogersNACBOutboundBasicPhoneWithTalkandTextPlanMBTest() {
        reporter.hardAssert(getEnvironmentSelectionPage().presenceOfTheGoButton(), "Rogers OV environment selection page displayed", "Rogers OV environment selection page not displayed");
        reporter.reportLogWithScreenshot("Rogers OV environment selection page loaded");
        getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
        reporter.reportLogWithScreenshot("Rogers OV environment selected" + TestDataHandler.bfaOneViewConfig.getEnvironmentName());
        //-------------------------------------NAC Dashboard page-----------------------------------------------------------
        reporter.hardAssert(getNacDashboardPage().verifyNewCustomerDashboard(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Rogers OV NAC Dashboard page");
        getAccountOverViewPage().changeFidoDealerToRogers();
        getNacDashboardPage().clkCustomerButton();
        reporter.reportLogWithScreenshot("Services under customer button");
        getNacDashboardPage().clkWirelessButton();
        reporter.reportLogWithScreenshot("Active Wireless Service Modal");
        getNacDashboardPage().fillShippingAddressField(TestDataHandler.buyFlowsOVtestCase20.getShippingAddress());
        getNacDashboardPage().clkGetANewPhoneButton();
        //-------------------------------------Choose Phone page-------------------------------------------------------------
        reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase20.getDeviceName()), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        String deviceName = TestDataHandler.buyFlowsOVtestCase20.getDeviceName();
        getRogersOVChoosePhonePage().clickDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase20.getDeviceName());
        //-------------------------------------Device Config page-------------------------------------------------------------
        getRogersOVChoosePhonePage().selectDeviceColor(TestDataHandler.buyFlowsOVtestCase20.getDeviceColor());
        reporter.reportLogPassWithScreenshot("Device config page displayed");
        getRogersOVChoosePhonePage().clickContinueButton();
        //-------------------------------------Plan config page----------------------------------------------------------------
        reporter.softAssert(getRogersOVPlanConfigPage().verifyBreadCrumb(deviceName),
                "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        reporter.hardAssert(getRogersOVPlanConfigPage().verifySelectedDeviceSection(deviceName), "Plan Config loaded", "Plan config page not loaded");
        reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");
        getRogersOVPlanConfigPage().clkPreCartDeviceCostContinueButtonForNac();
        reporter.reportLogPassWithScreenshot("Device cost option selected");
        getRogersOVPlanConfigPage().selectNonShareDataAndClkContinue(getRogersOVPlanConfigPage().getupdatedPlanIndexForTalkPlans(TestDataHandler.buyFlowsOVtestCase20.getDataOptionIndex()));
        reporter.hardAssert(getRogersOVPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersOVPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.buyFlowsOVtestCase20.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersOVPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersOVPlanConfigPage().clickCartSummaryContinueButton();
        //############################CheckoutPage############################//
        //----------------------------------------------Create Profile Stepper----------------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().verifyCreateProfileTitle(),"Create profile Title Present","Create profile Title not present");
        String emailCreateProfile=getRogersOVCheckoutPage().setEmailCreateProfile();
        String firstName = getRogersOVCheckoutPage().setFirstNameCreateProfile();
        String lastName = getRogersOVCheckoutPage().setLastNameCreateProfile();
        String fullNameCreateProfile=firstName+" "+lastName;
        getRogersOVCheckoutPage().setContactNumberCreateProfile(TestDataHandler.buyFlowsOVtestCase20.getContactNumber());
        reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
        reporter.reportLogPassWithScreenshot("Create Profile Page details provided for Address,Shipping Address & Language Selected");
        getRogersOVCheckoutPage().clkBtnGotoCreditEvalStepper();
        //-----------------------------------------Credit Evaluation Stepper------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
        getRogersOVCheckoutPage().selectYearDropdownOption(TestDataHandler.buyFlowsOVtestCase20.getDateOfBirthYear());
        getRogersOVCheckoutPage().selectMonthDropdownOption(TestDataHandler.buyFlowsOVtestCase20.getDateOfBirthMonth());
        getRogersOVCheckoutPage().selectDayDropdownOption(TestDataHandler.buyFlowsOVtestCase20.getDateOfBirthDay());
        getRogersOVCheckoutPage().selectPrimaryDropdownOption(TestDataHandler.buyFlowsOVtestCase20.getSelectYourPrimaryIdOption(), TestDataHandler.buyFlowsOVtestCase20.getNumber());
        reporter.reportLogPassWithScreenshot("Passport details Entered Successfully");
        getRogersOVCheckoutPage().selectSecondDropdownOption(TestDataHandler.buyFlowsOVtestCase20.getSelectYourSecondIdOption(),TestDataHandler.buyFlowsOVtestCase20.getSecondNumber());
        getRogersOVCheckoutPage().clkCreditAuthorizationChkBox();
        getRogersOVCheckoutPage().clkCreditEvalContinue();
        reporter.reportLogWithScreenshot("Credit Evaluation modal displayed");
        reporter.hardAssert(getRogersOVChoosePhonePage().checkAcceptAndContinueOnCreditEvalModal() ,
                "Credit Evaluation modal with credit information displayed","Credit Evaluation modal doesn't contain credit info");
        reporter.hardAssert(getRogersOVChoosePhonePage().validateCustomerType(),
                "Given customer risk type "+TestDataHandler.buyFlowsOVtestCase20.getCustomerRiskLevel()+" matches the risk type "+getRogersOVChoosePhonePage().checkCustomerType()+" from the credit evaluation modal",
                "Given customer risk type "+TestDataHandler.buyFlowsOVtestCase20.getCustomerRiskLevel()+" does not match the risk type "+getRogersOVChoosePhonePage().checkCustomerType()+" from the credit evaluation modal");
        getRogersOVChoosePhonePage().clickAcceptAndContinueOnCreditEvalModal();
        reporter.reportLogWithScreenshot("clicked on Accept and Continue button");
        //--------------------------------------------Choose a Number Stepper------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
        reporter.softAssert(getRogersOVCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose phone number page loaded successfully");
        getRogersOVCheckoutPage().selectPortinOption();
        getRogersOVCheckoutPage().chooseExistingNumberOption(TestDataHandler.buyFlowsOVtestCase20.getPortinNumber());
        reporter.hardAssert(getRogersOVCheckoutPage().verifyPortinEligibility(),
                "Entered number is eligible to portin", "Entered number not eligible to portin");
        reporter.reportLogPassWithScreenshot("Portin number verified successfully");
        String portinSuccessMessage = getRogersOVCheckoutPage().getPortinSuccessMessage();
        reporter.reportLogWithScreenshot(portinSuccessMessage);
        getRogersOVCheckoutPage().clkContinueBtnPorinStepper();
        //---------------------------------------------Billing & Payment Stepper------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().isBillingOptionsTitleDisplayed(), "Billing Options Title Displayed", "Billing Options Title Not Present");
        reporter.softAssert(getRogersOVCheckoutPage().isPaymentMethodDropdownPresent(),
                "Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not disaplayed");
        getRogersOVCheckoutPage().selectPayWithExistingCard();
        reporter.reportLogWithScreenshot("CC option is selected");
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
