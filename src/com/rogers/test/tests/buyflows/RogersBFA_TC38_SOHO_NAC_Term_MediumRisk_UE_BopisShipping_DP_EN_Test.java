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
 * TC38 - SOHO Medium Risk Customer_New Activation_Upfront edge option with POTG Shipping
 * @author praveen.kumar7
 */

public class RogersBFA_TC38_SOHO_NAC_Term_MediumRisk_UE_BopisShipping_DP_EN_Test extends BaseTestClass {
	String deviceName;

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

	@Test(groups = {"RegressionBFA","SOHONACBFA","SanityNACBFA"})
	public void tc38_sohoNACTermMediumRiskBopisTest() throws InterruptedException {
		// **************************Device catalog page*****************************************
		/*reporter.softAssert(getRogersDeviceCataloguePage().isRpotgBannerPresent(),
				"RPOTG Banner is present in the Device Catalog Page, verified by promo text",
				"RPOTG Banner is not present in the Device Catalog Page, verified by promo text");
		getRogersDeviceCataloguePage().clickRpotgBannerLearnMore();
		reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "RPOTG Learn More Modal is displayed",
				"Learn More Modal is not present");
		reporter.reportLogPassWithScreenshot("RPOTG Learn More Model");
		getRogersDeviceCataloguePage().clickCloseButtonOnModal();
		getRogersDeviceCataloguePage().clickCheckEligibilityRpotgBanner();
		reporter.reportLogPassWithScreenshot("RPOTG Check Eligibility Banner");
		getRogersDeviceCataloguePage().validateRpotgPostalCode(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionPOTG.getPostalCode());
		getRogersDeviceCataloguePage().clickCheckBtn();
		reporter.reportLogPassWithScreenshot("RPOTG: Postal Code & Check Eligibility Success");
		getRogersDeviceCataloguePage().clickContinueBtn();
		String postalCode = getRogersDeviceCataloguePage().verifyeligiblePostalCodeinBanner();
		reporter.hardAssert(postalCode.contains(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionPOTG.getPostalCode()),
				"RPOTG Banner has the eligible postal code displayed", "RPOTG Banner not displayed in banner");*/
		String deviceName = TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getDeviceName();
		getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
		reporter.softAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen",
				"Modal element is not present on the screen");
		reporter.softAssert(getRogersDeviceCataloguePage().verifyGetStartedButtonOnModal(),
				"Get started button on the modal is present", "Get started button on the modal is not present");
		reporter.reportLogWithScreenshot("Modal window Popup");
		reporter.hardAssert(getRogersDeviceCataloguePage().clickGetStartedButtonOnModalRPP(), "Clicked Get Started Button",
				"Get Started button not able to click");

