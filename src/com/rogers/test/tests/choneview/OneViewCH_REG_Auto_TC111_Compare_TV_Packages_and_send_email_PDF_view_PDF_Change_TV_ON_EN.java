package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;


public class OneViewCH_REG_Auto_TC111_Compare_TV_Packages_and_send_email_PDF_view_PDF_Change_TV_ON_EN extends BaseTestClass {
	@Test (groups = {"RNAC","RegressionCHOV"})
	public void OneViewCH_REG_Auto_TC111_Compare_TV_Packages_and_send_email_PDF_view_PDF_Change_TV_ON_EN(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.TC023_TVPackageDowngrade.getAccountDetails().getBan(), TestDataHandler.TC023_TVPackageDowngrade.getContactID());
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
//        reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(),"Login Successful","Login Failed");
		reporter.reportLogWithScreenshot("Account Overview page has Launched");
		getAccountOverViewPage().selectInternetBadage();
		getAccountOverViewPage().selectProduction();
		getAccountOverViewPage().clickProceed();
		getInternetDashboardPage().clickChangeInternetPackage();

		/*Click on Compare TV Packages*/
		getRogersIgniteBundlesPage().clkcompareTvPackages();
		reporter.reportLogWithScreenshot("compare package");
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCompareTvPackagePopUp(),"Select packages to compare pop up appears successfully","Select packages to compare pop up didnt appeared");
		reporter.reportLogWithScreenshot("compare package");
		getRogersIgniteBundlesPage().clkcompareChannelLineup();
		reporter.reportLogWithScreenshot("compare package");
		getRogersIgniteBundlesPage().clkemailChannelsPdf();
		reporter.reportLogWithScreenshot("compare package");
		getRogersIgniteBundlesPage().selectPackagesToCompare();
		reporter.reportLogWithScreenshot("compare package");
		//getRogersIgniteBundlesPage().clkViewPdf(mainWidow);
		/*getRogersIgniteBundlesPage().enterCustomerEmail("xtz@mailinator.com");
		reporter.reportLogWithScreenshot("compare package");
		getRogersIgniteBundlesPage().enterConfirmCustomerEmail("xtz@mailinator.com");
		reporter.reportLogWithScreenshot("compare package");*/
getRogersIgniteBundlesPage().clkSendPdf();
		reporter.reportLogWithScreenshot("compare package");
reporter.hardAssert(getRogersIgniteBundlesPage().verifySuccessPdfSend(),"PDF sent Successfully","PDF not sent successfully");
getRogersIgniteBundlesPage().clkCancelPdfResend();
		reporter.reportLogWithScreenshot("compare package");
getRogersIgniteBundlesPage().clkSelectTvPackage();
		reporter.reportLogWithScreenshot("compare package");

		getRogersIgniteBundlesPage().clickFirstAddToCart();
		getTVDashboardPage().clickContinueChannelsAndThemePacks();
		getTVDashboardPage().clickContinueOn4kTv();
		reporter.reportLogWithScreenshot("Continue clicked on 4k TV dailog");
		getTVDashboardPage().clickContinue4kChannelPack();
		reporter.reportLogWithScreenshot("Continue clicked on 4k channels pack");
		getTVDashboardPage().clickContinueOnSelectDateChange();
		reporter.softAssert(getRogersOVOrderReviewPage().verifyMonthlyCharges(),"Monthly Charges Displayed","Failed to Navigate to Monthly Charges Page");
		getRogersOVOrderReviewPage().clkSubmit();

	}

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage,RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","", method);
	}
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


