package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_2557_TC02_Validate_Chargeable_Pods_Test extends BaseTestClass {
    @Test (groups = {"Regression"})
    public void oneViewCH_Auto_2557_TC02_Validate_Chargeable_Pods_Test() {
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Chargeable_pods.getAccountNo(),TestDataHandler.Chargeable_pods.getContactID());
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("select Internet Badge");

        getInternetDashboardPage().clickAddPodsButton();
        reporter.reportLogWithScreenshot("select Internet Badge");

        getInternetDashboardPage().clickAddToCartForPods();
        reporter.reportLogWithScreenshot("select Internet Badge");

        getInternetDashboardPage().clickPlusToAddPod();
        reporter.reportLogWithScreenshot("select Internet Badge");

        reporter.hardAssert(getInternetDashboardPage().verifyMaximumLimitReached(),"maximum limit reached appeared","maximum limit reached did not appeared");

        getInternetDashboardPage().clickMinusToRemovePod();
        reporter.reportLogWithScreenshot("select Internet Badge");

        getInternetDashboardPage().clickContinueButton();
        reporter.reportLogWithScreenshot("select Internet Badge");

        getInternetDashboardPage().clickCustomerUnderstandCheckbox();
        reporter.reportLogWithScreenshot("select Internet Badge");

        getRogersOVOrderReviewPage().clickSubmitOrder();
        reporter.reportLogWithScreenshot("Order Confirmation page");

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