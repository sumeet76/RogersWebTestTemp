package com.rogers.test.tests.choneview;
import java.io.IOException;
import java.lang.reflect.Method;

import com.rogers.test.helpers.RogersEnums;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;                
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;

import utils.FormFiller;



public class OneViewCH_TC_025_EndtoEndFlowAnonymousCustomerTriplePlayTest extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV"})
    public void endToEndFlowAnonymousCustomerTriplePlayTest(){
		getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress(),System.getProperty("Browser"));
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress()+" not serviceable");
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkTVCheckbox();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
		reporter.reportLogWithScreenshot("Triple Play Selected");
		getRogersIgniteBundlesPage().clkShowOffers();
		getRogersIgniteBundlesPage().clkAddtoCart(TestDataHandler.anonymousData.getplanEng(),TestDataHandler.anonymousData.getplanFr());
		getRogersIgniteBundlesPage().portInPopup();
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().fourKContentPopup();
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
		getRogersIgniteBundlesPage().clkCheckOut();
		reporter.reportLogWithScreenshot("Cart Summary");
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
		getCustomerProfilePage().clkContinue();
		//getCreditCheckPage().setDOB(TestDataHandler.anonymousData.contactDetails.getYearOfBirth(),TestDataHandler.anonymousData.contactDetails.getMonthOfBirth(),TestDataHandler.anonymousData.contactDetails.getDateOfBirth());
		getCreditCheckPage().clkCollapse();
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());	
		//getCreditCheckPage().setIDs(TestDataHandler.anonymousData.contactDetails.getFirstID(),TestDataHandler.anonymousData.contactDetails.getProvince(),TestDataHandler.anonymousData.contactDetails.getIdExpiryYear(),TestDataHandler.anonymousData.contactDetails.getMonthOfBirth(),TestDataHandler.anonymousData.contactDetails.getDateOfBirth(),TestDataHandler.anonymousData.contactDetails.getLicenseNo(),TestDataHandler.anonymousData.contactDetails.getSecondID(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		getCreditCheckPage().clkContinue();
		getHomePhoneSelectionPage().clkGeneratePhoneNo();
		reporter.softAssert(getHomePhoneSelectionPage().verifySelectedNumber(),"Phone Number Selected","Phone Number Selection Failed");
		reporter.reportLogWithScreenshot("Phone Number Selected");
	//	getHomePhoneSelectionPage().entercIDFirstName("Harp");
	//	getHomePhoneSelectionPage().entercIDLastName("Gill");
		//getHomePhoneSelectionPage().clkUpdateCallerID();
		//getHomePhoneSelectionPage().enterDLFirstName("Harp");
		//getHomePhoneSelectionPage().enterDLLastName("Gill");
	//	getHomePhoneSelectionPage().clkUpdateDirectoryListing();
		reporter.softAssert(getHomePhoneSelectionPage().verifyNumber(),"Phone Number Selected","Phone Number Selection Failed");
		getHomePhoneSelectionPage().clkContinue();
		getFulfillmentPage().clkFirstAvailableAppointment();
		reporter.reportLogWithScreenshot("Appointment Selected");
		getFulfillmentPage().clkContinue();
		getPaymentOptionsPage().selectPaymentOption(TestDataHandler.anonymousData.contactDetails.getPaymentOption());
		reporter.reportLogWithScreenshot("Payment Option Selected");
		getPaymentOptionsPage().clkContinue();
		getRogersOVOrderReviewPage().expandMonthlyBill();
		reporter.reportLogWithScreenshot("Monthly Bill");
		//getRogersOVOrderReviewPage().expandOneTimeFees();
		reporter.reportLogWithScreenshot("One Time Fees");
		getRogersOVOrderReviewPage().clkSubmit();
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
		reporter.reportLogWithScreenshot("Order Placed");
		
    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactIDforDualPlay(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


