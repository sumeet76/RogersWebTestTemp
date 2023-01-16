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
 * This class contains the test method to test the IgniteTV buy flow for Rogers.com
 *
 * @author chinnarao.vattam
 * <p>
 * Test steps:
 * <p>
 * 1. Launch Rogers.com
 * 2. Browse to Shop menu and select Ignite TV option
 * 3. Scroll down to Ignite TV bundlessection and select one of available Bundle, click Add to Cart
 * 4. Enter home address to validate the serviceability and click on Check Availability
 * 5. Click on Continue
 * 6. Click "No thanks Continue"
 * 7. Click on Continue in Home phone add ons page
 * 8. Select one option for   'Do you have a 4K TV'
 * 9. Click checkout button on cart summary page.
 * 10. Enter all personal information on user profile creation page - 1) Profile step
 * 11. Click on Continue
 * 12. In 2) Credit Evaluation page, enter the required info on Credit Check:
 * 13. Click Submit
 * 14. Enter 1 or 2 numbers in Choose a phone Number textbox and click on Generate numbers
 * 15. Select any one phone number
 * 16. Make sure Caller ID and Directory listing fields are populated
 * 17. Click on Continue
 * 18. Validate minicart
 * 19. Select a time in Choose your Date and Time
 * 20. Enter any valid Mobile number and email address
 * 21. Click on Confirm
 * 22. Select Pre-Authorized credit card option from type of payment dropdown
 * 23. Enter valid Credit Card number details in Credit Card related fields
 * 24. Click on Continue
 * 25. Validate appropriate information is displayed in Review order page
 * 26. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 * 27. Click on Submit
 **/

public class RogersCH_Auto_TC026_3PNAC_BuyBundleTest extends BaseTestClass {

    @Test(groups = {"RegressionCH", "RogersIgniteBuyAnonymousCH","SanityCH","ReleaseSanity"})
    public void rogersCH_Auto_TC026_3PNAC_BuyBundle() {
       // getRogersHomePage().clkTVBundle();
        //getDriver().get(System.getProperty("QaUrl")+"home/ignite-bundles/tv-internet");
        reporter.reportLogWithScreenshot("Launched the Main QA Page");
        getRogersHomePage().clkNBProvinceLnk();
        reporter.reportLogWithScreenshot("select NB region");
        getRogersHomePage().clkExistingCustomerShop();
        reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
        getRogersHomePage().clkSubnavIgniteSmartStream();
        reporter.reportLogWithScreenshot("Launched the IgniteTV page");
        getRogersHomePage().clkGetIgniteTvWithIgniteInternet();
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String strAddressLine1 = TestDataHandler.tc25_IgniteServiceabilityAddressNB.getAccountDetails().getAddress().get("line1");
        String strAddressLine2 = TestDataHandler.tc25_IgniteServiceabilityAddressNB.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
        reporter.reportLogWithScreenshot("Entered address to check serviceability");
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Entered Serviceability address");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(), "Bundles Page has launched", "Bundles Page has not launched");
        getRogersIgniteTVBuyPage().clkHomephone();
        reporter.reportLogWithScreenshot("Clicked Home Phone");
       /* getRogersIgniteTVBuyPage().selectFlex20PackageMonthToMonthTypeOfContract();
        reporter.reportLogWithScreenshot("Selected Month-to-month type of contract");*/
        getRogersIgniteTVBuyPage().selectFlex20Package();
        reporter.reportLogWithScreenshot("Added to cart");
        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage(), "Port-InOut page has Launched", "Port-InOut page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersIgniteTVBuyPage().clkHomePhone();

        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(), "4KTV radio button is available", "4KTV radio button is not available");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().set4KTVNo();
        reporter.reportLogWithScreenshot("4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();

        reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(), "Profile page has Launched", "Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().setEmail();
        getRogersIgniteTVProfileCreationPage().setFirstname();
        getRogersIgniteTVProfileCreationPage().setLastName();
        getRogersIgniteTVProfileCreationPage().setPhone();
        reporter.reportLogWithScreenshot("Entered the profile information");
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();

        reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(), "Credit Evaluation page has Launched", "Credit Evaluation page has not Launched");
        reporter.reportLogWithScreenshot("Launched the credit evaluation page");
        getRogersIgniteTVCreditCheckPage().selectDOBYear();
        getRogersIgniteTVCreditCheckPage().selectDOBMonth();
        getRogersIgniteTVCreditCheckPage().selectDOBDay();
        reporter.reportLogWithScreenshot("Entered DOB details");
        getRogersIgniteTVCreditCheckPage().selectFirstID("Driver's License");
        getRogersIgniteTVCreditCheckPage().selectProvince("Ontario");
        getRogersIgniteTVCreditCheckPage().selectExpiryYear();
        getRogersIgniteTVCreditCheckPage().selectExpiryMonth();
        getRogersIgniteTVCreditCheckPage().selectExpiryDay();
        getRogersIgniteTVCreditCheckPage().setDrivingLicenseNumber("ON");
        reporter.reportLogWithScreenshot("Driving License Details");
        getRogersIgniteTVCreditCheckPage().selectSecondIDOption("Passport");
        getRogersIgniteTVCreditCheckPage().setPassportNumber();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryYear();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryMonth();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryDay();
        getRogersIgniteTVCreditCheckPage().clkCreditConsent();
        reporter.reportLogWithScreenshot("Passport Details");
        getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();

        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPhoneNumberPage(), "Ignite page has Launched", "Ignite page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhoneSelectionPage().clkPhoneNumberGenerator();
        reporter.reportLogWithScreenshot("clicked on generate Numbers");
        getRogersHomePhoneSelectionPage().selectPhoneNumber();
        reporter.reportLogWithScreenshot("Phone number selected");
        getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();

        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(), "TechInstall page has Launched", "TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Launched the tech install page");
        getRogersTechInstallPage().clkProInstallUpgradeNo();
        reporter.reportLogWithScreenshot("tech install details");
        getRogersTechInstallPage().clkTechInstallContinueSelf();
        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallSetUp(), "SetUp page has Launched", "SetUp page has not Launched");
        getRogersTechInstallPage().clkTechInstallContinue();

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
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(), "Agreement has Launched", "Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();

        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Launched the Confirmation page", "Confirmation page has not Launched");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(), "Order has created successfully", "Order has failed");
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    //IgniteAnonymous
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_igniteanonymous, method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }


}


