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



public class RogersSS_TC_051_ChangePassword extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"SanitySS","ProfileAndSettingsSS"})
    public void validateUserChangePassword() {

    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc2751.getUsername();
    	String strPassword = TestDataHandler.tc2751.getPassword();
		String strNewPassword = TestDataHandler.tc2751.getNewpassword();
		//getRogersLoginPage().switchToSignInIFrame();
		tryLogin(strUsername, strPassword);
        //If login fail message show, change password and try login again 
        if (getRogersLoginPage().verifyLoginFailMsgIframe()) {
        	reporter.reportLogWithScreenshot("Login Failed, use the updated password.");
        	String tempValue = strPassword;
        	strPassword = strNewPassword;
        	strNewPassword = tempValue;
        	tryLogin(strUsername, strPassword);
        	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),
        			"Successfully login with new password.",
        			"Both login with original and new user name atemp failed, please investigate.");
        }
        getRogersLoginPage().clkSkipIFrame();
        //getRogersLoginPage().switchOutOfSignInIFrame();
        //Account selection when there have multiple BAN.
//        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
//        	reporter.reportLogWithScreenshot("Select an account.");
//        	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc2751.getAccountDetails().getBan());       
//        }
        reporter.reportLogWithScreenshot("Account overview page.");
		getRogersAccountOverviewPage().clkLnkProfileNSettings();
		reporter.reportLogWithScreenshot("Profile & Settings page.");
		changePassword(strPassword, strNewPassword);
		reporter.reportLogWithScreenshot("Change password is done.");
        if (getRogersProfileAndSettingsPage().verifyUsername(strUsername)) {
        	//Change password back after successfully changed password
            changePassword(strNewPassword, strPassword);
        }
    }

    private void tryLogin(String strUsername, String strPassword) {
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();

    }
  
    private void changePassword(String strPassword, String strNewPassword) {
		getRogersProfileAndSettingsPage().clkLnkChangePassword();
		//verify the change password overlay is displayed or not
		reporter.hardAssert(getRogersProfileAndSettingsPage().isOverlayChangePasswordDisplayed(),
							"Change password process ready to set new password.",
							"Change password overlay didn't present.");
		getRogersProfileAndSettingsPage().setCurrentPassword(strPassword);
		getRogersProfileAndSettingsPage().setNewPassword(strNewPassword);
		getRogersProfileAndSettingsPage().setConfirmPassword(strNewPassword);
		reporter.reportLogWithScreenshot("New password is entered.");
		getRogersProfileAndSettingsPage().clkBtnChangePasswordSubmit();
		//verify success message --
        reporter.hardAssert(getRogersProfileAndSettingsPage().verifyChangePasswordSuccessMsg(),
        						"Successfully changed password.", 
        						"Change password failed.");
        getRogersProfileAndSettingsPage().clkBtnChangePasswordDone();
    }

}
