package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to validate the TV dashboard for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
1.Rogers.com landing page is opened successfully
2. Sign in popup is displayed
3. Account overview page displayed
4. Ignite TV dashboard page should be opened
 *
 **/

public class RogersSS_TC_041_AO_ValidateCHaccountBadge_IginteTV extends BaseTestClass {

    @Test(groups = {"RegressionSS","AccountOverviewSS"})
    public void checkTVDashboard() {
        reporter.reportLogWithScreenshot("Launched the Home Page");
        getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc41IgniteTVAccount.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc41IgniteTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame(); 
        //getRogersLoginPage().switchOutOfSignInIFrame();
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc41IgniteTVAccount.accountDetails.getBan());
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Logged in successfully", "Login failed");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkTVBadge();
             
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyViewMyChannelLineUpDisplayed()
        		&& getRogersSolarisTVDashboardPage().verifyViewFlexChannelsDisplayed(), "Ignite TV dashboard page is displayed", "Ignite TV dashboard page NOT displayed correctly please investigate");
        
        reporter.reportLogWithScreenshot("Launched the Ignite TV dashboard Page");     
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

