package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_1466_TC01_SAI_AddingSmartstream_With_Tier_Change_Test extends BaseTestClass {
    @Test(groups = {"AprilSanity","Baseline","ChangePackage"})
    public void checkAddSmartStream() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.TC032_SAI_AddingSmartStream.accountDetails.getBan(),TestDataHandler.TC032_SAI_AddingSmartStream.getContactID());
        reporter.reportLogWithScreenshot("Launched the account overview page");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard page");
        getInternetDashboardPage().clickAddSmartStream();
        reporter.reportLogWithScreenshot("Add SmartStream is clicked");
        getInternetDashboardPage().clickSelectSmartStreamChangeTier();
        reporter.reportLogWithScreenshot("Continue with smart stream selection");

        reporter.reportLogWithScreenshot("Smart Stream option selected");
        getInternetDashboardPage().clickContinueAddingStream();
        reporter.reportLogWithScreenshot("Continue clicked on Adding Stream pop up");
        getRogersOVInstallationPage().clickInstallationCheckBox();
        reporter.reportLogWithScreenshot("Activation Check box selecetd successfully");
        getRogersOVInstallationPage().clickContinue();
        reporter.reportLogWithScreenshot("Continue clicked");
////        getRogersOVOrderReviewPage().clkSubmit();
////        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
//        reporter.reportLogWithScreenshot("Order Placed");
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




