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
 * TC01 - Regression - [RNAC TERM] - Perform Rogers Net New Activation - TERM with Standard Shipping(Finance plan with Non POTG)_E2E
 */

public class RogersBFA_TC01_NAC_TermNpotgSSTest extends BaseTestClass {

  
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

    @Test(groups = {"RegressionBFA","SanityBFA","NACBFA"})
    public void rogersNACTermNpotgSSTest() throws InterruptedException {
    	 //**************************Device catalog page****************************************
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        String deviceName=TestDataHandler.tc01NACTermNpotgSS.getDeviceName();
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
        reporter.softAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen", "Modal element is not present on the screen");
        reporter.softAssert(getRogersDeviceCataloguePage().verifyGetStartedButtonOnModal(), "Get started button on the modal is present" ,"Get started button on the modal is not present");
        reporter.reportLogWithScreenshot("Modal window Popup");
        reporter.hardAssert(getRogersDeviceCataloguePage().clickGetStartedButtonOnModal(),"Clicked Get Started Button","Get Started button not able to click");
        // ***************************Device config page************************************
        reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(), "BreadCrumb on Phone config page is working fine", "BreadCrumb is not working fine");
        reporter.reportLogWithScreenshot("Device config page");
        getRogersDeviceConfigPage().clickContinueButton();
        //############################Plan config page###############################
        reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName), "BreadCrumb on Plan config page is working fine","BreadCrumb is not working fine");
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page data option selected");
        getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
        getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page data protection selected");
        getRogersPlanConfigPage().clickOptionInDataProtection(deviceName);
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
        String monthlyFeesAmount = getRogersPlanConfigPage().getMonthlyFeesAmount();
        String oneTimeFeesAmount = getRogersPlanConfigPage().getOneTimeFeesAmount();
        reporter.reportLogPassWithScreenshot("Cart summary: Monthly & OneTimeFees"+monthlyFeesAmount+"&"+oneTimeFeesAmount);
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        
        //############################CheckoutPage############################//
        //***************Cart Summary*************//
        String totalMonthlyFees=getRogersCheckoutPage().getMonthlyFeeAfterTax();
        String oneTimeFee=getRogersCheckoutPage().getOneTimeFeeAfterTax();
        String purchaseIncludes=getRogersCheckoutPage().getPurchaseIncludesText();
        reporter.reportLog("Checkout page Cart Summary Info"+"1. Total Monthly Fees"+totalMonthlyFees+"2. oneTimeFee"+oneTimeFee+"3. Purchase Include"+purchaseIncludes);
        //***************Create Profile Stepper*************//
        reporter.softAssert(getRogersCheckoutPage().verifyCreateProfileTitle(),"Create profile Title Present","Create profile Title not present");
        String emailCreateProfile=getRogersCheckoutPage().setEmailCreateProfile();
        getRogersCheckoutPage().confirmEmailCreateProfile(emailCreateProfile);
        //String firstName = getRogersCheckoutPage().setFirstNameCreateProfile();
        //String lastName = getRogersCheckoutPage().setLastNameCreateProfile();
      //*************** AVS Data Code- Commented for future issue ******//
        String firstName = getRogersCheckoutPage().setFirstNameCreateProfile();
        String lastName = getRogersCheckoutPage().setLastNameCreateProfile();
        //String firstName = getRogersCheckoutPage().setFirstNameCreateProfilepage("AMARAssspeares");
        //String lastName = getRogersCheckoutPage().setLastNameCreateProfilepage("SPEARSsscheck");
        String fullNameCreateProfile=firstName+" "+lastName;
        String contactNumberCreateProfile=TestDataHandler.tc01NACTermNpotgSS.getContactNumber();
        getRogersCheckoutPage().setContactNumberCreateProfile(contactNumberCreateProfile);
        reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
        getRogersCheckoutPage().setBillingAddressCreateProfile(TestDataHandler.tc01NACTermNpotgSS.getBillingAddress());
        //getRogersCheckoutPage().clkUseBillingAddressRadioBtnCreateProfile();
        getRogersCheckoutPage().clkLanguageEnglishRadioBtnCreateProfile();
        reporter.reportLogPassWithScreenshot("Create Profile Page details provided for Address,Shipping Address & Language Selected");
        getRogersCheckoutPage().switchToRecaptchaIFrame();
        getRogersCheckoutPage().clkImNotRombotCheckbox();
        reporter.reportLogPassWithScreenshot("I'm not Robot Checked");
        getRogersCheckoutPage().switchOutOfGoogleIFrame();
        getRogersCheckoutPage().clkBtnGotoCreditEvalStepper();
        //***************Credit Evaluation Stepper*************//
        reporter.softAssert(getRogersCheckoutPage().verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
		//getRogersCheckoutPage().setDateOfBirth(TestDataHandler.redesignRpotgData.getDateOfBirth());
		getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc01NACTermNpotgSS.getDateOfBirthYear());
		getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc01NACTermNpotgSS.getDateOfBirthMonth());
		getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.tc01NACTermNpotgSS.getDateOfBirthDay());
        getRogersCheckoutPage().switchToCreditCardIFrame();
        getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc01NACTermNpotgSS.getCreditCardDetails());
        reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
        getRogersCheckoutPage().switchOutOfCreditCardIFrame();
        getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc01NACTermNpotgSS.getExpiryDate());
        getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc01NACTermNpotgSS.getDropdownOption());
        getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc01NACTermNpotgSS.getPassportNumber());
        reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
        getRogersCheckoutPage().clkCreditAuthorizationChkBox();
        getRogersCheckoutPage().clkCreditEvalContinue();
        reporter.softAssert(getRogersCheckoutPage().isCreditEvalPopupPresent(),"Credit Evaluation Popup Displayed", "Credit Evaluation popup not disaplayed");
        reporter.softAssert(getRogersCheckoutPage().isCreditEvalTextOnModalPresent(), "Credit Evaluation Text Displayed","Credit Evaluation Text not disaplayed on Modal");
        reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
        reporter.hardAssert(getRogersCheckoutPage().isIdentificationLabel(),"Credit Evaluation Successful", "Credit Evaluation Identification Label not disaplayed");
       // ***************Choose a Number Stepper*************//      
        reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed","Choose a Number Title not disaplayed");
        reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(),"Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc01NACTermNpotgSS.getCityName());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully" );
        getRogersCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed","Find More Available Number Button not disaplayed");
        getRogersCheckoutPage().clkChooseNumberbutton();
        reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(),"Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
     // ***************Billing & Payment Stepper*************//
        reporter.softAssert(getRogersCheckoutPage().isBillingOptionsTitleDisplayed(),"Billing Options Title Displayed","Billing Options Title Not Present");
        reporter.softAssert(getRogersCheckoutPage().isPaymentMethodDropdownPresent(), "Select Payment Method Dropdown Displayed","Select Payment Method Dropdown not disaplayed");
		getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc01NACTermNpotgSS.getPaymentMethod());
        getRogersCheckoutPage().clkBillingContinueButton();
        //***************Billing Options Stepper*************//
        reporter.softAssert(getRogersCheckoutPage().clkBillingAddress(),"Billing Address radio button is selected ","Billing Address is not selected");
        getRogersCheckoutPage().clkDeliveryMethodStandard();
        reporter.reportLogPassWithScreenshot("Billing Options Stepper");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Continue button clicked from Billing Options Stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
      //***************Order Review Page*************//
        reporter.softAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(),"Order Review Page Title Present","Order Review Page Title is not Present");
        reporter.reportLogPass("Order Review Page");
        String totalMonthlyFeesReviewPage=getRogersReviewOrderPage().getMonthlyFeeAfterTax();
        reporter.hardAssert(totalMonthlyFees.equals(totalMonthlyFeesReviewPage),"Total Monthly Fee after tax matches with checkout page","Total Monthly Fee after tax not matches with checkout page");
        String oneTimeFeesReviewPage=getRogersReviewOrderPage().getOneTimeFeeAfterTax();
        reporter.hardAssert(oneTimeFee.equals(oneTimeFeesReviewPage),"Total One time fee after tax matches with checkout page","Total One time fee after tax not matches with checkout page");
        String puchaseIncludeReviewPage=getRogersReviewOrderPage().getPurchaseIncludesText();
        reporter.reportLogPassWithScreenshot("Order Review Page"+"1.Monthly Fees"+totalMonthlyFeesReviewPage+"2. OnetimeFees:"+oneTimeFeesReviewPage+"3.Purchase Include :"+puchaseIncludeReviewPage);
        String contactNameReviewPage=getRogersReviewOrderPage().getContactName();
        reporter.hardAssert(fullNameCreateProfile.equals(contactNameReviewPage),"Contact Name in Order Review Page matches as entered in Create Profile stepper","Contact Name in Order Review Page not matches as entered in Create Profile stepper");
        String contactEmailReviewPage=getRogersReviewOrderPage().getContactEmail();
        reporter.hardAssert(emailCreateProfile.equals(contactEmailReviewPage),"Contact email in Order Review Page matches as entered in Create Profile stepper","Contact email in Order Review Page not matches as entered in Create Profile stepper");
        reporter.reportLogPassWithScreenshot("Order Review Page : Contact Details");
        getRogersReviewOrderPage().clkFinancingConsentCheckbox();
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        //getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkSubmitOrderBtn();
        //************Order Confirmation Page****************//
        reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),"Order Confrimation Page Title Present","Order Confrimation Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Confirmation Page");
        String totalMonthlyFeesConfirmationPage=getRogersNACOrderConfirmationPage().getMonthlyFeeAfterTax();
        reporter.hardAssert(totalMonthlyFees.equals(totalMonthlyFeesConfirmationPage),"Total Monthly Fee after tax matches with checkout page","Total Monthly Fee after tax not matches with checkout page");
        String oneTimeFeesConfirmationPage=getRogersNACOrderConfirmationPage().getOneTimeFeeAfterTax();
        reporter.hardAssert(oneTimeFee.equals(oneTimeFeesConfirmationPage),"Total One time fee after tax matches with checkout page","Total One time fee after tax not matches with checkout page");
        String purchaseIncludesConfrimation=getRogersNACOrderConfirmationPage().getPurchaseIncludesText();
        reporter.reportLogPassWithScreenshot("Purchase includes captured as" + "-->" +purchaseIncludesConfrimation);
  }


        @AfterMethod(alwaysRun = true)
        public void afterTest () throws InterruptedException {
            closeSession();
        }
    }


