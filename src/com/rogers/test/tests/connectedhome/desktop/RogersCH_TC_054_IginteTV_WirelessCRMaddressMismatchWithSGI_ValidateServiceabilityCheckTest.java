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

public class RogersCH_TC_054_IginteTV_WirelessCRMaddressMismatchWithSGI_ValidateServiceabilityCheckTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersIgniteBuyCH"})
    public void checkCRMaddressMismatchWithSGI_ServiceabilityTest() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc38_DigitalTVUpgradeToIgnite.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc38_DigitalTVUpgradeToIgnite.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		reporter.reportLogWithScreenshot("Skip popup");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc38_DigitalTVUpgradeToIgnite.accountDetails.getBan());
		reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersHomePage().clkExistingCustomerShop();
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		getRogersHomePage().clkIgniteTVExistingCustomer();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		getRogersHomePage().clkNoThnx();
		getRogersHomePage().clkServiceability();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		getRogersHomePage().clkUseThisAddress();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		//reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
		getRogersIgniteTVBuyPage().clkHomephone();
		getRogersIgniteTVBuyPage().selectSolarisStarterPackageNew();
		reporter.reportLogWithScreenshot("Launched the information popup");
		getRogersIgniteTVBuyPage().clkIUnderstand();
		reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage() ,"Port-InOut page has Launched","Port-InOut page has not Launched");
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
		reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
		getRogersIgniteTVBuyPage().clkHomePhone();

		reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is available","4KTV radio button is not available");
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().set4KTV();
		reporter.reportLogWithScreenshot("4k TV selected");
		getRogersIgniteTVBuyPage().clkCheckout();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
		reporter.reportLogWithScreenshot("Launched the credit evalution page");
		getRogersIgniteTVCreditCheckPage().selectDOBYearExistingCustomerMigration(TestDataHandler.tc38_DigitalTVUpgradeToIgnite.getAccountDetails().getYear());
		getRogersIgniteTVCreditCheckPage().selectDOBMonthExistingCustomerMigration(TestDataHandler.tc38_DigitalTVUpgradeToIgnite.getAccountDetails().getMonth());
		getRogersIgniteTVCreditCheckPage().selectDOBDayExistingCustomerMigration(TestDataHandler.tc38_DigitalTVUpgradeToIgnite.getAccountDetails().getDate());
		reporter.reportLogWithScreenshot("Entered the DOB details");
		getRogersIgniteTVCreditCheckPage().clkCreditConsentSubmit();
		reporter.reportLogWithScreenshot("Launched the home phone selection page");
		getRogersHomePhoneSelectionPage().clkContinueHomePhoneSelection();

		reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(),"TechInstall page has Launched","TechInstall page has not Launched");
		reporter.reportLogWithScreenshot("Launched the tech install page");
		getRogersTechInstallPage().selTechInstalStartDate();
		reporter.reportLogWithScreenshot("Selected Start date for Installation");
		getRogersTechInstallPage().selectPreferredTimeSlot("1: AFT");
		reporter.reportLogWithScreenshot("Selected Start date for Installation slot");
		getRogersTechInstallPage().selTechInstalEndDate();
		reporter.reportLogWithScreenshot("Selected End date for Installation");
		getRogersTechInstallPage().selectBackupTimeSlot("1: AFT");
		reporter.reportLogWithScreenshot("Selected End date for Installation slot");
		reporter.reportLogWithScreenshot("tech install details");
		getRogersTechInstallPage().setMobielNumber();
		reporter.reportLogWithScreenshot("tech install details");
		getRogersTechInstallPage().clkTechInstalConsent();

		getRogersTechInstallPage().clkTechInstallContinue();
		reporter.reportLogWithScreenshot("Launched the payment options page");

		getRogersPaymentOptionsPage().clkPaymentConfirm();
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
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_ignitelogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


