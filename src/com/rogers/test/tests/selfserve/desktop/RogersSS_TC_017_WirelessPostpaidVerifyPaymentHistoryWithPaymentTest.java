package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_017_WirelessPostpaidVerifyPaymentHistoryWithPaymentTest extends BaseTestClass {
//	@DataProvider(name = "data-provider")
//    public Object[][] dataProviderMethod() {
//		
//        return new Object[][] {   
//        	{TestDataHandler.tc1920.getUsername(),TestDataHandler.tc1920.getPassword()},
//        	{TestDataHandler.tc44DigitalTVAccount.getUsername(),TestDataHandler.tc44DigitalTVAccount.getPassword()},
//        	        	
//        };
//    }
 

    @Test(/*dataProvider = "data-provider",*/groups = {"RegressionSS","BillingAndPaymentsSS"})
    public void verifyPaymentHistoryWithPayment( ) {
    	String strUsername = TestDataHandler.tc1920.getUsername();
    	String Password = TestDataHandler.tc1920.getPassword();
		getRogersHomePage().clkSignIn();		
		getRogersLoginPage().switchToSignInIFrame();

		getRogersLoginPage().setUsernameIFrame(strUsername);
		getRogersLoginPage().setPasswordIFrame(Password);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed without error.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		reporter.reportLogWithScreenshot("Account overveiew page");
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login successful",
				"Login Error. Refer screenshot");
		getRogersAccountOverviewPage().clkPaymentHistory();

		reporter.reportLogWithScreenshot("Payment history page.");
		reporter.hardAssert(getRogersPaymentHistoryPage().verifyPaymentHistoryIsDisplayed(),
				"Payment history is displayed", "Payment history is not displayed as expected.");
		reporter.hardAssert(getRogersPaymentHistoryPage().verifyIfPaymenyHistoryTablePresent(),
				"Payment history table is displayed", "Payment history table is not displayed as expected.");
		reporter.reportLogWithScreenshot("Transaction records view");
		int pageCount = getRogersPaymentHistoryPage().getTotalPage();
		if (pageCount != 0) {
			for (int page = 1; page <= pageCount; page++) {
				reporter.reportLogWithScreenshot("Payment history Page :" + page);
				getRogersPaymentHistoryPage().clkPageNumber(page);
				reporter.hardAssert(getRogersPaymentHistoryPage().verifyIfThePaymentHistoryDataIsConsistent(),
						"Payment history data is consistent in page: " + page,
						"Payment history data is not consistent for page no: " + page);
			}

		} else {
			reporter.reportLogWithScreenshot("Payment history records");
			reporter.hardAssert(getRogersPaymentHistoryPage().verifyIfThePaymentHistoryDataIsConsistent(),
					"Payment history data is consistent ", "Payment history data is not consistent");
		}
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
