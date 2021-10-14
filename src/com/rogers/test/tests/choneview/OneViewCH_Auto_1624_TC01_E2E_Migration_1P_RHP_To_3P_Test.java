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


public class OneViewCH_Auto_1624_TC01_E2E_Migration_1P_RHP_To_3P_Test extends BaseTestClass {
	@Test (groups = {"RegressionCHOV"})
    public void oneViewCH_Auto_1624_TC01_E2E_Migration_1P_RHP_To_3P_Test(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData1PRHPTo3P.getAccountNo(), TestDataHandler.migrationData1PRHPTo3P.getContactID());

		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		getAccountOverViewPage().clickIgnite();
		getRogersIgniteBundlesPage().clkUsethisAddress();
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkTVCheckbox();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
		reporter.reportLogWithScreenshot("3p selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		reporter.reportLogWithScreenshot("Added to Cart");
		getRogersIgniteBundlesPage().clkKeepNumberbtn();
		reporter.reportLogWithScreenshot("keep number");
		getRogersIgniteBundlesPage().noPortInPopup();
		getRogersIgniteBundlesPage().clkCollapse();
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("review terms and condition");
		getRogersIgniteBundlesPage().reviewTermsAndCondition();
		reporter.reportLogWithScreenshot("point to mention");
		getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().contiue4KContent();
		reporter.reportLogWithScreenshot("Exchange later");
		getRogersIgniteBundlesPage().clickExchangeLater();
		getCustomerProfilePage().clkContinue();
		getCustomerProfilePage().clkContinue();
		reporter.reportLogWithScreenshot("CheckOut for Cart Summary");
		getRogersIgniteBundlesPage().clkCheckOut();
		reporter.reportLogWithScreenshot("Cart Summary");
		getRogersIgniteBundlesPage().customerWishtoContinue();
		reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
		reporter.reportLogWithScreenshot("Customer Profile");
		getCreditCheckPage().goToPageBottom();
		getCustomerProfilePage().clkContinue();
		reporter.reportLogWithScreenshot("Evaluation form");
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		reporter.reportLogWithScreenshot("Evaluation form filled");
		getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		getCreditCheckPage().clkContinue();
		reporter.reportLogWithScreenshot("Home Phone selection page");
		getHomePhoneSelectionPage().clkContinue();
		reporter.reportLogWithScreenshot("Home Phone selection continue");
		getCreditCheckPage().continueConfirmation();

		getCreditCheckPage().goToPageBottom();
		getPaymentOptionsPage().clkContinue();
		getCreditCheckPage().verifyInstallationOption();

		getCreditCheckPage().goToPageBottom();
		reporter.reportLogWithScreenshot("In person delivery");

		getCreditCheckPage().clickInPersonDelivery();
		getPaymentOptionsPage().clkContinue();
		getCreditCheckPage().verifyBillingAndPaymentOption();
		getCreditCheckPage().clickDigitalFrontline();
		reporter.reportLogWithScreenshot("Front line");

		getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
		getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
		getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
		reporter.reportLogWithScreenshot("entered card details");

		//getPaymentOptionsPage().clkContinue();
		//getPaymentOptionsPage().clkContinue();
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

