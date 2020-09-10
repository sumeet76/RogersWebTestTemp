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
        rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.solarisTVAccountPackageUpgrade.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.solarisTVAccountPackageUpgrade.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        rogers_account_overview_page.selectAccount((TestDataHandler.solarisTVAccountPackageUpgrade.accountDetails.getBan()));
        reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Logged in successfully", "Login failed");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_solaris_tv_dashboard_page.clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        rogers_solaris_tv_dashboard_page.clkChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the TV packages page");
        rogers_solaris_tv_dashboard_page.selectSolarisTVPackage(TestDataHandler.solarisTVAccountPackageUpgrade.accountDetails.getDowngradePlanEn(),TestDataHandler.solarisTVAccountPackageUpgrade.accountDetails.getDowngradePlanFr());
        rogers_solaris_tv_dashboard_page.clkPopupChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the personalize channel page");
        rogers_solaris_tv_channels_and_themepacks_page.clkExchangeLater(); 
        reporter.reportLogWithScreenshot("Launched the channels and themepacks page");
        rogers_solaris_tv_channels_and_themepacks_page.clkContinueFromThemepacks();
        reporter.reportLogWithScreenshot("Launched the 4K enquiry popup");
        rogers_solaris_tv_channels_and_themepacks_page.clkYesIHave4K();  
        reporter.reportLogWithScreenshot("Launched the 4K Content popup");
        rogers_solaris_tv_channels_and_themepacks_page.clk4KContent();
        rogers_order_review_page.verifyAgreementPage();
        reporter.reportLogWithScreenshot("Launched the order review page");
        rogers_order_review_page.verifyAgreement();
        rogers_order_review_page.clkAcceptenceCheckbox();
        reporter.reportLogWithScreenshot("Agreement details");
		rogers_order_review_page.clkSubmit();
		rogers_order_confirmation_page.verifyOrderConfirmation();
		reporter.reportLogWithScreenshot("Launched the Confirmation page");
		reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Update order completed","Update order Failed");
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


