package com.rogers.test.tests.solarisconsumer;
import java.io.IOException;
import java.lang.reflect.Method;


import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;

/**
 * This class contains the test method to test the change tv package , add 4k Channels  and themes changes buy flow for Rogers.com   
 * 
 * @author Saurav.Goyal
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Login into the application
 *3. Click TV badge
 *4. Click change TV package
 *5. Select solaris TV package i.e. popular , premier
 *6. Click on change TV package 
 *7. Click Exchange later
 *8. Add channel and remove it and again add it
 *9. Click on theme pack
 *10. Add theme pack
 *11. Click continue on existing channel alert window
 *12. Click continue on theme pack
 *13. Launch the 4K inquiry popup
 *14. Launch the 4K Content popup
 *15. Click accept the agreement and Submit the order
 **/

public class RogersSC_TC_008_ExistingSolarisCustomer_ChangeTVPackageAdd4KChannelsAndThemePackTest extends BaseTestClass {

    @Test
    public void checkSolarisChangeTVPackageAdd4KChannelsAndThemePackFlow() {       
        reporter.reportLogWithScreenshot("Launched the Home Page");
        getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc13_SolarisChangeTVPackageAdd4KChannelsAndThemePack.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc13_SolarisChangeTVPackageAdd4KChannelsAndThemePack.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        getRogersAccountOverviewPage().selectAccount((TestDataHandler.tc13_SolarisChangeTVPackageAdd4KChannelsAndThemePack.accountDetails.getBan()));
        reporter.softAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Logged in successfully", "Login failed");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        getRogersSolarisTVDashboardPage().clkChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the TV packages page");
        getRogersSolarisTVDashboardPage().selectSolarisTVPackage(TestDataHandler.tc13_SolarisChangeTVPackageAdd4KChannelsAndThemePack.accountDetails.getDowngradePlanEn(),TestDataHandler.tc13_SolarisChangeTVPackageAdd4KChannelsAndThemePack.accountDetails.getDowngradePlanFr());
        getRogersSolarisTVDashboardPage().clkPopupChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the personalize channel page");
        getRogersSolarisTVChannelsAndThemepacksPage().clkExchangeLater();
        reporter.reportLogWithScreenshot("Launched the channels and themepacks page");
        getRogersSolarisTVChannelsAndThemepacksPage().addChannel();
        reporter.reportLogWithScreenshot("Channel added");
        getRogersSolarisTVChannelsAndThemepacksPage().removeChannel();
        reporter.reportLogWithScreenshot("Channel removed");
        getRogersSolarisTVChannelsAndThemepacksPage().clkButtonRemoveChannelFromAlert();
        reporter.reportLogWithScreenshot("Clicked on button to Remove channel in the alert");
        getRogersSolarisTVChannelsAndThemepacksPage().addChannel();
        reporter.reportLogWithScreenshot("Channel again added");
        getRogersSolarisTVChannelsAndThemepacksPage().clkThemePacks();
        reporter.reportLogWithScreenshot("Clicked on themepack tab");
        getRogersSolarisTVChannelsAndThemepacksPage().addThemePacks();
        reporter.reportLogWithScreenshot("ThemePack added");
        getRogersSolarisTVChannelsAndThemepacksPage().clkContinueOnExistingChannelAlertWindow();
        reporter.reportLogWithScreenshot("Clicked continue on existing channel alert window ");        
        getRogersSolarisTVChannelsAndThemepacksPage().clkContinueFromThemepacks();
        reporter.reportLogWithScreenshot("Launched the 4K enquiry popup");
        getRogersSolarisTVChannelsAndThemepacksPage().clkYesIHave4K();
        reporter.reportLogWithScreenshot("Launched the 4K Content popup");
        getRogersSolarisTVChannelsAndThemepacksPage().clk4KContent();
        getRogersOrderReviewPage().verifyAgreementPage();
        reporter.reportLogWithScreenshot("Launched the order review page");
        getRogersOrderReviewPage().verifyAgreement();
        getRogersOrderReviewPage().clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmit();
		getRogersOrderConfirmationPage().verifyOrderConfirmation();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Update order completed","Update order Failed");
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


