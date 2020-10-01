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

public class RogersSS_TC_100_Samurai_ValidateUsageDashboard_InfiniteNSE_SOHOIDVCustomer extends BaseTestClass {

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
	public void validateUsageDashboardOfInfiniteNSESohoIDVCustomer() throws InterruptedException {
		rogers_home_page.clkSignIn();
		String strUsername = TestDataHandler.tc100.getUsername();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(strUsername);
		String strPassword = TestDataHandler.tc100.getPassword();
		rogers_login_page.setPasswordIFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login proceed without error.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();

		if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
			reporter.reportLogWithScreenshot("Select an account.");
			rogers_account_overview_page.selectAccount(
					TestDataHandler.tc100.getAccountDetails().getBan());
		}
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), 
				"Login succeed, account overview page openned.", 
				"Account overview page didn't open successfully");
		reporter.reportLogWithScreenshot("Account overview page.");
		rogers_account_overview_page.clkMenuUsageAndService();
		reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
		String strAccountNum = TestDataHandler.tc100.getAccountDetails().getCtn();
		String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length() - 4);
		if (rogers_account_overview_page.isAccountShowInDropDown(strLast4DigitAccount)) {
			rogers_account_overview_page.clkDropDownAccount(strLast4DigitAccount);
		} else {
			rogers_account_overview_page.clkSubMenuWirelessUsage();
		}
		rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();

		reporter.hardAssert(rogers_wireless_dashboard_page.verifyDataDelayMessage(),
				"Data delay by 12 hours banner is displayed", "Data delay by 12 hours banner is NOT displayed");
		reporter.hardAssert(rogers_wireless_dashboard_page.verifySpeedPassButtonIsDisplayed(),
				"Speed Pass button is displayed", "Speed Pass button is NOT displayed");
		reporter.reportLogWithScreenshot("Wireless dashboard page.");
		rogers_wireless_dashboard_page.clkBtnSpeedPass();
		reporter.hardAssert(rogers_speed_pass_page.verifySpeedPassPopupIsDisplayed(), 
				"Add speed pass overlay is displayed.", 
				"Add speed pass overlay is not displayed correctly.");
		reporter.reportLogWithScreenshot("Speed passes overlay");
		rogers_speed_pass_page.clkBtnCloseInSpeedPassPopup();
		reporter.hardAssert(rogers_manage_data_page.validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");

		reporter.reportLogWithScreenshot("Manage data page.");
		rogers_manage_data_page.clkBackOnManageDataUsagePage();
		


	}
	



}
