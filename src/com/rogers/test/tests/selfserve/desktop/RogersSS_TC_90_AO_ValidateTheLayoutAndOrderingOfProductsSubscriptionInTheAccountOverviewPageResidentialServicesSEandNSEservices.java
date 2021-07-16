package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_90_AO_ValidateTheLayoutAndOrderingOfProductsSubscriptionInTheAccountOverviewPageResidentialServicesSEandNSEservices extends BaseTestClass {	
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	   // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
    @Test(groups = {"RegressionSS","AccountOverviewSS"})
    public void verifyTheLayoutAndOrderingOfProductsSubscriptionInTheAccountOverviewPageResidentialServicesSEandNSEservices() {
        reporter.reportLogWithScreenshot("Home Page");
        reporter.reportLog("Home Page Launched");
    	getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc90.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc90.getPassword());
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login proceed.", "Login got error.");
        getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();

        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc90.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(), "Login Passed", "Login Failed");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("CTNS View");
        
        reporter.hardAssert(getRogersAccountOverviewPage().isShareEverythingDisplayed(),
        "Share everything CTN is avialable",
        "Share everything CTN is not available");
        
        if(getRogersAccountOverviewPage().isShareEverythingCTNLeftAligned()==1)
        {
        	reporter.reportLogPass("The CTNS for Share everything is left aligned");
        }else if(getRogersAccountOverviewPage().isShareEverythingCTNLeftAligned()==2)
        {
        	reporter.reportLogPass("There is only one CTN for Share everything hence left aligned cant be compared wrt to other CTNS");
        }else if(getRogersAccountOverviewPage().isShareEverythingCTNLeftAligned()==3)
        {
        	reporter.reportLogFail("Some CTNS for Share everything is NOT left aligned");
        }
                
        
        reporter.hardAssert(getRogersAccountOverviewPage().isIndividualWirelessCTNsDisplayed(),
                "The NSE CTN service is displayed in a seperate section with one CTN below the other",
                "The NSE CTN service is NOT displayed in a seperate section with one CTN below the other");
        
        reporter.hardAssert(getRogersAccountOverviewPage().isResidentialServicesCTNsDisplayed(),
                "The residential services subscribed is displayed in a distinct section with one CTN below the other",
                "The residential services subscribed is not displayed in a distinct section with one CTN below the other");
                            
        
    }

  

}
