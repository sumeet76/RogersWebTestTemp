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


public class OneViewCH_1640_TC01_E2EMigrationFlow3PNewNumberTest extends BaseTestClass {
	@Test (groups = {"RegressionCHOV"})
    public void oneViewCH_1640_TC01_E2EMigrationFlow3PNewNumberTest(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData.getAccountNo(), TestDataHandler.migrationData.getContactID());
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		getAccountOverViewPage().clickIgnite();
		getRogersIgniteBundlesPage().clkUsethisAddress();
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkTVCheckbox();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
		reporter.reportLogWithScreenshot("Smart Stream - SAI ISS Selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		getRogersIgniteBundlesPage().clkAddtoCart(TestDataHandler.anonymousData.getplanEng(),TestDataHandler.anonymousData.getplanFr());
//		getRogersIgniteBundlesPage().clkKeepNumberbtn();
		getRogersIgniteBundlesPage().clkChooseNewNumberbtn();
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().reviewTermsAndCondition();
		getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().contiue4KContent();
		getRogersIgniteBundlesPage().clickExchangeLater();
		getTVDashboardPage().clickAddChannel();
		getTVDashboardPage().clickThemepacksTab();
		getTVDashboardPage().addThemepack();
		getTVDashboardPage().clickAddOnIfPresent();
		getCustomerProfilePage().clkContinue();
		getTVDashboardPage().addToCartCallingPackage();
		getCustomerProfilePage().clkContinue();
		reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
		getRogersIgniteBundlesPage().clkCheckOut();
		reporter.reportLogWithScreenshot("Cart Summary");
		getRogersIgniteBundlesPage().customerWishtoContinue();
		reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
		reporter.reportLogWithScreenshot("Customer Profile");
		getCreditCheckPage().goToPageBottom();
		getCustomerProfilePage().clkContinue();
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
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
//		getHomePhoneSelectionPage().clkGeneratePhoneNo();
//		reporter.softAssert(getHomePhoneSelectionPage().verifySelectedNumber(),"Phone Number Selected","Phone Number Selection Failed");
//		reporter.reportLogWithScreenshot("Phone Number Selected");
		getCreditCheckPage().goToPageBottom();
		getPaymentOptionsPage().clkContinue();
		getCreditCheckPage().continueConfirmation();
		getCreditCheckPage().goToPageBottom();
		getPaymentOptionsPage().clkContinue();
		getCreditCheckPage().verifyInstallationOption();
		getCreditCheckPage().goToPageBottom();
		getCreditCheckPage().clickInPersonDelivery();
		getPaymentOptionsPage().clkContinue();
		getCreditCheckPage().verifyBillingAndPaymentOption();
		getCreditCheckPage().clickDigitalFrontline();
		getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
		getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
		getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
//		getPaymentOptionsPage().clkContinue();
//		getRogersOVCheckoutPage().clkSubmit();
//		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
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


