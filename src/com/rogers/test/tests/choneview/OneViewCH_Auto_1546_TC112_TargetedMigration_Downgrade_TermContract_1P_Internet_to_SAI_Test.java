package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_1546_TC112_TargetedMigration_Downgrade_TermContract_1P_Internet_to_SAI_Test extends BaseTestClass {
    @Test(groups = {"RegressionCHOV"})
    public void oneViewCH_1617_TC01_TargetedMigrationFlowInternetToSAIISSTest(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.IgniteMappedOffersSAItoSAI.accountDetails.getBan(),TestDataHandler.IgniteMappedOffersSAItoSAI.getContactID());
        reporter.reportLogWithScreenshot("Launched the account overview page");
        getAccountOverViewPage().selectInternetBadage();
        getEnvironmentSelectionPage().selectProduction();
        reporter.reportLogWithScreenshot("Selected Production");
        getEnvironmentSelectionPage().clickProceed();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard page");
        getAccountOverViewPage().clickViewOffers();
        reporter.reportLogWithScreenshot("click View Offers");
        getAccountOverViewPage().selectRecommendedOffer();
        reporter.reportLogWithScreenshot("select Recommended Offer");
        getAccountOverViewPage().selectFirstExclusiveOffer();
        reporter.reportLogWithScreenshot("select Exclusive Offer");
        getAccountOverViewPage().clickContinue();
        getInternetDashboardPage().clickImmediateBill();
        reporter.reportLogWithScreenshot("Immediate option is selected for billing cycle");
        getInternetDashboardPage().clickContinueOnSelectDateChange();
        reporter.reportLogWithScreenshot("Continue clicked in select date pop up for next billing cycle");
        getRogersOVOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");

    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        //closeSession();
    }
}
