package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * This class contains the test method to test the IgniteTV buy flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:`
 * Launch Rogers.com url
 * Click on Ignite Tv under shop menu
 * Click on check Availability button
 * Enter valid serviceable address in serviceability check pop up and click on Check availablity button
 * In the bundles page
     1.Validate the Rate card
     2.Validate it displayes the respective bundle flex channel count
     3.Click on "more details" of the bundle and validate the content as per copydeck
 * Click on see all channels
 * In the see all channel page
    1.Validate all the contents are displayed as per copydeck
    2.Validate Hover text are displayed as per copydeck for "what are flex channels" and "How do I see 4K content"
 * Click on see flex channels
 * In the see flex channels
   1.validate Default flex channel and flex channel pool are displayed
   3.Validate all the contents and hover text are displayed as per copydeck
 * Choose any bundle and click on add to cart
 * Validate cart summary page is displayed as per copydeck and Select 4K option and click on Continue
 * Fill in appropriate data in all of the fields in profile page and click on Continue
 * Fill in appropriate data in all of the fields in Credit Check page and click on Continue
 * Select appropriate option in Installation page and click on Continue
 * Select appropriate option in payment page and click on Continue
 * Validate the review order page and Scroll down the aggreemnet and check the "I have read" and click on submit
 * Validate confirmation page displayed as per copydeck
 *
 **/

public class RogersCH_Auto_TC038_2PNAC_ValidateFlexChannelModel_ATLTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersIgniteBuyAnonymousCH"})
    public void rogersCH_Auto_TC038_2PNAC_ValidateFlexChannelModel_ATL() {
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
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
        reporter.softAssert(getRogersIgniteTVBuyPage().verifyChannelAtRateCard(),"Total channels are verified","Total channel verification Failed");
        reporter.reportLogWithScreenshot("Rate card page");
        reporter.softAssert(getRogersIgniteTVBuyPage().verifyFlexChannelAtRateCard(),"Flex channels are verified","Flex channel verification Failed");

        getRogersIgniteTVBuyPage().selectSolarisPremier();
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
        
        reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evalution page has Launched","Credit Evalution page has not Launched");
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
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

       reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
       reporter.reportLogWithScreenshot("Launched the tech install page");
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
        String ban = getRogersOrderConfirmationPage().getBAN();
        System.out.println("BAN from the portal : " + ban);
         Map<Object, Object> dblists = getDbConnection().connectionMethod(System.getProperty("DbEnvUrl"))
                .executeDBQuery("select BAN,ACCOUNT_SUB_TYPE,SYS_CREATION_DATE from billing_account where BAN='" + ban + "'", false);

        reporter.softAssert(dblists.get("BAN").equals(ban),"Entry is updated in the billing table","BAN is not present in the billing account table");
        reporter.softAssert(dblists.get("ACCOUNT_SUB_TYPE").equals("R"),"ACCOUNT_SUB_TYPE is verified as R","Account type is not updated as R");
    }

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_igniteanonymous, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


