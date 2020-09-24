package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test Legacy Bundle Offer Buy flow for Rogers.com  
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Browser to Shop menu and select Bundle option
 *3. Scroll down to  Bundles section and click on How to Get it button for a Bundle
 *4. Enter home address to validate the serviceability and click on Check button
 *5. Click on Buy online option
 *6. Click on Continue
 *7. Enter Valid contact information in 1) Your Contact information section
 *8. Enter Valid details in 2) Credit and Billing information 
 *9. Check the "Sure, lets do a Credit Evaluation" check box and click on Submit
 *10. In 3) 'Installation section, pick a date and time to schedule installation
 *11. In Order Summary section - select email option for receiving Order Summary
 *12. Scroll all the way down in Additional agreement details, check the checkbox - I have read……
 *13. Click Submit
 *
 **/

public class RogersCH_TC_004_LegacyBundle_BuyBundleOfferTest extends BaseTestClass {
	private String strLanguage=System.getProperty("Language");

	@Test(groups = {"SanityCH","RegressionCH","LegacyTVFlowsCH"})
    public void checkLegacyBundleOffer() throws InterruptedException {
		reporter.reportLogWithScreenshot("Launched the Easy Login Page");
		rogers_home_page.clkEasyLogin();
    	reporter.reportLogWithScreenshot("Launched the Home Page");
    	rogers_home_page.clkExistingCustomerShop();
    	reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the Legacy bundle");
    	rogers_home_page.clkBundle();
    	reporter.reportLogWithScreenshot("Launched the legacy bundle packages page");
    	rogers_legacy_bundle_buy_page.clkSelectBundle();
        String  strAddressLine1=TestDataHandler.digitalTVAccount.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.digitalTVAccount.getAccountDetails().getAddress().get("line2");
        rogers_legacy_bundle_buy_page.setAddressLookup(strAddressLine1+", "+strAddressLine2);
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        rogers_legacy_bundle_buy_page.clkAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Good News for the Service availability");
    	if (strLanguage.equals("en"))
    	{
    	reporter.reportLogWithScreenshot("Good News for the Service availability");
    	rogers_legacy_bundle_buy_page.clkBuyOnline();
    	reporter.reportLogWithScreenshot("Cart-summary Page with the selected plan");
    	rogers_legacy_bundle_buy_page.clkCheckout(); 
    	reporter.reportLogWithScreenshot("Checkout page has launched to give the user information");
    	rogers_order_summary_page.setFirstName();
    	rogers_order_summary_page.setLastName();
    	rogers_order_summary_page.setEmail();
    	rogers_order_summary_page.setStreetNumber(TestDataHandler.digitalTVAccount.getAccountDetails().getAddress().get("streetNumber"));
    	rogers_order_summary_page.setStreetName(TestDataHandler.digitalTVAccount.getAccountDetails().getAddress().get("streetName"));
    	rogers_order_summary_page.setCity(TestDataHandler.digitalTVAccount.getAccountDetails().getAddress().get("city"));
    	rogers_order_summary_page.selectProvince(TestDataHandler.digitalTVAccount.getAccountDetails().getAddress().get("Province"));
    	rogers_order_summary_page.setPostalCode(TestDataHandler.digitalTVAccount.getAccountDetails().getAddress().get("PostalCode"));
    	rogers_order_summary_page.setPhone();
    	reporter.reportLogWithScreenshot("Entered the user contact information");    	
    	rogers_order_summary_page.selectDOBYear();
    	rogers_order_summary_page.selectDOBMonth();
    	rogers_order_summary_page.selectDOBDay();
    	rogers_order_summary_page.switchToCreditCardIFrame();
    	rogers_order_summary_page.setCreditCardNumberIFrame(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
    	rogers_order_summary_page.switchOutOfCreditCardIFrame();
    	rogers_order_summary_page.selectExpiryMonth();
    	rogers_order_summary_page.selectExpiryYear();
    	reporter.reportLogWithScreenshot("Entered the Credit information");
    	rogers_order_summary_page.selectSecondIDOption("dl");
    	rogers_order_summary_page.setDrivingLicenseNumber();
    	rogers_order_summary_page.selectDirivingLicenseProvince("British Columbia");
    	rogers_order_summary_page.selectDrivingLicenseExpiryYear();
    	rogers_order_summary_page.selectLicenseExpiryMonth();
    	rogers_order_summary_page.selectDrivingLicenseExpiryDay();
    	reporter.reportLogWithScreenshot("Entered the Billing Information information");
    	rogers_order_summary_page.clkCreditConsent();
    	reporter.reportLogWithScreenshot("Credit Consent Check Done");
    	rogers_order_summary_page.clkCreditConsentSubmit();
    	reporter.reportLogWithScreenshot("Tech-Install block has launched");
    	rogers_order_summary_page.clkTechInstall();
    	reporter.reportLogWithScreenshot("Agreement block has launched");
    	rogers_order_summary_page.clkConsentCheckboxBundleflow();
    	reporter.reportLogWithScreenshot("Consent Check Done");
    	rogers_order_summary_page.clkSubmit();  
    	reporter.reportLogWithScreenshot("order info");
  	    reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmationLegacy(),"Order has created", "Order hasn't careted");
    	}
    	else
    	{
    	reporter.hardAssert(rogers_legacy_bundle_buy_page.verifyServiceabilitySuccess(),"Order has created", "Order hasn't careted");
    	}
        }

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//legacyAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_legacyanonymous, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}


