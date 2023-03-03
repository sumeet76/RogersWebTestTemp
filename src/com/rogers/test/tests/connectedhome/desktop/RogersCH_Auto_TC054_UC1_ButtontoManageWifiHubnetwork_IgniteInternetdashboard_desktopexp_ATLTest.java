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
 * This class contains the test method to test Legacy Internet Offer Buy flow for Rogers.com
 *
 * @author chinnarao.vattam
 *
 * Test steps:
 * 1.Launch Rogers SAI Tupelo URL in QA Env and click on get it now and enter address and click on continue
 * 2. Click on continue
 * 3. Choose Internet, SmartStream checkbox and click on Load offers
 * 4. Add 1 STB and click on Add to cart
 * 5. Click on Continue
 * 6. Click on Checkout
 * 7. Click on Yes, continue
 * 8. Click on Continue
 * 9. Enter DOB, valid ID details and click on continue
 * 10. Choose Installation type as enhanced self install and click on continue
 * 11. Click on Continue
 * 12. Click on Submit
 *
 **/

public class RogersCH_Auto_TC054_UC1_ButtontoManageWifiHubnetwork_IgniteInternetdashboard_desktopexp_ATLTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersInternetCH"})
    public void rogersCH_Auto_TC054_UC1_ButtontoManageWifiHubnetwork_IgniteInternetdashboard_desktopexp_ATL() {

        reporter.reportLogWithScreenshot("Launched the SignIn popup");
        getRogersLoginPage().setUsernameIFrame(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getUsername());
        getRogersLoginPage().clkContinueInBrowser();
        getRogersLoginPage().setPasswordIFrame(TestDataHandler.tc17_18_19_20_SolarisInternetAccount.getPassword());
        reporter.reportLogWithScreenshot("Enter the account credentials");
        getRogersLoginPage().clkSignInIFrame();
        reporter.hardAssert(!getRogersLoginPage().verifyLoginFailMsgIframe(),"Login Successful","Login Failed");
//        reporter.reportLogWithScreenshot("Skip popup");
//        getRogersLoginPage().clkSkipIFrame();
//        reporter.hardAssert(getRogersAccountOverviewPage().verifySuccessfulLogin(),"Launched the Account Page","Account Page hasn't launched");
        //getRogersAccountOverviewPage().selectAccount(TestDataHandler.tc16_17_18_19_SolarisInternetAccount.accountDetails.getBan());
        reporter.reportLogWithScreenshot("Launched the Account Page");
        getRogersInternetDashboardPage().clkSolarisInternetBadge();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard");
        getRogersInternetDashboardPage().clkInternetPopup();
        getRogersInternetDashboardPage().clkWifiPassword();
        getRogersInternetDashboardPage().SwitchIgnitewifiPage();
        reporter.reportLogWithScreenshot("Launched the Ignite WifiHub");
        reporter.hardAssert(getRogersInternetDashboardPage().verifyIgniteWifiHub(),"Launched the Ignitewifi Page ","Ignitewifi Page hasn't launched");
    }


    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    //legacyAnonymous
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_login, method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }



}


