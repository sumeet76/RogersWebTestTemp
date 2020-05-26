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



public class RogersSS_TC_055_ValidateUsageDetail_postpaid_NSEwLimitedTalkTextOnlyPlan extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validateLimitedTalkTextUsageDisplayWithinLimit() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc55.getUsername();
    	String strPassword = TestDataHandler.tc55.getPassword();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc55.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc55.getAccountDetails().getCtn();
        rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
        
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
        
        reporter.softAssert(rogers_wireless_dashboard_page.verifyTalkTextOnlyUsageModuleIsDisplayed(), 
        					"Talk & Text usage module is displayed.", 
        					"Talk & Text usage module is not displayed.");
        reporter.softAssert(rogers_wireless_dashboard_page.verifyTalkMinutesRemainingIsDisplayed(), 
							"Talk usage minutes remaining is displayed.", 
							"Talk usage minutes remaining is not displayed.");
        reporter.softAssert(rogers_wireless_dashboard_page.verifyTalkUsageAnytimeIsDisplayed(), 
							"Talk usage anytime is displayed.", 
							"Talk usage anytime is not displayed.");
        reporter.softAssert(rogers_wireless_dashboard_page.verifyLimitedTalkUsageDetailsAccuracy(), 
							"Talk usage details are accurate.", 
							"Talk usage details are not accurate, please investigate.");
        
        reporter.softAssert(rogers_wireless_dashboard_page.verifyLimitedTextsRemainingIsDisplayed(), 
							"Text usage texts remaining is displayed.", 
							"Text usage texts remaining is not displayed.");
        reporter.softAssert(rogers_wireless_dashboard_page.verifyLimitedTextsMsgSentIsDisplayed(), 
							"Text usage texts sent is displayed.", 
							"Text usage texts sent is not displayed.");
        reporter.softAssert(rogers_wireless_dashboard_page.verifyLimitedTextsMsgReceivedIsDisplayed(), 
							"Text usage texts received is displayed.", 
							"Text usage texts received is not displayed.");
        
        reporter.softAssert(rogers_wireless_dashboard_page.verifyLimitedTextUsageDetailsAccuracy(), 
							"Text usage details are accurate.", 
							"Text usage details are not accurate, please investigate.");
        
        rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");
        
        rogers_wireless_dashboard_page.scrollToBottomOfPage();;
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
    }

}
