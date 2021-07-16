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

public class RogersSS_TC_065_ValidateTotalDataForInfiniteIndividualPlanAndPurchasedSpeedPass extends BaseTestClass {

	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

	@Test(groups = {"AddDataFlow","WirelessDashboardSS","AddDataSpeedPass"})
	public void validateTotalDataForInfiniteIndividualPlan() throws InterruptedException {
		getRogersHomePage().clkSignIn();
		String strUsername = TestDataHandler.tc6577.getUsername();
		//getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(strUsername);
		String strPassword = TestDataHandler.tc6577.getPassword();
		getRogersLoginPage().setPasswordIFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed without error.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();

		if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
			reporter.reportLogWithScreenshot("Select an account.");
			getRogersAccountOverviewPage().selectAccount(
					TestDataHandler.tc6577.getAccountDetails().getBan());
		}
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), 
				"Login succeed, account overview page openned.", 
				"Account overview page didn't open successfully");
		reporter.reportLogWithScreenshot("Account overview page.");
		getRogersAccountOverviewPage().clkMenuUsageAndService();
		reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
		String strAccountNum = TestDataHandler.tc6577.getAccountDetails().getCtn();
		String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length() - 4);
		if (getRogersAccountOverviewPage().isAccountShowInDropDown(strLast4DigitAccount)) {
			getRogersAccountOverviewPage().clkDropDownAccount(strLast4DigitAccount);
		} else {
			getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
		}
		getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();

		reporter.hardAssert(getRogersWirelessDashboardPage().verifyDataDelayMessage(),
				"Data delay by 12 hours banner is displayed", "Data delay by 12 hours banner is NOT displayed");
		reporter.hardAssert(getRogersWirelessDashboardPage().verifySpeedPassButtonIsDisplayed(),
				"Speed Pass button is displayed", "Speed Pass button is NOT displayed");
		reporter.reportLogWithScreenshot("Wireless dashboard page.");
		reporter.hardAssert(getRogersManageDataPage().validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		int countOfExistSpeedPass = getRogersManageDataPage().getAllExistingSpeedPassCount();
		reporter.reportLogWithScreenshot("Speed passes");
		getRogersManageDataPage().clkBackOnManageDataUsagePage();
		
		
		int totalAddedSpeedPass = getCommonBusinessFlows().addSpeedPass();
		Thread.sleep(3000);
		reporter.hardAssert(getRogersManageDataPage().validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link",
				"'Data details' page is NOT displayed after click on view details link");
		reporter.reportLogWithScreenshot("Manage data page view after we click on view details");
		reporter.hardAssert(
				getRogersManageDataPage().verifyAddedDataInDataDetails(totalAddedSpeedPass, countOfExistSpeedPass),
				"Added data section is verified in 'Data details' page,"
						+ " multiple speed passes of same size displayed individually.",
				"Added data section in 'Data details' page is not verified successfully.");
		reporter.hardAssert(getRogersManageDataPage().verifyTotalDataInDataDetails(),
				"Total data section is verified in 'Data details' page.",
				"Total data section in 'Data details' page is not verified successfully.");
		getRogersManageDataPage().clkBackOnManageDataUsagePage();

	}
	



}
