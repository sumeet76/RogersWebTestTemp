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
 * This class contains the test method to test the IgniteTV buy flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 * Launch Rogers.com url
 * Click on Ignite Tv under shop menu
 * Click on check Availability button
 * Enter valid serviceable address in serviceability check pop up and click on Check availablity button
 * Validate flex and total channel count is displayed correctly in TV Dashboard page as per the Copy Deck
 * Validate the total channel count in The API "bundleoffers"
 * Choose any bundle and click on add to cart
 * Validate flex and total channel count is displayed correctly in Cart Summary page as per the Copy Deck
 * Click on continue in Cart summary page
 * Enter all necessary details on user profile creation page
 * Click on Continue
 * Enter the required information in credit check page
 * Click on continue button
 * Click on confirm
 * Click continue
 * Validate flex and total channel count is displayed correctly in order review page as per the copy deck
 * Scroll down the aggreemnet and check the "I have read" and click on submit
 * Validate flex and total channel count is displayed correctly in Order Confirmation page as per the Copy Deck
 *
 **/

public class RogersCH_TC_050_IginteBundle_TriplePlay_ValidateFlexChannelModel extends BaseTestClass {

    @Test(groups = {"RegressionCH","New"})
    public void checkBuyIgniteTVOffer3pValidateChannels() {
		reporter.reportLogWithScreenshot("Launched the Easy Login Page");
    	getRogersHomePage().clkTVBundle();
        reporter.hardAssert(getRogersHomePage().verifyIgnitepage(),"Ignite page has Launched","Ignite page has not Launched");
       	reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	getRogersHomePage().clkServiceability();
    	reporter.reportLogWithScreenshot("Launched the customer availability check popup");
    	//getRogersHomePage().clkAddressCheck();
    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
        getRogersIgniteTVBuyPage().clkHomephone();

        reporter.softAssert(getRogersIgniteTVBuyPage().verifyChannelAtRateCard(),"Total channels are verified","Total channel verification Failed");
        reporter.reportLogWithScreenshot("Rate card page");
        reporter.softAssert(getRogersIgniteTVBuyPage().verifyFlexChannelAtRateCard(),"Flex channels are verified","Flex channel verification Failed");

        getRogersIgniteTVBuyPage().selectSolarisPremier();
        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage() ,"Port-InOut page has Launched","Port-InOut page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersIgniteTVBuyPage().clkHomePhone();

        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is available","4KTV radio button is not available");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyTotalChannelCount(TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getTotalChannelsCount()),"Total Channels Count verified","Total Channels Count verification failed");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyFlexChannelCount(TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getFlexChannelsCount()),"Flex Channels Count verified","Flex Channels Count verification failed");
        getRogersIgniteTVBuyPage().clkViewTotalChannels();
        reporter.reportLogWithScreenshot("View Total Channels");
        getRogersIgniteTVBuyPage().clkHover4kChannels();
        reporter.reportLogWithScreenshot("what are flex channels Hover message ");
        getRogersIgniteTVBuyPage().clkHoverClose();

        getRogersIgniteTVBuyPage().clkViewFlexChannels();
        reporter.reportLogWithScreenshot("View Flex Channels");
        getRogersIgniteTVBuyPage().clkHoverPreSelectedChannels();
        reporter.reportLogWithScreenshot("Pre Selected Channels Hover message");
        getRogersIgniteTVBuyPage().clkHoverClose();

        getRogersIgniteTVBuyPage().set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();
        
        reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().setEmail();
        getRogersIgniteTVProfileCreationPage().setFirstname();
        getRogersIgniteTVProfileCreationPage().setLastName();
        getRogersIgniteTVProfileCreationPage().setPhone();
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
        
        reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evaluation page has Launched","Credit Evaluation page has not Launched");
        reporter.reportLogWithScreenshot("Launched the credit evaluation page");
        getRogersIgniteTVCreditCheckPage().selectDOBYear();
        getRogersIgniteTVCreditCheckPage().selectDOBMonth();
        getRogersIgniteTVCreditCheckPage().selectDOBDay();
        reporter.reportLogWithScreenshot("Entered DOB details");
        getRogersIgniteTVCreditCheckPage().selectFirstID("Driver's License");
        getRogersIgniteTVCreditCheckPage().selectProvince("Ontario");
        getRogersIgniteTVCreditCheckPage().selectExpiryYear();
        getRogersIgniteTVCreditCheckPage().selectExpiryMonth();
        getRogersIgniteTVCreditCheckPage().selectExpiryDay();
        getRogersIgniteTVCreditCheckPage().setDrivingLicenseNumber("ON");
        reporter.reportLogWithScreenshot("Driving License Details");
        getRogersIgniteTVCreditCheckPage().selectSecondIDOption("Passport");
        getRogersIgniteTVCreditCheckPage().setPassportNumber();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryYear();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryMonth();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryDay();
        getRogersIgniteTVCreditCheckPage().clkCreditConsent();
        reporter.reportLogWithScreenshot("Passport Details");
       getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();

        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPhoneNumberPage(),"Ignite page has Launched","Ignite page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhoneSelectionPage().clkPhoneNumberGenerator();
        getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();

       reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
       reporter.reportLogWithScreenshot("Launched the tech install page");
       //getRogersTechInstallPage().clkPersonalizedInstall();
       getRogersTechInstallPage().selSelffinstallDateAndTime();
       reporter.reportLogWithScreenshot("Launched the tech install page");
       getRogersTechInstallPage().setMobielNumber();
       getRogersTechInstallPage().clkTechInstalConsent();
       reporter.reportLogWithScreenshot("tech install details");
       getRogersTechInstallPage().clkTechInstallContinue();
       
        reporter.hardAssert( getRogersPaymentOptionsPage().verifyPaymentModepage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
        reporter.reportLogWithScreenshot("Launched the payment options page");
        getRogersPaymentOptionsPage().selectPaymentMode("Pre-authorized Credit Card");
        getRogersPaymentOptionsPage().switchToCreditCardIFrame();
        getRogersPaymentOptionsPage().setCreditCardNumberIFrame(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
        getRogersPaymentOptionsPage().switchOutOfCreditCardIFrame();
        getRogersPaymentOptionsPage().setCVV();
        getRogersPaymentOptionsPage().selectExpiryMonth();
        getRogersPaymentOptionsPage().selectExpiryYear(); 
        reporter.reportLogWithScreenshot("Payment options Details");
        getRogersPaymentOptionsPage().clkPaymentConfirm();
       
        reporter.hardAssert( getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");      
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
    }
    
   /*@Test
    public void checkBuyDigitalTVOfferLearn() {
		reporter.reportLogWithScreenshot("Launched the Easy Login Page");
		getRogersHomePage().clkEasyLogin();
   	    reporter.reportLogWithScreenshot("Launched the Home Page");
     	getRogersHomePage().clkShop();
   	    reporter.reportLogWithScreenshot("clicked shop menu from navigation bar to select the IgniteTV");
   	    getRogersHomePage().clkIgniteTV();
   	
        reporter.hardAssert(getRogersHomePage().verifyIgnitepage(),"Ignite page has Launched","Ignite page has not Launched");
      	reporter.reportLogWithScreenshot("Launched the IgniteTV page");  
    	getDriver().get(TestDataHandler.rogersConfig.getRogersURL()+"/web/consumer/ignite-bundles/learn");
    	getRogersHomePage().clkServiceability();

    	reporter.reportLogWithScreenshot("Launched the customer availability check popup");
    	getRogersIgniteTVBuyPage().selectSolarisStarterPackageServiceability();
    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookupLearn(strAddressLine1+", "+strAddressLine2+", CANADA");
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        getRogersIgniteTVBuyPage().selectSolarisStarterPackageNew();
        
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyOptNewPhone(),"4KTV radio button is available","4KTV radio button is not available");
        reporter.reportLogWithScreenshot("Launched the port-in popup");
        getRogersIgniteTVBuyPage().selectOptNewPhone();
        getRogersIgniteTVBuyPage().clickOptPhone();
        getRogersIgniteTVBuyPage().verifyHomePhone();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersIgniteTVBuyPage().clkHomePhone();
        
        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is available","4KTV radio button is not available");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();
        
        reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().setEmail();
        getRogersIgniteTVProfileCreationPage().setFirstname();
        getRogersIgniteTVProfileCreationPage().setLastName();
        getRogersIgniteTVProfileCreationPage().setPhone();
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
        
        reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evaluation page has Launched","Credit Evaluation page has not Launched");
        reporter.reportLogWithScreenshot("Launched the credit evaluation page");
        getRogersIgniteTVCreditCheckPage().selectDOBYear();
        getRogersIgniteTVCreditCheckPage().selectDOBMonth();
        getRogersIgniteTVCreditCheckPage().selectDOBDay();
        reporter.reportLogWithScreenshot("Entered DOB details");
        getRogersIgniteTVCreditCheckPage().selectFirstID("Driver's License");
        getRogersIgniteTVCreditCheckPage().selectProvince("Ontario");
        getRogersIgniteTVCreditCheckPage().selectExpiryYear();
        getRogersIgniteTVCreditCheckPage().selectExpiryMonth();
        getRogersIgniteTVCreditCheckPage().selectExpiryDay();
        getRogersIgniteTVCreditCheckPage().setDrivingLicenseNumber("ONTARIO");
        reporter.reportLogWithScreenshot("Driving License Details");
        getRogersIgniteTVCreditCheckPage().selectSecondIDOption("Passport");
        getRogersIgniteTVCreditCheckPage().setPassportNumber();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryYear();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryMonth();
        getRogersIgniteTVCreditCheckPage().selectPassportExpiryDay();
        getRogersIgniteTVCreditCheckPage().clkCreditConsent();
        reporter.reportLogWithScreenshot("Passport Details");
       getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
       
      reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPhoneNumberPage(),"Ignite page has Launched","Ignite page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhoneSelectionPage().clkPhoneNumberGenerator();
        getRogersHomePhoneSelectionPage().clkChosePhoneNumber();
        getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();
       
       reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
       reporter.reportLogWithScreenshot("Launched the tech install page");
       getRogersTechInstallPage().selSelffinstallDateAndTime();
       reporter.reportLogWithScreenshot("Launched the tech install page");
       getRogersTechInstallPage().clkTechInstallSlot();
       reporter.reportLogWithScreenshot("tech install details");
       getRogersTechInstallPage().setMobielNumber();
       getRogersTechInstallPage().setEmail();
       getRogersTechInstallPage().clkTechInstalConsent();
       reporter.reportLogWithScreenshot("tech install details");
       getRogersTechInstallPage().clkTechInstallContinue();
       
        reporter.hardAssert( getRogersPaymentOptionsPage().verifyPaymentModepage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
        reporter.reportLogWithScreenshot("Launched the payment options page");
        getRogersPaymentOptionsPage().selectPaymentMode("Pre-authorized Credit Card");
        getRogersPaymentOptionsPage().switchToCreditCardIFrame();
        getRogersPaymentOptionsPage().setCreditCardNumberIFrame(TestDataHandler.chPaymentInfo.getCreditCardDetails().getNumber());
        getRogersPaymentOptionsPage().switchOutOfCreditCardIFrame();
        getRogersPaymentOptionsPage().setCVV();
        getRogersPaymentOptionsPage().selectExpiryMonth();
        getRogersPaymentOptionsPage().selectExpiryYear(); 
        reporter.reportLogWithScreenshot("Payment options Details");
        getRogersPaymentOptionsPage().clkPaymentConfirm();
       
        reporter.hardAssert( getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");      
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
    }*/

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_igniteanonymous, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


