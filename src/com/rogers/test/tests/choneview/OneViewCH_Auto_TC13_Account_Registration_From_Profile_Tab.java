package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_TC13_Account_Registration_From_Profile_Tab extends BaseTestClass {
    @Test
    public void accountRegistrationFromProfileTab() {
        // getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.User_New_Profile_Creation.getAccountNo(),TestDataHandler.User_New_Profile_Creation.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().clickProfileLink();
        reporter.reportLogWithScreenshot("Launched the Profile dashboard page");
        getDashboardProfilePage().clickCreateNewProfileLink();
        reporter.reportLogWithScreenshot("Clicked link to create New Profile");
        getDashboardProfilePage().enterNewEmailAddressForProfile(TestDataHandler.anonymousData.getcontactDetails().getEmail());
        reporter.reportLogWithScreenshot("Entered Email Address for New Profile Creation");
        getDashboardProfilePage().enterConfirmEmailForProfile(TestDataHandler.anonymousData.contactDetails.getConfirmEmail());
        reporter.reportLogWithScreenshot("Entered Confirm Email Address for New Profile Creation");
        //reporter.hardAssert(getDashboardProfilePage().verifyEmailAddressForNewProfileUser(TestDataHandler.anonymousData.contactDetails.getEmail(),TestDataHandler.anonymousData.contactDetails.getConfirmEmail()),"Both NewEmail and ConfirmEmail address same","Both NewEmail and ConfirmEmail address different");
        getDashboardProfilePage().clickCreateButton();
        reporter.reportLogWithScreenshot("Create button clicked");
        getDashboardProfilePage().clickCloseButton();
        reporter.reportLogWithScreenshot("Close button clicked");

    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext testContext, Method method)throws ClientProtocolException, IOException {
//xmlTestParameters=newHashMap<String,String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
    }

    @AfterMethod(alwaysRun=true)
    public void afterTest(){

        closeSession();
    }
}