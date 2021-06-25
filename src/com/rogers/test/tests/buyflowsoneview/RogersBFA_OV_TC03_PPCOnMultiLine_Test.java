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
 * TC03-OV-PPC_Multiline Account_Validate if user is able to place an order in PPC flow for both lines_EN
 * @author Saurav.Goyal
 */
public class RogersBFA_OV_TC03_PPCOnMultiLine_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","RegressionOVBFA","PPCOvBFA"})
	public void ppcOnMultiLineFlowTest() {
		reporter.hardAssert(getEnvironmentSelectionPage().presenceOfTheGoButton(), "Rogers OV environment selection page displayed" , "Rogers OV environment selection page not displayed");
		reporter.reportLogWithScreenshot("Rogers OV environment selection page loaded");
		getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		reporter.reportLogWithScreenshot("Rogers OV environment selected" + TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		//getAccountOverViewPage().enterDealerCodeDialogue();
		//getAccountOverViewPage().clkSubmitBtnDealerCodeDialogue();
		reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Account Overview page");
		getAccountOverViewPage().setSkipNotification();
		reporter.hardAssert(getAccountOverViewPage().verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase03.getCtn()), "Select CTN Passed", "Select CTN Failed");
		getAccountOverViewPage().clkCloseBtnAssignDataManager();
		//getAccountOverViewPage().clkBtnOkOneViewDialoue();
		reporter.hardAssert(getRogersOVWirelessDetailsPage().verifyWirelessPageLoad() ,"Wireless page loaded" , "Wireless page not loaded" );
		reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
		getRogersOVWirelessDetailsPage().clickChangePlanButton();
		reporter.reportLogWithScreenshot("Change plan button clicked");
		reporter.hardAssert(getRogersOVChangeSharePlanPage().verifyChangeSharePlanPage(),"Change Share Plan page loaded" , "Change Share Plan page not loaded" );
		reporter.reportLogWithScreenshot("Change share plan page");
		getRogersOVChangeSharePlanPage().clickEditButton();
		reporter.hardAssert(getRogersOVChoosePlanPage().verifyChoosePlanPage() ,"Choose Plan page loaded" , "Choose Plan page not loaded" );
		reporter.reportLogWithScreenshot("Choose Plan page loaded");
		getRogersOVChoosePlanPage().clkSharedLineOne();
		getRogersOVChoosePlanPage().selectPlanCategory(TestDataHandler.buyFlowsOVtestCase03.getNewPlanCategory());
		getRogersOVChoosePlanPage().selectFirstAvailablePlan();
		getRogersOVChoosePlanPage().verifyAndClickDowngradeFeeContinue();
		reporter.reportLogWithScreenshot("Shared line one plan changed");
		getRogersOVChoosePlanPage().clkSharedLineTwo();
		getRogersOVChoosePlanPage().selectPlanCategory(TestDataHandler.buyFlowsOVtestCase03.getNewPlanCategory());
		getRogersOVChoosePlanPage().selectFirstAvailablePlan();
		getRogersOVChoosePlanPage().verifyAndClickDowngradeFeeContinue();
		reporter.reportLogWithScreenshot("Shared line two plan changed");
		getRogersOVChoosePlanPage().clkCheckout();
		reporter.hardAssert(getRogersOVChooseAddonsPage().verifyChooseAddOnPage() , "Addons page loaded" , "Addons page not loaded");
		reporter.reportLogWithScreenshot("Choose add ons page");
		getRogersOVChooseAddonsPage().clkCheckout();
		reporter.hardAssert(getRogersOVOrderReviewPage().verifyOrderReviewPage() , "Order review page loaded" , "Order review page not loaded");
		reporter.reportLogWithScreenshot("Rogers Order review page");
		getRogersOVOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.buyFlowsOVtestCase03.getUsername());
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
		reporter.reportLogWithScreenshot("Order Confirmation page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase03.getContactID(),TestDataHandler.buyFlowsOVtestCase03.getBanNo(),TestDataHandler.bfaOneViewConfig.getUsrID(), TestDataHandler.bfaOneViewConfig.getLoginID(),  method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}