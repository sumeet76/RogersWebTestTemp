package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_REG_Auto_TC114_RegularTargettedOffer_ExistingCx_withoutTermOffer_SAI_to_SAI_ON_EN extends BaseTestClass {
    @Test()
    public void oneViewCH_REG_Auto_TC114_RegularTargettedOffer_ExistingCx_withoutTermOffer_SAI_to_SAI_ON_EN(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.IgniteMappedOffersSAItoSAI.getAccountDetails().getBan(),TestDataHandler.IgniteMappedOffersSAItoSAI.getContactID());
        reporter.reportLogWithScreenshot("Launched Account Dashboard page");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched TV Dashboard Page");
        getEnvironmentSelectionPage().selectProduction();
        reporter.reportLogWithScreenshot("Selected Production");
        getEnvironmentSelectionPage().clickProceed();
        reporter.reportLogWithScreenshot("Clicked proceed button");
        getInternetDashboardPage().clickViewOffers();
        reporter.reportLogWithScreenshot("view offers link clicked");
        reporter.hardAssert(getInternetDashboardPage().verifyRecommendedOffer(),"Recommended offer available ","no Recommended offer displayed");
        getTVDashboardPage().selectRecommendedOffer();
        getInternetDashboardPage().selectExclusiveOfferAvailable();
        reporter.reportLogWithScreenshot("selected package");
        getInternetDashboardPage().clickContinue();
        getInternetDashboardPage().clickImmediateBill();
        reporter.reportLogWithScreenshot("click Immediate bill option ");
        getInternetDashboardPage().clickContinueOnSelectDateChange();
        reporter.reportLogWithScreenshot("click continue");
        getRogersOVOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext
            testContext, Method method)throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
    }
    @AfterMethod(alwaysRun=true)
    public void afterTest(){
        //closeSession();
    }
}
