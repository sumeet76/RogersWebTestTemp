package com.rogers.test.tests.selfserve.desktop;

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



public class RogersSS_TC_067_ValidateDataUsageInfiniteSEReducedSpeeds extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	/** == Pre conditions =====	 * 
		1. Infinite Shared plan  
		2. Multi lines
		3. Demo line (Real time Data)
		4. User run out of data on their Max speed plan (used total backet data)
	 */
			
	
    @Test
    public void validateDataUsageInfiniteSEReducedSpeeds() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc67.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc67.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc67.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");     
       rogers_account_overview_page.clkMenuUsageAndService();
       reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
       String strAccountNum = TestDataHandler.tc67.getAccountDetails().getCtn();
       String strLast4Digit = strAccountNum.substring(strAccountNum.length()-4);

       	rogers_account_overview_page.clkSubMenuWirelessUsage();

       rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();  
                           
		reporter.softAssert(rogers_wireless_dashboard_page.verifySpeedReducedMsg(),
						"Label using data at reduced speed is displayed",
						"Label using data at reduced speed is not displayed");
		reporter.softAssert(rogers_wireless_dashboard_page.verifySpeedPassButtonIsDisplayed(),
						"Link add speed pass is displayed",
						"Link add speed pass is not displayed");
		reporter.softAssert(rogers_wireless_dashboard_page.verifyCallOutMsgToAddSpeedPassIsDisplayed(),
						"Call out message to Add speed pass is displayed",
						"call out message to add speed pass is not displayed");
		rogers_wireless_dashboard_page.clkCloseCallOutMsg();
		reporter.softAssert(rogers_wireless_dashboard_page.validateCloseCallOutIsClosed(),
						"Click on close call out message successful",
						"Click on close call out message didnt succeed");
		reporter.reportLogWithScreenshot("Closed Call out message to Add speed pass on dashboard page.");  
		rogers_account_overview_page.clickOverview();		              			       
		   reporter.reportLogWithScreenshot("Account overview page.");      		
		   rogers_account_overview_page.clkMenuUsageAndService();
		   reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
		   if (rogers_account_overview_page.isAccountShowInDropDown(strLast4Digit)) {
	           rogers_account_overview_page.clkDropDownAccount(strLast4Digit);
	       } else {
	       	rogers_account_overview_page.clkSubMenuWirelessUsage();
	       }
		
		   reporter.reportLogWithScreenshot("Navigated back to dashboard from account overview");     
		   reporter.softAssert(rogers_wireless_dashboard_page.validateCloseCallOutIsClosed(),
					"call out message is not displayed (within same session)",
					"call out message should not be displayed (within same session)");  
		   reporter.reportLogWithScreenshot("Dashboard with Call out message not displayed in same session");             
    }
    
    
    

}
