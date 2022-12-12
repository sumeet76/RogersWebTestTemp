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
 * This class contains the test method to validate PSEF and GWP campaigns on Cart Summary, Order Review and Confirmation pages - SAI+ISS NAC flow with 24 months term contract.
 * TC053_CH-17639_SAI+ISS_NAC_Ignite internet_500u_Validate for 24m term contracts PSEF&GWP is configured for the package_ON_FF
 *
 * @author nandan.master
 *
 * Test steps:
 * 1. Launch Rogers.com
 * 2. Browse to Shop menu and select Internet option
 * 3. click on Check Availability and enter home address to validate the serviceability
 * 4. Select SS and select one of available packages, click Add to Cart
 * 5. Validate PSEF promotion and GWP on cart summary page
 * 6. Click on Checkout
 * 7. Click continue to Profile page and Enter all personal information on user profile creation page - 1) Profile step
 * 8. Click on Continue
 * 9. In 2) Credit Evaluation page, enter the required info on Credit Check:
 *10. Click Submit
 *11. Verify Tech Install Page
 *12. Choose NO professiobal installation and continue
 *13. Select Pre-Authorized credit card option from type of payment dropdown
 *14. Enter valid Credit Card number details in Credit Card related fields
 *15. Click on Continue
 *16. Validate PSEF and GWP / WiFi6 on Order Review page
 *17. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *18. Click on Submit
 *19. Validate PSEF and GWP / WiFi6 on order confirmation page
 **/

public class RogersCH_Auto_TC105_SAI_ISS_NAC_Validate_PSEF_GWP_Term_Contract_ON extends BaseTestClass {

    @Test
    public void rogersCH_Auto_TC103_SAI_ISS_NAC_Validate_PSEF_GWP_Term_Contract_ON() {
        getDriver().get(System.getProperty("QaUrl") + "internet/streaming?env=qa");
        reporter.hardAssert(getRogersHomePage().verifyInternetpage(),"Internet page has Launched","Internet page has not Launched");
        reporter.reportLogWithScreenshot("Launched the Stream Availability check page");
        getRogersInternetPackageSelectionPage().clkSmartStreamAvailability();
        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        String  strAddressLine1=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        reporter.reportLogWithScreenshot("Address entered for serviceability");
        getRogersHomePage().clkIgniteAddressLookupSubmitSS();

        reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
        // 24 months term contract is selected
//        reporter.hardAssert(getRogersInternetPackageSelectionPage().verify500IgniteStreamingIsChecked(), "Ignite Streaming checkbox is selected", "Ignite Streaming checkbox is unchecked");
        getRogersInternetPackageSelectionPage().clkSmartStream500uPackage();
        reporter.reportLogWithScreenshot("Add to cart Smart Stream Package");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyCartSummaryHeader(), "Launched the Internet-cart Summary page", "Cart Summary not verified");

        // validating  PSEF, GWP and WiFi6 tags in cart summary
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyDisneyImage(), "PSEF verified", "PSEF not verified");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyGWPTag(), "GWP verified", "GWP not verified");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyWiFi6Text(), "WiFi6 verified", "WiFi6 not verified");
        getRogersInternetPackageSelectionPage().clkInternetBuyContinue();

        reporter.hardAssert(getRogersInternetProfilePage().verifyProfilePageSAI(),"Profile page has Launched","Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersInternetProfilePage().setEmail();
        getRogersInternetProfilePage().setFirstname();
        getRogersInternetProfilePage().setLastName();
        getRogersInternetProfilePage().setPhone();
        getRogersInternetProfilePage().clkSubmitProfile();

        reporter.hardAssert(getRogersInternetCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evalution page has Launched","Credit Evalution page has not Launched");
        reporter.reportLogWithScreenshot("Launched the credit evaluation page");
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

        // validating PSEF, GWP and WiFi6 tags on Order Review Page
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyDisneyImage(), "PSEF verified", "PSEF not verified");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyGWPTag(), "GWP verified", "GWP not verified");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyWiFi6Text(), "WiFi6 verified", "WiFi6 not verified");

        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
        reporter.reportLogWithScreenshot("Launched the Confirmation page");

        // validating PSEF, GWP and WiFi6 tags on Order Confirmation Page
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyDisneyImage(), "PSEF verified", "PSEF not verified");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyGWPTag(), "GWP verified", "GWP not verified");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyWiFi6Text(), "WiFi6 verified", "WiFi6 not verified");
    }

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    //legacyAnonymous
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_igniteanonymous, method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
