
package com.rogers.test.tests.solarisconsumer;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;

/**
 * This class contains the test method to verify the Legacy Internet upgarde flow for Rogers.com   
 * 
 * @author Saurav.Goyal
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Browse to Shop menu and select Ignite TV option
 *3. Scroll down to Ignite TV bundlessection and select one of available Bundle, click Add to Cart
 *4. Enter home address to validate the serviceability and click on Check Availability
 *5. Click on Continue
 *6. Click "Yes, Keep my number"
 *7. Enter ph number and click on eligibility and continue
 *8. Click on Continue in Home phone add ons page
 *9. Select one option for   'Do you have a 4K TV'
 *10. Click checkout button on cart summary page.
 *11. Enter all personal information on user profile creation page - 1) Profile step
 *12. Click on Continue
 *13. In 2) Credit Evaluation page, enter the required info on Credit Check:
 *14. Click Submit
 *15. Select a time in Choose your Date and Time 
 *16. Enter any valid Mobile number and email address
 *17. Click on Confirm
 *18. Validate minicart 
 *19. Select Pre-Authorized credit card option from type of payment dropdown.
 *20. Enter valid Credit Card number details in Credit Card related fields.
 *21. Click on Continue.
 *22. Validate appropriate information is displayed in Review order page.
 *23. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox.
 *24. Order confirmation page will be displayed with the order number and validate the order details.
 *
 **/

public class RogersSC_TC_014_IgniteTV_AnonymousCustomerTriplePlayPortInTest extends BaseTestClass {

