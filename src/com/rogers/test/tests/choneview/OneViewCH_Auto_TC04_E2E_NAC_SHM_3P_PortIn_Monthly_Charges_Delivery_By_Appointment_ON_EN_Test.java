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

public class OneViewCH_Auto_TC04_E2E_NAC_SHM_3P_PortIn_Monthly_Charges_Delivery_By_Appointment_ON_EN_Test extends BaseTestClass {
    @Test(groups = {"ERM"})
    public void oneViewCH_Auto_TC04_E2E_NAC_SHM_3P_PortIn_Monthly_Charges_Delivery_By_Appointment_ON_EN(){
        reporter.reportLogWithScreenshot("oneview env");
        getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getEnvironmentSelectionPage().clickProceed();
        reporter.reportLogWithScreenshot("Click proceed button");
        reporter.reportLogWithScreenshot("address");
        getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress());
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
        reporter.reportLogWithScreenshot("Select Services Customer Wants");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        getRogersIgniteBundlesPage().clickSmartHomeMonitoring();
        reporter.reportLogWithScreenshot("Triple Play & SHM Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        getRogersIgniteBundlesPage().yesPortInPopup();
        reporter.reportLogWithScreenshot("Select Yes for port in options");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Port In Service");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("portin");
        getRogersIgniteBundlesPage().clkContinueFor3PPortIn();
        reporter.reportLogWithScreenshot("Port In initiated");
        getRogersIgniteBundlesPage().setProvider("BELL ONTARIO");
        reporter.reportLogWithScreenshot("provider");
        getRogersIgniteBundlesPage().enterAccountNumber("1122334455");
        reporter.reportLogWithScreenshot("portin details");
        getRogersIgniteBundlesPage().contiueFromPortIn();
        reporter.reportLogWithScreenshot("portin continue");
        getRogersIgniteBundlesPage().contiueToCartSummary();
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue is clicked");
//		getRogersIgniteBundlesPage().clkExpressCheckOut();
        getRogersIgniteBundlesPage().fourKTVPopup();
        getRogersIgniteBundlesPage().contiue4KContent();
        reporter.softAssert(getRogersIgniteBundlesPage().validateInternetAddOnsHeader(),"internet add header displayed","internet addon header did not display");
        reporter.reportLogWithScreenshot("Click Continue InternetAddon");
        getRogersIgniteBundlesPage().clkContinueInternetAddon();
        reporter.softAssert(getRogersIgniteBundlesPage().validateHomephoneAddOnsHeader(),"internet add header displayed","internet addon header did not display");
        reporter.reportLogWithScreenshot("Click Continue HomephoneAddon");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Clicked on Continue");
        getRogersIgniteBundlesPage().addSHMAddOn();
        reporter.reportLogWithScreenshot("clicked SHM Add On Add To Cart");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        reporter.reportLogWithScreenshot("cart summary");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("continue");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("credit form");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        reporter.reportLogWithScreenshot("filled customer credit form");
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
        getHomePhoneSelectionPage().selectDiffNumb();
        reporter.reportLogWithScreenshot("generate phone number");
        getHomePhoneSelectionPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
        reporter.hardAssert(getCreditCheckPage().verifyRecoEngineRecommendation(),"Reco Engine Install Recommendation Banner displayed"," Reco Engine Install Recommendation Banner is not displayed");
        reporter.hardAssert(getCreditCheckPage().verifyRecommendationBanner(),"Recommended Banner is displayed", "Recommeded Banner is not displayed");reporter.reportLogWithScreenshot("Installation options");
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("in person delivery");
        getCreditCheckPage().selectProfessionalInstallation();
        //getCreditCheckPage().clickDateTimeRadioButton();
       getFulfillmentPage().clkFirstAvailableAppointment();
        reporter.reportLogWithScreenshot(".enter Text Mobile Number");
        getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
       // getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
        reporter.reportLogWithScreenshot(".enter Special Instructions");
        getCreditCheckPage().enterSpecialInstructions();
        getCreditCheckPage().clkContinueInstallationOption();
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        getCreditCheckPage().verifyBillingAndPaymentOption();
        reporter.reportLogWithScreenshot("billing and payment");
        getCreditCheckPage().selectPaymentOption(1);
        reporter.reportLogWithScreenshot("Monthly charges");
        getPaymentOptionsPage().clkContinue();
        getRogersOVCheckoutPage().clkSubmit();
        reporter.reportLogWithScreenshot("submit payment");
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");
    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactID_SHM_3P_PortIn(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
