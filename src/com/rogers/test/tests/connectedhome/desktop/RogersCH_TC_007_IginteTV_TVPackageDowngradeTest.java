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

public class RogersCH_TC_007_IginteTV_TVPackageDowngradeTest extends BaseTestClass {

    @Test(groups = {"SanityCH","RegressionCH","TVPlanUpgardeCH","DryRunCH"})
    public void checkSolarisTVPackageDowngrade() {
        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc04_07_SolarisTVAccount.getUsername());
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc04_07_SolarisTVAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentails");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Skip popup");
        getRogersLoginPage().clkSkipIFrame();
        getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getBan());
        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersSolarisTVDashboardPage().clkTVBadge();
        reporter.reportLogWithScreenshot("Launched the TV dash board");
        getRogersSolarisTVDashboardPage().clkChangeTVPackage();
        reporter.reportLogWithScreenshot("Launched the TV packages page");
        getRogersSolarisTVDashboardPage().clkViewMoreDetailsFlex5();
        reporter.reportLogWithScreenshot("clicked on more details");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyIgniteBoxPrice(),"Additional feature price not zero","zero Additional feature price not zero");
        reporter.reportLogWithScreenshot("clicked on verify details");
        getRogersSolarisTVDashboardPage().selectSolarisTVPackage(TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getDowngradePlanEn(),TestDataHandler.tc04_07_SolarisTVAccount.accountDetails.getDowngradePlanFr());
        reporter.hardAssert(getRogersSolarisTVDashboardPage().verifycontatUSPopUp(),"Displayed the contat US popup","Download package has failed");
        reporter.reportLogWithScreenshot("Launched the customer care popup");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyChangePackagePopupHeader(),"Verified the Change Package Popup Header","Change Package Popup Header is not verified");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyContactUsModalContent(),"Verified the contact us modal content", "Contact us Modal content is not matching");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyBookACallBack(),"Verified the Book a call back link","Book a call back link not verified");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyLiveChat(),"Verified the Live chat link","Live Chat Link is not verified");
      /* // If difference in cost between current and selected package is +/- 10
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackagePopupHeader(),"Verified the Change TV Package Popup Header","Change TV Package Popup Header is not verified");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackageModalContentHeader(),"Verified the Change Package modal content header", "Change Package Modal content header is not matching");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyChangeTVPackageCancelBtn(),"Verified Change TV Package cancel button", "Cancel button verification failed");
        reporter.softAssert(getRogersSolarisTVDashboardPage().verifyPopupChangeTVPackageContinueBtn(), "Verified the Continue button", "Continue button not verified");*/
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


