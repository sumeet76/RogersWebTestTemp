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
 * Test steps:
1.Rogers.com landing page is opened successfully
2. Sign in popup is displayed
3. Account overview page displayed
4. Tupelo dashboard page should be opened
 *
 **/

public class RogersSS_TC_047_AO_ValidateCHaccountBadge_Tupelo extends BaseTestClass {

    @Test
    public void checkTVDashboard() {
        reporter.reportLogWithScreenshot("Launched the Home Page");
        rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.tc47TupeloAccount.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.tc47TupeloAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
        reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame(); 
        rogers_login_page.switchOutOfSignInIFrame();
        rogers_account_overview_page.selectAccount(TestDataHandler.tc47TupeloAccount.accountDetails.getBan());                    
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Logged in successfully", "Login failed");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_account_overview_page.scrollToMiddleOfPage();
        reporter.reportLogWithScreenshot("Middle of Account Overview Page");
        rogers_account_overview_page.clkEntertainmentBadge();             
        reporter.hardAssert(rogers_solaris_tv_dashboard_page.verifyTupeloDashbaordIsDisplayed(),
        		"Tupelo dashboard page is displayed", 
        		"Tupelo dashboard page NOT displayed correctly please investigate");        
        reporter.reportLogWithScreenshot("Tupelo dashboard Page");     
        common_business_flows.scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Mid page view");
		common_business_flows.scrollToBottomOfWebPage();
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

