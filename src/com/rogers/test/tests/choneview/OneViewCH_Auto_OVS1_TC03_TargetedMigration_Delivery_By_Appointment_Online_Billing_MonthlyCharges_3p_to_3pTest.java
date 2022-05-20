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

public class OneViewCH_Auto_OVS1_TC03_TargetedMigration_Delivery_By_Appointment_Online_Billing_MonthlyCharges_3p_to_3pTest extends BaseTestClass {
    @Test(groups = {"RegressionCHOV"})
    public void oneViewCH_Auto_OVS1_TC03_TargetedMigration_Delivery_By_Appointment_Online_Billing_MonthlyCharges_3p_to_3pTest(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.TargetedMigration_Delivery_by_Appointment_3pto3p_MonthlyCharges.getAccountNo(), TestDataHandler.TargetedMigration_Delivery_by_Appointment_3pto3p_MonthlyCharges.getContactID() );
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("User is prompted with check availability pop up");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Service Availability-Success window");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().verifyRecommendedOffers();
        reporter.reportLogWithScreenshot("Targeted offer for the customer is displayed under the recommended offer section");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        reporter.reportLogWithScreenshot("TV checkbox clicked");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Internet checkbox Clicked");
        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        reporter.reportLogWithScreenshot("Homephone checkbox Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("clicked on load offers");
        getRogersIgniteBundlesPage().clkAddToCartForBestOffer();
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clickNewNumber();
        reporter.reportLogWithScreenshot("click new number");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Monthly fee displayed");
        getRogersIgniteBundlesPage().clkCollapse();
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("continue button clicked");
        getRogersIgniteBundlesPage().clickInternetCollapse();
        getRogersIgniteBundlesPage().clickHomePhoneCollapse();
        getRogersIgniteBundlesPage().clickBatteryBackUpCollapse();
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        getRogersIgniteBundlesPage().clickExchangeNow();
        getRogersIgniteExchangePage().selectFirstChannelToRemove();
        reporter.reportLogWithScreenshot("first channel selected");
        getRogersIgniteExchangePage().clickSelectButton();
        reporter.reportLogWithScreenshot("button select");
        getRogersIgniteExchangePage().selectFirstChannelToAdd();
        reporter.reportLogWithScreenshot("first channel to Add");
        getRogersIgniteExchangePage().clickSelectButton();
        reporter.reportLogWithScreenshot("button select");
        getRogersIgniteBundlesPage().scrollToContinue();
        getRogersIgniteBundlesPage().clkContinue();
        getRogersOVChannelsAndThemePacksPage().clkCustomerAddonReview();
        reporter.reportLogWithScreenshot("Customer reviewed add ons link clicked");
        getRogersIgniteBundlesPage().scrollToContinue();
        getRogersIgniteBundlesPage().clkContinue();
        getRogersOVChannelsAndThemePacksPage().clickNoTheyDont();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyInternetAddOnsHeader(),"Internet Add ons header Available","Internet Add ons header not available");
        getRogersIgniteBundlesPage().scrollToContinue();
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("click continue");
        reporter.hardAssert(getHomePhoneAddonsPage().verifyHomePhoneAddOnsHeader(),"Home Phone Add ons header Available","Home Phone Add ons header not available");
        getRogersIgniteBundlesPage().scrollToContinue();
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("Product Added");
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
        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
        reporter.reportLogWithScreenshot("Installation options");
        getCreditCheckPage().verifyInstallationOption();
        getCreditCheckPage().goToPageBottom();
        reporter.reportLogWithScreenshot("Delivery By Appointment");
        getCreditCheckPage().selectDeliveryByAppointment();
        reporter.reportLogWithScreenshot("click Date Time Radio Button");
        getFulfillmentPage().clkFirstAvailableAppointment();
        reporter.reportLogWithScreenshot(".enter Text Mobile Number");
        getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
        reporter.reportLogWithScreenshot(".enter Email Mail Address");
        getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
        reporter.reportLogWithScreenshot(".enter Special Instructions");
        getCreditCheckPage().enterSpecialInstructions();
        reporter.reportLogWithScreenshot("Continue button clicked");
        getPaymentOptionsPage().clkContinue();
        reporter.reportLogWithScreenshot("Verifying billing and Payment options available");
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        reporter.reportLogWithScreenshot("select oline billing option");
       getCreditCheckPage().selectOnlineBilling();
        reporter.reportLogWithScreenshot("select monthly payment options from dropdown");
        getCreditCheckPage().selectPaymentOption(1);
        reporter.reportLogWithScreenshot("Continue button clicked");
        getPaymentOptionsPage().clkContinue();
        //reporter.reportLogWithScreenshot("One Time fee available at order review page");
        //reporter.hardAssert(getRogersOVOrderReviewPage().,"One time fees and credit amount is correct"," One time fees and credit amount is not correct");
       //getOVROrderReviewPage().checkOneTimeFee();
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



