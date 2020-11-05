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
    	getRogersHomePage().clkSignIn();
    	reporter.reportLogWithScreenshot("Sign In Overlay");
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().clkForgotUsernameIframe();
		reporter.reportLogWithScreenshot("Forgot username link is clicked.");
		String strUserName = TestDataHandler.tc07.getUsername();
		String strPassword = TestDataHandler.tc07.getPassword();
		//getRogersRecoverPassOrNamePage().clkBtnUserName();
		getRogersRecoverPassOrNamePage().setEmailAddress(strUserName);
		reporter.reportLogWithScreenshot("Set email for recover user name.");
		getRogersRecoverPassOrNamePage().clkBtnContinue();
		String strTestingTab = getDriver().getWindowHandle();
		String strRecoveredUserName ="";
		//Go to ENS to verify email and get reset password page.		

		ensVerifications.getEmailVerifyPage(strUserName);
		reporter.reportLogWithScreenshot("Get recovery code");
		String recoveryCode = getRogersRecoverPassOrNamePage().getVerificationCodeForRecoverUsername();
		getDriver().switchTo().window(strTestingTab);			
		getRogersRecoverPassOrNamePage().switchToSetCodeIframe();
		getRogersRecoverPassOrNamePage().setRecoveryCode(recoveryCode);
		reporter.reportLogWithScreenshot("Set recovery code");
		getRogersRecoverPassOrNamePage().clkBtnContinue();
		strRecoveredUserName= getRogersRecoverPassOrNamePage().getRecoveryUsernameNew();
		reporter.reportLogWithScreenshot("Recovered username is : "+strRecoveredUserName.trim());			

		reporter.hardAssert(strRecoveredUserName.trim().toLowerCase().contains(strUserName.trim().toLowerCase()),
				"The recovered username is correct",
				"The recovered username is incorrect");
		getRogersRecoverPassOrNamePage().setNewPassword(strPassword);
		getRogersRecoverPassOrNamePage().setConfirmPassword(strPassword);
		reporter.reportLogWithScreenshot("Reset Password page");
		getRogersRecoverPassOrNamePage().clkBtnContinue();
		//Login with recovered user name to verify 		 
		reporter.hardAssert(getRogersRecoverPassOrNamePage().isPasswordRestSuccessForRecoveredUsernameOrPwd(),
				"passowrd reset successful for recover username",
				"passowrd reset NOT successful for recover username");
		reporter.reportLogWithScreenshot("Password success page");
		getRogersRecoverPassOrNamePage().clkGoToMyRogers();
		reporter.reportLogWithScreenshot("Go to my rogers clicked");
		getRogersRecoverPassOrNamePage().switchToDefaultContent();
		setImplicitWait(getDriver(), 5);
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
				"Login with recovered username and password succeed.", 
				"Failed to login with recovered username and password");							
		reporter.reportLogWithScreenshot("Account overview");	
		
						
	}

}
