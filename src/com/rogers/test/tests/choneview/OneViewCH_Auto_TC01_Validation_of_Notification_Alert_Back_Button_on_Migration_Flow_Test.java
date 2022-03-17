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

public class OneViewCH_Auto_TC01_Validation_of_Notification_Alert_Back_Button_on_Migration_Flow_Test extends BaseTestClass {
    @Test
    public  void oneViewCH_Auto_TC01_Validation_of_Notification_Alert_Back_Button_on_Migration_Flow_Test(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.ValidationofNotificationAlertBackbutton.getAccountNo(),TestDataHandler.ValidationofNotificationAlertBackbutton.getContactID());
        reporter.reportLogWithScreenshot("OneView Interface has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("use this address");
//		getRogersIgniteBundlesPage().clkUsethisAddress();
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clkContinueServiceable();
        getRogersIgniteBundlesPage().clkTVCheckbox();
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        reporter.reportLogWithScreenshot("Triple play selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("added to cart");
        getRogersIgniteBundlesPage().noPortInPopup();
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("review terms and condition");
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        reporter.reportLogWithScreenshot("points to mention");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        getRogersIgniteBundlesPage().clickExchangeLater();
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().noTo4KTVPopup();
        getRogersIgniteBundlesPage().clkContinueInternetAddon();
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Cart Summary");
//		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        reporter.reportLogWithScreenshot("cart summary checkout");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.hardAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","failed");
    //    getCustomerProfilePage().clickBackButton();
     //   getCustomerProfilePage().clickNoContinue();
     //   getCustomerProfilePage().clickBackButton();
     //   getCustomerProfilePage().clickYesCancelButton();
    //    reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"CartSummarry Header Displayed","Failed");
        getCustomerProfilePage().clkContinue();
    //    getCustomerProfilePage().clickBackButton();
    //    reporter.softAssert(getCustomerProfilePage().verifyAreYouSureModal(),"Modal is Successfully Displayed","Modal failed to Appear");
    //    getCustomerProfilePage().clickNoContinue();
    //    getCustomerProfilePage().clickBackButton();
    //    getCustomerProfilePage().clickYesCancelButton();
    //    reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"CartSummarry Header Displayed","Failed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        getCustomerProfilePage().clkContinue();
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        getCustomerProfilePage().clickBackButton();
        reporter.softAssert(getCustomerProfilePage().verifyAreYouSureModal(),"Modal is Successfully Displayed","Modal failed to Appear");
        getCustomerProfilePage().clickNoContinue();
        getCustomerProfilePage().clickBackButton();
        getCustomerProfilePage().clickYesCancelButton();
     //   reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"CartSummarry Header Displayed","Failed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        getCustomerProfilePage().clkContinue();
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        getCreditCheckPage().goToPageBottom();
        getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
        getCustomerProfilePage().clickBackButton();
        reporter.softAssert(getCustomerProfilePage().verifyAreYouSureModal(),"Modal is Successfully Displayed","Modal failed to Appear");
        getCustomerProfilePage().clickNoContinue();
        getCustomerProfilePage().clickBackButton();
        getCustomerProfilePage().clickYesCancelButton();
    //    reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"CartSummarry Header Displayed","Failed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        getCustomerProfilePage().clkContinue();
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        getCreditCheckPage().goToPageBottom();
        getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("installation options");
        getCreditCheckPage().goToPageBottom();
        getCreditCheckPage().clickInPersonDelivery();
        reporter.reportLogWithScreenshot("in person delivery");
        getPaymentOptionsPage().clkContinue();
        getCustomerProfilePage().clickBackButton();
        reporter.softAssert(getCustomerProfilePage().verifyAreYouSureModal(),"Modal is Successfully Displayed","Modal failed to Appear");
        getCustomerProfilePage().clickNoContinue();
        getCustomerProfilePage().clickBackButton();
        getCustomerProfilePage().clickYesCancelButton();
     //   reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"CartSummarry Header Displayed","Failed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        getCustomerProfilePage().clkContinue();
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        getCreditCheckPage().goToPageBottom();
        getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("installation options");
        getCreditCheckPage().goToPageBottom();
        getCreditCheckPage().clickInPersonDelivery();
        reporter.reportLogWithScreenshot("in person delivery");
        getPaymentOptionsPage().clkContinue();
        getCreditCheckPage().verifyBillingAndPaymentOption();
        reporter.reportLogWithScreenshot("Billing and payment");
        getCreditCheckPage().clickDigitalFrontline();
        reporter.reportLogWithScreenshot("Front line");
        getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
        getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
        getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
        reporter.reportLogWithScreenshot("Entered card detail");
        getPaymentOptionsPage().clkContinue();
        reporter.hardAssert(getRogersOVCheckoutPage().verifyOrderReviewPage(),"Order Review Page is Displayed","Failed");
        getCustomerProfilePage().clickBackButton();
        reporter.softAssert(getCustomerProfilePage().verifyAreYouSureModal(),"Modal is Successfully Displayed","Modal failed to Appear");
        getCustomerProfilePage().clickNoContinue();
        getCustomerProfilePage().clickBackButton();
        getCustomerProfilePage().clickYesCancelButton();
       // reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"CartSummarry Header Displayed","Failed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        getCustomerProfilePage().clkContinue();
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        getCreditCheckPage().goToPageBottom();
        getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("installation options");
        getCreditCheckPage().goToPageBottom();
        getCreditCheckPage().clickInPersonDelivery();
        reporter.reportLogWithScreenshot("in person delivery");
        getPaymentOptionsPage().clkContinue();
        getCreditCheckPage().verifyBillingAndPaymentOption();
        reporter.reportLogWithScreenshot("Billing and payment");
        getCreditCheckPage().clickDigitalFrontline();
        reporter.reportLogWithScreenshot("Front line");
        getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
        getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
        getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
        reporter.reportLogWithScreenshot("Entered card detail");
        getPaymentOptionsPage().clkContinue();





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
