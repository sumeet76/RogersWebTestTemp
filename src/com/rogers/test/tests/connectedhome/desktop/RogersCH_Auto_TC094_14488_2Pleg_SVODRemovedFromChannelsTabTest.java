package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to test the SVOD is removed from genre dropdown under Channels tab for Rogers.com
 *
 * @author manpreet.kaur3
 *
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Login with credentials
 *3. Click on TV & Streaming under Shop menu
 *3. Click on Get it now
 *4. Select the address on file and click on use the address
 *5. Click on Channels Tab
 *6. Verify SVOD removed from genre tab
 *
 **/

public class RogersCH_Auto_TC094_14488_2Pleg_SVODRemovedFromChannelsTabTest extends BaseTestClass {

	@Test(groups = {"RegressionCH"})
	public void rogersCH_Auto_TC094_14488_2Pleg_SVODRemovedFromChannelsTab() {
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc87_Legacy2PTVToIgnite3P.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc87_Legacy2PTVToIgnite3P.getPassword());
		reporter.reportLogWithScreenshot("Enter the account credentials");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
		if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
			reporter.reportLogWithScreenshot("Select an account.");
			getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc87_Legacy2PTVToIgnite3P.getAccountDetails().getBan());
		}
		//reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		/*reporter.reportLogWithScreenshot("Launched the Account Page");
		getRogersHomePage().clkExistingCustomerShop();
		reporter.reportLogWithScreenshot("clicked shop menu from navigation bar to select the Ignite Stream");
		getRogersHomePage().clkSubnavIgniteSmartStream();
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		getRogersHomePage().clkGetIgniteTvWithIgniteInternet();
		if(getRogersHomePage().verifyNoThanks()) {
			getRogersHomePage().clkNoThnx();
			reporter.reportLogWithScreenshot("Clicked on No Thanks");
			getRogersHomePage().clkServiceability();
		}*/
		getDriver().get(System.getProperty("QaUrl") + "/bundles");
		reporter.reportLogWithScreenshot("Launched the IgniteTV page");
		getRogersHomePage().clkServiceability();
		reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
		getRogersHomePage().selectAddressOnFile();
		reporter.reportLogWithScreenshot("Selected Address on file");
		getRogersHomePage().clkUseAddress();
		reporter.reportLogWithScreenshot("Launched the Bundles Page");
		getRogersIgniteTVBuyPage().clkChannelsTab();
		reporter.reportLogWithScreenshot("Launched the Channels");
		reporter.hardAssert(getRogersIgniteTVBuyPage().verifySVODRemovedFromGenre(), "SVOD not present in the genre dropdown", "SVOD present under genre dropdown");
	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws  IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


