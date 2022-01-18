package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * TC32 RPP - Verify the passcode for an Expired IDV account Price plan change for an existing Single line account from FIN to BYOD(Bring Yor Own Device) plan type and Validating downgrade fee popup
 * @author praveen.kumar7
 */

public class RogersBFA_TC32_RPP_PPC_SL_FinInTerm_selectingBYOD_DowngradeFee_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows, method);
    }

    @Test(groups = {"RegressionBFA","PPCBFA","RegressionOnlineBFA"})
    public void rogersRPP_PPC_TC32_SL_FINInTerm_BYODPlan_DowngradeFeeTest() {
        reporter.reportLog("URL:" + System.getProperty("QaUrl"));
        reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        reporter.reportLogWithScreenshot("Home Page");
        getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc32_RPP_PPC_SL_FinToBYOD_DowngradeFee.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc32_RPP_PPC_SL_FinToBYOD_DowngradeFee.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");
        getDriver().get(System.getProperty("AWSUrl")+"/build-plan?flowType=ppc");
        //--------------------------------------------Plan Config page----------------------------------------------
        reporter.reportLogWithScreenshot("Passcode validation modal is displayed");
        getRogersDeviceCataloguePage().enterPasscodeInPasscodeModal(TestDataHandler.tc32_RPP_PPC_SL_FinToBYOD_DowngradeFee.getPasscode());
        reporter.reportLogWithScreenshot("Passcode entered successfully in passcode modal");
        getRogersDeviceCataloguePage().clkContinueBtnPassCodeMoodal();
        reporter.hardAssert(getRogersPlanConfigPage().verifyPPCPlanConfigPage(),"PPC Build plan page is loaded successfully","PPC build plan page is not loaded");
        getRogersPlanConfigPage().clkChangePlan();
        reporter.reportLogWithScreenshot("Clicked on Change Plan");
        getRogersPlanConfigPage().selectPlanType(TestDataHandler.tc32_RPP_PPC_SL_FinToBYOD_DowngradeFee.getNewPlanType(),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Downgrade fee popup displayed");
        getRogersPlanConfigPage().verifyDowngradeFeeModalAndClkContinue();
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc32_RPP_PPC_SL_FinToBYOD_DowngradeFee.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Data option selected");
        reporter.hardAssert(getRogersPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.tc32_RPP_PPC_SL_FinToBYOD_DowngradeFee.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        reporter.reportLogWithScreenshot("Addons option selected");
        String monthlyFeesBeforeReviewPage = getRogersPlanConfigPage().getMonthlyFeesAmount();
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        getRogersPlanConfigPage().clkContinueOnExistingAddonModal();
        //--------------------------------------Review Order Page-------------------------------------------------------
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        String monthlyFeesInReviewPage = getRogersReviewOrderPage().getMonthlyFeeAfterTax();
        reporter.hardAssert(monthlyFeesBeforeReviewPage.equals(monthlyFeesInReviewPage),
                "Monthly fee amount displayed correctly", "Monthly fee amount is not displayed correctly in Review order page");
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Terms and conditions accepted");
        getRogersReviewOrderPage().clkSubmitOrderBtn();
        //---------------------------Order Confirmation Page--------------------------------------
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(),
                "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.reportLogPassWithScreenshot("Order Confirmation Page");

    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }
}
