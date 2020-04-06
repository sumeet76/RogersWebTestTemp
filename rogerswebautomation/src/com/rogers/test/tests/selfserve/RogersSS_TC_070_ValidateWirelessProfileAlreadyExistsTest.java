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


public class RogersSS_TC_070_ValidateWirelessProfileAlreadyExistsTest extends BaseTestClass {

    @Test
    public void validateWirelessProfileAlreadyExists() {
                    rogers_home_page.clkSignIn();             
                    reporter.reportLogWithScreenshot("Sign in overlay");                	
                	String strBan = TestDataHandler.tc040609.getAccountDetails().getBan();
                	String strPostalCode = TestDataHandler.tc040609.getAccountDetails().getPostalcode();    	
            		rogers_login_page.switchToSignInIFrame();
            		rogers_login_page.clickRegister();
            		reporter.reportLogWithScreenshot("Register Now");     
            		try {
	            		rogers_register_page.clickRegisterNow();
	                	reporter.reportLogWithScreenshot("Wireless Or Resedential Services");
            		}catch (Exception e) {
						//supressing firefox dead object error
					}
            		rogers_register_page.clickWirelessOrResidentialServices();
            		reporter.reportLogWithScreenshot("Set account number and Postal code");
            		rogers_register_page.setAccountNumber(strBan);
            		rogers_register_page.setPostalCode(strPostalCode);
            		reporter.reportLogWithScreenshot("Account number and postal code ");
            		rogers_register_page.clickContinue();            		
            		reporter.hardAssert(rogers_register_page.isProfileAlreadyStarted(),
            				"Message displayed: This account is registered at the following address ",
            				"The profile is not already registered, please select existing registered profile and rerun");
            		reporter.reportLogWithScreenshot("The account already registered message");

    }

    @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
		xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
	}
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

}
