package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import org.testng.ITestContext;
import org.testng.annotations.*;

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
        closeSession();
    }

    @Test(groups = {"OVR", "RegressionOVR"})
    public void tc_01_OVR_Regression_SAI_Migration_1P_to_SAI_E2E() throws InterruptedException {
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"),System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");


    }

}
