package com.rogers.test.tests.solarisconsumer;

import com.rogers.test.base.BaseTestClass;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


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
	final String strBrowser=System.getProperty("Browser");
    @Test
    public void checkSolarisConsumerRHPDasboardAndLinks() {
		reporter.reportLogWithScreenshot("Launched the Home Page");
		getRogersHomePage().clkSignIn();
		getRogersLoginPage().switchToSignInIFrame();
		reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc42_igniteRHP.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc42_igniteRHP.getPassword());
 		reporter.reportLogWithScreenshot("Enter the account credentails");
 		getRogersLoginPage().clkSignInIFrame();
 		reporter.reportLogWithScreenshot("Skip popup");
 		getRogersLoginPage().clkSkipIFrame();
 		getRogersLoginPage().switchOutOfSignInIFrame();
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc42_igniteRHP.accountDetails.getBan());
		reporter.softAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Login Success","Login Failed");
		reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisRHPDashboardPage().clkSolarisRHPBadge(strBrowser);
        reporter.reportLogWithScreenshot("Launched the RHP Dashboard Page");
        reporter.softAssert(getRogersSolarisRHPDashboardPage().verifyConfigureYourCurrentFeatures(),"Verification of Configure Your Current Features link is success","Verification of Configure Your Current Features link is Failed");
        reporter.softAssert(getRogersSolarisRHPDashboardPage().verfyAccessYourVoicemailSettings(),"Verification of Access Your Voicemail Settings link is success","Verification of Access Your Voicemail Settings link is successFailed");
        reporter.softAssert(getRogersSolarisRHPDashboardPage().verfyResetYourVoicemailPassword(),"Verification of Reset Your Voicemail Password link is success","Verification of Reset Your Voicemail Password link is success Failed");
    }

    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, String strGroupName,ITestContext testContext,Method method) throws ClientProtocolException, IOException {
		startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,strGroupName, method);
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}


