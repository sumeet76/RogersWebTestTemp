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


public class RogersSS_TC_134_PSEF_DP_ValidateDPsmpMLbanWithCTN1ActiveAndDPredeemedCTN2SuspendedAndDPredeemedCTN3SuspendedAndDPredeemed extends BaseTestClass {
    
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
        reporter.hardAssert(getRogersAccountOverviewPage().isSuspendedCTNAvailable(),
                "Suspended CTN is avialable",
                "Suspended CTNs is not available");

        List<String> suspendedCTNLst = getRogersAccountOverviewPage().getSuspendedCTNAvailable();
        List<String> activeCTNLst = getRogersAccountOverviewPage().getActiveCTNAvailable();
        reporter.hardAssert(suspendedCTNLst.size()>1 && activeCTNLst.size()>0,
                "More than one Suspended CTN and atleast one active CTN is avialable",
                "Tt seems the Suspended CTNs are one or less than one or No active ctn present, please add two suspended ctn and one active ctn");
        String activeCTN= activeCTNLst.get(0);
        String firstSuspendedCTN= suspendedCTNLst.get(0);
        String secondSuspendedCTN= suspendedCTNLst.get(1);
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

        reporter.softAssert(getRogersPSEFPage().verifyIfSMPIsDisplayedWithSubscribedCTN(activeCTN),
                "SMP displays Active Trial WL Subscriptions for active  ctn"+activeCTN,
                "SMP did NOT display Active Trial WL Subscriptions for active ctn"+activeCTN);

        reporter.softAssert(getRogersPSEFPage().verifyIfSMPIsDisplayedWithSubscribedCTN(firstSuspendedCTN),
                "SMP displays Active Trial WL Subscriptions for suspended ctn"+firstSuspendedCTN,
                "SMP did NOT display Active Trial WL Subscriptions for suspended ctn"+firstSuspendedCTN);

        reporter.softAssert(getRogersPSEFPage().verifyIfSMPIsDisplayedWithSubscribedCTN(secondSuspendedCTN),
                "SMP displays Active Trial WL Subscriptions for suspended ctn"+secondSuspendedCTN,
                "SMP did NOT display Active Trial WL Subscriptions for suspended ctn"+secondSuspendedCTN);

        		
    }

  

}
