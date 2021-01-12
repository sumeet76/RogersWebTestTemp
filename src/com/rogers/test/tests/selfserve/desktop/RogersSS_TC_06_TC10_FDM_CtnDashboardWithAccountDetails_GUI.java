package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;



public class RogersSS_TC_06_TC10_FDM_CtnDashboardWithAccountDetails_GUI extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
/**
﻿1. Rogers.com CSS should be launched successfully
2. Login should be successful and Accounts should be displayed
3. Account overview page should be displayed
4. Individual CTN bucket details, Usage, Price Plan details along with Change Plan & Change number 
button should be displayed n Share Everything Dashboard		   	
 * @throws InterruptedException
 */
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"RegressionSS","FDMSS"})
    public void validateFdmCtnDashboardWithAccountDetails() {
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
       
       reporter.reportLogWithScreenshot("Click on data manager CTN");
       getRogersWirelessDashboardPage().clkDataManagerCTN();
       
       //usage dashboard area is displayed
       reporter.reportLogWithScreenshot("usage dashboard area is displayed");
       reporter.hardAssert(getRogersWirelessDashboardPage().verifyTotalDataBucket(),
    		   "Total data bucket is displayed", "Total data ");
       reporter.hardAssert(getRogersWirelessDashboardPage().verifyDataRemainingOutOfTotalDataBucket(),
    		   "data remaining out of total data bucket is dsiplayed", 
    		   "data remaining out of total data bucket is NOT displayed");
       reporter.hardAssert(getRogersWirelessDashboardPage().verifyDaysRemainingInTheBillCycleIsDisplayed(),
    		   "Days remaining in the bill cycle is displayed",
    		   "Days remaining in the bill cycle is not displayed");
       
       getCommonBusinessFlows().scrollToMiddleOfWebPage();
       reporter.reportLogWithScreenshot("Price Plan details along with Change Plan & Change number button");
       //Price Plan details along with Change Plan & Change number button
       reporter.hardAssert(getRogersWirelessDashboardPage().verifyChangePlanButtonDisplayed(),
				"Change Plan button is displayed", 
				"Change plan button is not displayed");
       
       reporter.softAssert(getRogersWirelessDashboardPage().verifyChangeMyNumberDisplayed(),
				"Change my number is displayed", 
				"Change my number is not displayed");
                     
       reporter.softAssert(getRogersWirelessDashboardPage().verifyHeaderOfDeviceSection(),
				"Header of Device section in wireless dashboard page verified successfully", 
				"Header of device section in wireless dashboard page didn't show as expected.");		
		//getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
		reporter.reportLogWithScreenshot("Wireless dashboard page Device Section."); 
		reporter.softAssert((getRogersWirelessDashboardPage().isSeeOffersOnNewPhonesDisplayed()
				|| getRogersWirelessDashboardPage().verifyLinkUpgradeMyDevice()),				
				"Device balance in wireless dashboard page verified successfully", 
				"Device balance in wireless dashboard page didn't show as expected.");
	
		//4.Share everything dashboard displayed successfully with
		//Data access, stream saver, data alert buttons in the wireless dashboard.
		 reporter.hardAssert(getRogersWirelessDashboardPage().verifyDataAccessDisplayed(),
					"Data access is displayed", 
					"Data access is not displayed");
		 reporter.softAssert(getRogersWirelessDashboardPage().verifyStreamSaverDisplayed(),
					"Stream Saver is displayed", 
					"Stream Saver is not displayed");
		 reporter.softAssert(getRogersWirelessDashboardPage().verifyDataAlertDisplayed(),
					"Data alert is displayed", 
					"Data alert is not displayed");		 
		 reporter.softAssert(getRogersWirelessDashboardPage().verifyDataManagerDisplayed(),
					"Data manager is displayed", 
					"Data manager is not displayed");	
		 
		  getCommonBusinessFlows().scrollToBottomOfWebPage();
	      reporter.reportLogWithScreenshot("Dashboard bottom view");
    }

}
