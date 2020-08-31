package com.rogers.test.tests.solarisconsumer;

import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;    
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;


/**
 * This class contains the test method to validate multiple Solaris consumer subcription and verify account bill   
 * 
 * @author Saurav.Goyal
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Verify two Subscriptions
 *4. Validate account overview Page
 *4. Click account and verify multiple accounts
 *5. and Verify account bill
 **/


public class RogersSC_TC_001_Ignite_MultipleSolarisSubscriptionsValidateAccountOverViewAndViewBillTest extends BaseTestClass {

	@Test
    public void validateMultipleServicesAndViewBill() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.solarisMultipleSubscriptions.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.solarisMultipleSubscriptions.getPassword());
 		reporter.reportLogWithScreenshot("Enter the account credentails");
 		rogers_login_page.clkSignInIFrame();
 		reporter.reportLogWithScreenshot("Skip popup");
 		rogers_login_page.clkSkipIFrame();
 		rogers_login_page.switchOutOfSignInIFrame();
 		Assert.assertTrue(rogers_account_overview_page.isMoreThanOneBanPresentInThePopUp(), "More than one Ban is not displayed in the pop up");
 		reporter.reportLogWithScreenshot("Two subscriptions(Multiple Services)are shown up");
 		rogers_account_overview_page.selectAccount(TestDataHandler.solarisMultipleSubscriptions.accountDetails.getBan());
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		/*
		 * rogers_account_overview_page.clickAccount();
		 * reporter.reportLogWithScreenshot("Account overlay is displayed");
		 * reporter.softAssert(rogers_account_overview_page.isMoreThanOneBanPresent(),
		 * "More than one Ban is present",
		 * "More than one Ban not displayed in the Account Submenu"); reporter.
		 * reportLogWithScreenshot("Two subscriptions(Multiple Services)are shown up");
		 * rogers_account_overview_page.selectAnAccountFromTheAccountDropDown();
		 * rogers_account_overview_page.clickOverview();
		 */
		rogers_account_overview_page.clickViewYourBill();
		reporter.reportLogWithScreenshot("Billing and payment page.");
		if (!rogersBillingPage.verifyIfAccountHasNoBill()) {
			rogersBillingPage.switchToBillViewIframe();
	        reporter.hardAssert(rogersBillingPage.verifyBillingAndPaymentPageLoadIframe(),
	        						"Billing page loaded.",
	        						"Billing page load Error. Refer screenshot");
			reporter.reportLogWithScreenshot("View bill page.");
	        reporter.hardAssert(rogersBillingPage.verifyYourBillDisplayedIFrame(), 
	        						"Bill viewed successfully.",
	        						"View Your Bill Error. Refer screenshot");
	        rogersBillingPage.switchOutOfBillViewIframe();
	        rogersBillingPage.scrollToMiddlePage();
			reporter.reportLogWithScreenshot("Middle of view bill page.");
		} else {
			rogersBillingPage.scrollToMiddlePage();
			reporter.reportLogWithScreenshot("There has no bill yet for the account.");
		} 
    }

    @BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,strGroupName, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


