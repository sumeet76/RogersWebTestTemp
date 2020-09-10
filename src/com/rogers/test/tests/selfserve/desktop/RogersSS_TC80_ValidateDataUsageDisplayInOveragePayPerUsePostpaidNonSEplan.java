package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC80_ValidateDataUsageDisplayInOveragePayPerUsePostpaidNonSEplan extends BaseTestClass {	
   	
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
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc80.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc80.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc80.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc80.getAccountDetails().getCtn();        
        if (rogers_account_overview_page.isAccountShowInDropDown(strAccountNum.substring(strAccountNum.length()-4))) {
            rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        } else {
        	rogers_account_overview_page.clkSubMenuWirelessUsage();
        }
        
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();        
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyOverageChargesInTheUsageBar(),
        		"You have overage charge is displayed",
        		"You have overage charge is NOT displayed, please decrease the data usage and re validate");       
         reporter.hardAssert((rogers_wireless_dashboard_page.verifyCallOutMessageToAddDataIsDisplayed()
        		             && rogers_wireless_dashboard_page.verifyCallOutMessageToAddDataDueToOverageIsDisplayed()),
        		 "Call out message to add data is displayed",
        		 "Call out message to add data is not displayed");
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyDataDelayMessage(), 
        					"Data delayed by 12 hours message is displayed", 
        					"Data delayed by 12 hours message is NOT displayed");
        reporter.reportLogWithScreenshot("Wireless dashboard page."); 
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyTotalDataBucket(), 
							"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info should be displayed", 
							"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info NOT displayed");      
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyAddDataButtonIsDisplayed(), 
							"Add the Data top-up button is displayed", 
							"Add the Data top-up  button is NOT displayed."); 
       
    }
    
    
    

}
