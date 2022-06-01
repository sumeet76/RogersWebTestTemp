package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneviewCH_Auto_TC110_OVS4_Migration_3P_GPON_ATL_OffersPage_ValidateSymmetricalTiersforCx_ATL_EN_Test extends BaseTestClass {

    @Test(groups = {"RegressionCHOV"})
    public void OneviewCH_Auto_TC110_OVS4_Migration_3P_GPON_ATL_OffersPage_ValidateSymmetricalTiersforCx_ATL_EN(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Migration_3P_GPON_ATL_OffersPage_ValidateSymmetricalTiersforCx.accountDetails.getBan(),TestDataHandler.SAI_GPON_ATL_ValidateChangeInternetFlowSymmetricPlan.getContactID());
        reporter.reportLogWithScreenshot("OneView Interface has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clkContinueServiceable();
        getRogersIgniteBundlesPage().goToPageBottom();
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        getRogersIgniteBundlesPage().clkSmartStream();
        reporter.reportLogWithScreenshot("Internet Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("load offers");
    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "", "", "", method);
    }

//    @AfterMethod(alwaysRun = true)
//    public void afterTest() {
//        closeSession();
//    }

}
