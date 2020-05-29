package com.rogers.test.tests.choneview;
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
import com.rogers.testdatamanagement.TestDataHandler;




public class OneViewCH_TC_018f_TV_ChannelLineupViewPDFTest extends BaseTestClass {
    @Test
    public void checkChannelLineupAndViewPdf() {
		environment_selection_page.selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		account_over_view_page.selectTVBadage();
		reporter.reportLogWithScreenshot("Lanched the HomePhone dashboard page ");
		tv_dashboard_page.clickViewChannelLineUp();
		reporter.hardAssert(tv_dashboard_page.verifyViewPdf(),"Channel Line up displays view PDF button","View PDF button on channel line up not available- Test failed");
		reporter.reportLogWithScreenshot("Channel Line up Launched and view pdf button available");
		tv_dashboard_page.clickViewPdf();
		reporter.reportLogWithScreenshot("PDF view clicked");
    }
    
	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	public void beforeTest(String strBrowser, String strLanguage,  String strGroupName, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(TestDataHandler.chOneViewConfig.getUrl(),strBrowser, strLanguage,strGroupName, "",TestDataHandler.solarisAccount.accountDetails.getBan(),TestDataHandler.chOneViewConfig.getUsrID(), TestDataHandler.chOneViewConfig.getLoginID(),  method);
  	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


