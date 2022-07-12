package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class OneViewCH_Auto_1618_TC01_E2E_MoveMigrationNotSupported extends BaseTestClass {
	@Test (groups = {"RMigration","RegressionCHOV"})
    public void oneViewCH_Auto_1618_TC01_E2E_MoveMigrationNotSupported(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData.getaccountNoMigrationNotSupported(), TestDataHandler.migrationData.getContactIDMigrationNotSupported());

		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		reporter.reportLogWithScreenshot("click ignite");
		getAccountOverViewPage().clickIgnite();
		reporter.reportLogWithScreenshot("check availaiblity");

		getRogersIgniteBundlesPage().clickOtherAddress();
		reporter.reportLogWithScreenshot("OtherAddress");
		getRogersIgniteBundlesPage().enterNewAddress(TestDataHandler.migrationData.getAddress());
		reporter.reportLogWithScreenshot("NewAddress");
		getRogersIgniteBundlesPage().clickAvailability();
		reporter.reportLogWithScreenshot("Availability");
	//	getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("Continue");
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyMoveMigration(),"Move Migration displayed","Move Migration did not display");
		getRogersIgniteBundlesPage().clickYes();
	//	reporter.hardAssert(getRogersIgniteBundlesPage().verifyMoveMigrationNotSupported(),"warning Move Migration Not Supported","warning Move Migration Not Supported  display");
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


