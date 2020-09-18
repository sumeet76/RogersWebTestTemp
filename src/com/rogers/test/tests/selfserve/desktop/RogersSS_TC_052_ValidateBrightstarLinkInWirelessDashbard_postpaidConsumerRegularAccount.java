package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_052_ValidateBrightstarLinkInWirelessDashbard_postpaidConsumerRegularAccount extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"RegressionSS","WirelessDashboardSS"})
    public void validateBrightstarLink() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc495271.getUsername();
    	String strPassword = TestDataHandler.tc495271.getPassword();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc495271.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc495271.getAccountDetails().getCtn();
        String strLast4Dig = strAccountNum.substring(strAccountNum.length()-4);
        if (rogers_account_overview_page.isAccountShowInDropDown(strLast4Dig)) {
            rogers_account_overview_page.clkDropDownAccount(strLast4Dig);
        } else {
        	rogers_account_overview_page.clkSubMenuWirelessUsage();
        }
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
        rogers_wireless_dashboard_page.scrollToBottomOfPage();
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
        rogers_wireless_dashboard_page.clkLnkTrackPhoneRepairClaim();
        reporter.reportLogWithScreenshot("Link start or track a phone repair claim is clicked.");
        rogers_wireless_dashboard_page.clkBtnHelpYourPhoneContinue();
        reporter.reportLogWithScreenshot("Button continue in help out on your phone is clicked.");
        String strUrlExpected = TestDataHandler.ssConfig.getPhoneRepairUrl();
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyBrightstarLinkOpenSuccessfully(strUrlExpected), 
				"Brightstar link opened successfully.", 
				"Brightstar link didn't redirect to expected url.");
        reporter.reportLogWithScreenshot("Brightstar link opened page.");
    }

}
