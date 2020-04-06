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



public class RogersSS_TC_014_BaselineUpdateEmailAddress extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validateUserUpdateUsername() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc1314.getUsername();
    	String strPassword = TestDataHandler.tc1314.getPassword();
		String strNewUsername = TestDataHandler.tc1314.getNewUsername();
    	rogers_login_page.switchToSignInIFrame();
		tryLogin(strUsername, strPassword);
        if (rogers_login_page.verifyLoginFailMsgIframe()) {
        	reporter.reportLogWithScreenshot("Login failed, update username.");
        	String tempUsername = strUsername;
        	strUsername = strNewUsername;
        	strNewUsername = tempUsername;
        	tryLogin(strUsername, strPassword);
        	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),
        						"Successfully login with new username.",
        						"Both login with original and new user name atemp failed, please investigate.");
        }
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();        
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	rogers_account_overview_page.selectAccount(TestDataHandler.tc1314.getAccountDetails().getBan());       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
		rogers_account_overview_page.clkLnkProfileNSettings();
		reporter.reportLogWithScreenshot("Profile & Settings page.");
        changeUsername(strUsername, strNewUsername);        
        if (rogers_profile_and_settings_page.verifyUsername(strNewUsername)) {
        	//Change user name back after successfully changed user name
            changeUsername(strNewUsername, strUsername);
        }
    }

    private void tryLogin(String strUsername, String strPassword) {
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        rogers_login_page.clkSignInIFrame();
    }
    
    private void changeUsername(String strUsername, String strNewUsername) {
		rogers_profile_and_settings_page.clkLnkChangeUsername();
		reporter.hardAssert(rogers_profile_and_settings_page.verifyCurrentUsername(strUsername), 
							"Change user name overlay displayed successfully.",
							"Change user name overlay didn't displayed.");
		rogers_profile_and_settings_page.setNewUsername(strNewUsername);
		reporter.reportLogWithScreenshot("New user name is entered.");
		rogers_profile_and_settings_page.clkBtnChangeUsernameContinue();		
		reporter.hardAssert(rogers_profile_and_settings_page.verifyChangeUsernameConfirmMsg(strNewUsername),
							"Change user name confirm message is displayed.",
							"Change user name flow failed to confirm.");
		reporter.reportLogWithScreenshot("Confirm change user name.");
		rogers_profile_and_settings_page.clkBtnChangeUsernameSubmit();
		//verify success message --
        reporter.hardAssert(rogers_profile_and_settings_page.verifyChangeUsernameSuccessMsg(), 
        						"Successfully changed user name.", 
        						"Change user name failed.");
        reporter.reportLogWithScreenshot("Change user name completed.");
        rogers_profile_and_settings_page.clkBtnChangeUsernameDone();
    }

}
