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

	 @Test(groups = {"RegressionCH","IgniteTVDashboardCH","DryRunCH"})
    public void checkSolarisTVResetParentalControlsAndPinFlow() {  
        reporter.reportLogWithScreenshot("Launched the Home Page");
        getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getBan());
    	reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
         getRogersSolarisTVDashboardPage().clkResetParentalConrolsAndPin();
         reporter.reportLogWithScreenshot("Alert window with Reset your Controls and Pin will appear");
         getRogersSolarisTVDashboardPage().clkContinueParentalControlAndPinReset();
         reporter.reportLogWithScreenshot("Success message verified");
         reporter.hardAssert(getRogersSolarisTVDashboardPage().verifyResetParentalControlsAndPinSuccess(), "Parental Controls And Pin reset successfull","Parental Controls And Pin reset failed");
         getRogersSolarisTVDashboardPage().clkOkContinue();
         getRogersSolarisTVDashboardPage().clkRefreshYourIgniteTVBox();
         reporter.reportLogWithScreenshot("Refresh your Ignite TV Box(es)");
         getRogersSolarisTVDashboardPage().clkRefreshYourIgniteTVBoxContinue();
         reporter.reportLogWithScreenshot("Success message verified");
         reporter.hardAssert(getRogersSolarisTVDashboardPage().verifysuccessRefreshYourIgniteTVBox() , "Refresh Your Ignite TV Box successfull","Refresh Your Ignite TV Box failed");
         getRogersSolarisTVDashboardPage().clkOkContinue();
         getRogersSolarisTVDashboardPage().clkResetPurchasePIN();
         reporter.reportLogWithScreenshot("Reset Purchase PIN");
         getRogersSolarisTVDashboardPage().clkResetPurchasePINContinue() ;
         reporter.reportLogWithScreenshot("Success message verified");
         reporter.hardAssert(getRogersSolarisTVDashboardPage().verifysuccessResetPurchasePIN() , "Reset Purchase PIN successfull","Reset Purchase PIN  reset failed");
         getRogersSolarisTVDashboardPage().clkOkContinue();
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


