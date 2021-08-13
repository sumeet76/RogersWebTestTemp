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
		System.setProperty("PageLoadStrategy", "NONE");
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
    	getRogersHomePage().clkSignIn();
    	reporter.reportLogWithScreenshot("Sign In Overlay");
		//getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().clkForgotUsernameIframe();
		reporter.reportLogWithScreenshot("Forgot username link is clicked.");
		String strUserName = TestDataHandler.tc07.getUsername();
		String strPassword = TestDataHandler.tc07.getPassword();
		//getRogersRecoverPassOrNamePage().clkBtnUserName();
		getRegisterOrAccountRecoveryPage().setEmailAddress(strUserName);
		reporter.reportLogWithScreenshot("Set email for recover user name.");
		getRegisterOrAccountRecoveryPage().clkBtnContinue();
		String strTestingTab = getDriver().getWindowHandle();
		String strRecoveredUserName ="";
		//Go to ENS to verify email and get reset password page.		

		getEnsVerifications().getEmailVerifyPage(strUserName);
		reporter.reportLogWithScreenshot("Get recovery code");
		String recoveryCode = getRegisterOrAccountRecoveryPage().getVerificationCode();
		getDriver().switchTo().window(strTestingTab);			
		//getRegisterOrAccountRecoveryPage().switchToSetCodeIframe();
		getRegisterOrAccountRecoveryPage().setVerificationCode(recoveryCode);
		reporter.reportLogWithScreenshot("Set recovery code");
		getRegisterOrAccountRecoveryPage().clkBtnContinue();
		strRecoveredUserName= getRegisterOrAccountRecoveryPage().getRecoveryUsernameNew();
		reporter.reportLogWithScreenshot("Recovered username is : "+strRecoveredUserName.trim());			

		reporter.hardAssert(strRecoveredUserName.trim().toLowerCase().contains(strUserName.trim().toLowerCase()),
				"The recovered username is correct",
				"The recovered username is incorrect");
		getRegisterOrAccountRecoveryPage().setNewPassword(strPassword);
		getRegisterOrAccountRecoveryPage().setConfirmPassword(strPassword);
		reporter.reportLogWithScreenshot("Reset Password page");
		getRegisterOrAccountRecoveryPage().clkBtnContinue();
		//Login with recovered user name to verify 		 
		reporter.hardAssert(getRegisterOrAccountRecoveryPage().isPasswordSuccessfullySet(),
				"passowrd reset successful for recover username",
				"passowrd reset NOT successful for recover username");
		reporter.reportLogWithScreenshot("Password success page");
		getRegisterOrAccountRecoveryPage().clkGoToMyRogers();
		reporter.reportLogWithScreenshot("Go to my rogers clicked");
		getRegisterOrAccountRecoveryPage().switchToDefaultContent();
		setImplicitWait(getDriver(), 5);
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
				"Login with recovered username and password succeed.", 
				"Failed to login with recovered username and password");							
		reporter.reportLogWithScreenshot("Account overview");	
		
						
	}

}
