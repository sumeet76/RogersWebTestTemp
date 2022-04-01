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

public class OneViewCH_Auto_Validation_of_Things_to_know_copy_Directory_Listing_Home_Phone_Personalisation_Page_Migration_Test extends BaseTestClass {
    @Test
    public void oneViewCH_Auto_Validation_of_Things_to_know_copy_Directory_Listing_Home_Phone_Personalisation_Page_Migration_Test(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Validation_of_Things_to_know_copy_Directory_Listing_Home_Phone_Personalisation.getAccountNo(),TestDataHandler.Validation_of_Things_to_know_copy_Directory_Listing_Home_Phone_Personalisation.getContactID());
        reporter.reportLogWithScreenshot("OneView Interface has Launched");
        getAccountOverViewPage().enterDealerCodeDialogue();
        getAccountOverViewPage().clickIgnite();
        reporter.reportLogWithScreenshot("Ignite button is clicked");
        //getRogersIgniteBundlesPage().clkUsethisAddress();
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clkContinueServiceable();
        reporter.reportLogWithScreenshot("Continue clidked on Serviceabilty modal");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        getRogersIgniteBundlesPage().clkHomePhoneCheckbox();
        reporter.reportLogWithScreenshot("Triple play selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("added to cart");
        getRogersIgniteBundlesPage().noPortInPopup();
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("review terms and condition");
        getRogersIgniteBundlesPage().reviewTermsAndCondition();
        reporter.reportLogWithScreenshot("points to mention");
        getRogersIgniteBundlesPage().clickContinueFromPointsToMention();
    //    reporter.reportLogWithScreenshot("Exchange later");
          getRogersIgniteBundlesPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("After Exchange later");
        getCustomerProfilePage().clkContinue();
        reporter.reportLogWithScreenshot("continue is clicked");
        getRogersIgniteBundlesPage().fourKTVPopup();
        reporter.reportLogWithScreenshot("4k Tv popup is displayed");
        getRogersIgniteBundlesPage().contiue4KContent();
        reporter.reportLogWithScreenshot(("Continue for4k content is clicked"));
        getRogersIgniteBundlesPage().clkContinueInternetAddon();
        reporter.reportLogWithScreenshot("Continue is clicked on Internet Addons page");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.reportLogWithScreenshot("Continue is clicked on Homephone addons page");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        reporter.reportLogWithScreenshot("Cart Summary");
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.softAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.anonymousData.contactDetails.getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),FormFiller.generateLicenseNumber("ONTARIO"));
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.anonymousData.contactDetails.getPassportNo());
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        getHomePhoneSelectionPage().clkGeneratePhoneNo();
     //   getHomePhoneSelectionPage().verifySelectedNumber();
        reporter.reportLogWithScreenshot("Phone Number Selected");
        getHomePhoneSelectionPage().clkContinueOnGeneratePhone();
        reporter.reportLogWithScreenshot("");
        getHomePhoneSelectionPage().clickOnContinueCallDisplay();
        getHomePhoneSelectionPage().verifythingsToKnowFirstname();
        reporter.reportLogWithScreenshot("Things to know Copy is displayed");
        getHomePhoneSelectionPage().verifyThingsToKnowLastName();
        reporter.reportLogWithScreenshot("things to know copy is displayed");
        getHomePhoneSelectionPage().clickContinueDirectoryListing();
     //  getHomePhoneSelectionPage().clkContinue();





    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"", "","", "", method);
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
