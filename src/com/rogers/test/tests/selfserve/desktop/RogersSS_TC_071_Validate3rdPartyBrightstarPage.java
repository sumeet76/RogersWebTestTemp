package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_071_Validate3rdPartyBrightstarPage extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validate3rdPartyBrightstarPage() { 
    	reporter.reportLogWithScreenshot("Rogers launched");
    	String strDeepLinkURL = TestDataHandler.ssConfig.getRogersURL().split(".com")[0]+".com"+TestDataHandler.ssConfig.getRepairClaimUrl();
    	getDriver().get(strDeepLinkURL);
    	reporter.reportLogWithScreenshot("After setting the deeplink : "+strDeepLinkURL);
    	reporter.hardAssert(rogers_login_page.isSignInFrameDisplayed()
    	    		   , "When a user is not logged into an account and deep link URL is entered, it is asking the user to login first"
    	    		   , "The login pop up didnt show up for non logged in user after entering deep link");
    	String strUsername = TestDataHandler.tc495271.getUsername();
    	String strPassword = TestDataHandler.tc495271.getPassword();
        String strUrlExpected = TestDataHandler.ssConfig.getPhoneRepairUrl();
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
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyBrightstarLinkOpenSuccessfully(strUrlExpected), 
				"Brightstar link opened successfully.", 
				"Brightstar link didn't redirect to expected url.");
        reporter.reportLogWithScreenshot("Brightstar link opened page.");
    }

}
