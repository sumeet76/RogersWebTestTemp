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

/**
 *  De-scoped-Need Manually Change PP from CSM
 * @author ning.xue
 *
 */

public class RogersSS_TC_068_ValidatePricePlanChangeToInfiniteSharedPlan extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	
    @Test
    public void validateTotalDataForInfiniteIndividualPlan() {
    	rogers_home_page.clkSignIn();
//    	String strUsername = TestDataHandler.tc68.getUsername();
//    	rogers_login_page.switchToSignInIFrame();
//        rogers_login_page.setUsernameIFrame(strUsername);
//        String strPassword = TestDataHandler.tc68.getPassword();    	
//        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
//            rogers_account_overview_page.selectAccount(TestDataHandler.tc68.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
//        String strAccountNum = TestDataHandler.tc68.getAccountDetails().getCtn();        
//        String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length()-4);
//        if (rogers_account_overview_page.isAccountShowInDropDown(strLast4DigitAccount)) {
//            rogers_account_overview_page.clkDropDownAccount(strLast4DigitAccount);
//        } else {
//        	rogers_account_overview_page.clkSubMenuWirelessUsage();
//        }
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
               
        /*
         * 
		4.  Data usage detail should not be displayed 
- Infinite Shared plan  banner should be displyed 
- Error message should be displyed:
Since you've made the recent change, usage details won't be available until your next billing cycle.	
         */
        reporter.reportLogWithScreenshot("Dashboard View");        
        reporter.hardAssert(rogers_wireless_dashboard_page.verifySpeedReducedMsg(),
            		"Usage page displays  the reduced speeds message",
            		"Usage page does not displays the reduced speeds message");	        
               
        reporter.hardAssert(rogers_wireless_dashboard_page.verifySpeedPassButtonIsDisplayed(),
							"Link add speed pass is displayed",
							"Link add speed pass is not displayed");
        reporter.reportLogWithScreenshot("Add speed pass is displayed");
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyCallOutMsgToAddSpeedPassIsDisplayed(),
							"Call out message to Add speed pass is displayed",
							"call out message to add speed pass is not displayed");
        
        //6. User navigate to overview page and again click on usage & service tab
		//call out message should not be displayed (within same session)
        rogers_wireless_dashboard_page.clickOverview();
        reporter.reportLogWithScreenshot("Account overview page.");   
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");       
//        if (rogers_account_overview_page.isAccountShowInDropDown(strLast4DigitAccount)) {
//            rogers_account_overview_page.clkDropDownAccount(strLast4DigitAccount);
//        } else {
//        	rogers_account_overview_page.clkSubMenuWirelessUsage();
//        }
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
                
        reporter.hardAssert(!rogers_wireless_dashboard_page.verifyCallOutMsgToAddSpeedPassIsDisplayed(),
				"Call out message to Add speed pass is NOT displayed",
				"call out message to add speed pass is displayed even after closing in the same session, please investigate");
        
    }
    
   
    

}
