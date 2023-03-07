package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the SAI+ISS cart abandon flow for Rogers.com
 * TC027_CH-12141_CH-17639_Anonymous Cx_Ignite SAI+ISS_M2M_Validate PSEF is configured for the package_
 * Abandon Cart from Profile page_In the SAME tab without clearing Cache_WelcomeBack modal displayed_Click Continue E2E_FF_ON_FR
 * @author manpreet.kaur3
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Browse to Shop menu and select Internet option
 *3. click on Check Availability and enter home address to validate the serviceability
 *4. Select SS and select one of available packages, click Add to Cart
 *4. Validate PSEF on cart summary page
 *5. Click MyRogers to abandon cart
 *6. Verify email modal and enter required details
 *7. Verify Confirmation modal and click okay
 *8. Re-execute the flow to validate welcome back modal
 *9. Click continue on Welcome back modal to navigate directly to cart summary page.
 *10. Validate minicart
 *11. Click continue to Profile page and Enter all personal information on user profile creation page - 1) Profile step
 *12. Click on Continue
 *13. In 2) Credit Evaluation page, enter the required info on Credit Check:
 *14. Click Submit
 *15. Verify Tech Install Page
 *16. Choose NO professiobal installation and continue
 *17. Select Pre-Authorized credit card option from type of payment dropdown
 *18. Enter valid Credit Card number details in Credit Card related fields
 *19. Click on Continue
 *20. Validate appropriate information is displayed in Review order page
 *21. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *22. Click on Submit
 *23. Validate order confirmation page
 *
 **/

public class RogersCH_Auto_TC103_ISS_NAC_PSEFpromotion_CartAbandon_ValidateWelcomeBackModalWhenCxRetrievesCartTest extends BaseTestClass {

