package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_01_ValidateDeviceSectionAndDeviceDetailsModalForCXWithFinanceNotPaidOFF_ON extends BaseTestClass {

	private String strAltEmail;

	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
	 
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	@Test(groups = {"RegressionSS","WirelessDashboardSS","CAMShiled"})
	public void validateDeviceSectionAndDeviceDetailsModalForCXWithFinanceNotPaidOFF_ON_chrome_EN() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc01FinanceNotPaidOff_ON.getUsername();
    	String strPassword = TestDataHandler.tc01FinanceNotPaidOff_ON.getPassword();
    	String strBan = TestDataHandler.tc01FinanceNotPaidOff_ON.getAccountDetails().getBan();
    	String strEmail = TestDataHandler.tc01FinanceNotPaidOff_ON.getAccountDetails().getContactemail();
    	strAltEmail = FormFiller.generateEmail();
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(strUsername);
		getRogersLoginPage().setPasswordIFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
        

		reporter.reportLogWithScreenshot("Account overveiew page");
		String strAccountNum = TestDataHandler.tc01FinanceNotPaidOff_ON.getAccountDetails().getCtn();
		String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length()-4);
		if (getRogersAccountOverviewPage().checkIfAccountIsShowInDropDown(strLast4DigitAccount)) {
			getRogersAccountOverviewPage().clkDropDownAccount(strLast4DigitAccount);
		} else {
			getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
		}

		reporter.reportLogWithScreenshot("Wireless Usage Details");

		reporter.hardAssert(getRogersWirelessDashboardPage().isMonthlyFinancingAmountDisplayed(),
				"Monthly Financing Amount is visible",
				"Monthly Financing Amount is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isRemainingFinancingBalanceDisplayed(),
				"Remaining Financing Balance is visible",
				"Remaining Financing Balance is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isFinancingAgreementStartDateDisplayed(),
				"Financing Agreement Start Date is visible",
				"Financing Agreement Start Date is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isFinancingAgreementEndDateDisplayed(),
				"Financing Agreement End Date is visible",
				"Financing Agreement End Date is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isFinancingAgreementEndDateDisplayed(),
				"Financing Agreement End Date is visible",
				"Financing Agreement End Date is not visible");


		reporter.hardAssert(getRogersWirelessDashboardPage().isViewFinancingDetailsButtonDisplayed(),
				"View Financing Details Button is visible",
				"View Financing Details Button is not visible");

		getRogersWirelessDashboardPage().clkViewFinancingDetails();

		reporter.reportLogWithScreenshot("Device Details Modal.");

		reporter.hardAssert(getRogersWirelessDashboardPage().isActivationDateDisplayed(),
				"Activation Date is visible",
				"Activation Date is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isFinancingEndDateDisplayed(),
				"Financing End Date is visible",
				"Financing End Date is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isTotalRemainingDeviceFinancingBalanceDisplayed(),
				"Total Remaining Device Financing Balance is visible",
				"Total Remaining Device Financing Balance is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isRemainingDeviceFinancingBalanceDisplayed(),
				"Remaining Financing Balance is visible",
				"Remaining Financing Balance is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isRemainingFinancedTaxesDisplayed(),
				"Remaining Financed Taxes is visible",
				"Remaining Financed Taxes is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isMonthlyFinancingAmountTotalDisplayed(),
				"Monthly Financing Total is visible",
				"Monthly Financing Total is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isMonthlyFinancingAmountBaseDisplayed(),
				"Monthly Financing Amount Base is visible",
				"Monthly Financing Amount Base is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isMonthlyFinancingTaxesDisplayed(),
				"Monthly Financing Tax is visible",
				"Monthly Financing Tax is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isMonthsRemainingDisplayed(),
				"Months Remaining is visible",
				"Months Remaining is not visible");


		getRogersWirelessDashboardPage().clkDeviceFinancingDetailsButton();

		reporter.reportLogWithScreenshot("Legal Copy For Financing Program");

		reporter.hardAssert(getRogersWirelessDashboardPage().isLegalCopyForFinancingProgramDisplayed(),
				"Legal Copy For Financing Program is visible",
				"Legal Copy For Financing Program is not visible");

	}

}
