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
 * This class contains the test method to test the change package / bundle upgrade scenario for 2p SolarisTV Cx.
 * TC052_CH-28278_2P-2P_INT dashboard_with Addon SN360 channel_ flex05 to flex20_order review_Validate SN360 not carried over as Add on_Submit order successfully_ON_CH_EN
 * @author nandan.master
 * 
 * Test steps:
 *
 *1. Launch Rogers.com url
 *2. Log into rogers.com url with valid Solaris 2p Account credentials with Flex 5 & SN360 channel / Addon associated to the account
 *3. Click on Manage Internet Dashboard link
 *4. Click on 'Upgrade your ignite bundle' to expand offers
 *5. Select a higher bundle pack (e.g. Ignite Flex 20)
 *6. Validate the header and the content of PTM model
 *7. Hit Continue button on PTM Model
 *8. Validate Channels & Themepacks page - verify Details about your channels section
 *9. Click on Review your flex channels to expand a list of flex channels associated with the bundle
 *10. Validate the number of flex channels matches with the package
 *11. Click Continue button
 *12. Validate Order Review page
 *13. Accept the agreement checkbox and Submit the order
 *14. Validate Order Confirmation page
 *
 **/

public class RogersCH_Auto_TC125_SolarisTVCx_2p_InternetDashboard_BundleOfferChangePackageUpgradeTest extends BaseTestClass {

	@Test(groups = {"RegressionCH"})
    public void rogersCH_Auto_TC125_SolarisTVCx_2p_InternetDashboard_BundleOfferChangePackageUpgrade() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Overview Page");

        getRogersInternetDashboardPage().clkSolarisInternetBadge();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard");
        getRogersInternetDashboardPage().clkSolChangeInternetPackage();
        reporter.reportLogWithScreenshot("Launched the Internet packages page");
        getRogersInternetDashboardPage().selectSolarisInternetPackage(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getAccountDetails().getUpgradePlanEn(), TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getAccountDetails().getUpgradePlanFr());
        reporter.reportLogWithScreenshot("Launched the agreement page");
        getRogersInternetDashboardPage().verifyPTMmodalHeader();
        reporter.reportLogWithScreenshot("Verified the PTM modal header");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyPTMmodalContent1(), "PTM Model Content Line #1 is validated", "PTM Model Content Line #1 is NOT validated");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyPTMmodalContent2(), "PTM Model Content Line #2 is validated", "PTM Model Content Line #2 is NOT validated");

        getRogersInternetDashboardPage().clkInternetChangeOK();
        reporter.reportLogWithScreenshot("Clicked continue on the PTM modal");

        reporter.hardAssert(getRogersChangePackageChannelsNThemePacksPage().verifyChannelsNThemePacksPage(), "Channels and theme-packs page is verified", "Channels and theme-packs page is not verified");
//        reporter.hardAssert(getRogersChangePackageChannelsNThemePacksPage().verifyAddonsHeader(), "Channels & Addons Details subheader is verified", "Channels & Addons Details subheader is NOT verified");

        getRogersChangePackageChannelsNThemePacksPage().clkReviewFlexChannels();
        reporter.reportLogWithScreenshot("Clicked continue on the PTM modal");

        // to validate the total flex channel count matches with the package
        getRogersChangePackageChannelsNThemePacksPage().validateFlexChannelCount(TestDataHandler.tc21_SolarisInternetAccountForUpgrade.getAccountDetails().getUpgradePlanEn());

        getRogersChangePackageChannelsNThemePacksPage().clkContinue();
        reporter.reportLogWithScreenshot("Clicked Continue button on Channels & Themepacks page");

        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPageInternet(), "Agreement page has Launched", "Agreement page has not Launched");
        reporter.reportLogWithScreenshot("Launched the order review page");
        reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(), "Agreement has Launched", "Agreement has not Launched");

        getRogersOrderReviewPage().clkAcceptenceCheckboxUpdateInternet();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmitUpdateInternet();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");

        reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmationNew(), "Update order completed", "Update order Failed");
        reporter.reportLogWithScreenshot("Verified the Confirmation page");

    }
	
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() { closeSession();
	}
}
