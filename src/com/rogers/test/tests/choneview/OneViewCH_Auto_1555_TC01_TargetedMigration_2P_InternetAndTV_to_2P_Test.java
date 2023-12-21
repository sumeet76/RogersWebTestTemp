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

import static com.rogers.testdatamanagement.TestDataHandler.targetedMigration2PInternetAndTVTo2P;

public class OneViewCH_Auto_1555_TC01_TargetedMigration_2P_InternetAndTV_to_2P_Test extends BaseTestClass {
    @Test(groups = {"RegressionCHOV"})
    public void oneViewCH_1547_TC01_TargetedMigrationFlow_2P_InternetAndTV_to_2PTest(){
        getEnvironmentSelectionPage().launchOneView(targetedMigration2PInternetAndTVTo2P.getAccountNo(), targetedMigration2PInternetAndTVTo2P.getContactID() );
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
      // getAccountOverViewPage().clickIgniteTVBadge();
      getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("User is prompted with check availability pop up");
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        reporter.reportLogWithScreenshot("Click proceed button");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Service Availability-Success window");
        getRogersIgniteBundlesPage().clkContinueServiceable();

        getRogersIgniteBundlesPage().verifyRecommendedOffers();
        reporter.reportLogWithScreenshot("Targeted offer for the customer is displayed under the recommended offer section");
        getRogersIgniteBundlesPage().selectRecommendedOffer();
//        getRogersIgniteBundlesPage().clkTVCheckbox();
//        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Dual Play- Internet TV are Selected");
//        getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clkAddToCartForBestOffer();
//		getRogersIgniteBundlesPage().clkAddtoCart(TestDataHandler.anonymousData.getplanEng(),TestDataHandler.anonymousData.getplanFr());
        //getRogersIgniteBundlesPage().clickFirstAddToCart(TestDataHandler.anonymousData.getPlanEngSAI());

        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Clicked Continue");
        getRogersIgniteBundlesPage().goToPageBottom();
        reporter.reportLogWithScreenshot("review terms and condition");
        getRogersIgniteBundlesPage().expandInternetdiv();
        getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
        reporter.reportLogWithScreenshot("check term and conditions");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        reporter.reportLogWithScreenshot("Navigated Points to Mention");

        getRogersIgniteBundlesPage().clickExchangeLater();
        getRogersIgniteBundlesPage().clickReviewAddons();
        getTVDashboardPage().selectStandaloneChannelsTab();
        getTVDashboardPage().clickAddChannel();
        reporter.reportLogWithScreenshot("Channel added");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Click continue with 4K TV");
        getRogersOVChannelsAndThemePacksPage().clkbtnContinueOn4ktv();
        getRogersOVChannelsAndThemePacksPage().clkbtnContinueOn4KChannelPack();
//        getRogersIgniteBundlesPage().fourKContinue();

        reporter.reportLogWithScreenshot("bottom to continue");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        reporter.reportLogWithScreenshot("Cart Summary");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();

        reporter.reportLogWithScreenshot("Customer Profile");
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        getCustomerProfilePage().clkContinue();
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue button is clicked");
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("Installation options");
        getCreditCheckPage().clkCourierDelivery();
        getCreditCheckPage().goToPageBottom();
        getCreditCheckPage().clickInPersonDelivery();
        reporter.reportLogWithScreenshot("In Person Delivery is Selected");

        getPaymentOptionsPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(), "Billing And Payment Options displayed", "Billing And Payment Options did not display");
        getCreditCheckPage().verifyBillingAndPaymentOption();
        getPaymentOptionsPage().clkContinue();

//		Checkout Page

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
//        closeSession();
    }
}
