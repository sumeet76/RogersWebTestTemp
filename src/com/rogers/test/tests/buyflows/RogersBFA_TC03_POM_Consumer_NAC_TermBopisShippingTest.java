package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC03 - Regression - [RNAC TERM] - Perform Rogers Net New Activation - TERM with POTG Shipping(Finance plan with POTG)_E2E
 */

public class RogersBFA_TC03_POM_Consumer_NAC_TermBopisShippingTest extends BaseTestClass {
	String deviceName;

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

	@Test(groups = {"RegressionBFA","NACBFA","POM"})
	public void tc03_pomRogersNACTermBopisShippingTest() throws InterruptedException {
		// **************************Device catalog page*****************************************
//		reporter.softAssert(getRogersDeviceCataloguePage().isRpotgBannerPresent(),
//				"RPOTG Banner is present in the Device Catalog Page, verified by promo text",
//				"RPOTG Banner is not present in the Device Catalog Page, verified by promo text");
//		getRogersDeviceCataloguePage().clickRpotgBannerLearnMore();
//		reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "RPOTG Learn More Modal is displayed",
//				"Learn More Modal is not present");
//		reporter.reportLogPassWithScreenshot("RPOTG Learn More Model");
//		getRogersDeviceCataloguePage().clickCloseButtonOnModal();
//		getRogersDeviceCataloguePage().clickCheckEligibilityRpotgBanner();
//		reporter.reportLogPassWithScreenshot("RPOTG Check Eligibility Banner");
//		getRogersDeviceCataloguePage().validateRpotgPostalCode(TestDataHandler.tc03NACTermPotgShipping.getPostalCode());
//		getRogersDeviceCataloguePage().clickCheckBtn();
//		reporter.reportLogPassWithScreenshot("RPOTG: Postal Code & Check Eligibility Success");
//		getRogersDeviceCataloguePage().clickContinueBtn();
//		String postalCode = getRogersDeviceCataloguePage().verifyeligiblePostalCodeinBanner();
//		reporter.hardAssert(postalCode.contains(TestDataHandler.tc03NACTermPotgShipping.getPostalCode()),
//				"RPOTG Banner has the eligible postal code displayed", "RPOTG Banner not displayed in banner");
		String deviceName = TestDataHandler.tc03NACTermPotgShipping.getDeviceName();
		getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
		reporter.softAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen",
				"Modal element is not present on the screen");
		reporter.softAssert(getRogersDeviceCataloguePage().verifyGetStartedButtonOnModal(),
				"Get started button on the modal is present", "Get started button on the modal is not present");
		reporter.reportLogWithScreenshot("Modal window Popup");
		reporter.hardAssert(getRogersDeviceCataloguePage().clickGetStartedButtonOnModal(), "Clicked Get Started Button",
				"Get Started button not able to click");

