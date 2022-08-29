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
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the Homephone badge.
 *
 **/


public class RogersCH_Auto_TC034_SolarisCx_ValidateRHPDasboardTest extends BaseTestClass {

	@Test(groups = {"SanityCH","RegressionCH","RhpAndRhmCH","DryRunCH"})
    public void rogersCH_Auto_TC034_SolarisCx_ValidateRHPDasboard() {

		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc34_igniteRHP.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc34_igniteRHP.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Skip popup");

		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Launched the Account Page", "Account Page hasn't launched");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc34_igniteRHP.accountDetails.getBan());
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersAccountOverviewPage().clkRHPBadge();
		reporter.reportLogWithScreenshot("Launched the RHP Dashboard Page");


		reporter.softAssert(getRogersSolarisRHPDashboardPage().verifyConfigureYourCurrentFeatures(), "Verification of Configure Your Current Features link is success", "Verification of Configure Your Current Features link is Failed");
		getRogersSolarisRHPDashboardPage().clkConfigureYourCurrentFeatures();
		reporter.reportLogWithScreenshot("Clicked on Configure Your Current Features link");

		reporter.softAssert(getRogersSolarisRHPDashboardPage().verfyAccessYourVoicemailSettings(), "Verification of Access Your Voicemail Settings link is success", "Verification of Access Your Voicemail Settings link is successFailed");
		getRogersSolarisRHPDashboardPage().clkAccessYourVoicemailSettings();
		reporter.reportLogWithScreenshot("Clicked on Access Your Voicemail Settings link");

		reporter.softAssert(getRogersSolarisRHPDashboardPage().verfyResetYourVoicemailPassword(), "Verification of Reset Your Voicemail Password link is success", "Verification of Reset Your Voicemail Password link is success Failed");
		getRogersSolarisRHPDashboardPage().clkResetYourVoicemailPassword();
		reporter.reportLogWithScreenshot("Launched the Reset Voice mail password popup");
		getRogersSolarisRHPDashboardPage().clkCancelResetVoicemailpswd();
		reporter.reportLogWithScreenshot("Closed the Reset Voice mail password popup");
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


