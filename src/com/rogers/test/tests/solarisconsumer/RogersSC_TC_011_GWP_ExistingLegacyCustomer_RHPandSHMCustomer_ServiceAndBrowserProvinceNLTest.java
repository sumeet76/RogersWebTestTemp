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
 * This class contains the test method to verify the gwp promotion for the legacy customer on Rogers.com  
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the TV badge
 *4. Click on Ignite TV under shop drowndown
 *5. Click on serviceability and click this address
 *6. Select the Bundles package and Click on Add to cart
 *7. Click on Continue.
 *8. Click on 'Yes I understood'button.
 *9. Click "No thanks Continue".
 *10. Verify GWP offer for the starter bundel and Click on Continue.
 *11. Select one option for   'Do you have a 4K TV'.
 *12. Verify GWP in the your cart and Click checkout button on cart summary page.
 *13. All the personal information is auto populated.
 *14. Verify GWP in the your cart and Click on continue button.
 *15. In Credit Evaluation page, enter the required info on Credit Check:
 *16. Verify GWP in the your cart and Click Submit.
 *17. In the tech install page, enter the required info on Credit Check:
 *18. Verify GWP in the your cart and click i understand radio button 
 *19. Click on Confirm.
 *20. verify user is on the payment page
 *21. Verify GWP in the your cart and Click Continue.
 *22. Validate appropriate information is displayed in Review order page. and also verify GWP in the your cart 
 *23. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox.
 *24. Order confirmation page will be displayed with the order number and validate the order details.
 *
 **/

public class RogersSC_TC_011_GWP_ExistingLegacyCustomer_RHPandSHMCustomer_ServiceAndBrowserProvinceNLTest extends BaseTestClass {

	@Test @Parameters({"strLanguage"})
	public void checkGWPRhpShmTest(String strLanguage) {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.solarisConsumerGWPLegacyInternet.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.solarisConsumerGWPLegacyInternet.getPassword());
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
		//getRogersHomePage().clkNoThnx();
		
		getRogersHomePage().clkServiceabilityMigration();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability"); 
		getRogersHomePage().clkUseThisAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		
		//Have to remove below navigation once actual flow will work properly
		getDriver().get("https://ecidbrt:ecidbrt@qa02-ciam.rogers.com/web/brt-consumer/ignite-bundles/get-iptv");
		//getRogersHomePage().clkNoThanks();
		
		if(strLanguage.equalsIgnoreCase("fr")) {
			getRogersIgniteTVBuyPage().clkChevronForBundle(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getBundelPackageNameFr());
			Assert.assertTrue(getRogersIgniteTVBuyPage().verifyGWPForStarterPackage(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getBundelPackageNameFr()), "GWP offer on starter package is not available");
			reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
			getRogersIgniteTVBuyPage().selectSolarisBundlePackage(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getBundelPackageNameFr());
		}
		else {
			getRogersIgniteTVBuyPage().clkChevronForBundle(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getBundelPackageNameEn());
			Assert.assertTrue(getRogersIgniteTVBuyPage().verifyGWPForStarterPackage(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getBundelPackageNameEn()), "GWP offer on starter package is not available");
			reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
			getRogersIgniteTVBuyPage().selectSolarisBundlePackage(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getBundelPackageNameEn());
		}
		
		//getRogersIgniteTVBuyPage().clkChevronForBundle("Ignite Flex 5");
		reporter.reportLogWithScreenshot("Launched the information popup");
		
		//getRogersIgniteTVBuyPage().verifyImportantInformation();
		//getRogersIgniteTVBuyPage().clkIUnderstand();
		
		 getRogersIgniteTVBuyPage().verifyOptNewPhone();
	        reporter.reportLogWithScreenshot("Launched the port-in popup");
	        getRogersIgniteTVBuyPage().selectOptNewPhone();
	        getRogersIgniteTVBuyPage().clickOptPhone();
	
	        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
	        getRogersIgniteTVBuyPage().clkHomePhone();
	        getRogersIgniteTVBuyPage().verify4KTV();
	        
		reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
		getRogersIgniteTVBuyPage().clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(getRogersIgniteTVBuyPage().verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		getRogersIgniteTVBuyPage().clkChevronUpYourCart();
 		getRogersIgniteTVBuyPage().clkHomePhone();
 		
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(getRogersIgniteTVBuyPage().verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		getRogersIgniteTVBuyPage().clkChevronUpYourCart();
		getRogersIgniteTVBuyPage().set4KTV();
		getRogersIgniteTVBuyPage().clkCheckout();
		getRogersIgniteTVProfileCreationPage().verifyProfilePage();
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
		getRogersIgniteTVCreditCheckPage().selectDOBYearExistingCustomer(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getYear());
		getRogersIgniteTVCreditCheckPage().selectDOBMonthExistingCustomer(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getMonth());
		getRogersIgniteTVCreditCheckPage().selectDOBDayExistingCustomer(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getDate());
		reporter.reportLogWithScreenshot("Entered the DOB details");
		getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		getRogersHomePhoneSelectionPage().verifyPhoneNumberPage();
		getRogersHomePhoneSelectionPage().clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(getRogersHomePhoneSelectionPage().verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		getRogersHomePhoneSelectionPage().clkChevronYourCart();
		getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();
		getRogersTechInstallPage().verifyTechInstallCalendar();
		reporter.reportLogWithScreenshot("Launched the tech install page");
		getRogersTechInstallPage().clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(getRogersTechInstallPage().verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		getRogersPaymentOptionsPage().clkChevronYourCart();
		getRogersTechInstallPage().selTechInstalStartDate();
		getRogersTechInstallPage().selTechInstalEndDate();
		getRogersTechInstallPage().setEmail();
		getRogersTechInstallPage().clkTechInstallContinue();
		getRogersPaymentOptionsPage().verifyPaymentModepageMigration();
		reporter.reportLogWithScreenshot("Launched the payment options page");
		getRogersPaymentOptionsPage().clkChevronYourCart();
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