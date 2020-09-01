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
		environment_selection_page.selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
/*		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		environment_selection_page.enterDealerCode(TestDataHandler.igniteTVParentalcontrols.getDealercode());
		reporter.reportLogWithScreenshot("Enter the dealer code");
		environment_selection_page.submitDealerCode();	*/
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		account_over_view_page.selectTVBadage(strBrowser);
		reporter.reportLogWithScreenshot("Launched the TV dashboard page");
		
		
		tv_dashboard_page.clickChangeTvPackage();
		reporter.reportLogWithScreenshot("Changed TV Package clicked");
		

		tv_dashboard_page.clickSelectLowestTVPackage();
		reporter.reportLogWithScreenshot("Lowest TV Package selected");

		tv_dashboard_page.clickContinueChangeTVPackage();
		reporter.reportLogWithScreenshot("Continue clicked on change TV Package");
		
		//tv_dashboard_page.clickContinue4kChannelPack();;
		channels_Theme_Packs_Page.clkMinicartContinue();
		reporter.reportLogWithScreenshot("Continue clicked on channels and theme pack page");
		
		tv_dashboard_page.clickContinueOn4kTv();
		reporter.reportLogWithScreenshot("Continue clicked on 4k TV dailog"); 
		
		tv_dashboard_page.clickContinue4kChannelPack();
		reporter.reportLogWithScreenshot("Continue clicked on 4k channels pack");
		
		tv_dashboard_page.clickContinueOnSelectDateChange();
		reporter.reportLogWithScreenshot("Continue clicked on select change date dailog");
	
		reporter.softAssert(order_Review_Page.verifyMonthlyCharges(),"Monthly Charges Displayed","Failed to Navigate to Monthly Charges Page");
		order_Review_Page.clkSubmit();
		reporter.hardAssert(order_Confirmation_Page.verifyOrder(),"Order Placed","Order Failed");
		reporter.reportLogWithScreenshot("Order Placed");
		
		
    }
    
	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaUrl"),strBrowser, strLanguage,strGroupName, "",TestDataHandler.solarisAccount.accountDetails.getBan(),TestDataHandler.chOneViewConfig.getUsrID(), TestDataHandler.chOneViewConfig.getLoginID(),  method);
  	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


