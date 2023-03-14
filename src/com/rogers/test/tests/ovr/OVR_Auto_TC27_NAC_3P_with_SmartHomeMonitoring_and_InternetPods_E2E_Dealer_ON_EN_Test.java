package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC27_NAC_3P_with_SmartHomeMonitoring_and_InternetPods_E2E_Dealer_ON_EN_Test extends BaseTestClass {
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
    public void ovr_Auto_TC27_NAC_3P_with_SmartHomeMonitoring_and_InternetPods_E2E_Dealer_ON_EN_Test(){
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"), System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        reporter.reportLogWithScreenshot("Account Search Page");
        getAccountSearchPage().selectNewCustomerEnv(TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("QA Env selected for new customer");
//        getAccountOverViewPage().selectProduction();
//        reporter.reportLogWithScreenshot("Select Environment as Production");
//        getAccountOverViewPage().clickProceed();
        reporter.reportLogWithScreenshot("Address Availability popup");
        reporter.hardAssert(getCheckAvailabilityPage().verifyCheckAvailabilityPopup(),"Check Availability Popup present","Check Availability Popup not present" );
        getCheckAvailabilityPage().checkAvailability("642 ABANA RD. MISSISSAUGA, ON L5A1H4", "chrome");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),"Address is serviceable","Address is not serviceable");
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
        reporter.reportLogWithScreenshot("Select Services Customer Wants");
        reporter.hardAssert(getBundleBuilderPage().verifyOvrSessionTimer(), "Ovr Session Timer Present", "Ovr Session timer not present");
        reporter.hardAssert(getBundleBuilderPage().verifyBundleBuilderPage(), "Bundle Builder page is displayed", "Bundle Builder page is not displayed");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Internet Selected");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        reporter.reportLogWithScreenshot("TV Check box selected");
        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        reporter.reportLogWithScreenshot("Home Phone Selected");
        getRogersIgniteBundlesPage().clickSmartHomeMonitoring();
        reporter.reportLogWithScreenshot("SHM selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("Load offers");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("added to cart");
        getRogersIgniteBundlesPage().noPortInPopup();
        reporter.reportLogWithScreenshot("NO to port in popup");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        reporter.reportLogWithScreenshot("Continue from Bundles page with 3p bundle + SHM");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.reportLogWithScreenshot("Channel Personalization page");
        getRogersIgniteBundlesPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Channels and theme packs page");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to 4k tv popup");
        getRogersIgniteBundlesPage().fourKTVPopup();
        reporter.reportLogWithScreenshot("4k tv popup");
        getRogersIgniteBundlesPage().contiue4KContent();
        reporter.reportLogWithScreenshot("4k Content popup");

        //Internet Add-Ons page.
        reporter.reportLogWithScreenshot("Continue to Internet Add Ons page");
        reporter.hardAssert(getRogersIgniteBundlesPage().validateInternetAddOnsHeader(),"Internet Add Ons Page loaded","Internet Add Ons Page not loaded");
        getRogersIgniteBundlesPage().addPods(5);
        reporter.reportLogWithScreenshot("Chargeable internet add on Pod is added to the cart");
        getRogersIgniteBundlesPage().clkContinueInternetAddon();

        reporter.reportLogWithScreenshot("Continue to Home phone Add ons page");
        getHomePhoneAddonsPage().chooseAddon(TestDataHandler.ovrMigrationData3PTo3PATL.getAddOnPlan(),TestDataHandler.ovrMigrationData3PTo3PATL.getAddOnPlanFr());
        reporter.reportLogWithScreenshot("Addons selected for addition");
        getHomePhoneAddonsPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to SHM Add ons page");

        reporter.hardAssert(getRogersIgniteBundlesPage().validateSmartHomeAddOnsHeader(),"SHM Add ons page loaded","SHM add ons page not loaded");
        //SHM add ons changed
        getRogersIgniteBundlesPage().addSHMAddOn();
        reporter.reportLogWithScreenshot("SHM Add on added to cart");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.reportLogWithScreenshot("Continue to Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        reporter.hardAssert(getRogersIgniteBundlesPage().validateSHMMonthlyChargesInCartSummary(),"Monthly SHM charges present", "Monthly SHM charges not Present");
        //validation for pods
        reporter.hardAssert(getRogersIgniteBundlesPage().validateInternetAddOnsInCartSummary(),"Internet AddOns present in cart summary", "Internet AddOns not present in cart summary");
        reporter.reportLogWithScreenshot("Cart Summary page");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("wish to continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.reportLogWithScreenshot("Customer Profile Page");

        String email = getRogersOVCheckoutPage().setEmailCreateProfile();
        getRogersOVCheckoutPage().confirmEmailCreateProfile(email);
        reporter.reportLogWithScreenshot("Email entered for customer Profile");
        getRogersOVCheckoutPage().setFirstNameCreateProfile();
        getRogersOVCheckoutPage().setLastNameCreateProfile();
        reporter.reportLogWithScreenshot("First and Last name entered for customer Profile");
        getRogersOVCheckoutPage().setContactNumberCreateProfile("1010000061");
        reporter.reportLogPassWithScreenshot("Create Profile Page details");
        getBundleBuilderPage().scrollAndClickContinue();
        reporter.reportLogWithScreenshot("Continue to credit Check page");

        reporter.hardAssert(getCreditCheckPage().verifyCreditEvaluationHeader(), "Credit Check Page loaded", "Credit Check Page not loaded");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay());
        reporter.reportLogWithScreenshot("Credit Evaluation Page");
        getCreditCheckPage().setDriversLicense("British Columbia",FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("BC"));
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
        reporter.reportLogWithScreenshot("Continue from Home phone personalization");

        reporter.reportLogWithScreenshot("Continue to install options  page");
        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(), "Installation Page loaded","Installation Page not loaded");
        getBundleBuilderPage().selectExpressProInstall();
        reporter.reportLogWithScreenshot("Install Options");
        getBundleBuilderPage().clkTechInstallSlot();
        reporter.reportLogWithScreenshot("Time Slot selected");
        getBundleBuilderPage().setMobileNumber();
        reporter.reportLogWithScreenshot("tech install details");
        getBundleBuilderPage().clkContinueInstallation();
        reporter.reportLogWithScreenshot("Billing and Payment page");
        reporter.hardAssert(getBundleBuilderPage().verifyBillingAndPaymentPage(), "Billing and Payment page displayed", "Billing and payment page not displayed");
        getBundleBuilderPage().setDrpSelectBillingPaymentMethod("Monthly charges");
        reporter.reportLogWithScreenshot("Monthly billing selected");
        getBundleBuilderPage().clkContinueBillingAndPayment();
        reporter.reportLogWithScreenshot("Continue to Order Review Page");

        reporter.hardAssert(getOVROrderReviewPage().verifyOrderOverviewHeader(), "Order Review Page Loaded", "Order Review Page Not loaded");
        reporter.hardAssert(getOVROrderReviewPage().verifyOneTimeFees(), "One time Fees is displayed", "One time fees not displayed");

        reporter.hardAssert(getOVROrderReviewPage().verifyMonthlyCharges(), "Monthly Charges is displayed", "Monthly Charges not displayed");
        //Validation for SHM Addon monthly fees.
        reporter.hardAssert(getOVROrderReviewPage().validateSHMMonthlyChargesInCartSummary(),"SMH charges present", "SHM add ons charges not present");
        reporter.hardAssert(getOVROrderReviewPage().verifyInternetAddOns(),"Internet AddOns present in cart summary", "Internet AddOns not present in cart summary");
        reporter.reportLogWithScreenshot("Order review Page");

        getOVROrderReviewPage().clkContinue();
        reporter.reportLogWithScreenshot("Sign Agreement Page");
        reporter.hardAssert(getOVRAgreementPage().verifySignAgreementPage(), "Agreement page displayed", "Agreement page not displayed");
        getOVRAgreementPage().signAgreement();
        reporter.reportLogWithScreenshot("Back to Agreement Page");
        getOVRAgreementPage().clkAgreementCheckbox();
        getOVRAgreementPage().clkCompleteOrder();
        reporter.reportLogWithScreenshot("Order Confirmation Page");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderConfirmation(), "Order Confirmation displayed", "Order not Confirmed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderNumberPresent(), "Order number successfully displayed", "Order number not displayed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOneTimeFees(), "One Time Fees Displayed", "One time fees not displayed");

        reporter.hardAssert(getOVROrderConfirmationPage().verifyMonthlyCharges(), "Monthly Charges displayed", "Monthly charges not displayed");
        reporter.hardAssert(getOVROrderReviewPage().verifyInternetAddOns(),"Internet AddOns present in order confirmation", "Internet AddOns not present in cart summary");
        //Validation for SHM Addon monthly fees.
        reporter.hardAssert(getOVROrderReviewPage().validateSHMMonthlyChargesInCartSummary(),"SMH charges present", "SHM add ons charges not present");

    }
}
