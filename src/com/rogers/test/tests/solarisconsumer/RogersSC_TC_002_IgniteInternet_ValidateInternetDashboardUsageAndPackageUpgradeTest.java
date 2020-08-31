package com.rogers.test.tests.solarisconsumer;

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
import com.rogers.testdatamanagement.TestDataHandler;



/**
 * This class contains the test method to validate Internet Dashboard Usage for Rogers.com   
 * 
 * @author Saurav.Goyal
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

public class RogersSC_TC_002_IgniteInternet_ValidateInternetDashboardUsageAndPackageUpgradeTest extends BaseTestClass {

	@Test
	public void checkInternetDashboardUsageAndPackageUpgrade() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.solarisInternetAccountWithUsageAndPackageUpgrade.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisInternetAccountWithUsageAndPackageUpgrade.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();  
		rogers_login_page.switchOutOfSignInIFrame();
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Logged in successfully", "Login failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_internet_dashboard_page.clkSolarisInternetBadge();
		reporter.reportLogWithScreenshot("Launched the Interent dashboard");
		reporter.softAssert(rogers_internet_dashboard_page.verifyInternet(), "Verified the Internet page", "Internet page verification failed");
		reporter.softAssert(rogers_internet_dashboard_page.verifyUsageAndAlerts(), "Usage and Alerts link present on the internet dash page", "Usage and Alerts link is not present on the internet page");                
		rogers_internet_dashboard_page.clkInternetUsageAlerts(); 
		reporter.reportLogWithScreenshot("Launched the UsageAlerts page");
		rogers_internet_usage_page.verifyDailyBreakdown();  
		rogers_internet_usage_page.verifyDailyBreakdownTable(); 
		reporter.reportLogWithScreenshot("Daily Breakdown details");
		reporter.softAssert(rogers_internet_usage_page.verifyDailyBreakdownTable(), "Verified the daily usage", "Daily usage deatils are not present");
		rogers_internet_usage_page.clkMonthlyUsage();
		reporter.reportLogWithScreenshot("Monthly Breakdown details");
		rogers_internet_usage_page.verifyMonthlyBreakdownTable();
		rogers_internet_usage_page.clkUsageAlerts();
		rogers_account_overview_page.clickOverview();
		rogers_internet_dashboard_page.clkSolarisInternetBadge();
		reporter.reportLogWithScreenshot("Launched the Interent dashboard");
		rogers_internet_dashboard_page.clkSolChangeInternetPackage();
		reporter.reportLogWithScreenshot("Launched the Interent packages page");
		rogers_internet_dashboard_page.selectSolarisInternetPackage(TestDataHandler.solarisInternetAccount.getAccountDetails().getUpgradePlanEn(),TestDataHandler.solarisInternetAccount.getAccountDetails().getUpgradePlanFr());
		reporter.reportLogWithScreenshot("Launched the agreement page"); 
		rogers_order_review_page.verifyAgreementPage();
		reporter.reportLogWithScreenshot("Launched the order review page");
		rogers_order_review_page.verifyAgreement();
		rogers_order_review_page.clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		rogers_order_review_page.clkSubmit();
		rogers_order_confirmation_page.verifyOrderConfirmation();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Update order completed","Update order Failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
	}


	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,strGroupName, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}
