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
 * This class contains the test method to test the TVPackage change buy flow for Rogers.com   
 * 
 * @author Saurav.Goyal
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Login into the application
 *3. Click solaris TV badge
 *4. Click change TV package and select TV package like premier , popular
 *5. Click Exchange later
 *8. Add channel and remove it and again add it
 *9. Click continue on theme pack
 *10. Launch the 4K inquiry popup
 *11. Launch the 4K Content popup
 *12. Click accept the agreement and Submit the order
 *
 **/

public class RogersSC_TC_005_ExistingSolarisCustomer_TVPackageChangeTest extends BaseTestClass {

    @Test
    public void checkSolarisTVPackageChangeFlow() {       
        reporter.reportLogWithScreenshot("Launched the Home Page");
        getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.solarisTVAccountPackageUpgrade.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.solarisTVAccountPackageUpgrade.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        getRogersAccountOverviewPage().selectAccount((TestDataHandler.solarisTVAccountPackageUpgrade.accountDetails.getBan()));
        reporter.softAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Logged in successfully", "Login failed");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        getRogersSolarisTVDashboardPage().clkChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the TV packages page");
        getRogersSolarisTVDashboardPage().selectSolarisTVPackage(TestDataHandler.solarisTVAccountPackageUpgrade.accountDetails.getDowngradePlanEn(),TestDataHandler.solarisTVAccountPackageUpgrade.accountDetails.getDowngradePlanFr());
        getRogersSolarisTVDashboardPage().clkPopupChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the personalize channel page");
        getRogersSolarisTVChannelsAndThemepacksPage().clkExchangeLater();
        reporter.reportLogWithScreenshot("Launched the channels and themepacks page");
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


