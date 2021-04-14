package com.rogers.test.tests.connectedhome.desktop;
import com.rogers.test.base.BaseTestClass;
import com.rogers.test.helpers.RogersEnums;
import com.rogers.testdatamanagement.TestDataHandler;
import org.apache.http.client.ClientProtocolException;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;


/**
 * This class contains the test method to test Legacy Internet Offer Buy flow for Rogers.com
 *
 * @author chinnarao.vattam
 *
 * Test steps:
 * 1.Launch Rogers SAI Tupelo URL in QA Env and click on get it now and enter address and click on continue
 * 2. Click on continue
 * 3. Choose Internet, SmartStream checkbox and click on Load offers
 * 4. Add 1 STB and click on Add to cart
 * 5. Click on Continue
 * 6. Click on Checkout
 * 7. Click on Yes, continue
 * 8. Click on Continue
 * 9. Enter DOB, valid ID details and click on continue
 * 10. Choose Installation type as enhanced self install and click on continue
 * 11. Click on Continue
 * 12. Click on Submit
 *
 **/

public class RogersCH_TC_069_CartAbandon_CancelCartatCartSummaryPage_Continue_saveCartAndRetrieveTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersCartAbandon","DryRunCH"})
    public void checkCartAbandonCancelCartatCartSummary_Continue_NewBeforeYouGoModalPage() {
        reporter.reportLogWithScreenshot("Launched the Easy Login Page");
        getRogersHomePage().clkTVBundle();
        reporter.hardAssert(getRogersHomePage().verifyIgnitepage(),"Ignite page has Launched","Ignite page has not Launched");
        reporter.reportLogWithScreenshot("Launched the IgniteTV page");
        getRogersHomePage().clkServiceability();
        reporter.reportLogWithScreenshot("Launched the customer availability check popup");
        //getRogersHomePage().clkAddressCheck();
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String  strAddressLine1=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line1");
        String  strAddressLine2=TestDataHandler.tc01_02_03_IgniteTVAccount.getAccountDetails().getAddress().get("line2");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+", "+strAddressLine2);
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.reportLogWithScreenshot("Launched the ignite-bundles page");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyBundlesPage(),"Bundles Page has launched","Bundles Page has not launched");
        getRogersIgniteTVBuyPage().clkHomephone();
        getRogersIgniteTVBuyPage().selectSolarisStarterPackageNew();
        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage() ,"Port-InOut page has Launched","Port-InOut page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersIgniteTVBuyPage().clkHomePhone();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is availabe","4KTV radio button is not availabe");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckoutCancel();

        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyEmailModal(),"Email Modal is availabe","EmailModal is not availabe");
        reporter.reportLogWithScreenshot("Launched the Email Modal");
        getRogersIgniteTVBuyPage().setEmail();
        getRogersIgniteTVBuyPage().clickEmailCheckbox();
        getRogersIgniteTVBuyPage().clickSubmit();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyConfirmation(),"Email Modal is availabe","EmailModal is not availabe");
        getRogersIgniteTVBuyPage().clickOkay();
        reporter.reportLogWithScreenshot("launched the login page");
        getDriver().get(System.getProperty("QaUrl")+"/consumer/easyloginriverpage");
        reporter.reportLogWithScreenshot("Launched the Easy Login Page");
        getRogersHomePage().clkShop();
        getRogersHomePage().clkIgniteTV();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyWelcomeBackPopup(),"Ignite page has Launched","Ignite page has not Launched");
        getRogersIgniteTVBuyPage().clickContinue();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"4KTV radio button is availabe","4KTV radio button is not availabe");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();
        //reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(),"Profile page has Launched","Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().setEmail();
        getRogersIgniteTVProfileCreationPage().setFirstname();
        getRogersIgniteTVProfileCreationPage().setLastName();
        getRogersIgniteTVProfileCreationPage().setPhone();
        getRogersIgniteTVProfileCreationPage().clkSubmitProfile();
        reporter.hardAssert(getRogersIgniteTVCreditCheckPage().verifyCreditEvalutionPage(),"Credit Evaluation page has Launched","Credit Evaluation page has not Launched");
    }


    @BeforeMethod (alwaysRun=true) @Parameters({ "strBrowser", "strLanguage"})
    //legacyAnonymous
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext,Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"),  strBrowser,strLanguage,RogersEnums.GroupName.connectedhome_igniteanonymous, method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }



}


