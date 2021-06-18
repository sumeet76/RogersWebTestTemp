package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;


public class RogersSS_TC_136_PSEF_DP_ValidateCTNRedemptionForAMthenDP_SingleAccount extends BaseTestClass {
    
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
		getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc136.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc136.getPassword());
        String strCTN = TestDataHandler.tc136.getAccountDetails().getCtn();
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Passed", "Login Failed");
        
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
       //Apple Music redemption flow:

/*
        reporter.reportLogWithScreenshot("CTNS or Subscriptions View");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySubscriptionIsAvailableForRedeem(),
                "The subscription is available for redeem",
                "The subscription is NOT available for redeem");

        getRogersAccountOverviewPage().clkSignUpSubscription();
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfSubscriptionIsAvailableForRedeem(),
                "The current subscription redeem selection is displayed",
                "The current subscription is redeem selection is NOT displayed");
        reporter.reportLogWithScreenshot("Current subscription for redeem");
        getRogersAccountOverviewPage().checkRedeem();
        reporter.reportLogWithScreenshot("Current subscription check box seletced for redeem");
        getRogersAccountOverviewPage().clkSignUp();
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfRedeemSubscriptionDetailsIsDisplayedCorrectly(strCTN),
                "The cancel subscription details matched",
                "The cancel subscription details did not matched");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("T and C page");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfTnCForSubscriptionIsDisplayed(),
                "The Subscription TnC is displayed",
                "The Subscription TnC is NOT displayed");

        getRogersAccountOverviewPage().checkTnC();
        reporter.reportLogWithScreenshot("T and C check box is selected");
        getRogersAccountOverviewPage().clkSubscribeToSubs();
        reporter.reportLogWithScreenshot("Subscription button clicked");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfSubscriptionSuccessfulOverLayDisplayed(),
                "The subscription success overlay is displayed",
                "The subscription success overlay not displayed");
        reporter.reportLogWithScreenshot("Subscription success overlay displayed");
        getRogersAccountOverviewPage().clkOKButtonOnSubscriptionSuccessOverlay();
        reporter.reportLogWithScreenshot("Cliked on OKay button");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfSMPIsDisplayedWithSubscribedCTN(strCTN),
                "The Subscription management page SMP shows the subscribed CTNs in Currently Subscribed Section",
                "The Subscription management page does NOT shows the SMP shows the subscribed CTNs in Currently Subscribed Section");
        reporter.reportLogWithScreenshot("Subscription management page shows the subscribed CTNs in Currently Subscribed Section");

        getRogersPSEFPage().clkAccountOverview();
        reporter.reportLogWithScreenshot("Account Overview");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
                "Account overview displayed correctly",
                "Account overview didnt load");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
*/
        //=================Disney Plus redemption flow=================================================================================

        reporter.reportLogWithScreenshot("CTNS or Subscriptions View");
        getRogersPSEFPage().clickDPlusSignUporManageButton();
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.hardAssert(getRogersPSEFPage().verifyIfDPAvaialbleForSubscription(),
                "The SMP is displayed for Disney Plus",
                "The SMP is NOT displayed for Disney Plus");

        reporter.reportLogWithScreenshot("Current subscription for redeem");
        getRogersPSEFPage().checkCTNForRedeem(strCTN);
        getRogersPSEFPage().clkSignUp();
        reporter.hardAssert(getRogersPSEFPage().verifyIfRedeemSubscriptionDetailsIsDisplayedCorrectly(strCTN.substring(strCTN.length()-4)),
                "The cancel subscription details matched",
                "The cancel subscription details did not matched");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("T and C page");
        reporter.hardAssert(getRogersPSEFPage().verifyIfTnCForSubscriptionIsDisplayed(),
                "The Subscription TnC is displayed",
                "The Subscription TnC is NOT displayed");

        getRogersPSEFPage().checkTnC();
        reporter.reportLogWithScreenshot("T and C check box is selected");

        getRogersPSEFPage().clkSubscribeToSubs();
        reporter.reportLogWithScreenshot("Subscription button clicked");
        reporter.hardAssert(getRogersPSEFPage().verifyIfSubscriptionSuccessfulOverLayDisplayed(),
                "The subscription success overlay is displayed",
                "The subscription success overlay not displayed");
        reporter.reportLogWithScreenshot("Subscription success overlay displayed");
        getRogersPSEFPage().clkOKButtonOnSubscriptionSuccessOverlay();
        reporter.reportLogWithScreenshot("Clicked on OKay button");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.hardAssert(getRogersPSEFPage().verifyIfSMPIsDisplayedWithSubscribedCTN(strCTN),
                "The Subscription management page SMP shows the subscribed CTNs in Currently Subscribed Section",
                "The Subscription management page does NOT shows the SMP shows the subscribed CTNs in Currently Subscribed Section");
        reporter.reportLogWithScreenshot("Subscription management page shows the subscribed CTNs in Currently Subscribed Section");

        getRogersPSEFPage().clkAppleMusicTab();
        reporter.reportLogWithScreenshot("Apple Music Tab clicked");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfSMPIsDisplayedWithSubscribedCTN(strCTN),
                "The Subscription management page SMP shows the subscribed CTNs in Currently Subscribed Section",
                "The Subscription management page does NOT shows the SMP shows the subscribed CTNs in Currently Subscribed Section");

    }

  

}
