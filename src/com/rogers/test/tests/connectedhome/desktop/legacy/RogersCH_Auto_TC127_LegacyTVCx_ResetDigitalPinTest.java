package com.rogers.test.tests.connectedhome.desktop.legacy;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the Reset Digital pin functionality in change tv buy flow(legacy) for Rogers.com
 * TC048_CH-22538_Validate the Cancel button while user clicking Reset PIN in TV dashboard page is presented with Alert modal with radio buttons Continue&Cancel_Transaction occurs in TV dashboard_Legacy 2P_ON_EN_CH
 * @author manpreet.kaur3
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Login with valid username and password
 *3. Click on TV badge
 *4. Click on Reset Digital pin
 *5. Click on radio button and Continue on the pop up window
 *6. Verify the Success message after clicking on the continue button
 *7. Click on Reset Digital pin and click cancel on Alert box
 *8. Click on Reset Digital pin and click close icon on Alert box
 *
 **/

public class RogersCH_Auto_TC127_LegacyTVCx_ResetDigitalPinTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH"})
    public void rogersCH_Auto_TC127_LegacyTVCx_ResetDigitalPin() {
         reporter.reportLogWithScreenshot("Launched the SignIn popup");
         getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc35_digitalTVAccount.getUsername());
         getRogersLoginPage().clkContinueInBrowser();
         getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc35_digitalTVAccount.getPassword());
         reporter.reportLogWithScreenshot("Enter the account credentials");
         getRogersLoginPage().clkSignInIFrame();
         reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
         getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc35_digitalTVAccount.accountDetails.getBan());
         reporter.reportLogWithScreenshot("Launched the Account Page");
         getRogersAccountOverviewPage().clkTVBadge();
         reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");
         getRogersDigitalTVDashboardPage().clkResetDigitalPin();
         reporter.reportLogWithScreenshot("Alert window with Reset Digital will appear");
         getRogersDigitalTVDashboardPage().clkRadioDigitalPin();
         reporter.reportLogWithScreenshot("Selected radio button for reset pin");
         getRogersDigitalTVDashboardPage().clkResetContinue();
         reporter.reportLogWithScreenshot("Click continue on reset digital box");
         reporter.hardAssert(getRogersDigitalTVDashboardPage().verifySuccessIcon(), "reset box successful", "reset box not successful");
         getRogersDigitalTVDashboardPage().clkOkContinue();
         reporter.reportLogWithScreenshot("Success message verified");
         getRogersDigitalTVDashboardPage().clkResetDigitalPin();
         reporter.reportLogWithScreenshot("Alert window with Reset Digital will appear");
         getRogersDigitalTVDashboardPage().clkResetPinCancel();
         reporter.reportLogWithScreenshot("Click cancel on reset digital box");
         getRogersDigitalTVDashboardPage().clkResetDigitalPin();
         reporter.reportLogWithScreenshot("Alert window with Reset Digital will appear");
         getRogersDigitalTVDashboardPage().clkResetClose();
         reporter.reportLogWithScreenshot("Click close on reset digital box");
     }

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
