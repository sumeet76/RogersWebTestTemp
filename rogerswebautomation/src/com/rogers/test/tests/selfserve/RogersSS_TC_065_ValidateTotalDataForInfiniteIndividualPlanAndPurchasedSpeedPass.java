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

public class RogersSS_TC_065_ValidateTotalDataForInfiniteIndividualPlanAndPurchasedSpeedPass extends BaseTestClass {

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
	public void validateTotalDataForInfiniteIndividualPlan() {
		rogers_home_page.clkSignIn();
		String strUsername = TestDataHandler.tc6577.getUsername();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(strUsername);
		String strPassword = TestDataHandler.tc6577.getPassword();
		rogers_login_page.setPasswordIFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();

		if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
			reporter.reportLogWithScreenshot("Select an account.");
			rogers_account_overview_page.selectAccount(
					TestDataHandler.tc6577.getAccountDetails().getBan());
		}
		reporter.reportLogWithScreenshot("Account overview page.");
		rogers_account_overview_page.clkMenuUsageAndService();
		reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
		String strAccountNum = TestDataHandler.tc6577.getAccountDetails().getCtn();
		String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length() - 4);
		if (rogers_account_overview_page.isAccountShowInDropDown(strLast4DigitAccount)) {
			rogers_account_overview_page.clkDropDownAccount(strLast4DigitAccount);
		} else {
			rogers_account_overview_page.clkSubMenuWirelessUsage();
		}
		rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();

		reporter.softAssert(rogers_wireless_dashboard_page.verifyDataDelayMessage(),
				"Data delay by 12 hours banner is displayed", "Data delay by 12 hours banner is NOT displayed");
		reporter.hardAssert(rogers_wireless_dashboard_page.verifySpeedPassButtonIsDisplayed(),
				"Speed Pass button is displayed", "Speed Pass button is NOT displayed");
		reporter.reportLogWithScreenshot("Wireless dashboard page.");
		reporter.softAssert(rogers_manage_data_page.validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		int countOfExistSpeedPass = rogers_manage_data_page.getAllExistingSpeedPassCount();
		reporter.reportLogWithScreenshot("Speed passes");
		rogers_manage_data_page.clkBackOnManageDataUsagePage();
		rogers_wireless_dashboard_page.clkBtnSpeedPass();
		int totalAddedSpeedPass = common_business_flows.addSpeedPass();

		reporter.softAssert(rogers_manage_data_page.validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		reporter.reportLogWithScreenshot("Manage data page view after we click on view details");
		reporter.softAssert(
				rogers_manage_data_page.verifyAddedDataInDataDetails(totalAddedSpeedPass, countOfExistSpeedPass),
				"Added data section is verified in 'Data details' page,"
						+ " multiple speed passes of same size displayed individually.",
				"Added data section in 'Data details' page is not verified successfully.");
		reporter.softAssert(rogers_manage_data_page.verifyTotalDataInDataDetails(),
				"Total data section is verified in 'Data details' page.",
				"Total data section in 'Data details' page is not verified successfully.");
		rogers_manage_data_page.clkBackOnManageDataUsagePage();

	}
	
	// TODO


}
