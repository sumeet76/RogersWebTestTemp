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


public class OneViewCH_Auto_1640_TC01_E2E_Migration_3P_To_3P_NewNumber_Test extends BaseTestClass {
	@Test (groups = {"RMigration","RegressionCHOV"})
    public void oneViewCH_Auto_1640_TC01_E2E_Migration_3P_NewNumber_Test(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData3PSameNumber.getAccountNo(), TestDataHandler.migrationData3PSameNumber.getContactID());
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		getAccountOverViewPage().clickIgnite();
	//	getRogersIgniteBundlesPage().clkUsethisAddress();
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkContinueServiceable();
		getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		getRogersIgniteBundlesPage().clkTVCheckbox();
		reporter.reportLogWithScreenshot("Triple play Selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		reporter.reportLogWithScreenshot("Add to cart");

		reporter.softAssert(getRogersIgniteBundlesPage().verifyIgniteHomePhoneSetup(),"Ignite HomePhone Setup pop up","Failed");
		reporter.reportLogWithScreenshot("Ignite home Phone Setup pop up is displayed");
		getRogersIgniteBundlesPage().clickNewNumber();

		//getRogersIgniteBundlesPage().noPortInPopup();
		getRogersIgniteBundlesPage().clkCollapse();
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().reviewTermsAndCondition();
		getRogersIgniteBundlesPage().clickContinueFromPointsToMention();



		getRogersIgniteBundlesPage().clickExchangeLater();
		//add channel themepack
		getRogersIgniteBundlesPage().clickReviewAddons();
		getCustomerProfilePage().clkContinue();
		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().contiue4KContent();
		//getTVDashboardPage().clickAddOnIfPresent();
		getCustomerProfilePage().clkContinue();
		getRogersIgniteBundlesPage().clkContinueInternetAddon();
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("Cart Summary");
		//	reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		reporter.reportLogWithScreenshot("Customer wish to continue");
		getRogersIgniteBundlesPage().customerWishtoContinue();
		reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
		reporter.reportLogWithScreenshot("Customer Profile");
		getCustomerProfilePage().clkContinue();
		/*Create profile page*/
		reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
		reporter.reportLogWithScreenshot("Customer Profile");
		getCreditCheckPage().goToPageBottom();
		getCustomerProfilePage().clkContinue();

		/*Credit evaulation page*/
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();

		/*Phone Number Selection page*/
		getHomePhoneSelectionPage().clkGeneratePhoneNo();
	//	reporter.softAssert(getHomePhoneSelectionPage().verifyNumber(),"Phone Number Selected","Phone Number Selection Failed");
		reporter.reportLogWithScreenshot("Phone Number Selected");
		getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
		getHomePhoneSelectionPage().clickOnContinueCallDisplay();
		getHomePhoneSelectionPage().clickContinueDirectoryListing();
		getHomePhoneSelectionPage().clkContinue();

		/*Installation page*/
		getFulfillmentPage().clkFirstAvailableAppointment();
		reporter.reportLogWithScreenshot("Appointment Selected");
		getFulfillmentPage().clkContinue();

		/*Bill and Payment page*/
	//	reporter.hardAssert(getPaymentOptionsPage().verifyPaymentPage(),"Payment Option Page Loaded","Failed to load payment option page");
		reporter.reportLogWithScreenshot("Payment Options Page");
		getPaymentOptionsPage().clkContinue();
		getRogersOVOrderReviewPage().expandMonthlyBill();
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
		reporter.reportLogWithScreenshot("Entered card details");
		getPaymentOptionsPage().clkContinue();

//		getRogersOVCheckoutPage().clkSubmit();
//		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
//		reporter.reportLogWithScreenshot("Order Placed");

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


