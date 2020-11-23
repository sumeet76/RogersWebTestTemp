package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_05_UserValidateRecoverPasswordUsingEmailI extends BaseTestClass {
	

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
	public void userValidateRecoverUsernameUsingEmailID() {
		
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	getRogersHomePage().clkSignIn();
    	reporter.reportLogWithScreenshot("Clicked SIgn IN");
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Switched to sign in iFrame");
		getRogersLoginPage().clkForgotPasswordIframe();							
		reporter.reportLogWithScreenshot("Forgot username link is clicked.");
		String strUserName = TestDataHandler.tc07.getUsername();
		String strPassword = TestDataHandler.tc07.getPassword();
		//getRogersRecoverPassOrNamePage().clkBtnUserName();
		String strEmail = TestDataHandler.tc07.getAccountDetails().getContactemail();
		String strBan = TestDataHandler.tc07.getAccountDetails().getBan();
		getRogersRecoverPassOrNamePage().setUsernameIFrame(strUserName);
		reporter.reportLogWithScreenshot("Set username for recover password.");
		getRogersRecoverPassOrNamePage().clkBtnContinue();
		String strTestingTab = getDriver().getWindowHandle();
		String strRecoveredUserName ="";
		//Go to ENS to verify email and get reset password page.		
		try {
			
			ensVerifications.getEmailVerifyPage(strUserName);
			String recoveryCode = getRogersRecoverPassOrNamePage().getVerificationCodeForRecoverUsername();
			getDriver().switchTo().window(strTestingTab);			
			reporter.reportLogWithScreenshot("Close the Overlay");
			getRogersRecoverPassOrNamePage().switchToSetCodeIframe();
			getRogersRecoverPassOrNamePage().setRecoveryCode(recoveryCode);
			getRogersRecoverPassOrNamePage().clkBtnContinue();
			strRecoveredUserName= getRogersRecoverPassOrNamePage().getRecoveryUsernameNew();
			reporter.reportLogWithScreenshot("Recovering password for  username : "+strRecoveredUserName.trim());			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		reporter.hardAssert(strRecoveredUserName.trim().toLowerCase().contains(strUserName.trim().toLowerCase()),
				"The username on set password overlay is correct",
				"The username on set password overlay is incorrect");
		getRogersRecoverPassOrNamePage().setNewPassword(strPassword);
		getRogersRecoverPassOrNamePage().setConfirmPassword(strPassword);
		getRogersRecoverPassOrNamePage().clkBtnContinue();
		//Login with recovered user name to verify 		 
		reporter.hardAssert(getRogersRecoverPassOrNamePage().isPasswordRestSuccessForRecoveredUsernameOrPwd(),
				"passowrd reset successful for recover username",
				"passowrd reset NOT successful for recover username");
		reporter.reportLogWithScreenshot("Password success page");
		getRogersRecoverPassOrNamePage().clkGoToMyRogers();
		reporter.reportLogWithScreenshot("Go to my rogers clicked");
		getRogersRecoverPassOrNamePage().switchToDefaultContent();
		reporter.reportLogWithScreenshot("Waiting for account overview to load...");
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
				"password successfully recovered/set", "password NOT recovered successfully, please investigate");							
		reporter.reportLogWithScreenshot("Account overview");	
		
						
	}

}
