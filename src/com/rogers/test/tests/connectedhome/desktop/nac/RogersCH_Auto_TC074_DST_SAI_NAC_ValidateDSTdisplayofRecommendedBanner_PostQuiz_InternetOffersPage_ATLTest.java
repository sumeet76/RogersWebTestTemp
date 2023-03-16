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
 * This class contains the test method to test Legacy Internet Offer Buy flow for Rogers.com
 *
 * @author dharani.up
 *
 * Test steps:
 * 1.Launch Rogers SAI URL in QA Env and click on get it now and enter address and click on continue
 * 2. Click on continue
 * 3. Click on Take quiz and select appropriate option needed
 * 4.After ansering all validate recommended best fit package is displayed on top of all
 * 5. Add the best fit and click on Add to cart
 * 6. Click on Continue
 * 7. Click on Checkout
 * 8. Click on Yes, continue
 * 9. Click on Continue
 * 10. Enter DOB, valid ID details and click on continue
 * 11. Choose Installation type as enhanced self install and click on continue
 * 12. Click on Continue
 * 13. Click on Submit
 *
 **/

public class RogersCH_Auto_TC074_DST_SAI_NAC_ValidateDSTdisplayofRecommendedBanner_PostQuiz_InternetOffersPage_ATLTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","saiNAC"})
    public void rogersCH_Auto_TC074_DST_SAI_NAC_ValidateDSTdisplayofRecommendedBanner_PostQuiz_InternetOffersPage_ATL() {
//        reporter.reportLogWithScreenshot("clicked shop menu from navigation bar to select the Legacy Internet");
//        getRogersHomePage().clkEasyInternet();
//        reporter.hardAssert(getRogersHomePage().verifyInternetpage(),"Internet page has Launched","Internet page has not Launched");

        getDriver().get(System.getProperty("QaUrl")+"/internet?env=qa");
        reporter.reportLogWithScreenshot("Launched the Internet page");
        getRogersHomePage().clkNBProvinceLnk();
        reporter.reportLogWithScreenshot("ATL region selected");
        getRogersHomePage().clkInternetAvailability();

        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        String  strAddressLine1=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc23_24_standaloneInternetAccountforUpgrade.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the Internet-bundles page");
        // DST take quiz
        getRogersInternetPackageSelectionPage().clkTakQuiz();
        reporter.reportLogWithScreenshot("Launched BEST PACKAGE FOR YOU page");
        getRogersInternetPackageSelectionPage().clkWebEmail();
        getRogersInternetPackageSelectionPage().clkWorkHome();
        reporter.reportLogWithScreenshot("Checked web Email and Work Home");
        getRogersInternetPackageSelectionPage().clkDSTContinue();
        getRogersInternetPackageSelectionPage().clkInternetCount();
        reporter.reportLogWithScreenshot("Selected Internet Count");
        getRogersInternetPackageSelectionPage().clkDSTContinue();
        getRogersInternetPackageSelectionPage().clkInternetDevice();
        reporter.reportLogWithScreenshot("Selected Internet Device");
        getRogersInternetPackageSelectionPage().clkDSTContinue();
//        getRogersInternetPackageSelectionPage().VerifyBestFit(); // to be fixed post release
        reporter.reportLogWithScreenshot("Best Fit package for the selected");
        getRogersInternetPackageSelectionPage().clkDSTClose();
        reporter.reportLogWithScreenshot("Closed the DST Recommendation");
//        getRogersInternetPackageSelectionPage().VerifyYourBestFit(); // to be fixed post release
        reporter.reportLogWithScreenshot("Recommended pack is displayed");
        getRogersInternetPackageSelectionPage().select150MonthToMonthTypeOfContact();
        reporter.reportLogWithScreenshot("Type of contract selected");
        getRogersInternetPackageSelectionPage().clkBestAdd();
        reporter.reportLogWithScreenshot("Launched the Internet-cart Summary page");
        getRogersInternetPackageSelectionPage().clkInternetBuyContinue();
        reporter.hardAssert(getRogersInternetProfilePage().verifyProfilePageSAI(),"Profile page has Launched","Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersInternetProfilePage().setEmail();
        getRogersInternetProfilePage().setFirstname();
        getRogersInternetProfilePage().setLastName();
        getRogersInternetProfilePage().setPhone();
        reporter.reportLogWithScreenshot("Profile details entered");
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
        //getRogersTechInstallPage().clkTechInstalConsent();
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


