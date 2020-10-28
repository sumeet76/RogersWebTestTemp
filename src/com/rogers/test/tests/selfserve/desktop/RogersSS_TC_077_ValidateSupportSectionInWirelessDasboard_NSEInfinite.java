package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_077_ValidateSupportSectionInWirelessDasboard_NSEInfinite extends BaseTestClass {	
   	
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
    public void validateSupportSectionOnWirelessDashboardPage() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc6577.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc6577.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc6577.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");  
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc6577.getAccountDetails().getCtn(); 
        String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length()-4);
        if (rogers_account_overview_page.isAccountShowInDropDown(strLast4DigitAccount)) {
            rogers_account_overview_page.clkDropDownAccount(strLast4DigitAccount);
        } else {
        	rogers_account_overview_page.clkSubMenuWirelessUsage();
        }
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
                       
        //rogers_wireless_dashboard_page.scrollToBottomOfPage();
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page."); 
        reporter.hardAssert(rogers_wireless_dashboard_page.verifySupportSection(), 
        					"Support section is loaded in wireless dashboard page", 
        					"Support section is NOT loaded in wireless dashboard page");
        String strBaseUrl = System.getProperty("QaUrl");
        strBaseUrl = strBaseUrl.substring(0, strBaseUrl.lastIndexOf("com")+3);
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyLinkFaqUnlockDevice(strBaseUrl), 
				"FAQ: Unlocking Device link in Support section is validated successfully.", 
				"Something wrong with FAQ: Unlocking Device link in Support section.");
        reporter.reportLogWithScreenshot("After click FAQ: Unlocking Device link."); 
        rogers_wireless_dashboard_page.navigateBacktoDashboardPage();
        
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyLinkDeviceProtection(strBaseUrl), 
				"Device Protection link in Support section is validated successfully.", 
				"Something wrong with Device protection link in Support section.");
        reporter.reportLogWithScreenshot("After click Device Protection link."); 
        rogers_wireless_dashboard_page.navigateBacktoDashboardPage();
        
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyLinkNetworkAid(strBaseUrl), 
				"Network Aid link in Support section is validated successfully.", 
				"Something wrong with Network Aid link in Support section.");
        reporter.reportLogWithScreenshot("After click Network Aid link."); 

    }
    
    
    

}
