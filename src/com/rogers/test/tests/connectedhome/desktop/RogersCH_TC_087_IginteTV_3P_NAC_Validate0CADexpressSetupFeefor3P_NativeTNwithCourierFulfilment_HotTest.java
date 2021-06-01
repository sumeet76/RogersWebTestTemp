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
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Browse to Shop menu and select Ignite TV option
 *3. Scroll down to Ignite TV bundlessection and select one of available Bundle, click Add to Cart
 *4. Enter home address to validate the serviceability and click on Check Availability
 *5. Click on Continue
 *6. Click "No thanks Continue"
 *7. Click on Continue in Home phone add ons page
 *8. Select one option for   'Do you have a 4K TV'
 *9. Click checkout button on cart summary page.
 *10. Enter all personal information on user profile creation page - 1) Profile step
 *11. Click on Continue
 *12. In 2) Credit Evaluation page, enter the required info on Credit Check:
 *13. Click Submit
 *14. Enter 1 or 2 numbers in Choose a phone Number textbox and click on Generate numbers
 *15. Select any one phone number
 *16. Make sure Caller ID and Directory listing fields are populated
 *17. Click on Continue
 *18. Validate minicart
 *19. Select a time in Choose your Date and Time 
 *20. Enter any valid Mobile number and email address
 *21. Click on Confirm
 *22. Select Pre-Authorized credit card option from type of payment dropdown
 *23. Enter valid Credit Card number details in Credit Card related fields
 *24. Click on Continue
 *25. Validate appropriate information is displayed in Review order page
 *26. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox
 *27. Click on Submit
 *
 **/

public class RogersCH_TC_087_IginteTV_3P_NAC_Validate0CADexpressSetupFeefor3P_NativeTNwithCourierFulfilment_HotTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersIgniteBuyAnonymousCH","DryRunCH"})
	    public void checkBuy3PValidate0CADexpressSetupFeefor3PNativeTNwithCourierFulfilmentHot() {
    	reporter.reportLogWithScreenshot("Launched the Easy Login Page");
    	getRogersHomePage().clkTVBundle();
    	reporter.hardAssert(getRogersHomePage().verifyIgnitepage(),"Ignite page has Launched","Ignite page has not Launched");
    	reporter.reportLogWithScreenshot("Launched the IgniteTV page");
    	getRogersHomePage().clkServiceability();
    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
    	String  strAddressLine1=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line1");
    	String  strAddressLine2=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line2");
    	getRogersHomePage().setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
    	getRogersHomePage().clkIgniteAddressLookupSubmit();
		//Validate cableCondition="Hot" from addressServices call, will be adding with selenium4
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
		getRogersIgniteTVBuyPage().clkHomephone();
		getRogersIgniteTVBuyPage().selectSolarisStarterPackage();

		reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage() ,"Port-InOut page has Launched","Port-InOut page has not Launched");
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		getRogersIgniteTVBuyPage().clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Launched the mini cart Chevron");
		getRogersIgniteTVBuyPage().clkChevronUpYourCart();
		getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
		getRogersIgniteTVBuyPage().clkHomePhone();
	        
		reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is availabe","4KTV radio button is not availabe");
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Launched the mini cart Chevron");
		getRogersIgniteTVBuyPage().clkChevronUpYourCart();
		getRogersIgniteTVBuyPage().set4KTV();
		reporter.reportLogWithScreenshot("4k TV selected");
		getRogersIgniteTVBuyPage().clkCheckout();
	        
	    reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
	    reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersIgniteTVBuyPage().clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Launched the mini cart Chevron");
		getRogersIgniteTVBuyPage().clkChevronUpYourCart();
	    getRogersIgniteTVProfileCreationPage().setEmail();
	    getRogersIgniteTVProfileCreationPage().setFirstname();
	    getRogersIgniteTVProfileCreationPage().setLastName();
	    getRogersIgniteTVProfileCreationPage().setPhone();
	    getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
	        
	    reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evalution page has Launched","Credit Evalution page has not Launched");
	    reporter.reportLogWithScreenshot("Launched the credit evalution page");
		getRogersIgniteTVBuyPage().clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Launched the mini cart Chevron");
		getRogersIgniteTVBuyPage().clkChevronUpYourCart();
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
		getRogersIgniteTVBuyPage().clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Launched the mini cart Chevron");
		getRogersIgniteTVBuyPage().clkChevronUpYourCart();
	    getRogersHomePhoneSelectionPage().clkPhoneNumberGenerator();
	    getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();
	       
	    reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
	    reporter.reportLogWithScreenshot("Launched the tech install page");
		getRogersIgniteTVBuyPage().clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Launched the mini cart Chevron");
		getRogersIgniteTVBuyPage().clkChevronUpYourCart();
		reporter.hardAssert(getRogersTechInstallPage().verifyIgniteExpressSetup(),"Ignite Express Setup is present","Ignite Express Setup is not present");
		reporter.hardAssert(getRogersTechInstallPage().clktxtIgniteExpressSetupCost(),"Ignite Express Setup Cost verified","Ignite Express Setup Cost verification is failed");
	    /*   getRogersTechInstallPage().selSelffinstallDateAndTime();
	       reporter.reportLogWithScreenshot("Launched the tech install page");
	       getRogersTechInstallPage().setMobielNumber();*/
	    getRogersTechInstallPage().clkTechInstalConsent();
	    reporter.reportLogWithScreenshot("tech install details");
	    getRogersTechInstallPage().clkTechInstallContinue();
	       
	    reporter.hardAssert( getRogersPaymentOptionsPage().verifyPaymentModepage(),"Payment Mode page has Launched","Payment Mode page has not Launched");
	    reporter.reportLogWithScreenshot("Launched the payment options page");
		getRogersIgniteTVBuyPage().clkChevronDownYourCart();
		reporter.reportLogWithScreenshot("Launched the mini cart Chevron");
		getRogersIgniteTVBuyPage().clkChevronUpYourCart();
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
			/**
			 * DB Validations in the subscriber table
			 */
		Map<Object, Object> dblists = getDbConnection().connectionMethod(System.getProperty("DbEnvUrl")).executeDBQuery("select BAN,ACCOUNT_SUB_TYPE,SYS_CREATION_DATE from billing_account where BAN='" + ban + "'", false);
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


