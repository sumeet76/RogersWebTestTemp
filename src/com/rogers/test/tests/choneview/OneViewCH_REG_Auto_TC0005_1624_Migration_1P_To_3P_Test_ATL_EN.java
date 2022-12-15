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
2. Province - ATL
3. SGI Acc Type - 1P RHP (Consolidated)
3. Add-Ons - For RHP, Select keep Number.
4. Installation Page - DBA
5. Payment Details - NA
6. Discounts - NA
 */

public class OneViewCH_REG_Auto_TC0005_1624_Migration_1P_To_3P_Test_ATL_EN extends BaseTestClass {
	@Test (groups = {"RegressionCHOV"})
    public void oneViewCH_Auto_1624_TC01_E2E_Migration_1P_RHP_To_3P_Test(){
		getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData1PRHPTo3P.getAccountNo(), TestDataHandler.migrationData1PRHPTo3P.getContactID());
		reporter.reportLogWithScreenshot("OneView Interface has Launched");
		getAccountOverViewPage().enterDealerCodeDialogue();
		getAccountOverViewPage().clickIgnite();
		getRogersIgniteBundlesPage().clkContinue();
		//getRogersIgniteBundlesPage().clkUsethisAddress();
		reporter.reportLogWithScreenshot("Service Availability");
		getRogersIgniteBundlesPage().clkContinueServiceable();
		getRogersIgniteBundlesPage().clkInternetCheckbox();
		getRogersIgniteBundlesPage().clkTVCheckbox();
		getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
		reporter.reportLogWithScreenshot("Triple play selected");
		getRogersIgniteBundlesPage().clkLoadOffers();
		getRogersIgniteBundlesPage().clickFirstAddToCart();
		reporter.reportLogWithScreenshot("Added to Cart");
		getRogersIgniteBundlesPage().noPortInPopup();
//		getRogersIgniteBundlesPage().clkKeepNumberbtn();
//		reporter.reportLogWithScreenshot("keep number");
		getRogersIgniteBundlesPage().clkCollapse();
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
		reporter.reportLogWithScreenshot("Product Added");
		getRogersIgniteBundlesPage().clkContinue();
		reporter.reportLogWithScreenshot("review terms and condition");
		getRogersIgniteBundlesPage().reviewAllTerms();
		getRogersIgniteBundlesPage().reviewTermsAndCondition();
		reporter.reportLogWithScreenshot("Points to mention");
		getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
/* getRogersIgniteBundlesPage().fourKTVPopup();
   getRogersIgniteBundlesPage().contiue4KContent();*/
		getRogersIgniteBundlesPage().clickExchangeLater();
		//getRogersIgniteBundlesPage().clickReviewAddons();
		getCustomerProfilePage().clkContinue();
		getRogersIgniteBundlesPage().fourKTVPopup();
		getRogersIgniteBundlesPage().fourKContentPopup();
		reporter.reportLogWithScreenshot("Internet Addons");
		getRogersIgniteBundlesPage().validateInternetAddOnsHeader();
		getCustomerProfilePage().clkContinue();
		reporter.hardAssert(getHomePhoneAddonsPage().verifyHomePhoneAddOnsHeader(),"Home Phone Header Display", "Home Phone Header not Displayed");
		reporter.reportLogWithScreenshot("Home Phone Add on page displayed");
		getHomePhoneAddonsPage().clkContinue();
		reporter.reportLogWithScreenshot("Cart Summary");
		reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
		getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
		getRogersIgniteBundlesPage().customerWishtoContinue();
		reporter.reportLogWithScreenshot("Customer Profile");
		reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile Header displayed","Customer Profile Header did not display");
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
		getHomePhoneSelectionPage().clkGeneratePhoneNo();
		reporter.reportLogWithScreenshot("Phone Number Selected");
		getCreditCheckPage().goToPageBottom();
		getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
		getCreditCheckPage().verifyInstallationOption();
		reporter.reportLogWithScreenshot("installation options");
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
		getCreditCheckPage().verifyBillingAndPaymentOption();
		//	reporter.hardAssert(getCreditCheckPage().verifyBillingAndPaymentOption(),"Billing And Payment Options displayed","Billing And Payment Options did not display");
		getPaymentOptionsPage().clkContinue();
	//	reporter.reportLogWithScreenshot("Submit order");
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
//		closeSession();
	}

}


