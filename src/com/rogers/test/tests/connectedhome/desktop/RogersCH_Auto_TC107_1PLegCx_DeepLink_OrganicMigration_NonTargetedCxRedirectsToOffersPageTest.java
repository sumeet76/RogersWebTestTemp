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
 * This class contains the test method to verify the Legacy Internet usage for Rogers.com   
 * 
 * @author manpreet.kaur3
 * Test steps:
 *
 *1. Launch deeplink 'Rogers.com/home/hto-eop'
 *2. Login with valid credentails for 1 profile 1 account.
 *3. Cx should get serviceability modal to launch Internet Offers Page
 *
 **/

public class RogersCH_Auto_TC107_1PLegCx_DeepLink_OrganicMigration_NonTargetedCxRedirectsToOffersPageTest extends BaseTestClass {
	
	@Test
	public void rogersCH_Auto_TC107_1PLegCx_DeepLink_OrganicMigration_NonTargetedCxRedirectsToOffersPage() {
		reporter.reportLogWithScreenshot("Launched the Deeplink");
		getDriver().get(System.getProperty("QaUrl")+"home/hto-eop");
		reporter.reportLogWithScreenshot("Launched the SignIn popup through deeplink");
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc62_Legacy1PtoIgnite2P.getUsername());
		getRogersLoginPage().clkContinueInBrowser();
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc62_Legacy1PtoIgnite2P.getPassword());
		reporter.reportLogWithScreenshot("Entered the account credentails");
		getRogersLoginPage().clkSignInIFrame();
		reporter.reportLogWithScreenshot("Sign-in");
		getRogersHomePage().selectAddressOnFile();
		reporter.reportLogWithScreenshot("cx navigates directly to Internet/offers");
		getRogersHomePage().clkUseAddress();
		reporter.reportLogWithScreenshot("selected address on file and clicked on use this address");
		reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyGoodNewsServiceabilityContent(),"Good News ! serviceability content verified on Offers page","Good News ! serviceability content not verified on Offers page");
		reporter.reportLogWithScreenshot("Launched the Internet packages page");
    	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_legacyanonymous , method);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
