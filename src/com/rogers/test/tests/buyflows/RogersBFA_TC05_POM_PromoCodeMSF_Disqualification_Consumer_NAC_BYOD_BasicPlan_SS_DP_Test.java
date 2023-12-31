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
 * TC05 - Regression - [RNAC BYOD] - Perform Rogers Net New Activation - BYOD with Standard Shipping_E2E
 */

public class RogersBFA_TC05_POM_PromoCodeMSF_Disqualification_Consumer_NAC_BYOD_BasicPlan_SS_DP_Test extends BaseTestClass {

	@BeforeMethod (alwaysRun = true) @Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("isIdentificationLabelen") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.redesignrogers, method);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest () throws InterruptedException {
		closeSession();
	}

	@Test(groups = {"RegressionBFA","NACBFA","DPBYOD"})
	public void tc05_POMPromoCodeMSF_RogersNacBYODDP_SSTest() throws InterruptedException {
		//getDriver().get(System.getProperty("AWSUrl")+"/bring-your-own-device?flowType=byod");
		reporter.hardAssert(getRogersPlanConfigPage().verifyBreadCrumb(), "BreadCrumb on Plan config page is displaying fine","BreadCrumb is not displaying fine");
		// ***************************Promo Section************************************
		//getRogersPlanConfigPage().clkPromoSection();
		reporter.reportLogWithScreenshot("Promo Section Displayed");
		getRogersPlanConfigPage().setPromoCode(TestDataHandler.tc05NACByodSS.getPromoCode());
		reporter.reportLogWithScreenshot("Promo Code Entered");
		getRogersPlanConfigPage().clkCheckPromoBtn();
		reporter.hardAssert(getRogersPlanConfigPage().verifyPromoSuccessMsg(), "Promo Code Applied Successfully", "Promo Code Not Applied");
		getRogersPlanConfigPage().clickContinuePromoModal();
		//############################Plan config page###############################
		//getRogersPlanConfigPage().clkBasicTab();
		//getRogersPlanConfigPage().selectBasicPlanAndClkContinueBtn(TestDataHandler.tc05NACByodSS.getDataOptionIndex());
		//getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
		//getRogersPlanConfigPage().clickShowMoreDetails();
		getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc06NACByodTermBopis.getDataOptionIndex()),this.getClass().getSimpleName());
		getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page data option selected");
		//getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		//getRogersPlanConfigPage().clickGetBPOOffer();
		getRogersPlanConfigPage().selectBYODdpAddon();
		reporter.reportLogPassWithScreenshot("Device Protection Addon option is selected");
		getRogersPlanConfigPage().enterDPIMEI(TestDataHandler.tc05NACByodSS.getDpIMEI());
		reporter.reportLogPassWithScreenshot("DP Addon IMEI Entered");
		getRogersPlanConfigPage().setDPDeviceStorage(TestDataHandler.tc05NACByodSS.getDpDeviceStorage());
		reporter.reportLogPassWithScreenshot("DP Addon Device Storage Selected");
		getRogersPlanConfigPage().setDPDeviceColor(TestDataHandler.tc05NACByodSS.getDpDeviceColor());
		reporter.reportLogPassWithScreenshot("DP Addon Device Color Selected");
		getRogersPlanConfigPage().clkDpEligCheckBtn();
		reporter.hardAssert(getRogersPlanConfigPage().verifyEligibilityMsg(),"Entered IMEI is eligible for Device Protection Addon","Entered IMEI is not eligible");
		getRogersPlanConfigPage().clickPreCartSummaryContinueButtonAddOns();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on your addon's");
		getRogersPlanConfigPage().clickeSIMContinueButton();
		reporter.hardAssert(getRogersPlanConfigPage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
		String dpAddon = getRogersPlanConfigPage().getDeviceProtectionAddon();
		reporter.reportLogPassWithScreenshot("Device Protection - " +dpAddon);
		reporter.hardAssert(getRogersPlanConfigPage().verifyCartLineItem(),"Promo Code and Discount amount Line Item displayed","Promo code line item not displayed");
		getRogersPlanConfigPage().clickCartSummaryContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on proceed to checkout");
		//############################CheckoutPage############################//
		//***************Create Profile Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().verifyCreateProfileTitle(),"Create profile Title Present","Create profile Title not present");
		String emailCreateProfile=getRogersCheckoutPage().setEmailCreateProfile();
		getRogersCheckoutPage().confirmEmailCreateProfile(emailCreateProfile);
		String firstName = getRogersCheckoutPage().setFirstNameCreateProfile();
		String lastName = getRogersCheckoutPage().setLastNameCreateProfile();
		String fullNameCreateProfile=firstName+" "+lastName;
		String contactNumberCreateProfile=TestDataHandler.tc05NACByodSS.getContactNumber();
		getRogersCheckoutPage().setContactNumberCreateProfile(contactNumberCreateProfile);
		reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
		getRogersCheckoutPage().setBillingAddressCreateProfile(TestDataHandler.tc05NACByodSS.getBillingAddress());
		reporter.reportLogPassWithScreenshot("Create Profile Page details provided for email , name and Address");
		getRogersCheckoutPage().switchToRecaptchaIFrame();
		getRogersCheckoutPage().clkImNotRombotCheckbox();
		reporter.reportLogPassWithScreenshot("I'm not Robot CheckedRogersCheckoutPage");
		getRogersCheckoutPage().switchOutOfGoogleIFrame();
		getRogersCheckoutPage().clkBtnGotoCreditEvalStepper();
		//***************Credit Evaluation Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
		getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc05NACByodSS.getDateOfBirthYear());
		getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc05NACByodSS.getDateOfBirthMonth());
		getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.tc05NACByodSS.getDateOfBirthDay());
		getRogersCheckoutPage().switchToCreditCardIFrame();
		getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc05NACByodSS.getCreditCardDetails());
		reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
		getRogersCheckoutPage().switchOutOfCreditCardIFrame();
		getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc05NACByodSS.getExpiryDate());
		getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc05NACByodSS.getDropdownOption());
		getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc05NACByodSS.getPassportNumber());
		reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
		getRogersCheckoutPage().clkCreditAuthorizationChkBox();
		getRogersCheckoutPage().clkCreditEvalContinue();
		reporter.softAssert(getRogersCheckoutPage().isCreditEvalPopupPresent(),"Credit Evaluation Popup Displayed", "Credit Evaluation popup not disaplayed");
		//reporter.softAssert(getRogersCheckoutPage().isCreditEvalTextOnModalPresent(), "Credit Evaluation Text Displayed","Credit Evaluation Text not disaplayed on Modal");
		reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
		reporter.hardAssert(getRogersCheckoutPage().isIdentificationLabel(),"Credit Evaluation Successful", "Credit Evaluation Identification Label not disaplayed");
		// ***************Choose a Number Stepper*************//      
		reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed","Choose a Number Title not disaplayed");
		reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(),"Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
		getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc05NACByodSS.getCityName());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully" );
		getRogersCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		//reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed","Find More Available Number Button not disaplayed");
		getRogersCheckoutPage().clkChooseNumberbutton();
		//reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(),"Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
		reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
		reporter.reportLogPassWithScreenshot("POM DisQualification Modal Displayed");
		reporter.hardAssert(getRogersCheckoutPage().verifyAgeDisQualifierMsg(),"Age DisQualifier Messages is displayed","Age DisQualifier Messages is not displayed");
		reporter.hardAssert(getRogersCheckoutPage().verifyLocationDisQualifierMsg(),"Location DisQualifier Messages is displayed","Location DisQualifier Messages is not displayed");
		getRogersCheckoutPage().clkContinueWithoutPromo();
		getRogersCheckoutPage().clkContinueAfterFirstNameLastName();
		// ***************Billing & Payment Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isBillingOptionsTitleDisplayed(),"Billing Options Title Displayed","Billing Options Title Not Present");
		reporter.softAssert(getRogersCheckoutPage().verifyPromoRemovedFrmCart(),"PromoCode removed from Cart","PromoCode not removed from Cart");
		reporter.softAssert(getRogersCheckoutPage().isPaymentMethodDropdownPresent(), "Select Payment Method Dropdown Displayed","Select Payment Method Dropdown not disaplayed");
		//getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc05NACByodSS.getPaymentMethod());
		//getRogersCheckoutPage().clkBillingContinueButton();
		getRogersCheckoutPage().clickSkipAutopay();
		//***************Shipping Options Stepper*************//
		//reporter.softAssert(getRogersCheckoutPage().clkBillingAddress(),"Billing Address radio button is selected ","Billing Address is not selected");
		getRogersCheckoutPage().clkDeliveryMethodStandard();
		reporter.reportLogPassWithScreenshot("Billing Options Stepper");
		getRogersCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPassWithScreenshot("Continue button clicked from Billing Options Stepper");
		getRogersCheckoutPage().clksaveAndContinueBtnCheckoutPage();
		getRogersCheckoutPage().clksubmitBtnCheckoutPage();
		//***************Order Review Page*************//
		reporter.softAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(),"Order Review Page Title Present","Order Review Page Title is not Present");
		reporter.reportLogPass("Order Review Page");
		reporter.hardAssert(getRogersReviewOrderPage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
		String deviceProtectionAddon = getRogersReviewOrderPage().getDeviceProtectionAddon();
		getReporter().reportLogPassWithScreenshot("Device Protection - " +deviceProtectionAddon);
//		String contactNameReviewPage=getRogersReviewOrderPage().getContactName();
//		reporter.hardAssert(fullNameCreateProfile.equals(contactNameReviewPage),"Contact Name in Order Review Page matches as entered in Create Profile stepper","Contact Name in Order Review Page not matches as entered in Create Profile stepper");
//		String contactEmailReviewPage=getRogersReviewOrderPage().getContactEmail();
//		reporter.hardAssert(emailCreateProfile.equals(contactEmailReviewPage),"Contact email in Order Review Page matches as entered in Create Profile stepper","Contact email in Order Review Page not matches as entered in Create Profile stepper");
		reporter.reportLogPassWithScreenshot("Order Review Page : Contact Details");
		getRogersReviewOrderPage().clkAgreementConsentCheckbox();
		//getRogersReviewOrderPage().clkEmailConsentCheckbox();
		reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
		getRogersReviewOrderPage().clkSubmitOrderBtn();
		//************Order Confirmation Page****************//
		reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),"Order Confrimation Page Title Present","Order Confrimation Page Title is not Present");
		reporter.reportLogPassWithScreenshot("Order Confirmation Page");
		String purchaseIncludesConfrimation=getRogersNACOrderConfirmationPage().getPurchaseIncludesText();
		reporter.reportLogPassWithScreenshot("Purchase includes captured as" + "-->" +purchaseIncludesConfrimation);
	}

}
