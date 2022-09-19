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
 * TC01 - MOM - New Activation Complete
 * @author ibrahim.coskun
 */

public class RogersMOM_TC01_NAC extends BaseTestClass {

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
    }



    @Test(groups = {"MOMSanity"})
    public void tc01rogersNACcomplete() throws InterruptedException {


                            // --------------------------------------------Device catalog page--------------------------------------------


        reporter.hardAssert(getRogersDeviceCataloguePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        String deviceName=TestDataHandler.MOM_tc01_Consumer_NAC.getDeviceName();
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
        reporter.softAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen", "Modal element is not present on the screen");
        reporter.softAssert(getRogersDeviceCataloguePage().verifyGetStartedButtonOnModal(), "Get started button on the modal is present" ,"Get started button on the modal is not present");
        reporter.reportLogWithScreenshot("Modal window Popup");
        reporter.hardAssert(getRogersDeviceCataloguePage().clickGetStartedButtonOnModal(),"Clicked Get Started Button","Get Started button not able to click");


                            // --------------------------------------------Device config page--------------------------------------------


        //reporter.hardAssert(getRogersDeviceConfigPage().verifyContinueButton(), "BreadCrumb on Phone config page is working fine", "BreadCrumb is not working fine");
        reporter.reportLogWithScreenshot("Device config page");
        getRogersDeviceConfigPage().clickContinueButton();


                            //--------------------------------------------Plan config page--------------------------------------------


        reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName), "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page data option selected");
        getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        getRogersPlanConfigPage().clkContinueDeviceProtection();
        reporter.reportLogPassWithScreenshot("Plan config page clicked on data protection continue button");
        getRogersPlanConfigPage().clickCartSummaryContinueButton();


                         // --------------------------------------------Create Profile Page--------------------------------------------


        reporter.softAssert(getRogersCheckoutPage().verifyCreateProfileTitle(), "Create profile Title Present",
                "Create profile Title not present");
        String emailCreateProfile = getRogersCheckoutPage().setEmailCreateProfile();
        getRogersCheckoutPage().confirmEmailCreateProfile(emailCreateProfile);
        String firstName = getRogersCheckoutPage().setFirstNameCreateProfile();
        String lastName = getRogersCheckoutPage().setLastNameCreateProfile();

        String contactNumberCreateProfile = TestDataHandler.MOM_tc01_Consumer_NAC.getContactNumber();
        getRogersCheckoutPage().setContactNumberCreateProfile(contactNumberCreateProfile);
        reporter.reportLogPassWithScreenshot("Create Profile Page details Entered till ContactNumber");
        String billingAddressCreateProfile = TestDataHandler.MOM_tc01_Consumer_NAC.getBillingAddress();
        getRogersCheckoutPage().setBillingAddressCreateProfile(billingAddressCreateProfile);
        getRogersCheckoutPage().clkLanguageEnglishRadioBtnCreateProfile();
        reporter.reportLogPassWithScreenshot(
                "Create Profile Page details provided for Address,Shipping Address & Language Selected");
        getRogersCheckoutPage().switchToRecaptchaIFrame();
        getRogersCheckoutPage().clkImNotRombotCheckbox();
        reporter.reportLogPassWithScreenshot("I'm not Robot Checked");
        getRogersCheckoutPage().switchOutOfGoogleIFrame();
        getRogersCheckoutPage().clkBtnGotoCreditEvalStepper();


                       //--------------------------------------------Credit Evaluation Stepper--------------------------------------------


        reporter.softAssert(getRogersCheckoutPage().verifyCreditEvaluationTitle(), "CreditEvaluation Title verified", "CreditEvaluation Title not present");
        getRogersCheckoutPage().selectYearDropdownOption(TestDataHandler.MOM_tc01_Consumer_NAC.getDateOfBirthYear());
        getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().selectMonthDropdownOption(TestDataHandler.MOM_tc01_Consumer_NAC.getDateOfBirthMonth());
        getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().selectDayDropdownOption(TestDataHandler.MOM_tc01_Consumer_NAC.getDateOfBirthDay());
        getRogersCheckoutPage().switchToCreditCardIFrame();
        getRogersCheckoutPage().setCreditCardNumberIFrame(TestDataHandler.MOM_tc01_Consumer_NAC.getCreditCardDetails());
        reporter.reportLogPassWithScreenshot("DOB & Credit Card Details Entered Successfully");
        getRogersCheckoutPage().switchOutOfCreditCardIFrame();
        getRogersCheckoutPage().setExpiryDate(TestDataHandler.MOM_tc01_Consumer_NAC.getExpiryDate());
        getRogersCheckoutPage().selectDropdownOption(TestDataHandler.MOM_tc01_Consumer_NAC.getDropdownOption());
        getRogersCheckoutPage().setPassportNumber(TestDataHandler.MOM_tc01_Consumer_NAC.getPassportNumber());
        reporter.reportLogPassWithScreenshot("PassportNumber Entered Successfully");
        getRogersCheckoutPage().clkCreditAuthorizationChkBox();
        getRogersCheckoutPage().clkCreditEvalContinue();
        reporter.reportLogWithScreenshot("Credit Evaluation processing popup");
        reporter.hardAssert(getRogersCheckoutPage().isIdentificationLabel(), "Credit Evaluation Successful", "Credit Evaluation Identification Label not displayed");


                        //--------------------------------------------Choose a Number Stepper--------------------------------------------


        reporter.softAssert(getRogersCheckoutPage().isChooseaNumberTitleDisplayed(), "Choose a Number Title Displayed", "Choose a Number Title not displayed");
        reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab Displayed", "Select a New Number/Use Existing Number Tab not Displayed");
		getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.MOM_tc01_Consumer_NAC.getCityName());
		reporter.reportLogPassWithScreenshot("City Dropdown Value Selected Successfully");
		getRogersCheckoutPage().clkNoThanks();
		getRogersCheckoutPage().clkChosePhoneNumber();
		reporter.reportLogPassWithScreenshot("Selected First Available Phone Number");
		reporter.softAssert(getRogersCheckoutPage().isFindMoreAvlNumberButtonPresent(), "Find More Available Number Button Displayed", "Find More Available Number Button not displayed");
		getRogersCheckoutPage().clkChooseNumberbutton();


                     //--------------------------------------------Billing & Payment Stepper--------------------------------------------


        reporter.softAssert(getRogersCheckoutPage().isBillingOptionsTitleDisplayed(), "Billing Options Title Displayed", "Billing Options Title Not Present");
        reporter.softAssert(getRogersCheckoutPage().isPaymentMethodDropdownPresent(), "Select Payment Method Dropdown Displayed", "Select Payment Method Dropdown not Displayed");
        getRogersCheckoutPage().selectPaymentMethodDropdownOption(TestDataHandler.MOM_tc01_Consumer_NAC.getPaymentMethod());
        getRogersCheckoutPage().clkBillingContinueButton();
        //getRogersCheckoutPage().clickSkipNacAutopay();


                        //--------------------------------------------Shipping Stepper--------------------------------------------


        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPass("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPass("Clicked submit button below cart summary");


                        //--------------------------------------------Order Review Page--------------------------------------------


        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present", "Order Review Page Title is not Present");
        reporter.reportLogPass("Order Review Page");
        getRogersReviewOrderPage().clkFinancingConsentCheckbox();
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page: T&C");
        getRogersReviewOrderPage().clkSubmitOrderBtn();


                         //--------------------------------------------Order Confirmation Page--------------------------------------------


        reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),
                "Order Confirmation Page Title Present", "Order Confirmation Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Confirmation Page");

    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() throws InterruptedException {
        closeSession();
    }
}
