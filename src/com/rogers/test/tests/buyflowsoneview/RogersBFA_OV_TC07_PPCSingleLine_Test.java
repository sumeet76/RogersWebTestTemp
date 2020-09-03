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
 * TC07-OV-PPC_Singleline Account_Validate if user is able to place an order in PPC flow_EN
 *  
 * @author Saurav.Goyal
 *
 */
public class RogersBFA_OV_TC07_PPCSingleLine_Test extends BaseTestClass {

	@Test
    public void ppcSingleLineFlowTest() {
		environment_selection_page.presenceOfTheGoButton();
		reporter.reportLogWithScreenshot("Rogers Choose Phone page");
		environment_selection_page.selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		//environment_selection_page.clkGo();
        reporter.hardAssert(account_over_view_page.verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        reporter.hardAssert(account_over_view_page.verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase07.getCtn()), "Select CTN Passed", "Select CTN Failed");
        account_over_view_page.clkCloseBtnAssignDataManager();
		//account_over_view_page.clkBtnOkOneViewDialoue();
		rogersOV_wireless_details_page.verifyWirelessPageLoad();
        reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
        rogersOV_wireless_details_page.clickChangePlanButton();
        reporter.reportLogWithScreenshot("Modal window appeared for change your plan");
        rogersOV_ChoosePlan_page.clkMakeChangesToExistingPlan();
        rogersOV_ChoosePlan_page.clkButtonModalContinue();
        reporter.reportLogWithScreenshot("Choose Plan page");
        rogersOV_ChoosePlan_page.selectPlanCategory(TestDataHandler.buyFlowsOVtestCase07.getNewPlanCategory());
        rogersOV_ChoosePlan_page.selectPlanType("");
        rogersOV_ChoosePlan_page.selectFirstAvailablePlan();
        rogersOV_ChoosePlan_page.verifyAndClickDowngradeFeeContinue();
        rogersOV_ChoosePlan_page.clkCheckout();
        //order_Review_Page.clkTermsAgreementCheckbox();
        //rogers_order_review_page.clkShieldAgreementCheckbox();
        order_Review_Page.selectEmailDigitalCopy(TestDataHandler.buyFlowsOVtestCase07.getUsername());
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

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaUrl"),strBrowser, strLanguage, RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim() , TestDataHandler.buyFlowsOVtestCase07.getContactID(),TestDataHandler.buyFlowsOVtestCase07.getBanNo(),TestDataHandler.bfaOneViewConfig.getUsrID(), TestDataHandler.bfaOneViewConfig.getLoginID(),  method);
  	}
    
	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }
    
}