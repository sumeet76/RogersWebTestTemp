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

public class RogersCH_TC_006_02_SolarisCustomer_ManageChannelsAndThemePack_ManageChannelsTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","IgniteTVDashboardCH"})
	public void checkManageChannelsAndThemePack_ManageChannelsFlow() {  
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc06_2_SolarisChangeTVManageChannels.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc06_2_SolarisChangeTVManageChannels.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
	    rogers_account_overview_page.selectAccount(TestDataHandler.tc06_2_SolarisChangeTVManageChannels.accountDetails.getBan());
		//reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_solaris_tv_dashboard_page.clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV dash board");
		rogers_solaris_tv_dashboard_page.clkManageChannelsAndThemePacks();
		
		rogers_solaris_tv_channels_and_themepacks_page.searchChannel(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getSwapInChannelOne());
		reporter.reportLogWithScreenshot("Clicked on remove from your changes");
		rogers_solaris_tv_channels_and_themepacks_page.addChannel();
		reporter.reportLogWithScreenshot("Channel again added");
		rogers_solaris_tv_channels_and_themepacks_page.clkConfirmChangesOnManageChannelsAndThemePacks();
		reporter.reportLogWithScreenshot("Clicked in confirm changes on manage channels and theme packs");
	
		reporter.hardAssert(rogers_order_review_page.verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
		rogers_order_review_page.clkAcceptenceCheckboxUpdate();
		reporter.reportLogWithScreenshot("Agreement details");
		rogers_order_review_page.clkSubmitUpdate();
        reporter.softAssert(rogers_order_confirmation_page.verifyOrderSuccess(),"Update order completed","Update order Failed");
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

