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

public class Mobile_RogersCH_Auto_TC009_LegacyCx_ValidateRHPDashboardTest extends BaseTestClass {


    @Test(groups = {"MobileRegressionCH"})
	public void mobile_RogersCH_Auto_TC009_LegacyCx_ValidateRHPDashboard() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
		if (getRogersLoginPage().isOverlayContainerDisplayed()) {
			reporter.reportLogWithScreenshot("Select Continue in browser.");
			getRogersLoginPage().clkContinueInBrowser();
			reporter.reportLogWithScreenshot("Continue in Browser Selected");
		}

		getRogersLoginPage().setUsernameMobile(TestDataHandler.tc37_legacyRHP.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		reporter.reportLogWithScreenshot("Username entered");
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc37_legacyRHP.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInMobile();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc37_legacyRHP.accountDetails.getBan());
//		reporter.hardAssert(getRogersAccountOverviewPage().verifyLoginSuccessWelcome(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersAccountOverviewPage().clkRHPBadgeMobile();
		reporter.reportLogWithScreenshot("Launched the RHP Dashboard Page");
		reporter.hardAssert(getRogersSolarisRHPDashboardPage().verifyRHPBanner(),"Verifed the RHP dashboard","RHP dashboard Verification has failed");
		reporter.hardAssert(getRogersAccountOverviewPage().verfyContactUsToManageFeaturess(),"Contact Us To Manage Featuress link has present on RHP dashboard","Contact Us To Manage Featuress link has not present on RHP dashboard");		
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

