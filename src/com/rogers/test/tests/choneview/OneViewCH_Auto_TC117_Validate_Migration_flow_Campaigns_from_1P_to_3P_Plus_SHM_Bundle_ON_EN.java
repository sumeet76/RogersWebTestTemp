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

public class OneViewCH_Auto_TC117_Validate_Migration_flow_Campaigns_from_1P_to_3P_Plus_SHM_Bundle_ON_EN extends BaseTestClass {
    @Test
    public void oneViewCH_Auto_TC117_Validate_Migration_flow_Campaigns_from_1P_to_3P_Plus_SHM_Bundle_ON_EN(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData1PTo3P.getAccountNo(), TestDataHandler.migrationData1PTo3P.getContactID());
        reporter.reportLogWithScreenshot("OneView Interface has Launched");
        //	getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("use this address");
        //	getRogersIgniteBundlesPage().clkUsethisAddress();
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clkContinueServiceable();
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        getRogersIgniteBundlesPage().clkTVCheckbox();
        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        getRogersIgniteBundlesPage().clickSmartHomeMonitoring();
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
        getRogersIgniteBundlesPage().reviewAllTerms();
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
    //  getRogersIgniteBundlesPage().reviewTermsAndCondition();
        reporter.reportLogWithScreenshot("points to mention");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        getRogersIgniteBundlesPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Exchange later");
        reporter.reportLogWithScreenshot("After Exchange later");
        getRogersOVChannelsAndThemePacksPage().clickAddChannel();
        getRogersOVChannelsAndThemePacksPage().clickThemepacksTab();
        getRogersOVChannelsAndThemePacksPage().addThemepack();
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().fourKTVPopup();
        getRogersIgniteBundlesPage().contiue4KContent();
        getRogersIgniteBundlesPage().clkContinueInternetAddon();
        getRogersIgniteBundlesPage().goToPageBottom();
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().addSHMAddOn();
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("smart home addons page");
        reporter.reportLogWithScreenshot("campaign");
        getRogersIgniteCampaignPage().clickCampaignTab();
        getRogersIgniteCampaignPage().enterCoupon("pCR6");
        getRogersIgniteCampaignPage().clickApplyCoupon();
        reporter.reportLogWithScreenshot("campaign coupon applied");
        getRogersIgniteBundlesPage().clickCancelButton();
        reporter.reportLogWithScreenshot("Cart Summary");
        //	reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        //getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        //getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        //getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        //getCreditCheckPage().clkAuthorize();
        //reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().goToPageBottom();
        getCreditCheckPage().clkContinue();
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        reporter.reportLogWithScreenshot("Phone Number Selected");
        getCreditCheckPage().goToPageBottom();
        getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("go To Page Bottom");
        getCreditCheckPage().goToPageBottom();
        reporter.reportLogWithScreenshot("professional installation");
        getCreditCheckPage().selectProfessionalInstallation();
        reporter.reportLogWithScreenshot("click Date Time Radio Button");
        getFulfillmentPage().clkFirstAvailableAppointment();
        reporter.reportLogWithScreenshot(".enter Text Mobile Number");
        getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
        reporter.reportLogWithScreenshot(".enter Email Mail Address");
        getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
        getCreditCheckPage().enterSpecialInstructions();
        reporter.reportLogWithScreenshot(".enter Special Instructions");
        getPaymentOptionsPage().clkContinue();

        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        reporter.reportLogWithScreenshot("billing and payment");
        getCreditCheckPage().selectPaymentOption(1);
        reporter.reportLogWithScreenshot("Monthly charges");
//        getPaymentOptionsPage().clkContinue();
//		reporter.reportLogWithScreenshot("Submit order");
//		getRogersOVCheckoutPage().clkSubmit();
//		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
//        reporter.reportLogWithScreenshot("Order Placed");
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
