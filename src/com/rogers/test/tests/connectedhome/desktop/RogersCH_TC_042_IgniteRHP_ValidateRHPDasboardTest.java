package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to validate the Solaris home phone dashboard for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the Homephone badge.
 *
 **/


public class RogersCH_TC_042_IgniteRHP_ValidateRHPDasboardTest extends BaseTestClass {

	@Test(groups = {"SanityCH","RegressionCH","RhpAndRhmCH"})
    public void checkSolarisRHPDasboard() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.tc42_igniteRHP.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.tc42_igniteRHP.getPassword());
 		reporter.reportLogWithScreenshot("Enter the account credentails");
 		rogers_login_page.clkSignInIFrame();
 		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
 	    reporter.reportLogWithScreenshot("Skip popup");
 	    rogers_login_page.clkSkipIFrame();
 	    rogers_login_page.switchOutOfSignInIFrame();
 		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
 	    rogers_account_overview_page.selectAccount(TestDataHandler.tc42_igniteRHP.accountDetails.getBan());
 		reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_account_overview_page.clkRHPBadge();
        reporter.reportLogWithScreenshot("Launched the RHP Dashboard Page");        
        reporter.softAssert(rogers_solaris_rhp_dashboard_validation_page.verifyConfigureYourCurrentFeatures(),"Verification of Configure Your Current Features link is success","Verification of Configure Your Current Features link is Failed");
        reporter.softAssert(rogers_solaris_rhp_dashboard_validation_page.verfyAccessYourVoicemailSettings(),"Verification of Access Your Voicemail Settings link is success","Verification of Access Your Voicemail Settings link is successFailed");
        reporter.softAssert(rogers_solaris_rhp_dashboard_validation_page.verfyResetYourVoicemailPassword(),"Verification of Reset Your Voicemail Password link is success","Verification of Reset Your Voicemail Password link is success Failed");
    	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


