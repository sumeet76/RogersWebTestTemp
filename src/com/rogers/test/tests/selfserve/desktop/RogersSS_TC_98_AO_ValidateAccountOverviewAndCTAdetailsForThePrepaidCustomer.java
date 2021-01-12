package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_98_AO_ValidateAccountOverviewAndCTAdetailsForThePrepaidCustomer extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"RegressionSS","AccountOverviewSS"})
    public void validateAccountOverviewAndCTAdetailsForThePrepaidCustomer() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc5398.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc5398.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc5398.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        //reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Passed", "Login Failed");
        
        
        reporter.hardAssert(getRogersAccountOverviewPage().isTopUpButtonDisplayed(),
        		"Top up button is displayed on AO page","Top up button not displayed on AO page");
        reporter.hardAssert(getRogersAccountOverviewPage().isCurrentAccountBalanceDisplayed(),"Current acount balance is displayed","Current acount balance is NOT displayed");
        reporter.hardAssert(getRogersAccountOverviewPage().isBalanceExpiresOnDisplayedOnAOPage(),"Balance expires on is displayed","Balance expires on is NOT displayed");
        reporter.hardAssert(getRogersAccountOverviewPage().isLnkUpdatePaymentMethodDisplayedOnAOPage(),"Link Update payment method is displayed","Link Update payment method is NOT displayed");
        reporter.hardAssert(getRogersAccountOverviewPage().isLnkViewCallTransactionHistoryDisplayedOnAOPage(),"Link View Call Transaction history is displayed","Link View Call Transaction history is NOT displayed");
        reporter.hardAssert(getRogersAccountOverviewPage().isBalanceExpiresOnDisplayedOnAOPage(),"Balance expires on is displayed","Balance expires on is not displayed");
        reporter.hardAssert(getRogersAccountOverviewPage().isCTNWidgetIsDisplayedOnAOPg(),"CTN widget is displayed","CTN widget is not displayed");
        
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("Account overview middle view");
        reporter.hardAssert(getRogersAccountOverviewPage().isAccountPreferencesSectionDisplayedAOPg(),"Account preference section is displayed","Account preference section is NOT displayed");
        reporter.hardAssert(getRogersAccountOverviewPage().isOtherServicesDisplayedOnAOPg(),"Other service is displayed","Other service is not displayed");
        getCommonBusinessFlows().scrollToTopOfWebPage();
        getRogersAccountOverviewPage().clkCTNWidget();
        reporter.reportLogWithScreenshot("Prepaid Dashboard view");
        
        reporter.hardAssert(getRogersWirelessDashboardPage().isPrepaidHeaderDisplayed(),"Prepaid header is displayed on Dashboard page","Prepaid header is NOT displayed on Dashboard page");
        reporter.hardAssert(getRogersWirelessDashboardPage().isPrepaidManageMyPlanAndDataAddOnheaderDisplayed(),"Manage my plan and data add on header is displayed","Manage my plan and data add on header is NOT displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().isPrepaidPlanDetailsSectionDisplayed(),"Plan details section is displayed","Plan details section is NOT displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().isPrepaidNextPaymentDateSectionDisplayed(),"Next payment date section is displayed","Next payment date section is NOT displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().isPrepaidTopUpNowButtonDisplayed(),"Top up now button is displayed","Top up now button is NOT displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().isPrepaidChangeMyPlanDisplayed(),"Prepaid Change my Plan is displayed","Prepaid Change my Plan is NOT displayed");
        
        reporter.hardAssert(getRogersWirelessDashboardPage().isPrepaidManageMyAddOnsDisplayed(),"Manage my add ons is displayed","Manage my add ons is NOT displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().isMyWirelessNumberSectionDisplayed(),"Wireless number section is displayed","Wireless number section is NOT displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().isPrepaidPinCodeDisplayed(),"Prepaid pin code is displayed","Prepaid pin code is NOT displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().isPrepaidChangeMyPinCodeDisplayed(),"Change my pin code is displayed","Change my pin code is NOT displayed");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("Dashboard Middle view");
        
        reporter.hardAssert(getRogersWirelessDashboardPage().isPrepaidStartOrTrackAPhoneRepairClaimDisplayed(),"Start or track a phone repair is displayed","Start or track a phone repair is NOT displayed");
          
        getCommonBusinessFlows().scrollToBottomOfWebPage();
        reporter.reportLogWithScreenshot("Dashboard Bottom view");
    }

  

}
