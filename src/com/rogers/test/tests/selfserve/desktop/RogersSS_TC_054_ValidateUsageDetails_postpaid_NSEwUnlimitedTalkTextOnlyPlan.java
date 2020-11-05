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
	
	
    @Test(groups = {"RegressionSS","WirelessDashboardSS"})
    public void validateUsageDisplayWithinLimit() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc54.getUsername();
    	String strPassword = TestDataHandler.tc54.getPassword();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc54.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc54.getAccountDetails().getCtn();
        getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
        
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyTalkTextOnlyUsageModuleIsDisplayed(),
				"Talk & Text usage module is displayed.", 
				"Talk & Text usage module is not displayed.");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyUnlimitedTalkMinutesIsDisplayed(),
				"Talk usage unlimited minutes is displayed.", 
				"Talk usage unlimited minutes is not displayed.");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyUnlimitedTalkWeekdayUsageIsDisplayed(),
				"Talk unlimited weekday usage is displayed.", 
				"Talk unlimited weekday usage is not displayed.");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyUnlimitedTalkNightAndWeekendUsageIsDisplayed(),
				"Talk unlimited weekday night and weekend usage is displayed.", 
				"Talk unlimited weekday night and weekend usage is not displayed.");
        
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
        
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyUnlimitedTextsIsDisplayed(),
				"Text usage unlimited texts is displayed.", 
				"Text usage unlimited texts is not displayed.");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyUnlimitedTextsPictureAndVideoIsDisplayed(),
				"Text usage unlimited  picture and video messages is displayed.", 
				"Text usage unlimited picture and video messages is not displayed.");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyUnlimitedTextsBundlesMsgIsDisplayed(),
				"Text usage unlimited bundles messages is displayed.", 
				"Text usage unlimited bundles messages is not displayed.");
        
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyTalkUsageAndTextUsageIncludeValueAreUnlimited(),
				"In both Talk usage and Text usage the include value are all Unlimited.", 
				"In both Talk usage and Text usage the include value not all are Unlimited, please investigate.");
        
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyTalkUsageAndTextUsageUsedValueAreNumber(),
				"In both Talk usage and Text usage the used value are all number", 
				"In both Talk usage and Text usage the used value are not all number, please investigate.");
        
        getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");
        
        getRogersWirelessDashboardPage().scrollToBottomOfPage();;
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
    }




}
