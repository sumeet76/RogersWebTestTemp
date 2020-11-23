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
 * TC09-Validate user able to perform HUP with PPC on Additional line - Existing account (Edge to Fin Offer)
 * 
 * Launch https://www.qa.rogers.com
 * Select the CTN
 * Click upgrade my device
 * Select the phone to upgrade
 * Choose a lower tier Edge plan than the Existing plan
 * Select the addons(optional)and click Continue
 * Select the shipping address as Billing address
 * Click Continue
 * Enter the payment details and click "Submit order" 
 *  
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TestOld_TC09_HUP_onAdditionalLine_EdgeToFin_Test extends BaseTestClass {

	@Test
    public void performHUPOnAdditionalLine() {
		reporter.reportLogWithScreenshot("Rogers Home Page");
		getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.testCase09.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.testCase09.getPassword());
        reporter.reportLogWithScreenshot("Rogers Login Page");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");
        getRogersAccountOverviewPage().verifyAndClickWirelessCTN(TestDataHandler.testCase09.getCtn());
        reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
        getRogersWirelessDetailsPage().clkUpgradeMyDevice();
        getRogersChoosePhonePage().searchDevice(TestDataHandler.testCase09.getNewDevice());
        reporter.reportLogWithScreenshot("Rogers Choose Phone Page");
        getRogersChoosePhonePage().selectFirstAvailableDevice();
        getRogersBuildPlanPage().selectPlanCategory("EDGE FIN 24");
        getRogersBuildPlanPage().selectFirstAvailablePlan();
        reporter.reportLogWithScreenshot("Rogers Build Plan Page");
        getRogersBuildPlanPage().clkContinue();
        reporter.reportLogWithScreenshot("Rogers Choose Addons Page");
        getRogersChooseAddonsPage().clkContinueHUP();
        reporter.reportLogWithScreenshot("Rogers Shipping Page");
        getRogersShippingPage().clkContinue();
        getRogersOrderReviewPage().clkTermsAgreementCheckbox();
        getRogersOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.testCase09.getUsername());
        reporter.reportLogWithScreenshot("Rogers Order Review Page");
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
        reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
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