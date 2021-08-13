package com.rogers.test.tests.choneview;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_TC_022_TV_PackageDowngradeTest extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV"})
    public void checkTVPackageDowngrade() {
		//getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.TC023_TVPackageDowngrade.getAccountDetails().getBan(), TestDataHandler.TC023_TVPackageDowngrade.getContactID());
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		getAccountOverViewPage().selectTVBadage();
		reporter.reportLogWithScreenshot("Launched the TV dashboard page");
		getTVDashboardPage().clickChangeTvPackage();
		reporter.reportLogWithScreenshot("Changed TV Package clicked");
		getTVDashboardPage().clickSelectLowestTVPackage();
		reporter.reportLogWithScreenshot("Lowest TV Package selected");

		//For Flex Channels - Exchange Later
        getTVDashboardPage().clickContinueChangeTVPackage();
        reporter.reportLogWithScreenshot("Continue clicked on change TV Package");
        getTVDashboardPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Exchange later is selected");

		getTVDashboardPage().clickContinueChannelsAndThemePacks();
		getTVDashboardPage().clickContinueOn4kTv();
		reporter.reportLogWithScreenshot("Continue clicked on 4k TV dailog"); 
		getTVDashboardPage().clickContinue4kChannelPack();
		reporter.reportLogWithScreenshot("Continue clicked on 4k channels pack");
		getTVDashboardPage().clickContinueOnSelectDateChange();
		reporter.softAssert(getRogersOVOrderReviewPage().verifyMonthlyCharges(),"Monthly Charges Displayed","Failed to Navigate to Monthly Charges Page");
		getRogersOVOrderReviewPage().clkSubmit();
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
		reporter.reportLogWithScreenshot("Order Placed");
    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage,RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "", "", "", method);
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


