package com.rogers.test.tests.selfserve;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;



public class RogersSS_TC_072_wldb_ValidateDetailsOfDeviceSection extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validateDeviceSectionOnWirelessDashboardPage() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc727375.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc727375.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc727375.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");  
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc727375.getAccountDetails().getCtn();
        String last4Digit = strAccountNum.substring(strAccountNum.length()-4);
        if (rogers_account_overview_page.isAccountShowInDropDown(last4Digit)) {
            rogers_account_overview_page.clkDropDownAccount(last4Digit);
        } else {
        	rogers_account_overview_page.clkSubMenuWirelessUsage();
        }
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
                       
        reporter.softAssert(rogers_wireless_dashboard_page.verifyHeaderOfDeviceSection(), 
        					"Header of Device section in wireless dashboard page verified successfully", 
        					"Header of device section in wireless dashboard page didn't show as expected.");
        reporter.softAssert(rogers_wireless_dashboard_page.verifyDeviceBalanceOfDeviceSection(), 
							"Device balance in wireless dashboard page verified successfully", 
							"Device balance in wireless dashboard page didn't show as expected.");
    	rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Wireless dashboard page Device Section."); 
        rogers_wireless_dashboard_page.clkLinkUpgradeMyDevice();
        if (rogers_wireless_dashboard_page.isModalDeviceUpgradeAvailable()) {
            reporter.softAssert(true, 
    							"The account is not eligible for device upgrade.", 
    							"."); 
            reporter.reportLogWithScreenshot("Device Upgrade Modal opened.");
        	rogers_wireless_dashboard_page.clkCloseDeviceUpgradeModal();
        } else {
            reporter.softAssert(rogers_wireless_dashboard_page.verifyChoosePhonePage(), 
    							"Choose phone page opened successfully", 
    							"Choose phone page didn't open as expected.");       
            reporter.reportLogWithScreenshot("Choose phone page opened.");
            rogers_wireless_dashboard_page.navigateBacktoDashboardPage();
        }

        if(rogers_wireless_dashboard_page.isDeviceClosingDateMsgAvailable()) {

            reporter.softAssert(rogers_wireless_dashboard_page.verifyDeviceClosingDateMsgIfAvailable(), 
    							"Device balance closing date message verified successfully", 
    							"Device balance closing date message didn't show as expected.");
            reporter.softAssert(rogers_wireless_dashboard_page.verifyMyDeviceDetailsModalOfDeviceSection(), 
    							"View details modal verified successfully", 
    							"View details modal didn't show activation date and expire date as expected.");    
            reporter.reportLogWithScreenshot("View details modal opened."); 
            rogers_wireless_dashboard_page.clkCloseMyDeviceDetailsModal();
        }else {
            reporter.softAssert(rogers_wireless_dashboard_page.verifyLinkMyDeviceDetailsOfDeviceSection(), 
    							"View details modal opened successfully", 
    							"View details modal didn't open as expected.");       
            rogers_wireless_dashboard_page.clkCloseMyDeviceDetailsModal();
        }
    }
    
}
