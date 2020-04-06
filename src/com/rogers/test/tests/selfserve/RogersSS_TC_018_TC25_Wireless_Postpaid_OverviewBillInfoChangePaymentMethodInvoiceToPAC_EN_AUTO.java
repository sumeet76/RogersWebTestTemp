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


public class RogersSS_TC_018_TC25_Wireless_Postpaid_OverviewBillInfoChangePaymentMethodInvoiceToPAC_EN_AUTO extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(priority = 1)
    public void overviewBillInfoChangePaymentMethodInvoiceToPAC() {
    	    	    
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc161825.getUsername();
    	String strPassword = TestDataHandler.tc161825.getPassword();		
		tryLogin(strUsername, strPassword);
		reporter.reportLogWithScreenshot("Account overveiew page");
		if(!rogers_account_overview_page.isSetAutoPaymentDisplayed())
		{
			reporter.reportLogWithScreenshot("Automatic payment is already set, trying to switch to manual");
			rogers_account_overview_page.clkBillingAndPaymentsSubMenuChangePaymentMethod();
			rogers_change_payment_method_page.clkSwitchToManualPayments();
			rogers_change_payment_method_page.clkYesCancelAutomaticPayment();
			reporter.reportLogWithScreenshot("Switch to manual completed");
			rogers_change_payment_method_page.clkButtonDoneChangePayment();
			reporter.reportLogWithScreenshot("Account overveiew page");
			rogers_account_overview_page.clkSetUpAutomaticPaymentMethod();
		}else
		{
			rogers_account_overview_page.clkBillngsAndPaymentsSubMenuSetUpAutomaticPaymentMethod();
			reporter.reportLogWithScreenshot("Set auto payment overlay");
		}			
		rogers_change_payment_method_page.clkUseBankAccountForAutomaticPayments();
		rogers_change_payment_method_page.setTransitCode(TestDataHandler.paymentInfo.getBankDetails().getTransitCode());
		rogers_change_payment_method_page.setBankCode(TestDataHandler.paymentInfo.getBankDetails().getBankCode());
		rogers_change_payment_method_page.setAccountNumber(TestDataHandler.paymentInfo.getBankDetails().getAccountNumber()); //2563695869
		reporter.reportLogWithScreenshot("Bank details entered");
		rogers_change_payment_method_page.clkContinue();
		rogers_change_payment_method_page.clkTermsAndCond();
		reporter.reportLogWithScreenshot("T n C selected");
		rogers_change_payment_method_page.clkSubmit();
		reporter.reportLogWithScreenshot("Click performed on submit button");
		reporter.hardAssert(rogers_change_payment_method_page.verifySuccessMessageIsDisplayed(),
				"Set up auto payment is successful",
				"Set up auto payment is not successful");
 		reporter.reportLogWithScreenshot("Auto Payment setting completed.");
		rogers_change_payment_method_page.clkOnDone();		
		//check payment method on overview page		
		reporter.softAssert(rogers_account_overview_page.verifyThatAutoPaymentIsDisplayedOnAccountOverViewPage(),
				"Auto payment account details displayed on the account overview page",
				"Auto payment account details NOT displayed on the account overview page");			
    }

    private void tryLogin(String strUsername, String strPassword) {
    	 rogers_login_page.switchToSignInIFrame();
    	 rogers_login_page.setUsernameIFrame(strUsername);
         rogers_login_page.setPasswordIFrame(strPassword);
  		 reporter.reportLogWithScreenshot("Login Credential is entered.");
         rogers_login_page.clkSignInIFrame();
         rogers_login_page.clkSkipIFrame();
         rogers_login_page.switchOutOfSignInIFrame();    
    }

       
    @Test(priority = 2,dependsOnMethods = "overviewBillInfoChangePaymentMethodInvoiceToPAC")
    public void wirelessPostpaidChangePaymentMethodToManualTest() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc161825.getUsername();
    	String strPassword = TestDataHandler.tc161825.getPassword();		
		tryLogin(strUsername, strPassword);
		reporter.reportLogWithScreenshot("Account overveiew page");

		if(!rogers_account_overview_page.isSetAutoPaymentDisplayed())
		{
			reporter.reportLogWithScreenshot("Automatic payment is already set, trying to switch to manual");
			rogers_account_overview_page.clkBillingAndPaymentsSubMenuChangePaymentMethod();
			rogers_change_payment_method_page.clkSwitchToManualPayments();
			rogers_change_payment_method_page.clkYesCancelAutomaticPayment();
			reporter.reportLogWithScreenshot("Payment method switch to manual completed");
			reporter.softAssert(rogers_change_payment_method_page.verifyChangePaymentMethodToManual(),
					"Change payment to manul completed successfully",
					"Change payment method to Manual failed. Refer screenshot");
			rogers_change_payment_method_page.clkButtonDoneChangePayment();
			reporter.reportLogWithScreenshot("Account overveiew page after change payment method.");                			
		}else
		{
			reporter.reportLog("The payment option is already set to manual");
		}
    }

    
}
