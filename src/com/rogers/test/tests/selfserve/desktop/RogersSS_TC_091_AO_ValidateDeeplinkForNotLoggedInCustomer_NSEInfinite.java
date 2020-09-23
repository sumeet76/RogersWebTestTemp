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
    @Test(groups = {"RegressionSS","WirelessDashboardSS"})
    public void validateDeeplinkForNotLoggedInCustomerNSEInfinite() {
    	reporter.reportLogWithScreenshot("Rogers launhced");
    	String strDeepLinkURL = TestDataHandler.ssConfig.getRogersURL().split(".com")[0]+".com/web/totes/#/viewbill/payment-method";
    	getDriver().get(strDeepLinkURL);
    	reporter.reportLogWithScreenshot("After setting the deeplink : "+strDeepLinkURL);
    	reporter.hardAssert(rogers_login_page.isSignInFrameDisplayed()
    	    		   , "When a user is not logged into an account and deep link URL is entered, it is asking the user to login first"
    	    		   , "The login pop up didnt show up for non logged in user after entering deep link");  
    	String strUsername = TestDataHandler.tc63.getUsername();
    	//rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc63.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		reporter.reportLogWithScreenshot("After Log In");
		reporter.hardAssert((rogers_change_payment_method_page.verifyChangePaymentMethodLoad()
				&& rogers_billing_page.verifyViewBillPageHeaderDisplayed())
	    		   , "Redirected to the view bill page from where the MOP modal pops up and is working as designed for not logged in user"
	    		   , "Didnt redirect to the view bill page and the MOP modal pops up is not shown");
		reporter.reportLogWithScreenshot("The view bill page from where the MOP modal pops up");
            }
    
    
    

}
