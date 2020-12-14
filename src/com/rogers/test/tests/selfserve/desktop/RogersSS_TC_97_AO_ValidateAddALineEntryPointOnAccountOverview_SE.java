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
	
	
    @Test(groups = {"RegressionSS","AccountOverviewSS"})
    public void validateSignInAndAccountOverview() {
    	 reporter.reportLogWithScreenshot("Home Page");
         reporter.reportLog("Home Page Launched");
     	 getRogersHomePage().clkSignIn();
 		 getRogersLoginPage().switchToSignInIFrame();
         getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc60.getUsername());
         getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc60.getPassword());
         reporter.reportLogWithScreenshot("Login Credential is entered.");
         getRogersLoginPage().clkSignInIFrame();
         reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
         getRogersLoginPage().clkSkipIFrame();
 		getRogersLoginPage().switchOutOfSignInIFrame();

         if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
         	reporter.reportLogWithScreenshot("Select an account.");
         	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc60.getAccountDetails().getBan());       
         }
         reporter.reportLogWithScreenshot("Account overview page.");
         reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Passed", "Login Failed");
         common_business_flows.scrollToMiddleOfWebPage();
         reporter.reportLogWithScreenshot("CTNs View");
         
         reporter.hardAssert(getRogersAccountOverviewPage().isAddALinkDisplayedBelowCTNs(),
         		"Add link is displayed below CTN's",
         		"Add link is not displayed below CTN's");
         reporter.reportLogWithScreenshot("Add link is displayed");
         getRogersAccountOverviewPage().clkAddALink();
         reporter.reportLogWithScreenshot("Click on Add link");
         reporter.hardAssert(getRogersAccountOverviewPage().verifyIfAddALinkOverlayOnDeviceSelectionPageIsdisplayed(),
         		"Pop up should get displayed asking 'What plan do you want to add this device to?' and device selection page in the background",
         		"Pop up 'What Plan do you want to add on Device page'  didnt get displayed");
         reporter.reportLogWithScreenshot("'What plan do you want to add this device to?' and device selection page in the background");
    }

  

}
