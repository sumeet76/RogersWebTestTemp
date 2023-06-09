package com.rogers.test.tests.ovr;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC65_Fido_WirelessCX_To_Nac_Flow_ISS_IntID_OVC_EN_ON_Test extends BaseTestClass {

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startOVSession(System.getProperty("OVFidoUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
    @Test(groups = {"OVR", "RegressionOVR"})
    public void ovr_Auto_TC65_Fido_WirelessCX_To_Nac_Flow_ISS_IntID_OVC_EN_ON_Test(){
        getEnvironmentSelectionPage().launchOneViewFido(TestDataHandler.tc_65_Ovr_FidoToRogers_Care_Nac_Data_ISS.getBanNumber(), "CO2100013754");
        reporter.reportLogWithScreenshot("OneView Fido Interface has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("address");
        getRogersIgniteBundlesPage().checkAvailability("43 AIRPORT HEIGHTS DR, ST. JOHN'S, NL, A1A4W8","Chrome");
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
        reporter.reportLogWithScreenshot("Select Services Customer Wants");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        getRogersIgniteBundlesPage().clkSmartStream();
        reporter.reportLogWithScreenshot("Smart Stream - SAI ISS Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("loading offers");

        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("added to cart");
        getRogersIgniteBundlesPage().noPortInPopup();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");

        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.hardAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyCreditEvaluationHeader(),"Credit Evaluation Displayed","Credit Evaluation did not Displayed");
        reporter.reportLogWithScreenshot("Credit Evaluation screen loaded");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay());
        reporter.reportLogWithScreenshot("Credit Check DOB entered");
        getCreditCheckPage().selectInternationalID(FormFiller.generateRandomNumber(9), FormFiller.generateExpiryYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay(),
                FormFiller.generatePassportNumber(), FormFiller.generateExpiryYear(), FormFiller.generateMonth(), FormFiller.generateCalendarDay());
        reporter.reportLogWithScreenshot("credit form completed");
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
        reporter.hardAssert(getCreditCheckPage().verifyRecoEngineRecommendation(),"Reco Engine Install Recommendation Banner displayed"," Reco Engine Install Recommendation Banner is not displayed");
        reporter.hardAssert(getCreditCheckPage().verifyRecommendationBanner(),"Recommended Banner is displayed", "Recommeded Banner is not displayed");reporter.reportLogWithScreenshot("Installation options");
        getCreditCheckPage().verifyInstallationOption();
        getCreditCheckPage().goToPageBottom();
        getCreditCheckPage().selectDeliveryByAppointment();
        getFulfillmentPage().clkFirstAvailableAppointment();
        reporter.reportLogWithScreenshot(".enter Text Mobile Number");
        getCreditCheckPage().enterTextMobileNumber("1010000061");
        getCreditCheckPage().enterEmailMailAddress("djasker.auto@mailinator.com");
        reporter.reportLogWithScreenshot(".enter Special Instructions");
        getCreditCheckPage().enterSpecialInstructions();
        getCreditCheckPage().clkContinueInstallationOption();
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        reporter.reportLogWithScreenshot("in person delivery");
        getPaymentOptionsPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        getCreditCheckPage().verifyBillingAndPaymentOption();
        reporter.reportLogWithScreenshot("Billing and payment");
        getCreditCheckPage().selectPaymentOption(1);
        reporter.reportLogWithScreenshot("Monthly charges");
        getPaymentOptionsPage().clkContinue();
        reporter.reportLogWithScreenshot("submit order");
        getRogersOVCheckoutPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");


    }
}
