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
    public void OneviewCH_Auto_TC110_OVS4_Migration_3P_GPON_ATL_OffersPage_ValidateSymmetricalTiersforCx_ATL_EN_Test(){
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
        getRogersIgniteBundlesPage().clickViewDetails();
        reporter.reportLogWithScreenshot("View Details Clicked");
        getRogersIgniteBundlesPage().clkExpandPackageDetails();
        reporter.reportLogWithScreenshot("Expand Package Details");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyDownloadAndUploadSpeed(),"Download and upload speed symmetrical"," Download and upload speed not symmetrical");
        reporter.reportLogWithScreenshot("Download and Upload speed validated");
        getRogersIgniteBundlesPage().clkCloseBtn();
        reporter.reportLogWithScreenshot("select first package to add in cart");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("review terms and condition");
        getRogersIgniteBundlesPage().goToPageBottom();
        getRogersIgniteBundlesPage().clickTermsAndConditionsCheckbox();
        reporter.reportLogWithScreenshot("points to mention");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
        reporter.reportLogWithScreenshot("contine from terms");
        getRogersIgniteBundlesPage().scrollToContinue();
        reporter.reportLogWithScreenshot("bottom to continue");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyCartSummaryHeader(),"Cart Summary Header displayed","Cart Summary Header did not Displayed");
        getRogersIgniteBundlesPage().clickShowPriceBreakdown();
        reporter.reportLogWithScreenshot("Clicked on Show price breakdown Button");
        getRogersIgniteBundlesPage().clickViewPricingDetails();
        reporter.reportLogWithScreenshot("clicked View Pricing and Package Details");
        getRogersIgniteBundlesPage().clkExpandPackageDetails();
        reporter.reportLogWithScreenshot("Expand Package Details");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyDownloadAndUploadSpeed(),"Download and upload speed symmetrical in Cart Summary"," Download and upload speed not symmetrical in cart summery");
        getRogersIgniteBundlesPage().clkCloseBtn();
        reporter.reportLogWithScreenshot("Download and Upload speed is validated on cart summary");
    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "", "", "", method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }

}
