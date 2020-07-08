package com.rogers.test.tests.connectedhome.mobile;

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



/**
 * This class contains the test method to validate Internet Dashboard Usage for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Click on Sign in button and login with valid details.
 *3. Login with valid credentials
 *4. Click on Internet badge.
 *5. Validate the data displayed in Dial and Graph
 *6. Click View usage history link
 *7. Validate montly , daily usage section.
 *
 **/

public class Mobile_RogersCH_TC_005_IginteInternet_ValidateInternetDashboardUsageTest extends BaseTestClass {

    @Test
    public void checkInternetDashboardMobile() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	rogers_home_page.clkSignInMobile();
    	
          rogers_login_page.switchToSignInIFrame();
          reporter.reportLogWithScreenshot("Launched the SignIn popup");
          rogers_login_page.setUsernameIFrame(TestDataHandler.solarisInternetAccountWithUsage.getUsername());
          rogers_login_page.setPasswordIFrame(TestDataHandler.solarisInternetAccountWithUsage.getPassword());
          reporter.reportLogWithScreenshot("Enter the account credentails");
          rogers_login_page.clkSignInIFrame();
      	if(rogers_login_page.verifyLoginFailMsgIframe())
      	{
      		reporter.reportLogFail("Login Failed",true) ;			
      	}
      	else
      	{
          reporter.reportLogWithScreenshot("Skip popup");
          rogers_login_page.clkSkipIFrame();
          rogers_login_page.switchOutOfSignInIFrame();
          rogers_account_overview_page.selectAccount(TestDataHandler.solarisInternetAccountWithUsage.accountDetails.getBan());
          reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Logged in successfully", "Login failed");
          reporter.reportLogWithScreenshot("Launched the Account Page");
          rogers_internet_dashboard_page.clkSolarisInternetBadge();
          rogers_internet_dashboard_page.clkInternetPopup();
          reporter.reportLogWithScreenshot("Launched the Interent dashboard");
  		reporter.hardAssert(rogers_internet_dashboard_page.verifyInternet(), "Verified the Internet page", "Internet page verification failed");
  		reporter.hardAssert(rogers_internet_dashboard_page.verifyUsageAndAlerts(), "Usage and Alerts link present on the internet dash page", "Usage and Alerts link is not present on the internet page");                
          rogers_internet_dashboard_page.clkInternetUsageAlerts(); 
          reporter.reportLogWithScreenshot("Launched the UsageAlerts page");                  
          reporter.softAssert(rogers_internet_usage_page.verifyDailyBreakdown(), "Verified the daily usage Breakdown", "Daily usage Breakdown deatils are not present");
          reporter.reportLogWithScreenshot("Daily Breakdown details");
          reporter.softAssert(rogers_internet_usage_page.verifyDailyBreakdownTable(), "Verified the daily usage", "Daily usage deatils are not present");
          rogers_internet_usage_page.clkMonthlyUsage();                    
          reporter.softAssert(rogers_internet_usage_page.verifyMonthlyBreakdown(),"Verified the monthly usage Breakdown", "Monthly usage Breakdown deatils are not present");
          reporter.reportLogWithScreenshot("Monthly Breakdown details");
          reporter.softAssert(rogers_internet_usage_page.verifyMonthlyBreakdownTable(),"Verified the monthly usage", "Monthly usage deatils are not present");
          rogers_internet_usage_page.clkUsageAlerts();
          reporter.softAssert(rogers_internet_usage_page.verifyUsageAlerts(),"Verified the Usage Alerts", "Usage Alerts are not present");
          reporter.reportLogWithScreenshot("Usage and Alerts details");
      	}
    }

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(String strBrowser, String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.rogersConfig.getRogersURL(), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_ignitelogin, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}
