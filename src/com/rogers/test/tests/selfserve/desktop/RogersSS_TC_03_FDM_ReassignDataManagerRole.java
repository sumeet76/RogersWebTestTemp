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



public class RogersSS_TC_03_FDM_ReassignDataManagerRole extends BaseTestClass {	
   	
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
    public void validateReassignDataManagerRole() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc7681.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc7681.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc7681.getAccountDetails().getBan());
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
              
       reporter.reportLogWithScreenshot("dashboard page displayed"); 
       rogers_wireless_dashboard_page.clkDataManagerCTN();
       reporter.reportLogWithScreenshot("Data Manager CTN clicked"); 
       reporter.hardAssert(rogers_wireless_dashboard_page.isChangeDataManagerDisplayed(),
    		   "Change data manager available for this account","Change data manager is not displayed for this account");
       String strDataManagerCTN = rogers_wireless_dashboard_page.getDataManagerCTN();
       reporter.reportLogWithScreenshot("Data manager CTN is : "+strDataManagerCTN); 
       String strNonDataManagerCTN = rogers_wireless_dashboard_page.getNonDataManagerCTN();
       reporter.reportLog("Non Data manager CTN is : "+strNonDataManagerCTN); 
       rogers_wireless_dashboard_page.clkChangeDataManager();
       reporter.reportLogWithScreenshot("Change data manger button clicked");
       reporter.hardAssert(rogers_wireless_dashboard_page.isChooseDataManagerOverlayDisplayed(),
        		   "Choose data manager overlay is displayed for this account", 
        		   "Choose data manager overlay is NOT available for this account");
       reporter.reportLogWithScreenshot("Choose data manager overlay displayed");       
       rogers_wireless_dashboard_page.changeDataManager(strNonDataManagerCTN);
       reporter.reportLogWithScreenshot("Data manager changes to : "+strNonDataManagerCTN);
       rogers_wireless_dashboard_page.clkSaveButtonOnDataManager();
       reporter.reportLogWithScreenshot("Save data manager clicked");
       rogers_wireless_dashboard_page.clkDataManagerCTN();
       reporter.reportLogWithScreenshot("Data Manager CTN clicked"); 
       reporter.hardAssert(rogers_wireless_dashboard_page.isChangeDataManagerSuccessful(strNonDataManagerCTN),
    		   "Data manager is changed successfully", "Data manager is not changed for this account yet");
       reporter.reportLogWithScreenshot("Change Data manager is done successfully from "+strDataManagerCTN+" this to "+strNonDataManagerCTN);
       
    }

}
