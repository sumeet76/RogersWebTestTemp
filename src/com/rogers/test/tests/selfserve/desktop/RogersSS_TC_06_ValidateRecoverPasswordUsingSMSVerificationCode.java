package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_06_ValidateRecoverPasswordUsingSMSVerificationCode extends BaseTestClass {
	

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
	public void validateRecoverUsernameUsingSMSVerificationCode() {
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	getRogersHomePage().clkSignIn();
    	reporter.reportLogWithScreenshot("Sign In Overlay");
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().clkForgotPasswordIframe();
		reporter.reportLogWithScreenshot("Forgot password link is clicked.");
		//getRogersRecoverPassOrNamePage().clkBtnPassword();
		String strUsername = TestDataHandler.tc060809.getUsername();
		String strPassword = TestDataHandler.tc060809.getPassword();
		String strAccount = TestDataHandler.tc060809.getAccountDetails().getBan();			
		getRegisterOrAccountRecoveryPage().setUsernameIFrame(strUsername);
		reporter.reportLogWithScreenshot("Set user name for password recovery");
		getRegisterOrAccountRecoveryPage().clkBtnContinue();
		//reporter.reportLogWithScreenshot("Click on Text as recovery option");
		//getRogersRecoverPassOrNamePage().clkTextToAsRecoveryOption();
		String strTestingTab = getDriver().getWindowHandle();						
		//--------------------
		try {
			reporter.reportLogWithScreenshot("ENS");
			String strPhoneNum = TestDataHandler.tc060809.getAccountDetails().getRecoveryNumber();
			String strCode = ensVerifications.getVerifyCode(strPhoneNum);			
			//switch to working test tab.
			getDriver().switchTo().window(strTestingTab);
			reporter.reportLogWithScreenshot("Set code");
			getRegisterOrAccountRecoveryPage().switchToSetCodeIframe();
			getRegisterOrAccountRecoveryPage().setVerificationCode(strCode);
			getRegisterOrAccountRecoveryPage().clkBtnContinue();
			getRegisterOrAccountRecoveryPage().setNewPassword(strPassword);
			getRegisterOrAccountRecoveryPage().setConfirmPassword(strPassword);
			getRegisterOrAccountRecoveryPage().clkBtnContinue();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Login with recovered user name to verify 		 
		reporter.hardAssert(getRegisterOrAccountRecoveryPage().isPasswordSuccessfullySet(),
				"passowrd reset successful for recover password flow",
				"passowrd reset NOT successful for recover password flow");
		reporter.reportLogWithScreenshot("Password success page");
		getRegisterOrAccountRecoveryPage().clkGoToMyRogers();
		reporter.reportLogWithScreenshot("Go to my rogers clicked");
		getRegisterOrAccountRecoveryPage().switchToDefaultContent();
		reporter.reportLogWithScreenshot("Switch to default content");
		reporter.reportLogWithScreenshot("waiting for account overview....");
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
				"username successfully recovered", "username NOT recovered successfully, please investigate");							
		reporter.reportLogWithScreenshot("Account overview");	
		
		/** ====old code
		
		reporter.reportLogWithScreenshot("Create New Password");
		String strNewPass = TestDataHandler.tc040609.getAccountDetails().getNewpassword();
		getRogersRecoverPassOrNamePage().setNewPassword(strNewPass);
		getRogersRecoverPassOrNamePage().setConfirmPassword(strNewPass);
		reporter.reportLogWithScreenshot("New passwords set");
		getRogersRecoverPassOrNamePage().clkBtnSetPassword();
		reporter.hardAssert(getRogersRecoverPassOrNamePage().isPasswordRestSuccessIsDisplayed()
				, "Password reset success message is displayed"
				, "Password reset success message not displayed");
		getRogersRecoverPassOrNamePage().clkLogInToMyAccount();
		//Login with old password:
		getRogersRecoverPassOrNamePage().switchToDefaultContent();
		getRogersLoginPage().switchToSignInIFrame();
		common_business_flows.loginApplication(strUsername, strPassword);				
		if(getRogersLoginPage().verifyLoginFailMsgIframe())
		{			
			reporter.reportLogWithScreenshot("Login attempt one not successful with old password, trying with new password:"+strNewPass);							
			getRogersLoginPage().setUsernameIFrame(strUsername);
			getRogersLoginPage().setPasswordIFrame(strNewPass);
			reporter.reportLogWithScreenshot("Login with UserName: "+strUsername+" and Password: "+strNewPass);
			getRogersLoginPage().clkSignInIFrame();
			getRogersLoginPage().clkSkipIFrame();
			getRogersLoginPage().switchOutOfSignInIFrame();
			 if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
		        	reporter.reportLogWithScreenshot("Select an account.");
		        	getRogersAccountOverviewPage().selectAccount(strAccount);
		        }
			reporter.reportLogWithScreenshot("Account overview page.");
			common_business_flows.resetPasswordBack(strNewPass, strPassword);
		}else
		{
			getRogersLoginPage().clkSkipIFrame();
			getRogersLoginPage().switchOutOfSignInIFrame();
			 if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
		        	reporter.reportLogWithScreenshot("Select an account.");
		        	getRogersAccountOverviewPage().selectAccount(strAccount);
		        }
			reporter.reportLogWithScreenshot("Account overview page.");
			reporter.reportLogFail("Its seems the reset password didnt work correctly, please investigate");
			reporter.reportLogWithScreenshot("Login successful");
			getRogersLoginPage().switchOutOfSignInIFrame();
			reporter.reportLogWithScreenshot("Account overview page");
			common_business_flows.resetPasswordBack(strNewPass, strPassword);
		}
		
		*/
	}

}
