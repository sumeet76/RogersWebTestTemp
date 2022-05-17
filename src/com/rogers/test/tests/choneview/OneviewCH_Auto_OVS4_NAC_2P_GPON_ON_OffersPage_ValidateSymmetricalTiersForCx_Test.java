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

public class OneviewCH_Auto_OVS4_NAC_2P_GPON_ON_OffersPage_ValidateSymmetricalTiersForCx_Test extends BaseTestClass {

    @Test(groups = {"RegressionCHOV"})
    public void oneviewCH_Auto_OVS4_NAC_2P_GPON_ON_OffersPage_ValidateSymmetricalTiersForCx_Test(){
        reporter.reportLogWithScreenshot("OneView env");
        getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        reporter.reportLogWithScreenshot("address");
        getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.GponData.getcontactDetails().getAddress());
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.GponData.contactDetails.getAddress()+" is serviceable",TestDataHandler.GponData.contactDetails.getAddress()+" not serviceable");
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
        reporter.reportLogWithScreenshot("Select Services Customer Wants");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Internet & TV Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("load offers");
        getRogersIgniteBundlesPage().clickViewDetails();
        reporter.reportLogWithScreenshot("Package Details");
        getRogersIgniteBundlesPage().clkExpandPackageDetails();
        reporter.reportLogWithScreenshot("Package details section expanded");
        reporter.hardAssert(getTVDashboardPage().verifyDownloadAndUploadSpeed(),"Download and upload speed symmetrical"," Download and upload speed not symmetrical");
        getRogersIgniteBundlesPage().clkCloseBtn();
        reporter.reportLogWithScreenshot("View details modal closed");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("added to cart");
        getRogersIgniteBundlesPage().noPortInPopup();
        reporter.reportLogWithScreenshot("no Port In Popup");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clkExpressCheckOut();
        getRogersIgniteBundlesPage().fourKTVPopup();
        getRogersIgniteBundlesPage().fourKContentPopup();
        reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyPersonalizeYourChannels(),"Personalize You Channel displayed","Personalize You Channel did not Displayed");
        reporter.reportLogWithScreenshot("Cart Summary");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyFibreActivationMSg(),"CUSTOMER WILL BE ACTIVATED ON FIBRE Msg shown","CUSTOMER WILL BE ACTIVATED ON FIBRE did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.hardAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyCreditEvaluationHeader(),"Credit Evaluation Displayed","Credit Evaluation did not Displayed");
        reporter.reportLogWithScreenshot("Credit Evaluation screen loaded");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.GponData.getcontactDetails().getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.GponData.getcontactDetails().getPassportNo());
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        reporter.reportLogWithScreenshot("Installation options");
        reporter.hardAssert(getCreditCheckPage().verifyInstallationOption(),"Installation Options Displays","Installation Options note Displayed");
        reporter.reportLogWithScreenshot("professional Installation");
        getCreditCheckPage().selectProfessionalInstallation();
        reporter.reportLogWithScreenshot("click Date Time Radio Button");
        getFulfillmentPage().clkFirstAvailableAppointment();
//		getCreditCheckPage().clickDateTimeRadioButton();
        reporter.reportLogWithScreenshot(".enter Text Mobile Number");
        getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
        reporter.reportLogWithScreenshot(".enter Email Mail Address");
        getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
        reporter.reportLogWithScreenshot(".enter Special Instructions");
        getCreditCheckPage().enterSpecialInstructions();
        getPaymentOptionsPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        reporter.reportLogWithScreenshot("select oline billing option");
        getCreditCheckPage().selectOnlineBilling();
        reporter.reportLogWithScreenshot("select monthly payment options from dropdown");
        getCreditCheckPage().selectPaymentOption(1);
        reporter.reportLogWithScreenshot("Continue button clicked");
        getPaymentOptionsPage().clkContinue();
		getRogersOVCheckoutPage().clkSubmit();
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");


    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeMethod(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext testContext, Method method)
    throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),
                TestDataHandler.GponData.getcontactDetails().getContactID(), "", System.getenv("MaestroLoginID"),
                System.getenv("MaestroUsrID"), method);
    }

}
