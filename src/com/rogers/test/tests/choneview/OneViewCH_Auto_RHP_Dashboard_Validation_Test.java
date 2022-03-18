package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_RHP_Dashboard_Validation_Test extends BaseTestClass {
    @Test(groups = {"RegressionCHOV", "SanityCHOV", "SanityCHOVTemp"})
    public void oneViewCH_Auto_RHP_Dashboard_Validation_Test() {
        //getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.RHPManage_AddOns.accountDetails.getBan(),TestDataHandler.RHPManage_AddOns.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().selectHomePhoneBadge();
        reporter.reportLogWithScreenshot("Launched the Home Phone dashboard page");
        reporter.softAssert(getHomePhonedashboard().verifyHeader(), "Header is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Header available on internet Dashboard page");
        reporter.softAssert(getHomePhonedashboard().verifyFooter(), "Footer is available", "Verification of Header failed");
        reporter.reportLogWithScreenshot("Footer available on internet Dashboard page");
        reporter.hardAssert(getHomePhonedashboard().verifyResetVoicemailPassword(), "Reset Voicemail Password Link Available","Reset Voicemail Password Link not Available");
        reporter.reportLogWithScreenshot("Reset voicemail link displayed");
        reporter.hardAssert(getHomePhonedashboard().verifyChangeCallDisplay(), "Change Call Display link Available","Change Call Display link not Available");
        reporter.reportLogWithScreenshot("Change call display display");
        reporter.hardAssert(getHomePhonedashboard().verifyManageAddOns(), "Manage Add-Ons Button Available","Manage Add-Ons Button not Available");
        reporter.reportLogWithScreenshot("Manage Add-ons button display");




    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","", method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
