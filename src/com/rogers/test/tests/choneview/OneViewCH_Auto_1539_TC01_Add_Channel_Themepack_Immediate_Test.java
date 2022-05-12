package com.rogers.test.tests.choneview;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class OneViewCH_Auto_1539_TC01_Add_Channel_Themepack_Immediate_Test extends BaseTestClass {
	@Test (groups = {"AprilSanity","RegressionCHOV"})
	public void oneViewCH_1539_TC01_AddChannelAndThemepackImmediate(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.addChannelAndThempackImmediate.getAccountNo(), TestDataHandler.addChannelAndThempackImmediate.getContactID());
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		reporter.reportLogWithScreenshot("TV Badge");
		getAccountOverViewPage().goToPageBottom();
		getAccountOverViewPage().clickIgniteTVBadge();
		reporter.reportLogWithScreenshot("select bundle");
		getAccountOverViewPage().selectBundleChangeIfPresent();
		reporter.hardAssert(getAccountOverViewPage().verifyTVOrChannelHeader(),"TV or Channel header displayed","TV or Channel header did not Displayed");
		reporter.reportLogWithScreenshot("Ignite TV widget selected");
		getTVDashboardPage().clickManageChannelsAndThemepacks();
		reporter.reportLogWithScreenshot("Customer followed channels and themepacks");
		getTVDashboardPage().clickChannelTab();
		reporter.reportLogWithScreenshot("Channal tab");
		getTVDashboardPage().clickAddChannel();
		reporter.reportLogWithScreenshot("Add channel");
		getTVDashboardPage().clickYourChanges();
		reporter.reportLogWithScreenshot("collapse");
//		getTVDashboardPage().clickManageChannelsAndThemepacks();
//		reporter.reportLogWithScreenshot("manage channel and themepack tab");
//		getTVDashboardPage().clickContinueToCancelOrder();
//		reporter.reportLogWithScreenshot("Cancel the changed ");
		getTVDashboardPage().clickThemepacksTab();
		reporter.reportLogWithScreenshot("themepack tab");
		getTVDashboardPage().clickThemepackTabFromBundle();
		reporter.reportLogWithScreenshot("themepack added");
		getTVDashboardPage().addThemepack();
		//reporter.reportLogWithScreenshot("4k popup");
		//getRogersIgniteBundlesPage().fourKTVPopup();
		//reporter.reportLogWithScreenshot("4k continue");
		//getRogersIgniteBundlesPage().fourKContinue();
//		reporter.reportLogWithScreenshot("4k content continue");
//		getRogersIgniteBundlesPage().fourKContentContinue();
		getTVDashboardPage().clickYourChanges();
		reporter.reportLogWithScreenshot("collapse");
		//getTVDashboardPage().clickYesContinueIfPresent();
		getTVDashboardPage().clickContinueForPackage();
		reporter.reportLogWithScreenshot("continue");
		getTVDashboardPage().immediateDateChangeOption();
		reporter.reportLogWithScreenshot("manage channel and themepack tab");
//		getTVDashboardPage().clickCancel();
//		getTVDashboardPage().clickContinueOnSelectDateChange();
//		reporter.reportLogWithScreenshot("ready to submit");
//		getRogersOVOrderReviewPage().clickSubmitToManageThemepackOrChannel();
//		reporter.reportLogWithScreenshot("Order Confirmation page");

	}

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {closeSession();
	}

}


