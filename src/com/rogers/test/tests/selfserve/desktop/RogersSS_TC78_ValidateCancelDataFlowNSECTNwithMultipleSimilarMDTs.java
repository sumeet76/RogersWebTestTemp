package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;

import java.util.Map;
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



public class RogersSS_TC78_ValidateCancelDataFlowNSECTNwithMultipleSimilarMDTs extends BaseTestClass {	
    
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
    public void validateCancelMDTFlowNSEWithMultipleMDT() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc78.getUsername();
    	String strPassword = TestDataHandler.tc78.getPassword();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc78.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc78.getAccountDetails().getCtn();
        if (rogers_account_overview_page.isAccountShowInDropDown(strAccountNum.substring(strAccountNum.length()-4))) {
            rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        } else {
        	rogers_account_overview_page.clkSubMenuWirelessUsage();
        }
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
        reporter.reportLogWithScreenshot("Dashboard page");
        rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Dashboard My Plan");
        
       	Map<String, Integer> countOfActiveAndCancelledAddDataOnMyPlan = rogers_wireless_dashboard_page.getAllExistingAddDataCountCancelledAndActiveOnMyPlanSection();			
       	rogers_wireless_dashboard_page.scrollToTopOfDasboardPage();
		//4. Click on View details in usage dashboard
		  reporter.hardAssert(rogers_manage_data_page.validateViewDetailsLink(), 
							"'Manage Data' page is displayed after click on view details link", 
							"'Manage Data' page is NOT displayed after click on view details link");  
        reporter.reportLogWithScreenshot("Manage data page view after we click on view details");  
      
		Map<String, Integer> countOfActiveAndCancelledAddData = rogers_manage_data_page.getAllExistingAddDataCountCancelledAndActive();
		reporter.reportLogWithScreenshot("Manage Data page");
		//Comparisons Before Cancel:
		reporter.hardAssert((countOfActiveAndCancelledAddDataOnMyPlan.get("cancelled")==countOfActiveAndCancelledAddData.get("cancelled")
							&& countOfActiveAndCancelledAddDataOnMyPlan.get("active")==countOfActiveAndCancelledAddData.get("active"))
				, "The number of cancelled and active add on macth on my plans and manage data page", 
				"The number of cancelled and active add on does not macth on my plans and manage data page");
				
		//TODO add mutiple similar MDT's
		
		
		if((countOfActiveAndCancelledAddData.get("active")>=1))
		{
			
			reporter.reportLogWithScreenshot("Click on cancel MTT Link");
			rogers_manage_data_page.clkCancelMDTLink();			
			reporter.reportLogWithScreenshot("Click on Yes Remove Top Up");
			rogers_manage_data_page.clkYesRemoveTopUpButton();
			reporter.hardAssert(rogers_manage_data_page.isCancelSuccessdisplayed(),
					"Cancel MDT success",
					"MDT cancel not successful");
			reporter.reportLogWithScreenshot("Cancel successful");
			rogers_manage_data_page.clkCloseButtonOnCancelSuccessOverlay();
			reporter.reportLogWithScreenshot("Close overlay");
			
			common_business_flows.scrollToTopOfWebPage();
			rogers_manage_data_page.clkBackOnManageDataUsagePage();
			reporter.reportLogWithScreenshot("Back on dashboard");
			
			rogers_login_page.clickSignOut();
			reporter.reportLogWithScreenshot("Sign out done");
			if(rogers_home_page.isContentFulURLDisplayed())
			{
				rogers_home_page.clkEasyLogin();
			}			
			rogers_login_page.clkSignInAs();
			reporter.reportLogWithScreenshot("Click Re Sign In");
			rogers_login_page.switchToSignInIFrame();	        
	        rogers_login_page.setPasswordIFrame(strPassword);
	        reporter.reportLogWithScreenshot("Login Credential is entered.");
			rogers_login_page.clkSignInIFrame();
			rogers_login_page.clkSkipIFrame();
			rogers_login_page.switchOutOfSignInIFrame();				        
			//rechange to the original one
			if(rogers_account_overview_page.verifySuccessfulLogin())
			{
				if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
		        	reporter.reportLogWithScreenshot("Select an account.");
		            rogers_account_overview_page.selectAccount(TestDataHandler.tc59.getAccountDetails().getBan());
		        }
		        reporter.reportLogWithScreenshot("Account overview page.");
		        
		        rogers_account_overview_page.clkMenuUsageAndService();
		        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
		        if (rogers_account_overview_page.isAccountShowInDropDown(strAccountNum.substring(strAccountNum.length()-4))) {
		            rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
		        } else {
		        	rogers_account_overview_page.clkSubMenuWirelessUsage();
		        }
		        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
		        rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();		        
				reporter.reportLogWithScreenshot("dashboard page");				
				reporter.reportLogWithScreenshot("My Plan Details");
				//All the added OTT are reflected in total bucket,plan section and manage data page
				reporter.hardAssert(rogers_wireless_dashboard_page.verifyCancelledAddedDataInMyPlan(1, countOfActiveAndCancelledAddDataOnMyPlan.get("cancelled"))
						,"Expires MMM DD - is displayed next to the cancelled MDT in plan section",
						"Expires MMM DD - is NOT displayed next to the cancelled MDT in plan section");
				
				rogers_wireless_dashboard_page.scrollToTopOfDasboardPage();
				reporter.hardAssert(rogers_manage_data_page.validateViewDetailsLink(),
						"'Data details' page is displayed after click on view details link",
						"'Data details' page is NOT displayed after click on view details link");					
				reporter.hardAssert(rogers_manage_data_page.verifyCancelledMDTInManageData(1,countOfActiveAndCancelledAddData.get("cancelled")),
						"Expires MMM DD - is displayed next to the cancelled MDT in manage data page",
						"Expires MMM DD - is NOT displayed next to the cancelled MDT in manage data page, plase investigate");	
				
			}
				
		}else
		{
			reporter.reportLogFail("No MDT to cancel, please add mtt and rerun the script");
		}
							

	}
        

}
