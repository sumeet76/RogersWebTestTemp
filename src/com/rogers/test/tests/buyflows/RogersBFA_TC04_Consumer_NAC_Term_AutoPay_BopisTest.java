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
 * TC04 - Regression - [RNAC TERM] - Perform Rogers Net New Activation - TERM with Express Pickup Shipping(Finance Plan) - BOPIS_E2E
 */

public class RogersBFA_TC04_Consumer_NAC_Term_AutoPay_BopisTest extends BaseTestClass {
	String deviceName;

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

	@Test(groups = {"RegressionBFA","NACBFA","SanityNACBFA"})
	public void tc04_rogersNACTermBopisTest() throws InterruptedException {

		// **************************Device catalog page*****************************************
		//getRogersDeviceCataloguePage().setProvince("Ontario");
		reporter.hardAssert(getRogersDeviceCataloguePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
		String deviceName = TestDataHandler.tc04NACTermBopis.getDeviceName();
		getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
		reporter.softAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen",
				"Modal element is not present on the screen");
		reporter.softAssert(getRogersDeviceCataloguePage().verifyGetStartedButtonOnModal(),
				"Get started button on the modal is present", "Get started button on the modal is not present");
		reporter.reportLogWithScreenshot("Modal window Popup");
		reporter.hardAssert(getRogersDeviceCataloguePage().clickGetStartedButtonOnModalRPP(),"Clicked Get Started Button","Get Started button not able to click");
		// ***************************Device config page************************************
		reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
				"Continue button on the device config page is present",
				"Continue button on the device config page is not present");
		reporter.reportLogPassWithScreenshot("Device config page displayed");
		getRogersDeviceConfigPage().clickContinueButton();
		// ****************************Plan config page***************************************
		reporter.hardAssert(getRogersPlanConfigPage().verifyPlanConfigPage(),"Build plan page is loaded successfully","Build plan page is not loaded");
		getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		getRogersPlanConfigPage().clickShowMoreDetails();
		reporter.hardAssert(getRogersPlanConfigPage().verifyAutoPayPlanSelection(getRogersPlanConfigPage().getAutoPayPlanIndex("MSF"),this.getClass().getSimpleName()),
				"Autopay plan is selected successfully","Autopay plan is not selected");
		reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
		getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
		getRogersPlanConfigPage().clkContinueDeviceProtection();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
		reporter.hardAssert(getRogersPlanConfigPage().verifyAutoPayDiscountInCartSummary(),"AutoPay discount is added in cart summary","AutoPay is not added in cart summary");
		getRogersPlanConfigPage().clickCartSummaryContinueButton();

