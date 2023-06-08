package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC03_Migration_1pINT_to_ISS_AdditionalSTB_E2E_Dealer_ON_EN_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("OVRURL"), strBrowser, strLanguage, RogersEnums.GroupName.ovr, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

    @Test(groups = {"OVR", "RegressionOVR","OVR_Sanity"})
    public void ovr_Auto_TC03_Migration_1pINT_to_ISS_AdditionalSTB_E2E_Dealer_ON_EN_Test()  {
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"), System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.ovrMigrationData1pINTtoISSATL.getBanNumber(), TestDataHandler.ovrMigrationData1pINTtoISSATL.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("search for account and select environment ");
        getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("Open IgniteLink from dashboard");
//        getAccountOverViewPage().selectProduction();
//        reporter.reportLogWithScreenshot("Select Environment as Production");
//        getAccountOverViewPage().clickProceed();
        getCheckAvailabilityPage().useThisAddress();
        reporter.reportLogWithScreenshot("Service Availability");
        reporter.hardAssert(getBundleBuilderPage().verifyCustomerCurrentPlan(), "Current Plan is displayed", "Current Plan is not displayed");
        reporter.hardAssert(getBundleBuilderPage().verifyOvrSessionTimer(), "Ovr Session Timer Present", "Ovr Session timer not present");
        reporter.hardAssert(getBundleBuilderPage().verifyBundleBuilderPage(), "Bundle Builder page is displayed", "Bundle Builder page is not displayed");
        reporter.reportLogWithScreenshot("Bundle Builder Page displayed");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        getRogersIgniteBundlesPage().clkSmartStream();
        reporter.reportLogWithScreenshot("Internet and ISS are Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("Load Offers");
        getRogersIgniteBundlesPage().selectAdditionalIgniteTVBoxes("2");
        reporter.reportLogWithScreenshot("2 Additional stb boxes added");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("Add to cart 1st offer");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to Points to mention pop-up");
        getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
        reporter.reportLogWithScreenshot("Review Points to mention");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();

        reporter.reportLogWithScreenshot("Continue to Internet Add Ons page");
        reporter.hardAssert(getRogersIgniteBundlesPage().validateInternetAddOnsHeader(),"Internet Add Ons Page loaded","Internet Add Ons Page not loaded");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to Cart Summary");

        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        reporter.reportLogWithScreenshot("Cart Summary Page");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("wish to continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.reportLogWithScreenshot("Customer Profile Page");
        getBundleBuilderPage().scrollAndClickContinue();

        reporter.hardAssert(getCreditCheckPage().verifyCreditEvaluationHeader(), "Credit Check Page loaded", "Credit Check Page not loaded");
//        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay());
//        reporter.reportLogWithScreenshot("Credit Evaluation Page");
//
//        getCreditCheckPage().setDriversLicense("British Columbia",FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("BC"));
//        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generatePassportNumber());
//        getCreditCheckPage().clkAuthorize();
//        reporter.hardAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
//        reporter.reportLogWithScreenshot("Credit Check Information");
//        getCreditCheckPage().clkContinue();
//
//        reporter.reportLogWithScreenshot("Continue to install options  page");
//        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(), "Installation Page loaded","Installation Page not loaded");
//        reporter.reportLogWithScreenshot("Install Options page");
//        getBundleBuilderPage().selectDeliveryByCourier();
//        //getBundleBuilderPage().clkTechInstallSlot();
//        //reporter.reportLogWithScreenshot("Time Slot selected");
//        //getBundleBuilderPage().setMobileNumber();
//        reporter.reportLogWithScreenshot("tech install details");
//        getBundleBuilderPage().clkContinueInstallation();
//
//        reporter.reportLogWithScreenshot("Billing and Payment page");
//        reporter.hardAssert(getBundleBuilderPage().verifyBillingAndPaymentPage(), "Billing and Payment page displayed", "Billing and payment page not displayed");
//        //reporter.hardAssert(getBundleBuilderPage().verifyStoredPaymentCardPresent(), "Stored Payment Card present", "Stored Payment card not present");
//        //reporter.reportLogWithScreenshot("Continue billing with stored payment method");
//        getBundleBuilderPage().clkContinueBillingAndPayment();
//        reporter.reportLogWithScreenshot("Order Review Page");
//        reporter.hardAssert(getOVROrderReviewPage().verifyOrderOverviewHeader(),"Order review page loaded","Order review page not loaded");
//        reporter.hardAssert(getOVROrderReviewPage().verifyOneTimeFees(), "One time Fees is displayed", "One time fees not displayed");
//        reporter.hardAssert(getOVROrderReviewPage().verifyMonthlyCharges(), "Monthly Charges is displayed", "Monthly Charges not displayed");
//        getOVROrderReviewPage().clkContinue();
//        reporter.reportLogWithScreenshot("Sign Agreement Page");
//        reporter.hardAssert(getOVRAgreementPage().verifySignAgreementPage(), "Agreement page displayed", "Agreement page not displayed");
//        getOVRAgreementPage().signAgreement();
//        reporter.reportLogWithScreenshot("Back to Agreement Page");
//        getOVRAgreementPage().clkAgreementCheckbox();
//        reporter.reportLogWithScreenshot("Agreement Checkbox clicked");
//        getOVRAgreementPage().clkCompleteOrder();
//        reporter.reportLogWithScreenshot("Order Confirmation Page");
//        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderConfirmation(), "Order Confirmation displayed", "Order not Confirmed");
//        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderNumberPresent(), "Order number successfully displayed", "Order number not displayed");
//        reporter.hardAssert(getOVROrderConfirmationPage().verifyOneTimeFees(), "One Time Fees Displayed", "One time fees not displayed");
//        reporter.hardAssert(getOVROrderConfirmationPage().verifyMonthlyCharges(), "Monthly Charges displayed", "Monthly charges not displayed");

    }
}
