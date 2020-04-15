package com.rogers.test.tests.selfserve;

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



public class RogersSS_TC_056_ValidateDataUsageDesplayWithinLimit_postpaid_NSEDataOnlyPlan extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.config.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void validateDataUsageDisplayForDataOnlyPlan() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc56.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc56.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc56.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");       
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc56.getAccountDetails().getCtn();
        rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
                       
        reporter.softAssert(rogers_wireless_dashboard_page.verifyDataDelayMessage(), 
        					"Data delayed by 12 hours message is displayed", 
        					"Data delayed by 12 hours message is NOT displayed");
        reporter.reportLogWithScreenshot("Wireless dashboard page."); 
        reporter.softAssert(rogers_wireless_dashboard_page.verifyDataRemainingOutOfTotalDataBucket(), 
							"Data remaining out of Total data bucket info should be displayed", 
							"Data remaining out of Total data bucket info is not displayed.");
        reporter.softAssert(rogers_wireless_dashboard_page.validateTotalDataBucket(), 
							"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info should be displayed", 
							"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info NOT displayed");
        reporter.softAssert(rogers_manage_data_page.validateViewDetailsLink(), 
							"'Manage Data' page is displayed after click on view details link", 
							"'Manage Data' page is NOT displayed after click on view details link");  
        reporter.reportLogWithScreenshot("Manage data page view after we click on view details");  
        rogers_manage_data_page.clkBackOnManageDataUsagePage();
        reporter.reportLogWithScreenshot("Navigated back to dashboard from manage data view");  
        reporter.softAssert(rogers_wireless_dashboard_page.verifyDaysRemainingInTheBillCycleIsDisplayed(), 
							"Days left remaining in the bill cycle is displayed", 
							"Days left remaining in the bill cycle is NOT displayed"); 
        common_business_flows.addDataFlow();
        if(rogers_add_data_page.verifyAddDataSuccessMsgIsDisplayed())
        {
        	rogers_add_data_page.clkCloseOnAddDataOverlay();
        	//Sign out and re sign in to verify if added data reflected.
	        reporter.reportLogWithScreenshot("Wireless dashboard page.");  
	        rogers_login_page.clickSignOut();
	        reporter.reportLogWithScreenshot("Sign Out clicked");  
	        rogers_login_page.clkSignInAs();
	        reporter.reportLogWithScreenshot("Re sign In");  
	        rogers_login_page.switchToSignInIFrame();
	                   
	        rogers_login_page.setPasswordIFrame(strPassword);
	        reporter.reportLogWithScreenshot("Login Credential is entered.");
			rogers_login_page.clkSignInIFrame();		
			rogers_login_page.switchOutOfSignInIFrame();		       
	        reporter.reportLogWithScreenshot("Account overview page.");        
	        rogers_account_overview_page.clkMenuUsageAndService();
	        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");        
	        rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
	        reporter.reportLogWithScreenshot("Wireless dashboard page.");
	        
        } else if (rogers_add_data_page.verifyErrorMsgIsDisplayed()) {
        	reporter.reportLogWithScreenshot("Add data purchase got error, please check if limit is reached.");
        	rogers_add_data_page.clkCloseOnAddDataOverlay();
        }
        reporter.reportLogWithScreenshot("Navigated back to dashboard after resign in");  
        reporter.softAssert(rogers_wireless_dashboard_page.verifyAllMBAmountsConvertedToGBForTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded(),
        		"All amounts are coverted to GB For Total Data Displayed Below Label Total Data Plus Plan Added",
        		"it seems amount is not convertd to GB For Total Data Displayed Below Label Total Data Plus Plan Added, please investigate");
        reporter.softAssert(rogers_wireless_dashboard_page.verifyAllMBAmountsConvertedToGBForLabelDataRemaining(),
        		"All amounts are coverted to GB For Label Data Remaining",
        		"it seems amount is not convertd to GB For Label Data Remaining, please investigate");
        reporter.softAssert(rogers_wireless_dashboard_page.verifyAllMBAmountsConvertedToGBForlabelTotalDataDisplayedBelowBarRightSide(),
        		"All amounts are coverted to GB label Total Data Displayed Below Bar RightSide",
        		"it seems amount is not convertd to GB label Total Data Displayed Below Bar RightSide, please investigate");
        reporter.softAssert(rogers_wireless_dashboard_page.verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesForTotalDataPlusAddedPlan(), 
							"All MB amounts converted in GB up to 2 decimal points For Total Data Plus Added Plan", 
							"MB amounts converted in GB up to 2 decimal points NOT validated For Total Data Plus Added Plan, please investigate");  
        reporter.softAssert(rogers_wireless_dashboard_page.verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesOnLabelDataRemaining(), 
				"All MB amounts converted in GB up to 2 decimal points On Label Data Remaining", 
				"MB amounts converted in GB up to 2 decimal points NOT validated On Label Data Remaining, please investigate"); 
        reporter.softAssert(rogers_wireless_dashboard_page.verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesOnTotalDataBelowUsageBarRightSide(), 
				"All MB amounts converted in GB up to 2 decimal points Total Data Below UsageBar RightSide", 
				"MB amounts converted in GB up to 2 decimal points NOT validated Total Data Below UsageBar RightSide, please investigate"); 
        rogers_wireless_dashboard_page.scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");        
        rogers_wireless_dashboard_page.scrollToBottomOfPage();
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
    }
    
    
    

}
