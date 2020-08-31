package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;


/**
 * This class contains the test method to validate Digital TV Dashboard for Rogers.com  
 * 
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Login with valid credentails
 *3. In Account Overview Page,
 *4. Click on the DTV Badge.
 *
 *"Expected:
1.Rogers.com landing page is opened successfully
2. Sign in popup is displayed
3. Account overview page displayed
4. Ignite RHP dashboard page should be opened"
 **/

public class RogersSS_TC_044_AO_ValidateCHaccountBadge_DigitalTV extends BaseTestClass {


	@Test
	public void checkLegacyTVDashboard () {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc44DigitalTVAccount.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc44DigitalTVAccount.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();	
		rogers_login_page.switchOutOfSignInIFrame();
		rogers_account_overview_page.selectAccount(TestDataHandler.tc44DigitalTVAccount.getAccountDetails().getBan());
		getDriver().switchTo().defaultContent();
		reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_account_overview_page.clkTVBadge();
		reporter.reportLogWithScreenshot("Clicked  the DTV badge");
		reporter.hardAssert(rogers_digital_tv_dashboard_page.verifyChangeMyPackage(),"Verifed the TV dashboard","TV dashboard Verification has failed");
		reporter.reportLogWithScreenshot("Launched the Digital TV Dashboard Page");
		common_business_flows.scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Mid page view");
		common_business_flows.scrollToBottomOfWebPage();
		reporter.reportLogWithScreenshot("Bottom View");
	}


	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
					
		}
	   	
		

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

