package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * This class contains the test method to test the IgniteTV buy flow for Rogers.com   
 * 
 * @author manpreet.kaur3
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on a TV account
 *4. Click on chage package button
 *5. Choose a tv package whose price is higher than the current package and click on Submit
 *6. Click on Continue Change TV package Popup
 *7. Click Exchange Later
 *8. Go to ThemePacks tab and add Prime Pack
 *9. Click on Continue on Mini Cart
 *10. Go to Agreement section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit
 *
 **/

public class RogersCH_Auto_TC076_SolarisTVCx_NewConstruct_NewStarter_PrimeTimeThemepack_ChangeTVflowTest extends BaseTestClass {

    @Test(groups = {"RegressionCH",""})
	public void rogersCH_Auto_TC076_SolarisTVCx_NewConstruct_NewStarter_PrimeTimeThemepack_ChangeTVflow() {
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc15_solarisTVAccountStarterPackage.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc15_solarisTVAccountStarterPackage.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc15_solarisTVAccountStarterPackage.accountDetails.getBan());
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersSolarisTVDashboardPage().clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV dash board");
		getRogersSolarisTVDashboardPage().clkChangeTVPackage();
		reporter.reportLogWithScreenshot("Launched the TV packages page");
		getRogersSolarisTVDashboardPage().selectSolarisTVPackage(TestDataHandler.tc15_solarisTVAccountStarterPackage.accountDetails.getUpgradePlanEn(),TestDataHandler.tc10_SolarisTVAccountForUpgrade.accountDetails.getUpgradePlanFr());
		reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackagePopUp(),"Displayed the Change TV Package popup","Download package has failed");
		getRogersSolarisTVDashboardPage().clkPopupChangeTVPackage();
		reporter.reportLogWithScreenshot("Launched the personalize channel page");
		getRogersSolarisTVChannelsAndThemepacksPage().clkExchangeLater();
		reporter.reportLogWithScreenshot("Launched the channels and themepacks page");
		getRogersSolarisTVChannelsAndThemepacksPage().clkThemePacks();
		reporter.reportLogWithScreenshot("Launched the themepacks page");
		getRogersSolarisTVChannelsAndThemepacksPage().clkAddPrimePack();
		reporter.reportLogWithScreenshot("Add prime pack");
		reporter.hardAssert(getRogersSolarisTVChannelsAndThemepacksPage().verifyPrimePackAdded(), "Prime Pack Added", "Prime pack not added");
		getRogersSolarisTVChannelsAndThemepacksPage().clkContinueMiniCart();
		reporter.reportLogWithScreenshot("Clicked continue MiniCart");

		reporter.reportLogWithScreenshot("Launched the 4K enquiry popup");
		getRogersSolarisTVChannelsAndThemepacksPage().clkNoIDontHave4K();
		reporter.reportLogWithScreenshot("Launched the Order Review page");

		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");;
		getRogersOrderReviewPage().clkAcceptenceCheckboxUpdate();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmitUpdateTV();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Update order completed","Update order Failed");
		reporter.reportLogWithScreenshot("Verified the Confirmation page");

	}
	   
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


