package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC33_MIG_1P_INT_to_3P_with_HomeSecurity_E2E_Dealer_ON_FR_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("OVRURL"), strBrowser, strLanguage, RogersEnums.GroupName.ovr, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

    @Test(groups = {"OVR", "RegressionOVR"})
    public void ovr_Auto_TC33_MIG_1P_INT_to_3P_with_HomeSecurity_E2E_Dealer_ON_FR_Test() {
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"), System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getChampLoginPage().changeChampToFR();
        reporter.reportLogWithScreenshot("Changed Champ page to French");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.tc_33_Ovr_Mig_Data_1pINT_to_3p_with_SHM.getBanNumber(), TestDataHandler.tc_33_Ovr_Mig_Data_1pINT_to_3p_with_SHM.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());

        reporter.reportLogWithScreenshot("search for account and select environment ");
        getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("Open IgniteLink from dashboard");
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        getCheckAvailabilityPage().useThisAddress();
        reporter.reportLogWithScreenshot("Service Availability");
        reporter.hardAssert(getBundleBuilderPage().verifyCustomerCurrentPlan(), "Current Plan is displayed", "Current Plan is not displayed");
        reporter.hardAssert(getBundleBuilderPage().verifyOvrSessionTimer(), "Ovr Session Timer Present", "Ovr Session timer not present");
        reporter.hardAssert(getBundleBuilderPage().verifyBundleBuilderPage(), "Bundle Builder page is displayed", "Bundle Builder page is not displayed");
        reporter.reportLogWithScreenshot("Bundle Builder Page displayed");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Internet Selected");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        reporter.reportLogWithScreenshot("TV Check box selected");
        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        reporter.reportLogWithScreenshot("HomePhone selected");
        getRogersIgniteBundlesPage().clickSmartHomeMonitoring();
        reporter.reportLogWithScreenshot("3P services with HomeSecurity selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("Click on Load offers");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("Add to cart 1st offer");
        getRogersIgniteBundlesPage().noPortInPopup();

        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to Points to mention pop-up");
        getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
        reporter.reportLogWithScreenshot("Review Points to mention");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();

        //reporter.reportLogWithScreenshot("Continue to Channel Personalization page");
        //getRogersIgniteBundlesPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Channels and theme packs page");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("4k tv pop up");
        getRogersIgniteBundlesPage().fourKTVPopup();
        reporter.reportLogWithScreenshot("4k Content Popup");
        getRogersIgniteBundlesPage().contiue4KContent();

        //Internet Add-Ons page.
        reporter.reportLogWithScreenshot("Continue to Internet Add Ons page");
        reporter.hardAssert(getRogersIgniteBundlesPage().validateInternetAddOnsHeader(),"Internet Add Ons Page loaded","Internet Add Ons Page not loaded");
        getRogersIgniteBundlesPage().clkContinueInternetAddon();

        getHomePhoneAddonsPage().chooseAddon(TestDataHandler.ovrMigrationData3PTo3PON.getAddOnPlan(),TestDataHandler.ovrMigrationData3PTo3PON.getAddOnPlanFr());
        reporter.reportLogWithScreenshot("Addons selected for home phone add ons");
        getHomePhoneAddonsPage().clkContinue();

        reporter.hardAssert(getRogersIgniteBundlesPage().validateSmartHomeAddOnsHeader(),"SHM Add ons page loaded","SHM add ons page not loaded");
//        getRogersIgniteBundlesPage().addSHMAddOn();
//        reporter.reportLogWithScreenshot("SHM Add on added to cart");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.reportLogWithScreenshot("Continue to Cart Summary Page");
        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        //Validation for HomeSecurity Addon
        //reporter.hardAssert(getRogersIgniteBundlesPage().validateSHMMonthlyChargesInCartSummary(),"Monthly HomeSecurity charges present", "Monthly HomeSecurity charges not Present");
        reporter.reportLogWithScreenshot("Cart Summary page");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();

        reporter.reportLogWithScreenshot("wish to continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.reportLogWithScreenshot("Customer Profile Page");
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to Credit Check Page");
        reporter.hardAssert(getCreditCheckPage().verifyCreditEvaluationHeader(), "Credit Check Page loaded", "Credit Check Page not loaded");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay());
        reporter.reportLogWithScreenshot("Credit Evaluation DOB set");
        getCreditCheckPage().setDriversLicense("Colombie-Britannique",FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("BC"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generatePassportNumber());
        reporter.reportLogWithScreenshot("credit form completed");
        getCreditCheckPage().clkAuthorize();
        reporter.reportLogWithScreenshot("Credit Check Authorized");
        reporter.hardAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();

        reporter.reportLogWithScreenshot("Continue to Home Phone personalisation Page");
        reporter.hardAssert(getHomePhoneSelectionPage().verifyHomePhonePersonalizationHeader(),"Home Phone Personalisation page loaded", "Home Phone Personalisation page not loaded");
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        reporter.reportLogWithScreenshot("Generate Phone Number");
        getCreditCheckPage().goToPageBottom();
        getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
        reporter.reportLogWithScreenshot("continue from generate phone number");

        reporter.reportLogWithScreenshot("Continue to install options  page");
        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(), "Installation Page loaded","Installation Page not loaded");
        //For GPON Address, skip select pro install as it's the only available installation option.
        getBundleBuilderPage().selectExpressProInstall();
        reporter.reportLogWithScreenshot("Select Express Pro install");
        getBundleBuilderPage().clkTechInstallSlot();
        reporter.reportLogWithScreenshot("Select a time slot");
        getBundleBuilderPage().setMobileNumber();
        reporter.reportLogWithScreenshot("tech install details");
        getBundleBuilderPage().clkContinueInstallation();
        reporter.reportLogWithScreenshot("Billing and Payment page");
        reporter.hardAssert(getBundleBuilderPage().verifyBillingAndPaymentPage(), "Billing and Payment page displayed", "Billing and payment page not displayed");
        getBundleBuilderPage().clkContinueBillingAndPayment();

        reporter.reportLogWithScreenshot("Continue to Order Review Page");
        reporter.hardAssert(getOVROrderReviewPage().verifyOrderOverviewHeader(), "Order Review Page Loaded", "Order Review Page Not loaded");
        reporter.hardAssert(getOVROrderReviewPage().verifyOneTimeFees(), "One time Fees is displayed", "One time fees not displayed");
        reporter.hardAssert(getOVROrderReviewPage().verifyMonthlyCharges(), "Monthly Charges is displayed", "Monthly Charges not displayed");
        //Validation for SHM Addon monthly fees.
        //reporter.hardAssert(getOVROrderReviewPage().validateSHMMonthlyChargesInCartSummary(),"HomeSecurity charges present", "HomeSecurity add ons charges not present");
        reporter.reportLogWithScreenshot("Order review Page");

        getOVROrderReviewPage().clkContinue();
        reporter.reportLogWithScreenshot("Sign Agreement Page");
        reporter.hardAssert(getOVRAgreementPage().verifySignAgreementPage(), "Agreement page displayed", "Agreement page not displayed");
        getOVRAgreementPage().signAgreement();
        reporter.reportLogWithScreenshot("Back to Agreement Page");
        getOVRAgreementPage().clkAgreementCheckbox();
        reporter.reportLogWithScreenshot("Click Agreement Checkbox");
        getOVRAgreementPage().clkCompleteOrder();
        reporter.reportLogWithScreenshot("Order Confirmation Page");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderConfirmation(), "Order Confirmation displayed", "Order not Confirmed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderNumberPresent(), "Order number successfully displayed", "Order number not displayed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOneTimeFees(), "One Time Fees Displayed", "One time fees not displayed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyMonthlyCharges(), "Monthly Charges displayed", "Monthly charges not displayed");
        //Validation for SHM Addon monthly fees.
        //reporter.hardAssert(getOVROrderReviewPage().validateSHMMonthlyChargesInCartSummary(),"SMH charges present", "SHM add ons charges not present");

    }
}
