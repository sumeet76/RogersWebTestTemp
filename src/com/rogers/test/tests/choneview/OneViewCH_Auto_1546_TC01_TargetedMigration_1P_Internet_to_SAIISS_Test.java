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

public class OneViewCH_Auto_1546_TC01_TargetedMigration_1P_Internet_to_SAIISS_Test extends BaseTestClass {
    @Test(groups = {"RegressionCHOV"})
    public void oneViewCH_1617_TC01_TargetedMigrationFlowInternetToSAIISSTest(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.targetedMigration1PInternetToSAIISS.getAccountNo(), TestDataHandler.targetedMigration1PInternetToSAIISS.getContactID() );
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        reporter.reportLogWithScreenshot("dashboard");
        getAccountOverViewPage().clickIgnite();

        reporter.reportLogWithScreenshot("Service Availability-Success window");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("click Continue");
        getRogersIgniteBundlesPage().refreshContinue();
        reporter.reportLogWithScreenshot("refresh Continue");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyRecommendedOffers(), "verify recommended offer appear", "verify recommeneded offer didnt appear");
        reporter.reportLogWithScreenshot("Targeted offer for the customer is displayed under the recommended offer section");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("refresh Continue");
        getRogersIgniteBundlesPage().clkSmartStream();
        reporter.reportLogWithScreenshot("Single Play - SAI Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clkAddToCartForBestOffer();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.reportLogWithScreenshot("click Collapse");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("click Continue");

//        getRogersIgniteBundlesPage().clkCheckOut();

        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        reporter.reportLogWithScreenshot("points to mention");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        reporter.reportLogWithScreenshot("click Continue From Points To Mention");
        getRogersIgniteBundlesPage().scrollToContinue();
        reporter.reportLogWithScreenshot("scroll To Continue");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("click Check Out for Cart Summary");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("Product Added");

        //getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        //reporter.reportLogWithScreenshot("scroll To Continue");
        //getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
       //reporter.reportLogWithScreenshot("scroll To Continue");
        //getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
       // reporter.reportLogWithScreenshot("scroll To Continue");
       // getCreditCheckPage().clkAuthorize();
        //reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        //reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().goToPageBottom();
        getCreditCheckPage().refreshContinue();
        getCreditCheckPage().clkContinue();
//        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
        reporter.reportLogWithScreenshot("Installation options");
        getCreditCheckPage().verifyInstallationOption();
        getCreditCheckPage().goToPageBottom();
        reporter.reportLogWithScreenshot("go To Page Bottom");
        getCreditCheckPage().clkCourierDelivery();
        getCreditCheckPage().clickInPersonDelivery();
        reporter.reportLogWithScreenshot("click In Person Delivery");
        getPaymentOptionsPage().clkContinue();
        reporter.reportLogWithScreenshot("click Continue");
        getCreditCheckPage().verifyBillingAndPaymentOption();
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        getCreditCheckPage().clickDigitalFrontline();
        reporter.reportLogWithScreenshot("click Digital Front line");
        getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
        reporter.reportLogWithScreenshot("enter Card Token");
        getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
        reporter.reportLogWithScreenshot("set Card Expiry Month And Year");
        getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
        reporter.reportLogWithScreenshot("set Card CVV");
		getPaymentOptionsPage().clkContinue();
        reporter.reportLogWithScreenshot("click Continue");
		getRogersOVCheckoutPage().clkSubmit();
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");

    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }

}
