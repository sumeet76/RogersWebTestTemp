package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class OneViewCH_Auto_TC007_018c_HomePhoneDashboard_HeaderFooterResetVoiceMail_ON_EN_Test extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV"})
    public void checkHomePhoneHeaderFooterAndResetVoiceMailTest() {
		//getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.solarisAccount.accountDetails.getBan(),TestDataHandler.solarisAccount.getContactID());
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		getAccountOverViewPage().selectHomePhoneBadge();
		reporter.reportLogWithScreenshot("Clicked the HomePhone dashboard icon");
		getAccountOverViewPage().selectProduction();
		reporter.reportLogWithScreenshot("Select Environment as Production");
		getAccountOverViewPage().clickProceed();
		reporter.reportLogWithScreenshot("Lanched the HomePhone dashboard page ");		
		reporter.softAssert(getHomePhonedashboard().verifyHeader(),"Header is available","Verification of Header failed");
		reporter.reportLogWithScreenshot("Header available on Home Phone Dashboard page");
		reporter.softAssert(getHomePhonedashboard().verifyFooter(),"Footer is available","Verification of Header failed");
		reporter.reportLogWithScreenshot("Footer available on Home Phone Dashboard page");
		/*home_phone_dashboard.goToPageMid();
		reporter.reportLogWithScreenshot("Moved to middle of the page");*/
		getHomePhonedashboard().clickResetVoiceMail();
		reporter.reportLogWithScreenshot("Reset Voice mail button clicked");
		getHomePhonedashboard().clickYesResetPassword();;
		reporter.reportLogWithScreenshot("Yes clicked on the reset voicemail link pop up to continue");
		reporter.hardAssert(getHomePhonedashboard().verifySuccess(),"Verification of reset success","Reset has Failed with a technical error");
        reporter.reportLogWithScreenshot("reset success");
    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage,RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","", "", method);
  	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}
}


