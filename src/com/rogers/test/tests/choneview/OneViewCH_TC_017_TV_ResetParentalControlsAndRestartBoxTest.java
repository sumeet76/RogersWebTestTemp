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



public class OneViewCH_TC_017_TV_ResetParentalControlsAndRestartBoxTest extends BaseTestClass {
    @Test @Parameters("strBrowser")
    public void checkIgniteTVResetPINandResetParentalControlsTest(String strBrowser) {
		environment_selection_page.selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
/*		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		environment_selection_page.enterDealerCode(TestDataHandler.igniteTVParentalcontrols.getDealercode());
		reporter.reportLogWithScreenshot("Enter the dealer code");
		environment_selection_page.submitDealerCode();	*/
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		account_over_view_page.selectTVBadage(strBrowser);
		reporter.reportLogWithScreenshot("Launched the TV dashboard page");
		tv_dashboard_page.clickResetParentalControl();
		reporter.reportLogWithScreenshot("Reset Parental Controls popup has launched");		
		tv_dashboard_page.clickContinueReset();
		reporter.reportLogWithScreenshot("Reset Success popup has launched");
        reporter.hardAssert(tv_dashboard_page.verifyResetSuccess(),"Verification of reset success","Reset has  is Failed");	
        reporter.reportLogWithScreenshot("reset success");	
		tv_dashboard_page.clickSuccessOk() ;
		reporter.reportLogWithScreenshot("Launched the TV dashboard page");		
		tv_dashboard_page.clickRestartSetupbox();
		reporter.reportLogWithScreenshot("Restart Setupbox popup has launched");		
		tv_dashboard_page.clickContinueReset();
		reporter.reportLogWithScreenshot("Reset Success popup has launched");
        reporter.hardAssert(tv_dashboard_page.verifyResetSuccess(),"Verification of reset success","Reset has  is Failed");	
        reporter.reportLogWithScreenshot("reset success");
		tv_dashboard_page.clickSuccessOk() ;
    }
    
	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(TestDataHandler.chOneViewConfig.getUrl(),  strBrowser, strLanguage,strGroupName,"", TestDataHandler.igniteTVParentalcontrols.accountDetails.getBan(),TestDataHandler.chOneViewConfig.getUsrID(), TestDataHandler.chOneViewConfig.getLoginID(),method);
		  	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


