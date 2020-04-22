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



public class RogersSS_TC_076_ValidateScrollBarInFDMsectionOfWirelessDashboardWhenCxHasMoreThan5CTN_SE extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	/**
1. Launch Rogers.com
2. Click on Sign-in
3. Sign-in with valid credentials
4. Click on the CTN badge
5. Click on the arrow to scroll to next CTN in FDM section
6. Click on 6th CTN"	"﻿1.Rogers.com up and running
2. Sign-in pop-up will be displayed
3. Account overview page will be displayed
4. Wireless dashboard will be displayed
5. 6th CTN will be displayed 
6. Wireless dashboard respective to the 6th CTN will be displayed"
	 */
	
	
    @Test
    public void validateDataRemainingOnMaxSpeedInfiniteSE() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc6269.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc6269.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc6269.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");     
       rogers_account_overview_page.clkMenuUsageAndService();
       //For demo-line data, the sub-menu shows as "Wireless Usage"
   		rogers_account_overview_page.clkSubMenuWirelessUsage();

       rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();  
              
      
       
             
    }
    
    
    

}
