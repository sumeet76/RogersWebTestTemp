package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class OneViewCH_Auto_1537_TC01_TV_Channel_Themepack_Immediate_Downgrade_Test extends BaseTestClass {
	@Test (groups = {"RegressionCHOV"})
    public void oneViewCH_1537_TC01_TV_ChannelThemepackImmediateDowngrade() {
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData.getAccountNo(),TestDataHandler.migrationData.getContactID() );
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		reporter.reportLogWithScreenshot("deal code");
		getAccountOverViewPage().clickIgniteTVBadge();
		reporter.reportLogWithScreenshot("TV Batch");
		getAccountOverViewPage().selectBundleChangeIfPresent();
		reporter.reportLogWithScreenshot("Select Bundle");
		reporter.hardAssert(getAccountOverViewPage().verifyTVOrChannelHeader(),"TV or Channel header displayed","TV or Channel header did not Displayed");
		reporter.reportLogWithScreenshot("Ignite TV widget selected");
		getTVDashboardPage().clickManageChannelsAndThemepacks();
//		reporter.hardAssert(getAccountOverViewPage().verifyCustomerFollowingsHeader(),"Customer followings displayed","Customer followings did not Displayed");
		reporter.reportLogWithScreenshot("Manage channels and themepacks");
		getTVDashboardPage().clickFirstChannelToRemove();
		reporter.reportLogWithScreenshot("first channel remove");
//		getTVDashboardPage().clickYourChanges();
//		reporter.reportLogWithScreenshot("collapse");
//		getTVDashboardPage().getAllChannelAndThemepacks();
//		reporter.reportLogWithScreenshot("all channels and themepacks");
		getTVDashboardPage().clickAddChannel();
		reporter.reportLogWithScreenshot("add channel");
//		getTVDashboardPage().clickYourChanges();
//		reporter.reportLogWithScreenshot("Collapse");
		getTVDashboardPage().clickContinueChannelsAndThemePacks();
		reporter.reportLogWithScreenshot("Continue channels and themepacks");
		getTVDashboardPage().immediateDateChangeOption();
		reporter.reportLogWithScreenshot("Immediate date");
		getTVDashboardPage().continueFromChangeDate();
		reporter.reportLogWithScreenshot("Continue");

//		getRogersOVOrderReviewPage().clickSubmitToManageThemepackOrChannel();
//		reporter.reportLogWithScreenshot("Order Confirmation page");
	}

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","", method);
    }

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


