package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_092_AO_ValidateTheMessageInAccountOverviewWhenTheAccountIsInCancelledState_SE extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	/**
1. Launch Rogers.com
2. Click on Sign-in
3. Sign-in with valid credentials
4. Validate the message displayed at the top of the billing widget in the account overview page
5. Validate the message links
6. Validate the billing widget below the cancelled account message
7. Validate the subsription widget 

1. Rogers.com up and running
2. Sign-in pop-up will be displayed
3. Account overview page will be displayed
4. Account cancelled message should be displayed as per mock screen
5. View Billing & Payment History and Manage profile links should be available 
6. The billing widget should be displayed as per the mock screen
7. Subscription widget or any other services widget should not be displayed for a cancelled account"
	 */
	
    @Test(groups = {"RegressionSS","AccountOverviewSS"})
    public void validateSignInAndAccountOverview() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc92.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc92.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc92.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(getRogersAccountOverviewPage().isAccountCancelledMessageDisplayed(),
        		"The cancelled account message is displayed as expected above the billing widget",
        		"The account cancelled message is NOT displayed ");
        reporter.reportLogWithScreenshot("Account cancelled message");
        reporter.hardAssert(getRogersAccountOverviewPage().isViewBillingAndPaymentHistoryDisplayedInsideAccountCancelledMessage(),
        		"The account cancelled message is displayed with View Billing & Payment History",
        		"The account cancelled message is NOT displayed with View Billing & Payment History");
        
        reporter.hardAssert(getRogersAccountOverviewPage().isManageProfileLinkDisplayedInsideAccountCancelledMessage(),
        		"Manage Profile displayed as expected",
        		"Manage Profile not displayed as expected");
        reporter.softAssert(getRogersAccountOverviewPage().isViewBillDisplayed(),"The View Bill link displayed",
        		"The View Bill link  NOt displayed");
        reporter.softAssert( getRogersAccountOverviewPage().isLnkSetAutoPaymentDisplayed(),"Payment history link displayed",
        		"Payment history link  Not displayed");
        reporter.softAssert(getRogersAccountOverviewPage().isLnkPaymentHistoryDisplayed(),"Set up autopayment link displayed",
	   "Set up autopayment link  Not displayed");
        		
        getCommonBusinessFlows().scrollToBottomOfWebPage();
        reporter.reportLogWithScreenshot("Checking CTN or other services");
        reporter.softAssert(getRogersAccountOverviewPage().isCTNNotDisplayed(),
        		"The cancelled account has no ctns or services",
        		"The cancelled account is showing ctn's please investigate");
        
        reporter.reportLogWithScreenshot("CTNs and other services not displayed");
    }

  

}
