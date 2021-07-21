package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_1641_TC01_RHP_ManageAddons_RemoveAddOns_NextBilTest extends BaseTestClass {
    @Test
    public void checkManageAddOns(){
        getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().selectHomePhoneBadge();
        reporter.reportLogWithScreenshot("Launched the Home Phone dashboard page");
        getHomePhonedashboard().clickManageAddOns();
        getHomePhoneAddonsPage().removeAddon(TestDataHandler.RHPManage_AddOns.accountDetails.getAddOnNameEn(),TestDataHandler.RHPManage_AddOns.accountDetails.getAddOnNameFr());
        reporter.reportLogWithScreenshot("Remove addon button is selected");
        getHomePhoneAddonsPage().clickConfirmButton();
        reporter.reportLogWithScreenshot("Billing selection pop up appears");
        getHomePhoneAddonsPage().clickContinueOnSelectDateChange();
        reporter.reportLogWithScreenshot("Continue clicked in select date popup for next billing cycle");
        getRogersOVOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext testContext, Method method)throws ClientProtocolException, IOException {
//xmlTestParameters=newHashMap<String,String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("QaOVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),TestDataHandler.RHPManage_AddOns.getContactID(),TestDataHandler.RHPManage_AddOns.accountDetails.getBan(),System.getenv("MaestroLoginID"),System.getenv("MaestroUsrID"),method);
    }


    @AfterMethod(alwaysRun=true)
    public void afterTest(){

        closeSession();
    }
}
