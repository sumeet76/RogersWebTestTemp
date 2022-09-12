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

public class OneViewCH_Auto_TC060_1556_TargetedMigrationFlow_2P_InternetAndTV_to_3P_TargetedOfferType_Recommended_ON_EN extends BaseTestClass {
    @Test(groups = {"RegressionCHOV","SanityCHOV"})
    public void oneViewCH_1548_TC01_TargetedMigrationFlow_2P_InternetAndTV_to_3PTest(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.targetedMigration2PInternetAndTVTo3P.getAccountNo(), TestDataHandler.targetedMigration2PInternetAndTVTo3P.getContactID() );
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("User is prompted with check availability pop up");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Service Availability-Success window");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().verifyRecommendedOffers();
        reporter.reportLogWithScreenshot("Targeted offer for the customer is displayed under the recommended offer section");
        getRogersIgniteBundlesPage().selectRecommendedOffer();
        reporter.reportLogWithScreenshot("Selected the Recommended offer");

//        getRogersIgniteBundlesPage().clkTVCheckbox();
//        getRogersIgniteBundlesPage().clkInternetCheckbox();
//        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
//        reporter.reportLogWithScreenshot("Triple Play - Internet TV and HomePhone Selected");
//        getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clkAddToCartForBestOffer();
		//getRogersIgniteBundlesPage().clkAddtoCart(TestDataHandler.anonymousData.getplanEng(),TestDataHandler.anonymousData.getplanFr());
        // getRogersIgniteBundlesPage().clickFirstAddToCart(TestDataHandler.anonymousData.getPlanEngSAI());
        getRogersIgniteBundlesPage().noPortInPopup();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().reviewAllTerms();
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        getRogersIgniteBundlesPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("customer add review link");
        getRogersOVChannelsAndThemePacksPage().clkCustomerAddonReview();
        reporter.reportLogWithScreenshot("click standalone channels tab");
        getTVDashboardPage().selectStandaloneChannelsTab();
        getTVDashboardPage().clickAddChannel();
        reporter.reportLogWithScreenshot("add channel");
        getTVDashboardPage().clickThemepacksTab();
        getTVDashboardPage().addThemepack();
        reporter.reportLogWithScreenshot("add themepack");
        getTVDashboardPage().verifyRemoveButton();
        reporter.reportLogWithScreenshot("verify theme pack");
        getTVDashboardPage().clickContinueForPackage();
        reporter.reportLogWithScreenshot("continue to calling package");
        getRogersIgniteBundlesPage().fourKTVPopup();
        getRogersIgniteBundlesPage().fourKContentPopup();
        reporter.reportLogWithScreenshot("Internet Addons");
        getRogersIgniteBundlesPage().validateInternetAddOnsHeader();
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("Calling cart - Add to cart");

        reporter.hardAssert(getHomePhoneAddonsPage().verifyHomePhoneAddOnsHeader(),"Home Phone Header Display", "Home Phone Header not Displayed");
        reporter.reportLogWithScreenshot("Home Phone Add on page displayed");
        getHomePhoneAddonsPage().clkContinue();
        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.reportLogWithScreenshot("Customer Profile");
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile Header displayed","Customer Profile Header did not display");
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
        getCreditCheckPage().goToPageBottom();
        getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
        getCreditCheckPage().verifyInstallationOption();
        getCreditCheckPage().clkCourierDelivery();
        getCreditCheckPage().clickInPersonDelivery();
        getPaymentOptionsPage().clkContinue();
        getCreditCheckPage().verifyBillingAndPaymentOption();
//        getCreditCheckPage().clickDigitalFrontline();
//        getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
//        getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
//        getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
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
        closeSession();
    }
}
