package com.rogers.test.tests.connectedhome.desktop.legacy;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to verify the upgarde flow for Legacy TV to IgniteTV for Rogers.com  
 * 
 * @author chinnarao.vattam
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
 *9. Click "No thanks Continue".
 *10. Click on Continue.
 *11. Select one option for   'Do you have a 4K TV'.
 *12. Click checkout button on cart summary page.
 *13. All the personal information is auto populated.
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
 *28. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox.
 *29. Order confirmation page will be displayed with the order number and validate the order details.
 *
 **/

public class RogersCH_Auto_TC031_LegacyTV_TVPackageUpgradeToIgniteBundleFromShopOptionTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersCustomerIgniteBuyCH"})
	public void rogersCH_Auto_TC031_LegacyTV_TVPackageUpgradeToIgniteBundleFromShopOption() {

		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc31_DigitalTVUpgradeToIgnite.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc31_DigitalTVUpgradeToIgnite.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentials");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc31_DigitalTVUpgradeToIgnite.accountDetails.getBan());
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersHomePage().clkExistingCustomerShop();
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		getRogersHomePage().clkSubnavIgniteSmartStream();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		getRogersHomePage().clkGetIgniteTvWithIgniteInternet();
//		getDriver().get(System.getProperty("QaUrl")+"/bundles");
//		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
//		getRogersHomePage().clkNoThnx();
//		getRogersHomePage().clkServiceability();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		getRogersHomePage().selectAddressOnFile();
		getRogersHomePage().clkUseAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(), "Bundles Page has launched", "Bundles Page has not launched");
		// getRogersIgniteTVBuyPage().selectStarterPackageMonthToMonthTypeOfContact();
		// reporter.reportLogWithScreenshot("Starter package selected");
		// getRogersIgniteTVBuyPage().selectSolarisStarterPackage();
		//getRogersIgniteTVBuyPage().selectFlex20PackageMonthToMonthTypeOfContract();
		getRogersIgniteTVBuyPage().selectFlex20Package();
		reporter.reportLogWithScreenshot("Flex20+ Added to cart");
		reporter.reportLogWithScreenshot("Launched the information popup");
		getRogersIgniteTVBuyPage().clkIUnderstand();
		reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(), "4KTV radio button is availabe", "4KTV radio button is not availabe");
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().set4KTVNo();
		reporter.reportLogWithScreenshot("4k TV selected");
		getRogersIgniteTVBuyPage().clkCheckout();
		reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(), "Profile page has Launched", "Profile page has not Launched");
		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersIgniteTVProfileCreationPage().clkSubmitProfile();

		reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(), "Credit Evalution page has Launched", "Credit Evalution page has not Launched");
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		getRogersIgniteTVCreditCheckPage().selectDOBYear();
		getRogersIgniteTVCreditCheckPage().selectDOBMonth();
		getRogersIgniteTVCreditCheckPage().selectDOBDay();
		reporter.reportLogWithScreenshot("Entered DOB details");
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

		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(), "TechInstall page has Launched", "TechInstall page has not Launched");
		reporter.reportLogWithScreenshot("Launched the tech install page");
		//getRogersTechInstallPage().clkTechInstalConsent();
		getRogersTechInstallPage().clkProInstallUpgradeNo();
		reporter.reportLogWithScreenshot("tech install details");
		getRogersTechInstallPage().clkTechInstallContinueSelf();
		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallSetUp(), "SetUp page has Launched", "SetUp page has not Launched");
		getRogersTechInstallPage().clkTechInstallContinue();

		reporter.hardAssert(getRogersPaymentOptionsPage().verifyPaymentModepage(), "Payment Mode page has Launched", "Payment Mode page has not Launched");
		reporter.reportLogWithScreenshot("Launched the payment options page");
		getRogersPaymentOptionsPage().clkPaymentConfirm();

		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(), "Agreement page has Launched", "Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");

		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(), "Agreement has Launched", "Agreement has not Launched");
		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(), "Order has created successfully", "Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws  IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_legacylogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}