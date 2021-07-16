package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_94_AO_ValidateCreditLimitExceededAccountSuspended_SE_Infinite extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"RegressionSS","AccountOverviewSS"})
    public void validateCreditLimitExceededAccountSuspended_SE_Infinite() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc94.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc94.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc94.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Passed", "Login Failed");
        
        /*
        reporter.hardAssert(getRogersAccountOverviewPage().isCreditLimitReachedNotificationDisplayed(),
        		"Credit limit reached notification is displayed as expected",
        		"Credit limit reached notification is NOT displayed as expected");
        */
        reporter.hardAssert(getRogersAccountOverviewPage().isServicesSuspendedNotificationDisplayed(),
        		"Service suspended notification is displayed as expected",
        		"Service suspended notification is NOT displayed as expected"); 
        reporter.reportLogWithScreenshot("Services suspended Notification displayed");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("CTNs View");
        reporter.hardAssert(getRogersAccountOverviewPage().isSuspendedCTNAvailable(),
        		"Suspended CTN is avialable",
        		"Suspended CTN is not available");
        
        getRogersAccountOverviewPage().clkSuspendedCTN();
       
        reporter.hardAssert(getRogersAccountOverviewPage().isSuspendedCTNAvailable(),
        		"User is unable to click and navigate through suspended CTN Badge",
        		"It seems the user was able to click on suspended CTN");
        
        getCommonBusinessFlows().scrollToTopOfWebPage();
        getRogersAccountOverviewPage().clkBtnLiveChatInsideSuspensionNotification();
		reporter.reportLogWithScreenshot("Clicked on Button Live Chat");	
		reporter.hardAssert(getRogersAccountOverviewPage().verifyLiveChatOverlayOpened(),
							"Live Chat overlay opened in Account overview page", 
							"Live Chat overlay did NOT open in Account overview page, please investigate.");
		reporter.reportLogWithScreenshot("Live Chat overlay opened."); 
        
    }
    
      

}
