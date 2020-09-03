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


public class OneViewCH_TC_020_TV_ChannelSwapTest extends BaseTestClass {
    @Test @Parameters("strBrowser")
    public void checkChannelSwapTest(String strBrowser) {
		environment_selection_page.selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
/*		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		environment_selection_page.enterDealerCode(TestDataHandler.igniteTVParentalcontrols.getDealercode());
		reporter.reportLogWithScreenshot("Enter the dealer code");
		environment_selection_page.submitDealerCode();	*/
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		account_over_view_page.selectTVBadage(strBrowser);
		reporter.reportLogWithScreenshot("Launched the TV dashboard page");
		tv_dashboard_page.clickExchangeFlexChannels();
		reporter.reportLogWithScreenshot("Exchange Flex Channel button clicked");	
		//tv_dashboard_page.clickSearchChannelToRemove();
		//reporter.reportLogWithScreenshot("Search Icon clicked on the Remove Channel Section");
		tv_dashboard_page.clickFirstChannelToRemove();
		reporter.reportLogWithScreenshot("First Channel on the remove list clicked");
		tv_dashboard_page.clickSelectChannelRemove();
		reporter.reportLogWithScreenshot("Select button clicked");
		tv_dashboard_page.clickSecondChannelToRemove();
		reporter.reportLogWithScreenshot("Second Channel on the remove list clicked");
		tv_dashboard_page.clickSelectChannelRemove();
		reporter.reportLogWithScreenshot("Select button clicked");
		//tv_dashboard_page.clickSearchChannelToAdd();
		//reporter.reportLogWithScreenshot("Search Icon clicked on the Add Channel Section");
		tv_dashboard_page.clickFirstChannelToAdd();
		reporter.reportLogWithScreenshot("First Channel on the add list clicked");
		tv_dashboard_page.clickSelectChannelAdd();
		reporter.reportLogWithScreenshot("Select button clicked");
		tv_dashboard_page.clickSecondChannelToAdd();
		reporter.reportLogWithScreenshot("Second Channel on the add list clicked");
		tv_dashboard_page.clickSelectChannelAdd();
		reporter.reportLogWithScreenshot("Select button clicked");
		tv_dashboard_page.clickConfirmExchange(strBrowser);
		reporter.reportLogWithScreenshot("Confirm Exchange button clicked");
		tv_dashboard_page.clickOK();
		reporter.reportLogWithScreenshot("Clicked Ok on the exhange channel pop up");
		reporter.hardAssert(tv_dashboard_page.verifyResetSuccess(),"Channel exchange completed successfully- Passed","Channel exchange not completed - Failed");	
        reporter.reportLogWithScreenshot("Swap channel success");
		tv_dashboard_page.clickSuccessOk() ;
		
    }
    
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaUrl"),strBrowser, strLanguage,strGroupName, "",TestDataHandler.solarisAccount.accountDetails.getBan(),TestDataHandler.chOneViewConfig.getUsrID(), TestDataHandler.chOneViewConfig.getLoginID(),  method);
  	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


