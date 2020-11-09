package com.rogers.test.tests.solarisconsumer;

import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;             
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;

/**
 * This class contains the test method to verify the gwp promotion for the legacy DTV and SHM customer on Rogers.com  
 * 
 * @author Saurav.Goyal
 *
 *Important Points:-
 *After logging into the ciam application , user has been navigated to below brt link
 *"https://ecidbrt:ecidbrt@qa02-ciam.rogers.com/web/brt-consumer/ignite-bundles/get-iptv" Which we need to edit once one application is ready
 *
 **/

public class RogersSC_TC_003_GWP_ExistingLegacyCustomer_SHMDTVCustomer_SameServiceAndBrowserProvinceAddressTest extends BaseTestClass {

	@Test @Parameters({"strLanguage"})
	public void gwpTestDtvShm(String strLanguage) {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.solarisConsumerGWPShmDtv.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.solarisConsumerGWPShmDtv.getPassword());
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
			getRogersIgniteTVBuyPage().clkChevronForBundle(TestDataHandler.solarisConsumerGWPShmDtv.getAccountDetails().getBundelPackageNameFr());
			Assert.assertTrue(getRogersIgniteTVBuyPage().verifyGWPForStarterPackage(TestDataHandler.solarisConsumerGWPShmDtv.getAccountDetails().getBundelPackageNameFr()), "GWP offer on starter package is not available");
			reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
			getRogersIgniteTVBuyPage().selectSolarisBundlePackage(TestDataHandler.solarisConsumerGWPShmDtv.getAccountDetails().getBundelPackageNameFr());
		}
		else {
			getRogersIgniteTVBuyPage().clkChevronForBundle(TestDataHandler.solarisConsumerGWPShmDtv.getAccountDetails().getBundelPackageNameEn());
			Assert.assertTrue(getRogersIgniteTVBuyPage().verifyGWPForStarterPackage(TestDataHandler.solarisConsumerGWPShmDtv.getAccountDetails().getBundelPackageNameEn()), "GWP offer on starter package is not available");
			reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
			getRogersIgniteTVBuyPage().selectSolarisBundlePackage(TestDataHandler.solarisConsumerGWPShmDtv.getAccountDetails().getBundelPackageNameEn());
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
		getRogersIgniteTVCreditCheckPage().selectDOBYearExistingCustomer(TestDataHandler.solarisConsumerGWPShmDtv.getAccountDetails().getYear());
		getRogersIgniteTVCreditCheckPage().selectDOBMonthExistingCustomer(TestDataHandler.solarisConsumerGWPShmDtv.getAccountDetails().getMonth());
		getRogersIgniteTVCreditCheckPage().selectDOBDayExistingCustomer(TestDataHandler.solarisConsumerGWPShmDtv.getAccountDetails().getDate());
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