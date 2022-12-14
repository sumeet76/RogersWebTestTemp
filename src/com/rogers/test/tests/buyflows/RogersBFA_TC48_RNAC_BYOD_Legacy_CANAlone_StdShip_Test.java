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
 * TC01 - Regression - [RNAC TERM] - Perform Rogers Net New Activation - TERM with Standard Shipping(Finance plan with Non POTG)_E2E
 */

public class RogersBFA_TC48_RNAC_BYOD_Legacy_CANAlone_StdShip_Test extends BaseTestClass {

  
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

    @Test(groups = {"RegressionBFA","CONNACBFA"})
    public void tc48_rnacByod_Legacy_StdShipTest() throws InterruptedException, IOException {
    	 //**************************Device catalog page****************************************

//        reporter.reportLogWithScreenshot("Login Page");
//        getRogersLoginPage().clkSignInIFrame();
//        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
//        //getRogersLoginPage().clkSkipIFrame();
//        getRogersLoginPage().switchOutOfSignInIFrame();
        //getRogersAccountOverviewPage().selectAccount(TestDataHandler.BFA_ProdTest_tc03_AALBYOD_StdShipping.getBan());
        //############################Plan config page###############################
        getDriver().get(System.getProperty("AWSUrl")+"/bring-your-own-device");
        Map<String,String> custInfoMap = getRogersDeviceCataloguePage().getCustomerInfoMap(TestDataHandler.tc48_Legacy_NACByod.getUsername(), TestDataHandler.tc48_Legacy_NACByod.getPassword());
        getRogersDeviceCataloguePage().clkAddALineBtnForIgniteCustomer();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc48_Legacy_NACByod.getUsername());
        getRogersLoginPage().clkContinueSignIn();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc48_Legacy_NACByod.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        //reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
        //getRogersLoginPage().clkSkipIFrame();
        //getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersPlanConfigPage().verifyPlanConfigPage(), "Plan config page is loaded", "Plan config page is not loaded");
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc48_Legacy_NACByod.getDataOptionIndex()),this.getClass().getSimpleName());
        getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page data protection selected");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersPlanConfigPage().clkContinueDeviceProtection();
        reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        //***************Create Profile Stepper*************//
        if(!(custInfoMap.size()==0)) {
            if (custInfoMap.containsKey("emailAddress")) {
                String emailCreateProfile = getRogersCheckoutPage().setEmailCreateProfile();
                getRogersCheckoutPage().confirmEmailCreateProfile(emailCreateProfile);
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
        reporter.softAssert(getRogersCheckoutPage().verifyCreditEvaluationTitle(), "CreditEvaluation Title verified",
                "CreditEvaluation Title not present");
        getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc48_Legacy_NACByod.getDateOfBirthYear());
        getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc48_Legacy_NACByod.getDateOfBirthMonth());
        getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.tc48_Legacy_NACByod.getDateOfBirthDay());
        getRogersCheckoutPage().switchToCreditCardIFrame();
        getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc48_Legacy_NACByod.getCreditCardDetails());
        reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
        getRogersCheckoutPage().switchOutOfCreditCardIFrame();
        getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc48_Legacy_NACByod.getExpiryDate());
        getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc48_Legacy_NACByod.getDropdownOption());
        getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc48_Legacy_NACByod.getPassportNumber());
        reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
        getRogersCheckoutPage().clkCreditAuthorizationChkBox();
        getRogersCheckoutPage().clkCreditEvalContinue();
        reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
        // ***************Choose a Number Stepper*************//
        getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc48_Legacy_NACByod.getCityName());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully" );
        getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed","Find More Available Number Button not disaplayed");
        getRogersCheckoutPage().clkChooseNumberbutton();
        //reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(),"Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        //reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
        // ***************Billing & Payment Stepper*************//
//        getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc48_Legacy_NACByod.getPaymentMethod());
//        getRogersCheckoutPage().clkBillingContinueButton();
        getRogersCheckoutPage().clickSkipAutopay();
        //***************Shipping Stepper*************//
        getRogersCheckoutPage().clkDeliveryMethod("STANDARD");
        reporter.reportLogPass("Standard Delivery selected");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Continue button clicked from Shipping Stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        //***************Order Review Page*************//
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(),"Order Review Page Title Present","Order Review Page Title is not Present");
        reporter.reportLogPass("Order Review Page");
        //getRogersReviewOrderPage().clkFinancingConsentCheckbox();
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        //getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkSubmitOrderBtn();
        //---------------------One Time Payment page------------------------------//
//        reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),
//                "Pay with Credit card details are present on OneTime payment page", "Pay with Credit card details are not present on OneTime payment page");
//        getRogersOneTimePaymentPage().setNameonCard();
//        getRogersOneTimePaymentPage().switchToCreditCardIFrame();
//        getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc48_Legacy_NACByod.getCreditCardDetailsOTP());
//        getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
//        getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc48_Legacy_NACByod.getExpiryDateOTP());
//        getRogersOneTimePaymentPage().setCVV();
//        reporter.reportLogPassWithScreenshot("Credit Card Details Entered Successfully");
//        getRogersOneTimePaymentPage().clkSubmitOrderBtn();
        //************Order Confirmation Page****************//
        reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),"Order Confrimation Page Title Present","Order Confrimation Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Confirmation Page");
    }


        @AfterMethod(alwaysRun = true)
        public void afterTest () throws InterruptedException {
            closeSession();
        }
    }