		// ***************************Device config page************************************
//		System.out.println(getRogersDeviceConfigPage().verifyeligiblePostalCodeinBanner());
//		System.out.println(TestDataHandler.tc03NACTermPotgShipping.getPostalCode());
//		reporter.softAssert(getRogersDeviceConfigPage().verifyeligiblePostalCodeinBanner().contains(TestDataHandler.tc03NACTermPotgShipping.getPostalCode()),
//				"Eligible postal code verified in Device Catalog page Banner is carried on to Device Config Page Banner as expected",
//				"Postal Code not matching");
		//reporter.hardAssert(getRogersDeviceConfigPage().verifyBreadCrumb(), "BreadCrumb on Phone config page is working fine", "BreadCrumb is not working fine");
		getRogersDeviceConfigPage().clickContinueButton();
		// ****************************Plan config page***************************************
//		reporter.softAssert(getRogersDeviceConfigPage().verifyeligiblePostalCodeinBanner().contains(TestDataHandler.tc03NACTermPotgShipping.getPostalCode()), "Eligible postal code verified in Device Catalog & Device Config page POTG Banner is carried on to Plan Config Page Banner as expected", "Postal code not matching in Plan Config page");
//		String rpotgLabelPlanConfig = getRogersPlanConfigPage().getRpotgLabelPlanConfigPage();
//		reporter.reportLogWithScreenshot(
//				"RPOTG Label and subcopy verified in Plan Config Page verified as" + "--->" + rpotgLabelPlanConfig);
		reporter.hardAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName),
				"BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
		// ***************************Promo Section************************************
		getRogersPlanConfigPage().clkPromoSection();
		reporter.reportLogWithScreenshot("Promo Section Displayed");
		getRogersPlanConfigPage().setPromoCode(TestDataHandler.tc03NACTermPotgShipping.getPromoCode());
		reporter.reportLogWithScreenshot("Promo Code Entered");
		getRogersPlanConfigPage().clkCheckPromoBtn();
		reporter.hardAssert(getRogersPlanConfigPage().verifyPromoSuccessMsg(), "Promo Code Applied Successfully", "Promo Code Not Applied");
		reporter.hardAssert(getRogersPlanConfigPage().verifyPromoDuration(), "Discount Value and Duration displayed", "Promo Code Not Applied");
		// ***************************Plan config page************************************
		getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page data option selected");
		getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc03NACTermPotgShipping.getDataOptionIndex()),this.getClass().getSimpleName());
		reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page data protection selected");
		getRogersPlanConfigPage().skipBPOOffer();
		getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
		getRogersPlanConfigPage().clkContinueDeviceProtection();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
		String monthlyFeesAmount = getRogersPlanConfigPage().getMonthlyFeesAmount();
		String oneTimeFeesAmount = getRogersPlanConfigPage().getOneTimeFeesAmount();
		reporter.reportLogPassWithScreenshot(
				"Cart summary: Monthly & OneTimeFees" + monthlyFeesAmount + "&" + oneTimeFeesAmount);
		reporter.hardAssert(getRogersPlanConfigPage().verifyCartLineItem(),"Promo Code and Discount amount Line Item displayed","Promo code line item not displayed");
		getRogersPlanConfigPage().clickCartSummaryContinueButton();
		// ***************Create Profile Stepper*************//
		reporter.hardAssert(getRogersCheckoutPage().verifyCreateProfileTitle(), "Create profile Title Present", "Create profile Title not present");
		String totalMonthlyFees = getRogersCheckoutPage().getMonthlyFeeAfterTax();
		String oneTimeFee = getRogersCheckoutPage().getOneTimeFeeAfterTax();
		String purchaseIncludes = getRogersCheckoutPage().getPurchaseIncludesText();
		reporter.reportLog("Checkout page Cart Summary Info" + "1. Total Monthly Fees" + totalMonthlyFees
				+ "2. oneTimeFee" + oneTimeFee + "3. Purchase Include" + purchaseIncludes);
		//String labelRpotgPurchaseIncludesCheckout = getRogersCheckoutPage().getRpotgLabelPurchaseIncludes();
		//reporter.softAssert(purchaseIncludes.contains(labelRpotgPurchaseIncludesCheckout),
				//"RPOTG label verified in Purchase Includes section",
				//"RPOTG label not availble in Purchase Includes section");
		String emailCreateProfile = getRogersCheckoutPage().setEmailCreateProfile();
		getRogersCheckoutPage().confirmEmailCreateProfile(emailCreateProfile);
		String firstName = getRogersCheckoutPage().setFirstNameCreateProfile();
		String lastName = getRogersCheckoutPage().setLastNameCreateProfile();
//		String firstName = rogers_checkout_page.setFirstNameCreateProfilepage("smisamvulamani");
//		String lastName = rogers_checkout_page.setLastNameCreateProfilepage("marichale");
		String fullNameCreateProfile = firstName + " " + lastName;
		String contactNumberCreateProfile = TestDataHandler.tc03NACTermPotgShipping.getContactNumber();
		getRogersCheckoutPage().setContactNumberCreateProfile(contactNumberCreateProfile);
		reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
		String billingAddressCreateProfile = TestDataHandler.tc03NACTermPotgShipping.getBillingAddress();
		getRogersCheckoutPage().setBillingAddressCreateProfile(billingAddressCreateProfile);
		//getRogersCheckoutPage().getRpotgSuccessMessage();
//		reporter.reportLogPassWithScreenshot(
//				"Billing Address entered is eligible for RPOTG - Success message validated");
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
		getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc03NACTermPotgShipping.getDateOfBirthYear());
		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc03NACTermPotgShipping.getDateOfBirthMonth());
		getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.tc03NACTermPotgShipping.getDateOfBirthDay());
		getRogersCheckoutPage().switchToCreditCardIFrame();
		getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc03NACTermPotgShipping.getCreditCardDetails());
		reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
		getRogersCheckoutPage().switchOutOfCreditCardIFrame();
		getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc03NACTermPotgShipping.getExpiryDate());
		getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc03NACTermPotgShipping.getDropdownOption());
		getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc03NACTermPotgShipping.getPassportNumber());
		reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
		getRogersCheckoutPage().clkCreditAuthorizationChkBox();
		getRogersCheckoutPage().clkCreditEvalContinue();
		reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
		reporter.hardAssert(getRogersCheckoutPage().isIdentificationLabel(), "Credit Evaluation Successful",
				"Credit Evaluation Identification Label not disaplayed");

		// ***************Choose a Number Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
		reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
		getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc03NACTermPotgShipping.getCityName());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
		getRogersCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(),
				"Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
		getRogersCheckoutPage().clkChooseNumberbutton();

		// ***************Billing & Payment Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isBillingOptionsTitleDisplayed(), "Billing Options Title Displayed", "Billing Options Title Not Present");
		reporter.softAssert(getRogersCheckoutPage().isPaymentMethodDropdownPresent(), "Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not disaplayed");
		getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc03NACTermPotgShipping.getPaymentMethod());
		getRogersCheckoutPage().clkBillingContinueButton();
		// ***************Shipping Stepper*************//
