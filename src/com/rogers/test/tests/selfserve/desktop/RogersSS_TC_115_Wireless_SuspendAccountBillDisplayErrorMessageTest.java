package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_115_Wireless_SuspendAccountBillDisplayErrorMessageTest extends BaseTestClass {


	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
  @Test(groups = {"RegressionSS","WirelessDashboardSS"})
  public void verifyBillDisplayErrorMessageSuspendAccount() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc95.getUsername();
    	String strPassword = TestDataHandler.tc95.getPassword();
    	//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc95.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
				"Login success.",
				"Login Error. Refer screenshot");
		getRogersAccountOverviewPage().clickViewYourBill();
	 	getReporter().hardAssert(getRogersBillingPage().verifyViewBillLoaded(),
			  "View bill page loaded.",
			  "View bill page not loaded.");
		reporter.reportLogWithScreenshot("Billing and payment page.");
		reporter.hardAssert(getRogersBillingPage().verifySuspendMessage(),"Error message displayed on the billing page" ,"Error message not displayed on the billing page" );
		reporter.hardAssert(getRogersBillingPage().verifyLinkLiveChat(),"Live Chat link displayed on the billing page","Live chat link is not displayed on the billing page");
	  reporter.reportLogWithScreenshot("Error message and Live chat link verified");
	}


}
