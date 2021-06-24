package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_091_AO_ValidateDeeplinkForNotLoggedInCustomer_NSEInfinite extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
/**
 * "Description:
1. Launch Rogers.com
2. Enter the deeplink URL https://qa4.rogers.com/web/totes/#/viewbill/payment-method
3. Login with valid credentials

"	"1. Rogers.com up and running
2. Sign-in pop-up should be displayed
3. The MOP modal from view bill page should be opened successfully

"	
 */
    @Test(groups = {"RegressionSS","AccountOverviewSS"})
    public void validateDeeplinkForNotLoggedInCustomerNSEInfinite() {
    	reporter.reportLogWithScreenshot("Rogers launhced");
    	String strDeepLinkURL = System.getProperty("QaUrl").split(".com")[0]+".com/consumer/self-serve/payments/history";
    	getDriver().get(strDeepLinkURL);
    	reporter.reportLogWithScreenshot("After setting the deeplink : "+strDeepLinkURL);
    	reporter.hardAssert(getRogersLoginPage().isSignInFrameDisplayed()
    	    		   , "When a user is not logged into an account and deep link URL is entered, it is asking the user to login first"
    	    		   , "The login pop up didnt show up for non logged in user after entering deep link");  
    	String strUsername = TestDataHandler.tc63.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc63.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		reporter.reportLogWithScreenshot("After Log In");
		reporter.hardAssert(getRogersPaymentHistoryPage().verifyIfPaymenyHistoryTabPresent(), 
				 "Payment history is displayed",
				 "Payment history is not displayed as expected.");

            }
    
    
    

}
