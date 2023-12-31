package com.rogers.test.tests.choneview;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

	public class OneViewCH_Auto_1543_TC01_Add_Channels_Immediate_Test extends BaseTestClass {
	@Test (groups = {"RChannelsandThemepacks","RegressionCHOV"})
    public void oneViewCH_Auto_1543_TC01_Add_Channels_Immediate_Test(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.addChannelImmediate.getAccountNo(), TestDataHandler.addChannelImmediate.getContactID());
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		getAccountOverViewPage().clickIgniteTVBadge();
		reporter.reportLogWithScreenshot("TV Ignite clicked");
		getAccountOverViewPage().selectBundleChangeIfPresent();
		reporter.hardAssert(getAccountOverViewPage().verifyTVOrChannelHeader(),"TV or Channel header displayed","TV or Channel header did not Displayed");
		reporter.reportLogWithScreenshot("Ignite TV widget selected");
		getTVDashboardPage().clickManageChannelsAndThemepacks();
//		reporter.hardAssert(getAccountOverViewPage().verifyCustomerFollowingsHeader(),"Customer followings displayed","Customer followings did not Displayed");
		reporter.reportLogWithScreenshot("Customer followed channels and themepacks");
		getTVDashboardPage().clickChannelTab();
		reporter.reportLogWithScreenshot("Ignite TV widget selected");
		getTVDashboardPage().clickAddChannel();
		reporter.reportLogWithScreenshot("add channel");
		getTVDashboardPage().clickContinueForPackage();
		reporter.reportLogWithScreenshot("continue");
		getTVDashboardPage().immediateDateChangeOption();
		reporter.reportLogWithScreenshot("date change option");
		getTVDashboardPage().continueFromChangeDate();
//		getRogersOVOrderReviewPage().clickSubmitToManageThemepackOrChannel();
//		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
//		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
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


