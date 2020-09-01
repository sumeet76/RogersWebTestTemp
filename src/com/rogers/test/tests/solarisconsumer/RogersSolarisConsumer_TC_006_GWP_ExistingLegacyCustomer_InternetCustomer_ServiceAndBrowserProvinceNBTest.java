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

public class RogersSolarisConsumer_TC_006_GWP_ExistingLegacyCustomer_InternetCustomer_ServiceAndBrowserProvinceNBTest extends BaseTestClass {

	@Test @Parameters({"strLanguage"})
	public void checkGWPLegacyInternetTest(String strLanguage) {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.solarisConsumerGWPLegacyInternet.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisConsumerGWPLegacyInternet.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed"); 
		rogers_home_page.clkShop(); 
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		rogers_home_page.clkIgniteTVExistingCustomer();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		//rogers_home_page.clkNoThnx();
		
		rogers_home_page.clkServiceabilityMigration(); 
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability"); 
		rogers_home_page.clkUseThisAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		
		//Have to remove below navigation once actual flow will work properly
		getDriver().get("https://ecidbrt:ecidbrt@qa02-ciam.rogers.com/web/brt-consumer/ignite-bundles/get-iptv");
		//rogers_home_page.clkNoThanks();
		
		if(strLanguage.equalsIgnoreCase("fr")) {
			rogers_igniteTV_buy_page.clkChevronForBundle(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getBundelPackageNameFr());
			Assert.assertTrue(rogers_igniteTV_buy_page.verifyGWPForStarterPackage(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getBundelPackageNameFr()), "GWP offer on starter package is not available");
			reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
			rogers_igniteTV_buy_page.selectSolarisBundlePackage(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getBundelPackageNameFr());
		}
		else {
			rogers_igniteTV_buy_page.clkChevronForBundle(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getBundelPackageNameEn());
			Assert.assertTrue(rogers_igniteTV_buy_page.verifyGWPForStarterPackage(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getBundelPackageNameEn()), "GWP offer on starter package is not available");
			reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
			rogers_igniteTV_buy_page.selectSolarisBundlePackage(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getBundelPackageNameEn());
		}
		
		//rogers_igniteTV_buy_page.clkChevronForBundle("Ignite Flex 5");
		reporter.reportLogWithScreenshot("Launched the information popup");
		
		//rogers_igniteTV_buy_page.verifyImportantInformation();
		//rogers_igniteTV_buy_page.clkIUnderstand();
		
		 rogers_igniteTV_buy_page.verifyOptNewPhone();
	        reporter.reportLogWithScreenshot("Launched the port-in popup");
	        rogers_igniteTV_buy_page.selectOptNewPhone();
	        rogers_igniteTV_buy_page.clickOptPhone();
	
	        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
	        rogers_igniteTV_buy_page.clkHomePhone();
	        rogers_igniteTV_buy_page.verify4KTV();
	        
		reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
		rogers_igniteTV_buy_page.clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_igniteTV_buy_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_igniteTV_buy_page.clkChevronUpYourCart();
 		rogers_igniteTV_buy_page.clkHomePhone();
 		
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		rogers_igniteTV_buy_page.clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_igniteTV_buy_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_igniteTV_buy_page.clkChevronUpYourCart();
		rogers_igniteTV_buy_page.set4KTV(); 
		rogers_igniteTV_buy_page.clkCheckout();
		rogers_igniteTV_profile_creation_page.verifyProfilePage();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		rogers_igniteTV_profile_creation_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_igniteTV_profile_creation_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_igniteTV_profile_creation_page.clkChevronYourCart();
		rogers_igniteTV_profile_creation_page.clkSubmitProfile(); 
		rogers_igniteTV_credit_check_page.verifyCreditEvalutionPage();
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		rogers_igniteTV_credit_check_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_igniteTV_credit_check_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_igniteTV_credit_check_page.clkChevronYourCart();
		rogers_igniteTV_credit_check_page.selectDOBYearExistingCustomer(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getYear());
		rogers_igniteTV_credit_check_page.selectDOBMonthExistingCustomer(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getMonth());
		rogers_igniteTV_credit_check_page.selectDOBDayExistingCustomer(TestDataHandler.solarisConsumerGWPLegacyInternet.getAccountDetails().getDate());
		reporter.reportLogWithScreenshot("Entered the DOB details");
		rogers_igniteTV_credit_check_page.clkCreditConsentSubmit();
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		rogers_home_phone_selection_page.verifyPhoneNumberPage();
		rogers_home_phone_selection_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_home_phone_selection_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_home_phone_selection_page.clkChevronYourCart();
		rogers_home_phone_selection_page.clkContinueHomePhoneSelection();
		rogers_tech_install_page.verifyTechInstallCalendar();		
		reporter.reportLogWithScreenshot("Launched the tech install page");
		rogers_tech_install_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_tech_install_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_payment_options_page.clkChevronYourCart();
		rogers_tech_install_page.selTechInstalStartDate();
		rogers_tech_install_page.selTechInstalEndDate();
		rogers_tech_install_page.setEmail();
		rogers_tech_install_page.clkTechInstallContinue();
		rogers_payment_options_page.verifyPaymentModepageMigration();
		reporter.reportLogWithScreenshot("Launched the payment options page");
		rogers_payment_options_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_payment_options_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_payment_options_page.clkChevronYourCart();
		rogers_payment_options_page.clkPaymentConfirmExistingCustomer();		
		rogers_order_review_page.verifyAgreementPage();
		reporter.reportLogWithScreenshot("Launched the order review page");
		rogers_order_review_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_order_review_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		reporter.reportLogWithScreenshot("GWP promotion verified successfully in the cart");
		rogers_order_review_page.verifyAgreement();
		rogers_order_review_page.clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		rogers_order_review_page.clkSubmit();
		reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Order has created successfully","Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
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