package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_015_ValidatePaymentHistoryOfWirelessPostpaid_NoPayment extends BaseTestClass {	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(groups = {"RegressionSS","BillingAndPaymentsSS"})
    public void verifyPaymentHistoryWithNoPayment() {    	    	    
		getRogersHomePage().clkSignIn();
		String strUsername = TestDataHandler.tc161825.getUsername();
		String strPassword = TestDataHandler.tc161825.getPassword();
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(strUsername);
		getRogersLoginPage().setPasswordIFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed without error.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		reporter.reportLogWithScreenshot("Account overveiew page");
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), 
				"Login successful",
				"Login Error. Refer screenshot");

		getRogersAccountOverviewPage().clkPaymentHistory();
		reporter.hardAssert(getRogersPaymentHistoryPage().verifyPaymentHistoryIsDisplayed(), 
				"Payment history is displayed",
				"Payment history is not displayed as expected.");
		reporter.reportLogWithScreenshot("Payment History Page.");
		reporter.hardAssert(getRogersPaymentHistoryPage().verifyNoPaymenyHistoryAlertPresent(), 
				"Sorry, you don't have any history message is displayed without error",
				"Sorry, you don't have any history message is not displayed, please investigate.");
															
    }
    
}
