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
        getChampLoginPage().logIntoChamp(System.getenv("champLoginUserName"), System.getenv("champLoginPassword"));
        reporter.reportLogWithScreenshot("Logged into champ successfully");
        getUniLoginPage().searchWithDealerCode(TestDataHandler.IgniteOffersChangeTV_INTpackage.getSspDealerCode());
        reporter.reportLogWithScreenshot("Searching with dealer code");
       getUniLoginPage().selectSSPEnvAndSwitchWindow(TestDataHandler.IgniteOffersChangeTV_INTpackage.getSspEnvironment());
        reporter.reportLogWithScreenshot("Select SSP environment");
        getAccountSearchPage().searchForAccountAndSelectEnv(TestDataHandler.IgniteOffersChangeTV_INTpackage.getBanNumber(), TestDataHandler.IgniteOffersChangeTV_INTpackage.getPostalCode(), TestDataHandler.IgniteOffersChangeTV_INTpackage.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("search for account and select environment ");
        reporter.reportLogWithScreenshot("Account Search Page");
        // getAccountSearchPage().searchForAccount("768903215","L5A1H4");
        // getAccountSearchPage().selectNewCustomerEnv(TestDataHandler.ovrConfigData.getOvrQaEnvironment());
        reporter.reportLogWithScreenshot("QA Env selected for new customer");
        //getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
        //getAccountOverViewPage().clickProceed();
       // getOvrDashboardPage().clickIgniteLink();
        reporter.reportLogWithScreenshot("Open IgniteLink from dashboard");
    //    getAccountOverViewPage().selectProduction();
        reporter.reportLogWithScreenshot("Select Environment as Production");
      //  getAccountOverViewPage().clickProceed();
//        reporter.reportLogWithScreenshot("One view is launched");
//        getEnvironmentSelectionPage().launchOneView(TestDataHandler.IgniteOffersChangeTV_INTpackage.getAccountNo(),TestDataHandler.IgniteOffersChangeTV_INTpackage.getContactID());
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("select Internet Badge");
        getAccountOverViewPage().selectProduction();
        getAccountOverViewPage().clickProceed();
        getAccountOverViewPage().clickViewOffers();
        reporter.reportLogWithScreenshot("click View Offers");
        getAccountOverViewPage().selectRecommendedOffer();
        reporter.reportLogWithScreenshot("select Recommended Offer");
        //getRogersIgniteBundlesPage().scrolltoOffers();
        getAccountOverViewPage().selectFirstExclusiveOffer();
        reporter.reportLogWithScreenshot("select Exclusive Offer");
        getAccountOverViewPage().clickContinueChangePackage();
        reporter.reportLogWithScreenshot("click Continue Change Package");
//        getAccountOverViewPage().clickSelectChangeContinue();
//        getAccountOverViewPage().clickExchangeLater();
//        reporter.reportLogWithScreenshot("click Exchange Later");
//        getAccountOverViewPage().clickContinue();
//        reporter.reportLogWithScreenshot("click Continue");
//        getAccountOverViewPage().fourKTVPopup();
//        reporter.reportLogWithScreenshot("four KTV Popup");
//        getAccountOverViewPage().fourKContinue();
//        reporter.reportLogWithScreenshot("four K Continue");
        getAccountOverViewPage().clickSelectChangeContinue();
        reporter.reportLogWithScreenshot("click Continue");
        reporter.hardAssert(getAccountOverViewPage().verifyReviewYourOrder(), "Review Your Order displayed", "Review Your Order did not displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyPreviousPackage(), "Previous Package displayed ", "Previous Package did not displayed");
//        reporter.hardAssert(getAccountOverViewPage().verifyTvDetails(), "Tv Details displayed", "Tv Details did not displayed");
        reporter.hardAssert(getAccountOverViewPage().verifyNewPackage(), "New Package displayed", "New Package did not displayed");
//        reporter.hardAssert(getAccountOverViewPage().verifyNewTvDetails(), "New Tv Details displayed", "New Tv Details did not displayed");
        reporter.reportLogWithScreenshot("Is Order Review Page Title Present");
//        getAccountOverViewPage().clickSubmit();
//        reporter.reportLogWithScreenshot("click Submit");
//
//        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
//        reporter.reportLogWithScreenshot("Order Placed");

        getOVROrderReviewPage().clkContinue();
        reporter.reportLogWithScreenshot("Sign Agreement Page");
        reporter.hardAssert(getOVRAgreementPage().verifySignAgreementPage(), "Agreement page displayed", "Agreement page not displayed");
        getOVRAgreementPage().signAgreement();
        reporter.reportLogWithScreenshot("Back to Agreement Page");
        getOVRAgreementPage().clkAgreementCheckbox();
        getOVRAgreementPage().clkCompleteOrder();
        reporter.reportLogWithScreenshot("Order Confirmation Page");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderConfirmation(), "Order Confirmation displayed", "Order not Confirmed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyOrderNumberPresent(), "Order number successfully displayed", "Order number not displayed");
       // reporter.hardAssert(getOVROrderConfirmationPage().verifyOneTimeFees(), "One Time Fees Displayed", "One time fees not displayed");
        reporter.hardAssert(getOVROrderConfirmationPage().verifyMonthlyCharges(), "Monthly Charges displayed", "Monthly charges not displayed");

    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws IOException {
        startSession(System.getProperty("OVRURL"), strBrowser, strLanguage, RogersEnums.GroupName.ovr, method);
    }

        @AfterMethod(alwaysRun=true)
        public void afterTest(){

        closeSession();
    }
}