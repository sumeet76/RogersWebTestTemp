package com.rogers.test.tests.connectedhome.desktop;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * This class contains the test method to validate the TV dashboard for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Login with valid credentials.
 *3. Click on the TV badge.
 *4. Click on View 'My channel Line Up' link below the Channels at the top left.
 *5. Click on the link to view as pdf and open the pdf.
 *6. Click on 'View My Flex channel' link below the Channels in the top left.
 *7. Click on the link to view as pdf and open the pdf.
 *
 **/

public class RogersCH_TC_092_2L7ContractType_3P_ValidateExistingBulkTenantAccountOverviewForInternetTVandIHPTest extends BaseTestClass {

	 @Test(groups = {"RegressionCH","IgniteTVDashboardCH"})
    public void checkTVDashboard() {
        reporter.reportLogWithScreenshot("Launched the Home Page");
        getRogersHomePage().clkSignIn();
        getRogersLoginPage().switchToSignInIFrame();
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
    	reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
        getRogersLoginPage().switchOutOfSignInIFrame();
    	reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
    	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getBan());
    	reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dashboard Page");          
        
        //Verifying the My Channel Line up
        getRogersSolarisTVDashboardPage().clkViewMyChannelLineup();
        reporter.reportLogWithScreenshot("Displayed the available channels"); 
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyChannelList(),"Channels are avilable","None of the Channels are avialabe");
        reporter.softAssert(getRogersSolarisTVDashboardPage().clklAndVerifyViewPDF(),"all the channels are displayed in PDF","PDF is not displying");
        getRogersSolarisTVDashboardPage().clkCloseChannelsPopup();
                    
        //Verifying the Flexchannels                     
        getRogersSolarisTVDashboardPage().clkViewfelxChannels();
        reporter.reportLogWithScreenshot("Displayed the available flex channels");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyChannelList(),"flex channels are avilable","There are no felx channels");
        reporter.softAssert(getRogersSolarisTVDashboardPage().clklAndVerifyViewPDF(),"all the flex channels are displayed in PDF","PDF is not displying");
        getRogersSolarisTVDashboardPage().clkCloseChannelsPopup();


      ////////////////////////////


         reporter.reportLogWithScreenshot("Launched the Account Page");
         getRogersInternetDashboardPage().clkSolarisInternetBadge();
         reporter.reportLogWithScreenshot("Launched the Interent dashboard");
         getRogersInternetDashboardPage().clkInternetPopup();
         reporter.hardAssert(getRogersInternetDashboardPage().verifyInternet(), "Verified the Internet page", "Internet page verification failed");
         reporter.hardAssert(getRogersInternetDashboardPage().verifyUsageAndAlerts(), "Usage and Alerts link present on the internet dash page", "Usage and Alerts link is not present on the internet page");
         getRogersInternetDashboardPage().clkInternetUsageAlerts();
         reporter.reportLogWithScreenshot("Launched the UsageAlerts page");
         reporter.softAssert(getRogersInternetUsagePage().verifyDailyBreakdown(), "Verified the daily usage Breakdown", "Daily usage Breakdown deatils are not present");
         reporter.reportLogWithScreenshot("Daily Breakdown details");
         reporter.softAssert(getRogersInternetUsagePage().verifyDailyBreakdownTable(), "Verified the daily usage", "Daily usage deatils are not present");
         getRogersInternetUsagePage().clkMonthlyUsage();
         reporter.softAssert(getRogersInternetUsagePage().verifyMonthlyBreakdown(),"Verified the monthly usage Breakdown", "Monthly usage Breakdown deatils are not present");
         reporter.reportLogWithScreenshot("Monthly Breakdown details");
         reporter.softAssert(getRogersInternetUsagePage().verifyMonthlyBreakdownTable(),"Verified the monthly usage", "Monthly usage deatils are not present");
         getRogersInternetUsagePage().clkUsageAlerts();
         reporter.softAssert(getRogersInternetUsagePage().verifyUsageAlerts(),"Verified the Usage Alerts", "Usage Alerts are not present");
         reporter.reportLogWithScreenshot("Usage and Alerts details");



	   ///////////////////

         reporter.reportLogWithScreenshot("Launched the Account Page");
         getRogersAccountOverviewPage().clkRHPBadge();
         reporter.reportLogWithScreenshot("Launched the RHP Dashboard Page");
         reporter.softAssert(getRogersSolarisRHPDashboardPage().verifyConfigureYourCurrentFeatures(),"Verification of Configure Your Current Features link is success","Verification of Configure Your Current Features link is Failed");
         reporter.softAssert(getRogersSolarisRHPDashboardPage().verfyAccessYourVoicemailSettings(),"Verification of Access Your Voicemail Settings link is success","Verification of Access Your Voicemail Settings link is successFailed");
         reporter.softAssert(getRogersSolarisRHPDashboardPage().verfyResetYourVoicemailPassword(),"Verification of Reset Your Voicemail Password link is success","Verification of Reset Your Voicemail Password link is success Failed");
	 }


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		//closeSession();
	}



}

