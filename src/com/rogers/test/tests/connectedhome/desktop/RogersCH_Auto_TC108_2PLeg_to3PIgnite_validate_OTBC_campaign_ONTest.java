package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to validate OTBC campaign on Offers, cart details / cart summary, order summary and order confirmaiton pages and whether the otbc presentment is two decimals.
 * TC038_CH-10026_OTBC_Migration_Validate Legacy 2P Cx migrating to Ignite 3P with OTBC campaign_ON_CH_EN
 * CH-17983_Update OTBC presentment with two decimal point(.00) instead of (.0)
 * @author nandan.master
 *
 * Test steps:
 *
 * 1. Launch the Rogers.com url
 * 2. Login with valid credentials
 * 3. Click on the TV badge
 * 4. Click on Ignite TV under shop drowndown
 * 5. View Bundles and click on Home Phone
 * 6. Validate One Time Bill Credit (OTBC) on Ignite 20 bundle on Offers Page
 * 7. Validate OTBC presentment is in two decimals (e.g. $200.00 and not $200.0)
 * 8. Expand bundle details and validate OTBC campaign
 * 9. Select the Bundles package and Click on Order online
 * 10. Select the address on file and use the address
 * 11. Select the month-to-month type of contract and Click on Add to cart
 * 12. Click on 'Yes I understood' button
 * 13. On port in page, expand Mini Cart (using chevron down button)
 * 14. Validate OTBC on mini-cart and collapse back the cart followed by Skip Selection button
 * 15. Click Continue on home phone add-ons page
 * 16. Validate OTBC on Cart Summary Page
 * 17. Click checkout button on cart summary page
 * 18. All the personal information is autopopulated
 * 19. Click on continue button
 * 20. In Credit Evaluation page, enter the required info on Credit Check:
 * 21. Click Submit
 * 22. Enter 1 or 2 numbers in Choose a phone Number textbox and click on Generate numbers
 * 23. Select any one phone number
 * 24. Continue without Pro installation
 * 25. Continue with pre-selected payment method
 * 26. Validate OTBC on Order Reivew page
 * 27. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 * 28. Order confirmation page will be displayed with the order number and validate the order details
 * 29. Validate OTBC on Order Confirmation page.
 **/

public class RogersCH_Auto_TC108_2PLeg_to3PIgnite_validate_OTBC_campaign_ONTest extends BaseTestClass {

    @Test
    public void rogersCH_Auto_TC108_2PLeg_to3PIgnite_validate_OTBC_campaign_ON() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc108_2PLeg_3PIgnite_otbc.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc108_2PLeg_3PIgnite_otbc.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");

        getDriver().get(System.getProperty("QaUrl")+"/home/ignite-bundles/tv-internet");
        reporter.reportLogWithScreenshot("Launched the TV Bundles Page");
        getRogersHomePage().clkServiceability();
        reporter.reportLogWithScreenshot("Launched serviceability model");
        getRogersHomePage().selectAddressOnFile();
        reporter.reportLogWithScreenshot("Selected Address on file");
        getRogersHomePage().clkUseAddress();
        reporter.reportLogWithScreenshot("Use the address on file");
        getRogersIgniteTVBuyPage().clkHomephone();
        reporter.reportLogWithScreenshot("Home phone selected");

        reporter.hardAssert(getRogersIgniteTVBuyPage().validateOTBCBundleOffers(TestDataHandler.tc108_2PLeg_3PIgnite_otbc.getAccountDetails().getUpgradeBundle()), "OTBC validated for a Bundle on offers page", "OTBC NOT validated for a Bundle on offers page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().isOTBCPresentmentTwoDecimal(TestDataHandler.tc108_2PLeg_3PIgnite_otbc.getAccountDetails().getUpgradeBundle()), "OTBC presentment with two decimal point(.00)", "OTBC presentment NOT with two decimal point(.00)");
        getRogersIgniteTVBuyPage().clkViewMoreDetailsFlex10();
        reporter.reportLogWithScreenshot("Clicked on View More Details");
        reporter.hardAssert(getRogersIgniteTVBuyPage().validateOTBCCampaign(), "OTBC validated on cart details page", "OTBC NOT validated on cart details page");
        getRogersIgniteTVBuyPage().clkCloseChannelsPopup();
        reporter.reportLogWithScreenshot("Clicked on Close verify More details popup Modal");

        getRogersIgniteTVBuyPage().selectFlex10Package();
        reporter.reportLogWithScreenshot("Clicked on bundles package");
        getRogersIgniteTVBuyPage().clkIUnderstand();
        reporter.reportLogWithScreenshot("Clicked yes on the information popup");
        getRogersIgniteTVBuyPage().clkChevronDownYourCart();
        reporter.reportLogWithScreenshot("Opened the Mini cart");
        reporter.hardAssert(getRogersIgniteTVBuyPage().validateOTBCCampaign(), "OTBC validated on cart details page", "OTBC NOT validated on cart details page");
        getRogersIgniteTVBuyPage().clkChevronUpYourCart();
        reporter.reportLogWithScreenshot("Closed the cart");
        getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersIgniteTVBuyPage().clkHomePhone();
        reporter.reportLogWithScreenshot("Launched the cart summary page");

        reporter.hardAssert(getRogersIgniteTVBuyPage().validateOTBCCampaign(), "OTBC validated on cart details page", "OTBC NOT validated on cart details page");
        getRogersIgniteTVBuyPage().set4KTVNo();
        reporter.reportLogWithScreenshot("No, I don't have a 4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();

        reporter.reportLogWithScreenshot("Launched the credit evalution page");
        getRogersIgniteTVCreditCheckPage().selectDOBYearExistingCustomer(TestDataHandler.tc108_2PLeg_3PIgnite_otbc.getAccountDetails().getYear());
        getRogersIgniteTVCreditCheckPage().selectDOBMonthExistingCustomerMigration(TestDataHandler.tc108_2PLeg_3PIgnite_otbc.getAccountDetails().getMonth());
        getRogersIgniteTVCreditCheckPage().selectDOBDayExistingCustomerMigration(TestDataHandler.tc108_2PLeg_3PIgnite_otbc.getAccountDetails().getDate());
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
        reporter.reportLogWithScreenshot("Click on ProInstallUpgradeNo");
        getRogersTechInstallPage().clkTechInstallContinueSelf();
        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallSetUp(), "SetUp page has Launched", "SetUp page has not Launched");
        getRogersTechInstallPage().clkTechInstallContinue();
        reporter.reportLogWithScreenshot("Launched the payment options page");
        getRogersPaymentOptionsPage().clkPaymentConfirm();

        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(), "Agreement page has Launched", "Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(), "Agreement has Launched", "Agreement has not Launched");
        reporter.hardAssert(getRogersIgniteTVBuyPage().validateOTBCCampaign(), "OTBC validated on Order Review", "OTBC NOT validated on Order Review");

        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(), "Order has created successfully", "Order has failed");
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().validateOTBCCampaign(), "OTBC validated on Order Confirmation", "OTBC NOT validated on Order Confirmation");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    //IgniteLogin
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_legacylogin, method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
