package com.rogers.test.tests.choneview;
import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class OneViewCH_TC_022_TV_PackageDowngradeTest extends BaseTestClass {
    @Test @Parameters("strBrowser")
    public void checkTVPackageDowngrade(String strBrowser) {
		getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
/*		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getEnvironmentSelectionPage().enterDealerCode(TestDataHandler.igniteTVParentalcontrols.getDealercode());
		reporter.reportLogWithScreenshot("Enter the dealer code");
		getEnvironmentSelectionPage().submitDealerCode();	*/
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		getAccountOverViewPage().selectTVBadage(strBrowser);
		reporter.reportLogWithScreenshot("Launched the TV dashboard page");
		
		
		getTVDashboardPage().clickChangeTvPackage();
		reporter.reportLogWithScreenshot("Changed TV Package clicked");
		

		getTVDashboardPage().clickSelectLowestTVPackage();
		reporter.reportLogWithScreenshot("Lowest TV Package selected");

		getTVDashboardPage().clickContinueChangeTVPackage();
		reporter.reportLogWithScreenshot("Continue clicked on change TV Package");
		
		//getTVDashboardPage().clickContinue4kChannelPack();;
		getRogersOVChannelsAndThemePacksPage().clkMinicartContinue();
		reporter.reportLogWithScreenshot("Continue clicked on channels and theme pack page");
		
		getTVDashboardPage().clickContinueOn4kTv();
		reporter.reportLogWithScreenshot("Continue clicked on 4k TV dailog"); 
		
		getTVDashboardPage().clickContinue4kChannelPack();
		reporter.reportLogWithScreenshot("Continue clicked on 4k channels pack");
		
		getTVDashboardPage().clickContinueOnSelectDateChange();
		reporter.reportLogWithScreenshot("Continue clicked on select change date dailog");
	
		reporter.softAssert(getRogersOVOrderReviewPage().verifyMonthlyCharges(),"Monthly Charges Displayed","Failed to Navigate to Monthly Charges Page");
		getRogersOVOrderReviewPage().clkSubmit();
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
		reporter.reportLogWithScreenshot("Order Placed");
		
		
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


