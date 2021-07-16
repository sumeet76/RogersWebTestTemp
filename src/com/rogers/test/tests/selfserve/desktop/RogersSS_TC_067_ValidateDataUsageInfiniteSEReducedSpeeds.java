package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;                     
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;



public class RogersSS_TC_067_ValidateDataUsageInfiniteSEReducedSpeeds extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
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
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc67.getUsername();
    	//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc67.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc67.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");     
       getRogersAccountOverviewPage().clkMenuUsageAndService();
       reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
       String strAccountNum = TestDataHandler.tc67.getAccountDetails().getCtn();
       String strLast4Digit = strAccountNum.substring(strAccountNum.length()-4);

       	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();

       getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();  
                           
		reporter.hardAssert(getRogersWirelessDashboardPage().verifySpeedReducedMsg(),
						"Label using data at reduced speed is displayed",
						"Label using data at reduced speed is not displayed");
		reporter.hardAssert(getRogersWirelessDashboardPage().verifySpeedPassButtonIsDisplayed(),
						"Link add speed pass is displayed",
						"Link add speed pass is not displayed");
		reporter.hardAssert(getRogersWirelessDashboardPage().verifyCallOutMsgToAddSpeedPassIsDisplayed(),
						"Call out message to Add speed pass is displayed",
						"call out message to add speed pass is not displayed");
		getRogersWirelessDashboardPage().clkCloseCallOutMsg();
		reporter.softAssert(getRogersWirelessDashboardPage().validateCloseCallOutIsClosed(),
						"Click on close call out message successful",
						"Click on close call out message didnt succeed");
		reporter.reportLogWithScreenshot("Closed Call out message to Add speed pass on dashboard page.");  
		getRogersAccountOverviewPage().clickOverview();		              			       
		   reporter.reportLogWithScreenshot("Account overview page.");      		
		   getRogersAccountOverviewPage().clkMenuUsageAndService();
		   reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
		   if (getRogersAccountOverviewPage().isAccountShowInDropDown(strLast4Digit)) {
	           getRogersAccountOverviewPage().clkDropDownAccount(strLast4Digit);
	       } else {
	       	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
	       }
		
		   reporter.reportLogWithScreenshot("Navigated back to dashboard from account overview");     
		   reporter.softAssert(getRogersWirelessDashboardPage().validateCloseCallOutIsClosed(),
					"call out message is not displayed (within same session)",
					"call out message should not be displayed (within same session)");  
		   reporter.reportLogWithScreenshot("Dashboard with Call out message not displayed in same session");             
    }
    
    
    

}
