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
 * TC34-Consuumer_OV_ML Account_Validate HUP with PPC on main line_EN_QC
 * @author praveen.kumar7
 */
public class RogersBFA_OV_TC34_OVHUPByKEPOnMainLine_ML_StdShip_EN_QC_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","RegressionOVBFA","OVHUPBFA"})
	public void rogersHUPOnMainLine_QCProv_Test() {
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.buyFlowsOVtestCase34.getBanNo(), TestDataHandler.buyFlowsOVtestCase34.getContactID());
		reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Rogers Account overview page");
		reporter.hardAssert(getAccountOverViewPage().verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase34.getCtn()),"CTN Found","CTN Not Found");
		getAccountOverViewPage().clkCloseBtnAssignDataManager();
		//----------------------------------------------Dashboard page--------------------------------------------------
		reporter.hardAssert(getRogersOVWirelessDetailsPage().verifyWirelessPageLoad() ,"Wireless page loaded" , "Wireless page not loaded");
		reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
		getRogersOVWirelessDetailsPage().clkUpgradeMyDevice();
		reporter.reportLogWithScreenshot("Device upgrade button clicked");
		//getRogersOVWirelessDetailsPage().setCustomerType(this.getClass().getSimpleName());
		//----------------------------------------Device Catalog & Config page-------------------------------------------
		/*reporter.hardAssert(getRogersOVChoosePhonePage().isModalDisplayed() , "CTN selection Modal window displayed on the screen " ,"CTN selection Modal window not displayed on the screen");
		reporter.reportLogWithScreenshot("CTN Modal window displayed on the screen");
		getRogersOVChoosePhonePage().selectCTN(TestDataHandler.buyFlowsOVtestCase34.getCtn());
		getRogersOVChoosePhonePage().clkContinueBtnHupCtnSelectionModal();*/
		String deviceName = TestDataHandler.buyFlowsOVtestCase34.getDeviceName();
		reporter.hardAssert(getRogersOVChoosePhonePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
		getRogersOVChoosePhonePage().clickDeviceTileCTAButton(TestDataHandler.buyFlowsOVtestCase34.getDeviceName());
		getRogersOVChoosePhonePage().clickContinueButton();
		//---------------------------------------------Plan config page-------------------------------------------------
		getRogersOVPlanConfigPage().clkRadioButtonNoTerm();
		getRogersOVPlanConfigPage().clkPreCartDeviceCostContinueButtonForNac();
		reporter.reportLogPassWithScreenshot("Device cost option selected");
		getRogersOVPlanConfigPage().clickContinueOnModalToDoWithOldPhone();
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
		getRogersOVReviewOrderPage().clkPointsToMentionCheckbox();
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
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyBANOrderConfirmationPage(TestDataHandler.buyFlowsOVtestCase34.getBanNo()), "BAN displayed is the same as the given BAN", "BAN displayed isn't the same as the given BAN");
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