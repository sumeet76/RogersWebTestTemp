package com.rogers.test.tests.ovr;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;
import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC02_Migration_2P_to_2P_Port_IN_Internet_E2E_Corp_ON_EN_Test extends BaseTestClass {
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
    public void ovr_Auto_TC02_Migration_2P_to_2P_Port_IN_Internet_E2E_Corp_ON_EN_Test() {
        getChampLoginPage().logIntoCorpChamp(System.getenv("champCorpUserName"), System.getenv("champCorpPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectCorpSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.ovrMigrationData2PInternetAndTvTo2P.getBanNumber(), TestDataHandler.ovrMigrationData2PInternetAndTvTo2P.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("search for account and select environment ");
        getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("Open IgniteLink from dashboard");
        getCheckAvailabilityPage().useThisAddress();
        reporter.reportLogWithScreenshot("Service Availability");
        reporter.hardAssert(getBundleBuilderPage().verifyCustomerCurrentPlan(), "Current Plan is displayed", "Current Plan is not displayed");
        reporter.hardAssert(getBundleBuilderPage().verifyOvrSessionTimer(), "Ovr Session Timer Present", "Ovr Session timer not present");
        reporter.hardAssert(getBundleBuilderPage().verifyBundleBuilderPage(), "Bundle Builder page is displayed", "Bundle Builder page is not displayed");
        reporter.reportLogWithScreenshot("Bundle Builder Page displayed");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Internet and TV are Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("Load Offers");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("Add to cart 1st offer");
        getRogersIgniteBundlesPage().yesPortInPopup();
        reporter.reportLogWithScreenshot("Yes to Port In Pop-up");

        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to Points to mention pop-up");
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        reporter.reportLogWithScreenshot("Review Points to mention");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();

        reporter.reportLogWithScreenshot("Channel Personalization page");
        getRogersIgniteBundlesPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Channels and theme packs page");
        getRogersIgniteBundlesPage().clickReviewAddons();
        reporter.reportLogWithScreenshot("Reviewed customer's add ons");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to 4k tv popup");
        getRogersIgniteBundlesPage().fourKTVPopup();
        reporter.reportLogWithScreenshot("4k content modal");
        getRogersIgniteBundlesPage().contiue4KContent();

        reporter.reportLogWithScreenshot("Continue to Internet Add Ons page");
        reporter.hardAssert(getRogersIgniteBundlesPage().validateInternetAddOnsHeader(),"Internet Add Ons Page loaded","Internet Add Ons Page not loaded");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("continue to port in page");

        reporter.hardAssert(getRogersIgniteBundlesPage().headerPortInService(), "Port in page loaded", "Port in page error");
        reporter.reportLogWithScreenshot("Port In Service page");
        getRogersIgniteBundlesPage().setProvider("BELL ONTARIO");
        getRogersIgniteBundlesPage().enterAccountNumber("1122334455");
        reporter.reportLogWithScreenshot("Port In form completed");
        getRogersIgniteBundlesPage().contiueFromPortIn();
        reporter.reportLogWithScreenshot("Continue from port in");
        getRogersIgniteBundlesPage().contiueToCartSummary();
        reporter.reportLogWithScreenshot("Continue to Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        reporter.reportLogWithScreenshot("Cart Summary Page");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();

        reporter.reportLogWithScreenshot("wish to continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to Credit Check Page");

        reporter.hardAssert(getCreditCheckPage().verifyCreditEvaluationHeader(), "Credit Eval Page displayed", "Credit Eval Page not displayed");
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
        reporter.reportLogWithScreenshot("Continue to Install page");

        reporter.reportLogWithScreenshot("Continue to install options  page");
        reporter.hardAssert(getCreditCheckPage().verifyInstallationOption(), "Installation Page loaded","Installation Page not loaded");
        reporter.reportLogWithScreenshot("Installation Page");
        getBundleBuilderPage().selectExpressProInstall();
        reporter.reportLogWithScreenshot("Select Express Pro install");
        getBundleBuilderPage().clkTechInstallSlot();
        reporter.reportLogWithScreenshot("Select tech install slot");
        getBundleBuilderPage().setMobileNumber();
        reporter.reportLogWithScreenshot("tech install details");
        getBundleBuilderPage().clkContinueInstallation();
        reporter.reportLogWithScreenshot("Continue to Billing and Payment Page");
        reporter.hardAssert(getBundleBuilderPage().verifyBillingAndPaymentPage(), "Billing and Payment page loaded", "Billing and Payment page error");
        reporter.reportLogWithScreenshot("Billing and Payment Page");
        getBundleBuilderPage().clkContinueBillingAndPayment();
        reporter.reportLogWithScreenshot("Order Review Page");
        reporter.hardAssert(getOVROrderReviewPage().verifyOneTimeFees(), "One time Fees is displayed", "One time fees not displayed");
        reporter.hardAssert(getOVROrderReviewPage().verifyMonthlyCharges(), "Monthly Charges is displayed", "Monthly Charges not displayed");
        getOVROrderReviewPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue to Sign Agreement Page");
        reporter.hardAssert(getOVRAgreementPage().verifySignAgreementPage(), "Agreement page displayed", "Agreement page not displayed");
        reporter.reportLogWithScreenshot("Sign Agreement Page");
        getOVRAgreementPage().signAgreement();
        reporter.reportLogWithScreenshot("Back to Agreement Page");
        getOVRAgreementPage().clkAgreementCheckbox();
        reporter.reportLogWithScreenshot("Agreement Checkbox clicked");
        getOVRAgreementPage().clkCompleteOrder();
        reporter.reportLogWithScreenshot("Order Confirmation Page");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderConfirmation(), "Order Confirmation displayed", "Order not Confirmed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderNumberPresent(), "Order number successfully displayed", "Order number not displayed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOneTimeFees(), "One Time Fees Displayed", "One time fees not displayed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyMonthlyCharges(), "Monthly Charges displayed", "Monthly charges not displayed");

    }

}
