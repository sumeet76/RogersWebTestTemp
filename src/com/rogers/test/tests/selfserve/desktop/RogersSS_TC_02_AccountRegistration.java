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
    	rogers_home_page.clkSignIn();    	 
    	reporter.reportLogWithScreenshot("Sign in overlay");
    	String strPassword = TestDataHandler.tc02.getPassword();
    	String strBan = TestDataHandler.tc02.getAccountDetails().getBan();
    	String strEmail = TestDataHandler.tc02.getUsername();
    	String strPostalCode = TestDataHandler.tc02.getAccountDetails().getPostalcode();  
    	String strDOB = TestDataHandler.tc02.getAccountDetails().getDob();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.clickRegister();
		reporter.reportLogWithScreenshot("Register Now");
		//=== commenting due  to changes in story DC-3077 		
		//rogers_register_page.clickRegisterNow();
		//reporter.reportLogWithScreenshot("Wireless Or Resedential Services");
		//rogers_register_page.clickWirelessOrResidentialServices();
		 
		//New chnage== Nov 11
		rogers_recover_pass_or_name.setEmailAddress(strEmail);
		reporter.reportLogWithScreenshot("Set email for recover user name.");
		rogers_recover_pass_or_name.clkBtnContinue();	
		rogers_recover_pass_or_name.setAccountNumber(strBan);
		rogers_recover_pass_or_name.setPostCode(strPostalCode);
		rogers_recover_pass_or_name.setDOB(strDOB);
		reporter.reportLogWithScreenshot("Set Account, post code and DOB number for recover user name.");
		rogers_recover_pass_or_name.clkBtnContinue();	
		reporter.reportLogWithScreenshot("Set account number and Postal code");
		//rogers_register_page.setAccountNumber(strBan);
		//rogers_register_page.setPostalCode(strPostalCode);
		//reporter.reportLogWithScreenshot("Account number and postal code ");
		//.clickContinue();
		if(!rogers_register_page.isProfileAlreadyStarted())
		{
			String strTestingTab = getDriver().getWindowHandle();
			String strRecoveredUserName ="";
			//Go to ENS to verify email and get reset password page.		

			ensVerifications.getEmailVerifyPage(strEmail);
			reporter.reportLogWithScreenshot("Get recovery code");
			String recoveryCode = rogers_recover_pass_or_name.getVerificationCodeForRecoverUsername();			
			getDriver().switchTo().window(strTestingTab);			
			rogers_recover_pass_or_name.switchToSetCodeIframe();
			rogers_recover_pass_or_name.setRecoveryCode(recoveryCode);
			reporter.reportLogWithScreenshot("Set recovery code");
			rogers_recover_pass_or_name.clkBtnContinue();
			strRecoveredUserName= rogers_recover_pass_or_name.getRecoveryUsernameNew();
			reporter.reportLogWithScreenshot("Recovered username is : "+strRecoveredUserName.trim());			

			reporter.hardAssert(strRecoveredUserName.trim().toLowerCase().contains(strEmail.trim().toLowerCase()),
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
		}else
		{
			reporter.reportLogFailWithScreenshot(" This profile is already registered");
		}
			
		
						
	}

}
