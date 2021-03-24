package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/*
1. Launch Rogers.com
2. Click on Sign-in
3. Sign-in with valid credentials
4. Click on the Apple music badge in the AO page.
5. Click on the cancel trial for the employee trial subscribed CTN
6. Choose the reason for cancellation to be "I’m already paying for an Apple Music subscription "and verify the cancellation timeline text displayed below. Click on Confirm cancellation.
7. Click on Close button "X" on the success modal
8. Verify the subscription management page and FE appearence as per PCR21



1. Rogers.com up and running
2. Sign-in pop-up will be displayed
3. Account overview page will be displayed
4. The Cx should be directed and displayed onto the subscription management page
5. The Cx should be initiated with the cancel flow and be displayed with the Cancel Apple Music Subsciption page.
6. The cancellation timeline text displayed should be immediate and not future dated for this specific reason of cancellation as per copy and mock. FE will call <TBD> Domain Service THEN Domain Service will return the cancelled SubscriptionState
7. The Cx should be redirected to the Subscription management page
8. As per PCR21:
    * The the effective cancel date for these cancellations is immediate and all the cancelled subscriptions (CTNs)
    and the immediate cancel date on the "Not eligible for this promotion" section of the Subscription Management Page.
    * CTN with Cancelled Status should be displayed with promotion Ended, subscription ended message as per Offer Type
    *  The order of the cancelled CTNs  will be displayed based on effective cancel dates for immediate and deferred
    cancelled CTNs



 */

public class RogersSS_TC_118_PACMAN_VerifyImmediateCancellationPCRchanges extends BaseTestClass {
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	    //xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		 
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(groups = {"RegressionSS","CancelSubscription"})
    public void validateSignInAndAccountOverview() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
        getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame("Autodatar321SS03@yahoo.com");
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc102.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
            reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount("946468832");
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Passed", "Login Failed");

        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("CTNS or Subscriptions View");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfSubscriptionIsAvailableForCancellation(),
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
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfCancelSubscriptionDetailsIsDisplayedCorrectly("4163120248"),
                "The cancel subscription details matched",
                "The cancel subscription details did not matched");
        getRogersAccountOverviewPage().selectReasonForCancelSubscription("immediate");
        reporter.reportLogWithScreenshot("reason for cancel subscription is selected");
        getRogersAccountOverviewPage().clkConfirmCancelSubscription();
        reporter.reportLogWithScreenshot("Confirm button clicked");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfCancelSuccessfulOverLayDisplayed(),
                "The cancel subscription success overlay is displayed",
                "The cancel subscription success overlay not displayed");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfCancelSuccessfulOverLayMentionsEffectiveImmediate(),
                "Verify is success message shows immediate effecyive",
                "The cancel subscription success overlay not displayed");

        reporter.reportLogWithScreenshot("cancel success overlay displayed");
        getRogersAccountOverviewPage().clkOKButtonOnCancelSuccessOverlay();
        reporter.reportLogWithScreenshot("Clicked on OKay button");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfEffectiveCancelDateForSubscriptionISImmediate(System.getProperty("test_language")),
                "The Subscription management page shows the cancelled CTN subscription ended immediately",
                "The Subscription management page does NOT shows the cancelled CTN subscription");

        //==============  Deferred cancel flow =============================

        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfSubscriptionIsAvailableForCancellation(),
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
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfCancelSubscriptionDetailsIsDisplayedCorrectly("4162780970"),
                "The cancel subscription details matched",
                "The cancel subscription details did not matched");
        getRogersAccountOverviewPage().selectReasonForCancelSubscription("deferred");
        reporter.reportLogWithScreenshot("reason for cancel subscription is selected");
        getRogersAccountOverviewPage().clkConfirmCancelSubscription();
        reporter.reportLogWithScreenshot("Confirm button clicked");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfCancelSuccessfulOverLayDisplayed(),
                "The cancel subscription success overlay is displayed",
                "The cancel subscription success overlay not displayed");

        reporter.reportLogWithScreenshot("cancel success overlay displayed");
        getRogersAccountOverviewPage().clkOKButtonOnCancelSuccessOverlay();
        reporter.reportLogWithScreenshot("Clicked on OKay button");

        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfSMPIsDisplayedWithCancelledSubscription(),
                "The effective cancel date for these cancellations is deferred to a future date and all the cancelled subscriptions (CTNs)",
                "The effective cancel date for these cancellations seems NOT deferred to a future date and all the cancelled subscriptions (CTNs)");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfEffectiveCancelDateForSubscriptionIsDefferred(System.getProperty("test_language")),
                "The Subscription management page shows the deferred cancel subscription date",
                "The Subscription management page does NOT shows the cancelled CTN subscription");

        //============ Defrred cancel flow ends ============================
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfTheOrderOfTheCancelledCTNsWillBeDisplayedBasedOnEffectiveCancelDatesForImmediateAndDeferredCancelledCTNs(),
                "The order of the cancelled CTNs  will be displayed based on effective cancel dates for immediate and deferred cancelled CTNs",
                "The order of the cancelled CTNs  seems NOT displayed based on effective cancel dates for immediate and deferred cancelled CTNs");

        reporter.reportLogWithScreenshot("Subscription management page shows the cancelled subscription");

    }
/*
 * The the effective cancel date for these cancellations is immediate and all the cancelled subscriptions (CTNs)
    and the immediate cancel date on the "Not eligible for this promotion" section of the Subscription Management Page.
    * CTN with Cancelled Status should be displayed with promotion Ended, subscription ended message as per Offer Type
    *  The order of the cancelled CTNs  will be displayed based on effective cancel dates for immediate and deferred
    cancelled CTNs

 */
  

}
