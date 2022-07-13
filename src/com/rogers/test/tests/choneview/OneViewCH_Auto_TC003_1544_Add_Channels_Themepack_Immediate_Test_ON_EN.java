package com.rogers.test.tests.choneview;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class OneViewCH_Auto_TC003_1544_Add_Channels_Themepack_Immediate_Test_ON_EN extends BaseTestClass {
	@Test (groups = {"RegressionCHOV"})
	public void oneViewCH_1544_TC01_AddThemepackImmediate(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.addThemepackImmediate.getAccountNo(), TestDataHandler.addThemepackImmediate.getContactID());
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		reporter.reportLogWithScreenshot("Enter dealer code if present");
		getAccountOverViewPage().clickAccountOverview();
		reporter.reportLogWithScreenshot("clicked on account overview arrow-down to see the customer address");
		reporter.hardAssert(getAccountOverViewPage().verifyProvince(),"ON address displayed","ON address doesn't displayed");
//		getAccountOverViewPage().goToPageBottom();
		getAccountOverViewPage().clickIgniteTVBadge();
		reporter.reportLogWithScreenshot("TV Ignite Badge");
		reporter.hardAssert(getTVDashboardPage().verifyManageChannelsAndThemepacks(),"Manage Channel and Theme pack Displayed","Manage channel and theme pack doesn't displayed");
		reporter.reportLogWithScreenshot("Click on Manage Channel and Theme Packs");
		getTVDashboardPage().clickManageChannelsAndThemepacks();
		reporter.hardAssert(getAccountOverViewPage().verifyCustomerFollowingsHeader(),"Customer followings displayed","Customer followings did not Displayed");
		reporter.reportLogWithScreenshot("Customer followed channels and themepacks");
		getTVDashboardPage().clickChannelTab();
		reporter.reportLogWithScreenshot("Ignite TV widget selected");
		getTVDashboardPage().clickAddChannel();
		reporter.reportLogWithScreenshot("add channel");
		getTVDashboardPage().clickYourChanges();
		getTVDashboardPage().clickThemepacksTab();
		reporter.reportLogWithScreenshot("Themepack tab");

		getTVDashboardPage().clickThemepackTabFromBundle();
		reporter.reportLogWithScreenshot("themepack added");
		getTVDashboardPage().addThemepack();
		getTVDashboardPage().clickYourChanges();
		reporter.reportLogWithScreenshot("Theme pack added and click on continue");
	//	getRogersIgniteBundlesPage().fourKTVPopup();
	//	reporter.reportLogWithScreenshot("4k continue");
	//	getRogersIgniteBundlesPage().fourKContinue();


		getTVDashboardPage().clickYesContinueIfPresent();
		reporter.reportLogWithScreenshot("continue for package");
		getTVDashboardPage().clickContinueForPackage();
		reporter.reportLogWithScreenshot("immediate date");
		getTVDashboardPage().immediateDateChangeOption();
//		reporter.reportLogWithScreenshot("Collapse");
		getTVDashboardPage().continueFromChangeDate();
		getRogersOVOrderReviewPage().clkSubmit();
		reporter.reportLogWithScreenshot("Order Confirmation page");
	}

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}