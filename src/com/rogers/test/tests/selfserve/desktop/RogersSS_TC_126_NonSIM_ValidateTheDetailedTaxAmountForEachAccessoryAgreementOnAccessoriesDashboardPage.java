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


public class RogersSS_TC_126_NonSIM_ValidateTheDetailedTaxAmountForEachAccessoryAgreementOnAccessoriesDashboardPage extends BaseTestClass {

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

	@Test(groups = {"CAMShiled"})
	public void validateTheDetailedTaxAmountForEachAccessoryAgreementOnAccessoriesDashboardPage() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc126.getUsername();
    	String strPassword = TestDataHandler.tc126.getPassword();
    	String strBan = TestDataHandler.tc126.getAccountDetails().getBan();
    	String strEmail = TestDataHandler.tc126.getAccountDetails().getContactemail();
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

		//4. The accessories entry point widget should be displayed for the eligible CTN on AO page as per copy.
		getCommonBusinessFlows().scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("CTN and accessories view");
		reporter.hardAssert(getRogersAccountOverviewPage().verifyFinancedAccessoriesIsDisplayed(),
				"Financed Accessories Is visible",
				"Financed Accessories is not visible");
		getCommonBusinessFlows().scrollToTopOfWebPage();
		getRogersAccountOverviewPage().clkFinancedAccessories();

		//5. The user will be presented with the Non-Sim Accessory Dashboard
		// (Accessories Images and description as expected) with the tax breakdown of the prices
		// and CTA button to see more details.
		reporter.softAssert(getRogersFinanceAccessoriesPagePage().isAccessoryPageOpen(),
				"the Non-Sim Accessory Dashboard is diaplayed",
				"the Non-Sim Accessory Dashboard is not visible");


		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateTotalMonthlyFinancingPayment(),
				"Total Monthly Finance Payment validated",
				"Total Monthly Finance Payment is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateMonthlyFinancingPayment(),
				"Monthly Finance Payment validated",
				"Monthly Finance Payment is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateMonthlyFinancedTaxes(),
				"Monthly Finance Taxes Payment validated",
				"Monthly Finance Taxes Payment is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateTotalRemainingFinancingBalance(),
				"Total Monthly Finance Balance validated",
				"Total Monthly Finance Balance is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateRemainingFinancingBalance(),
				"Remaining Financing Balance validated",
				"Remaining Financing Balance is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateRemainingFinancedTaxes(),
				"Remaining Financed Taxes validated",
				"Remaining Financed Taxes is NOT validated");

		//Accessories:
		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateFinancingEnding(),
				"Financing Ending date is validated",
				"Financing Ending date  is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateStarted(),
				"Started date is validated",
				"Started date is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateAgreementID(),
				"Agreement ID is  validated",
				"Agreement ID is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateFinancingTerm(),
				"Financing Term period validated",
				"Financing Term period is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateMonthlyFinancingPaymentOfAnAgreement(),
				"Monthly Financing Payment Of An Agreement is validated",
				"Monthly Financing Payment Of An Agreement is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateBalanceRemaining(),
				"Balance remaining is validated",
				"Balance remaining is NOT validated");

		getRogersFinanceAccessoriesPagePage().clkBtnSeeMoreDetails();

		reporter.reportLogWithScreenshot("Accessories details modal view");


		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateYourFinancingBalanceWillBeZeroOn(),
				"You fincance balance will be zero on is validated on details modal",
				"You fincance balance will be zero on is NOT validated on details modal");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateAccessoryPurchaseDate(),
				"Accessory purchase date is validated",
				"Accessory purchase date is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateAgreementIDOndetailsModal(),
				"AgreementID On details Modal is validated",
				"AgreementID On details Modal is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateFinancingTermOndetailsModal(),
				"Financing Term On details Modal is validated",
				"Financing Term On details Modal is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateTotalMonthlyFinancingPaymentOndetailsModal(),
				"Total Monthly Financing Payment On details Modal is validated",
				"Total Monthly Financing Payment On details Modal is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateMonthlyFinancingPaymentOndetailsModal(),
				"Monthly Financing Payment On details Modal is validated",
				"Monthly Financing Payment On details Modal is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateMonthlyFinancedTaxesOndetailsModal(),
				"Monthly Financed Taxes On details Modal is validated",
				"Monthly Financed Taxes On details Modal is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateTotalRemainingFinancingBalanceOndetailsModal(),
				"Total Remaining Financing Balance On details Modal is validated",
				"Total Remaining Financing Balance On details Modal is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateRemainingFinancingBalanceOndetailsModal(),
				"Remaining Financing Balance On details Modal is validated",
				"Remaining Financing Balance On details Modal is NOT validated");

		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateRemainingFinancedTaxesOndetailsModal(),
				"Remaining Financed Taxes On details Modal is validated",
				"Remaining Financed Taxes On details Modal is NOT validated");

		getRogersFinanceAccessoriesPagePage().clickCLoseModal();

		getCommonBusinessFlows().scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Accessories details view");
		reporter.softAssert(getRogersFinanceAccessoriesPagePage().validateAccessoryContentAndImageDisplayedCorrectly(),
				"Accessory Content And Image Displayed Correctly",
				"Accessory Content And Image needs investigation");



		/*
		6. The user will be presented with a Modal that displays following Information about my tax breakdown along with other info
		Header with last date of payment - 'Votre solde de financement sera de 0 $ le : [DATE]'
		Start Date of Accessories Contract
		Agreement Number
		Total Financing Term
		Monthly Instalment Amount
		Monthly Finance Balance (PreTax)
		Monthly Finance Tax (TaxOn)
		Total Remaining Balance for Agreement
		Remaning Finance Balance (Pre Tax)
		Tax on Remaining Finance Balance (Tax On)
		7. The modal should get disappear and the user should be displayed with Non SIM Dashboard
		8. Financial info is verified against FE using V21 successfully.
		 */


	}

}
