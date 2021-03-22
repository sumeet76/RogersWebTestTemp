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




public class RogersSS_TC_069_ValidateTotalDataAndPurchasedSpeedPass_InfiniteSE extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	
    @Test(groups = {"AddDataFlow","WirelessDashboardSS"})
    public void validateTotalDataForInfiniteSEIndividualPlan() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc6269.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc6269.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc6269.getAccountDetails().getBan());
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
	    //- Plan data: should be displayed (shared data across all lines)
		reporter.hardAssert(getRogersManageDataPage().verifyPlanDataIsDisplayed(),
				"Plan data is displayed", 
				"Plan data is NOT displayed");
		int totalSharedDataDisplayedInPlanDataSection = getRogersManageDataPage().getTotalPlanData();
		int countOfExistSpeedPass = getRogersManageDataPage().getAllExistingSpeedPassCount();
		reporter.reportLogWithScreenshot("Speed passes");
		
		getRogersManageDataPage().clkBackOnManageDataUsagePage();
		
		int totalAddedSpeedPass = getCommonBusinessFlows().addSpeedPass();	

		reporter.hardAssert(getRogersManageDataPage().validateViewDetailsLink(),
				"'Data details' page is displayed after click on view details link", 
				"'Data details' page is NOT displayed after click on view details link"); 
		reporter.reportLogWithScreenshot("Manage data page view after we click on view details"); 
		reporter.hardAssert(getRogersManageDataPage().verifyAddedDataInDataDetails(totalAddedSpeedPass,countOfExistSpeedPass),
						"Added data section is verified in 'Data details' page,"
						+ " multiple speed passes of same size displayed individually.", 
						"Added data section in 'Data details' page is not verified successfully.");  
		int countOfExistSpeedPassTotalGB = getRogersManageDataPage().getAllExistingSpeedPassTotalGB();
		getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
		reporter.reportLogWithScreenshot("Total data view");
		reporter.hardAssert(getRogersManageDataPage().verifyTotalDataInDataDetailsWithMaxSpeedAndTotalOfSpeedPasses(countOfExistSpeedPassTotalGB,totalSharedDataDisplayedInPlanDataSection),
						"Total Data: displays data plan on Max speed AND total added speed passes separately ", 
						"Total Data: NOT displays data plan on Max speed AND total added speed passes separately ");	

    }

}
