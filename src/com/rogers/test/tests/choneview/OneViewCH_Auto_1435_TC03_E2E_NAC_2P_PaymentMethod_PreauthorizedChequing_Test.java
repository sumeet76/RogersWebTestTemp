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


public class OneViewCH_Auto_1435_TC03_E2E_NAC_2P_PaymentMethod_PreauthorizedChequing_Test extends BaseTestClass {
	@Test (groups = {"RNAC","RegressionCHOV"})
    public void oneViewCH_Auto_1435_TC03_E2E_NAC_2P_PaymentMethod_PreauthorizedChequing_Test(){
        reporter.reportLogWithScreenshot("oneview env");
        getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        reporter.reportLogWithScreenshot("address");
		getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress());
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress()+" not serviceable");
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
		reporter.reportLogWithScreenshot("Select Services Customer Wants");
		getRogersIgniteBundlesPage().clkTVCheckbox();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		reporter.reportLogWithScreenshot("Double Play Selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("offers loading");
		getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("added to cart");

        getRogersIgniteBundlesPage().noPortInPopup();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
		reporter.reportLogWithScreenshot("Product in cart");
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().fourKContentPopup();
		reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyPersonalizeYourChannels(),"Personalize You Channel displayed","Personalize You Channel did not Displayed");
		getRogersIgniteBundlesPage().clkCheckOut();
		reporter.reportLogWithScreenshot("Cart Summary");
		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().fourKContentPopup();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("continue from cart summary");
        getRogersIgniteBundlesPage().customerWishtoContinue();
		reporter.hardAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
		getCustomerProfilePage().clkContinue();
		reporter.hardAssert(getCreditCheckPage().verifyCreditEvaluationHeader(),"Credit Evaluation Displayed","Credit Evaluation did not Displayed");
		reporter.reportLogWithScreenshot("Credit Evaluation screen loaded");
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        reporter.reportLogWithScreenshot("evaluation form filled");
        getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		getCreditCheckPage().clkContinue();
		reporter.reportLogWithScreenshot("Installation options");
		getCreditCheckPage().verifyInstallationOption();
		getCreditCheckPage().goToPageBottom();
        reporter.reportLogWithScreenshot("in person delivery");
		getCreditCheckPage().clickInPersonDelivery();
		getPaymentOptionsPage().clkContinue();
		reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
        reporter.reportLogWithScreenshot("verify billing and payments");
		getCreditCheckPage().verifyBillingAndPaymentOption();
		getCreditCheckPage().clickDigitalFrontline();
        reporter.reportLogWithScreenshot("front line");

		getCreditCheckPage().selectPaymentOption(2);
		reporter.reportLogWithScreenshot("Pre-authorized Chequing");
		getRogersOVCheckoutPage().enterTransitNumber("00333");
		reporter.reportLogWithScreenshot("Transit number");
		getRogersOVCheckoutPage().enterInstitutionNumber("003");
		reporter.reportLogWithScreenshot("Institution Number");
		getRogersOVCheckoutPage().enterAccountNumber("1234003");
		reporter.reportLogWithScreenshot("Account Number");

		getPaymentOptionsPage().clkContinue();
		getRogersOVCheckoutPage().clkSubmit();
        reporter.reportLogWithScreenshot("submit order");
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
		reporter.reportLogWithScreenshot("Order Placed");

    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactIDforDualPlay(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


