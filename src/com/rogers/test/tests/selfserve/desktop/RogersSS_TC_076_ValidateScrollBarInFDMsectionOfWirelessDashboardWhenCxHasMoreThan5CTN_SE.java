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



public class RogersSS_TC_076_ValidateScrollBarInFDMsectionOfWirelessDashboardWhenCxHasMoreThan5CTN_SE extends BaseTestClass {	
   	
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		}
	   	
		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}

	
    @Test(groups = {"RegressionSS","FDMSS"})
    public void validateScrollBarInFDMsectionOfWirelessDashboardWhenCxHasMoreThan5CTN_SE() {
    	getRogersHomePage().clkSignIn();
    	//TODO create new data file
    	String strUsername = TestDataHandler.tc7681.getUsername();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        String strPassword = TestDataHandler.tc7681.getPassword();    	
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		
		common_business_flows.scrollToMiddleOfWebPage();
		reporter.reportLogWithScreenshot("Check the number of CTNs");
		reporter.hardAssert(getRogersAccountOverviewPage().isCTNMoreThanSix(),
				"The account has more than 5 CTNS",
				"The account doesnt have more than 5 CTN's, please add more than 5 and rerun");
		common_business_flows.scrollToTopOfWebPage();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc7681.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");     
       getRogersAccountOverviewPage().clkMenuUsageAndService();
       //For demo-line data, the sub-menu shows as "Wireless Usage"
   		getRogersAccountOverviewPage().clkSubMenuWirelessUsage();

       getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();  
              
       reporter.hardAssert(getRogersWirelessDashboardPage().isScrollForCTNsPresent(),
    		   "The scroll for CTNS is present",
    		   "The scroll for CTNs not present");
       getRogersWirelessDashboardPage().clkLeftCTNScrollArrow();
       getRogersWirelessDashboardPage().clkLeftCTNScrollArrow();
       reporter.reportLogWithScreenshot("Click on left scroll performed"); 
       getRogersWirelessDashboardPage().clkTheNthCTNOnDashboardPage(1);
       reporter.reportLogWithScreenshot("Click 1st CTN");
       reporter.hardAssert(getRogersWirelessDashboardPage().isSixthCTNBadgeInVisibleBeforeScrollingOnDashBoard(),
    		   "6th CTN badge is not visible before scroll",
    		   "6th CTN is visible before scroll");
       getRogersWirelessDashboardPage().clkNextCTNScrollArrow();
       reporter.hardAssert(getRogersWirelessDashboardPage().isSixthCTNVisible(),
    		   "6th CTN badge is visible After click on  scroll",
    		   "6th CTN is not visible after click on scrol scroll");
       getRogersWirelessDashboardPage().clkTheSixthCTN();
       reporter.reportLogWithScreenshot("Clicked 6th CTN and wireless dashboard loaded for 6th"); 
    }
    
    
    

}
