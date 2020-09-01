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
 * This class contains the test method to test the Reset parental controls and pin functionality in change tv buy flow for Rogers.com   
 * 
 * @author Saurav.Goyal
 * 
 * Test steps:
 *
 *1. Launch Rogers.com
 *2. Login with valid user name and password
 *3. Click on TV badge
 *4. Click on Reset Parental controls and pin
 *5. Click Continue on the pop up window
 *6. Verify the Success message after clicking on the continue button
 *
 **/

public class RogersSC_TC_003_ExistingSolarisCustomer_ResetParentalControlsAndPin extends BaseTestClass {

    @Test
    public void checkSolarisTVResetParentalControlsAndPinFlow() {       
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
        rogers_solaris_tv_dashboard_page.clkResetParentalConrolsAndPin();
        reporter.reportLogWithScreenshot("Alert window with Reset your Controls and Pin will appear");
        rogers_solaris_tv_dashboard_page.clkContinueParentalControlAndPinReset();
        reporter.reportLogWithScreenshot("Clicked continue button on Reset your Controls and Pin Alert window");
        reporter.softAssert(rogers_solaris_tv_dashboard_page.verifyResetParentalControlsAndPinSuccess(), "Parental Controls And Pin reset successfull","Parental Controls And Pin reset failed");
        reporter.reportLogWithScreenshot("Success message verified");      
    }

    @BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
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


