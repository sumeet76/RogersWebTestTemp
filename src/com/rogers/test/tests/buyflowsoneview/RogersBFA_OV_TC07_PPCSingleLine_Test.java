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
		getEnvironmentSelectionPage().presenceOfTheGoButton();
		reporter.reportLogWithScreenshot("Rogers Choose Phone page");
		getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
		//getEnvironmentSelectionPage().clkGo();
        reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        reporter.hardAssert(getAccountOverViewPage().verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase07.getCtn()), "Select CTN Passed", "Select CTN Failed");
        getAccountOverViewPage().clkCloseBtnAssignDataManager();
		//getAccountOverViewPage().clkBtnOkOneViewDialoue();
		getRogersOVWirelessDetailsPage().verifyWirelessPageLoad();
        reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
        getRogersOVWirelessDetailsPage().clickChangePlanButton();
        reporter.reportLogWithScreenshot("Modal window appeared for change your plan");
        getRogersOVChoosePlanPage().clkMakeChangesToExistingPlan();
        getRogersOVChoosePlanPage().clkButtonModalContinue();
        reporter.reportLogWithScreenshot("Choose Plan page");
        getRogersOVChoosePlanPage().selectPlanCategory(TestDataHandler.buyFlowsOVtestCase07.getNewPlanCategory());
        getRogersOVChoosePlanPage().selectPlanType("");
        getRogersOVChoosePlanPage().selectFirstAvailablePlan();
        getRogersOVChoosePlanPage().verifyAndClickDowngradeFeeContinue();
        getRogersOVChoosePlanPage().clkCheckout();
        //getRogersOVOrderReviewPage().clkTermsAgreementCheckbox();
        //getRogersOrderReviewPage().clkShieldAgreementCheckbox();
        getRogersOVOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.buyFlowsOVtestCase07.getUsername());
        reporter.reportLogWithScreenshot("Order Review page");
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
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaUrl"),strBrowser, strLanguage, RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim() , TestDataHandler.buyFlowsOVtestCase07.getContactID(),TestDataHandler.buyFlowsOVtestCase07.getBanNo(),TestDataHandler.bfaOneViewConfig.getUsrID(), TestDataHandler.bfaOneViewConfig.getLoginID(),  method);
  	}
    
	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }
    
}