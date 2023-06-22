package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneviewCH_REG_Auto_TC033_TV_Dashboard_Reset_Parental_Controls_And_RestartBox_ON_EN extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV"})
    public void oneviewCH_REG_Auto_TC033_TV_Dashboard_Reset_ParentalControls_And_RestartBox_ON_EN() {
		//getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.igniteTVParentalcontrols.accountDetails.getBan(),TestDataHandler.igniteTVParentalcontrols.getContactID());
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		getAccountOverViewPage().selectTVBadage();
		reporter.reportLogWithScreenshot("Launched the TV dashboard page");
		getEnvironmentSelectionPage().selectProduction();
		getEnvironmentSelectionPage().clickProceed();
		getTVDashboardPage().goToPageBottom();
		getTVDashboardPage().clickResetParentalControl();
		reporter.reportLogWithScreenshot("Reset Parental Controls popup has launched");		
		getTVDashboardPage().clickContinueReset();
		reporter.reportLogWithScreenshot("Reset Success popup has launched");
        reporter.hardAssert(getTVDashboardPage().verifyResetSuccess(),"Verification of reset success","Reset has  is Failed");	
        reporter.reportLogWithScreenshot("reset success");	
		getTVDashboardPage().clickSuccessOk() ;
		reporter.reportLogWithScreenshot("Launched the TV dashboard page");		
		getTVDashboardPage().clickRestartSetupbox();
		reporter.reportLogWithScreenshot("Restart Setupbox popup has launched");		
		getTVDashboardPage().clickContinueReset();
		reporter.reportLogWithScreenshot("Reset Success popup has launched");
		reporter.hardAssert(getTVDashboardPage().verifyResetSuccess(),"Verification of reset success","Reset has  is Failed");
        reporter.reportLogWithScreenshot("reset success");
		getTVDashboardPage().clickSuccessOk() ;

    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage,RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","", method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		//closeSession();
	}

}


