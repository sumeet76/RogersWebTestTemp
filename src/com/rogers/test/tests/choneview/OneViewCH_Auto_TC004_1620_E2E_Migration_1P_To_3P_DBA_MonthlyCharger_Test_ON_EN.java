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
/*
"1. Language - EN
2. Province - ON
3. SGI Acc Type - 1P Int (Not Consolidated)
3. Add-Ons - NA.
4. Installation Page - DBA
5. Payment Details - Monthly Charges
6. Discounts - NA"
 */

public class OneViewCH_Auto_1620_TC01_E2E_Migration_1P_Internet_To_3P_Test extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV"})
    public void oneViewCH_Auto_1620_TC01_E2E_Migration_1P_To_3P_Test(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData1PTo3P.getAccountNo(), TestDataHandler.migrationData1PTo3P.getContactID());

		reporter.reportLogWithScreenshot("OneView Interface has Launched");
	//	getAccountOverViewPage().enterDealerCodeDialogue();
		getAccountOverViewPage().clickIgnite();
		reporter.reportLogWithScreenshot("use this address");
	//	getRogersIgniteBundlesPage().clkUsethisAddress();
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkContinueServiceable();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		getRogersIgniteBundlesPage().clkTVCheckbox();
		getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
		reporter.reportLogWithScreenshot("Triple play selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		reporter.reportLogWithScreenshot("added to cart");
		getRogersIgniteBundlesPage().noPortInPopup();
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("review terms and condition");
		getRogersIgniteBundlesPage().reviewAllTerms();
		getRogersIgniteBundlesPage().reviewTermsAndCondition();
		reporter.reportLogWithScreenshot("points to mention");
		getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
		getRogersIgniteBundlesPage().clickExchangeLater();
		reporter.reportLogWithScreenshot("Exchange later");
		reporter.reportLogWithScreenshot("After Exchange later");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().contiue4KContent();
		getRogersIgniteBundlesPage().clkContinueInternetAddon();
		reporter.reportLogWithScreenshot("Intenet addons page");
	//	getTVDashboardPage().clickAddChannel();
	//	reporter.reportLogWithScreenshot("Add channel");
	//	getTVDashboardPage().clickThemepacksTab();
	//	reporter.reportLogWithScreenshot("Themepack Tab");
	//	getTVDashboardPage().addThemepack();
	//	reporter.reportLogWithScreenshot("Add themepack");
	//	getCustomerProfilePage().clkContinue();
	//	getTVDashboardPage().addToCartCallingPackage();
	//	getCustomerProfilePage().clkContinue();
	//	reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
	//	getRogersIgniteBundlesPage().clkCheckOut();
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("Cart Summary");
	//	reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		getRogersIgniteBundlesPage().customerWishtoContinue();
		reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
		reporter.reportLogWithScreenshot("Customer Profile");
		getCustomerProfilePage().clkContinue();
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		getCreditCheckPage().clkContinue();
		getHomePhoneSelectionPage().clkGeneratePhoneNo();
		reporter.reportLogWithScreenshot("Phone Number Selected");
		getCreditCheckPage().goToPageBottom();
		getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
		getCreditCheckPage().verifyInstallationOption();
		reporter.reportLogWithScreenshot("installation options");
		reporter.reportLogWithScreenshot("Delivery by Appointment installation");
		getCreditCheckPage().selectDeliveryByAppointment();
		reporter.reportLogWithScreenshot("click Date Time Radio Button");
		getFulfillmentPage().clkFirstAvailableAppointment();
		reporter.reportLogWithScreenshot(".enter Text Mobile Number");
		getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
		reporter.reportLogWithScreenshot(".enter Email Mail Address");
		getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
		reporter.reportLogWithScreenshot(".enter Special Instructions");
		getCreditCheckPage().enterSpecialInstructions();
		reporter.reportLogWithScreenshot(".enter Special Instructions");
		getPaymentOptionsPage().clkContinue();
		reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
		getCreditCheckPage().verifyBillingAndPaymentOption();
		reporter.reportLogWithScreenshot("Billing and payment");
		getCreditCheckPage().selectPaymentOption(1);
		reporter.reportLogWithScreenshot("Monthly charges");
		//getPaymentOptionsPage().clkContinue();
//		reporter.reportLogWithScreenshot("Submit order");
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
		//closeSession();
	}

}


