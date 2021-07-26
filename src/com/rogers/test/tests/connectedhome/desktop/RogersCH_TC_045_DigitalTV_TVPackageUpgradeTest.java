package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to verify  DigitalTV Package downgrade functionality for Rogers.com  
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Log into rogers.com url with valid credentials.
 *3. Click on TV dashboard
 *4. Click on Change package
 *5. Select a package which has price lower to the current package
 *
 **/

public class RogersCH_TC_045_DigitalTV_TVPackageUpgradeTest extends BaseTestClass {
	final String strLanguage=System.getProperty("Language");

	@Test(groups = {"RegressionCH","LegacyDashboardCH"})
	public void checkTVPackageUpgrade() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc45_digitalTVAccountUpgradePackage.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc45_digitalTVAccountUpgradePackage.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    getRogersLoginPage().clkSkipIFrame();
	    getRogersLoginPage().switchOutOfSignInIFrame();
	    getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc45_digitalTVAccountUpgradePackage.accountDetails.getBan());
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");		
		getRogersAccountOverviewPage().clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");
		getRogersDigitalTVDashboardPage().clkChangeMyPackage();
		if (strLanguage.equals("en"))
		{
		reporter.reportLogWithScreenshot("Launched the TV package Page");
		getRogersDigitalTVPackageSelectionPage().selectPackageUpgarde(TestDataHandler.tc45_digitalTVAccountUpgradePackage.getAccountDetails().getUpgradePlanEn(),TestDataHandler.tc45_digitalTVAccountUpgradePackage.getAccountDetails().getUpgradePlanFr());
		getRogersDigitalTVPackageSelectionPage().clkCheckout();
		reporter.reportLogWithScreenshot("Launched the TV checkout Page");
		getRogersOrderConfirmationPage().clkUpgradeCartCheckOutButton();
		reporter.reportLogWithScreenshot("Launched the order summary Page");
		getRogersOrderSummaryPage().scrollDownToAgreementForLegacyflow();
    	getRogersOrderSummaryPage().clkConsentCheckboxLegacyFlow();
    	reporter.reportLogWithScreenshot("Consent Check Done");
    	getRogersOrderSummaryPage().clkOrderSubmit();
    	reporter.reportLogWithScreenshot("order confirmation page");
    	reporter.hardAssert(getRogersOrderConfirmationPage().verifyLegacyUpgardeOrderConfirmation(),"Order has created", "Order hasn't created");
		}	
		else
		{
		reporter.hardAssert(getRogersDigitalTVDashboardPage().verifyContactCustomercarePopupForFr(),"Downgrade ways popup has launched", "Downgrade has failed");
		}
    	}		


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		//closeSession();
	}
}
