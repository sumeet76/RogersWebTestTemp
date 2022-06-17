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

public class OneViewCH_Auto_1568_TC01_TargetedMigration_3P_to_3P_change_numbTest extends BaseTestClass {

    @Test
    public void oneViewCH_Auto_1568_TC01_TargetedMigration_3P_to_3P_change_numbTest(){
//          Launch One view

        getEnvironmentSelectionPage().launchOneView(TestDataHandler.targetedMigration_3P_to_3P_change_numb.getAccountNo(), TestDataHandler.targetedMigration_3P_to_3P_change_numb.getContactID());
        getAccountOverViewPage().enterDealerCodeDialogue();
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().clickIgnite();

//       Rogers Ignite page.

        reporter.reportLogWithScreenshot("User is prompted with check availability pop up");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Service Availability-Success window");
        getRogersIgniteBundlesPage().clkContinueServiceable();

        getRogersIgniteBundlesPage().verifyRecommendedOffers();
        reporter.reportLogWithScreenshot("Targeted offer for the customer is displayed under the recommended offer section");
        getRogersIgniteBundlesPage().selectRecommendedOffer();
        reporter.reportLogWithScreenshot("Selected the Recommended offer");

//        getRogersIgniteBundlesPage().clkTVCheckbox();
//        getRogersIgniteBundlesPage().clkInternetCheckbox();
//        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        reporter.reportLogWithScreenshot("Triple Play - Internet, TV and HomePhone is Selected");
//        getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clkAddToCartForBestOffer();
        reporter.reportLogWithScreenshot("Best targeted offer for the customer is displayed");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyHomePhoneSetupPopUp(),"Homephone pop is displayed","no popup is displayed");
        getRogersIgniteBundlesPage().clkChooseNewNumberbtn();
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().goToPageBottom();
        reporter.reportLogWithScreenshot("review terms and condition");
        getRogersIgniteBundlesPage().expandInternetdiv();
        getRogersIgniteBundlesPage().expandHomePhonediv();
        getRogersIgniteBundlesPage().goToPageBottom();
        getRogersIgniteBundlesPage().expandBatteryBackUpdiv();
        getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
        reporter.reportLogWithScreenshot("Term and condition checkbox checked");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        getRogersIgniteBundlesPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Clicked Exchange later");
        getRogersIgniteBundlesPage().clickReviewAddons();
        reporter.reportLogWithScreenshot("Clicked Review Addons");
        getTVDashboardPage().selectStandaloneChannelsTab();
        getTVDashboardPage().clickAddChannel();
        reporter.reportLogWithScreenshot("Channel added");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersOVChannelsAndThemePacksPage().clkbtnContinueOn4ktv();
        getRogersIgniteBundlesPage().fourKContentPopup();
        reporter.reportLogWithScreenshot("bottom to continue");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Home Phone Add on page displayed");
        getHomePhoneAddonsPage().clkContinue();
        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();

//        In the case of Credit evaluation not required

//        reporter.softAssert(getCreditCheckPage().verifyCreditEvaluationHeader(),"Credit Evaluation Header verified","Failed");
//        reporter.reportLogWithScreenshot("Credit check page is displayed");
//        getCreditCheckPage().goToPageBottom();

//        In the case of credit evaluation is required
        reporter.reportLogWithScreenshot("Credit check page is displayed");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");

        getCreditCheckPage().clkContinue();
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        getHomePhoneSelectionPage().verifySelectedNumber();
        getHomePhoneSelectionPage().clkContinueOnGeneratePhone();

        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("Installation options");
        getCreditCheckPage().clkCourierDelivery();
        getCreditCheckPage().goToPageBottom();
        getCreditCheckPage().clickInPersonDelivery();
        reporter.reportLogWithScreenshot("In Person Delivery is Selected");
        getPaymentOptionsPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        getCreditCheckPage().verifyBillingAndPaymentOption();
        getPaymentOptionsPage().clkContinue();

//        Checkout Page

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


