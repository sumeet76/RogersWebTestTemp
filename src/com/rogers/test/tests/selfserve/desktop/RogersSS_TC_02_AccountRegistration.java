package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_02_AccountRegistration extends BaseTestClass {
	

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"RegressionSS","ProfileAndSettingsSS","RecoverySS"})
	public void validateUserChangeContactInformationAndBillingAddress() {
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	getRogersHomePage().clkSignIn();
    	reporter.reportLogWithScreenshot("Sign in overlay");
    	String strPassword = TestDataHandler.tc02.getPassword();
    	String strBan = TestDataHandler.tc02.getAccountDetails().getBan();
    	String strEmail = TestDataHandler.tc02.getUsername();
    	String strPostalCode = TestDataHandler.tc02.getAccountDetails().getPostalcode();  
    	String strDOB = TestDataHandler.tc02.getAccountDetails().getDob();
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().clickRegister();
		reporter.reportLogWithScreenshot("Register Now");
		//=== commenting due  to changes in story DC-3077 		
		//rogers_register_page.clickRegisterNow();
		//reporter.reportLogWithScreenshot("Wireless Or Resedential Services");
		//rogers_register_page.clickWirelessOrResidentialServices();
		 
		//New changes from Nov 11 Onwards
		getRegisterOrAccountRecoveryPage().setEmailAddress(strEmail);
		reporter.reportLogWithScreenshot("Set email/username for user registartion");
		getRegisterOrAccountRecoveryPage().clkBtnContinue();	
		getRegisterOrAccountRecoveryPage().setAccountNumber(strBan);
		getRegisterOrAccountRecoveryPage().setPostCode(strPostalCode);
		getRegisterOrAccountRecoveryPage().setDOB(strDOB);
		reporter.reportLogWithScreenshot("Set Account, post code and DOB number for registration");
		getRegisterOrAccountRecoveryPage().clkBtnContinue();	
		reporter.reportLogWithScreenshot("Set account number and Postal code");
		//rogers_register_page.setAccountNumber(strBan);
		//rogers_register_page.setPostalCode(strPostalCode);
		//reporter.reportLogWithScreenshot("Account number and postal code ");
		//.clickContinue();
		if(!getRogersRegisterPage().isProfileAlreadyStarted())
		{
			String strTestingTab = getDriver().getWindowHandle();
			//Go to ENS to verify email and get reset password page.		
			getEnsVerifications().getEmailVerifyPage(strEmail);
			reporter.reportLogWithScreenshot("Get recovery code");
			String verificationCode = getRegisterOrAccountRecoveryPage().getVerificationCode();			
			getDriver().switchTo().window(strTestingTab);			
			getRegisterOrAccountRecoveryPage().switchToSetCodeIframe();
			getRegisterOrAccountRecoveryPage().setVerificationCode(verificationCode);
			reporter.reportLogWithScreenshot("Set verification code");
			getRegisterOrAccountRecoveryPage().clkBtnContinue();
			reporter.reportLogWithScreenshot("Click on continue button");
			getRegisterOrAccountRecoveryPage().setNewPassword(strPassword);
			getRegisterOrAccountRecoveryPage().setConfirmPassword(strPassword);
			reporter.reportLogWithScreenshot("Set new Password page");
			getRegisterOrAccountRecoveryPage().clkBtnContinue();
			//Login with recovered user name to verify 		 
			reporter.hardAssert(getRegisterOrAccountRecoveryPage().isPasswordSuccessfullySet(),
					"passoword successfully set",
					"passoword not set successfully");
			reporter.reportLogWithScreenshot("Password success page");
			getRegisterOrAccountRecoveryPage().clkGoToMyRogers();
			reporter.reportLogWithScreenshot("Go to my rogers clicked");
			getRegisterOrAccountRecoveryPage().switchToDefaultContent();	
			setImplicitWait(getDriver(), 5);
			reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
					"Login with new registered username and password succeed.", 
					"Failed to login with new registered username and password");							
			reporter.reportLogWithScreenshot("Account overview");	
		}else
		{
			reporter.reportLogFailWithScreenshot(" This profile is already registered");
		}
											
	}

}
