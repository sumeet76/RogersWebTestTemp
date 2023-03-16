package com.rogers.test.tests.connectedhome.sanity;

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

public class RogersCH_Auto_TC001_SolarisTVCx_ValidateTVDashboard_Channels_PDFTest extends BaseTestClass {
    @Test(groups = {"SanityCH","RegressionCH","IgniteTVDashboardCH","ReleaseSanity"}, description = "Rogers Ignite TV Dashboard")
    public void rogersCH_Auto_TC001_SolarisTVCx_ValidateTVDashboard_Channels_PDF() throws IOException {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
//        if(getRogersLoginPage().verifyMFAScreenIsVisible()) {
//            reporter.reportLogWithScreenshot("Click on Text as recovery option");
//            getRogersLoginPage().clkTextToAsRecoveryOption();
//            String strTestingTab = getDriver().getWindowHandle();
//            //Will open a new tab for ENS, to get verification code from ENS
//            reporter.reportLogWithScreenshot("ENS");
//            String strPhoneNum = TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getRecoveryNumber();
//            String strEnsUrl = System.getProperty("EnsUrl");
//            String recoveryCode = getEnsVerifications().getTextVerificationCodeCH(strPhoneNum, strEnsUrl);
//            getDriver().switchTo().window(strTestingTab);
//            reporter.reportLogWithScreenshot("Close the Overlay");
//            getRegisterOrAccountRecoveryPage().setVerificationCode(recoveryCode);
//            getRegisterOrAccountRecoveryPage().clkBtnContinue();
//            reporter.reportLogWithScreenshot("Continue to Account Overview");
//        }
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
    	getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getBan());
    	reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dashboard Page");          
        
        //Verifying My Channel Line up
        getRogersSolarisTVDashboardPage().clkViewMyChannelLineup();
        reporter.reportLogWithScreenshot("Displayed the available channels"); 
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyChannelList(),"Channels are available","None of the Channels are available");
        reporter.softAssert(getRogersSolarisTVDashboardPage().clklAndVerifyViewPDF(),"all the channels are displayed in PDF","PDF is not displaying");
        getRogersSolarisTVDashboardPage().clkCloseChannelsPopup();
         reporter.reportLogWithScreenshot("Closed the available channels popup");

         //Verifying the Flexchannels
        getRogersSolarisTVDashboardPage().clkViewfelxChannels();
        reporter.reportLogWithScreenshot("Displayed the available flex channels");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyChannelList(),"flex channels are available","There are no flex channels");
        reporter.softAssert(getRogersSolarisTVDashboardPage().clklAndVerifyViewPDF(),"all the flex channels are displayed in PDF","PDF is not displaying");
        getRogersSolarisTVDashboardPage().clkCloseChannelsPopup();
    	}       


	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,  ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}



}

