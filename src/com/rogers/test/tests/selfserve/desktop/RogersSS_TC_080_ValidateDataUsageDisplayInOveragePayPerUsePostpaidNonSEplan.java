package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_080_ValidateDataUsageDisplayInOveragePayPerUsePostpaidNonSEplan extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"RegressionSS","WirelessDashboardSS"})
    public void validateDataUsageDisplayInOverageForNSE() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc80.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc80.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc80.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc80.getAccountDetails().getCtn();        
        if (getRogersAccountOverviewPage().isAccountShowInDropDown(strAccountNum.substring(strAccountNum.length()-4))) {
            getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        } else {
        	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
        }
        
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyOverageChargesInTheUsageBar(),
        		"You have overage charge is displayed",
        		"You have overage charge is NOT displayed, please decrease the data usage and re validate");       
         reporter.hardAssert((getRogersWirelessDashboardPage().verifyCallOutMessageToAddDataIsDisplayed()
        		             && getRogersWirelessDashboardPage().verifyCallOutMessageToAddDataDueToOverageIsDisplayed()),
        		 "Call out message to add data is displayed",
        		 "Call out message to add data is not displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyDataDelayMessage(),
        					"Data delayed by 12 hours message is displayed", 
        					"Data delayed by 12 hours message is NOT displayed");
        reporter.reportLogWithScreenshot("Wireless dashboard page."); 
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyTotalDataBucket(),
							"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info should be displayed", 
							"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info NOT displayed");      
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyAddDataButtonIsDisplayed(),
							"Add the Data top-up button is displayed", 
							"Add the Data top-up  button is NOT displayed."); 
       
    }
    
    
    

}
