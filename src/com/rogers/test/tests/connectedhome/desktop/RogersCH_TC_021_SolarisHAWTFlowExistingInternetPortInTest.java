package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class RogersCH_TC_021_SolarisHAWTFlowExistingInternetPortInTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersCableBuyCH"})
    public void checkBuyIginteTVOfferPortIn() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
   		rogers_login_page.setUsernameIFrame(TestDataHandler.solarisPortinFlows.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisPortinFlows.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	    reporter.reportLogWithScreenshot("Skip popup");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
	    rogers_account_overview_page.selectAccount(TestDataHandler.solarisPortinFlows.accountDetails.getBan());
		//reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_home_page.clkShop(); 
        reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
        rogers_home_page.clkIgniteTVExistingCustomer();
	    	reporter.reportLogWithScreenshot("Launched the IgniteTV page");
	    	rogers_home_page.clkNoThnx();
	    	rogers_home_page.clkServiceability();
	    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");    	
	        rogers_home_page.clkUseThisAddress();        
    	reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
    	String  strAddressLine1=(String) TestDataHandler.solarisPortinFlows.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=(String) TestDataHandler.solarisPortinFlows.getAccountDetails().getAddress().get("line2");
/*       rogers_home_page.setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
        rogers_home_page.clkIgniteAddressLookupSubmit();*/
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        rogers_igniteTV_buy_page.selectSolarisStarterPackageNew();
        reporter.reportLogWithScreenshot("Launched the port-in popup");
        rogers_igniteTV_buy_page.clkKeepMyNumber();
        rogers_igniteTV_buy_page.clickOptPhone();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        rogers_home_phone_port_in_page.setHomePhoneNumber(TestDataHandler.solarisPortinFlows.getAccountDetails().getPhoneNumber());
        rogers_home_phone_port_in_page.clkPhoneNumberEligibiltyCheck();
        
        reporter.hardAssert(rogers_home_phone_port_in_page.verifyPhoneNumberSuccess(),"Port-in Number validation success","Port-in Number validation Failed");
        reporter.reportLogWithScreenshot("Port-in Number validation success");
        rogers_home_phone_port_in_page.setFirstName();
        rogers_home_phone_port_in_page.setLastName();
        rogers_home_phone_port_in_page.setInvoiceAddress(strAddressLine1+", "+strAddressLine2+", CANADA");
        rogers_home_phone_port_in_page.setCurrentPhoneNumber(); 
        reporter.reportLogWithScreenshot("Port-in details set");
        rogers_home_phone_port_in_page.selIMEI();
        rogers_home_phone_port_in_page.setAccountNumberOrIMEI("352912110031531") ;
        rogers_home_phone_port_in_page.clkPhoneCheck();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        rogers_igniteTV_buy_page.clkHomePhone();
        
        reporter.hardAssert(rogers_igniteTV_buy_page.verify4KTV(),"4KTV radio button is availabe","4KTV radio button is not availabe");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        rogers_igniteTV_buy_page.set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        rogers_igniteTV_buy_page.clkCheckout();
        reporter.reportLogWithScreenshot("Launched the profile page");
        rogers_igniteTV_profile_creation_page.clkSubmitProfile();  
        
        
        reporter.reportLogWithScreenshot("Launched the credit evalution page");
        rogers_igniteTV_credit_check_page.selectDOBYearExistingCustomerMigration(TestDataHandler.digitalTVUpgradeToIgnite.getAccountDetails().getYear());
        rogers_igniteTV_credit_check_page.selectDOBMonthExistingCustomerMigration(TestDataHandler.digitalTVUpgradeToIgnite.getAccountDetails().getMonth());
        rogers_igniteTV_credit_check_page.selectDOBDayExistingCustomerMigration(TestDataHandler.digitalTVUpgradeToIgnite.getAccountDetails().getDate());
        reporter.reportLogWithScreenshot("Entered the DOB details");
        rogers_igniteTV_credit_check_page.clkCreditConsentSubmit();
        
        reporter.reportLogWithScreenshot("Home Phone selection page has launched");
        rogers_home_phone_selection_page.clkContinueHomePhoneSelection();  

        reporter.hardAssert(rogers_tech_install_page.verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
        reporter.reportLogWithScreenshot("Launched the tech install page");
        rogers_tech_install_page.selTechInstalStartDate();
        reporter.reportLogWithScreenshot("Selected Start date for Installation slot");
        rogers_tech_install_page.selTechInstalEndDate();
        reporter.reportLogWithScreenshot("Selected End date for Installation slot");
        rogers_tech_install_page.setEmail(); 
        reporter.reportLogWithScreenshot("tech install details");
        rogers_tech_install_page.clkTechInstallContinue();
    	reporter.hardAssert(rogers_order_review_page.verifyAgreementPage(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");
		
		reporter.hardAssert(rogers_order_review_page.verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
        
        rogers_order_review_page.clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        rogers_order_review_page.clkSubmit();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Order has created successfully","Order has failed");       
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
    	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
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


