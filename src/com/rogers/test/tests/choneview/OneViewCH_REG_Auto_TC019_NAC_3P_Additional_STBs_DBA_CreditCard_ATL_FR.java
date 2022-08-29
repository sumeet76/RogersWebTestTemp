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


public class OneViewCH_REG_Auto_TC019_NAC_3P_Additional_STBs_DBA_CreditCard_ATL_FR extends BaseTestClass {
	@Test (groups = {"RNAC","RegressionCHOV","SanityCHOV"})
    public void oneViewCH_REG_Auto_TC019_NAC_3P_Additional_STBs_DBA_CreditCard_ATL_FR (){
			reporter.reportLogWithScreenshot("oneview env");
			getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
			reporter.reportLogWithScreenshot("address");
			getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress_ALT(),"Chrome");
			reporter.reportLogWithScreenshot("Service Availability");
			getRogersIgniteBundlesPage().clkContinue();
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
			getAccountOverViewPage().setLanguageFrench();
			reporter.reportLogWithScreenshot("Switched language from english to french");
			reporter.reportLogWithScreenshot("Select Services Customer Wants");
			getRogersIgniteBundlesPage().clkTVCheckbox();
			getRogersIgniteBundlesPage().clkInternetCheckbox();
			getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
			reporter.reportLogWithScreenshot("Triple Play Selected");
			getRogersIgniteBundlesPage().clkLoadOffers();
			getRogersIgniteBundlesPage().selectAdditionalIgniteTVBoxes();
			getRogersIgniteBundlesPage().clickFirstAddToCart();
			getRogersIgniteBundlesPage().noPortInPopup();
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
			reporter.reportLogWithScreenshot("Product in cart");
			getRogersIgniteBundlesPage().clkCollapse();
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
			reporter.reportLogWithScreenshot("Product Added");
			getRogersIgniteBundlesPage().clkContinue();
			reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
		    getRogersIgniteBundlesPage().clickExchangeLater();
			getRogersOVChannelsAndThemePacksPage().clkContinue();
			getRogersIgniteBundlesPage().fourKTVPopup();
			getRogersIgniteBundlesPage().fourKContinue();
		    reporter.reportLogWithScreenshot("Cart Summary");
			getRogersIgniteBundlesPage().clkContinue();
			getRogersIgniteBundlesPage().clkContinue();
			reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"cart summary header found","cart summary header not found");
			getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		    reporter.reportLogWithScreenshot("verify Customer Profile");
			getRogersIgniteBundlesPage().customerWishtoContinue();
			reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
			reporter.reportLogWithScreenshot("Customer Profile");
			getCustomerProfilePage().clkContinue();
			reporter.reportLogWithScreenshot("Evaluation form");
			getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
			reporter.reportLogWithScreenshot("DOB");
			getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
			reporter.reportLogWithScreenshot("Driver license");
			getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
			reporter.reportLogWithScreenshot("Evaluation form filled");
			getCreditCheckPage().clkAuthorize();
			reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
			reporter.reportLogWithScreenshot("Credit Check Information");
			getCreditCheckPage().clkContinue();
			reporter.reportLogWithScreenshot("Generate phone");
			getHomePhoneSelectionPage().clkGeneratePhoneNo();
			reporter.reportLogWithScreenshot("Phone Number Selected");
			getCreditCheckPage().goToPageBottom();
			reporter.reportLogWithScreenshot("Page bottom");
		    getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
			reporter.reportLogWithScreenshot("phone number generated.");
			//getHomePhoneSelectionPage().clkContinue();
			reporter.reportLogWithScreenshot("Installation options");
			reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
			reporter.hardAssert(getCreditCheckPage().verifyRecoEngineRecommendation(),"Reco Engine Install Recommendation Banner displayed"," Reco Engine Install Recommendation Banner is not displayed");
			reporter.hardAssert(getCreditCheckPage().verifyRecommendationBanner(),"Recommended Banner is displayed", "Recommeded Banner is not displayed");
			getCreditCheckPage().verifyInstallationOption();
			getCreditCheckPage().goToPageBottom();
			getCreditCheckPage().selectDeliveryByAppointment();
			getFulfillmentPage().clkFirstAvailableAppointment();
			reporter.reportLogWithScreenshot(".enter Text Mobile Number");
			getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
			getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
			reporter.reportLogWithScreenshot(".enter Special Instructions");
			getCreditCheckPage().enterSpecialInstructions();
			getCreditCheckPage().clkContinueInstallationOption();
			reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
			getCreditCheckPage().verifyBillingAndPaymentOption();
			reporter.reportLogWithScreenshot("front line");
			getCreditCheckPage().clickDigitalFrontline();
			reporter.reportLogWithScreenshot("card details");
			getRogersOVCheckoutPage().enterCardToken(TestDataHandler.anonymousData.getCreditCardDetails().getNumber());
			reporter.reportLogWithScreenshot("Token Number");
			getRogersOVCheckoutPage().setCardExpiryMonthAndYear();
			reporter.reportLogWithScreenshot("year and Month");
			getRogersOVCheckoutPage().setCardCVV(TestDataHandler.anonymousData.getCreditCardDetails().getCVV());
			reporter.reportLogWithScreenshot("card details entered");
			getPaymentOptionsPage().clkContinue();
			reporter.reportLogWithScreenshot("submit order");
			getRogersOVCheckoutPage().clkSubmit();
			reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
			reporter.reportLogWithScreenshot("Order Placed");
		
    }

	@BeforeMethod (alwaysRun=true)
	@Parameters({"strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactID_STB_3P(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		//closeSession();
	}

}


