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
 * This class contains the test method to verify the solaris TV package upgarde flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on a TV account
 *4. Click on chage package button
 *5. Choose a tv package whose price is higher than the current package and click on Submit
 *6. Scroll down to the last in the page and Click on Checkout
 *7. Enter appropriate Contact details
 *8. Pick a date time in step 2 - Most Convenient Time for us to call
 *9. Click on Continue
 *10. Go to Agreement section section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit
 *
 **/

public class RogersCH_Auto_TC011_SolarisTVCx_TVChangeFlow_NewBrunswickFootprint_ATL_FRTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","TVPlanUpgardeCH"})
	    public void rogersCH_Auto_TC011_SolarisTVCx_TVChangeFlow_NewBrunswickFootprint_ATL_FR() {
	        reporter.reportLogWithScreenshot("Launched the SignIn popup");
	        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc11_SolarisTVAccountForUpgradeNB.getUsername());
	        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc11_SolarisTVAccountForUpgradeNB.getPassword());
	        reporter.reportLogWithScreenshot("Enter the account credentails");
	        getRogersLoginPage().clkSignInIFrame();
	    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	        reporter.reportLogWithScreenshot("Skip popup");
	        getRogersLoginPage().clkSkipIFrame();
	    	reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
		    getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc11_SolarisTVAccountForUpgradeNB.accountDetails.getBan());
	    	reporter.reportLogWithScreenshot("Launched the Account Page");
	        getRogersSolarisTVDashboardPage().clkTVBadge();
	        reporter.reportLogWithScreenshot("Launched the TV dash board");
	        getRogersSolarisTVDashboardPage().clkChangeTVPackageLetency();
	        reporter.reportLogWithScreenshot("Launched the TV packages page");
	        //reporter.softAssert(getRogersSolarisTVDashboardPage().verifyIgniteTVStarterPackage(),"Ignite TV Starter Package is available for the Ontario footprint","Ignite TV Starter Package is not available for the Ontario footprint");
	        getRogersSolarisTVDashboardPage().selectSolarisTVPackage(TestDataHandler.tc11_SolarisTVAccountForUpgradeNB.accountDetails.getUpgradePlanEn(),TestDataHandler.tc11_SolarisTVAccountForUpgradeNB.accountDetails.getUpgradePlanFr());
	        getRogersSolarisTVDashboardPage().clkPopupChangeTVPackage();
	        reporter.reportLogWithScreenshot("Launched the personalize channel page");
	        getRogersSolarisTVChannelsAndThemepacksPage().clkExchangeLater();
	        reporter.reportLogWithScreenshot("Launched the channels and themepacks page");
	        getRogersSolarisTVChannelsAndThemepacksPage().clkContinueFromThemepacks();
	        reporter.reportLogWithScreenshot("Launched the 4K enquiry popup");
	        getRogersSolarisTVChannelsAndThemepacksPage().clkYesIHave4K();
	        reporter.reportLogWithScreenshot("Launched the 4K Content popup");
	        getRogersSolarisTVChannelsAndThemepacksPage().clk4KContent();
			
			reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
	        getRogersOrderReviewPage().clkAcceptenceCheckboxUpdate();
	        reporter.reportLogWithScreenshot("Agreement details");
	        getRogersOrderReviewPage().clkSubmitUpdateTV();
	        reporter.reportLogWithScreenshot("Launched the Confirmation page");
	        reporter.softAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Update order completed","Update order Failed");
	        reporter.reportLogWithScreenshot("Verified the Confirmation page");
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

