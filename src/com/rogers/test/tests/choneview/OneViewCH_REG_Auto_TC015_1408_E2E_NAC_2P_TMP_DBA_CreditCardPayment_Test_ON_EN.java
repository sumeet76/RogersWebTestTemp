
package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.Alert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;
/*
"1. Language - EN
2. Province - ON
3. Add-Ons - NA
4. Installation Page - DBA
5. Payment Details - Credit Card
6. Discounts - Apply any Product Campaigns."
 */

public class OneViewCH_REG_Auto_TC015_1408_E2E_NAC_2P_TMP_DBA_CreditCardPayment_Test_ON_EN extends BaseTestClass {
	@Test (groups = {"RNAC","RegressionCHOV"})
	public void oneViewCH_Auto_TC015_1408_E2E_NAC_2P_TMP_DBA_CreditCardPayment_Test_ON_EN(){
		reporter.reportLogWithScreenshot("OneView env");
		getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		getEnvironmentSelectionPage().selectProduction();
		reporter.reportLogWithScreenshot("Selected Production");
		getEnvironmentSelectionPage().clickProceed();
		reporter.reportLogWithScreenshot("Clicked proceed button");
		reporter.reportLogWithScreenshot("address");
		getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress());
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress_ALT()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress_ALT()+" not serviceable");
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("clk Continue");
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
		reporter.reportLogWithScreenshot("Select Services Customer Wants");
		getRogersIgniteBundlesPage().clkTVCheckbox();
		reporter.reportLogWithScreenshot("clk TV Checkbox");
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		reporter.reportLogWithScreenshot("Internet and TV Selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		reporter.reportLogWithScreenshot("Load Offers");
//		getRogersIgniteBundlesPage().termOffer();
		getRogersIgniteBundlesPage().oneTimeCredit();
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		reporter.reportLogWithScreenshot("Add To Cart");
		getRogersIgniteBundlesPage().noPortInPopup();
		reporter.reportLogWithScreenshot("Product in cart");
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.reportLogWithScreenshot("clk Collapse");
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("clk Continue");
		getRogersIgniteBundlesPage().clkExpressCheckOut();
		reporter.reportLogWithScreenshot("clk Express CheckOut");
		getRogersIgniteBundlesPage().fourKTVPopup();
		reporter.reportLogWithScreenshot("four KTV Popup");
		getRogersIgniteBundlesPage().fourKContentPopup();
		reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
		reporter.reportLogWithScreenshot("Cart Summary");
//		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
		/*		getRogersIgniteBundlesPage().fourKTVPopup();
		reporter.reportLogWithScreenshot("four KTV Popup");
		getRogersIgniteBundlesPage().fourKContentPopup();*/
		reporter.reportLogWithScreenshot("cart summary");
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		getRogersIgniteBundlesPage().customerWishtoContinue();
		reporter.reportLogWithScreenshot("customer Wish to Continue");
		reporter.hardAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
		reporter.reportLogWithScreenshot("Customer Profile");
		getCustomerProfilePage().clkContinue();
		reporter.hardAssert(getCreditCheckPage().verifyCreditEvaluationHeader(),"Credit Evaluation Displayed","Credit Evaluation did not Displayed");
		reporter.reportLogWithScreenshot("Credit Evaluation screen loaded");
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		reporter.reportLogWithScreenshot("enter DriversLicense");
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		reporter.reportLogWithScreenshot("enter Passport");
		getCreditCheckPage().clkAuthorize();
		reporter.reportLogWithScreenshot("clk Authorize");
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
//		getCreditCheckPage().goToPageBottom();
		getCreditCheckPage().clkContinue();
		reporter.reportLogWithScreenshot("Installation options");
		reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
//		reporter.hardAssert(getCreditCheckPage().verifyRecommendationBanner(),"Recommended Banner is displayed", "Recommeded Banner is not displayed");
		getCreditCheckPage().verifyInstallationOption();
		reporter.reportLogWithScreenshot("go To Page Bottom");
		getCreditCheckPage().goToPageBottom();
		reporter.reportLogWithScreenshot("professional installation");
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
		reporter.reportLogWithScreenshot("billing options");
		getCreditCheckPage().verifyBillingAndPaymentOption();
		getCreditCheckPage().clickDigitalFrontline();
		reporter.reportLogWithScreenshot("front line");
		getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
		getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
		getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
		reporter.reportLogWithScreenshot("payment details entered");
		getPaymentOptionsPage().clkContinue();
		reporter.reportLogWithScreenshot("Campaign code");
		getRogersIgniteCampaignPage().clickCampaignTab();
		getRogersIgniteCampaignPage().enterCoupon("KDT");
		reporter.reportLogWithScreenshot("Campaign code entered");
		getRogersIgniteCampaignPage().clickApplyCoupon();
		reporter.reportLogWithScreenshot("Campaign code applied");
	//	reporter.hardAssert(getRogersIgniteCampaignPage().verifyCouponRemoveLink(), "coupon successfully applied", "coupon not applied successfully");
		getRogersIgniteCampaignPage().closeCouponAlert();
		reporter.reportLogWithScreenshot("close Coupon Alert");
		reporter.reportLogWithScreenshot("Order Review Page");
		getRogersOVCheckoutPage().clkSubmit();
		reporter.reportLogWithScreenshot("Order Placed");
	}


	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactID2PPayMonthlyCharges(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}
}
