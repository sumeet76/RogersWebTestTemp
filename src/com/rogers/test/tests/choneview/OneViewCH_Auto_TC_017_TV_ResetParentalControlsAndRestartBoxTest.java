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

public class OneViewCH_Auto_TC_017_TV_ResetParentalControlsAndRestartBoxTest extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV","SanityCHOVTemp"})
    public void checkIgniteTVResetPINandResetParentalControlsTest() {
		//getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.igniteTVParentalcontrols.accountDetails.getBan(),TestDataHandler.igniteTVParentalcontrols.getContactID());
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		getAccountOverViewPage().selectTVBadage();
		reporter.reportLogWithScreenshot("Launched the TV dashboard page");
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
		closeSession();
	}

}


