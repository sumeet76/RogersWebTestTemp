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

public class OneViewCH_Auto_TC08_E2E_Validate_Migration_SAI_To_SAI_GPON_ON_EN_Test extends BaseTestClass {
    @Test(groups = {"ERM"})
    public void oneViewCH_Auto_TC08_E2E_Validate_Migration_SAI_To_SAI_GPON_ON_EN(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Migration_SAI_GPON.accountDetails.getBan(),TestDataHandler.Migration_SAI_GPON.getContactID());
        reporter.reportLogWithScreenshot("OneView Interface has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        getEnvironmentSelectionPage().selectProduction();
        reporter.reportLogWithScreenshot("Selected Production");
        getEnvironmentSelectionPage().clickProceed();
        reporter.reportLogWithScreenshot("Clicked proceed button");
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clkContinueServiceable();
        getRogersIgniteBundlesPage().goToPageBottom();
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Internet Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("load offers");
        getRogersIgniteBundlesPage().clickViewDetails();
        reporter.reportLogWithScreenshot("View Details Clicked");
        getRogersIgniteBundlesPage().clkExpandPackageDetails();
        reporter.reportLogWithScreenshot("Expand Package Details");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyInternetDownloadAndUploadSpeed(),"Download and upload speed symmetrical"," Download and upload speed not symmetrical");
        reporter.reportLogWithScreenshot("Download and Upload speed validated");
        getRogersIgniteBundlesPage().clkCloseBtn();
        reporter.reportLogWithScreenshot("select first package to add in cart");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("review terms and condition");
        getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
        reporter.reportLogWithScreenshot("points to mention");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        reporter.reportLogWithScreenshot("contine from terms");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyInternetAddOnsHeader(),"Internet Addons Header displayed","Internet Addons  Header did not Displayed");
        getRogersIgniteBundlesPage().clkContinueInternetAddon();
        reporter.reportLogWithScreenshot("bottom to continue");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clickShowPriceBreakdown();
        reporter.reportLogWithScreenshot("Clicked on Show price breakdown Button");
        getRogersIgniteBundlesPage().clickViewPricingDetails();
        reporter.reportLogWithScreenshot("clicked View Pricing and Package Details");
        getRogersIgniteBundlesPage().clkExpandPackageDetails();
        reporter.reportLogWithScreenshot("Expand Package Details");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyInternetDownloadAndUploadSpeed(),"Download and upload speed symmetrical in Cart Summary"," Download and upload speed not symmetrical in cart summery");
        getRogersIgniteBundlesPage().clkCloseBtn();
        reporter.reportLogWithScreenshot("Download and Upload speed is validated on cart summary");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("customer wish to continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();

        reporter.softAssert(getCreditCheckPage().verifyCreditEvaluationHeader(),"Credit Evaluation Header verified","Failed");
        reporter.reportLogWithScreenshot("Credit check page is displayed");
        reporter.reportLogWithScreenshot("evaluation form");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        reporter.reportLogWithScreenshot("evaluation form filled" );
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");

        getCreditCheckPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
        reporter.reportLogWithScreenshot("Installation options");
        getCreditCheckPage().verifyInstallationOption();
        getCreditCheckPage().goToMiddlePage();
        reporter.reportLogWithScreenshot("Select time slots for Professional Install");
        getFulfillmentPage().clkFirstAvailableAppointment();
        reporter.reportLogWithScreenshot(".enter Text Mobile Number");
        getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
        reporter.reportLogWithScreenshot(".enter Email Mail Address");
        getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
        reporter.reportLogWithScreenshot(".enter Special Instructions");
        getCreditCheckPage().enterSpecialInstructions();
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        getCreditCheckPage().verifyBillingAndPaymentOption();
        getCreditCheckPage().clickDigitalFrontline();
        reporter.reportLogWithScreenshot("Digital Payment option selected");
        getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
        getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
        getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
//        getPaymentOptionsPage().clkContinue();
//        reporter.reportLogWithScreenshot("Continue to Order review Page");
//        getRogersOVCheckoutPage().clkSubmit();
//        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
//        reporter.reportLogWithScreenshot("Order Placed");
    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "", "", "", method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
