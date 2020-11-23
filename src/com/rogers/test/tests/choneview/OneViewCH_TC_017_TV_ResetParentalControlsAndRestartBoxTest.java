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



public class OneViewCH_TC_017_TV_ResetParentalControlsAndRestartBoxTest extends BaseTestClass {
    @Test @Parameters("strBrowser")
    public void checkIgniteTVResetPINandResetParentalControlsTest(String strBrowser) {
		getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
/*		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getEnvironmentSelectionPage().enterDealerCode(TestDataHandler.igniteTVParentalcontrols.getDealercode());
		reporter.reportLogWithScreenshot("Enter the dealer code");
		getEnvironmentSelectionPage().submitDealerCode();	*/
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		getAccountOverViewPage().selectTVBadage(strBrowser);
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
    
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaUrl"),  strBrowser, strLanguage,strGroupName,"", TestDataHandler.igniteTVParentalcontrols.accountDetails.getBan(),TestDataHandler.chOneViewConfig.getUsrID(), TestDataHandler.chOneViewConfig.getLoginID(),method);
		  	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


