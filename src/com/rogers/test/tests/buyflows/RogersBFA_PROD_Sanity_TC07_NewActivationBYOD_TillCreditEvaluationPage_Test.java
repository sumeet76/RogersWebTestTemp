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
 * TC07 - PROD SANITY - [RNAC BYOD] - New Activation till Credit evaluation page
 * @author praveen.kumar7
 */

public class RogersBFA_PROD_Sanity_TC07_NewActivationBYOD_TillCreditEvaluationPage_Test extends BaseTestClass {

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("AWSPRODUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
	}

	@Test(groups = {"PRODSanity","PRODNACSanity"})
	public void tc07_rogersProdSanity_NewActivation_BYOD() throws InterruptedException {

		getDriver().get(System.getProperty("AWSPRODUrl")+"/phones/bring-your-own-device?flowType=byod");
		//---------------------------------Plan config page---------------------------------
		reporter.hardAssert(getRogersPlanConfigPage().verifySelectedDeviceSection("Bring Your Own Phone"), "Plan Config page is loaded", "Plan config page is not loaded");
		getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page data option selected");
		getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
		getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on your addon's");
		getRogersPlanConfigPage().clickCartSummaryContinueButton();
		reporter.reportLogPassWithScreenshot("Plan config page clicked on proceed to checkout");

		//-------------------------------Create Profile Stepper----------------------------
		reporter.softAssert(getRogersCheckoutPage().verifyCreateProfileTitle(), "Create profile Title Present",
				"Create profile Title not present");
		String emailCreateProfile = getRogersCheckoutPage().setEmailCreateProfile();
		getRogersCheckoutPage().confirmEmailCreateProfile(emailCreateProfile);
        getRogersCheckoutPage().setFirstNameCreateProfile();
        getRogersCheckoutPage().setLastNameCreateProfile();
		getRogersCheckoutPage().setContactNumberCreateProfile(TestDataHandler.tc06NACByodTermBopis.getContactNumber());
		reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
		getRogersCheckoutPage().setBillingAddressCreateProfile(TestDataHandler.tc06NACByodTermBopis.getBillingAddress());
		getRogersCheckoutPage().clkLanguageEnglishRadioBtnCreateProfile();
		reporter.reportLogPassWithScreenshot("Create Profile Page details provided");
		getRogersCheckoutPage().switchToRecaptchaIFrame();
		getRogersCheckoutPage().clkImNotRombotCheckbox();
		reporter.reportLogPassWithScreenshot("I'm not Robot CheckedRogersCheckoutPage");
		getRogersCheckoutPage().switchOutOfGoogleIFrame();
		getRogersCheckoutPage().clkBtnGotoCreditEvalStepper();
		//----------------------------------------Credit Evaluation Stepper----------------------------------------
		reporter.softAssert(getRogersCheckoutPage().verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
		getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.tc06NACByodTermBopis.getDateOfBirthYear());
		getRogersCheckoutPage().clkNoThanks();
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
