package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneviewCH_Auto_TC082_Migration_TMP_2P_To_SAI_ISS_Courier_ON_EN_Test extends BaseTestClass {
    @Test(groups = {"RegressionCHOV"})
    public void OneviewCH_Auto_TC113_Migration_TMP_2P_To_SAI_ISS_Courier_ON_EN_Test() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData.getAccountNo2PToSAIISSTMP(), TestDataHandler.migrationData.getContactID2PToSAIISSTMP());
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();

        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("User is prompted with check availability pop up");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Service Availability-Success window");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(), "Address Check passed", "Address check not passed");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(), "Select Services Customer Wants Displayed", "Select Services Customer Wants did not Displayed");
        reporter.reportLogWithScreenshot("Select Services Customer Wants");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        getRogersIgniteBundlesPage().clkSmartStream();
        reporter.reportLogWithScreenshot("Smart Stream - SAI ISS Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("loading offers");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("added to cart");

        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(), "Monthly Fees Displayed", "Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(), "Product Added to Cart", "Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();

        getRogersIgniteBundlesPage().reviewAllTerms();
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        reporter.reportLogWithScreenshot("Reviewed terms anc conditions");
        getRogersIgniteBundlesPage().clkReviewContinue();

        getRogersIgniteBundlesPage().addPods(5);
        getRogersIgniteBundlesPage().addPods(0);
        reporter.reportLogWithScreenshot("Free internet add on is added to the cart");
        getRogersIgniteBundlesPage().clkContinueInternetAddon();

       // getRogersIgniteBundlesPage().clkExpressCheckOut();
        reporter.reportLogWithScreenshot("Cart Summary");
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");


//        reporter.reportLogWithScreenshot("campaign");
//        getRogersIgniteCampaignPage().clickCampaignTab();
//        getRogersIgniteCampaignPage().enterCoupon("KX2");
//        getRogersIgniteCampaignPage().clickApplyCoupon();
//        reporter.reportLogWithScreenshot("campaign coupon applied");
//        reporter.hardAssert(getRogersIgniteCampaignPage().verifyCouponRemoveLink(), "Remove Coupon option exist", "Remove Coupon does not exist");
//        getRogersIgniteCampaignPage().closeCouponAlert();
//        reporter.reportLogWithScreenshot("close code window");

        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.hardAssert(getCustomerProfilePage().verifyCustomerProfile(), "Customer Profile", "Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyCreditEvaluationHeader(), "Credit Evaluation Displayed", "Credit Evaluation did not Displayed");
        reporter.reportLogWithScreenshot("Credit Evaluation screen loaded");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(), FormFiller.generateExpiryYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay(), FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay(), TestDataHandler.anonymousData.contactDetails.getPassportNo());
        reporter.reportLogWithScreenshot("evaluation form filled");
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(), "Credit Check Information Entered", "Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();

        reporter.reportLogWithScreenshot("Installation options");
        getCreditCheckPage().verifyInstallationOption();
        getCreditCheckPage().goToPageBottom();
        getCreditCheckPage().clkCourierDelivery();
        getCreditCheckPage().clickInPersonDelivery();
        reporter.reportLogWithScreenshot("in person delivery");
        getPaymentOptionsPage().clkContinue();

        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(), "Billing And Payment Options displayed", "Billing And Payment Options did not display");
        getCreditCheckPage().verifyBillingAndPaymentOption();
//        getCreditCheckPage().clickDigitalFrontline();
//        reporter.reportLogWithScreenshot("digitalfrontline");
//        getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
//        getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
//        getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
//        reporter.reportLogWithScreenshot("card details entered");
        getPaymentOptionsPage().clkContinue();
        reporter.reportLogWithScreenshot("Order Review Page");
        getRogersIgniteCampaignPage().clickCampaignTab();
        reporter.reportLogWithScreenshot("load offers");
        getRogersIgniteCampaignPage().enterCoupon("KX2");
        getRogersIgniteCampaignPage().clickApplyCoupon();
        reporter.reportLogWithScreenshot("apply coupon");
        reporter.hardAssert(getRogersIgniteCampaignPage().verifyCouponRemoveLink(), "Remove coupon link verified", "Remove coupon link not verified");
        getRogersIgniteCampaignPage().closeCouponAlert();

        getRogersOVCheckoutPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");

    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext testContext, Method method)throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
    }
    @AfterMethod(alwaysRun=true)
    public void afterTest(){
        getDriver().quit();
    }

}

