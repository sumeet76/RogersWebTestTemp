package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_OVS3_SUS_15702_TC01_Validation_Of_CallerIDChangedSuccessfully_Modal extends BaseTestClass {

    @Test (groups = {"RRhp","RegressionCHOV"})
    public void OneViewCH_Auto_OVS3_SUS_15702_TC01_Validation_Of_CallerIDChangedSuccessfully_Modal()

    {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.SUS_15702_TC01_Validation_Of_CallerID.accountDetails.getBan(), TestDataHandler.RHPManage_AddOns.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().selectHomePhoneBadge();
        reporter.reportLogWithScreenshot("Launched the Home Phone dashboard page");
        getHomePhonedashboard().clickChangeCallDisplayName();
        reporter.hardAssert(getHomePhonedashboard().verifyChangeCallNameDisplayPopUp(),"Pop Up Displayed","Pop up not loaded");
        reporter.reportLogWithScreenshot("The current caller name is "+ getHomePhonedashboard().currentCallerName());
        getHomePhonedashboard().enterCallername("name","name2");
        reporter.reportLogWithScreenshot("The new caller name are entered");
        getHomePhonedashboard().clickSubmit();
        reporter.reportLogWithScreenshot("The call display name changed successfully");
        reporter.hardAssert(getHomePhonedashboard().verifySuccess(),"Call Display name changed successfully","Call display name is not changed");
        getHomePhonedashboard().clickBackToDashboard();
        reporter.reportLogWithScreenshot("Back to Dashboard button is clicked");
        getHomePhonedashboard().clickChangeCallDisplayName();

        /*Added static wait in backToDashboard method. To wait for order closing*/
        reporter.hardAssert(getHomePhonedashboard().verifyChangeCallNameDisplayPopUp(),"Pop Up Displayed","Pop up not loaded");
        reporter.reportLogWithScreenshot("The New caller name is "+ getHomePhonedashboard().currentCallerName());

        /*To verify the pending order pop up*/
        reporter.hardAssert(getHomePhonedashboard().verifyPendingOrder(),"Call display anme changed successfully","Call display name not changed successfully");

    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext testContext, Method method)throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
    }


    @AfterMethod(alwaysRun=true)
    public void afterTest(){

        closeSession();
    }
}
