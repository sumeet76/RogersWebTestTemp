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
 * TC01 - Regression - [RNAC TERM] - Perform Rogers Net New Activation - TERM with Standard Shipping(Finance plan with Non POTG)_E2E
 */

public class RogersBFA_TC49_RNAC_TERM_2P_Ignite_WithNoWlsProduct_StdShipping_NoTerm_Test extends BaseTestClass {

  
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

    @Test(groups = {"RegressionBFA","CONNACBFA"})
    public void tc49_RNAC_2p_Ignite_StdShippingTest() throws InterruptedException, IOException {
    	 //**************************Device catalog page****************************************
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getDeviceName());
        reporter.reportLogWithScreenshot("New or existing customer modal Popup");
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyAddALineBtnForIgniteCustomer(),
                "Add a line button is verified successfully for Internet,TV or SHM customer","Add a line button is not displayed for Internet,TV or SHM customer");
        Map<String,String> custInfoMap = getRogersDeviceCataloguePage().getCustomerInfoMap(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getUsername(), TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getPassword());
        getRogersDeviceCataloguePage().clkAddALineBtnForIgniteCustomer();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getUsername());
        getRogersLoginPage().clkContinueSignIn();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
//        getRogersLoginPage().clkSkipIFrame();
//        getRogersLoginPage().switchOutOfSignInIFrame();
        // ***************************Device config page************************************
        reporter.reportLogWithScreenshot("Device config page");
        getRogersDeviceConfigPage().clickContinueButton();
        //############################Plan config page###############################
        reporter.hardAssert(getRogersPlanConfigPage().verifyPlanConfigPage(), "Plan config page is loaded", "Plan config page is not loaded");
        getRogersPlanConfigPage().clkRadioButtonNoTerm();
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getDataOptionIndex()),this.getClass().getSimpleName());
        getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page data protection selected");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersPlanConfigPage().clkContinueDeviceProtection();
        reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        
        //############################CheckoutPage############################//
        if(!(custInfoMap.size()==0)) {
            if (custInfoMap.containsKey("emailAddress")) {
                getRogersCheckoutPage().setEmailCreateProfile();
                getRogersCheckoutPage().setLastNameCreateProfile();
                reporter.reportLogWithScreenshot("Email address entered successfullly");
            }
            if (custInfoMap.containsKey("firstName")) {
                getRogersCheckoutPage().setFirstNameCreateProfile();
            }
            if (custInfoMap.containsKey("lastName")) {
                getRogersCheckoutPage().setLastNameCreateProfile();
            }
            if (custInfoMap.containsKey("homePhone")) {
                getRogersCheckoutPage().setContactNumberCreateProfile(TestDataHandler.tc04NACTermBopis.getContactNumber());
            }
            if (custInfoMap.containsKey("billingProvince")) {
                getRogersCheckoutPage().setBillingAddressCreateProfile(TestDataHandler.tc04NACTermBopis.getBillingAddress());
                reporter.reportLogWithScreenshot("Address entered successfullly");
            }
            getRogersCheckoutPage().clkLanguageEnglishRadioBtnCreateProfile();
            reporter.reportLogPassWithScreenshot("Language Selected");
            getRogersCheckoutPage().switchToRecaptchaIFrame();
            getRogersCheckoutPage().clkImNotRombotCheckbox();
            reporter.reportLogPassWithScreenshot("I'm not Robot Checked");
            getRogersCheckoutPage().switchOutOfGoogleIFrame();
            getRogersCheckoutPage().clkBtnGotoCreditEvalStepper();
        }
        //***************Credit Evaluation Stepper*************//
        getRogersCheckoutPage().switchToCreditCardIFrame();
        getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getCreditCardDetails());
        reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
        getRogersCheckoutPage().switchOutOfCreditCardIFrame();
        getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getExpiryDate());
        getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getDropdownOption());
        getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getPassportNumber());
        reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
        getRogersCheckoutPage().clkCreditAuthorizationChkBox();
        getRogersCheckoutPage().clkCreditEvalContinue();
        reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
        // ***************Choose a Number Stepper*************//
        //getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getCityName());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully" );
        //getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed","Find More Available Number Button not disaplayed");
        getRogersCheckoutPage().clkChooseNumberbutton();
        reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(),"Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
        // ***************Billing & Payment Stepper*************//
        getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getPaymentMethod());
        getRogersCheckoutPage().clkBillingContinueButton();
        getRogersCheckoutPage().clickSkipNacAutopay();
        //***************Shipping Stepper*************//
        getRogersCheckoutPage().clkDeliveryMethod("STANDARD");
        reporter.reportLogPass("Standard Delivery selected");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPass("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPass("Clicked submit button below cart summary");
        //***************Order Review Page*************//
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(),"Order Review Page Title Present","Order Review Page Title is not Present");
        reporter.reportLogPass("Order Review Page");
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        //getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        getRogersReviewOrderPage().clkEmailConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkSubmitOrderBtn();
        //---------------------One Time Payment page------------------------------//
        reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),
                "Pay with Credit card details are present on OneTime payment page", "Pay with Credit card details are not present on OneTime payment page");
        getRogersOneTimePaymentPage().setNameonCard();
        getRogersOneTimePaymentPage().switchToCreditCardIFrame();
        getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getCreditCardDetailsOTP());
        getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
        getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc49_2P_Ignite_NACNoTermTermSS.getExpiryDateOTP());
        getRogersOneTimePaymentPage().setCVV();
        reporter.reportLogPassWithScreenshot("Credit Card Details Entered Successfully");
        getRogersOneTimePaymentPage().clkSubmitOrderBtn();
        //************Order Confirmation Page****************//
        reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),"Order Confrimation Page Title Present","Order Confrimation Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Confirmation Page");
        
    }


        @AfterMethod(alwaysRun = true)
        public void afterTest () throws InterruptedException {
            closeSession();
        }
    }


