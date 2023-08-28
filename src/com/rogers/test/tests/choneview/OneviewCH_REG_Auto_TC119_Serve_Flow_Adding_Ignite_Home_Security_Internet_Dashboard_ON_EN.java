package com.rogers.test.tests.choneview;

import com.aventstack.extentreports.model.Report;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneviewCH_REG_Auto_TC119_Serve_Flow_Adding_Ignite_Home_Security_Internet_Dashboard_ON_EN extends BaseTestClass {
    @Test (groups = {"Regression"})
    public void oneviewCH_REG_Auto_TC119_Serve_Flow_Adding_Ignite_Home_Security_Internet_Dashboard_ON_EN() {
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Serve_Adding_Ignite_HomeSecurity.getAccountNo(),TestDataHandler.Serve_Adding_Ignite_HomeSecurity.getContactID());
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("select Internet Badge");
        getEnvironmentSelectionPage().selectProduction();
        reporter.reportLogWithScreenshot("Selected Production");
        getEnvironmentSelectionPage().clickProceed();
        reporter.reportLogWithScreenshot("click Proceed");
        getInternetDashboardPage().selectIgniteSelfProtect();
        reporter.reportLogWithScreenshot("click on Add Ignite Self Protect");
        getInternetDashboardPage().selectAddToCart();
        reporter.reportLogWithScreenshot("click on Add to cart to add self ignite protect");
        getInternetDashboardPage().clickContinue();
        reporter.reportLogWithScreenshot("click on Continue");
        getInternetDashboardPage().goToPageBottom();
        reporter.reportLogWithScreenshot("go to the bottom of page");
        getInternetDashboardPage().clickContinue();
        reporter.reportLogWithScreenshot(" Click Continue on Ignite Home Security Add-ons");
        getRogersOVInstallationPage().clkCourierDelivery();
        reporter.reportLogWithScreenshot(" Click on Ignite Express Setup- Courier Delivery");
        getRogersOVInstallationPage().clickInstallationCheckBox();
        reporter.reportLogWithScreenshot("Activation checkbox selected successfully");
        getRogersOVInstallationPage().clickContinue();
        reporter.reportLogWithScreenshot("click on Continue button from Installation page");
        reporter.hardAssert(getAccountOverViewPage().verifyReviewYourOrder(), "Review Your Order displayed", "Review Your Order did not displayed");
        reporter.reportLogWithScreenshot("Is Order Review Page Title Present");
//        getAccountOverViewPage().clickSubmit();
//        reporter.reportLogWithScreenshot("click Submit");
//
//        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
//        reporter.reportLogWithScreenshot("Order Placed");

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