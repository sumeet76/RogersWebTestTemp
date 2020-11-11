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
		getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
/*		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getEnvironmentSelectionPage().enterDealerCode(TestDataHandler.igniteTVParentalcontrols.getDealercode());
		reporter.reportLogWithScreenshot("Enter the dealer code");
		getEnvironmentSelectionPage().submitDealerCode();	*/
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		getAccountOverViewPage().selectTVBadage(strBrowser);
		reporter.reportLogWithScreenshot("Launched the TV dashboard page");
		getTVDashboardPage().clickExchangeFlexChannels();
		reporter.reportLogWithScreenshot("Exchange Flex Channel button clicked");	
		//getTVDashboardPage().clickSearchChannelToRemove();
		//reporter.reportLogWithScreenshot("Search Icon clicked on the Remove Channel Section");
		getTVDashboardPage().clickFirstChannelToRemove();
		reporter.reportLogWithScreenshot("First Channel on the remove list clicked");
		getTVDashboardPage().clickSelectChannelRemove();
		reporter.reportLogWithScreenshot("Select button clicked");
		getTVDashboardPage().clickSecondChannelToRemove();
		reporter.reportLogWithScreenshot("Second Channel on the remove list clicked");
		getTVDashboardPage().clickSelectChannelRemove();
		reporter.reportLogWithScreenshot("Select button clicked");
		//getTVDashboardPage().clickSearchChannelToAdd();
		//reporter.reportLogWithScreenshot("Search Icon clicked on the Add Channel Section");
		getTVDashboardPage().clickFirstChannelToAdd();
		reporter.reportLogWithScreenshot("First Channel on the add list clicked");
		getTVDashboardPage().clickSelectChannelAdd();
		reporter.reportLogWithScreenshot("Select button clicked");
		getTVDashboardPage().clickSecondChannelToAdd();
		reporter.reportLogWithScreenshot("Second Channel on the add list clicked");
		getTVDashboardPage().clickSelectChannelAdd();
		reporter.reportLogWithScreenshot("Select button clicked");
		getTVDashboardPage().clickConfirmExchange(strBrowser);
		reporter.reportLogWithScreenshot("Confirm Exchange button clicked");
		getTVDashboardPage().clickOK();
		reporter.reportLogWithScreenshot("Clicked Ok on the exhange channel pop up");
		reporter.hardAssert(getTVDashboardPage().verifyResetSuccess(),"Channel exchange completed successfully- Passed","Channel exchange not completed - Failed");	
        reporter.reportLogWithScreenshot("Swap channel success");
		getTVDashboardPage().clickSuccessOk() ;
		
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


