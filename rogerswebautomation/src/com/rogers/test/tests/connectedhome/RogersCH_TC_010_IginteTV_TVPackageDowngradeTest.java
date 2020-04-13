package com.rogers.test.tests.connectedhome;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;


/**
 * This class contains the test method to verify the solaris TV package downgrade flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on TV.
 *4. Click on chage package button.
 *5. Select a package which has price lower to the current package.
 *
 **/

public class RogersCH_TC_010_IginteTV_TVPackageDowngradeTest extends BaseTestClass {

    @Test
    public void checkSolarisTVPackageDowngrade() {
        reporter.reportLogWithScreenshot("Launched the Home Page");
        rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.solarisTVAccount.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.solarisTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame(); 
        rogers_login_page.switchOutOfSignInIFrame();
        rogers_account_overview_page.selectAccount((TestDataHandler.solarisTVAccount.accountDetails.getBan()));
        reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Logged in successfully", "Login failed");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_solaris_tv_dashboard_page.clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        rogers_solaris_tv_dashboard_page.clkChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the TV packages page");
        rogers_solaris_tv_dashboard_page.selectSolarisTVPackage1(TestDataHandler.solarisTVAccount.accountDetails.getDowngradePlanEn());
        reporter.softAssert(rogers_solaris_tv_dashboard_page.verifycontatUSPopUp(),"Displayed the contat US popup","Download package has failed");              
        reporter.reportLogWithScreenshot("Launched the customer care popup");       
    }

	@BeforeMethod @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	//login flow
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.rogersConfig.getRogersURL(), strBrowser,strLanguage,strGroupName, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


