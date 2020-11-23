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



public class RogersSS_TC_016_Baseline_CSS_Wireless_Pay_Now_Through_Bank_AUTO extends BaseTestClass {	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(groups = {"RegressionSS","BillingAndPaymentsSS"})
    public void baselineCSSWirelessPayNowThroughBankAUTO() {    	    	    
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc161825.getUsername();
    	String strPassword = TestDataHandler.tc161825.getPassword();		
		tryLogin(strUsername, strPassword);
		reporter.reportLogWithScreenshot("Account overveiew page");
		getRogersAccountOverviewPage().clkViewBill();
			getRogersAccountOverviewPage().clkBillingAndPaymentsMakeAPayment();
			String amountEntered = "0.1";
			getRogersMakePaymentPage().setPaymentAmount(amountEntered);
			reporter.reportLogWithScreenshot("Amount Entered");
			getRogersMakePaymentPage().selectHowWouldYouLikeToPay(RogersMakePaymentPage.MakePayOptions.Bank);
			reporter.reportLogWithScreenshot("Bank option selected");
			String strMainWindowHandle = getDriver().getWindowHandle();
			getRogersMakePaymentPage().selectBank("CIBC");
			reporter.reportLogWithScreenshot("Banking Page");
			getRogersMakePaymentPage().switchToCIBCBankPage(strMainWindowHandle);
			reporter.hardAssert(getRogersMakePaymentPage().verifyBankPageOpenedSuccessfully("CIBC"),
					"The banking page open successfully",
					"The banking page did not open successfully");			
			//close the new bank page
			getDriver().close();
			getDriver().switchTo().window(strMainWindowHandle);
			reporter.reportLogWithScreenshot("Banking page closed");			
			reporter.hardAssert(getRogersMakePaymentPage().verifyIfTheSelectedBankIsDisplayedCorrectlyOnTheMakePaymentOverLay(),
					"Selected Bank is displayed on the make payment overlay.",
					"Selected Bank isn't displayed on the make payment overlay.");																	
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
    
}
