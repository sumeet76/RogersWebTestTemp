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



public class RogersSS_TC_062_ValidateDataRemainingOnMaxSpeedInfiniteSE extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	
    @Test(groups = {"SanitySS","RegressionSS","WirelessDashboardSS"})
    public void validateDataRemainingOnMaxSpeedInfiniteSE() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc6269.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc6269.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc6269.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");     
       getRogersAccountOverviewPage().clkMenuUsageAndService();
       //For demo-line data, the sub-menu shows as "Wireless Usage"
   		getRogersAccountOverviewPage().clkSubMenuWirelessUsage();

       //getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();  
              
       //5. Usage bar displayed with the usage 
       reporter.hardAssert(getRogersWirelessDashboardPage().verifyUsageBarIsDisplayed(),
       "Usage bar displayed with the usage ",
       "Usage bar seems not displayed, please investigate");
       reporter.hardAssert(getRogersWirelessDashboardPage().verifyDataRemainingOutOfTotalDataBucket(),
				"Data remaining out of Total data bucket info should be displayed", 
				"Data remaining out of Total data bucket info is not displayed.");
		reporter.hardAssert(getRogersWirelessDashboardPage().verifyTotalDataBucket(),
						"Max Speed data remaining is displayed with the total data remaining included (Speed pass) if any", 
						"Max Speed data remaining seems NOT displayed with the total data remaining included (Speed pass)");
		//6. Total data should be displayed with GB
		reporter.reportLogWithScreenshot("Wireless dashboard of Infinite SE data.");  
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
		
		//7. Manage Data page displayed successfully
		reporter.hardAssert(getRogersManageDataPage().validateViewDetailsLink(),
						"'Manage Data' page is displayed after click on view details link", 
						"'Manage Data' page is NOT displayed after click on view details link");  
		reporter.reportLogWithScreenshot("Manage data page view after we click on view details");  
		getRogersManageDataPage().clkBackOnManageDataUsagePage();
		reporter.reportLogWithScreenshot("Navigated back to dashboard from manage data view"); 
		
		//8. Remaining days in bill cycle displayed below the total data
		reporter.hardAssert(getRogersWirelessDashboardPage().verifyDaysRemainingInTheBillCycleIsDisplayed(),
						"Days left remaining in the bill cycle is displayed", 
						"Days left remaining in the bill cycle is NOT displayed");  
		reporter.hardAssert(!getRogersWirelessDashboardPage().verifyDataDelayMessage(),
						"Data delayed 12 hours message doesn't display, this is Demo line.", 
						"Data delayed 12 hours message doesn't display, please check.");  
		//9. Add Speed pass flow page displayed successfully
		getRogersWirelessDashboardPage().clkBtnSpeedPass();
		reporter.hardAssert(getRogersSpeedPassPage().verifySpeedPassPopupIsDisplayed(),
				"Add speed pass overlay openned successfully.", 
				"Add speed pass overlay failed.");  
		getRogersSpeedPassPage().clkBtnCloseInSpeedPassPopup();
		getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
		reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");        
		getRogersWirelessDashboardPage().scrollToBottomOfPage();
		reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
       
             
    }
    
    
    

}
