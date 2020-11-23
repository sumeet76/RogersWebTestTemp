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
public class RogersBFA_OV_TC01_HUPWithPPCMultiLine_ChooseDifferentPlan_Test extends BaseTestClass {

	@Test
	public void hupWithPPCMultiLineChooseDifferentPlanFlow() {
		getEnvironmentSelectionPage().presenceOfTheGoButton();
		reporter.reportLogWithScreenshot("Rogers Choose Phone page");
		getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		//getEnvironmentSelectionPage().clkGo();
		//getAccountOverViewPage().enterDealerCodeDialogue();
		//getAccountOverViewPage().clkSubmitBtnDealerCodeDialogue();
		reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.hardAssert(getAccountOverViewPage().verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase01.getCtn()),"CTN Found","CTN Not Found");
		getAccountOverViewPage().clkCloseBtnAssignDataManager();
		//getAccountOverViewPage().clkBtnOkOneViewDialoue();
		getRogersOVWirelessDetailsPage().verifyWirelessPageLoad();
		reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
		getRogersOVWirelessDetailsPage().clkUpgradeMyDevice();
		reporter.reportLogWithScreenshot("Rogers Choose Phone Page");
		getRogersOVChoosePhonePage().searchDevice(TestDataHandler.buyFlowsOVtestCase01.getNewDevice());
		Boolean proOnTheGoAddressFlag  = getRogersOVChoosePhonePage().checkProOnTheGoAtAddress(TestDataHandler.buyFlowsOVtestCase01.getPostalCode());
		Boolean proOnTheGoFlag = false;
		if(proOnTheGoAddressFlag) {
			proOnTheGoFlag = getRogersOVChoosePhonePage().checkProOnTheGo();
		}
		getRogersOVChoosePhonePage().selectFirstAvailableDevice();
		reporter.reportLogWithScreenshot("Rogers Choose Phone Page");
		getRogersOVBuildPlanPage().selectFirstPlanInPickNewPlan();
		reporter.reportLogWithScreenshot("Rogers Build Plan Page");
		getRogersOVBuildPlanPage().clkContinue();
		reporter.reportLogWithScreenshot("Rogers Additional line option page");
		getRogersOVChooseAddonsPage().clkCheckBoxKeepCurrentPlanLine2();
		getRogersOVChooseAddonsPage().clkContinueHUP();
		reporter.reportLogWithScreenshot("Rogers Choose Addons Page");
		getRogersOVChooseAddonsPage().clkContinueHUP();
		reporter.reportLogWithScreenshot("Rogers Shipping Page");
		getRogersOVShippingPage().clkRadioBillingAddress();
		if(proOnTheGoFlag) {
			getRogersOVShippingPage().setEmailIDAndSave();
			getRogersOVShippingPage().setPhoneNumberAndSave();
			getRogersOVShippingPage().clkSelectAvailableTime();
			getRogersOVShippingPage().clkReserve();
		}
		reporter.reportLogWithScreenshot("Rogers Shipping Page before clicking continue");
		getRogersOVShippingPage().clkContinue();
		reporter.reportLogWithScreenshot("Rogers review page");
		getRogersOVOrderReviewPage().clkAllTermsAgreementCheckboxs();
		getRogersOVOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.buyFlowsOVtestCase01.getUsername());
		reporter.reportLogWithScreenshot("Rogers Order Review Page");
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
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaUrl"),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase01.getContactID(),TestDataHandler.buyFlowsOVtestCase01.getBanNo(),TestDataHandler.bfaOneViewConfig.getUsrID(), TestDataHandler.bfaOneViewConfig.getLoginID(),  method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}