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
 * TC01-OV-AAL_Singleline Account_Validate if user is able to place an order in HUP flow and choose a different plan_EN
 * @author Saurav.Goyal
 */
public class RogersBFA_OV_TC08_AALShareTerm_BopisShipping_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","RegressionOVBFA","SanityBFA","OVAALBFA"})
	public void aALSingleLineShareTermBopisShippingFlow() {
		reporter.hardAssert(getEnvironmentSelectionPage().presenceOfTheGoButton(), "Rogers OV environment selection page displayed" , "Rogers OV environment selection page not displayed");
		reporter.reportLogWithScreenshot("Rogers OV environment selection page loaded");
		getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		reporter.reportLogWithScreenshot("Rogers OV environment selected" + TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		//getAccountOverViewPage().enterDealerCodeDialogue();
		//getAccountOverViewPage().clkSubmitBtnDealerCodeDialogue();
		reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Rogers Account overview page");
		getAccountOverViewPage().setSkipNotification();
		getAccountOverViewPage().selectAddAWirelessLineButton();
		reporter.reportLogWithScreenshot("Add a Wireless Line Button is Selected");
		reporter.hardAssert(getRogersOVChoosePhonePage().checkAcceptAndContinueOnCreditEvalModal() , "Credit Evaluation modal with credit information displayed","Credit Evaluation modal doesn't contain credit info");
		reporter.hardAssert(getRogersOVChoosePhonePage().validateCustomerType(),"Given customer risk type "+TestDataHandler.buyFlowsOVtestCase08.getCustomerRiskLevel()+" matches the risk type "+getRogersOVChoosePhonePage().checkCustomerType()+" from the credit evaluation modal","Given customer risk type "+TestDataHandler.buyFlowsOVtestCase08.getCustomerRiskLevel()+" does not match the risk type "+getRogersOVChoosePhonePage().checkCustomerType()+" from the credit evaluation modal");
		reporter.reportLogWithScreenshot("Credit Evaluation Modal");
		getRogersOVChoosePhonePage().clickAcceptAndContinueOnCreditEvalModal();
		reporter.reportLogWithScreenshot("clicked on Accept and Continue button");
		reporter.hardAssert(getRogersOVChoosePhonePage().verifySharedNonSharedModalPresent(), "Shared/Nonshared modal displayed", "Shared/Nonshared modal not displayed");
		reporter.reportLogWithScreenshot("Shared/Nonshared modal popup");
		String aalSharingType = TestDataHandler.buyFlowsOVtestCase08.getSharingType();
		getRogersOVChoosePhonePage().selectAALSharingType(aalSharingType);
		reporter.reportLogPassWithScreenshot(aalSharingType+ " option selected successfully");
		getRogersOVChoosePhonePage().clickContinueButtonOnModal();
		reporter.reportLogWithScreenshot("Continue button is clicked");
		String deviceName = TestDataHandler.buyFlowsOVtestCase08.getDeviceName();
		reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		getRogersOVChoosePhonePage().clickDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase08.getDeviceName());
		getRogersOVChoosePhonePage().clickContinueButton();
		//-------------------------------------Plan config page---------------------------------------------
		reporter.softAssert(getRogersOVPlanConfigPage().verifyBreadCrumb(deviceName),
				"BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
		reporter.hardAssert(getRogersOVPlanConfigPage().verifySelectedDeviceSection(deviceName), "Plan Config loaded", "Plan config page not loaded");
		reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");
		getRogersOVPlanConfigPage().selectDeviceCostAndClickOnContinueButton(getRogersOVPlanConfigPage().getUpdatedDeviceCostIndex(TestDataHandler.buyFlowsOVtestCase08.getDeviceCostIndex()));
		//getRogersOVPlanConfigPage().clickPreCartDeviceCostContinueButton();
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		getRogersOVPlanConfigPage().clickShowMoreOutDetails();
		getRogersOVPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersOVPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.buyFlowsOVtestCase08.getDataOptionIndex()));
		reporter.reportLogPassWithScreenshot("Data option selected");
		//getRogersOVPlanConfigPage().clickGetBPOOffer();
		//reporter.reportLogPassWithScreenshot("BPO offer selected");
		reporter.hardAssert(getRogersOVPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersOVPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.buyFlowsOVtestCase08.getTalkOptionIndex())),
				"Talk option selected and Addons page in expanded state","Addons page not in expanded state");
		getRogersOVPlanConfigPage().clickPreCartAddonsContinueButton();
		getRogersOVPlanConfigPage().clkContinueCallerID();
		//String monthlyFeesAmountWithTax = getRogersOVPlanConfigPage().getMonthlyFeesAmount();
		//String oneTimeFeesAmountWithTax = getRogersOVPlanConfigPage().getOneTimeFeesAmount();
		//reporter.reportLog("Checkout page Cart Summary Info" + "1. Total Monthly Fees " + monthlyFeesAmountWithTax + "2. oneTimeFee " + oneTimeFeesAmountWithTax);
		//String isSelectedDeviceTier = getRogersOVPlanConfigPage().getDeviceCostTierSelected();
		getRogersOVPlanConfigPage().clickCartSummaryContinueButton();
//---------------------------------------Checkout pages---------------------------------------------------------
		reporter.softAssert(getRogersOVCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
		reporter.softAssert(getRogersOVCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
		getRogersOVCheckoutPage().selectCityDropdownOption(TestDataHandler.buyFlowsOVtestCase08.getCtnCity());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
		getRogersOVCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		reporter.softAssert(getRogersOVCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
		getRogersOVCheckoutPage().clkChooseNumberbutton();
		reporter.hardAssert(getRogersOVCheckoutPage().isChooseaNumberLabelDisplayed(), "Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
		reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
		reporter.hardAssert(getRogersOVCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
				"Billing Address is not selected");
	/*	getRogersOVCheckoutPage().clkDeliveryMethod("Express");
		reporter.reportLogPassWithScreenshot("Bopis Delivery selected");
		reporter.hardAssert(getRogersOVCheckoutPage().verifyExpressLocationMapPresent(), "Express pickup location map is present",
				"Express pickup location map is not available");*/
		//reporter.reportLogPassWithScreenshot("On Checkout page");
		getRogersOVCheckoutPage().clkDeliveryMethod("STANDARD");
		reporter.reportLogPassWithScreenshot("Pro on the go Delivery selected");

		//reporter.hardAssert(getRogersOVCheckoutPage().verifyAppointmentLabel(),"Appointment label is available","Appointment label is not available");
		getRogersOVCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
/*		getRogersOVCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");*/
		//getRogersOVCheckoutPage().clkNoThanks();
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
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyBANOrderConfirmationPage(), "BAN displayed is the same as the given BAN", "BAN displayed isn't the same as the given BAN");
		reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase08.getContactID(),TestDataHandler.buyFlowsOVtestCase08.getBanNo(),TestDataHandler.bfaOneViewConfig.getUsrID(), TestDataHandler.bfaOneViewConfig.getLoginID(),  method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}