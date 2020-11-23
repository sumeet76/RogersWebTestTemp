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
 * TC05-Validate user able to perform HUP with PPC for an existing account with device balance using financial offers (fin to fin) for 24 months with $0 upfront
 * 
 * Launch https://www.qa.rogers.com
 * Select the CTN
 * Click upgrade my device
 * Select the phone with $0 with Upfront to upgrade
 * Choose a Financing plan for 24 months  
 * Select the addons(optional)and click Continue
 * Select the shipping address as Billing address
 * Click Continue
 * User is asked to pay the device bal
 * Click "Submit order"
 * 
 * @author rajesh.varalli1
 *
 */
public class RogersBFA_TestOld_TC05_HUP_withDeviceBalance_FinToFin_24Months0Upfront_Test extends BaseTestClass {

	@Test
    public void performHUPwithDeviceBalance() {
		reporter.reportLogWithScreenshot("Rogers Home Page");
		getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.testCase05.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.testCase05.getPassword());
        reporter.reportLogWithScreenshot("Rogers Login Page");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyAndClickWirelessCTN(TestDataHandler.testCase05.getCtn()),"Select Subscriber Passed","Select Subscriber Failed");
        reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
        getRogersWirelessDetailsPage().clkUpgradeMyDevice();
        getRogersChoosePhonePage().searchDevice(TestDataHandler.testCase05.getNewDevice());
        reporter.reportLogWithScreenshot("Rogers Choose Phone Page");
        getRogersChoosePhonePage().selectFirstZeroUpfrontDeviceAvailable();
        getRogersBuildPlanPage().selectPlanCategory("Edge Fin 24");
        getRogersBuildPlanPage().selectFirstAvailablePlan();
        reporter.reportLogWithScreenshot("Rogers Build Plan Page");
        getRogersBuildPlanPage().clkContinue();
        reporter.reportLogWithScreenshot("Rogers Choose Addons Page");
        getRogersChooseAddonsPage().clkContinueHUP();
        reporter.reportLogWithScreenshot("Rogers Shipping Page");
        getRogersShippingPage().setEmailIDAndSave();
        getRogersShippingPage().clkSelectAvailableTime();
        getRogersShippingPage().clkReserve();
        reporter.reportLogWithScreenshot("Rogers Shipping Page before clicking continue");
        getRogersShippingPage().clkContinue();
        getRogersOrderReviewPage().clkTermsAgreementCheckbox();
        getRogersOrderReviewPage().clkShieldAgreementCheckbox();
        getRogersOrderReviewPage().clkUpfrontTermsCheckbox();
        getRogersOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.testCase05.getUsername());
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