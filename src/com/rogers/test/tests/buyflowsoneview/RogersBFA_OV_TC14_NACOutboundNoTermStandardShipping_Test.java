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
 * TC01-OV-HUP with PPC_Multiline Account_Validate if user is able to place an order in HUP flow and choose a different plan_EN
 * @author Saurav.Goyal
 */
public class RogersBFA_OV_TC14_NACOutboundNoTermStandardShipping_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","RegressionOVBFA","OVNACBFA"})
	public void rogersNACOutboundNoTermStandardShippingPlanFlow() {
		reporter.hardAssert(getEnvironmentSelectionPage().presenceOfTheGoButton(), "Rogers OV environment selection page displayed" , "Rogers OV environment selection page not displayed");
		reporter.reportLogWithScreenshot("Rogers OV environment selection page loaded");
		getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		reporter.reportLogWithScreenshot("Rogers OV environment selected" + TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		//-------------------------------------NAC Dashboard page---------------------------------------------
		//getAccountOverViewPage().enterDealerCodeDialogue();
		//getAccountOverViewPage().clkSubmitBtnDealerCodeDialogue();
		reporter.hardAssert(getNacDashboardPage().verifyNewCustomerDashboard(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Rogers OV NAC Dashboard page");
		getNacDashboardPage().clkCustomerButton();
		reporter.reportLogWithScreenshot("Services under customer button");
		getNacDashboardPage().clkWirelessButton();
		getNacDashboardPage().setDelearCode();
		reporter.reportLogWithScreenshot("Active Wireless Service Modal");
		getNacDashboardPage().fillShippingAddressField(TestDataHandler.buyFlowsOVtestCase14.getShippingAddress());
		getNacDashboardPage().fillApartmentField(TestDataHandler.buyFlowsOVtestCase14.getApartment());
		//reporter.hardAssert(getNacDashboardPage().verifyPOTGAddressEligibility(), "Address is Eligible for POTG", "Address is not Eligible for POTG");
		//reporter.reportLogWithScreenshot("POTG address is selected");
		getNacDashboardPage().clkGetANewPhoneButton();
		//-------------------------------------Choose Phone page---------------------------------------------
		reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase14.getDeviceName()), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		String deviceName = TestDataHandler.buyFlowsOVtestCase14.getDeviceName();
		reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		getRogersOVChoosePhonePage().clickDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase14.getDeviceName());
		getRogersOVChoosePhonePage().clickContinueButton();
		//-------------------------------------Plan config page---------------------------------------------
		reporter.softAssert(getRogersOVPlanConfigPage().verifyBreadCrumb(deviceName),
				"BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
		reporter.hardAssert(getRogersOVPlanConfigPage().verifySelectedDeviceSection(deviceName), "Plan Config loaded", "Plan config page not loaded");
		reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");
		getRogersOVPlanConfigPage().clickViewMoreOptions();
		getRogersOVPlanConfigPage().selectDeviceCostAndClickOnContinueButton(getRogersOVPlanConfigPage().getUpdatedDeviceCostIndex(TestDataHandler.buyFlowsOVtestCase14.getDeviceCostIndex()),TestDataHandler.buyFlowsOVtestCase14.getDeviceCostType());
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		getRogersOVPlanConfigPage().clickShowMoreOutDetails();
		getRogersOVPlanConfigPage().selectDataOptionButton(getRogersOVPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.buyFlowsOVtestCase14.getDataOptionIndex()));
		reporter.reportLogPassWithScreenshot("Data option selected");
		//getRogersOVPlanConfigPage().clickGetBPOOffer();
		//reporter.reportLogPassWithScreenshot("BPO offer selected");
		reporter.hardAssert(getRogersOVPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersOVPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.buyFlowsOVtestCase14.getTalkOptionIndex())),
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
		String contactNumberCreateProfile=TestDataHandler.buyFlowsOVtestCase14.getContactNumber();
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
		getRogersOVCheckoutPage().selectYearDropdownOption(TestDataHandler.buyFlowsOVtestCase14.getDateOfBirthYear());
		getRogersOVCheckoutPage().selectMonthDropdownOption(TestDataHandler.buyFlowsOVtestCase14.getDateOfBirthMonth());
		getRogersOVCheckoutPage().selectDayDropdownOption(TestDataHandler.buyFlowsOVtestCase14.getDateOfBirthDay());
		//getRogersOVCheckoutPage().selectDropdownOption(TestDataHandler.buyFlowsOVtestCase14.getDropdownOption());
		getRogersOVCheckoutPage().selectPrimaryDropdownOption(TestDataHandler.buyFlowsOVtestCase14.getSelectYourPrimaryIdOption(), TestDataHandler.buyFlowsOVtestCase14.getNumber());
		reporter.reportLogPassWithScreenshot("Driver's License Number Entered Successfully");
		getRogersOVCheckoutPage().selectSecondDropdownOption(TestDataHandler.buyFlowsOVtestCase14.getSelectYourSecondIdOption(),TestDataHandler.buyFlowsOVtestCase14.getSecondNumber());
		reporter.reportLogPassWithScreenshot("Provincial ID Number Entered Successfully");
		getRogersOVCheckoutPage().clkCreditAuthorizationChkBox();
		getRogersOVCheckoutPage().clkCreditEvalContinue();
		reporter.reportLogWithScreenshot("Credit Evaluation modal displayed");
		reporter.hardAssert(getRogersOVChoosePhonePage().checkAcceptAndContinueOnCreditEvalModal() , "Credit Evaluation modal with credit information displayed","Credit Evaluation modal doesn't contain credit info");
		reporter.hardAssert(getRogersOVChoosePhonePage().validateCustomerType(),"Given customer risk type "+TestDataHandler.buyFlowsOVtestCase08.getCustomerRiskLevel()+" matches the risk type "+getRogersOVChoosePhonePage().checkCustomerType()+" from the credit evaluation modal","Given customer risk type "+TestDataHandler.buyFlowsOVtestCase08.getCustomerRiskLevel()+" does not match the risk type "+getRogersOVChoosePhonePage().checkCustomerType()+" from the credit evaluation modal");
		reporter.reportLogWithScreenshot("Credit Evaluation Modal");
		getRogersOVChoosePhonePage().clickAcceptAndContinueOnCreditEvalModal();
		reporter.reportLogWithScreenshot("clicked on Accept and Continue button");
		// ***************Choose a Number Stepper*************//
		reporter.softAssert(getRogersOVCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
		reporter.softAssert(getRogersOVCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
		getRogersOVCheckoutPage().selectCityDropdownOption(TestDataHandler.buyFlowsOVtestCase14.getCtnCity());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
		getRogersOVCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		reporter.softAssert(getRogersOVCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
		getRogersOVCheckoutPage().clkChooseNumberbutton();
		reporter.hardAssert(getRogersOVCheckoutPage().isChooseaNumberLabelDisplayed(), "Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
		reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
		// ***************Billing & Payment Stepper*************//
		reporter.softAssert(getRogersOVCheckoutPage().isBillingOptionsTitleDisplayed(), "Billing Options Title Displayed",
				"Billing Options Title Not Present");
		reporter.softAssert(getRogersOVCheckoutPage().isPaymentMethodDropdownPresent(),
				"Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not disaplayed");
		getRogersOVCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.buyFlowsOVtestCase14.getPaymentMethod());
		getRogersOVCheckoutPage().clkBillingContinueButton();
		// ***************Shipping Stepper*************//
		reporter.hardAssert(getRogersOVCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
				"Billing Address is not selected");
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

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVNACSession(System.getProperty("QaOVUrl"),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase17.getContactID(),TestDataHandler.bfaOneViewLogin.getUsrIDFieldScience(), TestDataHandler.bfaOneViewLogin.getLoginIDFieldScience(),  method);
	}


	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}