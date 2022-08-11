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

public class OneViewCH_Auto_TC012_Pods_Buy_ValidateMigration3PFlowByAddingBothFreeAndChargeablePods_1PTo3P_Test extends BaseTestClass {
   @Test
       public void OneViewCH_Auto_OVS2_Pods_Buy_TC03_ValidateMigration3PFlowByAddingBothFreeAndChargeablePods_1PTo3P_Test(){
       getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData1PTo3P.getAccountNo(), TestDataHandler.migrationData1PTo3P.getContactID());

       reporter.reportLogWithScreenshot("OneView Interface has Launched");
       getAccountOverViewPage().clickIgnite();
       reporter.reportLogWithScreenshot("use this address");
   //    getRogersIgniteBundlesPage().clkUsethisAddress();
       reporter.reportLogWithScreenshot("Service Availability");
       getRogersIgniteBundlesPage().clkContinue();
       getRogersIgniteBundlesPage().clkContinueServiceable();
       reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
       reporter.reportLogWithScreenshot("Select Services Customer Wants");
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
//     getRogersIgniteBundlesPage().reviewTermsAndCondition();
//       getRogersIgniteBundlesPage().expandTvdiv();
       getRogersIgniteBundlesPage().expandInternetdiv();
       getRogersIgniteBundlesPage().expandHomePhonediv();
       getRogersIgniteBundlesPage().expandBatteryBackUpdiv();
       getRogersIgniteBundlesPage().goToPageBottom();
       reporter.reportLogWithScreenshot("points to mention");
       getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
       getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
       getRogersIgniteBundlesPage().clickExchangeLater();
       reporter.reportLogWithScreenshot("After Exchange later");
       getRogersIgniteBundlesPage().clkContinue();
       getRogersIgniteBundlesPage().fourKTVPopup();
       getRogersIgniteBundlesPage().contiue4KContent();
       getCustomerProfilePage().clkContinue();
       reporter.reportLogWithScreenshot("Lands in Internet Addons page");
       /*To Add the chargeable Pods*/
       getRogersIgniteBundlesPage().addPods(5);
       reporter.reportLogWithScreenshot("Chargable internet add on is added to the cart");
       /*To Add the free pods in the internt addons page*/
       getRogersIgniteBundlesPage().addPods(0);
       reporter.reportLogWithScreenshot("Free internet add on is added to the cart");
       getRogersIgniteBundlesPage().clkContinueInternetAddon();
       getRogersIgniteBundlesPage().clkContinue();
       reporter.reportLogWithScreenshot("Cart Summary");
       getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
       reporter.reportLogWithScreenshot("Cart Summary");
       reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
       getRogersIgniteBundlesPage().customerWishtoContinue();
       reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
       reporter.reportLogWithScreenshot("Customer Profile");
       getCustomerProfilePage().clkContinue();
       getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
       getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
       getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
       getCreditCheckPage().clkAuthorize();
       reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
       reporter.reportLogWithScreenshot("Credit Check Information");
       getCreditCheckPage().clkContinue();
       getHomePhoneSelectionPage().clkGeneratePhoneNo();
       reporter.reportLogWithScreenshot("Phone Number Selected");
   //    getCreditCheckPage().goToPageBottom();
//       getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
       getHomePhoneSelectionPage().clkContinue();
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
//		reporter.reportLogWithScreenshot("Submit order");
//		getRogersOVCheckoutPage().clkSubmit();
//		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
       reporter.reportLogWithScreenshot("Order Placed");

   }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
//        startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactID(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);

        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
    }

//    @AfterMethod(alwaysRun = true)
//    public void afterTest() {
//        closeSession();
//    }
}
