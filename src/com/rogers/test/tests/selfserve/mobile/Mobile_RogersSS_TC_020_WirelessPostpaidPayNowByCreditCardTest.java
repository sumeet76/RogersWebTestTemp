package com.rogers.test.tests.selfserve.mobile;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.pages.RogersMakePaymentPage;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;



public class Mobile_RogersSS_TC_020_WirelessPostpaidPayNowByCreditCardTest extends BaseTestClass {

    @Test
    public void payNowByCreditCard() {
        rogers_home_page.clkSignInMobile();
        rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(TestDataHandler.tc1920.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.tc1920.getPassword());
		reporter.reportLogWithScreenshot("Login credential is entered.");
        rogers_login_page.clkSignInIFrame();
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();                   
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),
			        		"Login successful",
			        		"Login Error. Refer screenshot");
        common_business_flows.clkCloseFeedbackIfAvailableMobile();
        //rogers_account_overview_page.clkViewBill();
        rogers_account_overview_page.clickMakePayment();
		reporter.reportLogWithScreenshot("Make Payment button is clicked.");
        reporter.hardAssert(rogers_secure_payment_page.verifySecurePaymentLoad(),
			        		"Secure payment loaded",
			        		"Secure Payment overlay error. Refer screenshot");                    
        String strPaymentAmount="2";
        rogers_secure_payment_page.setPaymentAmount(strPaymentAmount);
        rogers_make_payment_page.selectHowWouldYouLikeToPay(RogersMakePaymentPage.MakePayOptions.credit);
		reporter.reportLogWithScreenshot("Card option selected");
        rogers_secure_payment_page.setCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
        rogers_secure_payment_page.setCardExpiryMonth(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth());
        rogers_secure_payment_page.setCardExpiryYear(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
        rogers_secure_payment_page.setSecurityCode(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
        rogers_secure_payment_page.clickReviewAndContinue();
        rogers_secure_payment_page.clickPayNow();
        reporter.reportLogWithScreenshot("Payment status");
        reporter.hardAssert(rogers_secure_payment_page.verifyPaymentSuccessful(strPaymentAmount),
			        		"Payment confirmaton",
			        		"Payment Confirmation message Error. Refer screenshot");        
        String strReferenceNumber= rogers_secure_payment_page.getTransactionReferenceNumber();
        reporter.reportLogWithScreenshot("Payment Successful, Transaction reference number is :"+strReferenceNumber);
        rogers_secure_payment_page.clickDone();
        reporter.hardAssert((rogers_billing_page.verifyPaymentSuccessful(strPaymentAmount)
        					&& rogers_billing_page.getTransactionReferenceNumber().contains(strReferenceNumber)),
			        		"Payment confirmation message displayed",
			        		"Payment Confirmation message Error. Refer screenshot");
        common_business_flows.scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("Payment Confirmation on account overview page");        
        reporter.hardAssert(rogers_billing_page.verifyThePaymentHistoryRecordMobile(strReferenceNumber),
        					"The payment history record is created for the credit transaction"
        					,"The payment history is not created for the credit transaction, please investigate for ref  num :"+strReferenceNumber);
        
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
