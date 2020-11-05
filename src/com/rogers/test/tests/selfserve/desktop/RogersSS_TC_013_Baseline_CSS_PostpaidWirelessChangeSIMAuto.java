package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_013_Baseline_CSS_PostpaidWirelessChangeSIMAuto extends BaseTestClass {	
    
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
    public void postpaidWirelessChangeSIM() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc1314.getUsername();
    	String strPassword = TestDataHandler.tc1314.getPassword();
    	getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc1314.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc1314.getAccountDetails().getCtn();
        getRogersAccountOverviewPage().clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4));
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
        
        reporter.reportLogWithScreenshot("Wireless dashboard page.");   
        getRogersWirelessDashboardPage().clkLinkChangeMySIM();
        reporter.reportLogWithScreenshot("Click on Link : Update Sim card");               
		String strOldSimNum = TestDataHandler.tc1314.getAccountDetails().getSim();
        getRogersWirelessDashboardPage().setOldSimNum(strOldSimNum);
		String strNewSimNum = FormFiller.generateSIMNumber();		
		getRogersWirelessDashboardPage().setNewSimNum(strNewSimNum);
		reporter.reportLogWithScreenshot("Fill old and new sim card details");
		getRogersWirelessDashboardPage().clkBtnUpdateSimNext();
		reporter.reportLogWithScreenshot("Click Button update SIM card Next button");
		reporter.softAssert(getRogersWirelessDashboardPage().verifyUpdateSimReview(strOldSimNum, strNewSimNum),
				"SIM review successful",
				"SIM review is not successful, please investigate");	
		reporter.reportLogWithScreenshot("Update SIM card review page.");        
                           
    }




}
