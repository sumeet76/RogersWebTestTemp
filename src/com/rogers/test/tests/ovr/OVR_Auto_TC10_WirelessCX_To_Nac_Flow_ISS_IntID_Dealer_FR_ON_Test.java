package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC10_WirelessCX_To_Nac_Flow_ISS_IntID_Dealer_FR_ON_Test extends BaseTestClass {
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
    public void ovr_Auto_TC10_WirelessCX_To_Nac_Flow_ISS_IntID_Dealer_FR_ON_Test() throws InterruptedException {
        //getChampLoginPage().logIntoCorpChamp(System.getenv("champCorpUserName"), System.getenv("champCorpPassword"));
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"), System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getChampLoginPage().changeChampToFR();
        reporter.reportLogWithScreenshot("Changed Champ page to French");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        //getUniLoginPage().selectCorpSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        reporter.reportLogWithScreenshot("Account Search Page");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.ovrWirelessNacON.getBanNumber(),TestDataHandler.ovrWirelessNacON.getPostalCode(),TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("search for account and select environment ");
        getOvrDashboardPage().changeLangToFR();
        reporter.reportLogWithScreenshot("Ignite language Changed to French");
        getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("Open IgniteLink from dashboard");
        getCheckAvailabilityPage().useThisAddress();
        reporter.reportLogWithScreenshot("Service Availability");
        getCheckAvailabilityPage().addressIsServiceable();
        reporter.reportLogWithScreenshot("Address is serviceable");
        reporter.hardAssert(getBundleBuilderPage().verifyBundleBuilderPage(), "Bundle Builder page is displayed", "Bundle Builder page is not displayed");
        reporter.reportLogWithScreenshot("Bundle Builder Page");
        reporter.hardAssert(getBundleBuilderPage().verifyOvrSessionTimer(), "Ovr Session Timer Present", "Ovr Session timer not present");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        getRogersIgniteBundlesPage().clkSmartStream();
        reporter.reportLogWithScreenshot("Smart Stream and Internet are Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("Ignite Bundle Offers loaded");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("Bundle added to cart");
        getRogersIgniteBundlesPage().noPortInPopup();
        reporter.reportLogWithScreenshot("NO to Port-In pop-up");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.reportLogWithScreenshot("Continue to Internet Add Ons page");
        reporter.softAssert(getRogersIgniteBundlesPage().validateInternetAddOnsHeader(),"Internet Add Ons Page loaded","Internet Add Ons Page not loaded");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("wish to continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.reportLogWithScreenshot("Customer Profile Page");
        getCustomerProfilePage().clkContinue();

        reporter.reportLogWithScreenshot("Continue to Credit Check Page");
        reporter.softAssert(getCreditCheckPage().verifyCreditEvaluationHeader(), "Credit Eval Page displayed", "Credit Eval Page not displayed");
        reporter.reportLogWithScreenshot("Credit Check Page");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay());
        reporter.reportLogWithScreenshot("Credit Check DOB entered");
        getCreditCheckPage().selectInternationalID(FormFiller.generateRandomNumber(9), FormFiller.generateExpiryYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay(),
                FormFiller.generatePassportNumber(), FormFiller.generateExpiryYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay());
        reporter.reportLogWithScreenshot("credit form completed");
        getCreditCheckPage().clkAuthorize();
        reporter.reportLogWithScreenshot("Credit Check Authorized");
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");

        getCreditCheckPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to install options  page");
        reporter.hardAssert(getCreditCheckPage().verifyInstallationOption(), "Installation Page loaded","Installation Page not loaded");
        reporter.reportLogWithScreenshot("Launched the install options  page");
        getBundleBuilderPage().selectExpressProInstall();
        reporter.reportLogWithScreenshot("Install Options");
        getBundleBuilderPage().clkTechInstallSlot();
        getBundleBuilderPage().setMobileNumber();
        reporter.reportLogWithScreenshot("tech install details");
        getBundleBuilderPage().clkContinueInstallation();
        reporter.reportLogWithScreenshot("Continue to Billing and Payment page");
        reporter.hardAssert(getBundleBuilderPage().verifyBillingAndPaymentPage(), "Billing and Payment page displayed", "Billing and payment page not displayed");
        reporter.reportLogWithScreenshot("Billing and Payment Page");
        getBundleBuilderPage().clkContinueBillingAndPayment();
        reporter.reportLogWithScreenshot("Order Review Page");
        reporter.softAssert(getOVROrderReviewPage().verifyOneTimeFees(), "One time Fees is displayed", "One time fees not displayed");
        reporter.softAssert(getOVROrderReviewPage().verifyMonthlyCharges(), "Monthly Charges is displayed", "Monthly Charges not displayed");
        getOVROrderReviewPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to Sign Agreement Page");
        reporter.hardAssert(getOVRAgreementPage().verifySignAgreementPage(), "Agreement page displayed", "Agreement page not displayed");
        reporter.reportLogWithScreenshot("Sign Agreement Page");
        getOVRAgreementPage().signAgreement();
        reporter.reportLogWithScreenshot("Back to Agreement Page");
        getOVRAgreementPage().clkAgreementCheckbox();
        reporter.reportLogWithScreenshot("Agreement checkbox clicked");
        getOVRAgreementPage().clkCompleteOrder();
        reporter.reportLogWithScreenshot("Order Confirmation Page");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderConfirmation(), "Order Confirmation displayed", "Order not Confirmed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderNumberPresent(), "Order number successfully displayed", "Order number not displayed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOneTimeFees(), "One Time Fees Displayed", "One time fees not displayed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyMonthlyCharges(), "Monthly Charges displayed", "Monthly charges not displayed");

    }
}
