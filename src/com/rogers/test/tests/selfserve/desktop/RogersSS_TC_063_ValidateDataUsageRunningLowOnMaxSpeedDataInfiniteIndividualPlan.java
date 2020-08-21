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



public class RogersSS_TC_063_ValidateDataUsageRunningLowOnMaxSpeedDataInfiniteIndividualPlan extends BaseTestClass {	
   	
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
    public void validateDataUsageDisplayForRunningLowAndAddData() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc63.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc63.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc63.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");     
       rogers_account_overview_page.clkMenuUsageAndService();
       reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
       String strAccountNum = TestDataHandler.tc63.getAccountDetails().getCtn();
       String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length()-4);
       if (rogers_account_overview_page.isAccountShowInDropDown(strLast4DigitAccount)) {
           rogers_account_overview_page.clkDropDownAccount(strLast4DigitAccount);
       } else {
    	   rogers_account_overview_page.clkSubMenuWirelessUsage();
       }
       rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();              
       reporter.hardAssert(rogers_wireless_dashboard_page.checkIfTheDataIsTenPercentOrLess()
    		   , "Data remaining is ten percent and less"
    		   , "The data is not 10 % or less, please reduce the date and rerun the script");              
       reporter.reportLogWithScreenshot("Data remaining is ten percent and less");
       reporter.hardAssert(rogers_wireless_dashboard_page.validateDataRemainingOutOfTotalDataBucketTenPercentOrLess(),
            		"Running Low state in the usage bar ",
            		"Running Low state in the usage bar  is not displayed");	                       
       reporter.hardAssert(rogers_wireless_dashboard_page.verifySpeedPassButtonIsDisplayed(),
							"Link 'Add speed pass' is displayed",
							"Link 'Add speed pass' is not displayed");
       reporter.reportLogWithScreenshot("Add speed pass is displayed");
       reporter.hardAssert(rogers_wireless_dashboard_page.verifyCallOutMsgToAddSpeedPassIsDisplayed(),
							"Call out message to add speed pass is displayed",
							"call out message to add speed pass is not displayed");
       reporter.hardAssert(rogers_wireless_dashboard_page.verifyDataDelayMessage(),
        		"Data delay label is displayed",
        		"Data delay label is not displayed");
    }
    
    
    

}
