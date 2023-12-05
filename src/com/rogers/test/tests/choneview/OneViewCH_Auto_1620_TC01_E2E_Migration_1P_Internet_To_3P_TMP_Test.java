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


public class OneViewCH_Auto_1620_TC01_E2E_Migration_1P_Internet_To_3P_TMP_Test extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV"})
    public void oneViewCH_Auto_1620_TC01_E2E_Migration_1P_Internet_To_3P_TMP_Test(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData.getAccountNo1PTo3PTMP(), TestDataHandler.migrationData.getContactID1PTo3PTMP());

		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		//getAccountOverViewPage().enterDealerCodeDialogue();
		getAccountOverViewPage().clickIgnite();
		getAccountOverViewPage().selectProduction();
		getAccountOverViewPage().clickProceed();
		reporter.reportLogWithScreenshot("use this address");
	//	getRogersIgniteBundlesPage().clkUsethisAddress();
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkContinueServiceable();
		getRogersIgniteBundlesPage().clkTVCheckbox();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
		reporter.reportLogWithScreenshot("Triple play selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		getRogersIgniteBundlesPage().selectAdditionalIgniteTVBoxes("2");
		//getRogersIgniteBundlesPage().termOffer();

		getRogersIgniteBundlesPage().clickFirstAddToCart();
		reporter.reportLogWithScreenshot("added to cart");

		getRogersIgniteBundlesPage().yesPortInPopup();
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("review terms and condition");

		getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
		reporter.reportLogWithScreenshot("points to mention");
		getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
		getRogersIgniteBundlesPage().clickHomePhoneAndTVInPortInServices();
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("Port In Services ADD");
		getRogersIgniteBundlesPage().enterHomePhoneNumberPortIn("(905) 896-2833");
		reporter.reportLogWithScreenshot("ADDED Phone No in Port In");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().enterAccountNumber("345678901");
		reporter.reportLogWithScreenshot("Added Account details in Port In");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("Exchange later");
		reporter.reportLogWithScreenshot("After Exchange later");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().contiue4KContent();
	//	getRogersIgniteBundlesPage().clkContinueInternetAddon();
		reporter.reportLogWithScreenshot("Add channel");
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		getRogersIgniteBundlesPage().clkContinue();
getRogersIgniteBundlesPage().clickFirstAddToCart();
getRogersIgniteBundlesPage().clkContinue();
//		getTVDashboardPage().clickThemepacksTab();
//		reporter.reportLogWithScreenshot("Themepack Tab");
//		getTVDashboardPage().addThemepack();
//		reporter.reportLogWithScreenshot("Add themepack");
//		getCustomerProfilePage().clkContinue();
//		getTVDashboardPage().addToCartCallingPackage();
//		getCustomerProfilePage().clkContinue();
//		reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
		reporter.reportLogWithScreenshot("Cart Summary");


		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
//		getRogersIgniteBundlesPage().clkCheckOut();
//		getRogersIgniteBundlesPage().clkContinue();
//		getRogersIgniteCampaignPage().clickCampaignTab();
//		reporter.reportLogWithScreenshot("Campaign Tab");
//		getRogersIgniteCampaignPage().enterCoupon("K1D");
//		getRogersIgniteCampaignPage().clickApplyCoupon();
//		reporter.reportLogWithScreenshot("apply coupon");
//		reporter.hardAssert(getRogersIgniteCampaignPage().verifyCouponRemoveLink(), "Remove coupon link verified", "Remove coupon link not verified");
//		getRogersIgniteCampaignPage().closeCouponAlert();


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
//		reporter.softAssert(getHomePhoneSelectionPage().verifySelectedNumber(),"Phone Number Selected","Phone Number Selection Failed");
		reporter.reportLogWithScreenshot("Phone Number Selected");
		getCreditCheckPage().goToPageBottom();
		getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
		getCreditCheckPage().verifyInstallationOption();
		reporter.reportLogWithScreenshot("installation options");
		getCreditCheckPage().clkCourierDelivery();
		getCreditCheckPage().clickInPersonDelivery();
		reporter.reportLogWithScreenshot("in person delivery");
		getPaymentOptionsPage().clkContinue();
		getCreditCheckPage().verifyBillingAndPaymentOption();
		reporter.reportLogWithScreenshot("Billing and payment");
	//	getCreditCheckPage().clickDigitalFrontline();
	//	reporter.reportLogWithScreenshot("Front line");

	//	getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
	//	getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
	//	getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
	//	reporter.reportLogWithScreenshot("Entered card detail");

		getPaymentOptionsPage().clkContinue();
		reporter.reportLogWithScreenshot("Submit order");
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


