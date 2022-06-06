package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_17997_TC01_ValidateIgniteMappedOffers2p_TV_Test extends BaseTestClass {
    @Test()
    public void oneViewCH_Auto_17997_TC01_ValidateIgniteMappedOffers2p_TV_Test(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Ignite_Mapped_Offers_2p.getAccountDetails().getBan(),TestDataHandler.Ignite_Mapped_Offers_2p.getContactID());
        reporter.reportLogWithScreenshot("Launched Account Dashboard page");
        getAccountOverViewPage().selectTVBadage();
        reporter.reportLogWithScreenshot("Launched TV Dashboard Page");
        getTVDashboardPage().clickManageChannelsAndThemepacks();
        reporter.reportLogWithScreenshot("ManageChannels and Theme Packs button clicked");
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
        getTVDashboardPage().clickRemoveChannel();
        reporter.reportLogWithScreenshot("click Channel to removed");
        getTVDashboardPage().clickSelectChannel();
        reporter.reportLogWithScreenshot("Channel Remove selected");
        getTVDashboardPage().clickAddChannelBtn();
        reporter.reportLogWithScreenshot("click Channel to add");
        getTVDashboardPage().clickSelectChannel();
        reporter.reportLogWithScreenshot("Channel Add selected");
        getTVDashboardPage().clickContinueBottomOfPage();
        reporter.reportLogWithScreenshot("click continue");
        getTVDashboardPage().clickReviewedAllIssuesWithCustomer();
        reporter.reportLogWithScreenshot("click link reviewed all issues with customer");
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





