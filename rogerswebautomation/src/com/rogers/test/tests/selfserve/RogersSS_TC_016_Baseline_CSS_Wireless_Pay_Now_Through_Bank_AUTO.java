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
import com.rogers.pages.RogersMakePaymentPage;



public class RogersSS_TC_016_Baseline_CSS_Wireless_Pay_Now_Through_Bank_AUTO extends BaseTestClass {	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(priority = 1)
    public void baselineCSSWirelessPayNowThroughBankAUTO() {    	    	    
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc161825.getUsername();
    	String strPassword = TestDataHandler.tc161825.getPassword();		
		tryLogin(strUsername, strPassword);
		reporter.reportLogWithScreenshot("Account overveiew page");
				
			rogers_account_overview_page.clkBillingAndPaymentsMakeAPayment();
			String amountEntered = "0.1";
			rogers_make_payment_page.setPaymentAmount(amountEntered);
			reporter.reportLogWithScreenshot("Amount Entered");
			rogers_make_payment_page.selectHowWouldYouLikeToPay(RogersMakePaymentPage.MakePayOptions.Bank);
			reporter.reportLogWithScreenshot("Bank option selected");
			String strMainWindowHandle = getDriver().getWindowHandle();
			rogers_make_payment_page.selectBank("CIBC");
			reporter.reportLogWithScreenshot("Banking Page");
			rogers_make_payment_page.switchToCIBCBankPage(strMainWindowHandle);			
			reporter.hardAssert(rogers_make_payment_page.verifyBankPageOpenedSuccessfully("CIBC"),
					"The banking page open successfully",
					"The banking page did not open successfully");			
			//close the new bank page
			getDriver().close();
			getDriver().switchTo().window(strMainWindowHandle);
			reporter.reportLogWithScreenshot("Banking page closed");			
			reporter.softAssert(rogers_make_payment_page.verifyIfTheSelectedBankIsDisplayedCorrectlyOnTheMakePaymentOverLay(),
					"Selected Bank is displayed on the make payment overlay.",
					"Selected Bank isn't displayed on the make payment overlay.");																	
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
    
}
