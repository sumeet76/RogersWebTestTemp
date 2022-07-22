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


public class OneViewCH_Auto_TC016_1409_E2E_NAC_SAI_PortIn_PaymentMethod_MonthlyCharger_Test_ON_EN extends BaseTestClass {
	@Test (groups = {"RNAC","RegressionCHOV"})
    public void oneViewCH_Auto_TC016_1409_E2E_NAC_SAI_PortIn_PaymentMethod_MonthlyCharger_Test_ON_EN(){

		reporter.reportLogWithScreenshot("OneView env");
		getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
		reporter.reportLogWithScreenshot("address");
		getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress_ALT());
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress_ALT()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress_ALT()+" not serviceable");
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
		reporter.reportLogWithScreenshot("Select Services Customer Wants");
		getRogersIgniteBundlesPage().setLanguageFrench();
		getRogersIgniteBundlesPage().clickCheckAnotherAddress();
		getRogersIgniteBundlesPage().refreshCheckAvailability();
		getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress_ALT());
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress_ALT()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress_ALT()+" not serviceable");
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
		reporter.reportLogWithScreenshot("Select Services Customer Wants");
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		reporter.reportLogWithScreenshot("Single Play - SAI Selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		System.out.println(TestDataHandler.anonymousData.getPlanEngSAI());
		System.out.println(TestDataHandler.anonymousData.getplanFr());
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		getRogersIgniteBundlesPage().yesPortInPopup();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
		getRogersIgniteBundlesPage().clkContinue();
		getRogersIgniteBundlesPage().clkExpressCheckOut();
		reporter.hardAssert(getRogersIgniteBundlesPage().headerPortInService(),"Port in Service Header exist","Failed");
		reporter.reportLogWithScreenshot("Port In Service");
		getRogersIgniteBundlesPage().setProvider("BELL ONTARIO");
		getRogersIgniteBundlesPage().enterAccountNumber("1122334455");
		reporter.reportLogWithScreenshot("Port In completed");
		getRogersIgniteBundlesPage().contiueFromPortIn();
		reporter.reportLogWithScreenshot("CART SUMMARY");
		getRogersIgniteBundlesPage().contiueToCartSummary();
		reporter.reportLogWithScreenshot("Cart Summary");
//		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		reporter.reportLogWithScreenshot("wish to continue");
		getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
		getCustomerProfilePage().clkContinue();
		reporter.reportLogWithScreenshot("form filler");
		getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
		getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
		getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
		reporter.reportLogWithScreenshot("credit form completed");
		getCreditCheckPage().clkAuthorize();
		reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
		reporter.reportLogWithScreenshot("Credit Check Information");
		getCreditCheckPage().clkContinue();
		reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
		reporter.hardAssert(getCreditCheckPage().verifyRecoEngineRecommendation(),"Reco Engine Install Recommendation Banner displayed"," Reco Engine Install Recommendation Banner is not displayed");
		reporter.hardAssert(getCreditCheckPage().verifyRecommendationBanner(),"Recommended Banner is displayed", "Recommeded Banner is not displayed");
		getCreditCheckPage().verifyInstallationOption();
		getCreditCheckPage().goToPageBottom();
		reporter.reportLogWithScreenshot("in person delivery");
		getCreditCheckPage().clkCourierDelivery();
		getCreditCheckPage().clickInPersonDelivery();
		getPaymentOptionsPage().clkContinue();
		reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
		getCreditCheckPage().verifyBillingAndPaymentOption();
		getCreditCheckPage().verifyBillingAndPaymentOption();
		reporter.reportLogWithScreenshot("Billing and payment");
		getCreditCheckPage().selectPaymentOption(1);
		reporter.reportLogWithScreenshot("Monthly charges");
		getPaymentOptionsPage().clkContinue();
		reporter.reportLogWithScreenshot("submit order");
		//getPaymentOptionsPage().clkContinue();
		//getRogersOVCheckoutPage().clkSubmit();
		//reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
		//reporter.reportLogWithScreenshot("Order Placed");

    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactIDSAIPortIn(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


