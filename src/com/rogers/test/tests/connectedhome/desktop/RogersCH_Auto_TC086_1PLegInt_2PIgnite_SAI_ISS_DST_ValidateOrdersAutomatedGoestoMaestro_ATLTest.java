package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * This class contains the test method to verify the upgarde flow for Legacy Internet to Ignite SAI+ISS for Rogers.com
 *
 * @author manpreet.kaur3
 * <p>
 * Test steps:
 * <p>
 * 1. Launch the Rogers.com url.
 * 2. Login with valid credentials.
 * 3. Select the valid Account.
 * 4. Click on Internet under shop drowndown.
 * 5. Use the Address on file to validate the serviceability and click on Use this address.
 * 6. Select the Internet package with Ignite SmartStream option.
 * 7. Select the month-to-month term contract.
 * 8. Click Add to cart.
 * 9. Click on 'Yes I understood'button.
 * 10. Click on Continue on Internet Cart Summary Page.
 * 11. Verify the Profile Page.
 * 12. All the personal information is auto populated.
 * 13. Click on continue button.
 * 14. Verify the Credit Evaluation Page.
 * 15. In Credit Evaluation page, enter the required info on Credit Check:
 * 16. Click Continue.
 * 17. Verify the fulfillment Page.
 * 18. Select No to a professional install.
 * 19. Click on Continue.
 * 20. Click on Continue on Setup fulfillment page.
 * 21. Click on Continue on payment options Page.
 * 22. Verify the order review page.
 * 23. Check Agreement.
 * 24. Click Submit.
 * 25. Verify Order confirmation Page.
 * 26. Validate the Ban ID in the DB
 **/

public class RogersCH_Auto_TC086_1PLegInt_2PIgnite_SAI_ISS_DST_ValidateOrdersAutomatedGoestoMaestro_ATLTest extends BaseTestClass {

    @Test(groups = {"RegressionCH"})
    public void rogersCH_Auto_TC086_1PLegInt_2PIgnite_SAI_ISS_DST_ValidateOrdersAutomatedGoestoMaestro_ATL() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc86_Legacy1PInternetToIgnite2P.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc86_Legacy1PInternetToIgnite2P.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
       // reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
            reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc86_Legacy1PInternetToIgnite2P.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account Selected");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Launched the Account Page", "Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersHomePage().clkNLProvinceLnk();
        reporter.reportLogWithScreenshot("Selected the NL Province");
        getRogersHomePage().clkExistingCustomerShop();
        reporter.reportLogWithScreenshot("clicked shop menu from navigation bar to select the Internet");
       // getRogersHomePage().clkSmartInternet();
        getDriver().get(System.getProperty("QaUrl") + "/internet/offers");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getRogersHomePage().selectAddressOnFile();
        reporter.reportLogWithScreenshot("selected address on file");
        getRogersHomePage().clkUseAddress();

        reporter.hardAssert(getRogersHomePage().verifyInternetpage(), "Internet page has Launched", "Internet page has not Launched");


        getRogersInternetPackageSelectionPage().clkTakQuiz();
        reporter.reportLogWithScreenshot("Launched BEST PACKAGE FOR YOU page");
        getRogersInternetPackageSelectionPage().clkWebEmail();
        getRogersInternetPackageSelectionPage().clkStreamingShowsBtn();
        getRogersInternetPackageSelectionPage().clkOnlineGamingBtn();
        getRogersInternetPackageSelectionPage().clkSharingLargeVideosBtn();
        getRogersInternetPackageSelectionPage().clkSmartDevicesBtn();
        getRogersInternetPackageSelectionPage().clkWorkHome();
        reporter.reportLogWithScreenshot("Checked Internet usage of household");
        getRogersInternetPackageSelectionPage().clkDSTContinue();
        getRogersInternetPackageSelectionPage().clkInternetCount6OrMore();
        reporter.reportLogWithScreenshot("Selected Internet Count");
        getRogersInternetPackageSelectionPage().clkDSTContinue();
        getRogersInternetPackageSelectionPage().clkInternetDevice16OrMore();
        reporter.reportLogWithScreenshot("Selected Internet Device");
        getRogersInternetPackageSelectionPage().clkDSTContinue();
        getRogersInternetPackageSelectionPage().clkAddSmartStream();
        reporter.reportLogWithScreenshot("Add smart stream add on");
        getRogersInternetPackageSelectionPage().clkDSTContinue();
        getRogersInternetPackageSelectionPage().VerifyBestFit();
        reporter.reportLogWithScreenshot("Best Fit package for the selected");
        getRogersInternetPackageSelectionPage().clkBackToPackagesPage();
        reporter.reportLogWithScreenshot("Clicked on back to packages");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().VerifyRecommendedBanner(),"Best Fit package displayed post quiz","Best Fit package displayed post quiz");
        //getRogersInternetPackageSelectionPage().selectIgniteSmartStream1GbpsCheckBox();
        //reporter.reportLogWithScreenshot("Selected Ignite Smart Stream checkbox");
        //getRogersInternetPackageSelectionPage().selectMonthToMonthTypeOfContact();
        //reporter.reportLogWithScreenshot("Selected Month-to-month term contract");
        getRogersInternetPackageSelectionPage().clkInternet1GbpsPackage();
        reporter.reportLogWithScreenshot("Selected Add to Cart");
        getRogersInternetPackageSelectionPage().clkIUnderstand();
        reporter.reportLogWithScreenshot("Selected Yes I understand button");

        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyCartSummaryHeader(), "Cart Summary Page page has Launched", "Cart Summary Page page has not Launched");
        getRogersInternetPackageSelectionPage().clkInternetBuyContinue();

        reporter.hardAssert(getRogersInternetProfilePage().verifyProfilePageSAI(), "Profile page has Launched", "Profile page has not Launched");
        getRogersInternetProfilePage().clkSubmitProfile();
        reporter.hardAssert(getRogersInternetCreditCheckPage().verifyCreditEvalutionPage(), "Credit Evalution page has Launched", "Credit Evalution page has not Launched");
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

        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(), "TechInstall page has Launched", "TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Launched the tech install page");
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

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    //IgniteLogin
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_login, method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}