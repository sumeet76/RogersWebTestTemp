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
 *
Expected:
1.Rogers.com landing page is opened successfully
2. Sign in popup is displayed
3. Account overview page displayed
4. IgniteInternet dashboard page should be opened"
 *
 **/

public class RogersSS_TC_042_AO_ValidateCHaccountBadge_IginteInternet extends BaseTestClass {

    @Test
    public void checkInternetDashboard() {
    	            reporter.reportLogWithScreenshot("Launched the Home Page");
                    rogers_home_page.clkSignIn();
                    rogers_login_page.switchToSignInIFrame();
                    reporter.reportLogWithScreenshot("Launched the SignIn popup");
                    rogers_login_page.setUsernameIFrame(TestDataHandler.tc42SolarisInternetAccountWithUsage.getUsername());
                    rogers_login_page.setPasswordIFrame(TestDataHandler.tc42SolarisInternetAccountWithUsage.getPassword());
                    reporter.reportLogWithScreenshot("Enter the account credentails");
                    rogers_login_page.clkSignInIFrame();
                    reporter.reportLogWithScreenshot("Skip popup");
                    rogers_login_page.clkSkipIFrame();  
                    rogers_login_page.switchOutOfSignInIFrame();
                    rogers_account_overview_page.selectAccount((TestDataHandler.tc42SolarisInternetAccountWithUsage.accountDetails.getBan()));
            		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(), 
            				"Logged in successfully", "Login failed");
                    reporter.reportLogWithScreenshot("Launched the Account Page");
                    rogers_internet_dashboard_page.clkSolarisInternetBadge();
                    rogers_internet_dashboard_page.clkInternetPopup();
                    reporter.reportLogWithScreenshot("Clicked on Internet badge");                   
            		reporter.softAssert(rogers_internet_dashboard_page.verifyInternet(), 
            				"Verified the Internet page",
            				"Internet page verification failed");
            		reporter.softAssert(rogers_internet_dashboard_page.verifyUsageAndAlerts(),
            				"Usage and Alerts link present on the internet dash page",
            				"Usage and Alerts link is not present on the internet page");                
            		reporter.reportLogWithScreenshot("Ignite Internet dashboard is opened");
            		common_business_flows.scrollToMiddleOfWebPage();
            		reporter.reportLogWithScreenshot("Mid page view");
            		common_business_flows.scrollToBottomOfWebPage();
            		reporter.reportLogWithScreenshot("Bottom View");
    }

    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
   	
	

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}
