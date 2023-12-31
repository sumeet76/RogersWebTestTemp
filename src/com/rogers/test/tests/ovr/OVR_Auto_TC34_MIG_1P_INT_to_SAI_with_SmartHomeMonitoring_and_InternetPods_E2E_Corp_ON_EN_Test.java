package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC34_MIG_1P_INT_to_SAI_with_SmartHomeMonitoring_and_InternetPods_E2E_Corp_ON_EN_Test extends BaseTestClass {
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
    public void ovr_Auto_TC34_MIG_1P_INT_to_SAI_with_SmartHomeMonitoring_and_InternetPods_E2E_Corp_ON_EN_Test() {
        getChampLoginPage().logIntoCorpChamp(System.getenv("champCorpUserName"), System.getenv("champCorpPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectCorpSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.tc_34_Ovr_Mig_Data_1pINT_to_SAI_with_SHM_and_InternetPods.getBanNumber(), TestDataHandler.tc_34_Ovr_Mig_Data_1pINT_to_SAI_with_SHM_and_InternetPods.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("search for account and select environment ");
        getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("Open IgniteLink from dashboard");
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        reporter.reportLogWithScreenshot("Address Availability popup");
        getCheckAvailabilityPage().useThisAddress();
        reporter.reportLogWithScreenshot("Service Availability Page");
        reporter.hardAssert(getBundleBuilderPage().verifyCustomerCurrentPlan(),"Current plan is displayed", "Current Plan is not displayed");
        reporter.hardAssert(getBundleBuilderPage().verifyOvrSessionTimer(), "Ovr Session Timer Present", "Ovr Session timer not present");
        reporter.hardAssert(getBundleBuilderPage().verifyBundleBuilderPage(), "Bundle Builder page is displayed", "Bundle Builder page is not displayed");
        reporter.reportLogWithScreenshot("Bundle Builder Page");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Internet Selected");
        getRogersIgniteBundlesPage().clickSmartHomeMonitoring();
        reporter.reportLogWithScreenshot("SAI Internet with SHM selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("Load Offers");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("Add to cart 1st offer");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Continue with SAI internet and SHM bundle");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.reportLogWithScreenshot("Points to mention pop-up");
        getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
        reporter.reportLogWithScreenshot("Review Points to mention");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        //Internet Add-Ons page.
        reporter.reportLogWithScreenshot("Continue to Internet Add Ons page");
        reporter.hardAssert(getRogersIgniteBundlesPage().validateInternetAddOnsHeader(),"Internet Add Ons Page loaded","Internet Add Ons Page not loaded");
        /*To Add the chargeable Pods*/
        getRogersIgniteBundlesPage().addPods(5);
        reporter.reportLogWithScreenshot("Chargeable internet add on Pod is added to the cart");
        getRogersIgniteBundlesPage().addAdditionalPods(5);
        getRogersIgniteBundlesPage().clkContinueInternetAddon();

        reporter.hardAssert(getRogersIgniteBundlesPage().validateSmartHomeAddOnsHeader(),"SHM Add ons page loaded","SHM add ons page not loaded");
//        getRogersIgniteBundlesPage().addSHMAddOn();
//        reporter.reportLogWithScreenshot("SHM Add on added to cart");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.reportLogWithScreenshot("Continue to Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        //Validation for SHM Addon
        //reporter.hardAssert(getRogersIgniteBundlesPage().validateSHMMonthlyChargesInCartSummary(),"Monthly SHM charges present", "Monthly SHM charges not Present");
        //Validation for pods
        reporter.hardAssert(getRogersIgniteBundlesPage().validateInternetAddOnsInCartSummary(),"Internet AddOns present in cart summary", "Internet AddOns not present in cart summary");
        reporter.reportLogWithScreenshot("Cart Summary page");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();

        reporter.reportLogWithScreenshot("wish to continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to Credit Check Page");

        reporter.hardAssert(getCreditCheckPage().verifyCreditEvaluationHeader(), "Credit Check Page loaded", "Credit Check Page not loaded");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay());
        reporter.reportLogWithScreenshot("Credit Evaluation DOB set");
        getCreditCheckPage().setDriversLicense("British Columbia",FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("BC"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generatePassportNumber());
        reporter.reportLogWithScreenshot("credit form completed");
        getCreditCheckPage().clkAuthorize();
        reporter.reportLogWithScreenshot("Credit Check Authorized");
        reporter.hardAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to Install page");

        reporter.reportLogWithScreenshot("Launched the install page");
        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(), "Installation Page loaded","Installation Page not loaded");
        getBundleBuilderPage().selectExpressProInstall();
        reporter.reportLogWithScreenshot("Select Express Pro Install");
        getBundleBuilderPage().clkTechInstallSlot();
        reporter.reportLogWithScreenshot("Select tech install slot");
        getBundleBuilderPage().setMobileNumber();
        reporter.reportLogWithScreenshot("tech install details");
        getBundleBuilderPage().clkContinueInstallation();
        reporter.reportLogWithScreenshot("Billing and Payment page");
        getBundleBuilderPage().clkContinueBillingAndPayment();

        reporter.reportLogWithScreenshot("Continue to Order Review Page");
        reporter.hardAssert(getOVROrderReviewPage().verifyOrderOverviewHeader(), "Order Review Page Loaded", "Order Review Page Not loaded");
        reporter.hardAssert(getOVROrderReviewPage().verifyOneTimeFees(), "One time Fees is displayed", "One time fees not displayed");
        //validate SHM charges and Internet pods one time fees
        reporter.hardAssert(getOVROrderReviewPage().verifyMonthlyCharges(), "Monthly Charges is displayed", "Monthly Charges not displayed");
        reporter.hardAssert(getOVROrderReviewPage().verifyInternetAddOns(),"Internet AddOns present in cart summary", "Internet AddOns not present in cart summary");
        //Validation for SHM Addon monthly fees.
        //reporter.hardAssert(getOVROrderReviewPage().validateSHMMonthlyChargesInCartSummary(),"SMH charges present", "SHM add ons charges not present");
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
        //validate Internet pods one time fees
        reporter.hardAssert(getOVROrderConfirmationPage().verifyMonthlyCharges(), "Monthly Charges displayed", "Monthly charges not displayed");
        reporter.hardAssert(getOVROrderReviewPage().verifyInternetAddOns(),"Internet AddOns present in order confirmation", "Internet AddOns not present in order confirmation");
        //Validation for SHM Addon monthly fees.
        //reporter.hardAssert(getOVROrderReviewPage().validateSHMMonthlyChargesInCartSummary(),"SMH charges present", "SHM add ons charges not present");
    }
}
