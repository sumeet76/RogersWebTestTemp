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



public class RogersSS_TC_98_ValidateAccountOverviewAndCTAdetailsForThePrepaidCustomer extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validateAccountOverviewAndCTAdetailsForThePrepaidCustomer() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(TestDataHandler.tc98.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.tc98.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        rogers_login_page.clkSignInIFrame();
        reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();

        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	rogers_account_overview_page.selectAccount(TestDataHandler.tc98.getAccountDetails().getBan());       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        //reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Passed", "Login Failed");
        
        
        reporter.hardAssert(rogers_account_overview_page.isTopUpButtonDisplayed(),
        		"Top up button is displayed on AO page","Top up button not displayed on AO page");
        reporter.hardAssert(rogers_account_overview_page.isCurrentAccountBalanceDisplayed(),"Current acount balance is displayed","Current acount balance is NOT displayed");
        reporter.hardAssert(rogers_account_overview_page.isBalanceExpiresOnDisplayedOnAOPage(),"Balance expires on is displayed","Balance expires on is NOT displayed");
        reporter.hardAssert(rogers_account_overview_page.isLnkUpdatePaymentMethodDisplayedOnAOPage(),"Link Update payment method is displayed","Link Update payment method is NOT displayed");
        reporter.hardAssert(rogers_account_overview_page.isLnkViewCallTransactionHistoryDisplayedOnAOPage(),"Link View Call Transaction history is displayed","Link View Call Transaction history is NOT displayed");
        reporter.hardAssert(rogers_account_overview_page.isBalanceExpiresOnDisplayedOnAOPage(),"Balance expires on is displayed","Balance expires on is not displayed");                                
        reporter.hardAssert(rogers_account_overview_page.isCTNWidgetIsDisplayedOnAOPg(),"CTN widget is displayed","CTN widget is not displayed");
        
        common_business_flows.scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("Account overview middle view");
        reporter.hardAssert(rogers_account_overview_page.isAccountPreferencesSectionDisplayedAOPg(),"Account preference section is displayed","Account preference section is NOT displayed");
        reporter.hardAssert(rogers_account_overview_page.isOtherServicesDisplayedOnAOPg(),"Other service is displayed","Other service is not displayed");
        common_business_flows.scrollToTopOfWebPage();
        rogers_account_overview_page.clkCTNWidget();
        reporter.reportLogWithScreenshot("Prepaid Dashboard view");
        
        reporter.hardAssert(rogers_wireless_dashboard_page.isPrepaidHeaderDisplayed(),"Prepaid header is displayed on Dashboard page","Prepaid header is NOT displayed on Dashboard page");
        reporter.hardAssert(rogers_wireless_dashboard_page.isPrepaidManageMyPlanAndDataAddOnheaderDisplayed(),"Manage my plan and data add on header is displayed","Manage my plan and data add on header is NOT displayed");
        reporter.hardAssert(rogers_wireless_dashboard_page.isPrepaidPlanDetailsSectionDisplayed(),"Plan details section is displayed","Plan details section is NOT displayed");
        reporter.hardAssert(rogers_wireless_dashboard_page.isPrepaidNextPaymentDateSectionDisplayed(),"Next payment date section is displayed","Next payment date section is NOT displayed");
        reporter.hardAssert(rogers_wireless_dashboard_page.isPrepaidTopUpNowButtonDisplayed(),"Top up now button is displayed","Top up now button is NOT displayed");
        reporter.hardAssert(rogers_wireless_dashboard_page.isPrepaidChangeMyPlanDisplayed(),"Prepaid Change my Plan is displayed","Prepaid Change my Plan is NOT displayed");
        
        reporter.hardAssert(rogers_wireless_dashboard_page.isPrepaidManageMyAddOnsDisplayed(),"Manage my add ons is displayed","Manage my add ons is NOT displayed");
        reporter.hardAssert(rogers_wireless_dashboard_page.isMyWirelessNumberSectionDisplayed(),"Wireless number section is displayed","Wireless number section is NOT displayed");
        reporter.hardAssert(rogers_wireless_dashboard_page.isPrepaidPinCodeDisplayed(),"Prepaid pin code is displayed","Prepaid pin code is NOT displayed");
        reporter.hardAssert(rogers_wireless_dashboard_page.isPrepaidChangeMyPinCodeDisplayed(),"Change my pin code is displayed","Change my pin code is NOT displayed");
        common_business_flows.scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("Dashboard Middle view");
        
        reporter.hardAssert(rogers_wireless_dashboard_page.isPrepaidStartOrTrackAPhoneRepairClaimDisplayed(),"Start or track a phone repair is displayed","Start or track a phone repair is NOT displayed");
          
        common_business_flows.scrollToBottomOfWebPage();
        reporter.reportLogWithScreenshot("Dashboard Bottom view");
    }

  

}
