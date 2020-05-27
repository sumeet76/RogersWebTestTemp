package com.rogers.test.tests.selfserve.mobile;

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

public class Mobile_RogersSS_TC_001_Sanity_ValidateSignInAndAccountOverviewTest extends BaseTestClass {	
    
	// private AndroidDriver<WebElement> Driver;


	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		   xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.mobile_selfserve,method);					
		}
	   	
		
	


	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validateSignInAndAccountOverview() {    	        
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	mobile_rogers_home_page.clkSignIn();
    	mobile_rogers_login_page.switchToSignInIFrame();
    	mobile_rogers_login_page.setUsernameIFrame(TestDataHandler.tc013132.getUsername());
    	mobile_rogers_login_page.setPasswordIFrame(TestDataHandler.tc013132.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        mobile_rogers_login_page.clkSignInIFrame();
        mobile_rogers_login_page.clkSkipIFrame();
        mobile_rogers_login_page.switchOutOfSignInIFrame();

        if (mobile_rogers_account_overview_Page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	mobile_rogers_account_overview_Page.selectAccount(TestDataHandler.tc013132.getAccountDetails().getBan());       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(mobile_rogers_account_overview_Page.verifySuccessfulLogin(), "Login Passed", "Login Failed");
    }

  

}
