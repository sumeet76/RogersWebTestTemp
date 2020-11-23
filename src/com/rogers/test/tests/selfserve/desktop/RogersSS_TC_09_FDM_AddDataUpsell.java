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



public class RogersSS_TC_09_FDM_AddDataUpsell extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
		
	Integer counterOfAddedData =0;
    @Test(groups = {"AddDataFlow","FDMSS"})
    public void validateDataUsageDisplayForRunningLowAndAddData() {
    	reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
        getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc60.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc60.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc60.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");

    	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
 
        reporter.softAssert(getRogersManageDataPage().validateViewDetailsLink(),
				"'Manage Data' page is displayed after click on view details link", 
				"'Manage Data' page is NOT displayed after click on view details link");  
		reporter.reportLogWithScreenshot("Manage data page view after we click on view details");  
		counterOfAddedData = getRogersManageDataPage().getAllExistingAddedDataCount();
		Map<String, Integer> countOfAlreadyAddedData = getRogersManageDataPage().getCountOfAllExistingAddedDataValues();
		
		getRogersManageDataPage().clkBackOnManageDataUsagePage();
		reporter.reportLogWithScreenshot("Navigated back to dashboard from manage data view");  
		reporter.softAssert(getRogersWirelessDashboardPage().verifyAddDataButtonIsDisplayed(),
						"Add the Data top-up button is displayed", 
						"Add the Data top-up  button is NOT displayed.");  
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
