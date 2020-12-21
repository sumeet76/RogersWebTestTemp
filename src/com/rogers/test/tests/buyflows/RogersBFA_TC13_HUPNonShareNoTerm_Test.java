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
 * TC13-Validate user able to perform HUP with PPC on main line (finance offers) keep existing plan
 * 
 * Launch https://www.qa.rogers.com
 * Select the CTN
 * Click upgrade my device
 * Select the phone to upgrade
 * Choose a Keep Existing plan (Finance offers) for the CTN
 * Select the addons(optional)and click Continue
 * Select the shipping address as Billing address
 * Click Continue
 * Enter the payment details and click "Submit order"
 *
 */
public class RogersBFA_TC13_HUPNonShareNoTerm_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","SanityBFA","HUPBFA"})
    public void hupFlowTest() {
		reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
		reporter.reportLogWithScreenshot("Rogers Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc13HUPNonShareNoTerm.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc13HUPNonShareNoTerm.getPassword());
		reporter.reportLogWithScreenshot("Rogers Login Page");
		getRogersLoginPage().clkSignInIFrame();
		reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");
        reporter.hardAssert(getRogersAccountOverviewPage().verifyAndClickWirelessCTN(TestDataHandler.tc13HUPNonShareNoTerm.getCtn()),"CTN Found","CTN Not Found");
        getRogersWirelessDetailsPage().verifyWirelessPageLoad();
        reporter.reportLogWithScreenshot("Rogers Wireless Dashboard Page");
        getRogersWirelessDetailsPage().clkUpgradeMyDevice();
        reporter.hardAssert(getRogersChoosePhonePage().verifyRogersChoosePhonePage(), "Rogers Choose Phone Page loaded properly", "Rogers Choose Phone Page load failed");
        reporter.reportLogWithScreenshot("Rogers Choose Phone Page");
        getRogersChoosePhonePage().searchDevice(TestDataHandler.tc13HUPNonShareNoTerm.getNewDevice());
        Boolean proOnTheGoAddressFlag  = getRogersChoosePhonePage().checkProOnTheGoAtAddress(TestDataHandler.tc13HUPNonShareNoTerm.getPostalCode());
		Boolean proOnTheGoFlag = false;
		if(proOnTheGoAddressFlag) {
			proOnTheGoFlag = getRogersChoosePhonePage().checkProOnTheGo();
		}
        getRogersChoosePhonePage().selectFirstAvailableDevice();
        getRogersBuildPlanPage().verifyBildPlanPageLoadedSuccessfully();
		reporter.reportLogWithScreenshot("Rogers Build Plan page");
        getRogersBuildPlanPage().selectExistingPlan();
        reporter.reportLogWithScreenshot("Rogers Build Plan Page Existing plan");
        getRogersBuildPlanPage().clkContinue();
        getRogersChooseAddonsPage().verifyChooseAddOnsPageLoadedSuccessfully();
        reporter.reportLogWithScreenshot("Rogers Choose Addons Page");
        getRogersChooseAddonsPage().clkContinueHUP();
        reporter.hardAssert(getRogersShippingPage().verifyRogersShippingPage(), "Rogers shipping Page loaded properly", "Rogers shipping Page load failed");
        reporter.reportLogWithScreenshot("Rogers Shipping Page");
        getRogersShippingPage().clkRadioBillingAddress();
        if(proOnTheGoFlag) {
	        getRogersShippingPage().setEmailIDAndSave();
	        getRogersShippingPage().setPhoneNumberAndSave();
	        getRogersShippingPage().clkSelectAvailableTime();
	        getRogersShippingPage().clkReserve();
        }
        reporter.reportLogWithScreenshot("Rogers Shipping Page before clicking continue");
        getRogersShippingPage().clkContinue();
        getRogersOrderReviewPage().verifyOrderReviewPageLoadedSuccessfully();
        reporter.reportLogWithScreenshot("Rogers review page");
        getRogersOrderReviewPage().clkTermsAgreementCheckbox();
        getRogersOrderReviewPage().clkShieldAgreementCheckbox();
        getRogersOrderReviewPage().clkUpfrontTermsCheckbox();
        getRogersOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.tc13HUPNonShareNoTerm.getUsername());
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