package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to verify the stand alone Internet upgarde flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Click on Sign in button and login with valid credentials. (Solaris account Credentials that has ONLY Internet account linked )
 *3. Login with valid credentials.
 *4. Click on Internet badge.
 *5. Validate the data displayed in Dial and Graph.
 *6. Click View usage history link.
 *7. Validate montly , daily usage section.
 *
 **/

public class RogersCH_TC_022_IginteInternet_ValidateStandaloneInternetDashboardUsageTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","saiCH","AKS"})
    public void checkStandaloneInternetDashboard() {
        reporter.reportLogWithScreenshot("Launched the Home Page");
        getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc22_StandaloneInternetAccountWithUsage.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc22_StandaloneInternetAccountWithUsage.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc22_StandaloneInternetAccountWithUsage.accountDetails.getBan());
    	//reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersInternetDashboardPage().clkSolarisInternetBadge();
        reporter.reportLogWithScreenshot("Launched the Interent dashboard");
        getRogersInternetDashboardPage().clkInternetPopup();
		reporter.hardAssert(getRogersInternetDashboardPage().verifyInternet(), "Verified the Internet page", "Internet page verification failed");
		reporter.hardAssert(getRogersInternetDashboardPage().verifyUsageAndAlerts(), "Usage and Alerts link present on the internet dash page", "Usage and Alerts link is not present on the internet page");
        getRogersInternetDashboardPage().clkInternetUsageAlerts();
        reporter.reportLogWithScreenshot("Launched the UsageAlerts page");                  
        reporter.softAssert(getRogersInternetUsagePage().verifyDailyBreakdown(), "Verified the daily usage Breakdown", "Daily usage Breakdown deatils are not present");
        reporter.reportLogWithScreenshot("Daily Breakdown details");
        reporter.softAssert(getRogersInternetUsagePage().verifyDailyBreakdownTable(), "Verified the daily usage", "Daily usage deatils are not present");
        getRogersInternetUsagePage().clkMonthlyUsage();
        reporter.softAssert(getRogersInternetUsagePage().verifyMonthlyBreakdown(),"Verified the monthly usage Breakdown", "Monthly usage Breakdown deatils are not present");
        reporter.reportLogWithScreenshot("Monthly Breakdown details");
        reporter.softAssert(getRogersInternetUsagePage().verifyMonthlyBreakdownTable(),"Verified the monthly usage", "Monthly usage deatils are not present");
        getRogersInternetUsagePage().clkUsageAlerts();
        reporter.softAssert(getRogersInternetUsagePage().verifyUsageAlerts(),"Verified the Usage Alerts", "Usage Alerts are not present");
        reporter.reportLogWithScreenshot("Usage and Alerts details");
    	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}
