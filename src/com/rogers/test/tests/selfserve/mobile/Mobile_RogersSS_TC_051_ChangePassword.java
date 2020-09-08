package com.rogers.test.tests.selfserve.mobile;

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



public class Mobile_RogersSS_TC_051_ChangePassword extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validateUserChangePassword() {
    	rogers_home_page.clkSignInMobile();
    	String strUsername = TestDataHandler.tc2751.getUsername();
    	String strPassword = TestDataHandler.tc2751.getPassword();
		String strNewPassword = TestDataHandler.tc2751.getNewpassword();
		rogers_login_page.switchToSignInIFrame();
		tryLogin(strUsername, strPassword);
        //If login fail message show, change password and try login again 
        if (rogers_login_page.verifyLoginFailMsgIframe()) {
        	reporter.reportLogWithScreenshot("Login Failed, use the updated password.");
        	String tempValue = strPassword;
        	strPassword = strNewPassword;
        	strNewPassword = tempValue;
        	tryLogin(strUsername, strPassword);
        	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),
        			"Successfully login with new password.",
        			"Both login with original and new user name atemp failed, please investigate.");
        }
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	rogers_account_overview_page.selectAccount(TestDataHandler.tc2751.getAccountDetails().getBan());       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        rogers_profile_and_settings_page.clkCloseFeedbackIfAvailableMobile();
		rogers_account_overview_page.clkLnkProfileNSettingsMobile();
		reporter.reportLogWithScreenshot("Profile & Settings page.");		
		changePassword(strPassword, strNewPassword);
		reporter.reportLogWithScreenshot("Change password is done.");
        if (rogers_profile_and_settings_page.verifyUsername(strUsername)) {
        	//Change password back after successfully changed password
            changePassword(strNewPassword, strPassword);
        }
    }

    private void tryLogin(String strUsername, String strPassword) {
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        rogers_login_page.clkSignInIFrame();

    }
  
    private void changePassword(String strPassword, String strNewPassword) {
		rogers_profile_and_settings_page.clkLnkChangePassword();
		//verify the change password overlay is displayed or not
		reporter.hardAssert(rogers_profile_and_settings_page.isOverlayChangePasswordDisplayed(),
							"Change password process ready to set new password.",
							"Change password overlay didn't present.");
		rogers_profile_and_settings_page.setCurrentPassword(strPassword);
		rogers_profile_and_settings_page.setNewPassword(strNewPassword);
		rogers_profile_and_settings_page.setConfirmPassword(strNewPassword);
		reporter.reportLogWithScreenshot("New password is entered.");
		rogers_profile_and_settings_page.clkBtnChangePasswordSubmit();
		//verify success message --
        reporter.hardAssert(rogers_profile_and_settings_page.verifyChangePasswordSuccessMsg(), 
        						"Successfully changed password.", 
        						"Change password failed.");
        rogers_profile_and_settings_page.clkBtnChangePasswordDone();
    }

}
