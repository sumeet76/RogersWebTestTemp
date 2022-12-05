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

public class OneViewCH_REG_Auto_TC097_Validation_of_Port_In_Migration_1P_to_3P_ON_EN_Test extends BaseTestClass {
    @Test
    public void oneViewCH_REG_Auto_TC097_Validation_of_Port_In_Migration_1P_to_3P_ON_EN_Test(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData1PTo3P.getAccountNo(), TestDataHandler.migrationData1PTo3P.getContactID());
        reporter.reportLogWithScreenshot("OneView Interface has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        getRogersIgniteBundlesPage().clkContinue();
        //getRogersIgniteBundlesPage().clkUsethisAddress();
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinueServiceable();
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        getRogersIgniteBundlesPage().clkTVCheckbox();
        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        reporter.reportLogWithScreenshot("Triple play selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        getRogersIgniteBundlesPage().yesPortInPopup();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().reviewAllTerms();
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        reporter.reportLogWithScreenshot("Port In Service");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        reporter.reportLogWithScreenshot("portin");
        getRogersIgniteBundlesPage().clkContinueFor3PPortIn();
        reporter.reportLogWithScreenshot("Port In initiated");
        getRogersIgniteBundlesPage().setProvider("BELL ONTARIO");
        reporter.reportLogWithScreenshot("provider");
        getRogersIgniteBundlesPage().enterAccountNumber("1122334455");
        reporter.reportLogWithScreenshot("portin details");
        getRogersIgniteBundlesPage().contiueFromPortIn();
        reporter.reportLogWithScreenshot("portin continue");
        getRogersIgniteBundlesPage().contiueToCartSummary();
        getRogersIgniteBundlesPage().clickExchangeLater();
//        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersOVChannelsAndThemePacksPage().clkContinue();
    //    getRogersIgniteBundlesPage().clkExpressCheckOut();
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
        //reporter.reportLogWithScreenshot("Phone Number Selected");
        getCreditCheckPage().goToPageBottom();
        //reporter.reportLogWithScreenshot("continue");
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
        closeSession();
    }
    }

