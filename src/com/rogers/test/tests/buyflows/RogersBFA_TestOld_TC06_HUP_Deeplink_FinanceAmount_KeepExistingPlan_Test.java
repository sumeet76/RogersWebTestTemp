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
 * TC06-Validate user able to perform Deeplink HUP for Keep existing plan using Existing Finance Account
 * 
 * Launch Deeplink URL: https://www.qa.rogers.com/web/totes/upgrade/#/choose-phone
 * Select the phone to upgrade
 * Choose a Keep Existing plan for the CTN
 * Select the addons(optional)and click Continue
 * Select the shipping address as Billing address
 * Click Continue
 * Enter the payment details and click "Submit order"
 * 
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TestOld_TC06_HUP_Deeplink_FinanceAmount_KeepExistingPlan_Test extends BaseTestClass {

	@Test
    public void validateSignInAndAccountOverview() {
		getDriver().get(TestDataHandler.bfaConfig.getHupURL());
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.testCase06.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.testCase06.getPassword());
        reporter.reportLogWithScreenshot("Rogers Login page");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        //getRogersChoosePhonePage().selectLineForUpgrade(TestDataHandler.testCase06.getCtn());
        getRogersChoosePhonePage().searchDevice(TestDataHandler.testCase06.getNewDevice());
        reporter.reportLogWithScreenshot("Rogers Choose Phone page");
        getRogersChoosePhonePage().selectFirstAvailableDevice();
        getRogersBuildPlanPage().selectExistingPlan();
        reporter.reportLogWithScreenshot("Rogers Build Plan page");
        getRogersBuildPlanPage().clkContinue();
        reporter.reportLogWithScreenshot("Rogers Choose Addons page");
        getRogersChooseAddonsPage().clkContinueHUP();
        reporter.reportLogWithScreenshot("Rogers Shipping page");
        getRogersShippingPage().setEmailIDAndSave();
        getRogersShippingPage().clkSelectAvailableTime();
        getRogersShippingPage().clkReserve();
        reporter.reportLogWithScreenshot("Rogers Shipping Page before clicking continue");
        getRogersShippingPage().clkContinue();
        getRogersOrderReviewPage().clkTermsAgreementCheckbox();
        getRogersOrderReviewPage().clkShieldAgreementCheckbox();
        getRogersOrderReviewPage().clkUpfrontTermsCheckbox();
        getRogersOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.testCase06.getUsername());
        if(getRogersOrderReviewPage().isPaymentRequired()) {
        	reporter.reportLogWithScreenshot("Rogers Order Review page");
        	getRogersOrderReviewPage().clkContinue();
        	getRogersPaymentPage().setCreditCardDetails(TestDataHandler.paymentInfo.getCreditCardDetails().getNumber(),
   				 TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth(), 
   				 TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear(),
   				 TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCVV());
        	reporter.reportLogWithScreenshot("Rogers Payment page");
        	getRogersPaymentPage().clkSubmit();
        } else {
        	reporter.reportLogWithScreenshot("Rogers Order Review page");
        	getRogersOrderReviewPage().clkSubmitOrder();
        }
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation page");
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