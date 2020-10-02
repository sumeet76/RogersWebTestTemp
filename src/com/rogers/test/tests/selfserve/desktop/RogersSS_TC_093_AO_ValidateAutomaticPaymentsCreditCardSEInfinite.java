package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_093_AO_ValidateAutomaticPaymentsCreditCardSEInfinite extends BaseTestClass {	
    
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
    	 rogers_login_page.switchToSignInIFrame();
    	 rogers_login_page.setUsernameIFrame(strUsername);
         rogers_login_page.setPasswordIFrame(strPassword);
 		reporter.reportLogWithScreenshot("Login Credential is entered.");
         rogers_login_page.clkSignInIFrame();
         reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
         rogers_login_page.clkSkipIFrame();      
         rogers_login_page.switchOutOfSignInIFrame();
    }
    
    @Test(groups = {"RegressionSS","BillingAndPaymentsSS"})
    public void validateAutomaticPaymentsCreditCardSEInfinite() {

    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc6269.getUsername();
    	String strPassword = TestDataHandler.tc6269.getPassword();		
		tryLogin(strUsername, strPassword);
		reporter.reportLogWithScreenshot("Account overveiew page");		
		rogers_account_overview_page.clkViewBill();
		if(!rogers_account_overview_page.isCCDisplayedOnAccountOverViewPage())
		{
			if(!rogers_account_overview_page.isSetAutoPaymentDisplayed())
			{				
				rogers_account_overview_page.clkBillingAndPaymentsSubMenuChangePaymentMethod();				
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
		}	
		
		reporter.softAssert((rogers_account_overview_page.verifyThatAutoPaymentWithCCIsDisplayedOnAccountOverViewPage()
				&& rogers_account_overview_page.verifyCCEndingWithIsDisplayedCorrectly(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber()))
				,"Auto payment CC details displayed on the Account overview page"
				,"Auto payment CC details is NOT displayed on the Account overview page page");
		reporter.reportLogWithScreenshot("Billing widget is displayed with type of CC, last 4 digits of CC Number");
		reporter.reportLogWithScreenshot("Click on View Bill");
		rogers_account_overview_page.clkViewBill();
		reporter.softAssert((rogers_account_overview_page.verifyThatAutoPaymentWithCCIsDisplayedOnAccountOverViewPage()
				&& rogers_account_overview_page.isChangePaymentMethodDisplayed())
				,"Auto payment CC details displayed on the Billing and Payment page"
				,"Auto payment CC details is NOT displayed on the Billing and Payment page");
 		reporter.reportLogWithScreenshot("Auto payment CC details displayed on the Billing and payment page");

    }


    
}
