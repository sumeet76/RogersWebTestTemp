package com.rogers.test.tests.choneview;
import java.io.IOException;
import java.lang.reflect.Method;

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
    @Test @Parameters("strBrowser")
    public void endToEndFlowAnonymousCustomerTriplePlayTest(String browser){
		environment_selection_page.selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
		rogers_ignite_bundles_page.checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress(),browser);
		reporter.hardAssert(rogers_ignite_bundles_page.verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress()+" not serviceable");
		reporter.reportLogWithScreenshot("Service Availability");
		rogers_ignite_bundles_page.clkContinue();
		rogers_ignite_bundles_page.clkTVCheckbox();
		rogers_ignite_bundles_page.clkInternetCheckbox();
		rogers_ignite_bundles_page.clkHomePhoneCheckbox();
		reporter.reportLogWithScreenshot("Triple Play Selected");
		rogers_ignite_bundles_page.clkShowOffers();
		rogers_ignite_bundles_page.clkAddtoCart(TestDataHandler.anonymousData.getplanEng(),TestDataHandler.anonymousData.getplanFr());
		rogers_ignite_bundles_page.portInPopup();
		rogers_ignite_bundles_page.clkCollapse();
		reporter.hardAssert(rogers_ignite_bundles_page.verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		rogers_ignite_bundles_page.clkContinue();
		rogers_ignite_bundles_page.fourKTVPopup();
		rogers_ignite_bundles_page.fourKContentPopup();
		rogers_ignite_bundles_page.clkCollapse();
		reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
		rogers_ignite_bundles_page.clkCheckOut();
		reporter.reportLogWithScreenshot("Cart Summary");
		rogers_ignite_bundles_page.clkCheckOutforCartSummary();
		rogers_ignite_bundles_page.customerWishtoContinue();
        reporter.softAssert(customer_Profile_Page.verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
		customer_Profile_Page.clkContinue();
		//credit_Check_Page.setDOB(TestDataHandler.anonymousData.contactDetails.getYearOfBirth(),TestDataHandler.anonymousData.contactDetails.getMonthOfBirth(),TestDataHandler.anonymousData.contactDetails.getDateOfBirth());
		credit_Check_Page.clkCollapse();
		credit_Check_Page.setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());	
		//credit_Check_Page.setIDs(TestDataHandler.anonymousData.contactDetails.getFirstID(),TestDataHandler.anonymousData.contactDetails.getProvince(),TestDataHandler.anonymousData.contactDetails.getIdExpiryYear(),TestDataHandler.anonymousData.contactDetails.getMonthOfBirth(),TestDataHandler.anonymousData.contactDetails.getDateOfBirth(),TestDataHandler.anonymousData.contactDetails.getLicenseNo(),TestDataHandler.anonymousData.contactDetails.getSecondID(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		credit_Check_Page.setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		credit_Check_Page.setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		credit_Check_Page.clkAuthorize();
		reporter.softAssert(credit_Check_Page.verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		credit_Check_Page.clkContinue();
		home_Phone_Selection_Page.clkGeneratePhoneNo();
		reporter.softAssert(home_Phone_Selection_Page.verifySelectedNumber(),"Phone Number Selected","Phone Number Selection Failed");
		reporter.reportLogWithScreenshot("Phone Number Selected");
	//	home_Phone_Selection_Page.entercIDFirstName("Harp");
	//	home_Phone_Selection_Page.entercIDLastName("Gill");
		//home_Phone_Selection_Page.clkUpdateCallerID();
		//home_Phone_Selection_Page.enterDLFirstName("Harp");
		//home_Phone_Selection_Page.enterDLLastName("Gill");
	//	home_Phone_Selection_Page.clkUpdateDirectoryListing();
		reporter.softAssert(home_Phone_Selection_Page.verifyNumber(),"Phone Number Selected","Phone Number Selection Failed");
		home_Phone_Selection_Page.clkContinue();
		fulfillment_Page.clkFirstAvailableAppointment();
		reporter.reportLogWithScreenshot("Appointment Selected");
		fulfillment_Page.clkContinue();
		payment_Options_Page.selectPaymentOption(TestDataHandler.anonymousData.contactDetails.getPaymentOption());
		reporter.reportLogWithScreenshot("Payment Option Selected");
		payment_Options_Page.clkContinue();
		order_Review_Page.expandMonthlyBill();
		reporter.reportLogWithScreenshot("Monthly Bill");
		//order_Review_Page.expandOneTimeFees();
		reporter.reportLogWithScreenshot("One Time Fees");
		order_Review_Page.clkSubmit();
		reporter.hardAssert(order_Confirmation_Page.verifyOrder(),"Order Placed","Order Failed");
		reporter.reportLogWithScreenshot("Order Placed");
		
    }
    
	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,String strGroupName, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("QaUrl"), strBrowser, strLanguage,strGroupName,TestDataHandler.anonymousData.contactDetails.getContactID(),"",TestDataHandler.chOneViewConfig.getUsrID(), TestDataHandler.chOneViewConfig.getLoginID(), method);
	
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


