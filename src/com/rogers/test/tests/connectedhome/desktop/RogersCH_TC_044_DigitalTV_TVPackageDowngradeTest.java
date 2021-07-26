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

public class RogersCH_TC_044_DigitalTV_TVPackageDowngradeTest extends BaseTestClass {
	private String strLanguage=System.getProperty("Language");

	@Test(groups = {"SanityCH","RegressionCH","LegacyDashboardCH"})
	public void checkTVPackageDowngrade() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc43_44_digitalTVAccount.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc43_44_digitalTVAccount.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    getRogersLoginPage().clkSkipIFrame();
	    getRogersLoginPage().switchOutOfSignInIFrame();
	    getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc43_44_digitalTVAccount.accountDetails.getBan());
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");		
		getRogersAccountOverviewPage().clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");
		getRogersDigitalTVDashboardPage().clkChangeMyPackage();
		if (strLanguage.equals("en"))
		{
		reporter.reportLogWithScreenshot("Launched the TV package Page");
		getRogersDigitalTVPackageSelectionPage().selectPackage(TestDataHandler.tc43_44_digitalTVAccount.getAccountDetails().getDowngradePlanEn(),TestDataHandler.tc43_44_digitalTVAccount.getAccountDetails().getDowngradePlanFr());
		reporter.hardAssert(getRogersDigitalTVPackageSelectionPage().verifyDowngradeWaysToBuyBox(), "Downgrade ways popup has launched", "Downgrade has failed");
		}	
		else
		{
		reporter.hardAssert(getRogersDigitalTVDashboardPage().verifyContactCustomercarePopupForFr(),"Downgrade ways popup has launched", "Downgrade has failed");
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
