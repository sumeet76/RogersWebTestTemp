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
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the TV badge.
 *4. Click on View 'My channel Line Up' link below the Channels at the top left.
 *5. Click on the link to view as pdf and open the pdf.
 *6. Click on 'View My Flex channel' link below the Channels in the top left.
 *7. Click on the link to view as pdf and open the pdf.
 *
 **/

public class RogersCH_Auto_TC067_Bulk3PTenantCx_2L7ContractType_ValidateAllDashboardsTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","RogersInternetCH"})
    public void rogersCH_Auto_TC067_Bulk3PTenantCx_2L7ContractType_ValidateAllDashboards() {

        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc67_2L7ContractType3PBulkTenant.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc67_2L7ContractType3PBulkTenant.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
    	reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
         if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
             reporter.reportLogWithScreenshot("Select an account.");
             getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc67_2L7ContractType3PBulkTenant.accountDetails.getBan());
         }
         reporter.reportLogWithScreenshot("Account Selected");
         getRogersInternetDashboardPage().clkSolarisInternetBadge();
         reporter.reportLogWithScreenshot("Launched the Internet dashboard");
         reporter.hardAssert(getRogersInternetDashboardPage().verifyInternet(), "Verified the Internet page", "Internet page verification failed");
         reporter.hardAssert(getRogersInternetDashboardPage().verifyChangeInternetPackageBtnNotPresent(), "Change Internet Package Button not present", "Change Internet Package Button present");
         getRogersInternetDashboardPage().clkShowDetails();
         reporter.reportLogWithScreenshot("Clicked on Show Details");
         reporter.hardAssert(getRogersInternetDashboardPage().verifyShowDetailsExpanded(), "Show Details Expanded", "Show Details not expanded");
         reporter.hardAssert(getRogersInternetDashboardPage().verifyCallUs(), "Verified Call Us is clickable", "Call Us is not clickable");

         getRogersAccountOverviewPage().clkHomePhoneUnderUsageAndServiceMenu();
         reporter.reportLogWithScreenshot("Clicked on submenu Home Phone");

         reporter.hardAssert(getRogersSolarisRHPDashboardPage().verifyHomePhone(), "Verified the Home Phone page", "Home Phone page verification failed");
         reporter.hardAssert(getRogersSolarisRHPDashboardPage().verifyCallUs(), "Verified Call Us is clickable", "Call Us is not clickable");

         getRogersAccountOverviewPage().clkTVUnderUsageAndServiceMenu();
         reporter.reportLogWithScreenshot("Clicked on submenu TV");

         reporter.hardAssert(!getRogersSolarisTVDashboardPage().verifyExchangeFlexChannelLink(), "Exchange Flex Channel not present", "Exchange Flex Channel present");
         reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyFlexChannelcount("0"), "Flex Channel count is zero", "Flex Channel count not zero");
         getRogersSolarisTVDashboardPage().clkManageChannelsAndThemePacks();
         reporter.reportLogWithScreenshot("Clicked on Manage Channels and Theme Packs");
         reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyLTQModal(), "Verified the LTQ Modal", "LTQ Modal not verified");
         reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyLTQModalHeader(), "Verified the LTQ Modal header", "LTQ Modal not verified");
         reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyLTQModalContent(), "Verified the LTQ Modal Content", "LTQ Modal not verified");
         reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyLTQModalCallUsLink(), "Verified the LTQ Modal Call Us Link", "LTQ Modal not verified");
         getRogersSolarisTVDashboardPage().clkCloseLTQMOdal();
         reporter.reportLogWithScreenshot("Closed LTQ Modal");
         reporter.hardAssert(!getRogersSolarisTVDashboardPage().verifyExchangeNow(), "Exchange Now not present", "Exchange Now button present");
         getRogersSolarisTVDashboardPage().clkMoreDetails();
         reporter.reportLogWithScreenshot("Clicked on More Details");
         reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyMoreDetailsExpanded(), "More Details Expanded", "More Details not expanded");
         reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyCallUs(), "Verified Call Us is clickable", "Call Us is not clickable");

	 }


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
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

