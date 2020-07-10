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



public class RogersSS_TC_091_ValidateDeeplinkForNotLoggedInCustomer_NSEInfinite extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
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
    @Test
    public void validateDeeplinkForNotLoggedInCustomerNSEInfinite() {
    	reporter.reportLogWithScreenshot("Rogers launhced");
    	getDriver().get(TestDataHandler.ssConfig.getRogersURL().split(".com")[0]+".com/web/totes/#/viewbill/payment-method");
    	reporter.reportLogWithScreenshot("After setting the deeplink");
    	reporter.hardAssert(rogers_login_page.isSignInFrameDisplayed()
    	    		   , "When a user is not logged into an account and deep link URL is entered, it is asking the user to login first with login modal popping up"
    	    		   , "The login pop up didnt show up for non logged in user after entering deep link");  
    	String strUsername = TestDataHandler.tc63.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc63.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		reporter.reportLogWithScreenshot("Rogers launhced");
		reporter.hardAssert((rogers_change_payment_method_page.verifyChangePaymentMethodLoad() &&
				rogers_billing_page.verifyIfViewBillFrameDisplayed())
	    		   , "Redirected to the view bill page from where the MOP modal pops up and is working as designed for not logged in user"
	    		   , "Didnt redirect to the view bill page and the MOP modal pops up is not shown");
		reporter.reportLogWithScreenshot("The view bill page from where the MOP modal pops up");
            }
    
    
    

}
