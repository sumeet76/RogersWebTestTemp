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
public class RogersBFA_TC06_NAC_BYOD_BopisTest extends BaseTestClass {
	String deviceName;

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("AWSBYODUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

	//https://rcom5.qa01.eks.rogers.com/phones/bring-your-own-device?flowType=byod
	@Test(groups = {"RegressionBFA","SanityBFA","NACBFA"})
	public void rogersNACBYODBopisTest() throws InterruptedException {
		// ****************************Plan config page***************************************
		reporter.hardAssert(getRogersPlanConfigPage().verifyBreadCrumb(), "BreadCrumb on Plan config page is displaying fine","BreadCrumb is not displaying fine");
		getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page data option selected");
		getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		getRogersPlanConfigPage().clickGetBPOOffer();
		getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
		String monthlyFeesAmount = getRogersPlanConfigPage().getMonthlyFeesAmount();
		String oneTimeFeesAmount = getRogersPlanConfigPage().getOneTimeFeesAmount();
		reporter.reportLogPassWithScreenshot(
				"Cart summary: Monthly & OneTimeFees" + monthlyFeesAmount + "&" + oneTimeFeesAmount);
		getRogersPlanConfigPage().clickCartSummaryContinueButton();

		// *****************************CheckoutPage*****************************************
		String totalMonthlyFees = getRogersCheckoutPage().getMonthlyFeeAfterTax();
		String oneTimeFee = getRogersCheckoutPage().getOneTimeFeeAfterTax();
		String purchaseIncludes = getRogersCheckoutPage().getPurchaseIncludesText();
		reporter.reportLog("Checkout page Cart Summary Info" + "1. Total Monthly Fees" + totalMonthlyFees
				+ "2. oneTimeFee" + oneTimeFee + "3. Purchase Include" + purchaseIncludes);
		String labelRpotgPurchaseIncludesCheckout = getRogersCheckoutPage().getRpotgLabelPurchaseIncludes();
		reporter.softAssert(purchaseIncludes.contains(labelRpotgPurchaseIncludesCheckout),
				"RPOTG label verified in Purchase Includes section",
				"RPOTG label not availble in Purchase Includes section");
		// ***************Create Profile Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().verifyCreateProfileTitle(), "Create profile Title Present",
				"Create profile Title not present");
		String emailCreateProfile = getRogersCheckoutPage().setEmailCreateProfile();
		getRogersCheckoutPage().confirmEmailCreateProfile(emailCreateProfile);
		String firstName = getRogersCheckoutPage().setFirstNameCreateProfile();
		String lastName = getRogersCheckoutPage().setLastNameCreateProfile();
//		String firstName = rogers_checkout_page.setFirstNameCreateProfilepage("smisamvulamani");
//		String lastName = rogers_checkout_page.setLastNameCreateProfilepage("marichale");
		String fullNameCreateProfile = firstName + " " + lastName;
		String contactNumberCreateProfile = TestDataHandler.tc06NACByodTermBopis.getContactNumber();
		getRogersCheckoutPage().setContactNumberCreateProfile(contactNumberCreateProfile);
		reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
		String billingAddressCreateProfile = TestDataHandler.tc06NACByodTermBopis.getBillingAddress();
		getRogersCheckoutPage().setBillingAddressCreateProfile(billingAddressCreateProfile);
		//rogers_checkout_page.getRpotgSuccessMessage();
		reporter.reportLogPassWithScreenshot(
				"Billing Address entered is eligible for RPOTG - Success message validated");
		//rogers_checkout_page.clkUseBillingAddressRadioBtnCreateProfile();
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
		// rogers_checkout_page.setDateOfBirth(TestDataHandler.redesignRpotgData.getDateOfBirth());
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
//		reporter.softAssert(rogers_checkout_page.isCreditEvalPopupPresent(), "Credit Evaluation Popup Displayed",
//				"Credit Evaluation popup not disaplayed");
//		reporter.softAssert(rogers_checkout_page.isCreditEvalTextOnModalPresent(), "Credit Evaluation Text Displayed",
//				"Credit Evaluation Text not disaplayed on Modal");
		reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
		reporter.hardAssert(getRogersCheckoutPage().isIdentificationLabel(), "Credit Evaluation Successful",
				"Credit Evaluation Identification Label not disaplayed");

		// ***************Choose a Number Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed",
				"Choose a Number Title not disaplayed");
		reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(),
				"Select a New Number/Use Existing Number Tab Displayed",
				"Select a New Number/Use Existing Number Tab not disaplayed");
		getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc06NACByodTermBopis.getCityName());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
		getRogersCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(),
				"Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
		getRogersCheckoutPage().clkChooseNumberbutton();

		// ***************Billing & Payment Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isBillingOptionsTitleDisplayed(), "Billing Options Title Displayed",
				"Billing Options Title Not Present");
		reporter.softAssert(getRogersCheckoutPage().isPaymentMethodDropdownPresent(),
				"Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not disaplayed");
		getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc06NACByodTermBopis.getPaymentMethod());
