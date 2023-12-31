package com.rogers.test.tests.connectedhome.desktop.legacy;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to validate the Solaris home phone dashboard for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 * Launch Rogers.com in QA env
 * Sign-in with valid credential( RHP 1.5 account)
 * click on shop and select Internet from the drop down
 * click on check availability
 * Validate change package message is removed in the modal
 * Validate use this address button
 * Click on use this address and validate another modal advice user to call or live chat
 *
 **/


public class RogersCH_Auto_TC042_LegacyRHPCx_ValidateOrderInternetHome extends BaseTestClass {

	@Test(groups = {"RegressionCH","IHP","saiCH"})
    public void rogersCH_Auto_TC042_LegacyRHPCx_ValidateOrderInternet() {
		String strAddressLine1 = TestDataHandler.tc04_08_SolarisTVAccount.getAccountDetails().getAddress().get("line1");
		String strAddressLine2 = TestDataHandler.tc04_08_SolarisTVAccount.getAccountDetails().getAddress().get("line2");

		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc37_legacyRHP.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc37_legacyRHP.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc37_legacyRHP.accountDetails.getBan());
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getDriver().get(System.getProperty("QaUrl") + "/internet/");
		reporter.hardAssert(getRogersHomePage().verifyInternetpage(), "Internet page has Launched", "Internet page has not Launched");
		reporter.reportLogWithScreenshot("Launched the Internet packages page");
		getRogersHomePage().clkInternetAvailability();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		getRogersHomePage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
		getRogersHomePage().clkIgniteAddressLookupSubmit();
		reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
		getRogersInternetPackageSelectionPage().clkInternetPackage();
		reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
		reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyCartSummaryHeader(), "Cart Summary Page page has Launched", "Cart Summary Page page has not Launched");
		getRogersInternetPackageSelectionPage().clkInternetBuyContinue();
		reporter.hardAssert(getRogersInternetProfilePage().verifyProfilePageSAI(), "Profile page has Launched", "Profile page has not Launched");
		reporter.reportLogWithScreenshot("Launched the create profile page");

	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


