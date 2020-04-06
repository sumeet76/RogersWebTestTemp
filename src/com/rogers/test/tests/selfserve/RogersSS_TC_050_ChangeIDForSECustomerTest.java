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

import utils.FormFiller;



public class RogersSS_TC_050_ChangeIDForSECustomerTest extends BaseTestClass {

	@Test
	public void changeIDForSECustomer() {
		String strFirstName = FormFiller.generateRandomName().toUpperCase();
		String strLastName = FormFiller.generateRandomName().toUpperCase();		
        rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc5074.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc5074.getPassword());
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		 if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
	        	reporter.reportLogWithScreenshot("Select an account.");
	            rogers_account_overview_page.selectAccount(TestDataHandler.tc5074.getAccountDetails().getBan());
	        }
        reporter.reportLogWithScreenshot("Account overview page.");        
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc5074.getAccountDetails().getCtn();
        String strLast4Dig = strAccountNum.substring(strAccountNum.length()-4);
        if (rogers_account_overview_page.isAccountShowInDropDown(strLast4Dig)) {
        	rogers_account_overview_page.clkDropDownAccount(strLast4Dig);
        } else {
        	rogers_account_overview_page.clkSubMenuWirelessUsage();
        }
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();

		rogers_wireless_dashboard_page.clickChangeMyCallerId();
		reporter.reportLogWithScreenshot("Click performed on Change caller id"); 
		
		if (rogers_change_my_caller_id_page.isExceedLimitOverlayPopup()) {
			reporter.reportLogWithScreenshot("Change caller id limit exceeded.");
			rogers_change_my_caller_id_page.clkBtnDoneInExceedLimitOverlay();
		} else {
			rogers_change_my_caller_id_page.setNewCallerIdFirstName(strFirstName);
			rogers_change_my_caller_id_page.setNewCallerIdLastName(strLastName);
			reporter.reportLogWithScreenshot("First name and Last name set"); 
			rogers_change_my_caller_id_page.clickContinue();
			reporter.reportLogWithScreenshot("Acknowledgement page"); 
			rogers_change_my_caller_id_page.clickSubmit();
			reporter.hardAssert(rogers_change_my_caller_id_page.verifyCallerIdChangeSuccessMsg(),
					"Caller ID update confirmation message displayed",
					"Successful Caller ID name update message NOT displayed");
			reporter.reportLogWithScreenshot("Caller id update confirmation"); 
			rogers_change_my_caller_id_page.clickDone();	
			
			//for CTN refresh go on overview and come back
			rogers_wireless_dashboard_page.clickOverview();
			reporter.reportLogWithScreenshot("Back on overview page"); 
			reporter.softAssert(rogers_account_overview_page.verifyWirelessCallerIdCTNBadgeName(strFirstName),
					"Caller ID First Name" + strFirstName + " is updated in CTN badge",
					"Caller ID First Name" + strFirstName + " is NOT updated in CTN badge");			
			rogers_account_overview_page.clkMenuUsageAndService();
	        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");	        
	        if (rogers_account_overview_page.isAccountShowInDropDown(strLast4Dig)) {
	        	rogers_account_overview_page.clkDropDownAccount(strLast4Dig);
	        } else {
	        	rogers_account_overview_page.clkSubMenuWirelessUsage();
	        }
	        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();	        	        
			reporter.softAssert(rogers_wireless_dashboard_page.verifyWirelessCallerIdUpdatedInSeCtnTab(strFirstName),
					"Caller ID First Name" + strFirstName + " is updated in SE CTN Tab",
					"Caller ID First Name" + strFirstName + " is NOT updated in SE CTN Tab");			
		}

	}

	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

}
