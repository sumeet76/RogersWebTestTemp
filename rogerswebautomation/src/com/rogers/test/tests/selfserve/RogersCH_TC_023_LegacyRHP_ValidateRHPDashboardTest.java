package com.rogers.test.tests.selfserve;

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
 * This class contains the test method to validate the Legacy home phone dashboard for Rogers.com   
 * 
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the Homephone badge.
 *
 **/

public class RogersCH_TC_023_LegacyRHP_ValidateRHPDashboardTest extends BaseTestClass {


	@Test
	public void checkLegacyRHPDashboard () {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.legacyRHP.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.legacyRHP.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		rogers_account_overview_page.selectAccount(TestDataHandler.legacyRHP.getAccountDetails().getBan());
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_account_overview_page.clkRHPBadge(TestDataHandler.ssConfig.getBrowser());
		reporter.reportLogWithScreenshot("Launched the RHP Dashboard Page");
		//reporter.hardAssert(rogers_account_overview_page.verifyRHPBanner(),"Verifed the RHP dashboard","RHP dashboard Verification has failed");
		//reporter.hardAssert(rogers_account_overview_page.verfyContactUsToManageFeaturess(),"Contact Us To Manage Featuress link has present on RHP dashboard","Contact Us To Manage Featuress link has not present on RHP dashboard");		
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