		// ***************************Device config page************************************
		/*System.out.println(getRogersDeviceConfigPage().verifyeligiblePostalCodeinBanner());
		System.out.println(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionPOTG.getPostalCode());
		reporter.softAssert(getRogersDeviceConfigPage().verifyeligiblePostalCodeinBanner().contains(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionPOTG.getPostalCode()),
				"Eligible postal code verified in Device Catalog page Banner is carried on to Device Config Page Banner as expected",
				"Postal Code not matching");*/
		String deviceCost = getRogersDeviceConfigPage().getDeviceFullPrice(this.getClass().getSimpleName());
		//String upfrontEdgeAmt = getRogersDeviceConfigPage().getUpfrontEdgeAmt(this.getClass().getSimpleName());
		String financeProgramCredit = "0.0";
		financeProgramCredit = getRogersDeviceConfigPage().getFinanceProgramCreditPrice(this.getClass().getSimpleName());
		String upfrontEdgeAmt = "0.0";
		upfrontEdgeAmt = getRogersDeviceConfigPage().getUpfrontEdgeAmt(this.getClass().getSimpleName());
		getRogersDeviceConfigPage().selectDeviceProtectionAddon();
		reporter.reportLogPassWithScreenshot("Device Protection Addon is selected in Device Config Page");
		getRogersDeviceConfigPage().clickContinueButton();
		// ****************************Plan config page***************************************
		/*reporter.softAssert(getRogersDeviceConfigPage().verifyeligiblePostalCodeinBanner().contains(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionPOTG.getPostalCode()), "Eligible postal code verified in Device Catalog & Device Config page POTG Banner is carried on to Plan Config Page Banner as expected", "Postal code not matching in Plan Config page");
		String rpotgLabelPlanConfig = getRogersPlanConfigPage().getRpotgLabelPlanConfigPage();
		reporter.reportLogWithScreenshot(
				"RPOTG Label and subcopy verified in Plan Config Page verified as" + "--->" + rpotgLabelPlanConfig);*/
		reporter.hardAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName),
				"BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
		getRogersPlanConfigPage().selectDeviceCostAndClickOnContinueButton(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getDeviceCostIndex());
		reporter.reportLogPassWithScreenshot("Plan config page data option selected");
		getRogersPlanConfigPage().clickShowMoreDetails();
		getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getDataOptionIndex(),this.getClass().getSimpleName());
		reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
		getRogersPlanConfigPage().skipBPOOffer();
		reporter.reportLogPassWithScreenshot("Device Protection Addon is already selected in Device Config Page");
		getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page Add-ons Continue button clicked");
		reporter.hardAssert(getRogersPlanConfigPage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
		String dpAddon = getRogersPlanConfigPage().getDeviceProtectionAddon();
		reporter.reportLogPassWithScreenshot("Device Protection - " +dpAddon);
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
		getRogersCheckoutPage().setFirstNameCreateProfile();
		getRogersCheckoutPage().setLastNameCreateProfile();
		getRogersCheckoutPage().setBusinessName();
		getRogersCheckoutPage().setBusinessNumber(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getBusinessNumber());
		getRogersCheckoutPage().setContactNumberCreateProfile(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getContactNumber());
		getRogersCheckoutPage().setCompanySize(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getCompanySize());
		reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
		getRogersCheckoutPage().setBillingAddressCreateProfile(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getBillingAddress());
		/*getRogersCheckoutPage().getRpotgSuccessMessage();
		reporter.reportLogPassWithScreenshot(
				"Billing Address entered is eligible for RPOTG - Success message validated");*/
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
		getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getDateOfBirthYear());
		getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getDateOfBirthMonth());
		getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getDateOfBirthDay());
		getRogersCheckoutPage().switchToCreditCardIFrame();
		getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getCreditCardDetails());
		reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
		getRogersCheckoutPage().switchOutOfCreditCardIFrame();
		getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getExpiryDate());
		getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getDropdownOption());
		getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getPassportNumber());
		reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
		getRogersCheckoutPage().clkCreditAuthorizationChkBox();
		getRogersCheckoutPage().clkCreditEvalContinue();
		reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
		/*reporter.hardAssert(getRogersCheckoutPage().verifyClaDownPaymentModalPresent(),
				"CLA and Security deposit modal is displayed", "Cla and Security Deposit Modal is not dislayed");
		reporter.softAssert(getRogersCheckoutPage().verifyDownPaymentTextPresent(),
				"Down payment info dislayed in modal", "Down payment info not dislayed in modal");
		reporter.reportLogWithScreenshot("CLA/Down payment Modal");*/
		String expectedDownPayment = getRogersCheckoutPage().setDownPaymentUpfrontEdge(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getRiskClass(),deviceCost,upfrontEdgeAmt,financeProgramCredit);
		reporter.reportLog("Expected DownPayment" +expectedDownPayment);
		//reporter.hardAssert(getRogersCheckoutPage().verifyDownPaymentAmt(expectedDownPayment),
				//"Downpayment amount is displayed correctly", "Downpayment amount is not displayed correctly");
		getRogersCheckoutPage().clkAcceptButton();
		reporter.hardAssert(getRogersCheckoutPage().isIdentificationLabel(), "Credit Evaluation Successful",
				"Credit Evaluation Identification Label not disaplayed");

		// ***************Choose a Number Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
		reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
		getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getCityName());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
		getRogersCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
