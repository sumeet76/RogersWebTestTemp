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
 * TC13-Validate user able to perform HUP with PPC on main line (finance offers) keep existing plan
 * 
 * Launch https://www.qa.rogers.com
 * Select the CTN
 * Click upgrade my device
 * Select the phone to upgrade
 * Choose a Keep Existing plan (Finance offers) for the CTN
 * Select the addons(optional)and click Continue
 * Select the shipping address as Billing address
 * Click Continue
 * Enter the payment details and click "Submit order"
 * 
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TC08_HUP_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","SanityBFA","HUPBFA"})
    public void hupFlowTest() {
		reporter.hardAssert(rogers_home_page.verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
		reporter.reportLogWithScreenshot("Rogers Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(TestDataHandler.testCase8.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.testCase8.getPassword());
		reporter.reportLogWithScreenshot("Rogers Login Page");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");
        reporter.hardAssert(rogers_account_overview_page.verifyAndClickWirelessCTN(TestDataHandler.testCase8.getCtn()),"CTN Found","CTN Not Found");
        rogers_wireless_details_page.verifyWirelessPageLoad();
        reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
        rogers_wireless_details_page.clkUpgradeMyDevice();
        reporter.hardAssert(rogers_choose_phone_page.verifyRogersChoosePhonePage(), "Rogers Choose Phone Page loaded properly", "Rogers Choose Phone Page load failed");
        reporter.reportLogWithScreenshot("Rogers Choose Phone Page");
        rogers_choose_phone_page.searchDevice(TestDataHandler.testCase8.getNewDevice());
        Boolean proOnTheGoAddressFlag  = rogers_choose_phone_page.checkProOnTheGoAtAddress(TestDataHandler.testCase8.getPostalCode());
		Boolean proOnTheGoFlag = false;
		if(proOnTheGoAddressFlag) {
			proOnTheGoFlag = rogers_choose_phone_page.checkProOnTheGo();
		}
        rogers_choose_phone_page.selectFirstAvailableDevice();
        rogers_build_plan_page.verifyBildPlanPageLoadedSuccessfully();
		reporter.reportLogWithScreenshot("Rogers Build Plan page");
        rogers_build_plan_page.selectExistingPlan();
        reporter.reportLogWithScreenshot("Rogers Build Plan Page Existing plan");
        rogers_build_plan_page.clkContinue();
        rogers_choose_addons_page.verifyChooseAddOnsPageLoadedSuccessfully();
        reporter.reportLogWithScreenshot("Rogers Choose Addons Page");
        rogers_choose_addons_page.clkContinueHUP();
        reporter.hardAssert(rogers_shipping_page.verifyRogersShippingPage(), "Rogers shipping Page loaded properly", "Rogers shipping Page load failed");
        reporter.reportLogWithScreenshot("Rogers Shipping Page");
        rogers_shipping_page.clkRadioBillingAddress();
        if(proOnTheGoFlag) {
	        rogers_shipping_page.setEmailIDAndSave();
	        rogers_shipping_page.setPhoneNumberAndSave();
	        rogers_shipping_page.clkSelectAvailableTime();
	        rogers_shipping_page.clkReserve();
        }
        reporter.reportLogWithScreenshot("Rogers Shipping Page before clicking continue");
        rogers_shipping_page.clkContinue();
        rogers_order_review_page.verifyOrderReviewPageLoadedSuccessfully();
        reporter.reportLogWithScreenshot("Rogers review page");
        rogers_order_review_page.clkTermsAgreementCheckbox();
        rogers_order_review_page.clkShieldAgreementCheckbox();
        rogers_order_review_page.clkUpfrontTermsCheckbox();
        rogers_order_review_page.selectEmailDigitalCopy(TestDataHandler.testCase8.getUsername());
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