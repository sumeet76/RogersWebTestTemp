package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_1460_TC01_Tupelo_Internet_Downgrade_Immediate_Test extends BaseTestClass {
    @Test(groups = {"RChangeInternet","RegressionCHOV"})
    public void oneViewCH_1460_Tupelo_Internet_Downgrade_ImmediateTest() {
        //getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.tupeloDowngradeTest.accountDetails.getBan(),TestDataHandler.tupeloDowngradeTest.getContactID());
        reporter.reportLogWithScreenshot("Launched the account overview page");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard page");
        getInternetDashboardPage().clickChangePackageButton();
        reporter.reportLogWithScreenshot("Change Internet Package clicked");
        getInternetDashboardPage().clickCheckBoxSmartStream();
        reporter.reportLogWithScreenshot("Smart Stream option selected");
        getInternetDashboardPage().clickLoadOffers();
        reporter.reportLogWithScreenshot("Load offers button clicked");
        getInternetDashboardPage().selectButtonAddSmartStream();
        reporter.reportLogWithScreenshot("Lowest Internet Package selected");
        getInternetDashboardPage().clickContinueChangeInternetPackage();
        reporter.reportLogWithScreenshot("Continue clicked on change Internet Package");
        getRogersOVInstallationPage().clickInstallationCheckBox();
        reporter.reportLogWithScreenshot("Activation Check box selected successfully");
        getRogersOVInstallationPage().clickContinue();
        reporter.reportLogWithScreenshot("Continue clicked");
//        getInternetDashboardPage().clickImmediateBill();
//        reporter.reportLogWithScreenshot("Immediate option is selected for billing cycle");
//        getInternetDashboardPage().clickContinueOnSelectDateChange();
//        reporter.reportLogWithScreenshot("Continue clicked in select date pop up for next billing cycle");

//        getRogersOVOrderReviewPage().clkSubmit();
//        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
//        reporter.reportLogWithScreenshot("Order Placed");

    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","","", method);
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}



