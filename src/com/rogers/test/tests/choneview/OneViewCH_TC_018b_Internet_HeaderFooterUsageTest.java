package com.rogers.test.tests.choneview;
import java.io.IOException;
import java.lang.reflect.Method;

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
    @Test @Parameters("strBrowser")
    public void checkInternetHeaderFooterAndUsage(String strBrowser) {
		environment_selection_page.selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
/*		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		environment_selection_page.enterDealerCode(TestDataHandler.igniteTVParentalcontrols.getDealercode());
		reporter.reportLogWithScreenshot("Enter the dealer code");
		environment_selection_page.submitDealerCode();	*/
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		account_over_view_page.selectInternetBadage();
		reporter.reportLogWithScreenshot("Lanched the internet dashboard page ");
		reporter.softAssert(internet_dashboard_page.verifyHeader(),"Header is available","Verification of Header failed");
		reporter.reportLogWithScreenshot("Header available on Internet Dashboard page");
		reporter.softAssert(internet_dashboard_page.verifyFooter(),"Footer is available","Verification of Header failed");
		reporter.reportLogWithScreenshot("Footer available on Internet Dashboard page");
		internet_dashboard_page.clickbtnUsageAndAlerts();
		reporter.reportLogWithScreenshot("Internet usage page launched");
		//reporter.softAssert(rogers_internet_usage_ov_page.verifyDailyBreakdownTable(strBrowser),"Verification for break down table passed","Verification for breakdown table failed");
		reporter.reportLogWithScreenshot("Daily Break down table available");
		rogers_internet_usage_ov_page.clkMonthlyUsage(strBrowser);
		reporter.reportLogWithScreenshot("Monthly Usage page launched");
		reporter.softAssert(rogers_internet_usage_ov_page.verifyMonthlyBreakdownTable(strBrowser),"Verification for monthly down table passed","Verification for breakdown table failed");
		reporter.reportLogWithScreenshot("Monthly Break down table available");
		rogers_internet_usage_ov_page.clkUsageAlerts(strBrowser);
		reporter.reportLogWithScreenshot("Usage Alers Page launched");
		}
    
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,String strGroupName, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaUrl"),strBrowser, strLanguage,strGroupName, "",TestDataHandler.solarisAccount.accountDetails.getBan(),TestDataHandler.chOneViewConfig.getUsrID(), TestDataHandler.chOneViewConfig.getLoginID(),  method);
  	}


	@AfterMethod(alwaysRun = true)
	public void afterTest(ITestResult res) {
		closeSession();
	}

}


