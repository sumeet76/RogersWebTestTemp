package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC08 - Regression - Rogers PPC e2e
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TC08_PPC_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","SanityBFA","PPCBFA"})
    public void rogersPpcTest() {
		reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
		reporter.reportLogWithScreenshot("Home Page");
		getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc08PPC.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc08PPC.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
        //getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyAndClickWirelessCTN(TestDataHandler.tc08PPC.getCtn()), "Select CTN Passed", "Select CTN Failed");
        getRogersWirelessDetailsPage().verifyWirelessPageLoad();
        reporter.reportLogWithScreenshot("Wireless Dashboard Page");
        getRogersWirelessDetailsPage().clickChangePlanButton();
        getRogersChoosePlanPage().verifyAndClickDowngradeFeeContinue();
        /*
        getRogersChoosePlanPage().clkMakeChangesToExistingPlan();
        reporter.reportLogWithScreenshot("Modal window appeared for change your plan");
        getRogersChoosePlanPage().clkButtonModalContinue();
         */
        getRogersChoosePlanPage().verifyChoosePlanPage();
        reporter.reportLogWithScreenshot("Choose Plan page loaded");
        getRogersChoosePlanPage().selectPlanCategory(TestDataHandler.tc08PPC.getNewPlanCategory());
        getRogersChoosePlanPage().selectPlanType(TestDataHandler.tc08PPC.getNewPlanType());
        getRogersChoosePlanPage().selectFirstAvailablePlan();
        getRogersChoosePlanPage().verifyAndClickDowngradeFeeContinue();
        reporter.reportLogWithScreenshot("Plan selected");
        getRogersChoosePlanPage().clkCheckout();
        getRogersOrderReviewPage().verifyOrderReviewPageLoadedSuccessfully();
        reporter.reportLogWithScreenshot("Rogers Order review page");
        getRogersOrderReviewPage().clkTermsAgreementCheckbox();
        //getRogersOrderReviewPage().clkUpfrontTermsCheckbox();
        getRogersOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.tc08PPC.getUsername());
        reporter.reportLogWithScreenshot("All terms and conditions selected");
        if(getRogersOrderReviewPage().isPaymentRequired()) {
        	getRogersOrderReviewPage().clkContinue();
        	getRogersPaymentPage().setCreditCardDetails(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber(),
   				 TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth(), 
   				 TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear(),
   				 TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCVV());
        	reporter.reportLogWithScreenshot("Rogers Payment Page");
        	getRogersPaymentPage().clkSubmit();
        } else {
        	getRogersOrderReviewPage().clkSubmitOrder();
        }
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        //reporter.hardAssert(getRogersOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Order Confirmation page");
   }

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows , method);
	}
    
	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }
    
}