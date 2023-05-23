package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_REG_Auto_TC109_Add_STB_2P_ServeFlow_ON_Test extends BaseTestClass {

    @Test
    public void oneViewCH_REG_Auto_TC109_Add_STB_2P_ServeFlow_ON_Test(){
        getEnvironmentSelectionPage().launchOneView( TestDataHandler.TC026_TVPackageUpgrade.accountDetails.getAddSTBban(),TestDataHandler.TC026_TVPackageUpgrade.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().selectTVBadage();
        reporter.reportLogWithScreenshot("Launched the Internet dashboard page");
        reporter.reportLogWithScreenshot("Clicked on Add STB box");
        getTVDashboardPage().addTVBoxes();
        getTVDashboardPage().clickAddToCartForSTB();
        reporter.reportLogWithScreenshot("Clicked on Add STB box");
        getTVDashboardPage().clickPlusToAddSTB();
        reporter.reportLogWithScreenshot("Added maximum STB box");
        getRogersIgniteBundlesPage().clkContinue();
        getCreditCheckPage().verifyInstallationOption();
        reporter.reportLogWithScreenshot("installation options");
        getCreditCheckPage().selectDeliveryByAppointment();
        reporter.reportLogWithScreenshot("click Date Time Radio Button");
        getFulfillmentPage().clkFirstAvailableAppointment();
        reporter.reportLogWithScreenshot(".enter Text Mobile Number");
        getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
        reporter.reportLogWithScreenshot(".enter Email Mail Address");
        getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
        getCreditCheckPage().enterSpecialInstructions();
        reporter.reportLogWithScreenshot(".enter Special Instructions");
        getPaymentOptionsPage().clkContinue();
        reporter.reportLogWithScreenshot("click Continue Button");
        reporter.hardAssert(getRogersOVOrderReviewPage().verifyOrderReviewPage(),"order review page","waiting for order review page");
        getRogersIgniteBundlesPage().clkContinue();
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
