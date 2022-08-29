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
 * TC06 - Regression - [RPPC] - Price plann change by selecting financing plan - Till Review Order page
 * @author praveen.kumar7
 */

public class RogersBFA_PROD_Sanity_TC06_PPC_FinancingPlan_Test extends BaseTestClass {

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("AWSPRODUrl"), strBrowser,strLanguage,RogersEnums.GroupName.buyflows, method);
    }

    @Test(groups = {"PRODSanity"})
    public void tc06_rogersProdSanity_PPC_SelectingFinancingPlan() {

        reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        reporter.reportLogWithScreenshot("Home Page");
        getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.BFA_ProdTest_tc06_PPC_FinancingPlan.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.BFA_ProdTest_tc06_PPC_FinancingPlan.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        //getRogersAccountOverviewPage().selectAccount(TestDataHandler.BFA_ProdTest_tc06_PPC_FinancingPlan.getBanNo());
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");

        reporter.hardAssert(getRogersAccountOverviewPage().verifyAndClickShareEverythingCTN(TestDataHandler.BFA_ProdTest_tc06_PPC_FinancingPlan.getCtn()),
                "CTN button is clicked", "CTN button is not clicked");
        reporter.reportLogWithScreenshot("Wireless Dashboard page");
        getRogersWirelessDashboardPage().clickMakeChangesToCurrentPlan();
        //--------------------------------------------Plan Config page----------------------------------------------
        getRogersCheckoutPage().clkNoThanks();
        reporter.hardAssert(getRogersPlanConfigPage().verifyPPCPlanConfigPage(),"PPC Build plan page is loaded successfully","PPC build plan page is not loaded");
        getRogersPlanConfigPage().clkChangePlan();
        reporter.reportLogWithScreenshot("Clicked on Change Plan");
        getRogersPlanConfigPage().selectPlanType(TestDataHandler.BFA_ProdTest_tc06_PPC_FinancingPlan.getNewPlanType(),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Plan Type is selected successfully");
        getRogersCheckoutPage().clkNoThanks();
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.BFA_ProdTest_tc06_PPC_FinancingPlan.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Data option selected");
        getRogersCheckoutPage().clkNoThanks();
        reporter.hardAssert(getRogersPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.BFA_ProdTest_tc06_PPC_FinancingPlan.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersCheckoutPage().clkNoThanks();
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        reporter.reportLogWithScreenshot("Addons option selected");
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        getRogersCheckoutPage().clkNoThanks();
        //getRogersPlanConfigPage().selectAdditionalLinePlanOptions();
        getRogersPlanConfigPage().clkContinueOnExistingAddonModal();
        //--------------------------------------Review Order Page-------------------------------------------------------
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");

    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }
}
