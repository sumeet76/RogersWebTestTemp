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
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
		
	@Test(groups = {"RegressionSS","ProfileAndSettingsSS"})
	public void validateRecoverUsernameAndResetPasswordUsingSMSVerificationCode() {
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	rogers_home_page.clkSignIn(); 
    	reporter.reportLogWithScreenshot("Sign In Overlay");
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.clkForgotUsernameIframe();							
		reporter.reportLogWithScreenshot("Forgot username link is clicked.");
		rogers_recover_pass_or_name.clkUseYourAccountInfoInsteadLink();
		String strAccountNumber = TestDataHandler.tc060809.getAccountDetails().getBan();
		String strPostcode =  TestDataHandler.tc060809.getAccountDetails().getPostalcode();
		String strDOB =  TestDataHandler.tc060809.getAccountDetails().getDob();
		String strPassword = TestDataHandler.tc060809.getPassword();
		rogers_recover_pass_or_name.setAccountNumber(strAccountNumber);
		rogers_recover_pass_or_name.setPostCode(strPostcode);
		rogers_recover_pass_or_name.setDOB(strDOB);
		reporter.reportLogWithScreenshot("Set Account, post code and DOB number for recover user name.");
		rogers_recover_pass_or_name.clkBtnContinue();	
		//wait 3 seconds for click to effect
		setImplicitWait(getDriver(), 3);
		reporter.reportLogWithScreenshot("Continue button clicked.");
		String strTestingTab = getDriver().getWindowHandle();
		
		//Will open a new tab for ENS, to get verification code from ENS		
		try {
			reporter.reportLogWithScreenshot("ENS");
			String strPhoneNum = TestDataHandler.tc060809.getAccountDetails().getRecoveryNumber();
			String recoveryCode = ensVerifications.getAccountUserName(strPhoneNum);			
			getDriver().switchTo().window(strTestingTab);			
			reporter.reportLogWithScreenshot("Close the Overlay");
			rogers_recover_pass_or_name.switchToSetCodeIframe();
			rogers_recover_pass_or_name.setRecoveryCode(recoveryCode);
			rogers_recover_pass_or_name.clkBtnContinue();
			String strRecoveredUserName= rogers_recover_pass_or_name.getRecoveryUsernameNew();
			reporter.reportLogWithScreenshot("Recovered username is : "+strRecoveredUserName);
			rogers_recover_pass_or_name.setNewPassword(strPassword);
			rogers_recover_pass_or_name.setConfirmPassword(strPassword);
			rogers_recover_pass_or_name.clkBtnContinue();
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Login with recovered user name to verify 		 
		reporter.hardAssert(rogers_recover_pass_or_name.isPasswordRestSuccessForRecoveredUsernameOrPwd(),
				"passowrd reset successful for recover username",
				"passowrd reset NOT successful for recover username");
		reporter.reportLogWithScreenshot("Password reset success page");
		rogers_recover_pass_or_name.clkGoToMyRogers();
		reporter.reportLogWithScreenshot("Go to my rogers clicked");
		rogers_recover_pass_or_name.switchToDefaultContent();	
		setImplicitWait(getDriver(), 3);
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),
				"username successfully recovered", "username NOT recovered successfully, please investigate");							
		reporter.reportLogWithScreenshot("Account overview");		
						
	}

}
