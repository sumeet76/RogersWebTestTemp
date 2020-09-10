package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;



public class RogersSS_TC_102_PACMAN_ValidateTheVAScancelFlowFreeTrialNSEInfinite50 extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	    //xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		 
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(groups = {"SanitySS","RegressionSS","CancelSubscription"})
    public void validateSignInAndAccountOverview() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		//TestDataHandler.tc013132.getUsername()
		//TestDataHandler.tc013132.getPassword()
        rogers_login_page.setUsernameIFrame("cancellation001@mailinator.com");
        rogers_login_page.setPasswordIFrame("rogers123");
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        rogers_login_page.clkSignInIFrame();
        reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();

        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	//TestDataHandler.tc013132.getAccountDetails().getBan()
        	rogers_account_overview_page.selectAccount("937131852");       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Passed", "Login Failed");
        
        common_business_flows.scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("CTNS or Subscriptions View");
        reporter.hardAssert(rogers_account_overview_page.verifyIfSubscriptionIsAvailableForCancellation(), 
        		"The subscription is available for Cancellation", 
        		"The subscription is NOT available for Cancellation");
        rogers_account_overview_page.clkManageOnSubscription();
        reporter.hardAssert(rogers_account_overview_page.verifyIfCurrentlySubscribedPaneIsDisplayed(), 
        		"The current subscription is displayed", 
        		"The current subscription is NOT displayed");
        reporter.reportLogWithScreenshot("Current subscription");
        rogers_account_overview_page.clkCancelSubscription();
        reporter.reportLogWithScreenshot("Cancel subscription details is displayed");
        reporter.hardAssert(rogers_account_overview_page.verifyIfHeaderCancelSubscriptionIsDisplayed(), 
        		"The header cancel subscription is displayed", 
        		"The header cancel subscription is NOT displayed");
        reporter.hardAssert(rogers_account_overview_page.verifyIfCancelSubscriptionDetailsIsDisplayedCorrectly("4165004630"), 
        		"The cancel subscription details matched", 
        		"The cancel subscription details did not matched");        
        rogers_account_overview_page.selectReasonForCancelSubscription();
        reporter.reportLogWithScreenshot("reason for cancel subscription is selected");
        /*rogers_account_overview_page.clkConfirmCancelSubscription();
        reporter.hardAssert(rogers_account_overview_page.verifyIfCancelSuccessfulOverLayDisplayed(), 
        		"The cancel subscription success overlay is displayed", 
        		"The cancel subscription success overlay not displayed");  
        rogers_account_overview_page.clkOKButtonOnCancelSuccessOverlay();
        reporter.hardAssert(rogers_account_overview_page.verifyIfSMPIsDisplayedWithCancelledSubscription(), 
        		"The Subscription management page shows the cancelled CTN subscription", 
        		"The Subscription management page does NOT shows the cancelled CTN subscription");
        		*/
    }

  

}
