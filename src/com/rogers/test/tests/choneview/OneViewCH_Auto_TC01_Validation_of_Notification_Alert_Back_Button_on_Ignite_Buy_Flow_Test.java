package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TC01_Validation_of_Notification_Alert_Back_Button_on_Ignite_Buy_Flow_Test  extends BaseTestClass {
    @Test
    public void validation_of_Notification_Alert_Back_Button_on_Ignite_Buy_Flow_Test(){
        reporter.reportLogWithScreenshot("oneview env");
        getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        reporter.reportLogWithScreenshot("address");
        getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.anonymousData.contactDetails.getAddress());
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
        reporter.reportLogWithScreenshot("Select Services Customer Wants");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        reporter.reportLogWithScreenshot("click TV Check box");
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("click Internet Check box");
        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        reporter.reportLogWithScreenshot("Triple Play Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("load offers");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("Added to Cart");
        getRogersIgniteBundlesPage().noPortInPopup();
//      reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue is clicked");
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        getRogersIgniteBundlesPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Exchange later is clicked");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Clicked on Continue");
        getRogersIgniteBundlesPage().fourKTVPopup();
        reporter.reportLogWithScreenshot("4k tv pop up");
        getRogersIgniteBundlesPage().fourKContinue();
        reporter.reportLogWithScreenshot("4k tv pop up continue clicked");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
    //    getRogersIgniteBundlesPage().

    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), TestDataHandler.anonymousData.contactDetails.getContactID(), "", System.getenv("MaestroLoginID"), System.getenv("MaestroUsrID"), method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
