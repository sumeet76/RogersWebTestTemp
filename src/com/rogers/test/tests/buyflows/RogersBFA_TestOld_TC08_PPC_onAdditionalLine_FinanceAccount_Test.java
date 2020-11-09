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
 * TC08-Validate user able to perform PPC on Additional line  - Existing Finance Account
 * 
 * Launch qa.rogers.com and login using the credentials
 * Select the additional line CTN for which the plan has to be changed and select change 
 * Select a Edge Infinite plan for main and 2nd line > continue
 * Select a Addon(optional) and Click continue
 * Click continue
 * Select the billing address and click OK
 * Click continue
 * Enter the payment details and click "Submit order"
 * 
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TestOld_TC08_PPC_onAdditionalLine_FinanceAccount_Test extends BaseTestClass {

	@Test
    public void performPPCOnAdditionalLine() {
		reporter.reportLogWithScreenshot("Home Page");
		getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.testCase08.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.testCase08.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyAndClickWirelessCTN(TestDataHandler.testCase08.getCtn()), "Select Subscriber Passed", "Select Subscriber Failed");
        reporter.reportLogWithScreenshot("Wireless Dashboard page");
        getRogersWirelessDetailsPage().clickChangePlanButton();
        getRogersChangePlanPage().clkEdit(TestDataHandler.testCase08.getCtn());
        getRogersChangePlanPage().clkChangeMainLine();
        getRogersChoosePlanPage().selectFirstAvailablePlan();
        getRogersChoosePlanPage().selectAdditionalLine(TestDataHandler.testCase08.getCtn());
        getRogersChoosePlanPage().selectPlanCategory(TestDataHandler.testCase08.getNewPlanCategory());
        getRogersChoosePlanPage().selectFirstAvailablePlan();
        getRogersChoosePlanPage().verifyAndClickDowngradeFeeContinue();
        reporter.reportLogWithScreenshot("Choose Plan page");
        getRogersChoosePlanPage().clkContinue();
        reporter.reportLogWithScreenshot("Choose Addons page");
        getRogersChooseAddonsPage().clkCheckout();
        getRogersOrderReviewPage().clkShieldAgreementCheckbox();
        getRogersOrderReviewPage().clkTermsAgreementCheckbox();
        getRogersOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.testCase08.getUsername());
        reporter.reportLogWithScreenshot("Order Review page");
        getRogersOrderReviewPage().clkSubmitOrder();
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