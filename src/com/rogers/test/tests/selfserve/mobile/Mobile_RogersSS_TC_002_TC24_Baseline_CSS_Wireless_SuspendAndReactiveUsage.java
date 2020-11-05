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
	
    @Test(groups = {"MobileSanitySS"})
    public void validateSuspendUsage() {
    	this.loginAndNavToDashboard();
      //Click on 'Reactive' link in Services page.
    	getRogersProfileAndSettingsPage().clkCloseFeedbackIfAvailableMobile();
    	if(getRogersWirelessDashboardPage().verifyToReactivateServiceMsgDisplayed()) {
    		getRogersWirelessDashboardPage().clkLnkReactivateService();
            reporter.reportLogWithScreenshot("Service suspended, Reactivate service link is clicked.");
    		reporter.hardAssert(getRogersWirelessDashboardPage().verifyServiceResumedMsgDisplayed(),
    				"Service resumed message displayed.",
    				"Service resumed message didn't display.");	
            getRogersAccountOverviewPage().clkbtnBackToDevices();
    	}
    	
        getRogersWirelessDashboardPage().clkLnkLostOrStolenDevice();
        reporter.reportLogWithScreenshot("Lost or stolen device link is clicked.");
        getRogersWirelessDashboardPage().clkBtnSwitchOffMyService();
        reporter.reportLogWithScreenshot("Switch off my service is clicked.");
		reporter.hardAssert(getRogersWirelessDashboardPage().verifyServiceSuspendedMsgDisplayed(),
				"Service successfully suspended.",
				"Service suspended message didn't display.");	
        reporter.reportLogWithScreenshot("Service successfully suspended.");
    }
	
    @Test (dependsOnMethods = "validateSuspendUsage",groups = {"MobileSanitySS"})
    public void validateReactivateService() {
    	this.loginAndNavToDashboard();
      //Click on 'Reactive' link in Services page.
    	getRogersProfileAndSettingsPage().clkCloseFeedbackIfAvailableMobile();
		reporter.hardAssert(getRogersWirelessDashboardPage().verifyToReactivateServiceMsgDisplayed(),
				"Reactivate service message didn't displayed on wireless dashboard page.",
				"Reactivate service message didn't display.");	
		getRogersWirelessDashboardPage().clkLnkReactivateService();
        reporter.reportLogWithScreenshot("Reactivate service link is clicked.");
		reporter.hardAssert(getRogersWirelessDashboardPage().verifyServiceResumedMsgDisplayed(),
				"Service resumed message displayed.",
				"Service resumed message didn't display.");	
        reporter.reportLogWithScreenshot("Service resumed success message.");
	     //Go back to wireless dashboard page to verify service resumed successfully
        getRogersAccountOverviewPage().clkbtnBackToDevices();
        reporter.hardAssert(!getRogersWirelessDashboardPage().verifyToReactivateServiceMsgDisplayed(),
				"Service is successfully resumed.",
				"Reactivate service message still display in wireless dashboard page.");	
		
		getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
     
    }

    public void loginAndNavToDashboard() {
    	reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	getRogersHomePage().clkSignInMobile();
    	String strUsername = TestDataHandler.tc0224.getUsername();
    	String strPassword = TestDataHandler.tc0224.getPassword();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
      
        reporter.reportLogWithScreenshot("Account overview page.");

      //Click on the Wireless badge in account overview badge.        
        getRogersAccountOverviewPage().clkMenuUsageAndServiceMobile();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc0224.getAccountDetails().getCtn();
        getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
        
    }


}
