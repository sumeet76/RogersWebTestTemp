package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Recover username and reset password flow updated after Rogers recovery flow re-design. 
 * 2020/10/5
 * @author ning.xue
 *
 */
public class RogersSS_TC_08_ValidateRecoverUsernameAndResetPasswordUsingTextMessageWhileEnteringTheAccountNumber extends BaseTestClass {
	
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
	public void validateRecoverUsernameAndResetPasswordUsingSMSVerificationCode() {
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	getRogersHomePage().clkSignIn(); 
    	reporter.reportLogWithScreenshot("Sign In Overlay");
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().clkForgotUsernameIframe();
		reporter.reportLogWithScreenshot("Forgot username link is clicked.");
		getRegisterOrAccountRecoveryPage().clkUseYourAccountInfoInsteadLink();
		String strAccountNumber = TestDataHandler.tc060809.getAccountDetails().getBan();
		String strPostcode =  TestDataHandler.tc060809.getAccountDetails().getPostalcode();
		String strDOB =  TestDataHandler.tc060809.getAccountDetails().getDob();
		String strPassword = TestDataHandler.tc060809.getPassword();
		getRegisterOrAccountRecoveryPage().setAccountNumber(strAccountNumber);
		getRegisterOrAccountRecoveryPage().setPostCode(strPostcode);
		getRegisterOrAccountRecoveryPage().setDOB(strDOB);
		reporter.reportLogWithScreenshot("Set Account, post code and DOB number for recover user name.");
		getRegisterOrAccountRecoveryPage().clkBtnContinue();
		//wait 3 seconds for click to effect
		setImplicitWait(getDriver(), 3);
		reporter.reportLogWithScreenshot("Continue button clicked.");
		String strTestingTab = getDriver().getWindowHandle();
		
		//Will open a new tab for ENS, to get verification code from ENS		
		try {
			reporter.reportLogWithScreenshot("ENS");
			String strPhoneNum = TestDataHandler.tc060809.getAccountDetails().getRecoveryNumber();
			String recoveryCode = getEnsVerifications().getAccountUserName(strPhoneNum);			
			getDriver().switchTo().window(strTestingTab);			
			reporter.reportLogWithScreenshot("Close the Overlay");
			getRegisterOrAccountRecoveryPage().switchToSetCodeIframe();
			getRegisterOrAccountRecoveryPage().setVerificationCode(recoveryCode);
			getRegisterOrAccountRecoveryPage().clkBtnContinue();
			String strRecoveredUserName= getRegisterOrAccountRecoveryPage().getRecoveryUsernameNew();
			reporter.reportLogWithScreenshot("Recovered username is : "+strRecoveredUserName);
			getRegisterOrAccountRecoveryPage().setNewPassword(strPassword);
			getRegisterOrAccountRecoveryPage().setConfirmPassword(strPassword);
			getRegisterOrAccountRecoveryPage().clkBtnContinue();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Login with recovered user name to verify 		 
		reporter.hardAssert(getRegisterOrAccountRecoveryPage().isPasswordSuccessfullySet(),
				"passowrd reset successful for recover username",
				"passowrd reset NOT successful for recover username");
		reporter.reportLogWithScreenshot("Password reset success page");
		getRegisterOrAccountRecoveryPage().clkGoToMyRogers();
		reporter.reportLogWithScreenshot("Go to my rogers clicked");
		getRegisterOrAccountRecoveryPage().switchToDefaultContent();
		setImplicitWait(getDriver(), 3);
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
				"username successfully recovered", "username NOT recovered successfully, please investigate");							
		reporter.reportLogWithScreenshot("Account overview");		
						
	}

}
