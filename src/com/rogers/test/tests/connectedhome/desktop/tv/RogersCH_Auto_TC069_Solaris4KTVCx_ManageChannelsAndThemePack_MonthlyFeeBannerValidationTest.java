package com.rogers.test.tests.connectedhome.desktop.tv;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the Manage theme packs functionality in TV buy flow for Rogers.com   
 * 
 * @author Saurav.Goyal
 * 
 * Test steps:
 *
 1. Launch Rogers.com
 *2. Login into the application
 *3. Click TV badge
 *4. Click Manage channels and theme packs
 *5. Click on theme pack
 *6. Add theme pack and remove it and again add it
 *7. Click confirm changes on manage channels and theme packs
 *8. Click accept the agreement and Submit the order
 **/

public class RogersCH_Auto_TC069_Solaris4KTVCx_ManageChannelsAndThemePack_MonthlyFeeBannerValidationTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","IgniteTVDashboardCH"})
	 public void rogersCH_Auto_TC069_Solaris4KTVCx_ManageChannelsAndThemePack_MonthlyFeeBannerValidation() {
		 reporter.reportLogWithScreenshot("Launched the SignIn popup");
		 getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc06_SolarisChangeTVManageThemePacks.getUsername());
		 getRogersLoginPage().clkContinueInBrowser();
		 getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc06_SolarisChangeTVManageThemePacks.getPassword());
		 reporter.reportLogWithScreenshot("Enter the account credentials");
		 getRogersLoginPage().clkSignInIFrame();
		 reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
		 getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc06_SolarisChangeTVManageThemePacks.accountDetails.getBan());
		 reporter.reportLogWithScreenshot("Launched the Account Page");
		 getRogersSolarisTVDashboardPage().clkTVBadge();
		 reporter.reportLogWithScreenshot("Launched the TV dash board");
		 getRogersSolarisTVDashboardPage().clkManageChannelsAndThemePacks();
		 reporter.reportLogWithScreenshot("Clicked on Manage channels and theme packs");
		 getRogersSolarisTVDashboardPage().clkManageChannelsAndThemePacks();
		 reporter.reportLogWithScreenshot("Launched the Channels");
		 reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KChannelsAlert(), "Banner is present", "Banner is not present");
		 getRogersSolarisTVChannelsAndThemepacksPage().clkThemePacks();
		 reporter.reportLogWithScreenshot("Clicked on themepack tab");
		 reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KChannelsAlert(), "Banner is present", "Banner is not present");

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


