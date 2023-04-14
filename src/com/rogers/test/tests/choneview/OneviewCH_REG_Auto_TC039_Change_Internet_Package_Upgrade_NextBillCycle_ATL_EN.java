
package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
/*
"1. Language - EN
2. Province - ATL
3. Change Type - Change Internet.(Upgrade)
4. Add-Ons - NA
5. Bill Cycle - Next Bill Cycle"
 */
public class OneviewCH_REG_Auto_TC039_Change_Internet_Package_Upgrade_NextBillCycle_ATL_EN extends BaseTestClass {
    @Test(groups = {"Baseline","ChangePackage","RunOV1"})
    public void oneviewCH_REG_Auto_TC039_Change_Internet_Package_Upgrade_NextBillCycle_ATL_EN() {
        //getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.TC030_Internet_PackageUpgrade.accountDetails.getBan(),TestDataHandler.TC030_Internet_PackageUpgrade.getContactID());
        reporter.reportLogWithScreenshot("Launched the account overview page");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard page");
        getInternetDashboardPage().clickChangeInternetPackage();
        reporter.reportLogWithScreenshot("Change Internet Package clicked");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("Loaded Offers");
//        getInternetDashboardPage().selectUpgradeInternetPlan(TestDataHandler.TC030_Internet_PackageUpgrade.accountDetails.getUpgradeBundle(),TestDataHandler.TC030_Internet_PackageUpgrade.accountDetails.getUpgradePlanEn());
//        reporter.reportLogWithScreenshot("Higher Internet Plan selected");
        getInternetDashboardPage().selectInternetPlan(TestDataHandler.TC030_Internet_PackageUpgrade.accountDetails.getUpgradePlanEn());
        reporter.reportLogWithScreenshot("Higher Internet Package selected");
        getInternetDashboardPage().clickContinue();
        reporter.reportLogWithScreenshot("Continue clicked on change Internet Package");

        /*Billing option to be selected*/;
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
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","","", method);
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }
}


