package com.rogers.test.tests.connectedhome.desktop;
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

public class RogersCH_TC_054_IginteTV_WirelessCRMaddressMismatchWithSGI_ValidateServiceabilityCheckTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersIgniteBuyAnonymousCH"})
    public void checkCRMaddressMismatchWithSGI_ServiceabilityTest() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc54_iginteTVWirelessCRMaddressMismatchWithSGI.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc54_iginteTVWirelessCRMaddressMismatchWithSGI.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		reporter.reportLogWithScreenshot("Skip popup");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc54_iginteTVWirelessCRMaddressMismatchWithSGI.accountDetails.getBan());
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Logged in successfully", "Login failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersHomePage().clkExistingCustomerShop();
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		getRogersHomePage().clkIgniteTVExistingCustomer();

		reporter.hardAssert(getRogersHomePage().verifyIgnitepage(),"Ignite page has Launched","Ignite page has not Launched");
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		getRogersHomePage().clkServiceability();
		reporter.reportLogWithScreenshot("Launched the customer availability check popup");
		getRogersHomePage().clkUseThisAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
		getRogersIgniteTVBuyPage().selectSolarisStarterPackageNew();

		reporter.reportLogWithScreenshot("Launched the port-in popup");

		reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is availabe","4KTV radio button is not availabe");
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().set4KTV();
		reporter.reportLogWithScreenshot("4k TV selected");
		getRogersIgniteTVBuyPage().clkCheckout();

		reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
		reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evaluation page has Launched","Credit Evaluation page has not Launched");
		reporter.reportLogWithScreenshot("Launched the credit evaluation page");
		getRogersIgniteTVCreditCheckPage().selectDOBYear();
		getRogersIgniteTVCreditCheckPage().selectDOBMonth();
		getRogersIgniteTVCreditCheckPage().selectDOBDay();
		reporter.reportLogWithScreenshot("Entered DOB details");
		getRogersIgniteTVCreditCheckPage().selectFirstID("Driver's License");
		getRogersIgniteTVCreditCheckPage().selectProvince("Ontario");
		getRogersIgniteTVCreditCheckPage().selectExpiryYear();
		getRogersIgniteTVCreditCheckPage().selectExpiryMonth();
		getRogersIgniteTVCreditCheckPage().selectExpiryDay();
		getRogersIgniteTVCreditCheckPage().setDrivingLicenseNumber("ON");
		reporter.reportLogWithScreenshot("Driving License Details");
		getRogersIgniteTVCreditCheckPage().selectSecondIDOption("Passport");
		getRogersIgniteTVCreditCheckPage().setPassportNumber();
		getRogersIgniteTVCreditCheckPage().selectPassportExpiryYear();
		getRogersIgniteTVCreditCheckPage().selectPassportExpiryMonth();
		getRogersIgniteTVCreditCheckPage().selectPassportExpiryDay();
		getRogersIgniteTVCreditCheckPage().clkCreditConsent();
		reporter.reportLogWithScreenshot("Passport Details");
		getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();

		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
		getRogersTechInstallPage().clkTechInstalConsent();
		reporter.reportLogWithScreenshot("tech install details");
		getRogersTechInstallPage().clkTechInstallContinue();
		getRogersPaymentOptionsPage().clkPaymentConfirm();
		reporter.reportLogWithScreenshot("Launched the order review page");
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");

		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");

		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		String ban = getRogersOrderConfirmationPage().getBAN();
		System.out.println("BAN from the portal : " + ban);
		/**
		 * DB Validations in the subscriber table
		 */

		Map<Object, Object> dblists = getDbConnection().connectionMethod(System.getProperty("DbEnvUrl"))
				.executeDBQuery("select BAN,ACCOUNT_SUB_TYPE,SYS_CREATION_DATE from billing_account where BAN='" + ban + "'", false);

		reporter.softAssert(dblists.get("BAN").equals(ban),"Entry is updated in the billing table","BAN is not present in the billing account table");
		reporter.softAssert(dblists.get("ACCOUNT_SUB_TYPE").equals("R"),"ACCOUNT_SUB_TYPE is verified as R","Account type is not updated as R");
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


