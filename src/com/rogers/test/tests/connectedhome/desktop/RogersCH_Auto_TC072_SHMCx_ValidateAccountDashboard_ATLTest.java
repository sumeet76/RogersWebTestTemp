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
 * @author nandhini.ventakachal
 * 
 * Test steps:
 *
1.Rogers.com landing page is opened successfully
2. Sign in popup is displayed
3. Account overview page displayed
4. SHM dashboard page should be opened
 *
 **/

public class RogersCH_Auto_TC072_SHMCx_ValidateAccountDashboard_ATLTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","RhpAndRhmCH","DryRunCH"})
        public void rogersCH_Auto_TC072_SHMCx_ValidateAccountDashboard_ATL() {
            reporter.reportLogWithScreenshot("Launched the SignIn popup");
            getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc72_RogersSHM_NB.getUsername());
            getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc72_RogersSHM_NB.getPassword());
            reporter.reportLogWithScreenshot("Enter the account credentails");
            getRogersLoginPage().clkSignInIFrame();
            reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
            reporter.reportLogWithScreenshot("Skip popup");
            getRogersLoginPage().clkSkipIFrame();
            reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Logged in successfully", "Login failed");
            getRogersSolarisTVDashboardPage().clkSHMBadge();
            reporter.reportLogWithScreenshot("SHM dashboard page");
            reporter.hardAssert(getRogersSHMDashboardPage().verifySHMDashBoardPageIsDisplayed(),"Launched SHM dashboard successfully", "SHM dashboard failed");
            reporter.softAssert(getRogersSHMDashboardPage().verifyLearnAboutSmartHomeMonitoringLinkdisplayed(),
                "SHM Learn About Smart Home Monitoring displayed", "SHM Learn About SmartHome Monitoring not displayed correctly please investigate");
            reporter.softAssert( getRogersSHMDashboardPage().verifyInsuranceCertificateLinkdisplayed(),
                "SHM Rogers SHM Dashboard page displayed", "SHM Rogers SHM Dashboard page not displayed correctly please investigate");
              reporter.softAssert(getRogersSHMDashboardPage().verifyNewToSmartHomeLinkdisplayed(),
                "New To SmartHome Link displayed", "New To SmartHome Link not displayed correctly please investigate");

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


