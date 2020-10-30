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
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.clickRegister();
		reporter.reportLogWithScreenshot("Register Now");
		//=== commenting due  to changes in story DC-3077 		
		//rogers_register_page.clickRegisterNow();
		reporter.reportLogWithScreenshot("Wireless Or Resedential Services");
		rogers_register_page.clickWirelessOrResidentialServices();
		reporter.reportLogWithScreenshot("Set account number and Postal code");
		rogers_register_page.setAccountNumber(strBan);
		rogers_register_page.setPostalCode(strPostalCode);
		reporter.reportLogWithScreenshot("Account number and postal code ");
		rogers_register_page.clickContinue();
		if(!rogers_register_page.isProfileAlreadyStarted())
		{
			rogers_register_page.setEmail(strEmail);
			rogers_register_page.setReEnterEmail(strEmail);
			reporter.reportLogWithScreenshot("Set email address");
			rogers_register_page.clkContinueEmailVarification();
		}
			
		//Will open a new tab for ENS, to get verification code from ENS		
		reporter.reportLogWithScreenshot("ENS");
		ensVerifications.getEmailVerifyPage(strEmail);
		reporter.reportLogWithScreenshot("Email inbox got from ENS.");
		rogers_set_password_page.clkBtnSetPasswordInEmail();
		//Another new page opened
		rogers_set_password_page.switchToSetPasswordTab(3);
		rogers_set_password_page.setPassword(strPassword);
		rogers_set_password_page.setConfirmPassword(strPassword);
		reporter.reportLogWithScreenshot("Set password page.");
		rogers_set_password_page.clkBtnSetPassword();
		reporter.hardAssert(rogers_set_password_page.verifyMsgReigistrationCompleteIsDisplayed(),
				"Registration completed message displayed",
				"Registration completed message does Not displayed");
		reporter.reportLogWithScreenshot("Set password completed.");
		rogers_set_password_page.clkButtonSignIn();
		rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strEmail);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        rogers_login_page.clkSignInIFrame();
        rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	rogers_account_overview_page.selectAccount(strBan);       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
						
	}

}
