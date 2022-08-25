package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_REG_Auto_TC0046_InternetDashboard_Validate_Support_Links_ON_EN extends BaseTestClass {
    @Test
    public void oneViewCH_Auto_TC01_InternetDashboard_Validate_Support_Links() {

        getEnvironmentSelectionPage().launchOneView(TestDataHandler.InternetDashboardSupportLinks.accountDetails.getBan(),TestDataHandler.InternetDashboardSupportLinks.getContactID());
        reporter.reportLogWithScreenshot("One view page launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
//        reporter.hardAssert(getAccountOverViewPage().verifySuccessfulLogin(),"Login Successful","Login Failed");
        reporter.reportLogWithScreenshot("Account Overview page has Launched");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("select Internet badge");
        getInternetDashboardPage().goToPageBottom();
        if(getInternetDashboardPage().verifLlnkLearnMoreWallToWallWifi()) {
            reporter.hardAssert(getInternetDashboardPage().verifLlnkLearnMoreWallToWallWifi(), "Link is Displayed", "Link is not displayed");
            getInternetDashboardPage().clickWalltoWallWifiLink();
            reporter.reportLogWithScreenshot("Wall to Wall Wifi link is Clicked");
        } else {
            getInternetDashboardPage().goToPageBottom();
            reporter.reportLogWithScreenshot("Wall to Wall Wifi link is not available on this account");
        }


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


