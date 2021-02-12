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

public class RogersCH_TC_024_StandaloneInternet_BuyInternetOfferTest extends BaseTestClass {

	@Test//(groups = {"RegressionCH","saiCH"})
    public void checkBuyStandAloneInternetOffer() throws InterruptedException {
    	reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the Legacy Internet");
    	getRogersHomePage().clkEasyInternet();
        reporter.hardAssert(getRogersHomePage().verifyInternetpage(),"Internet page has Launched","Internet page has not Launched");
        reporter.reportLogWithScreenshot("Launched the Internet packages page");
        getRogersHomePage().clkInternetAvailability();
        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        //getRogersHomePage().clkAddressCheck();
    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
        getRogersInternetPackageSelectionPage().clkInternetPackage();
        reporter.reportLogWithScreenshot("Launched the Internet-cart Summary page");
        //getRogersHomePage().clkOnlyInternet();
        getRogersInternetPackageSelectionPage().clkInternetBuyContinue();
        reporter.hardAssert(getRogersInternetProfilePage().verifyProfilePageSAI(),"Profile page has Launched","Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersInternetProfilePage().setEmail();
        getRogersInternetProfilePage().setFirstname();
        getRogersInternetProfilePage().setLastName();
        getRogersInternetProfilePage().setPhone();
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
       getRogersTechInstallPage().clkTechInstalConsent();
       reporter.reportLogWithScreenshot("tech install details");
       getRogersTechInstallPage().clkTechInstallContinue();
        
        reporter.hardAssert(getRogersPaymentOptionsPage().verifyPaymentModepage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
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
        
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");

        reporter.hardAssert( getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");      
        reporter.reportLogWithScreenshot("Launched the Confirmation page");    
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


