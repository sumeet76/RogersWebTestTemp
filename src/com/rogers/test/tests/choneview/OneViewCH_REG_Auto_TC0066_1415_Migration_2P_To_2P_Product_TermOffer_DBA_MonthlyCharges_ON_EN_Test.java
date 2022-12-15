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


public class OneViewCH_REG_Auto_TC0066_1415_Migration_2P_To_2P_Product_TermOffer_DBA_MonthlyCharges_ON_EN_Test extends BaseTestClass {
	@Test (groups = {"RNAC","RegressionCHOV"})
    public void oneViewCH_Auto_TC095_1415_Migration_2P_To_2P_Product_TermOffer_DBA_MonthlyCharges_ON_EN_Test(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData.getAccountNo2PToISSTMP(), TestDataHandler.migrationData.getContactID2PToISSTMP() );
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
//		getAccountOverViewPage().enterDealerCodeDialogue();
		getAccountOverViewPage().clickIgnite();
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkContinueServiceable();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		getRogersIgniteBundlesPage().clkSmartStream();
		reporter.reportLogWithScreenshot("Internet Selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		reporter.reportLogWithScreenshot("load offers");
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		reporter.reportLogWithScreenshot("Product in cart");
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("review terms and condition");
		getRogersIgniteBundlesPage().reviewAllTerms();
		getRogersIgniteBundlesPage().reviewTermsAndCondition();
		reporter.reportLogWithScreenshot("points to mention");
		getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
		reporter.reportLogWithScreenshot("continue from terms");
		getRogersIgniteBundlesPage().clkContinue();
//		getRogersIgniteBundlesPage().clkContinueInternetAddon();
//		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
		getRogersIgniteCampaignPage().clickCampaignTab();
		reporter.reportLogWithScreenshot("load offers");
		getRogersIgniteCampaignPage().enterCoupon("KCS");
		getRogersIgniteCampaignPage().clickApplyCoupon();
		reporter.reportLogWithScreenshot("apply coupon");
		reporter.hardAssert(getRogersIgniteCampaignPage().verifyCouponRemoveLink(), "Remove coupon link verified", "Remove coupon link not verified");
		reporter.reportLogWithScreenshot("Term Offer Applied");
		getRogersIgniteCampaignPage().enterCoupon("KR2");
		getRogersIgniteCampaignPage().clickApplyCoupon();
		reporter.hardAssert(getRogersIgniteCampaignPage().verifyCouponRemoveLink(), "Remove Coupon option exist", "Remove Coupon does not exist");
		reporter.reportLogWithScreenshot("Product Campign coupon applied");
		getRogersIgniteCampaignPage().closeCouponAlert();
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		reporter.reportLogWithScreenshot("cart summary checkout");
		getRogersIgniteBundlesPage().customerWishtoContinue();

		reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
		getCustomerProfilePage().clkContinue();

//		In the case of credit evaluation not required

//		reporter.softAssert(getCreditCheckPage().verifyCreditEvaluationHeader(),"Credit Evaluation Header verified","Failed");
//		getCreditCheckPage().goToPageBottom();
//		getCreditCheckPage().clkContinue();

//		In the case if credit evaluation required
		reporter.softAssert(getCreditCheckPage().verifyCreditEvaluationHeader(),"Credit Evaluation Header verified","Failed");
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		reporter.reportLogWithScreenshot("evaluation form filled");getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		getCreditCheckPage().clkContinue();
		reporter.reportLogWithScreenshot("Installation options");
		getCreditCheckPage().verifyInstallationOption();
		getCreditCheckPage().goToPageBottom();
		reporter.reportLogWithScreenshot("Delivery by Appointment");
		getCreditCheckPage().selectDeliveryByAppointment();
		reporter.reportLogWithScreenshot("click Date Time Radio Button");
		getFulfillmentPage().clkFirstAvailableAppointment();
		reporter.reportLogWithScreenshot(".enter Text Mobile Number");
		getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
		reporter.reportLogWithScreenshot(".enter Email Mail Address");
		getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
		reporter.reportLogWithScreenshot(".enter Special Instructions");
		getCreditCheckPage().enterSpecialInstructions();
		getPaymentOptionsPage().clkContinue();
	//	reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
		getCreditCheckPage().verifyBillingAndPaymentOption();
		reporter.reportLogWithScreenshot("billing and payment");
		getCreditCheckPage().selectPaymentOption(1);
		reporter.reportLogWithScreenshot("Monthly charges");
		getPaymentOptionsPage().clkContinue();
		reporter.reportLogWithScreenshot("Order Review Page");
	//	getRogersOVCheckoutPage().clkSubmit();
	//	reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
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


