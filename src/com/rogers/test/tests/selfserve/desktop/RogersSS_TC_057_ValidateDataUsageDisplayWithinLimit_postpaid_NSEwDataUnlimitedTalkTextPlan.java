package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_057_ValidateDataUsageDisplayWithinLimit_postpaid_NSEwDataUnlimitedTalkTextPlan extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"SanitySS","RegressionSS","WirelessDashboardSS"})
    public void validateLimitedTalkTextUsageDisplayWithinLimit() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc57.getUsername();
    	String strPassword = TestDataHandler.tc57.getPassword();
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
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc57.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc57.getAccountDetails().getCtn();
        getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        //getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
       
        //verify Data usage
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyDataDelayMessage(),
				"Data delayed by 12 hours message is displayed", 
				"Data delayed by 12 hours message is NOT displayed");
		reporter.hardAssert(getRogersWirelessDashboardPage().verifyDataRemainingOutOfTotalDataBucket(),
						"Data remaining out of Total data bucket info should be displayed", 
						"Data remaining out of Total data bucket info is not displayed.");
		reporter.hardAssert(getRogersWirelessDashboardPage().verifyTotalDataBucket(),
						"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info should be displayed", 
						"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info NOT displayed");

        reporter.hardAssert(getRogersWirelessDashboardPage().verifyDaysRemainingInTheBillCycleIsDisplayed(),
							"Days left remaining in the bill cycle is displayed", 
							"Days left remaining in the bill cycle is NOT displayed");        
		
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
        
        //verify Talk & Text usage detail section
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyFullPlanTalkTextUsageModuleIsDisplayed(),
				"Talk & Text usage module for full plan is displayed.", 
				"Talk & Text usage module for full plan is not displayed.");
       // reporter.softAssert(getRogersWirelessDashboardPage().verifyUnlimitedTalkMinutesIsDisplayed(),
       // "Unlimited minutes for talk is displayed.", 
		//		"Unlimited minutes for talk is not displayed.");
        if(getRogersWirelessDashboardPage().verifyUnlimitedTextsIsDisplayed())
        {
        	reporter.reportLogPass("Unlimited text is displayed.");
        }else
        {
        	reporter.reportLog("Unlimited text is NOT displayed for this account");
        }
        
        getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");
        
        getRogersWirelessDashboardPage().scrollToBottomOfPage();;
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
    }

}
