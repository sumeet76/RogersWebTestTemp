package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;



public class RogersSS_TC_01_FDM_AssignDMRoleViaOverlayForFirstTimeLogin extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"RegressionSS","FDMSS"})
    public void validateAssignDMRoleViaOverlayForFirstTimeLogin() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc01030405.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc01030405.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc01030405.getAccountDetails().getBan());
        }
       reporter.reportLogWithScreenshot("Account overview page.");     
       getRogersAccountOverviewPage().clkMenuUsageAndService();
       reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
       getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
       getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible(); 
              
       reporter.reportLogWithScreenshot("dashboard page displayed");
       double totalDataValue = getRogersWirelessDashboardPage().getTotalDataVolume();
       double dataAlert = totalDataValue*0.8;
       String strDataAlert = Double.toString(dataAlert).replaceAll(",", ".");
       strDataAlert =  String.format("%.2f", new BigDecimal(Double.toString(dataAlert).replaceAll(",", ".")));
       //common_business_flows.scrollToMiddleOfWebPage();
       
       reporter.hardAssert(getRogersWirelessDashboardPage().isAddDataManagerDisplayed(),
    		   "Add data manager available for this account","Add data manager is not displayed for this account");
       getRogersWirelessDashboardPage().clkAddDataManager();
       reporter.reportLogWithScreenshot("Add data manger button clicked");
       reporter.hardAssert(getRogersWirelessDashboardPage().isChooseDataManagerOverlayDisplayed(),
        		   "Choose data manager overlay is displayed for this account", 
        		   "Choose data manager overlay is NOT available for this account");
       reporter.reportLogWithScreenshot("Add data manager overlay displayed");
       getRogersWirelessDashboardPage().selectDataManager();
       reporter.reportLogWithScreenshot("Data manager selected");
       getRogersWirelessDashboardPage().clkSaveButtonOnDataManager();
       reporter.reportLogWithScreenshot("Save data manager clicked");
      
       reporter.hardAssert(!getRogersWirelessDashboardPage().isAddDataManagerDisplayed(),
    		   "Data manager set successfully",
    		   "Data manager is not set for this account yet");
       reporter.reportLogWithScreenshot("Data manager is set");
       reporter.hardAssert(getRogersWirelessDashboardPage().isSetDataAlertDisplayed(),
    		   "Set data alert is displayed for this account", "Set data alert is not available for this account");       
       getRogersWirelessDashboardPage().clkSetDataAlert();
       reporter.reportLogWithScreenshot("Set data alert");
       reporter.hardAssert(getRogersWirelessDashboardPage().isSetDataAlertOverlayDisplayed(),
    		   "Set Data alert overlay is  displayed for this account",
    		   "Set Data alert overlay is not available for this account");
	   getRogersWirelessDashboardPage().setAlertOn();
	   reporter.reportLogWithScreenshot("Set Alert ON");
	   getRogersWirelessDashboardPage().setDataAlertValue(strDataAlert);
	   reporter.reportLogWithScreenshot("Set data alert value");
	   getRogersWirelessDashboardPage().clkSaveButtonOnDataAlertOverlay();
	   reporter.reportLogWithScreenshot("Save data alert");
	   reporter.hardAssert(getRogersWirelessDashboardPage().isDataAlertCorrectlySet(strDataAlert),
    		   "Set Data alert is  set correctly for this account", "Set data alert is not set correctly for this account");
	   reporter.reportLogWithScreenshot("Set data alert");
    }

}
