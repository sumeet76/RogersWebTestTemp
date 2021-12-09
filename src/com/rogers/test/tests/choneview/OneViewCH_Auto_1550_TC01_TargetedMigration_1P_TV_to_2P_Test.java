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

public class OneViewCH_Auto_1550_TC01_TargetedMigration_1P_TV_to_2P_Test extends BaseTestClass {
    @Test(groups = {"RegressionCHOV"})
    public void oneViewCH_1547_TC01_TargetedMigrationFlow_1P_Tv_to_2PTest(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.targetedMigration1PTvTo2P.getAccountNo(), TestDataHandler.targetedMigration1PTvTo2P.getContactID() );
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        reporter.reportLogWithScreenshot("enter Dealer Code Dialogue");
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("User is prompted with check availability pop up");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("clkContinue");
        getRogersIgniteBundlesPage().refreshContinue();
        reporter.reportLogWithScreenshot("refreshContinue");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Targeted offer for the customer is displayed under the recommended offer section");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        reporter.reportLogWithScreenshot("click TV Checkbox");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Dual Play- Internet TV are Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("click Load Offers");
        getRogersIgniteBundlesPage().clkAddToCartForBestOffer();
        reporter.reportLogWithScreenshot("click Add To Cart For Best Offer");
        getRogersIgniteBundlesPage().noPortInPopup();
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.reportLogWithScreenshot("click Collapse");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("click Continue");
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        reporter.reportLogWithScreenshot("review Terms And Condition");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();

        reporter.reportLogWithScreenshot("click Continue From Points To Mention");
        getRogersIgniteBundlesPage().clickReviewAddons();
        reporter.reportLogWithScreenshot("click Review Addons");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("click Continue");
        getRogersIgniteBundlesPage().fourKTVPopup();
        reporter.reportLogWithScreenshot("four K TV Popup");
        getRogersIgniteBundlesPage().contiue4KContent();
        reporter.reportLogWithScreenshot("contiue 4K Content");
        getRogersIgniteBundlesPage().scrollToContinue();
        reporter.reportLogWithScreenshot("scroll To Continue");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();

        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("click Continue");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        reporter.reportLogWithScreenshot("enter DOB");
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        reporter.reportLogWithScreenshot("enter DriversLicense");
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        reporter.reportLogWithScreenshot("enter Passport");
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        reporter.reportLogWithScreenshot("click Continue");
        getCreditCheckPage().goToPageBottom();
        reporter.reportLogWithScreenshot("go To Page Bottom");
        getCreditCheckPage().goToPageBottom();
        reporter.reportLogWithScreenshot("go To Page Bottom");
        getCreditCheckPage().clickInPersonDelivery();
        reporter.reportLogWithScreenshot("click In Person Delivery");
        getPaymentOptionsPage().clkContinue();
        reporter.reportLogWithScreenshot("click Continue");
        getCreditCheckPage().verifyBillingAndPaymentOption();
        reporter.reportLogWithScreenshot("verify Billing And Payment Option");
        getCreditCheckPage().clickDigitalFrontline();
        reporter.reportLogWithScreenshot("click Digital Front line");
        getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
        reporter.reportLogWithScreenshot("enter Card Token");
        getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
        reporter.reportLogWithScreenshot("set Card Expiry Month And Year");
        getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
        reporter.reportLogWithScreenshot("set Card CVV");
		getPaymentOptionsPage().clkContinue();
        reporter.reportLogWithScreenshot("click Continue");
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
