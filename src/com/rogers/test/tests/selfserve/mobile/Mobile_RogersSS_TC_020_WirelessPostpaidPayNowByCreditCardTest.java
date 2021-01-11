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

    @Test(groups = {"MobileSanitySS"})
    public void payNowByCreditCard() {
        getRogersHomePage().clkSignInMobile();
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc1920.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc1920.getPassword());
		reporter.reportLogWithScreenshot("Login credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();                   
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLoginMobile(),
			        		"Login successful",
			        		"Login Error. Refer screenshot");
        getCommonBusinessFlows().clkCloseFeedbackIfAvailableMobile();
        getRogersAccountOverviewPage().clkViewBill();
        reporter.reportLogWithScreenshot("Clicked on view bill");        
        getCommonBusinessFlows().clkCloseFeedbackIfAvailableMobile();
        getRogersAccountOverviewPage().clickMakePayment();        
        reporter.reportLogWithScreenshot("Make Payment button is clicked.");		
        reporter.hardAssert(getRogersSecurePaymentPage().verifyNewMakePaymentViewLoad(),
        		"Secure payment loaded",
        		"Secure Payment overlay error. Refer screenshot"); 
        String strPaymentAmount="2";
        getRogersMakePaymentPage().selectHowWouldYouLikeToPayNew(RogersMakePaymentPage.MakePayOptions.credit);
        getRogersSecurePaymentPage().setPaymentAmountNew(strPaymentAmount);         
        reporter.reportLogWithScreenshot("Card option selected");                
        getRogersSecurePaymentPage().setCardNumberNew(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
        String strDDMM = TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth() + 
        			TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear().substring(2);
        getRogersSecurePaymentPage().setCardExpiry(strDDMM);
        
        getRogersSecurePaymentPage().setSecurityCode(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
        getRogersSecurePaymentPage().clickReviewAndContinue();
        getRogersSecurePaymentPage().clickPayNow();
        
        reporter.reportLogWithScreenshot("Payment status");
        reporter.hardAssert(getRogersSecurePaymentPage().verifyPaymentSuccessful(strPaymentAmount),
			        		"Payment confirmaton",
			        		"Payment Confirmation message Error. Refer screenshot");        
        String strReferenceNumber= getRogersSecurePaymentPage().getTransactionReferenceNumberNew();
        reporter.reportLogWithScreenshot("Payment Successful, Details :"+strReferenceNumber);
    
        getRogersSecurePaymentPage().clickDone();
        
        /*
		reporter.reportLogWithScreenshot("Make Payment button is clicked.");
        reporter.hardAssert(getRogersSecurePaymentPage().verifySecurePaymentLoad(),
			        		"Secure payment loaded",
			        		"Secure Payment overlay error. Refer screenshot");                    
        String strPaymentAmount="2";
        getRogersSecurePaymentPage().setPaymentAmount(strPaymentAmount);
        getRogersMakePaymentPage().selectHowWouldYouLikeToPay(RogersMakePaymentPage.MakePayOptions.credit);
		reporter.reportLogWithScreenshot("Card option selected");
        getRogersSecurePaymentPage().setCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
        getRogersSecurePaymentPage().setCardExpiryMonth(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth());
        getRogersSecurePaymentPage().setCardExpiryYear(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
        getRogersSecurePaymentPage().setSecurityCode(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
        getRogersSecurePaymentPage().clickReviewAndContinue();
        getRogersSecurePaymentPage().clickPayNow();
        reporter.reportLogWithScreenshot("Payment status");
        reporter.hardAssert(getRogersSecurePaymentPage().verifyPaymentSuccessful(strPaymentAmount),
			        		"Payment confirmaton",
			        		"Payment Confirmation message Error. Refer screenshot");        
        String strReferenceNumber= getRogersSecurePaymentPage().getTransactionReferenceNumber();
        reporter.reportLogWithScreenshot("Payment Successful, Transaction reference number is :"+strReferenceNumber);
        getRogersSecurePaymentPage().clickDone();
        reporter.hardAssert((getRogersBillingPage().verifyPaymentSuccessful(strPaymentAmount)
        					&& getRogersBillingPage().getTransactionReferenceNumber().contains(strReferenceNumber)),
			        		"Payment confirmation message displayed",
			        		"Payment Confirmation message Error. Refer screenshot");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("Payment Confirmation on account overview page");        
        reporter.hardAssert(getRogersBillingPage().verifyThePaymentHistoryRecordMobile(strReferenceNumber),
        					"The payment history record is created for the credit transaction"
        					,"The payment history is not created for the credit transaction, please investigate for ref  num :"+strReferenceNumber);
        					
        					*/
        
        
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
