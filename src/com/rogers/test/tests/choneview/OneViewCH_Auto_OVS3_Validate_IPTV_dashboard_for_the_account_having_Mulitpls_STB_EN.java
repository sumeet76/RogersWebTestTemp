package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_OVS3_Validate_IPTV_dashboard_for_the_account_having_Mulitpls_STB_EN extends BaseTestClass {
    @Test
    public void oneViewCH_Auto_OVS3_Validate_IPTV_dashboard_for_the_account_having_Mulitpls_STB_EN(){
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.IPTVDasboad_MulitplsSTB.getAccountNo(),TestDataHandler.IPTVDasboad_MulitplsSTB.getContactID());
        getAccountOverViewPage().clickIgniteTVBadge();
        reporter.reportLogWithScreenshot("select TV Badage");
//        getRogersAccountOverviewPage().scrollToBottomOfPage();
        getAccountOverViewPage().verifydisplayedMulitplsSTB();
        reporter.reportLogWithScreenshot("Test Passed");
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
