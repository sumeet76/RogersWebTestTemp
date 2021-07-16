package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_011_TC04_ValidateUserTryToLinkAccountToRegisteredProfile extends BaseTestClass {

	@Test(groups = {"RegressionSS","ProfileAndSettingsSS"})
	public void validateUserLinkAccountToRegisteredProfile() {
		
		getRogersHomePage().clkSignIn();
		reporter.reportLogWithScreenshot("Sign In page");
		//getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc041139.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc041139.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
		String strNewBan = TestDataHandler.tc041139.getAccountDetails().getNewBan();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select account.");
        	if(getRogersAccountOverviewPage().isAccountLinked(strNewBan)) {
        		getRogersAccountOverviewPage().selectAccount(strNewBan);
        		unlinkThisAccount(strNewBan);
        	} else {
        		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc041139.getAccountDetails().getBan());
        	}
        }
        reporter.reportLogWithScreenshot("Account overview page.");
		getRogersAccountOverviewPage().clkLnkProfileNSettings();
		reporter.reportLogWithScreenshot("Profile and Settings page");

		//click the link to link another account from Profile & Settings page
		getRogersProfileAndSettingsPage().clklnkLinkAnotherAcct();
		reporter.hardAssert(getRogersLinkAccountPage().verifyLinkAccountPageLoad(),
								"Link Account page load success, ready to set account number.", 
								"Link Account Page Load Failed");		

		getRogersLinkAccountPage().setAccountNumber(strNewBan);
		reporter.reportLogWithScreenshot("Account number added");
		getRogersLinkAccountPage().setPostalCode(TestDataHandler.tc041139.getAccountDetails().getNewPostalcode());
		reporter.reportLogWithScreenshot("Postal code added");
		getRogersLinkAccountPage().clkBtnLinkAccount();
		reporter.reportLogWithScreenshot("Button Link account clicked");
		//reporter.softAssert(getRogersAccountOverviewPage().verifyLinkAccountSuccessful(), 
		//		"User successfully linked another account.", 
		//		"Link Account Success Message DID NOT displayed");
		
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Account selection pop up displayed, will select account : "+strNewBan);
    		getRogersAccountOverviewPage().selectAccount(strNewBan);
        }
        reporter.reportLogWithScreenshot("Link account successful");
	}

	@Test (dependsOnMethods = "validateUserLinkAccountToRegisteredProfile", groups = {"RegressionSS","ProfileAndSettingsSS"})
	public void validateUserRemoveAccount() {
		
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc041139.getUsername());
		getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc041139.getPassword());
		reporter.reportLogWithScreenshot("Login Credential is entered.");
		getRogersLoginPage().clkSignInIFrame();
		getRogersLoginPage().clkSkipIFrame();
		getRogersLoginPage().switchOutOfSignInIFrame();
		String strBan = TestDataHandler.tc041139.getAccountDetails().getNewBan();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select account.");
    		getRogersAccountOverviewPage().selectAccount(strBan);
        }

        if (getRogersAccountOverviewPage().verifySuccessfulLogin()) {
        	reporter.reportLogWithScreenshot("Login successful");
    		unlinkThisAccount(strBan);
        }
	}
	
	public void unlinkThisAccount(String strBan) {
		getRogersAccountOverviewPage().clkLnkProfileNSettings();
		//check if the account working on is the account need to be unlink!!!
		reporter.hardAssert(getRogersProfileAndSettingsPage().isTheWorkingAccount(strBan),
							"The account you want to unlink is the working account.",
							"The account you want to unlink is not this working account.");
		getRogersProfileAndSettingsPage().clkLnkUnlinkThisAcct();
		getRogersProfileAndSettingsPage().clkBtnUnlinkThisAccount();
		reporter.reportLogWithScreenshot("Button unlink account clicked");
		reporter.softAssert(getRogersProfileAndSettingsPage().verifyAccountUnlinkSuccessMsg(strBan),
							"User successfully unlinked the account.", 
							"Unlink Account Success Message DID NOT displayed");
		reporter.reportLogWithScreenshot("Unlink successful");
		getRogersProfileAndSettingsPage().clkBtnUnlinkDone();
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
