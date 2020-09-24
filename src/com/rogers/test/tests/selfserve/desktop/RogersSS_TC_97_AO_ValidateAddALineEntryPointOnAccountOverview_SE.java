package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_97_AO_ValidateAddALineEntryPointOnAccountOverview_SE extends BaseTestClass {	
    
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
    public void validateSignInAndAccountOverview() {
    	 reporter.reportLogWithScreenshot("Home Page");
         reporter.reportLog("Home Page Launched");
     	 rogers_home_page.clkSignIn();
 		 rogers_login_page.switchToSignInIFrame();
         rogers_login_page.setUsernameIFrame(TestDataHandler.tc60.getUsername());
         rogers_login_page.setPasswordIFrame(TestDataHandler.tc60.getPassword());
         reporter.reportLogWithScreenshot("Login Credential is entered.");
         rogers_login_page.clkSignInIFrame();
         reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
         rogers_login_page.clkSkipIFrame();
 		rogers_login_page.switchOutOfSignInIFrame();

         if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
         	reporter.reportLogWithScreenshot("Select an account.");
         	rogers_account_overview_page.selectAccount(TestDataHandler.tc60.getAccountDetails().getBan());       
         }
         reporter.reportLogWithScreenshot("Account overview page.");
         reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Passed", "Login Failed");
         common_business_flows.scrollToMiddleOfWebPage();
         reporter.reportLogWithScreenshot("CTNs View");
         
         reporter.hardAssert(rogers_account_overview_page.isAddALinkDisplayedBelowCTNs(),
         		"Add link is displayed below CTN's",
         		"Add link is not displayed below CTN's");
         reporter.reportLogWithScreenshot("Add link is displayed");
         rogers_account_overview_page.clkAddALink();
         reporter.reportLogWithScreenshot("Click on Add link");
         reporter.hardAssert(rogers_account_overview_page.verifyIfAddALinkOverlayOnDeviceSelectionPageIsdisplayed(),
         		"Pop up should get displayed asking 'What plan do you want to add this device to?' and device selection page in the background",
         		"Pop up 'What Plan do you want to add on Device page'  didnt get displayed");
         reporter.reportLogWithScreenshot("'What plan do you want to add this device to?' and device selection page in the background");
    }

  

}
