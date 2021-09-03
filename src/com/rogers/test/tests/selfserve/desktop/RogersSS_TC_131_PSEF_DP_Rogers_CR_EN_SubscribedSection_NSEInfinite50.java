package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.JdbcOracleConnector;


import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


public class RogersSS_TC_131_PSEF_DP_Rogers_CR_EN_SubscribedSection_NSEInfinite50 extends BaseTestClass {

    public JdbcOracleConnector jdbcOracleConnector;
    public List<Map> testdata = null;
    Map.Entry<String, String> e = null;

    @BeforeTest
    public void getTestDataDB() {
        try{
            jdbcOracleConnector = new JdbcOracleConnector("jdbc:oracle:thin:@exa002ldcs.rci.rogers.com:1528:AUTODBQA",TestDataHandler.bdConnection.getUsername(),TestDataHandler.bdConnection.getPassword());
            jdbcOracleConnector.connect();
            testdata = jdbcOracleConnector.resultSetToListOfMap("select BAN as ACCOUNT_NUMBER,CTN,email as USERNAME,password,CASE WHEN 1=1 THEN 'apple-music' END as VAS_TYPE from uipath_front_end_linking where ban in ( select ban from uipath_wireless_test_data WHERE scenario like 'ma_NSEInfiniteCustomerSubscribesAppleMusic_%' and uipath_status like 'Completed' fetch first 1 ROW only) and flag='N' fetch first 1 ROW only");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
        //xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }

    public String returnDBDataValue(String variable) {
        for(Map<String, String> map : testdata) {
            for(Map.Entry<String, String> e: map.entrySet()) {
                System.out.println("Key=" + e.getKey() + ", Value=" + e.getValue());
                if (e.getKey().contains("USERNAME") && e.getKey().equalsIgnoreCase(variable) && !e.getKey().isEmpty()) {
                    return e.getValue();
                } else if (e.getKey().contains("PASSWORD") && e.getKey().equalsIgnoreCase(variable) && !e.getKey().isEmpty()) {
                    return e.getValue();
                }
            }
        }
        return e.getValue();
    }


    @Test(groups = {"RegressionSS","PSEF","DisneyPlus"})
    public void validateSignInAndAccountOverview() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
        getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        //getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc130.getUsername());
        //getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc130.getPassword());
        getRogersLoginPage().setUsernameIFrame(returnDBDataValue("USERNAME"));
        getRogersLoginPage().setPasswordIFrame(returnDBDataValue("PASSWORD"));
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
        //getRogersLoginPage().switchOutOfSignInIFrame();

        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Passed", "Login Failed");

        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("CTNS or Subscriptions View");
        getRogersPSEFPage().clickDPlusSignUporManageButton();
        reporter.hardAssert(getRogersAccountOverviewPage().verifyIfCurrentlySubscribedPaneIsDisplayed(),
                "The current subscription is displayed",
                "The current subscription is NOT displayed");
        reporter.reportLogWithScreenshot("Current subscription");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.hardAssert(getRogersPSEFPage().verifyIfDPAvaialbleForSubscription(),
                "The current subscription is displayed",
                "The current subscription is NOT displayed");

        reporter.reportLogWithScreenshot("Current subscription for redeem");
        String strSelectedCTNForRedeem = getRogersPSEFPage().checkFirstDefaultCTNForRedeem();
        getRogersPSEFPage().clkSignUp();
        reporter.hardAssert(getRogersPSEFPage().verifyIfRedeemSubscriptionDetailsIsDisplayedCorrectly(strSelectedCTNForRedeem.substring(strSelectedCTNForRedeem.length()-4)),
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
        reporter.hardAssert(getRogersPSEFPage().verifyIfSMPIsDisplayedWithSubscribedCTN(strSelectedCTNForRedeem),
                "The Subscription management page SMP shows the subscribed CTNs in Currently Subscribed Section",
                "The Subscription management page does NOT shows the SMP shows the subscribed CTNs in Currently Subscribed Section");
        reporter.reportLogWithScreenshot("Subscription management page shows the subscribed CTNs in Currently Subscribed Section");



    }
  

}
