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



public class RogersSS_TC_019_Wireless_Postpaid_OverviewBillInfoChangePaymentMethodPACToCC_EN_AUTO extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
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

    
    @Test
    public void overviewBillInfoChangePaymentMethodPAC_To_CC() {

    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc1920.getUsername();
    	String strPassword = TestDataHandler.tc1920.getPassword();		
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
		rogers_change_payment_method_page.clkUseCCForAutomaticPayments();
		rogers_change_payment_method_page.setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
		rogers_change_payment_method_page.setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
		rogers_change_payment_method_page.selectCreditcardExpiryMonth(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth());
		rogers_change_payment_method_page.selectCreditcardExpiryYear(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
		reporter.reportLogWithScreenshot("CC details entered");
		rogers_change_payment_method_page.clkContinue();
		reporter.softAssert(rogers_change_payment_method_page.labelCCDetailsWillBeKeptEncryptedMsgDisplayed(),
				"CC Details encrypted msg displayed",
				"CC Details encrypted msg NOT displayed");
		reporter.reportLogWithScreenshot("CC secured details");
		reporter.softAssert(rogers_change_payment_method_page.isCCSecuredAreaDisplayed(),
				"CC secured details displayed",
				"CC secured details NOT displayed");
		rogers_change_payment_method_page.clkContinueOnReviewPg();		
		reporter.softAssert(rogers_change_payment_method_page.verifySuccessMessageIsDisplayed(),
				"Set up auto payment is successful",
				"Set up auto payment is not successful");
 		reporter.reportLogWithScreenshot("Payment complete page.");
		rogers_change_payment_method_page.clkOnDone();		
		//check payment method on overview page		
		reporter.softAssert(rogers_account_overview_page.verifyThatAutoPaymentWithCCIsDisplayedOnAccountOverViewPage()
				,"Auto payment CC details displayed on the account overview page"
				,"Auto payment CC details NOT displayed on the account overview page");
 		reporter.reportLogWithScreenshot("Account overview page, check the payment method.");

    }


    
}
