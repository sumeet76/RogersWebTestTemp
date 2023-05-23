package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TC047_TV_Dashboard_ValidateLinks_ON_EN_Test extends BaseTestClass {
    @Test
    public void oneViewCH_Auto_TC01_TV_Dashboard_ValidateLinks_Test(){

        getEnvironmentSelectionPage().launchOneView(TestDataHandler.solarisTV.getAccountDetails().getBan(),TestDataHandler.solarisTV.getContactID());
        reporter.reportLogWithScreenshot("Launched Account Dashboard page");
        getAccountOverViewPage().selectTVBadage();
        reporter.reportLogWithScreenshot("Selected TV badge");
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        reporter.reportLogWithScreenshot("clicked Proceed button");
        reporter.reportLogWithScreenshot("Launched TV Dashboard Page");
        getTVDashboardPage().clickViewChannelLineUp();
        reporter.reportLogWithScreenshot("Click View Channel Lineup");
        getTVDashboardPage().clickCloseButton();
        reporter.reportLogWithScreenshot("Closing My Channels Modal");
        getTVDashboardPage().clickViewMyFlexChannelsLink();
        reporter.reportLogWithScreenshot("Closing Flex Channels Modal");
        getTVDashboardPage().clickCloseButton();

//        getTVDashboardPage().goToPageMid();
        getTVDashboardPage().clickCloudStorageBubble();
        reporter.reportLogWithScreenshot("Cloud Storage Bubble Button is clicked");
        getTVDashboardPage().clickCloseButton();
        reporter.reportLogWithScreenshot("Closing Cloud Storage Bubble");
        getTVDashboardPage().clickDownloadGoBubble();
        reporter.reportLogWithScreenshot("Download & Go Bubble is clicked");
        getTVDashboardPage().clickCloseButton();
        reporter.reportLogWithScreenshot("Download & Go Bubble closed");

        getTVDashboardPage().clickRestartSetupbox();
        reporter.reportLogWithScreenshot("Clicked on restart Set Top Box link");
        getTVDashboardPage().clickContinueReset();
        reporter.reportLogWithScreenshot("Clicked Continue on Reset Set Top Box popup");
        getTVDashboardPage().clickOK();
        reporter.reportLogWithScreenshot("Clicked OK");
        getTVDashboardPage().clickResetPurchasePin();
        reporter.reportLogWithScreenshot("Clicked on Reset Purchase Pin");
        getTVDashboardPage().clickContinueReset();
        reporter.reportLogWithScreenshot("Continue Clicked");
        getTVDashboardPage().clickOK();
        reporter.reportLogWithScreenshot("Clicked Ok");
        getTVDashboardPage().clickResetParentalControl();
        getTVDashboardPage().clickContinueReset();
       reporter.reportLogWithScreenshot("Clicked Continue on Reset Parental Controls");
        getTVDashboardPage().clickOK();
        reporter.reportLogWithScreenshot("Test Passed");

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
