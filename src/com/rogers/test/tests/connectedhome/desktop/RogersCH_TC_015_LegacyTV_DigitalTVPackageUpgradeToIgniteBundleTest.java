package com.rogers.test.tests.connectedhome.desktop;

import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * This class contains the test method to verify the upgarde flow for Legacy TV to IgniteTV for Rogers.com  
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the TV badge
 *4. Click on Ignite TV under shop drowndown
 *5. Select the Bundles package and Click on Add to cart
 *6. Enter home address to validate the serviceability and click on Check Availability
 *7. Click on Continue.
 *8. Click on 'Yes I understood'button.
 *9. Click "No thanks Continue".
 *10. Click on Continue.
 *11. Select one option for   'Do you have a 4K TV'.
 *12. Click “checkout” button on cart summary page.
 *13. All the personal information is auto populated.
 *14. Click on continue button.
 *15. In Credit Evaluation page, enter the required info on Credit Check:
 *16. Click Submit.
 *17. Enter 1 or 2 numbers in Choose a phone Number textbox and click on Generate numbers.
 *18. Select any one phone number. 
 *19. Make sure Caller ID and Directory listing fields are populated.
 *20. Click on Continue.
 *21. Select a time in Choose your Date and Time. 
 *22. Enter any valid Mobile number and email address.
 *23. Click on Confirm.
 *24. Select Pre-Authorized credit card option from type of payment dropdown.
 *25. Enter valid Credit Card number details in Credit Card related fields.
 *26. Click on Continue.
 *27. Validate appropriate information is displayed in Review order page.
 *28. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox.
 *29. Order confirmation page will be displayed with the order number and validate the order details.
 *
 **/

public class RogersCH_TC_015_LegacyTV_DigitalTVPackageUpgradeToIgniteBundleTest extends BaseTestClass {

	@Test
	public void checkTVPackageUpgradeTest() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.digitalTVUpgradeToIgnite.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.digitalTVUpgradeToIgnite.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
    	if(rogers_login_page.verifyLoginFailMsgIframe())
    	{
    		reporter.reportLogFail("Login Faied",true) ;		
    	}
    	else
    	{
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        rogers_account_overview_page.selectAccount(TestDataHandler.digitalTVUpgradeToIgnite.accountDetails.getBan());
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Logged in successfully", "Login failed");
        reporter.reportLogWithScreenshot("Launched the Account Page"); 
		 rogers_home_page.clkExistingCustomerShop();
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		 rogers_home_page.clkIgniteTVExistingCustomer();
    	reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	rogers_home_page.clkNoThnx();
    	rogers_home_page.clkServiceability();
    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");    	
        rogers_home_page.clkUseThisAddress();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        rogers_igniteTV_buy_page.selectSolarisStarterPackageNew();
        reporter.reportLogWithScreenshot("Launched the information popup");
        rogers_igniteTV_buy_page.clkIUnderstand();
        reporter.reportLogWithScreenshot("Launched the port-in popup");
        rogers_igniteTV_buy_page.selectOptNewPhone();
        rogers_igniteTV_buy_page.clickOptPhone();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        rogers_igniteTV_buy_page.clkHomePhone();
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        rogers_igniteTV_buy_page.set4KTV(); 
        rogers_igniteTV_buy_page.clkCheckout();
        reporter.reportLogWithScreenshot("Launched the create profile page");
        rogers_igniteTV_profile_creation_page.clkSubmitProfile();   
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
        rogers_igniteTV_credit_check_page.selectDOBYearExistingCustomerMigration(TestDataHandler.digitalTVUpgradeToIgnite.getAccountDetails().getYear());
        rogers_igniteTV_credit_check_page.selectDOBMonthExistingCustomerMigration(TestDataHandler.digitalTVUpgradeToIgnite.getAccountDetails().getMonth());
        rogers_igniteTV_credit_check_page.selectDOBDayExistingCustomerMigration(TestDataHandler.digitalTVUpgradeToIgnite.getAccountDetails().getDate());
        reporter.reportLogWithScreenshot("Entered the DOB details");
        rogers_igniteTV_credit_check_page.clkCreditConsentSubmit();
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        rogers_home_phone_selection_page.clkContinueHomePhoneSelectionMigration(); 
         
        reporter.hardAssert(rogers_tech_install_page.verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Launched the tech install page");
        rogers_tech_install_page.selTechInstalStartDate();
        reporter.reportLogWithScreenshot("Selected Start date for Installation");
        rogers_tech_install_page.selectPreferredTimeSlot("1: AFT");
        reporter.reportLogWithScreenshot("Selected Start date for Installation slot");
        rogers_tech_install_page.selTechInstalEndDate();
        reporter.reportLogWithScreenshot("Selected End date for Installation");
        rogers_tech_install_page.selectBackupTimeSlot("1: AFT");
        reporter.reportLogWithScreenshot("Selected End date for Installation slot");
        rogers_tech_install_page.clkTechInstallSlot();
        reporter.reportLogWithScreenshot("tech install details");
        rogers_tech_install_page.setMobielNumberMigration();
        rogers_tech_install_page.setEmailMigration();        
        reporter.reportLogWithScreenshot("tech install details");
        rogers_tech_install_page.clkTechInstallContinue();
        reporter.reportLogWithScreenshot("Launched the payment options page");        
        rogers_payment_options_page.clkPaymentConfirmExistingCustomer();        
    	reporter.hardAssert(rogers_order_review_page.verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");
		
		reporter.hardAssert(rogers_order_review_page.verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        
        rogers_order_review_page.clkAcceptenceCheckboxMigration();
        reporter.reportLogWithScreenshot("Agreement details");
        rogers_order_review_page.clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");      
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
    	}
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws  IOException {
		startSession(TestDataHandler.rogersConfig.getRogersURL(),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_ignitelogin, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		//closeSession();
	}

}