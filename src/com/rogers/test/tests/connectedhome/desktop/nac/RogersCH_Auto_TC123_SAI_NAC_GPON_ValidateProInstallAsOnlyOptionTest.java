package com.rogers.test.tests.connectedhome.desktop.nac;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;


/**
 * This class contains the test method to test Internet Offer Buy flow with gpon only address for Rogers.com
 * TC044_Negative Scenerio_SAI NAC_GPON topology_ no active ONT _Validate Pro install as only fulfillment option on buy flow.
 * @author manpreet.kaur3
 *
 * Test steps:
 * 1.Launch Rogers SAI Packages in QA Env and click on Check Availability
 * 2. Enter Gpon only address with no active ONT
 * 3. Check Serviceability and validate Internet Packages page
 * 4. Add to cart 2.5 gbps package
 * 5. Validate Cart summary
 * 6. Click on Checkout
 * 7. Click on Yes, continue
 * 8. Click on Continue
 * 9. Enter DOB, valid ID details and click on continue
 * 10. Validate Pro install as only option
 * 11. Select Date and Time slot for pro install and Click on Continue
 * 12. Click on Submit
 *
 **/

public class RogersCH_Auto_TC123_SAI_NAC_GPON_ValidateProInstallAsOnlyOptionTest extends BaseTestClass {

    @Test(groups = {"RegressionCH", "saiNAC"})
    public void rogersCH_Auto_TC123_SAI_NAC_GPON_ValidateProInstallAsOnlyOption() {
        reporter.reportLogWithScreenshot("clicked on Easy Internet");
        getDriver().get(System.getProperty("QaUrl") + "/internet?setProvince=NB");
        reporter.hardAssert(getRogersHomePage().verifyInternetpage(),"Internet page has Launched","Internet page has not Launched");
        reporter.reportLogWithScreenshot("Launched the Internet packages page");
        getRogersHomePage().clkInternetAvailability();
        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=TestDataHandler.tc88_GPON_DualTopology.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc88_GPON_DualTopology.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        reporter.reportLogWithScreenshot("Address GPON only entered for serviceability");
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        getRogersInternetPackageSelectionPage().clkViewPkgs();
        reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyInternetPackagesPage(),"Packages page has Launched","Packages page has not Launched");
        getRogersInternetPackageSelectionPage().clkInternet2d5Package();
        reporter.reportLogWithScreenshot("Clicked on 2.5 gbps package");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyCartSummaryHeader(), "Launched the Internet-cart Summary page", "Cart Summary not verified");
        getRogersInternetPackageSelectionPage().clkInternetBuyContinue();
        reporter.hardAssert(getRogersInternetProfilePage().verifyProfilePageSAI(),"Profile page has Launched","Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersInternetProfilePage().setEmail();
        getRogersInternetProfilePage().setFirstname();
        getRogersInternetProfilePage().setLastName();
        getRogersInternetProfilePage().setPhone();
        getRogersInternetProfilePage().clkSubmitProfile();

        reporter.hardAssert(getRogersInternetCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evalution page has Launched","Credit Evalution page has not Launched");
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
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

        reporter.reportLogWithScreenshot("Launched the Schedule Appointment Page");
        getRogersTechInstallPage().selectPrefferedDate();
        getRogersTechInstallPage().selectPreferredTimeSlot();
        reporter.reportLogWithScreenshot("Selected Preferred Date and timeslot");
        getRogersTechInstallPage().setContactNumber();
        getRogersTechInstallPage().clkTechInstalConsent();
        reporter.reportLogWithScreenshot("Professional Installation content provided");
        getRogersTechInstallPage().clkTechInstallContinue();
        reporter.reportLogWithScreenshot("Verified Pro Install as the only option");

        reporter.hardAssert(getRogersPaymentOptionsPage().verifyPaymentModepage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
        reporter.reportLogWithScreenshot("Launched the payment options page");
        getRogersPaymentOptionsPage().selectPaymentMode("Monthly Bill");
        reporter.reportLogWithScreenshot("Payment options Details");
        getRogersPaymentOptionsPage().clkPaymentConfirm();
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert( getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        String ban = getRogersOrderConfirmationPage().getBAN();
        System.out.println("BAN from the portal : " + ban);
        String DbSchema = getDbConnection().getSchemaName(System.getProperty("DbEnvUrl"));
        System.out.println("SCHEMA : " + DbSchema);
        /**
         * DB Validations in the subscriber table
         */
        Map<Object, Object> dblists = getDbConnection().connectionMethod(System.getProperty("DbEnvUrl")).executeDBQuery("select BAN,ACCOUNT_SUB_TYPE,SYS_CREATION_DATE from " + DbSchema +".billing_account where BAN='" + ban + "'", false);
        reporter.softAssert(dblists.get("BAN").equals(ban),"Entry is updated in the billing table","BAN is not present in the billing account table");
        reporter.softAssert(dblists.get("ACCOUNT_SUB_TYPE").equals("R"),"ACCOUNT_SUB_TYPE is verified as R","Account type is not updated as R");
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


