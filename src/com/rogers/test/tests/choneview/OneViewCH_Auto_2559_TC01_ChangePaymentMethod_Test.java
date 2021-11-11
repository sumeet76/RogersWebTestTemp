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

public class OneViewCH_Auto_2559_TC01_ChangePaymentMethod_Test extends BaseTestClass {
    @Test
    public void oneViewCH_Auto_2559_TC01_ChangePaymentMethod(){
        //Launch one view
        reporter.reportLogWithScreenshot("One view is launched");
        getEnvironmentSelectionPage().launchOneView(TestDataHandler.Change_Payment_Method.getAccountDetails().getBan(),TestDataHandler.Change_Payment_Method.getContactID());
        getAccountOverViewPage().clickBillinglink();
        reporter.hardAssert(getAccountOverViewPage().verifybillingpage(),"Billing Page is Displayed","Billing Page failed to load");
        getAccountOverViewPage().clkAutoPayLink();
        reporter.reportLogWithScreenshot("Set-up Automatic payment Popup is displayed.");
        reporter.reportLogWithScreenshot("payment method of the card is selected");
        getAccountOverViewPage().SlctPymntMthd();
        getAccountOverViewPage().DgtlFrtlnbtn();
        getAccountOverViewPage().tokenfieldfiller();
        reporter.reportLogWithScreenshot("Token number is input");
        getAccountOverViewPage().SetCard(FormFiller.generateMonth(),FormFiller.generateExpiryYear());
        getAccountOverViewPage().securityfiledfiller(FormFiller.generateCVVNumber());
       // reporter.hardAssert(getAccountOverViewPage(
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
