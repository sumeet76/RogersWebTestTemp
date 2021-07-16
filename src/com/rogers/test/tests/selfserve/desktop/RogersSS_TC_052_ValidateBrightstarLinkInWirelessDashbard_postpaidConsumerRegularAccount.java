package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;



public class RogersSS_TC_052_ValidateBrightstarLinkInWirelessDashbard_postpaidConsumerRegularAccount extends BaseTestClass {	
    
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
    public void validateBrightstarLink() {
    	getRogersHomePage().clkSignIn();
    	String strUsername = TestDataHandler.tc495271.getUsername();
    	String strPassword = TestDataHandler.tc495271.getPassword();
    	//getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
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
        //getRogersWirelessDashboardPage().scrollToBottomOfPage();
        reporter.reportLogWithScreenshot("Bottom of Wireless dashboard page.");
        getRogersWirelessDashboardPage().clkLnkTrackPhoneRepairClaim();
        reporter.reportLogWithScreenshot("Link start or track a phone repair claim is clicked.");
        getRogersWirelessDashboardPage().clkBtnHelpYourPhoneContinue();
        reporter.reportLogWithScreenshot("Button continue in help out on your phone is clicked.");
        String strUrlExpected = TestDataHandler.ssConfig.getPhoneRepairUrl();
        reporter.hardAssert(getRogersWirelessDashboardPage().verifyBrightstarLinkOpenSuccessfully(strUrlExpected),
				"Brightstar link opened successfully.", 
				"Brightstar link didn't redirect to expected url.");
        reporter.reportLogWithScreenshot("Brightstar link opened page.");
    }

}
