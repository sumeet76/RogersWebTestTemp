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

public class Mobile_RogersCH_Auto_TC008_LegacyCx_ValidateTVDashboardTest extends BaseTestClass {


    @Test(groups = {"MobileRegressionCH"})
	public void mobile_RogersCH_Auto_TC008_LegacyCx_ValidateTVDashboard() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
		if (getRogersLoginPage().isOverlayContainerDisplayed()) {
			reporter.reportLogWithScreenshot("Select Continue in browser.");
			getRogersLoginPage().clkContinueInBrowser();
		}
		reporter.reportLogWithScreenshot("Continue in Browser Selected");
		getRogersLoginPage().setUsernameMobile(TestDataHandler.tc43_44_digitalTVAccount.getUsername());
		getRogersLoginPage().setPasswordMobile(TestDataHandler.tc43_44_digitalTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
		reporter.hardAssert(getRogersAccountOverviewPage().verifyLoginSuccessWelcome(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersAccountOverviewPage().clkTVBadgeMobile();
		reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");
		if(getRogersDigitalTVDashboardPage().isPackageBlock()) {
			reporter.hardAssert(getRogersDigitalTVDashboardPage().verifyChangeMyPackageMobile(),"Verifed the TV dashboard","TV dashboard Verification has failed");
		} else {
			reporter.hardAssert(getRogersDigitalTVDashboardPage().verifyChatBlock(), "Verifed the TV dashboard with Support/Chat Block", "TV dashboard Verification has failed");
		}
		reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");
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

