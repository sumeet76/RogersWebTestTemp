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
 * TC01 - PROD SANITY - [RNAC TERM] - Financing with VDP_Till Credit Evaluation_E2E
 * @author praveen.kumar7
 */

public class RogersBFA_PROD_Sanity_TC01_NewActivationTerm_TillCreditEvaluationPage_Test extends BaseTestClass {

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("AWSPRODUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

	@Test(groups = {"PRODSanity","PRODNACSanity"})
	public void tc01_rogersProdSanity_NewActivation_Term() throws InterruptedException {

		// **************************Device catalog page*****************************************
		//getRogersDeviceCataloguePage().setProvince("Ontario");
		getDriver().get(System.getProperty("AWSPRODUrl")+"/phones");
		reporter.hardAssert(getRogersDeviceCataloguePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
		getRogersDeviceCataloguePage().clickDeviceTileCTAButton(TestDataHandler.tc02NACNoTermStandardShipping.getDeviceName());
		reporter.softAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen",
				"Modal element is not present on the screen");
		reporter.softAssert(getRogersDeviceCataloguePage().verifyGetStartedButtonOnModal(),
				"Get started button on the modal is present", "Get started button on the modal is not present");
		reporter.reportLogWithScreenshot("Modal window Popup");
		reporter.hardAssert(getRogersDeviceCataloguePage().clickGetStartedButtonOnModal(), "Clicked Get Started Button",
				"Get Started button not able to click");

		reporter.reportLogPassWithScreenshot("Device config page loaded successfully");
		getRogersDeviceConfigPage().clickContinueButton();

		getRogersCheckoutPage().clkNoThanks();
		getRogersPlanConfigPage().clkDownPaymentChkBox();
		reporter.reportLogWithScreenshot("Clicked on Downpayment checkbox");
		getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		getRogersPlanConfigPage().clickShowMoreDetails();
		//getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc04NACTermBopis.getDataOptionIndex()),this.getClass().getSimpleName());
		getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		getRogersCheckoutPage().clkNoThanks();
		getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
		getRogersCheckoutPage().clkNoThanks();
		reporter.reportLogPassWithScreenshot("Landed in Addons stepper");
		getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
		getRogersPlanConfigPage().clkContinueDeviceProtection();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
		getRogersPlanConfigPage().clickCartSummaryContinueButton();

		//--------------------------------------Create Profile Stepper-----------------------------------------------
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
		reporter.reportLogPassWithScreenshot("Create Profile Page details provided");
		getRogersCheckoutPage().switchToRecaptchaIFrame();
		getRogersCheckoutPage().clkImNotRombotCheckbox();
		reporter.reportLogPassWithScreenshot("I'm not Robot CheckedRogersCheckoutPage");
		getRogersCheckoutPage().switchOutOfGoogleIFrame();
		getRogersCheckoutPage().clkBtnGotoCreditEvalStepper();
		//----------------------------------------Credit Evaluation Stepper----------------------------------------
		getRogersCheckoutPage().clkNoThanks();
		reporter.softAssert(getRogersCheckoutPage().verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
		getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc06NACByodTermBopis.getDateOfBirthYear());
		getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.tc06NACByodTermBopis.getDateOfBirthMonth());
		getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.tc06NACByodTermBopis.getDateOfBirthDay());
		getRogersCheckoutPage().switchToCreditCardIFrame();
		getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.tc06NACByodTermBopis.getCreditCardDetails());
		reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
		getRogersCheckoutPage().switchOutOfCreditCardIFrame();
		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().setExpiryDate(TestDataHandler.tc06NACByodTermBopis.getExpiryDate());
		getRogersCheckoutPage().selectDropdownOption(TestDataHandler.tc06NACByodTermBopis.getDropdownOption());
		getRogersCheckoutPage().setPassportNumber(TestDataHandler.tc06NACByodTermBopis.getPassportNumber());
		reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");

	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
