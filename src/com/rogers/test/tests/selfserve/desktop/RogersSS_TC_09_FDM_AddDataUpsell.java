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
import com.rogers.test.helpers.RogersEnums.GroupName;
import com.rogers.testdatamanagement.TestDataHandler;



public class RogersSS_TC_09_FDM_AddDataUpsell extends BaseTestClass {	
   	
	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,GroupName.selfserve, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
	}
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
		
    @Test
    public void validateDataUsageDisplayForRunningLowAndAddData() {
    	reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	rogers_home_page.clkSignInMobile();
    	String strUsername = TestDataHandler.tc61.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc61.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc61.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");

    	rogers_account_overview_page.clkSubMenuWirelessUsage();
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
        
        double origTotalData = rogers_wireless_dashboard_page.getTotalDataVolume();
        double addedData = 0;


        reporter.hardAssert(rogers_wireless_dashboard_page.verifyAddDataButtonIsDisplayed(), 
							"Add the Data top-up button is displayed", 
							"Add the Data top-up  button is NOT displayed."); 
        //Validate add data flow
        common_business_flows.addDataFlow();
        if(rogers_add_data_page.verifyAddDataSuccessMsgIsDisplayed())
        {
        	addedData = rogers_add_data_page.getAddedDataVolume();
        	rogers_add_data_page.clkCloseOnAddDataOverlay();
        	//Sign out and re sign in to verify if added data reflected.
	        reporter.reportLogWithScreenshot("Wireless dashboard page.");  
	        rogers_login_page.clickSignOut();
	        reporter.reportLogWithScreenshot("Sign Out clicked");  
	        rogers_login_page.clkSignInAs();
	        reporter.reportLogWithScreenshot("Re sign In");  
	        rogers_login_page.switchToSignInIFrame();
	                   
	        rogers_login_page.setPasswordIFrame(strPassword);
	        reporter.reportLogWithScreenshot("Login Credential is entered.");
			rogers_login_page.clkSignInIFrame();		
			rogers_login_page.switchOutOfSignInIFrame();		       
	        reporter.reportLogWithScreenshot("Account overview page.");        
	        rogers_account_overview_page.clkMenuUsageAndService();
	        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");        
	        rogers_account_overview_page.clkSubMenuWirelessUsage();
	        reporter.reportLogWithScreenshot("Wireless dashboard page.");
	       
	     	        
        } else if (rogers_add_data_page.verifyErrorMsgIsDisplayed()) {
        	reporter.reportLogWithScreenshot("Add data purchase got error, please check if limit is reached.");
        	rogers_add_data_page.clkCloseOnAddDataOverlay();
        }
             
		rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");        
        rogers_wireless_dashboard_page.scrollToBottomOfPage();
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
    }
    
   
}
