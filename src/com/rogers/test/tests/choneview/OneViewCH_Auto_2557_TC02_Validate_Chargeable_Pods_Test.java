package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_2557_TC02_Validate_Chargeable_Pods_Test extends BaseTestClass {
    @Test (groups = {"Regression"})
    public void oneViewCH_Auto_2557_TC02_Validate_Chargeable_Pods_Test() {
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Chargeable_pods.getAccountNo(),TestDataHandler.Chargeable_pods.getContactID());
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("select Internet Badge");
<<<<<<< HEAD
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
        reporter.hardAssert(getAccountOverViewPage().verifyPreviousPackage(), "Review Your Order displayed ", "Review Your Order did not displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyTvDetails(), "Review Your Order displayed", "Review Your Order did not displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyNewPackage(), "Review Your Order displayed", "Review Your Order did not displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyNewTvDetails(), "Review Your Order displayed", "Review Your Order did not displayed");
        reporter.reportLogWithScreenshot("Is Order Review Page Title Present");
        getAccountOverViewPage().clickSubmit();
        reporter.reportLogWithScreenshot("click Submit");
		reporter.reportLogWithScreenshot("Order Confirmation page");





=======

        getInternetDashboardPage().clickAddPodsButton();
        reporter.reportLogWithScreenshot("click AddPods Button ");

        getInternetDashboardPage().clickAddToCartForPods();
        reporter.reportLogWithScreenshot("click Add To Cart For Pods");

        getInternetDashboardPage().clickPlusToAddPod();
        reporter.reportLogWithScreenshot("click Plus To Add Pod");

        reporter.hardAssert(getInternetDashboardPage().verifyMaximumLimitReached(),"maximum limit reached appeared","maximum limit reached did not appeared");

        getInternetDashboardPage().clickMinusToRemovePod();
        reporter.reportLogWithScreenshot("click Minus To Remove Pod");

        getInternetDashboardPage().clickContinueButton();
        reporter.reportLogWithScreenshot("click Continue Button");

        getInternetDashboardPage().clickCustomerUnderstandCheckbox();
        reporter.reportLogWithScreenshot("click Customer Understand Checkbox");

        getRogersOVOrderReviewPage().clickSubmitOrder();
        reporter.reportLogWithScreenshot("click Submit Order");
>>>>>>> master

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