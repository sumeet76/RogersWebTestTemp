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


public class RogersCH_TC_051_IgniteSmartStream_ValidateSupportSectionTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","RhpAndRhmCH"})
    public void checkSolarisRHPDasboard() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc51_igniteSmartStream.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc51_igniteSmartStream.getPassword());
 		reporter.reportLogWithScreenshot("Enter the account credentails");
 		getRogersLoginPage().clkSignInIFrame();
 		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
 	    reporter.reportLogWithScreenshot("Skip popup");
 	    getRogersLoginPage().clkSkipIFrame();
 	    getRogersLoginPage().switchOutOfSignInIFrame();
 		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
 	    getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc51_igniteSmartStream.accountDetails.getBan());
 		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersAccountOverviewPage().clkSmartStream();
        reporter.reportLogWithScreenshot("Launched the RHP Dashboard Page");        

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


