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
 * TC04 - MOM - HUP Main Complete
 * @author Nitin.Arora
 */

public class RogersMOM_TC04_HUP_Main extends BaseTestClass {

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.buyflows, method);
    }

    @Test(groups = {"MOMSanity"})
    public void tc04RogersMOMHupMain() throws InterruptedException {

        //--------- Launch login page and sign in with using email id and password---------//
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.MOM_TC04_HUP_Main.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.MOM_TC04_HUP_Main.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();

        //--------- Validate Successful login to overview page ---------//
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
                "Login Successful",
                "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");

        //--------- Click Manage button for individual line ---------//
        getRogersAccountOverviewPage().clickManageButton();
        reporter.reportLogWithScreenshot("Manage");

        //--------- Click on upgrade my device ---------//
        getRogersWirelessDetailsPage().clkUpgradeMyDevice();
        reporter.reportLogWithScreenshot("Upgrade Device");

        //--------- Select a new device and click continue ---------//
        String deviceName = TestDataHandler.MOM_TC04_HUP_Main.getDeviceName();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(TestDataHandler.MOM_TC04_HUP_Main.getDeviceName());
        reporter.reportLogWithScreenshot("Device Selection");
        getRogersChoosePhonePage().clickContinueButton();

        //--------- Select Keep my current plan ---------//
        getRogersPlanConfigPage().setCheckBoxKeepMyCurrentPlan();
        reporter.reportLogWithScreenshot("Keep My Current Plan");

        //--------- Select pay for the device in full option ---------//
        getRogersBuildPlanPage().clickPayforDeviceinFull();
        reporter.reportLogWithScreenshot("Pay For Device in Full");

        //--------- Click Continue button after plan ---------//
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        reporter.reportLogWithScreenshot("Continue Plan");

        //--------- Click Continue button after data option ---------//
        getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
        reporter.reportLogWithScreenshot("Continue Data");

        //--------- Click Continue button after add ons ---------//
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        reporter.reportLogWithScreenshot("Continue Add on");

        //--------- Click continue for device protection ---------//
        reporter.reportLogWithScreenshot("Device Protection Popup");
        getRogersPlanConfigPage().clkContinueDeviceProtection();

        //--------- Click Proceed to checkout ---------//
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        reporter.reportLogWithScreenshot("Checkout");

        //--------- Click Continue button after delivery ---------//
        getRogersCheckoutPage().clkContinueBtnShipping();

        //--------- Click Continue button on cart summary ---------//
        getRogersOrderReviewPage().clkSubmitOrder();
        reporter.reportLogWithScreenshot("Continue Button cart Summary");

        //--------- Validate Order Review page loaded ---------//
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(),
                "Order Review Page Title Present",
                "Order Review Page Title is not Present");

        //--------- Select Agreement Consent Checkbox ---------//
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        reporter.reportLogWithScreenshot("Agreement Consent Check Box");

        //--------- Click Submit Order button ---------//
        getRogersOrderReviewPage().clkSubmitOrder();
        reporter.reportLogWithScreenshot("Submit Order Button");

        //--------- Verify One time payment page is loaded ---------//
        reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),
                "Payment Page Displayed Successfully",
                "Payment Page Did Not Display");
        reporter.reportLogWithScreenshot("One Time Payment Page");

        //--------- Enter credit card details name, card number, expiry date and cvv ---------//
        getRogersOneTimePaymentPage().setNameonCard();
        getRogersOneTimePaymentPage().switchToCreditCardIFrame();
        getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.MOM_TC04_HUP_Main.getCreditCardDetails());
        reporter.reportLogPassWithScreenshot("Credit Card Details Entered Successfully");
        getRogersCheckoutPage().switchOutOfCreditCardIFrame();
        getRogersCheckoutPage().setExpiryDate(TestDataHandler.MOM_TC04_HUP_Main.getExpiryDate());
        getRogersOneTimePaymentPage().setCVV();
        reporter.reportLogWithScreenshot("Credit Card Details");

        //--------- Click submit order button ---------//
        getRogersOneTimePaymentPage().clkSubmitOrderBtn();
        reporter.reportLogWithScreenshot("Order Submit");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(),
                "Order Confirmation Page Loaded",
                "Order Confirmation Error");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyThankYouDisplayed(),
                "Thank You Message Displayed",
                "Thank You Message Failed To Display");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }

}
