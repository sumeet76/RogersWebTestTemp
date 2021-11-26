package com.rogers.test.tests.buyflows;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * TC17 - Rogers Add a line with BOPIS shipping option - E2E
 * @author praveen.kumar7
 */

public class RogersBFA_TC17_AALUpfrontEdge_MediumRisk_Bopis_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.buyflows, method);
    }

    @Test(groups = {"RegressionBFA","AALBFA","RegressionOnlineBFA"})
    public void rogersAalTermBopisTest() {
        reporter.reportLog("URL:" + System.getProperty("QaUrl"));
        reporter.hardAssert(getRogersHomePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        reporter.reportLogWithScreenshot("Home Page");
        getRogersHomePage().clkSignIn();
        //getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc17AALShareTermBopis.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc17AALShareTermBopis.getPassword());
        reporter.reportLogWithScreenshot("Login Page");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Account Overview Page");
        getDriver().get(System.getProperty("AWSUrl"));
        //------------------------------------Device Catalog page--------------------------------------------
        String deviceName = TestDataHandler.tc17AALShareTermBopis.getNewDevice();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyDeviceTileCTAButton(deviceName),
                "phone catalogue Page appeared Successful", "phone catalogue Page did not appear");
        reporter.reportLogWithScreenshot("Device Catalog Page");
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
        reporter.hardAssert(getRogersDeviceCataloguePage().isModalDisplayed(),
                "Existing Customer Modal element is present on the screen",
                "Existing Customer Modal element is not present on the screen");
        reporter.reportLogWithScreenshot("Existing Customer Modal window Popup");
        reporter.hardAssert(getRogersDeviceCataloguePage().verifyAddALineButtonOnModal(), "Add a line button displayed", "Add a line button not displayed");
        getRogersDeviceCataloguePage().clickAddALineButtonOnModal();
        //reporter.softAssert(getRogersDeviceCataloguePage().verifyCreditEvaluationPopupPresent(), "Credit Evaluation Popup Displayed", "Credit Evaluation popup not disaplayed");
        //reporter.softAssert(getRogersDeviceCataloguePage().verifyCreditEvalTextOnModalPresent(), "Credit Evaluation Text Displayed", "Credit Evaluation Text not disaplayed on Modal");
        getRogersCheckoutPage().clkAcceptButton();
        reporter.hardAssert(getRogersDeviceCataloguePage().verifySharedNonSharedModalPresent(), "Shared/Nonshared modal displayed", "Shared/Nonshared modal not displayed");
        reporter.reportLogWithScreenshot("Shared/Nonshared modal popup");
        String aalSharingType = TestDataHandler.tc17AALShareTermBopis.getSharingType();
        getRogersDeviceCataloguePage().selectAALSharingType(aalSharingType);
        reporter.reportLogPassWithScreenshot(aalSharingType+ " option selected successfully");
        getRogersDeviceCataloguePage().clickContinueButtonOnModal();
        //------------------------------------Device Config page--------------------------------------------
        getRogersDeviceConfigPage().selectDeviceColor(TestDataHandler.tc17AALShareTermBopis.getDeviceColor());
        reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(),
                "Continue button on the device config page is present",
                "Continue button on the device config page is not present");
        reporter.reportLogPassWithScreenshot("Device config page displayed");
        String upfrontEdgeAmt = getRogersDeviceConfigPage().getUpfrontEdgeAmt(this.getClass().getSimpleName());
        String deviceCost = getRogersDeviceConfigPage().getDeviceFullPrice(this.getClass().getSimpleName());
        String expectedDownPayment = getRogersCheckoutPage().setDownPayment(TestDataHandler.tc17AALShareTermBopis.getRiskClass(),deviceCost);
        reporter.hardAssert(getRogersCheckoutPage().verifyDownPaymentAmt(expectedDownPayment.substring(0,expectedDownPayment.lastIndexOf("."))),
                "Downpayment amount is displayed correctly", "Downpayment amoount is not displayed correctly");
        getRogersDeviceConfigPage().clickContinueButton();
        //-------------------------------------Plan config page---------------------------------------------
        reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName),
                "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        //reporter.hardAssert(getRogersPlanConfigPage().verifySelectedDeviceSection(deviceName), "Plan Config loaded", "Plan config page not loaded");
        reporter.reportLogPassWithScreenshot("Plan Config page loaded successfully");
        getRogersPlanConfigPage().selectDeviceCostAndClickOnContinueButton(getRogersPlanConfigPage().getUpdatedDeviceCostIndex(TestDataHandler.tc17AALShareTermBopis.getDeviceCostIndex()));
        reporter.reportLogPassWithScreenshot("Device cost option selected");
        getRogersPlanConfigPage().clickShowMoreDetails();
        getRogersPlanConfigPage().selectDataOptionAndClickonContinueButton(getRogersPlanConfigPage().getupdatedDataOptionIndex(TestDataHandler.tc17AALShareTermBopis.getDataOptionIndex()),this.getClass().getSimpleName());
        reporter.reportLogPassWithScreenshot("Data option selected");
        reporter.hardAssert(getRogersPlanConfigPage().verifyTalkOptionSelectionAndAddonsContinueButton(getRogersPlanConfigPage().getupdatedTalkOptionIndex(TestDataHandler.tc17AALShareTermBopis.getTalkOptionIndex())),
                "Talk option selected and Addons page in expanded state","Addons page not in expanded state");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersPlanConfigPage().clkContinueDeviceProtection();
        getRogersPlanConfigPage().setUserNameCallerID();
        reporter.reportLogWithScreenshot("CalledID details entered");
        String monthlyFeesAmountWithTax = getRogersPlanConfigPage().getMonthlyFeesAmount();
        String oneTimeFeesAmountWithTax = getRogersPlanConfigPage().getOneTimeFeesAmount();
        reporter.reportLog("Checkout page Cart Summary Info" + "1. Total Monthly Fees " + monthlyFeesAmountWithTax + "2. oneTimeFee " + oneTimeFeesAmountWithTax);
        String isSelectedDeviceTier = getRogersPlanConfigPage().getDeviceCostTierSelected();
        getRogersPlanConfigPage().clickCartSummaryContinueButton();
        //---------------------------------------Checkout pages---------------------------------------------------------
        reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not disaplayed");
        reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not disaplayed");
        getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.tc17AALShareTermBopis.getCtnCity());
        reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
        getRogersCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
        reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed", "Find More Available Number Button not disaplayed");
        getRogersCheckoutPage().clkChooseNumberbutton();
        reporter.hardAssert(getRogersCheckoutPage().isChooseaNumberLabelDisplayed(), "Choose a Number Identification label displayed Successfully", "Choose a Number Identification Label not disaplayed");
        reporter.reportLogPassWithScreenshot("Choose a Number Identification label Displayed");
        reporter.hardAssert(getRogersCheckoutPage().clkBillingAddress(), "Billing Address radio button is selected ",
                "Billing Address is not selected");
        getRogersCheckoutPage().clkDeliveryMethod("Express");
        reporter.reportLogPassWithScreenshot("Bopis Delivery selected");
        getRogersCheckoutPage().setEmailShippingPage();
        reporter.hardAssert(getRogersCheckoutPage().verifyExpressLocationMapPresent(), "Express pickup location map is present",
                "Express pickup location map is not available");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");
        //--------------------------------------Review Order Page-------------------------------------------------------
        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        getRogersReviewOrderPage().clkAllAgreementConsentCheckbox(isSelectedDeviceTier);
        getRogersReviewOrderPage().clkBopisConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkSubmitOrderBtn();
        //---------------------One Time Payment page------------------------------//
        reporter.hardAssert(getRogersOneTimePaymentPage().verifyOneTimePaymentPage(),
                "Pay with Credit card details are present on OneTime payment page", "Pay with Credit card details are not present on OneTime payment page");
        getRogersOneTimePaymentPage().setNameonCard();
        getRogersOneTimePaymentPage().switchToCreditCardIFrame();
        getRogersOneTimePaymentPage().setCreditCardNumberIFrame(TestDataHandler.tc01NACTermNpotgSS.getCreditCardDetailsOTP());
        getRogersOneTimePaymentPage().switchOutOfCreditCardIFrame();
        getRogersOneTimePaymentPage().setExpiryDate(TestDataHandler.tc01NACTermNpotgSS.getExpiryDateOTP());
        getRogersOneTimePaymentPage().setCVV();
        reporter.reportLogPassWithScreenshot("Credit Card Details Entered Successfully");
        getRogersOneTimePaymentPage().clkSubmitOrderBtn();
        //************Order Confirmation Page****************//
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationPageLoad(), "Order Confirmation page loaded", "Order Confirmation Error");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyThankYouDisplayed(), "Thank You message displayed", "Thank You message not displayed");
        reporter.reportLogWithScreenshot("Rogers Order Confirmation Page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyBopisContentDisplayed(),
                "Express pickup details displayed and device image displayed", "Express pickup details and device details not displayed");
        reporter.reportLogWithScreenshot("BOPIS contents displayed in order confirmation page");
        //--------------------------------------------------DB Validation-----------------------------------------------

        Map<Object, Object> dblists = getDbConnection().connectionMethod(System.getProperty("DbEnvUrl"))
                .executeDBQuery("select * from (select es.BAN,es.SUBSCRIBER_NO,s.SUB_STATUS,s.PAYEE_IND,es.RV_AMOUNT,es.MONTHLY_INSTALLMENT_AMT," +
                        "es.TOTAL_FINANCING_OBLIG as TOTAL,es.MANDATORY_CHG as MANDATORY_DP,p.ORIGINAL_AMT as MANDATORY_DP_WITH_TAX,ch.CAS_TOTAL_APPROVE_CTN from equipment_subsidy es inner join payment p" +
                        " on es.ban=p.ban inner join credit_history ch on es.ban=ch.ban inner join subscriber s on es.subscriber_no=s.subscriber_no" +
                        " where es.subscriber_no="+TestDataHandler.tc17AALShareTermBopis.getCtn()+"') where ROWNUM=1", false);

        reporter.softAssert(dblists.get("SUB_STATUS").equals("R"),"Subcriber status is verified as R","Subcriber status is not verified as R");
        reporter.softAssert(dblists.get("PAYEE_IND").equals("D"), "Payee indicator is verified as D", "Payee indicator is not verified as D");
        reporter.softAssert(dblists.get("RV_AMOUNT").toString().equals(upfrontEdgeAmt),"Upfront edge amt is verified successfully as $"+upfrontEdgeAmt+"","Upfront edge amount is not verified successfully");
        reporter.softAssert(dblists.get("MANDATORY_DP").equals(expectedDownPayment.substring(0,expectedDownPayment.lastIndexOf("."))),
                "Mandatory downpayment amount is verified successfully", "Mandatory downpayment amount is not verified successfully");
        reporter.softAssert(dblists.get("MANDATORY_DP_WITH_TAX").toString().equals(getRogersOrderConfirmationPage().getTotalOneTimeFeeWithTax(expectedDownPayment.substring(0,expectedDownPayment.lastIndexOf(".")))),
                "Mandatory downpayment with tax is verified successfully as "+expectedDownPayment+"","Mandatory DP is not verified successfully");

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }
}

