package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.FormFiller;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneViewCH_Auto_Validation_of_Things_to_know_copy_Directory_Listing_Home_Phone_Personalisation_Page_Serve_Flow_Test extends BaseTestClass {
    @Test
    public void oneViewCH_Auto_Validation_of_Things_to_know_copy_Directory_Listing_Home_Phone_Personalisation_Page_Serve_Flow_Test_FR() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Validation_of_Things_to_know_copy_Directory_Listing_Home_Phone_Personalisation.getAccountNo(),TestDataHandler.Validation_of_Things_to_know_copy_Directory_Listing_Home_Phone_Personalisation.getContactID());
        reporter.reportLogWithScreenshot("OneView Interface has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().setLanguageFrench();
        getAccountOverViewPage().selectHomePhoneBadge();
        reporter.reportLogWithScreenshot("Home phone badge is clicked");
        getHomePhonedashboard().clickManageAddOns();
        reporter.reportLogWithScreenshot("Manage Add ons is clicked");
        getHomePhonedashboard().removeUnlistedNumberAddOn();
        getHomePhonedashboard().yourChangeContinue();
     //   getTVDashboardPage().yourChangeContinue();
    //    getHomePhonedashboard().clickContinue();
        getCustomerProfilePage().goToTheBottom();
        getHomePhoneSelectionPage().verifythingsToKnowFirstname();
        reporter.reportLogWithScreenshot("verified thing to know copy for First name");
        getHomePhoneSelectionPage().verifyThingsToKnowLastName();
        reporter.reportLogWithScreenshot("verified thing to know copy for Last name");
      //  getHomePhoneSelectionPage().clickContinueDirectoryListing();
      //  getRogersIgniteBundlesPage().clkContinue();
      //  reporter.reportLogWithScreenshot("Continue clicked on the Directory lis ting section");
      //  getRogersIgniteBundlesPage().clkContinue();
      //  getCustomerProfilePage().goToTheBottom();
      //  reporter.reportLogWithScreenshot("Continue clicked after Directory listing copy verified");
        //   getInternetDashboardPage().selectRadioImmediate();
      //  reporter.reportLogWithScreenshot("Select change date pop up is displayed");
      //  getInternetDashboardPage().clickContinueOnSelectDateChange();
        //   getHomePhoneSelectionPage().clkContinue();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
