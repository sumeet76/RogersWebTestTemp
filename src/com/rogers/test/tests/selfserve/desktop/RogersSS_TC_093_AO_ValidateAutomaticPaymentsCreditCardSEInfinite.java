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
    	 //getRogersLoginPage().switchToSignInIFrame();
    	 getRogersLoginPage().setUsernameIFrame(strUsername);
         getRogersLoginPage().setPasswordIFrame(strPassword);
 		reporter.reportLogWithScreenshot("Login Credential is entered.");
         getRogersLoginPage().clkSignInIFrame();
         reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
         getRogersLoginPage().clkSkipIFrame();
         //getRogersLoginPage().switchOutOfSignInIFrame();
    }
    
    @Test(groups = {"RegressionSS","BillingAndPaymentsSS","AccountOverviewSS"})
    public void validateAutomaticPaymentsCreditCardSEInfinite() {

    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc6269.getUsername();
    	String strPassword = TestDataHandler.tc6269.getPassword();		
		tryLogin(strUsername, strPassword);
		reporter.reportLogWithScreenshot("Account overveiew page");		
		//getRogersAccountOverviewPage().clkViewBill();
		if(!getRogersAccountOverviewPage().isCCDisplayedOnAccountOverViewPage())
		{
			if(getRogersAccountOverviewPage().isAutoPaymentAlreadySet())
			{
				reporter.reportLogWithScreenshot("Automatic payment is already set, trying to switch to manual");
				getRogersAccountOverviewPage().clkChangePaymentMethod();			
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
		}	
		
		reporter.softAssert((getRogersAccountOverviewPage().verifyThatAutoPaymentWithCCIsDisplayedOnAccountOverViewPage()
				&& getRogersAccountOverviewPage().verifyCCEndingWithIsDisplayedCorrectly())
				,"Auto payment CC details displayed on the Account overview page"
				,"Auto payment CC details is NOT displayed on the Account overview page page");
		reporter.reportLogWithScreenshot("Billing widget is displayed with type of CC, last 4 digits of CC Number");
		reporter.reportLogWithScreenshot("Click on View Bill");
		getRogersAccountOverviewPage().clkViewBill();
		reporter.softAssert((getRogersAccountOverviewPage().verifyThatAutoPaymentWithCCIsDisplayedOnAccountOverViewPage()
				&& getRogersAccountOverviewPage().isChangePaymentMethodDisplayed())
				,"Auto payment CC details displayed on the Billing and Payment page"
				,"Auto payment CC details is NOT displayed on the Billing and Payment page");
 		reporter.reportLogWithScreenshot("Auto payment CC details displayed on the Billing and payment page");

    }


    
}
