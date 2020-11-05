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
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().clickRegister();
		reporter.reportLogWithScreenshot("Register Now");
		//=== commenting due  to changes in story DC-3077 		
		//getRogersRegisterPage().clickRegisterNow();
		reporter.reportLogWithScreenshot("Wireless Or Resedential Services");
		getRogersRegisterPage().clickWirelessOrResidentialServices();
		reporter.reportLogWithScreenshot("Set account number and Postal code");
		getRogersRegisterPage().setAccountNumber(strBan);
		getRogersRegisterPage().setPostalCode(strPostalCode);
		reporter.reportLogWithScreenshot("Account number and postal code ");
		getRogersRegisterPage().clickContinue();
		if(!getRogersRegisterPage().isProfileAlreadyStarted())
		{
			getRogersRegisterPage().setEmail(strEmail);
			getRogersRegisterPage().setReEnterEmail(strEmail);
			reporter.reportLogWithScreenshot("Set email address");
			getRogersRegisterPage().clkContinueEmailVarification();
		}
			
		//Will open a new tab for ENS, to get verification code from ENS		
		reporter.reportLogWithScreenshot("ENS");
		ensVerifications.getEmailVerifyPage(strEmail);
		reporter.reportLogWithScreenshot("Email inbox got from ENS.");
		getRogersSetPasswordPage().clkBtnSetPasswordInEmail();
		//Another new page opened
		getRogersSetPasswordPage().switchToSetPasswordTab(3);
		getRogersSetPasswordPage().setPassword(strPassword);
		getRogersSetPasswordPage().setConfirmPassword(strPassword);
		reporter.reportLogWithScreenshot("Set password page.");
		getRogersSetPasswordPage().clkBtnSetPassword();
		reporter.hardAssert(getRogersSetPasswordPage().verifyMsgReigistrationCompleteIsDisplayed(),
				"Registration completed message displayed",
				"Registration completed message does Not displayed");
		reporter.reportLogWithScreenshot("Set password completed.");
		getRogersSetPasswordPage().clkButtonSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strEmail);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(strBan);       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
						
	}

}
