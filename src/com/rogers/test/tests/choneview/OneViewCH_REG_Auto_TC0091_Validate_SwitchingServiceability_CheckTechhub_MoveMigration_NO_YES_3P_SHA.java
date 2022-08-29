package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_REG_Auto_TC0091_Validate_SwitchingServiceability_CheckTechhub_MoveMigration_NO_YES_3P_SHA extends BaseTestClass {
    @Test(groups = {"RegressionCHOV", "SanityCHOV", "SanityCHOVTemp", "MaySanity"})
    public void oneViewCH_Auto_Validate_SwitchingServiceability_CheckTechhub_MoveMigration_NO_YES_3P_SHA() {
        {
            /* serviceability check to Techhub for Move Migration_NO_3PSHA*/
            getEnvironmentSelectionPage().launchOneView(TestDataHandler.migrationData.getaccountNoMigrationNotSupported(), TestDataHandler.migrationData.getContactIDMigrationNotSupported());
            reporter.reportLogWithScreenshot("OneView Interface has Launched");
            getAccountOverViewPage().enterDealerCodeDialogue();
            reporter.reportLogWithScreenshot("click ignite");
            getAccountOverViewPage().clickIgnite();
            reporter.reportLogWithScreenshot("check availaiblity");
            getRogersIgniteBundlesPage().clickOtherAddress();
            reporter.reportLogWithScreenshot("OtherAddress");
            getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.migrationData.getAddress());
            reporter.reportLogWithScreenshot("NewAddress");
            reporter.reportLogWithScreenshot("Availability");
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyMoveMigration(),"Move Migration displayed","Move Migration did not display");
            getRogersIgniteBundlesPage().clickNo();
            reporter.reportLogWithScreenshot("click no");
            getRogersIgniteBundlesPage().clickCheckAnotherAddress();
            getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.migrationData.getAddress());
            reporter.reportLogWithScreenshot("NewAddress");
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyMoveMigration(),"Move Migration displayed","Move Migration did not display");
            getRogersIgniteBundlesPage().clickYes();
            reporter.reportLogWithScreenshot("click Yes");
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyMoveMigrationNotSupported(),"Move Migration not supported","Move Migration ");
            getRogersIgniteBundlesPage().clickOkButton();
            reporter.reportLogWithScreenshot("click ok");






        }
    }

    @BeforeMethod (alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
