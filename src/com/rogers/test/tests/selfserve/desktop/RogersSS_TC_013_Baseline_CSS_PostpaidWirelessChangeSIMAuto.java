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
	
	
    @Test
    public void postpaidWirelessChangeSIM() {
    	rogers_home_page.clkSignIn();
    	String strUsername = TestDataHandler.tc1314.getUsername();
    	String strPassword = TestDataHandler.tc1314.getPassword();
    	rogers_login_page.switchToSignInIFrame();
        rogers_login_page.setUsernameIFrame(strUsername);
        rogers_login_page.setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
            rogers_account_overview_page.selectAccount(TestDataHandler.tc1314.getAccountDetails().getBan());
        }
        reporter.reportLogWithScreenshot("Account overview page.");   
        rogers_account_overview_page.clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc1314.getAccountDetails().getCtn();
        rogers_account_overview_page.clkDropDownAccount(strAccountNum.substring(strAccountNum.length()-4)); 
        rogers_account_overview_page.clkCloseInNewLookPopupIfVisible();     
        
        reporter.reportLogWithScreenshot("Wireless dashboard page.");   
        rogers_wireless_dashboard_page.clkLinkChangeMySIM();
        reporter.reportLogWithScreenshot("Click on Link : Update Sim card");               
		String strOldSimNum = TestDataHandler.tc1314.getAccountDetails().getSim();
        rogers_wireless_dashboard_page.setOldSimNum(strOldSimNum);
		String strNewSimNum = FormFiller.generateSIMNumber();		
		rogers_wireless_dashboard_page.setNewSimNum(strNewSimNum);
		reporter.reportLogWithScreenshot("Fill old and new sim card details");
		rogers_wireless_dashboard_page.clkBtnUpdateSimNext();
		reporter.reportLogWithScreenshot("Click Button update SIM card Next button");
		reporter.softAssert(rogers_wireless_dashboard_page.verifyUpdateSimReview(strOldSimNum, strNewSimNum),
				"SIM review successful",
				"SIM review is not successful, please investigate");	
		reporter.reportLogWithScreenshot("Update SIM card review page.");        
                           
    }




}
