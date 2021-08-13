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
 * TC22 - Rogers Add a line with by selecting Non share option and Standard shipping - E2E
 * @author praveen.kumar7
 */

public class RogersBFA_TC22_AAL_BYOD_NonShareStdShipping_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows, method);
    }

    @Test(groups = {"RegressionBFA","AALBFA"})
    public void rogersAalByodNonShareStdShippingTest() {
        reporter.reportLog("URL:" + System.getProperty("QaUrl"));
        reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        reporter.reportLogWithScreenshot("Home Page");
        getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc22AALBYODStandardShipping.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc22AALBYODStandardShipping.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");
        getDriver().get(System.getProperty("AWSUrl")+"?flowType=aal");
        //------------------------------------Device Catalog page--------------------------------------------
        //reporter.softAssert(getRogersDeviceCataloguePage().verifyCreditEvaluationPopupPresent(), "Credit Evaluation Popup Displayed", "Credit Evaluation popup not disaplayed");
        //reporter.softAssert(getRogersDeviceCataloguePage().verifyCreditEvalTextOnModalPresent(), "Credit Evaluation Text Displayed", "Credit Evaluation Text not disaplayed on Modal");
        reporter.hardAssert(getRogersDeviceCataloguePage().verifySharedNonSharedModalPresent(), "Shared/Nonshared modal displayed", "Shared/Nonshared modal not displayed");
        reporter.reportLogWithScreenshot("Shared/Nonshared modal popup");
        String aalSharingType = TestDataHandler.tc22AALBYODStandardShipping.getSharingType();
        getRogersDeviceCataloguePage().selectAALSharingType(aalSharingType);
        reporter.reportLogPassWithScreenshot(aalSharingType+ " option selected successfully");
        getRogersDeviceCataloguePage().clickContinueButtonOnModal();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyByodDeviceTile(), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        reporter.reportLogWithScreenshot("Device Catalog Page");
        getRogersDeviceCataloguePage().clkByodDeviceTileContinueBtn();
        //-------------------------------------Plan config page---------------------------------------------
        reporter.softAssert(getRogersPlanConfigPage().verifyAalByodBreadCrumb(),
                "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        reporter.hardAssert(getRogersPlanConfigPage().verifyByodSelectedDeviceSection(), "Plan Config loaded", "Plan config page not loaded");
        getRogersPlanConfigPage().clkBasicTab();
        getRogersPlanConfigPage().selectBasicPlanAndClkContinueBtn(TestDataHandler.tc05NACByodSS.getDataOptionIndex());
        reporter.reportLogPassWithScreenshot("Data option selected");
        reporter.hardAssert(getRogersPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.tc22AALBYODStandardShipping.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersPlanConfigPage().setUserNameCallerID();
        reporter.reportLogWithScreenshot("CalledID details entered");
        String monthlyFeesAmountWithTax = getRogersPlanConfigPage().getMonthlyFeesAmount();
        String oneTimeFeesAmountWithTax = getRogersPlanConfigPage().getOneTimeFeesAmount();
        reporter.reportLog("Checkout page Cart Summary Info" + "1. Total Monthly Fees " + monthlyFeesAmountWithTax + "2. oneTimeFee " + oneTimeFeesAmountWithTax);
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        //---------------------------------------Checkout pages---------------------------------------------------------
        reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
        reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc22AALBYODStandardShipping.getCtnCity());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
        getRogersCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
        getRogersCheckoutPage().clkChooseNumberbutton();
        reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(), "Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
        /*reporter.hardAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
                "Billing Address is not selected");*/
        getRogersCheckoutPage().clkDeliveryMethod("standard");
        reporter.reportLogPassWithScreenshot("Standard Delivery selected");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
        //--------------------------------------Review Order Page-------------------------------------------------------
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        getRogersReviewOrderPage().clkAllAgreementConsentCheckbox("financing");
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkSubmitOrderBtn();
        //--------------------------------------Order Confirmation Page-------------------------------------------------------
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        String totalMonthlyFeesConfirmationPage = getRogersOrderConfirmationPage().getMonthlyFeeAfterTax();
        reporter.reportLogWithScreenshot("Cart summary of Order confirmation page");
        reporter.hardAssert(monthlyFeesAmountWithTax.equals(totalMonthlyFeesConfirmationPage),
                "Total Monthly Fee after tax matches with checkout page", "Total Monthly Fee after tax not matches with checkout page");
        String oneTimeFeesConfirmationPage = getRogersOrderConfirmationPage().getOneTimeFeeAfterTax();
        reporter.reportLogWithScreenshot("Order confirmation page - Cart summary One Time fee section");
        reporter.hardAssert(oneTimeFeesAmountWithTax.equals(oneTimeFeesConfirmationPage),
                "Total One time fee after tax matches with checkout page", "Total One time fee after tax not matches with checkout page");

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }
}
