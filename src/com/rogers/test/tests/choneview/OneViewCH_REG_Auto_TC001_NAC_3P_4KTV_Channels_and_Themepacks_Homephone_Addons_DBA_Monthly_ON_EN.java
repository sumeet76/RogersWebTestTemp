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
3. Add-Ons - Exchange Later, with 4K TV and Add any Channels and Themepacks and Homephone add-ons.
4. Installation Page - DBA
5. Payment Details - Monthly Charges
6. Discounts - NA"
 */
public class OneViewCH_REG_Auto_TC001_NAC_3P_4KTV_Channels_and_Themepacks_Homephone_Addons_DBA_Monthly_ON_EN extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV","ReleaseSanity"})
    public void oneViewCH_REG_Auto_TC001_NAC_3P_4KTV_Channels_and_Themepacks_Homephone_Addons_DBA_Monthly_ON_EN(){
		reporter.reportLogWithScreenshot("oneview env");
		getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		reporter.reportLogWithScreenshot("address");
		getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress(),"Chrome");
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
		getRogersIgniteBundlesPage().noPortInPopup();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
		reporter.reportLogWithScreenshot("Product in cart");
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("click continue");
		getRogersIgniteBundlesPage().clickExchangeLater();
		reporter.reportLogWithScreenshot("click exchange");
		getRogersOVChannelsAndThemePacksPage().clickAddChannel();
		reporter.reportLogWithScreenshot("click add channel");
		getRogersOVChannelsAndThemePacksPage().clickThemepacksTab();
		reporter.reportLogWithScreenshot("click themepack tab");
		getRogersOVChannelsAndThemePacksPage().addThemepack();
		reporter.reportLogWithScreenshot("add theme pack");
		getRogersOVChannelsAndThemePacksPage().clkContinue();
		reporter.reportLogWithScreenshot("click continue");
		getRogersOVChannelsAndThemePacksPage().clickNoTheyDont();
		reporter.reportLogWithScreenshot("click no they don't");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("click continue");
		reporter.hardAssert(getHomePhoneAddonsPage().verifyHomePhoneAddOnsHeader(),"Homephone add ons page available","Home phone add ons page not available");
		getTVDashboardPage().addToCartCallingPackage();
		reporter.reportLogWithScreenshot("add calling card");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		reporter.reportLogWithScreenshot("checkout to cart summary");
		getRogersIgniteBundlesPage().customerWishtoContinue();
		reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
		reporter.reportLogWithScreenshot("Customer Profile");
		getCustomerProfilePage().useAnotheraddress();
		getCustomerProfilePage().enterNewAddress("105 Abbeywood Trail");
		getCustomerProfilePage().clkContinue();
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		reporter.reportLogWithScreenshot("credit evaluation");
		getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		getCreditCheckPage().clkContinue();
		//reporter.reportLogWithScreenshot("Phone Number Generate");
		getHomePhoneSelectionPage().clkGeneratePhoneNo();
		reporter.reportLogWithScreenshot("Phone Number Selected");
//		getCreditCheckPage().goToPageBottom();
		getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
		reporter.reportLogWithScreenshot("Phone display name");
		//getHomePhoneSelectionPage().clkContinue();
		reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
		reporter.hardAssert(getCreditCheckPage().verifyRecoEngineRecommendation(),"Reco Engine Install Recommendation Banner displayed"," Reco Engine Install Recommendation Banner is not displayed");
		reporter.hardAssert(getCreditCheckPage().verifyRecommendationBanner(),"Recommended Banner is displayed", "Recommeded Banner is not displayed");reporter.reportLogWithScreenshot("Installation options");
		getCreditCheckPage().verifyInstallationOption();
		reporter.reportLogWithScreenshot("Installation options");
		//getCreditCheckPage().goToPageBottom();
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
		getPaymentOptionsPage().clkContinue();
		reporter.reportLogWithScreenshot("submit order");
		getRogersOVCheckoutPage().clkSubmit();
		reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
		reporter.reportLogWithScreenshot("Order Placed");
    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})

	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactID(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		//closeSession();
	}

}


