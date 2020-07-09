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



public class RogersSS_TC_04_05_FDM_BlockAndUnblockDataUsageForTheCTN extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void blockFDMDataUsageForTheCTN() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc01030405.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc01030405.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc01030405.getAccountDetails().getBan());
        }
       reporter.reportLogWithScreenshot("Account overview page.");     
       rogers_account_overview_page.clkMenuUsageAndService();
       reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
       rogers_account_overview_page.clkSubMenuWirelessUsage();
       rogers_account_overview_page.clkCloseInNewLookPopupIfVisible(); 
     
       reporter.reportLogWithScreenshot("Dashboard page");
       common_business_flows.scrollToMiddleOfWebPage();
       reporter.reportLogWithScreenshot("Middle view of Dashboard page");
       common_business_flows.scrollToTopOfWebPage();
    
       reporter.hardAssert(rogers_wireless_dashboard_page.isDataAccessDisplayed(),
    		   "Data access ON is displayed",
    		   "Data access ON is not displayed");
       if(!rogers_wireless_dashboard_page.isDataAccessOnDisplayed())
       {
    	   
    	onDataAccess();   
       }
                  	   
    	   reporter.reportLogWithScreenshot("Data access if set to ON");
           rogers_wireless_dashboard_page.clkDataAccessOff();
           reporter.hardAssert(rogers_wireless_dashboard_page.isDataAccessOFF(),
        		   "Data access is switch off successfully",
        		   "Data access didnt switch off successfuly , please investigate");       
           reporter.reportLogWithScreenshot("Data access set to OFf");
                 
                   
       
    }
    
    
    @Test (dependsOnMethods = "blockFDMDataUsageForTheCTN")
	public void unblockFDMDataUsageForTheCTN() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc01030405.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc01030405.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc01030405.getAccountDetails().getBan());
        }
       reporter.reportLogWithScreenshot("Account overview page.");     
       rogers_account_overview_page.clkMenuUsageAndService();
       reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
       rogers_account_overview_page.clkSubMenuWirelessUsage();
       rogers_account_overview_page.clkCloseInNewLookPopupIfVisible(); 
     
       reporter.reportLogWithScreenshot("Dashboard page");
       common_business_flows.scrollToMiddleOfWebPage();
       reporter.reportLogWithScreenshot("Middle view of Dashboard page");
       common_business_flows.scrollToTopOfWebPage();
    
       reporter.hardAssert(rogers_wireless_dashboard_page.isDataAccessDisplayed(),
    		   "Data access ON is displayed",
    		   "Data access ON is not displayed");	
       if(rogers_wireless_dashboard_page.isDataAccessOnDisplayed())
       {
    	 offDataAccess();
       }
        reporter.reportLogWithScreenshot("Data access if set to OFF");
        rogers_wireless_dashboard_page.clkDataAccessOn();
        reporter.hardAssert(rogers_wireless_dashboard_page.isDataAccessOnDisplayed(),
     		   "Data access is switch ON successfully",
     		   "Data access didnt switch ON successfuly , please investigate");       
        reporter.reportLogWithScreenshot("Data access set to ON");        
    
    
    }
	
	public void offDataAccess() {
		 reporter.reportLogWithScreenshot("Data access if set to ON, switching OFF");
         rogers_wireless_dashboard_page.clkDataAccessOff();
         reporter.hardAssert(rogers_wireless_dashboard_page.isDataAccessOFF(),
      		   "Data access is switch off successfully",
      		   "Data access didnt switch off successfuly , please investigate");       
         reporter.reportLogWithScreenshot("Data access set to OFf");
	}

	public void onDataAccess() {
		reporter.reportLogWithScreenshot("Data access if set to OFF, switching it ON");
        rogers_wireless_dashboard_page.clkDataAccessOn();
        reporter.hardAssert(rogers_wireless_dashboard_page.isDataAccessOnDisplayed(),
     		   "Data access is switch ON successfully",
     		   "Data access didnt switch ON successfuly , please investigate");
	}
	
	

}
