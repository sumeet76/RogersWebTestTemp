package com.rogers.test.tests.choneview;

import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

public class OneviewCH_Auto_TC115_E2E_Validation_DOCSIS_to_GPON_2p_to_2p_EN_ATL_Test extends BaseTestClass {
    @Test(groups = {"RchangeTv","Baseline","ChangePackage","OVSet2"})
    public void oneviewCH_Auto_TC115_E2E_Validation_DOCSIS_to_GPON_2p_to_2p_EN_ATL_TestN() {
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.TC026_TVPackageUpgrade.accountDetails.getBan(), TestDataHandler.TC026_TVPackageUpgrade.getContactID());
        reporter.reportLogWithScreenshot("Launched the account dashboard page");
        getAccountOverViewPage().selectTVBadage();
        reporter.reportLogWithScreenshot("Launched TV Dashboard Page");
        getEnvironmentSelectionPage().selectProduction();
        reporter.reportLogWithScreenshot("Selected Production");
        getEnvironmentSelectionPage().clickProceed();
        reporter.reportLogWithScreenshot("Launched the TV dashboard page");
        reporter.hardAssert(getTVDashboardPage().verifyChangePackage(),"Change Package Displayed","Change Package doesn't displayed");
        reporter.reportLogWithScreenshot("Click on Change Package");
        getTVDashboardPage().clickChangePackage();
        reporter.reportLogWithScreenshot("Changed TV Package clicked");
        //ToDo verify modal for D to G confirmation
        //ToDo select technology verification - fibre
        getRogersIgniteBundlesPage().clickViewDetails();
        reporter.reportLogWithScreenshot("View Details Clicked");
        getRogersIgniteBundlesPage().clkExpandPackageDetails();
        reporter.reportLogWithScreenshot("Expand Package Details");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyDownloadAndUploadSpeed(),"Download and upload speed symmetrical"," Download and upload speed not symmetrical");
        reporter.reportLogWithScreenshot("Download and Upload speed validated");
        getRogersIgniteBundlesPage().clkCloseBtn();
        getTVDashboardPage().selectTVPackage(TestDataHandler.TC026_TVPackageUpgrade.accountDetails.getUpgradePlanEn(),TestDataHandler.TC023_TVPackageDowngrade.accountDetails.getUpgradePlanFr());
        reporter.reportLogWithScreenshot("Upgrade TV Package selected");

        //For Flex Channels - Exchange Later
        getTVDashboardPage().clickContinueChangeTVPackage();
        reporter.reportLogWithScreenshot("Continue clicked on change TV Package");
        getTVDashboardPage().clickExchangeLater();
        reporter.reportLogWithScreenshot("Exchange later is selected");

        getTVDashboardPage().clickContinueChannelsAndThemePacks();
        getTVDashboardPage().clickContinueOn4kTv();
        reporter.reportLogWithScreenshot("Continue clicked on 4k TV dailog");
        getTVDashboardPage().clickContinue4kChannelPack();
        reporter.reportLogWithScreenshot("Continue clicked on 4k channels pack");
        reporter.reportLogWithScreenshot("Next Billing Cycle is Selected by default");
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
        getRogersOVOrderReviewPage().clkSubmit();
        reporter.hardAssert(getRogersOVOrderConfirmationPage().verifyOrder(),"Order Placed","Order Failed");
        reporter.reportLogWithScreenshot("Order Placed");
    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser", "strLanguage"})
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("OVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(), "" ,"", "","", method);
    }
}
