package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_019_Wireless_Postpaid_OverviewBillInfoChangePaymentMethodPACToCC_EN_AUTO extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
		   
    private void tryLogin(String strUsername, String strPassword) {
    	 getRogersLoginPage().switchToSignInIFrame();
    	 getRogersLoginPage().setUsernameIFrame(strUsername);
         getRogersLoginPage().setPasswordIFrame(strPassword);
 		reporter.reportLogWithScreenshot("Login Credential is entered.");
         getRogersLoginPage().clkSignInIFrame();
         reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
         getRogersLoginPage().clkSkipIFrame();
         getRogersLoginPage().switchOutOfSignInIFrame();
    }

    
    @Test(groups = {"SanitySS","BillingAndPaymentsSS"})
    public void overviewBillInfoChangePaymentMethodPAC_To_CC() {

    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc1920.getUsername();
    	String strPassword = TestDataHandler.tc1920.getPassword();		
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
		
		
		getRogersChangePaymentMethodPage().clkUseCCForAutomaticPayments();
		getRogersSecurePaymentPage().setCardNumberNew(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
	    String strDDMM = TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth() + 
	        			TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear().substring(2);
	    getRogersSecurePaymentPage().setCardExpiry(strDDMM);	       
	    getRogersSecurePaymentPage().setSecurityCode(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
		
		
		//getRogersChangePaymentMethodPage().setCreditCardNumber(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber());
		//getRogersChangePaymentMethodPage().setCreditcardCVV(TestDataHandler.paymentInfo.getCreditCardDetails().getCVV());
		//getRogersChangePaymentMethodPage().selectCreditcardExpiryMonth(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryMonth());
		//getRogersChangePaymentMethodPage().selectCreditcardExpiryYear(TestDataHandler.paymentInfo.getCreditCardDetails().getExpiryYear());
		reporter.reportLogWithScreenshot("CC details entered");
		getRogersChangePaymentMethodPage().clkContinueSettingCC();
		reporter.hardAssert(getRogersChangePaymentMethodPage().isReviewCCDetailsPageDisplayed(),
				"CC Details encrypted msg displayed",
				"CC Details encrypted msg NOT displayed");
		reporter.reportLogWithScreenshot("CC secured details");
		
		getRogersChangePaymentMethodPage().clkContinueOnReviewPg();
		reporter.hardAssert(getRogersChangePaymentMethodPage().verifySuccessMessageIsDisplayed(),
				"Set up auto payment is successful",
				"Set up auto payment is not successful");
 		reporter.reportLogWithScreenshot("Payment complete page.");
		getRogersChangePaymentMethodPage().clkOnDone();
		//check payment method on overview page	
		getDriver().navigate().refresh();
		reporter.hardAssert(getRogersAccountOverviewPage().verifyThatAutoPaymentWithCCIsDisplayedOnAccountOverViewPage()
				,"Auto payment CC details displayed on the account overview page"
				,"Auto payment CC details NOT displayed on the account overview page");
 		reporter.reportLogWithScreenshot("Account overview page, check the payment method.");

    }


    
}
