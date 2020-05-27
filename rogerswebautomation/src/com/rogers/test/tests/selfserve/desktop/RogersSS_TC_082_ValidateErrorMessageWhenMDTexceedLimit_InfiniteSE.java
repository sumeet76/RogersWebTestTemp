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




public class RogersSS_TC_082_ValidateErrorMessageWhenMDTexceedLimit_InfiniteSE extends BaseTestClass {	
   	
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
    public void validateErrorMessageWhenExceedLimitForInfiniteSEPlan() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc82.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc82.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc82.getAccountDetails().getBan());
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
		reporter.softAssert(rogers_manage_data_page.validateViewDetailsLink(), 
			"'Data details' page is displayed after click on view details link", 
			"'Data details' page is NOT displayed after click on view details link");  
		int countOfExistSpeedPass = rogers_manage_data_page.getAllExistingSpeedPassCount();		
		reporter.reportLogWithScreenshot("Manage data page.");		
		rogers_manage_data_page.clkBackOnManageDataUsagePage();	
		//Add speed pass to reach limit 10
		if (countOfExistSpeedPass < 10) {
			for (int counter = 0; counter + countOfExistSpeedPass < 10; counter++) {
				common_business_flows.addSpeedPass();	
			}
		}
		rogers_wireless_dashboard_page.clkBtnSpeedPass();
		reporter.softAssert(rogers_speed_pass_page.verifyCannotAddSpeedPassHeaderIsDisplayed(), 
				"Cannot Add Speed Pass error message is displayed", 
				"Cannot Add Speed Pass error message is not displayed");  

		reporter.reportLogWithScreenshot("Error message");


    }

}
