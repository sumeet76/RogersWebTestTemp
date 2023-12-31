package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneviewCH_REG_Auto_TC052_IgniteMappedOffers_2P_ChangeTVPackage_ATL_EN extends BaseTestClass {
    @Test()
    public void oneviewCH_REG_Auto_TC052_IgniteMappedOffers_2P_ChangeTVPackage_ATL_EN(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Ignite_Mapped_Offers_2p.getAccountDetails().getBan(),TestDataHandler.Ignite_Mapped_Offers_2p.getContactID());
        reporter.reportLogWithScreenshot("Launched Account Dashboard page");
        getAccountOverViewPage().selectTVBadage();
        reporter.reportLogWithScreenshot("Launched TV Dashboard Page");
        getEnvironmentSelectionPage().selectProduction();
        reporter.reportLogWithScreenshot("Selected Production");
        getEnvironmentSelectionPage().clickProceed();
        reporter.reportLogWithScreenshot("Clicked proceed button");
        getTVDashboardPage().clickViewOffers();
        reporter.reportLogWithScreenshot("view offers link clicked");
        reporter.hardAssert(getTVDashboardPage().verifyRecommendedOffer(),"Recommended offer available ","no Recommended offer displayed");
        getTVDashboardPage().selectRecommendedOffer();
        reporter.reportLogWithScreenshot("Recommended offer selected");
        //getTVDashboardPage().clickViewDetails(TestDataHandler.Ignite_Mapped_Offers_2p.getAccountDetails().getTargetedOfferEn(),TestDataHandler.Ignite_Mapped_Offers_2p.getAccountDetails().getTargetedOfferFr());
        //reporter.reportLogWithScreenshot("click of view details of recommended offer");
        //getTVDashboardPage().clickCloseButton();
        //reporter.reportLogWithScreenshot("close view details window");
        //getTVDashboardPage().selectCampaign();
        getTVDashboardPage().selectTVPackage(TestDataHandler.Ignite_Mapped_Offers_2p.getAccountDetails().getTargetedOfferEn(),TestDataHandler.Ignite_Mapped_Offers_2p.getAccountDetails().getTargetedOfferFr());
        reporter.reportLogWithScreenshot("recommended offer TV Package selected");
        getTVDashboardPage().clickContinueChangeTVPackage();
        reporter.reportLogWithScreenshot("click continue");
        getTVDashboardPage().clickExchangeNow();
        reporter.reportLogWithScreenshot("click Exchange Now");
        getTVDashboardPage().clickFirstChannelToRemove();
        reporter.reportLogWithScreenshot("first channel to be removed is clicked");
        getTVDashboardPage().clickSelectChannelRemove();
        reporter.reportLogWithScreenshot("first channel is removed");
        getTVDashboardPage().clickSecondChannelToRemove();
        reporter.reportLogWithScreenshot("Second channel to be removed is clicked");
        getTVDashboardPage().clickSelectChannelRemove();
        reporter.reportLogWithScreenshot("second channel is removed");
        getTVDashboardPage().clickFirstChannelToAdd();
        reporter.reportLogWithScreenshot("First channel to be added is clicked ");
        getTVDashboardPage().clickSelectChannelAdd();
        reporter.reportLogWithScreenshot("First channel is added");
        getTVDashboardPage().clickSecondChannelToAdd();
        reporter.reportLogWithScreenshot("Second channel to be added is clicked");
        getTVDashboardPage().clickSelectChannelAdd();
        getTVDashboardPage().clickContinueBottomOfPage();
        reporter.reportLogWithScreenshot("clicked continue");
       // getTVDashboardPage().clickReviewedAllIssuesWithCustomer();
        //reporter.reportLogWithScreenshot("click link reviewed all issues with customer");
        getTVDashboardPage().clickThemepacksTab();
        reporter.reportLogWithScreenshot("click Theme pack Tab");
        getTVDashboardPage().clickContinueChangeTVPackage();
        reporter.reportLogWithScreenshot("click Continue");
        getTVDashboardPage().clickNoTheyDont();
        reporter.reportLogWithScreenshot("click No they Dont pop up option");
        getTVDashboardPage().clickImmediateBill();
        reporter.reportLogWithScreenshot("click Immediate bill option ");
        getTVDashboardPage().clickContinueOnSelectDateChange();
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





