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


public class RogersSS_TC_009_UserSetMobileNumForSMSRecovery extends BaseTestClass {
	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void validateUserSuccessfullyAddMobileNumForRecovery() {
		String strUserName = TestDataHandler.tc040609.getUsername();
		String strRecoveryNumber = TestDataHandler.tc040609.getAccountDetails().getRecoveryNumber();
    	rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(strUserName);
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc040609.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();        
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc040609.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        if (rogers_account_overview_page.verifySuccessfulLogin()) {
        	rogers_account_overview_page.clkLnkProfileNSettings();
        	reporter.reportLogWithScreenshot("Profile & Settings page.");
        	rogers_profile_and_settings_page.clkLnkSetupRecoveryNum();
    		String strTestingTab = getDriver().getWindowHandle();
    		rogers_profile_and_settings_page.switchToSetRecoveryNumIFrame();
        	rogers_profile_and_settings_page.setPhoneNumberIframe(strRecoveryNumber);
        	reporter.reportLogWithScreenshot("Recovery phone number is entered.");
        	rogers_profile_and_settings_page.clkBtnContinueIframe();
        	
    		//Will open a new tab for ENS, to get verification code from ENS
    		
    		try {

    			String strVerifyCode = ensVerifications.getVerifyCode(strRecoveryNumber);
    			getDriver().switchTo().window(strTestingTab);
    			rogers_profile_and_settings_page.switchToSetRecoveryNumIFrame();
    			rogers_profile_and_settings_page.setVerifyCodeIframe(strVerifyCode);
    			reporter.reportLogWithScreenshot("Verify code is entered.");
    			rogers_profile_and_settings_page.clkBtnVerifyMeIframe();

    			reporter.softAssert(rogers_profile_and_settings_page.verifySetRecoverySuccessConfirmationMsg(strRecoveryNumber.substring(strRecoveryNumber.length()-4)),
    					"Got recovery phone number set successfully confirm message",
    					"Got error when setting recovery phone number");
    			reporter.reportLogWithScreenshot("Confirm page of set recovery phone number.");
    			rogers_profile_and_settings_page.clkBtnContinueToMyRogersIframe();
    	        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
    	        	reporter.reportLogWithScreenshot("Select an account.");
    	            rogers_account_overview_page.selectAccount(TestDataHandler.tc040609.getAccountDetails().getBan());
    	        }
    	        rogers_profile_and_settings_page.switchOutofSetRecoveryNumIframe();
    			rogers_account_overview_page.clkLnkProfileNSettings();
    			reporter.softAssert(rogers_profile_and_settings_page.verifyRecoveryNumberSetSuccessfully(strRecoveryNumber.substring(strRecoveryNumber.length()-4)),
    					"Recovery number set successfully",
    					"Recovery number did not set successfully");
    			reporter.reportLogWithScreenshot("Profile & Settings page after set recovery phone num.");
    			
    		} catch (IOException e) {
    			reporter.reportLogWithScreenshot(e.getMessage());
    			
    		}
        }
	}

}
