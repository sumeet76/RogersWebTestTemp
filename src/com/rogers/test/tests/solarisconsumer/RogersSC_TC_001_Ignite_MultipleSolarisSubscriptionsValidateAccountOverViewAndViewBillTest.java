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
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.solarisMultipleSubscriptions.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.solarisMultipleSubscriptions.getPassword());
 		reporter.reportLogWithScreenshot("Enter the account credentails");
 		getRogersLoginPage().clkSignInIFrame();
 		reporter.reportLogWithScreenshot("Skip popup");
 		getRogersLoginPage().clkSkipIFrame();
 		getRogersLoginPage().switchOutOfSignInIFrame();
 		Assert.assertTrue(getRogersAccountOverviewPage().isMoreThanOneBanPresentInThePopUp(), "More than one Ban is not displayed in the pop up");
 		reporter.reportLogWithScreenshot("Two subscriptions(Multiple Services)are shown up");
 		getRogersAccountOverviewPage().selectAccount(TestDataHandler.solarisMultipleSubscriptions.accountDetails.getBan());
		reporter.softAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Login Success","Login Failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		/*
		 * getRogersAccountOverviewPage().clickAccount();
		 * reporter.reportLogWithScreenshot("Account overlay is displayed");
		 * reporter.softAssert(getRogersAccountOverviewPage().isMoreThanOneBanPresent(),
		 * "More than one Ban is present",
		 * "More than one Ban not displayed in the Account Submenu"); reporter.
		 * reportLogWithScreenshot("Two subscriptions(Multiple Services)are shown up");
		 * getRogersAccountOverviewPage().selectAnAccountFromTheAccountDropDown();
		 * getRogersAccountOverviewPage().clickOverview();
		 */
		getRogersAccountOverviewPage().clickViewYourBill();
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

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
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


