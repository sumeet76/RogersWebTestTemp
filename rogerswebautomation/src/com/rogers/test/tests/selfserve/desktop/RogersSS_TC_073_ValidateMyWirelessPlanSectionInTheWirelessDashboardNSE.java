package com.rogers.test.tests.selfserve.desktop;

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



public class RogersSS_TC_073_ValidateMyWirelessPlanSectionInTheWirelessDashboardNSE extends BaseTestClass {	
    
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
    public void validateMyWirelessPlanSectionInTheWirelessDashboardNSE() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc727375.getUsername();
    	String strPassword = TestDataHandler.tc727375.getPassword();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc727375.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc727375.getAccountDetails().getCtn();
        if (rogers_account_overview_page.isAccountShowInDropDown(strAccountNum.substring(strAccountNum.length()-4))) {
            rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        } else {
        	rogers_account_overview_page.clkSubMenuWirelessUsage();
        }
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
        rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");        
	    reporter.softAssert(rogers_wireless_dashboard_page.verifyPlanNameIsDisplayed(),
	    		"Plan name is displayed",
	    		"Plan name is not displayed");	    
	    reporter.softAssert(rogers_wireless_dashboard_page.verifyMonthlyServiceFeeIsDisplayed(),
	    		"Monthly service fee is displayed in the Plan section",
	    		"Monthly service fee is not displayed in the Plan section");
	    reporter.softAssert(rogers_wireless_dashboard_page.verifyButtonChangePlanIsDisplayed(),
	    		"Button Change plan is displayed in the plan section",
	    		"Button Change plan is not displayed");
	    reporter.softAssert(rogers_wireless_dashboard_page.verifyIncludedSectionIsDisplayed(),
	    		"Included section is displayed",
	    		"included section is not displayed");
	    reporter.softAssert(rogers_wireless_dashboard_page.verifTitleMyWirelessPlanIsDisplayed(),
	    		"My Wireless plan title is displayed",
	    		"My Wireless plan title is not displayed");
	    reporter.softAssert(rogers_wireless_dashboard_page.verifyMyPlansDetailsIsDisplayedAtTheBottomOfMyPlan(),
	    		"My Plan link details is displayed at the bottom",
	    		"My Plan link details is not displayed at the bottom");
	    rogers_wireless_dashboard_page.clkMyPlanDetailsLink();	    
	    reporter.softAssert(rogers_wireless_dashboard_page.verifyMyPlanDetailsOverlayIsDisplayed(),
	    "My Plan details overlay is displayed",
	    "My Plan details overlay is not displayed");
	    reporter.reportLogWithScreenshot("My Plan details overlay");   
	    rogers_wireless_dashboard_page.closeMyPlanDetailsOverlay();
	    
    }

}
