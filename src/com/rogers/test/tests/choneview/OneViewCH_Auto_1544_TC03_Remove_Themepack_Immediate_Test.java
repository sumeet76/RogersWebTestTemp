package com.rogers.test.tests.choneview;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class OneViewCH_Auto_1544_TC03_Remove_Themepack_Immediate_Test extends BaseTestClass {
	@Test (groups = {"RegressionCHOV"})
    public void OneViewCH_1544_TC01_AddThemepackImmediate(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.RemoveThemepack1544Tc03.getAccountDetails().getBan(), TestDataHandler.RemoveThemepack1544Tc03.getContactID());
		reporter.reportLogWithScreenshot("Account Overview page has Launched");
		reporter.reportLogWithScreenshot("TV Ignite Badge");
		getAccountOverViewPage().clickIgniteTVBadge();
		reporter.reportLogWithScreenshot("Landed in Tv Dashboard page");
		getTVDashboardPage().clickManageChannelsAndThemepacks();
		reporter.reportLogWithScreenshot("Channels and themepacks section gets expanded");

		/*To verify the count of added themepacks and list their names*/
		reporter.hardAssert(getTVDashboardPage().verifyExistingThemepack(),"Existing themepack section dsiplayed","Cusomter do not have any existing themepack");
		reporter.reportLogWithScreenshot("Totally"+ getTVDashboardPage().getExistingThemepackCount()+"Themepacks are added in the account");
		reporter.reportLogWithScreenshot("The existing themepacks are"+getTVDashboardPage().getExistingThemepackNames());


		/*To Remove the specifed Themepack*/
		getTVDashboardPage().removeThemepack(TestDataHandler.RemoveThemepack1544Tc03.getAccountDetails().getThemepackNameEn(),TestDataHandler.RemoveThemepack1544Tc03.getAccountDetails().getThemepackNameFr());
		reporter.hardAssert(getTVDashboardPage().verifyYourChangeSection(),"Selected themepack is listed in the changes section","Your change section is not visible");
        getTVDashboardPage().yourChangeContinue();

        /*Select the Billing cycle date*/
		getTVDashboardPage().immediateDateChangeOption();
		reporter.reportLogWithScreenshot("Immediate Billing option is selected");
		getTVDashboardPage().continueFromChangeDate();

		reporter.reportLogWithScreenshot("Navigated to review order page");
		//getRogersOVReviewOrderPage().clkSubmitOrderBtn();
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


