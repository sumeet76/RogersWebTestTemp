package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC16_ExistingIgniteISS_Cx_to_NAC_3P_CheckAnotherAddress_Dealer_EN_ON_Test extends BaseTestClass {
    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("OVRURL"), strBrowser, strLanguage, RogersEnums.GroupName.ovr, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }

    @Test(groups = {"OVR", "RegressionOVR"})
    public void ovr_Auto_TC16_ExistingIgniteISS_Cx_to_NAC_3P_CheckAnotherAddress_Dealer_EN_ON_Test() throws InterruptedException {
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"), System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        //Use OSRCP as dealer code for ExistingIgniteAccounts.
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspIgniteDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        reporter.reportLogWithScreenshot("Account Search Page");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.existingIgniteCxToNac3pON.getBanNumber(), TestDataHandler.existingIgniteCxToNac3pON.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("search for account and select environment ");
        getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("Open IgniteLink from dashboard");

        reporter.reportLogWithScreenshot("Address Availability popup");
        getCheckAvailabilityPage().checkAvailabilityAtOtherAddress("642 ABANA RD. MISSISSAUGA, ON L5A1H4", "chrome");
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
        reporter.reportLogWithScreenshot("HomePhone selected");
        reporter.reportLogWithScreenshot("3P services selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("Click on Load offers");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("Add to cart 1st offer");
        getRogersIgniteBundlesPage().noPortInPopup();
        reporter.reportLogWithScreenshot("No to port in popup");

        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.reportLogWithScreenshot("Continue to Channel Personalization page");
        getRogersIgniteBundlesPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Channels and theme packs page");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("4k tv pop up");
        getRogersIgniteBundlesPage().fourKTVPopup();
        reporter.reportLogWithScreenshot("4k Content Popup");
        getRogersIgniteBundlesPage().contiue4KContent();
        reporter.reportLogWithScreenshot("Continue to Internet Add Ons page");
        reporter.hardAssert(getRogersIgniteBundlesPage().validateInternetAddOnsHeader(),"Internet Add Ons Page loaded","Internet Add Ons Page not loaded");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("continue to Home Phone add ons");

        getHomePhoneAddonsPage().chooseAddon(TestDataHandler.legacy1PtoNac3pNewAddress.getAddOnPlan(),TestDataHandler.legacy1PtoNac3pNewAddress.getAddOnPlanFr());
        reporter.reportLogWithScreenshot("Addons selected for addition");
        getHomePhoneAddonsPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to Cart Summary Page");
        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("wish to continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.reportLogWithScreenshot("Customer Profile Page");
        getCreditCheckPage().clkAuthorize();
        getBundleBuilderPage().scrollAndClickContinue();

        reporter.reportLogWithScreenshot("Continue to Home Phone Selection Page");
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        reporter.hardAssert(getHomePhoneSelectionPage().verifySelectedNumber(),"Phone Number Selected","Phone Number Selection Failed");
        reporter.reportLogWithScreenshot("Phone Number Selected");
        reporter.hardAssert(getHomePhoneSelectionPage().verifyNumber(),"Phone Number Selected","Phone Number Selection Failed");
        getHomePhoneSelectionPage().clkContinue();

        reporter.reportLogWithScreenshot("Continue to install options  page");
        reporter.hardAssert(getCreditCheckPage().verifyInstallationOption(), "Installation Page loaded","Installation Page not loaded");
        reporter.reportLogWithScreenshot("Installation Page");
        getBundleBuilderPage().selectDeliveryByAppointmentInstall();
        reporter.reportLogWithScreenshot("Select install by appointment");
        getBundleBuilderPage().clkTechInstallSlot();
        reporter.reportLogWithScreenshot("Select a time slot");
        getBundleBuilderPage().setMobileNumber();
        reporter.reportLogWithScreenshot("tech install details");
        getBundleBuilderPage().clkContinueInstallation();
//        reporter.reportLogWithScreenshot("Billing and Payment page");
//        reporter.hardAssert(getBundleBuilderPage().verifyBillingAndPaymentPage(), "Billing and Payment page displayed", "Billing and payment page not displayed");
//        reporter.reportLogWithScreenshot("Monthly billing selected");
//        getBundleBuilderPage().clkContinueBillingAndPayment();

        reporter.reportLogWithScreenshot("Continue to Order Review Page");
        reporter.hardAssert(getOVROrderReviewPage().verifyOrderoverviewHeader(),"Order review page loaded","Order review page not loaded");
        reporter.hardAssert(getOVROrderReviewPage().verifyOneTimeFees(), "One time Fees is displayed", "One time fees not displayed");
        reporter.hardAssert(getOVROrderReviewPage().verifyMonthlyCharges(), "Monthly Charges is displayed", "Monthly Charges not displayed");
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

    }
}
