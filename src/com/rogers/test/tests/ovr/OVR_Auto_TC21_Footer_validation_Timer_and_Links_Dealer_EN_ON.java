package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC21_Footer_validation_Timer_and_Links_Dealer_EN_ON extends BaseTestClass {
    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("OVRURL"), strBrowser, strLanguage, RogersEnums.GroupName.ovr, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
    @Test(groups = {"OVR", "RegressionOVR"})
    public void ovr_Auto_TC21_Footer_validation_Timer_and_Links_Dealer_EN_ON() {
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"), System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        reporter.reportLogWithScreenshot("Account Search Page");
        getAccountSearchPage().selectNewCustomerEnv(TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("QA Env selected for new customer");
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        reporter.hardAssert(getCheckAvailabilityPage().verifyCheckAvailabilityPopup(),"Check Availability Popup present","Check Availability Popup not present" );
        getCheckAvailabilityPage().checkAvailability("642 ABANA RD. MISSISSAUGA, ON L5A1H4", "chrome");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),"Address is serviceable","Address is not serviceable");
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        //Verify session timer in footer and footer links for sign out
        getReporter().hardAssert(getBundleBuilderPage().verifySessionTimerInFooter(),"Session timer present in footer","Session timer not present in footer");
        getReporter().hardAssert(getBundleBuilderPage().verifyFooterLinks(),"Footer Sign out Links present in footer","Footer Sign out Links not present in footer");
        //Verify Logout link
        reporter.reportLogWithScreenshot("Click Logout link");
        getReporter().hardAssert(getBundleBuilderPage().clickLogoutOneviewAndSSP(),"Logged out of Oneview and SSP","Error Logging out of Oneview and SSP");

    }
}
