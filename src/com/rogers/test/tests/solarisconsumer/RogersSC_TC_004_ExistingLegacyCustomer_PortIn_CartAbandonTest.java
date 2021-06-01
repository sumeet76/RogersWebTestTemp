package com.rogers.test.tests.solarisconsumer;

import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;              
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;

/**
 * This class contains the test method to verify the cart abandon flow with port-In option for existing legacy customer on Rogers.com  
 * @author Saurav.Goyal
 **/

public class RogersSC_TC_004_ExistingLegacyCustomer_PortIn_CartAbandonTest extends BaseTestClass {

	@Test
	public void checkCartAbandonPortinExistingLegacySignedinfromMyRogersTest() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.solarisConsumerPortInCartAbandon.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.solarisConsumerPortInCartAbandon.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getBan());
		reporter.softAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Login Success","Login Failed"); 
		getRogersHomePage().clkShop(); 
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		getRogersHomePage().clkIgniteTV();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		getRogersHomePage().clkServiceability();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		getRogersHomePage().clkUseThisAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		getRogersIgniteTVBuyPage().selectSolarisStarterPackage();
		getRogersIgniteTVBuyPage().verifyImportantInformation();
		getRogersIgniteTVBuyPage().clkIUnderstand();
		reporter.reportLogWithScreenshot("Launched the port-in popup");
		getRogersIgniteTVBuyPage().clkRadioOptKeepMyExistingPhoneNumber();
		getRogersIgniteTVBuyPage().clickOptPhone();
		reporter.reportLogWithScreenshot("Port-In Screen launched");
		getRogersHomePhonePortInPage().setHomePhoneNumber(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getPhoneNumber());
		getRogersHomePhonePortInPage().clkPhoneNumberEligibiltyCheck();
		getRogersHomePhonePortInPage().verifyPhoneNumberSuccess();
		reporter.reportLogWithScreenshot("Port-in Number validation success");
		getRogersHomePhonePortInPage().setFirstName();
		getRogersHomePhonePortInPage().setLastName();
		String  strAddressLine1=TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getAddress().get("line1");
		String  strAddressLine2=TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getAddress().get("line2");
		getRogersHomePhonePortInPage().setInvoiceAddress(strAddressLine1+", "+strAddressLine2+", CANADA");
		getRogersHomePhonePortInPage().setCurrentPhoneNumber();
		getRogersHomePhonePortInPage().setAccountNumberOrIMEI(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getImeiNumber());
		reporter.reportLogWithScreenshot("Port-in details set");
		getRogersHomePhonePortInPage().clkPhoneCheck();
		reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
		getRogersIgniteTVBuyPage().clkHomePhone();
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().set4KTV();
		getRogersIgniteTVBuyPage().clkCheckout();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage();
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		getRogersHomePage().clkMyRogers(); 
		reporter.reportLogWithScreenshot("Launched the Cart Abandonment Form popup");
		getRogersIgniteTVCreditCheckPage().verifyCartAbandonmentForm();
		getRogersIgniteTVCreditCheckPage().clkCartAbandonmentForm();
		reporter.reportLogWithScreenshot("Launched the Email sent success popup");
		getRogersIgniteTVCreditCheckPage().verifyCartEmailSuccess();
		getRogersIgniteTVCreditCheckPage().clkCartEmailSuccess();
		reporter.reportLogWithScreenshot("Signout account");
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.solarisConsumerPortInCartAbandon.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getBan());
		reporter.softAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Login Success","Login Failed"); 
		getRogersHomePage().clkShop(); 
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		getRogersHomePage().clkIgniteTV();
		reporter.reportLogWithScreenshot("Launched the Welcome back popup");
		getRogersHomePage().clkWelcomeback();     
		reporter.reportLogWithScreenshot("Launched the Port-in page");
		getRogersHomePhonePortInPage().setHomePhoneNumber(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getPhoneNumber());
		getRogersHomePhonePortInPage().clkPhoneNumberEligibiltyCheck();
		getRogersHomePhonePortInPage().verifyPhoneNumberSuccess();
		getRogersHomePhonePortInPage().clkPhoneCheck();
		reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
		getRogersIgniteTVBuyPage().clkHomePhone();
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().set4KTV();
		getRogersIgniteTVBuyPage().clkCheckout();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage();
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		getRogersIgniteTVCreditCheckPage().selectDOBYearExistingCustomer(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getYear());
		getRogersIgniteTVCreditCheckPage().selectDOBMonthExistingCustomer(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getMonth());
		getRogersIgniteTVCreditCheckPage().selectDOBDayExistingCustomer(TestDataHandler.solarisConsumerPortInCartAbandon.getAccountDetails().getDate());
		reporter.reportLogWithScreenshot("Entered the DOB details");
		getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();
		reporter.reportLogWithScreenshot("Launched the tech install page");
		getRogersTechInstallPage().selTechInstalStartDate();
		getRogersTechInstallPage().selTechInstalEndDate();
		getRogersTechInstallPage().setEmail();
		getRogersTechInstallPage().clkTechInstallContinue();
		reporter.reportLogWithScreenshot("Launched the payment options page");
		getRogersPaymentOptionsPage().clkPaymentConfirmExistingCustomer();
		getRogersOrderReviewPage().verifyAgreementPage();
		reporter.reportLogWithScreenshot("Launched the order review page");
		getRogersOrderReviewPage().verifyAgreement();
		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Order has created successfully","Order has failed");
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
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