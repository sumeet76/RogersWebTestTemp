package com.rogers.test.tests.selfserve.desktop;

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



public class RogersSS_TC_092_AO_ValidateTheMessageInAccountOverviewWhenTheAccountIsInCancelledState_SE extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	/**
	 * "1. Launch Rogers.com
2. Click on Sign-in
3. Sign-in with valid credentials
4. Validate the message displayed at the top of the billing widget in the account overview page
5. Validate the message links
6. Validate the billing widget below the cancelled account message
7. Validate the subsription widget 
"	"1. Rogers.com up and running
2. Sign-in pop-up will be displayed
3. Account overview page will be displayed
4. Account cancelled message should be displayed as per mock screen
5. View Billing & Payment History and Manage profile links should be available 
6. The billing widget should be displayed as per the mock screen
7. Subscription widget or any other services widget should not be displayed for a cancelled account"
	 */
	
    @Test
    public void validateSignInAndAccountOverview() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(TestDataHandler.tc013132.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.tc013132.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        rogers_login_page.clkSignInIFrame();
        rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();

        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	rogers_account_overview_page.selectAccount(TestDataHandler.tc013132.getAccountDetails().getBan());       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Passed", "Login Failed");
    }

  

}
