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
 * TC15-OV-NAC TERM_Validate if user is able to place a NAC order by selecting financing outbound plan and standard shipping_EN
 * @author praveen.kumar7
 */
public class RogersBFA_OV_TC15_NACOutboundFinanceStandardShipping_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","RegressionOVBFA","OVSanityBFA","OVNACBFA"})
	public void rogersNACOutboundFinanceStandardShippingDifferentPlanFlow() {
		reporter.hardAssert(getEnvironmentSelectionPage().presenceOfTheGoButton(), "Rogers OV environment selection page displayed" , "Rogers OV environment selection page not displayed");
		reporter.reportLogWithScreenshot("Rogers OV environment selection page loaded");
		getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		reporter.reportLogWithScreenshot("Rogers OV environment selected" + TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		//-------------------------------------NAC Dashboard page---------------------------------------------
		//getAccountOverViewPage().enterDealerCodeDialogue();
		//getAccountOverViewPage().clkSubmitBtnDealerCodeDialogue();
		reporter.hardAssert(getNacDashboardPage().verifyNewCustomerDashboard(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Rogers OV NAC Dashboard page");
		getAccountOverViewPage().changeFidoDealerToRogers();
		getNacDashboardPage().clkCustomerButton();
		reporter.reportLogWithScreenshot("Services under customer button");
		getNacDashboardPage().clkWirelessButton();
		reporter.reportLogWithScreenshot("Active Wireless Service Modal");
		//getAccountOverViewPage().enterDealerCodeDialogue();
		//getAccountOverViewPage().clkSubmitBtnDealerCodeDialogue();
		getNacDashboardPage().setDelearCode();
		getNacDashboardPage().fillShippingAddressField(TestDataHandler.buyFlowsOVtestCase15.getShippingAddress());
		//getNacDashboardPage().fillApartmentField(TestDataHandler.buyFlowsOVtestCase15.getApartment());
		//reporter.hardAssert(getNacDashboardPage().verifyPOTGAddressEligibility(), "Address is Eligible for POTG", "Address is not Eligible for POTG");
		//reporter.reportLogWithScreenshot("POTG address is selected");
		getNacDashboardPage().clkGetANewPhoneButton();
		//-------------------------------------Choose Phone page---------------------------------------------
		reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase15.getDeviceName()), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		String deviceName = TestDataHandler.buyFlowsOVtestCase15.getDeviceName();
		reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		getRogersOVChoosePhonePage().clickDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase15.getDeviceName());
		getRogersOVChoosePhonePage().selectDeviceColor(TestDataHandler.buyFlowsOVtestCase15.getDeviceColor());
		reporter.reportLogPassWithScreenshot("Device config page displayed");
		getRogersOVChoosePhonePage().clickContinueButton();
		//-------------------------------------Plan config page---------------------------------------------
		reporter.softAssert(getRogersOVPlanConfigPage().verifyBreadCrumb(deviceName),
				"BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
		reporter.hardAssert(getRogersOVPlanConfigPage().verifySelectedDeviceSection(deviceName), "Plan Config loaded", "Plan config page not loaded");
		reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");
		getRogersOVPlanConfigPage().clickViewMoreOptions();
		getRogersOVPlanConfigPage().selectDeviceCostAndClickOnContinueButton(getRogersOVPlanConfigPage().getUpdatedDeviceCostIndex(TestDataHandler.buyFlowsOVtestCase15.getDeviceCostIndex()),TestDataHandler.buyFlowsOVtestCase15.getDeviceCostType());
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		//getRogersOVPlanConfigPage().clickShowMoreOutDetails();
		getRogersOVPlanConfigPage().clickOutBoundAccordion();
		getRogersOVPlanConfigPage().selectDataOptionButton(getRogersOVPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.buyFlowsOVtestCase15.getDataOptionIndex()));
		reporter.reportLogPassWithScreenshot("Data option selected");
		//getRogersOVPlanConfigPage().clickGetBPOOffer();
		//reporter.reportLogPassWithScreenshot("BPO offer selected");
		reporter.hardAssert(getRogersOVPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersOVPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.buyFlowsOVtestCase15.getTalkOptionIndex())),
				"Talk option selected and Addons page in expanded state","Addons page not in expanded state");
		getRogersOVPlanConfigPage().clickPreCartAddonsContinueButton();
		getRogersOVPlanConfigPage().clickCartSummaryContinueButton();
		//############################CheckoutPage############################//
		//***************Create Profile Stepper*************//
		reporter.softAssert(getRogersOVCheckoutPage().verifyCreateProfileTitle(),"Create profile Title Present","Create profile Title not present");
		String emailCreateProfile=getRogersOVCheckoutPage().setEmailCreateProfile();
		String firstName = getRogersOVCheckoutPage().setFirstNameCreateProfile();
		String lastName = getRogersOVCheckoutPage().setLastNameCreateProfile();
		String fullNameCreateProfile=firstName+" "+lastName;
		String contactNumberCreateProfile=TestDataHandler.buyFlowsOVtestCase15.getContactNumber();
		getRogersOVCheckoutPage().setContactNumberCreateProfile(contactNumberCreateProfile);
		reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
		//getRogersOVCheckoutPage().clkUseBillingAddressRadioBtnCreateProfile();
		//getRogersCheckoutPage().setBillingAddressCreateProfile(TestDataHandler.tc01NACTermNpotgSS.getBillingAddress());
		//getRogersCheckoutPage().clkUseBillingAddressRadioBtnCreateProfile();
		//getRogersCheckoutPage().clkLanguageEnglishRadioBtnCreateProfile();
		reporter.reportLogPassWithScreenshot("Create Profile Page details provided for Address,Shipping Address & Language Selected");
		getRogersOVCheckoutPage().clkBtnGotoCreditEvalStepper();
		//***************Credit Evaluation Stepper*************//
		reporter.softAssert(getRogersOVCheckoutPage().verifyCreditEvaluationTitle(),"CreditEvaluation Title verified","CreditEvaluation Title not present");
		//getRogersCheckoutPage().setDateOfBirth(TestDataHandler.redesignRpotgData.getDateOfBirth());
		getRogersOVCheckoutPage().selectYearDropdownOption(TestDataHandler.buyFlowsOVtestCase15.getDateOfBirthYear());
		getRogersOVCheckoutPage().selectMonthDropdownOption(TestDataHandler.buyFlowsOVtestCase15.getDateOfBirthMonth());
		getRogersOVCheckoutPage().selectDayDropdownOption(TestDataHandler.buyFlowsOVtestCase15.getDateOfBirthDay());
		//getRogersOVCheckoutPage().selectDropdownOption(TestDataHandler.buyFlowsOVtestCase15.getDropdownOption());
		getRogersOVCheckoutPage().selectPrimaryDropdownOption(TestDataHandler.buyFlowsOVtestCase15.getSelectYourPrimaryIdOption(), TestDataHandler.buyFlowsOVtestCase15.getNumber());
		reporter.reportLogPassWithScreenshot("Driver's License Number Entered Successfully");
		getRogersOVCheckoutPage().selectSecondDropdownOption(TestDataHandler.buyFlowsOVtestCase15.getSelectYourSecondIdOption(),TestDataHandler.buyFlowsOVtestCase15.getSecondNumber());
		reporter.reportLogPassWithScreenshot("Birth Certificate Number Entered Successfully");
		getRogersOVCheckoutPage().clkCreditAuthorizationChkBox();
		getRogersOVCheckoutPage().clkCreditEvalContinue();
		reporter.reportLogWithScreenshot("Credit Evaluation modal displayed");
		reporter.hardAssert(getRogersOVChoosePhonePage().checkAcceptAndContinueOnCreditEvalModal() , "Credit Evaluation modal with credit information displayed","Credit Evaluation modal doesn't contain credit info");
		//reporter.hardAssert(getRogersOVChoosePhonePage().validateCustomerType(),"Given customer risk type "+TestDataHandler.buyFlowsOVtestCase08.getCustomerRiskLevel()+" matches the risk type "+getRogersOVChoosePhonePage().checkCustomerType()+" from the credit evaluation modal","Given customer risk type "+TestDataHandler.buyFlowsOVtestCase08.getCustomerRiskLevel()+" does not match the risk type "+getRogersOVChoosePhonePage().checkCustomerType()+" from the credit evaluation modal");
		reporter.reportLogWithScreenshot("Credit Evaluation Modal");
		getRogersOVChoosePhonePage().clickAcceptAndContinueOnCreditEvalModal();
		reporter.reportLogWithScreenshot("clicked on Accept and Continue button");
		// ***************Choose a Number Stepper*************//
		reporter.softAssert(getRogersOVCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
		reporter.softAssert(getRogersOVCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
		reporter.reportLogPassWithScreenshot("Choose phone number page loaded successfully");
		getRogersOVCheckoutPage().selectPortinOption();
		getRogersOVCheckoutPage().chooseExistingNumberOption(TestDataHandler.buyFlowsOVtestCase15.getPortinNumber());
		reporter.hardAssert(getRogersOVCheckoutPage().verifyPortinEligibility(),
				"Entered number is eligible to portin", "Entered number not eligible to portin");
		reporter.reportLogPassWithScreenshot("Portin number verified successfully");
		String portinSuccessMessage = getRogersOVCheckoutPage().getPortinSuccessMessage();
		reporter.reportLogWithScreenshot(portinSuccessMessage);
		getRogersOVCheckoutPage().clkContinueBtnPorinStepper();
		// ***************Billing & Payment Stepper*************//
		reporter.softAssert(getRogersOVCheckoutPage().isBillingOptionsTitleDisplayed(), "Billing Options Title Displayed",
				"Billing Options Title Not Present");
		reporter.softAssert(getRogersOVCheckoutPage().isPaymentMethodDropdownPresent(),
				"Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not disaplayed");
		getRogersOVCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.buyFlowsOVtestCase15.getPaymentMethod());
		getRogersOVCheckoutPage().clkBillingContinueButton();
		// ***************Shipping Stepper*************//
		getRogersOVCheckoutPage().clkDeliveryMethod("STANDARD");
		reporter.reportLogPassWithScreenshot("Standard Delivery selected");
		getRogersOVCheckoutPage().clkContinueBtnShipping();
		reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
		getRogersOVCheckoutPage().clksubmitBtnCheckoutPage();
		reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
		// ***************Order Review Page*************//
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
			getRogersOVOneTimePaymentPage().setTokenDetails(TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getNumber1(),
					TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getExpiryMonth1(),
					TestDataHandler.bfaOneViewPaymentInfo.getTokenDetails().getExpiryYear1());
			reporter.reportLogWithScreenshot("Rogers Payment Page");
			getRogersOVPaymentPage().clkSubmit();
		} /*else {
			getRogersOVOrderReviewPage().clkSubmitOrder();
		}*/
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
		//reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
		//reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyBANOrderConfirmationPage(), "BAN displayed is the same as the given BAN", "BAN displayed isn't the same as the given BAN");
		reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
	}

	@BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVNACSession(System.getProperty("QaOVUrl"),strBrowser, strLanguage, RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase17.getContactID(),TestDataHandler.bfaOneViewLogin.getUsrIDFieldScience(), TestDataHandler.bfaOneViewLogin.getLoginIDFieldScience(),  method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		//closeSession();
	}

}