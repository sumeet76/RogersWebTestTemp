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


public class OneViewCH_TC_018d_Internet_DashboardSupportLinksAvailabilityTest extends BaseTestClass {
    @Test
    public void checkInernetDashboardSupportLinkTest() {
		environment_selection_page.selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		account_over_view_page.selectInternetBadage();
		reporter.reportLogWithScreenshot("Lanched the internet dashboard page ");
		reporter.softAssert(internet_dashboard_page.verifLlnkLearnMoreWallToWallWifi(),"Learn more about wall to wall wifi Link is available","Learn more about wall to wall wifi Link is not available");
		reporter.softAssert(internet_dashboard_page.verifyLnkUnderstandingWifi(),"Understanging wifi link available" ,"Understanging wifi link not available ");		
		reporter.softAssert(internet_dashboard_page.verifyLnkTestInternetSpeed(),"Test internet speed link available","Test internet speed link not available");
		reporter.softAssert(internet_dashboard_page.verifyLnkTipsForPlacingEero(),"Tips for placing eero link available","Tips for placing eero link not available");		
		reporter.softAssert(internet_dashboard_page.verifyLnkHowToOptimizeSpeed(),"How to optimize link available","How to optimize link not available");
		reporter.softAssert(internet_dashboard_page.verifyLnkGoToSupportSection(),"Go to support section link available","Go to support section link not available");
		//internet_dashboard_page.goToPageBottom();
		reporter.reportLogWithScreenshot("All links available ");
		//internet_dashboard_page.goToPageMid();
		//reporter.reportLogWithScreenshot("All links available ");

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


