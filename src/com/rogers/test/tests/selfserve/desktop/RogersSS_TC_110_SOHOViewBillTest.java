package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_110_SOHOViewBillTest extends BaseTestClass {

    @Test(groups = {"BillingAndPaymentsSS"})
    public void viewBillTest() {
        getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc101.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc101.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account overlay.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc101.getAccountDetails().getBan());
        }
		reporter.reportLogWithScreenshot("Page after login.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
        						"Login success.",
        						"Login Error. Refer screenshot");
        getRogersAccountOverviewPage().clickViewYourBill();
		reporter.reportLogWithScreenshot("Billing and payment page.");
		if (!getRogersBillingPage().verifyIfAccountHasNoBill()) {
			getRogersBillingPage().switchToBillViewIframe();
	        reporter.hardAssert(getRogersBillingPage().verifyBillingAndPaymentPageLoadIframe(),
	        						"Billing page loaded.",
	        						"Billing page load Error. Refer screenshot");
			reporter.reportLogWithScreenshot("View bill page.");
	        reporter.hardAssert(getRogersBillingPage().verifyYourBillDisplayedIFrame(),
	        						"Bill viewed successfully.",
	        						"View Your Bill Error. Refer screenshot");
	        getRogersBillingPage().scrollToMiddlePage();
			reporter.reportLogWithScreenshot("Middle of view bill page.");
		} else {
	        getRogersBillingPage().scrollToMiddlePage();
			reporter.reportLogWithScreenshot("There has no bill yet for the account.");
		}

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
