package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * TC47 - Regression - 1P_Existing Ignite Account without wireless product - Perform Rogers New Activation - with VDP and BOPIS Shipping_E2E
 * @author praveen.kumar7
 */

public class RogersBFA_TC47_RNAC_TERM_1P_Ignite_WithNoWlsProduct_VDP_Bopis_Fin_Test extends BaseTestClass {

  
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

    @Test(groups = {"RegressionBFA","NACBFA"})
    public void tc47_RNACTerm_1P_Ignite_VDP_BopisTest() throws InterruptedException, IOException {
    	 //**************************Device catalog page****************************************
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getDeviceName());
        reporter.reportLogWithScreenshot("New or existing customer modal Popup");
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyAddALineBtnForIgniteCustomer(),
                "Add a line button is verified successfully for Internet,TV or SHM customer","Add a line button is not displayed for Internet,TV or SHM customer");
        Map<String,String> custInfoMap = getRogersDeviceCataloguePage().getCustomerInfoMap(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getUsername(), TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getPassword());
        getRogersDeviceCataloguePage().clkAddALineBtnForIgniteCustomer();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        // ***************************Device config page************************************
        reporter.reportLogWithScreenshot("Device config page");
        getRogersDeviceConfigPage().clickContinueButton();
        //############################Plan config page###############################
        reporter.hardAssert(getRogersPlanConfigPage().verifyPlanConfigPage(), "Plan config page is loaded", "Plan config page is not loaded");
        getRogersPlanConfigPage().clkDownPaymentChkBox();
        reporter.reportLogWithScreenshot("Down payment checkbox is selected");
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogWithScreenshot("Plan config page talk option selected");
        getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page data protection selected");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersPlanConfigPage().clkContinueDeviceProtection();
        reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        //***************Create Profile Stepper*************//
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
        getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getCreditCardDetails());
        reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
        getRogersCheckoutPage().switchOutOfCreditCardIFrame();
        getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getExpiryDate());
        getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getDropdownOption());
        getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getPassportNumber());
        reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
        getRogersCheckoutPage().clkCreditAuthorizationChkBox();
        getRogersCheckoutPage().clkCreditEvalContinue();
        reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
        // ***************Choose a Number Stepper*************//
        getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getCityName());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully" );
        getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed","Find More Available Number Button not disaplayed");
        getRogersCheckoutPage().clkChooseNumberbutton();
        reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(),"Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
     // ***************Billing & Payment Stepper*************//
        getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getPaymentMethod());
        getRogersCheckoutPage().clkBillingContinueButton();
        //***************Shipping Stepper*************//
        getRogersCheckoutPage().clkDeliveryMethod("EXPRESS");
        reporter.reportLogPass("Express Delivery selected");
        reporter.hardAssert(getRogersCheckoutPage().verifyExpressLocationMapPresent() ,"Express location map available", "Express location map not available");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPass("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPass("Clicked submit button below cart summary");
      //***************Order Review Page*************//
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(),"Order Review Page Title Present","Order Review Page Title is not Present");
        reporter.reportLogPass("Order Review Page");
        getRogersReviewOrderPage().clkFinancingConsentCheckbox();
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        getRogersReviewOrderPage().clkBopisConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkSubmitOrderBtn();
        //---------------------One Time Payment page------------------------------//
        reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),
                "Pay with Credit card details are present on OneTime payment page", "Pay with Credit card details are not present on OneTime payment page");
        getRogersOneTimePaymentPage().setNameonCard();
        getRogersOneTimePaymentPage().switchToCreditCardIFrame();
        getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getCreditCardDetailsOTP());
        getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
        getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc47_1P_Ignite_NACTermTermBopis.getExpiryDateOTP());
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


