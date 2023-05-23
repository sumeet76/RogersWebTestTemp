package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_REG_Auto_TC098_SATV_Validation_SATV_2P_to_Bundle_2P_Offer_ON_EN extends BaseTestClass {
    @Test(groups = {"ChangePackage"})
    public void oneViewCH_Auto_SATV_Validation_SATV_2P_to_Bundle_2P_Offer_ON_EN(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.tc098_SATV2P_To_Bundle2P.accountDetails.getBan(),TestDataHandler.TC026_TVPackageUpgrade.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().selectTVBadage();
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        reporter.reportLogWithScreenshot("launch the Tv Dashboard page");
        getTVDashboardPage().clickChangePackage();
        reporter.reportLogWithScreenshot("Changed TV Package clicked");
        getTVDashboardPage().clickCheckBoxInternet();
        reporter.reportLogWithScreenshot("Internet option selected");
        getTVDashboardPage().clickLoadOffers();
        reporter.reportLogWithScreenshot("Load offers button clicked");
        getTVDashboardPage().selectTVPackage(TestDataHandler.tc098_SATV2P_To_Bundle2P.accountDetails.getUpgradePlanEn(),TestDataHandler.tc098_SATV2P_To_Bundle2P.accountDetails.getUpgradePlanFr());
        reporter.reportLogWithScreenshot("Upgrade TV Package selected");

        /*For Flex Channels - Exchange Later*/
        getTVDashboardPage().clickContinueChangeTVPackage();
        reporter.reportLogWithScreenshot("Continue clicked on change TV Package");
        getTVDashboardPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Exchange later is selected");
        getTVDashboardPage().clickContinueChannelsAndThemePacks();
        reporter.reportLogWithScreenshot("click continue at channels and themepack");
        getTVDashboardPage().clickContinueOn4kTv();
        reporter.reportLogWithScreenshot("Continue clicked on 4k TV dailog");
        getTVDashboardPage().clickContinue4kChannelPack();
        reporter.reportLogWithScreenshot("Continue clicked on 4k channels pack");
        getInternetDashboardPage().clickImmediateBill();
        reporter.reportLogWithScreenshot("Immediate Billing Cycle Selected");
        getTVDashboardPage().continueFromChangeDate();
        reporter.softAssert(getRogersOVOrderReviewPage().verifyMonthlyCharges(),"Monthly Charges Displayed","Failed to Navigate to Monthly Charges Page");
        getRogersOVOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","", "", method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
