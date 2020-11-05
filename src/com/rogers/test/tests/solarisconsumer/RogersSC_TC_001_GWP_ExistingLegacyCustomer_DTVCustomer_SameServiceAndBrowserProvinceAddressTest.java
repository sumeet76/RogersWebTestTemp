package com.rogers.test.tests.solarisconsumer;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to verify the gwp promotion for the legacy DTV customer on Rogers.com  
 * 
 * @author Saurav.Goyal
 *
 *Important Points:-
 *After logging into the ciam application , user has been navigated to below brt link
 *"https://ecidbrt:ecidbrt@qa02-ciam.rogers.com/web/brt-consumer/ignite-bundles/get-iptv" Which we need to edit once one application is ready
 *
 **/

public class RogersSC_TC_001_GWP_ExistingLegacyCustomer_DTVCustomer_SameServiceAndBrowserProvinceAddressTest extends BaseTestClass {

	@Test @Parameters({"strLanguage"})
	public void gwpTestDtvCustomer(String strLanguage) {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.solarisConsumerGWPDigitalTV.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.solarisConsumerGWPDigitalTV.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		reporter.softAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Login Success","Login Failed");
		getRogersHomePage().clkShop();
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		getRogersHomePage().clkIgniteTVExistingCustomer();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability"); 
		getRogersHomePage().clkUseThisAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		//Have to remove below navigation once actual flow will work properly
		getDriver().get("https://ecidbrt:ecidbrt@qa02-ciam.rogers.com/web/brt-consumer/ignite-bundles/get-iptv");
		//getRogersHomePage().clkUseThisAddress();
		//getRogersHomePage().clkNoThanks();
		if(strLanguage.equalsIgnoreCase("fr")) {
			getRogersIgniteTVBuyPage().clkChevronForBundle(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getBundelPackageNameFr());
			Assert.assertTrue(getRogersIgniteTVBuyPage().verifyGWPForStarterPackage(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getBundelPackageNameFr()), "GWP offer on starter package is not available");
			reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
			getRogersIgniteTVBuyPage().selectSolarisBundlePackage(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getBundelPackageNameFr());
		}
		else {
			getRogersIgniteTVBuyPage().clkChevronForBundle(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getBundelPackageNameEn());
			Assert.assertTrue(getRogersIgniteTVBuyPage().verifyGWPForStarterPackage(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getBundelPackageNameEn()), "GWP offer on starter package is not available");
			reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
			getRogersIgniteTVBuyPage().selectSolarisBundlePackage(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getBundelPackageNameEn());
		}
		//getRogersIgniteTVBuyPage().clkChevronForBundle("Ignite Flex 5");
		reporter.reportLogWithScreenshot("Launched the information popup");
		getRogersIgniteTVBuyPage().verifyImportantInformation();
		getRogersIgniteTVBuyPage().clkIUnderstand();
		reporter.reportLogWithScreenshot("Launched the port-in popup");
		getRogersIgniteTVBuyPage().clickOptPhone();
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(getRogersIgniteTVBuyPage().verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		getRogersIgniteTVBuyPage().clkChevronUpYourCart();
		getRogersIgniteTVBuyPage().set4KTV();
		getRogersIgniteTVBuyPage().clkCheckout();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersIgniteTVProfileCreationPage().clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(getRogersIgniteTVProfileCreationPage().verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		getRogersIgniteTVProfileCreationPage().clkChevronYourCart();
		getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
		getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage();
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		getRogersIgniteTVCreditCheckPage().clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(getRogersIgniteTVCreditCheckPage().verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		getRogersIgniteTVCreditCheckPage().clkChevronYourCart();
		getRogersIgniteTVCreditCheckPage().selectDOBYearExistingCustomer(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getYear());
		getRogersIgniteTVCreditCheckPage().selectDOBMonthExistingCustomer(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getMonth());
		getRogersIgniteTVCreditCheckPage().selectDOBDayExistingCustomer(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getDate());
		reporter.reportLogWithScreenshot("Entered the DOB details");
		getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
		reporter.reportLogWithScreenshot("Launched the tech install page");
		getRogersTechInstallPage().clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(getRogersTechInstallPage().verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		getRogersTechInstallPage().clkIUnderStand();
		//getRogersTechInstallPage().clkChevronYourCart();
		getRogersTechInstallPage().clkTechInstallContinue();
		reporter.reportLogWithScreenshot("Launched the payment options page");
		//getRogersPaymentOptionsPage().clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(getRogersPaymentOptionsPage().verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		getRogersPaymentOptionsPage().clkChevronYourCart();
		getRogersPaymentOptionsPage().clkPaymentConfirmExistingCustomer();		
		getRogersOrderReviewPage().verifyAgreementPage();
		reporter.reportLogWithScreenshot("Launched the order review page");
		getRogersOrderReviewPage().clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(getRogersOrderReviewPage().verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		getRogersOrderReviewPage().verifyAgreement();
		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Order has created successfully","Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,strGroupName, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}