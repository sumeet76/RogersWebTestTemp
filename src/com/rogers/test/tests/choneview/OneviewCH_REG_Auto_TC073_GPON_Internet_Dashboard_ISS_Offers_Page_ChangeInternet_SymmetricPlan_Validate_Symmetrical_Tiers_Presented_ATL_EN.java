package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneviewCH_REG_Auto_TC073_GPON_Internet_Dashboard_ISS_Offers_Page_ChangeInternet_SymmetricPlan_Validate_Symmetrical_Tiers_Presented_ATL_EN extends BaseTestClass {
    @Test(groups = {"RegressionCHOV"})
    public void oneviewCH_REG_Auto_TC073_GPON_Internet_Dashboard_ISS_Offers_Page_ChangeInternet_SymmetricPlan_Validate_Symmetrical_Tiers_Presented_ATL_EN(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.SAI_GPON_ATL_ValidateChangeInternetFlowSymmetricPlan.accountDetails.getBan(),TestDataHandler.SAI_GPON_ATL_ValidateChangeInternetFlowSymmetricPlan.getContactID());
        reporter.reportLogWithScreenshot("Launched the account overview page");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard page");
        getInternetDashboardPage().clickChangePackageButton();
        reporter.reportLogWithScreenshot("Change Internet Package clicked");
        getInternetDashboardPage().clickViewDetails();
        reporter.reportLogWithScreenshot("View Details Clicked");
        getInternetDashboardPage().clickPricingDetails();
        reporter.reportLogWithScreenshot("Collapse Price details");
        getInternetDashboardPage().clickPackageDetails();
        reporter.reportLogWithScreenshot("Expand Package Details");
        reporter.hardAssert(getInternetDashboardPage().verifyDownloadAndUploadSpeed(),"Download and upload speed symmetrical"," Download and upload speed not symmetrical");
        reporter.reportLogWithScreenshot("Download and Upload speed validated");
    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "", "", "", method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }

}
