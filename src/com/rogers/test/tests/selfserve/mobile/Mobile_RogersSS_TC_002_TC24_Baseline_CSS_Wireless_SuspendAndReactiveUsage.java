package com.rogers.test.tests.selfserve.mobile;

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



public class Mobile_RogersSS_TC_002_TC24_Baseline_CSS_Wireless_SuspendAndReactiveUsage extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
    @Test
    public void validateSuspendUsage() {
    	this.loginAndNavToDashboard();
      //Click on 'Reactive' link in Services page.
    	rogers_profile_and_settings_page.clkCloseFeedbackIfAvailableMobile();
    	if(rogers_wireless_dashboard_page.verifyToReactivateServiceMsgDisplayed()) {
    		rogers_wireless_dashboard_page.clkLnkReactivateService();
            reporter.reportLogWithScreenshot("Service suspended, Reactivate service link is clicked.");
    		reporter.hardAssert(rogers_wireless_dashboard_page.verifyServiceResumedMsgDisplayed(),
    				"Service resumed message displayed.",
    				"Service resumed message didn't display.");	
            rogers_account_overview_page.clkbtnBackToDevices();           
    	}
    	
        rogers_wireless_dashboard_page.clkLnkLostOrStolenDevice();
        reporter.reportLogWithScreenshot("Lost or stolen device link is clicked.");
        rogers_wireless_dashboard_page.clkBtnSwitchOffMyService();
        reporter.reportLogWithScreenshot("Switch off my service is clicked.");
		reporter.hardAssert(rogers_wireless_dashboard_page.verifyServiceSuspendedMsgDisplayed(),
				"Service successfully suspended.",
				"Service suspended message didn't display.");	
        reporter.reportLogWithScreenshot("Service successfully suspended.");
    }
	
    @Test (dependsOnMethods = "validateSuspendUsage")
    public void validateReactivateService() {
    	this.loginAndNavToDashboard();
      //Click on 'Reactive' link in Services page.
    	rogers_profile_and_settings_page.clkCloseFeedbackIfAvailableMobile();
		reporter.hardAssert(rogers_wireless_dashboard_page.verifyToReactivateServiceMsgDisplayed(),
				"Reactivate service message didn't displayed on wireless dashboard page.",
				"Reactivate service message didn't display.");	
		rogers_wireless_dashboard_page.clkLnkReactivateService();
        reporter.reportLogWithScreenshot("Reactivate service link is clicked.");
		reporter.hardAssert(rogers_wireless_dashboard_page.verifyServiceResumedMsgDisplayed(),
				"Service resumed message displayed.",
				"Service resumed message didn't display.");	
        reporter.reportLogWithScreenshot("Service resumed success message.");
	     //Go back to wireless dashboard page to verify service resumed successfully
        rogers_account_overview_page.clkbtnBackToDevices();
        reporter.hardAssert(!rogers_wireless_dashboard_page.verifyToReactivateServiceMsgDisplayed(),
				"Service is successfully resumed.",
				"Reactivate service message still display in wireless dashboard page.");	
		
		rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
     
    }

    public void loginAndNavToDashboard() {
    	reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	rogers_home_page.clkSignInMobile();
    	String strUsername = TestDataHandler.tc0224.getUsername();
    	String strPassword = TestDataHandler.tc0224.getPassword();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
      
        reporter.reportLogWithScreenshot("Account overview page.");

      //Click on the Wireless badge in account overview badge.        
        rogers_account_overview_page.clkMenuUsageAndServiceMobile();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc0224.getAccountDetails().getCtn();
        rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
        
    }


}
