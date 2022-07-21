package com.rogers.test.tests.connectedhome.mobile;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to test the TV channels swap functionality for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials (Solaris account credentials with TV ).
 *3. Click on TV badge.
 *4. Click on Exchange Flex Channels button.
 *5. In Select Channels to remove section, select a change. 
 *6. Click  on Select in the pop up.
 *7. In Select Channels to add section, select one  channel.
 *8. Click  on Select in the pop up.
 *9. Check the "Sure, lets do a Credit Evaluation" check box and click on Submit.
 *10. Scroll down the page and click on Confirm Exchange.
 *11. Click on Ok.
 *
 **/

public class Mobile_RogersCH_TC_006_IginteTV_TVChannelsSwapTest extends BaseTestClass {
	
    @Test(groups = {"MobileRegressionCH"})
   public void checkSolarisTVSwapChannelsMobile() {
     reporter.reportLogWithScreenshot("Launched the SignIn popup");
     if (getRogersLoginPage().isOverlayContainerDisplayed()) {
      reporter.reportLogWithScreenshot("Select Continue in browser.");
      getRogersLoginPage().clkContinueInBrowser();
      reporter.reportLogWithScreenshot("Continue in Browser Selected");
     }
     getRogersLoginPage().setUsernameMobile(TestDataHandler.tcm06_IgniteTVAccount.getUsername());
     getRogersLoginPage().setPasswordMobile(TestDataHandler.tcm06_IgniteTVAccount.getPassword());
     reporter.reportLogWithScreenshot("Enter the account credentails");
     getRogersLoginPage().clkSignInIFrame();
     reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
     getRogersLoginPage().clkSkipIFrame();
     reporter.reportLogWithScreenshot("Skip popup");
     // reporter.hardAssert(getRogersAccountOverviewPage().verifyLoginSuccessWelcome(),"Launched the Account Page","Account Page hasn't launched");
     reporter.reportLogWithScreenshot("Launched the Account Page");
     getRogersSolarisTVDashboardPage().clkTVBadgeMobile();
     reporter.reportLogWithScreenshot("Launched the TV dash board");
     getRogersSolarisTVDashboardPage().clkChangeFlexChannelsMobile();
     reporter.reportLogWithScreenshot("TV channels pannel has displayed");
     getRogersSolarisChannelsExchangePage().verifyExchangeChannelPage();
     reporter.reportLogWithScreenshot("TV channels exchange page has launched");
     getRogersSolarisChannelsExchangePage().verifyChannelsPannel();
     reporter.reportLogWithScreenshot("TV channels pannel has displayed");

     getRogersSolarisChannelsExchangePage().swapChannelOutMobile(TestDataHandler.tcm06_IgniteTVAccount.accountDetails.getSwapOutChannelOne());
     reporter.reportLogWithScreenshot("selected the Swap-out Channel one");
     getRogersSolarisChannelsExchangePage().clkRemoveChannel();
     reporter.reportLogWithScreenshot("removed the Swap-out Channel one");
     getRogersSolarisChannelsExchangePage().swapChannelInMobile(TestDataHandler.tcm06_IgniteTVAccount.accountDetails.getSwapInChannelOne());
     reporter.reportLogWithScreenshot("Selected the Swap-in Channel one");
     getRogersSolarisChannelsExchangePage().clkAddChannelDifferentLogic();
     reporter.reportLogWithScreenshot("Added the Swap-in Channel one");

     getRogersSolarisChannelsExchangePage().swapChannelOutMobile(TestDataHandler.tcm06_IgniteTVAccount.accountDetails.getSwapOutChannelTwo());
     reporter.reportLogWithScreenshot("selected the Swap-out Channel two");
     getRogersSolarisChannelsExchangePage().clkRemoveChannel();
     reporter.reportLogWithScreenshot("removed the Swap-out Channel two");
     getRogersSolarisChannelsExchangePage().swapChannelInMobile(TestDataHandler.tcm06_IgniteTVAccount.accountDetails.getSwapInChannelTwo());
     reporter.reportLogWithScreenshot("Selected the Swap-in Channel two");
     getRogersSolarisChannelsExchangePage().clkAddChannelDifferentLogic();
     reporter.reportLogWithScreenshot("Added the Swap-in Channel two");

     getRogersSolarisChannelsExchangePage().swapChannelOutMobile(TestDataHandler.tcm06_IgniteTVAccount.accountDetails.getSwapOutChannelThree());
     reporter.reportLogWithScreenshot("selected the Swap-out Channel three");
     getRogersSolarisChannelsExchangePage().clkRemoveChannel();
     reporter.reportLogWithScreenshot("removed the Swap-out Channel three");
     getRogersSolarisChannelsExchangePage().swapChannelInMobile(TestDataHandler.tcm06_IgniteTVAccount.accountDetails.getSwapInChannelThree());
     reporter.reportLogWithScreenshot("Selected the Swap-in Channel three");
     getRogersSolarisChannelsExchangePage().clkAddChannelDifferentLogic();
     reporter.reportLogWithScreenshot("Added the Swap-in Channel three");
     getRogersSolarisChannelsExchangePage().clkConfirmSwapMobile();

     reporter.hardAssert(getRogersSolarisChannelsExchangePage().verifyExchangeSuccess(),"Swap Success","Swap failed");
     reporter.reportLogWithScreenshot("Swap Success popup has launched");
     getRogersSolarisChannelsExchangePage().clkReturnToDashbaord();
     reporter.reportLogWithScreenshot("Tv Dashboard has launched");
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


