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



public class RogersSS_TC_076_ValidateScrollBarInFDMsectionOfWirelessDashboardWhenCxHasMoreThan5CTN_SE extends BaseTestClass {	
   	
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
    public void validateScrollBarInFDMsectionOfWirelessDashboardWhenCxHasMoreThan5CTN_SE() {
    	rogers_home_page.clkSignIn();
    	//TODO create new data file
    	String strUsername = TestDataHandler.tc7681.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc7681.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
		common_business_flows.scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Check the number of CTNs");
		reporter.hardAssert(rogers_account_overview_page.isCTNMoreThanSix(),
				"The account has more than 5 CTNS",
				"The account doesnt have more than 5 CTN's, please add more than 5 and rerun");
		common_business_flows.scrollToTopOfWebPage();
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc7681.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");     
       rogers_account_overview_page.clkMenuUsageAndService();
       //For demo-line data, the sub-menu shows as "Wireless Usage"
   		rogers_account_overview_page.clkSubMenuWirelessUsage();

       rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();  
              
       reporter.hardAssert(rogers_wireless_dashboard_page.isScrollForCTNsPresent(),
    		   "The scroll for CTNS is present",
    		   "The scroll for CTNs not present");
       rogers_wireless_dashboard_page.clkLeftCTNScrollArrow();
       rogers_wireless_dashboard_page.clkLeftCTNScrollArrow();
       reporter.reportLogWithScreenshot("Click on left scroll performed"); 
       rogers_wireless_dashboard_page.clkTheNthCTNOnDashboardPage(1);
       reporter.reportLogWithScreenshot("Click 1st CTN");
       reporter.softAssert(rogers_wireless_dashboard_page.isSixthCTNBadgeInVisibleBeforeScrollingOnDashBoard(),
    		   "6th CTN badge is not visible before scroll",
    		   "6th CTN is visible before scroll");
       rogers_wireless_dashboard_page.clkNextCTNScrollArrow();
       reporter.softAssert(rogers_wireless_dashboard_page.isSixthCTNVisible(),
    		   "6th CTN badge is visible After click on  scroll",
    		   "6th CTN is not visible after click on scrol scroll");
       rogers_wireless_dashboard_page.clkTheSixthCTN();
       reporter.reportLogWithScreenshot("Clicked 6th CTN and wireless dashboard loaded for 6th"); 
    }
    
    
    

}
