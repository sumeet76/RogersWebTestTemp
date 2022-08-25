package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
//user should
public class OneViewCH_REG_Auto_TC049_Internet_Dashboard_ISS_Cx_With_No_Pods_Agent_Adding_Max_Both_Pods_ON_EN extends BaseTestClass {
    @Test (groups = {"Regression"})
    public void oneViewCH_REG_Auto_TC049_Internet_Dashboard_ISS_Cx_With_No_Pods_Agent_Adding_Max_Both_Pods_ON_EN() {
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.SAI_ISSCxPods.getAccountNo(),TestDataHandler.SAI_ISSCxPods.getContactID());
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("select Internet Badge");
        getInternetDashboardPage().clickAddPodsButton();
        reporter.reportLogWithScreenshot("click Add Pods Button");
        getInternetDashboardPage().clickAddToCartForPods();
        reporter.reportLogWithScreenshot("click Add To Cart For Pods");
        getInternetDashboardPage().clickPlusToAddPod();
        reporter.reportLogWithScreenshot("click Plus To Add Pod");
        reporter.hardAssert(getInternetDashboardPage().verifyMaximumLimitReached(),"maximum limit reached appeared","maximum limit reached did not appeared");
        reporter.hardAssert(getInternetDashboardPage().verifyRestricted(),"Restricted appeared","Restricted did not appeared");
        getInternetDashboardPage().clickAddToCartForPods();
        reporter.reportLogWithScreenshot("click Add To Cart For Pods");
        reporter.hardAssert(getInternetDashboardPage().verifySecondMaximumLimitReached(),"Second maximum limit reached appeared","Second maximum limit reached did not appeared");
        getInternetDashboardPage().clickContinueButton();
        reporter.reportLogWithScreenshot("click Continue Button");
        reporter.hardAssert(getInternetDashboardPage().verifyInstallationOption(),"InstallationOption appeared","InstallationOption did not appeared");
        getInternetDashboardPage().clickCustomerUnderstandCheckbox();
        reporter.reportLogWithScreenshot("click Customer Understand Checkbox");
        getInternetDashboardPage().clickContinueButton();
        reporter.reportLogWithScreenshot("click Continue Button");
        getRogersOVOrderReviewPage().clickSubmitOrder();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");


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