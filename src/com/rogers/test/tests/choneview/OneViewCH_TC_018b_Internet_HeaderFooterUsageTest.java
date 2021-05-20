package com.rogers.test.tests.choneview;
import java.io.IOException;
import java.lang.reflect.Method;

import com.rogers.test.helpers.RogersEnums;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;                 
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;


public class OneViewCH_TC_018b_Internet_HeaderFooterUsageTest extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV"})
    public void checkInternetHeaderFooterAndUsage() {
		getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		getAccountOverViewPage().selectInternetBadage();
		reporter.reportLogWithScreenshot("Lanched the internet dashboard page ");
		reporter.softAssert(getInternetDashboardPage().verifyHeader(),"Header is available","Verification of Header failed");
		reporter.reportLogWithScreenshot("Header available on Internet Dashboard page");
		reporter.softAssert(getInternetDashboardPage().verifyFooter(),"Footer is available","Verification of Header failed");
		reporter.reportLogWithScreenshot("Footer available on Internet Dashboard page");
		reporter.softAssert(getInternetDashboardPage().verifLlnkLearnMoreWallToWallWifi(),"Learn more about wall to wall wifi Link is available","Learn more about wall to wall wifi Link is not available");
		getInternetDashboardPage().clickbtnUsageAndAlerts();
		reporter.reportLogWithScreenshot("Internet usage page launched");
		reporter.softAssert(getRogersInternetUsageOVPage().verifyDailyBreakdownTable(System.getProperty("Browser")),"Verification for break down table passed","Verification for breakdown table failed");
		reporter.reportLogWithScreenshot("Daily Break down table available");
		getRogersInternetUsageOVPage().clkMonthlyUsage(System.getProperty("Browser"));
		reporter.reportLogWithScreenshot("Monthly Usage page launched");
		reporter.softAssert(getRogersInternetUsageOVPage().verifyMonthlyBreakdownTable(System.getProperty("Browser")),"Verification for monthly down table passed","Verification for breakdown table failed");
		reporter.reportLogWithScreenshot("Monthly Break down table available");
		getRogersInternetUsageOVPage().clkUsageAlerts(System.getProperty("Browser"));
		reporter.reportLogWithScreenshot("Usage Alers Page launched");
		}

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage,RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.solarisAccount.getContactID(), TestDataHandler.solarisAccount.accountDetails.getBan(), System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
    }


	@AfterMethod(alwaysRun = true)
	public void afterTest(ITestResult res) {
		closeSession();
	}

}


