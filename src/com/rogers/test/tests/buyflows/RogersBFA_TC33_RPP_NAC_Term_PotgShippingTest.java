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
 * TC33 - Regression - RPP Customer [RNAC TERM] - Perform Rogers Net New Activation - POTG Shipping(Finance plan with POTG)_E2E
 */

public class RogersBFA_TC33_RPP_NAC_Term_PotgShippingTest extends BaseTestClass {

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

	@Test(groups = {"RegressionBFA","NACBFA"})
	public void rogersRPPNACTermPotgShippingTest() throws InterruptedException {
		// **************************Device catalog page*****************************************
		getDriver().get(System.getProperty("AWSUrl")+"/?type=rpp");
		reporter.hardAssert(getRogersDeviceCataloguePage().verifyRppPasscodeModal(),"RPP Passcode modal is displayed", "RPP passcode modal is not displayed");
		getRogersDeviceCataloguePage().enterPasscodeInPasscodeModal(TestDataHandler.tc33RPPNACTermPotgShipping.getPasscode());
		reporter.reportLogWithScreenshot("Passcode entered successfully in passcode modal");
		getRogersDeviceCataloguePage().clkContinueBtnPassCodeMoodal();
		reporter.hardAssert(getRogersDeviceCataloguePage().verifyPasscode(),"Passcode is verified successfully", "Invalid Passcode");
		getRogersDeviceCataloguePage().clickGetStartedButtonOnModal();
		//-------------------------------Device Catalog Page----------------------------
		getRogersDeviceCataloguePage().clickDeviceTileCTAButton(TestDataHandler.tc33RPPNACTermPotgShipping.getDeviceName());
		reporter.reportLogWithScreenshot("Modal window Popup");
		reporter.hardAssert(getRogersDeviceCataloguePage().clickGetStartedButtonOnModal(), "Clicked Get Started Button",
				"Get Started button not able to click");
		// ***************************Device config page************************************
		reporter.reportLogWithScreenshot("Device Config page");
		getRogersDeviceConfigPage().clickContinueButton();
		// ****************************Plan config page***************************************
		getRogersPlanConfigPage().selectDeviceCostAndClickOnContinueButton(getRogersPlanConfigPage().getUpdatedDeviceCostIndex(TestDataHandler.tc33RPPNACTermPotgShipping.getDeviceCostIndex()));
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		getRogersPlanConfigPage().clickShowMoreDetails();
		getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc33RPPNACTermPotgShipping.getDataOptionIndex()),this.getClass().getSimpleName());
		reporter.reportLogPassWithScreenshot("Data option selected");
		reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page data protection selected");
		getRogersPlanConfigPage().skipBPOOffer();
		getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
		getRogersPlanConfigPage().clickCartSummaryContinueButton();
		// ***************Create Profile Stepper*************//
		reporter.hardAssert(getRogersCheckoutPage().verifyCreateProfileTitle(), "Create profile Title Present", "Create profile Title not present");
		String totalMonthlyFees = getRogersCheckoutPage().getMonthlyFeeAfterTax();
		String oneTimeFee = getRogersCheckoutPage().getOneTimeFeeAfterTax();
		String purchaseIncludes = getRogersCheckoutPage().getPurchaseIncludesText();
		reporter.reportLog("Checkout page Cart Summary Info" + "1. Total Monthly Fees" + totalMonthlyFees
				+ "2. oneTimeFee" + oneTimeFee + "3. Purchase Include" + purchaseIncludes);
		String emailCreateProfile = getRogersCheckoutPage().setEmailCreateProfile();
		getRogersCheckoutPage().confirmEmailCreateProfile(emailCreateProfile);
		String firstName = getRogersCheckoutPage().setFirstNameCreateProfile();
		String lastName = getRogersCheckoutPage().setLastNameCreateProfile();
		String fullNameCreateProfile = firstName + " " + lastName;
		String contactNumberCreateProfile = TestDataHandler.tc33RPPNACTermPotgShipping.getContactNumber();
		getRogersCheckoutPage().setContactNumberCreateProfile(contactNumberCreateProfile);
		reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
		String billingAddressCreateProfile = TestDataHandler.tc33RPPNACTermPotgShipping.getBillingAddress();
		getRogersCheckoutPage().setBillingAddressCreateProfile(billingAddressCreateProfile);
		getRogersCheckoutPage().clkLanguageEnglishRadioBtnCreateProfile();
		reporter.reportLogPassWithScreenshot("Create Profile Page details provided for Address,Shipping Address & Language Selected");
		getRogersCheckoutPage().switchToRecaptchaIFrame();
		getRogersCheckoutPage().clkImNotRombotCheckbox();
		reporter.reportLogPassWithScreenshot("I'm not Robot Checked");
		getRogersCheckoutPage().switchOutOfGoogleIFrame();
		getRogersCheckoutPage().clkBtnGotoCreditEvalStepper();

		// ***************Credit Evaluation Stepper***********//
		reporter.softAssert(getRogersCheckoutPage().verifyCreditEvaluationTitle(), "CreditEvaluation Title verified",
				"CreditEvaluation Title not present");
		getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc33RPPNACTermPotgShipping.getDateOfBirthYear());
		getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc33RPPNACTermPotgShipping.getDateOfBirthMonth());
		getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.tc33RPPNACTermPotgShipping.getDateOfBirthDay());
		getRogersCheckoutPage().switchToCreditCardIFrame();
		getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc33RPPNACTermPotgShipping.getCreditCardDetails());
		reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
		getRogersCheckoutPage().switchOutOfCreditCardIFrame();
		getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc33RPPNACTermPotgShipping.getExpiryDate());
		getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc33RPPNACTermPotgShipping.getDropdownOption());
		getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc33RPPNACTermPotgShipping.getPassportNumber());
		reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
		getRogersCheckoutPage().clkCreditAuthorizationChkBox();
		getRogersCheckoutPage().clkCreditEvalContinue();
		reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
		reporter.hardAssert(getRogersCheckoutPage().isIdentificationLabel(), "Credit Evaluation Successful",
				"Credit Evaluation Identification Label not disaplayed");

		// ***************Choose a Number Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
		getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc33RPPNACTermPotgShipping.getCityName());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
		getRogersCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(),
				"Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
		getRogersCheckoutPage().clkChooseNumberbutton();

		// ***************Billing & Payment Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isPaymentMethodDropdownPresent(), "Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not disaplayed");
		getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc33RPPNACTermPotgShipping.getPaymentMethod());
		getRogersCheckoutPage().clkBillingContinueButton();
		// ***************Shipping Stepper*************//
		getRogersCheckoutPage().clkDeliveryMethod("PRO");
		reporter.hardAssert(getRogersCheckoutPage().verifyAppointmentLabel() ,"Appointment label available", "Appointment label not available");
		getRogersCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPass("Clicked continue button in shipping stepper");
		getRogersCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPass("Clicked submit button below cart summary");
		// ***************Order Review Page****************************************************
		reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present", "Order Review Page Title is not Present");
		reporter.reportLogPass("Order Review Page");
		String totalMonthlyFeesReviewPage = getRogersReviewOrderPage().getMonthlyFeeAfterTax();
		reporter.hardAssert(totalMonthlyFees.equals(totalMonthlyFeesReviewPage), "Total Monthly Fee after tax matches with checkout page", "Total Monthly Fee after tax not matches with checkout page");
		String oneTimeFeesReviewPage = getRogersReviewOrderPage().getOneTimeFeeAfterTax();
		reporter.hardAssert(oneTimeFee.equals(oneTimeFeesReviewPage), "Total One time fee after tax matches with checkout page", "Total One time fee after tax not matches with checkout page");
		String puchaseIncludeReviewPage = getRogersReviewOrderPage().getPurchaseIncludesText();
		reporter.reportLogPassWithScreenshot("Order Review Page" + "1.Monthly Fees" + totalMonthlyFeesReviewPage + "2. OnetimeFees:" + oneTimeFeesReviewPage + "3.Purchase Include :" + puchaseIncludeReviewPage);
		String contactNameReviewPage = getRogersReviewOrderPage().getContactName();
		reporter.hardAssert(fullNameCreateProfile.equals(contactNameReviewPage), "Contact Name in Order Review Page matches as entered in Create Profile stepper", "Contact Name in Order Review Page not matches as entered in Create Profile stepper");
		String contactNumberReviewPage = getRogersReviewOrderPage().getContactNumber();
		reporter.softAssert(contactNumberCreateProfile.equals(contactNumberReviewPage), "Contact Number Matched", "Contact Number not matching");
		String contactEmailReviewPage = getRogersReviewOrderPage().getContactEmail();
		reporter.hardAssert(emailCreateProfile.equals(contactEmailReviewPage), "Contact email in Order Review Page matches as entered in Create Profile stepper", "Contact email in Order Review Page not matches as entered in Create Profile stepper");
		reporter.reportLogPassWithScreenshot("Order Review Page : Contact Details");
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
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
