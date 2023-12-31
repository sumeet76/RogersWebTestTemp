package com.rogers.test.tests.connectedhome.mobile;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to verify the Legacy Internet usage for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com.
 *2. Login with valid credentails.
 *3. In Account Overview Page, Click on the Internet Badge.
 *4. Click on the 'View Usage Details' link
 *
 **/

public class Mobile_RogersCH_Auto_TC007_LegacyCx_ValidateInternetUsageTest extends BaseTestClass {
	
    @Test(groups = {"MobileRegressionCH"})
	public void mobile_RogersCH_Auto_TC007_LegacyCx_ValidateInternetUsage() {

        reporter.reportLogWithScreenshot("Launched the SignIn popup");
		/*if (getRogersLoginPage().isOverlayContainerDisplayed()) {
			reporter.reportLogWithScreenshot("Select Continue in browser.");
			getRogersLoginPage().clkContinueInBrowser();
		}*/
		reporter.reportLogWithScreenshot("Continue in Browser Selected");
		getRogersLoginPage().setUsernameMobile(TestDataHandler.tc37_legacyRHP.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		reporter.reportLogWithScreenshot("Username entered");
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc37_legacyRHP.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
		getRogersLoginPage().clkSignInMobile();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc37_legacyRHP.accountDetails.getBan());
    	reporter.hardAssert(getRogersAccountOverviewPage().verifyLoginSuccessWelcome(),"Launched the Account Page","Account Page hasn't launched");
    	reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersAccountOverviewPage().clkLegacyInternetMobile();
		reporter.reportLogWithScreenshot("Launched the Internet Dashboard Page");
		getRogersAccountOverviewPage().clkInternetPopup();
		reporter.hardAssert(getRogersInternetDashboardPage().verifyInternetUsageMobile(),"Verified the Internet dashboard","Internet dashboard Verification has failed");
		reporter.hardAssert(getRogersInternetDashboardPage().verifyDailyUsage(),"Verified the Daily usage link","Daily Usage Verification has failed");
		reporter.hardAssert(getRogersInternetDashboardPage().verifyMonthlyUsage(),"Verified the monthly usage link","Monthly Verification has failed");
   	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

	






	
}
