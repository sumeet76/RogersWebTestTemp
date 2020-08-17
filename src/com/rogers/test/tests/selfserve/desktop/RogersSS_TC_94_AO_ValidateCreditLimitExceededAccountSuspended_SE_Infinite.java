package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;



public class RogersSS_TC_94_AO_ValidateCreditLimitExceededAccountSuspended_SE_Infinite extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
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
        //rogers_login_page.setUsernameIFrame(TestDataHandler.tc95.getUsername());
        //rogers_login_page.setPasswordIFrame(TestDataHandler.tc95.getPassword());
		rogers_login_page.setUsernameIFrame("nonsimentrypoint@mailinator.com");
		rogers_login_page.setPasswordIFrame("rogers123");
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        rogers_login_page.clkSignInIFrame();
        reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();

        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	rogers_account_overview_page.selectAccount(TestDataHandler.tc95.getAccountDetails().getBan());       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Passed", "Login Failed");
        common_business_flows.scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("CTNS View");
        
        reporter.hardAssert(rogers_account_overview_page.isCreditLimitReachedNotificationDisplayed(),
        		"Credit limit reached notification is displayed as expected",
        		"Credit limit reached notification is displayed as expected");
        
        //rogers_account_overview_page.clkSuspendedCTN();
       
        //reporter.hardAssert(rogers_account_overview_page.isSuspendedCTNAvailable(),
        //		"User is unable to click and navigate through suspended CTN Badge",
        //		"It seems the user was able to click on suspended CTN");
        
        rogers_account_overview_page.clkBtnLiveChat();
		reporter.reportLogWithScreenshot("Clicked on Button Live Chat");	
		reporter.softAssert(rogers_account_overview_page.verifyLiveChatOverlayOpened(), 
							"Live Chat overlay opened in Account overview page", 
							"Live Chat overlay did NOT open in Account overview page, please investigate.");
		reporter.reportLogWithScreenshot("Live Chat overlay opened."); 
        
    }

  

}
