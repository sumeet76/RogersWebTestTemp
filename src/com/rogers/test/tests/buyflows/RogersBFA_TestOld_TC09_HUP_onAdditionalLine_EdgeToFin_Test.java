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
 * TC09-Validate user able to perform HUP with PPC on Additional line - Existing account (Edge to Fin Offer)
 * 
 * Launch https://www.qa.rogers.com
 * Select the CTN
 * Click upgrade my device
 * Select the phone to upgrade
 * Choose a lower tier Edge plan than the Existing plan
 * Select the addons(optional)and click Continue
 * Select the shipping address as Billing address
 * Click Continue
 * Enter the payment details and click "Submit order" 
 *  
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TestOld_TC09_HUP_onAdditionalLine_EdgeToFin_Test extends BaseTestClass {

	@Test
    public void performHUPOnAdditionalLine() {
		reporter.reportLogWithScreenshot("Rogers Home Page");
		rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(TestDataHandler.testCase09.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.testCase09.getPassword());
        reporter.reportLogWithScreenshot("Rogers Login Page");
        rogers_login_page.clkSignInIFrame();
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");
        rogers_account_overview_page.verifyAndClickWirelessCTN(TestDataHandler.testCase09.getCtn());
        reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
        rogers_wireless_details_page.clkUpgradeMyDevice();
        rogers_choose_phone_page.searchDevice(TestDataHandler.testCase09.getNewDevice());
        reporter.reportLogWithScreenshot("Rogers Choose Phone Page");
        rogers_choose_phone_page.selectFirstAvailableDevice();
        rogers_build_plan_page.selectPlanCategory("EDGE FIN 24");
        rogers_build_plan_page.selectFirstAvailablePlan();
        reporter.reportLogWithScreenshot("Rogers Build Plan Page");
        rogers_build_plan_page.clkContinue();
        reporter.reportLogWithScreenshot("Rogers Choose Addons Page");
        rogers_choose_addons_page.clkContinueHUP();
        reporter.reportLogWithScreenshot("Rogers Shipping Page");
        rogers_shipping_page.clkContinue();
        rogers_order_review_page.clkTermsAgreementCheckbox();
        rogers_order_review_page.selectEmailDigitalCopy(TestDataHandler.testCase09.getUsername());
        reporter.reportLogWithScreenshot("Rogers Order Review Page");
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
        reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
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