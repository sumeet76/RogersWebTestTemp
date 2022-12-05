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

public class OneViewCH_REG_Auto_TC0055_1548_TargetedMigration_1P_Internet_to_3P_TargetedOfferType_Regular_ON_EN extends BaseTestClass {
    @Test(groups = {"RegressionCHOV","SanityCHOV"})
    public void oneViewCH_1548_TC01_TargetedMigrationFlow_1P_Internet_to_3PTest(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.targetedMigration1PInternetTo3P.getAccountNo(), TestDataHandler.targetedMigration1PInternetTo3P.getContactID() );
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("User is prompted with check availability pop up");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Service Availability-Success window");
    //    getRogersIgniteBundlesPage().refreshContinue();
        getRogersIgniteBundlesPage().clkContinueServiceable();
        getRogersIgniteBundlesPage().verifyRecommendedOffers();
        reporter.reportLogWithScreenshot("Targeted offer for the customer is displayed under the recommended offer section");
        reporter.reportLogWithScreenshot("Triple Play - Internet TV and HomePhone Selected");
        getRogersIgniteBundlesPage().selectRecommendedOffer();
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        getRogersIgniteBundlesPage().noPortInPopup();
        getRogersIgniteBundlesPage().clkCollapse();
//      reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().reviewAllTerms();
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        reporter.reportLogWithScreenshot("Points to remember");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        getRogersIgniteBundlesPage().clickExchangeLater();
//        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getCustomerProfilePage().clkContinue();
        getRogersIgniteBundlesPage().fourKTVPopup();
        getRogersIgniteBundlesPage().fourKContinue();
        reporter.reportLogWithScreenshot("Cart Summary");
        getRogersIgniteBundlesPage().clkContinueInternetAddon();
        getHomePhoneAddonsPage().clkContinue();
//        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        reporter.reportLogWithScreenshot("cart summary");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("credit form");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        reporter.reportLogWithScreenshot("filled customer credit form");
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        reporter.reportLogWithScreenshot("generate phone number");
        getCreditCheckPage().goToPageBottom();
        reporter.reportLogWithScreenshot("continue clicked on Home-phone Selection page");
        getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
        reporter.reportLogWithScreenshot("Phone number generated");
        //getHomePhoneSelectionPage().clkContinue();
        //   reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
        //    reporter.hardAssert(getCreditCheckPage().verifyRecoEngineRecommendation(),"Reco Engine Install Recommendation Banner displayed"," Reco Engine Install Recommendation Banner is not displayed");
        //    reporter.hardAssert(getCreditCheckPage().verifyRecommendationBanner(),"Recommended Banner is displayed", "Recommeded Banner is not displayed");reporter.reportLogWithScreenshot("Installation options");
        getCreditCheckPage().verifyInstallationOption();
        getCreditCheckPage().goToPageBottom();
        reporter.reportLogWithScreenshot("in person delivery");
        getCreditCheckPage().clkCourierDelivery();
        getCreditCheckPage().clickInPersonDelivery();
        getPaymentOptionsPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        getCreditCheckPage().verifyBillingAndPaymentOption();
        reporter.reportLogWithScreenshot("billing and payment");
        getCreditCheckPage().clickDigitalFrontline();
        reporter.reportLogWithScreenshot("front line");
        getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
        getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
        getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
        reporter.reportLogWithScreenshot("entered payment info");
        getPaymentOptionsPage().clkContinue();
        //   getRogersOVCheckoutPage().clkSubmit();
        reporter.reportLogWithScreenshot("submit payment");
        //   reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
       // closeSession();
    }

}