//		getRogersCheckoutPage().clkDeliveryMethod("PRO");
//		reporter.hardAssert(getRogersCheckoutPage().verifyAppointmentLabel() ,"Appointment label available", "Appointment label not available");
//		getRogersCheckoutPage().clkContinueBtnShipping();
		getRogersCheckoutPage().clkDeliveryMethod("EXPRESS");
		reporter.reportLogPass("Express Delivery selected");
		reporter.hardAssert(getRogersCheckoutPage().verifyExpressLocationMapPresent() ,"Express location map available", "Express location map not available");
		getRogersCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPass("Clicked continue button in shipping stepper");
		getRogersCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPass("Clicked submit button below cart summary");
		// ***************Order Review Page****************************************************
		reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present", "Order Review Page Title is not Present");
		reporter.reportLogPass("Order Review Page");
		String totalMonthlyFeesReviewPage = getRogersReviewOrderPage().getMonthlyFeeAfterTax();
		reporter.softAssert(totalMonthlyFees.equals(totalMonthlyFeesReviewPage), "Total Monthly Fee after tax matches with checkout page", "Total Monthly Fee after tax not matches with checkout page");
		String oneTimeFeesReviewPage = getRogersReviewOrderPage().getOneTimeFeeAfterTax();
		reporter.softAssert(oneTimeFee.equals(oneTimeFeesReviewPage), "Total One time fee after tax matches with checkout page", "Total One time fee after tax not matches with checkout page");
		String puchaseIncludeReviewPage = getRogersReviewOrderPage().getPurchaseIncludesText();
		reporter.reportLogPassWithScreenshot("Order Review Page" + "1.Monthly Fees" + totalMonthlyFeesReviewPage + "2. OnetimeFees:" + oneTimeFeesReviewPage + "3.Purchase Include :" + puchaseIncludeReviewPage);
		String contactNameReviewPage = getRogersReviewOrderPage().getContactName();
		reporter.softAssert(fullNameCreateProfile.equals(contactNameReviewPage), "Contact Name in Order Review Page matches as entered in Create Profile stepper", "Contact Name in Order Review Page not matches as entered in Create Profile stepper");
		String contactNumberReviewPage = getRogersReviewOrderPage().getContactNumber();
		reporter.softAssert(contactNumberCreateProfile.equals(contactNumberReviewPage), "Contact Number Matched", "Contact Number not matching");
		String contactEmailReviewPage = getRogersReviewOrderPage().getContactEmail();
		reporter.softAssert(emailCreateProfile.equals(contactEmailReviewPage), "Contact email in Order Review Page matches as entered in Create Profile stepper", "Contact email in Order Review Page not matches as entered in Create Profile stepper");
		reporter.reportLogPassWithScreenshot("Order Review Page : Contact Details");
		getRogersReviewOrderPage().clkFinancingConsentCheckbox();
		getRogersReviewOrderPage().clkAgreementConsentCheckbox();
		getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
		getRogersReviewOrderPage().clkBopisConsentCheckbox();
		reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
		getRogersReviewOrderPage().clkEmailConsentCheckbox();
		reporter.reportLogPass("Email Communication consent box checked");
		getRogersReviewOrderPage().clkSubmitOrderBtn();
		// ************Order Confirmation Page***************************************************

		reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),
				"Order Confrimation Page Title Present", "Order Confrimation Page Title is not Present");
		reporter.reportLogPassWithScreenshot("Order Confirmation Page");
//		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyRpotgTitle(), "RPOTG Title verified",
//				"RPOTG Title Not Present");
//		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyAppointmentDetailsTitle(),
//				"Appointment Details Title verified", "Your Appointment Details Title Not present");
//		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyAppointmentDateTitle(),
//				"Appointment Date Title Verified", "Appointment Date Title not Present");
//		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyAppointmentAddressTitle(),
//				"Appointment Address Title Verified", "Appointment Address Title not present");
//		String appointmentAddress = getRogersNACOrderConfirmationPage().getAppointmentAddressText();
//		reporter.reportLogWithScreenshot("Appointment Address Details" + "-->" + appointmentAddress);
//		reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyDeviceImage(),
//				"Device Image Present in Confirmation Page", "Device Image not present");
		String totalMonthlyFeesConfirmationPage = getRogersNACOrderConfirmationPage().getMonthlyFeeAfterTax();
		reporter.softAssert(totalMonthlyFees.equals(totalMonthlyFeesConfirmationPage),
				"Total Monthly Fee after tax matches with checkout page",
				"Total Monthly Fee after tax not matches with checkout page");
		String oneTimeFeesConfirmationPage = getRogersNACOrderConfirmationPage().getOneTimeFeeAfterTax();
		reporter.softAssert(oneTimeFee.equals(oneTimeFeesConfirmationPage),
				"Total One time fee after tax matches with checkout page",
				"Total One time fee after tax not matches with checkout page");
		String purchaseIncludesConfrimation = getRogersNACOrderConfirmationPage().getPurchaseIncludesText();
		reporter.softAssert(purchaseIncludesConfrimation.equals(puchaseIncludeReviewPage),
				"Purchase includes Matches in Order Confirmation page", "Purchase Includes Not Matching");
		reporter.reportLogPassWithScreenshot("Purchase includes captured as" + "-->" + purchaseIncludesConfrimation);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
