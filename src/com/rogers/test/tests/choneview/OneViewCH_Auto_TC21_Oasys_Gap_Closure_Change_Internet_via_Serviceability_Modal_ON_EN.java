package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TC21_Oasys_Gap_Closure_Change_Internet_via_Serviceability_Modal_ON_EN extends BaseTestClass {

    @Test(groups = {"RegressionCHOV"})
    public void oneViewCH_Auto_TC21_Oasys_Gap_Closure_Change_Internet_via_Serviceability_Modal_ON_EN () {
        // getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Oasys_Gap_Closure_Change_Internet_via_Serviceability_Model.getAccountNo(), TestDataHandler.Oasys_Gap_Closure_Change_Internet_via_Serviceability_Model.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("Ignite Link Clicked ");
        getInternetDashboardPage().clickContinue();
        reporter.reportLogWithScreenshot("Continue Button Clicked ");
        getInternetDashboardPage().clickChangeInternetPackage();
        reporter.reportLogWithScreenshot("Change InternetPackage Button Clicked ");
        getInternetDashboardPage().selectPlanUnderTvPackage(TestDataHandler.TC028_InternetPackageDowngrade.accountDetails.getInternetBundle(),TestDataHandler.TC028_InternetPackageDowngrade.accountDetails.getDowngradePlanEn());
        reporter.reportLogWithScreenshot("Lowest Internet Package selected");
        getInternetDashboardPage().clickContinueChangeInternetPackage();
        reporter.reportLogWithScreenshot("Continue Button Clicked ");
        getInternetDashboardPage().selectRadioImmediate();
        reporter.reportLogWithScreenshot("Immediately effective radio button Clicked ");
        getInternetDashboardPage().clickContinueOnSelectDateChange();
        reporter.reportLogWithScreenshot("Continue clicked in select date pop up for next billing cycle");
       // getInternetDashboardPage().selectMoreDetails();
       // reporter.reportLogWithScreenshot("Expand More Details section");
       // getInternetDashboardPage().selectSeeFullDetails();
      //  reporter.reportLogWithScreenshot("Expand See Full Details");
        getRogersOVOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");

    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(te
        // stContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","", "", method);
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
