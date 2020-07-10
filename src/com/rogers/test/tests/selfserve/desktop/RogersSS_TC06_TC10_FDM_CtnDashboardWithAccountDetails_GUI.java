package com.rogers.test.tests.selfserve.desktop;

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



public class RogersSS_TC06_TC10_FDM_CtnDashboardWithAccountDetails_GUI extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
/**
﻿1. Rogers.com CSS should be launched successfully
2. Login should be successful and Accounts should be displayed
3. Account overview page should be displayed
4. Individual CTN bucket details, Usage, Price Plan details along with Change Plan & Change number 
button should be displayed n Share Everything Dashboard		   	
 * @throws InterruptedException
 */
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validateFdmCtnDashboardWithAccountDetails() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc0610.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc0610.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc0610.getAccountDetails().getBan());
        }
        
       common_business_flows.scrollToMiddleOfWebPage();
	   reporter.reportLogWithScreenshot("Check the number of CTNs");
	   reporter.hardAssert(rogers_account_overview_page.isCTNMoreThanOne(),
				"The account has more than 1 CTNS",
				"The account doesnt have more than 1 CTNs, please add more than 1 and rerun");
	   common_business_flows.scrollToTopOfWebPage();
       reporter.reportLogWithScreenshot("Account overview page.");     
       rogers_account_overview_page.clkMenuUsageAndService();
       reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
       rogers_account_overview_page.clkSubMenuWirelessUsage();
       rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();           
       
       //usage dashboard area is displayed
       reporter.reportLogWithScreenshot("usage dashboard area is displayed");
       reporter.softAssert(rogers_wireless_dashboard_page.verifyTotalDataBucket(),
    		   "Total data bucket is displayed", "Total data ");
       reporter.softAssert(rogers_wireless_dashboard_page.verifyDataRemainingOutOfTotalDataBucket(),
    		   "data remaining out of total data bucket is dsiplayed", 
    		   "data remaining out of total data bucket is NOT displayed");
       reporter.softAssert(rogers_wireless_dashboard_page.verifyDaysRemainingInTheBillCycleIsDisplayed(),
    		   "Days remaining in the bill cycle is displayed",
    		   "Days remaining in the bill cycle is not displayed");
       
       common_business_flows.scrollToMiddleOfWebPage();
       reporter.reportLogWithScreenshot("Price Plan details along with Change Plan & Change number button");
       //Price Plan details along with Change Plan & Change number button
       reporter.softAssert(rogers_wireless_dashboard_page.verifyChangePlanButtonDisplayed(), 
				"Change Plan button is displayed", 
				"Change plan button is not displayed");
       
       reporter.softAssert(rogers_wireless_dashboard_page.verifyChangeMyNumberDisplayed(), 
				"Change my number is displayed", 
				"Change my number is not displayed");
                     
       reporter.softAssert(rogers_wireless_dashboard_page.verifyHeaderOfDeviceSection(), 
				"Header of Device section in wireless dashboard page verified successfully", 
				"Header of device section in wireless dashboard page didn't show as expected.");		
		//rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
		reporter.reportLogWithScreenshot("Wireless dashboard page Device Section."); 
		reporter.softAssert(rogers_wireless_dashboard_page.verifyLinkUpgradeMyDevice(), 
				"Device balance in wireless dashboard page verified successfully", 
				"Device balance in wireless dashboard page didn't show as expected.");
			
		//4.Share everything dashboard displayed successfully with
		//Data access, stream saver, data alert buttons in the wireless dashboard.
		 reporter.softAssert(rogers_wireless_dashboard_page.verifyDataAccessDisplayed(), 
					"Data access is displayed", 
					"Data access is not displayed");
		 reporter.softAssert(rogers_wireless_dashboard_page.verifyStreamSaverDisplayed(), 
					"Stream Saver is displayed", 
					"Stream Saver is not displayed");
		 reporter.softAssert(rogers_wireless_dashboard_page.verifyDataAlertDisplayed(), 
					"Data alert is displayed", 
					"Data alert is not displayed");
		 reporter.softAssert(rogers_wireless_dashboard_page.verifyDataManagerDisplayed(), 
					"Data manager is displayed", 
					"Data manager is not displayed");	
		 
		  common_business_flows.scrollToBottomOfWebPage();
	      reporter.reportLogWithScreenshot("Dashboard bottom view");
    }

}
