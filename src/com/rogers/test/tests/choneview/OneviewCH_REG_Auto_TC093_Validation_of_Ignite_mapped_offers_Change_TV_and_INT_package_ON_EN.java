package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneviewCH_REG_Auto_TC093_Validation_of_Ignite_mapped_offers_Change_TV_and_INT_package_ON_EN extends BaseTestClass {
    @Test (groups = {"Regression"})
    public void oneviewCH_REG_Auto_TC093_Validation_of_Ignite_mapped_offers_Change_TV_and_INT_package_ON_EN() {
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.IgniteOffersChangeTV_INTpackage.getAccountNo(),TestDataHandler.IgniteOffersChangeTV_INTpackage.getContactID());
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("select Internet Badge");
        getAccountOverViewPage().clickViewOffers();
        reporter.reportLogWithScreenshot("click View Offers");
        getAccountOverViewPage().selectRecommendedOffer();
        reporter.reportLogWithScreenshot("select Recommended Offer");
        getAccountOverViewPage().selectFirstExclusiveOffer();
        reporter.reportLogWithScreenshot("select Exclusive Offer");
        getAccountOverViewPage().clickContinueChangePackage();
        reporter.reportLogWithScreenshot("click Continue Change Package");
        getAccountOverViewPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("click Exchange Later");
        getAccountOverViewPage().clickContinue();
        reporter.reportLogWithScreenshot("click Continue");
        getAccountOverViewPage().fourKTVPopup();
        reporter.reportLogWithScreenshot("four KTV Popup");
        getAccountOverViewPage().fourKContinue();
        reporter.reportLogWithScreenshot("four K Continue");
        getAccountOverViewPage().clickSelectChangeContinue();
        reporter.reportLogWithScreenshot("click Continue");
        reporter.hardAssert(getAccountOverViewPage().verifyReviewYourOrder(), "Review Your Order displayed", "Review Your Order did not displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyPreviousPackage(), "Previous Package displayed ", "Previous Package did not displayed");
//        reporter.hardAssert(getAccountOverViewPage().verifyTvDetails(), "Tv Details displayed", "Tv Details did not displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyNewPackage(), "New Package displayed", "New Package did not displayed");
//        reporter.hardAssert(getAccountOverViewPage().verifyNewTvDetails(), "New Tv Details displayed", "New Tv Details did not displayed");
        reporter.reportLogWithScreenshot("Is Order Review Page Title Present");
        getAccountOverViewPage().clickSubmit();
        reporter.reportLogWithScreenshot("click Submit");

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
            closeSession();
    }
}