package com.rogers.test.tests.choneview;
import java.io.IOException;
import java.lang.reflect.Method;


import com.rogers.test.helpers.RogersEnums;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;                 
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;




public class OneViewCH_TC_018d_TV_ChannelLineupViewPDFTest extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV","SanityCHOVTemp"})
    public void checkChannelLineupAndViewPdf() {
		getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		getAccountOverViewPage().selectTVBadage();
		reporter.reportLogWithScreenshot("Lanched the HomePhone dashboard page ");
		getTVDashboardPage().clickViewChannelLineUp();
		reporter.hardAssert(getTVDashboardPage().verifyViewPdf(),"Channel Line up displays view PDF button","View PDF button on channel line up not available- Test failed");
		reporter.reportLogWithScreenshot("Channel Line up Launched and view pdf button available");
		getTVDashboardPage().clickViewPdf();
		reporter.reportLogWithScreenshot("PDF view clicked");
    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage,RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.solarisTV.getContactID(), TestDataHandler.solarisTV.accountDetails.getBan(), System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


