package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to verify the upgrade flow for Legacy Int/ TV to 3P Ignite for Rogers.com
 * @author manpreet.kaur3
 * <p>
 * Test steps:
 * <p>
 * 1. Launch the Rogers.com url.
 * 2. Login with valid credentials.
 * 3. Click on the TV badge
 * 4. Click on Ignite TV under shop drowndown
 * 5. View Bundles and click on Home Phone
 * 6. Select the Bundles package and Click on Order online
 * 6. Select the address on file and use the address
 * 7. Select the month-to-month type of contract and Click on Add to cart
 * 8. Click on 'Yes I understood' button.
 * 9. Select the skip for new number
 * 10. Click on Continue.
 * 11. Select No for 'Do you have a 4K TV'.
 * 13. Add Additional Ignite Tv Boxes - 5 and click on update cart
 * 14. Click checkout button on cart summary page.
 * 15. All the personal information is auto populated.
 * 16. Click on continue button.
 * 17. In Credit Evaluation page, enter the required info on Credit Check:
 * 18. Click Submit.
 * 19. Enter 1 or 2 numbers in Choose a phone Number textbox and click on Generate numbers.
 * 20. Select any one phone number.
 * 21. Make sure Caller ID and Directory listing fields are populated.
 * 22. Click on Continue.
 * 23. Select a time in Choose your Date and Time.
 * 24. Enter any valid Mobile number and email address.
 * 25. Click on Confirm.
 * 26. Select Pre-Authorized credit card option from type of payment dropdown.
 * 27. Enter valid Credit Card number details in Credit Card related fields.
 * 28. Click on Continue.
 * 29. Validate appropriate information is displayed in Review order page.
 * 30. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox.
 * 31. Order confirmation page will be displayed with the order number and validate the order details.
 **/

public class RogersCH_Auto_TC087_2PLeg_to3PIgnite_ValidateSVODRemovedFromGenre_No4K_Over4STBs_DBAasDefaultFO_ProInstallOptionTest extends BaseTestClass {

