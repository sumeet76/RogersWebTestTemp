package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;


/**
 * This class contains the test method to validate the Solaris home phone dashboard for Rogers.com   
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the Homephone badge.
 *
 *
 *"Expected:
1.Rogers.com landing page is opened successfully
2. Sign in popup is displayed
3. Account overview page displayed
4. Ignite RHP dashboard page should be opened"
 **/


public class RogersSS_TC_043_AO_ValidateCHaccountBadge_IgniteRHP extends BaseTestClass {

    @Test(groups = {"RegressionSS","AccountOverviewSS"})
    public void checkSolarisRHPDasboard() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc43IgniteRHP.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc43IgniteRHP.getPassword());
 		reporter.reportLogWithScreenshot("Enter the account credentails");
 		getRogersLoginPage().clkSignInIFrame();
 		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
 		reporter.reportLogWithScreenshot("Skip popup");
 		getRogersLoginPage().clkSkipIFrame();
 		//getRogersLoginPage().switchOutOfSignInIFrame();
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc43IgniteRHP.accountDetails.getBan());
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Login Success","Login Failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisRHPDashboardPage().clkSolarisRHPBadge(System.getProperty("Browser"));
        reporter.reportLogWithScreenshot("Clicked on RHP badge");
        reporter.hardAssert(getRogersSolarisRHPDashboardPage().verifyConfigureYourCurrentFeatures(),
        		"Verification of Configure Your Current Features link is success",
        		"Verification of Configure Your Current Features link is Failed");        
        reporter.reportLogWithScreenshot("RHP Dashboard page is opened correctly");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Mid page view");
		getCommonBusinessFlows().scrollToBottomOfWebPage();
		reporter.reportLogWithScreenshot("Bottom View");
        
    }
    
    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
   	

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


