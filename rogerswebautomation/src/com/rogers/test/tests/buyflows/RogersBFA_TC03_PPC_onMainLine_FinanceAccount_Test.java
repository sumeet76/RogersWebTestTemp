package com.rogers.test.tests.buyflows;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;

/**
 * TC03-Validate user able to perform Main line PPC on Existing Finance account
 * 
 * Launch qa.rogers.com and login using the credentials
 * Select the main line CTN for which the plan has to be changed and select change 
 * Select a Edge plan for main line and click continue
 * Select a Addon(optional) and Click continue
 * Click continue
 * Select the billing address and click OK
 * Click continue
 *  
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TC03_PPC_onMainLine_FinanceAccount_Test extends BaseTestClass {

	@Test
    public void performPPCOnMainline() {
		reporter.reportLogWithScreenshot("Home Page");
		rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(TestDataHandler.testCase03.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.testCase03.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        rogers_login_page.clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        reporter.hardAssert(rogers_account_overview_page.verifyAndClickWirelessCTN(TestDataHandler.testCase03.getCtn()), "Select CTN Passed", "Select CTN Failed");
        reporter.reportLogWithScreenshot("Wireless Dashboard Page");
        rogers_wireless_details_page.clickChangePlanButton();
        rogers_choose_plan_page.selectPlanCategory(TestDataHandler.testCase03.getNewPlanCategory());
        rogers_choose_plan_page.selectFirstAvailablePlan();
        rogers_choose_plan_page.verifyAndClickDowngradeFeeContinue();
        reporter.reportLogWithScreenshot("Choose Plan page");
        rogers_choose_plan_page.clkCheckout();
        rogers_order_review_page.clkTermsAgreementCheckbox();
        rogers_order_review_page.clkShieldAgreementCheckbox();
        rogers_order_review_page.selectEmailDigitalCopy(TestDataHandler.testCase03.getUsername());
        reporter.reportLogWithScreenshot("Order Review page");
        rogers_order_review_page.clkSubmitOrder();
        reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(rogers_order_confirmation_page.verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Order Confirmation page");
   }

	@BeforeTest @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.bfaConfig.getRogersURL(), TestDataHandler.bfaConfig.getBrowser(),TestDataHandler.bfaConfig.getLanguage(),strGroupName, method);
	}
    
    @AfterTest(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }
    
}