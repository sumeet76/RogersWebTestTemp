package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;



public class RogersSS_TC_012_ValidateVideoContentQualityWhenVTturnedONforDM extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"RegressionSS","FDMSS"})
    public void videoContentQualityWhenVTturnedONforDM() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc01030405.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc01030405.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
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
    
       reporter.hardAssert(rogers_wireless_dashboard_page.verifyStreamSaverDisplayed(),
    		   "Stream saver is displayed",
    		   "Stream saver is not displayed");
       
       reporter.hardAssert(rogers_wireless_dashboard_page.isSetDataAlertDisplayed(),
    		   "Set data alert is displayed for this account", "Set data alert is not available for this account");
       
       double totalDataValue = rogers_wireless_dashboard_page.getTotalDataVolume();
       double dataAlert = totalDataValue*0.8;
       String strDataAlert = Double.toString(dataAlert).replaceAll(",", ".");
       rogers_wireless_dashboard_page.clkSetDataAlert();
       reporter.reportLogWithScreenshot("Set data alert");
       reporter.hardAssert(rogers_wireless_dashboard_page.isSetDataAlertOverlayDisplayed(),
    		   "Set Data alert overlay is  displayed for this account",
    		   "Set Data alert overlay is not available for this account");
	   rogers_wireless_dashboard_page.setAlertOn();
	   reporter.reportLogWithScreenshot("Set Alert ON");
	   rogers_wireless_dashboard_page.setDataAlertValue(strDataAlert);
	   reporter.reportLogWithScreenshot("Set data alert value");
	   rogers_wireless_dashboard_page.clkSaveButtonOnDataAlertOverlay();
	   reporter.reportLogWithScreenshot("Save data alert");
	   reporter.hardAssert(rogers_wireless_dashboard_page.isDataAlertCorrectlySet(strDataAlert),
    		   "Set Data alert is  set correctly for this account", "Set data alert is not set correctly for this account");
	   reporter.reportLogWithScreenshot("Set data alert");
             
       if(!rogers_wireless_dashboard_page.isStreamSaverONDisplayed())
       {    	   
    		reporter.reportLogWithScreenshot("Stream saver is set to OFF, switching it ON");
            rogers_wireless_dashboard_page.clkStreamSaverOn();
            reporter.hardAssert(rogers_wireless_dashboard_page.isStreamSaverONDisplayed(),
         		   "Stream saver is switch ON successfully",
         		   "Stream saver didnt switch ON successfuly , please investigate");   
       }
                  	       	                            
       
    }
    
        	

}
