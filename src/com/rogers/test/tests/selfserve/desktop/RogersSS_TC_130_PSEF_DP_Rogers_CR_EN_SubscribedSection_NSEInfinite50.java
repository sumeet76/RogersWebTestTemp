package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_130_PSEF_DP_Rogers_CR_EN_SubscribedSection_NSEInfinite50 extends BaseTestClass {
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	    //xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		 
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

	
	@Test(groups = {"RegressionSS","PSEF","DisneyPlus"})
    public void validateSignInAndAccountOverview() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc130.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc130.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc130.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Passed", "Login Failed");
        
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("CTNS or Subscriptions View");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfDPSubscriptionIsAvailableForCancellation(),
        		"Subscription Management page is displayed ",
        		"Subscription Management page is Not displayed ");
        getRogersAccountOverviewPage().clkManageOnSubscriptionDisneyPlus();
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfCurrentlySubscribedPaneIsDisplayed(), 
        		"The current subscription is displayed", 
        		"The current subscription is NOT displayed");
        reporter.reportLogWithScreenshot("Current subscription");
        reporter.softAssert(getRogersPSEFPage().verifyIfSMPDisplaysActiveTrialWLSubscriptionsInAlphabeticalOrder(),
                "SMP displays Active Trial WL Subscriptions in alphabetical order",
                "SMP did NOT display Active Trial WL Subscriptions in alphabetical order");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("Current subscription mid view");
        reporter.softAssert(getRogersPSEFPage().verifyIfSMPDisplaysPendinTrialWLSubscriptionsInAlphabeticalOrder(),
                "SMP displays Pending WL Subscription  in alphabetical order",
                "SMP did NOT display Pending WL Subscription  in alphabetical order");

        		
    }

  

}
