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
	
	
    @Test
    public void validateCreditLimitExceededAccountSuspended_SE_Infinite() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(TestDataHandler.tc94.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.tc94.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        rogers_login_page.clkSignInIFrame();
        reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();

        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	rogers_account_overview_page.selectAccount(TestDataHandler.tc94.getAccountDetails().getBan());       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Passed", "Login Failed");
        
        /*
        reporter.hardAssert(rogers_account_overview_page.isCreditLimitReachedNotificationDisplayed(),
        		"Credit limit reached notification is displayed as expected",
        		"Credit limit reached notification is NOT displayed as expected");
        */
        reporter.hardAssert(rogers_account_overview_page.isServicesSuspendedNotificationDisplayed(),
        		"Service suspended notification is displayed as expected",
        		"Service suspended notification is NOT displayed as expected"); 
        reporter.reportLogWithScreenshot("Services suspended Notification displayed");
        common_business_flows.scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("CTNs View");
        reporter.hardAssert(rogers_account_overview_page.isSuspendedCTNAvailable(),
        		"Suspended CTN is avialable",
        		"Suspended CTN is not available");
        
        rogers_account_overview_page.clkSuspendedCTN();
       
        reporter.hardAssert(rogers_account_overview_page.isSuspendedCTNAvailable(),
        		"User is unable to click and navigate through suspended CTN Badge",
        		"It seems the user was able to click on suspended CTN");
        
        common_business_flows.scrollToTopOfWebPage();
        rogers_account_overview_page.clkBtnLiveChatInsideSuspensionNotification();
		reporter.reportLogWithScreenshot("Clicked on Button Live Chat");	
		reporter.hardAssert(rogers_account_overview_page.verifyLiveChatOverlayOpened(), 
							"Live Chat overlay opened in Account overview page", 
							"Live Chat overlay did NOT open in Account overview page, please investigate.");
		reporter.reportLogWithScreenshot("Live Chat overlay opened."); 
        
    }
    
      

}
