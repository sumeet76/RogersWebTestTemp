package com.rogers.test.tests.buyflowsoneview;

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
 * TC01-OV-HUP with PPC_Multiline Account_Validate if user is able to place an order in HUP flow and choose a different plan_EN
 * @author Saurav.Goyal
 */
public class RogersBFA_OV_TC01_HUPWithPPCMultiLine_ChooseDifferentPlan_Test extends BaseTestClass {

	@Test
	public void hupWithPPCMultiLineChooseDifferentPlanFlow() {
		environment_selection_page.presenceOfTheGoButton();
		reporter.reportLogWithScreenshot("Rogers Choose Phone page");
		environment_selection_page.selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		environment_selection_page.clkGo();
		reporter.hardAssert(account_over_view_page.verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.hardAssert(account_over_view_page.verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase01.getCtn()),"CTN Found","CTN Not Found");
		account_over_view_page.clkBtnAssignDataManager();
		account_over_view_page.clkBtnOkOneViewDialoue();
		rogersOV_wireless_details_page.verifyWirelessPageLoad();
		reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
		rogersOV_wireless_details_page.clkUpgradeMyDevice();
		reporter.reportLogWithScreenshot("Rogers Choose Phone Page");
		rogersOV_choose_phone_page.searchDevice(TestDataHandler.buyFlowsOVtestCase01.getNewDevice());
		Boolean proOnTheGoAddressFlag  = rogersOV_choose_phone_page.checkProOnTheGoAtAddress(TestDataHandler.buyFlowsOVtestCase01.getPostalCode());
		Boolean proOnTheGoFlag = false;
		if(proOnTheGoAddressFlag) {
			proOnTheGoFlag = rogersOV_choose_phone_page.checkProOnTheGo();
		}
		rogersOV_choose_phone_page.selectFirstAvailableDevice();
		reporter.reportLogWithScreenshot("Rogers Choose Phone Page");
		rogersOV_build_plan_page.selectFirstPlanInPickNewPlan();
		reporter.reportLogWithScreenshot("Rogers Build Plan Page");
		rogersOV_build_plan_page.clkContinue();
		reporter.reportLogWithScreenshot("Rogers Additional line option page");
		rogersOV_choose_addons_page.clkCheckBoxKeepCurrentPlanLine2();
		rogersOV_choose_addons_page.clkContinueHUP();
		reporter.reportLogWithScreenshot("Rogers Choose Addons Page");
		rogersOV_choose_addons_page.clkContinueHUP();
		reporter.reportLogWithScreenshot("Rogers Shipping Page");
		if(proOnTheGoFlag) {
			rogers_shipping_page.setEmailID();
			rogers_shipping_page.clkSaveEmail();
			rogers_shipping_page.setPhoneNumber();
			rogers_shipping_page.clkSaveNumber();
			rogers_shipping_page.clkSelectAvailableTime();
			rogers_shipping_page.clkReserve();
		}
		reporter.reportLogWithScreenshot("Rogers Shipping Page before clicking continue");
		rogersOV_shipping_page.clkContinue();
		reporter.reportLogWithScreenshot("Rogers review page");
		order_Review_Page.clkAllTermsAgreementCheckboxs();
		order_Review_Page.selectEmailDigitalCopy(TestDataHandler.buyFlowsOVtestCase01.getUsername());
		reporter.reportLogWithScreenshot("Rogers Order Review Page");
		if(order_Review_Page.isPaymentRequired()) {
			order_Review_Page.clkContinue();
			rogersOV_payment_page.setCreditCardDetails(TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getNumber(), 
					TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getExpiryMonth(), 
					TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getExpiryYear(),
					TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getCVV());
			reporter.reportLogWithScreenshot("Rogers Payment Page");
			rogersOV_payment_page.clkSubmit();
		} else {
			order_Review_Page.clkSubmitOrder();
		}
		reporter.hardAssert(order_Confirmation_Page.verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
		reporter.hardAssert(order_Confirmation_Page.verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
		reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(TestDataHandler.bfaOneViewConfig.getRogersOVUrl(),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase01.getContactID(),TestDataHandler.buyFlowsOVtestCase01.getBanNo(),TestDataHandler.bfaOneViewConfig.getUsrID(), TestDataHandler.bfaOneViewConfig.getLoginID(),  method);
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}