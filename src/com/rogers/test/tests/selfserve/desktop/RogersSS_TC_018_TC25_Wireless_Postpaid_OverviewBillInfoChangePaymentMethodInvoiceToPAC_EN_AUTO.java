package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_018_TC25_Wireless_Postpaid_OverviewBillInfoChangePaymentMethodInvoiceToPAC_EN_AUTO extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(priority = 1,groups = {"RegressionSS","BillingAndPaymentsSS"})
    public void overviewBillInfoChangePaymentMethodInvoiceToPAC() {
    	    	    
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc161825.getUsername();
    	String strPassword = TestDataHandler.tc161825.getPassword();		
		tryLogin(strUsername, strPassword);
		reporter.reportLogWithScreenshot("Account overveiew page");
		//getRogersAccountOverviewPage().clkViewBill();
		

				if(getRogersAccountOverviewPage().isAutoPaymentAlreadySet())
				{
					reporter.reportLogWithScreenshot("Automatic payment is already set, trying to switch to manual");
					getRogersAccountOverviewPage().clkChangePaymentMethod();			
					getRogersChangePaymentMethodPage().clkSwitchToManualPayments();
					getRogersChangePaymentMethodPage().clkYesCancelAutomaticPayment();
					reporter.reportLogWithScreenshot("Switch to manual completed");
					getRogersChangePaymentMethodPage().clkButtonDoneChangePayment();
					reporter.reportLogWithScreenshot("Account overveiew page");
					getDriver().navigate().refresh();
					reporter.reportLogWithScreenshot("Account overveiew page page refresh");
					getRogersAccountOverviewPage().clkSetUpAutomaticPaymentMethod();
				}else
				{
					getRogersAccountOverviewPage().clkSetUpAutoPaymentQuickLink();			
					reporter.reportLogWithScreenshot("Set auto payment overlay");
				}
		
						
		getRogersChangePaymentMethodPage().clkUseBankAccountForAutomaticPayments();
		getRogersChangePaymentMethodPage().setTransitCode(TestDataHandler.paymentInfo.getBankDetails().getTransitCode());
		getRogersChangePaymentMethodPage().setBankCode(TestDataHandler.paymentInfo.getBankDetails().getBankCode());
		getRogersChangePaymentMethodPage().setAccountNumber(TestDataHandler.paymentInfo.getBankDetails().getAccountNumber()); //2563695869
		reporter.reportLogWithScreenshot("Bank details entered");
		getRogersChangePaymentMethodPage().clkContinueBank();
		getRogersChangePaymentMethodPage().clkTermsAndCond();
		reporter.reportLogWithScreenshot("T n C selected");
		getRogersChangePaymentMethodPage().clkSubmit();
		reporter.reportLogWithScreenshot("Click performed on submit button");
		reporter.hardAssert(getRogersChangePaymentMethodPage().verifySuccessMessageIsDisplayed(),
				"Set up auto payment is successful",
				"Set up auto payment is not successful");
 		reporter.reportLogWithScreenshot("Payment complete page.");
		getRogersChangePaymentMethodPage().clkOnDone();
		//check payment method on overview page	
		getDriver().navigate().refresh();
		//check payment method on overview page		
		reporter.hardAssert(getRogersAccountOverviewPage().verifyThatAutoPaymentIsDisplayedOnAccountOverViewPage(),
				"Auto payment account details displayed on the account overview page",
				"Auto payment account details NOT displayed on the account overview page");			
    }

    private void tryLogin(String strUsername, String strPassword) {
    	 //getRogersLoginPage().switchToSignInIFrame();
    	 getRogersLoginPage().setUsernameIFrame(strUsername);
         getRogersLoginPage().setPasswordIFrame(strPassword);
  		 reporter.reportLogWithScreenshot("Login Credential is entered.");
         getRogersLoginPage().clkSignInIFrame();
         reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
         getRogersLoginPage().clkSkipIFrame();
         //getRogersLoginPage().switchOutOfSignInIFrame();
    }

       
    @Test(priority = 2,dependsOnMethods = "overviewBillInfoChangePaymentMethodInvoiceToPAC",groups = {"RegressionSS","BillingAndPaymentsSS"})
    public void wirelessPostpaidChangePaymentMethodToManualTest() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc161825.getUsername();
    	String strPassword = TestDataHandler.tc161825.getPassword();		
		tryLogin(strUsername, strPassword);		
		reporter.reportLogWithScreenshot("Account overveiew page");
		//getRogersAccountOverviewPage().clkViewBill();
		if(getRogersAccountOverviewPage().isAutoPaymentAlreadySet())
		{
			reporter.reportLogWithScreenshot("Automatic payment is already set, trying to switch to manual");
			getRogersAccountOverviewPage().clkChangePaymentMethod();			
			getRogersChangePaymentMethodPage().clkSwitchToManualPayments();
			getRogersChangePaymentMethodPage().clkYesCancelAutomaticPayment();
			reporter.reportLogWithScreenshot("Switch to manual completed");
			reporter.hardAssert(getRogersChangePaymentMethodPage().verifyChangePaymentMethodToManual(),
					"Change payment to manual completed successfully",
					"Change payment method to Manual failed. Refer screenshot");
			getRogersChangePaymentMethodPage().clkButtonDoneChangePayment();
			reporter.reportLogWithScreenshot("Account overveiew page");
			getDriver().navigate().refresh();
			reporter.reportLogWithScreenshot("Account overveiew page after change payment method.");                			
		}else
		{
			reporter.reportLog("The payment option is already set to manual");
		}
		
		
	/*	if(!getRogersAccountOverviewPage().isSetAutoPaymentDisplayed())
		{
			reporter.reportLogWithScreenshot("Automatic payment is already set, trying to switch to manual");
			getRogersAccountOverviewPage().clkBillingAndPaymentsSubMenuChangePaymentMethod();
			getRogersChangePaymentMethodPage().clkSwitchToManualPayments();
			getRogersChangePaymentMethodPage().clkYesCancelAutomaticPayment();
			reporter.reportLogWithScreenshot("Payment method switch to manual completed");
			reporter.hardAssert(getRogersChangePaymentMethodPage().verifyChangePaymentMethodToManual(),
					"Change payment to manual completed successfully",
					"Change payment method to Manual failed. Refer screenshot");
			getRogersChangePaymentMethodPage().clkButtonDoneChangePayment();
			reporter.reportLogWithScreenshot("Account overveiew page after change payment method.");                			
		}else
		{
			reporter.reportLog("The payment option is already set to manual");
		}
		*/
    }

    
}
