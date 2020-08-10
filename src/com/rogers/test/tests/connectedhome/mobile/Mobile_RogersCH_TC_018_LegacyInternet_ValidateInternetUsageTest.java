package com.rogers.test.tests.connectedhome.mobile;

import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * This class contains the test method to verify the Legacy Internet usage for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com.
 *2. Login with valid credentails.
 *3. In Account Overview Page, Click on the Internet Badge.
 *4. Click on the 'View Usage Details' link
 *
 **/

public class Mobile_RogersCH_TC_018_LegacyInternet_ValidateInternetUsageTest extends BaseTestClass {
	
	@Test
	public void checkLegacyInternetUsageMobile() {
		reporter.reportLogWithScreenshot("Launched the Easy Login Page");
		rogers_home_page.clkEasyLogin();
        reporter.reportLogWithScreenshot("Home Page");
    	rogers_home_page.clkSignInMobile();    	
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.legacyInternetAccount.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.legacyInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
    	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
	    rogers_account_overview_page.selectAccount(TestDataHandler.legacyInternetAccount.accountDetails.getBan());
    	reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_account_overview_page.clkLegacyInternetMobile();
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
		rogers_account_overview_page.clkInternetPopup();
		reporter.hardAssert(rogers_internet_dashboard_page.verifyInternetUsage(),"Verifed the Internet dashboard","Internet dashboard Verification has failed");
   	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.chConfig.getRogersURL(), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_legacylogin, method);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

	






	
}
