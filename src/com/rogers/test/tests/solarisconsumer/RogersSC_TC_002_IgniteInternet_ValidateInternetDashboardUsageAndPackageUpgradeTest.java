package com.rogers.test.tests.solarisconsumer;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



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
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc31_SolarisInternetAccountWithUsageAndPackageUpgrade.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc31_SolarisInternetAccountWithUsageAndPackageUpgrade.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		reporter.softAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Logged in successfully", "Login failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersInternetDashboardPage().clkSolarisInternetBadge();
		reporter.reportLogWithScreenshot("Launched the Interent dashboard");
		reporter.softAssert(getRogersInternetDashboardPage().verifyInternet(), "Verified the Internet page", "Internet page verification failed");
		reporter.softAssert(getRogersInternetDashboardPage().verifyUsageAndAlerts(), "Usage and Alerts link present on the internet dash page", "Usage and Alerts link is not present on the internet page");
		getRogersInternetDashboardPage().clkInternetUsageAlerts();
		reporter.reportLogWithScreenshot("Launched the UsageAlerts page");
		getRogersInternetUsagePage().verifyDailyBreakdown();
		getRogersInternetUsagePage().verifyDailyBreakdownTable();
		reporter.reportLogWithScreenshot("Daily Breakdown details");
		reporter.softAssert(getRogersInternetUsagePage().verifyDailyBreakdownTable(), "Verified the daily usage", "Daily usage deatils are not present");
		getRogersInternetUsagePage().clkMonthlyUsage();
		reporter.reportLogWithScreenshot("Monthly Breakdown details");
		getRogersInternetUsagePage().verifyMonthlyBreakdownTable();
		getRogersInternetUsagePage().clkUsageAlerts();
		getRogersAccountOverviewPage().clickOverview();
		getRogersInternetDashboardPage().clkSolarisInternetBadge();
		reporter.reportLogWithScreenshot("Launched the Interent dashboard");
		getRogersInternetDashboardPage().clkSolChangeInternetPackage();
		reporter.reportLogWithScreenshot("Launched the Interent packages page");
		getRogersInternetDashboardPage().selectSolarisInternetPackage(TestDataHandler.tc16_17_18_19_SolarisInternetAccount.getAccountDetails().getUpgradePlanEn(),TestDataHandler.tc16_17_18_19_SolarisInternetAccount.getAccountDetails().getUpgradePlanFr());
		reporter.reportLogWithScreenshot("Launched the agreement page"); 
		getRogersOrderReviewPage().verifyAgreementPage();
		reporter.reportLogWithScreenshot("Launched the order review page");
		getRogersOrderReviewPage().verifyAgreement();
		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		getRogersOrderConfirmationPage().verifyOrderConfirmation();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Update order completed","Update order Failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
	}


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
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
