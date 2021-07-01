package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_TC_030_Internet_PackageUpgrade_NextBillingCycleTest extends BaseTestClass {
    @Test(groups = {"Baseline","ChangePackage"})
    public void checkTVPackageDowngrade() {
        getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard page");
        getInternetDashboardPage().clickChangeInternetPackage();
        reporter.reportLogWithScreenshot("Change Internet Package clicked");
        getInternetDashboardPage().selectInternetPackage(TestDataHandler.TC030_Internet_PackageUpgrade.accountDetails.getUpgradePlanEn(),TestDataHandler.TC030_Internet_PackageUpgrade.accountDetails.getUpgradePlanFr());
        reporter.reportLogWithScreenshot("Internet Package selected for upgrade");
        getInternetDashboardPage().clickContinueChangeInternetPackage();
        reporter.reportLogWithScreenshot("Continue clicked on change Internet Package");
        getInternetDashboardPage().clickContinueOnSelectDateChange();
        reporter.reportLogWithScreenshot("Continue clicked in select date pop up for next billing cycle");
        getRogersOVOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.TC030_Internet_PackageUpgrade.getContactID(), TestDataHandler.TC030_Internet_PackageUpgrade.accountDetails.getBan(), System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}