//		rogers_checkout_page.setNameOnCard(TestDataHandler.redesignRpotgData.getNameOnCard());
//		rogers_checkout_page.switchToCreditCardIFrame();
//		rogers_checkout_page.setCreditCardNumberIFrame(TestDataHandler.redesignRpotgData.getBillingCreditCardNumber());
//		rogers_checkout_page.switchOutOfCreditCardIFrame();
//		rogers_checkout_page.setBillingExpiryDate(TestDataHandler.redesignRpotgData.getExpiryDate());
//		rogers_checkout_page.setCVVNumber(TestDataHandler.redesignRpotgData.getCvvNumber());
//		reporter.reportLogPassWithScreenshot("Billing & Payment Details Entered Successfully");
//		rogers_checkout_page.clkAddCard();
		getRogersCheckoutPage().clkBillingContinueButton();
//		reporter.hardAssert(rogers_checkout_page.isCardDetailsDisplayed(),
//				"Card details disaplayed in Billing & Payment Options",
//				"Card details not disaplayed in Billing & Payment Options");
		// ***************Shipping Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
				"Billing Address is not selected");
		String addressShippingStepper = getRogersCheckoutPage().getShippingAddress();
		System.out.println(billingAddressCreateProfile+"and"+addressShippingStepper);
		reporter.softAssert(billingAddressCreateProfile.equals(addressShippingStepper),
				"Address in Shipping Stepper matches as entered in Create Profile stepper",
				"Address in Shipping Stepper not matches as entered in Create Profile stepper");
		getRogersCheckoutPage().clkDeliveryMethod("EXPRESS");
		reporter.reportLogPass("Express Delivery selected");
		reporter.hardAssert(getRogersCheckoutPage().verifyExpressLocationMapPresent() ,"Express location map available", "Express location map not available");
		getRogersCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPass("Clicked continue button in shipping stepper");
		getRogersCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPass("Clicked submit button below cart summary");
		// ***************Order Review Page****************************************************
		reporter.softAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
				"Order Review Page Title is not Present");
		reporter.reportLogPass("Order Review Page");
		String totalMonthlyFeesReviewPage = getRogersReviewOrderPage().getMonthlyFeeAfterTax();
		reporter.hardAssert(totalMonthlyFees.equals(totalMonthlyFeesReviewPage),
				"Total Monthly Fee after tax matches with checkout page",
				"Total Monthly Fee after tax not matches with checkout page");
		String oneTimeFeesReviewPage = getRogersReviewOrderPage().getOneTimeFeeAfterTax();
		reporter.hardAssert(oneTimeFee.equals(oneTimeFeesReviewPage),
				"Total One time fee after tax matches with checkout page",
				"Total One time fee after tax not matches with checkout page");
		String puchaseIncludeReviewPage = getRogersReviewOrderPage().getPurchaseIncludesText();
		reporter.reportLogPassWithScreenshot("Order Review Page" + "1.Monthly Fees" + totalMonthlyFeesReviewPage
				+ "2. OnetimeFees:" + oneTimeFeesReviewPage + "3.Purchase Include :" + puchaseIncludeReviewPage);
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
		/*
		String shippingAddressReviewPage = rogers_review_order_page.getShippingAddressText();
		reporter.reportLogWithScreenshot("Shipping Address Details" + "-->" + shippingAddressReviewPage);
		reporter.softAssert(rogers_review_order_page.verifyDeliveryAddressTitle(), "Delivery Address Title verified",
				"Delivery Address Title Not Present");
		String deliveryDateReviewPage = rogers_review_order_page.getDeliveryDate();
		//reporter.softAssert(appointmentDate.equals(deliveryDateReviewPage),"Delivery Date in Order Review Page matches with Shipping Stepper Date","Delivery Date in Order Review Page not matches with Shipping Stepper Date");
		String deliveryTimeReviewPage = rogers_review_order_page.getDeliveryTime();
		//reporter.softAssert(appointmentTime.contains(deliveryTimeReviewPage),"Delivery Time in Order Review Page matches with Shipping Stepper Time","Delivery Time not available in Review page");
		 */
		getRogersReviewOrderPage().clkFinancingConsentCheckbox();
		getRogersReviewOrderPage().clkAgreementConsentCheckbox();
		getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
		reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
		getRogersReviewOrderPage().clkEmailConsentCheckbox();
		reporter.reportLogPass("Email Communication consent box checked");
		getRogersReviewOrderPage().clkSubmitOrderBtn();
		// ************Order Confirmation Page***************************************************

		reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),
				"Order Confrimation Page Title Present", "Order Confrimation Page Title is not Present");
		reporter.reportLogPassWithScreenshot("Order Confirmation Page");
		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyRpotgTitle(), "RPOTG Title verified",
				"RPOTG Title Not Present");
		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyAppointmentDetailsTitle(),
				"Appointment Details Title verified", "Your Appointment Details Title Not present");
		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyAppointmentDateTitle(),
				"Appointment Date Title Verified", "Appointment Date Title not Present");
		String appointmentDateCnfPage = getRogersNACOrderConfirmationPage().getAppointmentDate();
		//reporter.softAssert(appointmentDate.equals(appointmentDateCnfPage), "Appointment Date in Order Confirmation page matches with Shipping Stepper Date", "Appointment Date in Order Confirmation page not matches with Shipping Stepper Date");
		String appointmentTimeCnfPage = getRogersNACOrderConfirmationPage().getAppointmentTime();
		//reporter.hardAssert(appointmentTime.contains(appointmentTimeCnfPage), "Appointment Time in Order Confirmation page matches with Shipping Stepper Time", "Appointment Time not available in Confirmation page");
		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyAppointmentAddressTitle(),
				"Appointment Address Title Verified", "Appointment Address Title not present");
		String appointmentAddress = getRogersNACOrderConfirmationPage().getAppointmentAddressText();
		reporter.reportLogWithScreenshot("Appointment Address Details" + "-->" + appointmentAddress);
		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyDeviceImage(),
				"Device Image Present in Confirmation Page", "Device Image not present");
		String totalMonthlyFeesConfirmationPage = getRogersNACOrderConfirmationPage().getMonthlyFeeAfterTax();
		reporter.hardAssert(totalMonthlyFees.equals(totalMonthlyFeesConfirmationPage),
				"Total Monthly Fee after tax matches with checkout page",
				"Total Monthly Fee after tax not matches with checkout page");
		String oneTimeFeesConfirmationPage = getRogersNACOrderConfirmationPage().getOneTimeFeeAfterTax();
		reporter.hardAssert(oneTimeFee.equals(oneTimeFeesConfirmationPage),
				"Total One time fee after tax matches with checkout page",
				"Total One time fee after tax not matches with checkout page");
		String purchaseIncludesConfrimation = getRogersNACOrderConfirmationPage().getPurchaseIncludesText();
		reporter.hardAssert(purchaseIncludesConfrimation.equals(puchaseIncludeReviewPage),
				"Purchase includes Matches in ORder Confirmation page", "Purchase Includes Not Matching");
		reporter.reportLogPassWithScreenshot("Purchase includes captured as" + "-->" + purchaseIncludesConfrimation);
//		reporter.hardAssert(rogers_NAC_order_confirmation_page.isLearnMoreLinkDisplayed(), "Learn More Link Displayed",
//				"Learn More Link not Present");
//		reporter.reportLogPassWithScreenshot("Order Review Page: LearnMore Link");
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
