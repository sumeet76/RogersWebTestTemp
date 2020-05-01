package com.rogers.test.tests.selfserve;

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



public class RogersSS_TC_002_TC24_Baseline_CSS_Wireless_SuspendAndReactiveUsage extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
    @Test
    public void validateSuspendUsage() {
    	this.loginAndNavToDashboard();
      //Click on 'Reactive' link in Services page.
    	if(rogers_wireless_dashboard_page.verifyToReactivateServiceMsgDisplayed()) {
    		rogers_wireless_dashboard_page.clkLnkReactivateService();
            reporter.reportLogWithScreenshot("Service suspended, Reactivate service link is clicked.");
    		reporter.hardAssert(rogers_wireless_dashboard_page.verifyServiceResumedMsgDisplayed(),
    				"Service resumed message displayed.",
    				"Service resumed message didn't display.");	
            rogers_account_overview_page.clkMenuUsageAndService();
            String strAccountNum = TestDataHandler.tc0224.getAccountDetails().getCtn();
            rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
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
        rogers_account_overview_page.clkMenuUsageAndService();
        String strAccountNum = TestDataHandler.tc0224.getAccountDetails().getCtn();
        rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        reporter.hardAssert(!rogers_wireless_dashboard_page.verifyToReactivateServiceMsgDisplayed(),
				"Service is successfully resumed.",
				"Reactivate service message still display in wireless dashboard page.");	
		
		rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
     
    }

    public void loginAndNavToDashboard() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc0224.getUsername();
    	String strPassword = TestDataHandler.tc0224.getPassword();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc0224.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");

      //Click on the Wireless badge in account overview badge.
      
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc0224.getAccountDetails().getCtn();
        rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
        
    }


}
