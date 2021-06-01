package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_126_PSEF_DP_Rogers_CR_EN_SubscribedSection_NSEInfinite50 extends BaseTestClass {
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	    //xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		 
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(groups = {"RegressionSS","PACMAN"})
    public void validateSignInAndAccountOverview() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc102.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc102.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc102.getAccountDetails().getBan());       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Passed", "Login Failed");
        
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("CTNS or Subscriptions View");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfDPSubscriptionIsAvailableForCancellation(),
        		"The subscription is available for Cancellation", 
        		"The subscription is NOT available for Cancellation");
        getRogersAccountOverviewPage().clkManageOnSubscription();
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfCurrentlySubscribedPaneIsDisplayed(), 
        		"The current subscription is displayed", 
        		"The current subscription is NOT displayed");
        reporter.reportLogWithScreenshot("Current subscription");
        getRogersAccountOverviewPage().clkCancelSubscription();
        reporter.reportLogWithScreenshot("Cancel subscription details is displayed");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfHeaderCancelSubscriptionIsDisplayed(), 
        		"The header cancel subscription is displayed", 
        		"The header cancel subscription is NOT displayed");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfCancelSubscriptionDetailsIsDisplayedCorrectly(TestDataHandler.tc102.getAccountDetails().getCtn()), 
        		"The cancel subscription details matched", 
        		"The cancel subscription details did not matched");        
        getRogersAccountOverviewPage().selectReasonForCancelSubscription();
        reporter.reportLogWithScreenshot("reason for cancel subscription is selected");
        getRogersAccountOverviewPage().clkConfirmCancelSubscription();
        reporter.reportLogWithScreenshot("Confirm button clicked");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfCancelSuccessfulOverLayDisplayed(), 
        		"The cancel subscription success overlay is displayed", 
        		"The cancel subscription success overlay not displayed");  
        reporter.reportLogWithScreenshot("cancel success overlay displayed");
        getRogersAccountOverviewPage().clkOKButtonOnCancelSuccessOverlay();
        reporter.reportLogWithScreenshot("Cliked on OKay button");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfSMPIsDisplayedWithCancelledSubscription(), 
        		"The Subscription management page shows the cancelled CTN subscription", 
        		"The Subscription management page does NOT shows the cancelled CTN subscription");
        reporter.reportLogWithScreenshot("Subscription management page shows the cancelled subscription");
        		
    }

  

}
