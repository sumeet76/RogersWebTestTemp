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

public class OneviewCH_REG_Auto_TC027_TargetedMigrationOffer_Regular_1P_INT_To_SAI_ON_EN extends BaseTestClass {
    @Test(groups = {"RegressionCHOV"})
    public void oneviewCH_REG_Auto_TC027_TargetedMigrationOffer_Regular_1P_INT_To_SAI_ON_EN(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.targetedMigration1PInternetToSAI.getAccountNo(), TestDataHandler.targetedMigration1PInternetToSAI.getContactID() );
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("User is prompted with check availability pop up");
     //   getRogersIgniteBundlesPage().clkUsethisAddress();
        reporter.reportLogWithScreenshot("Service Availability-Success window");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clkContinueServiceable();
        getRogersIgniteBundlesPage().verifyRecommendedOffers();
        reporter.reportLogWithScreenshot("Targeted offer for the customer is displayed under the recommended offer section");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Single Play - SAI Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clkAddToCartForBestOffer();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Cart Summary");
    //    reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("Product Added");
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
        getCreditCheckPage().clickInPersonDelivery();
        getPaymentOptionsPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");

        getCreditCheckPage().verifyBillingAndPaymentOption();
        getCreditCheckPage().clickDigitalFrontline();
        getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
        getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
        getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
		getPaymentOptionsPage().clkContinue();
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



