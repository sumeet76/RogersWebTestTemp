package com.rogers.test.tests.buyflowsoneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC06-OV-HUP_Singleline Account_Validate if user is able to place an order in HUP flow with existing plan_EN
 * @author Saurav.Goyal
 */
public class RogersBFA_OV_TC06_HUPSingleLine_ChooseExistingPlan_Test extends BaseTestClass {

	@Test
    public void hupSingleLineChooseExistingPlanFlow() {
		environment_selection_page.presenceOfTheGoButton();
		reporter.reportLogWithScreenshot("Rogers Choose Phone page");
		environment_selection_page.selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		//environment_selection_page.clkGo();
		reporter.hardAssert(account_over_view_page.verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.hardAssert(account_over_view_page.verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase06.getCtn()),"CTN Found","CTN Not Found");
		account_over_view_page.clkCloseBtnAssignDataManager();
		//account_over_view_page.clkBtnOkOneViewDialoue();
		rogersOV_wireless_details_page.verifyWirelessPageLoad();
		reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
		rogersOV_wireless_details_page.clkUpgradeMyDevice();
		reporter.reportLogWithScreenshot("Rogers Choose Phone Page");
		rogersOV_choose_phone_page.searchDevice(TestDataHandler.buyFlowsOVtestCase06.getNewDevice());
		Boolean proOnTheGoAddressFlag  = rogersOV_choose_phone_page.checkProOnTheGoAtAddress(TestDataHandler.buyFlowsOVtestCase01.getPostalCode());
		Boolean proOnTheGoFlag = false;
		if(proOnTheGoAddressFlag) {
			proOnTheGoFlag = rogersOV_choose_phone_page.checkProOnTheGo();
		}
		rogersOV_choose_phone_page.selectFirstAvailableDevice();
		rogersOV_build_plan_page.selectExistingPlan();
		reporter.reportLogWithScreenshot("Rogers Build Plan Page");
		rogersOV_build_plan_page.clkContinue();
		reporter.reportLogWithScreenshot("Rogers Choose Addons Page");
		rogersOV_choose_addons_page.clkContinueHUP();
		reporter.reportLogWithScreenshot("Rogers Shipping Page");
		rogersOV_shipping_page.clkRadioBillingAddress();
		if(proOnTheGoFlag) {
			rogersOV_shipping_page.setEmailIDAndSave();
			rogersOV_shipping_page.setPhoneNumberAndSave();
			rogersOV_shipping_page.clkSelectAvailableTime();
			rogersOV_shipping_page.clkReserve();
        }
        reporter.reportLogWithScreenshot("Rogers Shipping Page before clicking continue");
        rogersOV_shipping_page.clkContinue();
        reporter.reportLogWithScreenshot("Rogers review page");
        order_Review_Page.clkAllTermsAgreementCheckboxs();
        order_Review_Page.selectEmailDigitalCopy(TestDataHandler.buyFlowsOVtestCase06.getUsername());
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
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaUrl"),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase06.getContactID(),TestDataHandler.buyFlowsOVtestCase06.getBanNo(),TestDataHandler.bfaOneViewConfig.getUsrID(), TestDataHandler.bfaOneViewConfig.getLoginID(),  method);
  	}
    
	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}