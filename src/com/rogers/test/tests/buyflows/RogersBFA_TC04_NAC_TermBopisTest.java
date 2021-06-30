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

public class RogersBFA_TC04_NAC_TermBopisTest extends BaseTestClass {
	String deviceName;

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

	@Test(groups = {"RegressionBFA","NACBFAA","SanityBFA"})
	public void rogersNACTermBopisTest() throws InterruptedException {

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
		getRogersDeviceCataloguePage().validateRpotgPostalCode(TestDataHandler.tc04NACTermBopis.getPostalCode());
		getRogersDeviceCataloguePage().clickCheckBtn();
		reporter.reportLogPassWithScreenshot("RPOTG: Postal Code & Check Eligibility Success");
		getRogersDeviceCataloguePage().clickContinueBtn();
		String postalCode = getRogersDeviceCataloguePage().verifyeligiblePostalCodeinBanner();
		reporter.hardAssert(postalCode.contains(TestDataHandler.tc04NACTermBopis.getPostalCode()),
				"RPOTG Banner has the eligible postal code displayed", "RPOTG Banner not displayed in banner");*/
		reporter.hardAssert(getRogersDeviceCataloguePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
		String deviceName = TestDataHandler.tc04NACTermBopis.getDeviceName();
		getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
		reporter.softAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen",
				"Modal element is not present on the screen");
		reporter.softAssert(getRogersDeviceCataloguePage().verifyGetStartedButtonOnModal(),
				"Get started button on the modal is present", "Get started button on the modal is not present");
		reporter.reportLogWithScreenshot("Modal window Popup");
		reporter.hardAssert(getRogersDeviceCataloguePage().clickGetStartedButtonOnModal(), "Clicked Get Started Button",
				"Get Started button not able to click");

		// ***************************Device config page************************************
		System.out.println(getRogersDeviceConfigPage().verifyeligiblePostalCodeinBanner());
		System.out.println(TestDataHandler.tc04NACTermBopis.getPostalCode());
		/*reporter.softAssert(
				getRogersDeviceConfigPage().verifyeligiblePostalCodeinBanner()
						.contains(TestDataHandler.tc04NACTermBopis.getPostalCode()),
				"Eligible postal code verified in Device Catalog page Banner is carried on to Device Config Page Banner as expected",
				"Postal Code not matching");*/
		String rpotgLabelDeviceConfig = getRogersDeviceConfigPage().getRpotgLabelDeviceConfigPage();
		reporter.reportLogWithScreenshot(
				"RPOTG Promo Label and subcopy verified in Device Config Page as" + "-->" + rpotgLabelDeviceConfig);
		String deviceNameDeviceConfigPage = getRogersDeviceConfigPage().deviceInfoDeviceNameDeviceConfigPage()
				.toUpperCase();
		String deviceSizeDeviceConfigPage = getRogersDeviceConfigPage().deviceInfoDeviceSizeDeviceConfigPage()
				.toUpperCase();
		String deviceColorDeviceConfigPage = getRogersDeviceConfigPage().deviceInfoDeviceColorDeviceConfigPage()
				.toUpperCase();
		String deviceInfoDeviceConfigPage = deviceNameDeviceConfigPage + " " + deviceSizeDeviceConfigPage + " "
				+ deviceColorDeviceConfigPage;
		reporter.softAssert(getRogersDeviceConfigPage().verifyDefaultSizeSelected(), "Default value for size is selected",
				"Default value for size is not selected");
		reporter.reportLogPassWithScreenshot("Device Config Page" + "Device info:" + deviceInfoDeviceConfigPage);
		String pricingBlockValueDeviceConfigPage = getRogersDeviceConfigPage().getPricingBlockValueDeviceConfigPage();
		String pricePlanInfoDeviceConfigPage = getRogersDeviceConfigPage().getPricePlanValueDeviceConfigPage();
		reporter.softAssert(getRogersDeviceConfigPage().verifyBreadCrumb(),
				"BreadCrumb on Phone config page is working fine", "BreadCrumb is not working fine");
		String fullPriceDeviceConfigPage = getRogersDeviceConfigPage().getFullPrice();
		String promoBlockInformation = getRogersDeviceConfigPage().getPromoBlockText();
		reporter.reportLogPassWithScreenshot("Device config page Details" + "1. Price Block Value :"
				+ pricingBlockValueDeviceConfigPage + "2. Priceplan Info:" + pricePlanInfoDeviceConfigPage
				+ "3. Full Price:" + fullPriceDeviceConfigPage + "4. PromoBlock Info:" + promoBlockInformation);
		getRogersDeviceConfigPage().clickContinueButton();
		// ****************************Plan config page***************************************
		System.out.print(getRogersPlanConfigPage().verifyeligiblePostalCodeinBanner());
		System.out.println(TestDataHandler.tc04NACTermBopis.getPostalCode());
		/*reporter.softAssert(
				getRogersPlanConfigPage().verifyeligiblePostalCodeinBanner()
						.contains(TestDataHandler.tc04NACTermBopis.getPostalCode()),
				"Eligible postal code verified in Device Catalog & Device Config page POTG Banner is carried on to Plan Config Page Banner as expected",
				"Postal code not matching in Plan Config page");*/
		String rpotgLabelPlanConfig = getRogersPlanConfigPage().getRpotgLabelPlanConfigPage();
		reporter.reportLogWithScreenshot(
				"RPOTG Label and subcopy verified in Plan Config Page verified as" + "--->" + rpotgLabelPlanConfig);
		reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName),
				"BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
		//reporter.hardAssert(getRogersPlanConfigPage().verifyDefaultPrice(fullPriceValueCataloguePage),"Default  price is same as it is shown in device catalogue & Config page page","Default price is not same as it is shown in device catalogue page");
		getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page data option selected");
		getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page data protection selected");
		getRogersPlanConfigPage().skipBPOOffer();
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
		reporter.hardAssert(getRogersCheckoutPage().isIdentificationLabel(), "Credit Evaluation Successful",
				"Credit Evaluation Identification Label not disaplayed");

		// ***************Choose a Number Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed",
				"Choose a Number Title not disaplayed");
		reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(),
				"Select a New Number/Use Existing Number Tab Displayed",
				"Select a New Number/Use Existing Number Tab not disaplayed");
		getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc04NACTermBopis.getCityName());
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
		getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.tc04NACTermBopis.getPaymentMethod());
		getRogersCheckoutPage().clkBillingContinueButton();
		// ***************Shipping Stepper*************//
		reporter.softAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
				"Billing Address is not selected");
		String addressShippingStepper = getRogersCheckoutPage().getShippingAddress();
		System.out.println(billingAddressCreateProfile+"and"+addressShippingStepper);
		/*reporter.softAssert(billingAddressCreateProfile.equals(addressShippingStepper),
				"Address in Shipping Stepper matches as entered in Create Profile stepper",
				"Address in Shipping Stepper not matches as entered in Create Profile stepper");*/
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
		getRogersReviewOrderPage().clkFinancingConsentCheckbox();
		getRogersReviewOrderPage().clkAgreementConsentCheckbox();
		getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
		reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
		getRogersReviewOrderPage().clkBopisConsentCheckbox();
		reporter.reportLogPass("Email Communication consent box checked");
		getRogersReviewOrderPage().clkSubmitOrderBtn();

		// ************Order Confirmation Page***************************************************

		reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),
				"Order Confrimation Page Title Present", "Order Confrimation Page Title is not Present");
		reporter.reportLogPassWithScreenshot("Order Confirmation Page");
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