    @Test
    public void rogersCH_Auto_TC087_2PLeg_to3PIgnite_ValidateSVODRemovedFromGenre_No4K_Over4STBs_DBAasDefaultFO_ProInstallOption() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc117_Legacy2PTVToIgnite3P.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc117_Legacy2PTVToIgnite3P.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().clkSkipIFrame();
        reporter.reportLogWithScreenshot("Skip popup");
       // reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
            reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc117_Legacy2PTVToIgnite3P.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account Selected");
        //reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Launched the Account Page", "Account Page hasn't launched");
        //getRogersHomePage().clkExistingCustomerShop();
        //reporter.reportLogWithScreenshot("clicked shop menu from navigation bar to select the IgniteTV");
        //getRogersHomePage().clkIgniteTVExistingCustomer();
        //reporter.reportLogWithScreenshot("Launched the IgniteTV page");
        getDriver().get(System.getProperty("QaUrl") + "/home/ignite-bundles/tv-internet");
        reporter.reportLogWithScreenshot("Launched the IgniteTV page");
        getRogersHomePage().clkServiceability();
        reporter.reportLogWithScreenshot("Clicked on View Bundles");
        getRogersIgniteTVBuyPage().clkHomephone();
        reporter.reportLogWithScreenshot("Home phone selected");
        getRogersIgniteTVBuyPage().selectFlex20Package();
        //getRogersIgniteTVBuyPage().selectSolarisPremierPackage();
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getRogersHomePage().selectAddressOnFile();
        reporter.reportLogWithScreenshot("Selected Address on file");
        getRogersHomePage().clkUseAddress();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(), "Bundles Page has launched", "Bundles Page has not launched");
       /* getRogersIgniteTVBuyPage().selectPremierMonthToMonthTypeOfContract();
        reporter.reportLogWithScreenshot("Selected month-to-month term contract");
        getRogersIgniteTVBuyPage().selectSolarisPremier(); */
        getRogersIgniteTVBuyPage().selectFlex20PackageMonthToMonthTypeOfContract();
        reporter.reportLogWithScreenshot("Selected Month-to-month type of contract");
        getRogersIgniteTVBuyPage().clkTotalChannelsFlex20();
        reporter.reportLogWithScreenshot("Clicked on Total channels link");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyViewTotalChannelsPopupModal(), "View Total Channels Popup Modal has launched", "View Total Channels Popup Modal has not launched");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifySVODRemovedFromGenre(), "SVOD removed from the genre dropdown","SVOD present under genre dropdown");
        getRogersIgniteTVBuyPage().clkCloseChannelsPopup();
        reporter.reportLogWithScreenshot("Clicked on Close Total Channels popup Modal");
        getRogersIgniteTVBuyPage().clkFlexChannelsFlex20();
        reporter.reportLogWithScreenshot("Clicked on Flex channels link");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyViewFlexChannelsPopupModal(), "View Flex Channels Popup Modal has launched", "View Flex Channels Popup Modal has not launched");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifySVODRemovedFromGenre(), "SVOD removed from the genre dropdown","SVOD present under genre dropdown");
        getRogersIgniteTVBuyPage().clkCloseChannelsPopup();
        reporter.reportLogWithScreenshot("Clicked on Close Flex Channels popup Modal");
        getRogersIgniteTVBuyPage().selectFlex20Package();
        reporter.reportLogWithScreenshot("Clicked on bundles package");
        getRogersIgniteTVBuyPage().clkIUnderstand();
        reporter.reportLogWithScreenshot("Clicked yes on the information popup");
        getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersIgniteTVBuyPage().clkHomePhone();

        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(), "4KTV radio button is available", "4KTV radio button is not available");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().set4KTVNo();
        reporter.reportLogWithScreenshot("No, I don't have a 4k TV selected");

        getRogersIgniteTVBuyPage().clkChevronDownYourCart();
        reporter.reportLogWithScreenshot("Opened the Mini cart");

        getRogersIgniteTVBuyPage().clkPlusAddOverFourIgniteTVBoxes();
        reporter.reportLogWithScreenshot("Added 5 TV boxes");

        getRogersIgniteTVBuyPage().clkUpdateCart();
        reporter.reportLogWithScreenshot("Clicked Update Cart");

        getRogersIgniteTVBuyPage().clkChevronUpYourCart();
        reporter.reportLogWithScreenshot("Closed the cart");
        getRogersIgniteTVBuyPage().clkCheckout();

        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
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

        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPhoneNumberPage(), "Ignite page has Launched", "Ignite page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhoneSelectionPage().clkPhoneNumberGenerator();
        getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();

        //Validate flowType="AUTL" from continueBuy call, will be adding with selenium4
        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(), "TechInstall page has Launched", "TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Launched the tech install page");
        getRogersTechInstallPage().clkProInstallUpgradeYes();
        reporter.reportLogWithScreenshot("Click on ProInstallUpgradeYes");
        getRogersTechInstallPage().clkTechContinue();

        reporter.reportLogWithScreenshot("Launched the Schedule Appointment Page");
        getRogersTechInstallPage().selectPrefferedDate();
        getRogersTechInstallPage().selectPreferredTimeSlot();
        getRogersTechInstallPage().setContactNumber();
        getRogersTechInstallPage().clkTechInstalConsent();
        reporter.reportLogWithScreenshot("Scheduled Appointment");
        getRogersTechInstallPage().clkTechInstallContinue();

        reporter.reportLogWithScreenshot("Launched the payment options page");
        getRogersPaymentOptionsPage().clkPaymentConfirm();

        getRogersOrderReviewPage().clkShowPriceBreakdown();
        reporter.reportLogWithScreenshot("Expand the Show Price Breakdown button under One-Time Charges block");

        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(), "Agreement page has Launched", "Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(), "Agreement has Launched", "Agreement has not Launched");

        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(), "Order has created successfully", "Order has failed");
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        String ban = getRogersOrderConfirmationPage().getBAN();
        System.out.println("BAN from the portal : " + ban);

    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    //IgniteLogin
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_ignitelogin, method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}