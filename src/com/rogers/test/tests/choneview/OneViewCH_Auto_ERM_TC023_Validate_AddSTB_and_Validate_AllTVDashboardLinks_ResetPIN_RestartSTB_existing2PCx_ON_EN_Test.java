package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_ERM_TC023_Validate_AddSTB_and_Validate_AllTVDashboardLinks_ResetPIN_RestartSTB_existing2PCx_ON_EN_Test extends BaseTestClass {

//1. Maestro launched and searched Customer opened in Maestro.
//2. Environment selector page should be displayed.
//3. Account Overview Page should be displayed
//4. IPTV dashboard should be displayed
//5. Add Boxes button should be displayed and should able to add Additional STB
//6. TV Add-ons page should be displayed
//7. Installation page should be displayed as per BAU
//8. Review page should be displayed
//9. Order Confirmation page should be displayed
//10. Order should be in submmited state in Maestro
//11.Reset parental control & PINs modal should be displayed
//12. Success modal should be displayed
//13. IPTV dashboard should be displayed
//14. Refresh Ignite TV box modal should be displayed
//15. Success modal should be displayed
//16. IPTV dashboard should be displayed
@Test(groups = {"ERM"})
public void oneViewCH_Auto_ERM_TC023_Validate_AddSTB_and_Validate_AllTVDashboardLinks_ResetPIN_RestartSTB_existing2PCx_ON_EN_Test(){
    getEnvironmentSelectionPage().launchOneView( TestDataHandler.TC026_TVPackageUpgrade.accountDetails.getAddSTBban(),TestDataHandler.TC026_TVPackageUpgrade.getContactID());
    reporter.reportLogWithScreenshot("Launched the account dashboard page");
    getAccountOverViewPage().selectTVBadage();
    getEnvironmentSelectionPage().selectProduction();
    reporter.reportLogWithScreenshot("Selected Production");
    getEnvironmentSelectionPage().clickProceed();
    reporter.reportLogWithScreenshot("Clicked proceed button");
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
