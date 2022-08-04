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

public class RogersCH_Auto_TC013_SolarisTVCx_ChangeTVPackageAdd4KChannelsAndThemePack_NL_ATLTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","TVPlanUpgardeCH"})
    public void rogersCH_Auto_TC013_SolarisTVCx_ChangeTVPackageAdd4KChannelsAndThemePack_NL_ATL() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc13_SolarisChangeTVPackageAdd4KChannelsAndThemePack.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc13_SolarisChangeTVPackageAdd4KChannelsAndThemePack.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
    	reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
    	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc13_SolarisChangeTVPackageAdd4KChannelsAndThemePack.accountDetails.getBan());
    	reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        getRogersSolarisTVDashboardPage().clkChangeTVPackageLetency();
        reporter.reportLogWithScreenshot("Launched the TV packages page");
        getRogersSolarisTVDashboardPage().selectSolarisTVPackage(TestDataHandler.tc13_SolarisChangeTVPackageAdd4KChannelsAndThemePack.accountDetails.getUpgradePlanEn(),TestDataHandler.tc13_SolarisChangeTVPackageAdd4KChannelsAndThemePack.accountDetails.getUpgradePlanFr());
        getRogersSolarisTVDashboardPage().clkPopupChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the personalize channel page");
        getRogersSolarisTVChannelsAndThemepacksPage().clkExchangeLater();
        reporter.reportLogWithScreenshot("Launched the channels and themepacks page");
         getRogersSolarisTVChannelsAndThemepacksPage().SelectChannelGenres(TestDataHandler.tc06_2_SolarisChangeTVManageChannels.accountDetails.getSwapInChannelOne());
        getRogersSolarisTVChannelsAndThemepacksPage().addChannel();
        reporter.reportLogWithScreenshot("Channel added");
        getRogersSolarisTVChannelsAndThemepacksPage().clkThemePacks();
        reporter.reportLogWithScreenshot("Clicked on themepack tab");
         getRogersSolarisTVChannelsAndThemepacksPage().clkAddButtonOnThemePackListOnManageChannelsAndThemePacks();
        reporter.reportLogWithScreenshot("ThemePack added");
        getRogersSolarisTVChannelsAndThemepacksPage().clkContinueOnExistingChannelAlertWindow();
        reporter.reportLogWithScreenshot("Clicked continue on existing channel alert window ");        
        getRogersSolarisTVChannelsAndThemepacksPage().clkContinueFromThemepacks();
        reporter.reportLogWithScreenshot("Launched the 4K enquiry popup");
        getRogersSolarisTVChannelsAndThemepacksPage().clkYesIHave4K();
        reporter.reportLogWithScreenshot("Launched the 4K Content popup");
        getRogersSolarisTVChannelsAndThemepacksPage().clk4KContent();
        
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckboxUpdate();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmitUpdateTV();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Update order completed","Update order Failed");
        reporter.reportLogWithScreenshot("Verified the Confirmation page");
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


