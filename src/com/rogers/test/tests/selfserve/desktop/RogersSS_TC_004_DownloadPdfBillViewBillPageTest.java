package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_004_DownloadPdfBillViewBillPageTest extends BaseTestClass {

    @Test(groups = {"RegressionSS","BillingAndPaymentsSS"})
    public void downloadPdfBillViewBillPageTest() {
        getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc36.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc36.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account overlay.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc36.getAccountDetails().getBan());
        }
		reporter.reportLogWithScreenshot("Page after login.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
        						"Login success.",
        						"Login Error. Refer screenshot");
        getRogersAccountOverviewPage().clickViewYourBill();
		getReporter().hardAssert(getRogersBillingPage().verifyViewBillLoaded(),
				"View bill page loaded.",
				"View bill page not loaded.");
		reporter.reportLogWithScreenshot("Billing and payment page.");
		getRogersBillingPage().clkLnkSavePdf();
		getReporter().hardAssert(getRogersBillingPage().isModalSaveOrPrintBillDisplayed(),
				"Modal displayed Correctly.",
				"Modal did not appear.");
		getRogersBillingPage().clkBtnDownloadBills();
		getReporter().hardAssert(getRogersBillingPage().isSuccessMessageDisplayed(),
				"Success message displayed.",
				"Success message not displayed.");
		getReporter().reportLogWithScreenshot("Bill got downloaded successfully");
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
