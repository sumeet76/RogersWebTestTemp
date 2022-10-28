package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_REG_Auto_TC104_Validation_adding_4K_enable_changePackage_Existing_2PCx_without_4Kenable_ETE_ON_EN extends BaseTestClass {
    @Test(groups = {"RegressionCHOV"})
    public void oneViewCH_REG_Auto_TC104_Validation_adding_4K_enable_changePackage_Existing_2PCx_without_4Kenable_ETE_ON_EN() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Change_TV_Channel_Themepack_Immediate_Downgrade.accountDetails.getBan(),TestDataHandler.Change_TV_Channel_Themepack_Immediate_Downgrade.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched the internet dashboard page");
        reporter.hardAssert(getInternetDashboardPage().verifyChangePackageButtonEN()," Change package button on Internet dashboard is in English Language", "Change Package button on Internet dashboard is in French Language");
        reporter.reportLogWithScreenshot("Verified Change package button on Internet Dashboard is in English");
        getInternetDashboardPage().clickChangeInternetPackage();
        reporter.reportLogWithScreenshot("Change Internet Package clicked");
        getInternetDashboardPage().selectPlanUnderTvPackage(TestDataHandler.TC028_InternetPackageDowngrade.accountDetails.getInternetBundle(),TestDataHandler.TC028_InternetPackageDowngrade.accountDetails.getUpgradePlanEn());
        reporter.reportLogWithScreenshot("Internet Package selected for upgrade");
        getInternetDashboardPage().clickContinueChangeInternetPackage();
        getRogersIgniteBundlesPage().clickExchangeLater();
        getTVDashboardPage().clickAddChannel();
        reporter.reportLogWithScreenshot("add channel");
        getTVDashboardPage().clickThemepacksTab();
        getTVDashboardPage().addThemepack();
        reporter.reportLogWithScreenshot("add themepack");
        getCustomerProfilePage().clkContinue();
        getRogersIgniteBundlesPage().fourKTVPopup();
        getRogersIgniteBundlesPage().contiue4KContent();
        reporter.reportLogWithScreenshot("Pop for selecting billing cycle");
        getInternetDashboardPage().clickContinueOnSelectDateChange();
        reporter.reportLogWithScreenshot("Continue clicked in select date pop up for next billing cycle");

        reporter.reportLogWithScreenshot("Order Review Page");
        reporter.hardAssert(getRogersOVCheckoutPage().verifyfourKdetails(),"4K details present in order review page","4K details not present in order review page");
        getRogersOVCheckoutPage().clkSubmit();

        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.hardAssert(getRogersOVCheckoutPage().verifyfourKdetails(),"4K details present in order review page","4K details not present in order review page");
        reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","", method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}
