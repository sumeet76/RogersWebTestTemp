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



public class RogersSS_TC_073_ValidateMyWirelessPlanSectionInTheWirelessDashboardNSE extends BaseTestClass {	
    
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
    public void validateMyWirelessPlanSectionInTheWirelessDashboardNSE() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc727375.getUsername();
    	String strPassword = TestDataHandler.tc727375.getPassword();
    	//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc727375.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc727375.getAccountDetails().getCtn();
        if (getRogersAccountOverviewPage().isAccountShowInDropDown(strAccountNum.substring(strAccountNum.length()-4))) {
            getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        } else {
        	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
        }
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
        getRogersWirelessDashboardPage().scrollToMidOfDasboardPage();
        reporter.reportLogWithScreenshot("Middle of Wireless dashboard page.");        
	    reporter.hardAssert(getRogersWirelessDashboardPage().verifyPlanNameIsDisplayed(),
	    		"Plan name is displayed",
	    		"Plan name is not displayed");	    
	    reporter.hardAssert(getRogersWirelessDashboardPage().verifyMonthlyServiceFeeIsDisplayed(),
	    		"Monthly service fee is displayed in the Plan section",
	    		"Monthly service fee is not displayed in the Plan section");
	    reporter.hardAssert(getRogersWirelessDashboardPage().verifyButtonChangePlanIsDisplayed(),
	    		"Button Change plan is displayed in the plan section",
	    		"Button Change plan is not displayed");
	    reporter.softAssert(getRogersWirelessDashboardPage().verifyIncludedSectionIsDisplayed(),
	    		"Included section is displayed",
	    		"included section is not displayed");
	    reporter.softAssert(getRogersWirelessDashboardPage().verifTitleMyWirelessPlanIsDisplayed(),
	    		"My Wireless plan title is displayed",
	    		"My Wireless plan title is not displayed");
	    reporter.softAssert(getRogersWirelessDashboardPage().verifyMyPlansDetailsIsDisplayedAtTheBottomOfMyPlan(),
	    		"My Plan link details is displayed at the bottom",
	    		"My Plan link details is not displayed at the bottom");
	    getRogersWirelessDashboardPage().clkMyPlanDetailsLink();
	    reporter.softAssert(getRogersWirelessDashboardPage().verifyMyPlanDetailsOverlayIsDisplayed(),
	    "My Plan details overlay is displayed",
	    "My Plan details overlay is not displayed");
	    reporter.reportLogWithScreenshot("My Plan details overlay");   
	    getRogersWirelessDashboardPage().closeMyPlanDetailsOverlay();
	    
    }

}
