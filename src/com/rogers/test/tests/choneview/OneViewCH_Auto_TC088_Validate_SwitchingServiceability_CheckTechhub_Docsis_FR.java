package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TC088_Validate_SwitchingServiceability_CheckTechhub_Docsis_FR extends BaseTestClass {
    @Test(groups = {"RegressionCHOV", "SanityCHOV", "SanityCHOVTemp", "MaySanity"})
    public void oneViewCH_Auto_Validate_SwitchingServiceability_CheckTechhub_Docsis_FR() {
        {
            /* serviceability check to Techhub for Docsis 3P+SHA_NAC_FR*/
            reporter.reportLogWithScreenshot("OneView env");
            getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
            reporter.reportLogWithScreenshot("address");
            getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress_docsis_3P_SHA_NAC());
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress_docsis_3P_SHA_NAC()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress_docsis_3P_SHA_NAC()+" not serviceable");
            reporter.reportLogWithScreenshot("Service Availability");
            getRogersIgniteBundlesPage().clkContinue();
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
            reporter.reportLogWithScreenshot("Select Services Customer Wants");
            getRogersIgniteBundlesPage().setLanguageFrench();
            getRogersIgniteBundlesPage().clickCheckAnotherAddress();
            getRogersIgniteBundlesPage().refreshCheckAvailability();
            getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress_docsis_3P_SHA_NAC());
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress_docsis_3P_SHA_NAC()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress_docsis_3P_SHA_NAC()+" not serviceable");
            reporter.reportLogWithScreenshot("Service Availability");
            getRogersIgniteBundlesPage().clkContinue();
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
            reporter.reportLogWithScreenshot("Select Services Customer Wants");

            /* serviceability check to Techhub for Docsis 2P+SHA_NAC_FR*/
            getRogersIgniteBundlesPage().clickCheckAnotherAddress();
            getRogersIgniteBundlesPage().refreshCheckAvailability();
            getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress_docsis_2P_SHA_NAC());
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress_docsis_2P_SHA_NAC()+" is serviceable",TestDataHandler.anonymousData.contactDetails.getAddress_docsis_2P_SHA_NAC()+" not serviceable");
            reporter.reportLogWithScreenshot("Service Availability");
            getRogersIgniteBundlesPage().clkContinue();
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
            reporter.reportLogWithScreenshot("Select Services Customer Wants");

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
