package com.rogers.test.tests.selfserve.desktop;

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



public class RogersSS_TC_90_AO_VerifyTheLayoutAndOrderingOfProductsSubscriptionInTheAccountOverviewPageResidentialServicesSEandNSEservices extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test
    public void verifyTheLayoutAndOrderingOfProductsSubscriptionInTheAccountOverviewPageResidentialServicesSEandNSEservices() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(TestDataHandler.tc90.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.tc90.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        rogers_login_page.clkSignInIFrame();
        reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();

        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	rogers_account_overview_page.selectAccount(TestDataHandler.tc90.getAccountDetails().getBan());       
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(rogers_account_overview_page.verifySuccessfulLogin(), "Login Passed", "Login Failed");
        common_business_flows.scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("CTNS View");
        
        reporter.hardAssert(rogers_account_overview_page.isShareEverythingDisplayed(),
        "Share everything CTN is avialable",
        "Share everything CTN is not available");
        
        if(rogers_account_overview_page.isShareEverythingCTNLeftAligned()==1)
        {
        	reporter.reportLogPass("The CTNS for Share everything is left aligned");
        }else if(rogers_account_overview_page.isShareEverythingCTNLeftAligned()==2)
        {
        	reporter.reportLogPass("There is only one CTN for Share everything hence left aligned cant be compared wrt to other CTNS");
        }else if(rogers_account_overview_page.isShareEverythingCTNLeftAligned()==3)
        {
        	reporter.reportLogFail("Some CTNS for Share everything is NOT left aligned");
        }
                
        
        reporter.hardAssert(rogers_account_overview_page.isIndividualWirelessCTNsDisplayed(),
                "The NSE CTN service is displayed in a seperate section with one CTN below the other",
                "The NSE CTN service is NOT displayed in a seperate section with one CTN below the other");
        
        reporter.hardAssert(rogers_account_overview_page.isResidentialServicesCTNsDisplayed(),
                "The residential services subscribed is displayed in a distinct section with one CTN below the other",
                "The residential services subscribed is not displayed in a distinct section with one CTN below the other");
                            
        
    }

  

}
