package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_REG_Auto_TC103_FE_AddPods_ServeFlow_Styling_Changes_ON_EN extends BaseTestClass {
    @Test(groups = {"Regression"})
    public void oneViewCH_REG_Auto_TC103_FE_AddPods_ServeFlow_Styling_Changes_ON_EN() {
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Max2pCx_Pods.getAccountNo(),TestDataHandler.Max2pCx_Pods.getContactID());
        reporter.reportLogWithScreenshot("select Internet Badge");
        getAccountOverViewPage().selectInternetBadage();

        reporter.reportLogWithScreenshot("click AddPods Button ");
        getInternetDashboardPage().clickAddPodsButton();

        //getInternetDashboardPage().clickAddToCartForPods();
        reporter.reportLogWithScreenshot("click Add To Cart For Pods");
        getRogersIgniteBundlesPage().addPods(0);
        getInternetDashboardPage().clickPlusToAddPod();
        getRogersIgniteBundlesPage().addPods(5);
        getInternetDashboardPage().clickPlusToAddPod();
        reporter.reportLogWithScreenshot("click Plus To Add Pod");
        reporter.hardAssert(getInternetDashboardPage().verifyMaximumLimitReached(),"maximum limit reached appeared","maximum limit reached did not appeared");
        getInternetDashboardPage().clickContinueButton();
        reporter.reportLogWithScreenshot("click Continue Button");

        reporter.hardAssert(getInternetDashboardPage().verifyInstallationOption(),"InstallationOption appeared","InstallationOption did not appeared");
        reporter.hardAssert(getCreditCheckPage().verifyInstallationDesc(),"Displayed only once","Displayed twice");
        getInternetDashboardPage().clickCustomerUnderstandCheckbox();
        reporter.reportLogWithScreenshot("click Customer Understand Checkbox");
        getInternetDashboardPage().clickContinueButton();
        reporter.reportLogWithScreenshot("click Continue Button");
        getCreditCheckPage().verifyTaxTag();

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
