package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_11_TC04_ValidateUserTryToLinkAccountToRegisteredProfile extends BaseTestClass {

	@Test
	public void validateUserLinkAccountToRegisteredProfile() {
		
		rogers_home_page.clkSignIn();
		reporter.reportLogWithScreenshot("Sign In page");
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc041139.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc041139.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		reporter.hardAssert(!rogers_login_page.verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		String strNewBan = TestDataHandler.tc041139.getAccountDetails().getNewBan();
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select account.");
        	if(rogers_account_overview_page.isAccountLinked(strNewBan)) {
        		rogers_account_overview_page.selectAccount(strNewBan);
        		unlinkThisAccount(strNewBan);
        	} else {
        		rogers_account_overview_page.selectAccount(TestDataHandler.tc041139.getAccountDetails().getBan());
        	}
        }
        reporter.reportLogWithScreenshot("Account overview page.");
		rogers_account_overview_page.clkLnkProfileNSettings();
		reporter.reportLogWithScreenshot("Profile and Settings page");

		//click the link to link another account from Profile & Settings page
		rogers_profile_and_settings_page.clklnkLinkAnotherAcct();
		reporter.hardAssert(rogers_link_account_page.verifyLinkAccountPageLoad(), 
								"Link Account page load success, ready to set account number.", 
								"Link Account Page Load Failed");		

		rogers_link_account_page.setAccountNumber(strNewBan);
		reporter.reportLogWithScreenshot("Account number added");
		rogers_link_account_page.setPostalCode(TestDataHandler.tc041139.getAccountDetails().getNewPostalcode());
		reporter.reportLogWithScreenshot("Postal code added");
		rogers_link_account_page.clkBtnLinkAccount();
		reporter.reportLogWithScreenshot("Button Link account clicked");
		//reporter.softAssert(rogers_account_overview_page.verifyLinkAccountSuccessful(), 
		//		"User successfully linked another account.", 
		//		"Link Account Success Message DID NOT displayed");
		
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Account selection pop up displayed, will select account : "+strNewBan);
    		rogers_account_overview_page.selectAccount(strNewBan);
        }
        reporter.reportLogWithScreenshot("Link account successful");
	}
	
	@Test (dependsOnMethods = "validateUserLinkAccountToRegisteredProfile")
	public void validateUserRemoveAccount() {
		
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		rogers_login_page.setUsernameIFrame(TestDataHandler.tc041139.getUsername());
		rogers_login_page.setPasswordIFrame(TestDataHandler.tc041139.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		rogers_login_page.clkSignInIFrame();
		rogers_login_page.clkSkipIFrame();
		rogers_login_page.switchOutOfSignInIFrame();
		String strBan = TestDataHandler.tc041139.getAccountDetails().getNewBan();
        if (rogers_account_overview_page.isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select account.");
    		rogers_account_overview_page.selectAccount(strBan);
        }

        if (rogers_account_overview_page.verifySuccessfulLogin()) {
        	reporter.reportLogWithScreenshot("Login successful");
    		unlinkThisAccount(strBan);
        }
	}
	
	public void unlinkThisAccount(String strBan) {
		rogers_account_overview_page.clkLnkProfileNSettings();
		//check if the account working on is the account need to be unlink!!!
		reporter.hardAssert(rogers_profile_and_settings_page.isTheWorkingAccount(strBan),
							"The account you want to unlink is the working account.",
							"The account you want to unlink is not this working account.");
		rogers_profile_and_settings_page.clkLnkUnlinkThisAcct();
		rogers_profile_and_settings_page.clkBtnUnlinkThisAccount();
		reporter.reportLogWithScreenshot("Button unlink account clicked");
		reporter.softAssert(rogers_profile_and_settings_page.verifyAccountUnlinkSuccessMsg(strBan), 
							"User successfully unlinked the account.", 
							"Unlink Account Success Message DID NOT displayed");
		reporter.reportLogWithScreenshot("Unlink successful");
		rogers_profile_and_settings_page.clkBtnUnlinkDone();
		reporter.reportLogWithScreenshot("Button Unlink Done clicked");

	}

	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
		public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
			startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
			// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		
		}
	   	
		

		
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
}