//		reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(),
//				"Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
		getRogersCheckoutPage().clkChooseNumberbutton();
		// ***************Billing & Payment Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isBillingOptionsTitleDisplayed(), "Billing Options Title Displayed", "Billing Options Title Not Present");
		reporter.softAssert(getRogersCheckoutPage().isPaymentMethodDropdownPresent(), "Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not disaplayed");
		getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getPaymentMethod());
		getRogersCheckoutPage().clkBillingContinueButton();
		getRogersCheckoutPage().clickSkipNacAutopay();
		// ***************Shipping Stepper*************//
		//reporter.softAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ", "Billing Address is not selected");
		//String addressShippingStepper = getRogersCheckoutPage().getShippingAddress();
		/*getRogersCheckoutPage().clkDeliveryMethod("PRO");
		reporter.hardAssert(getRogersCheckoutPage().verifyAppointmentLabel() ,"Appointment label available", "Appointment label not available");*/
		getRogersCheckoutPage().clkDeliveryMethod("STANDARD");
		//reporter.reportLogPassWithScreenshot("Bopis Delivery selected");
//		reporter.hardAssert(getRogersCheckoutPage().verifyExpressLocationMapPresent(), "Express Location Map is available",
//				"Express Location Map is not available");
		getRogersCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPass("Clicked continue button in shipping stepper");
		getRogersCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPass("Clicked submit button below cart summary");
		// ***************Order Review Page****************************************************
		reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present", "Order Review Page Title is not Present");
		reporter.reportLogPass("Order Review Page");
		String contactEmailReviewPage = getRogersReviewOrderPage().getContactEmail();
		reporter.hardAssert(emailCreateProfile.equals(contactEmailReviewPage), "Contact email in Order Review Page matches as entered in Create Profile stepper", "Contact email in Order Review Page not matches as entered in Create Profile stepper");
		reporter.reportLogPassWithScreenshot("Order Review Page : Contact Details");
		reporter.hardAssert(getRogersReviewOrderPage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
		String deviceProtectionAddon = getRogersReviewOrderPage().getDeviceProtectionAddon();
		getReporter().reportLogPassWithScreenshot("Device Protection - " +deviceProtectionAddon);
		getRogersReviewOrderPage().clkFinancingConsentCheckbox();
		getRogersReviewOrderPage().clkAgreementConsentCheckbox();
		getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
		//getRogersReviewOrderPage().clkBopisConsentCheckbox();
		reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
		getRogersReviewOrderPage().clkEmailConsentCheckbox();
		reporter.reportLogPass("Email Communication consent box checked");
		getRogersReviewOrderPage().clkSubmitOrderBtn();
		//---------------------One Time Payment page------------------------------//
		reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),
				"Pay with Credit card details are present on OneTime payment page", "Pay with Credit card details are not present on OneTime payment page");
		getRogersOneTimePaymentPage().setNameonCard();
		getRogersOneTimePaymentPage().switchToCreditCardIFrame();
		getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getCreditCardDetailsOTP());
		getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
		getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc38_SOHO_NACTermMediumRiskUEOptionBOPIS.getExpiryDateOTP());
		getRogersOneTimePaymentPage().setCVV();
		reporter.reportLogPassWithScreenshot("Credit Card Details Entered Successfully");

		getRogersOneTimePaymentPage().clkSubmitOrderBtn();
		// ************Order Confirmation Page***************************************************

		reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),
				"Order Confrimation Page Title Present", "Order Confrimation Page Title is not Present");
		reporter.reportLogPassWithScreenshot("Order Confirmation Page");
		/*reporter.hardAssert(getRogersNACOrderConfirmationPage().verifyRpotgTitle(), "RPOTG Title verified",
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
				"Device Image Present in Confirmation Page", "Device Image not present");*/
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
