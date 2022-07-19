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


public class OneViewCH_Auto_1618_TC01_E2E_Migration_1P_Internet_To_SAIISS_Test extends BaseTestClass {
	@Test (groups = {"RMigration","RegressionCHOV"})
    public void oneViewCH_Auto_1618_TC01_E2E_Migration_To_SAIISS_Test(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationDataToISS.getAccountNo(), TestDataHandler.migrationDataToISS.getContactID());

		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		reporter.reportLogWithScreenshot("click ignite");
		getAccountOverViewPage().clickIgnite();
		reporter.reportLogWithScreenshot("use this address");
	//	getRogersIgniteBundlesPage().clkUsethisAddress();
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkContinueServiceable();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		getRogersIgniteBundlesPage().clkSmartStream();
		reporter.reportLogWithScreenshot("Smart Stream - SAI ISS Selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		reporter.reportLogWithScreenshot("load offers");
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		reporter.reportLogWithScreenshot("add to cart");
		getRogersIgniteBundlesPage().clkCollapse();
		getRogersIgniteBundlesPage().clkContinue();
	//	getRogersIgniteBundlesPage().clkExpressCheckOut();
		reporter.reportLogWithScreenshot("review terms and condition");
		getRogersIgniteBundlesPage().reviewTermsAndCondition();
		getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
		getRogersIgniteBundlesPage().clkContinueInternetAddon();
	//	getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("Cart Summary");
	//	reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		reporter.reportLogWithScreenshot("Customer wish to continue");
		getRogersIgniteBundlesPage().customerWishtoContinue();
		reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
		reporter.reportLogWithScreenshot("Customer Profile");
		getCustomerProfilePage().clkContinue();
		reporter.reportLogWithScreenshot("Credit evaluation");
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		reporter.reportLogWithScreenshot("Credit evaluation form filled");
		getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		getCreditCheckPage().clkContinue();
		getCreditCheckPage().verifyInstallationOption();
		reporter.reportLogWithScreenshot("Installation Options");
		getCreditCheckPage().clkCourierDelivery();
		reporter.reportLogWithScreenshot("Inperson delivery");
		getCreditCheckPage().clickInPersonDelivery();
		getPaymentOptionsPage().clkContinue();
		getCreditCheckPage().verifyBillingAndPaymentOption();
		reporter.reportLogWithScreenshot("Billing and Payment test");
	//	getCreditCheckPage().clickDigitalFrontline();
	//	reporter.reportLogWithScreenshot("Digital front line");
	//	getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
	//	getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
	//	getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
	//	reporter.reportLogWithScreenshot("Entered card details");
		getCreditCheckPage().goToPageBottom();
		getPaymentOptionsPage().clkContinue();
	//	reporter.reportLogWithScreenshot("submit order");
	//	getRogersOVCheckoutPage().clkSubmit();
	//	reporter.reportLogWithScreenshot("Order Placed");

    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


