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



public class RogersSS_TC_060_ValidateCopyChangesOfDataUsageDisplayWithInLimitsPostpaidSEplanMultiTN extends BaseTestClass {	
   	
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
    public void validateDataRemainingOnMaxSpeedInfiniteSE() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc60.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc60.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc60.getAccountDetails().getBan());
        }
        
        
        
       reporter.reportLogWithScreenshot("Account overview page.");
       common_business_flows.scrollToMiddleOfWebPage();
       reporter.reportLogWithScreenshot("Check the number of CTNs");
       int totalCTN = rogers_account_overview_page.getTotalCTN();
		reporter.hardAssert((totalCTN>1),
				"The account has more than 1 CTNS",
				"The account doesnt have more than 1 CTN's, please add more CTNS and rerun");
		common_business_flows.scrollToTopOfWebPage();
       
       
       rogers_account_overview_page.clkMenuUsageAndService();
       //For demo-line data, the sub-menu shows as "Wireless Usage"
   		rogers_account_overview_page.clkSubMenuWirelessUsage();

       rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();  
       
       double totalDataRemaining= rogers_wireless_dashboard_page.getDataRemainingOutOfTotalDataBucket();      
       double totalDataPlan = rogers_wireless_dashboard_page.getTotalDataVolume();
       
       for(int ctnCount=1;ctnCount<=totalCTN;ctnCount++)
       {
    	   rogers_wireless_dashboard_page.clkTheNthCTNOnDashboardPage(ctnCount);
    	   reporter.reportLogWithScreenshot("CTN Number : "+ctnCount);
    	   reporter.softAssert(rogers_wireless_dashboard_page.verifyUsageBarIsDisplayed(),
    	           "Usage bar displayed with the usage ",
    	           "Usage bar seems not displayed, please investigate");
    	           reporter.softAssert(rogers_wireless_dashboard_page.verifyDataRemainingOutOfTotalDataBucket(), 
    	    				"Data remaining out of Total data bucket info should be displayed", 
    	    				"Data remaining out of Total data bucket info is not displayed.");
    	    		reporter.softAssert(rogers_wireless_dashboard_page.verifyTotalDataBucket(), 
    	    						"Max Speed data remaining is displayed with the total data remaining included (Speed pass) if any", 
    	    						"Max Speed data remaining seems NOT displayed with the total data remaining included (Speed pass)");
    	    		//6. Total data should be displayed with GB
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
    	    		
    	    		//7. Manage Data page displayed successfully
    	    		reporter.softAssert(rogers_manage_data_page.validateViewDetailsLink(), 
    	    						"'Manage Data' page is displayed after click on view details link", 
    	    						"'Manage Data' page is NOT displayed after click on view details link");  
    	    		reporter.reportLogWithScreenshot("Manage data page view after we click on view details");  
    	    		rogers_manage_data_page.clkBackOnManageDataUsagePage();
    	    		reporter.reportLogWithScreenshot("Navigated back to dashboard from manage data view"); 
    	    		
    	    		//8. Remaining days in bill cycle displayed below the total data
    	    		reporter.softAssert(rogers_wireless_dashboard_page.verifyDaysRemainingInTheBillCycleIsDisplayed(), 
    	    						"Days left remaining in the bill cycle is displayed", 
    	    						"Days left remaining in the bill cycle is NOT displayed");  
    	    		reporter.softAssert(!rogers_wireless_dashboard_page.verifyDataDelayMessage(), 
    	    						"Data delayed 12 hours message doesn't display, this is Demo line.", 
    	    						"Data delayed 12 hours message doesn't display, please check.");  
    	    		//9. Add Speed pass flow page displayed successfully
    	    		reporter.reportLogWithScreenshot("Navigated back to dashboard from manage data view");  
    	            reporter.softAssert(rogers_wireless_dashboard_page.verifyAddDataButtonIsDisplayed(), 
    	    							"Add the Data top-up button is displayed", 
    	    							"Add the Data top-up  button is NOT displayed.");        
    	            rogers_wireless_dashboard_page.clkAddData();      
    	            reporter.softAssert(rogers_add_data_page.verifyAddDataOverlayIsDisplayed(), 
    	    							"Add the Data top-up  window should be displayed. (completd an MDT add on)", 
    	    							"Add the Data top-up  window is NOT displayed.");                           
    	            rogers_speed_pass_page.clkBtnCloseInSpeedPassPopup();
    	            if(ctnCount>1)
    	            {
    	            reporter.softAssert(totalDataPlan==rogers_wireless_dashboard_page.getTotalDataVolume()
    	            		&& totalDataRemaining==rogers_wireless_dashboard_page.getDataRemainingOutOfTotalDataBucket(), 
    	            		"data usage details remain the same for CTN Number: "+ctnCount, 
    	            		"data usage details is not the same for CTN Number: "+ctnCount);    	                	            
    	            }
    	            
    	    		common_business_flows.scrollToMiddleOfWebPage();
    	    		reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");        
    	    		common_business_flows.scrollToBottomOfWebPage();
    	    		reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
    	    		common_business_flows.scrollToTopOfWebPage();
    	   
       }
    	   
          
     
       
    
       
             
    }
    
    
    

}
