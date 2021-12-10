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
 * TC37 - RPP Customer - Price plan change for an existing Multi line Shared account from Financing to BYOD plan type(DTT plan) on additional line
 * @author praveen.kumar7
 */

public class RogersBFA_TC37_RPP_PPC_ML_SE_FinOutTermToBYODPlanOnAdditionalLine_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows, method);
    }

    @Test(groups = {"RegressionBFA","PPCBFA","RegressionOnlineBFA"})
    public void rogersPPC_TC37_ML_SE_FinOutTerm_SelectingBYODPlanTest() {
        reporter.reportLog("URL:" + System.getProperty("QaUrl"));
        reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        reporter.reportLogWithScreenshot("Home Page");
        getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc37RPP_PPC_ML_SE_BYODToBYODPlanOnAdditionalLine.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc37RPP_PPC_ML_SE_BYODToBYODPlanOnAdditionalLine.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");
        getDriver().get(System.getProperty("AWSUrl")+"/build-plan?flowType=ppc");
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed() , "CTN selection Modal window displayed on the screen " ,"CTN selection Modal window not displayed on the screen");
        reporter.reportLogWithScreenshot("CTN Modal window displayed on the screen");
        getRogersDeviceCataloguePage().selectCTN(TestDataHandler.tc37RPP_PPC_ML_SE_BYODToBYODPlanOnAdditionalLine.getCtn());
        getRogersDeviceCataloguePage().clkContinueBtnPPCShareNonShareModal();
        //--------------------------------------------Plan Config page----------------------------------------------
        reporter.hardAssert(getRogersPlanConfigPage().verifyPPCPlanConfigPage(),"PPC Build plan page is loaded successfully","PPC build plan page is not loaded");
        getRogersPlanConfigPage().clkChangePlan();
        reporter.reportLogWithScreenshot("Clicked on Change Plan");
        getRogersPlanConfigPage().selectPlanType(TestDataHandler.tc37RPP_PPC_ML_SE_BYODToBYODPlanOnAdditionalLine.getNewPlanType());
        reporter.reportLogPassWithScreenshot("Plan Type is selected successfully");
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc37RPP_PPC_ML_SE_BYODToBYODPlanOnAdditionalLine.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Data option selected");
        reporter.hardAssert(getRogersPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.tc37RPP_PPC_ML_SE_BYODToBYODPlanOnAdditionalLine.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        reporter.reportLogWithScreenshot("Addons option selected");
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        //--------------------------------------Review Order Page-------------------------------------------------------
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
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
