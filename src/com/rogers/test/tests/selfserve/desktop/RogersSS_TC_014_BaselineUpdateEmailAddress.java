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



public class RogersSS_TC_014_BaselineUpdateEmailAddress extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"RegressionSS","ProfileAndSettingsSS"})
    public void validateUserUpdateUsername() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc1314.getUsername();
    	String strPassword = TestDataHandler.tc1314.getPassword();
		String strNewUsername = TestDataHandler.tc1314.getNewUsername();
    	//getRogersLoginPage().switchToSignInIFrame();
		tryLogin(strUsername, strPassword);
        if (getRogersLoginPage().verifyLoginFailMsgIframe()) {
        	reporter.reportLogWithScreenshot("Login failed, update username.");
        	String tempUsername = strUsername;
        	strUsername = strNewUsername;
        	strNewUsername = tempUsername;
        	tryLogin(strUsername, strPassword);
        	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),
        						"Successfully login with new username.",
        						"Both login with original and new user name atemp failed, please investigate.");
        }
        getRogersLoginPage().clkSkipIFrame();
        //getRogersLoginPage().switchOutOfSignInIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc1314.getAccountDetails().getBan());       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
		getRogersAccountOverviewPage().clkLnkProfileNSettings();
		reporter.reportLogWithScreenshot("Profile & Settings page.");
        changeUsername(strUsername, strNewUsername);        
        if (getRogersProfileAndSettingsPage().verifyUsername(strNewUsername)) {
        	//Change user name back after successfully changed user name
            changeUsername(strNewUsername, strUsername);
        }
    }

    private void tryLogin(String strUsername, String strPassword) {
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
    }
    
    private void changeUsername(String strUsername, String strNewUsername) {
		getRogersProfileAndSettingsPage().clkLnkChangeUsername();
		reporter.hardAssert(getRogersProfileAndSettingsPage().verifyCurrentUsername(strUsername),
							"Change user name overlay displayed successfully.",
							"Change user name overlay didn't displayed.");
		getRogersProfileAndSettingsPage().setNewUsername(strNewUsername);
		reporter.reportLogWithScreenshot("New user name is entered.");
		getRogersProfileAndSettingsPage().clkBtnChangeUsernameContinue();
		reporter.hardAssert(getRogersProfileAndSettingsPage().verifyChangeUsernameConfirmMsg(strNewUsername),
							"Change user name confirm message is displayed.",
							"Change user name flow failed to confirm.");
		reporter.reportLogWithScreenshot("Confirm change user name.");
		getRogersProfileAndSettingsPage().clkBtnChangeUsernameSubmit();
		//verify success message --
        reporter.hardAssert(getRogersProfileAndSettingsPage().verifyChangeUsernameSuccessMsg(),
        						"Successfully changed user name.", 
        						"Change user name failed.");
        reporter.reportLogWithScreenshot("Change user name completed.");
        getRogersProfileAndSettingsPage().clkBtnChangeUsernameDone();
    }

}
