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

import utils.FormFiller;


public class RogersSS_TC_034_Postpaid_UpdateWirelessPhoneNumber extends BaseTestClass {

	private String strAltEmail;

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
	public void validateUpdateWirelessPhoneNumber() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc013132.getUsername();
    	String strPassword = TestDataHandler.tc013132.getPassword();
    	String strBan = TestDataHandler.tc013132.getAccountDetails().getBan();
    	String strEmail = TestDataHandler.tc013132.getAccountDetails().getContactemail();
    	strAltEmail = FormFiller.generateEmail();
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(strUsername);
		getRogersLoginPage().setPasswordIFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
        
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select BAN.");
            getRogersAccountOverviewPage().selectAccount(strBan);
        }
		reporter.reportLogWithScreenshot("Account overveiew page");
    	getRogersAccountOverviewPage().clkLnkProfileNSettings();
		reporter.reportLogWithScreenshot("Profile & Settings page");
    	getRogersProfileAndSettingsPage().clkBtnContactInfomation();
    	
    	//Add Contact email, can't be the same as user name!!!
    	getRogersProfileAndSettingsPage().clkLnkAddWirelessNumber();
    	String strWirelessPhoneNumer = FormFiller.generateRandomNumber(10);
    	reporter.reportLogWithScreenshot("Set wireless number");
    	getRogersProfileAndSettingsPage().setNewWirelessNumber(strWirelessPhoneNumer);
    	
    	reporter.reportLogWithScreenshot("Click button continue");
    	getRogersProfileAndSettingsPage().clkBtnContinue();
    	reporter.reportLogWithScreenshot("Click on set code");
    	getRogersProfileAndSettingsPage().clkBtnSendCode();
    	String strTestingTab = getDriver().getWindowHandle();
		String verificationCode ="";
    	//Go to ENS to verify email and get reset password page.		
		try {
			
			verificationCode = ensVerifications.getVerifyCode(strWirelessPhoneNumer);			
			getDriver().switchTo().window(strTestingTab);						
			 						
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
		getRogersProfileAndSettingsPage().setVerificationCode(verificationCode);
		getRogersProfileAndSettingsPage().clkBtnSubmitCode();		
		reporter.hardAssert((getRogersProfileAndSettingsPage().clkBtnDoneWirelessVerification()
    			&& getRogersProfileAndSettingsPage().verifyWirelessNumber(strWirelessPhoneNumer.substring(strWirelessPhoneNumer.length()-4))),
    			"Wireless phone number was successfully set/updated",
    			"Wireless phone number failed"); 	
	}

}