	@Test
    public void rogersCH_Auto_TC103_ISS_NAC_PSEFpromotion_CartAbandon_ValidateWelcomeBackModalWhenCxRetrievesCart() {
        reporter.reportLogWithScreenshot("Launched the main QA page");
        getDriver().get(System.getProperty("QaUrl")+"/internet");
        reporter.hardAssert(getRogersHomePage().verifyInternetpage(),"Internet page has Launched","Internet page has not Launched");
        getRogersHomePage().clkInternetAvailability();
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        reporter.reportLogWithScreenshot("Address entered for serviceability");
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyInternetPackagesPage(),"Packages page has Launched","Packages page has not Launched");
        getDriver().get(System.getProperty("QaUrl")+"/streaming");
        getRogersInternetPackageSelectionPage().clkSmartStreamAvailability();
        reporter.reportLogWithScreenshot("Click SS Availability");
        getRogersInternetPackageSelectionPage().selectSmartStreamPkgMonthToMonthTypeOfContact();
        reporter.reportLogWithScreenshot("Selected Month-to-month type of contract");
        String pkgPrice = getRogersInternetPackageSelectionPage().get150SSPkgPrice();
        getRogersInternetPackageSelectionPage().verifyISSBoxChecked("Ignite 150 Ultd");
        getRogersInternetPackageSelectionPage().clkSmartStreamPackage();
        reporter.reportLogWithScreenshot("Add to cart Smart Stream Package");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyCartSummaryHeader(), "Launched the Internet-cart Summary page", "Cart Summary not verified");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyDisneyImage(), "PSEF verified", "PSEF not verified");
        getRogersIgniteTVBuyPage().clickMyRogers();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyEmailModal(),"Email Modal is available","EmailModal is not available");
        getRogersIgniteTVBuyPage().setFirstname();
        getRogersIgniteTVBuyPage().setLastName();
        getRogersIgniteTVBuyPage().setEmail();
        getRogersIgniteTVBuyPage().setPhone();
        getRogersIgniteTVBuyPage().clickEmailCheckbox();
        reporter.reportLogWithScreenshot("Entered the details on Email Modal");
        getRogersIgniteTVBuyPage().clickSubmit();
        reporter.reportLogWithScreenshot("Submit the details on Email Modal");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyConfirmation(),"Confirmation Modal is available","Confirmation Modal is not available");
        getRogersIgniteTVBuyPage().clickOkay();
        reporter.reportLogWithScreenshot("Restart the flow without clearing cache, to validate Welcome Modal");
        getDriver().get(System.getProperty("QaUrl")+"/internet");
        reporter.reportLogWithScreenshot("Launched the Internet Page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyWelcomeBackPopup(),"Welcome Modal has Launched","Welcome Modal has not Launched");
        getRogersIgniteTVBuyPage().clickContinue();
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyCartSummaryHeader(), "Launched the Internet-cart Summary page", "Cart Summary not verified");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyDisneyImage(), "PSEF verified", "PSEF not verified");
        getRogersIgniteTVBuyPage().clkChevronDownYourCart();
        reporter.reportLogWithScreenshot("Launched the mini cart Chevron");
        reporter.hardAssert(getRogersIgniteTVBuyPage().isPriceCorrectMiniCart(pkgPrice), "Price match with selected package price at offers page","Price mismatch with selected package price at offers page");
        getRogersIgniteTVBuyPage().clkChevronUpYourCart();

        getRogersInternetPackageSelectionPage().clkInternetBuyContinue();
        reporter.reportLogWithScreenshot("Continue to profile page");
        reporter.hardAssert(getRogersInternetProfilePage().verifyProfilePageSAI(),"Profile page has Launched","Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersInternetProfilePage().setEmail();
        getRogersInternetProfilePage().setFirstname();
        getRogersInternetProfilePage().setLastName();
        getRogersInternetProfilePage().setPhone();
        getRogersInternetProfilePage().clkSubmitProfile();

        reporter.hardAssert(getRogersInternetCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evaluation page has Launched","Credit Evaluation page has not Launched");
        getRogersInternetCreditCheckPage().selectDOBYear();
        getRogersInternetCreditCheckPage().selectDOBMonth();
        getRogersInternetCreditCheckPage().selectDOBDay();
        reporter.reportLogWithScreenshot("Entered DOB details");
        getRogersInternetCreditCheckPage().selectFirstID("Driver's License");
        getRogersInternetCreditCheckPage().selectProvince("Ontario");
        getRogersInternetCreditCheckPage().selectExpiryYear();
        getRogersInternetCreditCheckPage().selectExpiryMonth();
        getRogersInternetCreditCheckPage().selectExpiryDay();
        getRogersInternetCreditCheckPage().setDrivingLicenseNumber("ONTARIO");
        reporter.reportLogWithScreenshot("Driving License Details");
        getRogersInternetCreditCheckPage().selectSecondIDOption("Passport");
        getRogersInternetCreditCheckPage().setPassportNumber();
        getRogersInternetCreditCheckPage().selectPassportExpiryYear();
        getRogersInternetCreditCheckPage().selectPassportExpiryMonth();
        getRogersInternetCreditCheckPage().selectPassportExpiryDay();
        getRogersInternetCreditCheckPage().clkCreditConsentSai();
        reporter.reportLogWithScreenshot("Passport Details");
        getRogersInternetCreditCheckPage().clkCreditConsentSubmit();

        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Launched the tech install page");
        getRogersTechInstallPage().clkProInstallUpgradeNo();
        reporter.reportLogWithScreenshot("tech install details");
        getRogersTechInstallPage().clkTechInstallContinueSelf();
        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallSetUp(),"SetUp page has Launched","SetUp page has not Launched");
        getRogersTechInstallPage().clkTechInstallContinue();
        reporter.hardAssert(getRogersPaymentOptionsPage().verifyPaymentModepage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
        reporter.reportLogWithScreenshot("Launched the payment options page");
        getRogersPaymentOptionsPage().selectPaymentMode("Pre-authorized Credit Card");
        getRogersPaymentOptionsPage().switchToCreditCardIFrame();
        getRogersPaymentOptionsPage().setCreditCardNumberIFrame(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
        getRogersPaymentOptionsPage().switchOutOfCreditCardIFrame();
        getRogersPaymentOptionsPage().setCVV();
        getRogersPaymentOptionsPage().selectExpiryMonth();
        getRogersPaymentOptionsPage().selectExpiryYear();
        reporter.reportLogWithScreenshot("Payment options Details");
        getRogersPaymentOptionsPage().clkPaymentConfirm();
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyDisneyImage(), "PSEF verified", "PSEF not verified");
        reporter.hardAssert( getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
    }

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_igniteanonymous, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


