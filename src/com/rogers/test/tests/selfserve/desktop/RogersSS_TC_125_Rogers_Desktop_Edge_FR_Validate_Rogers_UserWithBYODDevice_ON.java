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


public class RogersSS_TC_125_Rogers_Desktop_Edge_FR_Validate_Rogers_UserWithBYODDevice_ON extends BaseTestClass {

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
	
	@Test(groups = {"CAMShiled","RegressionSS"})
	public void Validate_Rogers_UserWithBYODDevice_ON() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc125.getUsername();
    	String strPassword = TestDataHandler.tc125.getPassword();
    	String strBan = TestDataHandler.tc125.getAccountDetails().getBan();
    	String strEmail = TestDataHandler.tc125.getAccountDetails().getContactemail();
    	strAltEmail = FormFiller.generateEmail();
		//getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(strUsername);
		getRogersLoginPage().setPasswordIFrame(strPassword);
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
        

		reporter.reportLogWithScreenshot("Account overveiew page");
		String strAccountNum = TestDataHandler.tc125.getAccountDetails().getCtn();
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

		reporter.hardAssert(getRogersWirelessDashboardPage().verifySeeOfferOnNewPhonesURL(),
				"Navigates to the correct link",
				"Does not navigate to the correct link - check link");


		reporter.reportLogWithScreenshot("See Offers on new phones Page");



	}

}
