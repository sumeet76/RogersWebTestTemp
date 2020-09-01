package com.rogers.test.tests.solarisconsumer;

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
import com.rogers.testdatamanagement.TestDataHandler;


/**
 * This class contains the test method to validate the Solaris consumer home phone dashboard for Rogers.com   
 * 
 * @author Saurav.Goyal
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the Homephone badge.
 *4. Verify configure Your current features link
 *5. Verify access Your voicemail settings link
 *6. Verify reset Your voicemail password link is success
 *
 **/


public class RogersSC_TC_011_IgniteRHP_ValidateRHPDasboardAndLinksTest extends BaseTestClass {

    @Test
    public void checkSolarisConsumerRHPDasboardAndLinks() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		rogers_home_page.clkSignIn();
		rogers_login_page.switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
        rogers_login_page.setUsernameIFrame(TestDataHandler.igniteRHP.getUsername());
        rogers_login_page.setPasswordIFrame(TestDataHandler.igniteRHP.getPassword());
 		reporter.reportLogWithScreenshot("Enter the account credentails");
 		rogers_login_page.clkSignInIFrame();
 		reporter.reportLogWithScreenshot("Skip popup");
 		rogers_login_page.clkSkipIFrame();
 		rogers_login_page.switchOutOfSignInIFrame();
        rogers_account_overview_page.selectAccount(TestDataHandler.igniteRHP.accountDetails.getBan()); 
		reporter.softAssert(rogers_account_overview_page.verifySuccessfulLogin(),"Login Success","Login Failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
        rogers_solaris_rhp_dashboard_validation_page.clkSolarisRHPBadge(TestDataHandler.chConfig.getBrowser()); 
        reporter.reportLogWithScreenshot("Launched the RHP Dashboard Page");
        reporter.softAssert(rogers_solaris_rhp_dashboard_validation_page.verifyConfigureYourCurrentFeatures(),"Verification of Configure Your Current Features link is success","Verification of Configure Your Current Features link is Failed");
        reporter.softAssert(rogers_solaris_rhp_dashboard_validation_page.verfyAccessYourVoicemailSettings(),"Verification of Access Your Voicemail Settings link is success","Verification of Access Your Voicemail Settings link is successFailed");
        reporter.softAssert(rogers_solaris_rhp_dashboard_validation_page.verfyResetYourVoicemailPassword(),"Verification of Reset Your Voicemail Password link is success","Verification of Reset Your Voicemail Password link is success Failed");
    }

    @BeforeMethod @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,strGroupName, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


