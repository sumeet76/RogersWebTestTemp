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

	@Test(groups = {"SanitySS","ProfileAndSettingsSS","CAMShiled"})
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
		reporter.hardAssert(getRogersAccountOverviewPage().verifyFinancedAccessoriesIsDisplayed(),
				"Financed Accessories Is visible",
				"Financed Accessories is not visible");

		getRogersAccountOverviewPage().clkFinancedAccessories();

		//5. The user will be presented with the Non-Sim Accessory Dashboard
		// (Accessories Images and description as expected) with the tax breakdown of the prices
		// and CTA button to see more details.

		reporter.hardAssert(getRogersAccountOverviewPage().verifyFinancedAccessoriesIsDisplayed(),
				"the Non-Sim Accessory Dashboard is diaplayed",
				"the Non-Sim Accessory Dashboard is not visible");

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


		String strAccountNum = TestDataHandler.tc01FinanceNotPaidOff_ON.getAccountDetails().getCtn();
		String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length()-4);
		if (getRogersAccountOverviewPage().checkIfAccountIsShowInDropDown(strLast4DigitAccount)) {
			getRogersAccountOverviewPage().clkDropDownAccount(strLast4DigitAccount);
		} else {
			getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
		}

		reporter.reportLogWithScreenshot("Wireless Usage Details");

		reporter.hardAssert(getRogersWirelessDashboardPage().isBroughtYourOwnPhoneVisible(),
				"You brought your own phone with this plan. is visible",
				"You brought your own phone with this plan. is not visible");

		reporter.hardAssert(getRogersWirelessDashboardPage().isSeeOffersOnNewPhonesDisplayed(),
				"See Offers On New Phones is visible",
				"See Offers On New Phones is not visible");

		getRogersWirelessDashboardPage().clkSeeOffersOnNewPhones();

		reporter.reportLogWithScreenshot("See Offers on new phones");



	}

}
