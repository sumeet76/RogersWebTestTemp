package com.rogers.test.tests.connectedhome.desktop;

import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * This class contains the test method to verify  Internet Package downgrade functionality for Rogers.com  
 * 
 * @author aditya.dhingra
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet dashboard
 *4. Click on Change package
 *5. Select a package which has price lower to the current package
 *
 **/

public class RogersCH_TC_026_LegacyInternet_InternetPackageDowngradeTest extends BaseTestClass {

	
	@Test
	public void checkInternetPackageDowngrade() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.legacyInternetAccount.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.legacyInternetAccount.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
	    rogers_account_overview_page.selectAccount(TestDataHandler.legacyInternetAccount.accountDetails.getBan());
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_account_overview_page.clkLegacyInternetBadge(TestDataHandler.chConfig.getBrowser());
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
		rogers_account_overview_page.clkInternetPopup(); 
		rogers_internet_dashboard_page.clkChangeInternetPackage();
		reporter.reportLogWithScreenshot("Launched the Internet package Page");
		rogers_internet_package_selection_page.selectInternetPackage(TestDataHandler.legacyInternetAccount.getAccountDetails().getDowngradePlanEn(),TestDataHandler.legacyInternetAccount.getAccountDetails().getDowngradePlanFr(), TestDataHandler.chConfig.getLanguage());
		reporter.hardAssert(rogers_internet_package_selection_page.verifyDowngradeWaysToBuyBox(), "Downgrade ways popup has launched", "Downgrade has failed");
	}

	
	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	//login flow
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.chConfig.getRogersURL(), strBrowser,strLanguage,strGroupName, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
