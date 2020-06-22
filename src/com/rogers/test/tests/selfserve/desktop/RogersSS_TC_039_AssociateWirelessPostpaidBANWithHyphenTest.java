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


public class RogersSS_TC_039_AssociateWirelessPostpaidBANWithHyphenTest extends BaseTestClass {

	@Test
	public void associateWirelessPostpaidBANwithHyphen() {
		
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc041139.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc041139.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();

		String strNewBan = TestDataHandler.tc041139.getAccountDetails().getNewBan();
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	if(rogers_account_overview_page.isAccountLinked(strNewBan)) {
        		rogers_account_overview_page.selectAccount(strNewBan);
        		unlinkThisAccount(strNewBan);
        		rogers_profile_and_settings_page.clkLnkOverview();
        	} else {
        		rogers_account_overview_page.selectAccount(TestDataHandler.tc041139.getAccountDetails().getBan());
        	}
        }
        reporter.reportLogWithScreenshot("Account overview page.");
		rogers_account_overview_page.clkLinkAnotherAccount();
		reporter.softAssert(rogers_link_account_page.verifyLinkAccountPageLoad(), 
				"Link Account page load success.", 
				"Link Account Page Load Failed");
		reporter.reportLogWithScreenshot("Link account page.");
		rogers_link_account_page.setAccountNumber(strNewBan);
		rogers_link_account_page.setPostalCode(TestDataHandler.tc041139.getAccountDetails().getNewPostalcode());
		rogers_link_account_page.clkBtnLinkAccount();
//		try {
//			getDriver().switchTo().alert().accept();
//		}catch (NoAlertPresentException ex){
//			System.out.print("No Alert Present.");
//		}
			
		reporter.reportLogWithScreenshot("Link account processing.");
		
		//reporter.hardAssert(rogers_account_overview_page.verifyLinkAccountSuccessful(), 
		//		"User successfully linked another account.", 
		//		"Link Account Failed -- Success Message DID NOT displayed");
		reporter.reportLogWithScreenshot("Link account completed.");
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
    		rogers_account_overview_page.selectAccount(strNewBan);
        }		
		unlinkThisAccount(strNewBan);
	}
	
	public void unlinkThisAccount(String strBan) {
		rogers_account_overview_page.clkLnkProfileNSettings();
		reporter.reportLogWithScreenshot("Profile & Settings page.");
		//check if the account working on is the account need to be unlink!!!
		if(rogers_profile_and_settings_page.isTheWorkingAccount(strBan)) {
			rogers_profile_and_settings_page.clkLnkUnlinkThisAcct();
			rogers_profile_and_settings_page.clkBtnUnlinkThisAccount();
			reporter.hardAssert(rogers_profile_and_settings_page.verifyAccountUnlinkSuccessMsg(strBan), 
					"User successfully unlinked the account.", 
					"Unlink Account Success Message DID NOT displayed");
			rogers_profile_and_settings_page.clkBtnUnlinkDone();
		}

	}

	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(String strBrowser, String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(TestDataHandler.ssConfig.getRogersURL(),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	

	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
