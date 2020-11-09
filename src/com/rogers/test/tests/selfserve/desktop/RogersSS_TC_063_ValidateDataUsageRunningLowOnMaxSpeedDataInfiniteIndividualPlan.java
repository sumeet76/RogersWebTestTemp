package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_063_ValidateDataUsageRunningLowOnMaxSpeedDataInfiniteIndividualPlan extends BaseTestClass {	
   	
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
    public void validateDataUsageDisplayForRunningLowAndAddData() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc63.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc63.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc63.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");     
       getRogersAccountOverviewPage().clkMenuUsageAndService();
       reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
       String strAccountNum = TestDataHandler.tc63.getAccountDetails().getCtn();
       String strLast4DigitAccount = strAccountNum.substring(strAccountNum.length()-4);
       if (getRogersAccountOverviewPage().isAccountShowInDropDown(strLast4DigitAccount)) {
           getRogersAccountOverviewPage().clkDropDownAccount(strLast4DigitAccount);
       } else {
    	   getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
       }
       getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
       reporter.hardAssert(getRogersWirelessDashboardPage().checkIfTheDataIsTenPercentOrLess()
    		   , "Data remaining is ten percent and less"
    		   , "The data is not 10 % or less, please reduce the date and rerun the script");              
       reporter.reportLogWithScreenshot("Data remaining is ten percent and less");
       reporter.hardAssert(getRogersWirelessDashboardPage().validateDataRemainingOutOfTotalDataBucketTenPercentOrLess(),
            		"Running Low state in the usage bar ",
            		"Running Low state in the usage bar  is not displayed");	                       
       reporter.hardAssert(getRogersWirelessDashboardPage().verifySpeedPassButtonIsDisplayed(),
							"Link 'Add speed pass' is displayed",
							"Link 'Add speed pass' is not displayed");
       reporter.reportLogWithScreenshot("Add speed pass is displayed");
       reporter.hardAssert(getRogersWirelessDashboardPage().verifyCallOutMsgToAddSpeedPassIsDisplayed(),
							"Call out message to add speed pass is displayed",
							"call out message to add speed pass is not displayed");
       reporter.hardAssert(getRogersWirelessDashboardPage().verifyDataDelayMessage(),
        		"Data delay label is displayed",
        		"Data delay label is not displayed");
    }
    
    
    

}
