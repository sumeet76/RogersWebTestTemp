package com.rogers.test.tests.selfserve;

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

import utils.FormFiller;


public class RogersSS_TC_027_UpdateVoicemailPasswordTest extends BaseTestClass {

	@Test
	public void updateVoicemailPassword() {
		String strNewPwd = FormFiller.generatePhoneNumber().substring(0, 4);
		rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc2751.getUsername();
    	String strPassword = TestDataHandler.tc2751.getPassword();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc2751.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");                       
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc2751.getAccountDetails().getCtn(); 
        String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length()-4);
        if (rogers_account_overview_page.isAccountShowInDropDown(strLast4DigitAccount)) {
            rogers_account_overview_page.clkDropDownAccount(strLast4DigitAccount);
        } else {
        	rogers_account_overview_page.clkSubMenuWirelessUsage();
        }   
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
      
        reporter.reportLogWithScreenshot("Click on Link : Update voice mail password link");
        reporter.hardAssert(rogers_wireless_dashboard_page.clickUpdateMyVoicemailPwd(),
        		"Update my voicemail password link clicked",
        		"Update My Voicemail Password' link NOT found");	
        reporter.reportLogWithScreenshot("Set the new voice mail password");
		rogers_wireless_dashboard_page.setNewVoicemailPassword(strNewPwd);
		rogers_wireless_dashboard_page.setConfirmVoicemailPassword(strNewPwd);
		rogers_wireless_dashboard_page.clickSubmitButton();
		reporter.reportLogWithScreenshot("New password submitted");
		reporter.hardAssert(rogers_wireless_dashboard_page.verifyResetVoicemailPasswordSuccess(),
				"Voicemail Password Reset Success message displayed",
				"Voicemail Password Reset Success message NOT displayed");	
		reporter.reportLogWithScreenshot("Voice Mail Password reset confirmation page");
		rogers_wireless_dashboard_page.clickResetVMPwdDoneButton();

	}

	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

}
