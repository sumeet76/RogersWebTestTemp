package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_054_ValidateUsageDetails_postpaid_NSEwUnlimitedTalkTextOnlyPlan extends BaseTestClass {	
    
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
    public void validateUsageDisplayWithinLimit() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc54.getUsername();
    	String strPassword = TestDataHandler.tc54.getPassword();
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
            rogers_account_overview_page.selectAccount(TestDataHandler.tc54.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc54.getAccountDetails().getCtn();
        rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
        
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyTalkTextOnlyUsageModuleIsDisplayed(), 
				"Talk & Text usage module is displayed.", 
				"Talk & Text usage module is not displayed.");
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyUnlimitedTalkMinutesIsDisplayed(), 
				"Talk usage unlimited minutes is displayed.", 
				"Talk usage unlimited minutes is not displayed.");
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyUnlimitedTalkWeekdayUsageIsDisplayed(), 
				"Talk unlimited weekday usage is displayed.", 
				"Talk unlimited weekday usage is not displayed.");
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyUnlimitedTalkNightAndWeekendUsageIsDisplayed(), 
				"Talk unlimited weekday night and weekend usage is displayed.", 
				"Talk unlimited weekday night and weekend usage is not displayed.");
        
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
        
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyUnlimitedTextsIsDisplayed(), 
				"Text usage unlimited texts is displayed.", 
				"Text usage unlimited texts is not displayed.");
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyUnlimitedTextsPictureAndVideoIsDisplayed(), 
				"Text usage unlimited  picture and video messages is displayed.", 
				"Text usage unlimited picture and video messages is not displayed.");
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyUnlimitedTextsBundlesMsgIsDisplayed(), 
				"Text usage unlimited bundles messages is displayed.", 
				"Text usage unlimited bundles messages is not displayed.");
        
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyTalkUsageAndTextUsageIncludeValueAreUnlimited(), 
				"In both Talk usage and Text usage the include value are all Unlimited.", 
				"In both Talk usage and Text usage the include value not all are Unlimited, please investigate.");
        
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyTalkUsageAndTextUsageUsedValueAreNumber(), 
				"In both Talk usage and Text usage the used value are all number", 
				"In both Talk usage and Text usage the used value are not all number, please investigate.");
        
        rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");
        
        rogers_wireless_dashboard_page.scrollToBottomOfPage();;
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
    }




}
