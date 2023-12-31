package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

//user should have any  pods
public class OneViewCH_Auto_OVS2_NAC_SAI_AddBothFreeAndChargeablePods_Test extends BaseTestClass {
    @Test (groups = {"Regression"})
    public void oneViewCH_Auto_OVS2_NAC_SAI_AddBothFreeAndChargeablePods_Test() {
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.MaxSAI_Cx_Pods.getAccountNo(),TestDataHandler.MaxSAI_Cx_Pods.getContactID());
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("select Internet Badge");
     //   reporter.hardAssert(getInternetDashboardPage().verifyIgniteWiFiPod(),"Ignite WiFi Pod appeared","Ignite WiFi Pod did not appeared");
     //   reporter.hardAssert(getInternetDashboardPage().verifyRemovePods(),"Remove Pods appeared","Remove Pods did not appeared");
        getInternetDashboardPage().clickAddPodsButton();
        reporter.reportLogWithScreenshot("click Add Pods Button ");
        getInternetDashboardPage().clickAddToCartForPods();
        reporter.reportLogWithScreenshot(" click Add To Cart For Pods");
        getInternetDashboardPage().clickPlusToAddPod();
        reporter.reportLogWithScreenshot("click Plus To Add Pod");
        reporter.hardAssert(getInternetDashboardPage().verifyMaximumLimitReached(),"maximum limit reached appeared","maximum limit reached did not appeared");
    //    reporter.hardAssert(getInternetDashboardPage().verifyRestrictedDoesNotAppear(),"Restricted appeared","Restricted did not appeared");
        getInternetDashboardPage().clickContinueButton();
        reporter.reportLogWithScreenshot("click Continue Button");
        reporter.hardAssert(getInternetDashboardPage().verifyInstallationOption(),"InstallationOption appeared","InstallationOption did not appeared");
        getInternetDashboardPage().clickCustomerUnderstandCheckbox();
        reporter.reportLogWithScreenshot("click Customer Understand Checkbox");
        getInternetDashboardPage().clickContinueButton();
        reporter.reportLogWithScreenshot("click Continue Button");
    //    reporter.hardAssert(getInternetDashboardPage().verifyOrderReview(),"OrderReview appeared","OrderReview did not appeared");

//        getRogersOVOrderReviewPage().clickSubmitOrder();
//        reporter.reportLogWithScreenshot("click Submit Order");
    }

        @BeforeMethod(alwaysRun=true)
        @Parameters({"strBrowser","strLanguage"})
        public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext
        testContext, Method method)throws ClientProtocolException, IOException {
            startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
        }

        @AfterMethod(alwaysRun=true)
        public void afterTest(){
            closeSession();
    }
}