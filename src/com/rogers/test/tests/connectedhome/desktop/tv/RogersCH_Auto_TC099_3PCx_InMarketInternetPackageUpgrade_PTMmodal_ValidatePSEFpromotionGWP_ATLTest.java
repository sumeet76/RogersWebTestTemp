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
 * This class contains the test method to verify the Internet package upgrade flow for Rogers.com
 * CH-13233,CH-13908,CH-13909_Regression_3PCx Change Internet_PTM Modal_Eligible for PSEF and GWP_E2E_NL_CH_EN
 * @author manpreet.kaur3
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet package.
 *4. Click on change package button.
 *5. Select a package which has price higher to the current package.
 *6. Validate the PTM modal.
 *7. Click continue on PTM modal.
 *8. Validate the PSEF promotion on Order Review page.
 *9. Validate the GWP on Order Review page.
 *10. Go to Agreement section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit.
 * 12. Verify Order Confirmation
 *
 **/

public class RogersCH_Auto_TC099_3PCx_InMarketInternetPackageUpgrade_PTMmodal_ValidatePSEFpromotionGWP_ATLTest extends BaseTestClass {
	@Test
    public void rogersCH_Auto_TC099_3PCx_ChangeInternetPackage_PTMmodal_ValidatePSEFpromotionGWP_ATL() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc99_3PCxInternetAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc99_3PCxInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc99_3PCxInternetAccount.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersInternetDashboardPage().clkSolarisInternetBadge();
//        getRogersInternetDashboardPage().clkInternetPopup();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard");
        getRogersInternetDashboardPage().clkSolChangeInternetPackage();
        reporter.reportLogWithScreenshot("Launched the Interent packages page");
        getRogersInternetDashboardPage().selectSolarisInternetPackage(TestDataHandler.tc99_3PCxInternetAccount.getAccountDetails().getUpgradePlanEn(),TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getAccountDetails().getUpgradePlanFr());
        reporter.reportLogWithScreenshot("Launched the agreement page");
        getRogersInternetDashboardPage().verifyInfoIconPTMmodal();
        reporter.reportLogWithScreenshot("Verified the PTM modal");
        getRogersInternetDashboardPage().verifyPTMmodalHeader();
        reporter.reportLogWithScreenshot("Verified the PTM modal header");
        getRogersInternetDashboardPage().verifyPTMmodalContent();
        reporter.reportLogWithScreenshot("Verified the PTM modal content");
        getRogersInternetDashboardPage().clkInternetChangeOK();
        reporter.reportLogWithScreenshot("Clicked continue on the PTM modal");
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPageInternet(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert(!getRogersInternetPackageSelectionPage().verifyDisneyImage(), "PSEF promotion", "PSEF promotion not verified");
        reporter.hardAssert(getRogersInternetPackageSelectionPage().verifyGWPTag(), "GWP verified", "GWP not verified");
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
		
        getRogersOrderReviewPage().clkAcceptenceCheckboxUpdateInternet();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmitUpdateInternet();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(),"Update order completed","Update order Failed");
        reporter.reportLogWithScreenshot("Verified the Confirmation page");
    	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}


}

