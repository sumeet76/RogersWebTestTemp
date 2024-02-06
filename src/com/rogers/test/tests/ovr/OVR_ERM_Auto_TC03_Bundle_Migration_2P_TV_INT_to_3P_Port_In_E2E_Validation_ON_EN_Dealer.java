package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_ERM_Auto_TC03_Bundle_Migration_2P_TV_INT_to_3P_Port_In_E2E_Validation_ON_EN_Dealer extends BaseTestClass {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("OVRURL"), strBrowser, strLanguage, RogersEnums.GroupName.ovr, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

    @Test(groups = {"OVR_ERM", "RegressionERM"})
    public void ovr_ERM_Auto_TC03_Bundle_Migration_2P_TV_INT_to_3P_Port_In_E2E_Validation_ON_EN_Dealer() {
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"), System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.tc_03_Ovr_ERM_Mig_Data_2p_to_3p.getBanNumber(), TestDataHandler.tc_03_Ovr_ERM_Mig_Data_2p_to_3p.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("search for account and select environment ");
        reporter.reportLogWithScreenshot("Account Search Page");
       // getAccountSearchPage().searchForAccount("768903215","L5A1H4");
       // getAccountSearchPage().selectNewCustomerEnv(TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("QA Env selected for new customer");
        //getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        //getAccountOverViewPage().clickProceed();
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
        reporter.reportLogWithScreenshot("3P services selected");
       getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        getRogersIgniteBundlesPage().yesPortInPopup();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
        reporter.reportLogWithScreenshot("Term and condition checkbox checked");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        reporter.reportLogWithScreenshot("Port In Service");
       // getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("phone no for Port IN");
       getRogersIgniteBundlesPage().enterHomePhoneNumberPortIn("9052909983");
        reporter.reportLogWithScreenshot("phone no for Port IN");
//       getRogersIgniteBundlesPage().clkContinueFor3PPortIn();
        // getRogersIgniteBundlesPage().clkTVCheckbox();
        reporter.reportLogWithScreenshot("portin");
        getRogersIgniteBundlesPage().clkContinueFor3PPortIn();
        reporter.reportLogWithScreenshot("Port In initiated");
      //  getRogersIgniteBundlesPage().setProvider("BELL ONTARIO");
        reporter.reportLogWithScreenshot("provider");
        getRogersIgniteBundlesPage().enterAccountNumber("1122334455");
        reporter.reportLogWithScreenshot("portin details");
        getRogersIgniteBundlesPage().contiueFromPortIn();
        reporter.reportLogWithScreenshot("portin continue");
        getRogersIgniteBundlesPage().contiueToCartSummary();
//        getRogersIgniteBundlesPage().clickExchangeLater();
//        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clickAddOnLink();
        reporter.reportLogWithScreenshot("Review Points to mention");
        //getRogersIgniteBundlesPage().clkContinue();//.clickContinueFromPointsToMention();

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
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        reporter.reportLogWithScreenshot("cart summary");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("credit form");
        reporter.softAssert(getCreditCheckPage().verifyCreditEvaluationHeader(),"Credit Evaluation Header verified","Failed");
        reporter.reportLogWithScreenshot("Credit check page is displayed");
        reporter.reportLogWithScreenshot("evaluation form");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
       getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
     getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        reporter.reportLogWithScreenshot("filled customer credit form");
       getCreditCheckPage().clkAuthorize();
       // getCreditCheckPage().clkContinue();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        getCallerInformationPage().clickFinalContinue();
       // getHomePhoneSelectionPage().clkGeneratePhoneNo();
        reporter.reportLogWithScreenshot("generate phone number");
        //reporter.reportLogWithScreenshot("Phone Number Selected");
       // getCreditCheckPage().goToPageBottom();
        //reporter.reportLogWithScreenshot("continue");
       // getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
        //reporter.reportLogWithScreenshot("Phone number generated");
//        getHomePhoneSelectionPage().clkContinue();
       reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
//        reporter.hardAssert(getCreditCheckPage().verifyRecoEngineRecommendation(),"Reco Engine Install Recommendation Banner displayed"," Reco Engine Install Recommendation Banner is not displayed");
//        reporter.hardAssert(getCreditCheckPage().verifyRecommendationBanner(),"Recommended Banner is displayed", "Recommeded Banner is not displayed");reporter.reportLogWithScreenshot("Installation options");
        reporter.reportLogWithScreenshot("Continue to install options  page");
        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(), "Installation Page loaded","Installation Page not loaded");
        getCreditCheckPage().clickDateTimeRadioButton();
        getFulfillmentPage().clkFirstAvailableAppointment();
        reporter.reportLogWithScreenshot(".enter Text Mobile Number");
        getCreditCheckPage().enterTextMobileNumber("4156383833");
        //TestDataHandler.anonymousData.contactDetails.getPhoneNo());
        // getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());      reporter.reportLogWithScreenshot(".enter Special Instructions");
        getCreditCheckPage().enterSpecialInstructions();
        getCreditCheckPage().clkContinueInstallationOption();
        reporter.reportLogWithScreenshot("Billing and Payment page");
        reporter.hardAssert(getBundleBuilderPage().verifyBillingAndPaymentPage(), "Billing and Payment page displayed", "Billing and payment page not displayed");
        getBundleBuilderPage().clkContinueBillingAndPayment();

        reporter.reportLogWithScreenshot("Continue to Order Review Page");
        reporter.hardAssert(getOVROrderReviewPage().verifyOrderOverviewHeader(), "Order Review Page Loaded", "Order Review Page Not loaded");
        reporter.hardAssert(getOVROrderReviewPage().verifyOneTimeFees(), "One time Fees is displayed", "One time fees not displayed");
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
    }
}
