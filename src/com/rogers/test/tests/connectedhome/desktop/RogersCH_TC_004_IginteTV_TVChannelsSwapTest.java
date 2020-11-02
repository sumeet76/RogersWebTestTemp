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

public class RogersCH_TC_004_IginteTV_TVChannelsSwapTest extends BaseTestClass {
	
	 @Test(groups = {"RegressionCH","IgniteTVDashboardCH"})
	
   public void checkSolarisTVSwapChannels() {
    reporter.reportLogWithScreenshot("Launched the Home Page");
    rogers_home_page.clkSignIn();
    rogers_login_page.switchToSignInIFrame();
    reporter.reportLogWithScreenshot("Launched the SignIn popup");
    rogers_login_page.setUsernameIFrame(TestDataHandler.tc04_07_SolarisTVAccount.getUsername());
    rogers_login_page.setPasswordIFrame(TestDataHandler.tc04_07_SolarisTVAccount.getPassword());
    reporter.reportLogWithScreenshot("Enter the account credentails");
    rogers_login_page.clkSignInIFrame();
	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
    reporter.reportLogWithScreenshot("Skip popup");
    rogers_login_page.clkSkipIFrame();
    rogers_login_page.switchOutOfSignInIFrame();
    rogers_account_overview_page.selectAccount(TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getBan());
	reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
    reporter.reportLogWithScreenshot("Launched the Account Page");              
    rogers_solaris_tv_dashboard_page.clkTVBadge();
    reporter.reportLogWithScreenshot("Launched the TV dash board");
    rogers_solaris_tv_dashboard_page.clkChangeFlexChannels();  
    reporter.reportLogWithScreenshot("TV channels pannel has displayed");
    rogers_solaris_tv_dashboard_page.clkOutChannelOne();
    rogers_solaris_tv_dashboard_page.clkOutChannelTwo();
    rogers_solaris_tv_dashboard_page.clkOutChannelThree();
    reporter.reportLogWithScreenshot("removed the Swap-out Channels");
    rogers_solaris_tv_dashboard_page.swapChannelIn(TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getSwapInChannelOne());
    reporter.reportLogWithScreenshot("Selceted the Swap-in Channel one");
    rogers_solaris_tv_dashboard_page.btnChannelAdd();
    rogers_solaris_tv_dashboard_page.btnClearSerachResults();
    rogers_solaris_tv_dashboard_page.swapChannelIn(TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getSwapInChannelTwo());
    reporter.reportLogWithScreenshot("Selceted the Swap-in Channel two");
    rogers_solaris_tv_dashboard_page.btnChannelAdd();
    rogers_solaris_tv_dashboard_page.btnClearSerachResults();
    rogers_solaris_tv_dashboard_page.swapChannelIn(TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getSwapInChannelThree());
    reporter.reportLogWithScreenshot("Selceted the Swap-in Channel three");
    rogers_solaris_tv_dashboard_page.btnChannelAdd();
    rogers_solaris_tv_dashboard_page.btnClearSerachResults();    
    rogers_solaris_tv_dashboard_page.clkConfirmSwap(); 
    reporter.reportLogWithScreenshot("Swap Success popup has launched");
    rogers_solaris_tv_dashboard_page.clkSuccessSwap();    
    reporter.reportLogWithScreenshot("Swap success");  
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