    @Test
    public void checkBuyIginteTVOffer() {
    	reporter.reportLogWithScreenshot("Launched the Home Page");
    	getRogersHomePage().clkShop(); 
    	reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
    	getRogersHomePage().clkIgniteTV();
    	getRogersHomePage().verifyIgnitepage();
    	reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	getRogersHomePage().clkServiceability();
    	reporter.reportLogWithScreenshot("Launched the customer availability check popup");
    	getRogersHomePage().clkAddressCheck();
    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=TestDataHandler.tc32_SolarisPortinFlows.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc32_SolarisPortinFlows.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        getRogersIgniteTVBuyPage().selectSolarisStarterPackage();
        reporter.reportLogWithScreenshot("Launched the port-in popup");
        getRogersIgniteTVBuyPage().clickOptPhone();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersHomePhonePortInPage().setHomePhoneNumber(TestDataHandler.tc32_SolarisPortinFlows.getAccountDetails().getPhoneNumber());
        getRogersHomePhonePortInPage().clkPhoneNumberEligibiltyCheck();
        getRogersHomePhonePortInPage().clkPhoneCheck();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersIgniteTVBuyPage().clkHomePhone();
        getRogersIgniteTVBuyPage().verify4KTV();
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();
        getRogersIgniteTVProfileCreationPage().verifyProfilePage();
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().setEmail();
        getRogersIgniteTVProfileCreationPage().setFirstname();
        getRogersIgniteTVProfileCreationPage().setLastName();
        getRogersIgniteTVProfileCreationPage().setPhone();
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
        getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage();
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
        getRogersIgniteTVCreditCheckPage().selectDOBYear();
        getRogersIgniteTVCreditCheckPage().selectDOBMonth();
        getRogersIgniteTVCreditCheckPage().selectDOBDay();
        reporter.reportLogWithScreenshot("Entered DOB details");
        getRogersIgniteTVCreditCheckPage().selectFirstID("2");
        getRogersIgniteTVCreditCheckPage().selectProvince("BC");
        getRogersIgniteTVCreditCheckPage().selectExpiryYearwithSpace();
        getRogersIgniteTVCreditCheckPage().selectExpiryMonth();
        getRogersIgniteTVCreditCheckPage().selectExpiryDay();
        getRogersIgniteTVCreditCheckPage().setDrivingLicenseNumber("ON");
        reporter.reportLogWithScreenshot("Driving License Details");
        getRogersIgniteTVCreditCheckPage().selectSecondIDOption("4");
        getRogersIgniteTVCreditCheckPage().setPassportNumber();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryYear();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryMonth();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryDay();
        getRogersIgniteTVCreditCheckPage().clkCreditConsent();
        reporter.reportLogWithScreenshot("Passport Details");
        getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
        getRogersHomePhoneSelectionPage().verifyPhoneNumberPage();
        getRogersHomePhoneSelectionPage().clkPhoneNumberGenerator();
        getRogersHomePhoneSelectionPage().clkChosePhoneNumber();
        getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();
        getRogersTechInstallPage().verifyTechInstallPage();
        reporter.reportLogWithScreenshot("Launched the tech install page");
        getRogersTechInstallPage().clkTechInstallSlot();
        reporter.reportLogWithScreenshot("tech install details");
        getRogersTechInstallPage().clkTechInstallContinue();
        getRogersPaymentOptionsPage().verifyPaymentModepage();
        reporter.reportLogWithScreenshot("Launched the payment options page");
        getRogersPaymentOptionsPage().selectPaymentMode("pacc");
        getRogersPaymentOptionsPage().switchToCreditCardIFrame();
        getRogersPaymentOptionsPage().setCreditCardNumberIFrame(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
        getRogersPaymentOptionsPage().switchOutOfCreditCardIFrame();
        getRogersPaymentOptionsPage().setCVV();
        getRogersPaymentOptionsPage().selectExpiryMonth();
        getRogersPaymentOptionsPage().selectExpiryYear(); 
        reporter.reportLogWithScreenshot("Payment options Details");
        getRogersPaymentOptionsPage().clkPaymentConfirm();
        getRogersOrderReviewPage().verifyAgreementPage();
        reporter.reportLogWithScreenshot("Launched the order review page");
        getRogersOrderReviewPage().verifyAgreement();
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        getRogersOrderConfirmationPage().verifyOrderConfirmation();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Order has created successfully","Order has failed");       
        
        /*getRogersHomePhonePortInPage().setFirstName();
        getRogersHomePhonePortInPage().setLastName();
        getRogersHomePhonePortInPage().setInvoiceAddress(strAddressLine1+", "+strAddressLine2+", CANADA");
        getRogersHomePhonePortInPage().setAccountNumberOrIMEI("358709098788163");
        getRogersHomePhonePortInPage().clkConfirmPhoneNumber();
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().clkHomePhone();
        getRogersIgniteTVBuyPage().set4KTV();
        getRogersIgniteTVBuyPage().clkCheckout();
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().setEmail();
        getRogersIgniteTVProfileCreationPage().setFirstname();
        getRogersIgniteTVProfileCreationPage().setLastName();
        getRogersIgniteTVProfileCreationPage().setPhone();
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
        getRogersIgniteTVCreditCheckPage().selectDOBYear();
        getRogersIgniteTVCreditCheckPage().selectDOBMonth();
        getRogersIgniteTVCreditCheckPage().selectDOBDay();
        getRogersIgniteTVCreditCheckPage().selectFirstID("2");
        getRogersIgniteTVCreditCheckPage().selectProvince("BC");
        getRogersIgniteTVCreditCheckPage().selectExpiryYearwithSpace();
        getRogersIgniteTVCreditCheckPage().selectExpiryMonth();
        getRogersIgniteTVCreditCheckPage().selectExpiryDay();
        getRogersIgniteTVCreditCheckPage().setDrivingLicenseNumber();
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersIgniteTVCreditCheckPage().selectSecondIDOption("4");
        getRogersIgniteTVCreditCheckPage().setPassportNumber();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryYear();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryMonth();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryDay();
        getRogersIgniteTVCreditCheckPage().clkCreditConsent();
        getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
        reporter.reportLogWithScreenshot("Launched the tech install page");
        getRogersTechInstallPage().clkTechInstallSlot();
        getRogersTechInstallPage().setMobielNumber();
        getRogersTechInstallPage().setEmail();
        getRogersTechInstallPage().clkTechInstallContinue();
        reporter.reportLogWithScreenshot("Launched the payment options page");
        getRogersPaymentOptionsPage().selectPaymentMode("pacc");
        getRogersPaymentOptionsPage().setCreditCardNumberIFrame(TestDataHandler.rogersPaymentInfo.getCreditCardDetails().getNumber());
        getRogersPaymentOptionsPage().setCVV();
        getRogersPaymentOptionsPage().selectExpiryMonth();
        getRogersPaymentOptionsPage().selectExpiryYear();
        getRogersPaymentOptionsPage().clkPaymentConfirm();
        reporter.reportLogWithScreenshot("Launched the order review page");
        getRogersOrderReviewPage().verifyAgreement();
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
       getRogersOrderReviewPage().clkChangeSubmit();
       reporter.reportLogWithScreenshot("Launched the Order Confirmation page");
       reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Order has created successfully","Order has failed"); */
                          
    }

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,strGroupName, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


