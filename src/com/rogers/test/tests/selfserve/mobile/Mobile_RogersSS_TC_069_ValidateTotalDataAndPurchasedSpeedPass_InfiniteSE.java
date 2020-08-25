package com.rogers.test.tests.selfserve.mobile;

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




public class Mobile_RogersSS_TC_069_ValidateTotalDataAndPurchasedSpeedPass_InfiniteSE extends BaseTestClass {	
   	
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
    public void validateTotalDataForInfiniteSEIndividualPlan() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc6269.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc6269.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc6269.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
    	rogers_account_overview_page.clkSubMenuWirelessUsage();

        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
         
        //  - Added Data: should be included all Speed passes added for current bill cycle
        //  - Added Data: multiple speed passes of same size should be displayed individually (not summed up)
        reporter.hardAssert(rogers_wireless_dashboard_page.verifySpeedPassButtonIsDisplayed(), 
				"Speed Pass button is displayed", 
				"Speed Pass button is NOT displayed");
		reporter.reportLogWithScreenshot("Wireless dashboard page."); 
		reporter.hardAssert(rogers_manage_data_page.validateViewDetailsLink(), 
			"'Data details' page is displayed after click on view details link", 
			"'Data details' page is NOT displayed after click on view details link");  
	    //- Plan data: should be displayed (shared data across all lines)
		reporter.hardAssert(rogers_manage_data_page.verifyPlanDataIsDisplayed(), 
				"Plan data is displayed", 
				"Plan data is NOT displayed");
		int totalSharedDataDisplayedInPlanDataSection = rogers_manage_data_page.getTotalPlanData();
		int countOfExistSpeedPass = rogers_manage_data_page.getAllExistingSpeedPassCount();		
		reporter.reportLogWithScreenshot("Speed passes");
		
		rogers_manage_data_page.clkBackOnManageDataUsagePage();	
		
		int totalAddedSpeedPass = common_business_flows.addSpeedPass();	

		reporter.hardAssert(rogers_manage_data_page.validateViewDetailsLink(), 
				"'Data details' page is displayed after click on view details link", 
				"'Data details' page is NOT displayed after click on view details link"); 
		reporter.reportLogWithScreenshot("Manage data page view after we click on view details"); 
		reporter.hardAssert(rogers_manage_data_page.verifyAddedDataInDataDetails(totalAddedSpeedPass,countOfExistSpeedPass), 
						"Added data section is verified in 'Data details' page,"
						+ " multiple speed passes of same size displayed individually.", 
						"Added data section in 'Data details' page is not verified successfully.");  
		int countOfExistSpeedPassTotalGB = rogers_manage_data_page.getAllExistingSpeedPassTotalGB();	
		rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
		reporter.reportLogWithScreenshot("Total data view");
		reporter.hardAssert(rogers_manage_data_page.verifyTotalDataInDataDetailsWithMaxSpeedAndTotalOfSpeedPasses(countOfExistSpeedPassTotalGB,totalSharedDataDisplayedInPlanDataSection), 
						"Total Data: displays data plan on Max speed AND total added speed passes separately ", 
						"Total Data: NOT displays data plan on Max speed AND total added speed passes separately ");	

    }

}
