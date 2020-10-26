package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to validate the Legacy home phone dashboard for Rogers.com   
 * 
 * 
Steps:
1. Navigate to Rogers.com
2. Click on sign in
3. Login with valid credentials 
4.  Click on Legacy RHP badge
 *
 *
 *"Expected:
1.Rogers.com landing page is opened successfully
2. Sign in popup is displayed
3. Account overview page displayed
4. Legacy RHP dashboard page should be opened"
 **/

public class RogersSS_TC_046_AO_ValidateCHaccountBadge_LegacyRHP extends BaseTestClass {


	@Test(groups = {"RegressionSS","AccountOverviewSS"})
	public void checkLegacyRHPDashboard () throws InterruptedException {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc46LegacyRHP.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc46LegacyRHP.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		rogers_account_overview_page.selectAccount(TestDataHandler.tc46LegacyRHP.getAccountDetails().getBan());
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_account_overview_page.clkRHPBadge();
		reporter.reportLogWithScreenshot("Click RHP Badge");
		Thread.sleep(7000);
		reporter.hardAssert(rogers_solaris_rhp_dashboard_validation_page.verifyRHPBanner(),"Verifed the RHP dashboard",
				"RHP dashboard Verification has failed");		
		reporter.reportLogWithScreenshot("Launched the RHP Dashboard Page");
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

