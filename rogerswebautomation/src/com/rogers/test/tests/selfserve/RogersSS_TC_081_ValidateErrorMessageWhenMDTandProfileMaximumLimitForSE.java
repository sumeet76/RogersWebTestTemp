package com.rogers.test.tests.selfserve;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;



public class RogersSS_TC_081_ValidateErrorMessageWhenMDTandProfileMaximumLimitForSE extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	Integer counterOfAddedData =0;
	
    @Test
    public void validateErrorMessageWhenMDTandProfileMaximumLimitForSE() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc7681.getUsername();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc7681.getPassword();    	
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc7681.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc7681.getAccountDetails().getCtn();        
        if (rogers_account_overview_page.isAccountShowInDropDown(strAccountNum.substring(strAccountNum.length()-4))) {
            rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        } else {
        	rogers_account_overview_page.clkSubMenuWirelessUsage();
        }
        
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();
        
        reporter.softAssert(rogers_manage_data_page.validateViewDetailsLink(), 
							"'Manage Data' page is displayed after click on view details link", 
							"'Manage Data' page is NOT displayed after click on view details link");  
        reporter.reportLogWithScreenshot("Manage data page view after we click on view details");  
        counterOfAddedData = rogers_manage_data_page.getAllExistingAddedDataCount();
        Map<String, Integer> countOfAlreadyAddedData = rogers_manage_data_page.getCountOfAllExistingAddedDataValues();
        
        rogers_manage_data_page.clkBackOnManageDataUsagePage();
        reporter.reportLogWithScreenshot("Navigated back to dashboard from manage data view");  
        reporter.softAssert(rogers_wireless_dashboard_page.verifyAddDataButtonIsDisplayed(), 
							"Add the Data top-up button is displayed", 
							"Add the Data top-up  button is NOT displayed.");        
        rogers_wireless_dashboard_page.clkAddData();
        if(counterOfAddedData<10)
        {
        reporter.softAssert(rogers_add_data_page.verifyAddDataOverlayIsDisplayed(), 
							"Add the Data top-up  window should be displayed. (completd an MDT add on)", 
							"Add the Data top-up  window is NOT displayed.");          
        List<String> allData =rogers_add_data_page.getAllAddDataOptions();         
        rogers_speed_pass_page.clkBtnCloseInSpeedPassPopup();
        
		addThreeTimesEachData(allData,countOfAlreadyAddedData);        		
        }else
        {
        	reporter.hardAssert(rogers_add_data_page.verifyAddDataLimitReachedIsDisplayed(), 
					"Limit reached overlay is displayed, since already 10 addons have been added", 
					"Limit reached overlay is not displayed even though there are 10 add ons"); 
	    	 reporter.reportLogWithScreenshot("Limit reached overlay is displayed");
	    	 rogers_speed_pass_page.clkBtnCloseInSpeedPassPopup();
        }
                                               
    }
    
    private void addDataForMaxThreeTimesEach(Integer intMaxNumberOfTimesToAdd,String strData) {
    	for(int itr=1;itr<=intMaxNumberOfTimesToAdd+1;itr++)
    	{
    		 rogers_wireless_dashboard_page.clkAddData();
             reporter.softAssert(rogers_add_data_page.verifyAddDataOverlayIsDisplayed(), 
     							"Add the Data top-up  window should be displayed. (completd an MDT add on)", 
     							"Add the Data top-up  window is NOT displayed.");   
             reporter.reportLogWithScreenshot("Add Data Add on");  
             rogers_add_data_page.selectAddOnOption(strData);
             reporter.reportLogWithScreenshot("Select Add on option");  
             rogers_add_data_page.clkContinue();
             reporter.reportLogWithScreenshot("Select Purchase"); 
             rogers_add_data_page.clkPurchase();
             if(itr<=intMaxNumberOfTimesToAdd && counterOfAddedData<10)
             {
             reporter.softAssert(rogers_add_data_page.verifyAddDataSuccessMsgIsDisplayed(), 
						"Add the Data top-up  window should be displayed. (completd an MDT add on)", 
						"Add the Data top-up  window is NOT displayed.");
             rogers_speed_pass_page.clkBtnCloseInSpeedPassPopup();
             counterOfAddedData++;
             }else if(itr>intMaxNumberOfTimesToAdd || counterOfAddedData==10)
             {
            	 reporter.hardAssert(rogers_add_data_page.verifyAddDataLimitReachedIsDisplayed(), 
							"Limit reached overlay is displayed", 
							"Limit reached overlay is not displayed"); 
            	 reporter.reportLogWithScreenshot("Limit reached overlay is displayed");
            	 rogers_speed_pass_page.clkBtnCloseInSpeedPassPopup();
            	 break;
             }
             
    	}
    	    	        
    }
    
    private void addThreeTimesEachData(List<String> allData, Map<String, Integer> countOfAlreadyAddedData) {
    	for(String data: allData)
    	{
    		if(counterOfAddedData==10) {break;}
    		
    		if(countOfAlreadyAddedData.containsKey(data)  && countOfAlreadyAddedData.get(data)<3)
    		{
    			reporter.reportLog("The Add on data :"+data+" needs to be added "+(countOfAlreadyAddedData.get(data)-3)+" times and one extra attempt to check Limit reached");
    			addDataForMaxThreeTimesEach(countOfAlreadyAddedData.get(data)-3,data);
    		}else if(!countOfAlreadyAddedData.containsKey(data))
    		{
    			reporter.reportLog("The Add on data :"+data+" is not added , will add it 3 times and one extra attempt to check Limit reached");
    			addDataForMaxThreeTimesEach(3,data);
    		}else if(countOfAlreadyAddedData.get(data)==3)
    		{
    			reporter.reportLog("The Add on data :"+data+" is already added 3 times");
    			addDataForMaxThreeTimesEach(0,data);
    		}
    	}
    }

}
