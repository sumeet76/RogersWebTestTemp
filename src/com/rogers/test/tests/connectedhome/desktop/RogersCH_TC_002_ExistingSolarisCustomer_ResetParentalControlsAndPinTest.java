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
 * This class contains the test method to test the Reset parental controls and pin functionality in change tv buy flow for Rogers.com   
 * 
 * @author chinnarao.vattam
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

public class RogersCH_TC_002_ExistingSolarisCustomer_ResetParentalControlsAndPinTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","IgniteTVDashboardCH"})
    public void checkSolarisTVResetParentalControlsAndPinFlow() {  
        reporter.reportLogWithScreenshot("Launched the Home Page");
        rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
    	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
        rogers_account_overview_page.selectAccount(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getBan());
    	reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_solaris_tv_dashboard_page.clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        rogers_solaris_tv_dashboard_page.clkResetParentalConrolsAndPin();
        reporter.reportLogWithScreenshot("Alert window with Reset your Controls and Pin will appear");
        rogers_solaris_tv_dashboard_page.clkContinueParentalControlAndPinReset();
        reporter.reportLogWithScreenshot("Clicked continue button on Reset your Controls and Pin Alert window");
        reporter.hardAssert(rogers_solaris_tv_dashboard_page.verifyResetParentalControlsAndPinSuccess(), "Parental Controls And Pin reset successfull","Parental Controls And Pin reset failed");
        reporter.reportLogWithScreenshot("Success message verified");   
    	}

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//IgniteLogin
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}

