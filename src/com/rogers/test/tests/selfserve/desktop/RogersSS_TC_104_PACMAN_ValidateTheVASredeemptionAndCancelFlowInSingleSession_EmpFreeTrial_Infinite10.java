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



public class RogersSS_TC_104_PACMAN_ValidateTheVASredeemptionAndCancelFlowInSingleSession_EmpFreeTrial_Infinite10 extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	    xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(groups = {"RegressionSS","PACMANRedeem"})
    public void verifyTheOrderSummaryPageOfVASsubscriptionRedemptionFlow_SEInfinite20() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(TestDataHandler.tc104.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.tc104.getPassword());
        String strCTN =TestDataHandler.tc104.getAccountDetails().getCtn();
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        rogers_login_page.clkSignInIFrame();
        reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login proceed.",
        		"Login got error.");
        rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();

        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	rogers_account_overview_page.selectAccount(TestDataHandler.tc104.getAccountDetails().getBan());       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Passed", "Login Failed");
        
        common_business_flows.scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("CTNS or Subscriptions View");
        reporter.hardAssert(rogers_account_overview_page.verifySubscriptionIsAvailableForRedeem(), 
        		"The subscription is available for redeem", 
        		"The subscription is NOT available for redeem");
        
        rogers_account_overview_page.clkSignUpSubscription();
        reporter.hardAssert(rogers_account_overview_page.verifyIfSubscriptionIsAvailableForRedeem(), 
        		"The current subscription redeem selection is displayed", 
        		"The current subscription is redeem selection is NOT displayed");
        reporter.reportLogWithScreenshot("Current subscription for redeem");
        rogers_account_overview_page.checkRedeem();
        reporter.reportLogWithScreenshot("Current subscription check box seletced for redeem");
        rogers_account_overview_page.clkSignUp();
        reporter.hardAssert(rogers_account_overview_page.verifyIfRedeemSubscriptionDetailsIsDisplayedCorrectly(strCTN), 
        		"The cancel subscription details matched", 
        		"The cancel subscription details did not matched");          
        common_business_flows.scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("T and C page");
        reporter.hardAssert(rogers_account_overview_page.verifyIfTnCForSubscriptionIsDisplayed(), 
        		"The Subscription TnC is displayed", 
        		"The Subscription TnC is NOT displayed");
       
        rogers_account_overview_page.checkTnC();
        reporter.reportLogWithScreenshot("T and C check box is selected");
        rogers_account_overview_page.clkSubscribeToSubs();   
        reporter.reportLogWithScreenshot("Subscription button clicked");
        reporter.hardAssert(rogers_account_overview_page.verifyIfSubscriptionSuccessfulOverLayDisplayed(), 
        		"The subscription success overlay is displayed", 
        		"The subscription success overlay not displayed");  
        reporter.reportLogWithScreenshot("Subscription success overlay displayed");
        rogers_account_overview_page.clkOKButtonOnSubscriptionSuccessOverlay();
        reporter.reportLogWithScreenshot("Cliked on OKay button");        
        reporter.hardAssert(rogers_account_overview_page.verifyIfSMPIsDisplayedWithSubscribedCTN(strCTN), 
        		"The Subscription management page SMP shows the subscribed CTNs in Currently Subscribed Section", 
        		"The Subscription management page does NOT shows the SMP shows the subscribed CTNs in Currently Subscribed Section");
        reporter.reportLogWithScreenshot("Subscription management page shows the subscribed CTNs in Currently Subscribed Section");
        
        reporter.hardAssert(rogers_account_overview_page.verifyIfCurrentlySubscribedPaneIsDisplayed(), 
        		"The current subscription is displayed", 
        		"The current subscription is NOT displayed");
        reporter.reportLogWithScreenshot("Current subscription");
        rogers_account_overview_page.clkCancelSubscription();
        reporter.reportLogWithScreenshot("Cancel subscription details is displayed");
        reporter.hardAssert(rogers_account_overview_page.verifyIfHeaderCancelSubscriptionIsDisplayed(), 
        		"The header cancel subscription is displayed", 
        		"The header cancel subscription is NOT displayed");
        reporter.hardAssert(rogers_account_overview_page.verifyIfCancelSubscriptionDetailsIsDisplayedCorrectly(TestDataHandler.tc102.getAccountDetails().getCtn()), 
        		"The cancel subscription details matched", 
        		"The cancel subscription details did not matched");        
        rogers_account_overview_page.selectReasonForCancelSubscription();
        reporter.reportLogWithScreenshot("reason for cancel subscription is selected");
        rogers_account_overview_page.clkConfirmCancelSubscription();
        reporter.reportLogWithScreenshot("Confirm button clicked");
        reporter.hardAssert(rogers_account_overview_page.verifyIfCancelSuccessfulOverLayDisplayed(), 
        		"The cancel subscription success overlay is displayed", 
        		"The cancel subscription success overlay not displayed");  
        reporter.reportLogWithScreenshot("cancel success overlay displayed");
        rogers_account_overview_page.clkOKButtonOnCancelSuccessOverlay();
        reporter.reportLogWithScreenshot("Cliked on OKay button");
        reporter.hardAssert(rogers_account_overview_page.verifyIfSMPIsDisplayedWithCancelledSubscription(), 
        		"The Subscription management page shows the cancelled CTN subscription", 
        		"The Subscription management page does NOT shows the cancelled CTN subscription");
        reporter.reportLogWithScreenshot("Subscription management page shows the cancelled subscription");
        	
        
    }

  

}
