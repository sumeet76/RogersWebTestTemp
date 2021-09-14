package com.rogers.test.tests.buyflowsoneview;

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

public class SOHOBFA_OV_TC23_NAC_BYOD_NonShareFinancingPlan_Bopis_ON_Test extends BaseTestClass{


    @BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVNACSession(System.getProperty("QaOVUrl"),strBrowser, strLanguage, RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase18.getContactID(),TestDataHandler.bfaOneViewLogin.getLoginID(),TestDataHandler.bfaOneViewLogin.getUsrID(), method);
    }

    @Test(groups = {"RegressionBFA","RegressionOVBFA","OVNACBFA","OVSOHOBFA","OVSOHONACBFA"})
    public void sohoNacBYODOutboundNonShareBopisONTest() {
        reporter.hardAssert(getEnvironmentSelectionPage().presenceOfTheGoButton(), "Rogers OV environment selection page displayed" , "Rogers OV environment selection page not displayed");
        reporter.reportLogWithScreenshot("Rogers OV environment selection page loaded");
        getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
        reporter.reportLogWithScreenshot("Rogers OV environment selected" + TestDataHandler.bfaOneViewConfig.getEnvironmentName());
        //-------------------------------------NAC Dashboard page---------------------------------------------
        //getAccountOverViewPage().enterDealerCodeDialogue();
        //getAccountOverViewPage().clkSubmitBtnDealerCodeDialogue();
        reporter.hardAssert(getNacDashboardPage().verifyNewCustomerDashboard(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Rogers OV NAC Dashboard page");
        getNacDashboardPage().clkSohoBtn();
        reporter.reportLogWithScreenshot("Services under customer button");
        getNacDashboardPage().clkWirelessButton();
        getNacDashboardPage().setDelearCode();
        reporter.reportLogWithScreenshot("Active Wireless Service Modal");
        getNacDashboardPage().fillShippingAddressField(TestDataHandler.tc23SOHONACBYODNonShareBopis.getShippingAddress());
        reporter.reportLogPassWithScreenshot("Shipping address entered successfully");
        getNacDashboardPage().clkBringYourOwnPhoneButton();
        //-------------------------------------PLAN CONFIG PAGE-------------------------------------------------
        getRogersOVPlanConfigPage().verifyCustomerTypeInHeader("BUSINESS");
        reporter.hardAssert(getRogersOVPlanConfigPage().verifyPlanConfigPageLoaded(),
                "Plan config page loaded successfully", "Plan config page not loaded");
        reporter.reportLogWithScreenshot("Outbound plan accordion expanded");
        getRogersOVPlanConfigPage().clkNonShareTab();
        getRogersOVPlanConfigPage().selectNonShareDataAndClkContinue(TestDataHandler.tc23SOHONACBYODNonShareBopis.getDataOptionIndex());
        reporter.reportLogPassWithScreenshot("Data option selected");
        reporter.hardAssert(getRogersOVPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersOVPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.tc23SOHONACBYODNonShareBopis.getTalkOptionIndex())),
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
        getRogersOVCheckoutPage().setBusinessName();
        getRogersOVCheckoutPage().setBusinessNumber(TestDataHandler.tc23SOHONACBYODNonShareBopis.getBusinessNumber());
        getRogersOVCheckoutPage().setContactNumberCreateProfile(TestDataHandler.tc23SOHONACBYODNonShareBopis.getContactNumber());
        getRogersOVCheckoutPage().setCompanySize(TestDataHandler.tc23SOHONACBYODNonShareBopis.getCompanySize());
        reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
        reporter.reportLogPassWithScreenshot("Create Profile Page details provided for Address,Shipping Address & Language Selected");
        getRogersOVCheckoutPage().clkBtnGotoCreditEvalStepper();
        //-----------------------------------------Credit Evaluation Stepper------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
        getRogersOVCheckoutPage().selectYearDropdownOption(TestDataHandler.tc23SOHONACBYODNonShareBopis.getDateOfBirthYear());
        getRogersOVCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc23SOHONACBYODNonShareBopis.getDateOfBirthMonth());
        getRogersOVCheckoutPage().selectDayDropdownOption(TestDataHandler.tc23SOHONACBYODNonShareBopis.getDateOfBirthDay());
        getRogersOVCheckoutPage().selectPrimaryDropdownOption(TestDataHandler.tc23SOHONACBYODNonShareBopis.getSelectYourPrimaryIdOption(), TestDataHandler.tc23SOHONACBYODNonShareBopis.getNumber());
        reporter.reportLogPassWithScreenshot("Provincial ID Number Entered Successfully");
        getRogersOVCheckoutPage().selectSecondDropdownOption(TestDataHandler.tc23SOHONACBYODNonShareBopis.getSelectYourSecondIdOption(),TestDataHandler.tc23SOHONACBYODNonShareBopis.getSecondNumber());
        getRogersOVCheckoutPage().clkCreditAuthorizationChkBox();
        getRogersOVCheckoutPage().clkCreditEvalContinue();
        reporter.reportLogWithScreenshot("Credit Evaluation modal displayed");
        reporter.hardAssert(getRogersOVChoosePhonePage().checkAcceptAndContinueOnCreditEvalModal() ,
                "Credit Evaluation modal with credit information displayed","Credit Evaluation modal doesn't contain credit info");
        reporter.hardAssert(getRogersOVChoosePhonePage().validateCustomerType(),
                "Given customer risk type "+TestDataHandler.tc23SOHONACBYODNonShareBopis.getCustomerRiskLevel()+" matches the risk type "+getRogersOVChoosePhonePage().checkCustomerType()+" from the credit evaluation modal",
                "Given customer risk type "+TestDataHandler.tc23SOHONACBYODNonShareBopis.getCustomerRiskLevel()+" does not match the risk type "+getRogersOVChoosePhonePage().checkCustomerType()+" from the credit evaluation modal");
        getRogersOVChoosePhonePage().clickAcceptAndContinueOnCreditEvalModal();
        reporter.reportLogWithScreenshot("clicked on Accept and Continue button");
        //--------------------------------------------Choose a Number Stepper------------------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
        reporter.softAssert(getRogersOVCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        getRogersOVCheckoutPage().selectCityDropdownOption(TestDataHandler.tc23SOHONACBYODNonShareBopis.getCtnCity());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
        getRogersOVCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        reporter.softAssert(getRogersOVCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
        getRogersOVCheckoutPage().clkChooseNumberbutton();
        reporter.hardAssert(getRogersOVCheckoutPage().isChooseaNumberLabelDisplayed(), "Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
        //---------------------------------------------Billing & Payment Stepper-----------------------------------------
        reporter.softAssert(getRogersOVCheckoutPage().isBillingOptionsTitleDisplayed(), "Billing Options Title Displayed", "Billing Options Title Not Present");
        reporter.softAssert(getRogersOVCheckoutPage().isPaymentMethodDropdownPresent(),
                "Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not disaplayed");
        getRogersOVCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc23SOHONACBYODNonShareBopis.getPaymentMethod());
        reporter.reportLogWithScreenshot("Invoice option is selected");
        //-------------------------------------------------Shipping Stepper----------------------------------------------
        getRogersOVCheckoutPage().clkBillingContinueButton();
        getRogersOVCheckoutPage().clkDeliveryMethod("EXPRESS");
        reporter.reportLogPass("Express Delivery selected");
        reporter.hardAssert(getRogersOVCheckoutPage().verifyExpressLocationMapPresent() ,"Express location map available", "Express location map not available");
        getRogersOVCheckoutPage().clkContinueBtnShipping();
        getRogersOVCheckoutPage().clksubmitBtnCheckoutPage();
        //-------------------------------------------------Order Review Page----------------------------------------------
        reporter.hardAssert(getRogersOVReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        getRogersOVReviewOrderPage().clkPointsToMentionCheckbox();
        getRogersOVReviewOrderPage().clkBopisConsentCheckbox();
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
