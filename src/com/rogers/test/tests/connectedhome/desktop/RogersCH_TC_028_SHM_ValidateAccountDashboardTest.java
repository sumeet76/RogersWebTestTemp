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
 * This class contains the test method to validate the TV dashboard for Rogers.com   
 * 
 * @author Mirza.Kamran
 * 
 * Test steps:
 *
1.Rogers.com landing page is opened successfully
2. Sign in popup is displayed
3. Account overview page displayed
4. SHM dashboard page should be opened
 *
 **/

public class RogersCH_TC_028_SHM_ValidateAccountDashboardTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","RhpAndRhmCH"})
        public void checkSHMaccountDashboard() {
            reporter.reportLogWithScreenshot("Launched the Home Page");
            rogers_home_page.clkSignIn();
            rogers_login_page.switchToSignInIFrame();
            reporter.reportLogWithScreenshot("Launched the SignIn popup");
            rogers_login_page.setUsernameIFrame(TestDataHandler.rogersSHM.getUsername());
            rogers_login_page.setPasswordIFrame(TestDataHandler.rogersSHM.getPassword());
            reporter.reportLogWithScreenshot("Enter the account credentails");
            rogers_login_page.clkSignInIFrame();
            reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
            reporter.reportLogWithScreenshot("Skip popup");
            rogers_login_page.clkSkipIFrame(); 
            rogers_login_page.switchOutOfSignInIFrame();
            reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Logged in successfully", "Login failed");
            rogers_solaris_tv_dashboard_page.clkSHMBadge();
            reporter.reportLogWithScreenshot("SHM dashboard page");
            reporter.softAssert(rogers_shm_dashboard_page.verifyShopForAccessoriesLinkdisplayed(),
            		"SHM dashboard page Links displayed", "SHM dashboard page Links not displayed correctly please investigate");
            reporter.softAssert(rogers_shm_dashboard_page.verifyShopForAccessoriesLinkdisplayed(),
                "SHM dashboard page Links displayed", "SHM dashboard page Links not displayed correctly please investigate");
            reporter.softAssert(rogers_shm_dashboard_page.verifyLearnAboutSmartHomeMonitoringLinkdisplayed(),
                "SHM dashboard page Links displayed", "SHM dashboard page Links not displayed correctly please investigate");
            reporter.softAssert( rogers_shm_dashboard_page.verifyInsuranceCertificateLinkdisplayed(),
                "SHM dashboard page Links displayed", "SHM dashboard page Links not displayed correctly please investigate");
    }

    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login,method);
				
	}
   	
	
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}

