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

public class RogersCH_TC_047_LegacyBundle_BuyBundleOfferTest extends BaseTestClass {
	private String strLanguage=System.getProperty("Language");

	//functionality has been obsoleted
	@Test
    public void checkLegacyBundleOffer() throws InterruptedException {
    	reporter.reportLogWithScreenshot("Launched the Home Page");
    	getRogersHomePage().clkShop();
    	reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the Legacy bundle");
    	getRogersHomePage().clkBundle();
    	reporter.reportLogWithScreenshot("Launched the legacy bundle packages page");
    	getRogersLegacyBundleBuyPage().clkSelectBundle();
        String  strAddressLine1=TestDataHandler.tc43_44_digitalTVAccount.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc43_44_digitalTVAccount.getAccountDetails().getAddress().get("line2");
        getRogersLegacyBundleBuyPage().setAddressLookup(strAddressLine1+", "+strAddressLine2);
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getRogersLegacyBundleBuyPage().clkAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Good News for the Service availability");
    	if (strLanguage.equals("en"))
    	{
    	reporter.reportLogWithScreenshot("Good News for the Service availability");
    	getRogersLegacyBundleBuyPage().clkBuyOnline();
    	reporter.reportLogWithScreenshot("Cart-summary Page with the selected plan");
    	getRogersLegacyBundleBuyPage().clkCheckout();
    	reporter.reportLogWithScreenshot("Checkout page has launched to give the user information");
    	getRogersOrderSummaryPage().setFirstName();
    	getRogersOrderSummaryPage().setLastName();
    	getRogersOrderSummaryPage().setEmail();
    	getRogersOrderSummaryPage().setStreetNumber(TestDataHandler.tc43_44_digitalTVAccount.getAccountDetails().getAddress().get("streetNumber"));
    	getRogersOrderSummaryPage().setStreetName(TestDataHandler.tc43_44_digitalTVAccount.getAccountDetails().getAddress().get("streetName"));
    	getRogersOrderSummaryPage().setCity(TestDataHandler.tc43_44_digitalTVAccount.getAccountDetails().getAddress().get("city"));
    	getRogersOrderSummaryPage().selectProvince(TestDataHandler.tc43_44_digitalTVAccount.getAccountDetails().getAddress().get("Province"));
    	getRogersOrderSummaryPage().setPostalCode(TestDataHandler.tc43_44_digitalTVAccount.getAccountDetails().getAddress().get("PostalCode"));
    	getRogersOrderSummaryPage().setPhone();
    	reporter.reportLogWithScreenshot("Entered the user contact information");    	
    	getRogersOrderSummaryPage().selectDOBYear();
    	getRogersOrderSummaryPage().selectDOBMonth();
    	getRogersOrderSummaryPage().selectDOBDay();
    	getRogersOrderSummaryPage().switchToCreditCardIFrame();
    	getRogersOrderSummaryPage().setCreditCardNumberIFrame(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
    	getRogersOrderSummaryPage().switchOutOfCreditCardIFrame();
    	getRogersOrderSummaryPage().selectExpiryMonth();
    	getRogersOrderSummaryPage().selectExpiryYear();
    	reporter.reportLogWithScreenshot("Entered the Credit information");
    	getRogersOrderSummaryPage().selectSecondIDOption("dl");
    	getRogersOrderSummaryPage().setDrivingLicenseNumber();
    	getRogersOrderSummaryPage().selectDirivingLicenseProvince("British Columbia");
    	getRogersOrderSummaryPage().selectDrivingLicenseExpiryYear();
    	getRogersOrderSummaryPage().selectLicenseExpiryMonth();
    	getRogersOrderSummaryPage().selectDrivingLicenseExpiryDay();
    	reporter.reportLogWithScreenshot("Entered the Billing Information information");
    	getRogersOrderSummaryPage().clkCreditConsent();
    	reporter.reportLogWithScreenshot("Credit Consent Check Done");
    	getRogersOrderSummaryPage().clkCreditConsentSubmit();
    	reporter.reportLogWithScreenshot("Tech-Install block has launched");
    	getRogersOrderSummaryPage().clkTechInstall();
    	reporter.reportLogWithScreenshot("Agreement block has launched");
    	getRogersOrderSummaryPage().clkConsentCheckboxBundleflow();
    	reporter.reportLogWithScreenshot("Consent Check Done");
    	getRogersOrderSummaryPage().clkSubmit();
    	reporter.reportLogWithScreenshot("order info");
  	    reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationLegacy(),"Order has created", "Order hasn't careted");
    	}
    	else
    	{
    	reporter.hardAssert(getRogersLegacyBundleBuyPage().verifyServiceabilitySuccess(),"Order has created", "Order hasn't careted");
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


