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
 *
 *1. Launch Rogers.com
 *2. Browse to Shop menu and select Ignite TV option
 *3. Scroll down to Ignite TV bundlessection and select one of available Bundle, click Add to Cart
 *4. Enter home address to validate the serviceability and click on Check Availability
 *5. Click on Continue
 *6. Click "No thanks Continue"
 *7. Click on Continue in Home phone add ons page
 *8. Select one option for   'Do you have a 4K TV'
 *9. Click checkout button on cart summary page.
 *10. Enter all personal information on user profile creation page - 1) Profile step
 *11. Click on Continue
 *12. In 2) Credit Evaluation page, enter the required info on Credit Check:
 *13. Click Submit
 *14. Enter 1 or 2 numbers in Choose a phone Number textbox and click on Generate numbers
 *15. Select any one phone number
 *16. Make sure Caller ID and Directory listing fields are populated
 *17. Click on Continue
 *18. Validate minicart
 *19. Select a time in Choose your Date and Time 
 *20. Enter any valid Mobile number and email address
 *21. Click on Confirm
 *22. Select Pre-Authorized credit card option from type of payment dropdown
 *23. Enter valid Credit Card number details in Credit Card related fields
 *24. Click on Continue
 *25. Validate appropriate information is displayed in Review order page
 *26. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *27. Click on Submit
 *
 **/

public class RogersCH_TC_033_IginteTV_BuyIgniteStarterBundleTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersIgniteBuyCH"})
	    public void checkBuyStarterTVOffer() {
			reporter.reportLogWithScreenshot("Launched the Easy Login Page");
	    	rogers_home_page.clkTVBundle();
	    	
	        reporter.hardAssert(rogers_home_page.verifyIgnitepage(),"Ignite page has Launched","Ignite page has not Launched");
	       	reporter.reportLogWithScreenshot("Launched the IgniteTV page");
	    	rogers_home_page.clkServiceability();
	    	reporter.reportLogWithScreenshot("Launched the customer availability check popup");
	    	rogers_home_page.clkAddressCheck();
	    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
	        String  strAddressLine1=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line1");
	        String  strAddressLine2=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line2");
	        rogers_home_page.setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
	        rogers_home_page.clkIgniteAddressLookupSubmit();
	        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		reporter.hardAssert(rogers_igniteTV_buy_page.verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
	        rogers_igniteTV_buy_page.selectSolarisStarterPackageNew();

		reporter.hardAssert(rogers_home_phone_selection_page.verifyPortInOutPage() ,"Port-InOut page has Launched","Port-InOut page has not Launched");
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		rogers_home_phone_selection_page.clkSkipforNewNumber();
		rogers_igniteTV_buy_page.clkHomePhone();
	        
	        reporter.hardAssert(rogers_igniteTV_buy_page.verify4KTV(),"4KTV radio button is availabe","4KTV radio button is not availabe");
	        reporter.reportLogWithScreenshot("Launched the cart summary page");
	        rogers_igniteTV_buy_page.set4KTV();
	        reporter.reportLogWithScreenshot("4k TV selected");
	        rogers_igniteTV_buy_page.clkCheckout();
	        
	        reporter.hardAssert(rogers_igniteTV_profile_creation_page.verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
	        reporter.reportLogWithScreenshot("Launched the create profile page");
	        rogers_igniteTV_profile_creation_page.setEmail();
	        rogers_igniteTV_profile_creation_page.setFirstname();
	        rogers_igniteTV_profile_creation_page.setLastName();
	        rogers_igniteTV_profile_creation_page.setPhone();
	        rogers_igniteTV_profile_creation_page.clkSubmitProfile();
	        
	        reporter.hardAssert(rogers_igniteTV_credit_check_page.verifyCreditEvalutionPage(),"Credit Evalution page has Launched","Credit Evalution page has not Launched");
	        reporter.reportLogWithScreenshot("Launched the credit evalution page");
	        rogers_igniteTV_credit_check_page.selectDOBYear();
	        rogers_igniteTV_credit_check_page.selectDOBMonth();
	        rogers_igniteTV_credit_check_page.selectDOBDay();
	        reporter.reportLogWithScreenshot("Entered DOB details");
	        rogers_igniteTV_credit_check_page.selectFirstID("Driver's License");
	        rogers_igniteTV_credit_check_page.selectProvince("Ontario");
	        rogers_igniteTV_credit_check_page.selectExpiryYear();
	        rogers_igniteTV_credit_check_page.selectExpiryMonth();
	        rogers_igniteTV_credit_check_page.selectExpiryDay();
	        rogers_igniteTV_credit_check_page.setDrivingLicenseNumber("ONTARIO");
	        reporter.reportLogWithScreenshot("Driving License Details");
	        rogers_igniteTV_credit_check_page.selectSecondIDOption("Passport");
	        rogers_igniteTV_credit_check_page.setPassportNumber();
	        rogers_igniteTV_credit_check_page.selectPassportExpiryYear();
	        rogers_igniteTV_credit_check_page.selectPassportExpiryMonth();
	        rogers_igniteTV_credit_check_page.selectPassportExpiryDay();
	        rogers_igniteTV_credit_check_page.clkCreditConsent();
	        reporter.reportLogWithScreenshot("Passport Details");
	       rogers_igniteTV_credit_check_page.clkCreditConsentSubmit();
	       
	      reporter.hardAssert(rogers_home_phone_selection_page.verifyPhoneNumberPage(),"Ignite page has Launched","Ignite page has not Launched");
	        reporter.reportLogWithScreenshot("Launched the home phone selection page");
	        rogers_home_phone_selection_page.clkPhoneNumberGenerator(); 
	        rogers_home_phone_selection_page.clkContinueHomePhoneSelection();
	       
	       reporter.hardAssert(rogers_tech_install_page.verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
	       reporter.reportLogWithScreenshot("Launched the tech install page");
	       //rogers_tech_install_page.clkPersonalizedInstall();
	       rogers_tech_install_page.selSelffinstallDateAndTime();
	       reporter.reportLogWithScreenshot("Launched the tech install page");
	       rogers_tech_install_page.setMobielNumber();
	       rogers_tech_install_page.clkTechInstalConsent();
	       reporter.reportLogWithScreenshot("tech install details");
	       rogers_tech_install_page.clkTechInstallContinue();
	       
	        reporter.hardAssert( rogers_payment_options_page.verifyPaymentModepage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
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
	       
	        reporter.hardAssert( rogers_order_review_page.verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
	        reporter.reportLogWithScreenshot("Launched the order review page");
	        
	        reporter.hardAssert(rogers_order_review_page.verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
	        rogers_order_review_page.clkAcceptenceCheckbox();
	        reporter.reportLogWithScreenshot("Agreement details");
	        rogers_order_review_page.clkSubmit();
	        reporter.reportLogWithScreenshot("Launched the Confirmation page");
	        reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");      
	        reporter.reportLogWithScreenshot("Launched the Confirmation page");
	    }
	   
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_igniteanonymous, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


