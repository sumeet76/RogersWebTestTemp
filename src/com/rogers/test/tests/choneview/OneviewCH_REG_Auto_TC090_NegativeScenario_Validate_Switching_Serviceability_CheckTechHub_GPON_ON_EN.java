package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneviewCH_REG_Auto_TC090_NegativeScenario_Validate_Switching_Serviceability_CheckTechHub_GPON_ON_EN extends BaseTestClass {
    @Test(groups = {"RegressionCHOV", "SanityCHOV", "SanityCHOVTemp", "MaySanity"})
    public void oneviewCH_REG_Auto_TC090_NegativeScenario_Validate_Switching_Serviceability_CheckTechHub_GPON_ON_EN() {
        {
            /* serviceability check to Techhub for GPON 3P+SHA_NAC ENG*/

            getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
            getEnvironmentSelectionPage().selectProduction();
            reporter.reportLogWithScreenshot("Selected Production");
            getEnvironmentSelectionPage().clickProceed();
            reporter.reportLogWithScreenshot("Clicked proceed button");
            reporter.reportLogWithScreenshot("address");
            getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getGPON_3P_SHA_NAC());
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getGPON_3P_SHA_NAC()+" is serviceable on Fibre!",TestDataHandler.anonymousData.contactDetails.getGPON_3P_SHA_NAC()+" not serviceable");
            reporter.reportLogWithScreenshot("Service Availability");
            getRogersIgniteBundlesPage().clkContinue();
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
            reporter.reportLogWithScreenshot("Select Services Customer Wants");
            /*getRogersIgniteBundlesPage().setLanguageFrench();
            getRogersIgniteBundlesPage().clickCheckAnotherAddress();
            getRogersIgniteBundlesPage().refreshCheckAvailability();
            getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress_3P_SHA_NAC());
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.anonymousData.contactDetails.getAddress_3P_SHA_NAC()+" is serviceable on Fibre!",TestDataHandler.anonymousData.contactDetails.getAddress_3P_SHA_NAC()+" not serviceable");
            reporter.reportLogWithScreenshot("Service Availability");
            getRogersIgniteBundlesPage().clkContinue();
            reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
            reporter.reportLogWithScreenshot("Select Services Customer Wants");*/
        }
    }

    @BeforeMethod (alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage,ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactID(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }
}
