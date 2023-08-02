package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TC_OVS1_Serve_FWACx_DowngradeInternetPlan_ON_EN extends BaseTestClass {
    @Test(groups = {"Baseline","ChangePackage","RunOV1"})
    public void checkInternetPackageDowngrade() {
        //getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Serve_FWACx_DowngradeInternetPlan.accountDetails.getBan(),TestDataHandler.Serve_FWACx_DowngradeInternetPlan.getContactID());
        reporter.reportLogWithScreenshot("Launched the account overview page");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard page");
        getAccountOverViewPage().selectProduction();
        getAccountOverViewPage().clickProceed();
        getInternetDashboardPage().clickChangeInternetPackage();
        reporter.reportLogWithScreenshot("Change Internet Package clicked");
        getInternetDashboardPage().clickLoadOffers();
        reporter.reportLogWithScreenshot("Click on Load Offers");
        getInternetDashboardPage().clickSelectButtonAsPerPackageName(TestDataHandler.Serve_FWACx_DowngradeInternetPlan.accountDetails.getInternetBundle());
        reporter.reportLogWithScreenshot("Lowest Internet Package selected");
        getInternetDashboardPage().clickContinue();
        reporter.reportLogWithScreenshot("Continue clicked on change Internet Package");

        /*Billing option to be selected*/
        getInternetDashboardPage().selectRadioImmediate();
        reporter.reportLogWithScreenshot("Immediate option is selected for billing cycle");
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



