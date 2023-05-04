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
 * This class contains the test method to verify the solaris TV package downgrade flow for Rogers.com   
 *
 * @author chinnarao.vattam
 *
 * Test steps:
 *
 *1. Launch the Rogers.com url.
 *2. Log into rogers.com url with valid credentials.
 *3. Click on TV.
 *4. Click on chage package button.
 *5. Select a package which has price lower to the current package.
 *
 **/

public class RogersCH_Auto_TC008_Negative_SolarisTVCx_TVPackageDowngradeTest extends BaseTestClass {

    @Test(groups = {"SanityCH", "RegressionCH", "TVPlanUpgardeCH", "ReleaseSanity"})
    public void rogersCH_Auto_TC008_Negative_SolarisTVCx_TVPackageDowngrade() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc01_02_03_IgniteTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();

        /* if (getRogersLoginPage().verifyMFAScreenIsVisible()) {
            reporter.reportLogWithScreenshot("Click on Text as recovery option");
            getRogersLoginPage().clkTextToAsRecoveryOption();
            String strTestingTab = getDriver().getWindowHandle();
            // will open a new tab for ENS, to get verification code from ENS
            reporter.reportLogWithScreenshot("ENS");
            String strPhoneNum = TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getRecoveryNumber();
            String strEnsUrl = System.getProperty("EnsUrl");
            String recoveryCode = getEnsVerifications().getTextVerificationCode(strPhoneNum, strEnsUrl);
            getDriver().switchTo().window(strTestingTab);
            reporter.reportLogWithScreenshot("Close the Overlay");
            getRegisterOrAccountRecoveryPage().setVerificationCode(recoveryCode);
            getRegisterOrAccountRecoveryPage().clkBtnContinue();
            reporter.reportLogWithScreenshot("Continue to Account Overview");
        } */

        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc01_02_03_IgniteTVAccount.accountDetails.getBan());
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(), "Login Successful", "Login Failed");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        getRogersSolarisTVDashboardPage().clkChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the TV packages page");

        /* getRogersSolarisTVDashboardPage().clkViewMoreDetailsFlex5();
        reporter.reportLogWithScreenshot("clicked on more details");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyIgniteBoxPrice(),"Additional feature price not zero","zero Additional feature price");
        reporter.reportLogWithScreenshot("clicked on verify details"); */

        getRogersSolarisTVDashboardPage().selectSolarisTVPackage(TestDataHandler.tc04_08_SolarisTVAccount.accountDetails.getDowngradePlanEn(), TestDataHandler.tc04_08_SolarisTVAccount.accountDetails.getDowngradePlanFr());
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifycontatUSPopUp(), "Displayed the contat US popup", "Download package has failed");
        reporter.reportLogWithScreenshot("Launched the customer care popup");

       /* reporter.softAssert(getRogersSolarisTVDashboardPage().verifyChangePackagePopupHeader(),"Verified the Change Package Popup Header","Change Package Popup Header is not verified");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyBookACallBack(),"Verified the Book a call back link","Book a call back link not verified");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyLiveChat(),"Verified the Live chat link","Live Chat Link is not verified");
         // If difference in cost between current and selected package is +/- 20 upgrade modal will be shown
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackagePopupHeader(),"Verified the Change TV Package Popup Header","Change TV Package Popup Header is not verified");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackageModalContentHeader(),"Verified the Change Package modal content header", "Change Package Modal content header is not matching");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackageCancelBtn(),"Verified Change TV Package cancel button", "Cancel button verification failed");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyPopupChangeTVPackageContinueBtn(), "Verified the Continue button", "Continue button not verified"); */
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    //login flow
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_login, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}
