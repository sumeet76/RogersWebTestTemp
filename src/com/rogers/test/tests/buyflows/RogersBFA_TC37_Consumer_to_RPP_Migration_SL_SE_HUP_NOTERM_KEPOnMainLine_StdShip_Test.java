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
 * TC37 - Regression - RPP HUP-E2E-Multi Line Shared Account - Validate the HUP flow by selecting the Noterm cost option on Main Line_Std Shipping_Chrome_EN_ON
 * @author praveen.kumar7
 */
public class RogersBFA_TC37_Consumer_to_RPP_Migration_SL_SE_HUP_NOTERM_KEPOnMainLine_StdShip_Test extends BaseTestClass{

        @Test(groups = {"RegressionBFA","RPPBFA"})
        public void tc37_ConToRppHUP_SLSE_HUPNOTERM_KEPOnMainLine_StdShip_Test() {
            //reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
            //reporter.reportLogWithScreenshot("Home Page");
            //getRogersHomePage().clkSignIn();
            //getRogersLoginPage().switchToSignInIFrame();
            getDriver().get(System.getProperty("AWSUrl")+"/?type=rpp");
            reporter.hardAssert(getRogersDeviceCataloguePage().verifyRppPasscodeModal(),"RPP Passcode modal is displayed", "RPP passcode modal is not displayed");
            getRogersDeviceCataloguePage().enterPasscodeInPasscodeModal(TestDataHandler.tc37_RPP_HUP_SL_HUP_NOTERM_KEPOnMainLine_StdShip.getPasscode());
            reporter.reportLogWithScreenshot("Passcode entered successfully in passcode modal");
            getRogersDeviceCataloguePage().clkContinueBtnPassCodeModal();
            reporter.hardAssert(getRogersDeviceCataloguePage().verifyPasscode(),"Passcode is verified successfully", "Invalid Passcode");
            getRogersDeviceCataloguePage().clickUpgradeMyPhoneButtonOnModal();
            getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc37_RPP_HUP_SL_HUP_NOTERM_KEPOnMainLine_StdShip.getUsername());
            getRogersLoginPage().clkContinueSignIn();
            getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc37_RPP_HUP_SL_HUP_NOTERM_KEPOnMainLine_StdShip.getPassword());
            reporter.reportLogWithScreenshot("Login Page");
            getRogersLoginPage().clkSignInIFrame();
            //reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
            //getRogersLoginPage().clkSkipIFrame();
            //getRogersLoginPage().switchOutOfSignInIFrame();
//            reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
//            reporter.reportLogWithScreenshot("Account Overview page");
//            getDriver().get(System.getProperty("AWSUrl"));
            //reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed() , "CTN selection Modal window displayed on the screen " ,"CTN selection Modal window not displayed on the screen");
            //reporter.reportLogWithScreenshot("CTN Modal window displayed on the screen");
            //getRogersDeviceCataloguePage().selectCTN(TestDataHandler.tc37_RPP_HUP_ML_HUP_NOTERM_KEPOnMainLine_StdShip.getCtn());
            //getRogersDeviceCataloguePage().clkContinueBtnHupCtnSelectionModal();
            reporter.reportLogPassWithScreenshot("RPP Migration Fee Modal");
            getRogersDeviceCataloguePage().clkContinueBtnMigrationFeeRpp();
            String deviceName = TestDataHandler.tc37_RPP_HUP_SL_HUP_NOTERM_KEPOnMainLine_StdShip.getDeviceName();
            reporter.reportLogWithScreenshot("Moving to device catalogue page");
            reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName), "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
            getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
//            reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen",
//                    "Modal element is not present on the screen");
            //reporter.reportLogWithScreenshot("Upgrade button clicked on Modal window Popup");
            reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
                    "Continue button on the device config page is present",
                    "Continue button on the device config page is not present");
            getRogersDeviceConfigPage().clickContinueButton();
            //*********************Plan Builder Page***************************************
            reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName),
                    "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
            reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");
            reporter.hardAssert(getRogersPlanConfigPage().isMigratedToRppFin(),"Consumer User Migrated to RPP Financing successfully","Not Migrated to RPP Financing");
            getRogersPlanConfigPage().clkRadioButtonNoTerm();
            reporter.reportLogPassWithScreenshot("No term selected");
            getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
            reporter.reportLogPassWithScreenshot("Plan config page device cost selected");
            getRogersPlanConfigPage().clickContinueOnModalToDoWithOldPhone();
            reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
            getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
            getRogersPlanConfigPage().clkContinueDeviceProtection();
            reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
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
            getRogersReviewOrderPage().clkAgreementConsentCheckbox();
            getRogersReviewOrderPage().clkReturningUEDeviceConsentCheckbox();
            reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
            getRogersOrderReviewPage().clkSubmitOrder();
            reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentTitle(),
                    "One Time Payment Page displayed","One Time Payment Page Not displayed");
            String otpAmount = getRogersOneTimePaymentPage().getOneTimePaymentAmount();
            reporter.reportLogWithScreenshot("One Time Payment Amount = " +otpAmount);
            reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),
                    "Pay with Credit card details are present on OneTime payment page", "Pay with Credit card details are not present on OneTime payment page");
            getRogersOneTimePaymentPage().setNameonCard();
            getRogersOneTimePaymentPage().switchToCreditCardIFrame();
            getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc37_RPP_HUP_SL_HUP_NOTERM_KEPOnMainLine_StdShip.getCreditCardDetails());
            getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
            getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc37_RPP_HUP_SL_HUP_NOTERM_KEPOnMainLine_StdShip.getExpiryDate());
            getRogersOneTimePaymentPage().setCVV();
            reporter.reportLogPassWithScreenshot("Credit Card Details Entered Successfully");
            getRogersOneTimePaymentPage().clkSubmitOrderBtn();

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