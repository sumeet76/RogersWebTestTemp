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
 * TC08 - Regression - Rogers HUP on Additional line e2e
 * @author Saurav.Goyal
 */
public class RogersBFA_TC08_Consumer_HUPWithPPC_OnAdditonalLine_StdShipping_Test extends BaseTestClass {

	@Test(groups = {"RegressionBFA","HUPBFA"})
    public void tc08_RogersHUPOnAdditonalLineStdShippingTest() {
        //reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        reporter.reportLogWithScreenshot("Home Page");
        //getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc08HUPAdditionalLineSS.getUsername());
        getRogersLoginPage().clkContinueSignIn();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc08HUPAdditionalLineSS.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
//        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
//        getRogersLoginPage().clkSkipIFrame();
//        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl"));
        String deviceName = TestDataHandler.tc08HUPAdditionalLineSS.getDeviceName();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen",
                "Modal element is not present on the screen");
        getRogersDeviceCataloguePage().clickUpgradeMyPhoneButtonOnModal();
        reporter.reportLogWithScreenshot("Upgrade button clicked on Modal window Popup");
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed() , "CTN selection Modal window displayed on the screen " ,"CTN selection Modal window not displayed on the screen");
        reporter.reportLogWithScreenshot("CTN Modal window displayed on the screen");
        getRogersDeviceCataloguePage().selectCTN(TestDataHandler.tc08HUPAdditionalLineSS.getCtn());
        getRogersDeviceCataloguePage().clickContinueBtn();
        reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
                "Continue button on the device config page is present",
                "Continue button on the device config page is not present");
        reporter.reportLogPassWithScreenshot("Device config page displayed");
        getRogersDeviceConfigPage().clickContinueButton();
        reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName),
                "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page device cost selected");
        //getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc08HUPAdditionalLineSS.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Data option selected");
        getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
        getRogersPlanConfigPage().clkContinueDeviceProtection();
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        getRogersCheckoutPage().clickSkipAutopay();
        getRogersCheckoutPage().clkDeliveryMethod("STANDARD");
        reporter.reportLogPass("Standard Delivery selected");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPass("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPass("Clicked submit button below cart summary");
        getRogersPlanConfigPage().clkContinueOnExistingAddonModal();
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPass("Order Review Page");
        getRogersReviewOrderPage().clkFinancingConsentCheckbox();
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
       getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        getRogersReviewOrderPage().clkReturningUEDeviceConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        if(getRogersOrderReviewPage().isPaymentRequired()) {
            getRogersOrderReviewPage().clkContinue();
            getRogersPaymentPage().setCreditCardDetails(TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getNumber(),
                    TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryMonth(),
                    TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getExpiryYear(),
                    TestDataHandler.bfaPaymentInfo.getCreditCardDetails().getCVV());
            reporter.reportLogWithScreenshot("Rogers Payment Page");
            getRogersPaymentPage().clkSubmit();
        } else {
            getRogersOrderReviewPage().clkSubmitOrder();
        }
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
    }

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows , method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
    
}