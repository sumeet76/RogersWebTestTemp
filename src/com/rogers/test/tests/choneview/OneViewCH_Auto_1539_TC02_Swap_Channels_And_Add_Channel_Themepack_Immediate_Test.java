package com.rogers.test.tests.choneview;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class OneViewCH_Auto_1539_TC02_Swap_Channels_And_Add_Channel_Themepack_Immediate_Test extends BaseTestClass {
	@Test (groups = {"RChannelsandThemepacks","RegressionCHOV"})
	public void oneViewCH_1539_TC01_AddChannelAndThemepackImmediate() {
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.addChannelAndThempackImmediate.getswapAccountNo(), TestDataHandler.addChannelAndThempackImmediate.getswapContactID());
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		reporter.reportLogWithScreenshot("TV Badge");
		getAccountOverViewPage().clickIgniteTVBadge();
		reporter.reportLogWithScreenshot("select bundle");
		getAccountOverViewPage().selectBundleChangeIfPresent();
		reporter.hardAssert(getAccountOverViewPage().verifyTVOrChannelHeader(), "TV or Channel header displayed", "TV or Channel header did not Displayed");

		reporter.reportLogWithScreenshot("Launched the TV dashboard page");
		getTVDashboardPage().clickChangePackage();
		reporter.reportLogWithScreenshot("Changed TV Package clicked");
		getTVDashboardPage().selectFirstTVPackage();
		reporter.reportLogWithScreenshot("Upgrade TV Package selected");
		getTVDashboardPage().clickContinueChangeTVPackage();
		reporter.reportLogWithScreenshot("Continue clicked on change TV Package");


		reporter.reportLogWithScreenshot("Exchange Options");
		getRogersIgniteExchangePage().clickExchangeNow();
		reporter.reportLogWithScreenshot("Exchange Now");
		getRogersIgniteExchangePage().verifyChannelToSwapHeader();
		getRogersIgniteExchangePage().selectFirstChannelToRemove();
		reporter.reportLogWithScreenshot("first channel selected");
		getRogersIgniteExchangePage().clickSelectButton();
		reporter.reportLogWithScreenshot("button select");
		getRogersIgniteExchangePage().selectFirstChannelToAdd();
		reporter.reportLogWithScreenshot("first channel to Add");
		getRogersIgniteExchangePage().clickSelectButton();
		reporter.reportLogWithScreenshot("Channel Swapped");
		getRogersIgniteExchangePage().clkContinue();


		getTVDashboardPage().clickAddChannel();
		reporter.reportLogWithScreenshot("add channel");
		getTVDashboardPage().clickThemepacksTab();

		reporter.reportLogWithScreenshot("themepack tab from bundle");
		getTVDashboardPage().clickThemepackTabFromBundle();
		reporter.reportLogWithScreenshot("themepack options");
		getTVDashboardPage().addThemepack();
		reporter.reportLogWithScreenshot("add themepack ");

		reporter.reportLogWithScreenshot("Continue");
		getCustomerProfilePage().clkContinue();


		reporter.reportLogWithScreenshot("4k popup");
		getRogersIgniteBundlesPage().fourKTVPopup();
		reporter.reportLogWithScreenshot("4k continue");
		getRogersIgniteBundlesPage().fourKContinue();
		reporter.reportLogWithScreenshot("4k content continue");
//		getRogersIgniteBundlesPage().fourKContentContinue();



//		reporter.reportLogWithScreenshot("continue");
		getTVDashboardPage().immediateDateChangeOption();
		reporter.reportLogWithScreenshot("manage channel and themepack tab");
		getTVDashboardPage().clickContinueOnSelectDateChange();
		reporter.reportLogWithScreenshot("ready to submit");
		getRogersOVOrderReviewPage().clickSubmitOrder();
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

