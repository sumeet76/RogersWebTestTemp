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


public class OneViewCH_Auto_1443_TC01_E2E_NAC_SAI_DeliveryByAppointment_PaymentMethod_CreditCard_test extends BaseTestClass {
	@Test (groups = {"RNAC","RegressionCHOV"})
	public void oneViewCH_Auto_1443_TC01_E2E_NAC_SAI_DeliveryByAppointment_PaymentMethod_CreditCard_test(){
		reporter.reportLogWithScreenshot("oneView env");
		getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		reporter.reportLogWithScreenshot("address");
		getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress());
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress()+" not serviceable");
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("click Continue");
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		reporter.reportLogWithScreenshot("click Internet Checkbox");
		/*getRogersIgniteBundlesPage().clkSmartStream();
		reporter.reportLogWithScreenshot("Smart Stream - SAI ISS Selected");*/
		getRogersIgniteBundlesPage().clkLoadOffers();
		reporter.reportLogWithScreenshot("load offers");
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		reporter.reportLogWithScreenshot("added to cart");
		getRogersIgniteBundlesPage().noPortInPopup();
		reporter.reportLogWithScreenshot("no Port In Popup");
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.reportLogWithScreenshot("click Collapse");
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("click Continue");
		getRogersIgniteBundlesPage().clkExpressCheckOut();
		reporter.reportLogWithScreenshot("cart summary checkout");
		getRogersIgniteBundlesPage().clkCheckOut();
		reporter.reportLogWithScreenshot("Cart Summary");
//		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		reporter.reportLogWithScreenshot("cart summary checkout");
		getRogersIgniteBundlesPage().customerWishtoContinue();
		reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
		getCustomerProfilePage().clkContinue();
		reporter.reportLogWithScreenshot("evaluation form");
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		reporter.reportLogWithScreenshot("set DOB");
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		reporter.reportLogWithScreenshot("set Drivers License");
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		reporter.reportLogWithScreenshot("set Passport");
		reporter.reportLogWithScreenshot("evaluation form filled");
		getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		getCreditCheckPage().clkContinue();
		reporter.reportLogWithScreenshot("click Continue");
		reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
		reporter.reportLogWithScreenshot("Installation options");
		getCreditCheckPage().verifyInstallationOption();
		getCreditCheckPage().goToPageBottom();
		reporter.reportLogWithScreenshot("Delivery By Appointment");
		getCreditCheckPage().selectDeliveryByAppointment();
		reporter.reportLogWithScreenshot("click Date Time Radio Button");
		getFulfillmentPage().clkFirstAvailableAppointment();
//		getCreditCheckPage().clickDateTimeRadioButton();
		reporter.reportLogWithScreenshot(".enter Text Mobile Number");
		getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
		reporter.reportLogWithScreenshot(".enter Email Mail Address");
		getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
		reporter.reportLogWithScreenshot(".enter Special Instructions");
		getCreditCheckPage().enterSpecialInstructions();
		reporter.reportLogWithScreenshot("in person delivery");
//		getCreditCheckPage().clickInPersonDelivery();
		getPaymentOptionsPage().clkContinue();
		reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
		reporter.reportLogWithScreenshot("billing and payment");
		getCreditCheckPage().verifyBillingAndPaymentOption();
		getCreditCheckPage().clickDigitalFrontline();
		reporter.reportLogWithScreenshot("digital front line");
		getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
		reporter.reportLogWithScreenshot("enter Card Token");
		getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
		reporter.reportLogWithScreenshot("set Card Expiry Month And Year");
		getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
//		reporter.reportLogWithScreenshot("payment details entered");
//		getPaymentOptionsPage().clkContinue();
//		reporter.reportLogWithScreenshot("sumbit order");
//		getRogersOVCheckoutPage().clkSubmit();
//		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");

	}

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactIDSAIDeliveryByAppt(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


