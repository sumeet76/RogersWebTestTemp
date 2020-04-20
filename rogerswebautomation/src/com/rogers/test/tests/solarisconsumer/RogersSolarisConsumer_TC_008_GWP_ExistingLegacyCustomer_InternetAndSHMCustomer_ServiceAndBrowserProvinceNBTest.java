package com.rogers.test.tests.solarisconsumer;

import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * This class contains the test method to verify the gwp promotion for the legacy customer on Rogers.com  
 * 
 * @author Saurav.Goyal
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
 *12. Verify GWP in the your cart and Click “checkout” button on cart summary page.
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

public class RogersSolarisConsumer_TC_008_GWP_ExistingLegacyCustomer_InternetAndSHMCustomer_ServiceAndBrowserProvinceNBTest extends BaseTestClass {

	@Test
	public void checkCartAbandonNoPortinExistingLegacySignedinfromMyRogersTest() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.solarisConsumerGWPDigitalTV.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisConsumerGWPDigitalTV.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		rogers_account_overview_page.selectAccount(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getBan());
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed"); 
		rogers_home_page.clkShop(); 
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		rogers_home_page.clkIgniteTVExistingCustomer();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		rogers_home_page.clkServiceabilityMigration();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");    
		rogers_home_page.clkUseThisAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		rogers_igniteTV_buy_page.clkChevronSolarisStarterPackageNew();
		Assert.assertTrue(rogers_igniteTV_buy_page.verifyGWPForStarterPackage(), "GWP offer on starter package is not available");
		rogers_igniteTV_buy_page.selectSolarisStarterPackageNew();
		reporter.reportLogWithScreenshot("Launched the information popup");
		rogers_igniteTV_buy_page.verifyImportantInformation();
		rogers_igniteTV_buy_page.clkIUnderstand();
		reporter.reportLogWithScreenshot("Launched the port-in popup");
		rogers_igniteTV_buy_page.clkConfirmActivateLater();
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		rogers_igniteTV_buy_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_igniteTV_buy_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		rogers_igniteTV_buy_page.set4KTV(); 
		rogers_igniteTV_buy_page.clkCheckout();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		rogers_igniteTV_profile_creation_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_igniteTV_profile_creation_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		rogers_igniteTV_profile_creation_page.clkSubmitProfile();   
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		rogers_igniteTV_credit_check_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_igniteTV_credit_check_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		rogers_igniteTV_credit_check_page.verifyCreditEvalutionPage(); 
		rogers_igniteTV_credit_check_page.selectDOBYearExistingCustomer(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getYear());
		rogers_igniteTV_credit_check_page.selectDOBMonthExistingCustomer(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getMonth());
		rogers_igniteTV_credit_check_page.selectDOBDayExistingCustomer(TestDataHandler.solarisConsumerGWPDigitalTV.getAccountDetails().getDate());
		reporter.reportLogWithScreenshot("Entered the DOB details");
		rogers_igniteTV_credit_check_page.clkCreditConsentSubmit();
		reporter.reportLogWithScreenshot("Launched the tech install page");
		rogers_tech_install_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_tech_install_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		rogers_tech_install_page.clkIUnderStand();
		rogers_tech_install_page.clkTechInstallContinue();
		reporter.reportLogWithScreenshot("Launched the payment options page");
		rogers_payment_options_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_payment_options_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		rogers_payment_options_page.clkPaymentConfirmExistingCustomer();		
		rogers_order_review_page.verifyAgreementPage();
		reporter.reportLogWithScreenshot("Launched the order review page");
		rogers_payment_options_page.clkChevronYourCart();
		reporter.reportLogWithScreenshot("Clicked chevron");
		Assert.assertTrue(rogers_payment_options_page.verifyGWPYourCartPromotion(), "GWP promotion on your cart is not available");
		rogers_order_review_page.verifyAgreement();
		rogers_order_review_page.clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		rogers_order_review_page.clkSubmit();
		reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Order has created successfully","Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	//IgniteLogin
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.rogersConfig.getRogersURL(),  strBrowser,strLanguage,strGroupName, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}