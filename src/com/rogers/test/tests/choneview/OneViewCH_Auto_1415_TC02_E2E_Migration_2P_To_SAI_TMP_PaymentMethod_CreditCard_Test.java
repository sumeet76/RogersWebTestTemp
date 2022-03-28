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


public class OneViewCH_Auto_1415_TC02_E2E_Migration_2P_To_SAI_TMP_PaymentMethod_CreditCard_Test extends BaseTestClass {
	@Test (groups = {"RNAC","RegressionCHOV"})
    public void oneViewCH_Auto_1415_TC02_E2E_Migration_2P_To_SAI_TMP_PaymentMethod_CreditCard_Test(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData.getAccountNo2PToSAITMP(), TestDataHandler.migrationData.getContactID2PTOSAITMP() );
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		getAccountOverViewPage().clickIgnite();
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		reporter.reportLogWithScreenshot("Internet Selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		reporter.reportLogWithScreenshot("load offers");
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		reporter.reportLogWithScreenshot("added to cart");
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().reviewTermsAndCondition();
		reporter.reportLogWithScreenshot("points to mention");
		getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
		reporter.reportLogWithScreenshot("contine from terms");
		getRogersIgniteBundlesPage().scrollToContinue();
		reporter.reportLogWithScreenshot("bottom to continue");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
		getRogersIgniteCampaignPage().clickCampaignTab();
		reporter.reportLogWithScreenshot("Campaign Tab");
		getRogersIgniteCampaignPage().enterCoupon("K5G");
		getRogersIgniteCampaignPage().clickApplyCoupon();
		reporter.reportLogWithScreenshot("apply coupon");
		reporter.hardAssert(getRogersIgniteCampaignPage().verifyCouponRemoveLink(), "Remove coupon link verified", "Remove coupon link not verified");
		getRogersIgniteCampaignPage().closeCouponAlert();
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		reporter.reportLogWithScreenshot("cart summary checkout");
		getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
		getCustomerProfilePage().clkContinue();
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		reporter.reportLogWithScreenshot("evaluation form filled");
		getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		getCreditCheckPage().clkContinue();
		reporter.reportLogWithScreenshot("Installation options");
		getCreditCheckPage().verifyInstallationOption();
		getCreditCheckPage().goToPageBottom();
		getCreditCheckPage().clickInPersonDelivery();
		reporter.reportLogWithScreenshot("in person deliver");
		getPaymentOptionsPage().clkContinue();
		reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
		getCreditCheckPage().verifyBillingAndPaymentOption();
		getCreditCheckPage().clickDigitalFrontline();
		reporter.reportLogWithScreenshot("front line");
		getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
		getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
		getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
		reporter.reportLogWithScreenshot("card detail entered");
//		getPaymentOptionsPage().clkContinue();
//		reporter.reportLogWithScreenshot("Order Review Page");
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


