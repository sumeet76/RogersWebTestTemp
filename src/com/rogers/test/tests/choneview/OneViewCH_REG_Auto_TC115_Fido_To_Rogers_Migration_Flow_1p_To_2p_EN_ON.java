package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_REG_Auto_TC115_Fido_To_Rogers_Migration_Flow_1p_To_2p_EN_ON extends BaseTestClass {
    @Test(groups = {"RMigration","RegressionCHOV"})
    public void oneViewCH_REG_Auto_TC115_Fido_To_Rogers_Migration_Flow_1p_To_2p_EN_ON(){
        getEnvironmentSelectionPage().launchOneViewFido(TestDataHandler.migrationData.getAccountNo(), TestDataHandler.migrationData.getContactID());
        reporter.reportLogWithScreenshot("OneView Fido Interface has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        reporter.reportLogWithScreenshot("Click proceed button");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clkContinueServiceable();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
        reporter.reportLogWithScreenshot("Select Services Customer Wants");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Internet selected");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        reporter.reportLogWithScreenshot("TV selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("Load offers");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("added to cart");
        getRogersIgniteBundlesPage().noPortInPopup();
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
        reporter.reportLogWithScreenshot("Term and condition checkbox checked");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
//        getRogersIgniteBundlesPage().clickExchangeLater();
//        reporter.reportLogWithScreenshot("Clicked On Exchange later");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Clicked Continue on add channel and theme pack");
        getRogersIgniteBundlesPage().fourKTVPopup();
        reporter.reportLogWithScreenshot("Clicked yes on 4k tv pop up");
        getRogersIgniteBundlesPage().contiue4KContent();
        reporter.softAssert(getRogersIgniteBundlesPage().validateInternetAddOnsHeader(),"internet add header displayed","internet addon header did not display");
        getRogersIgniteBundlesPage().clkContinueInternetAddon();

        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
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
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("Installation options displayed");
        getCreditCheckPage().clkCourierDelivery();
        reporter.reportLogWithScreenshot("Courier Delivery selected");
        getCreditCheckPage().clickInPersonDelivery();
        reporter.reportLogWithScreenshot("in person delivery");
        getPaymentOptionsPage().clkContinue();
        getCreditCheckPage().verifyBillingAndPaymentOption();
        reporter.reportLogWithScreenshot("Billing and payment");

        getPaymentOptionsPage().clkContinue();
        reporter.reportLogWithScreenshot("submit order");
        getRogersOVCheckoutPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");

    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startOVSession(System.getProperty("OVFidoUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
