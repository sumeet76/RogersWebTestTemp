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



public class RogersSS_TC_056_ValidateDataUsageDesplayWithinLimit_postpaid_NSEDataOnlyPlan extends BaseTestClass {	
   	
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
    public void validateDataUsageDisplayForDataOnlyPlan() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc56.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc56.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
        reporter.reportLogWithScreenshot("Account overview page.");       
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc56.getAccountDetails().getCtn();
        getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
                       
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyDataDelayMessage(),
        					"Data delayed by 12 hours message is displayed", 
        					"Data delayed by 12 hours message is NOT displayed");
        reporter.reportLogWithScreenshot("Wireless dashboard page."); 
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyDataRemainingOutOfTotalDataBucket(),
							"Data remaining out of Total data bucket info should be displayed", 
							"Data remaining out of Total data bucket info is not displayed.");
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyTotalDataBucket(),
							"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info should be displayed", 
							"Total data bucket includes plan, paid OTTs, paid MDTs, promotional (zero-rated) bonus OTT and MDTs info NOT displayed");
        reporter.hardAssert(getRogersManageDataPage().validateViewDetailsLink(),
							"'Manage Data' page is displayed after click on view details link", 
							"'Manage Data' page is NOT displayed after click on view details link");  
        reporter.reportLogWithScreenshot("Manage data page view after we click on view details");  
        getRogersManageDataPage().clkBackOnManageDataUsagePage();
        reporter.reportLogWithScreenshot("Navigated back to dashboard from manage data view");  
       // reporter.hardAssert(getRogersWirelessDashboardPage().verifyDaysRemainingInTheBillCycleIsDisplayed(),
		//					"Days left remaining in the bill cycle is displayed", 
		//					"Days left remaining in the bill cycle is NOT displayed"); 
        getCommonBusinessFlows().addDataFlow();
        if(getRogersAddDataPage().verifyAddDataSuccessMsgIsDisplayed())
        {
        	getRogersAddDataPage().clkCloseOnAddDataOverlay();
        	//Sign out and re sign in to verify if added data reflected.
	        reporter.reportLogWithScreenshot("Wireless dashboard page.");  
	        getCommonBusinessFlows().logOutAndReSignIn(strUsername, strPassword);       
	        getRogersAccountOverviewPage().clkMenuUsageAndService();
	        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");        
	        getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
	        reporter.reportLogWithScreenshot("Wireless dashboard page.");
	        
        } else if (getRogersAddDataPage().verifyErrorMsgIsDisplayed()) {
        	reporter.reportLogWithScreenshot("Add data purchase got error, please check if limit is reached.");
        	getRogersAddDataPage().clkCloseOnAddDataOverlay();
        }
        reporter.reportLogWithScreenshot("Navigated back to dashboard after resign in");  
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
