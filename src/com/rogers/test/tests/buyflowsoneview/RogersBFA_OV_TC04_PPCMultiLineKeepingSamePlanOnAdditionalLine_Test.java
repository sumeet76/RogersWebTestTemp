package com.rogers.test.tests.buyflowsoneview;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

/**
 * TC03-OV-PPC_Multiline Account_Validate if user is able to place an order in PPC flow for both lines_EN
 *  
 * @author Saurav.Goyal
 *
 */
public class RogersBFA_OV_TC04_PPCMultiLineKeepingSamePlanOnAdditionalLine_Test extends BaseTestClass {

	@Test
    public void ppcOnMultiLineKeepingSamePlanOnAdditionalLineFlowTest() {
		environment_selection_page.presenceOfTheGoButton();
		reporter.reportLogWithScreenshot("Rogers Choose Phone page");
		environment_selection_page.selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
        reporter.hardAssert(account_over_view_page.verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        reporter.hardAssert(account_over_view_page.verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase04.getCtn()), "Select CTN Passed", "Select CTN Failed");
        account_over_view_page.clkCloseBtnAssignDataManager();
		//account_over_view_page.clkBtnOkOneViewDialoue();
        reporter.reportLogWithScreenshot("Wireless Dashboard Page");
        rogersOV_wireless_details_page.clickChangePlanButton();
        reporter.reportLogWithScreenshot("Change share plan page");
        rogersOV_ChangeSharePlan_page.clickEditButton();
        reporter.reportLogWithScreenshot("Choose Plan page");
        rogersOV_ChoosePlan_page.clkSharedLineOne();
        rogersOV_ChoosePlan_page.selectPlanCategory(TestDataHandler.buyFlowsOVtestCase04.getNewPlanCategory());
        rogersOV_ChoosePlan_page.selectFirstAvailablePlan();
        rogersOV_ChoosePlan_page.verifyAndClickDowngradeFeeContinue();
        /*
        rogersOV_ChoosePlan_page.clkSharedLineTwo();
        rogersOV_ChoosePlan_page.selectPlanCategory(TestDataHandler.buyFlowsOVtestCase03.getNewPlanCategory());
        rogersOV_ChoosePlan_page.selectFirstAvailablePlan();
        rogersOV_ChoosePlan_page.verifyAndClickDowngradeFeeContinue();
        */
        rogersOV_ChoosePlan_page.clkCheckout();
        reporter.reportLogWithScreenshot("Rogers Choose Addons Page");
		rogersOV_choose_addons_page.clkContinueHUP();
        order_Review_Page.selectEmailDigitalCopy(TestDataHandler.buyFlowsOVtestCase04.getUsername());
        reporter.reportLogWithScreenshot("Order Review page");
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
        reporter.reportLogWithScreenshot("Order Confirmation page");
   }

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(TestDataHandler.bfaOneViewConfig.getRogersOVUrl(),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase04.getContactID(),TestDataHandler.buyFlowsOVtestCase04.getBanNo(),TestDataHandler.bfaOneViewConfig.getUsrID(), TestDataHandler.bfaOneViewConfig.getLoginID(),  method);
  	}
    
	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }
    
}