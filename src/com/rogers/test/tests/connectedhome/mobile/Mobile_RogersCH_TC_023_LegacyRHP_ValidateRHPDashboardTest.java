package com.rogers.test.tests.connectedhome.mobile;

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
 * This class contains the test method to validate the Legacy home phone dashboard for Rogers.com   
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

public class Mobile_RogersCH_TC_023_LegacyRHP_ValidateRHPDashboardTest extends BaseTestClass {


	@Test
	public void checkLegacyRHPDashboardMobile() {
        reporter.reportLogWithScreenshot("Home Page");
    	rogers_home_page.clkSignInMobile();    	
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.legacyRHP.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.legacyRHP.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
    	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
		reporter.hardAssert(rogers_account_overview_page.verifyLoginSuccessWelcome(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_account_overview_page.clkRHPBadgeMobile();
		reporter.reportLogWithScreenshot("Launched the RHP Dashboard Page");
		reporter.hardAssert(rogers_account_overview_page.verifyRHPBanner(),"Verifed the RHP dashboard","RHP dashboard Verification has failed");
		reporter.hardAssert(rogers_account_overview_page.verfyContactUsToManageFeaturess(),"Contact Us To Manage Featuress link has present on RHP dashboard","Contact Us To Manage Featuress link has not present on RHP dashboard");		
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.chConfig.getRogersURL(), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

