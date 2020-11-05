package com.rogers.test.tests.selfserve.desktop;

import com.rogers.pages.RogersMakePaymentPage;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_020_WirelessPostpaidPayNowByCreditCardTest extends BaseTestClass {

    @Test(groups = {"SanitySS","RegressionSS","BillingAndPaymentsSS"})
    public void payNowByCreditCard() {
        getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc1920.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc1920.getPassword());
		reporter.reportLogWithScreenshot("Login credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();                   
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
			        		"Login successful",
			        		"Login Error. Refer screenshot");
        getRogersAccountOverviewPage().clkViewBill();
        getRogersAccountOverviewPage().clickMakePayment();
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
        reporter.reportLogWithScreenshot("Payment Confirmation on account overview page");
        getRogersBillingPage().sortPaymentHistoryTableByReferenceNumberDesc();
        reporter.hardAssert(getRogersBillingPage().verifyThePaymentHistoryRecord(strReferenceNumber),
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
