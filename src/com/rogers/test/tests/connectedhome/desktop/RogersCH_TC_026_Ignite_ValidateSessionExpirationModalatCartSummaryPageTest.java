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

public class RogersCH_TC_026_Ignite_ValidateSessionExpirationModalatCartSummaryPageTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","SessionExpaire"})
    public void checkSessionExpirationModalatCartSummaryPage() throws InterruptedException {
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
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
        getRogersIgniteTVBuyPage().clkHomephone();
        getRogersIgniteTVBuyPage().selectSolarisStarterPackage();

        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage() ,"Port-InOut page has Launched","Port-InOut page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersIgniteTVBuyPage().clkHomePhone();

        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is available","4KTV radio button is not available");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifySessionModel(),"Session expiry Model has Launched","Session expiry Model has not Launched");
        getRogersIgniteTVBuyPage().clkContinueSession();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is available","4KTV radio button is not available");
        reporter.reportLogWithScreenshot("Launched the cart summary page");

        getRogersIgniteTVBuyPage().set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();

        reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().setEmail();
        getRogersIgniteTVProfileCreationPage().setFirstname();
        getRogersIgniteTVProfileCreationPage().setLastName();
        getRogersIgniteTVProfileCreationPage().setPhone();
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
        getRogersIgniteTVCreditCheckPage().setDrivingLicenseNumber("ONTARIO");
        reporter.reportLogWithScreenshot("Driving License Details");
        getRogersIgniteTVCreditCheckPage().selectSecondIDOption("Passport");
        getRogersIgniteTVCreditCheckPage().setPassportNumber();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryYear();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryMonth();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryDay();
        getRogersIgniteTVCreditCheckPage().clkCreditConsent();
        reporter.reportLogWithScreenshot("Passport Details");
        getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();

        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPhoneNumberPage(),"Ignite page has Launched","Ignite page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhoneSelectionPage().clkPhoneNumberGenerator();
        getRogersHomePhoneSelectionPage().clkChosePhoneNumber();
        getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();

        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Launched the tech install page");
        getRogersTechInstallPage().selSelffinstallDateAndTime();
        reporter.reportLogWithScreenshot("Launched the tech install page");
        getRogersTechInstallPage().setMobielNumber();
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

        reporter.hardAssert(getRogersOrderReviewPage().verifySessionModel(),"Session expiry Model has Launched","Session expiry Model has not Launched");
        getRogersOrderReviewPage().clkContinueSession();

        reporter.hardAssert( getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
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


