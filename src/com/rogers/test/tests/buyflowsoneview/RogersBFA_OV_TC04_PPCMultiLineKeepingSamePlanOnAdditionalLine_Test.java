package com.rogers.test.tests.buyflowsoneview;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
/**
 * TC03-OV-PPC_Multiline Account_Validate if user is able to place an order in PPC flow for both lines_EN
 * @author Saurav.Goyal
 */
public class RogersBFA_OV_TC04_PPCMultiLineKeepingSamePlanOnAdditionalLine_Test extends BaseTestClass {
    @Test(groups = {"RegressionBFA","RegressionOVBFA","PPCOvBFA"})
    public void ppcOnMultiLineKeepingSamePlanOnAdditionalLineFlowTest() {
        reporter.hardAssert(getEnvironmentSelectionPage().presenceOfTheGoButton(), "Rogers OV environment selection page displayed" , "Rogers OV environment selection page not displayed");
        reporter.reportLogWithScreenshot("Rogers OV environment selection page loaded");
		getEnvironmentSelectionPage().selectOneViewEnv(TestDataHandler.bfaOneViewConfig.getEnvironmentName());
        reporter.reportLogWithScreenshot("Rogers OV environment selected" + TestDataHandler.bfaOneViewConfig.getEnvironmentName());
        //getAccountOverViewPage().enterDealerCodeDialogue();
        //getAccountOverViewPage().clkSubmitBtnDealerCodeDialogue();
        reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        reporter.hardAssert(getAccountOverViewPage().verifyAndClickWirelessCTN(TestDataHandler.buyFlowsOVtestCase04.getCtn()), "Select CTN Passed", "Select CTN Failed");
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
        getRogersOVChoosePlanPage().selectPlanCategory(TestDataHandler.buyFlowsOVtestCase04.getNewPlanCategory());
        getRogersOVChoosePlanPage().selectFirstAvailablePlan();
        getRogersOVChoosePlanPage().verifyAndClickDowngradeFeeContinue();
        reporter.reportLogWithScreenshot("Shared line one plan changed");
        getRogersOVChoosePlanPage().clkCheckout();
        reporter.hardAssert(getRogersOVChooseAddonsPage().verifyChooseAddOnPage() , "Addons page loaded" , "Addons page not loaded");
        reporter.reportLogWithScreenshot("Rogers Choose add ons page");
		getRogersOVChooseAddonsPage().clkContinueHUP();
        reporter.hardAssert(getRogersOVOrderReviewPage().verifyOrderReviewPage() , "Order review page loaded" , "Order review page not loaded");
        reporter.reportLogWithScreenshot("Rogers Order review page");
        getRogersOVOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.buyFlowsOVtestCase04.getUsername());
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
		startOVSession(System.getProperty("QaOVUrl"),strBrowser, strLanguage,RogersEnums.GroupName.buyflowsoneview.toString().toLowerCase().trim(), TestDataHandler.buyFlowsOVtestCase04.getContactID(),TestDataHandler.buyFlowsOVtestCase04.getBanNo(),TestDataHandler.bfaOneViewConfig.getUsrID(), TestDataHandler.bfaOneViewConfig.getLoginID(),  method);
  	}
    
	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }
    
}