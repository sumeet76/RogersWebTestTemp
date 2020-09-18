package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class RogersBFA_TC11_NAC_BYOD_Test extends BaseTestClass {

	@BeforeMethod (alwaysRun = true) @Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.redesignrogers, method);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest () throws InterruptedException {
		closeSession();
	}

	@Test(groups = {"RegressionBFA","NACBFA"})
	public void nacByodFlow() throws InterruptedException {
		//############################Plan config page###############################
		reporter.hardAssert(rogers_plan_config_page.verifyBreadCrumb(), "BreadCrumb on Plan config page is displaying fine","BreadCrumb is not displaying fine");
		rogers_plan_config_page.clickPreCartSummaryContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page data option selected");
		rogers_plan_config_page.clickPreCartSummaryContinueButtonTalkOptions();
		reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		rogers_plan_config_page.clickPreCartSummaryContinueButtonAddOns();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on your addon's");
		rogers_plan_config_page.clickGetBPOOffer();
		rogers_plan_config_page.clickCartSummaryContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on proceed to checkout");
		//############################CheckoutPage############################//
		//***************Create Profile Stepper*************//
		reporter.softAssert(rogers_checkout_page.verifyCreateProfileTitle(),"Create profile Title Present","Create profile Title not present");
		String emailCreateProfile=rogers_checkout_page.setEmailCreateProfile();
		rogers_checkout_page.confirmEmailCreateProfile(emailCreateProfile);
		String firstName = rogers_checkout_page.setFirstNameCreateProfile();
		String lastName = rogers_checkout_page.setLastNameCreateProfile();
		//*************** AVS Data Code- Commented for future issue ******//
		//	        String firstName = rogers_checkout_page.setFirstNameCreateProfilepage("AMARA");
		//	        String lastName = rogers_checkout_page.setLastNameCreateProfilepage("SPEARS");
		String fullNameCreateProfile=firstName+" "+lastName;
		String contactNumberCreateProfile=TestDataHandler.testCase11.getContactNumber();
		rogers_checkout_page.setContactNumberCreateProfile(contactNumberCreateProfile);
		reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
		rogers_checkout_page.setBillingAddressCreateProfile(TestDataHandler.testCase11.getBillingAddress());
		reporter.reportLogPassWithScreenshot("Create Profile Page details provided for email , name and Address");
		rogers_checkout_page.switchToRecaptchaIFrame();
		rogers_checkout_page.clkImNotRombotCheckbox();
		reporter.reportLogPassWithScreenshot("I'm not Robot Checked");
		rogers_checkout_page.switchOutOfGoogleIFrame();
		rogers_checkout_page.clkBtnGotoCreditEvalStepper();
		//***************Credit Evaluation Stepper*************//
		reporter.softAssert(rogers_checkout_page.verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
		//rogers_checkout_page.setDateOfBirth(TestDataHandler.redesignRpotgData.getDateOfBirth());
		rogers_checkout_page.selectYearDropdownOption(TestDataHandler.testCase11.getDateOfBirthYear());
		//span[text()='No, thanks']
		//rogers_checkout_page.clkNoThanks();
		rogers_checkout_page.selectMonthDropdownOption(TestDataHandler.testCase11.getDateOfBirthMonth());
		rogers_checkout_page.selectDayDropdownOption(TestDataHandler.testCase11.getDateOfBirthDay());
		rogers_checkout_page.switchToCreditCardIFrame();
		rogers_checkout_page.setCreditCardNumberIFrame(TestDataHandler.testCase11.getCreditCardDetails());
		reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
		rogers_checkout_page.switchOutOfCreditCardIFrame();
		rogers_checkout_page.setExpiryDate(TestDataHandler.testCase11.getExpiryDate());
		rogers_checkout_page.selectDropdownOption(TestDataHandler.testCase11.getDropdownOption());
		rogers_checkout_page.setPassportNumber(TestDataHandler.testCase11.getPassportNumber());
		reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
		rogers_checkout_page.clkCreditAuthorizationChkBox();
		rogers_checkout_page.clkCreditEvalContinue();
		reporter.softAssert(rogers_checkout_page.isCreditEvalPopupPresent(),"Credit Evaluation Popup Displayed", "Credit Evaluation popup not disaplayed");
		reporter.softAssert(rogers_checkout_page.isCreditEvalTextOnModalPresent(), "Credit Evaluation Text Displayed","Credit Evaluation Text not disaplayed on Modal");
		reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
		reporter.hardAssert(rogers_checkout_page.isIdentificationLabel(),"Credit Evaluation Successful", "Credit Evaluation Identification Label not disaplayed");
		// ***************Choose a Number Stepper*************//      
		reporter.softAssert(rogers_checkout_page.isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed","Choose a Number Title not disaplayed");
		reporter.softAssert(rogers_checkout_page.isChooseNumberTabsDisplayed(),"Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
		rogers_checkout_page.selectCityDropdownOption(TestDataHandler.testCase11.getCityName());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully" );
		rogers_checkout_page.clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		reporter.softAssert(rogers_checkout_page.isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed","Find More Available Number Button not disaplayed");
		rogers_checkout_page.clkChooseNumberbutton();
		reporter.hardAssert(rogers_checkout_page.isChooseaNumberLabelDisplayed(),"Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
		reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
		// ***************Billing & Payment Stepper*************//
		reporter.softAssert(rogers_checkout_page.isBillingOptionsTitleDisplayed(),"Billing Options Title Displayed","Billing Options Title Not Present");
		reporter.softAssert(rogers_checkout_page.isPaymentMethodDropdownPresent(), "Select Payment Method Dropdown Displayed","Select Payment Method Dropdown not disaplayed");
		rogers_checkout_page.clkNoThanks();
		rogers_checkout_page.setNameOnCard(TestDataHandler.testCase11.getNameOnCard());
		rogers_checkout_page.switchToCreditCardIFrame();
		rogers_checkout_page.setCreditCardNumberIFrame(TestDataHandler.testCase11.getBillingCreditCardNumber());
		rogers_checkout_page.switchOutOfCreditCardIFrame();
		rogers_checkout_page.setBillingExpiryDate(TestDataHandler.testCase11.getExpiryDate());
		rogers_checkout_page.setCVVNumber(TestDataHandler.testCase11.getCvvNumber());
		reporter.reportLogPassWithScreenshot("Billing & Payment Details Entered Successfully");
		rogers_checkout_page.clkAddCard();       
		rogers_checkout_page.clkBillingContinueButton();
		reporter.hardAssert(rogers_checkout_page.isCardDetailsDisplayed(),"Card details disaplayed in Billing & Payment Options", "Card details not disaplayed in Billing & Payment Options");
		//***************Billing Options Stepper*************//
		reporter.softAssert(rogers_checkout_page.clkBillingAddress(),"Billing Address radio button is selected ","Billing Address is not selected");
		rogers_checkout_page.clkDeliveryMethodStandard();
		reporter.reportLogPassWithScreenshot("Billing Options Stepper");
		Thread.sleep(1000);
		rogers_checkout_page.clkContinueBtnShipping();
		reporter.reportLogPassWithScreenshot("Continue button clicked from Billing Options Stepper");
		rogers_checkout_page.clksubmitBtnCheckoutPage();
		//***************Order Review Page*************//
		reporter.softAssert(rogers_review_order_page.isOrderReviewPageTitlePresent(),"Order Review Page Title Present","Order Review Page Title is not Present");
		reporter.reportLogPass("Order Review Page");
		String contactNameReviewPage=rogers_review_order_page.getContactName();
		reporter.hardAssert(fullNameCreateProfile.equals(contactNameReviewPage),"Contact Name in Order Review Page matches as entered in Create Profile stepper","Contact Name in Order Review Page not matches as entered in Create Profile stepper");
		String contactEmailReviewPage=rogers_review_order_page.getContactEmail();
		reporter.hardAssert(emailCreateProfile.equals(contactEmailReviewPage),"Contact email in Order Review Page matches as entered in Create Profile stepper","Contact email in Order Review Page not matches as entered in Create Profile stepper");
		reporter.reportLogPassWithScreenshot("Order Review Page : Contact Details");
		rogers_review_order_page.clkFinancingConsentCheckbox();
		rogers_review_order_page.clkAgreementConsentCheckbox();
		rogers_review_order_page.clkUpfrontConsentCheckbox();
		reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
		rogers_review_order_page.clkSubmitOrderBtn();
		//************Order Confirmation Page****************//
		reporter.hardAssert(rogers_NAC_order_confirmation_page.isOrderConfirmationTitlePresent(),"Order Confrimation Page Title Present","Order Confrimation Page Title is not Present");
		reporter.reportLogPassWithScreenshot("Order Confirmation Page");
		String purchaseIncludesConfrimation=rogers_NAC_order_confirmation_page.getPurchaseIncludesText();
		reporter.reportLogPassWithScreenshot("Purchase includes captured as" + "-->" +purchaseIncludesConfrimation);
		reporter.hardAssert(rogers_NAC_order_confirmation_page.isLearnMoreLinkDisplayed(),"Learn More Link Displayed","Learn More Link not Present");
		reporter.reportLogPassWithScreenshot("Order Review Page: LearnMore Link");

	}

}
