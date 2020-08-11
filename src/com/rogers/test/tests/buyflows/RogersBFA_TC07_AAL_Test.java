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
 * TC01-Validate user able to perform AAL on SL with Fin offer
 * 
 * Launch rogers.com page 
 * Select SHOP-->Wireless-->View all devices
 * Select the device
 * Select "Add a line" option
 * Enter the User name and password
 * Select a talk and text plan for the new line and click Continue
 * Select a Addon(optional) and Click continue
 * Click continue
 * Select Choose a number and click continue
 * Click continue
 * Enter the payment details and click "Submit order"
 * 
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TC07_AAL_Test extends BaseTestClass {

	@Test
	public void aalFlowTest() {
		//Test
		reporter.reportLogWithScreenshot("Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(TestDataHandler.testCase7.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.testCase7.getPassword());
		reporter.reportLogWithScreenshot("Login Page");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Account Overview page");
		rogers_home_page.clkShop();
		rogers_home_page.clkWireless();
		rogers_home_page.clkViewAllDevices();
		reporter.reportLogWithScreenshot("Add button displayed");
		rogers_home_page.clkAddNow();
		reporter.reportLogWithScreenshot("Add device to a shared plan diologue displayed");
		rogers_home_page.clkAddDeviceToSharedPlan();
		rogers_choose_phone_page.searchDevice(TestDataHandler.testCase7.getNewDevice());
		Boolean proOnTheGoAddressFlag  = rogers_choose_phone_page.checkProOnTheGoAtAddress(TestDataHandler.testCase7.getPostalCode());
		Boolean proOnTheGoFlag = false;
		if(proOnTheGoAddressFlag) {
			proOnTheGoFlag = rogers_choose_phone_page.checkProOnTheGo();
		}
		reporter.reportLogWithScreenshot("Rogers Choose Phone page");
		rogers_choose_phone_page.addFirstAvailableDevice();
		reporter.reportLogWithScreenshot("Rogers Build Plan page");
		rogers_build_plan_page.selectFirstAvailablePlan();
		rogers_build_plan_page.clkContinue();
		reporter.reportLogWithScreenshot("Rogers Choose Addons page");
		rogers_choose_addons_page.clkContinue();
		reporter.reportLogWithScreenshot("Rogers Cart Summary page");
		rogers_cart_summary_page.clkContinue();
		reporter.reportLogWithScreenshot("Rogers Shipping page");
		rogers_shipping_page.clkRadioBillingAddress();
		if(proOnTheGoFlag) {
	        rogers_shipping_page.setEmailIDAndSave();
	        rogers_shipping_page.setPhoneNumberAndSave();
	        rogers_shipping_page.clkSelectAvailableTime();
	        rogers_shipping_page.clkReserve();
        }
        reporter.reportLogWithScreenshot("Rogers Shipping Page before clicking continue");
		rogers_shipping_page.clkContinue();
		reporter.reportLogWithScreenshot("Rogers Choose Number page");
		rogers_choose_number_page.clkSelectNewNumber();
		rogers_choose_number_page.selectCity(TestDataHandler.testCase7.getCtnCity());
		rogers_choose_number_page.clkFindAvailableNumbers();
		rogers_choose_number_page.selectFirstAvailableNumber();
		rogers_choose_number_page.clkSave();
		reporter.reportLogWithScreenshot("Rogers Choose Number page");
		rogers_choose_number_page.clkContinue();
		reporter.reportLogWithScreenshot("Rogers Order Review page");
		//rogers_order_review_page.clkEmailDigitalCopy();
		rogers_order_review_page.clkTermsAgreementCheckbox();
		rogers_order_review_page.clkShieldAgreementCheckbox();
		rogers_order_review_page.clkUpfrontTermsCheckbox();
		rogers_order_review_page.selectEmailDigitalCopy(TestDataHandler.testCase7.getUsername());
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
		reporter.reportLogWithScreenshot("Rogers Order Confirmation page");
	}

	@BeforeMethod @Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.bfaConfig.getRogersURL(), strBrowser, strLanguage, RogersEnums.GroupName.buyflows, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}