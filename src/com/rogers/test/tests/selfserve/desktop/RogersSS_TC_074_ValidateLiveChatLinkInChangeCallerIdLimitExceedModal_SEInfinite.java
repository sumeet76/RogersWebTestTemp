package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
/**
 * This script is to test the live chat link in change caller ID limit exceed modal, so the precondition is 
 * to let change caller ID exceed the limit of 3, so we have to run this script after successfully run TC50 3 times.
 * @author ning.xue
 *
 */
public class RogersSS_TC_074_ValidateLiveChatLinkInChangeCallerIdLimitExceedModal_SEInfinite extends BaseTestClass {	
   	
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
    public void validateLiveChatBadgeInChangeCallerIdLimitExceedModal() {
	
        rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc5074.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc5074.getPassword());
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		 if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
	        	reporter.reportLogWithScreenshot("Select an account.");
	            rogers_account_overview_page.selectAccount(TestDataHandler.tc5074.getAccountDetails().getBan());
	        }
        reporter.reportLogWithScreenshot("Account overview page.");  
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc5074.getAccountDetails().getCtn();
        String strLast4Dig = strAccountNum.substring(strAccountNum.length()-4);
        if (rogers_account_overview_page.isAccountShowInDropDown(strLast4Dig)) {
        	rogers_account_overview_page.clkDropDownAccount(strLast4Dig);
        } else {
        	rogers_account_overview_page.clkSubMenuWirelessUsage();
        }
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();


		rogers_wireless_dashboard_page.clickChangeMyCallerId();
		reporter.reportLogWithScreenshot("Click performed on Change caller id"); 
		
		reporter.hardAssert(rogers_change_my_caller_id_page.isExceedLimitOverlayPopup(), 
							"Change call ID limit exceed modal opened successfully.", 
							"Change call ID limit exceed modal didn't open, please check the data.");
                       
        reporter.hardAssert(rogers_change_my_caller_id_page.verifyLinkLiveChatOnExceedLimitOverlay(), 
        					"Live Chat button is displayed in Exceed Limit overlay", 
        					"Live Chat button is NOT displayed in Exceed Limit overlay");
        reporter.reportLogWithScreenshot(" Exceed Limit overlay."); 
        rogers_change_my_caller_id_page.clkLinkLiveChatOnExceedLimitOverlay();
        
        reporter.hardAssert(rogers_wireless_dashboard_page.verifyLiveChatOverlayOpened(), 
							"Live Chat overlay opened.", 
							"Live Chat overlay did NOT open, please investigate.");
        reporter.reportLogWithScreenshot("Live Chat overlay opened."); 
    } 

}
