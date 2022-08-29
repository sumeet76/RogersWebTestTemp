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

public class RogersCH_Auto_TC015_SolarisTVCx_ValidateStarterPackDashboardButtonsRepositioningTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","IgniteTVDashboardCH"})
    public void rogersCH_Auto_TC015_SolarisTVCx_ValidateStarterPackDashboardButtonsRepositioning() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc15_solarisTVAccountStarterPackage.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc15_solarisTVAccountStarterPackage.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
    	reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc15_solarisTVAccountStarterPackage.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyFlexChannelcount(TestDataHandler.tc15_solarisTVAccountStarterPackage.accountDetails.getFlexChannelsCount()),"FlexChannel are Zero","FlexChannel are not Zero");
        reporter.reportLogWithScreenshot("Launched the TV dashboard Page");
        reporter.hardAssert(!getRogersSolarisTVDashboardPage().verifyExchangeFlexChannelLink(),"Exchange FlexChannel Link is not available","Exchange FlexChannel Link is available");
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

