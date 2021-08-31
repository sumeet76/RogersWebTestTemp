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
 * This class contains the test method to verify  www.rogersanyplacetv.com is opened when legacy customer clicks on channel list
 * 
 * @author dharani.up
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Log into rogers.com url with valid credentials.
 *3. Click on TV dashboard
 *4. Click on view my channels list
 *5. Validate www.rogersanyplacetv.com URL opened in new tab/page
 *
 **/

public class RogersCH_TC_097_3P_LegacyCx_TVDashBoard_MyTVPackage_ClickonChannelslistlink_Validate_RogersanyplacetvPageTest extends BaseTestClass {
	final String strLanguage=System.getProperty("Language");

	@Test(groups = {"RegressionCH","LegacyDashboardCH"})
	public void checkTVPackageUpgrade() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc45_digitalTVAccountUpgradePackage.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc45_digitalTVAccountUpgradePackage.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    getRogersLoginPage().clkSkipIFrame();
	    getRogersLoginPage().switchOutOfSignInIFrame();
	    getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc45_digitalTVAccountUpgradePackage.accountDetails.getBan());
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");		
		getRogersAccountOverviewPage().clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");
		getRogersDigitalTVDashboardPage().clkViewMyChannelsLink();
		reporter.reportLogWithScreenshot("Launched www.rogersanyplacetv.com URL in new page");
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
