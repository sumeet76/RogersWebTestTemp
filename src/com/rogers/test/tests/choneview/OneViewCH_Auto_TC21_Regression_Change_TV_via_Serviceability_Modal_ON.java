package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TC21_Regression_Change_TV_via_Serviceability_Modal_ON extends BaseTestClass {
    @Test

    public void OneViewCH_Auto_TC21_Regression_Change_TV_via_Serviceability_Modal_ON() {

        /*getEnvironmentSelectionPage().launchOneView(TestDataHandler.ChangeTvViaServiceability.accountDetails.getBan(),TestDataHandler.ChangeTvViaServiceability.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().setSkipNotification();
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("Serviceability modal is displayed");
        getAccountOverViewPage().clickSecondAddressIfPresent();
        reporter.reportLogWithScreenshot("Bundle change section is displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyBundleChangeSection(),"Bundle change option is dispalyed","Bundle change option is not displayed");
        getAccountOverViewPage().clickTVCheckbox();
        getAccountOverViewPage().clickContinue();
        reporter.hardAssert(getTVDashboardPage().verifyHeader(),"TV Dashboard launched successfully","Tv dashboard not launched successfully");
        reporter.reportLogWithScreenshot("Tv Dashboard page");

        getTVDashboardPage().clickChangePackage();
        reporter.reportLogWithScreenshot("Changed TV Package clicked");
        getTVDashboardPage().selectFirstTVPackage();
        reporter.reportLogWithScreenshot("TV Package selected");*/

        /*For Flex Channels - Exchange Later*/
        /*getTVDashboardPage().clickContinueChangeTVPackage();
        reporter.reportLogWithScreenshot("Continue clicked on change TV Package");
        getTVDashboardPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Exchange later is selected");

        getTVDashboardPage().clickContinueChannelsAndThemePacks();
        getTVDashboardPage().clickContinueOn4kTv();
        reporter.reportLogWithScreenshot("Continue clicked on 4k TV dailog");
        getTVDashboardPage().clickContinue4kChannelPack();
        reporter.reportLogWithScreenshot("Continue clicked on 4k channels pack");
        getTVDashboardPage().clickImmediateBill();
        reporter.reportLogWithScreenshot("Immediate Billing Cycle Selected");
        getTVDashboardPage().clickContinueOnSelectDateChange();
        reporter.softAssert(getRogersOVOrderReviewPage().verifyMonthlyCharges(),"Monthly Charges Displayed","Failed to Navigate to Monthly Charges Page");
//        getRogersOVOrderReviewPage().clkSubmit();
//        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");*/

        getEnvironmentSelectionPage().launchOneView(TestDataHandler.TC023_TVPackageDowngrade.getAccountDetails().getBan(), TestDataHandler.TC023_TVPackageDowngrade.getContactID());
        reporter.reportLogWithScreenshot("OneView Interface has Launched");
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().selectTVBadage();
        reporter.reportLogWithScreenshot("Launched the TV dashboard page");
        getTVDashboardPage().clickChangePackage();
        reporter.reportLogWithScreenshot("Changed TV Package clicked");
        getTVDashboardPage().selectTVPackage(TestDataHandler.TC023_TVPackageDowngrade.getAccountDetails().getDowngradePlanEn(),TestDataHandler.TC023_TVPackageDowngrade.getAccountDetails().getDowngradePlanFr());
        reporter.reportLogWithScreenshot("Lowest TV Package selected");

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
        getTVDashboardPage().clickContinueOnSelectDateChange();
        reporter.softAssert(getRogersOVOrderReviewPage().verifyMonthlyCharges(),"Monthly Charges Displayed","Failed to Navigate to Monthly Charges Page");
        getRogersOVOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrderConfirmationPageLoad(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","", "", method);
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }


}
