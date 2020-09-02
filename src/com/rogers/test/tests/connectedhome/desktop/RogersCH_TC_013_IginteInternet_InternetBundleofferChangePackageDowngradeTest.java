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
 * This class contains the test method to verify the solaris bundle change package downgrade flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid Solaris Account credentials.
 *3. Go to Shop menu and select Ignite TV option.
 *4. Go to Ignite TV bundle section, and select bundle that is lower than the current bundle and click on Add to Cart
 *5. Click on Ignite Internet speed.
 *6. Go to bundle section and click on Rogers Ignite bundle that is lower price than the current bundle.
 *
 **/

public class RogersCH_TC_013_IginteInternet_InternetBundleofferChangePackageDowngradeTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","RogersInternetCH"})
    public void checkInternetBundleofferChangePackageDowngrade() {
        reporter.reportLogWithScreenshot("Launched the Home Page");
        rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.solarisInternetAccount.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.solarisInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
    	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        rogers_account_overview_page.selectAccount(TestDataHandler.solarisInternetAccount.accountDetails.getBan());
    	//reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_home_page.clkExistingCustomerShop();
        rogers_home_page.clkIgniteTVExistingCustomer();
        reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	rogers_home_page.clkServiceabilityMigration();
        reporter.reportLogWithScreenshot("Address confirmation popup has lanched to select Ignite Internet speed button"); 
        rogers_buy_page.clkIgniteInternetSpeed();
        reporter.reportLogWithScreenshot("Launched the TV packge Page"); 
       
        rogers_internet_dashboard_page.selectSolarisInternetPackage(TestDataHandler.solarisInternetAccount.getAccountDetails().getDowngradePlanEn(),TestDataHandler.solarisInternetAccount.getAccountDetails().getDowngradePlanFr());
        reporter.hardAssert(rogers_internet_dashboard_page.verifyContatUSInternetDowngarde(),"Displayed the contat US popup","Download package has failed");        
        reporter.reportLogWithScreenshot("Launched the customercare popup");
    	}                        

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


