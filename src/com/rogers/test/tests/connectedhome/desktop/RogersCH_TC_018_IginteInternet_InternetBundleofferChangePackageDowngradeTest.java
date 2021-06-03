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

public class RogersCH_TC_018_IginteInternet_InternetBundleofferChangePackageDowngradeTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","RogersInternetCH","DryRunCH"})
    public void checkInternetBundleofferChangePackageDowngrade() {
        reporter.reportLogWithScreenshot("Launched the Home Page");
        getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc16_17_18_19_SolarisInternetAccount.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc16_17_18_19_SolarisInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc16_17_18_19_SolarisInternetAccount.accountDetails.getBan());
    	//reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersHomePage().clkExistingCustomerShop();
        getRogersHomePage().clkIgniteTVExistingCustomer();
        reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	getRogersHomePage().clkServiceabilityMigration();
        reporter.reportLogWithScreenshot("Address confirmation popup has lanched to select Ignite Internet speed button"); 
        getRogersBuyPage().clkIgniteInternetSpeed();
        reporter.reportLogWithScreenshot("Launched the TV packge Page"); 
       
        getRogersInternetDashboardPage().selectSolarisInternetPackage(TestDataHandler.tc16_17_18_19_SolarisInternetAccount.getAccountDetails().getDowngradePlanEn(),TestDataHandler.tc16_17_18_19_SolarisInternetAccount.getAccountDetails().getDowngradePlanFr());
        reporter.hardAssert(getRogersInternetDashboardPage().verifyContatUSInternetDowngarde(),"Displayed the contat US popup","Download package has failed");
        reporter.reportLogWithScreenshot("Launched the customercare popup");
    	}                        

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
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


