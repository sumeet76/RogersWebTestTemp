package com.rogers.test.tests.solarisconsumer;

import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;

import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;     
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;

/**
 * This class contains the test method to verify the cart abandon flow with no port-In option for existing legacy customer on Rogers.com
 * 
 * @author Saurav.Goyal
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the TV badge
 *4. Click on Ignite TV under shop drowndown
 *5. Enter home address to validate the serviceability and click on this address
 *6. Select the Bundles package and Click on Add to cart
 *7. Click on 'Yes I understood'button.
 *8. Click "No thanks Continue".
 *9. Click on new number options and click on Continue. 
 *10. Verify cart summary page
 *11. Select one option for   'Do you have a 4K TV'.
 *12. Click checkout button on cart summary page.
 *13. All the personal information is auto populated.
 *14. Click on continue button.
 *15. In Credit Evaluation page, enter the required info on Credit Check:
 *16. Click MyRogers and make the cart abandoned.
 *17. Login again in the application and repeat step 2,3,4 and verify welcome back and continue with same order
 *18. User will be on the cart summary page and click continue
 *19. User will be on the profile page and click continue
 *20. User will be on the credit evaluation page. Enter the required info and click continue.
 *21. User is on the tech install page and click i understand radio button
 *22. Click on Confirm.
 *23. verify user is on the payment page and Click Continue.
 *24. Validate appropriate information is displayed in Review order page 
 *25. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox.
 *26. Order confirmation page will be displayed with the order number and validate the order details.
 **/

public class RogersSC_TC_003_ExistingLegacyCustomer_NoPortin_CartAbandonTest extends BaseTestClass {

	@Test
	public void checkCartAbandonNoPortinExistingLegacySignedinfromMyRogersTest() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.solarisConsumerNoPortinCartAbandon.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisConsumerNoPortinCartAbandon.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		rogers_account_overview_page.selectAccount(TestDataHandler.solarisConsumerNoPortinCartAbandon.getAccountDetails().getBan());
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed"); 
		rogers_home_page.clkShop(); 
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		rogers_home_page.clkIgniteTVExistingCustomer();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		rogers_home_page.clkServiceabilityMigration();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");    
		rogers_home_page.clkUseThisAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		rogers_igniteTV_buy_page.selectSolarisStarterPackageNew();
		reporter.reportLogWithScreenshot("Launched the information popup");
		rogers_igniteTV_buy_page.verifyImportantInformation();
		rogers_igniteTV_buy_page.clkIUnderstand();
		reporter.reportLogWithScreenshot("Launched the port-in popup");
		rogers_igniteTV_buy_page.selectOptNewPhone();
		rogers_igniteTV_buy_page.clickOptPhone();
		reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
		rogers_igniteTV_buy_page.clkHomePhone();
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		rogers_igniteTV_buy_page.set4KTV(); 
		rogers_igniteTV_buy_page.clkCheckout();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		rogers_igniteTV_profile_creation_page.clkSubmitProfile();   
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		rogers_igniteTV_credit_check_page.verifyCreditEvalutionPage();
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		rogers_home_page.clkMyRogers(); 
		reporter.reportLogWithScreenshot("Launched the Cart Abandonment Form popup");
		rogers_igniteTV_credit_check_page.verifyCartAbandonmentForm();
		rogers_igniteTV_credit_check_page.clkCartAbandonmentForm();
		reporter.reportLogWithScreenshot("Launched the Email sent success popup");
		rogers_igniteTV_credit_check_page.verifyCartEmailSuccess();
		rogers_igniteTV_credit_check_page.clkCartEmailSuccess();
		reporter.reportLogWithScreenshot("Signout account");
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisConsumerNoPortinCartAbandon.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		rogers_account_overview_page.selectAccount(TestDataHandler.solarisConsumerNoPortinCartAbandon.getAccountDetails().getBan());
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed"); 
		rogers_home_page.clkShop(); 
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		rogers_home_page.clkIgniteTV();
		reporter.reportLogWithScreenshot("Launched the Welcome back popup");
		rogers_home_page.clkWelcomeback();     
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		rogers_igniteTV_buy_page.clkCheckout();
		reporter.reportLogWithScreenshot("Launched the information popup");
		rogers_igniteTV_profile_creation_page.verifyImportantInformation();
		rogers_igniteTV_profile_creation_page.clkIUnderstand();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		rogers_igniteTV_profile_creation_page.clkSubmitProfile();   
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		rogers_igniteTV_credit_check_page.selectDOBYearExistingCustomer(TestDataHandler.solarisConsumerNoPortinCartAbandon.getAccountDetails().getYear());
		rogers_igniteTV_credit_check_page.selectDOBMonthExistingCustomer(TestDataHandler.solarisConsumerNoPortinCartAbandon.getAccountDetails().getMonth());
		rogers_igniteTV_credit_check_page.selectDOBDayExistingCustomer(TestDataHandler.solarisConsumerNoPortinCartAbandon.getAccountDetails().getDate());
		reporter.reportLogWithScreenshot("Entered the DOB details");
		rogers_igniteTV_credit_check_page.clkCreditConsentSubmit();
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		rogers_home_phone_selection_page.clkContinueHomePhoneSelection();  
		reporter.reportLogWithScreenshot("Launched the tech install page");
		rogers_tech_install_page.selTechInstalStartDate();
		rogers_tech_install_page.selTechInstalEndDate();
		rogers_tech_install_page.setEmail();
		rogers_tech_install_page.clkTechInstallContinue();
		reporter.reportLogWithScreenshot("Launched the payment options page");
		rogers_payment_options_page.clkPaymentConfirmExistingCustomer();
		rogers_order_review_page.verifyAgreementPage();
		reporter.reportLogWithScreenshot("Launched the order review page");
		rogers_order_review_page.verifyAgreement();
		rogers_order_review_page.clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		rogers_order_review_page.clkSubmit();
		reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Order has created successfully","Order has failed");
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