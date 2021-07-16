package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_053_ValidateBrightstarLinkInWirelessDashbard_prepaidConsumerRegularAccount extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test (groups = {"RegressionSS","WirelessDashboardSS","Prepaid"})
    public void validateBrightstarLink() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc5398.getUsername();
    	String strPassword = TestDataHandler.tc5398.getPassword();
        String strAccountNum = TestDataHandler.tc5398.getAccountDetails().getCtn();
    	//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersAccountOverviewPage().removeCookieAfterLogin("temp_token_r");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();

        reporter.reportLogWithScreenshot("Account overview page.");
       // getRogersAccountOverviewPage().removeCookieAfterLogin("temp_token_r");
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));

        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
        getRogersWirelessDashboardPage().scrollToBottomOfPage();
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
        getRogersWirelessDashboardPage().clkLnkTrackPhoneRepairClaim();
        reporter.reportLogWithScreenshot("Link start or track a phone repair claim is clicked.");
        getRogersWirelessDashboardPage().clkBtnHelpYourPhoneContinue();
        reporter.reportLogWithScreenshot("Button continue in help out on your phone is clicked.");
        String strUrlExpected = TestDataHandler.ssConfig.getPhoneRepairUrl();
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyBrightstarLinkOpenSuccessfully(strUrlExpected),
				"Brightstar link opened successfully.", 
				"Brightstar link didn't redirect to expected url.");
        reporter.reportLogWithScreenshot("Brightstar link opened page.");
    }

}
