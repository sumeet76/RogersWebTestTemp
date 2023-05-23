package com.rogers.test.tests.connectedhome.desktop.nac;

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
 * <p>
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
 **/

public class RogersCH_Auto_TC056_IgniteNAC_CartAbandon_CancelCartatProfileCreationPage_StartOver_newBeforeYouGoModal_saveCartAndRetrieve_ATLTest extends BaseTestClass {

    @Test(groups = {"RegressionCH", "RogersCartAbandon", "BundlesNAC"})
    public void rogersCH_Auto_TC056_IgniteNAC_CartAbandon_CancelCartatProfileCreationPage_StartOver_newBeforeYouGoModal_saveCartAndRetrieve_ATL() {
        getDriver().get(System.getProperty("QaUrl")+"/bundles?setprovince=NB");
        reporter.reportLogWithScreenshot("Launched the IgniteTV page for NB region");
        getRogersHomePage().clkServiceability();
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        String strAddressLine1 = TestDataHandler.tc25_IgniteServiceabilityAddressNB.getAccountDetails().getAddress().get("line1");
        String strAddressLine2 = TestDataHandler.tc25_IgniteServiceabilityAddressNB.getAccountDetails().getAddress().get("line2");

        getRogersHomePage().setIgniteAddressLookup(strAddressLine1 + ", " + strAddressLine2);
        reporter.reportLogWithScreenshot("Address entered");
        getRogersHomePage().clkIgniteAddressLookupSubmit();

        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyOffersPage(), "Offers Page has launched", "Offers Page has not launched");
        getRogersIgniteTVBuyPage().clkHomephone();

       // getRogersIgniteTVBuyPage().selectStarterPackageMonthToMonthTypeOfContract();
       // reporter.reportLogWithScreenshot("Selected month-to-month term contract");
        getRogersIgniteTVBuyPage().selectSolarisStarterPackage();

        reporter.hardAssert(getRogersHomePhoneSelectionPage().verifyPortInOutPage(), "Port-InOut page has Launched", "Port-InOut page has not Launched");
        reporter.reportLogWithScreenshot("Launched the home phone selection page");
        getRogersHomePhoneSelectionPage().clkSkipforNewNumber();
        reporter.reportLogWithScreenshot("Launched the Home phone add-on page");
        getRogersIgniteTVBuyPage().clkHomePhone();

        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(), "4KTV radio button is availabe", "4KTV radio button is not availabe");
        reporter.reportLogWithScreenshot("Launched the cart summary page");
        getRogersIgniteTVBuyPage().set4KTV();
        reporter.reportLogWithScreenshot("4k TV selected");
        getRogersIgniteTVBuyPage().clkCheckout();

        reporter.hardAssert(getRogersIgniteTVProfileCreationPage().verifyProfilePage(), "Profile page has Launched", "Profile page has not Launched");
        reporter.reportLogWithScreenshot("Launched the create profile page");
        getRogersIgniteTVProfileCreationPage().setEmail();
        getRogersIgniteTVProfileCreationPage().setFirstname();
        getRogersIgniteTVProfileCreationPage().setLastName();
        getRogersIgniteTVProfileCreationPage().setPhone();
        reporter.reportLogWithScreenshot("Entered the details on Profile page");
        getRogersIgniteTVProfileCreationPage().clkSubmitCancel();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyEmailModal(), "Email Modal is availabe", "EmailModal is not availabe");
        reporter.reportLogWithScreenshot("Launched the Email Modal");
        getRogersIgniteTVBuyPage().clickStartOver();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyOffersPage(), "Offers Page has launched", "Offers Page has not launched");
    }


    @BeforeMethod(alwaysRun = true)
    @Parameters({"strBrowser", "strLanguage"})
    //legacyAnonymous
    public void beforeTest(@Optional("chrome") String strBrowser, @Optional("en") String strLanguage, ITestContext testContext, Method method) throws ClientProtocolException, IOException {
        startSession(System.getProperty("QaUrl"), strBrowser, strLanguage, RogersEnums.GroupName.connectedhome_igniteanonymous, method);
        // xmlTestParameters = new HashMap<String, String>(testContext.getCurrentXmlTest().getAllParameters());
    }


    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        closeSession();
    }


}


