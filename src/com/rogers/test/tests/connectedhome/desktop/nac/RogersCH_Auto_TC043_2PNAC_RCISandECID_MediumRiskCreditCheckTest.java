package com.rogers.test.tests.connectedhome.desktop.nac;
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
 * Enter Address(Exact Address) in serviceability modal and click on check address
 * Select any Bundle and add to cart
 * Click on No I don’t have a Ignite TV and Click on Checkout
 * In the Profile page Enter the details as per the RCIS rule sheet for Medium risk class to simulate Medium Risk class scenario(Same as on file).
 * Click on Proceed once we fill all the details
 * In Credit evaluation page enter the different DOB and exact DL that was used at the time of account creation
 * Follow the RCIS rule sheet same as above to have the correct details respective to that to simulate Medium Risk Class and Click on Continue
 * Select the required details in Fulfillment page to complete the E2E flow
 * Same Address, same profile details, diff credit details
 **/

public class RogersCH_Auto_TC043_2PNAC_RCISandECID_MediumRiskCreditCheckTest extends BaseTestClass {

    @Test(groups = {"RegressionCH"})
    public void rogersCH_Auto_TC043_2PNAC_RCISandECID_MediumRiskCreditCheck() {
		getDriver().get(System.getProperty("QaUrl") + "/bundles?setprovince=ON");
		reporter.reportLogWithScreenshot("Launched the IgniteTV page for ON region");
		getRogersHomePage().clkServiceability();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");

		String strAddressLine1 = TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getAddress().get("line1");
		String strAddressLine2 = TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getAddress().get("line2");
		getRogersHomePage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
		reporter.reportLogWithScreenshot("Exact Address entered as on fido account");
		getRogersHomePage().clkIgniteAddressLookupSubmit();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(), "Bundles Page has launched", "Bundles Page has not launched");
		getRogersIgniteTVBuyPage().selectFlex20Package();
		reporter.reportLogWithScreenshot("Added to cart");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(), "4KTV radio button is availabe", "4KTV radio button is not availabe");
		getRogersIgniteTVBuyPage().set4KTVNo();
		reporter.reportLogWithScreenshot("4k TV selected");
		getRogersIgniteTVBuyPage().clkCheckout();

		reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(), "Profile page has Launched", "Profile page has not Launched");
		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersIgniteTVProfileCreationPage().setEmail(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getUsername());
		getRogersIgniteTVProfileCreationPage().setFirstname(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getFirstName());
		reporter.reportLogWithScreenshot("Entered Fuzzy first name");
		getRogersIgniteTVProfileCreationPage().setLastName(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getLastName());
		getRogersIgniteTVProfileCreationPage().setPhone(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getPhoneNumber());
		reporter.reportLogWithScreenshot("Fido wireless account details entered");
		getRogersIgniteTVProfileCreationPage().clkSubmitProfile();

		reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(), "Credit Evalution page has Launched", "Credit Evalution page has not Launched");
		reporter.reportLogWithScreenshot("Launched the credit evaluation page");
		getRogersIgniteTVCreditCheckPage().selectDOBYear();
		getRogersIgniteTVCreditCheckPage().selectDOBMonth();
		getRogersIgniteTVCreditCheckPage().selectDOBDay();
		reporter.reportLogWithScreenshot("Entered diff DOB details");
		getRogersIgniteTVCreditCheckPage().selectFirstID("Driver's License");
		getRogersIgniteTVCreditCheckPage().selectProvince("Ontario");
		/*getRogersIgniteTVCreditCheckPage().selectExpiryYear(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getYear());
		getRogersIgniteTVCreditCheckPage().selectExpiryMonth(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getMonth());
		getRogersIgniteTVCreditCheckPage().selectExpiryDay(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getDate());
		getRogersIgniteTVCreditCheckPage().setDrivingLicense(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getDrivingLicence());
		reporter.reportLogWithScreenshot("Exact Driving License Details");*/

		/*getRogersIgniteTVCreditCheckPage().selectDOBYearExistingCustomer(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getYear());
		getRogersIgniteTVCreditCheckPage().selectDOBMonthExistingCustomer(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getMonth());
		getRogersIgniteTVCreditCheckPage().selectDOBDayExistingCustomer(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getDate());
		reporter.reportLogWithScreenshot("Entered Exact DOB details");*/
		getRogersIgniteTVCreditCheckPage().selectFirstID("Driver's License");
		getRogersIgniteTVCreditCheckPage().selectProvince("Ontario");
		getRogersIgniteTVCreditCheckPage().selectExpiryYear();
		getRogersIgniteTVCreditCheckPage().selectExpiryMonth();
		getRogersIgniteTVCreditCheckPage().selectExpiryDay();
		getRogersIgniteTVCreditCheckPage().setDrivingLicenseNumber("ONTARIO");
		reporter.reportLogWithScreenshot("Diff Driving License Details");

		/*getRogersIgniteTVCreditCheckPage().selectSecondIDOption("Birth Certificate");
		getRogersIgniteTVCreditCheckPage().setBirthCertificateNumber(TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getBirthCertNumber());*/
		getRogersIgniteTVCreditCheckPage().selectSecondIDOption("Passport");
		getRogersIgniteTVCreditCheckPage().setPassportNumber();
		getRogersIgniteTVCreditCheckPage().selectPassportExpiryYear();
		getRogersIgniteTVCreditCheckPage().selectPassportExpiryMonth();
		getRogersIgniteTVCreditCheckPage().selectPassportExpiryDay();
		getRogersIgniteTVCreditCheckPage().clkCreditConsent();
		reporter.reportLogWithScreenshot("Second Id entered");
		getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
		reporter.reportLogWithScreenshot("Medium Risk details entered according to RCIS rule sheet");
		/*if (getRogersIgniteTVCreditCheckPage().verifyAddressModal()) {
			String strAddressLineOne = TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getAddressOnFile().get("line1");
			String strAddressLineTwo = TestDataHandler.tc43_rCISandECIDLowRiskMediumRiskAddressRetry.getAccountDetails().getAddressOnFile().get("line2");
			reporter.reportLogWithScreenshot("Enter the address on file");
			getRogersIgniteTVCreditCheckPage().setIgniteAddressLookupSecond(strAddressLineOne + ", " + strAddressLineTwo + ", CANADA");
			reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check Address on file");
			//getRogersIgniteTVCreditCheckPage().clkIgniteAddressLookupSecondSubmit();
		}*/
		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(), "TechInstall page has Launched", "TechInstall page has not Launched");
		reporter.reportLogWithScreenshot("Launched the tech install page");
		getRogersTechInstallPage().clkProInstallUpgradeNo();
		reporter.reportLogWithScreenshot("tech install details");
		getRogersTechInstallPage().clkTechInstallContinueSelf();
		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallSetUp(), "SetUp page has Launched", "SetUp page has not Launched");
		getRogersTechInstallPage().clkTechInstallContinue();
		reporter.hardAssert(getRogersPaymentOptionsPage().verifyPaymentModepage(), "Payment Mode page has Launched", "Payment Mode page has not Launched");
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

		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(), "Agreement page has Launched", "Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");

		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(), "Agreement has Launched", "Agreement has not Launched");
		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(), "Order has created successfully", "Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		String ban = getRogersOrderConfirmationPage().getBAN();
		System.out.println("BAN from the portal : " + ban);
		String DbSchema = getDbConnection().getSchemaName(System.getProperty("DbEnvUrl"));
		System.out.println("SCHEMA : " + DbSchema);
		/**
		 * DB Validations in the subscriber table
		 */
		Map<Object, Object> dblists = getDbConnection().connectionMethod(System.getProperty("DbEnvUrl")).executeDBQuery("select BAN,ACCOUNT_SUB_TYPE,SYS_CREATION_DATE from " + DbSchema + ".billing_account where BAN='" + ban + "'", false);
		reporter.softAssert(dblists.get("BAN").equals(ban), "Entry is updated in the billing table", "BAN is not present in the billing account table");
		reporter.softAssert(dblists.get("ACCOUNT_SUB_TYPE").equals("R"), "ACCOUNT_SUB_TYPE is verified as R", "Account type is not updated as R");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_igniteanonymous, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
			closeSession();
	}



}


