	package com.rogers.test.tests.selfserve.desktop;


import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_070_ValidateWirelessProfileAlreadyExistsTest extends BaseTestClass {

    @Test
    public void validateWirelessProfileAlreadyExists() {
                    rogers_home_page.clkSignIn();             
                    reporter.reportLogWithScreenshot("Sign in overlay");                	
                	String strBan = TestDataHandler.tc040609.getAccountDetails().getBan();
                	String strPostalCode = TestDataHandler.tc040609.getAccountDetails().getPostalcode();    	
            		rogers_login_page.switchToSignInIFrame();
            		try {
            		rogers_login_page.clickRegister();            		
            		reporter.reportLogWithScreenshot("Wireless Or Resedential Services");
            		/*=== commenting due  to changes in story DC-3077 
            		
	            		rogers_register_page.clickRegisterNow();	
	            		
	            		                	*/
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
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve_login,method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

}
