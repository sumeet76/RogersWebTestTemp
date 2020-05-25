package com.rogers.test.tests.connectedhome;

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
import com.rogers.testdatamanagement.TestDataHandler;


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

public class RogersCH_TC_001_IginteTV_TVChannelsSwapFromAddressmodalTest extends BaseTestClass {
	
@Test
	
   public void checkSolarisTVSwapChannels() {               
    reporter.reportLogWithScreenshot("Launched the Home Page");
    rogers_home_page.clkSignIn();
    rogers_login_page.switchToSignInIFrame();
    reporter.reportLogWithScreenshot("Launched the SignIn popup");
    rogers_login_page.setUsernameIFrame(TestDataHandler.igniteTVAccount.getUsername());
    rogers_login_page.setPasswordIFrame(TestDataHandler.igniteTVAccount.getPassword());
    reporter.reportLogWithScreenshot("Enter the account credentails");
    rogers_login_page.clkSignInIFrame();
    reporter.reportLogWithScreenshot("Skip popup");
    rogers_login_page.clkSkipIFrame();
    rogers_login_page.switchOutOfSignInIFrame();
    rogers_account_overview_page.selectAccount(TestDataHandler.igniteTVAccount.accountDetails.getBan());
    reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Logged in successfully", "Login failed");
    reporter.reportLogWithScreenshot("Launched the Account Page");               
    rogers_solaris_tv_dashboard_page.clkTVBadge();
    reporter.reportLogWithScreenshot("Launched the TV dash board");
    rogers_solaris_tv_dashboard_page.clkChangeFlexChannels();  
    reporter.reportLogWithScreenshot("TV channels pannel has displayed");
    rogers_solaris_tv_dashboard_page.clkOutChannelOne();
    rogers_solaris_tv_dashboard_page.clkOutChannelTwo();
    rogers_solaris_tv_dashboard_page.clkOutChannelThree();
    reporter.reportLogWithScreenshot("removed the Swap-out Channels");
    rogers_solaris_tv_dashboard_page.swapChannelIn(TestDataHandler.igniteTVAccount.accountDetails.getSwapInChannelOne());
    reporter.reportLogWithScreenshot("Selceted the Swap-in Channel one");
    rogers_solaris_tv_dashboard_page.btnChannelAdd();
    rogers_solaris_tv_dashboard_page.btnClearSerachResults();
    rogers_solaris_tv_dashboard_page.swapChannelIn(TestDataHandler.igniteTVAccount.accountDetails.getSwapInChannelTwo());
    reporter.reportLogWithScreenshot("Selceted the Swap-in Channel two");
    rogers_solaris_tv_dashboard_page.btnChannelAdd();
    rogers_solaris_tv_dashboard_page.btnClearSerachResults();
    rogers_solaris_tv_dashboard_page.swapChannelIn(TestDataHandler.igniteTVAccount.accountDetails.getSwapInChannelThree());
    reporter.reportLogWithScreenshot("Selceted the Swap-in Channel three");
    rogers_solaris_tv_dashboard_page.btnChannelAdd();
    rogers_solaris_tv_dashboard_page.btnClearSerachResults();    
    rogers_solaris_tv_dashboard_page.clkConfirmSwap(); 
    reporter.reportLogWithScreenshot("Swap Success popup has launched");
    rogers_solaris_tv_dashboard_page.clkSuccessSwap();    
    reporter.reportLogWithScreenshot("Swap success");         
    }
	
/*  @Test	
    public void checkSolarisTVSwapChannelsReverse() {               
	    reporter.reportLogWithScreenshot("Launched the Home Page");
	    rogers_home_page.clkSignIn();
	    rogers_login_page.switchToSignInIFrame();
	    reporter.reportLogWithScreenshot("Launched the SignIn popup");
	    rogers_login_page.setUsernameIFrame(TestDataHandler.solarisTVAccount.getUsername());
	    rogers_login_page.setPasswordIFrame(TestDataHandler.solarisTVAccount.getPassword());
	    reporter.reportLogWithScreenshot("Enter the account credentails");
	    rogers_login_page.clkSignInIFrame();
	    reporter.reportLogWithScreenshot("Skip popup");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
	    rogers_account_overview_page.selectAccount(TestDataHandler.igniteTVAccount.accountDetails.getBan());
	    reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Logged in successfully", "Login failed");
	    reporter.reportLogWithScreenshot("Launched the Account Page");               
	    rogers_solaris_tv_dashboard_page.clkTVBadge(TestDataHandler.rogersConfig.getBrowser());
	    reporter.reportLogWithScreenshot("Launched the TV dash board");
	    rogers_solaris_tv_dashboard_page.clkChangeFlexChannels();                    
        rogers_solaris_tv_dashboard_page.swapInChannel(TestDataHandler.igniteTVAccount.accountDetails.getSwapoutChannel());
        reporter.reportLogWithScreenshot("Selceted the Swap-in Channel");
        rogers_solaris_tv_dashboard_page.swapOutChannel(TestDataHandler.igniteTVAccount.accountDetails.getSwapinChannel());                  
        rogers_solaris_tv_dashboard_page.clkConfirmExchange();
        reporter.softAssert(rogers_solaris_tv_dashboard_page.verifySuccessIcon(), "Channels swap success","Channels swap failed");
        rogers_solaris_tv_dashboard_page.clkOkButton();
                
    }
*/

@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
//login flow
public void beforeTest(String strBrowser, String strLanguage, String strGroupName, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
	xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	startSession(TestDataHandler.rogersConfig.getRogersURL(), strBrowser,strLanguage,strGroupName, method);
}

@AfterMethod(alwaysRun = true)
public void afterTest() {
	closeSession();
}



}


