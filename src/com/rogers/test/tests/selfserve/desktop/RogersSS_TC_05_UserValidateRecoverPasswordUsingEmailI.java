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
	
	@Test(groups = {"RegressionSS","ProfileAndSettingsSS"})
	public void userValidateRecoverUsernameUsingEmailID() {
		
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	rogers_home_page.clkSignIn(); 
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.clkForgotPasswordIframe();							
		reporter.reportLogWithScreenshot("Forgot username link is clicked.");
		String strUserName = TestDataHandler.tc03.getUsername();
		String strPassword = TestDataHandler.tc03.getPassword();
		//rogers_recover_pass_or_name.clkBtnUserName();
		String strEmail = TestDataHandler.tc03.getAccountDetails().getContactemail();
		String strBan = TestDataHandler.tc03.getAccountDetails().getBan();
		rogers_recover_pass_or_name.setUsernameIFrame(strUserName);
		reporter.reportLogWithScreenshot("Set username for recover password.");
		rogers_recover_pass_or_name.clkBtnContinue();		
		String strTestingTab = getDriver().getWindowHandle();
		String strRecoveredUserName ="";
		//Go to ENS to verify email and get reset password page.		
		try {
			
			ensVerifications.getEmailVerifyPage(strUserName);
			String recoveryCode = rogers_recover_pass_or_name.getVerificationCodeForRecoverUsername();			
			getDriver().switchTo().window(strTestingTab);			
			reporter.reportLogWithScreenshot("Close the Overlay");
			rogers_recover_pass_or_name.switchToSetCodeIframe();
			rogers_recover_pass_or_name.setRecoveryCode(recoveryCode);
			rogers_recover_pass_or_name.clkBtnContinue();
			strRecoveredUserName= rogers_recover_pass_or_name.getRecoveryUsernameNew();
			reporter.reportLogWithScreenshot("Recovering password for  username : "+strRecoveredUserName.trim());			
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		reporter.hardAssert(strRecoveredUserName.trim().toLowerCase().contains(strUserName.trim().toLowerCase()),
				"The username on set password overlay is correct",
				"The username on set password overlay is incorrect");
		rogers_recover_pass_or_name.setNewPassword(strPassword);
		rogers_recover_pass_or_name.setConfirmPassword(strPassword);
		rogers_recover_pass_or_name.clkBtnContinue();
		//Login with recovered user name to verify 		 
		reporter.hardAssert(rogers_recover_pass_or_name.isPasswordRestSuccessForRecoveredUsernameOrPwd(),
				"passowrd reset successful for recover username",
				"passowrd reset NOT successful for recover username");
		reporter.reportLogWithScreenshot("Password success page");
		rogers_recover_pass_or_name.clkGoToMyRogers();
		reporter.reportLogWithScreenshot("Go to my rogers clicked");
		rogers_recover_pass_or_name.switchToDefaultContent();	
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),
				"password successfully recovered/set", "password NOT recovered successfully, please investigate");							
		reporter.reportLogWithScreenshot("Account overview");	
		
						
	}

}
