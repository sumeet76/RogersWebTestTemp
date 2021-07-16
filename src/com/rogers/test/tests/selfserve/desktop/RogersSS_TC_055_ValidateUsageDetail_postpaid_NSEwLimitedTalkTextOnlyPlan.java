package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_055_ValidateUsageDetail_postpaid_NSEwLimitedTalkTextOnlyPlan extends BaseTestClass {	
    
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
    public void validateLimitedTalkTextUsageDisplayWithinLimit() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc55.getUsername();
    	String strPassword = TestDataHandler.tc55.getPassword();
    	//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc55.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc55.getAccountDetails().getCtn();
        getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
        
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
        
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyTalkTextOnlyUsageModuleIsDisplayed(),
        					"Talk & Text usage module is displayed.", 
        					"Talk & Text usage module is not displayed.");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyTalkMinutesRemainingIsDisplayed(),
							"Talk usage minutes remaining is displayed.", 
							"Talk usage minutes remaining is not displayed.");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyTalkUsageAnytimeIsDisplayed(),
							"Talk usage anytime is displayed.", 
							"Talk usage anytime is not displayed.");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyLimitedTalkUsageDetailsAccuracy(),
							"Talk usage details are accurate.", 
							"Talk usage details are not accurate, please investigate.");
        
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyLimitedTextsRemainingIsDisplayed(),
							"Text usage texts remaining is displayed.", 
							"Text usage texts remaining is not displayed.");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyLimitedTextsMsgSentIsDisplayed(),
							"Text usage texts sent is displayed.", 
							"Text usage texts sent is not displayed.");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyLimitedTextsMsgReceivedIsDisplayed(),
							"Text usage texts received is displayed.", 
							"Text usage texts received is not displayed.");
        
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyLimitedTextUsageDetailsAccuracy(),
							"Text usage details are accurate.", 
							"Text usage details are not accurate, please investigate.");
        
        getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");
        
        getRogersWirelessDashboardPage().scrollToBottomOfPage();;
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
    }

}
