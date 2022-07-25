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

public class OneViewCH_Auto_TC080_1549_TargetedMigration_1P_TV_to_ISS_TargetedOfferType_Recommended_ATL_EN extends BaseTestClass {
    @Test(groups = {"RegressionCHOV"})
    public void oneViewCH_1617_TC01_TargetedMigrationFlowTvToSAIISSTest(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.targetedMigration1PTvToSAIISS.getAccountNo(), TestDataHandler.targetedMigration1PTvToSAIISS.getContactID() );
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("User is prompted with check availability pop up");
        //getRogersIgniteBundlesPage().clkUsethisAddress();
        getAccountOverViewPage().clickContinue();
        reporter.reportLogWithScreenshot("Service Availability-Success window");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().verifyRecommendedOffers();
        reporter.reportLogWithScreenshot("Targeted offer for the customer is displayed under the recommended offer section");
        getRogersIgniteBundlesPage().selectRecommendedOffer();
        reporter.reportLogWithScreenshot("Selected the Recommended offer");

//        getRogersIgniteBundlesPage().clkInternetCheckbox();
//        getRogersIgniteBundlesPage().clkSmartStream();
//        reporter.reportLogWithScreenshot("Single Play - SAI Selected");
//        getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clkAddToCartForBestOffer();
//        getRogersIgniteBundlesPage().noPortInPopup();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        getRogersIgniteBundlesPage().clkContinue();
        //getRogersIgniteBundlesPage().clkCheckOut();
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        getRogersIgniteBundlesPage().clkReviewContinue();
        /*To Add the chargeable Pods*/
        getRogersIgniteBundlesPage().addPods(5);
        reporter.reportLogWithScreenshot("Chargable internet add on is added to the cart");
        /*To Add the free pods in the internt addons page*/
        getRogersIgniteBundlesPage().addPods(0);
        reporter.reportLogWithScreenshot("Free internet add on is added to the cart");
        getRogersIgniteBundlesPage().clkContinueInternetAddon();
        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        //reporter.reportLogWithScreenshot("Product Added");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
        reporter.reportLogWithScreenshot("Installation options");

        getCreditCheckPage().verifyInstallationOption();
        getCreditCheckPage().goToPageBottom();
        getCreditCheckPage().clkCourierDelivery();
        getCreditCheckPage().clickInPersonDelivery();
        getPaymentOptionsPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");

        getCreditCheckPage().verifyBillingAndPaymentOption();
        getCreditCheckPage().clickDigitalFrontline();
        getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
        getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
        getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
		getPaymentOptionsPage().clkContinue();
//	    getRogersOVCheckoutPage().clkSubmit();
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");

    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);

    }

//    @AfterMethod(alwaysRun = true)
//    public void afterTest() {
//        closeSession();
//    }

}
