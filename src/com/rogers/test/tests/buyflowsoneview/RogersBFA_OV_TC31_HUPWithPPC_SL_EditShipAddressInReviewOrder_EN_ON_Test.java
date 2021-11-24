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
 * TC31-Consumer_OV_SL Account_Perform HUP with Std shipping delivery_Edit shipping address in review order page_EN_ON
 * @author praveen.kumar7
 */
public class RogersBFA_OV_TC31_HUPWithPPC_SL_EditShipAddressInReviewOrder_EN_ON_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","RegressionOVBFA","OVHUPBFA"})
	public void rogersHUPWithPPCEditShipAddrInReviewPage_EN_Test() {
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.buyFlowsOVtestCase31.getBanNo(), TestDataHandler.buyFlowsOVtestCase31.getContactID());
		reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Rogers Account overview page");
		reporter.hardAssert(getAccountOverViewPage().verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase31.getCtn()),"CTN Found","CTN Not Found");
		getAccountOverViewPage().clkCloseBtnAssignDataManager();
		//----------------------------------------------Dashboard page--------------------------------------------------
		reporter.hardAssert(getRogersOVWirelessDetailsPage().verifyWirelessPageLoad() ,"Wireless page loaded" , "Wireless page not loaded");
		reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
		getRogersOVWirelessDetailsPage().clkUpgradeMyDevice();
		reporter.reportLogWithScreenshot("Device upgrade button clicked");
		//getRogersOVWirelessDetailsPage().setCustomerType(this.getClass().getSimpleName());
		//----------------------------------------Device Catalog & Config page-------------------------------------------
		String deviceName = TestDataHandler.buyFlowsOVtestCase31.getDeviceName();
		reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		getRogersOVChoosePhonePage().clickDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase31.getDeviceName());
		getRogersOVChoosePhonePage().clickContinueButton();
		//---------------------------------------------Plan config page-------------------------------------------------
		reporter.hardAssert(getRogersOVPlanConfigPage().verifyCustomerTypeInHeader("CONSUMER"),
				"Customer type in header is displayed correctly", "Customer type in header is not displayed correctly");
		reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");
		getRogersOVPlanConfigPage().clkPreCartDeviceCostContinueButtonForNac();
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		getRogersOVPlanConfigPage().clickContinueOnModalToDoWithOldPhone();
		getRogersOVPlanConfigPage().clickShowMoreDetails();
		getRogersOVPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersOVPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.buyFlowsOVtestCase31.getDataOptionIndex()));
		reporter.reportLogPassWithScreenshot("Data option selected");
		getRogersOVPlanConfigPage().clickPreCartTalkOptionContinueButton();
		getRogersOVPlanConfigPage().clickPreCartAddonsContinueButton();
		getRogersOVPlanConfigPage().clickCartSummaryContinueButton();
		//---------------------------------------------Checkout pages---------------------------------------------------
		getRogersOVCheckoutPage().clkDeliveryMethod("STANDARD");
		reporter.reportLogPassWithScreenshot("Standard shipping option selected");
		getRogersOVCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
		getRogersOVCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
		//--------------------------------------Review Order Page-------------------------------------------------------
		reporter.hardAssert(getRogersOVReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
				"Order Review Page Title is not Present");
		reporter.reportLogPassWithScreenshot("Order Review Page");
		getRogersOVReviewOrderPage().clkEditShippingAddress();
		getRogersOVCheckoutPage().clkNewAddress();
		reporter.reportLogWithScreenshot("New address option selected");
		getRogersOVCheckoutPage().enterNewAddress(TestDataHandler.buyFlowsOVtestCase17.getShippingAddress());
		getRogersOVCheckoutPage().clkDeliveryMethod("STANDARD");
		reporter.reportLogPassWithScreenshot("Standard shipping option selected");
		getRogersOVCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
		getRogersOVCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
		reporter.hardAssert(getRogersOVReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
				"Order Review Page Title is not Present");
		reporter.hardAssert(getRogersOVReviewOrderPage().verifyShippingAddress(TestDataHandler.buyFlowsOVtestCase17.getShippingAddress()),
				"New shipping address entered is displayed correctly in Review page", "New shipping address entered is not displayed correctly in Review page");
		getRogersOVReviewOrderPage().clkPointsToMentionCheckbox();
		getRogersOVReviewOrderPage().clkEmailConsentCheckbox();
		reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
		getRogersOVReviewOrderPage().clkSubmitOrderBtn();
		reporter.reportLogWithScreenshot("Submit Order Button Pressed");
		if(getRogersOVOrderReviewPage().isPaymentRequired()) {
			//getRogersOVOrderReviewPage().clkContinue();
			getRogersOVOneTimePaymentPage().clkPreAuthorizedCreditCardTokenButton();
			getRogersOVOneTimePaymentPage().setNameonCard();
			getRogersOVOneTimePaymentPage().setTokenDetails(TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getNumber3(),
					TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getExpiryMonth3(),
					TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getExpiryYear3());
			reporter.reportLogWithScreenshot("Rogers Payment Page");
			getRogersOVPaymentPage().clkSubmit();
		}
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
		//reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyBANOrderConfirmationPage(TestDataHandler.buyFlowsOVtestCase31.getBanNo()), "BAN displayed is the same as the given BAN", "BAN displayed isn't the same as the given BAN");
		reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("OVUrl"),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(),"", "","", "", method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}