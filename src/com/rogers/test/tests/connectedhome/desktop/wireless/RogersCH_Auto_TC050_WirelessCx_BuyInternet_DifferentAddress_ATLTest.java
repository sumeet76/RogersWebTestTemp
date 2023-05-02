package com.rogers.test.tests.connectedhome.desktop.wireless;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

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
 * In the Profile page Enter the details as per the RCIS rule sheet for Medium risk class with Different address (Row 74-77) to simulate Medium Risk class scenario.Email ID and Contact number should be used different as the one with which we created the account in RCIS for address_1 to simulate failed verification. Billing address should be same as serviceable address. Click on Proceed once we fill all the details
 * In Credit evaluation page enter the same details which were used for creating Address_1 account in RCIS, also follow the RCIS rule sheet same as above to have the correct details respective to that to simulate Medium Risk Class and Click on Continue
 * Clicking on Cancel and X button should take you back to credit Eval page
 * As the Address retry is set to 2 , in the first retry enter any other address except Address_1 of the account which we created in RCIS and click on Proceed in the new modal
 * In the 2nd retry enter the same address of the account which we created in RCIS i.e Address_1 and click on Proceed
 * Select the required details in Fulfillment page to complete the E2E flow
 *
 **/

public class RogersCH_Auto_TC050_WirelessCx_BuyInternet_DifferentAddress_ATLTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","saiCH"})
    public void rogersCH_Auto_TC050_WirelessCx_BuyInternet_DifferentAddress_ATL() {
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc50_wirelessSignedInInternetBuy.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc50_wirelessSignedInInternetBuy.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentials");
		getRogersLoginPage().clkSignInIFrame();
		getEnsVerifications().setVerificationCodeCH(TestDataHandler.tc50_wirelessSignedInInternetBuy.getUsername());
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc50_wirelessSignedInInternetBuy.accountDetails.getBan());
		reporter.reportLogWithScreenshot("Launched the Account Page");

		getDriver().get(System.getProperty("QaUrl") + "/internet");
		reporter.reportLogWithScreenshot("Launched the Internet page");
		getRogersHomePage().clkInternetAvailability();
		reporter.reportLogWithScreenshot("Launched the customer availability check popup");
		String  strAddressLine1=TestDataHandler.tc50_wirelessSignedInInternetBuy.getAccountDetails().getAddress().get("line1");
		String  strAddressLine2=TestDataHandler.tc50_wirelessSignedInInternetBuy.getAccountDetails().getAddress().get("line2");
		
		getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
		getRogersHomePage().clkIgniteAddressLookupSubmit();
		reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
		getRogersInternetPackageSelectionPage().clkInternetPackage();

		reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyCartSummaryHeader(), "Cart Summary Page page has Launched", "Cart Summary Page page has not Launched");
		reporter.reportLogWithScreenshot("Launched the Internet-cart Summary page");

		getRogersInternetPackageSelectionPage().clkInternetBuyContinue();
		reporter.hardAssert(getRogersInternetProfilePage().verifyProfilePageSAI(),"Profile page has Launched","Profile page has not Launched");
		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersInternetProfilePage().clkSubmitProfile();

		reporter.hardAssert(getRogersInternetCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evalution page has Launched","Credit Evalution page has not Launched");
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		getRogersInternetCreditCheckPage().selectDOBYear();
		getRogersInternetCreditCheckPage().selectDOBMonth();
		getRogersInternetCreditCheckPage().selectDOBDay();
		reporter.reportLogWithScreenshot("Entered DOB details");
		getRogersInternetCreditCheckPage().selectFirstID("Driver's License");
		getRogersInternetCreditCheckPage().selectProvince("Ontario");
		getRogersInternetCreditCheckPage().selectExpiryYear();
		getRogersInternetCreditCheckPage().selectExpiryMonth();
		getRogersInternetCreditCheckPage().selectExpiryDay();
		getRogersInternetCreditCheckPage().setDrivingLicenseNumber("ONTARIO");
		reporter.reportLogWithScreenshot("Driving License Details");
		getRogersInternetCreditCheckPage().selectSecondIDOption("Passport");
		getRogersInternetCreditCheckPage().setPassportNumber();
		getRogersInternetCreditCheckPage().selectPassportExpiryYear();
		getRogersInternetCreditCheckPage().selectPassportExpiryMonth();
		getRogersInternetCreditCheckPage().selectPassportExpiryDay();
		getRogersInternetCreditCheckPage().clkCreditConsentSai();
		reporter.reportLogWithScreenshot("Passport Details");
		getRogersInternetCreditCheckPage().clkCreditConsentSubmit();

		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
		reporter.reportLogWithScreenshot("Launched the tech install page");
		//getRogersTechInstallPage().clkTechInstalConsent();
		getRogersTechInstallPage().clkProInstallUpgradeNo();
		reporter.reportLogWithScreenshot("tech install details");
		getRogersTechInstallPage().clkTechInstallContinueSelf();
		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallSetUp(),"SetUp page has Launched","SetUp page has not Launched");
		getRogersTechInstallPage().clkTechInstallContinue();
       /*getRogersTechInstallPage().clkTechInstalConsent();
       reporter.reportLogWithScreenshot("tech install details");
       getRogersTechInstallPage().clkTechInstallContinue();*/

		reporter.hardAssert(getRogersPaymentOptionsPage().verifyPaymentModepage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
		reporter.reportLogWithScreenshot("Launched the payment options page");
		getRogersPaymentOptionsPage().clkPaymentConfirm();

		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");
		reporter.hardAssert( getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		String ban = getRogersOrderConfirmationPage().getBAN();
		System.out.println("BAN from the portal : " + ban);
		String DbSchema = getDbConnection().getSchemaName(System.getProperty("DbEnvUrl"));
		System.out.println("SCHEMA : " + DbSchema);
		/**
		 * DB Validations in the subscriber table
		 */
		Map<Object, Object> dblists = getDbConnection().connectionMethod(System.getProperty("DbEnvUrl")).executeDBQuery("select BAN,ACCOUNT_SUB_TYPE,SYS_CREATION_DATE from " + DbSchema +".billing_account where BAN='" + ban + "'", false);
		reporter.softAssert(dblists.get("BAN").equals(ban),"Entry is updated in the billing table","BAN is not present in the billing account table");
		reporter.softAssert(dblists.get("ACCOUNT_SUB_TYPE").equals("R"),"ACCOUNT_SUB_TYPE is verified as R","Account type is not updated as R");
	}


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_login, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


