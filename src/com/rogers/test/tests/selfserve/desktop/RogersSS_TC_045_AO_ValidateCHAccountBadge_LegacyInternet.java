package com.rogers.test.tests.selfserve.desktop;

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

public class RogersSS_TC_045_AO_ValidateCHAccountBadge_LegacyInternet extends BaseTestClass {
	
	@Test
	public void checkLegacyInternetUsage() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		 rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc45LegacyInternetAccount.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc45LegacyInternetAccount.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		 rogers_login_page.switchOutOfSignInIFrame();
		rogers_account_overview_page
				.selectAccount(TestDataHandler.tc45LegacyInternetAccount.getAccountDetails().getBan());
		reporter.reportLogWithScreenshot("Launched the Account Overview Page");
		rogers_account_overview_page.clkLegacyInternetBadge(xmlTestParameters.get("strBrowser"));
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
		rogers_account_overview_page.clkInternetPopup(xmlTestParameters.get("strBrowser"));		
		reporter.hardAssert(rogers_internet_dashboard_page.verifyInternetUsage(),"Verifed the Internet dashboard","Internet dashboard Verification has failed");
		reporter.reportLogWithScreenshot("The Internet Dashboard Page");		   
        common_business_flows.scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Mid page view");
		common_business_flows.scrollToBottomOfWebPage();
		reporter.reportLogWithScreenshot("Bottom View");

	}

	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		   xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
					
		}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

	






	
}
