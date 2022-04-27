package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_OVS3_RHPAddOns_Validate_ConfigureCallerId_And_DirectoryListingPage_Test extends BaseTestClass {
    @Test
    public void oneViewCH_Auto_OVS3_RHPAddOns_ValidateConfigureCallerIdAndDirectoryListingPage_Test(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.RHPAddOns_ValidateConfigureCallerIdAndDirectoryListingPage.getAccountNo(),TestDataHandler.Validation_of_Things_to_know_copy_Directory_Listing_Home_Phone_Personalisation.getContactID());
        reporter.reportLogWithScreenshot("OneView Interface has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().selectHomePhoneBadge();
        reporter.reportLogWithScreenshot("Home phone badge is Clicked");
        getHomePhonedashboard().clickManageAddOns();
        reporter.reportLogWithScreenshot("Manage Add ons is Clicked");
        getHomePhonedashboard().removeUnlistedNumberAddOn();
        reporter.reportLogWithScreenshot("Unlisted Number Addon Remove Clicked");
        getTVDashboardPage().clickYourChanges();
        getHomePhonedashboard().removeCallDisplayBlockAddon();
        reporter.reportLogWithScreenshot("Call Display Blocking Addon is Removed");
        getHomePhonedashboard().yourChangeContinue();
        reporter.hardAssert(getHomePhoneSelectionPage().verifyConfigureCallDisplayAndDirectoryListingHeader(),"Configure Call display And Directory Listing Page is Displayed","Failed");
        getHomePhoneSelectionPage().clickOnContinueCallDisplay();
        reporter.reportLogWithScreenshot("Continue on call Display Clicked");
        getHomePhoneSelectionPage().clickContinueDirectoryListing();
        reporter.reportLogWithScreenshot("Continue on Directory Listing is Clicked");
        getHomePhoneSelectionPage().clkContinue();
        reporter.reportLogWithScreenshot("Final Continue is Clicked on Home Phone Selection Page");
        getTVDashboardPage().immediateDateChangeOption();
        reporter.reportLogWithScreenshot("Change date Selection Modal Is Displayed");
        getTVDashboardPage().continueFromChangeDate();
        reporter.reportLogWithScreenshot("Order Review Page is Displayed");
     //   getRogersOVCheckoutPage().clkSubmit();
        reporter.reportLogWithScreenshot("Test Passed");

    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext testContext, Method method)throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
    }
    @AfterMethod(alwaysRun=true)
    public void afterTest(){

        //closeSession();
    }
}
