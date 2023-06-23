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

public class OneViewCH_Auto_TC009_NAC_3P_Add_both_Intern_Plus_Long_Dis_and_Unlim_CA_Wide_Call_IHP_AddOns_TMP_ProInstall_ON_EN extends BaseTestClass {
    @Test
    public void oneViewCH_Auto_TC01_Validation_of_NAC_flow_3P_Add_both_International_Plus_Long_Distance_and_Unlimited_Canada_Wide_Calling_IHP_Add_ons_Test() {
        reporter.reportLogWithScreenshot("oneview env");
        getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().selectProduction();
        reporter.reportLogWithScreenshot("Selected Production");
        getEnvironmentSelectionPage().clickProceed();
        reporter.reportLogWithScreenshot("Clicked proceed button");
        reporter.reportLogWithScreenshot("address");
        getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress());
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
        reporter.reportLogWithScreenshot("Select Services Customer Wants");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        reporter.reportLogWithScreenshot("click TV Check box");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("click Internet Check box");
        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        reporter.reportLogWithScreenshot("Triple Play Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("load offers");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("Added to Cart");
        getRogersIgniteBundlesPage().noPortInPopup();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue is clicked");
//        getRogersIgniteBundlesPage().clickExchangeLater();
//        reporter.reportLogWithScreenshot("Exchange later is clicked");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Clicked on Continue");
        getRogersIgniteBundlesPage().fourKTVPopup();
        getRogersIgniteBundlesPage().fourKContentPopup();
        reporter.reportLogWithScreenshot("4k tv pop up");
    //    getRogersIgniteBundlesPage().fourKContinue();
        reporter.reportLogWithScreenshot("4k tv pop up continue clicked");
        reporter.softAssert(getRogersIgniteBundlesPage().validateInternetAddOnsHeader(),"internet add header displayed","internet addon header did not display");
        getRogersIgniteBundlesPage().clkContinueInternetAddon();
        getHomePhoneAddonsPage().chooseAddon(TestDataHandler.RHPManage_AddOns.accountDetails.getAddOnNameEn01(),TestDataHandler.RHPManage_AddOns.accountDetails.getAddOnNameFr01());
        reporter.reportLogWithScreenshot("Home Phone Add on selected");
        getHomePhoneAddonsPage().clkCollapse();
//        getHomePhoneAddonsPage().removeAddon(TestDataHandler.RHPManage_AddOns.accountDetails.getAddOnNameEn01(),TestDataHandler.RHPManage_AddOns.accountDetails.getAddOnNameFr01());
        getHomePhoneAddonsPage().chooseAddon(TestDataHandler.RHPManage_AddOns.accountDetails.getAddOnNameEn(),TestDataHandler.RHPManage_AddOns.accountDetails.getAddOnNameFr());
        reporter.reportLogWithScreenshot("Home phone Add on selected");
//        getHomePhoneAddonsPage().incompatibleAddonRadioBtn();
//        reporter.reportLogWithScreenshot("Incompatible Add ons Dialog box displayed");
        getRogersIgniteBundlesPage().clkContinue();

        /*** Adding Campaign in cart summary page ***/
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        reporter.reportLogWithScreenshot("campaign");
        getRogersIgniteCampaignPage().clickCampaignTab();
        getRogersIgniteCampaignPage().enterCoupon("K1D");
        reporter.reportLogWithScreenshot("Campaign code entered");
        getRogersIgniteCampaignPage().clickApplyCoupon();
        reporter.reportLogWithScreenshot("Campaign code applied");
        reporter.reportLogWithScreenshot("close coupon alert");
        getRogersIgniteCampaignPage().closeCouponAlert();
        reporter.reportLogWithScreenshot("Clicked on Continue");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("Checkout on Cart Summary page clicked");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.reportLogWithScreenshot("Customer wish to continue dialog box appeared");

        getCustomerProfilePage().verifyCustomerProfile();
        reporter.reportLogWithScreenshot("Verified Customer profile header");
        getCustomerProfilePage().clkContinue();
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        reporter.reportLogWithScreenshot("credit eval form details filled");
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        reporter.reportLogWithScreenshot("Phone Number Selected");
        getHomePhoneSelectionPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
        reporter.hardAssert(getCreditCheckPage().verifyRecoEngineRecommendation(),"Reco Engine Install Recommendation Banner displayed"," Reco Engine Install Recommendation Banner is not displayed");
        reporter.hardAssert(getCreditCheckPage().verifyRecommendationBanner(),"Recommended Banner is displayed", "Recommeded Banner is not displayed");
        reporter.reportLogWithScreenshot("Installation options");
//        getCreditCheckPage().verifyInstallationOption();
//        getCreditCheckPage().clkCourierDelivery();
//        reporter.reportLogWithScreenshot("in person delivery");
//        getCreditCheckPage().clickInPersonDelivery();
//        getRogersIgniteBundlesPage().clkContinue();

        /*** Professional Installation ***/
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("professional installation");
        getCreditCheckPage().selectProfessionalInstallation();
        reporter.reportLogWithScreenshot("click Date Time Radio Button");
        getFulfillmentPage().clkFirstAvailableAppointment();
        reporter.reportLogWithScreenshot(".enter Text Mobile Number");
        getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
        reporter.reportLogWithScreenshot(".enter Email Mail Address");
        getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
        reporter.reportLogWithScreenshot(".enter Special Instructions");
        getCreditCheckPage().enterSpecialInstructions();
        getPaymentOptionsPage().clkContinue();


        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        reporter.reportLogWithScreenshot("billing and payment");
        getCreditCheckPage().verifyBillingAndPaymentOption();
        getCreditCheckPage().clickDigitalFrontline();
        reporter.reportLogWithScreenshot("digital front line");
        getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
        reporter.reportLogWithScreenshot("enter Card Token");
        getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
        reporter.reportLogWithScreenshot("set Card Expiry Month And Year");
        getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
        reporter.reportLogWithScreenshot("payment details entered");
		getPaymentOptionsPage().clkContinue();
		reporter.reportLogWithScreenshot("sumbit order");
		getRogersOVCheckoutPage().clkSubmit();
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
    }

    @BeforeMethod (alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactID3PDeliveryByAppt(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}

