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
 * TC03 - MOM - PPC Complete
 * @author Nitin.Arora
 */

public class RogersMOM_TC03_PPC extends BaseTestClass {

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.buyflows, method);
    }

    @Test(groups = {"MOMSanity"})
    public void tc03RogersMOMPPC() throws InterruptedException {

        //--------- Launch Login page and sign in with using email id and password---------//
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.MOM_TC03_PPC.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.MOM_TC03_PPC.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();

        //--------- Validate Successful login to Overview page ---------//
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
                "Login Successful",
                "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");

        //--------- Click Manage button for individual line ---------//
        getRogersAccountOverviewPage().clickManageButton();
        reporter.reportLogWithScreenshot("Manage Button");

        //--------- Click on change plan button ---------//
        getRogersAccountOverviewPage().clickChangePlanButton();
        reporter.reportLogWithScreenshot("Change Plan");

        //--------- Click Continue button after plan ---------//
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        reporter.reportLogWithScreenshot("Continue Plan");

        //--------- Click Continue button after data option ---------//
        getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
        reporter.reportLogWithScreenshot("Continue Data");

        //--------- Click Continue button after add ons ---------//
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        reporter.reportLogWithScreenshot("Continue Add on");

        //--------- Click Proceed to checkout ---------//
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        reporter.reportLogWithScreenshot("Checkout");

        //--------- Verify Auto Payment Page is loaded ---------//
        reporter.hardAssert(getRogersCheckoutPage().verifyAutoPaymentPage(),
                "Auto Payment Page Loaded Successfully",
                "Auto Payment Page Load Failed");
        reporter.reportLogWithScreenshot("Auto Payment Page");

        //--------- Click Skip Auto Pay option ---------//
        getRogersCheckoutPage().clickSkipAutopay();
        reporter.reportLogWithScreenshot("Skip Auto Pay");

        //--------- Click Continue button and handle pop-up---------//
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogWithScreenshot("Continue Button");

        //--------- Click Credit Authorization checkbox ---------//
        getRogersCheckoutPage().clkCreditAuthorizationChkBox();
        reporter.reportLogWithScreenshot("Credit Authorization Check Box");

        //--------- Click Submit button ---------//
        getRogersReviewOrderPage().clkSubmitOrderBtn();

        //--------- Order Confirmation ---------//
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(),
                "Order Confirmation page loaded",
                "Order Confirmation Error");
        reporter.reportLogPassWithScreenshot("Order Confirmation Page");
        reporter.hardAssert(getRogersCheckoutPage().getCheckoutTitle().getText().contains("Order Confirmation"),
                "Order Successful",
                "Order Successful Page Failed");

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }

}
