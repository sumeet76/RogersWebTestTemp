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

public class OneViewCH_Auto_TC072_1437_E2E_NAC_3P_Without4KTVExpressCheckout_ProInstall_Cheque_ON_EN_Test extends BaseTestClass {
	@Test (groups = {"RegressionCHOV","SanityCHOV"})
    public void oneViewCH_Auto_TC072_1437_E2E_NAC_3P_Without4KTVExpressCheckout_ProInstall_Cheque_ON_EN_Test(){
			reporter.reportLogWithScreenshot("oneview env");
			getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
			reporter.reportLogWithScreenshot("address");
			getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress());
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

			reporter.reportLogWithScreenshot("continue to exchange later");
			getRogersIgniteBundlesPage().clkExpressCheckOut();
			reporter.reportLogWithScreenshot("Cart Summary");
			getRogersIgniteBundlesPage().noTo4KTVPopup();
			getRogersIgniteBundlesPage().clkExpressCheckOut();
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
			reporter.reportLogWithScreenshot("Phone Number Generate");
			getHomePhoneSelectionPage().clkGeneratePhoneNo();
			reporter.reportLogWithScreenshot("Phone Number Selected");
			getCreditCheckPage().goToPageBottom();
		    getHomePhoneSelectionPage().clkContinueOnGeneratePhone();

			reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
			reporter.reportLogWithScreenshot("Installation options");
			reporter.hardAssert(getCreditCheckPage().verifyRecoEngineRecommendation(),"Reco Engine Install Recommendation Banner displayed"," Reco Engine Install Recommendation Banner is not displayed");
			reporter.hardAssert(getCreditCheckPage().verifyRecommendationBanner(),"Recommended Banner is displayed", "Recommeded Banner is not displayed");
			getCreditCheckPage().verifyInstallationOption();
			reporter.reportLogWithScreenshot("go To Page Bottom");
			getCreditCheckPage().goToPageBottom();
			reporter.reportLogWithScreenshot("professional installation");
			getCreditCheckPage().selectProfessionalInstallation();
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
			reporter.reportLogWithScreenshot("digital front line");
			getCreditCheckPage().selectPaymentOption(2);
			reporter.reportLogWithScreenshot("Pre-authorized Chequing");
			getRogersOVCheckoutPage().enterTransitNumber("00333");
			reporter.reportLogWithScreenshot("Transit number");
			getRogersOVCheckoutPage().enterInstitutionNumber("003");
			reporter.reportLogWithScreenshot("Institution Number");
			getRogersOVCheckoutPage().enterAccountNumber("1234003");
			reporter.reportLogWithScreenshot("Account Number");
			getPaymentOptionsPage().clkContinue();

			reporter.reportLogWithScreenshot("submit order");
			getRogersOVCheckoutPage().clkSubmit();
			reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
			reporter.reportLogWithScreenshot("Order Placed");
		
    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactID3PWithout4KTVExpressCheckout(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		//closeSession();
	}

}


