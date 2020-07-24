package com.rogers.test.tests.connectedhome.desktop;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

/**
 * This class contains the test method to test the change tv package , add 4k Channels  and themes changes buy flow for Rogers.com   
 * 
 * @author Saurav.Goyal
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Login into the application
 *3. Click TV badge
 *4. Click change TV package
 *5. Select solaris TV package i.e. popular , premier
 *6. Click on change TV package 
 *7. Click Exchange later
 *8. Add channel and remove it and again add it
 *9. Click on theme pack
 *10. Add theme pack
 *11. Click continue on existing channel alert window
 *12. Click continue on theme pack
 *13. Launch the 4K inquiry popup
 *14. Launch the 4K Content popup
 *15. Click accept the agreement and Submit the order
 **/

public class RogersCH_TC_008_ExistingSolarisCustomer_ChangeTVPackageAdd4KChannelsAndThemePackTest extends BaseTestClass {

    @Test
    public void checkSolarisChangeTVPackageAdd4KChannelsAndThemePackFlow() { 
		reporter.reportLogWithScreenshot("Launched the Easy Login Page");
		rogers_home_page.clkEasyLogin();
        reporter.reportLogWithScreenshot("Launched the Home Page");
        rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.solarisChangeTVPackageAdd4KChannelsAndThemePack.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.solarisChangeTVPackageAdd4KChannelsAndThemePack.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
    	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        rogers_account_overview_page.selectAccount(TestDataHandler.solarisChangeTVPackageAdd4KChannelsAndThemePack.accountDetails.getBan());
    	reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_solaris_tv_dashboard_page.clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        rogers_solaris_tv_dashboard_page.clkChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the TV packages page");
        rogers_solaris_tv_dashboard_page.selectSolarisTVPackage(TestDataHandler.solarisChangeTVPackageAdd4KChannelsAndThemePack.accountDetails.getUpgradePlanEn(),TestDataHandler.solarisChangeTVPackageAdd4KChannelsAndThemePack.accountDetails.getUpgradePlanFr());
        rogers_solaris_tv_dashboard_page.clkPopupChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the personalize channel page");
        rogers_solaris_tv_channels_and_themepacks_page.clkExchangeLater(); 
        reporter.reportLogWithScreenshot("Launched the channels and themepacks page");
        rogers_solaris_tv_channels_and_themepacks_page.addChannel();
        reporter.reportLogWithScreenshot("Channel added");
        rogers_solaris_tv_channels_and_themepacks_page.clkThemePacks();
        reporter.reportLogWithScreenshot("Clicked on themepack tab");
        rogers_solaris_tv_channels_and_themepacks_page.addThemePacks();
        reporter.reportLogWithScreenshot("ThemePack added");
        rogers_solaris_tv_channels_and_themepacks_page.clkContinueOnExistingChannelAlertWindow();
        reporter.reportLogWithScreenshot("Clicked continue on existing channel alert window ");        
        rogers_solaris_tv_channels_and_themepacks_page.clkContinueFromThemepacks();
        reporter.reportLogWithScreenshot("Launched the 4K enquiry popup");
        rogers_solaris_tv_channels_and_themepacks_page.clkYesIHave4K();  
        reporter.reportLogWithScreenshot("Launched the 4K Content popup");
        rogers_solaris_tv_channels_and_themepacks_page.clk4KContent();
        
		reporter.hardAssert(rogers_order_review_page.verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        rogers_order_review_page.clkAcceptenceCheckboxUpdate();
        reporter.reportLogWithScreenshot("Agreement details");
        rogers_order_review_page.clkSubmitUpdate();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Update order completed","Update order Failed");
        reporter.reportLogWithScreenshot("Verified the Confirmation page");
    	}

    @BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.chConfig.getRogersURL(),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_ignitelogin, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


