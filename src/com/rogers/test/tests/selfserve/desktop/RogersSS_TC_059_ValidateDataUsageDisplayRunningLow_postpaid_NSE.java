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



public class RogersSS_TC_059_ValidateDataUsageDisplayRunningLow_postpaid_NSE extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	

   @Test(groups = {"RegressionSS","WirelessDashboardSS","AddDataSpeedPass"})
    public void validateDataUsageDisplayForRunningLowAndAddData() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc59.getUsername();
    	//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc59.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
		
//        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
//        	reporter.reportLogWithScreenshot("Select an account.");
//            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc59.getAccountDetails().getBan());
//        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc59.getAccountDetails().getCtn();        
        getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));

        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyRunningLowStateInTheUsageBar(),
        		"Data running low is displayed for 10% or less data",
        		"It seems the data running low state is not yet reached for this acccount, please decrease the data usage and re validate");
         reporter.hardAssert(getRogersWirelessDashboardPage().verifyCallOutMessageToAddDataIsDisplayed(),
        		 "Call out message to add data is displayed",
        		 "Call out message to add data is not displayed");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyDataDelayMessage(),
        					"Data delayed by 12 hours message is displayed", 
        					"Data delayed by 12 hours message is NOT displayed");
        reporter.reportLogWithScreenshot("Wireless dashboard page."); 
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyTotalDataBucket(),
							"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info should be displayed", 
							"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info NOT displayed");
        reporter.hardAssert(getRogersManageDataPage().validateViewDetailsLink(),
							"'Manage Data' page is displayed after click on view details link", 
							"'Manage Data' page is NOT displayed after click on view details link");  
        reporter.reportLogWithScreenshot("Manage data page view after we click on view details");  
        getRogersManageDataPage().clkBackOnManageDataUsagePage();
        reporter.reportLogWithScreenshot("Navigated back to dashboard from manage data view");  
        //reporter.hardAssert(getRogersWirelessDashboardPage().verifyDaysRemainingInTheBillCycleIsDisplayed(),
		//					"Days left remaining in the bill cycle is displayed",
		//					"Days left remaining in the bill cycle is NOT displayed");

        reporter.hardAssert(getRogersWirelessDashboardPage().verifyAddDataButtonIsDisplayed(),
							"Add the Data top-up button is displayed", 
							"Add the Data top-up  button is NOT displayed."); 
        //Comment out this block because the flow is checked in TC56.
//        double origTotalData = getRogersWirelessDashboardPage().getTotalDataVolume();
//        double addedData = 0;
//        getCommonBusinessFlows().addDataFlow();
//        if(getRogersAddDataPage().verifyAddDataSuccessMsgIsDisplayed())
//        {
//        	addedData = getRogersAddDataPage().getAddedDataVolume();
//        	getRogersAddDataPage().clkCloseOnAddDataOverlay();
//        	//Sign out and re sign in to verify if added data reflected.
//	        reporter.reportLogWithScreenshot("Wireless dashboard page.");  
//	        getCommonBusinessFlows().logOutAndReSignIn(strUsername, strPassword);     
//	        getRogersAccountOverviewPage().clkMenuUsageAndService();
//	        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");        
//            getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
//
//	        reporter.reportLogWithScreenshot("Wireless dashboard page.");
//	        reporter.softAssert(!getRogersWirelessDashboardPage().verifyRunningLowStateInTheUsageBar(),
//	        		"Data running low is disappeared",
//	        		"It seems the data running low state is still displayed, please add more data and re validate");
//	        reporter.softAssert(getRogersWirelessDashboardPage().verifyAddedDataReflectedInTotalDataBucket(origTotalData, addedData),
//								"Added data is reflected in total data bucket.", 
//								"Added data didn't reflect in total data bucket.");
//	     	        
//        } else if (getRogersAddDataPage().verifyErrorMsgIsDisplayed()) {
//        	reporter.reportLogWithScreenshot("Add data purchase got error, please check if limit is reached.");
//        	getRogersAddDataPage().clkCloseOnAddDataOverlay();
//        }
        
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyAllMBAmountsConvertedToGBForTotalDataDisplayedBelowLabelTotalDataPlusPlanAdded(),
        		"All amounts are coverted to GB For Total Data Displayed Below Label Total Data Plus Plan Added",
        		"it seems amount is not convertd to GB For Total Data Displayed Below Label Total Data Plus Plan Added, please investigate");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyAllMBAmountsConvertedToGBForLabelDataRemaining(),
        		"All amounts are coverted to GB For Label Data Remaining",
        		"it seems amount is not convertd to GB For Label Data Remaining, please investigate");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyAllMBAmountsConvertedToGBForlabelTotalDataDisplayedBelowBarRightSide(),
        		"All amounts are coverted to GB label Total Data Displayed Below Bar RightSide",
        		"it seems amount is not convertd to GB label Total Data Displayed Below Bar RightSide, please investigate");
        
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesForTotalDataPlusAddedPlan(),
				"All MB amounts converted in GB up to 2 decimal points For Total Data Plus Added Plan", 
				"MB amounts converted in GB up to 2 decimal points NOT validated For Total Data Plus Added Plan, please investigate");  
		reporter.hardAssert(getRogersWirelessDashboardPage().verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesOnLabelDataRemaining(),
			"All MB amounts converted in GB up to 2 decimal points On Label Data Remaining", 
			"MB amounts converted in GB up to 2 decimal points NOT validated On Label Data Remaining, please investigate"); 
		reporter.hardAssert(getRogersWirelessDashboardPage().verifyAllMBAmountsConvertedToGBUptoTwoDecimalPlacesOnTotalDataBelowUsageBarRightSide(),
			"All MB amounts converted in GB up to 2 decimal points Total Data Below UsageBar RightSide", 
			"MB amounts converted in GB up to 2 decimal points NOT validated Total Data Below UsageBar RightSide, please investigate");                              
        getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");        
        getRogersWirelessDashboardPage().scrollToBottomOfPage();
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
    }
    


}
