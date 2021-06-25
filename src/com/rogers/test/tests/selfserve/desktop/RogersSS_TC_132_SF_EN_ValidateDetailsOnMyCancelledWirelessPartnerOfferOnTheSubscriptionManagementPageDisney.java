package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_132_SF_EN_ValidateDetailsOnMyCancelledWirelessPartnerOfferOnTheSubscriptionManagementPageDisney extends BaseTestClass {

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
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc130.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc130.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();

        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Passed", "Login Failed");

        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("CTNS or Subscriptions View");
        getRogersAccountOverviewPage().clickDPlusSignUporManageButton();
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfCurrentlySubscribedPaneIsDisplayed(),
                "The current subscription is displayed",
                "The current subscription is NOT displayed");
        reporter.reportLogWithScreenshot("Current subscription");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.hardAssert(getRogersPSEFPage().verifyIfDPAvaialbleForCancellation(),
                "The Sunscription is available for  Cancellation",
                "The Sunscription is available for  Cancellation is NOT available for cancellation");

        reporter.reportLogWithScreenshot("Current subscription for cancel");
        String strSelectedCTNForCancel = getRogersPSEFPage().checkFirstDefaultCTNForCancel();
        reporter.reportLogWithScreenshot("CTN selected for cancellation");

        reporter.reportLogWithScreenshot("Cancel subscription details is displayed");
        reporter.hardAssert(getRogersPSEFPage().verifyIfHeaderCancelSubscriptionIsDisplayed(),
                "The header cancel subscription is displayed",
                "The header cancel subscription is NOT displayed");
        reporter.hardAssert(getRogersPSEFPage().verifyIfCancelSubscriptionDetailsIsDisplayedCorrectly(strSelectedCTNForCancel),
                "The cancel subscription details matched",
                "The cancel subscription details did not matched");
        getRogersPSEFPage().selectReasonForCancelSubscription("immediate");
        reporter.reportLogWithScreenshot("reason for cancel subscription is selected");
        getRogersPSEFPage().clkConfirmCancelSubscription();
        reporter.reportLogWithScreenshot("Confirm button clicked");
        reporter.hardAssert(getRogersPSEFPage().verifyIfCancelSuccessfulOverLayDisplayed(),
                "The cancel subscription success overlay is displayed",
                "The cancel subscription success overlay not displayed");
        reporter.hardAssert(getRogersPSEFPage().verifyIfCancelSuccessfulOverLayMentionsEffectiveImmediate(),
                "Verify is success message shows immediate effecyive",
                "The cancel subscription success overlay not displayed");

        reporter.reportLogWithScreenshot("cancel success overlay displayed");
        getRogersPSEFPage().clkOKButtonOnCancelSuccessOverlay();
        reporter.reportLogWithScreenshot("Clicked on OKay button");
        reporter.hardAssert(getRogersPSEFPage().verifyIfEffectiveCancelDateForSubscriptionISImmediate(System.getProperty("test_language"),strSelectedCTNForCancel),
                "The Subscription management page shows the cancelled CTN subscription ended immediately",
                "The Subscription management page does NOT shows the cancelled CTN subscription");


    }
  

}
