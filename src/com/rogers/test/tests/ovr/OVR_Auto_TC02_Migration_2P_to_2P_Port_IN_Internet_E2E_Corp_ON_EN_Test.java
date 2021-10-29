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
        closeSession();
    }

    @Test(groups = {"OVR", "RegressionOVR"})
    public void ovr_Auto_TC02_Migration_2P_to_2P_Port_IN_Internet_E2E_Corp_ON_EN_Test() throws InterruptedException {
        getChampLoginPage().logIntoCorpChamp(System.getenv("champCorpUserName"), System.getenv("champCorpPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspdealercode());
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
        reporter.reportLogWithScreenshot("Bundle Builder Page displayed");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Internet and TV are Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        getRogersIgniteBundlesPage().yesPortInPopup();
        reporter.reportLogWithScreenshot("Port In Pop-up");

        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        reporter.reportLogWithScreenshot("Points to mention pop-up");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        reporter.reportLogWithScreenshot("Channel Personalization page");
        getRogersIgniteBundlesPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Channels and theme packs page");
        getRogersIgniteBundlesPage().clickReviewAddons();
        reporter.reportLogWithScreenshot("Reviewed customer's add ons");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().fourKTVPopup();
        getRogersIgniteBundlesPage().contiue4KContent();

        reporter.hardAssert(getRogersIgniteBundlesPage().headerPortInService(),"Port in Service Header exist","Failed");
        reporter.reportLogWithScreenshot("Port In Service");
        getRogersIgniteBundlesPage().setProvider("BELL ONTARIO");
        getRogersIgniteBundlesPage().enterAccountNumber("1122334455");
        reporter.reportLogWithScreenshot("Port In completed");
        getRogersIgniteBundlesPage().contiueFromPortIn();
        getRogersIgniteBundlesPage().contiueToCartSummary();
        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();

        reporter.reportLogWithScreenshot("wish to continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();

        getBundleBuilderPage().enterdateOfBirth(FormFiller.generateDOBYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay());
        reporter.reportLogWithScreenshot("Credit Evaluation Page");
        getBundleBuilderPage().creditevaluationAndContinue();
        reporter.reportLogWithScreenshot("Launched the install options  page");
        getBundleBuilderPage().selectExpressProInstall();
        getBundleBuilderPage().clkTechInstallSlot();
        getBundleBuilderPage().setMobileNumber();
        reporter.reportLogWithScreenshot("tech install details");
        getBundleBuilderPage().clkContinueInstallation();
        reporter.reportLogWithScreenshot("Billing and Payment Details");
        getBundleBuilderPage().clkContinueBillingAndPayment();
        reporter.reportLogWithScreenshot("Order Review Page");
        reporter.softAssert(getOVROrderReviewPage().verifyOneTimeFees(), "One time Fees is displayed", "One time fees not displayed");
        reporter.softAssert(getOVROrderReviewPage().verifyMonthlyCharges(), "Monthly Charges is displayed", "Monthly Charges not displayed");
        getOVROrderReviewPage().clkContinue();
        reporter.reportLogWithScreenshot("Sign Agreement Page");
        getOVRAgreementPage().signAgreement();
        getOVRAgreementPage().clkAgreementCheckbox();
        getOVRAgreementPage().clkCompleteOrder();
        reporter.reportLogWithScreenshot("Order Confirmation Page");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderConfirmation(), "Order Confirmation displayed", "Order not Confirmed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderNumberPresent(), "Order number successfully displayed", "Order number not displayed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOneTimeFees(), "One Time Fees Displayed", "One time fees not displayed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyMonthlyCharges(), "Monthly Charges displayed", "Monthly charges not displayed");

    }

}
