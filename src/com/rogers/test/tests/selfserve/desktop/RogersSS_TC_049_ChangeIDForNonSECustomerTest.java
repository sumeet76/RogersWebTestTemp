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

import utils.FormFiller;


public class RogersSS_TC_049_ChangeIDForNonSECustomerTest extends BaseTestClass {

	@Test(groups = {"RegressionSS","WirelessDashboardSS"})
	public void changeIDForNonSECustomer() {
		String strFirstName = FormFiller.generateRandomName().toUpperCase();
		String strLastName = FormFiller.generateRandomName().toUpperCase();		
        getRogersHomePage().clkSignIn();
		//getRogersLoginPage().switchToSignInIFrame();
		String strUserName = TestDataHandler.tc495271.getUsername();
		String strPassword = TestDataHandler.tc495271.getPassword();
		getRogersLoginPage().setUsernameIFrame(strUserName);
		getRogersLoginPage().setPasswordIFrame(strPassword);
		getRogersLoginPage().clkSignInIFrame();
		reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login succeed.", "Login got error.");
		getRogersLoginPage().clkSkipIFrame();
		//getRogersLoginPage().switchOutOfSignInIFrame();
		 if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
	        	reporter.reportLogWithScreenshot("Select an account.");
	            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc495271.getAccountDetails().getBan());
	        }
        reporter.reportLogWithScreenshot("Account overview page.");        
        getRogersAccountOverviewPage().clkMenuUsageAndService();
        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked.");
        String strAccountNum = TestDataHandler.tc495271.getAccountDetails().getCtn();        
        String strLast4Dig = strAccountNum.substring(strAccountNum.length()-4);
        if (getRogersAccountOverviewPage().isAccountShowInDropDown(strLast4Dig)) {
        	getRogersAccountOverviewPage().clkDropDownAccount(strLast4Dig);
        } else {
        	getRogersAccountOverviewPage().clkSubMenuWirelessUsage();
        }
        getRogersAccountOverviewPage().clkCloseInNewLookPopupIfVisible();
		getRogersWirelessDashboardPage().clickChangeMyCallerId();
		reporter.reportLogWithScreenshot("Click performed on Change caller id"); 
		
		if (getRogersChangeMyCallerIdPage().isExceedLimitOverlayPopup()) {
			reporter.reportLogWithScreenshot("Change caller id limit exceeded.");
			getRogersChangeMyCallerIdPage().clkBtnDoneInExceedLimitOverlay();
		} else {
			getRogersChangeMyCallerIdPage().setNewCallerIdFirstName(strFirstName);
			getRogersChangeMyCallerIdPage().setNewCallerIdLastName(strLastName);
			reporter.reportLogWithScreenshot("First name and Last name set"); 
			getRogersChangeMyCallerIdPage().clickContinue();
			reporter.reportLogWithScreenshot("Acknowledgement page"); 
			getRogersChangeMyCallerIdPage().clickSubmit();
			reporter.hardAssert(getRogersChangeMyCallerIdPage().verifyCallerIdChangeSuccessMsg(),
					"Caller ID update confirmation message displayed",
					"Successful Caller ID name update message NOT displayed");
			reporter.reportLogWithScreenshot("Caller id update confirmation"); 
			getRogersChangeMyCallerIdPage().clickDone();
			getRogersWirelessDashboardPage().scrollToTopOfDasboardPage();
			getRogersWirelessDashboardPage().clickOverview();
			reporter.reportLogWithScreenshot("Back on overview page"); 
			
			getCommonBusinessFlows().logOutAndReSignIn(strUserName, strPassword);     					
			reporter.hardAssert(getRogersAccountOverviewPage().verifyWirelessCallerIdCTNBadgeName(strFirstName),
					"Caller ID First Name" + strFirstName + " is updated in CTN badge",
					"Caller ID First Name" + strFirstName + " is NOT updated in CTN badge");
			getRogersAccountOverviewPage().clkMenuUsageAndService();
	        reporter.reportLogWithScreenshot("Menu Usage & Service is clicked");
			reporter.hardAssert(getRogersAccountOverviewPage().verifyWirelessCallerIdUpdatedInDropDownToSelectWirelessUsage(strFirstName),
					"Caller ID First Name" + strFirstName + " is updated in Dropdown to select usage and services",
					"Caller ID First Name" + strFirstName + " is NOT updated in Dropdown to select usage and services");
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
