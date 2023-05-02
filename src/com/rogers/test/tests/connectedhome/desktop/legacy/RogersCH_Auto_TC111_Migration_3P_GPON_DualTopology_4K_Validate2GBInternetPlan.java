package com.rogers.test.tests.connectedhome.desktop.legacy;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class RogersCH_Auto_TC111_Migration_3P_GPON_DualTopology_4K_Validate2GBInternetPlan extends BaseTestClass {

    @Test(groups = {"Regression"})
    public void RogersCH_Auto_TC111_Migration_3P_GPON_DualTopology_4K_Validate2GBInternetPlan(){
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc111_3p_migration_gpon.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc111_3p_migration_gpon.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        getEnsVerifications().setVerificationCodeCH(TestDataHandler.tc111_3p_migration_gpon.getUsername());
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
       // getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc14_SolarisTVAccountFlex5Package.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getDriver().get(System.getProperty("QaUrl")+"/bundles/offers?env=qa");
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getRogersHomePage().selectAddressOnFile();
        reporter.reportLogWithScreenshot("Selected Address on file");
        getRogersHomePage().clkUseAddress();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(), "Bundles Page has launched", "Bundles Page has not launched");
        //getRogersIgniteTVBuyPage().selectFlex20PackageMonthToMonthTypeOfContract();
        getRogersIgniteTVBuyPage().selectInternetSpeeed("Flex 20","2.5 Gbps");
        reporter.reportLogWithScreenshot("Selected 2.5 gbps download speed");
        getRogersIgniteTVBuyPage().selectFlex20Package();
        reporter.reportLogWithScreenshot("Added to cart");
        getRogersIgniteTVBuyPage().clkIUnderstand();
        reporter.reportLogWithScreenshot("Clicked on the \"Yes I Understand\" popup");
        //reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage(), "Port-InOut page has Launched", "Port-InOut page has not Launched");
        //reporter.reportLogWithScreenshot("Launched the home phone selection page");
        //getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersIgniteTVBuyPage().clkHomePhone();
        reporter.reportLogWithScreenshot("Click continue on rhp Addons page");

        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(), "4KTV radio button is available", "4KTV radio button is not available");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().set4KTVNo();
        reporter.reportLogWithScreenshot("4k TV selected as No");
        getRogersIgniteTVBuyPage().clkCheckout();

        reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(), "Profile page has Launched", "Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
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

        reporter.reportLogWithScreenshot("Clicked continue on Credit Check page");
        getRogersIgniteTVBuyPage().clkReviewCallerContinuebtn();
        reporter.reportLogWithScreenshot("Clicked continue on Review Caller info page");
        reporter.reportLogWithScreenshot("professional installation");
        getRogersTechInstallPage().selectPrefferedDate();
        getRogersTechInstallPage().selectPreferredTimeSlot();
        reporter.reportLogWithScreenshot("Selected Available appoinments");
        getRogersTechInstallPage().clkTechInstalConsent();
        reporter.reportLogWithScreenshot("clicked on the agreement checkboc");
        getRogersTechInstallPage().clkTechContinue();
        reporter.reportLogWithScreenshot("clicked on the continue button");

        reporter.hardAssert(getRogersPaymentOptionsPage().verifyPaymentModepage(), "Payment Mode page has Launched", "Payment Mode page has not Launched");
        reporter.reportLogWithScreenshot("Launched the payment options page");

        getRogersPaymentOptionsPage().clkPaymentConfirm();

        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(), "Agreement page has Launched", "Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(), "Agreement has Launched", "Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();

    }
    @BeforeMethod(alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    //login flow
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws  IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_legacylogin, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}
