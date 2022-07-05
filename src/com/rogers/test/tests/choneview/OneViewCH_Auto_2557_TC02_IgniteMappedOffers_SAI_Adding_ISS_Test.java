package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_2557_TC02_IgniteMappedOffers_SAI_Adding_ISS_Test extends BaseTestClass {
    @Test (groups = {"Regression"})
    public void oneViewCH_Auto_2557_TC02_IgniteMappedOffers_SAI_Adding_ISS_Test() {
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.IgniteOffers_SAI_Adding_ISS.getAccountNo(),TestDataHandler.IgniteOffers_SAI_Adding_ISS.getContactID());
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("select Internet Badge");
        getAccountOverViewPage().clickViewOffers();
        reporter.reportLogWithScreenshot("click View Offers");
        getAccountOverViewPage().selectRecommendedOffer();
        reporter.reportLogWithScreenshot("select Recommended Offer");
        getAccountOverViewPage().selectFirstExclusiveOffer();
        reporter.reportLogWithScreenshot("select Exclusive Offer");

        getAccountOverViewPage().clickContinue();
        reporter.reportLogWithScreenshot("click Continue");
        getRogersOVInstallationPage().clkCourierDelivery();
        getCreditCheckPage().clickInPersonDelivery();
        reporter.reportLogWithScreenshot("click Authorize");
        getAccountOverViewPage().clickContinue();
        reporter.reportLogWithScreenshot("click Continue");
//        getAccountOverViewPage().IsOrderReviewPageTitlePresent();
        reporter.reportLogWithScreenshot("Is Order Review Page Title Present");
        reporter.reportLogWithScreenshot("click Submit");
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