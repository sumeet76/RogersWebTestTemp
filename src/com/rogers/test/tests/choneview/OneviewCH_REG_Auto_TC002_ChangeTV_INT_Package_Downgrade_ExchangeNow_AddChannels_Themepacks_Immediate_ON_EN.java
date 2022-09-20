package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
/*
"1. Language - EN
2. Province - ON
3. Change Type - Change TV and Internet package. (Downgrade)
4. Add-Ons - Exchange Flex channels and Add any Channels & Themepacks.
5. Bill Cycle - Immediate."
 */

public class OneviewCH_REG_Auto_TC002_ChangeTV_INT_Package_Downgrade_ExchangeNow_AddChannels_Themepacks_Immediate_ON_EN extends BaseTestClass {
	@Test (groups = {"RegressionCHOV"})
    public void oneviewCH_REG_Auto_TC002_ChangeTV_INT_Package_Downgrade_ExchangeNow_AddChannels_Themepacks_Immediate_ON_EN() {
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.Change_TV_Channel_Themepack_Immediate_Downgrade.accountDetails.getBan(),TestDataHandler.Change_TV_Channel_Themepack_Immediate_Downgrade.getContactID());
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		reporter.reportLogWithScreenshot("deal code");
		getAccountOverViewPage().clickIgniteTVBadge();
		reporter.reportLogWithScreenshot("TV Batch");
		reporter.hardAssert(getAccountOverViewPage().verifyTVOrChannelHeader(),"TV or Channel header displayed","TV or Channel header did not Displayed");
		reporter.reportLogWithScreenshot("Ignite TV widget selected");
		getTVDashboardPage().clickChangePackage();
		reporter.reportLogWithScreenshot("change package button selected");
		getInternetDashboardPage().selectPlanUnderTvPackage(TestDataHandler.Change_TV_Channel_Themepack_Immediate_Downgrade.accountDetails.getDowngradeTvPlanEn(),TestDataHandler.Change_TV_Channel_Themepack_Immediate_Downgrade.accountDetails.getDowngradeInternetPlanEn());
		reporter.reportLogWithScreenshot("Lowest Internet Package selected");
		getInternetDashboardPage().clickContinueChangeInternetPackage();
		reporter.reportLogWithScreenshot("Continue clicked on change Internet Package");
		//getTVDashboardPage().clickExchangeNow();
		getTVDashboardPage().clickRemoveChannel();
		getTVDashboardPage().clickSelectChannelRemove();
		getTVDashboardPage().clickAddChannelBtn();
		getTVDashboardPage().clickSelectChannelAdd();
		reporter.reportLogWithScreenshot("add channel");
		getTVDashboardPage().clickContinueBottomOfPage();
		getTVDashboardPage().selectStandaloneChannelsTab();
		getRogersOVChannelsAndThemePacksPage().clickAddChannel();
		getRogersOVChannelsAndThemePacksPage().clickThemepacksTab();
		getRogersOVChannelsAndThemePacksPage().addThemepack();
		getRogersOVChannelsAndThemePacksPage().clkContinue();
		getRogersOVChannelsAndThemePacksPage().clickYesTheyDo();
		getTVDashboardPage().clickContinue4kChannelPack();
		getTVDashboardPage().immediateDateChangeOption();
		reporter.reportLogWithScreenshot("Immediate date");
		getTVDashboardPage().continueFromChangeDate();
		reporter.reportLogWithScreenshot("Continue");

		getRogersOVOrderReviewPage().clickSubmitOrder();
		reporter.reportLogWithScreenshot("Order Confirmation page");
	}

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","", method);
    }

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		//closeSession();
	}

}


