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


public class OneViewCH_Auto_1619_TC01_E2E_Migration_1P_Internet_To_2P_Test extends BaseTestClass {
	@Test (groups = {"RMigration","RegressionCHOV"})
    public void oneViewCH_Auto_1619_TC01_E2E_Migration_To_2P_Test(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData1PTo2P.getAccountNo(), TestDataHandler.migrationData1PTo2P.getContactID());

		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		//getAccountOverViewPage().enterDealerCodeDialogue();
		getAccountOverViewPage().clickIgnite();
		getAccountOverViewPage().selectProduction();
		reporter.reportLogWithScreenshot("Select Environment as Production");
		getAccountOverViewPage().clickProceed();
		reporter.reportLogWithScreenshot("address");
		//getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress());
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
	//	reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
		reporter.reportLogWithScreenshot("Select Services Customer Wants");
	//	getRogersIgniteBundlesPage().clkUsethisAddress();
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkTVCheckbox();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		reporter.reportLogWithScreenshot("Smart Stream - SAI ISS Selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		reporter.reportLogWithScreenshot("Load offers");
		getRogersIgniteBundlesPage().selectAdditionalIgniteTVBoxes("2");
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		reporter.reportLogWithScreenshot("add to cart");
		//getRogersIgniteBundlesPage().noPortInPopup();
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("review terms and condition");
		getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
		reporter.reportLogWithScreenshot("Term and condition checkbox checked");
		getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
		reporter.reportLogWithScreenshot("Points to mention");
		//getRogersIgniteBundlesPage().clkReviewContinue();
		//getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
		getRogersIgniteBundlesPage().clkExpressCheckOut();
		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().contiue4KContent();
		//getRogersIgniteBundlesPage().clickExchangeLater();
//		reporter.reportLogWithScreenshot("add channel");
//		getTVDashboardPage().clickAddChannel();
//		reporter.reportLogWithScreenshot("Tab themepack");
//		getTVDashboardPage().clickThemepacksTab();
//		reporter.reportLogWithScreenshot("add themepack");
//		getTVDashboardPage().addThemepack();
//		getCustomerProfilePage().clkContinue();
		//reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
	//	getRogersIgniteBundlesPage().clkCheckOut();
		reporter.reportLogWithScreenshot("Cart Summary");
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		reporter.reportLogWithScreenshot("customer wish to continue");
		getRogersIgniteBundlesPage().customerWishtoContinue();
		reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
		reporter.reportLogWithScreenshot("Customer Profile");
		getCustomerProfilePage().clkContinue();
		reporter.reportLogWithScreenshot("evaluation form");
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		reporter.reportLogWithScreenshot("evaluation form filled" );
		getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		getCreditCheckPage().clkContinue();
		getCreditCheckPage().verifyInstallationOption();
		getCreditCheckPage().goToPageBottom();
		reporter.reportLogWithScreenshot("in person delivery");
		getCreditCheckPage().clkCourierDelivery();
		getCreditCheckPage().clickInPersonDelivery();
		getPaymentOptionsPage().clkContinue();
		reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
		getCreditCheckPage().verifyBillingAndPaymentOption();
		getCreditCheckPage().clkContinue();
		reporter.reportLogWithScreenshot("billing and payment");
//		getCreditCheckPage().clickDigitalFrontline();
//		reporter.reportLogWithScreenshot("front line");
//		getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
//		getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
//		getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
//		reporter.reportLogWithScreenshot("entered payment info");
//		getPaymentOptionsPage().clkContinue();
		getRogersOVCheckoutPage().clkSubmit();
		reporter.reportLogWithScreenshot("submit payment");
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
		reporter.reportLogWithScreenshot("Order Placed");


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


