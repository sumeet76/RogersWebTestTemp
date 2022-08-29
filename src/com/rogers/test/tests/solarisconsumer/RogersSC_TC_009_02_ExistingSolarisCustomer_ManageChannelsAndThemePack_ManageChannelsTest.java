package com.rogers.test.tests.solarisconsumer;
import com.rogers.test.base.BaseTestClass;
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

public class RogersSC_TC_009_02_ExistingSolarisCustomer_ManageChannelsAndThemePack_ManageChannelsTest extends BaseTestClass {

	@Test
	public void checkManageChannelsAndThemePack_ManageChannelsFlow() {       
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc07_SolarisChangeTVManageChannels.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc07_SolarisChangeTVManageChannels.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		getRogersAccountOverviewPage().selectAccount((TestDataHandler.tc07_SolarisChangeTVManageChannels.accountDetails.getBan()));
		reporter.softAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Logged in successfully", "Login failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersSolarisTVDashboardPage().clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV dash board");
		getRogersSolarisTVDashboardPage().clkManageChannelsAndThemePacks();
		reporter.reportLogWithScreenshot("Clicked on Manage channels and theme packs");
		getRogersSolarisTVChannelsAndThemepacksPage().addChannel();
		reporter.reportLogWithScreenshot("Channel added");
		getRogersSolarisTVChannelsAndThemepacksPage().clkRemoveFromYourChanges();
		reporter.reportLogWithScreenshot("Clicked on remove from your changes");
		getRogersSolarisTVChannelsAndThemepacksPage().addChannel();
		reporter.reportLogWithScreenshot("Channel again added");
		getRogersSolarisTVChannelsAndThemepacksPage().clkConfirmChangesOnManageChannelsAndThemePacks();
		reporter.reportLogWithScreenshot("Clicked in confirm changes on manage channels and theme packs");
		getRogersOrderReviewPage().verifyAgreementPage();
		reporter.reportLogWithScreenshot("Launched the order review page");
		getRogersOrderReviewPage().verifyAgreement();
		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		getRogersOrderConfirmationPage().verifyOrderConfirmation();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Update order completed","Update order Failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,strGroupName, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


