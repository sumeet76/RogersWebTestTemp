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



public class RogersSS_TC06_FDM_CtnDashboardWithAccountDetails_GUI extends BaseTestClass {	
   	
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
    public void validateDataUsageInfiniteSEReducedSpeeds() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc7681.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc7681.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc7681.getAccountDetails().getBan());
        }
        
       common_business_flows.scrollToMiddleOfWebPage();
	   reporter.reportLogWithScreenshot("Check the number of CTNs");	 
       reporter.reportLogWithScreenshot("Account overview page.");     
       rogers_account_overview_page.clkMenuUsageAndService();
       reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
       rogers_account_overview_page.clkSubMenuWirelessUsage();
       rogers_account_overview_page.clkCloseInNewLookPopupIfVisible(); 
              
       reporter.reportLogWithScreenshot("dashboard page displayed"); 
       rogers_wireless_dashboard_page.clkTheNthCTNOnDashboardPage(1);
       reporter.reportLogWithScreenshot("CTN clicked"); 
      // reporter.hardAssert(rogers_wireless_dashboard_page.isChangePlanDisplayed(),
    	//	   "Change plan button is displayed",
    	//	   "Chnage plan button not displayed");
       String strDataManagerCTN = rogers_wireless_dashboard_page.getDataManagerCTN();
       reporter.reportLogWithScreenshot("Data manager CTN is : "+strDataManagerCTN); 
       String strNonDataManagerCTN = rogers_wireless_dashboard_page.getNonDataManagerCTN();
       reporter.reportLogWithScreenshot("Non Data manager CTN is : "+strNonDataManagerCTN); 
       rogers_wireless_dashboard_page.clkChangeDataManager();
       reporter.reportLogWithScreenshot("Change data manger button clicked");
       reporter.softAssert(rogers_wireless_dashboard_page.isChooseDataManagerOverlayDisplayed(),
        		   "Choose data manager overlay is displayed for this account", 
        		   "Choose data manager overlay is NOT available for this account");
       reporter.reportLogWithScreenshot("Choose data manager overlay displayed");       
       rogers_wireless_dashboard_page.changeDataManager(strNonDataManagerCTN);
       reporter.reportLogWithScreenshot("Data manager chnages to : "+strNonDataManagerCTN);
       rogers_wireless_dashboard_page.clkSaveButtonOnDataManager();
       reporter.reportLogWithScreenshot("Save data manager clicked");
       rogers_wireless_dashboard_page.clkDataManagerCTN();
       reporter.reportLogWithScreenshot("Data Manager CTN clicked"); 
       reporter.softAssert(rogers_wireless_dashboard_page.isChangeDataManagerSuccessful(strNonDataManagerCTN),
    		   "Data manager is changed successfully", "Data manager is not chnaged for this account yet");
       reporter.reportLogWithScreenshot("Chnage Data manager is done successfully from "+strDataManagerCTN+" this to "+strNonDataManagerCTN);
       
    }

}
