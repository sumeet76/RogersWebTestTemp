package com.rogers.test.tests.connectedhome.sanity;

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

public class RogersCH_Auto_TC035_LegacyCx_ValidateTVDashboardTest extends BaseTestClass {


	@Test(groups = {"SanityCH", "RegressionCH", "LegacyDashboardCH", "ReleaseSanity"})
	public void rogersCH_Auto_TC035_LegacyCx_ValidateTVDashboard() {
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc37_legacyRHP.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc37_legacyRHP.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentials");
		getRogersLoginPage().clkSignInIFrame();
		/*if(getRogersLoginPage().verifyMFAScreenIsVisible()) {
			reporter.reportLogWithScreenshot("Click on Text as recovery option");
			getRogersLoginPage().clkTextToAsRecoveryOption();
			String strTestingTab = getDriver().getWindowHandle();
			//Will open a new tab for ENS, to get verification code from ENS
			reporter.reportLogWithScreenshot("ENS");
			String strPhoneNum = TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getRecoveryNumber();
			String strEnsUrl = System.getProperty("EnsUrl");
			String recoveryCode = getEnsVerifications().getTextVerificationCode(strPhoneNum, strEnsUrl);
			getDriver().switchTo().window(strTestingTab);
			reporter.reportLogWithScreenshot("Close the Overlay");
			getRegisterOrAccountRecoveryPage().setVerificationCode(recoveryCode);
			getRegisterOrAccountRecoveryPage().clkBtnContinue();
			reporter.reportLogWithScreenshot("Continue to Account Overview");
		}*/
	    getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc37_legacyRHP.accountDetails.getBan());
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersAccountOverviewPage().clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");

		if (getRogersDigitalTVDashboardPage().isPackageBlock()) {
			reporter.hardAssert(getRogersDigitalTVDashboardPage().verifyChangeMyPackage(), "Verifed the TV dashboard", "TV dashboard Verification has failed");
		} else {
			reporter.hardAssert(getRogersDigitalTVDashboardPage().verifyChatBlock(), "Verifed the TV dashboard with Support/Chat Block", "TV dashboard Verification has failed");
		}
		reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");
	}


	@BeforeMethod(alwaysRun = true)
	@Parameters({"strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_login, method);
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
