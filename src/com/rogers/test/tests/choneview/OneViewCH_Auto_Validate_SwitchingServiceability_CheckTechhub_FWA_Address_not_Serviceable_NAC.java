package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_Validate_SwitchingServiceability_CheckTechhub_FWA_Address_not_Serviceable_NAC extends BaseTestClass {
    @Test(groups = {"RegressionCHOV", "SanityCHOV", "SanityCHOVTemp", "MaySanity"})
    public void oneViewCH_Auto_Validate_SwitchingServiceability_CheckTechhub_FWA_Address_not_Serviceable_NAC() {
        {
            /* serviceability check to Techhub for Address_not_Serviceable_NAC */
            reporter.reportLogWithScreenshot("OneView env");
            getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
            reporter.reportLogWithScreenshot("address");
            getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress_not_Serviceable());
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyNoServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress_not_Serviceable()+" Not serviceable",TestDataHandler.anonymousData.contactDetails.getAddress_not_Serviceable2()+" is Servicable");
            reporter.reportLogWithScreenshot("No Service Availability");
            getRogersIgniteBundlesPage().clkContinue();
            getRogersIgniteBundlesPage().refreshCheckAvailability();
            reporter.reportLogWithScreenshot("address");
            getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress_not_Serviceable2());
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyNoServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress_not_Serviceable2()+" Not serviceable",TestDataHandler.anonymousData.contactDetails.getAddress_not_Serviceable2()+" is Servicable");
            reporter.reportLogWithScreenshot("No Service Availability");
            getRogersIgniteBundlesPage().clkContinue();



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
