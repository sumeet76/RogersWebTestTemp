package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_REG_Auto_TC102_Validate_OrderReviewPage_Existing_Free_ChargeablePods_ChangeFlow_UI_ON_EN extends BaseTestClass {
    @Test(groups = {"Regression"})
    public void oneViewCH_REG_Auto_TC102_Validate_OrderReviewPage_Existing_Free_ChargeablePods_ChangeFlow_UI_ON_EN() {
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Max2pCx_Pods.getAccountNo(),TestDataHandler.Max2pCx_Pods.getContactID());
        getAccountOverViewPage().selectInternetBadage();
        getEnvironmentSelectionPage().selectProduction();
        reporter.reportLogWithScreenshot("Selected Production");
        getEnvironmentSelectionPage().clickProceed();
        reporter.reportLogWithScreenshot("select Internet Badge");
        reporter.hardAssert(getInternetDashboardPage().verifyIgniteWiFiPod(),"Ignite WiFi Pod appeared","Ignite WiFi Pod did not appeared");
        reporter.hardAssert(getInternetDashboardPage().verifyRemovePods(),"Remove Pods appeared","Remove Pods did not appeared");
        getInternetDashboardPage().clickChangeInternetPackage();
        reporter.reportLogWithScreenshot("Change Internet Package clicked");

        reporter.reportLogWithScreenshot("Loaded Offers");
        //getInternetDashboardPage().selectInternetPlan(TestDataHandler.Max2pCx_Pods.accountDetails.getUpgradePlan());
        reporter.reportLogWithScreenshot("Another Internet Package selected");
        getInternetDashboardPage().clickContinue();
        reporter.reportLogWithScreenshot("Continue clicked on change Internet Package");
        getRogersIgniteBundlesPage().clickExchangeLater();

        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().fourKTVPopup();
        getRogersIgniteBundlesPage().contiue4KContent();

        /*Billing option to be selected*/;
        getInternetDashboardPage().clickImmediateBill();
        getInternetDashboardPage().clickContinueOnSelectDateChange();
        reporter.reportLogWithScreenshot("Continue clicked in Immediate Bill");
        /* order review verification for the existing regular and free pods.*/
        reporter.hardAssert(getRogersOVOrderReviewPage().verifyCarriedOverInternetAddon(),"Order review validation success","Order review validation failure");
        reporter.reportLogWithScreenshot("Order Review");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext
            testContext, Method method)throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
    }

    @AfterMethod(alwaysRun=true)
    public void afterTest(){
        //closeSession();
    }
}
