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
 * TC03-Validate user able to perform Main line PPC on Existing Finance account
 * 
 * Launch qa.rogers.com and login using the credentials
 * Select the main line CTN for which the plan has to be changed and select change 
 * Select a Edge plan for main line and click continue
 * Select a Addon(optional) and Click continue
 * Click continue
 * Select the billing address and click OK
 * Click continue
 *  
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TC09_PPC_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","SanityBFA","PPCBFA"})
    public void ppcFlowTest() {
		reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
		reporter.reportLogWithScreenshot("Home Page");
		getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.testCase9.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.testCase9.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyAndClickWirelessCTN(TestDataHandler.testCase9.getCtn()), "Select CTN Passed", "Select CTN Failed");
        getRogersWirelessDetailsPage().verifyWirelessPageLoad();
        reporter.reportLogWithScreenshot("Wireless Dashboard Page");
        getRogersWirelessDetailsPage().clickChangePlanButton();
        getRogersChoosePlanPage().verifyAndClickDowngradeFeeContinue();
        getRogersChoosePlanPage().clkMakeChangesToExistingPlan();
        reporter.reportLogWithScreenshot("Modal window appeared for change your plan");
        getRogersChoosePlanPage().clkButtonModalContinue();
        reporter.reportLogWithScreenshot("Choose Plan page");
        getRogersChoosePlanPage().selectPlanCategory(TestDataHandler.testCase9.getNewPlanCategory());
        getRogersChoosePlanPage().selectPlanType(TestDataHandler.testCase9.getNewPlanType());
        getRogersChoosePlanPage().selectFirstAvailablePlan();
        getRogersChoosePlanPage().verifyAndClickDowngradeFeeContinue();
        getRogersChoosePlanPage().clkCheckout();
        getRogersOrderReviewPage().verifyOrderReviewPageLoadedSuccessfully();
        reporter.reportLogWithScreenshot("Rogers Order review page");
        getRogersOrderReviewPage().clkTermsAgreementCheckbox();
        getRogersOrderReviewPage().clkUpfrontTermsCheckbox();
        getRogersOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.testCase9.getUsername());
        reporter.reportLogWithScreenshot("Rogers Order Review page");
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
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Order Confirmation page");
   }

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows , method);
	}
    
	@AfterMethod(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }
    
}