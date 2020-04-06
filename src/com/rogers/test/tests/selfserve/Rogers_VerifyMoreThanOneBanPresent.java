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


public class Rogers_VerifyMoreThanOneBanPresent extends BaseTestClass {

    @Test
    public void viewBillTest() {
        rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame("solarisconsumer1-rogers10@yahoo.com");
		rogers_login_page.setPasswordIFrame("Rogers123");
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {        	
        	reporter.reportLogWithScreenshot("Select an account overlay.");
            rogers_account_overview_page.selectAccount("930668694");
        }
		
        rogers_account_overview_page.clickAccount();
        reporter.reportLogWithScreenshot("Account overlay is displayed");
        reporter.softAssert(rogers_account_overview_page.isMoreThanOneBanPresent(), 
        		"More than one Ban is present", 
        		"More than one Ban not displayed in the Account Submenu");        
    }

    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
	}
   	
   	
   	@AfterMethod(alwaysRun = true)
   	public void afterTest() throws InterruptedException {
   		closeSession();
   	}


}
