package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_2557_TC01_ChangeBillingPreferences_Test extends BaseTestClass {
    @Test
    public void oneViewCH_Auto_2557_TC01_ChangeBillingPreferences(){
        //Launch One view
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.InternetDashboardSupportLinks.getAccountDetails().getBan(),TestDataHandler.InternetDashboardSupportLinks.getContactID());
        getAccountOverViewPage().clickProfileLink();
        reporter.hardAssert(getAccountOverViewPage().verifyProfilePage(),"Profile page is displaye","profile Page is not displayed");
        reporter.reportLogWithScreenshot("Profile link is opened");
        getAccountOverViewPage().clickonBillingDropDown();
        reporter.reportLogWithScreenshot("Billing options are displayed");
        getAccountOverViewPage().clickOnlineBilling();
        reporter.reportLogWithScreenshot("Test Passed");

    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext testContext, Method method)throws ClientProtocolException, IOException {
//xmlTestParameters=newHashMap<String,String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }


}
