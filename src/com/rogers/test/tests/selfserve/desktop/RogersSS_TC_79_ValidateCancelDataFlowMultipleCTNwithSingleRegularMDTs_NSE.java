package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;



public class RogersSS_TC_79_ValidateCancelDataFlowMultipleCTNwithSingleRegularMDTs_NSE extends BaseTestClass {	
   	
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
    public void validateCancelSingleMDTFlowNSEWithMultiline() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc56.getUsername();
    	String strPassword = TestDataHandler.tc56.getPassword();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
//        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
//        	reporter.reportLogWithScreenshot("Select an account.");
//            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc59.getAccountDetails().getBan());
//        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc56.getAccountDetails().getCtn();
        getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
        reporter.reportLogWithScreenshot("Dashboard page");
        getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Dashboard My Plan");
        
       	Map<String, Integer> countOfActiveAndCancelledAddDataOnMyPlan = getRogersWirelessDashboardPage().getAllExistingAddDataCountCancelledAndActiveOnMyPlanSection();
       	getRogersWirelessDashboardPage().scrollToTopOfDasboardPage();
		//4. Click on View details in usage dashboard
		  reporter.softAssert(getRogersManageDataPage().validateViewDetailsLink(),
							"'Manage Data' page is displayed after click on view details link", 
							"'Manage Data' page is NOT displayed after click on view details link");  
        reporter.reportLogWithScreenshot("Manage data page view after we click on view details");  
      
		Map<String, Integer> countOfActiveAndCancelledAddData = getRogersManageDataPage().getAllExistingAddDataCountCancelledAndActive();
		reporter.reportLogWithScreenshot("Manage Data page");
		//Comparisions Before Cancel:
		reporter.softAssert((countOfActiveAndCancelledAddDataOnMyPlan.get("cancelled")==countOfActiveAndCancelledAddData.get("cancelled")
							&& countOfActiveAndCancelledAddDataOnMyPlan.get("active")==countOfActiveAndCancelledAddData.get("active"))
				, "The number of cancelled and active add on macth on my plans and manage data page", 
				"The number of cancelled and active add on does not macth on my plans and manage data page");
		
		if((countOfActiveAndCancelledAddData.get("active")>=1))
		{
			
			reporter.reportLogWithScreenshot("Click on cancel MTT Link");
			getRogersManageDataPage().clkCancelMDTLink();
			reporter.reportLogWithScreenshot("Click on Yes Remove Top Up");
			getRogersManageDataPage().clkYesRemoveTopUpButton();
			reporter.hardAssert(getRogersManageDataPage().isCancelSuccessdisplayed(),
					"Cancel MDT success",
					"MDT cancel not successful");
			reporter.reportLogWithScreenshot("Cancel successful");
			getRogersManageDataPage().clkCloseButtonOnCancelSuccessOverlay();
			reporter.reportLogWithScreenshot("Close overlay");
			
			common_business_flows.scrollToTopOfWebPage();
			getRogersManageDataPage().clkBackOnManageDataUsagePage();
			reporter.reportLogWithScreenshot("Back on dashboard");
			
			common_business_flows.logOutAndReSignIn(strUsername, strPassword);			        
			//rechange to the original one
			if(getRogersAccountOverviewPage().verifySuccessfulLogin())
			{
//				if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
//		        	reporter.reportLogWithScreenshot("Select an account.");
//		            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc59.getAccountDetails().getBan());
//		        }
		        reporter.reportLogWithScreenshot("Account overview page.");
		        
		        getRogersAccountOverviewPage().clkMenuUsageAndService();
		        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
	            getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
		        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
		        getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
				reporter.reportLogWithScreenshot("dashboard page");				
				reporter.reportLogWithScreenshot("My Plan Details");
				//All the added OTT are reflected in total bucket,plan section and manage data page
				reporter.hardAssert(getRogersWirelessDashboardPage().verifyCancelledAddedDataInMyPlan(1, countOfActiveAndCancelledAddDataOnMyPlan.get("cancelled"))
						,"Expires MMM DD - is displayed next to the cancelled MDT in plan section",
						"Expires MMM DD - is NOT displayed next to the cancelled MDT in plan section");
				
				getRogersWirelessDashboardPage().scrollToTopOfDasboardPage();
				reporter.hardAssert(getRogersManageDataPage().validateViewDetailsLink(),
						"'Data details' page is displayed after click on view details link",
						"'Data details' page is NOT displayed after click on view details link");				
				reporter.hardAssert(getRogersManageDataPage().verifyCancelledMDTInManageData(1,countOfActiveAndCancelledAddData.get("cancelled")),
						"Expires MMM DD - is displayed next to the cancelled MDT in manage data page",
						"Expires MMM DD - is NOT displayed next to the cancelled MDT in manage data page, plase investigate");	
				
			}
				
		}else
		{
			reporter.reportLogFail("No MDT to cancel, please add MDT and rerun the script");
		}
							

	}
    

}
