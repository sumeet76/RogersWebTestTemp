package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_037_ValidateAccountWithNoBill extends BaseTestClass {

    @Test(groups = {"BillingAndPaymentsSS"})
    public void viewBillTest() {
        getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame("Autodatar221BFA06@yahoo.com");
		getRogersLoginPage().setPasswordIFrame("DigiAuto@123");
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account overlay.");
            getRogersAccountOverviewPage().selectAccount("941765042");
        }
		reporter.reportLogWithScreenshot("Page after login.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
        						"Login success.",
        						"Login Error. Refer screenshot");
        getRogersAccountOverviewPage().clickViewYourBill();
		reporter.reportLogWithScreenshot("Billing and payment page.");
		
	        reporter.hardAssert(getRogersBillingPage().verifyIfAccountHasNoBill(),
	        						"No bill error message displayed.",
	        						"Billing page loaded");
			reporter.reportLogWithScreenshot("View No bill display page.");
			CommonBusinessFlowsThreadLocal.get().scrollToMiddleOfWebPage();
			reporter.reportLogWithScreenshot("View No bill display page.");
	       
		
    }

    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
   	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
   		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
   		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
   	}
      	
   	
   	
   	@AfterMethod(alwaysRun = true)
   	public void afterTest() throws InterruptedException {
   		closeSession();
   	}


}
