package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_REG_Auto_TC038_TV_Change_TV_Package_Upgrade_Next_Bill_Cycle_ON_EN extends BaseTestClass {
    @Test(groups = {"RchangeTv","Baseline","ChangePackage","OVSet2"})
    public void oneViewCH_REG_Auto_TC038_TV_Change_TV_Package_Upgrade_Next_Bill_Cycle_ON_EN() {
        //getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.TC026_TVPackageUpgrade.accountDetails.getBan(), TestDataHandler.TC026_TVPackageUpgrade.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        //getAccountOverViewPage().clickAccountOverview();
        //reporter.reportLogWithScreenshot("clicked on account overview arrow-down to see the customer address");
        //reporter.hardAssert(getAccountOverViewPage().verifyProvince(),"ON address displayed","ON address doesn't displayed");
        getAccountOverViewPage().clickIgniteTVBadge();
        getEnvironmentSelectionPage().selectProduction();
        getEnvironmentSelectionPage().clickProceed();
        reporter.reportLogWithScreenshot("Launched the TV dashboard page");
        //reporter.hardAssert(getTVDashboardPage().verifyChangePackage(),"Change Package Displayed","Change Package doesn't displayed");
        reporter.reportLogWithScreenshot("Click on Change Package");
        getTVDashboardPage().clickChangePackage();
        reporter.reportLogWithScreenshot("Changed TV Package clicked");
        getTVDashboardPage().selectTVPackage(TestDataHandler.TC026_TVPackageUpgrade.accountDetails.getUpgradePlanEn(),TestDataHandler.TC023_TVPackageDowngrade.accountDetails.getUpgradePlanFr());
        reporter.reportLogWithScreenshot("Upgrade TV Package selected");

        //For Flex Channels - Exchange Later
        getTVDashboardPage().clickContinueChangeTVPackage();
        reporter.reportLogWithScreenshot("Continue clicked on change TV Package");
        getTVDashboardPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Exchange later is selected");

        getTVDashboardPage().clickContinueChannelsAndThemePacks();
        getTVDashboardPage().clickContinueOn4kTv();
        reporter.reportLogWithScreenshot("Continue clicked on 4k TV dailog");
        getTVDashboardPage().clickContinue4kChannelPack();
        reporter.reportLogWithScreenshot("Continue clicked on 4k channels pack");
        reporter.reportLogWithScreenshot("Next Billing Cycle is Selected by default");
//        getTVDashboardPage().clickContinueOnSelectDateChange();
//        reporter.softAssert(getRogersOVOrderReviewPage().verifyMonthlyCharges(),"Monthly Charges Displayed","Failed to Navigate to Monthly Charges Page");
//        getRogersOVOrderReviewPage().clkSubmit();
//        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
//        reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), "" ,"", "","", method);
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }

}



