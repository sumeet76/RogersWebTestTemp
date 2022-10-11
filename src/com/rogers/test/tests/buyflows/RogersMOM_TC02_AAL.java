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
 * TC02 - MOM - Add A Line
 * @author ibrahim.coskun
 */

public class RogersMOM_TC02_AAL extends BaseTestClass {

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("AWSUrl"), strBrowser,strLanguage,RogersEnums.GroupName.redesignrogers, method);
    }


    @Test(groups = {"MOMSanity"})
    public void rogersmom_tc02_AAL() {

                    //------------------------------------Device Catalog page-------------------------------------------


        reporter.hardAssert(getRogersDeviceCataloguePage().verifyHomepage(), "Home Page appeared Successful", "Home Page did not appear");
        String deviceName=TestDataHandler.MOM_tc02_Consumer_AAL.getNewDevice();
        getRogersDeviceCataloguePage().clickDeviceTileCTAButton(deviceName);
        reporter.softAssert(getRogersDeviceCataloguePage().isModalDisplayed(), "Modal element is present on the screen", "Modal element is not present on the screen");
        getRogersDeviceCataloguePage().clickAddALineButtonOnModal();


                    //---------------------------------------Login page-------------------------------------------------

        getRogersLoginPage().setUsernameIFrame(TestDataHandler.MOM_tc02_Consumer_AAL.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.MOM_tc02_Consumer_AAL.getPassword());
        getRogersLoginPage().clkSkipIFrame();


                    //-----------------------------------Device Catalog page--------------------------------------------


        reporter.hardAssert(getRogersDeviceCataloguePage().verifySharedNonSharedModalPresent(),
                "Shared/Nonshared modal displayed", "Shared/Nonshared modal not displayed");
        reporter.reportLogWithScreenshot("Shared/Nonshared modal popup");
        String aalSharingType = TestDataHandler.MOM_tc02_Consumer_AAL.getSharingType();
        getRogersDeviceCataloguePage().selectAALSharingType(aalSharingType);
        reporter.reportLogPassWithScreenshot(aalSharingType+ " option selected successfully");
        getRogersDeviceCataloguePage().clickContinueButtonOnModal();


                    //------------------------------------Device Config page--------------------------------------------


        reporter.reportLogWithScreenshot("Device config page");
        getRogersDeviceConfigPage().clickContinueButton();


                    //-------------------------------------Plan config page---------------------------------------------


        reporter.softAssert(getRogersPlanConfigPage().verifyBreadCrumb(deviceName), "BreadCrumb on Plan config page is working fine", "BreadCrumb is not working fine");
        getRogersPlanConfigPage().clickPreCartDeviceCostContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page data option selected");
        getRogersPlanConfigPage().clickPreCartDataOptionContinueButton();
        reporter.reportLogPassWithScreenshot("Plan config page talk option selected");
        getRogersPlanConfigPage().clickPreCartAddonsContinueButton();
        reporter.reportLogPassWithScreenshot("Clicked on continue button in addons stepper");
        getRogersPlanConfigPage().clkContinueDeviceProtection();
        getRogersPlanConfigPage().setUserNameCallerID();
        reporter.reportLogWithScreenshot("CallerID details entered");
        getRogersPlanConfigPage().clickCartSummaryContinueButton();


                    //---------------------------------------Checkout page----------------------------------------------


        reporter.softAssert(getRogersCheckoutPage().isChooseNumberTabsDisplayed(), "Select a New Number/Use Existing Number Tab is Displayed", "Select a New Number/Use Existing Number Tab is not displayed");
        getRogersCheckoutPage().selectCityDropdownOption(TestDataHandler.MOM_tc02_Consumer_AAL.getCtnCity());
        reporter.reportLogWithScreenshot("City Dropdown Value Selected Successfully");
        getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().clkChosePhoneNumber();
        reporter.reportLogWithScreenshot("First Available Phone Number is Selected");
        getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().clkChooseNumberbutton();
        reporter.reportLogPassWithScreenshot("Choose a Number Label is displayed");
        getRogersCheckoutPage().clickSkipAutopay();
        reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clkContinueBtnShipping();
        reporter.reportLogPassWithScreenshot("Clicked continue button in shipping stepper");
        getRogersCheckoutPage().clkNoThanks();
        getRogersCheckoutPage().clksubmitBtnCheckoutPage();
        reporter.reportLogPassWithScreenshot("Clicked submit button below cart summary");


                    //---------------------------------Review Order Page------------------------------------------------


        reporter.hardAssert(getRogersReviewOrderPage().isOrderReviewPageTitlePresent(), "Order Review Page Title Present",
                "Order Review Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Review Page");
        getRogersReviewOrderPage().clkFinancingConsentCheckbox();
        getRogersReviewOrderPage().clkAgreementConsentCheckbox();
        getRogersReviewOrderPage().clkUpfrontConsentCheckbox();
        reporter.reportLogPassWithScreenshot("Order Review Page");
        getRogersOrderReviewPage().clkSubmitOrder();


                    //-------------------------------Order Confirmation Page--------------------------------------------


        reporter.hardAssert(getRogersNACOrderConfirmationPage().isOrderConfirmationTitlePresent(),
                "Order Confirmation Page Title Present", "Order Confirmation Page Title is not Present");
        reporter.reportLogPassWithScreenshot("Order Confirmation Page");

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest () throws InterruptedException {
        closeSession();
    }
}
