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
 * This class contains the test method to test Legacy Internet Offer Buy flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Browser to Shop menu and select Bundle option
 *3. Scroll down to  Bundles section and click on How to Get it button for a Bundle
 *4. Enter home address to validate the serviceability and click on Check button
 *5. Verify the customer care contact popup
 *
 **/

public class RogersCH_TC_025_StandaloneInternet_ValidateSessionExpirationModalAtCartSummaryPageAndBundlesPageTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","saiCH"})
    public void checkSessionExpirationModalatCartSummaryPage() throws InterruptedException {
        reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the Legacy Internet");
        rogers_home_page.clkEasyInternet();
        reporter.hardAssert(rogers_home_page.verifyInternetpage(),"Internet page has Launched","Internet page has not Launched");
        reporter.reportLogWithScreenshot("Launched the Internet packages page");
        rogers_home_page.clkInternetAvailability();
        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        rogers_home_page.clkAddressCheck();
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=TestDataHandler.igniteTVAccount.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.igniteTVAccount.getAccountDetails().getAddress().get("line2");
        rogers_home_page.setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        rogers_home_page.clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
        //rogers_home_page.clkOnlyInternet();
        reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
        rogers_internet_package_selection_page.clkInternetPackage();
        reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
        rogers_internet_package_selection_page.clkInternetBuyContinue();

        reporter.hardAssert(rogers_ineternet_profile_page.verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        reporter.hardAssert(rogers_ineternet_profile_page.verifySessionModel(),"Session expiry Model has Launched","Session expiry Model has not Launched");
        rogers_ineternet_profile_page.clkContinue();
        reporter.hardAssert(rogers_ineternet_profile_page.verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
        rogers_ineternet_profile_page.setEmail();
        rogers_ineternet_profile_page.setFirstname();
        rogers_ineternet_profile_page.setLastName();
        rogers_ineternet_profile_page.setPhone();
        rogers_ineternet_profile_page.clkSubmitProfile();

        reporter.hardAssert(rogers_internet_credit_check_page.verifyCreditEvalutionPage(),"Credit Evalution page has Launched","Credit Evalution page has not Launched");
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
        rogers_internet_credit_check_page.selectDOBYear();
        rogers_internet_credit_check_page.selectDOBMonth();
        rogers_internet_credit_check_page.selectDOBDay();
        reporter.reportLogWithScreenshot("Entered DOB details");
        rogers_internet_credit_check_page.selectFirstID("Driver's License");
        rogers_internet_credit_check_page.selectProvince("Ontario");
        rogers_internet_credit_check_page.selectExpiryYear();
        rogers_internet_credit_check_page.selectExpiryMonth();
        rogers_internet_credit_check_page.selectExpiryDay();
        rogers_internet_credit_check_page.setDrivingLicenseNumber("ONTARIO");
        reporter.reportLogWithScreenshot("Driving License Details");
        rogers_internet_credit_check_page.selectSecondIDOption("Passport");
        rogers_internet_credit_check_page.setPassportNumber();
        rogers_internet_credit_check_page.selectPassportExpiryYear();
        rogers_internet_credit_check_page.selectPassportExpiryMonth();
        rogers_internet_credit_check_page.selectPassportExpiryDay();
        rogers_internet_credit_check_page.clkCreditConsent();
        reporter.reportLogWithScreenshot("Passport Details");
        rogers_internet_credit_check_page.clkCreditConsentSubmit();

        reporter.hardAssert(rogers_tech_install_page.verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Launched the tech install page");
        reporter.reportLogWithScreenshot("tech install details");
        rogers_tech_install_page.clkTechInstalConsent();
        reporter.reportLogWithScreenshot("tech install details");
        rogers_tech_install_page.clkTechInstallContinue();

        reporter.hardAssert(rogers_payment_options_page.verifyPaymentModepage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
        reporter.reportLogWithScreenshot("Launched the payment options page");
        reporter.hardAssert(rogers_payment_options_page.verifySessionModel(),"Session expiry Model has Launched","Session expiry Model has not Launched");
        rogers_payment_options_page.clkContinueSession();
        reporter.hardAssert(rogers_payment_options_page.verifyPaymentModepage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
        reporter.reportLogWithScreenshot("Launched the payment options page");

        rogers_payment_options_page.selectPaymentMode("Pre-authorized Credit Card");
        rogers_payment_options_page.switchToCreditCardIFrame();
        rogers_payment_options_page.setCreditCardNumberIFrame(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
        rogers_payment_options_page.switchOutOfCreditCardIFrame();
        rogers_payment_options_page.setCVV();
        rogers_payment_options_page.selectExpiryMonth();
        rogers_payment_options_page.selectExpiryYear();
        reporter.reportLogWithScreenshot("Payment options Details");
        rogers_payment_options_page.clkPaymentConfirm();

        reporter.hardAssert(rogers_order_review_page.verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");

    }


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//legacyAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_igniteanonymous, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}
	

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


