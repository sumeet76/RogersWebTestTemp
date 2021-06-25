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
 * TC18 - Validate OV NAC BYOD flow for Outbound-New customer by selecting Outbound plans_Port-in-Invoice-Provincial + Safe Send combination in Credit Evaluation_ON_EN
 * @author Praveen.Kumar7
 */

public class RogersBFA_OV_TC18_NAC_BYOD_OutboundPlans_Portin_Invoice_ON_Test extends BaseTestClass{


    @BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVNACSession(System.getProperty("QaOVUrl"),strBrowser, strLanguage, RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase18.getContactID(),TestDataHandler.bfaOneViewLogin.getUsrID(), TestDataHandler.bfaOneViewLogin.getLoginID(),  method);
    }

    @Test(groups = {"RegressionBFA","RegressionOVBFA","OVNACBFA"})
    public void rogersNACBYODOutboundPlanPortinInvoiceONTest() {
        reporter.hardAssert(getEnvironmentSelectionPage().presenceOfTheGoButton(), "Rogers OV environment selection page displayed" , "Rogers OV environment selection page not displayed");
        reporter.reportLogWithScreenshot("Rogers OV environment selection page loaded");
        getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
        reporter.reportLogWithScreenshot("Rogers OV environment selected" + TestDataHandler.bfaOneViewConfig.getEnvironmentName());
        //-------------------------------------NAC Dashboard page---------------------------------------------
        //getAccountOverViewPage().enterDealerCodeDialogue();
        //getAccountOverViewPage().clkSubmitBtnDealerCodeDialogue();
        reporter.hardAssert(getNacDashboardPage().verifyNewCustomerDashboard(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Rogers OV NAC Dashboard page");
        getNacDashboardPage().clkCustomerButton();
        reporter.reportLogWithScreenshot("Services under customer button");
        getNacDashboardPage().clkWirelessButton();
        reporter.reportLogWithScreenshot("Active Wireless Service Modal");
        getNacDashboardPage().fillShippingAddressField(TestDataHandler.buyFlowsOVtestCase18.getShippingAddress());
        //getNacDashboardPage().fillApartmentField(TestDataHandler.buyFlowsOVtestCase14.getApartment());
        reporter.reportLogPassWithScreenshot("Shipping address entered successfully");
        getNacDashboardPage().clkBringYourOwnPhoneButton();
        //-------------------------------------PLAN CONFIG PAGE-------------------------------------------------
        reporter.hardAssert(getRogersOVPlanConfigPage().verifyPlanConfigPageLoaded(),
                "Plan config page loaded successfully", "Plan config page not loaded");
        getRogersOVPlanConfigPage().clickOutBoundAccordion();
        reporter.reportLogWithScreenshot("Outbound plan accordion expanded");
        getRogersOVPlanConfigPage().selectDataOptionButton(getRogersOVPlanConfigPage().getupdatedDataOptionIndexForOutbound(TestDataHandler.buyFlowsOVtestCase18.getDataOptionIndex()));
        reporter.reportLogPassWithScreenshot("Data option selected");
        reporter.hardAssert(getRogersOVPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersOVPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.buyFlowsOVtestCase15.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersOVPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersOVPlanConfigPage().clickCartSummaryContinueButton();
        //############################CheckoutPage############################//
        //***************Create Profile Stepper*************//
        reporter.softAssert(getRogersOVCheckoutPage().verifyCreateProfileTitle(),"Create profile Title Present","Create profile Title not present");
        String emailCreateProfile=getRogersOVCheckoutPage().setEmailCreateProfile();
        String firstName = getRogersOVCheckoutPage().setFirstNameCreateProfile();
        String lastName = getRogersOVCheckoutPage().setLastNameCreateProfile();
        String fullNameCreateProfile=firstName+" "+lastName;
        getRogersOVCheckoutPage().setContactNumberCreateProfile(TestDataHandler.buyFlowsOVtestCase18.getContactNumber());
        reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
        reporter.reportLogPassWithScreenshot("Create Profile Page details provided for Address,Shipping Address & Language Selected");
        getRogersOVCheckoutPage().clkBtnGotoCreditEvalStepper();
        //-----------------------------------------Credit Evaluation Stepper------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
        getRogersOVCheckoutPage().selectYearDropdownOption(TestDataHandler.buyFlowsOVtestCase18.getDateOfBirthYear());
        getRogersOVCheckoutPage().selectMonthDropdownOption(TestDataHandler.buyFlowsOVtestCase18.getDateOfBirthMonth());
        getRogersOVCheckoutPage().selectDayDropdownOption(TestDataHandler.buyFlowsOVtestCase18.getDateOfBirthDay());
        getRogersOVCheckoutPage().selectPrimaryDropdownOption(TestDataHandler.buyFlowsOVtestCase18.getSelectYourPrimaryIdOption(), TestDataHandler.buyFlowsOVtestCase18.getNumber());
        reporter.reportLogPassWithScreenshot("Provincial ID Number Entered Successfully");
        getRogersOVCheckoutPage().selectSecondDropdownOption(TestDataHandler.buyFlowsOVtestCase18.getSelectYourSecondIdOption(),TestDataHandler.buyFlowsOVtestCase18.getSecondNumber());
        getRogersOVCheckoutPage().clkCreditAuthorizationChkBox();
        getRogersOVCheckoutPage().clkCreditEvalContinue();
        reporter.reportLogWithScreenshot("Credit Evaluation modal displayed");
        reporter.hardAssert(getRogersOVChoosePhonePage().checkAcceptAndContinueOnCreditEvalModal() ,
                "Credit Evaluation modal with credit information displayed","Credit Evaluation modal doesn't contain credit info");
        reporter.hardAssert(getRogersOVChoosePhonePage().validateCustomerType(),
                "Given customer risk type "+TestDataHandler.buyFlowsOVtestCase18.getCustomerRiskLevel()+" matches the risk type "+getRogersOVChoosePhonePage().checkCustomerType()+" from the credit evaluation modal",
                "Given customer risk type "+TestDataHandler.buyFlowsOVtestCase18.getCustomerRiskLevel()+" does not match the risk type "+getRogersOVChoosePhonePage().checkCustomerType()+" from the credit evaluation modal");
        getRogersOVChoosePhonePage().clickAcceptAndContinueOnCreditEvalModal();
        reporter.reportLogWithScreenshot("clicked on Accept and Continue button");
        //--------------------------------------------Choose a Number Stepper------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
        reporter.softAssert(getRogersOVCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose phone number page loaded successfully");
        getRogersOVCheckoutPage().selectPortinOption();
        getRogersOVCheckoutPage().chooseExistingNumberOption(TestDataHandler.buyFlowsOVtestCase18.getPortinNumber());
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
        getRogersOVCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.buyFlowsOVtestCase18.getPaymentMethod());
        reporter.reportLogWithScreenshot("Invoice option is selected");
        getRogersOVCheckoutPage().clkBillingContinueButton();
        getRogersOVCheckoutPage().clksubmitBtnCheckoutPage();
        //-------------------------------------------------Order Review Page-----------------------------------------------------
        reporter.hardAssert(getRogersOVReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        getRogersOVReviewOrderPage().clkPointsToMentionCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersOVReviewOrderPage().clkSubmitOrderBtn();
        reporter.reportLogWithScreenshot("Submit Order Button Pressed");
        //-------------------------------------------------Order Confirmation page-------------------------------------------------
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
