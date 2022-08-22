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
 * This class contains the test method to test the Manage channels packs functionality in TV buy flow for Rogers.com   
 * 
 * @author Saurav.Goyal
 * 
 * Test steps:
 *
 1. Launch Rogers.com
 *2. Login into the application
 *3. Click TV badge
 *4. Click Manage channels and theme packs
 *5. Click on channels
 *6. Add channel and remove it and again add it
 *7. Click confirm changes on manage channels and theme packs
 *8. Click accept the agreement and Submit the order
 **/

public class RogersCH_Auto_TC007_SolarisTVCx_ManageChannelsAndThemePack_ManageChannelsTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","IgniteTVDashboardCH"})
	public void rogersCH_Auto_TC007_SolarisTVCx_ManageChannelsAndThemePack_ManageChannels() {

		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc07_SolarisChangeTVManageChannels.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc07_SolarisChangeTVManageChannels.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");

		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc07_SolarisChangeTVManageChannels.accountDetails.getBan());
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersSolarisTVDashboardPage().clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV dash board");
		getRogersSolarisTVDashboardPage().clkManageChannelsAndThemePacks();
		 reporter.reportLogWithScreenshot("Manage Channels and Theme Packs clicked");
		getRogersSolarisTVChannelsAndThemepacksPage().addChannel();
		reporter.reportLogWithScreenshot("Channel added");
		getRogersSolarisTVChannelsAndThemepacksPage().clkConfirmChangesOnManageChannelsAndThemePacks();
		reporter.reportLogWithScreenshot("Clicked in confirm changes on manage channels and theme packs");
	
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
		getRogersOrderReviewPage().clkAcceptenceCheckboxUpdate();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmitUpdate();

        reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderSuccess(),"Update order completed","Update order Failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
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


