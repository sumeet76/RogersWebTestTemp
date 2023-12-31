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

public class OneviewCH_REG_Auto_TC086_MIG_3P_To_3P_SHM_ChannelsandThemepacks_SHM_AddOns_ProInstall_Monthly_ON_EN extends BaseTestClass {

    @Test(groups="RegressionCHOV")
    public void oneviewCH_REG_Auto_TC086_MIG_3P_To_3P_SHM_ChannelsandThemepacks_SHM_AddOns_ProInstall_Monthly_ON_EN() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData.getAccountNoLegacyToSHM3PInternet(),TestDataHandler.migrationData.getContactIDLegacyToSHM3PInternet());
        reporter.reportLogWithScreenshot("OneviewLaunched");

        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        getAccountOverViewPage().selectProduction();
        getAccountOverViewPage().clickProceed();
        reporter.reportLogWithScreenshot("Use this address");
        getAccountOverViewPage().selectAddress();
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().refreshContinue();
        getRogersIgniteBundlesPage().clkContinue();

        reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
        reporter.reportLogWithScreenshot("Select Services Customer Wants");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        getRogersIgniteBundlesPage().clkTVCheckbox();
        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        getRogersIgniteBundlesPage().clickSmartHomeMonitoring();
        reporter.reportLogWithScreenshot("SHM + 3P Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("Load offers");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("add to cart");
        getRogersIgniteBundlesPage().clickNewNumber();
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.reportLogWithScreenshot("review terms and condition");
        getRogersIgniteBundlesPage().reviewAllTerms();
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        reporter.reportLogWithScreenshot("Points to mention");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();

        reporter.reportLogWithScreenshot("Customer followed channels and themepacks");
        getRogersIgniteBundlesPage().clickReviewAddons();
        reporter.reportLogWithScreenshot("Clicked customer’s legacy add-ons.");
        getTVDashboardPage().clickThemepacksTab();
        reporter.reportLogWithScreenshot("Themepack tab");
        getTVDashboardPage().addThemepack();
        reporter.reportLogWithScreenshot("themepack added");
        getTVDashboardPage().clickstandaloneAndSeasonalTab();
        reporter.reportLogWithScreenshot("StandAlone and Seasonal Events Selected");
        getRogersOVChannelsAndThemePacksPage().clickAddChannel();
        reporter.reportLogWithScreenshot("add channel");
        getRogersIgniteBundlesPage().clkContinue();

        getRogersIgniteBundlesPage().fourKTVPopup();
        getRogersIgniteBundlesPage().contiue4KContent();

        getRogersIgniteBundlesPage().addPods(5);
        getRogersIgniteBundlesPage().addPods(0);
        reporter.reportLogWithScreenshot("Free internet add on is added to the cart");
        getRogersIgniteBundlesPage().clkContinueInternetAddon();
        getRogersIgniteBundlesPage().clickAddOnAddToCart();
        reporter.reportLogWithScreenshot("clicked Homephone Add On Add To Cart");
        getRogersIgniteBundlesPage().validateAddonAddToCart();
        reporter.reportLogWithScreenshot("validate add on add to cart");
        getRogersIgniteBundlesPage().clkContinue();

        getRogersIgniteBundlesPage().addSHMAddOn();
        getRogersIgniteBundlesPage().clkContinue();

        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("customer wish to continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("evaluation form");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        reporter.reportLogWithScreenshot("evaluation form filled" );
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        reporter.reportLogWithScreenshot("Phone Number Generate");
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        reporter.reportLogWithScreenshot("Phone Number Selected");
        getCreditCheckPage().goToPageBottom();
        getHomePhoneSelectionPage().clkContinueOnGeneratePhone();

        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
        reporter.reportLogWithScreenshot("Installation options");
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("professional installation");
        getCreditCheckPage().selectProfessionalInstallation();
        reporter.reportLogWithScreenshot("click Date Time Radio Button");
        getFulfillmentPage().clkFirstAvailableAppointment();
        getCreditCheckPage().enterSpecialInstructions();
        reporter.reportLogWithScreenshot(".enter Special Instructions");
        getPaymentOptionsPage().clkContinue();

        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        reporter.reportLogWithScreenshot("billing and payment");
        reporter.reportLogWithScreenshot("Monthly charges");
        getPaymentOptionsPage().clkContinue();

        reporter.reportLogWithScreenshot("submit order");
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
        //getDriver().quit();
    }

}
