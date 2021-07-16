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


public class RogersSS_TC_135_PSEF_DP_ValidateSMPafterResumingCTNfromCancelledStateCTNcancelledWithDPfreeTrial extends BaseTestClass {
    
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
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc134.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc134.getPassword());
        String strCTNRestoredFromV21AfterCancel = TestDataHandler.tc134.getAccountDetails().getCtn();
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc134.getAccountDetails().getBan());
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

        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("Current subscription mid view");

        reporter.hardAssert(getRogersPSEFPage().verifyIfCancelledDPIsShown(strCTNRestoredFromV21AfterCancel),
                "CTN displayed under Subscribed section with cancelled CTA next to CTN," +
                        " and Disney+  subscription  restored with it's original subscription start date",
                "It seems the CTN did not get displayed under Subscribed section with cancelled CTA next to CTN,\" +\n" +
                        "                        \" and Disney+  subscription  restored with it's original subscription start date");



    }

  

}
