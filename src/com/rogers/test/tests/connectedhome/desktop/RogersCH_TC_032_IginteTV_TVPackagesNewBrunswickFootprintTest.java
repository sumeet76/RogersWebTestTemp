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

public class RogersCH_TC_032_IginteTV_TVPackagesNewBrunswickFootprintTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","TVPlanUpgardeCH"})
	    public void checkSolarisTVPackageUpgrade() {
	        reporter.reportLogWithScreenshot("Launched the Home Page");
	        rogers_home_page.clkSignIn();
	        rogers_login_page.switchToSignInIFrame();
	        reporter.reportLogWithScreenshot("Launched the SignIn popup");
	        rogers_login_page.setUsernameIFrame(TestDataHandler.solarisTVAccountForUpgradeNB.getUsername());
	        rogers_login_page.setPasswordIFrame(TestDataHandler.solarisTVAccountForUpgradeNB.getPassword());
	        reporter.reportLogWithScreenshot("Enter the account credentails");
	        rogers_login_page.clkSignInIFrame();
	    	reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
	        reporter.reportLogWithScreenshot("Skip popup");
	        rogers_login_page.clkSkipIFrame();
	        rogers_login_page.switchOutOfSignInIFrame();
	        rogers_account_overview_page.selectAccount(TestDataHandler.solarisTVAccountForUpgradeNB.accountDetails.getBan());
	    	reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
            reporter.reportLogWithScreenshot("Launched the Account Page");                
	        rogers_solaris_tv_dashboard_page.clkTVBadge();
	        reporter.reportLogWithScreenshot("Launched the TV dash board");
	        rogers_solaris_tv_dashboard_page.clkChangeTVPackage();
	        reporter.reportLogWithScreenshot("Launched the TV packages page");
	        reporter.softAssert(rogers_solaris_tv_dashboard_page.verifyIgniteTVStarterPackage(),"Ignite TV Starter Package is available for the Ontario footprint","Ignite TV Starter Package is not available for the Ontario footprint");
	        rogers_solaris_tv_dashboard_page.selectSolarisTVPackage(TestDataHandler.solarisTVAccountForUpgradeNB.accountDetails.getUpgradePlanEn(),TestDataHandler.solarisTVAccountForUpgradeNB.accountDetails.getUpgradePlanFr());

	        rogers_solaris_tv_dashboard_page.clkPopupChangeTVPackage();
	        reporter.reportLogWithScreenshot("Launched the personalize channel page");
	        rogers_solaris_tv_channels_and_themepacks_page.clkExchangeLater(); 
	        reporter.reportLogWithScreenshot("Launched the channels and themepacks page");
	        rogers_solaris_tv_channels_and_themepacks_page.clkContinueFromThemepacks();
	        reporter.reportLogWithScreenshot("Launched the 4K enquiry popup");
	        rogers_solaris_tv_channels_and_themepacks_page.clkYesIHave4K();  
	        reporter.reportLogWithScreenshot("Launched the 4K Content popup");
	        rogers_solaris_tv_channels_and_themepacks_page.clk4KContent();
			
			reporter.hardAssert(rogers_order_review_page.verifyAgreement(),"Agreement has Launched","Agreement has not Launched");
	        rogers_order_review_page.clkAcceptenceCheckboxUpdate();
	        reporter.reportLogWithScreenshot("Agreement details");
	        rogers_order_review_page.clkSubmitUpdate();
	        reporter.reportLogWithScreenshot("Launched the Confirmation page");
	        reporter.softAssert(rogers_order_confirmation_page.verifyOrderConfirmation(),"Update order completed","Update order Failed");
	        reporter.reportLogWithScreenshot("Verified the Confirmation page");
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

