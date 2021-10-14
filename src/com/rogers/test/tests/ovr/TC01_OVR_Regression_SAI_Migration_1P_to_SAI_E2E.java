package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class TC01_OVR_Regression_SAI_Migration_1P_to_SAI_E2E extends BaseTestClass {
    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("OVRURL"), strBrowser, strLanguage, RogersEnums.GroupName.ovr, method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }

    @Test(groups = {"OVR", "RegressionOVR"})
    public void tc_01_OVR_Regression_SAI_Migration_1P_to_SAI_E2E() throws InterruptedException {
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"),System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspdealercode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.ovrReusableData.getBanNumber(),TestDataHandler.ovrReusableData.getPostalCode(),TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("search for account and select environment ");
        getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("Open IgniteLink from dashboard");
        getCheckAvailabilityPage().useThisAddress();
        reporter.reportLogWithScreenshot("Service Availability");
        getBundleBuilderPage().selectInternet();
        reporter.reportLogWithScreenshot("Internet Bundle Selected");
        getBundleBuilderPage().clickloadoffers();
        getBundleBuilderPage().selectFirstAddToCart();
        reporter.reportLogWithScreenshot("Product Added to Cart");
        getBundleBuilderPage().clickCheckout();
        getBundleBuilderPage().expandPointsToMentionAndContinue();
        getBundleBuilderPage().clickCheckout();
        getBundleBuilderPage().selectyescontinue();
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        System.out.println("Calendar Day Input: "+FormFiller.generateCalendarDay());
        getBundleBuilderPage().enterdateOfBirth(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());

        getBundleBuilderPage().creditevaluationAndContinue();
        //getBundleBuilderPage().generatePhonenumber();
        getBundleBuilderPage().generatephonenumberAndContinue();
        getBundleBuilderPage().clickchcbxInstallAndContinue();
//        getBundleBuilderPage().scrollAndclickcontinue();
//        getBundleBuilderPage().scrollAndclickcontinue();
        getBundleBuilderPage().billingandpaymentoptionscontinue();
        getBundleBuilderPage().orderreviewpageandcontinue();
        getBundleBuilderPage().clickchcbxSigninAgreement();



    }

}
