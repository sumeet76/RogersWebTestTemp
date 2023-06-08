
package com.rogers.test.tests.connectedhome.desktop.nac;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to verify the Legacy Internet upgarde flow for Rogers.com
 *
 * @author chinnarao.vattam
 * <p>
 * Test steps:
 * <p>
 * 1. Launch the Rogers.com url.
 * 2. Browse to Shop menu and select Ignite TV option
 * 3. Scroll down to Ignite TV bundlessection and select one of available Bundle, click Add to Cart
 * 4. Enter home address to validate the serviceability and click on Check Availability
 * 5. Click on Continue
 * 6. Click "Yes, Keep my number"
 * 7. Enter ph number and click on eligibility and continue
 * 8. Click on Continue in Home phone add ons page
 * 9. Select one option for   'Do you have a 4K TV'
 * 10. Click checkout button on cart summary page.
 * 11. Enter all personal information on user profile creation page - 1) Profile step
 * 12. Click on Continue
 * 13. In 2) Credit Evaluation page, enter the required info on Credit Check:
 * 14. Click Submit
 * 15. Select a time in Choose your Date and Time
 * 16. Enter any valid Mobile number and email address
 * 17. Click on Confirm
 * 18. Validate minicart
 * 19. Select Pre-Authorized credit card option from type of payment dropdown.
 * 20. Enter valid Credit Card number details in Credit Card related fields.
 * 21. Click on Continue.
 * 22. Validate appropriate information is displayed in Review order page.
 * 23. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox.
 * 24. Order confirmation page will be displayed with the order number and validate the order details.
 **/

public class RogersCH_Auto_TC071_3PNAC_PortIn_ValidateDatefieldEntryFulfillmentPageTest extends BaseTestClass {

    @Test(groups = {"RegressionCH", "BundlesNAC"})
    public void rogersCH_Auto_TC071_3PNAC_PortIn_ValidateDatefieldEntryFulfillmentPage() {
        getDriver().get(System.getProperty("QaUrl")+"/bundles");
        reporter.reportLogWithScreenshot("Launched the IgniteTV page for ON region");
        getRogersHomePage().clkServiceability();

        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String strAddressLine1 = TestDataHandler.tc32_SolarisPortinFlows.getAccountDetails().getAddress().get("line1");
        String strAddressLine2 = TestDataHandler.tc32_SolarisPortinFlows.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyOffersPage(), "Offers Page has launched", "Offers Page has not launched");

        getRogersIgniteTVBuyPage().clkHomephone();
        getRogersIgniteTVBuyPage().selectPremierMonthToMonthTypeOfContract();
        reporter.reportLogWithScreenshot("Selected month-to-month term contract");
        getRogersIgniteTVBuyPage().selectSolarisPremier();
        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage(), "Port-InOut page has Launched", "Port-InOut page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhonePortInPage().setHomePhoneNumber(TestDataHandler.tc32_SolarisPortinFlows.getAccountDetails().getPhoneNumber());
        getRogersHomePhonePortInPage().clkPhoneNumberEligibiltyCheck();

        reporter.hardAssert(getRogersHomePhonePortInPage().verifyPhoneNumberSuccess(), "Port-in Number validation success", "Port-in Number validation Failed");
        reporter.reportLogWithScreenshot("Port-in Number validation success");
        getRogersHomePhonePortInPage().setFirstName();
        getRogersHomePhonePortInPage().setLastName();
        getRogersHomePhonePortInPage().setInvoiceAddress(strAddressLine1 + ", " + strAddressLine2 + ", CANADA");
        getRogersHomePhonePortInPage().setCurrentPhoneNumber();
        reporter.reportLogWithScreenshot("Port-in details set");
        getRogersHomePhonePortInPage().selIMEI();
        getRogersHomePhonePortInPage().setAccountNumberOrIMEI(TestDataHandler.tc32_SolarisPortinFlows.getAccountDetails().getImei());
        getRogersIgniteTVBuyPage().clkHomePhoneAddOn();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");

        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyHomePhoneAddOnPage(), "Launched the Home phone add-on page", "Home phone add-on page has not launched");
        getRogersIgniteTVBuyPage().clkHomePhone();
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(), "4KTV radio button is availabe", "4KTV radio button is not availabe");

        getRogersIgniteTVBuyPage().set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();

        reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(), "Launched the create profile page", "Profile page hasn't  Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().setEmail();
        getRogersIgniteTVProfileCreationPage().setFirstname();
        getRogersIgniteTVProfileCreationPage().setLastName();
        getRogersIgniteTVProfileCreationPage().setPhone();
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
        reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(), "Launched the credit evalution page", "Credit evalution page hasn't  Launched");
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
        reporter.reportLogWithScreenshot("Home Phone selection page has launched");
        getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();
        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(), "TechInstall page has Launched", "TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Launched the tech install page");
        getRogersTechInstallPage().selTechInstalStartDate();
        reporter.reportLogWithScreenshot("Selected Start date for Installation slot");
        getRogersTechInstallPage().selectPreferredTimeSlot();
        reporter.reportLogWithScreenshot("Selected Start date for Installation slot");
        getRogersTechInstallPage().selTechInstalEndDate();
        reporter.reportLogWithScreenshot("Selected End date for Installation");
        getRogersTechInstallPage().selectBackupTimeSlot();
        reporter.reportLogWithScreenshot("Selected End date for Installation slot");
        getRogersTechInstallPage().setContactNumber();
        reporter.reportLogWithScreenshot("Entered Contact Number");
        getRogersTechInstallPage().setMobielNumber();
        reporter.reportLogWithScreenshot("tech install details");
        getRogersTechInstallPage().clkTechInstalConsent();
        reporter.reportLogWithScreenshot("Consent chek has done");
        getRogersTechInstallPage().clkTechInstallContinue();
        reporter.hardAssert(getRogersPaymentOptionsPage().verifyPaymentModepage(), "Launched the payment options page", "Payment options page has not Launched");
        reporter.reportLogWithScreenshot("Launched the payment options page");
        getRogersPaymentOptionsPage().selectPaymentMode("Monthly Bill");
        reporter.reportLogWithScreenshot("Payment options Details");
        getRogersPaymentOptionsPage().clkPaymentConfirm();
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(), "Agreement page has Launched", "Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(), "Agreement has Launched", "Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(), "Order has created successfully", "Order has failed");
        reporter.reportLogWithScreenshot("Verified the Confirmation page");
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