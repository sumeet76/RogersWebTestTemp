package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TC32_SAI_AddingSmartstream_WithoutTierChange_ON_EN_Test extends BaseTestClass {
    @Test(groups = {"RAddingISS","Baseline","ChangePackage"})
    public void checkAddSmartStream() {
        //getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.TC032_SAI_AddingSmartStream.accountDetails.getBan(),TestDataHandler.TC032_SAI_AddingSmartStream.getContactID());
        reporter.reportLogWithScreenshot("Launched the account overview page");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard page");
        getEnvironmentSelectionPage().selectProduction();
        reporter.reportLogWithScreenshot("Selected Production");
        getEnvironmentSelectionPage().clickProceed();
        getInternetDashboardPage().clickChangePackageButton();
        reporter.reportLogWithScreenshot("Add SmartStream is clicked");
        getInternetDashboardPage().clickCheckBoxSmartStream();
        reporter.reportLogWithScreenshot("Smart Stream option selected");
        getInternetDashboardPage().clickLoadOffers();
        reporter.reportLogWithScreenshot("Load offers button clicked");
        getInternetDashboardPage().selectButtonAddSmartStream();
        reporter.reportLogWithScreenshot(" Smart Stream Selected");
        getInternetDashboardPage().clickContinueAddingStream();
        reporter.reportLogWithScreenshot("Continue clicked on Adding Stream pop up");
        getRogersOVInstallationPage().clkCourierDelivery();
        reporter.reportLogWithScreenshot("Select the courier delivery");
        getRogersOVInstallationPage().clickInstallationCheckBox();
        reporter.reportLogWithScreenshot("Activation Check box selected successfully");
        getRogersOVInstallationPage().clickContinue();
        reporter.reportLogWithScreenshot("Continue clicked");
        getRogersOVOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","", method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}