		// ***************Create Profile Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().verifyCreateProfileTitle(), "Create profile Title Present",
				"Create profile Title not present");
		String emailCreateProfile = getRogersCheckoutPage().setEmailCreateProfile();
		getRogersCheckoutPage().confirmEmailCreateProfile(emailCreateProfile);
        String firstName = getRogersCheckoutPage().setFirstNameCreateProfile();
        String lastName = getRogersCheckoutPage().setLastNameCreateProfile();
		String fullNameCreateProfile = firstName + " " + lastName;
		String contactNumberCreateProfile = TestDataHandler.tc04NACTermBopis.getContactNumber();
		getRogersCheckoutPage().setContactNumberCreateProfile(contactNumberCreateProfile);
		reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
		String billingAddressCreateProfile = TestDataHandler.tc04NACTermBopis.getBillingAddress();
		getRogersCheckoutPage().setBillingAddressCreateProfile(billingAddressCreateProfile);
		getRogersCheckoutPage().clkLanguageEnglishRadioBtnCreateProfile();
		reporter.reportLogPassWithScreenshot(
				"Create Profile Page details provided for Address,Shipping Address & Language Selected");
		getRogersCheckoutPage().switchToRecaptchaIFrame();
		getRogersCheckoutPage().clkImNotRombotCheckbox();
		reporter.reportLogPassWithScreenshot("I'm not Robot Checked");
		getRogersCheckoutPage().switchOutOfGoogleIFrame();
		getRogersCheckoutPage().clkBtnGotoCreditEvalStepper();

		// ***************Credit Evaluation Stepper***********//
		reporter.softAssert(getRogersCheckoutPage().verifyCreditEvaluationTitle(), "CreditEvaluation Title verified",
				"CreditEvaluation Title not present");
		getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc04NACTermBopis.getDateOfBirthYear());
		getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc04NACTermBopis.getDateOfBirthMonth());
		getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.tc04NACTermBopis.getDateOfBirthDay());
		getRogersCheckoutPage().switchToCreditCardIFrame();
		getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc04NACTermBopis.getCreditCardDetails());
		reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
		getRogersCheckoutPage().switchOutOfCreditCardIFrame();
		getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc04NACTermBopis.getExpiryDate());
		getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc04NACTermBopis.getDropdownOption());
		getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc04NACTermBopis.getPassportNumber());
		reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
		getRogersCheckoutPage().clkCreditAuthorizationChkBox();
		getRogersCheckoutPage().clkCreditEvalContinue();
		reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
		// ***************Choose a Number Stepper*************//
		getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc04NACTermBopis.getCityName());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
		getRogersCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		getRogersCheckoutPage().clkChooseNumberbutton();
		// ***************Billing & Payment Stepper*************//
		reporter.hardAssert(getRogersCheckoutPage().verifyAutoPaymentPage(),"Autopay payment page is displayed","Autopay payment page is not displayed");
		getRogersCheckoutPage().enterBankDetails();
		getRogersCheckoutPage().clkAutoPayConsentCheckBox();
		getRogersCheckoutPage().clkBillingContinueButton();
		// ***************Shipping Stepper*************//
		//String addressShippingStepper = getRogersCheckoutPage().getShippingAddress();
		//System.out.println(billingAddressCreateProfile+"and"+addressShippingStepper);
		getRogersCheckoutPage().clkDeliveryMethod("STANDARD");
//		reporter.reportLogPass("Express Delivery selected");
//		reporter.hardAssert(getRogersCheckoutPage().verifyExpressLocationMapPresent() ,"Express location map available", "Express location map not available");
		getRogersCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPass("Clicked continue button in shipping stepper");
		getRogersCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPass("Clicked submit button below cart summary");
		// ***************Order Review Page****************************************************
		reporter.softAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
				"Order Review Page Title is not Present");
		reporter.reportLogPass("Order Review Page");
		String totalMonthlyFeesReviewPage = getRogersReviewOrderPage().getMonthlyFeeAfterTax();
		String contactNameReviewPage = getRogersReviewOrderPage().getContactName();
		reporter.hardAssert(fullNameCreateProfile.equals(contactNameReviewPage),
				"Contact Name in Order Review Page matches as entered in Create Profile stepper",
				"Contact Name in Order Review Page not matches as entered in Create Profile stepper");
		String contactNumberReviewPage = getRogersReviewOrderPage().getContactNumber();
		reporter.softAssert(contactNumberCreateProfile.equals(contactNumberReviewPage), "Contact Number Matched",
				"Contact Number not matching");
		String contactEmailReviewPage = getRogersReviewOrderPage().getContactEmail();
		reporter.hardAssert(emailCreateProfile.equals(contactEmailReviewPage),
				"Contact email in Order Review Page matches as entered in Create Profile stepper",
				"Contact email in Order Review Page not matches as entered in Create Profile stepper");
		reporter.reportLogPassWithScreenshot("Order Review Page : Contact Details");
		getRogersReviewOrderPage().clkFinancingConsentCheckbox();
		getRogersReviewOrderPage().clkAgreementConsentCheckbox();
		getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
		reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
//		getRogersReviewOrderPage().clkBopisConsentCheckbox();
		reporter.reportLogPass("Email Communication consent box checked");
		getRogersReviewOrderPage().clkSubmitOrderBtn();

		// ************Order Confirmation Page***************************************************

		reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),
				"Order Confrimation Page Title Present", "Order Confrimation Page Title is not Present");
		reporter.reportLogPassWithScreenshot("Order Confirmation Page");
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
