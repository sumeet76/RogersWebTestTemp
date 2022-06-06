package com.rogers.test.tests.selfserve.mobile;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class Mobile_RogersSS_TC_001_Sanity_ValidateSignInAndAccountOverviewTest extends BaseTestClass {	
    

	@BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("sauceandroidchrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
		}
	   	

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"MobileSanitySS"})
    public void validateSignInAndAccountOverview() {    	        
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	getRogersHomePage().clkSignInMobile();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		if (getRogersLoginPage().isOverlayContainerDisplayed()) {
			reporter.reportLogWithScreenshot("Select Continue in browser.");
			getRogersLoginPage().clkContinueInBrowser();
		}
		reporter.reportLogWithScreenshot("Continue in Browser Selected");
    	getRogersLoginPage().setUsernameIFrameMobile(TestDataHandler.tc013132.getUsername());
    	getRogersLoginPage().setPasswordIFrameMobile(TestDataHandler.tc013132.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
		getRogersLoginPage().clkContinueInBrowser();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc013132.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLoginMobile(),
        		"Login Passed", "Login Failed");
    }

  

}
