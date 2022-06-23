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
 * TC06 - Regression - [RNAC BYOD] - Perform Rogers Net New Activation - BYOD with Express Pickup Shipping - BOPIS_E2E
 */
public class RogersBFA_TC06_Consumer_NAC_BYOD_BopisTest extends BaseTestClass {
	String deviceName;

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

	//https://rcom5.qa01.eks.rogers.com/phones/bring-your-own-device?flowType=byod
	@Test(groups = {"RegressionBFA","NACBFA"})
	public void tc06rogersNACBYODBopisTest() throws InterruptedException {
//############################Plan config page###############################
		getDriver().get(System.getProperty("AWSUrl")+"/bring-your-own-device?flowType=byod");
		reporter.hardAssert(getRogersPlanConfigPage().verifyBreadCrumb(), "BreadCrumb on Plan config page is displaying fine","BreadCrumb is not displaying fine");
		getRogersPlanConfigPage().clickShowMoreDetails();
		getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc06NACByodTermBopis.getDataOptionIndex()),this.getClass().getSimpleName());
		//reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		//getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page data option selected");
		getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		getRogersPlanConfigPage().clickGetBPOOffer();
		getRogersPlanConfigPage().selectBYODdpAddon();
		reporter.reportLogPassWithScreenshot("Device Protection Addon option is selected");
		getRogersPlanConfigPage().enterDPIMEI(TestDataHandler.tc06NACByodTermBopis.getDpIMEI());
		reporter.reportLogPassWithScreenshot("DP Addon IMEI Entered");
		getRogersPlanConfigPage().setDPDeviceStorage(TestDataHandler.tc06NACByodTermBopis.getDpDeviceStorage());
		reporter.reportLogPassWithScreenshot("DP Addon Device Storage Selected");
		getRogersPlanConfigPage().setDPDeviceColor(TestDataHandler.tc06NACByodTermBopis.getDpDeviceColor());
		reporter.reportLogPassWithScreenshot("DP Addon Device Color Selected");
		getRogersPlanConfigPage().clkDpEligCheckBtn();
		reporter.hardAssert(getRogersPlanConfigPage().verifyEligibilityMsg(),"Entered IMEI is eligible for Device Protection Addon","Entered IMEI is not eligible");
		getRogersPlanConfigPage().selectNoDeviceProtection();
		reporter.reportLogPassWithScreenshot("No Device Protection option selected after checking the eligibility(success)");
		getRogersPlanConfigPage().clickPreCartSummaryContinueButtonAddOns();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on your addon's");
		getRogersPlanConfigPage().clickCartSummaryContinueButton();
		reporter.reportLogPassWithScreenshot("Device Protection Pop-up is not displayed and Proceed to checkout clicked");
		//############################CheckoutPage############################//
		//***************Create Profile Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().verifyCreateProfileTitle(),"Create profile Title Present","Create profile Title not present");
		String emailCreateProfile=getRogersCheckoutPage().setEmailCreateProfile();
		getRogersCheckoutPage().confirmEmailCreateProfile(emailCreateProfile);
		String firstName = getRogersCheckoutPage().setFirstNameCreateProfile();
		String lastName = getRogersCheckoutPage().setLastNameCreateProfile();
		String fullNameCreateProfile=firstName+" "+lastName;
		String contactNumberCreateProfile=TestDataHandler.tc06NACByodTermBopis.getContactNumber();
		getRogersCheckoutPage().setContactNumberCreateProfile(contactNumberCreateProfile);
		reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
		getRogersCheckoutPage().setBillingAddressCreateProfile(TestDataHandler.tc06NACByodTermBopis.getBillingAddress());
		reporter.reportLogPassWithScreenshot("Create Profile Page details provided for email , name and Address");
		getRogersCheckoutPage().switchToRecaptchaIFrame();
		getRogersCheckoutPage().clkImNotRombotCheckbox();
		reporter.reportLogPassWithScreenshot("I'm not Robot CheckedRogersCheckoutPage");
		getRogersCheckoutPage().switchOutOfGoogleIFrame();
		getRogersCheckoutPage().clkBtnGotoCreditEvalStepper();
		//***************Credit Evaluation Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
		getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc06NACByodTermBopis.getDateOfBirthYear());
		getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc06NACByodTermBopis.getDateOfBirthMonth());
		getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.tc06NACByodTermBopis.getDateOfBirthDay());
		getRogersCheckoutPage().switchToCreditCardIFrame();
		getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc06NACByodTermBopis.getCreditCardDetails());
		reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
		getRogersCheckoutPage().switchOutOfCreditCardIFrame();
		getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc06NACByodTermBopis.getExpiryDate());
		getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc06NACByodTermBopis.getDropdownOption());
		getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc06NACByodTermBopis.getPassportNumber());
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
		getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc06NACByodTermBopis.getCityName());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully" );
		getRogersCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed","Find More Available Number Button not disaplayed");
		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().clkChooseNumberbutton();
		reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(),"Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
		reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
		// ***************Billing & Payment Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isBillingOptionsTitleDisplayed(),"Billing Options Title Displayed","Billing Options Title Not Present");
		reporter.softAssert(getRogersCheckoutPage().isPaymentMethodDropdownPresent(), "Select Payment Method Dropdown Displayed","Select Payment Method Dropdown not disaplayed");
		getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc06NACByodTermBopis.getPaymentMethod());
		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().clkBillingContinueButton();
		//***************Shipping Options Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().clkBillingAddress(),"Billing Address radio button is selected ","Billing Address is not selected");
		getRogersCheckoutPage().clkDeliveryMethod("EXPRESS");
		reporter.reportLogPass("Express Delivery selected");
		reporter.hardAssert(getRogersCheckoutPage().verifyExpressLocationMapPresent() ,"Express location map available", "Express location map not available");
		getRogersCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPass("Clicked continue button in shipping stepper");
		getRogersCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPass("Clicked submit button below cart summary");
		//***************Order Review Page*************//
		reporter.softAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(),"Order Review Page Title Present","Order Review Page Title is not Present");
		reporter.reportLogPass("Order Review Page");
		String contactNameReviewPage=getRogersReviewOrderPage().getContactName();
		reporter.hardAssert(fullNameCreateProfile.equals(contactNameReviewPage),"Contact Name in Order Review Page matches as entered in Create Profile stepper","Contact Name in Order Review Page not matches as entered in Create Profile stepper");
		String contactEmailReviewPage=getRogersReviewOrderPage().getContactEmail();
		reporter.hardAssert(emailCreateProfile.equals(contactEmailReviewPage),"Contact email in Order Review Page matches as entered in Create Profile stepper","Contact email in Order Review Page not matches as entered in Create Profile stepper");
		reporter.reportLogPassWithScreenshot("Order Review Page : Contact Details");
		getRogersReviewOrderPage().clkAgreementConsentCheckbox();
		getRogersReviewOrderPage().clkBopisConsentCheckbox();
		reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
		getRogersReviewOrderPage().clkSubmitOrderBtn();
		//************Order Confirmation Page****************//
		reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),"Order Confrimation Page Title Present","Order Confrimation Page Title is not Present");
		reporter.reportLogPassWithScreenshot("Order Confirmation Page");
		String purchaseIncludesConfrimation=getRogersNACOrderConfirmationPage().getPurchaseIncludesText();
		reporter.reportLogPassWithScreenshot("Purchase includes captured as" + "-->" +purchaseIncludesConfrimation);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
