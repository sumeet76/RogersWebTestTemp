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
 * Launch Rogers.com
 * Click sign in in rogers homepage
 * Login with valid credentials
 * Click smart stream badge in account overview page
 * Validate hyperlinks under Support section in dashboard footer displayed with below order and redirect to the respective URL's
   1.Introducing Ignite SmartStream
   2.How to use voice commands on Ignite SmartStream
   3.How to rent or buy on Ignite SmartStream
   4.Ignite SmartStream Error Codes
   5.Go to support section
 *
 **/


public class RogersCH_Auto_TC040_IgniteSmartStreamCx_ValidateSupportSectionTest extends BaseTestClass {

	@Test(groups = {"SanityCH","RegressionCH","SmartStreamCH","DryRunCH"})
    public void rogersCH_Auto_TC040_IgniteSmartStreamCx_ValidateSupportSection() {
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc51_igniteSmartStream.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc51_igniteSmartStream.getPassword());
 		reporter.reportLogWithScreenshot("Enter the account credentails");
 		getRogersLoginPage().clkSignInIFrame();
 		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
 	    reporter.reportLogWithScreenshot("Skip popup");
 	    getRogersLoginPage().clkSkipIFrame();
 		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
 		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersAccountOverviewPage().clkSmartStream();
		reporter.hardAssert(getRogersSmartStreamDashboardPage().verifySmartStreamdashboard(),"SmartStream dashboard page","SmartStream dashboard page is not displaying");
		reporter.hardAssert(getRogersSmartStreamDashboardPage().verifyUsingVoiceCommandsLinkdisplayed(),
				"SmartStream Using Voice Commands Links displayed", "SmartStream Using Voice Commands Links not displayed correctly please investigate");
		reporter.softAssert(getRogersSmartStreamDashboardPage().verifyUsingAppsOnIgniteTvLinkdisplayed(),
				"SmartStream Using Apps On Ignite Tv Links displayed", "SmartStream Using Apps On Ignite Tv Links not displayed correctly please investigate");
		reporter.softAssert(getRogersSmartStreamDashboardPage().verifyIgniteTvPowerSaverLinkdisplayed(),
				"SmartStream Ignite Tv Power Saver Links displayed", "SmartStream Ignite Tv Power Saver Links not displayed correctly please investigate");
		reporter.softAssert( getRogersSmartStreamDashboardPage().verifyIgniteTvErrorCodesLinkdisplayed(),
				"SmartStream Ignite Tv Error Codes Links displayed", "SmartStream Ignite Tv Error Codes Links not displayed correctly please investigate");
		reporter.softAssert( getRogersSmartStreamDashboardPage().verifyGoToSupportSectionLinkdisplayed(),
				"SmartStream Go To Support Section Links displayed", "SmartStream Go To Support Section Links not displayed correctly please investigate");
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


