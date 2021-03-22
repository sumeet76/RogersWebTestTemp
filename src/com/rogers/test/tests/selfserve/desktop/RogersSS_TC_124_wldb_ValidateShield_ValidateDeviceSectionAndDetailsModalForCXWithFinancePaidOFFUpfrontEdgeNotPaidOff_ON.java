package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_124_wldb_ValidateShield_ValidateDeviceSectionAndDetailsModalForCXWithFinancePaidOFFUpfrontEdgeNotPaidOff_ON extends BaseTestClass {
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"RegressionSS","WirelessDashboardSS","CAMShiled"})
    public void validateDeviceSectionOnWirelessDashboardPage() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc727375.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc727375.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc727375.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");  
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc727375.getAccountDetails().getCtn();
        String last4Digit = strAccountNum.substring(strAccountNum.length()-4);
        if (getRogersAccountOverviewPage().isAccountShowInDropDown(last4Digit)) {
            getRogersAccountOverviewPage().clkDropDownAccount(last4Digit);
        } else {
        	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
        }
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
                       
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyHeaderOfDeviceSection(),
        					"Header of Device section in wireless dashboard page verified successfully", 
        					"Header of device section in wireless dashboard page didn't show as expected.");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyDeviceBalanceOfDeviceSection(),
							"Device balance in wireless dashboard page verified successfully", 
							"Device balance in wireless dashboard page didn't show as expected.");
    	//getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Wireless dashboard page Device Section."); 
        getRogersWirelessDashboardPage().clkLinkUpgradeMyDevice();
        if (getRogersWirelessDashboardPage().isModalDeviceUpgradeAvailable()) {
            reporter.softAssert(true, 
    							"The account is not eligible for device upgrade.", 
    							"."); 
            reporter.reportLogWithScreenshot("Device Upgrade Modal opened.");
        	getRogersWirelessDashboardPage().clkCloseDeviceUpgradeModal();
        } else {
            reporter.hardAssert(getRogersWirelessDashboardPage().verifyChoosePhonePage(),
    							"Choose phone page opened successfully", 
    							"Choose phone page didn't open as expected.");       
            reporter.reportLogWithScreenshot("Choose phone page opened.");
            getRogersWirelessDashboardPage().navigateBacktoDashboardPage();
        }

        if(getRogersWirelessDashboardPage().isDeviceClosingDateMsgAvailable()) {

            reporter.hardAssert(getRogersWirelessDashboardPage().verifyDeviceClosingDateMsgIfAvailable(),
    							"Device balance closing date message verified successfully", 
    							"Device balance closing date message didn't show as expected.");
            reporter.hardAssert(getRogersWirelessDashboardPage().verifyMyDeviceDetailsModalOfDeviceSection(),
    							"View details modal verified successfully", 
    							"View details modal didn't show activation date and expire date as expected.");    
            reporter.reportLogWithScreenshot("View details modal opened."); 
            getRogersWirelessDashboardPage().clkCloseMyDeviceDetailsModal();
        }else {
            reporter.hardAssert(getRogersWirelessDashboardPage().verifyLinkMyDeviceDetailsOfDeviceSection(),
    							"View details modal opened successfully", 
    							"View details modal didn't open as expected.");       
            getRogersWirelessDashboardPage().clkCloseMyDeviceDetailsModal();
        }
    }
    
}
