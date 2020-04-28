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
 * TC08-Validate user able to perform PPC on Additional line  - Existing Finance Account
 * 
 * Launch qa.rogers.com and login using the credentials
 * Select the additional line CTN for which the plan has to be changed and select change 
 * Select a Edge Infinite plan for main and 2nd line > continue
 * Select a Addon(optional) and Click continue
 * Click continue
 * Select the billing address and click OK
 * Click continue
 * Enter the payment details and click "Submit order"
 * 
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TC08_PPC_onAdditionalLine_FinanceAccount_Test extends BaseTestClass {

	@Test
    public void performPPCOnAdditionalLine() {
		reporter.reportLogWithScreenshot("Home Page");
		rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(TestDataHandler.testCase08.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.testCase08.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        rogers_login_page.clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        reporter.hardAssert(rogers_account_overview_page.verifyAndClickWirelessCTN(TestDataHandler.testCase08.getCtn()), "Select Subscriber Passed", "Select Subscriber Failed");
        reporter.reportLogWithScreenshot("Wireless Dashboard page");
        rogers_wireless_details_page.clickChangePlanButton();
        rogers_change_plan_page.clkEdit(TestDataHandler.testCase08.getCtn());
        rogers_change_plan_page.clkChangeMainLine();
        rogers_choose_plan_page.selectFirstAvailablePlan();
        rogers_choose_plan_page.selectAdditionalLine(TestDataHandler.testCase08.getCtn());
        rogers_choose_plan_page.selectPlanCategory(TestDataHandler.testCase08.getNewPlanCategory());
        rogers_choose_plan_page.selectFirstAvailablePlan();
        rogers_choose_plan_page.verifyAndClickDowngradeFeeContinue();
        reporter.reportLogWithScreenshot("Choose Plan page");
        rogers_choose_plan_page.clkContinue();
        reporter.reportLogWithScreenshot("Choose Addons page");
        rogers_choose_addons_page.clkCheckout();
        rogers_order_review_page.clkShieldAgreementCheckbox();
        rogers_order_review_page.clkTermsAgreementCheckbox();
        rogers_order_review_page.selectEmailDigitalCopy(TestDataHandler.testCase08.getUsername());
        reporter.reportLogWithScreenshot("Order Review page");
        rogers_order_review_page.clkSubmitOrder();
        reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(rogers_order_confirmation_page.verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Order Confirmation page");
   }

	@BeforeTest @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.bfaConfig.getBrowser(), TestDataHandler.bfaConfig.getBrowser(),TestDataHandler.bfaConfig.getLanguage(),strGroupName, method);
	}

    @AfterTest(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }
    
}