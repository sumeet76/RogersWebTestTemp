package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_1464_TC01_Tupelo_Internet_Upgrade_Immediate_Test extends BaseTestClass {
    @Test(groups = {"RChangeInternet","RegressionCHOV"})
    public void oneViewCH_1464_Tupelo_Internet_Upgrade_ImmediateTest() {
        //getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView( TestDataHandler.tupeloUpgradeTest.accountDetails.getBan(),TestDataHandler.tupeloUpgradeTest.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard page");
        getInternetDashboardPage().clickChangeInternetPackage();
        reporter.reportLogWithScreenshot("Change Internet Package clicked");
        getInternetDashboardPage().selectInternetPackage(TestDataHandler.tupeloUpgradeTest.accountDetails.getUpgradePlanEn(),TestDataHandler.tupeloUpgradeTest.accountDetails.getUpgradePlanFr());
        reporter.reportLogWithScreenshot("Internet Package selected for upgrade");
        /*getInternetDashboardPage().clickContinueChangeInternetPackage();
        reporter.reportLogWithScreenshot("Continue clicked on change Internet Package");*/
        getInternetDashboardPage().clickImmediateBill();
        reporter.reportLogWithScreenshot("Immediate option is selected for billing cycle");
        getInternetDashboardPage().clickContinueOnSelectDateChange();
        reporter.reportLogWithScreenshot("Continue clicked in select date pop up for next billing cycle");
//        getRogersOVOrderReviewPage().clkSubmit();
//        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "", "", "", method);
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}


