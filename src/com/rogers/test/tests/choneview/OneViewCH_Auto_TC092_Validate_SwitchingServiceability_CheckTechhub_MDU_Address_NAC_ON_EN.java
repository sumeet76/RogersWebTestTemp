package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TC092_Validate_SwitchingServiceability_CheckTechhub_MDU_Address_NAC_ON_EN extends BaseTestClass {
    @Test(groups = {"RegressionCHOV", "SanityCHOV", "SanityCHOVTemp", "MaySanity"})
    public void oneViewCH_Auto_Validate_SwitchingServiceability_CheckTechhub_MDU_Address_NAC() {
        {
            /* serviceability check to Techhub for MDU_Address */
            reporter.reportLogWithScreenshot("OneView env");
            getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
            reporter.reportLogWithScreenshot("address");
            getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress_MDU_NAC());
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyBulkAddress(),TestDataHandler.anonymousData.contactDetails.getAddress_MDU_NAC()+" MDU Address",TestDataHandler.anonymousData.contactDetails.getAddress_MDU_NAC()+" not MDU Address");
            reporter.reportLogWithScreenshot("MDU Address");
            getRogersIgniteBundlesPage().clickCancelButton();

        }
    }

    @BeforeMethod (alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactID(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
