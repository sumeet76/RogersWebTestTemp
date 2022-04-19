package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_OVS1_TC04_Validate_Change_Package_Button_TvInternet_EN_and_FR extends BaseTestClass {

    @Test(groups = {"RChangeTv", "Baseline", "ChangePackage", "RunOV1"})
    public void oneViewCH_Auto_OVS1_TC04_Validate_Change_Package_Button_TvInternet_EN_and_FR() {
        //getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Internet_Dashboard_Validation.accountDetails.getBan(), TestDataHandler.Internet_Dashboard_Validation.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched the internet dashboard page");
        reporter.hardAssert(getInternetDashboardPage().verifyChangePackageButtonEN()," Change package button on Internet dashboard is in English Language", "Change Package button on Internet dashboard is in French Language");
        reporter.reportLogWithScreenshot("Verified Change package button on Internet Dashboard is in English");
        getInternetDashboardPage().clickBacktoAccountOverview();
        reporter.reportLogWithScreenshot("Clicked Back to OneView Dashboard");
        getInternetDashboardPage().clickContinue();
        reporter.reportLogWithScreenshot("Click continue");
        reporter.hardAssert(getAccountOverViewPage().verifyInternetBadge(),"Accounts dashboard Loaded","Accounts dashboard not loaded");
        reporter.reportLogWithScreenshot("Checked Accounts dashboard loaded again");
        getAccountOverViewPage().setLanguageFrench();
        reporter.reportLogWithScreenshot("Change Language to French");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched the internet dashboard page");
        reporter.hardAssert(getInternetDashboardPage().verifyChangePackageButtonFR()," Change package button on Internet dashboard is in French Language", "Change Package button on Internet dashboard is in English Language");
        reporter.reportLogWithScreenshot("Verified Change Package button on Internet Dashboard is in French");
        getInternetDashboardPage().clickBacktoAccountOverview();
        reporter.reportLogWithScreenshot("Clicked Back to OneView again");
        getInternetDashboardPage().clickContinue();
        reporter.reportLogWithScreenshot("Click Continue again");
        reporter.hardAssert(getAccountOverViewPage().verifyInternetBadge(),"Accounts dashboard Loaded","Accounts dashboard not loaded");
        reporter.reportLogWithScreenshot("Accounts Dashboard loaded");
        getAccountOverViewPage().setLanguageFrench();
        reporter.reportLogWithScreenshot("Set Language English again");
        getAccountOverViewPage().selectTVBadage();
        reporter.reportLogWithScreenshot("Launched the TV dashboard page");
        reporter.hardAssert(getTVDashboardPage().verifyChangePackageButtonEN()," Change package button on Internet dashboard is in English Language", "Change Package button on Internet dashboard is in French Language");
        reporter.reportLogWithScreenshot("Verified Change package button on TV Dashboard is in English");
        getTVDashboardPage().clickBacktoAccountOverview();
        reporter.reportLogWithScreenshot("Clicked Back to OneView Dashboard");
        getTVDashboardPage().clickContinue();
        reporter.reportLogWithScreenshot("Click continue");
        reporter.hardAssert(getAccountOverViewPage().verifyTvBadge(),"Accounts dashboard Loaded","Accounts dashboard not loaded");
        reporter.reportLogWithScreenshot("Checked Accounts dashboard loaded again");
        getAccountOverViewPage().setLanguageFrench();
        reporter.reportLogWithScreenshot("Change Language to French");
        getAccountOverViewPage().selectTVBadage();
        reporter.reportLogWithScreenshot("Launched the TV dashboard page");
        reporter.hardAssert(getTVDashboardPage().verifyChangePackageButtonFR()," Change package button on Internet dashboard is in French Language", "Change Package button on Internet dashboard is in English Language");
        reporter.reportLogWithScreenshot("Verified Change Package button on TV Dashboard is in French");
        getTVDashboardPage().clickBacktoAccountOverview();
        reporter.reportLogWithScreenshot("Clicked Back to OneView again");
        getTVDashboardPage().clickContinue();
        reporter.reportLogWithScreenshot("Click Continue again");
        reporter.hardAssert(getAccountOverViewPage().verifyTvBadge(),"Accounts dashboard Loaded","Accounts dashboard not loaded");
        reporter.reportLogWithScreenshot("Accounts Dashboard loaded");

    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext
            testContext, Method method)throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
    }

    @AfterMethod(alwaysRun=true)
    public void afterTest(){
        closeSession();
    }
}

