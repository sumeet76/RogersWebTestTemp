package com.rogers.test.tests.connectedhome.desktop;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;



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

public class RogersCH_TC_003_StandAloneInternet_BuyInternetOfferTest extends BaseTestClass {

    @Test
    public void checkBuyInternetOffer() throws InterruptedException {
		reporter.reportLogWithScreenshot("Launched the Easy Login Page");
		//rogers_home_page.clkEasyLogin();
    	reporter.reportLogWithScreenshot("Launched the Home Page");
    	rogers_home_page.clkShop(); 
    	reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the Legacy Internet");
    	rogers_home_page.clkInternet();
    	reporter.reportLogWithScreenshot("Launched the Internet packages page");
    	rogers_home_page.clkInternetAvailability();
    	reporter.reportLogWithScreenshot("Launched the customer availability check popup");
    	rogers_home_page.clkAddressCheck();
    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=(String) TestDataHandler.igniteTVAccount.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.igniteTVAccount.getAccountDetails().getAddress().get("line2");
        rogers_home_page.setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        rogers_home_page.clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
        rogers_home_page.clkOnlyInternet();
        reporter.reportLogWithScreenshot("Launched the Internet-bundles page");       
        rogers_internet_package_selection_page.clkInternetPackage();
        reporter.reportLogWithScreenshot("Launched the Internet-bundles page");         
        rogers_internet_package_selection_page.clkInternetBuyContinue();
        rogers_ineternet_profile_page.verifyProfilePage();
        reporter.reportLogWithScreenshot("Launched the create profile page");
        rogers_ineternet_profile_page.setEmail();
        rogers_ineternet_profile_page.setFirstname();
        rogers_ineternet_profile_page.setLastName();
        rogers_ineternet_profile_page.setPhone();
        rogers_ineternet_profile_page.clkSubmitProfile();
        rogers_internet_credit_check_page.verifyCreditEvalutionPage();
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
       rogers_tech_install_page.verifyTechInstallPage(); 
       reporter.reportLogWithScreenshot("Launched the tech install page");
       //rogers_tech_install_page.clkPersonalizedInstall();
       rogers_tech_install_page.selSelffinstallDateAndTime();
       reporter.reportLogWithScreenshot("Launched the tech install page");
       rogers_tech_install_page.clkTechInstallSlot();
       reporter.reportLogWithScreenshot("tech install details");
       rogers_tech_install_page.setMobielNumber();
       rogers_tech_install_page.setEmail();
       rogers_tech_install_page.clkTechInstalConsent();
       reporter.reportLogWithScreenshot("tech install details");
       rogers_tech_install_page.clkTechInstallContinue();
        rogers_payment_options_page.verifyPaymentModepage();
        reporter.reportLogWithScreenshot("Launched the payment options page");
        rogers_payment_options_page.selectPaymentMode("Pre-authorized Credit Card");
        rogers_payment_options_page.switchToCreditCardIFrame();
        rogers_payment_options_page.setCreditCardNumberIFrame(TestDataHandler.rogersPaymentInfo.getCreditCardDetails().getNumber());
        rogers_payment_options_page.switchOutOfCreditCardIFrame();
        rogers_payment_options_page.setCVV();
        rogers_payment_options_page.selectExpiryMonth();
        rogers_payment_options_page.selectExpiryYear(); 
        reporter.reportLogWithScreenshot("Payment options Details");
        rogers_payment_options_page.clkPaymentConfirm();
        rogers_order_review_page.verifyAgreementPage();
        reporter.reportLogWithScreenshot("Launched the order review page");
        rogers_order_review_page.verifyAgreement();
        rogers_order_review_page.clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        rogers_order_review_page.clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");      
        reporter.reportLogWithScreenshot("Launched the Confirmation page");    
    }


	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//legacyAnonymous
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.rogersConfig.getRogersURL(),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_igniteanonymous, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}
	

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		//closeSession();
	}



}


