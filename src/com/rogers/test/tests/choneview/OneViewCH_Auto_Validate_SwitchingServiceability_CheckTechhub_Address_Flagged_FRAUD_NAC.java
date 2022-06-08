package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_Validate_SwitchingServiceability_CheckTechhub_Address_Flagged_FRAUD_NAC extends BaseTestClass {
    @Test(groups = {"RegressionCHOV", "SanityCHOV", "SanityCHOVTemp", "MaySanity"})
    public void oneViewCH_Auto_Validate_SwitchingServiceability_CheckTechhub_Address_Flagged_FRAUD_NAC() {
        {
            /* serviceability check to Techhub for Address_Flagged_FRAUD_NAC */
            reporter.reportLogWithScreenshot("OneView env");
            getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
            reporter.reportLogWithScreenshot("address");
            getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress_Flagges_Fraud());
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyFraudAddressMessage(),TestDataHandler.anonymousData.contactDetails.getAddress_Flagges_Fraud()+" Fraud Address",TestDataHandler.anonymousData.contactDetails.getAddress_Flagges_Fraud()+" not Fraud Address");
            reporter.reportLogWithScreenshot("Flagged Fraud Address");
            getRogersIgniteBundlesPage().clickOkButton();


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
