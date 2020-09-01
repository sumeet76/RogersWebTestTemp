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



public class OneViewCH_TC_004_MigrationTriplePlayON extends BaseTestClass {
    @Test @Parameters("strBrowser")
    public void endToEndFlowAnonymousCustomerTriplePlayTest(String browser){
		environment_selection_page.selectOneViewEnv(TestDataHandler.chOneViewConfig.getOneViewenv());
			reporter.reportLogWithScreenshot("OneView Interface has Launched");
			/*		environment_selection_page.enterDealerCode(TestDataHandler.igniteTVParentalcontrols.getDealercode());
				reporter.reportLogWithScreenshot("Enter the dealer code");
				environment_selection_page.submitDealerCode();	*/
		reporter.reportLogWithScreenshot("Launched the account dashboard page");
		account_over_view_page.selectGetIgniteTVBadge();
		reporter.hardAssert(rogers_ignite_bundles_page.verifyCheckAvailabilityPopUp(),"Check availability pop up appears","Failed to Load check availability pop up");
		reporter.reportLogWithScreenshot("Check Availability Pop Up");
		rogers_ignite_bundles_page.clkUsethisAddress();
		reporter.hardAssert(rogers_ignite_bundles_page.verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress()+" not serviceable");
		reporter.reportLogWithScreenshot("Service Availability");
		rogers_ignite_bundles_page.clkContinue();
		rogers_ignite_bundles_page.expandInternetdiv();
		rogers_ignite_bundles_page.expandHomePhonediv();
		rogers_ignite_bundles_page.expandBatteryBackUpdiv();
		rogers_ignite_bundles_page.selectchkboxpointsToMentionReviewed();
		rogers_ignite_bundles_page.clkContinue();
		rogers_ignite_bundles_page.clkAddtoCart(TestDataHandler.anonymousData.getplanEng(),TestDataHandler.anonymousData.getplanFr());
		reporter.hardAssert(rogers_ignite_bundles_page.verifyHomePhoneSetupPopUp(),"Home Phone Setup Pop up", "Home Phone Setup Failed");
		reporter.reportLogWithScreenshot("Home Phone setup");
		rogers_ignite_bundles_page.clkChooseNewNumberbtn();
		rogers_ignite_bundles_page.clkCollapse();
		reporter.hardAssert(rogers_ignite_bundles_page.verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		rogers_ignite_bundles_page.clkContinue();
		rogers_ignite_bundles_page.fourKTVPopup();
		rogers_ignite_bundles_page.fourKContentPopup();
		channels_Theme_Packs_Page.clkCollapse();
		reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
		channels_Theme_Packs_Page.clkCollapse();
		channels_Theme_Packs_Page.clkexchangeLater();
		//channels_Theme_Packs_Page.clkCustomerAddonReview();
		reporter.hardAssert(channels_Theme_Packs_Page.verifyreviewed(),"Addons reviewed","Failed");
		reporter.reportLogWithScreenshot("Addons reviewed for channels and Theme Packs");
		channels_Theme_Packs_Page.clkContinue();
		//channels_Theme_Packs_Page.clkCheckOut();
		home_Phone_Addons_Page.clkCustomerAddonReview();
		reporter.hardAssert(home_Phone_Addons_Page.verifyreviewed(),"Addons reviewed","Failed");
		reporter.reportLogWithScreenshot("Addons reviewed for Home Phone");
		home_Phone_Addons_Page.clkContinue();
		reporter.reportLogWithScreenshot("Cart Summary");
		rogers_ignite_bundles_page.clkCheckOutforCartSummary();
		rogers_ignite_bundles_page.customerWishtoContinue();
        reporter.softAssert(customer_Profile_Page.verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
		customer_Profile_Page.clkContinue();
		//credit_Check_Page.setDOB(TestDataHandler.anonymousData.contactDetails.getYearOfBirth(),TestDataHandler.anonymousData.contactDetails.getMonthOfBirth(),TestDataHandler.anonymousData.contactDetails.getDateOfBirth());
		//credit_Check_Page.clkCollapse();
		credit_Check_Page.setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());	
		//credit_Check_Page.setIDs(TestDataHandler.anonymousData.contactDetails.getFirstID(),TestDataHandler.anonymousData.contactDetails.getProvince(),TestDataHandler.anonymousData.contactDetails.getIdExpiryYear(),TestDataHandler.anonymousData.contactDetails.getMonthOfBirth(),TestDataHandler.anonymousData.contactDetails.getDateOfBirth(),TestDataHandler.anonymousData.contactDetails.getLicenseNo(),TestDataHandler.anonymousData.contactDetails.getSecondID(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		credit_Check_Page.setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		credit_Check_Page.setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		credit_Check_Page.clkAuthorize();
		reporter.softAssert(credit_Check_Page.verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		credit_Check_Page.clkContinue();
		home_Phone_Selection_Page.clkGeneratePhoneNo();
		reporter.softAssert(home_Phone_Selection_Page.verifyNumber(),"Phone Number Selected","Phone Number Selection Failed");
		reporter.reportLogWithScreenshot("Phone Number Selected");
		home_Phone_Selection_Page.clkContinue();
		fulfillment_Page.clkFirstAvailableAppointment();
		reporter.reportLogWithScreenshot("Appointment Selected");
		fulfillment_Page.clkContinue();
		reporter.hardAssert(payment_Options_Page.verifyPaymentPage(),"Payment Option Page Loaded","Failed to load payment option page");
		reporter.reportLogWithScreenshot("Payment Options Page");
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
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startOVSession(System.getProperty("QaUrl"), strBrowser, strLanguage,strGroupName,TestDataHandler.migrationData.getContactID(), TestDataHandler.migrationData.getAccountNo(),TestDataHandler.chOneViewConfig.getUsrID(), TestDataHandler.chOneViewConfig.getLoginID(), method);
	
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


