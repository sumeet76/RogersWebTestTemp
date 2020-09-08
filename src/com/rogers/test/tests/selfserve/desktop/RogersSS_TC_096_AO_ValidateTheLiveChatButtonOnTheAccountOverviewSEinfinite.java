package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_096_AO_ValidateTheLiveChatButtonOnTheAccountOverviewSEinfinite extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
		   
    private void tryLogin(String strUsername, String strPassword) {
    	 rogers_login_page.switchToSignInIFrame();
    	 rogers_login_page.setUsernameIFrame(strUsername);
         rogers_login_page.setPasswordIFrame(strPassword);
 		 reporter.reportLogWithScreenshot("Login Credential is entered.");
         rogers_login_page.clkSignInIFrame();
         reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
         rogers_login_page.clkSkipIFrame();      
         rogers_login_page.switchOutOfSignInIFrame();
    }
    
    @Test
    public void validateTheLiveChatButtonOnTheAccountOverviewSEinfinite() {

    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc63.getUsername();
    	String strPassword = TestDataHandler.tc63.getPassword();		
		tryLogin(strUsername, strPassword);
		reporter.reportLogWithScreenshot("Account overveiew page");		
		reporter.hardAssert(rogers_account_overview_page.verifyLiveChatButtonIsDisplayed(), 
					"Live Chat button is displayed in Account overview page", 
					"Live Chat button is NOT displayed in Account overview page");
		
		rogers_account_overview_page.clkBtnLiveChat();
		reporter.reportLogWithScreenshot("Clicked on Button Live Chat");	
		reporter.hardAssert(rogers_account_overview_page.verifyLiveChatOverlayOpened(), 
							"Live Chat overlay opened in Account overview page", 
							"Live Chat overlay did NOT open in Account overview page, please investigate.");
		reporter.reportLogWithScreenshot("Live Chat overlay opened."); 
    }


    
}
