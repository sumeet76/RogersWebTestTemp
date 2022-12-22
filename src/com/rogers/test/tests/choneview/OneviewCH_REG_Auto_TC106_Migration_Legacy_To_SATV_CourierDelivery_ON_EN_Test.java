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

public class OneviewCH_REG_Auto_TC106_Migration_Legacy_To_SATV_CourierDelivery_ON_EN_Test extends BaseTestClass {
    @Test
    public void oneviewCH_REG_Auto_TC106_Migration_Legacy_To_SATV_CourierDelivery_ON_EN_Test(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData.getAccountNoLegacyToSATV(),TestDataHandler.migrationData.getContactIDLegacyToSATV());
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("User is prompted with check availability pop up");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Service Availability-Success window");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(), "Address Check passed", "Address check not passed");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(), "Select Services Customer Wants Displayed", "Select Services Customer Wants did not Displayed");
        reporter.reportLogWithScreenshot("Select Services Customer Wants");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        reporter.reportLog("select the TV and HomePhone  checkbox");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("loading offers");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("added to cart");
        getRogersIgniteBundlesPage().noPortInPopup();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(), "Monthly Fees Displayed", "Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(), "Product Added to Cart", "Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.reportLogWithScreenshot("review terms and condition");
        getRogersIgniteBundlesPage().reviewAllTerms();
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        reporter.reportLogWithScreenshot("Points to mention");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();

        getRogersIgniteBundlesPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("After Exchange later");
        getRogersIgniteBundlesPage().clickReviewAddons();
        getCustomerProfilePage().clkContinue();
        getRogersIgniteBundlesPage().noTo4KTVPopup();
//        getRogersIgniteBundlesPage().fourKTVPopup();
//        getRogersIgniteBundlesPage().contiue4KContent();

        reporter.softAssert(getRogersIgniteBundlesPage().validateInternetAddOnsHeader(),"internet add header displayed","internet addon header did not display");
        getRogersIgniteBundlesPage().clkContinueInternetAddon();

        reporter.hardAssert(getRogersIgniteBundlesPage().validateHomephoneAddOnsHeader(),"Internet Add on hearder displayed", "Header does not displayed");
        getRogersIgniteBundlesPage().clkContinue();

        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        reporter.reportLogWithScreenshot("Cart Summary");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();

        reporter.softAssert(getCreditCheckPage().verifyCreditEvaluationHeader(),"Credit Evaluation Header verified","Failed");
        reporter.reportLogWithScreenshot("Credit check page is displayed");
        reporter.reportLogWithScreenshot("evaluation form");

        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
//        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
//        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
//        getCreditCheckPage().clkAuthorize();

        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        reporter.reportLogWithScreenshot("Phone Number Selected");
        getCreditCheckPage().goToPageBottom();
        getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("installation options");
        getCreditCheckPage().clkCourierDelivery();
        getCreditCheckPage().clickInPersonDelivery();
        reporter.reportLogWithScreenshot("in person delivery");
        getPaymentOptionsPage().clkContinue();
        getCreditCheckPage().verifyBillingAndPaymentOption();
        reporter.reportLogWithScreenshot("Billing and payment");

        getPaymentOptionsPage().clkContinue();
        reporter.reportLogWithScreenshot("Submit order");
//        getRogersOVCheckoutPage().clkSubmit();
//        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
//        reporter.reportLogWithScreenshot("Order Placed");

    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext testContext, Method method)throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
    }
    @AfterMethod(alwaysRun=true)
    public void afterTest(){
        getDriver().quit();
    }
}
