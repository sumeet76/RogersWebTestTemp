package com.rogers.test.tests.selfserve.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


public class RogersSS_TC_133_PSEF_DP_ValidateTheDisneyPlusDeeplinkURLNavigationForANotLoggedInUser_ConsolidatedAccountWithWireless extends BaseTestClass {
    
	 @BeforeMethod(alwaysRun = true)   @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
	    //xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());		 
		startSession(System.getProperty("QaUrl"),strBrowser,strLanguage,RogersEnums.GroupName.selfserve,method);
				
	}
	   	
	@AfterMethod(alwaysRun = true)
	public void afterTest() throws InterruptedException {
		closeSession();
	}
	
	
	@Test(groups = {"RegressionSS","PACMAN"})
    public void validateSignInAndAccountOverview() {
        reporter.reportLogWithScreenshot("Rogers launched");
        String strDeepLinkURL = System.getProperty("QaUrl").split(".com")[0]+".com"+"/consumer/self-serve/vas/disney-plus";
        getDriver().get(strDeepLinkURL);
        reporter.reportLogWithScreenshot("After setting the deeplink : "+strDeepLinkURL);
        reporter.hardAssert(getRogersLoginPage().isSignInFrameDisplayed()
                , "When a user is not logged into an account and deep link URL is entered, it is asking the user to login first"
                , "The login pop up didnt show up for non logged in user after entering deep link");
        String strUsername = TestDataHandler.tc130.getUsername();
        String strPassword = TestDataHandler.tc130.getPassword();
        String strUrlExpected = TestDataHandler.ssConfig.getPhoneRepairUrl();
        getRogersLoginPage().switchToSignInIFrame();
        getRogersLoginPage().setUsernameIFrame(strUsername);
        getRogersLoginPage().setPasswordIFrame(strPassword);
        reporter.reportLogWithScreenshot("Login Credential is entered.");
        getRogersLoginPage().clkSignInIFrame();
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
        	reporter.reportLogWithScreenshot("Select an account.");
        	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc130.getAccountDetails().getBan());
        }

        reporter.reportLogWithScreenshot("SMP for Disney plus is displayed");
        reporter.hardAssert(getRogersPSEFPage().verifyIfDisneyPlusSMPViewPageIsDisplayed(),
        		"The Disney Plus SMP page is displayed",
        		"The Disney Plus SMP page is NOT displayed");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.reportLogWithScreenshot("Current subscription");
        getCommonBusinessFlows().scrollToTopOfWebPage();
        getRogersPSEFPage().clkAccountOverview();
        reporter.reportLogWithScreenshot("Account Overview");
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),
                "Account overview displayed correctly",
                "Account overview didnt load");
        getCommonBusinessFlows().scrollToMiddleOfWebPage();
        reporter.hardAssert(getRogersPSEFPage().verifyIfDisneyPlusIsDisplayedOnAO(),
                "The Disney Plus is displayed on AO",
                "The Disney Plus is not displayed on AO");
    }

  

}
