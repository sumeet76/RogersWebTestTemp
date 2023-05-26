package com.rogers.test.tests.connectedhome.desktop.tv;

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

public class RogersCH_Auto_TC019_SolarisTVCx_InternetBundleofferChangePackageDowngradeTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","RogersInternetCH"})
    public void rogersCH_Auto_TC019_SolarisTVCx_InternetBundleofferChangePackageDowngrade() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getDriver().get(System.getProperty("QaUrl") + "/bundles");
        reporter.reportLogWithScreenshot("Launched the IgniteTV page");
        getRogersHomePage().clkServiceability();
        reporter.reportLogWithScreenshot("Address confirmation popup has launched to select Ignite Internet speed button");
        getRogersHomePage().selectAddressOnFile();
        reporter.reportLogWithScreenshot("Address Selected");
        getRogersBuyPage().clkIgniteInternetSpeed();
        reporter.reportLogWithScreenshot("Launched the TV package Page");
        getRogersInternetDashboardPage().selectSolarisInternetPackage(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getAccountDetails().getDowngradePlanEn(), TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getAccountDetails().getDowngradePlanFr());
        reporter.hardAssert(getRogersInternetDashboardPage().verifyChangePackagePopupHeader(), "Displayed the contat US popup", "Download package has failed");
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


