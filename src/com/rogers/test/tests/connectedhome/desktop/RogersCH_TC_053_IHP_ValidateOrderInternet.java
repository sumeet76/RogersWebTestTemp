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
 * This class contains the test method to validate the Solaris home phone dashboard for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the Homephone badge.
 *
 **/


public class RogersCH_TC_053_IHP_ValidateOrderInternet extends BaseTestClass {

	@Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void checkSolarisRHPDasboard() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc42_igniteRHP.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc42_igniteRHP.getPassword());
 		reporter.reportLogWithScreenshot("Enter the account credentails");
 		getRogersLoginPage().clkSignInIFrame();
 		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
 	    reporter.reportLogWithScreenshot("Skip popup");
 	    getRogersLoginPage().clkSkipIFrame();
 	    getRogersLoginPage().switchOutOfSignInIFrame();
 		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
 	    getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc42_igniteRHP.accountDetails.getBan());
 		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersAccountOverviewPage().clkRHPBadge();
        reporter.reportLogWithScreenshot("Launched the RHP Dashboard Page");

        getRogersHomePage().clkEasyInternet();
		reporter.hardAssert(getRogersHomePage().verifyInternetpage(),"Internet page has Launched","Internet page has not Launched");
		reporter.reportLogWithScreenshot("Launched the Internet packages page");
		getRogersHomePage().clkInternetAvailability();
		reporter.reportLogWithScreenshot("Launched the customer availability check popup");
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		String  strAddressLine1=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line1");
		String  strAddressLine2=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line2");
		getRogersHomePage().setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
		getRogersHomePage().clkIgniteAddressLookupSubmit();
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


