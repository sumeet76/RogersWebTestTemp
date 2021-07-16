package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 *  De-scoped-Need Manually Change PP from CSM
 * @author ning.xue
 *
 */

public class RogersSS_TC_068_ValidatePricePlanChangeToInfiniteSharedPlan extends BaseTestClass {	
   	
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
    public void validateTotalDataForInfiniteIndividualPlan() {
    	getRogersHomePage().clkSignIn();
//    	String strUsername = TestDataHandler.tc68.getUsername();
//    	getRogersLoginPage().switchToSignInIFrame();
//        getRogersLoginPage().setUsernameIFrame(strUsername);
//        String strPassword = TestDataHandler.tc68.getPassword();    	
//        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
//            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc68.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
//        String strAccountNum = TestDataHandler.tc68.getAccountDetails().getCtn();        
//        String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length()-4);
//        if (getRogersAccountOverviewPage().isAccountShowInDropDown(strLast4DigitAccount)) {
//            getRogersAccountOverviewPage().clkDropDownAccount(strLast4DigitAccount);
//        } else {
//        	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
//        }
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
               
        /*
         * 
		4.  Data usage detail should not be displayed 
- Infinite Shared plan  banner should be displyed 
- Error message should be displyed:
Since you've made the recent change, usage details won't be available until your next billing cycle.	
         */
        reporter.reportLogWithScreenshot("Dashboard View");        
        reporter.hardAssert(getRogersWirelessDashboardPage().verifySpeedReducedMsg(),
            		"Usage page displays  the reduced speeds message",
            		"Usage page does not displays the reduced speeds message");	        
               
        reporter.hardAssert(getRogersWirelessDashboardPage().verifySpeedPassButtonIsDisplayed(),
							"Link add speed pass is displayed",
							"Link add speed pass is not displayed");
        reporter.reportLogWithScreenshot("Add speed pass is displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyCallOutMsgToAddSpeedPassIsDisplayed(),
							"Call out message to Add speed pass is displayed",
							"call out message to add speed pass is not displayed");
        
        //6. User navigate to overview page and again click on usage & service tab
		//call out message should not be displayed (within same session)
        getRogersWirelessDashboardPage().clickOverview();
        reporter.reportLogWithScreenshot("Account overview page.");   
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");       
//        if (getRogersAccountOverviewPage().isAccountShowInDropDown(strLast4DigitAccount)) {
//            getRogersAccountOverviewPage().clkDropDownAccount(strLast4DigitAccount);
//        } else {
//        	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
//        }
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
                
        reporter.hardAssert(!getRogersWirelessDashboardPage().verifyCallOutMsgToAddSpeedPassIsDisplayed(),
				"Call out message to Add speed pass is NOT displayed",
				"call out message to add speed pass is displayed even after closing in the same session, please investigate");
        
    }
    
   
    

}
