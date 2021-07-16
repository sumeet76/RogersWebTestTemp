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
	
	
    @Test(groups = {"RegressionSS","WirelessDashboardSS"})
    public void validateLiveChatBadgeInChangeCallerIdLimitExceedModal() {
	
        getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc5074.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc5074.getPassword());
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
		 if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
	        	reporter.reportLogWithScreenshot("Select an account.");
	            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc5074.getAccountDetails().getBan());
	        }
        reporter.reportLogWithScreenshot("Account overview page.");  
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc5074.getAccountDetails().getCtn();
        String strLast4Dig = strAccountNum.substring(strAccountNum.length()-4);
        if (getRogersAccountOverviewPage().isAccountShowInDropDown(strLast4Dig)) {
        	getRogersAccountOverviewPage().clkDropDownAccount(strLast4Dig);
        } else {
        	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
        }
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();


		getRogersWirelessDashboardPage().clickChangeMyCallerId();
		reporter.reportLogWithScreenshot("Click performed on Change caller id"); 
		
		reporter.hardAssert(getRogersChangeMyCallerIdPage().isExceedLimitOverlayPopup(),
							"Change call ID limit exceed modal opened successfully.", 
							"Change call ID limit exceed modal didn't open, please check the data.");
                       
        reporter.hardAssert(getRogersChangeMyCallerIdPage().verifyLinkLiveChatOnExceedLimitOverlay(),
        					"Live Chat button is displayed in Exceed Limit overlay", 
        					"Live Chat button is NOT displayed in Exceed Limit overlay");
        reporter.reportLogWithScreenshot(" Exceed Limit overlay."); 
        getRogersChangeMyCallerIdPage().clkLinkLiveChatOnExceedLimitOverlay();
        
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyLiveChatOverlayOpened(),
							"Live Chat overlay opened.", 
							"Live Chat overlay did NOT open, please investigate.");
        reporter.reportLogWithScreenshot("Live Chat overlay opened."); 
    } 

}
