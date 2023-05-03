package com.rogers.test.tests.connectedhome.mobile;

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
 *10. Go to Agreement section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit
 *
 **/

public class Mobile_RogersCH_Auto_TC005_SolarisTVCx_TVPackageUpgradeTest extends BaseTestClass {

    @Test(groups = {"MobileRegressionCH"})
    public void mobile_RogersCH_Auto_TC005_SolarisTVCx_TVPackageUpgrade() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameMobile(TestDataHandler.tcm05_SolarisTVAccountForUpgrade.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordMobile(TestDataHandler.tcm05_SolarisTVAccountForUpgrade.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
    	//reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tcm05_SolarisTVAccountForUpgrade.accountDetails.getBan());
    	//reporter.hardAssert(getRogersAccountOverviewPage().verifyLoginSuccessWelcome(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        
        getRogersSolarisTVDashboardPage().clkTVBadgeMobile();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        getRogersSolarisTVDashboardPage().clkChangeTVPackageMobile();
        reporter.reportLogWithScreenshot("Launched the TV packages page");
        getRogersSolarisTVDashboardPage().selectSolarisTVPackage(TestDataHandler.tcm05_SolarisTVAccountForUpgrade.accountDetails.getUpgradePlanEn(),TestDataHandler.tc10_SolarisTVAccountForUpgrade.accountDetails.getUpgradePlanFr());
        getRogersSolarisTVDashboardPage().clkPopupChangeTVPackageMobile();
        reporter.reportLogWithScreenshot("Launched the personalize channel page");
        getRogersSolarisTVChannelsAndThemepacksPage().clkExchangeLaterMobile();
        reporter.reportLogWithScreenshot("Launched the channels and themepacks page");
        getRogersSolarisTVChannelsAndThemepacksPage().clkContinueFromThemepacksMobile();
        reporter.reportLogWithScreenshot("Launched the 4K enquiry popup");
        getRogersSolarisTVChannelsAndThemepacksPage().clkYesIHave4KMobile();
        reporter.reportLogWithScreenshot("Launched the 4K Content popup");
        getRogersSolarisTVChannelsAndThemepacksPage().clk4KContent();
        reporter.reportLogWithScreenshot("Click continue 4K content");
    	//reporter.hardAssert(getRogersOrderReviewPage().verifyAgreementPageTVMobile(),"Agreement page has Launched","Agreement page has not Launched");
		reporter.hardAssert(getRogersOrderReviewPage().verifyAgreement(),"Agreement has Launched","Agreement has not Launched");;
        getRogersOrderReviewPage().clkAcceptenceCheckboxUpdateTVMobile();
        reporter.reportLogWithScreenshot("Agreement details");
        getRogersOrderReviewPage().clkSubmitUpdateMobile();
        reporter.reportLogWithScreenshot("Launched the Confirmation page");
        reporter.hardAssert(getRogersOrderConfirmationPage().verifyOrderConfirmation(),"Update order completed","Update order Failed");
        reporter.reportLogWithScreenshot("Verified the Confirmation page"); 
    	}

	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() { closeSession();
	}


}

