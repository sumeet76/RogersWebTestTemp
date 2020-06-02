package com.rogers.test.tests.buyflows;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

/**
 * TC02-Validate user able to perform AAL on ML with Fin offer
 * 
 * Launch rogers.com page 
 * Select SHOP-->Wireless-->View all devices
 * Select the device
 * Select "Add a line" option
 * Enter the User name and password
 * Click Ok
 * Select a plan for the new line and click Continue
 * Select a Addon(optional) and Click continue
 * Click continue
 * Select Choose a number and click continue
 * Click continue
 * Enter the payment details and click "Submit order"
 * 
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TC02_AAL_MultiLine_FinancePlan_Test extends BaseTestClass {

	@Test
    public void performAALMultiLine() {
		reporter.reportLogWithScreenshot("Rogers Home page");
        rogers_home_page.clkShop();
        rogers_home_page.clkWireless();
        rogers_home_page.clkViewAllDevices();
        rogers_choose_phone_page.searchDevice(TestDataHandler.testCase02.getNewDevice());
        reporter.reportLogWithScreenshot("Rogers Choose Phone page");
        reporter.reportLogWithScreenshot("Existing Existing Customer overlay");
        rogers_choose_phone_page.selectFirstAvailableDevice();
        rogers_choose_phone_page.clkAddALine();
        rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(TestDataHandler.testCase02.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.testCase02.getPassword());
        reporter.reportLogWithScreenshot("Rogers login overlay");
        rogers_login_page.clkSignInIFrame();
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        reporter.reportLogWithScreenshot("Calling Options overlay");
        rogers_build_plan_page.clkCallingOptionsOkay();
        rogers_build_plan_page.selectPlanCategory(TestDataHandler.testCase02.getNewPlanCategory());
        rogers_build_plan_page.selectFirstAvailablePlan();
        reporter.reportLogWithScreenshot("Rogers Build Plan page");
        rogers_build_plan_page.clkContinue();
        reporter.reportLogWithScreenshot("Rogers Choose Addons page");
        rogers_choose_addons_page.clkContinue();
        reporter.reportLogWithScreenshot("Rogers Cart Summary page");
        rogers_cart_summary_page.clkContinue();
        reporter.reportLogWithScreenshot("Rogers Shipping page");
        rogers_shipping_page.clkContinue();
        rogers_choose_number_page.clkSelectNewNumber();
        rogers_choose_number_page.selectCity(TestDataHandler.testCase02.getCtnCity());
        rogers_choose_number_page.clkFindAvailableNumbers();
        rogers_choose_number_page.selectFirstAvailableNumber();
        rogers_choose_number_page.clkSave();
        reporter.reportLogWithScreenshot("Rogers Choose Number page");
        rogers_choose_number_page.clkContinue();
        rogers_order_review_page.clkTermsAgreementCheckbox();
        rogers_order_review_page.clkShieldAgreementCheckbox();
        rogers_order_review_page.selectEmailDigitalCopy(TestDataHandler.testCase02.getUsername());
        reporter.reportLogWithScreenshot("Rogers Order Review page");
        rogers_order_review_page.clkSubmitOrder();
        reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(rogers_order_confirmation_page.verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation page");
    }

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.bfaConfig.getRogersURL(), strBrowser, strLanguage, RogersEnums.GroupName.BUYFLOWS, method);
	}

    @AfterTest(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }
    
}