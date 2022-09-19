package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class RogersCH_Auto_TC032_SolarisTVCx_HAWTFlowPortInWithExistingBundleOfferTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersCustomerIgniteBuyCH"})
    public void rogersCH_Auto_TC032_SolarisTVCx_HAWTFlowPortInWithExistingBundleOffer() {
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
   		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc32_SolarisPortinFlows.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc32_SolarisPortinFlows.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();

	//	reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
     //   getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc32_SolarisPortinFlows.accountDetails.getBan());
		reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersHomePage().clkShop();
        reporter.reportLogWithScreenshot("clicked shop menu from navigation bar to select the IgniteTV");

       // getRogersHomePage().clkIgniteTVExistingCustomer();
        getDriver().get(System.getProperty("QaUrl")+"home/ignite-bundles/tv-internet");
        reporter.reportLogWithScreenshot("Launched the IgniteTV page");
        getRogersHomePage().clkNoThnx();
        getRogersHomePage().clkServiceability();

      /*  getRogersIgniteTVBuyPage().clkHomephone();
        reporter.reportLogWithScreenshot("Clicked Home Phone");
        getRogersIgniteTVBuyPage().selectFlex20Package();
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");*/

        String  strAddressLine1=TestDataHandler.tc32_SolarisPortinFlows.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc32_SolarisPortinFlows.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
        reporter.reportLogWithScreenshot("Entered Serviceability address");
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the Bundles page");
        getRogersIgniteTVBuyPage().clkHomephone();
        reporter.reportLogWithScreenshot("Clicked Home Phone");
        getRogersIgniteTVBuyPage().selectFlex20PackageMonthToMonthTypeOfContract();
        reporter.reportLogWithScreenshot("Selected Month-to-month type of contract");
        getRogersIgniteTVBuyPage().selectFlex20Package();
        reporter.reportLogWithScreenshot("Added to cart");

        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage() ,"Port-InOut page has Launched","Port-InOut page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhonePortInPage().setHomePhoneNumber(TestDataHandler.tc32_SolarisPortinFlows.getAccountDetails().getPhoneNumber());
        reporter.reportLogWithScreenshot("Phone number eligibility test");
        getRogersHomePhonePortInPage().clkPhoneNumberEligibiltyCheck();
        
        reporter.hardAssert(getRogersHomePhonePortInPage().verifyPhoneNumberSuccess(),"Port-in Number validation success","Port-in Number validation Failed");
        reporter.reportLogWithScreenshot("Port-in Number validation success");
        getRogersHomePhonePortInPage().setFirstName();
        getRogersHomePhonePortInPage().setLastName();
        getRogersHomePhonePortInPage().setInvoiceAddress(strAddressLine1+", "+strAddressLine2+", CANADA");
        getRogersHomePhonePortInPage().setCurrentPhoneNumber();
        reporter.reportLogWithScreenshot("Port-in details set");
        getRogersHomePhonePortInPage().selIMEI();
        getRogersHomePhonePortInPage().setAccountNumberOrIMEI(TestDataHandler.tc32_SolarisPortinFlows.getAccountDetails().getImei()) ;

        getRogersIgniteTVBuyPage().clkHomePhoneAddOn();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");

        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyHomePhoneAddOnPage(), "Launched the Home phone add-on page", "Home phone add-on page has not launched");
        getRogersIgniteTVBuyPage().clkHomePhone();
        
        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is availabe","4KTV radio button is not availabe");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();
        reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(),"Launched the create profile page", "Profile page hasn't  Launched");
        reporter.reportLogWithScreenshot("Launched the profile page");
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
        //reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(),"Launched the credit evalution page","Credit evalution page hasn't  Launched");
        
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
        //getRogersIgniteTVCreditCheckPage().selectDOBYearExistingCustomerMigration(TestDataHandler.tc39_40_SolarisPortinFlows.getAccountDetails().getYear());
        //getRogersIgniteTVCreditCheckPage().selectDOBMonthExistingCustomerMigration(TestDataHandler.tc39_40_SolarisPortinFlows.getAccountDetails().getMonth());
        //getRogersIgniteTVCreditCheckPage().selectDOBDayExistingCustomerMigration(TestDataHandler.tc39_40_SolarisPortinFlows.getAccountDetails().getDate());
        //reporter.reportLogWithScreenshot("Entered the DOB details");

        //getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
        
        reporter.reportLogWithScreenshot("Home Phone selection page has launched");
        getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();

        reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Launched the tech install page");
        getRogersTechInstallPage().selTechInstalStartDate();
        reporter.reportLogWithScreenshot("Selected Start date for Installation slot");
        getRogersTechInstallPage().selectPreferredTimeSlot();
        reporter.reportLogWithScreenshot("Selected Start date for Installation slot");
        getRogersTechInstallPage().selTechInstalEndDate();
        reporter.reportLogWithScreenshot("Selected End date for Installation");
        getRogersTechInstallPage().selectBackupTimeSlot();
        reporter.reportLogWithScreenshot("Selected End date for Installation slot");
        getRogersTechInstallPage().setContactNumber();
        getRogersTechInstallPage().setMobielNumber();
        reporter.reportLogWithScreenshot("tech install details");
        getRogersTechInstallPage().clkTechInstalConsent();
        getRogersTechInstallPage().clkTechInstallContinue();
        reporter.reportLogWithScreenshot("Launched the payment options page");

        //reporter.hardAssert(getRogersPaymentOptionsPage().verifyPaymentModepage(),"Launched the payment options page","Payment options page has not Launched");
       // getRogersPaymentOptionsPage().clkPaymentConfirm();
    	reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");
		
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Order has created successfully","Order has failed");
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
     }

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_ignitelogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}


