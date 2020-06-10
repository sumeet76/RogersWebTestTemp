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
    public void validateDataUsageInfiniteSEReducedSpeeds() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc67.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc67.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc67.getAccountDetails().getBan());
        }
       reporter.reportLogWithScreenshot("Account overview page.");     
       rogers_account_overview_page.clkMenuUsageAndService();
       reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
       rogers_account_overview_page.clkSubMenuWirelessUsage();
       rogers_account_overview_page.clkCloseInNewLookPopupIfVisible(); 
              
       reporter.reportLogWithScreenshot("dashboard page displayed");
       double totalDataValue = rogers_wireless_dashboard_page.getTotalDataVolume();
       double dataAlert = totalDataValue*0.8;
       String strDataAlert = Double.toString(dataAlert).replaceAll(",", ".");
       //common_business_flows.scrollToMiddleOfWebPage();
       reporter.hardAssert(rogers_wireless_dashboard_page.isAddDataManagerDisplayed(),
    		   "Add data manager available for this account","Add data manager is not displayed for this account");
       rogers_wireless_dashboard_page.clkAddDataManager();
       reporter.reportLogWithScreenshot("Add data manger button clicked");
       reporter.softAssert(rogers_wireless_dashboard_page.isChooseDataManagerOverlayDisplayed(),
        		   "Choose data manager overlay is displayed for this account", 
        		   "Choose data manager overlay is NOT available for this account");
       reporter.reportLogWithScreenshot("Add data manager overlay displayed");
       rogers_wireless_dashboard_page.selectDataManager();
       reporter.reportLogWithScreenshot("Data manager selected");
       rogers_wireless_dashboard_page.clkSaveButtonOnDataManager();
       reporter.reportLogWithScreenshot("Save data manager clicked");
       reporter.softAssert(!rogers_wireless_dashboard_page.isAddDataManagerDisplayed(),
    		   "Data manager set successfully", "Data manager is not set for this account yet");
       reporter.reportLogWithScreenshot("Data manager is set");
       reporter.hardAssert(rogers_wireless_dashboard_page.isSetDataAlertDisplayed(),
    		   "Set data alert is displayed for this account", "Set data alert is not available for this account");       
       rogers_wireless_dashboard_page.clkSetDataAlert();
       reporter.reportLogWithScreenshot("Set data alert");
       reporter.softAssert(rogers_wireless_dashboard_page.isSetDataAlertOverlayDisplayed(),
    		   "Set Data alert overlay is  displayed for this account", "Set Data alert overlay is not available for this account");
	   rogers_wireless_dashboard_page.setAlertOn();
	   reporter.reportLogWithScreenshot("Set Alert ON");
	   rogers_wireless_dashboard_page.setDataAlertValue(strDataAlert);
	   reporter.reportLogWithScreenshot("Set data alert value");
	   rogers_wireless_dashboard_page.clkSaveButtonOnDataAlertOverlay();
	   reporter.reportLogWithScreenshot("Save data alert");
	   reporter.softAssert(rogers_wireless_dashboard_page.isDataAlertCorrectlySet(strDataAlert),
    		   "Set Data alert is  set correctly for this account", "Set data alert is not set correctly for this account");
	   reporter.reportLogWithScreenshot("Set data alert");
    }

}
