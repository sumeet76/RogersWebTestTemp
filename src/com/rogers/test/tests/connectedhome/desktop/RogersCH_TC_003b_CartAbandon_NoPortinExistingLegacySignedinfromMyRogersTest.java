package com.rogers.test.tests.connectedhome.desktop;

import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod; 
import org.testng.annotations.Optional;                     
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
 *12. Click checkout button on cart summary page.
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

public class RogersCH_TC_003b_CartAbandon_NoPortinExistingLegacySignedinfromMyRogersTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersIgniteBuyCH"})
	public void checkCartAbandonNoPortinExistingLegacySignedinfromMyRogersTest() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();     
  		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.noPortInAbondoneFlows.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.noPortInAbondoneFlows.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
	    rogers_account_overview_page.selectAccount(TestDataHandler.noPortInAbondoneFlows.accountDetails.getBan());
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
	    reporter.reportLogWithScreenshot("Launched the Account Page"); 
        rogers_home_page.clkShop(); 
        reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
        rogers_home_page.clkIgniteTVExistingCustomer();   	
     	reporter.hardAssert(rogers_home_page.verifyWelcomeback(),"Welcome back popup has Launched","Welcome back popup has not Launched");
     	reporter.reportLogWithScreenshot("Launched the Welcome back popup");
     	rogers_home_page.clkWelcomeback();   	
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        rogers_igniteTV_buy_page.clkCheckout();
        reporter.reportLogWithScreenshot("Launched the information popup");
       
        reporter.hardAssert( rogers_igniteTV_profile_creation_page.verifyImportantInformation(),"Important Information popup has Launched","Important Information popup has not Launched");
        rogers_igniteTV_profile_creation_page.clkIUnderstand();
		}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_ignitelogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}