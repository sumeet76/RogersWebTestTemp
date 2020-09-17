package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to verify  Internet Package downgrade functionality for Rogers.com  
 * 
 * @author aditya.dhingra
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet dashboard
 *4. Click on Change package
 *5. Select a package which has price lower to the current package
 *
 **/

public class RogersCH_TC_025_LegacyInternet_InternetPackageUpgradeTest extends BaseTestClass {
	final String strLanguage=System.getProperty("Language");
	
	@Test(groups = {"RegressionCH","LegacyTVFlowsCH"})
	public void checkInternetPackageUpgrade() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.legacyInternetAccountUpgrade.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.legacyInternetAccountUpgrade.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
	    rogers_account_overview_page.selectAccount(TestDataHandler.legacyInternetAccountUpgrade.accountDetails.getBan());
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
		rogers_account_overview_page.clkInternetPopup(); 
		rogers_internet_dashboard_page.clkChangeInternetPackage();
		reporter.reportLogWithScreenshot("Launched the Internet package Page");
		rogers_internet_package_selection_page.selectInternetPackage(TestDataHandler.legacyInternetAccountUpgrade.getAccountDetails().getUpgradePlanEn(),TestDataHandler.legacyInternetAccountUpgrade.getAccountDetails().getUpgradePlanFr(), strLanguage);
		reporter.reportLogWithScreenshot("Launched the upgrade modem popup");
		rogers_internet_package_selection_page.clkUpgradeContinue();		
		rogers_internet_package_selection_page.clkCheckout();		
		reporter.reportLogWithScreenshot("Launched the Internet checkout Page");
		rogers_order_confirmation_page.clkUpgradeCartCheckOutButton();		
		reporter.reportLogWithScreenshot("Launched the order summary Page");
		rogers_order_summary_page.scrollDownToAgreementForLegacyflow();		
    	rogers_order_summary_page.clkConsentCheckboxLegacyFlow();    	
    	reporter.reportLogWithScreenshot("Consent Check Done");
    	rogers_order_summary_page.clkOrderSubmit();
    	reporter.reportLogWithScreenshot("order confirmation page");
    	reporter.hardAssert(rogers_order_confirmation_page.verifyLegacyUpgardeOrderConfirmation(),"Order has created", "Order hasn't created");
    	reporter.hardAssert(rogers_internet_package_selection_page.verifyDowngradeWaysToBuyBox(), "upgardeways popup has launched", "upgarde has failed");
	}


	
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,strGroupName, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
