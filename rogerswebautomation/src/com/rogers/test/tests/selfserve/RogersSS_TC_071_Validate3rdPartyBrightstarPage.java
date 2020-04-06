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



public class RogersSS_TC_071_Validate3rdPartyBrightstarPage extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validate3rdPartyBrightstarPage() {
    	String strUsername = TestDataHandler.tc495271.getUsername();
    	String strPassword = TestDataHandler.tc495271.getPassword();
        String strUrlExpected = TestDataHandler.config.getPhoneRepairUrl();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		if (rogers_wireless_dashboard_page.verifyRepairClaimModalIsDisplayed()) {
	        reporter.reportLogWithScreenshot("Repair claim page.");
	        rogers_wireless_dashboard_page.clkFirstCtnInListForRepairClaim();
	        rogers_wireless_dashboard_page.clkBtnHelpYourPhoneContinue();
	        reporter.reportLogWithScreenshot("Button continue in help out on your phone is clicked.");
		} 
        reporter.softAssert(rogers_wireless_dashboard_page.verifyBrightstarLinkOpenSuccessfully(strUrlExpected), 
				"Brightstar link opened successfully.", 
				"Brightstar link didn't redirect to expected url.");
        reporter.reportLogWithScreenshot("Brightstar link opened page.");
    }

}
