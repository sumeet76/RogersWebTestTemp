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

public class OneviewCH_REG_Auto_TC008_AccountOverviewPage_ChangePaymentMethod_ON_EN extends BaseTestClass {
    @Test
    public void oneviewCH_REG_Auto_TC008_AccountOverviewPage_ChangePaymentMethod_ON_EN(){
        //Launch one view
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.ChangePaymentMethod.getAccountDetails().getBan(),TestDataHandler.ChangePaymentMethod.getContactID());
        getAccountOverViewPage().clickBillinglink();
        reporter.hardAssert(getAccountOverViewPage().verifyBillingPage(),"Billing Page is Displayed","Billing Page failed to load");
        getAccountOverViewPage().clkAutoPayLink();
        reporter.reportLogWithScreenshot("Set-up Automatic payment Popup is displayed.");
        reporter.reportLogWithScreenshot("payment method of the card is selected");
        getAccountOverViewPage().selectPaymentMethod();
        reporter.reportLogWithScreenshot("Payment method is Selected");
        getAccountOverViewPage().digtalFrontlinebtn();
        reporter.reportLogWithScreenshot("Digital Frontline radio button is clicked");
        getAccountOverViewPage().tokenFieldFiller();
        reporter.reportLogWithScreenshot("Token number is input");
        getAccountOverViewPage().SetCard(FormFiller.generateMonth(),FormFiller.generateExpiryYear());
        reporter.reportLogWithScreenshot("Card details arte input");
        getAccountOverViewPage().securityFieldFiller(FormFiller.generateCVVNumber());
        reporter.reportLogWithScreenshot("test passed");

    }

    @BeforeMethod(alwaysRun=true)
    @Parameters({"strBrowser","strLanguage"})
    public void beforeTest(@Optional("chrome")String strBrowser, @Optional("en")String strLanguage, ITestContext testContext, Method method)throws ClientProtocolException, IOException {
//xmlTestParameters=newHashMap<String,String>(testContext.getCurrentXmlTest().getAllParameters());
        startOVSession(System.getProperty("OVUrl"),strBrowser,strLanguage, RogersEnums.GroupName.connectedhome_oneview.toString().toLowerCase().trim(),"","","","",method);
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }
    }
