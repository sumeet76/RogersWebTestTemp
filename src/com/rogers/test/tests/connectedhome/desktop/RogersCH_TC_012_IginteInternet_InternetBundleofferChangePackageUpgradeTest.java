package com.rogers.test.tests.connectedhome.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

/**
 * This class contains the test method to verify the solaris bundle change package upgrade flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com url
 *2. Log into rogers.com url with valid Solaris Account credentials that has either Select or Popular bundle associated to the account/Profile
 *3. Go to Shop menu and select Ignite TV option
 *4. Go to Ignite TV bundle section, and select bundle that is higher than the current bundle and click on Add to Cart
 *5. Click on Ignite Internet speed
 *6. Go to bundle section and click on Rogers Ignite bundle that is higher price than the current bundle
 *7. Validate appropriate information is displayed in Review order page
 *8. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *9. Order confirmation page will be displayed with the order number and validate the order details
 *
 **/

public class RogersCH_TC_012_IginteInternet_InternetBundleofferChangePackageUpgradeTest extends BaseTestClass {

    @Test
    public void checkSolarisBundleofferChangePackageUpgrade() {
        reporter.reportLogWithScreenshot("Launched the Home Page");
        rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.solarisInternetAccountForUpgrade.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.solarisInternetAccountForUpgrade.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
    	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        rogers_account_overview_page.selectAccount(TestDataHandler.solarisInternetAccountForUpgrade.accountDetails.getBan());
    	reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_home_page.clkExistingCustomerShop();
        rogers_home_page.clkIgniteTVExistingCustomer();
        reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	rogers_home_page.clkServiceabilityMigration();  
        reporter.reportLogWithScreenshot("Address confirmation popup has lanched to select Ignite Internet speed button"); 
        rogers_buy_page.clkIgniteInternetSpeed();
        reporter.reportLogWithScreenshot("Launched the TV packge Page"); 
        rogers_internet_dashboard_page.selectSolarisInternetPackage(TestDataHandler.solarisInternetAccountForUpgrade.getAccountDetails().getUpgradePlanEn(),TestDataHandler.solarisInternetAccountForUpgrade.getAccountDetails().getUpgradePlanFr());
        reporter.reportLogWithScreenshot("Launched the Interent packages confirm OK popup"); 
    	reporter.hardAssert(rogers_order_review_page.verifyAgreementPageInternet(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");
		
		reporter.hardAssert(rogers_order_review_page.verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        rogers_order_review_page.clkAcceptenceCheckboxUpdateInternet();
        reporter.reportLogWithScreenshot("Agreement details");
        rogers_order_review_page.clkSubmitUpdateInternet();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmationNew(),"Update order completed","Update order Failed");
        reporter.reportLogWithScreenshot("Verified the Confirmation page"); 
    	}
	
	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(String strBrowser, String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.rogersConfig.getRogersURL(), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_ignitelogin, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}


