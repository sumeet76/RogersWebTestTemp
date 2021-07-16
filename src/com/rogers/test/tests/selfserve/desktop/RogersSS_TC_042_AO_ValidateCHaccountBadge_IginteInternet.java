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



/**
 * This class contains the test method to validate Internet Dashboard Usage for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
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

    @Test(groups = {"RegressionSS","AccountOverviewSS"})
    public void checkInternetDashboard() {
    	            reporter.reportLogWithScreenshot("Launched the Home Page");
                    getRogersHomePage().clkSignIn();
                    //getRogersLoginPage().switchToSignInIFrame();
                    reporter.reportLogWithScreenshot("Launched the SignIn popup");
                    getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc42SolarisInternetAccountWithUsage.getUsername());
                    getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc42SolarisInternetAccountWithUsage.getPassword());
                    reporter.reportLogWithScreenshot("Enter the account credentails");
                    getRogersLoginPage().clkSignInIFrame();
                    reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
                    reporter.reportLogWithScreenshot("Skip popup");
                    getRogersLoginPage().clkSkipIFrame();
                    //getRogersLoginPage().switchOutOfSignInIFrame();
                    getRogersAccountOverviewPage().selectAccount((TestDataHandler.tc42SolarisInternetAccountWithUsage.accountDetails.getBan()));
            		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), 
            				"Logged in successfully", "Login failed");
                    reporter.reportLogWithScreenshot("Launched the Account Page");
                    getRogersInternetDashboardPage().clkSolarisInternetBadge();
                    getRogersInternetDashboardPage().clkInternetPopup();
                    reporter.reportLogWithScreenshot("Clicked on Internet badge");                   
            		reporter.hardAssert(getRogersInternetDashboardPage().verifyInternet(),
            				"Verified the Internet page",
            				"Internet page verification failed");
            		reporter.hardAssert(getRogersInternetDashboardPage().verifyUsageAndAlerts(),
            				"Usage and Alerts link present on the internet dash page",
            				"Usage and Alerts link is not present on the internet page");                
            		reporter.reportLogWithScreenshot("Ignite Internet dashboard is opened");
            		getCommonBusinessFlows().scrollToMiddleOfWebPage();
            		reporter.reportLogWithScreenshot("Mid page view");
            		getCommonBusinessFlows().scrollToBottomOfWebPage();
            		reporter.reportLogWithScreenshot("Bottom View");
    }

    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
   	
	

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}
