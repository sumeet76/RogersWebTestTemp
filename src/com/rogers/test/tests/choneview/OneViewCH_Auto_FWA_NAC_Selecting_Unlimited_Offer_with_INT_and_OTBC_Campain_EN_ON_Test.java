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

public class OneViewCH_Auto_FWA_NAC_Selecting_Unlimited_Offer_with_INT_and_OTBC_Campain_EN_ON_Test extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV"})
    public void OneViewCH_Auto_FWA_NAC_Selecting_Unlimited_Offer_with_INT_and_OTBC_Campain_EN_ON_Test(){
			reporter.reportLogWithScreenshot("oneview env");
			getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
			getEnvironmentSelectionPage().selectProduction();
			reporter.reportLogWithScreenshot("Selected Production");
			getEnvironmentSelectionPage().clickProceed();
			reporter.reportLogWithScreenshot("Clicked proceed button");
			reporter.reportLogWithScreenshot("address");
			getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress_FWA(),"Chrome");
			reporter.reportLogWithScreenshot("Service Availability");
			getRogersIgniteBundlesPage().clkContinue();
			reporter.reportLogWithScreenshot("clicked continue button");
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyExclusiveOffersAvailable(),"Exclusive offers Available","Exclusive offers not available");
			getRogersIgniteBundlesPage().oneTimeCredit();
			reporter.reportLogWithScreenshot("one time credit selected");
			getRogersIgniteBundlesPage().wirelessHomeInternetCredit();
			reporter.reportLogWithScreenshot("Wireless Home Internet credit selected");
			getRogersIgniteBundlesPage().clickFirstAddToCart();
			reporter.reportLogWithScreenshot("Added to Cart");
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
			reporter.reportLogWithScreenshot("Product in cart");
			getRogersIgniteBundlesPage().clkCollapse();
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
			reporter.reportLogWithScreenshot("Product Added");
			getRogersIgniteBundlesPage().clkContinue();
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
			reporter.reportLogWithScreenshot("checkout to cart summary");
			getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
			getRogersIgniteBundlesPage().customerWishtoContinue();
			reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
			reporter.reportLogWithScreenshot("Customer Profile");
			getCustomerProfilePage().clkContinue();
			getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
			getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
			getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
			reporter.reportLogWithScreenshot("credit evaluation");
			getCreditCheckPage().clkAuthorize();
			reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
			reporter.reportLogWithScreenshot("Credit Check Information");
			getCreditCheckPage().clkContinue();
			reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
			reporter.reportLogWithScreenshot("Installation options");
			reporter.reportLogWithScreenshot("professional installation");
//			getCreditCheckPage().selectProfessionalInstallation();
			reporter.reportLogWithScreenshot("click Date Time Radio Button");
			getFulfillmentPage().clkFirstAvailableAppointment();
			reporter.reportLogWithScreenshot(".enter Text Mobile Number");
			getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
			reporter.reportLogWithScreenshot(".enter Email Mail Address");
			getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
			reporter.reportLogWithScreenshot(".enter Special Instructions");
			getCreditCheckPage().enterSpecialInstructions();
			getRogersIgniteBundlesPage().clkContinue();
			reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
			reporter.reportLogWithScreenshot("billing and payment");
			getCreditCheckPage().verifyBillingAndPaymentOption();
			reporter.reportLogWithScreenshot("Billing and payment");
			getCreditCheckPage().selectPaymentOption(1);
			reporter.reportLogWithScreenshot("Monthly charges");
			getPaymentOptionsPage().clkContinue();
			//reporter.reportLogWithScreenshot("submit order");
			//getRogersOVCheckoutPage().clkSubmit();
			//reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
			//reporter.reportLogWithScreenshot("Order Placed");
		
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


