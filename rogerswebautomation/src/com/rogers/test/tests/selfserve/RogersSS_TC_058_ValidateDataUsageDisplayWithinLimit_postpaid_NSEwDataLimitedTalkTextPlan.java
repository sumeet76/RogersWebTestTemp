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



public class RogersSS_TC_058_ValidateDataUsageDisplayWithinLimit_postpaid_NSEwDataLimitedTalkTextPlan extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validateLimitedTalkTextUsageDisplayWithinLimit() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc58.getUsername();
    	String strPassword = TestDataHandler.tc58.getPassword();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc58.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc58.getAccountDetails().getCtn();
        rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
       
        //verify Data usage
        reporter.softAssert(rogers_wireless_dashboard_page.verifyDataDelayMessage(), 
				"Data delayed by 12 hours message is displayed", 
				"Data delayed by 12 hours message is NOT displayed");
		reporter.softAssert(rogers_wireless_dashboard_page.verifyDataRemainingOutOfTotalDataBucket(), 
						"Data remaining out of Total data bucket info should be displayed", 
						"Data remaining out of Total data bucket info is not displayed.");
		reporter.softAssert(rogers_wireless_dashboard_page.verifyTotalDataBucket(), 
						"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info should be displayed", 
						"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info NOT displayed");
        reporter.reportLogWithScreenshot("Navigated back to dashboard from manage data view");  
        reporter.softAssert(rogers_wireless_dashboard_page.verifyDaysRemainingInTheBillCycleIsDisplayed(), 
							"Days left remaining in the bill cycle is displayed", 
							"Days left remaining in the bill cycle is NOT displayed");        
        reporter.softAssert(rogers_wireless_dashboard_page.verifyAddDataButtonIsDisplayed(), 
							"Add the Data top-up  button should be displayed", 
							"Add the Data top-up  button is NOT displayed.");   		
        reporter.reportLogWithScreenshot("Wireless dashboard page.");
        
        //verify Talk & Text usage detail section
        reporter.softAssert(rogers_wireless_dashboard_page.verifyFullPlanTalkTextUsageModuleIsDisplayed(), 
				"Talk & Text usage module for full plan is displayed.", 
				"Talk & Text usage module for full plan is not displayed.");
        reporter.softAssert(rogers_wireless_dashboard_page.verifyTalkHaveMinutesRemainingValues(), 
				"Remaining minutes for talk is displayed.", 
				"Remaining minutes for talk is not displayed.");
        reporter.softAssert(rogers_wireless_dashboard_page.verifyTextHaveMinutesRemainingValues(), 
				"Remaining text is displayed.", 
				"Remaining text is not displayed.");
        rogers_wireless_dashboard_page.clkViewDetailsInFullPlanTalkAndTextUsageModule();
        reporter.softAssert(rogers_wireless_dashboard_page.verifyDsModalTalkTextDetailIsDisplayed(), 
				"Talk & Text detail ds-modal for full plan is displayed.", 
				"Talk & Text detail ds-modal for full plan is not displayed.");
        reporter.reportLogWithScreenshot("Talk and text details after click view details.");
        reporter.softAssert(rogers_wireless_dashboard_page.verifyDsModalTalkTextDetailComplyWithTalkTextUsageInWirelessDashboard(), 
				"Talk & Text details in ds-modal for full plan comply with the usage in dashboard.", 
				"Talk & Text details in ds-modal for full plan does not comply with the usage in dashboard."); 
        rogers_wireless_dashboard_page.closeDsModal();
        rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");        
        rogers_wireless_dashboard_page.scrollToBottomOfPage();;
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
    }

}
