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
 * TC31 - Rogers Add a line BYOD with Standard shipping option for a RPP account- E2E
 * @author praveen.kumar7
 */

public class RogersBFA_TC31_RPP_AAL_BYOD_StdShipping_DP_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows, method);
    }

    @Test(groups = {"RegressionBFA","RPPAAL","DPBYOD"})
    public void tc31_rogersRPPAalByodStdShipTest() {
        reporter.reportLog("URL:" + System.getProperty("QaUrl"));
        //reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        //reporter.reportLogWithScreenshot("Home Page");
        //getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        /*getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc31_RPP_AALBYODStdShipping.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc31_RPP_AALBYODStdShipping.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();*/
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc31_RPP_AALBYODStdShipping.getUsername());
        getRogersLoginPage().clkContinueSignIn();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc31_RPP_AALBYODStdShipping.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");
        getDriver().get(System.getProperty("AWSUrl"));
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyByodDeviceTile(), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        reporter.reportLogWithScreenshot("Device Catalog Page");
        getRogersDeviceCataloguePage().clkByodDeviceTileContinueBtn();
        getRogersDeviceCataloguePage().clickAddALineButtonOnModal();
        //------------------------------------Device Catalog page--------------------------------------------
        reporter.hardAssert(getRogersDeviceCataloguePage().verifySharedNonSharedModalPresent(), "Shared/Nonshared modal displayed", "Shared/Nonshared modal not displayed");
        reporter.reportLogWithScreenshot("Shared/Nonshared modal popup");
        String aalSharingType = TestDataHandler.tc31_RPP_AALBYODStdShipping.getSharingType();
        getRogersDeviceCataloguePage().selectAALSharingType(aalSharingType);
        reporter.reportLogPassWithScreenshot(aalSharingType+ " option selected successfully");
        getRogersDeviceCataloguePage().clickContinueButtonOnModal();
        //-------------------------------------Plan config page---------------------------------------------
        reporter.softAssert(getRogersPlanConfigPage().verifyAalByodBreadCrumb(),
                "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        reporter.hardAssert(getRogersPlanConfigPage().verifyByodSelectedDeviceSection(), "Plan Config loaded", "Plan config page not loaded");
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc31_RPP_AALBYODStdShipping.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Data option selected");
        reporter.hardAssert(getRogersPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.tc31_RPP_AALBYODStdShipping.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersPlanConfigPage().selectBYODdpAddon();
        reporter.reportLogPassWithScreenshot("Device Protection Addon option is selected");
        getRogersPlanConfigPage().enterDPIMEI(TestDataHandler.tc31_RPP_AALBYODStdShipping.getDpIMEI());
        reporter.reportLogPassWithScreenshot("Device Protection Addon IMEI Entered");
        getRogersPlanConfigPage().setDPDeviceStorage(TestDataHandler.tc31_RPP_AALBYODStdShipping.getDpDeviceStorage());
        reporter.reportLogPassWithScreenshot("Device Protection Addon Device Storage Selected");
        getRogersPlanConfigPage().setDPDeviceColor(TestDataHandler.tc31_RPP_AALBYODStdShipping.getDpDeviceColor());
        reporter.reportLogPassWithScreenshot("Device Protection Addon Device Color Selected");
        getRogersPlanConfigPage().clkDpEligCheckBtn();
        reporter.hardAssert(getRogersPlanConfigPage().verifyEligibilityMsg(),"Entered IMEI is eligible for Device Protection Addon","Entered IMEI is not eligible");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersPlanConfigPage().setUserNameCallerID();
        reporter.reportLogWithScreenshot("CalledID details entered");
        reporter.hardAssert(getRogersPlanConfigPage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
        String dpAddon = getRogersPlanConfigPage().getDeviceProtectionAddon();
        reporter.reportLogPassWithScreenshot("Device Protection - " +dpAddon);
        String monthlyFeesAmountWithTax = getRogersPlanConfigPage().getMonthlyFeesAmount();
        String oneTimeFeesAmountWithTax = getRogersPlanConfigPage().getOneTimeFeesAmount();
        reporter.reportLog("Checkout page Cart Summary Info" + "1. Total Monthly Fees " + monthlyFeesAmountWithTax + "2. oneTimeFee " + oneTimeFeesAmountWithTax);
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        //---------------------------------------Checkout pages---------------------------------------------------------
        reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
        reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc31_RPP_AALBYODStdShipping.getCtnCity());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
        //getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
        getRogersCheckoutPage().clkChooseNumberbutton();
        //reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(), "Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        //reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
        /*reporter.hardAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
                "Billing Address is not selected");*/
        getRogersCheckoutPage().clickSkipAutopay();
        getRogersCheckoutPage().clkDeliveryMethod("Express");
        reporter.reportLogPassWithScreenshot("Bopis Delivery selected");
        getRogersCheckoutPage().setEmailShippingPage();
        reporter.hardAssert(getRogersCheckoutPage().verifyExpressLocationMapPresent(), "Express pickup location map is present",
                "Express pickup location map is not available");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
        //getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
        //--------------------------------------Review Order Page-------------------------------------------------------
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        reporter.hardAssert(getRogersReviewOrderPage().verifyDPCartLineItem(),"DP Addon added to cart","DP Addon not added to cart");
        String deviceProtectionAddon = getRogersReviewOrderPage().getDeviceProtectionAddon();
        getReporter().reportLogPassWithScreenshot("Device Protection - " +deviceProtectionAddon);
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        //getRogersReviewOrderPage().clkAllAgreementConsentCheckbox("financing");
        getRogersReviewOrderPage().clkBopisConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkSubmitOrderBtn();
        //--------------------------------------Order Confirmation Page-------------------------------------------------------
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyBopisContentDisplayed(),
                "Express pickup details displayed and device image displayed", "Express pickup details and device details not displayed");
        reporter.reportLogWithScreenshot("BOPIS contents displayed in order confirmation page");
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }
}
