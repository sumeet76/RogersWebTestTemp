package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TC01_Validation_of_Exchange_Flex_Channels_Existing_Customer extends BaseTestClass {
    @Test (groups = {"MaySanity"})
    public void oneViewCH_Auto_TC01_Validation_of_Exchange_Flex_Channels_Existing_Customer(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.SUS_16553_TC01_Validation_of_Exchange_Flex_Channels_Existing_Customer.accountDetails.getBan(), TestDataHandler.SUS_16553_TC01_Validation_of_Exchange_Flex_Channels_Existing_Customer.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().selectTVBadage();
        reporter.reportLogWithScreenshot("Launched Tv Dashboard Page");
        getTVDashboardPage().clickManageChannelsAndThemepacks();
        reporter.reportLogWithScreenshot("Manage Channels and Themepacks Clicked");
        getTVDashboardPage().clkExchangeFlexChannels();
        reporter.reportLogWithScreenshot("Exchange Flex Channels Is clicked");
      //  getTVDashboardPage().clickSearchChannelToRemove();
      //  reporter.reportLogWithScreenshot("Search Channel is clicked");
        getTVDashboardPage().clickFirstChannelToRemove();
        reporter.reportLogWithScreenshot("first channel to be removed is clicked");
      //  getTVDashboardPage().clickSelectChannelRemove();
        reporter.reportLogWithScreenshot("first channel is removed");
        getTVDashboardPage().clickSecondChannelToRemove();
        reporter.reportLogWithScreenshot("Second channel to be removed is clicked");
       // getTVDashboardPage().clickSelectChannelRemove();
        reporter.reportLogWithScreenshot("second channel is removed");
       // getTVDashboardPage().clickSearchChannelToAdd();
      // reporter.reportLogWithScreenshot("Search channel to add bar is clicked");
        getTVDashboardPage().clickFirstChannelToAdd();
        reporter.reportLogWithScreenshot("First channel to be added is clicked ");
        //getTVDashboardPage().clickSelectChannelAdd();
        reporter.reportLogWithScreenshot("First channel is added");
        getTVDashboardPage().clickSecondChannelToAdd();
        reporter.reportLogWithScreenshot("Second channel to be added is clicked");
       // getTVDashboardPage().clickSelectChannelAdd();
        reporter.reportLogWithScreenshot("Second channel is added");
        getTVDashboardPage().ScrolltoConfirmExchangeBtn();
        getTVDashboardPage().clickConfirmExchange("chrome");
 //       getTVDashboardPage().clickOK();
//        getTVDashboardPage().clickContinueChannelsAndThemePacks();
  //      getTVDashboardPage().clickSuccessOk();



    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext testContext, Method method)throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
    }
    @AfterMethod(alwaysRun=true)
    public void afterTest(){
        closeSession();
    }

}
