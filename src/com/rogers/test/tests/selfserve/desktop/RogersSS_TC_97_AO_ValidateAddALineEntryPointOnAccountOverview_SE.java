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



public class RogersSS_TC_97_AO_ValidateAddALineEntryPointOnAccountOverview_SE extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
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
        reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
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
