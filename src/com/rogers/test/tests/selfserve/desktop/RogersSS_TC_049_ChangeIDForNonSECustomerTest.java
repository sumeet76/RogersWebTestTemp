package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

import utils.FormFiller;


public class RogersSS_TC_049_ChangeIDForNonSECustomerTest extends BaseTestClass {

	@Test(groups = {"RegressionSS","WirelessDashboardSS"})
	public void changeIDForNonSECustomer() {
		String strFirstName = FormFiller.generateRandomName().toUpperCase();
		String strLastName = FormFiller.generateRandomName().toUpperCase();		
        rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc495271.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc495271.getPassword());
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		 if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
	        	reporter.reportLogWithScreenshot("Select an account.");
	            rogers_account_overview_page.selectAccount(TestDataHandler.tc495271.getAccountDetails().getBan());
	        }
        reporter.reportLogWithScreenshot("Account overview page.");        
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc495271.getAccountDetails().getCtn();        
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
			rogers_wireless_dashboard_page.scrollToTopOfDasboardPage();
			rogers_wireless_dashboard_page.clickOverview();
			reporter.reportLogWithScreenshot("Back on overview page"); 
			reporter.hardAssert(rogers_account_overview_page.verifyWirelessCallerIdCTNBadgeName(strFirstName),
					"Caller ID First Name" + strFirstName + " is updated in CTN badge",
					"Caller ID First Name" + strFirstName + " is NOT updated in CTN badge");
			rogers_account_overview_page.clkMenuUsageAndService();
	        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked");
			reporter.hardAssert(rogers_account_overview_page.verifyWirelessCallerIdUpdatedInDropDownToSelectWirelessUsage(strFirstName),
					"Caller ID First Name" + strFirstName + " is updated in Dropdown to select usage and services",
					"Caller ID First Name" + strFirstName + " is NOT updated in Dropdown to select usage and services");
		}

	}

	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
