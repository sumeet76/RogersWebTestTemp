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
 * TC07 - Regression - Rogers AAL - e2e
 * @author rajesh.varalli1
 * //Pending Tobe updated after 27th Jan
 */
public class RogersBFA_TC07_AAL_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","AALBFA"})
	public void rogersAalTest() {
		reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
		reporter.reportLogWithScreenshot("Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc07AAL.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc07AAL.getPassword());
		reporter.reportLogWithScreenshot("Login Page");
		getRogersLoginPage().clkSignInIFrame();
		reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
		reporter.reportLogWithScreenshot("Account Overview page");
		getRogersHomePage().clkShop();
		getRogersHomePage().clkWireless();
		getRogersHomePage().clkViewAllDevices();
		getRogersHomePage().clkAddNow();
		reporter.reportLogWithScreenshot("clicked on Add button and on Add device to a shared plan diologue displayed");
		getRogersHomePage().clkAddDeviceToSharedPlan();
		reporter.hardAssert(getRogersChoosePhonePage().verifyRogersChoosePhonePage(), "Rogers Choose Phone Page loaded properly", "Rogers Choose Phone Page load failed");
		reporter.reportLogWithScreenshot("Rogers Choose Phone page");
		getRogersChoosePhonePage().searchDevice(TestDataHandler.tc07AAL.getNewDevice());
		Boolean proOnTheGoAddressFlag  = getRogersChoosePhonePage().checkProOnTheGoAtAddress(TestDataHandler.tc07AAL.getPostalCode());
		Boolean proOnTheGoFlag = false;
		if(proOnTheGoAddressFlag) {
			proOnTheGoFlag = getRogersChoosePhonePage().checkProOnTheGo();
		}
		getRogersChoosePhonePage().addFirstAvailableDevice();
		getRogersBuildPlanPage().verifyBildPlanPageLoadedSuccessfully();
		reporter.reportLogWithScreenshot("Rogers Build Plan page");
		getRogersBuildPlanPage().selectFirstAvailablePlan();
		getRogersBuildPlanPage().clkContinue();
		getRogersChooseAddonsPage().verifyChooseAddOnsPageLoadedSuccessfully();
		reporter.reportLogWithScreenshot("Rogers Choose Addons page");
		getRogersChooseAddonsPage().clkContinue();
		getRogersCartSummaryPage().verifyCartSummaryPageLoadedSuccessfully();
		reporter.reportLogWithScreenshot("Rogers Cart Summary page");
		getRogersCartSummaryPage().clkContinue();
		reporter.hardAssert(getRogersShippingPage().verifyRogersShippingPage(), "Rogers shipping Page loaded properly", "Rogers shipping Page load failed");
		reporter.reportLogWithScreenshot("Rogers Shipping page");
		getRogersShippingPage().clkRadioBillingAddress();
		if(proOnTheGoFlag) {
	        getRogersShippingPage().setEmailIDAndSave();
	        getRogersShippingPage().setPhoneNumberAndSave();
	        getRogersShippingPage().clkSelectAvailableTime();
	        getRogersShippingPage().clkReserve();
        }
        reporter.reportLogWithScreenshot("Rogers Shipping Page before clicking continue");
		getRogersShippingPage().clkContinue();
		getRogersChooseNumberPage().verifyChooseNumberPageLoadedSuccessfully();
		reporter.reportLogWithScreenshot("Rogers Choose Number page");
		getRogersChooseNumberPage().clkSelectNewNumber();
		getRogersChooseNumberPage().selectCity(TestDataHandler.tc07AAL.getCtnCity());
		getRogersChooseNumberPage().clkFindAvailableNumbers();
		getRogersChooseNumberPage().selectFirstAvailableNumber();
		getRogersChooseNumberPage().clkSave();
		reporter.reportLogWithScreenshot("Rogers Choose Number page clicking continue");
		getRogersChooseNumberPage().clkContinue();
		getRogersOrderReviewPage().verifyOrderReviewPageLoadedSuccessfully();
		reporter.reportLogWithScreenshot("Rogers Order Review page");
		getRogersOrderReviewPage().clkTermsAgreementCheckbox();
		getRogersOrderReviewPage().clkShieldAgreementCheckbox();
		getRogersOrderReviewPage().clkUpfrontTermsCheckbox();
		getRogersOrderReviewPage().selectEmailDigitalCopy(TestDataHandler.tc07AAL.getUsername());
		reporter.reportLogWithScreenshot("Rogers Order Review page before clicking submit");
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
		reporter.reportLogWithScreenshot("Rogers Order Confirmation page");
	}

	@BeforeMethod (alwaysRun = true) @Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}