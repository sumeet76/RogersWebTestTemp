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
 * This class contains the test method to verify  DigitalTV Package downgrade functionality for Rogers.com  
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Log into rogers.com url with valid credentials.
 *3. Click on TV dashboard
 *4. Click on Change package
 *5. Select a package which has price lower to the current package
 *
 **/

public class RogersCH_TC_022_DigitalTV_TVPackageDowngradeTest extends BaseTestClass {
	private String strLanguage=System.getProperty("Language");

	@Test(groups = {"SanityCH","RegressionCH","LegacyDashboardCH"})
	public void checkTVPackageDowngrade() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.digitalTVAccount.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.digitalTVAccount.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
	    rogers_account_overview_page.selectAccount(TestDataHandler.digitalTVAccount.accountDetails.getBan());
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");		
		rogers_account_overview_page.clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");
		rogers_digital_tv_dashboard_page.clkChangeMyPackage();
		if (strLanguage.equals("en"))
		{
		reporter.reportLogWithScreenshot("Launched the TV package Page");
		rogers_digital_tv_package_selection_page.selectPackage(TestDataHandler.digitalTVAccount.getAccountDetails().getDowngradePlanEn(),TestDataHandler.digitalTVAccount.getAccountDetails().getDowngradePlanFr());
		reporter.hardAssert(rogers_digital_tv_package_selection_page.verifyDowngradeWaysToBuyBox(), "Downgrade ways popup has launched", "Downgrade has failed");
		}	
		else
		{
		reporter.hardAssert(rogers_digital_tv_dashboard_page.verifyContactCustomercarePopupForFr(),"Downgrade ways popup has launched", "Downgrade has failed");
		}
		}


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}
}
