package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_039_AssociateWirelessPostpaidBANWithHyphenTest extends BaseTestClass {

	@Test(groups = {"RegressionSS","WirelessDashboardSS"})
	public void associateWirelessPostpaidBANwithHyphen() {
		
		getRogersHomePage().clkSignIn();
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
        	reporter.reportLogWithScreenshot("Select an account.");
        	if(getRogersAccountOverviewPage().isAccountLinked(strNewBan)) {
        		getRogersAccountOverviewPage().selectAccount(strNewBan);
        		unlinkThisAccount(strNewBan);
        		getRogersProfileAndSettingsPage().clkLnkOverview();
        	} else {
        		getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc041139.getAccountDetails().getBan());
        	}
        }
        reporter.reportLogWithScreenshot("Account overview page.");
		getRogersAccountOverviewPage().clkLinkAnotherAccount();
		reporter.hardAssert(getRogersLinkAccountPage().verifyLinkAccountPageLoad(),
				"Link Account page load success.", 
				"Link Account Page Load Failed");
		reporter.reportLogWithScreenshot("Link account page.");
		getRogersLinkAccountPage().setAccountNumber(strNewBan);
		getRogersLinkAccountPage().setPostalCode(TestDataHandler.tc041139.getAccountDetails().getNewPostalcode());
		getRogersLinkAccountPage().clkBtnLinkAccount();
//		try {
//			getDriver().switchTo().alert().accept();
//		}catch (NoAlertPresentException ex){
//			System.out.print("No Alert Present.");
//		}
			
		reporter.reportLogWithScreenshot("Link account processing.");
		
		//reporter.hardAssert(getRogersAccountOverviewPage().verifyLinkAccountSuccessful(), 
		//		"User successfully linked another account.", 
		//		"Link Account Failed -- Success Message DID NOT displayed");
		reporter.reportLogWithScreenshot("Link account completed.");
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
    		getRogersAccountOverviewPage().selectAccount(strNewBan);
        }		
		unlinkThisAccount(strNewBan);
	}
	
	public void unlinkThisAccount(String strBan) {
		getRogersAccountOverviewPage().clkLnkProfileNSettings();
		reporter.reportLogWithScreenshot("Profile & Settings page.");
		//check if the account working on is the account need to be unlink!!!
		if(getRogersProfileAndSettingsPage().isTheWorkingAccount(strBan)) {
			getRogersProfileAndSettingsPage().clkLnkUnlinkThisAcct();
			getRogersProfileAndSettingsPage().clkBtnUnlinkThisAccount();
			reporter.hardAssert(getRogersProfileAndSettingsPage().verifyAccountUnlinkSuccessMsg(strBan),
					"User successfully unlinked the account.", 
					"Unlink Account Success Message DID NOT displayed");
			getRogersProfileAndSettingsPage().clkBtnUnlinkDone();
		}

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
