package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_03_FDM_ReassignDataManagerRole extends BaseTestClass {	
   	
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
    public void validateReassignDataManagerRole() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc60.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc60.getPassword();
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc60.getAccountDetails().getBan());
        }
        
       getCommonBusinessFlows().scrollToMiddleOfWebPage();
	   reporter.reportLogWithScreenshot("Check the number of CTNs");
	   reporter.hardAssert(getRogersAccountOverviewPage().isCTNMoreThanOne(),
				"The account has more than 1 CTNS",
				"The account doesnt have more than 1 CTNs, please add more than 1 and rerun");
	   getCommonBusinessFlows().scrollToTopOfWebPage();
       reporter.reportLogWithScreenshot("Account overview page.");     
       getRogersAccountOverviewPage().clkMenuUsageAndService();
       reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
       getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
       getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
              
       reporter.reportLogWithScreenshot("dashboard page displayed"); 
       getRogersWirelessDashboardPage().clkDataManagerCTN();
       reporter.reportLogWithScreenshot("Data Manager CTN clicked"); 
       reporter.hardAssert(getRogersWirelessDashboardPage().isChangeDataManagerDisplayed(),
    		   "Change data manager available for this account","Change data manager is not displayed for this account");
       String strDataManagerCTN = getRogersWirelessDashboardPage().getDataManagerCTN();
       reporter.reportLogWithScreenshot("Data manager CTN is : "+strDataManagerCTN); 
       String strNonDataManagerCTN = getRogersWirelessDashboardPage().getNonDataManagerCTN();
       reporter.reportLog("Non Data manager CTN is : "+strNonDataManagerCTN); 
       getRogersWirelessDashboardPage().clkChangeDataManager();
       reporter.reportLogWithScreenshot("Change data manger button clicked");
       reporter.hardAssert(getRogersWirelessDashboardPage().isChooseDataManagerOverlayDisplayed(),
        		   "Choose data manager overlay is displayed for this account", 
        		   "Choose data manager overlay is NOT available for this account");
       reporter.reportLogWithScreenshot("Choose data manager overlay displayed");       
       getRogersWirelessDashboardPage().changeDataManager(strNonDataManagerCTN);
       reporter.reportLogWithScreenshot("Data manager changes to : "+strNonDataManagerCTN);
       getRogersWirelessDashboardPage().clkSaveButtonOnDataManager();
       reporter.reportLogWithScreenshot("Save data manager clicked");
       getRogersWirelessDashboardPage().clkDataManagerCTN();
       reporter.reportLogWithScreenshot("Data Manager CTN clicked"); 
       reporter.hardAssert(getRogersWirelessDashboardPage().isChangeDataManagerSuccessful(strNonDataManagerCTN),
    		   "Data manager is changed successfully", "Data manager is not changed for this account yet");
       reporter.reportLogWithScreenshot("Change Data manager is done successfully from "+strDataManagerCTN+" this to "+strNonDataManagerCTN);
       
    }

}
