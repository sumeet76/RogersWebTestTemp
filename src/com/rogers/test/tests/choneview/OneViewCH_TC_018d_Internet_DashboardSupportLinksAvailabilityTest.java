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
		getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		getAccountOverViewPage().selectInternetBadage();
		reporter.reportLogWithScreenshot("Lanched the internet dashboard page ");
		reporter.softAssert(getInternetDashboardPage().verifLlnkLearnMoreWallToWallWifi(),"Learn more about wall to wall wifi Link is available","Learn more about wall to wall wifi Link is not available");
		reporter.softAssert(getInternetDashboardPage().verifyLnkUnderstandingWifi(),"Understanging wifi link available" ,"Understanging wifi link not available ");
		reporter.softAssert(getInternetDashboardPage().verifyLnkTestInternetSpeed(),"Test internet speed link available","Test internet speed link not available");
		reporter.softAssert(getInternetDashboardPage().verifyLnkTipsForPlacingEero(),"Tips for placing eero link available","Tips for placing eero link not available");
		reporter.softAssert(getInternetDashboardPage().verifyLnkHowToOptimizeSpeed(),"How to optimize link available","How to optimize link not available");
		reporter.softAssert(getInternetDashboardPage().verifyLnkGoToSupportSection(),"Go to support section link available","Go to support section link not available");
		//getInternetDashboardPage().goToPageBottom();
		reporter.reportLogWithScreenshot("All links available ");
		//getInternetDashboardPage().goToPageMid();
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


