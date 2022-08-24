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

public class OneviewCH_REG_Auto_TC074_NegativeScenario_NFDB_NAC_2P_Blacklisted_Cx_Validate_Fraud_Error_Message_ON_EN extends BaseTestClass {
    @Test(groups = "")
    public void oneviewCH_REG_Auto_TC074_NegativeScenario_NFDB_NAC_2P_Blacklisted_Cx_Validate_Fraud_Error_Message_ON_EN(){
        reporter.reportLogWithScreenshot("oneview env");
        getEnvironmentSelectionPage().selectOneViewEnv(System.getProperty("OneViewEnv"));
        reporter.reportLogWithScreenshot("address");
        getRogersIgniteBundlesPage().checkAvailability(TestDataHandler.GponData.getcontactDetails().getAddress());
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyServiceAvailabilityMessage(),TestDataHandler.GponData.contactDetails.getAddress()+" is serviceable",TestDataHandler.GponData.contactDetails.getAddress()+" not serviceable");
        reporter.reportLogWithScreenshot("Service Availability");
        getRogersIgniteBundlesPage().clkContinue();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyAvailableServicesCheckboxes(),"Select Services Customer Wants Displayed","Select Services Customer Wants did not Displayed");
        reporter.reportLogWithScreenshot("Select Services Customer Wants");
        getRogersIgniteBundlesPage().clkTVCheckbox();
        getRogersIgniteBundlesPage().clkInternetCheckbox();
        reporter.reportLogWithScreenshot("Internet & TV Selected");
        getRogersIgniteBundlesPage().clkLoadOffers();
        reporter.reportLogWithScreenshot("offers loading");
        getRogersIgniteBundlesPage().clickViewDetails();
        reporter.reportLogWithScreenshot("Package Details");
        getRogersIgniteBundlesPage().clkExpandPackageDetails();
        reporter.reportLogWithScreenshot("Package details section expanded");
       // reporter.hardAssert(getTVDashboardPage().verifyDownloadAndUploadSpeed(),"Download and upload speed symmetrical"," Download and upload speed not symmetrical");
        getRogersIgniteBundlesPage().clkCloseBtn();
        reporter.reportLogWithScreenshot("View details modal closed");
        getRogersIgniteBundlesPage().clickFirstAddToCart();
        reporter.reportLogWithScreenshot("added to cart");
        getRogersIgniteBundlesPage().noPortInPopup();
        reporter.reportLogWithScreenshot("no Port In Popup");
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyMonthlyFeesInCollapsible(),"Monthly Fees Displayed","Monthly Fees did not Displayed");
        reporter.reportLogWithScreenshot("Product in cart");
        getRogersIgniteBundlesPage().clkCollapse();
        reporter.hardAssert(getRogersIgniteBundlesPage().verifyProductinCart(),"Product Added to Cart","Failed");
        reporter.reportLogWithScreenshot("Product Added");
        getRogersIgniteBundlesPage().clkContinue();
        getRogersIgniteBundlesPage().clkExpressCheckOut();
        getRogersIgniteBundlesPage().fourKTVPopup();
        getRogersIgniteBundlesPage().fourKContentPopup();
        reporter.reportLogWithScreenshot("CheckOut for Exchange channels");
        //reporter.hardAssert(getRogersIgniteBundlesPage().verifyPersonalizeYourChannels(),"Personalize You Channel displayed","Personalize You Channel did not Displayed");
        reporter.reportLogWithScreenshot("Cart Summary");
       // reporter.hardAssert(getRogersIgniteBundlesPage().verifyFibreActivationMSg(),"CUSTOMER WILL BE ACTIVATED ON FIBRE Msg shown","CUSTOMER WILL BE ACTIVATED ON FIBRE did not Displayed");
        getRogersIgniteBundlesPage().clkCheckOutforCartSummary();
        getRogersIgniteBundlesPage().customerWishtoContinue();
        reporter.hardAssert(getCustomerProfilePage().verifyCustomerProfile(),"Customer Profile","Failed");
        reporter.reportLogWithScreenshot("Customer Profile");
        getCustomerProfilePage().clkContinue();

        reporter.hardAssert(getCreditCheckPage().verifyCreditEvaluationHeader(),"Credit Evaluation Displayed","Credit Evaluation did not Displayed");
        reporter.reportLogWithScreenshot("Credit Evaluation screen loaded");
        getCreditCheckPage().setDOB(FormFiller.generateDOBYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay());
        getCreditCheckPage().setDriversLicense(TestDataHandler.GponData.getcontactDetails().getProvince(),FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.GponData.getcontactDetails().getLicenseNo());
        getCreditCheckPage().setPassport(FormFiller.generateExpiryYear(),FormFiller.generateMonth(),FormFiller.generateCalendarDay(),TestDataHandler.GponData.getcontactDetails().getPassportNo());
        getCreditCheckPage().clkAuthorize();
        reporter.softAssert(getCreditCheckPage().verifyCreditInfo(),"Credit Check Information Entered","Credit Check Information Failed");
        reporter.reportLogWithScreenshot("Credit Check Information");
        getCreditCheckPage().clkContinue();
        reporter.hardAssert(getCreditCheckPage().verifyFraudErrorMessage(),"Fraud Error Message Displayed","Fraud Erron Message Did Not Displayed");
        reporter.reportLogWithScreenshot("Fraud Message validated");
    }
    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeMethod(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext testContext, Method method)
            throws ClientProtocolException, IOException {
        startOVSession(System.getProperty("QaOVUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),
                TestDataHandler.GponData.getcontactDetails().getContactIDGponNFDBNAC2p(), "", System.getenv("MaestroLoginID"),
                System.getenv("MaestroUsrID"), method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
}
