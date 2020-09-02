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
 * This class contains the test method to verify the Solaris Internet package downgarde flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet package.
 *4. Click on chage package button.
 *5. Select a package which has price higher to the current package.
 *6. Scroll down to the last in the page and Click on Checkout.
 *7. Enter appropriate Contact details.
 *8. Pick a date time in step 2 - Most Convenient Time for us to call.
 *9. Click on Continue.
 *10. Go to Agreement section section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit.
 *
 **/

public class RogersCH_TC_013_IginteInternet_ValidateVAicononInternetDashboardTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","RogersInternetCH"})
    public void checkVAicononInternetDashboard() {
        reporter.reportLogWithScreenshot("Launched the Home Page");
        rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.solarisInternetAccount.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.solarisInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
    	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame();
        rogers_login_page.switchOutOfSignInIFrame();
    	reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        rogers_account_overview_page.selectAccount(TestDataHandler.solarisInternetAccount.accountDetails.getBan());
    	reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_internet_dashboard_page.clkSolarisInternetBadge();
        reporter.hardAssert(rogers_internet_dashboard_page.verifyInternetPage(),"Launched the internet dashboard Page","Internet dashboard Page dosen't launched");
        reporter.hardAssert(rogers_internet_dashboard_page.verifyVAButton(),"VA button is present","VA button is not present");
        rogers_internet_dashboard_page.clkVAButton();
        reporter.hardAssert(rogers_internet_dashboard_page.verifyVaWelcome(),"VA chat tab has launched","VA chat tab hasn't launched");
        rogers_internet_dashboard_page.clkVAMenu();
        rogers_internet_dashboard_page.clkVAMininmize();
        rogers_internet_dashboard_page.clkVAButton();
        reporter.hardAssert(rogers_internet_dashboard_page.verifyVaWelcome(),"VA chat tab has launched","VA chat tab hasn't launched");
        reporter.hardAssert(rogers_internet_dashboard_page.verifyVaTopicList(),"VA chat Topic list is available","VA chat Topic list is not available");
        rogers_internet_dashboard_page.clkVAMenu();
        rogers_internet_dashboard_page.clkVAClose();
        reporter.hardAssert(rogers_internet_dashboard_page.verifyVAButton(),"VA button is present","VA button is not present");
    	}

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
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

