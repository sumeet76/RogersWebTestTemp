package com.rogers.test.tests.selfserve;

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


public class RogersSS_TC_036_WirelessPostpaidOverviewViewBillTest extends BaseTestClass {

    @Test
    public void viewBillTest() {
        rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc36.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc36.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account overlay.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc36.getAccountDetails().getBan());
        }
		reporter.reportLogWithScreenshot("Page after login.");
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),
        						"Login success.",
        						"Login Error. Refer screenshot");
        rogers_account_overview_page.clickViewYourBill();
		reporter.reportLogWithScreenshot("Billing and payment page.");
		if (!rogers_billing_page.verifyIfAccountHasNoBill()) {
			rogers_billing_page.switchToBillViewIframe();
	        reporter.hardAssert(rogers_billing_page.verifyBillingAndPaymentPageLoadIframe(),
	        						"Billing page loaded.",
	        						"Billing page load Error. Refer screenshot");
			reporter.reportLogWithScreenshot("View bill page.");
	        reporter.hardAssert(rogers_billing_page.verifyYourBillDisplayedIFrame(), 
	        						"Bill viewed successfully.",
	        						"View Your Bill Error. Refer screenshot");
	        rogers_billing_page.scrollToMiddlePage();
			reporter.reportLogWithScreenshot("Middle of view bill page.");
		} else {
	        rogers_billing_page.scrollToMiddlePage();
			reporter.reportLogWithScreenshot("There has no bill yet for the account.");
		}

    }

    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
   	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
   		startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
   		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
   	}
      	
   	
   	
   	@AfterMethod(alwaysRun = true)
   	public void afterTest() throws InterruptedException {
   		closeSession();
   	}


}
