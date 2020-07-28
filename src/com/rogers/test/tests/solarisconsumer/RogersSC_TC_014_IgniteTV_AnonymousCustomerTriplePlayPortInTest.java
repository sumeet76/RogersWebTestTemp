
package com.rogers.test.tests.solarisconsumer;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
 *10. Click “checkout” button on cart summary page.
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
    	rogers_home_page.clkShop(); 
    	reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
    	rogers_home_page.clkIgniteTV();
    	rogers_home_page.verifyIgnitepage();
    	reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	rogers_home_page.clkServiceability();
    	reporter.reportLogWithScreenshot("Launched the customer availability check popup");
    	rogers_home_page.clkAddressCheck();
    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=(String) TestDataHandler.solarisPortinFlows.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.solarisPortinFlows.getAccountDetails().getAddress().get("line2");
        rogers_home_page.setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        rogers_home_page.clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        rogers_igniteTV_buy_page.selectSolarisStarterPackageNew();
        reporter.reportLogWithScreenshot("Launched the port-in popup");
        rogers_igniteTV_buy_page.clickOptPhone();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        rogers_home_phone_port_in_page.setHomePhoneNumber(TestDataHandler.solarisPortinFlows.getAccountDetails().getPhoneNumber());
        rogers_home_phone_port_in_page.clkPhoneNumberEligibiltyCheck();
        rogers_home_phone_port_in_page.clkPhoneCheck();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        rogers_igniteTV_buy_page.clkHomePhone();
        rogers_igniteTV_buy_page.verify4KTV();
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        rogers_igniteTV_buy_page.set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        rogers_igniteTV_buy_page.clkCheckout();
        rogers_igniteTV_profile_creation_page.verifyProfilePage();
        reporter.reportLogWithScreenshot("Launched the create profile page");
        rogers_igniteTV_profile_creation_page.setEmail();
        rogers_igniteTV_profile_creation_page.setFirstname();
        rogers_igniteTV_profile_creation_page.setLastName();
        rogers_igniteTV_profile_creation_page.setPhone();
        rogers_igniteTV_profile_creation_page.clkSubmitProfile();
        rogers_igniteTV_credit_check_page.verifyCreditEvalutionPage();
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
        rogers_igniteTV_credit_check_page.selectDOBYear();
        rogers_igniteTV_credit_check_page.selectDOBMonth();
        rogers_igniteTV_credit_check_page.selectDOBDay();
        reporter.reportLogWithScreenshot("Entered DOB details");
        rogers_igniteTV_credit_check_page.selectFirstID("2");
        rogers_igniteTV_credit_check_page.selectProvince("BC");
        rogers_igniteTV_credit_check_page.selectExpiryYearwithSpace();
        rogers_igniteTV_credit_check_page.selectExpiryMonth();
        rogers_igniteTV_credit_check_page.selectExpiryDay();
        rogers_igniteTV_credit_check_page.setDrivingLicenseNumber("ON");
        reporter.reportLogWithScreenshot("Driving License Details");
        rogers_igniteTV_credit_check_page.selectSecondIDOption("4");
        rogers_igniteTV_credit_check_page.setPassportNumber();
        rogers_igniteTV_credit_check_page.selectPassportExpiryYear();
        rogers_igniteTV_credit_check_page.selectPassportExpiryMonth();
        rogers_igniteTV_credit_check_page.selectPassportExpiryDay();
        rogers_igniteTV_credit_check_page.clkCreditConsent();
        reporter.reportLogWithScreenshot("Passport Details");
        rogers_igniteTV_credit_check_page.clkCreditConsentSubmit();
        rogers_home_phone_selection_page.verifyPhoneNumberPage();
        rogers_home_phone_selection_page.clkPhoneNumberGenerator(); 
        rogers_home_phone_selection_page.clkChosePhoneNumber(); 
        rogers_home_phone_selection_page.clkContinueHomePhoneSelection(); 
        rogers_tech_install_page.verifyTechInstallPage(); 
        reporter.reportLogWithScreenshot("Launched the tech install page");
        rogers_tech_install_page.clkTechInstallSlot();
        reporter.reportLogWithScreenshot("tech install details");
        rogers_tech_install_page.clkTechInstallContinue();
        rogers_payment_options_page.verifyPaymentModepage();
        reporter.reportLogWithScreenshot("Launched the payment options page");
        rogers_payment_options_page.selectPaymentMode("pacc");
        rogers_payment_options_page.switchToCreditCardIFrame();
        rogers_payment_options_page.setCreditCardNumberIFrame(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
        rogers_payment_options_page.switchOutOfCreditCardIFrame();
        rogers_payment_options_page.setCVV();
        rogers_payment_options_page.selectExpiryMonth();
        rogers_payment_options_page.selectExpiryYear(); 
        reporter.reportLogWithScreenshot("Payment options Details");
        rogers_payment_options_page.clkPaymentConfirm();
        rogers_order_review_page.verifyAgreementPage();
        reporter.reportLogWithScreenshot("Launched the order review page");
        rogers_order_review_page.verifyAgreement();
        rogers_order_review_page.clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        rogers_order_review_page.clkSubmit();
        rogers_order_confirmation_page.verifyOrderConfirmation();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Order has created successfully","Order has failed");       
        
        /*rogers_home_phone_port_in_page.setFirstName();
        rogers_home_phone_port_in_page.setLastName();
        rogers_home_phone_port_in_page.setInvoiceAddress(strAddressLine1+", "+strAddressLine2+", CANADA");
        rogers_home_phone_port_in_page.setAccountNumberOrIMEI("358709098788163");
        rogers_home_phone_port_in_page.clkConfirmPhoneNumber();
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        rogers_igniteTV_buy_page.clkHomePhone();
        rogers_igniteTV_buy_page.set4KTV(); 
        rogers_igniteTV_buy_page.clkCheckout();
        reporter.reportLogWithScreenshot("Launched the create profile page");
        rogers_igniteTV_profile_creation_page.setEmail();
        rogers_igniteTV_profile_creation_page.setFirstname();
        rogers_igniteTV_profile_creation_page.setLastName();
        rogers_igniteTV_profile_creation_page.setPhone();
        rogers_igniteTV_profile_creation_page.clkSubmitProfile();
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
        rogers_igniteTV_credit_check_page.selectDOBYear();
        rogers_igniteTV_credit_check_page.selectDOBMonth();
        rogers_igniteTV_credit_check_page.selectDOBDay();
        rogers_igniteTV_credit_check_page.selectFirstID("2");
        rogers_igniteTV_credit_check_page.selectProvince("BC");
        rogers_igniteTV_credit_check_page.selectExpiryYearwithSpace();
        rogers_igniteTV_credit_check_page.selectExpiryMonth();
        rogers_igniteTV_credit_check_page.selectExpiryDay();
        rogers_igniteTV_credit_check_page.setDrivingLicenseNumber();
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        rogers_igniteTV_credit_check_page.selectSecondIDOption("4");
        rogers_igniteTV_credit_check_page.setPassportNumber();
        rogers_igniteTV_credit_check_page.selectPassportExpiryYear();
        rogers_igniteTV_credit_check_page.selectPassportExpiryMonth();
        rogers_igniteTV_credit_check_page.selectPassportExpiryDay();
        rogers_igniteTV_credit_check_page.clkCreditConsent();
        rogers_igniteTV_credit_check_page.clkCreditConsentSubmit();
        reporter.reportLogWithScreenshot("Launched the tech install page");
        rogers_tech_install_page.clkTechInstallSlot();
        rogers_tech_install_page.setMobielNumber();
        rogers_tech_install_page.setEmail();
        rogers_tech_install_page.clkTechInstallContinue();
        reporter.reportLogWithScreenshot("Launched the payment options page");
        rogers_payment_options_page.selectPaymentMode("pacc");
        rogers_payment_options_page.setCreditCardNumberIFrame(TestDataHandler.rogersPaymentInfo.getCreditCardDetails().getNumber());
        rogers_payment_options_page.setCVV();
        rogers_payment_options_page.selectExpiryMonth();
        rogers_payment_options_page.selectExpiryYear();
        rogers_payment_options_page.clkPaymentConfirm();
        reporter.reportLogWithScreenshot("Launched the order review page");
        rogers_order_review_page.verifyAgreement();
        rogers_order_review_page.clkAcceptenceCheckbox();
       rogers_order_review_page.clkChangeSubmit();
       reporter.reportLogWithScreenshot("Launched the Order Confirmation page");
       reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Order has created successfully","Order has failed"); */
                          
    }

    @BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	//IgniteLogin
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.chConfig.getRogersURL(),  strBrowser,strLanguage,strGroupName, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


