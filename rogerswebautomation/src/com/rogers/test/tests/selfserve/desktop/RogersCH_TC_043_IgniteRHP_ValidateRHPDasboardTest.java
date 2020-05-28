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
 * This class contains the test method to validate the Solaris home phone dashboard for Rogers.com   
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the Homephone badge.
 *
 *
 *"Expected:
1.Rogers.com landing page is opened successfully
2. Sign in popup is displayed
3. Account overview page displayed
4. Ignite RHP dashboard page should be opened"
 **/


public class RogersCH_TC_043_IgniteRHP_ValidateRHPDasboardTest extends BaseTestClass {

    @Test
    public void checkSolarisRHPDasboard() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.igniteRHP.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.igniteRHP.getPassword());
 		reporter.reportLogWithScreenshot("Enter the account credentails");
 		rogers_login_page.clkSignInIFrame();
 		reporter.reportLogWithScreenshot("Skip popup");
 		rogers_login_page.clkSkipIFrame();
 		rogers_login_page.switchOutOfSignInIFrame();
        rogers_account_overview_page.selectAccount(TestDataHandler.igniteRHP.accountDetails.getBan()); 
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_solaris_rhp_dashboard_validation_page.clkSolarisRHPBadge(TestDataHandler.ssConfig.getBrowser()); 
        reporter.reportLogWithScreenshot("Clicked on RHP badge");
        reporter.softAssert(rogers_solaris_rhp_dashboard_validation_page.verifyConfigureYourCurrentFeatures(),"Verification of Configure Your Current Features link is success","Verification of Configure Your Current Features link is Failed");
        reporter.softAssert(rogers_solaris_rhp_dashboard_validation_page.verfyAccessYourVoicemailSettings(),"Verification of Access Your Voicemail Settings link is success","Verification of Access Your Voicemail Settings link is successFailed");
        reporter.softAssert(rogers_solaris_rhp_dashboard_validation_page.verfyResetYourVoicemailPassword(),"Verification of Reset Your Voicemail Password link is success","Verification of Reset Your Voicemail Password link is success Failed");
        reporter.reportLogWithScreenshot("RHP Dashboard page is opened correctly");
        common_business_flows.scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Mid page view");
		common_business_flows.scrollToBottomOfWebPage();
		reporter.reportLogWithScreenshot("Bottom View");
        
    }
    
    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
   	

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


