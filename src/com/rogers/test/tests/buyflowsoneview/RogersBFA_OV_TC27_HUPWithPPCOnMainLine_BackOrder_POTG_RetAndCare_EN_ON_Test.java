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
 * TC27-Consumer_OV_Retension&Care Role_ ML Account_Validate if user is able to place a HUP order with PPC for a backorder device on main line by selecting POTG Shipping_EN_BC
 * @author praveen.kumar7
 */
public class RogersBFA_OV_TC27_HUPWithPPCOnMainLine_BackOrder_POTG_RetAndCare_EN_ON_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","RegressionOVBFA","OVHUPBFA"})
	public void rogersHUPWithPPCOnMainLine_POTG_BackOrder_EN_Test() {
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.buyFlowsOVtestCase27.getBanNo(), TestDataHandler.buyFlowsOVtestCase27.getContactID());
		reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Rogers Account overview page");
		reporter.hardAssert(getAccountOverViewPage().verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase27.getCtn()),"CTN Found","CTN Not Found");
		getAccountOverViewPage().clkCloseBtnAssignDataManager();
		//----------------------------------------------Dashboard page--------------------------------------------------
		reporter.hardAssert(getRogersOVWirelessDetailsPage().verifyWirelessPageLoad() ,"Wireless page loaded" , "Wireless page not loaded");
		reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
		getAccountOverViewPage().changeFidoDealerToRogers();
		getRogersOVWirelessDetailsPage().clkUpgradeMyDevice();
		reporter.reportLogWithScreenshot("Device upgrade button clicked");
		//getRogersOVWirelessDetailsPage().setCustomerType(this.getClass().getSimpleName());
		//----------------------------------------Device Catalog & Config page-------------------------------------------
		/*reporter.hardAssert(getRogersOVChoosePhonePage().isModalDisplayed() , "CTN selection Modal window displayed on the screen " ,"CTN selection Modal window not displayed on the screen");
		reporter.reportLogWithScreenshot("CTN Modal window displayed on the screen");
		getRogersOVChoosePhonePage().selectCTN(TestDataHandler.buyFlowsOVtestCase27.getCtn());
		getRogersOVChoosePhonePage().clkContinueBtnHupCtnSelectionModal();*/
		String deviceName = TestDataHandler.buyFlowsOVtestCase27.getDeviceName();
		reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		getRogersOVChoosePhonePage().clickDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase27.getDeviceName());
		getRogersOVChoosePhonePage().clickContinueButton();
		//---------------------------------------------Plan config page-------------------------------------------------
		reporter.hardAssert(getRogersOVPlanConfigPage().verifyCustomerTypeInHeader("CONSUMER"),
				"Customer type in header is displayed correctly", "Customer type in header is not displayed correctly");
		reporter.softAssert(getRogersOVPlanConfigPage().verifyBreadCrumb(deviceName),
				"BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
		reporter.hardAssert(getRogersOVPlanConfigPage().verifySelectedDeviceSection(deviceName), "Plan Config loaded", "Plan config page not loaded");
		reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");
		getRogersOVPlanConfigPage().clkPreCartDeviceCostContinueButtonForNac();
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		getRogersOVPlanConfigPage().clickContinueOnModalToDoWithOldPhone();
		//getRogersOVPlanConfigPage().clickShowMoreDetails();
		getRogersOVPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersOVPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.buyFlowsOVtestCase27.getDataOptionIndex()));
		reporter.reportLogPassWithScreenshot("Data option selected");
		getRogersOVPlanConfigPage().clickPreCartTalkOptionContinueButton();
		getRogersOVPlanConfigPage().clickPreCartAddonsContinueButton();
		getRogersOVPlanConfigPage().clickCartSummaryContinueButton();
		getRogersOVPlanConfigPage().clkAdditionalLineOptions();
		//---------------------------------------------Checkout pages---------------------------------------------------
		getRogersOVCheckoutPage().clkDeliveryMethod("PRO");
		reporter.reportLogPassWithScreenshot("POTG option selected");
		reporter.hardAssert(getRogersOVCheckoutPage().verifyAppointmentLabel(),"Appointment label is available","Appointment label is not available");
		getRogersOVCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
		getRogersOVCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
		//--------------------------------------Review Order Page-------------------------------------------------------
		reporter.hardAssert(getRogersOVReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
				"Order Review Page Title is not Present");
		reporter.reportLogPassWithScreenshot("Order Review Page");
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
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyBANOrderConfirmationPage(TestDataHandler.buyFlowsOVtestCase27.getBanNo()), "BAN displayed is the same as the given BAN", "BAN displayed isn't the same as the given BAN");
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