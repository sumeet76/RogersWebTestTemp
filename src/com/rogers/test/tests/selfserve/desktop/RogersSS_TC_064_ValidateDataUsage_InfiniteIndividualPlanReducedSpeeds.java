package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_064_ValidateDataUsage_InfiniteIndividualPlanReducedSpeeds extends BaseTestClass {	
   	
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
    public void validateDataUsageForInfiniteNsePlanReducedSpeed() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc64.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc64.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc64.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");  
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc64.getAccountDetails().getCtn();
        String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length()-4);
        if (getRogersAccountOverviewPage().isAccountShowInDropDown(strLast4DigitAccount)) {
            getRogersAccountOverviewPage().clkDropDownAccount(strLast4DigitAccount);
        } else {
     	   getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
        }
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
        
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyUnlimitedDataNoOverage(),
		        		"The unlimited data no overage is diaplyed",
		        		"The unlimited data no overage label is not displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifySpeedReducedMsg(),
						"Label using data at reduced speed is displayed",
						"Label using data at reduced speed is not displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifySpeedPassButtonIsDisplayed(),
						"Link add speed pass is displayed",
						"Link add speed pass is not displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyCallOutMsgToAddSpeedPassIsDisplayed(),
						"Call out message to Add speed pass is displayed",
						"call out message to add speed pass is not displayed");
        reporter.reportLogWithScreenshot("Dashboard page of reduced speed.");          
        getRogersWirelessDashboardPage().clkCloseCallOutMsg();
        reporter.hardAssert(getRogersWirelessDashboardPage().validateCloseCallOutIsClosed(),
						"Click on close call out message successful",
						"Click on close call out message didnt succeed");
        reporter.reportLogWithScreenshot("Closed Call out message to Add speed pass on dashboard page.");  
        getCommonBusinessFlows().logOutAndReSignIn(strUsername, strPassword);   
//	        getRogersAccountOverviewPage().clkCtnBadge(last4Digit);
	        getRogersAccountOverviewPage().clkMenuUsageAndService();
	        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
	        if (getRogersAccountOverviewPage().isAccountShowInDropDown(strLast4DigitAccount)) {
	            getRogersAccountOverviewPage().clkDropDownAccount(strLast4DigitAccount);
	        } else {
	     	   getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
	        }

	        reporter.reportLogWithScreenshot("Navigated back to dashboard after re-sign in");     
            getRogersWirelessDashboardPage().verifyCallOutMsgToAddSpeedPassIsDisplayed();
            reporter.reportLogWithScreenshot("Dashboard with Call out message to Add speed pass displayed");
    }
    
    
    

}
