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



public class OneViewCH_Auto_TC_004_MigrationTriplePlayON extends BaseTestClass {
	@Test (groups = {"RegressionCHOV"})
    public void endToEndMigrationTriplePlayTest(){
		//getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		getEnvironmentSelectionPage().launchOneView( TestDataHandler.migrationData.getAccountNo(),TestDataHandler.migrationData.getContactID());
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().selectGetIgniteTVBadge();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCheckAvailabilityPopUp(),"Check availability pop up appears","Failed to Load check availability pop up");
		reporter.reportLogWithScreenshot("Check Availability Pop Up");
		getRogersIgniteBundlesPage().clkUsethisAddress();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress()+" not serviceable");
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().expandInternetdiv();
		getRogersIgniteBundlesPage().expandHomePhonediv();
		getRogersIgniteBundlesPage().expandBatteryBackUpdiv();
		getRogersIgniteBundlesPage().selectchkboxpointsToMentionReviewed();
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkAddtoCart(TestDataHandler.anonymousData.getplanEng(),TestDataHandler.anonymousData.getplanFr());
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyHomePhoneSetupPopUp(),"Home Phone Setup Pop up", "Home Phone Setup Failed");
		reporter.reportLogWithScreenshot("Home Phone setup");
		getRogersIgniteBundlesPage().clkChooseNewNumberbtn();
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().fourKContentPopup();
		getRogersOVChannelsAndThemePacksPage().clkCollapse();
		reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
		getRogersOVChannelsAndThemePacksPage().clkCollapse();
		getRogersOVChannelsAndThemePacksPage().clkexchangeLater();
		//getRogersOVChannelsAndThemePacksPage().clkCustomerAddonReview();
		reporter.hardAssert(getRogersOVChannelsAndThemePacksPage().verifyreviewed(),"Addons reviewed","Failed");
		reporter.reportLogWithScreenshot("Addons reviewed for channels and Theme Packs");
		getRogersOVChannelsAndThemePacksPage().clkContinue();
		//getRogersOVChannelsAndThemePacksPage().clkCheckOut();
		getHomePhoneAddonsPage().clkCustomerAddonReview();
		reporter.hardAssert(getHomePhoneAddonsPage().verifyreviewed(),"Addons reviewed","Failed");
		reporter.reportLogWithScreenshot("Addons reviewed for Home Phone");
		getHomePhoneAddonsPage().clkContinue();
		reporter.reportLogWithScreenshot("Cart Summary");
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
		getCustomerProfilePage().clkContinue();
		//getCreditCheckPage().setDOB(TestDataHandler.anonymousData.contactDetails.getYearOfBirth(),TestDataHandler.anonymousData.contactDetails.getMonthOfBirth(),TestDataHandler.anonymousData.contactDetails.getDateOfBirth());
		//getCreditCheckPage().clkCollapse();
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());	
		//getCreditCheckPage().setIDs(TestDataHandler.anonymousData.contactDetails.getFirstID(),TestDataHandler.anonymousData.contactDetails.getProvince(),TestDataHandler.anonymousData.contactDetails.getIdExpiryYear(),TestDataHandler.anonymousData.contactDetails.getMonthOfBirth(),TestDataHandler.anonymousData.contactDetails.getDateOfBirth(),TestDataHandler.anonymousData.contactDetails.getLicenseNo(),TestDataHandler.anonymousData.contactDetails.getSecondID(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		getCreditCheckPage().clkContinue();
		getHomePhoneSelectionPage().clkGeneratePhoneNo();
		reporter.softAssert(getHomePhoneSelectionPage().verifyNumber(),"Phone Number Selected","Phone Number Selection Failed");
		reporter.reportLogWithScreenshot("Phone Number Selected");
		getHomePhoneSelectionPage().clkContinue();
		getFulfillmentPage().clkFirstAvailableAppointment();
		reporter.reportLogWithScreenshot("Appointment Selected");
		getFulfillmentPage().clkContinue();
		reporter.hardAssert(getPaymentOptionsPage().verifyPaymentPage(),"Payment Option Page Loaded","Failed to load payment option page");
		reporter.reportLogWithScreenshot("Payment Options Page");
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
		startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","", method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


