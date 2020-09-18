package com.rogers.test.tests.buyflows;

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
public class RogersBFA_TC09_PPC_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","SanityBFA","PPCBFA"})
    public void ppcFlowTest() {
		reporter.hardAssert(rogers_home_page.verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
		reporter.reportLogWithScreenshot("Home Page");
		rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(TestDataHandler.testCase9.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.testCase9.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        rogers_login_page.clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        reporter.hardAssert(rogers_account_overview_page.verifyAndClickWirelessCTN(TestDataHandler.testCase9.getCtn()), "Select CTN Passed", "Select CTN Failed");
        rogers_wireless_details_page.verifyWirelessPageLoad();
        reporter.reportLogWithScreenshot("Wireless Dashboard Page");
        rogers_wireless_details_page.clickChangePlanButton();
        rogers_choose_plan_page.clkMakeChangesToExistingPlan();
        reporter.reportLogWithScreenshot("Modal window appeared for change your plan");
        rogers_choose_plan_page.clkButtonModalContinue();
        reporter.reportLogWithScreenshot("Choose Plan page");
        rogers_choose_plan_page.selectPlanCategory(TestDataHandler.testCase9.getNewPlanCategory());
        rogers_choose_plan_page.selectPlanType(TestDataHandler.testCase9.getNewPlanType());
        rogers_choose_plan_page.selectFirstAvailablePlan();
        rogers_choose_plan_page.verifyAndClickDowngradeFeeContinue();
        rogers_choose_plan_page.clkCheckout();
        rogers_order_review_page.verifyOrderReviewPageLoadedSuccessfully();
        reporter.reportLogWithScreenshot("Rogers Order review page");
        rogers_order_review_page.clkTermsAgreementCheckbox();
        rogers_order_review_page.selectEmailDigitalCopy(TestDataHandler.testCase9.getUsername());
        reporter.reportLogWithScreenshot("Rogers Order Review page");
        if(rogers_order_review_page.isPaymentRequired()) {
        	rogers_order_review_page.clkContinue();
        	rogers_payment_page.setCreditCardDetails(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber(), 
   				 TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth(), 
   				 TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear(),
   				 TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCVV());
        	reporter.reportLogWithScreenshot("Rogers Payment Page");
        	rogers_payment_page.clkSubmit();
        } else {
        	rogers_order_review_page.clkSubmitOrder();
        }
        reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(rogers_order_confirmation_page.verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Order Confirmation page");
   }

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.bfaConfig.getRogersURL(), strBrowser, strLanguage, RogersEnums.GroupName.buyflows , method);
	}
    
	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }
    
}