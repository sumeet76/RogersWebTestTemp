package com.rogers.test.tests.selfserve.desktop;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
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



public class RogersSS_TC_078_ValidateCancelDataFlowNSECTNwithMultipleSimilarMDTs extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	Integer counterOfAddedData =0;
    @Test(groups = {"AddDataFlow","WirelessDashboardSS"})
    public void validateCancelMDTFlowNSEWithMultipleMDT() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc78.getUsername();
    	String strPassword = TestDataHandler.tc78.getPassword();
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
//            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc78.getAccountDetails().getBan());
//        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc78.getAccountDetails().getCtn();
        getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));

        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
        reporter.reportLogWithScreenshot("Dashboard page");
        getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Dashboard My Plan");
        
       	Map<String, Integer> countOfActiveAndCancelledAddDataOnMyPlan = getRogersWirelessDashboardPage().getAllExistingAddDataCountCancelledAndActiveOnMyPlanSection();
       	getRogersWirelessDashboardPage().scrollToTopOfDasboardPage();
		//4. Click on View details in usage dashboard
		reporter.hardAssert(getRogersManageDataPage().validateViewDetailsLink(),
							"'Manage Data' page is displayed after click on view details link", 
							"'Manage Data' page is NOT displayed after click on view details link");  
        reporter.reportLogWithScreenshot("Manage data page view after we click on view details");  
       
        counterOfAddedData = getRogersManageDataPage().getAllExistingAddedDataCount();
        Map<String, Integer> countOfAlreadyAddedData = getRogersManageDataPage().getCountOfAllExistingAddedDataValues();
		Map<String, Integer> countOfActiveAndCancelledAddData = getRogersManageDataPage().getAllExistingAddDataCountCancelledAndActive();
		reporter.reportLogWithScreenshot("Manage Data page");
		//Comparisons Before Cancel:
		reporter.hardAssert((countOfActiveAndCancelledAddDataOnMyPlan.get("cancelled")==countOfActiveAndCancelledAddData.get("cancelled")
							&& countOfActiveAndCancelledAddDataOnMyPlan.get("active")==countOfActiveAndCancelledAddData.get("active"))
				, "The number of cancelled and active add on macth on my plans and manage data page", 
				"The number of cancelled and active add on does not macth on my plans and manage data page");
		if((countOfActiveAndCancelledAddData.get("active")<1)) {
			getRogersManageDataPage().clkBackOnManageDataUsagePage();
			
			getRogersWirelessDashboardPage().clkAddData();
			if(counterOfAddedData<10)
			{
				
				reporter.softAssert(getRogersAddDataPage().verifyAddDataOverlayIsDisplayed(),
									"Add the Data top-up  window should be displayed. (completd an MDT add on)", 
									"Add the Data top-up  window is NOT displayed.");          
				List<String> allMDTValues =getRogersAddDataPage().getAllAddDataOptions();
				getRogersSpeedPassPage().clkBtnCloseInSpeedPassPopup();
				
				addAnyMDTForTotalOfThreeTimes(allMDTValues,countOfAlreadyAddedData);        		
			}else
			{
				reporter.hardAssert(getRogersAddDataPage().verifyAddDataLimitReachedIsDisplayed(),
						"Limit reached overlay is displayed, since already 10 addons have been added", 
						"Limit reached overlay is not displayed even though there are 10 add ons"); 
				 reporter.reportLogWithScreenshot("Limit reached overlay is displayed");
				 getRogersSpeedPassPage().clkBtnCloseInSpeedPassPopup();
			}

			reporter.hardAssert(getRogersManageDataPage().validateViewDetailsLink(),
					"'Manage Data' page is displayed after click on view details link", 
					"'Manage Data' page is NOT displayed after click on view details link");  
			reporter.reportLogWithScreenshot("Manage data page view after we click on view details");  
			
			counterOfAddedData = getRogersManageDataPage().getAllExistingAddedDataCount();
			countOfAlreadyAddedData = getRogersManageDataPage().getCountOfAllExistingAddedDataValues();
			countOfActiveAndCancelledAddData = getRogersManageDataPage().getAllExistingAddDataCountCancelledAndActive();
			reporter.reportLogWithScreenshot("Manage Data page");
			
		}
		
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
			
			getCommonBusinessFlows().scrollToTopOfWebPage();
			getRogersManageDataPage().clkBackOnManageDataUsagePage();
			reporter.reportLogWithScreenshot("Back on dashboard");
			getCommonBusinessFlows().logOutAndReSignIn(strUsername, strPassword);				        
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
			reporter.reportLogFail("No MDT to cancel, please add mtt and rerun the script");
		}
							

	}
        

    /**
     * This method will try to add each MDT's 3 times if its not already added
     * @param allMDT List of all the MDT values available for the account
     * @param countOfAlreadyAddedData Map containing the count of already added MDT's 
     */
    private void addAnyMDTForTotalOfThreeTimes(List<String> allMDT, Map<String, Integer> countOfAlreadyAddedData) {
    	for(String mdt: allMDT)
    	{
    		    		
    		if(countOfAlreadyAddedData.containsKey(mdt)  && countOfAlreadyAddedData.get(mdt)<3)
    		{
    			reporter.reportLog("The Add on data :"+mdt+" needs to be added "+(3-countOfAlreadyAddedData.get(mdt))+" times and one extra attempt to check Limit reached");
    			addMDTForGivenNumberOfTimes(3-countOfAlreadyAddedData.get(mdt),mdt);
    			
    			break;
    		}else if(!countOfAlreadyAddedData.containsKey(mdt))
    		{
    			reporter.reportLog("The Add on data :"+mdt+" is not added , will add it 3 times and one extra attempt to check Limit reached");
    			addMDTForGivenNumberOfTimes(3,mdt);
    			break;
    		}else if(countOfAlreadyAddedData.get(mdt)==3)
    		{
    			reporter.reportLog("The Add on data :"+mdt+" is already added 3 times");
    			addMDTForGivenNumberOfTimes(0,mdt);
    			break;
    		}
    	}
    }
    
    /**
     * This methods will try to add MDT value for the specified number of times
     * @param intMaxNumberOfTimesToAdd The number of times to add a particular MDT
     * @param strMDT The MDT data value to add
     */
    private void addMDTForGivenNumberOfTimes(Integer intMaxNumberOfTimesToAdd,String strMDT) {
    	for(int itr=1;itr<=intMaxNumberOfTimesToAdd+1;itr++)
    	{
    		 getRogersWirelessDashboardPage().clkAddData();
             reporter.softAssert(getRogersAddDataPage().verifyAddDataOverlayIsDisplayed(),
     							"Add the Data top-up  window should be displayed. (completd an MDT add on)", 
     							"Add the Data top-up  window is NOT displayed.");   
             reporter.reportLogWithScreenshot("Add Data Add on");  
             getRogersAddDataPage().selectAddOnOption(strMDT);
             reporter.reportLogWithScreenshot("Select Add on option");  
             getRogersAddDataPage().clkContinue();
             reporter.reportLogWithScreenshot("Select Purchase"); 
             getRogersAddDataPage().clkPurchase();
             if(itr<=intMaxNumberOfTimesToAdd && counterOfAddedData<10)
             {
             reporter.softAssert(getRogersAddDataPage().verifyAddDataSuccessMsgIsDisplayed(),
						"Add the Data top-up  window should be displayed. (completd an MDT add on)", 
						"Add the Data top-up  window is NOT displayed.");
             getRogersSpeedPassPage().clkBtnCloseInSpeedPassPopup();
             counterOfAddedData++;
             }else if(itr>intMaxNumberOfTimesToAdd || counterOfAddedData==10)
             {
            	 reporter.hardAssert(getRogersAddDataPage().verifyAddDataLimitReachedIsDisplayed(),
							"Limit reached overlay is displayed", 
							"Limit reached overlay is not displayed"); 
            	 reporter.reportLogWithScreenshot("Limit reached overlay is displayed");
            	 getRogersSpeedPassPage().clkBtnCloseInSpeedPassPopup();
            	 break;
             }
             
    	}
    	    	        
    }
    
}
