package com.rogers.test.tests.buyflows;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;

public class TestHeadless extends BaseTestClass{
	
	@Test
    public void performSingleLineAAL() {
		reporter.reportLogWithScreenshot("Home Page");
		rogers_home_page.clkSignIn();
	    rogers_login_page.switchToSignInIFrame();
	    rogers_login_page.setUsernameIFrame(TestDataHandler.testCase01.getUsername());
	    rogers_login_page.setPasswordIFrame(TestDataHandler.testCase01.getPassword());
	    reporter.reportLogWithScreenshot("Login Page");
	    rogers_login_page.clkSignInIFrame();
	    reporter.reportLogWithScreenshot("Initial Setup Reminder Page");
	    rogers_login_page.clkSkipIFrame();
	    rogers_login_page.switchOutOfSignInIFrame();
	    Assert.assertTrue(rogers_account_overview_page.isMoreThanOneBanPresentInThePopUp(), "More than one Ban is not displayed in the pop up");
	}
	
    @BeforeTest @Parameters({ "strBrowser", "strLanguage","strGroupName"})
	public void beforeTest(String strBrowser, String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.bfaConfig.getRogersURL(), strBrowser, strLanguage, strGroupName, method);
	}
    
    @AfterTest(alwaysRun = true)
    public void afterTest() {
    	closeSession();
    }

}
