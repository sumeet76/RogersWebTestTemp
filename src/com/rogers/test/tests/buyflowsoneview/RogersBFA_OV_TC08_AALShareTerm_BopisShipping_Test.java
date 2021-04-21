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

	@Test(groups = {"RegressionBFA","RegressionOVBFA","SanityBFA","HupOvBFA"})
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
		getRogersOVPlanConfigPage().clickViewMoreOptions();
		getRogersOVPlanConfigPage().selectDeviceCostAndClickOnContinueButton(getRogersOVPlanConfigPage().getUpdatedDeviceCostIndex(TestDataHandler.buyFlowsOVtestCase08.getDeviceCostIndex()));
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		getRogersOVPlanConfigPage().clickShowMoreDetails();
		getRogersOVPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersOVPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.buyFlowsOVtestCase08.getDataOptionIndex()));
		reporter.reportLogPassWithScreenshot("Data option selected");
		reporter.hardAssert(getRogersOVPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersOVPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.buyFlowsOVtestCase08.getTalkOptionIndex())),
				"Talk option selected and Addons page in expanded state","Addons page not in expanded state");
		getRogersOVPlanConfigPage().clickPreCartAddonsContinueButton();
		String monthlyFeesAmountWithTax = getRogersOVPlanConfigPage().getMonthlyFeesAmount();
		String oneTimeFeesAmountWithTax = getRogersOVPlanConfigPage().getOneTimeFeesAmount();
		reporter.reportLog("Checkout page Cart Summary Info" + "1. Total Monthly Fees " + monthlyFeesAmountWithTax + "2. oneTimeFee " + oneTimeFeesAmountWithTax);
		String isSelectedDeviceTier = getRogersOVPlanConfigPage().getDeviceCostTierSelected();
		getRogersOVPlanConfigPage().clickCartSummaryContinueButton();





		reporter.hardAssert(getRogersOVBuildPlanPage().verifyBuildPlanPage() , "Build plan page loaded" , "Build plan page not loaded");
		reporter.reportLogWithScreenshot("Rogers Build Plan Page");
		getRogersOVBuildPlanPage().selectFirstPlanInPickNewPlan();
		reporter.reportLogWithScreenshot("Plan selected");
		getRogersOVBuildPlanPage().clkContinue();
		reporter.hardAssert(getRogersOVChooseAddonsPage().verifyChooseAddOnPage() , "Addons page loaded" , "Addons page not loaded");
		reporter.reportLogWithScreenshot("Rogers Additional line option page");
		getRogersOVChooseAddonsPage().clkCheckBoxKeepCurrentPlanLine2();
		getRogersOVChooseAddonsPage().clkContinueHUP();
		reporter.reportLogWithScreenshot("Rogers Choose Addons Page");
		getRogersOVChooseAddonsPage().clkContinueHUP();
		reporter.hardAssert(getRogersOVShippingPage().verifyShippingPage() , "Shipping page loaded" , "Shipping page not loaded");
		reporter.reportLogWithScreenshot("Rogers Shipping Page");
		getRogersOVShippingPage().clkRadioBillingAddress();
		getRogersOVShippingPage().setEmailIDAndSave();
		getRogersOVShippingPage().setPhoneNumberAndSave();
		getRogersOVShippingPage().clkSelectAvailableTime();
		getRogersOVShippingPage().clkReserve();
		reporter.reportLogWithScreenshot("Rogers Shipping Page before clicking continue");
		getRogersOVShippingPage().clkContinue();
		reporter.hardAssert(getRogersOVOrderReviewPage().verifyOrderReviewPage() , "Order review page loaded" , "Order review page not loaded");
		reporter.reportLogWithScreenshot("Rogers Order review page");
		getRogersOVOrderReviewPage().clkAllTermsAgreementCheckboxs();
		getRogersOVOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.buyFlowsOVtestCase01.getUsername());
		reporter.reportLogWithScreenshot("Rogers Order Review Page after selecting terms and conditions");
		if(getRogersOVOrderReviewPage().isPaymentRequired()) {
			getRogersOVOrderReviewPage().clkContinue();
			getRogersOVPaymentPage().setCreditCardDetails(TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getNumber(),
					TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getExpiryMonth(), 
					TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getExpiryYear(),
					TestDataHandler.bfaOneViewPaymentInfo.getCreditCardDetails().getCVV());
			reporter.reportLogWithScreenshot("Rogers Payment Page");
			getRogersOVPaymentPage().clkSubmit();
		} else {
			getRogersOVOrderReviewPage().clkSubmitOrder();
		}
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
		reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase08.getContactID(),TestDataHandler.buyFlowsOVtestCase08.getBanNo(),TestDataHandler.bfaOneViewConfig.getUsrID(), TestDataHandler.bfaOneViewConfig.getLoginID(),  method);
	}

/*	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}*/

}