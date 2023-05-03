package com.rogers.test.tests.ovr;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OVR_Auto_TC48_MIG_Validate_LegacyCX_Move_Migration_Not_Supported_Dealer_EN_ON_Test extends BaseTestClass {
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
    public void ovr_Auto_TC48_MIG_Validate_LegacyCX_Move_Migration_Not_Supported_Dealer_EN_ON_Test()  {
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"), System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.ovrConfigData.getSspDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
        getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.ovrConfigData.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        //Legacy CX account migrating product at another address
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.tc_48_Ovr_Mig_Data_LegacyCx_Move_Migration_Not_Supported.getBanNumber(), TestDataHandler.tc_48_Ovr_Mig_Data_LegacyCx_Move_Migration_Not_Supported.getPostalCode(), TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("search for account and select environment ");
        getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("Open IgniteLink from dashboard");
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        getCheckAvailabilityPage().checkAvailabilityAtOtherAddress("642 ABANA RD. MISSISSAUGA, ON L5A1H4", "chrome");
        reporter.reportLogWithScreenshot("Service Availability");

        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMoveMigration(),"Move Migration displayed","Move Migration did not display");
        getRogersIgniteBundlesPage().clickYes();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMoveMigrationNotSupported(),"warning displayed Move Migration Not Supported",
                "warning not displayed Move Migration Not Supported");

    }
}
