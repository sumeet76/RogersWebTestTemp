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
 * This class contains the test method to validate Digital TV Dashboard for Rogers.com  
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Login with valid credentails
 *3. In Account Overview Page, Click on the TV Badge.
 *4. Valided
 *
 **/

public class Mobile_RogersCH_TC_019_DigitalTV_ValidateTVDashboardTest extends BaseTestClass {


	@Test
	public void checkLegacyTVDashboard () {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.digitalTVAccount.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.digitalTVAccount.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();	
		rogers_login_page.switchOutOfSignInIFrame();
		rogers_account_overview_page.selectAccount(TestDataHandler.digitalTVAccount.getAccountDetails().getBan());
		getDriver().switchTo().defaultContent();
		reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_account_overview_page.clkTVBadge(TestDataHandler.rogersConfig.getBrowser());
		reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");
		reporter.hardAssert(rogers_digital_tv_dashboard_page.verifyChangeMyPackage(),"Verifed the TV dashboard","TV dashboard Verification has failed");
		reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");
	}


	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.rogersConfig.getRogersURL(), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_legacylogin, method);
	}

	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}

