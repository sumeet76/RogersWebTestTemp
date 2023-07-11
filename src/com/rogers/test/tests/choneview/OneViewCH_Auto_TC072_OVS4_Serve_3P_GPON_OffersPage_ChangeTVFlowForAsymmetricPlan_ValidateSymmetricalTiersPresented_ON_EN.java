package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TC072_OVS4_Serve_3P_GPON_OffersPage_ChangeTVFlowForAsymmetricPlan_ValidateSymmetricalTiersPresented_ON_EN extends BaseTestClass {
    @Test(groups = {"Regression"})
    public void oneviewCH_Auto_OVS4_Serve_3P_GPON_ON_OffersPage_ChangeTVFlowForAsymmetricPlan_ValidateSymmetricalTiersPresented() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.GPON_3P_ON_OffersPage_ChangeTVFlowForAsymmetricPlan.accountDetails.getBan(), TestDataHandler.GPON_3P_ON_OffersPage_ChangeTVFlowForAsymmetricPlan.getContactID());
        reporter.reportLogWithScreenshot("Launched account dashboard page");
        getAccountOverViewPage().selectTVBadage();
        getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        getAccountOverViewPage().clickProceed();
        reporter.reportLogWithScreenshot("Launched the TV dashboard page");
        getTVDashboardPage().clickChangePackage();
        reporter.reportLogWithScreenshot("Changed TV Package clicked");
//        getTVDashboardPage().clickContinue();
//        reporter.reportLogWithScreenshot("Click continue upgrade fiber modal");
//        getTVDashboardPage().clickRadioButtonFibre();
//        reporter.reportLogWithScreenshot("select Fibre");
//        getTVDashboardPage().clickLoadOffers();
//        reporter.reportLogWithScreenshot("Load offers button clicked");
        getTVDashboardPage().clickViewDetails(TestDataHandler.GPON_3P_ON_OffersPage_ChangeTVFlowForAsymmetricPlan.accountDetails.getDowngradePlanEn(), TestDataHandler.GPON_3P_ON_OffersPage_ChangeTVFlowForAsymmetricPlan.accountDetails.getDowngradePlanFr());
        reporter.reportLogWithScreenshot("View details button clicked");
        getTVDashboardPage().clickPackageDetailsExpander();
        reporter.reportLogWithScreenshot("Package details section expanded");
        reporter.hardAssert(getTVDashboardPage().verifyDownloadAndUploadSpeed(),"Download and upload speed symmetrical"," Download and upload speed not symmetrical");
        reporter.reportLogWithScreenshot("Download and Upload speed displayed");
        getTVDashboardPage().clickCancel();
        reporter.reportLogWithScreenshot("View details closed");
        getTVDashboardPage().selectTVPackage(TestDataHandler.GPON_3P_ON_OffersPage_ChangeTVFlowForAsymmetricPlan.accountDetails.getDowngradePlanEn(), TestDataHandler.GPON_3P_ON_OffersPage_ChangeTVFlowForAsymmetricPlan.accountDetails.getDowngradePlanFr());
        reporter.reportLogWithScreenshot("Lowest TV Package selected");
        reporter.hardAssert(getTVDashboardPage().verifyContinueAndCancelButton()," Continue and Cancel button displayed", " Continue and Cancel button not displayed");
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
