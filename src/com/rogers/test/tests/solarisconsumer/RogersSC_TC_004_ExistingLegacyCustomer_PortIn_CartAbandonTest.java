package com.rogers.test.tests.solarisconsumer;

import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * This class contains the test method to verify the cart abandon flow with port-In option for existing legacy customer on Rogers.com  
 * @author Saurav.Goyal
 **/

public class RogersSC_TC_004_ExistingLegacyCustomer_PortIn_CartAbandonTest extends BaseTestClass {

	@Test
	public void checkCartAbandonPortinExistingLegacySignedinfromMyRogersTest() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setUsernameIFrame(TestDataHandler.solarisConsumerPortInCartAbandon.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisConsumerPortInCartAbandon.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		rogers_account_overview_page.selectAccount(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getBan());
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed"); 
		rogers_home_page.clkShop(); 
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		rogers_home_page.clkIgniteTV();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		rogers_home_page.clkServiceability();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		rogers_home_page.clkUseThisAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		rogers_igniteTV_buy_page.selectSolarisStarterPackageNew();
		rogers_igniteTV_buy_page.verifyImportantInformation();
		rogers_igniteTV_buy_page.clkIUnderstand();
		reporter.reportLogWithScreenshot("Launched the port-in popup");
		rogers_igniteTV_buy_page.clkRadioOptKeepMyExistingPhoneNumber();
		rogers_igniteTV_buy_page.clickOptPhone();
		reporter.reportLogWithScreenshot("Port-In Screen launched");
		rogers_home_phone_port_in_page.setHomePhoneNumber(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getPhoneNumber());
		rogers_home_phone_port_in_page.clkPhoneNumberEligibiltyCheck();
		rogers_home_phone_port_in_page.verifyPhoneNumberSuccess();
		reporter.reportLogWithScreenshot("Port-in Number validation success");
		rogers_home_phone_port_in_page.setFirstName();
		rogers_home_phone_port_in_page.setLastName();
		String  strAddressLine1=(String) TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getAddress().get("line1");
		String  strAddressLine2=(String) TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getAddress().get("line2");
		rogers_home_phone_port_in_page.setInvoiceAddress(strAddressLine1+", "+strAddressLine2+", CANADA");
		rogers_home_phone_port_in_page.setCurrentPhoneNumber();
		rogers_home_phone_port_in_page.setAccountNumberOrIMEI(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getImeiNumber());
		reporter.reportLogWithScreenshot("Port-in details set");
		rogers_home_phone_port_in_page.clkPhoneCheck();
		reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
		rogers_igniteTV_buy_page.clkHomePhone();
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		rogers_igniteTV_buy_page.set4KTV(); 
		rogers_igniteTV_buy_page.clkCheckout();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		rogers_igniteTV_profile_creation_page.clkSubmitProfile();   
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		rogers_igniteTV_credit_check_page.verifyCreditEvalutionPage();
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		rogers_home_page.clkMyRogers(); 
		reporter.reportLogWithScreenshot("Launched the Cart Abandonment Form popup");
		rogers_igniteTV_credit_check_page.verifyCartAbandonmentForm();
		rogers_igniteTV_credit_check_page.clkCartAbandonmentForm();
		reporter.reportLogWithScreenshot("Launched the Email sent success popup");
		rogers_igniteTV_credit_check_page.verifyCartEmailSuccess();
		rogers_igniteTV_credit_check_page.clkCartEmailSuccess();
		reporter.reportLogWithScreenshot("Signout account");
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		rogers_login_page.setPasswordIFrame(TestDataHandler.solarisConsumerPortInCartAbandon.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		rogers_login_page.clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		rogers_account_overview_page.selectAccount(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getBan());
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed"); 
		rogers_home_page.clkShop(); 
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		rogers_home_page.clkIgniteTV();
		reporter.reportLogWithScreenshot("Launched the Welcome back popup");
		rogers_home_page.clkWelcomeback();     
		reporter.reportLogWithScreenshot("Launched the Port-in page");
		rogers_home_phone_port_in_page.setHomePhoneNumber(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getPhoneNumber());
		rogers_home_phone_port_in_page.clkPhoneNumberEligibiltyCheck();
		rogers_home_phone_port_in_page.verifyPhoneNumberSuccess();
		rogers_home_phone_port_in_page.clkPhoneCheck();
		reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
		rogers_igniteTV_buy_page.clkHomePhone();
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		rogers_igniteTV_buy_page.set4KTV(); 
		rogers_igniteTV_buy_page.clkCheckout();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		rogers_igniteTV_profile_creation_page.clkSubmitProfile();   
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		rogers_igniteTV_credit_check_page.verifyCreditEvalutionPage(); 
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		rogers_igniteTV_credit_check_page.selectDOBYearExistingCustomer(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getYear());
		rogers_igniteTV_credit_check_page.selectDOBMonthExistingCustomer(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getMonth());
		rogers_igniteTV_credit_check_page.selectDOBDayExistingCustomer(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getDate());
		reporter.reportLogWithScreenshot("Entered the DOB details");
		rogers_igniteTV_credit_check_page.clkCreditConsentSubmit();
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		rogers_home_phone_selection_page.clkContinueHomePhoneSelection();  
		reporter.reportLogWithScreenshot("Launched the tech install page");
		rogers_tech_install_page.selTechInstalStartDate();
		rogers_tech_install_page.selTechInstalEndDate();
		rogers_tech_install_page.setEmail();
		rogers_tech_install_page.clkTechInstallContinue();
		reporter.reportLogWithScreenshot("Launched the payment options page");
		rogers_payment_options_page.clkPaymentConfirmExistingCustomer();
		rogers_order_review_page.verifyAgreementPage();
		reporter.reportLogWithScreenshot("Launched the order review page");
		rogers_order_review_page.verifyAgreement();
		rogers_order_review_page.clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		rogers_order_review_page.clkSubmit();
		reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Order has created successfully","Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	//IgniteLogin
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.rogersConfig.getRogersURL(),  strBrowser,strLanguage,strGroupName, method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}