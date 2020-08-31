package com.rogers.test.tests.selfserve.mobile;

import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;  
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;



public class Mobile_RogersSS_TC_057_ValidateDataUsageDisplayWithinLimit_postpaid_NSEwDataUnlimitedTalkTextPlan extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validateLimitedTalkTextUsageDisplayWithinLimit() {
    	reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	rogers_home_page.clkSignInMobile();
    	String strUsername = TestDataHandler.tc57.getUsername();
    	String strPassword = TestDataHandler.tc57.getPassword();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc57.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        rogers_account_overview_page.clkMenuUsageAndServiceMobile();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");       
        String strAccountNum = TestDataHandler.tc57.getAccountDetails().getCtn();
        rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        //rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
       
        //verify Data usage
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyDataDelayMessage(), 
				"Data delayed by 12 hours message is displayed", 
				"Data delayed by 12 hours message is NOT displayed");
		reporter.softAssert(rogers_wireless_dashboard_page.verifyDataRemainingOutOfTotalDataBucket(), 
						"Data remaining out of Total data bucket info should be displayed", 
						"Data remaining out of Total data bucket info is not displayed.");
		reporter.softAssert(rogers_wireless_dashboard_page.verifyTotalDataBucket(), 
						"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info should be displayed", 
						"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info NOT displayed");

        reporter.softAssert(rogers_wireless_dashboard_page.verifyDaysRemainingInTheBillCycleIsDisplayed(), 
							"Days left remaining in the bill cycle is displayed", 
							"Days left remaining in the bill cycle is NOT displayed");        
		
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
        
        //verify Talk & Text usage detail section
        reporter.softAssert(rogers_wireless_dashboard_page.verifyFullPlanTalkTextUsageModuleIsDisplayed(), 
				"Talk & Text usage module for full plan is displayed.", 
				"Talk & Text usage module for full plan is not displayed.");
       // reporter.softAssert(rogers_wireless_dashboard_page.verifyUnlimitedTalkMinutesIsDisplayed(), 
       // "Unlimited minutes for talk is displayed.", 
		//		"Unlimited minutes for talk is not displayed.");
        if(rogers_wireless_dashboard_page.verifyUnlimitedTextsIsDisplayed())
        {
        	reporter.reportLogPass("Unlimited text is displayed.");
        }else
        {
        	reporter.reportLog("Unlimited text is NOT displayed for this account");
        }
        
        rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");
        
        rogers_wireless_dashboard_page.scrollToBottomOfPage();;
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
    }

}
