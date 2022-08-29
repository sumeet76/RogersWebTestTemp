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
 * This class contains the test method to verify the Solaris Internet package downgarde flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet package.
 *4. Click on chage package button.
 *5. Select a package which has price higher to the current package.
 *6. Scroll down to the last in the page and Click on Checkout.
 *7. Enter appropriate Contact details.
 *8. Pick a date time in step 2 - Most Convenient Time for us to call.
 *9. Click on Continue.
 *10. Go to Agreement section section,  scroll down all the way,  and click on "I have read………." check box
 *11. Click on Submit.
 *
 **/

public class RogersCH_Auto_TC017_SolarisInternetCx_enableVA_Livechat_InternetDashboardPage_ATLTest extends BaseTestClass {

	@Test(groups = {"RegressionCH","RogersInternetCH"})
    public void rogersCH_Auto_TC017_SolarisInternetCx_enableVA_Livechat_InternetDashboardPage_ATL() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
    	reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        //getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc16_17_18_19_SolarisInternetAccount.accountDetails.getBan());
    	reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersInternetDashboardPage().clkSolarisInternetBadge();
        getRogersInternetDashboardPage().clkInternetPopup();
        reporter.hardAssert(getRogersInternetDashboardPage().verifyInternet(),"Launched the internet dashboard Page","Internet dashboard Page dosen't launched");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyVAButton(),"VA button is present","VA button is not present");
        getRogersInternetDashboardPage().clkVAButton();
        getRogersInternetDashboardPage().switchToVAIFrame();
        reporter.hardAssert(getRogersInternetDashboardPage().verifyVaWelcome(),"VA chat tab has launched","VA chat tab hasn't launched");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyVaTopicList(),"VA chat Topic list is available","VA chat Topic list is not available");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyVaWelcomeSend(),"VA chat Continue button is available","VA chat Continue button  is not available");
        getRogersInternetDashboardPage().clkVaWelcomeSend();
        reporter.hardAssert(getRogersInternetDashboardPage().verifyVAOptions(),"VA chat options are available","VA chat options are not available");
        reporter.reportLogWithScreenshot("VA chat options ");
        getRogersInternetDashboardPage().clkIgniteInternetOption();
        reporter.hardAssert(getRogersInternetDashboardPage().verifyInternetIssues(),"Internet issues list","Internet issues list not displayed");
        reporter.reportLogWithScreenshot("Internet issues list");
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

