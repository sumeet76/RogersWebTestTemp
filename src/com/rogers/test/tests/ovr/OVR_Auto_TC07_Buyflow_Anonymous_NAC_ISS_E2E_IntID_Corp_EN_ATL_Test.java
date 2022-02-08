package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC07_Buyflow_Anonymous_NAC_ISS_E2E_IntID_Corp_EN_ATL_Test extends BaseTestClass {
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
    public void ovr_Auto_TC07_Buyflow_Anonymous_NAC_ISS_E2E_IntID_Corp_EN_ATL_Test() {
        getChampLoginPage().logIntoCorpChamp(System.getenv("champCorpUserName"), System.getenv("champCorpPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectCorpSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        reporter.reportLogWithScreenshot("Account Search Page");
        getAccountSearchPage().selectNewCustomerEnv(TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("QA Env selected for new customer");
        reporter.reportLogWithScreenshot("Address Availability popup");
        getCheckAvailabilityPage().checkAvailability("12294-247 AIRPORT HEIGHTS DR. ST. JOHN'S, NL A1A4X3", "chrome");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),"This address is serviceable","This Address is not serviceable");
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
        reporter.reportLogWithScreenshot("Select Services Customer Wants");
        reporter.hardAssert(getBundleBuilderPage().verifyOvrSessionTimer(), "Ovr Session Timer Present", "Ovr Session timer not present");
        reporter.hardAssert(getBundleBuilderPage().verifyBundleBuilderPage(), "Bundle Builder page is displayed", "Bundle Builder page is not displayed");
        reporter.reportLogWithScreenshot("Bundle Builder Page");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("SAI Selected");
        getRogersIgniteBundlesPage().clkSmartStream();
        reporter.reportLogWithScreenshot("Smart Stream Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("Load offers");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("added to cart");
        getRogersIgniteBundlesPage().noPortInPopup();
        reporter.reportLogWithScreenshot("No to PortIn Popup");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        reporter.reportLogWithScreenshot("CheckOut internet and ISS bundle");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to Internet Add Ons page");
        getRogersIgniteBundlesPage().clkExpressCheckout();
        reporter.reportLogWithScreenshot("Continue to Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        reporter.reportLogWithScreenshot("Cart Summary page");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("wish to continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();

        reporter.reportLogWithScreenshot("continue to Customer Profile Page");
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
        getCreditCheckPage().selectInternationalID(FormFiller.generateRandomNumber(9), FormFiller.generateExpiryYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay(),
                FormFiller.generatePassportNumber(), FormFiller.generateExpiryYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay());
        reporter.reportLogWithScreenshot("credit form completed");
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();

        reporter.reportLogWithScreenshot("Continue to install options  page");
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("Installation Page");
        getBundleBuilderPage().selectExpressProInstall();
        reporter.reportLogWithScreenshot("Install Options");
        getBundleBuilderPage().clkTechInstallSlot();
        reporter.reportLogWithScreenshot("Select a time slot");
        getBundleBuilderPage().setMobileNumber();
        reporter.reportLogWithScreenshot("tech install details");
        getBundleBuilderPage().clkContinueInstallation();
        reporter.reportLogWithScreenshot("Billing and Payment page");
        reporter.hardAssert(getBundleBuilderPage().verifyBillingAndPaymentPage(), "Billing and Payment page displayed", "Billing and payment page not displayed");
        getBundleBuilderPage().setDrpSelectBillingPaymentMethod("Monthly charges");
        reporter.reportLogWithScreenshot("Monthly billing selected");
        getBundleBuilderPage().clkContinueBillingAndPayment();
        reporter.reportLogWithScreenshot("Continue to Order Review Page");
        reporter.softAssert(getOVROrderReviewPage().verifyOneTimeFees(), "One time Fees is displayed", "One time fees not displayed");
        reporter.softAssert(getOVROrderReviewPage().verifyMonthlyCharges(), "Monthly Charges is displayed", "Monthly Charges not displayed");
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
