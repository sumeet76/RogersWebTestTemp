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



public class OneviewCH_REG_Auto_TC061_MIG_3P_Discounts_ProductCampaign_OTBC_DBA_ON_EN_Test extends BaseTestClass {
	@Test (groups = {"RegressionCHOV"})
    public void oneviewCH_REG_Auto_TC061_MIG_3P_Discounts_ProductCampaign_OTBC_DBA_ON_EN_Test(){
		getEnvironmentSelectionPage().launchOneView( TestDataHandler.migrationData.getAccountNo(),TestDataHandler.migrationData.getContactID());
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().clickIgnite();
		reporter.reportLogWithScreenshot("Check Availability Pop Up");
		//reporter.hardAssert(getRogersIgniteBundlesPage().verifyCheckAvailabilityPopUp(),"Check availability pop up appears","Failed to Load check availability pop up");
		getRogersIgniteBundlesPage().clkContinue();


		//getRogersIgniteBundlesPage().clkUsethisAddress();
		//reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress()+" not serviceable");
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();

		reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
		reporter.reportLogWithScreenshot("Select Services Customer Wants");
		getRogersIgniteBundlesPage().clkTVCheckbox();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
		reporter.reportLogWithScreenshot("Triple Play Selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		reporter.reportLogWithScreenshot("load offers");
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		reporter.reportLogWithScreenshot("Added to Cart");
		//getRogersIgniteBundlesPage().clkKeepNumberbtn();
		getRogersIgniteBundlesPage().noPortInPopup();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
		reporter.reportLogWithScreenshot("Product in cart");
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		getRogersIgniteBundlesPage().clkContinue();

		getRogersIgniteBundlesPage().reviewAllTerms();
		getRogersIgniteBundlesPage().reviewTermsAndCondition();
		getRogersIgniteBundlesPage().clickContinueFromPointsToMention();

		//getRogersIgniteBundlesPage().clickExchangeLater();
		reporter.reportLogWithScreenshot("add channel");
		getRogersIgniteBundlesPage().clickReviewAddons();
		reporter.reportLogWithScreenshot("Clicked customer’s legacy add-ons.");
		getTVDashboardPage().clickThemepacksTab();
		reporter.reportLogWithScreenshot("Themepack tab");
		getTVDashboardPage().addThemepack();
		reporter.reportLogWithScreenshot("themepack added");
		//getTVDashboardPage().clickChannelTab();
		//reporter.reportLogWithScreenshot("Channel Tab Selected");
		getRogersIgniteBundlesPage().clkContinue();

		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().contiue4KContent();

		getRogersIgniteBundlesPage().addPods(5);
		getRogersIgniteBundlesPage().addPods(0);
		reporter.reportLogWithScreenshot("Free internet add on is added to the cart");
		getRogersIgniteBundlesPage().clkContinueInternetAddon();

		//getRogersIgniteBundlesPage().clickReviewAddons();
		getRogersIgniteBundlesPage().clickAddOnAddToCart();
		reporter.reportLogWithScreenshot("clicked Homephone Add On Add To Cart");
		//getCustomerProfilePage().clkContinue();

		reporter.reportLogWithScreenshot("Cart Summary");
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
		reporter.reportLogWithScreenshot("campaign");
		getRogersIgniteCampaignPage().clickCampaignTab();
		//getRogersIgniteCampaignPage().enterCoupon("PCR6");
		//getRogersIgniteCampaignPage().clickApplyCoupon();
		//reporter.hardAssert(getRogersIgniteCampaignPage().verifyCouponRemoveLink(), "Remove Coupon option exist", "Remove Coupon does not exist");
		reporter.reportLogWithScreenshot("OTBC coupon applied");
//		getRogersIgniteCampaignPage().enterCoupon("KR2");
//		getRogersIgniteCampaignPage().clickApplyCoupon();
//		reporter.reportLogWithScreenshot("Product coupon applied");
//		reporter.hardAssert(getRogersIgniteCampaignPage().verifyCouponRemoveLink(), "Remove Coupon option exist", "Remove Coupon does not exist");
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
		reporter.reportLogWithScreenshot("Phone Number Selected");
		getCreditCheckPage().goToPageBottom();
		getHomePhoneSelectionPage().clkContinueOnGeneratePhone();

		reporter.hardAssert(getCreditCheckPage().verifyInstallationOption(),"Installation Options Displayed","Installation Options not Displayed");
		reporter.reportLogWithScreenshot("Installation Options");
		getCreditCheckPage().goToPageBottom();
		getCreditCheckPage().selectDeliveryByAppointment();
		reporter.reportLogWithScreenshot("click Date Time Radio Button");
		getFulfillmentPage().clkFirstAvailableAppointment();
		reporter.reportLogWithScreenshot(".enter Text Mobile Number");
		getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
		getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
		reporter.reportLogWithScreenshot(".enter Special Instructions");
		getCreditCheckPage().enterSpecialInstructions();
		getCreditCheckPage().clkContinueInstallationOption();

		getCreditCheckPage().verifyBillingAndPaymentOption();
		reporter.reportLogWithScreenshot("Billing and Payment Options");
		/*getCreditCheckPage().clickDigitalFrontline();
		getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
		getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
		getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());*/
		getPaymentOptionsPage().clkContinue();
		getRogersOVCheckoutPage().clkSubmit();
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
		//closeSession();
	}

}


