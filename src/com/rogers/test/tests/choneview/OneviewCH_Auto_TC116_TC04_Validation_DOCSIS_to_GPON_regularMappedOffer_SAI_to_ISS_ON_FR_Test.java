package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneviewCH_Auto_TC116_TC04_Validation_DOCSIS_to_GPON_regularMappedOffer_SAI_to_ISS_ON_FR_Test extends BaseTestClass {
    @Test()
    public void oneviewCH_Auto_TC116_TC04_Validation_DOCSIS_to_GPON_regularMappedOffer_SAI_to_ISS_ON_FR_Test(){
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.IgniteMappedOffersSAItoSAI.getAccountDetails().getBan(),TestDataHandler.IgniteMappedOffersSAItoSAI.getContactID());
        reporter.reportLogWithScreenshot("Launched Account Dashboard page");
        getAccountOverViewPage().selectInternetBadage();
        reporter.reportLogWithScreenshot("Launched TV Dashboard Page");
        getEnvironmentSelectionPage().selectProduction();
        reporter.reportLogWithScreenshot("Selected Production");
        getEnvironmentSelectionPage().clickProceed();
        reporter.reportLogWithScreenshot("Clicked proceed button");
        getInternetDashboardPage().clickViewOffers();
        // verify modal for D to G confirmation
        reporter.hardAssert(getTVDashboardPage().verifyDtoGModal(),"Docisis to GPON upgrade modal visible"," Fibre to the home available modal not visible");
        getTVDashboardPage().clickContinue();
        // select technology verification - fibre
        reporter.reportLogWithScreenshot("view offers link clicked");
        reporter.hardAssert(getInternetDashboardPage().verifyRecommendedOffer(),"Recommended offer available ","no Recommended offer displayed");

        getTVDashboardPage().selectRecommendedOffer();
        getInternetDashboardPage().selectExclusiveOfferAvailable();
        reporter.reportLogWithScreenshot("selected package");
        getInternetDashboardPage().clickContinue();
        reporter.hardAssert(getCreditCheckPage().verifyInstallationHeader(),"Installation Header Displayed","Installation Header did not Displayed");
        reporter.reportLogWithScreenshot("Installation options");
        getCreditCheckPage().goToPageBottom();
        //verify pro install. this is mandatory.
        reporter.reportLogWithScreenshot("professional installation");
        reporter.reportLogWithScreenshot("click Date Time Radio Button");
        getFulfillmentPage().clkFirstAvailableAppointment();
        reporter.reportLogWithScreenshot(".enter Text Mobile Number");
        getCreditCheckPage().enterTextMobileNumber(TestDataHandler.anonymousData.contactDetails.getPhoneNo());
        reporter.reportLogWithScreenshot(".enter Email Mail Address");
        getCreditCheckPage().enterEmailMailAddress(TestDataHandler.anonymousData.contactDetails.getEmail());
        reporter.reportLogWithScreenshot(".enter Special Instructions");
        getCreditCheckPage().enterSpecialInstructions();
        getPaymentOptionsPage().clkContinue();

        //verify customer is activate on fibre tag.
        reporter.softAssert(getRogersOVOrderReviewPage().verifyMonthlyCharges(),"Monthly Charges Displayed","Failed to Navigate to Monthly Charges Page");
        reporter.hardAssert(getRogersOVOrderReviewPage().verifyFibreActivationTag()," Fibre activation tag present","Fibre activation tag not present");
        getRogersOVOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.hardAssert(getRogersOVOrderReviewPage().verifyFibreActivationTag()," Fibre activation tag present","Fibre activation tag not present");
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
