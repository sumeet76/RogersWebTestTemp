package com.rogers.test.tests.choneview;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class OneViewCH_1539_TC01_AddChannelAndThemepackImmediate extends BaseTestClass {
	@Test (groups = {"RegressionCHOV"})
    public void addChannelAndThemepackImmediate(){
		getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		getAccountOverViewPage().clickNotificationIfPresent();
		getAccountOverViewPage().clickIgniteTVBadge();
		getAccountOverViewPage().selectBundleChangeIfPresent();
		reporter.reportLogWithScreenshot("Ignite TV widget selected");
		getTVDashboardPage().clickManageChannelsAndThemepacks();
		getTVDashboardPage().clickChannelTab();
		getTVDashboardPage().clickAddChannel();
		getTVDashboardPage().clickYourChanges();
		getTVDashboardPage().clickManageChannelsAndThemepacks();
		getTVDashboardPage().clickThemepacksTab();
		getTVDashboardPage().addThemepack();
		getTVDashboardPage().clickYourChanges();
		getTVDashboardPage().clickContinueForPackage();
		getTVDashboardPage().immediateDateChangeOption();
		getTVDashboardPage().clickContinueToManageChannel();
		getRogersOVOrderReviewPage().clickSubmitToManageThemepackOrChannel();
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
		reporter.reportLogWithScreenshot("Order Confirmation page");
    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),TestDataHandler.migrationData.getContactID(), TestDataHandler.migrationData.getAccountNo(),System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


