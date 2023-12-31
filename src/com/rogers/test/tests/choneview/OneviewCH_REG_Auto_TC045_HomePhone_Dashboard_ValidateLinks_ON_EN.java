package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneviewCH_REG_Auto_TC045_HomePhone_Dashboard_ValidateLinks_ON_EN extends BaseTestClass {
    @Test (groups = {"Regression","MaySanity"})
    public void oneviewCH_REG_Auto_TC045_HomePhone_Dashboard_ValidateLinks_ON_EN() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.RHP_Dashboard_Validation.accountDetails.getBan(), TestDataHandler.RHPManage_AddOns.getContactID());
        reporter.reportLogWithScreenshot("Launched account dashboard page");
        getAccountOverViewPage().selectHomePhoneBadge();
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        reporter.reportLogWithScreenshot("Launch Home Phone dashboard page");
        getHomePhonedashboard().clickResetVoiceMail();
        reporter.reportLogWithScreenshot("Clicked on Reset Voicemail");
        reporter.hardAssert(getHomePhonedashboard().verifyResetVoicemailPasswordImage(),"Reset Voicemail Password link works", "Reset Voicemail Password link is not working");
        getHomePhonedashboard().clickCancel();
        reporter.reportLogWithScreenshot("Closing Reset Voicemail Password image");

        getHomePhonedashboard().clickOnlineManagerInfo();
        reporter.reportLogWithScreenshot("Clicked on Online Manager Info");
        reporter.hardAssert(getHomePhonedashboard().verifyOnlineManagerImage(),"Online Manager i link works","Online Manager i link is not working");
        getHomePhonedashboard().clickCancel();
        reporter.reportLogWithScreenshot("Closing online manager image");

        getHomePhonedashboard().clickManageAddOns();
        reporter.reportLogWithScreenshot("Clicked on Manage Add-Ons");
        reporter.hardAssert(getHomePhonedashboard().verifyText(),"Manage Add Ons link works", "Manage Add Ons link is not working");
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