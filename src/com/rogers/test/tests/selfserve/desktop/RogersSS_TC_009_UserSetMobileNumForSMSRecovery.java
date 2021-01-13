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


public class RogersSS_TC_009_UserSetMobileNumForSMSRecovery extends BaseTestClass {
	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"RegressionSS","ProfileAndSettingsSS","RecoverySS"})
	public void validateUserSuccessfullyAddMobileNumForRecovery() {
		String strUserName = TestDataHandler.tc060809.getUsername();
		String strRecoveryNumber = TestDataHandler.tc060809.getAccountDetails().getRecoveryNumber();
    	getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(strUserName);
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc060809.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc060809.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        if (getRogersAccountOverviewPage().verifySuccessfulLogin()) {
        	getRogersAccountOverviewPage().clkLnkProfileNSettings();
        	reporter.reportLogWithScreenshot("Profile & Settings page.");
        	getRogersProfileAndSettingsPage().clkLnkSetupRecoveryNum();
    		String strTestingTab = getDriver().getWindowHandle();
    		getRogersProfileAndSettingsPage().switchToSetRecoveryNumIFrame();
        	getRogersProfileAndSettingsPage().setPhoneNumberIframe(strRecoveryNumber);
        	reporter.reportLogWithScreenshot("Recovery phone number is entered.");
        	getRogersProfileAndSettingsPage().clkBtnContinueIframe();
        	
    		//Will open a new tab for ENS, to get verification code from ENS
    		
			String strVerifyCode = getEnsVerifications().getVerifyCode(strRecoveryNumber);
			getDriver().switchTo().window(strTestingTab);
			getRogersProfileAndSettingsPage().switchToSetRecoveryNumIFrame();
			getRogersProfileAndSettingsPage().setVerifyCodeIframe(strVerifyCode);
			reporter.reportLogWithScreenshot("Verify code is entered.");
			getRogersProfileAndSettingsPage().clkBtnVerifyMeIframe();

			reporter.hardAssert(getRogersProfileAndSettingsPage().verifySetRecoverySuccessConfirmationMsg(strRecoveryNumber.substring(strRecoveryNumber.length()-4)),
					"Got recovery phone number set successfully confirm message",
					"Got error when setting recovery phone number");
			reporter.reportLogWithScreenshot("Confirm page of set recovery phone number.");
			getRogersProfileAndSettingsPage().clkBtnContinueToMyRogersIframe();
	        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
	        	reporter.reportLogWithScreenshot("Select an account.");
	            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc060809.getAccountDetails().getBan());
	        }
	        getRogersProfileAndSettingsPage().switchOutofSetRecoveryNumIframe();
			getRogersAccountOverviewPage().clkLnkProfileNSettings();
			reporter.softAssert(getRogersProfileAndSettingsPage().verifyRecoveryNumberSetSuccessfully(strRecoveryNumber.substring(strRecoveryNumber.length()-4)),
					"Recovery number set successfully",
					"Recovery number did not set successfully");
			reporter.reportLogWithScreenshot("Profile & Settings page after set recovery phone num.");
    			
        }
	}

}
