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
 * This class contains the test method to verify the solaris internet package downgrade flow for Rogers.com   
 * 
 * @author chinnarao.vattam
 * 
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on internet package.
 *4. Click on change package button.
 *5. Select a package which has price lower to the current package.
 *
 **/

public class RogersCH_Auto_TC018_SolarisInternetCx_InternetPackageDowngradeTest extends BaseTestClass {

	@Test(groups = {"SanityCH","RegressionCH","RogersInternetCH","ReleaseSanity"})
    public void rogersCH_Auto_TC018_SolarisInternetCx_InternetPackageDowngrade() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        if (getRogersLoginPage().verifyMFAScreenIsVisible()) {
            reporter.reportLogWithScreenshot("Click on Text as recovery option");
            getRogersLoginPage().clkTextToAsRecoveryOption();
            String strTestingTab = getDriver().getWindowHandle();
            //Will open a new tab for ENS, to get verification code from ENS
            reporter.reportLogWithScreenshot("ENS");
            String strPhoneNum = TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getRecoveryNumber();
            String strEnsUrl = System.getProperty("EnsUrl");
            String recoveryCode = getEnsVerifications().getTextVerificationCode(strPhoneNum, strEnsUrl);
            getDriver().switchTo().window(strTestingTab);
            reporter.reportLogWithScreenshot("Close the Overlay");
            getRegisterOrAccountRecoveryPage().setVerificationCode(recoveryCode);
            getRegisterOrAccountRecoveryPage().clkBtnContinue();
            reporter.reportLogWithScreenshot("Continue to Account Overview");
        }
        if (getRogersAccountOverviewPage().isAccountSelectionPopupDisplayed()) {
            reporter.reportLogWithScreenshot("Select an account.");
            getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.accountDetails.getBan());
        }
        reporter.reportLogWithScreenshot("Account Selected");
        getRogersInternetDashboardPage().clkSolarisInternetBadge();
        reporter.reportLogWithScreenshot("Launched the Interent dashboard");
        getRogersInternetDashboardPage().clkInternetPopup();
        getRogersInternetDashboardPage().clkSolChangeInternetPackage();
        reporter.reportLogWithScreenshot("Launched the Interent packages page");
        getRogersInternetDashboardPage().selectSolarisInternetPackage(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getAccountDetails().getDowngradePlanEn(), TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getAccountDetails().getDowngradePlanFr());
        //getRogersInternetDashboardPage().clkInternetChangeOK();
        //  reporter.hardAssert(getRogersInternetDashboardPage().verifyContatUSInternetDowngardeInternet(),"Displayed the contat US popup","Download package has failed");
        reporter.reportLogWithScreenshot("Launched the customercare popup");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyChangePackagePopupHeader(), "Verified the Change Package Popup Header", "Change Package Popup Header is not verified");
        //  reporter.hardAssert(getRogersInternetDashboardPage().verifyContactUsModalContent(),"Verified the contact us modal content", "Contact us Modal content is not matching");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyBookACallBack(), "Verified the Book a call back link", "Book a call back link not verified");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyLiveChat(), "Verified the Live chat link", "Live Chat Link is not verified");
    }
	
	@BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
	//login flow
	public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
		// xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
		startSession(System.getProperty("QaUrl"), strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		closeSession();
	}

}
