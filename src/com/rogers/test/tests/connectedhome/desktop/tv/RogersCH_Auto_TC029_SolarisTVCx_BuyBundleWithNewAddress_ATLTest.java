package com.rogers.test.tests.connectedhome.desktop.tv;
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

public class RogersCH_Auto_TC029_SolarisTVCx_BuyBundleWithNewAddress_ATLTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","RogersCustomerIgniteBuyCH"})
    public void rogersCH_Auto_TC029_SolarisTVCx_BuyBundleWithNewAddress_ATL() {
		 reporter.reportLogWithScreenshot("Launched the SignIn popup");
		 getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc04_08_SolarisTVAccount.getUsername());
		 getRogersLoginPage().clkContinueInBrowser();
		 getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc04_08_SolarisTVAccount.getPassword());
		 reporter.reportLogWithScreenshot("Enter the account credentials");
		 getRogersLoginPage().clkSignInIFrame();
		 reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
	  	 getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc04_08_SolarisTVAccount.accountDetails.getBan());
		 reporter.reportLogWithScreenshot("Launched the Account Page");
		 getDriver().get(System.getProperty("QaUrl") + "/bundles?setProvince=NL");
		 reporter.reportLogWithScreenshot("Navigated to IgniteTV Page - NL province");
		 getRogersHomePage().clkServiceability();
		 reporter.reportLogWithScreenshot("Launched the customer availability check popup");
		 String strAddressLine1 = TestDataHandler.tc52_IgniteSmartStreamNL.getAccountDetails().getAddress().get("line1");
		 String strAddressLine2 = TestDataHandler.tc52_IgniteSmartStreamNL.getAccountDetails().getAddress().get("line2");
		 getRogersHomePage().setIgniteAddressLookup(strAddressLine1 + "," + strAddressLine2);
		 getRogersHomePage().clkIgniteAddressLookupSubmit();
		 reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
		 reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(), "Bundles Page has launched", "Bundles Page has not launched");
		 getRogersIgniteTVBuyPage().selectFlex10Package();
		 reporter.reportLogWithScreenshot("Flex20+ Added to cart");
		 reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(), "4KTV radio button is availabe", "4KTV radio button is not availabe");
		 reporter.reportLogWithScreenshot("Launched the cart summary page");

		 getRogersIgniteTVBuyPage().set4KTVNo();
		 reporter.reportLogWithScreenshot("4k TV selected");
		 getRogersIgniteTVBuyPage().clkCheckout();

		 //reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(), "Profile page has Launched", "Profile page has not Launched");
		 reporter.reportLogWithScreenshot("Launched the create profile page");
		 getRogersIgniteTVProfileCreationPage().clkSubmitProfile();

		 reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallPage(), "TechInstall page has Launched", "TechInstall page has not Launched");
		 reporter.reportLogWithScreenshot("Launched the tech install page");
		 //getRogersTechInstallPage().clkTechInstalConsent();
		 getRogersTechInstallPage().clkProInstallUpgradeNo();
		 reporter.reportLogWithScreenshot("tech install details");
		 getRogersTechInstallPage().clkTechInstallContinueSelf();
		 reporter.hardAssert(getRogersTechInstallPage().verifyTechInstallSetUp(), "SetUp page has Launched", "SetUp page has not Launched");
		 getRogersTechInstallPage().clkTechInstallContinue();

		 reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPage(), "Agreement page has Launched", "Agreement page has not Launched");
		 reporter.reportLogWithScreenshot("Launched the order review page");

		 reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(), "Agreement has Launched", "Agreement has not Launched");
		 getRogersOrderReviewPage().clkAcceptenceCheckbox();
		 reporter.reportLogWithScreenshot("Agreement details");
		 getRogersOrderReviewPage().clkSubmit();
		 reporter.reportLogWithScreenshot("Launched the Confirmation page");
		 reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(), "Order has created successfully", "Order has failed");
		 reporter.reportLogWithScreenshot("Launched the Confirmation page");
	 }

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteAnonymous
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_legacylogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


