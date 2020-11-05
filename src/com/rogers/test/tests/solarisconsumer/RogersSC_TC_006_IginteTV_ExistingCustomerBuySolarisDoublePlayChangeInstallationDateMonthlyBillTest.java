package com.rogers.test.tests.solarisconsumer;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the IgniteTV buy flow for Rogers.com   
 * 
 * @author Saurav.Goyal
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

public class RogersSC_TC_006_IginteTV_ExistingCustomerBuySolarisDoublePlayChangeInstallationDateMonthlyBillTest extends BaseTestClass {

	@Test
	public void checkBuyDigitalTVOffer() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc31_SolarisInternetAccountWithUsageAndPackageUpgrade.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc31_SolarisInternetAccountWithUsageAndPackageUpgrade.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.reportLogWithScreenshot("Skip popup");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		reporter.softAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Logged in successfully", "Login failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersHomePage().clkShop(); 
		reporter.reportLogWithScreenshot("clicked shop menu from navigarion bar to selcet the IgniteTV");
		getRogersHomePage().clkIgniteTV();
		getRogersHomePage().verifyIgnitepage();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		getRogersHomePage().clkServiceability();
		reporter.reportLogWithScreenshot("Launched the customer availability check popup");
		String  strAddressLine1=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line1");
		String  strAddressLine2=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line2");
		getRogersHomePage().setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2+", CANADA");
		getRogersHomePage().clkIgniteAddressLookupSubmit();
		//getRogersHomePage().clkContinueIgniteMultipleAddressLookupSubmit();
		reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		getRogersIgniteTVBuyPage().selectSolarisStarterPackageNew();
		reporter.reportLogWithScreenshot("Launched the port-in popup");
		getRogersIgniteTVBuyPage().verify4KTV();
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().set4KTV();
		reporter.reportLogWithScreenshot("4k TV selected");
		getRogersIgniteTVBuyPage().clkPlusAddIgniteTVBoxes();
		getRogersIgniteTVBuyPage().clkUpdateCart();
		getRogersIgniteTVBuyPage().clkCheckout();
		getRogersIgniteTVProfileCreationPage().verifyProfilePage();
		reporter.reportLogWithScreenshot("Launched the create profile page");
		getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
		getRogersTechInstallPage().selSelffinstallDateAndTime();
		getRogersTechInstallPage().clkTechInstallSlot();
		reporter.reportLogWithScreenshot("tech install date selected");
		getRogersTechInstallPage().clkIUnderStand();
		reporter.reportLogWithScreenshot("clicked I Understand condition");
		getRogersTechInstallPage().clkTechInstallContinue();
		getRogersOrderReviewPage().verifyAgreementPage();
		reporter.reportLogWithScreenshot("Launched the order review page");
		getRogersOrderReviewPage().verifyAgreement();
		getRogersOrderReviewPage().clkAcceptenceCheckbox();
		reporter.reportLogWithScreenshot("Agreement details");
		getRogersOrderReviewPage().clkSubmit();
		getRogersOrderConfirmationPage().verifyOrderConfirmation();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Order has created successfully","Order has failed");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,strGroupName, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


