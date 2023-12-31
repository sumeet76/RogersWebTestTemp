package com.rogers.test.tests.connectedhome.desktop.legacy;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to verify the upgarde flow for Legacy TV to IgniteTV for Rogers.com  
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the TV badge
 *4. Click on Ignite TV under shop drowndown
 *5. Select the Bundles package and Click on Add to cart
 *6. Enter home address to validate the serviceability and click on Check Availability
 *7. Click on Continue.
 *8. Click on 'Yes I understood'button.
 *9. Click "No thanks Continue".
 *10. Click on Continue.
 *11. Select one option for   'Do you have a 4K TV'.
 *12. Click checkout button on cart summary page.
 *13. All the personal information is auto populated.
 *14. Click on continue button.
 *15. In Credit Evaluation page, enter the required info on Credit Check:
 *16. Click Submit.
 *17. Enter 1 or 2 numbers in Choose a phone Number textbox and click on Generate numbers.
 *18. Select any one phone number. 
 *19. Make sure Caller ID and Directory listing fields are populated.
 *20. Click on Continue.
 *21. Select a time in Choose your Date and Time. 
 *22. Enter any valid Mobile number and email address.
 *23. Click on Confirm.
 *24. Select Pre-Authorized credit card option from type of payment dropdown.
 *25. Enter valid Credit Card number details in Credit Card related fields.
 *26. Click on Continue.
 *27. Validate appropriate information is displayed in Review order page.
 *28. Scroll down all the way down in Agreement field and select "I have read understood….." checkbox.
 *29. Order confirmation page will be displayed with the order number and validate the order details.
 *
 **/

public class RogersCH_Auto_TC027_LegacyDTV_CartAbandon_NoPortinTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersCartAbandon"})
	public void rogersCH_Auto_TC027_LegacyDTV_CartAbandon_NoPortin() {
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc27_NoPortInAbondoneFlows.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc27_NoPortInAbondoneFlows.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		getEnsVerifications().setVerificationCodeCH(TestDataHandler.tc27_NoPortInAbondoneFlows.getUsername());
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc27_NoPortInAbondoneFlows.accountDetails.getBan());
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getDriver().get(System.getProperty("QaUrl") + "/bundles");
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		getRogersHomePage().clkServiceability();
		getRogersHomePage().selectAddressOnFile();
		reporter.reportLogWithScreenshot("Selected Address on file");
		getRogersHomePage().clkUseAddress();
		reporter.reportLogWithScreenshot("Launched the Bundles Page");
		getRogersIgniteTVBuyPage().selectFlex20PackageMonthToMonthTypeOfContract();
		reporter.reportLogWithScreenshot("Selected Month-to-month type of contract");
		getRogersIgniteTVBuyPage().selectFlex20Package();
		reporter.reportLogWithScreenshot("Added to cart");
		getRogersIgniteTVBuyPage().clkIUnderstand();
        reporter.reportLogWithScreenshot("Clicked on Yes, I understand");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is available","4KTV radio button is not available");
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersHomePage().clkSignOut();
		reporter.reportLogWithScreenshot("Signed Out");
	//	reporter.hardAssert(getRogersHomePage().verifyMyRogers(), "Launched the QA rogers main page", "Main QA page has not loaded");
		//getRogersHomePage().clkMyRogers();
		getRogersHomePage().waitBeforeSwapSecondRun();
		//  getRogersHomePage().clkEasyLogin();
		getDriver().get(System.getProperty("QaUrl") + "/consumer/easyloginriverpage?setLanguage=en");
		reporter.reportLogWithScreenshot("Launched the SignIn popup 2");
		//getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc27_NoPortInAbondoneFlows.getUsername());
		//getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc27_NoPortInAbondoneFlows.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc27_NoPortInAbondoneFlows.accountDetails.getBan());
		reporter.reportLogWithScreenshot("Launched the Account Page");
		getDriver().get(System.getProperty("QaUrl") + "/bundles");
		reporter.hardAssert(getRogersHomePage().verifyWelcomeback(),"Welcome back popup has Launched","Welcome back popup has not Launched");
		reporter.reportLogWithScreenshot("Launched the Welcome back popup");
		getRogersHomePage().clkWelcomeback();
		reporter.reportLogWithScreenshot("Launched the cart summary page");
		getRogersIgniteTVBuyPage().clkCheckout();
		reporter.reportLogWithScreenshot("Launched the information popup");
		}


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_legacylogin, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}
}