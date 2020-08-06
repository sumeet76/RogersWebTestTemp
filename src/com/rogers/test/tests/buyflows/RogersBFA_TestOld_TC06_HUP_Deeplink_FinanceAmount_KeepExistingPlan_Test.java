package com.rogers.test.tests.buyflows;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

/**
 * TC06-Validate user able to perform Deeplink HUP for Keep existing plan using Existing Finance Account
 * 
 * Launch Deeplink URL: https://www.qa.rogers.com/web/totes/upgrade/#/choose-phone
 * Select the phone to upgrade
 * Choose a Keep Existing plan for the CTN
 * Select the addons(optional)and click Continue
 * Select the shipping address as Billing address
 * Click Continue
 * Enter the payment details and click "Submit order"
 * 
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TestOld_TC06_HUP_Deeplink_FinanceAmount_KeepExistingPlan_Test extends BaseTestClass {

	@Test
    public void validateSignInAndAccountOverview() {
		getDriver().get(TestDataHandler.bfaConfig.getHupURL());
        rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(TestDataHandler.testCase06.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.testCase06.getPassword());
        reporter.reportLogWithScreenshot("Rogers Login page");
        rogers_login_page.clkSignInIFrame();
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        //rogers_choose_phone_page.selectLineForUpgrade(TestDataHandler.testCase06.getCtn());
        rogers_choose_phone_page.searchDevice(TestDataHandler.testCase06.getNewDevice());
        reporter.reportLogWithScreenshot("Rogers Choose Phone page");
        rogers_choose_phone_page.selectFirstAvailableDevice();
        rogers_build_plan_page.selectExistingPlan();
        reporter.reportLogWithScreenshot("Rogers Build Plan page");
        rogers_build_plan_page.clkContinue();
        reporter.reportLogWithScreenshot("Rogers Choose Addons page");
        rogers_choose_addons_page.clkContinueHUP();
        reporter.reportLogWithScreenshot("Rogers Shipping page");
        rogers_shipping_page.setEmailIDAndSave();
        rogers_shipping_page.clkSelectAvailableTime();
        rogers_shipping_page.clkReserve();
        reporter.reportLogWithScreenshot("Rogers Shipping Page before clicking continue");
        rogers_shipping_page.clkContinue();
        rogers_order_review_page.clkTermsAgreementCheckbox();
        rogers_order_review_page.clkShieldAgreementCheckbox();
        rogers_order_review_page.clkUpfrontTermsCheckbox();
        rogers_order_review_page.selectEmailDigitalCopy(TestDataHandler.testCase06.getUsername());
        if(rogers_order_review_page.isPaymentRequired()) {
        	reporter.reportLogWithScreenshot("Rogers Order Review page");
        	rogers_order_review_page.clkContinue();
        	rogers_payment_page.setCreditCardDetails(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber(), 
   				 TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth(), 
   				 TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear(),
   				 TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCVV());
        	reporter.reportLogWithScreenshot("Rogers Payment page");
        	rogers_payment_page.clkSubmit();
        } else {
        	reporter.reportLogWithScreenshot("Rogers Order Review page");
        	rogers_order_review_page.clkSubmitOrder();
        }
        reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(rogers_order_confirmation_page.verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation page");
   }

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.bfaConfig.getRogersURL(), strBrowser, strLanguage, RogersEnums.GroupName.buyflows , method);
	}

    @AfterTest(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }
    
}