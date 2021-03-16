package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_04_05_FDM_BlockAndUnblockDataUsageForTheCTN extends BaseTestClass {	
   	
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
    public void blockFDMDataUsageForTheCTN() {
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
     
       reporter.reportLogWithScreenshot("Dashboard page");
       getCommonBusinessFlows().scrollToMiddleOfWebPage();
       reporter.reportLogWithScreenshot("Middle view of Dashboard page");
       getCommonBusinessFlows().scrollToTopOfWebPage();
    
       reporter.hardAssert(getRogersWirelessDashboardPage().isDataAccessDisplayed(),
    		   "Data access ON is displayed",
    		   "Data access ON is not displayed");
       if(!getRogersWirelessDashboardPage().isDataAccessOnDisplayed())
       {
    	   
    	onDataAccess();   
       }
                  	   
    	   reporter.reportLogWithScreenshot("Data access if set to ON");
           getRogersWirelessDashboardPage().clkDataAccessOff();
           reporter.hardAssert(getRogersWirelessDashboardPage().isDataAccessOFF(),
        		   "Data access is switch off successfully",
        		   "Data access didnt switch off successfuly , please investigate");       
           reporter.reportLogWithScreenshot("Data access set to OFf");
                 
                   
       
    }
    
    
    @Test (dependsOnMethods = "blockFDMDataUsageForTheCTN")
	public void unblockFDMDataUsageForTheCTN() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc01030405.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc01030405.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
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
     
       reporter.reportLogWithScreenshot("Dashboard page");
       getCommonBusinessFlows().scrollToMiddleOfWebPage();
       reporter.reportLogWithScreenshot("Middle view of Dashboard page");
       getCommonBusinessFlows().scrollToTopOfWebPage();
    
       reporter.hardAssert(getRogersWirelessDashboardPage().isDataAccessDisplayed(),
    		   "Data access ON is displayed",
    		   "Data access ON is not displayed");	
       if(getRogersWirelessDashboardPage().isDataAccessOnDisplayed())
       {
    	 offDataAccess();
       }
        reporter.reportLogWithScreenshot("Data access if set to OFF");
        getRogersWirelessDashboardPage().clkDataAccessOn();
        reporter.hardAssert(getRogersWirelessDashboardPage().isDataAccessOnDisplayed(),
     		   "Data access is switch ON successfully",
     		   "Data access didnt switch ON successfuly , please investigate");       
        reporter.reportLogWithScreenshot("Data access set to ON");        
    
    
    }
	
	public void offDataAccess() {
		 reporter.reportLogWithScreenshot("Data access if set to ON, switching OFF");
         getRogersWirelessDashboardPage().clkDataAccessOff();
         reporter.hardAssert(getRogersWirelessDashboardPage().isDataAccessOFF(),
      		   "Data access is switch off successfully",
      		   "Data access didnt switch off successfuly , please investigate");       
         reporter.reportLogWithScreenshot("Data access set to OFf");
	}

	public void onDataAccess() {
		reporter.reportLogWithScreenshot("Data access if set to OFF, switching it ON");
        getRogersWirelessDashboardPage().clkDataAccessOn();
        reporter.hardAssert(getRogersWirelessDashboardPage().isDataAccessOnDisplayed(),
     		   "Data access is switch ON successfully",
     		   "Data access didnt switch ON successfuly , please investigate");
	}
	
	

}
