package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_07_UserValidateRecoverUsernameAndResetPasswordUsingEmailID extends BaseTestClass {
	

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
	public void userValidateRecoverUsernameAndResetPasswordUsingEmailID() {
		
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	rogers_home_page.clkSignIn(); 
    	reporter.reportLogWithScreenshot("Sign In Overlay");
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.clkForgotUsernameIframe();							
		reporter.reportLogWithScreenshot("Forgot username link is clicked.");
		String strUserName = TestDataHandler.tc07.getUsername();
		String strPassword = TestDataHandler.tc07.getPassword();
		//rogers_recover_pass_or_name.clkBtnUserName();
		rogers_recover_pass_or_name.setEmailAddress(strUserName);
		reporter.reportLogWithScreenshot("Set email for recover user name.");
		rogers_recover_pass_or_name.clkBtnContinue();		
		String strTestingTab = getDriver().getWindowHandle();
		String strRecoveredUserName ="";
		//Go to ENS to verify email and get reset password page.		

		ensVerifications.getEmailVerifyPage(strUserName);
		reporter.reportLogWithScreenshot("Get recovery code");
		String recoveryCode = rogers_recover_pass_or_name.getVerificationCodeForRecoverUsername();			
		getDriver().switchTo().window(strTestingTab);			
		rogers_recover_pass_or_name.switchToSetCodeIframe();
		rogers_recover_pass_or_name.setRecoveryCode(recoveryCode);
		reporter.reportLogWithScreenshot("Set recovery code");
		rogers_recover_pass_or_name.clkBtnContinue();
		strRecoveredUserName= rogers_recover_pass_or_name.getRecoveryUsernameNew();
		reporter.reportLogWithScreenshot("Recovered username is : "+strRecoveredUserName.trim());			

		reporter.hardAssert(strRecoveredUserName.trim().toLowerCase().contains(strUserName.trim().toLowerCase()),
				"The recovered username is correct",
				"The recovered username is incorrect");
		rogers_recover_pass_or_name.setNewPassword(strPassword);
		rogers_recover_pass_or_name.setConfirmPassword(strPassword);
		reporter.reportLogWithScreenshot("Reset Password page");
		rogers_recover_pass_or_name.clkBtnContinue();
		//Login with recovered user name to verify 		 
		reporter.hardAssert(rogers_recover_pass_or_name.isPasswordRestSuccessForRecoveredUsernameOrPwd(),
				"passowrd reset successful for recover username",
				"passowrd reset NOT successful for recover username");
		reporter.reportLogWithScreenshot("Password success page");
		rogers_recover_pass_or_name.clkGoToMyRogers();
		reporter.reportLogWithScreenshot("Go to my rogers clicked");
		rogers_recover_pass_or_name.switchToDefaultContent();	
		setImplicitWait(getDriver(), 5);
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),
				"Login with recovered username and password succeed.", 
				"Failed to login with recovered username and password");							
		reporter.reportLogWithScreenshot("Account overview");	
		
						
	}

}
