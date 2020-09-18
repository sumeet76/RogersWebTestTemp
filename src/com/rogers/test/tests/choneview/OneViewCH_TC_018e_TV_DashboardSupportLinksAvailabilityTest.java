package com.rogers.test.tests.choneview;
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


public class OneViewCH_TC_018e_TV_DashboardSupportLinksAvailabilityTest extends BaseTestClass {
    @Test
    public void checkTVDashboardSupportLinkTest() {
    	environment_selection_page.selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		account_over_view_page.selectTVBadage(TestDataHandler.chOneViewConfig.getBrowser());
		reporter.reportLogWithScreenshot("Launched the TV dashboard page");
		reporter.softAssert(tv_dashboard_page.verifyLnkFAQOnPowerSaver(),"FAQ on power saver - Link availability assertion passed","FAQ on power saver - Link availability assertion failed");
		reporter.softAssert(tv_dashboard_page.verifyLnkGoToSupportSection(),"Go to support section - Link availability assertion passed","Go to support section - Link availability assertion failed");
		reporter.softAssert(tv_dashboard_page.verifyLnkIgniteTvErrCode(),"Ignite Tv Error code - Link availability assertion passed","Ignite Tv Error code - Link availability assertion failed");
		reporter.softAssert(tv_dashboard_page.verifyLnkIntroToAppsOnIgniteTv(),"Intro to apps on Ignite Tv- Link availability assertion passed","Intro to apps on Ignite Tv - Link availability assertion failed");
		reporter.softAssert(tv_dashboard_page.verifyLnkUsingVoiceCommands(),"Using voice commands - Link availability assertion passed","Using voice commands - Link availability assertion failed");
		tv_dashboard_page.goToPageBottom();
		reporter.reportLogWithScreenshot("Support links available");		
    }
    
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaUrl"),strBrowser, strLanguage,strGroupName, "",TestDataHandler.solarisAccount.accountDetails.getBan(),TestDataHandler.chOneViewConfig.getUsrID(), TestDataHandler.chOneViewConfig.getLoginID(),  method);
  	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


