package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to verify the 3P legacy to 3P Ignite Flow with DST for Rogers.com
 * 
 * @author manpreet.kaur3
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the TV badge
 *4. Click on Ignite TV under shop drowndown
 *5. Select the Bundles package and Click on Add to cart
 *6. Enter home address to validate the serviceability and click on Check Availability
 *7. Click on Continue.
 *8. Click on 'Yes I understood'button.
 *9. Click "No thanks, Continue".
 *10. Click on Continue.
 *11. Select one option for   'Do you have a 4K TV'.
 *12. Click checkout button on cart summary page.
 *13. All the personal information is autopopulated.
 *14. Click on continue button.
 *15. In Credit Evaluation page, enter the required info on Credit Check:
 *16. Click Submit.
 *17. Enter 1 or 2 numbers in Choose a phone Number textbox and click on Generate numbers.
 *18. Select any one phone number. 
 *19. Make sure Caller ID and Directory listing fields are populated.
 *20. Click on Continue.
 *21. Select a time in Choose your Date and Time. 
 *22. Enter any valid Mobile number and email address.
 *23. Click on Confirm.
 *24. Select Pre-Authorized credit card option from type of payment dropdown.
 *25. Enter valid Credit Card number details in Credit Card related fields.
 *26. Click on Continue.
 *27. Validate appropriate information is displayed in Review order page.
 *28. Scroll down all the way down in Agreement field and select "I have read understood…." checkbox.
 *29. Order confirmation page will be displayed with the order number and validate the order details.
 *
 **/

public class RogersCH_Auto_TC092_3PLeg_3PIgnite_DST_E2E_No4KTest extends BaseTestClass {

