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
 * TC14 - Regression - HUP-E2E-SL Shared(Fin)-Validate the HUP by selecting Keep current plan _Chrome_EN_ON
 */
public class RogersBFA_TC14_HUPMLBySelectingFinDevice_MultipleFinAccessories_NB_Test extends BaseTestClass{

    @Test(groups = {"RegressionBFA","HUPBFA","RegressionOnlineBFA"})
    public void rogersHUPMLFinDeviceMultiplAccessories_NB_Test() {
        reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        reporter.reportLogWithScreenshot("Home Page");
        getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc14HUPShareKeepCurrentPlanTermML.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc14HUPShareKeepCurrentPlanTermML.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page");
        getDriver().get(System.getProperty("AWSUrl"));
        String deviceName = TestDataHandler.tc14HUPShareKeepCurrentPlanTermML.getDeviceName();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen",
                "Modal element is not present on the screen");
        getRogersDeviceCataloguePage().clickUpgradeMyPhoneButtonOnModal();
        /*reporter.reportLogWithScreenshot("Upgrade button clicked on Modal window Popup");
        getRogersDeviceCataloguePage().isModalDisplayed();
        reporter.reportLogWithScreenshot("CTN Modal window displayed on the screen");
        getRogersDeviceCataloguePage().selectCTN(TestDataHandler.tc14HUPShareKeepCurrentPlanTermML.getCtn());
        getRogersDeviceCataloguePage().clickContinueBtn();*/
        reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
                "Continue button on the device config page is present",
                "Continue button on the device config page is not present");
        //-----------------------------------Accessories selection------------------------------
        reporter.hardAssert(getRogersDeviceConfigPage().verifyAddAccessoriesOption(),"Accessories option is displayed", "Accessories option is not displayed");
        getRogersDeviceConfigPage().clkAddAccessoriesOption();
        reporter.reportLogWithScreenshot("Accessories displayed successfully");
        getRogersDeviceConfigPage().addAccessoriesToCart(TestDataHandler.tc14HUPShareKeepCurrentPlanTermML.getAccessoriesCount(),
                TestDataHandler.tc14HUPShareKeepCurrentPlanTermML.getAccessory1(),TestDataHandler.tc14HUPShareKeepCurrentPlanTermML.getAccessory2());
        reporter.reportLogPassWithScreenshot("Accessories selected successfully");
        getRogersDeviceConfigPage().clkContinueAccessories();
        //--------------------------------------Plan config page----------------------------------
        reporter.hardAssert(getRogersPlanConfigPage().verifyPlanConfigPage(),
                "Plan config page loaded successfully", "Plan config page not loaded");
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page device cost selected");
        getRogersPlanConfigPage().clickContinueOnModalToDoWithOldPhone();
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc14HUPShareKeepCurrentPlanTermML.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Data option selected");
        getRogersPlanConfigPage().clickPreCartTalkOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
        getRogersPlanConfigPage().skipBPOOffer();
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersPlanConfigPage().clkContinueDeviceProtection();
        reporter.reportLogPassWithScreenshot("Addons option selected and Landed in Accessories Cost selection stepper");
        getRogersPlanConfigPage().clkContinueAccessoriesCostSelection();
        getRogersPlanConfigPage().skipBPOOffer();
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        getRogersPlanConfigPage().selectAdditionalLinePlanOptions();
        //---------------------------------------Checkout pages--------------------------------------------
        reporter.hardAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
                "Billing Address is not selected");
        getRogersCheckoutPage().clkDeliveryMethod("standard");
        reporter.reportLogPass("Standard Delivery selected");
        reporter.hardAssert(getRogersCheckoutPage().verifyAccessoriesShippingMessage(),
                "Accessory shipping message is displayed", "Accessory shipping message is not displayed");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPass("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPass("Clicked submit button below cart summary");
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPass("Order Review Page");
        getRogersReviewOrderPage().clkFinancingConsentCheckbox();
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        getRogersReviewOrderPage().clkReturningUEDeviceConsentCheckbox();
        getRogersReviewOrderPage().clkAccessoriesFinancingAgreementCheckBox();
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

/*    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }*/

}
