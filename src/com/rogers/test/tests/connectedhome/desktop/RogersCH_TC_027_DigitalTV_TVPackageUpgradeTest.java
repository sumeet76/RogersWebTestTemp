package com.rogers.test.tests.connectedhome.desktop;

import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

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

public class RogersCH_TC_027_DigitalTV_TVPackageUpgradeTest extends BaseTestClass {

	@Test
	public void checkTVPackageUpgrade() {
		reporter.reportLogWithScreenshot("Launched the Easy Login Page");
		rogers_home_page.clkEasyLogin();
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.digitalTVAccountUpgradePackage.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.digitalTVAccountUpgradePackage.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
	    rogers_account_overview_page.selectAccount(TestDataHandler.digitalTVAccountUpgradePackage.accountDetails.getBan());
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");		
		rogers_account_overview_page.clkTVBadge();
		reporter.reportLogWithScreenshot("Launched the TV Dashboard Page");
		rogers_digital_tv_dashboard_page.clkChangeMyPackage();
		String strLanguage = TestDataHandler.rogersConfig.getLanguage();
		if (strLanguage.equals("en"))
		{
		reporter.reportLogWithScreenshot("Launched the TV package Page");
		rogers_digital_tv_package_selection_page.selectPackageUpgarde(TestDataHandler.digitalTVAccountUpgradePackage.getAccountDetails().getUpgradePlanEn(),TestDataHandler.digitalTVAccount.getAccountDetails().getUpgradePlanFr());
		rogers_digital_tv_package_selection_page.clkCheckout();
		reporter.reportLogWithScreenshot("Launched the TV checkout Page");
		rogers_order_confirmation_page.clkUpgradeCartCheckOutButton();
		reporter.reportLogWithScreenshot("Launched the order summary Page");
		rogers_order_summary_page.scrollDownToAgreementForLegacyflow();		
    	rogers_order_summary_page.clkConsentCheckboxLegacyFlow();    	
    	reporter.reportLogWithScreenshot("Consent Check Done");
    	rogers_order_summary_page.clkOrderSubmit();
    	reporter.reportLogWithScreenshot("order confirmation page");
    	reporter.hardAssert(rogers_order_confirmation_page.verifyLegacyUpgardeOrderConfirmation(),"Order has created", "Order hasn't created");
		}	
		else
		{
		reporter.hardAssert(rogers_digital_tv_dashboard_page.verifyContactCustomercarePopupForFr(),"Downgrade ways popup has launched", "Downgrade has failed");
		}
    	}		


	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.rogersConfig.getRogersURL(),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_legacylogin, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}
}
