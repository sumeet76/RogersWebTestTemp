package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

/**
 * This test case has a precondition which is the recovery number for the profile have to be set before this TC execute. 
 * Which means TC04 and TC009 should share the same data and for the first execution, we have to run TC009 before running TC04.
 * @author mirza.kamran
 *
 */
public class RogersSS_TC_04_ValidateRecoverUsernameUsingSMSVerificationCode extends BaseTestClass {
	

	private String strRecoveredUserName;
	private String strPassword;

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
	}
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test
	public void validateRecoverUsernameUsingSMSVerificationCode() {
		reporter.reportLogWithScreenshot("Rogers Launch page");
    	rogers_home_page.clkSignIn(); 
    	reporter.reportLogWithScreenshot("Sign In Overlay");
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.clkForgotPassOrNameIframe();							
		reporter.reportLogWithScreenshot("Forgot password or name is clicked.");
		rogers_recover_pass_or_name.clkBtnUserName();
		String strAccountNumber = TestDataHandler.tc040609.getAccountDetails().getBan();
		strPassword = TestDataHandler.tc040609.getPassword();
		rogers_recover_pass_or_name.setAccountNumber(strAccountNumber);
		reporter.reportLogWithScreenshot("Set email for recover user name.");
		rogers_recover_pass_or_name.clkBtnContinue();	
		reporter.reportLogWithScreenshot("Click on Text as recovery option");
		rogers_recover_pass_or_name.clkTextToAsRecoveryOption();
		String strTestingTab = getDriver().getWindowHandle();
		
		//Will open a new tab for ENS, to get verification code from ENS		
		try {
			reporter.reportLogWithScreenshot("ENS");
			String strPhoneNum = TestDataHandler.tc040609.getAccountDetails().getRecoveryNumber();
			strRecoveredUserName = ensVerifications.getAccountUserName(strPhoneNum);			
			getDriver().switchTo().window(strTestingTab);
			reporter.reportLogWithScreenshot("Close the Overlay");
			rogers_recover_pass_or_name.switchToSetCodeIframe();
			rogers_recover_pass_or_name.clkBtnCloseWeHaveTextedUserNameOverlay();			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Login with recovered user name to verify 		 
		reporter.reportLogWithScreenshot("Login Page");
		rogers_recover_pass_or_name.switchToDefaultContent();		
		common_business_flows.launchAndLoginApplication(strRecoveredUserName, strPassword, strAccountNumber);						
		reporter.reportLogWithScreenshot("Login successful");		
						
	}

}
