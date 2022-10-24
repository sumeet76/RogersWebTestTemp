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

public class OneViewCH_Auto_TC097_1566_TargetedMigration_3P_to_2P_ATL_EN_Test extends BaseTestClass {
    @Test
    public void oneViewCH_Auto_TC097_1566_TargetedMigration_3P_to_2P_ATL_EN_Test() {
//               Launching One View

        getEnvironmentSelectionPage().launchOneView(TestDataHandler.targetedMigration_3P_to_2P.getAccountNo(), TestDataHandler.targetedMigration_3P_to_2P.getContactID());
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("User is prompted with check availability pop up");

//                RogersIgniteBundlePage                                                                                w
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Service Availability-Success window");
        getRogersIgniteBundlesPage().clkContinueServiceable();

        getRogersIgniteBundlesPage().verifyRecommendedOffers();
        reporter.reportLogWithScreenshot("Targeted offer for the customer is displayed under the recommended offer section");
        getRogersIgniteBundlesPage().selectRecommendedOffer();
//        getRogersIgniteBundlesPage().clkInternetCheckbox();
//        getRogersIgniteBundlesPage().clkTVCheckbox();
        reporter.reportLogWithScreenshot("Internet & TV checkboxes are Selected");
//        getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clkAddToCartForBestOffer();
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(), "Product Added to Cart", "Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Clicked Continue");
        getRogersIgniteBundlesPage().goToPageBottom();
        reporter.reportLogWithScreenshot("review terms and condition");
        getRogersIgniteBundlesPage().expandInternetdiv();
        getRogersIgniteBundlesPage().expandHomePhonediv();
        getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
        reporter.reportLogWithScreenshot("Clicked review add ons");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        reporter.reportLogWithScreenshot("Navigated Points to Mention");
        getRogersIgniteBundlesPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Clicked Exchange later");
        getRogersIgniteBundlesPage().clickReviewAddons();
        reporter.reportLogWithScreenshot("review add on");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersOVChannelsAndThemePacksPage().clkbtnContinueOn4ktv();
        getRogersOVChannelsAndThemePacksPage().clkbtnContinueOn4KChannelPack();
        reporter.reportLogWithScreenshot("bottom to continue");
        getRogersIgniteBundlesPage().scrollToContinue();
        reporter.reportLogWithScreenshot("click continue");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(), "Cart Summary Header displayed", "Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.reportLogWithScreenshot("Customer Profile");
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile Header displayed","Customer Profile Header did not display");
        getCustomerProfilePage().clkContinue();

//      In the case of Credit evaluation not required
//        reporter.softAssert(getCreditCheckPage().verifyCreditEvaluationHeader(),"Credit Evaluation Header verified","Failed");
//        getCreditCheckPage().goToPageBottom();

//        In the case of credit evaluation is required
        reporter.reportLogWithScreenshot("Evaluation form");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(), FormFiller.generateExpiryYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay(), FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay(), TestDataHandler.anonymousData.contactDetails.getPassportNo());
        reporter.reportLogWithScreenshot("Evaluation form filled");
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(), "Credit Check Information Entered", "Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");

        getCreditCheckPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue button is clicked");
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("Installation options");
        getCreditCheckPage().clkCourierDelivery();
        reporter.reportLogWithScreenshot("select courier delivery");
        getCreditCheckPage().clickInPersonDelivery();
        reporter.reportLogWithScreenshot("In Person Delivery is Selected");
        getPaymentOptionsPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(), "Billing And Payment Options displayed", "Billing And Payment Options did not display");
        getCreditCheckPage().verifyBillingAndPaymentOption();
        getPaymentOptionsPage().clkContinue();

//               Checkout Page
//        if(getRogersOVCheckoutPage().isErrorToApplyOfferCodeVisible()){
//        reporter.reportLogWithScreenshot("Invalid Offer code pop displayed");
//        getRogersOVCheckoutPage().closeInvalidOfferCodePopUp();
//        }
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

