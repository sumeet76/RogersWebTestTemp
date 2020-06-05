package com.rogers.test.tests.selfserve.desktop;

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
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;

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

public class RogersSS_TC_040_AO_ValidateCHaccountBadge_SHM extends BaseTestClass {

    @Test
    public void checkTVDashboard() {
        reporter.reportLogWithScreenshot("Launched the Home Page");
        rogers_home_page.clkSignIn();
        rogers_login_page.switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.shmAccount.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.shmAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        rogers_login_page.clkSignInIFrame();
        reporter.reportLogWithScreenshot("Skip popup");
        rogers_login_page.clkSkipIFrame(); 
        rogers_login_page.switchOutOfSignInIFrame();
        rogers_account_overview_page.selectAccount(TestDataHandler.shmAccount.accountDetails.getBan());                    
        reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),
        		"Logged in successfully", "Login failed");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_solaris_tv_dashboard_page.clkSHMBadge();          
        reporter.hardAssert(rogers_shm_dashboard_page.verifySHMDashBoardPageIsDisplayed(),
        		"SHM dashboard page is displayed", "SHM dashboard page NOT displayed correctly please investigate");        
        reporter.reportLogWithScreenshot("Launched the SHM dashboard Page");
        common_business_flows.scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Mid page view");
        reporter.softAssert(rogers_shm_dashboard_page.verifyShopForAccessoriesLinkdisplayed()
        		&& rogers_shm_dashboard_page.verifyShopForAccessoriesLinkdisplayed()
        		&& rogers_shm_dashboard_page.verifyLearnAboutSmartHomeMonitoringLinkdisplayed()
        		&& rogers_shm_dashboard_page.verifyInsuranceCertificateLinkdisplayed(),
        		"SHM dashboard page Links displayed", "SHM dashboard page Links not displayed correctly please investigate");               
		common_business_flows.scrollToBottomOfWebPage();
		reporter.reportLogWithScreenshot("Bottom View");
        
        
    }

    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
   	
	
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}