    @Test//(groups = {"RegressionCH"})
	public void rogersCH_Auto_TC092_3PLeg_3PIgnite_DST_E2E_No4K() {
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc124_Legacy3pToIgnite3P.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc124_Legacy3pToIgnite3P.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentials");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		reporter.reportLogWithScreenshot("Skip popup");
		getRogersLoginPage().clkSkipIFrame();
		if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
			reporter.reportLogWithScreenshot("Select an account.");
			getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc124_Legacy3pToIgnite3P.getAccountDetails().getBan());
		}
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersHomePage().clkExistingCustomerShop();
		reporter.reportLogWithScreenshot("clicked shop menu from navigation bar to select the Ignite Stream");
		getRogersHomePage().clkSubnavIgniteSmartStream();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		getRogersHomePage().clkGetIgniteTvWithIgniteInternet();
		reporter.reportLogWithScreenshot("Clicked on Get it Now");
		if(getRogersHomePage().verifyNoThanks()) {
			getRogersHomePage().clkNoThnx();
			reporter.reportLogWithScreenshot("Clicked on No Thanks");
			getRogersHomePage().clkServiceability();
		}
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		getRogersHomePage().selectAddressOnFile();
		reporter.reportLogWithScreenshot("Selected Address on file");
		getRogersHomePage().clkUseAddress();
		reporter.reportLogWithScreenshot("Launched the Bundles Page");
		getRogersIgniteTVBuyPage().clkTaketheQuiz();
		reporter.reportLogWithScreenshot("Clicked on Take the Quiz");
		getRogersIgniteTVBuyPage().clkLiveTVChannels();
		getRogersIgniteTVBuyPage().clkLiveSports();
		getRogersIgniteTVBuyPage().clkFlexibleChannels();
		getRogersIgniteTVBuyPage().clkMobileApp();
		reporter.reportLogWithScreenshot("Selected entertainment features");
		getRogersIgniteTVBuyPage().clkDSTContinue();
		reporter.reportLogWithScreenshot("Clicked on DST Continue to next question");
		getRogersIgniteTVBuyPage().clkFourStarsNetworkCategory();
		getRogersIgniteTVBuyPage().clkFourStarsNewsCategory();
		getRogersIgniteTVBuyPage().clkFourStarsEntertainmentCategory();
		getRogersIgniteTVBuyPage().clkFourStarsLifestyleCategory();
		reporter.reportLogWithScreenshot("Rated channel categories according to preference");
		getRogersIgniteTVBuyPage().clkDSTContinue();
		reporter.reportLogWithScreenshot("Clicked on DST Continue to next question");
		getRogersIgniteTVBuyPage().clkInternetDevices();
		reporter.reportLogWithScreenshot("Selected Internet Devices");
		getRogersIgniteTVBuyPage().clkDSTContinue();
		reporter.reportLogWithScreenshot("Clicked on DST Continue to next question");
		getRogersIgniteTVBuyPage().clkAddHomePhoneDST();
		reporter.reportLogWithScreenshot("Added Home Phone");
		getRogersIgniteTVBuyPage().clkDSTContinue();
		reporter.reportLogWithScreenshot("Clicked on DST Continue to next question");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBestFit(),"Best Fit verified" ,"Best Fit not verified");
		getRogersIgniteTVBuyPage().clkDSTClose();
		reporter.reportLogWithScreenshot("Closed the DST Recommendation");
		getRogersIgniteTVBuyPage().VerifyYourBestFit();
		reporter.reportLogWithScreenshot("Recommended pack is displayed");
		getRogersIgniteTVBuyPage().selectFlex10PackageMonthToMonthTypeOfContract();
		reporter.reportLogWithScreenshot("Type of contract selected");
		// get channels
		getRogersIgniteTVBuyPage().clkBestAdd();
		reporter.reportLogWithScreenshot("Launched the information popup");
		getRogersIgniteTVBuyPage().clkIUnderstand();
		reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
		getRogersIgniteTVBuyPage().clkHomePhone();

		reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyCartSummaryHeader(), "Launched the Bundles-cart Summary page", "Cart Summary not verified");
		reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyDisneyImage(), "PSEF verified", "PSEF not verified");
		reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyGWPTag(), "GWP verified", "GWP not verified");
		//Mini Cart get monthly fees
		// verify channels
		getRogersIgniteTVBuyPage().set4KTVNo();
		reporter.reportLogWithScreenshot("No, I don't have a 4k TV selected");

		reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is available","4KTV radio button is not available");
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().clkCheckout();

		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
		reporter.reportLogWithScreenshot("Launched the credit evaluation page");
		getRogersIgniteTVCreditCheckPage().selectDOBYearExistingCustomer(TestDataHandler.tc117_Legacy2PTVToIgnite3P.getAccountDetails().getYear());
		getRogersIgniteTVCreditCheckPage().selectDOBMonthExistingCustomerMigration(TestDataHandler.tc117_Legacy2PTVToIgnite3P.getAccountDetails().getMonth());
		getRogersIgniteTVCreditCheckPage().selectDOBDayExistingCustomerMigration(TestDataHandler.tc117_Legacy2PTVToIgnite3P.getAccountDetails().getDate());
		reporter.reportLogWithScreenshot("Entered the DOB details");
		getRogersIgniteTVCreditCheckPage().selectFirstID("Driver's License");
		getRogersIgniteTVCreditCheckPage().selectProvince("Ontario");
		getRogersIgniteTVCreditCheckPage().selectExpiryYear();
		getRogersIgniteTVCreditCheckPage().selectExpiryMonth();
		getRogersIgniteTVCreditCheckPage().selectExpiryDay();
		getRogersIgniteTVCreditCheckPage().setDrivingLicenseNumber("ONTARIO");
		reporter.reportLogWithScreenshot("Driving License Details");
		getRogersIgniteTVCreditCheckPage().selectSecondIDOption("Passport");
		getRogersIgniteTVCreditCheckPage().setPassportNumber();
		getRogersIgniteTVCreditCheckPage().selectPassportExpiryYear();
		getRogersIgniteTVCreditCheckPage().selectPassportExpiryMonth();
		getRogersIgniteTVCreditCheckPage().selectPassportExpiryDay();
		getRogersIgniteTVCreditCheckPage().clkCreditConsent();
		reporter.reportLogWithScreenshot("Passport Details");
		getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
		reporter.reportLogWithScreenshot("Launched Review Caller Information Page");
		//Validate flowType="AUTL" from continueBuy call, will be adding with selenium4
		getRogersIgniteTVBuyPage().clkReviewCallerContinuebtn();
		reporter.reportLogWithScreenshot("Clicked continue on Review Caller info page");
		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(), "TechInstall page has Launched", "TechInstall page has not Launched");
		reporter.reportLogWithScreenshot("Launched the tech install page");
		getRogersTechInstallPage().clkProInstallUpgradeNo();
		reporter.reportLogWithScreenshot("Click on ProInstallUpgradeYes");
		getRogersTechInstallPage().clkTechContinue();

		reporter.hardAssert(getRogersPaymentOptionsPage().verifyPaymentModepage(), "Payment Mode page has Launched", "Payment Mode page has not Launched");
		reporter.reportLogWithScreenshot("Launched the payment options page");
		//getRogersPaymentOptionsPage().selectPaymentMode("Monthly Bill");
		getRogersPaymentOptionsPage().selectPaymentMode("Pre-authorized Credit Card");
		getRogersPaymentOptionsPage().switchToCreditCardIFrame();
		getRogersPaymentOptionsPage().setCreditCardNumberIFrame(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
		getRogersPaymentOptionsPage().switchOutOfCreditCardIFrame();
		getRogersPaymentOptionsPage().setCVV();
		getRogersPaymentOptionsPage().selectExpiryMonth();
		getRogersPaymentOptionsPage().selectExpiryYear();
		reporter.reportLogWithScreenshot("Payment options Details");
		getRogersPaymentOptionsPage().clkPaymentConfirm();

		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(), "Agreement page has Launched", "Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");
		reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyDisneyImage(), "PSEF verified", "PSEF not verified");
		reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyGWPTag(), "GWP verified", "GWP not verified");
		// validate monthly fees
		reporter.hardAssert( getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");

		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(), "Order has created successfully", "Order has failed");

    	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws  IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_ignitelogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	 @AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}