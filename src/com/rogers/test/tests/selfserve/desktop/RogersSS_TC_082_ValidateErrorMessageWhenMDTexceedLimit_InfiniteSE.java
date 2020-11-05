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




public class RogersSS_TC_082_ValidateErrorMessageWhenMDTexceedLimit_InfiniteSE extends BaseTestClass {	
   	
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
    public void validateErrorMessageWhenExceedLimitForInfiniteSEPlan() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc82.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc82.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc82.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
    	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();

        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
         
        //  - Added Data: should be included all Speed passes added for current bill cycle
        //  - Added Data: multiple speed passes of same size should be displayed individually (not summed up)
        reporter.hardAssert(getRogersWirelessDashboardPage().verifySpeedPassButtonIsDisplayed(),
				"Speed Pass button is displayed", 
				"Speed Pass button is NOT displayed");
		reporter.reportLogWithScreenshot("Wireless dashboard page."); 
		reporter.hardAssert(getRogersManageDataPage().validateViewDetailsLink(),
			"'Data details' page is displayed after click on view details link", 
			"'Data details' page is NOT displayed after click on view details link");  
		int countOfExistSpeedPass = getRogersManageDataPage().getAllExistingSpeedPassCount();
		reporter.reportLogWithScreenshot("Manage data page.");		
		getRogersManageDataPage().clkBackOnManageDataUsagePage();
		//Add speed pass to reach limit 10
		if (countOfExistSpeedPass < 10) {
			for (int counter = 0; counter + countOfExistSpeedPass < 10; counter++) {
				common_business_flows.addSpeedPass();	
			}
		}
		getRogersWirelessDashboardPage().clkBtnSpeedPass();
		reporter.hardAssert(getRogersSpeedPassPage().verifyCannotAddSpeedPassHeaderIsDisplayed(),
				"Cannot Add Speed Pass error message is displayed", 
				"Cannot Add Speed Pass error message is not displayed");  

		reporter.reportLogWithScreenshot("Error message");


    }

}
