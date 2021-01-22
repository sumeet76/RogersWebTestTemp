package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the IgniteTV buy flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 * Browse Rogers.com in QA
 * Click on Shop-> TV Bundles
 * Click on See available Ignite Bundles
 * Enter Address_2 in serviceability modal and click on check address
 * Select any Bundle and add to cart
 * Click on No I don’t have a Ignite TV and Click on Checkout
 * In the Profile page Enter the details as per the RCIS rule sheet for Medium risk class with Different address (Row 74-77) to simulate Medium Risk class scenario.Email ID and Contact number should be used different as the one with which we created the account in RCIS for address_1 to simulate failed verification. Billing address should be same as serviceable address.
 * Click on Proceed once we fill all the details
 * In Credit evaluation page enter the same details which were used for creating Address_1 account in RCIS,
 * also follow the RCIS rule sheet same as above to have the correct details respective to that to simulate Medium Risk Class and Click on Continue
 * Clicking on Cancel and X button should take you back to credit Eval page
 * As the Address retry is set to 2 , in the first retry enter any other address except Address_1 of the account which we created in RCIS and click on Proceed in the new modal
 * In the 2nd retry enter the same address of the account which we created in RCIS i.e Address_1 and click on Proceed
 * Select the required details in Fulfillment page to complete the E2E flow
 *
 **/

public class RogersCH_TC_055_IginteTV_ValidateAnonymousDifferentAddressRCISandECIDsetLowRiskIgniteBundleMediumRiskAddressRetry2CreditCheckTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","New"})
    public void checkAnonymousDifferentAddressRCISandECIDsetLowRiskIgniteBundleMediumRiskAddressRetry2CreditTest() {
		reporter.reportLogWithScreenshot("Launched the Easy Login Page");
		getRogersHomePage().clkTVBundle();
		reporter.hardAssert(getRogersHomePage().verifyIgnitepage(),"Ignite page has Launched","Ignite page has not Launched");
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		getRogersHomePage().clkServiceability();
		reporter.reportLogWithScreenshot("Launched the customer availability check popup");
		//getRogersHomePage().clkAddressCheck();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		String  strAddressLine1=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line1");
		String  strAddressLine2=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line2");
		getRogersHomePage().setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
		getRogersHomePage().clkIgniteAddressLookupSubmit();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
		getRogersIgniteTVBuyPage().selectSolarisStarterPackageNew();

		reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is availabe","4KTV radio button is not availabe");
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().set4KTV();
		reporter.reportLogWithScreenshot("4k TV selected");
		getRogersIgniteTVBuyPage().clkCheckout();

		reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersIgniteTVProfileCreationPage().setEmail(TestDataHandler.tc55_rCISandECIDLowRiskMediumRiskAddressRetry.getUsername());
		getRogersIgniteTVProfileCreationPage().setFirstname(TestDataHandler.tc55_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getFirstName());
		getRogersIgniteTVProfileCreationPage().setLastName(TestDataHandler.tc55_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getLastName());
		getRogersIgniteTVProfileCreationPage().setPhone(TestDataHandler.tc55_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getPhoneNumber());
		getRogersIgniteTVProfileCreationPage().clkSubmitProfile();

		reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evalution page has Launched","Credit Evalution page has not Launched");
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		getRogersIgniteTVCreditCheckPage().selectDOBYear();
		getRogersIgniteTVCreditCheckPage().selectDOBMonth();
		getRogersIgniteTVCreditCheckPage().selectDOBDay();
		reporter.reportLogWithScreenshot("Entered DOB details");
		getRogersIgniteTVCreditCheckPage().selectFirstID("Driver's License");
		getRogersIgniteTVCreditCheckPage().selectProvince("Ontario");
		getRogersIgniteTVCreditCheckPage().selectExpiryYear(TestDataHandler.tc55_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getYear());
		getRogersIgniteTVCreditCheckPage().selectExpiryMonth(TestDataHandler.tc55_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getMonth());
		getRogersIgniteTVCreditCheckPage().selectExpiryDay(TestDataHandler.tc55_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getDate());
		getRogersIgniteTVCreditCheckPage().setDrivingLicense(TestDataHandler.tc55_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getDrivingLicence());
		reporter.reportLogWithScreenshot("Driving License Details");
		getRogersIgniteTVCreditCheckPage().selectSecondIDOption("Birth Certificate");
		getRogersIgniteTVCreditCheckPage().setBirthCertificateNumber(TestDataHandler.tc55_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getBirthCertNumber());
		getRogersIgniteTVCreditCheckPage().clkCreditConsent();
		reporter.reportLogWithScreenshot("Passport Details");
		getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
		reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyAddressModal(),"Address Modal has Launched","Address Modal has not Launched");
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		String  strAddressLineOne=TestDataHandler.tc55_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getAddress().get("line1");
		String  strAddressLineTwo=TestDataHandler.tc55_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getAddress().get("line2");
		getRogersIgniteTVCreditCheckPage().setIgniteAddressLookup(strAddressLineOne+", "+strAddressLineTwo+", CANADA");
		getRogersIgniteTVCreditCheckPage().clkIgniteAddressLookupSubmit();
		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
		reporter.reportLogWithScreenshot("Launched the tech install page");
		getRogersTechInstallPage().clkTechInstalConsent();
		reporter.reportLogWithScreenshot("tech install details");
		getRogersTechInstallPage().clkTechInstallContinue();

		reporter.hardAssert( getRogersPaymentOptionsPage().verifyPaymentModepage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
		reporter.reportLogWithScreenshot("Launched the payment options page");
		getRogersPaymentOptionsPage().selectPaymentMode("Pre-authorized Credit Card");
		getRogersPaymentOptionsPage().switchToCreditCardIFrame();
		getRogersPaymentOptionsPage().setCreditCardNumberIFrame(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
		getRogersPaymentOptionsPage().switchOutOfCreditCardIFrame();
		getRogersPaymentOptionsPage().setCVV();
		getRogersPaymentOptionsPage().selectExpiryMonth();
		getRogersPaymentOptionsPage().selectExpiryYear();
		reporter.reportLogWithScreenshot("Payment options Details");
		getRogersPaymentOptionsPage().clkPaymentConfirm();

		reporter.hardAssert( getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");

		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_ignitelogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


