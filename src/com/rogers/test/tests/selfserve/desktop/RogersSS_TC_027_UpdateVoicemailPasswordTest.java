package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_027_UpdateVoicemailPasswordTest extends BaseTestClass {

	@Test(groups = {"RegressionSS","ProfileAndSettingsSS"})
	public void updateVoicemailPassword() {
		String strNewPwd = FormFiller.generatePhoneNumber().substring(0, 4);
		getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc2751.getUsername();
    	String strPassword = TestDataHandler.tc2751.getPassword();
    	//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc2751.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");                       
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc2751.getAccountDetails().getCtn(); 
        String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length()-4);
        if (getRogersAccountOverviewPage().isAccountShowInDropDown(strLast4DigitAccount)) {
            getRogersAccountOverviewPage().clkDropDownAccount(strLast4DigitAccount);
        } else {
        	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
        }   
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
      
        reporter.reportLogWithScreenshot("Click on Link : Update voice mail password link");
        reporter.hardAssert(getRogersWirelessDashboardPage().clickUpdateMyVoicemailPwd(),
        		"Update my voicemail password link clicked",
        		"Update My Voicemail Password' link NOT found");	
        reporter.reportLogWithScreenshot("Set the new voice mail password");
		getRogersWirelessDashboardPage().setNewVoicemailPassword(strNewPwd);
		getRogersWirelessDashboardPage().setConfirmVoicemailPassword(strNewPwd);
		getRogersWirelessDashboardPage().clickSubmitButton();
		reporter.reportLogWithScreenshot("New password submitted");
		reporter.hardAssert(getRogersWirelessDashboardPage().verifyResetVoicemailPasswordSuccess(),
				"Voicemail Password Reset Success message displayed",
				"Voicemail Password Reset Success message NOT displayed");	
		reporter.reportLogWithScreenshot("Voice Mail Password reset confirmation page");
		getRogersWirelessDashboardPage().clickResetVMPwdDoneButton();

	}

	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

}
