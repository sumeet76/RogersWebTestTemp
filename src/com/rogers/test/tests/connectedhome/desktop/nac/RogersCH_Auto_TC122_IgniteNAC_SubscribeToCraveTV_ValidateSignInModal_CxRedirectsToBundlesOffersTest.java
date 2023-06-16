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
 * This class contains the test method to test Bundles Buy flow through crave url for Rogers.com
 * CH-17853_Anonymous CX_Validate new sign in modal and Cx is redirected to TV bundles offers page after clicking check Ignite TV+Internet bundles in the modal_cart summary_ON_CH_EN
 * @author manpreet.kaur3
 *
 * Test steps:
 * 1.Launch Rogers Crave URL in QA Env and click on subscribe now
 * 2. Validate Crave modal for sign in
 * 3. Click on Shop now
 * 4. Validate Serviceability modal
 * 5. Enter Address to check availability
 * 6. Validate Bundles page
 * 7. Add to cart the bundle
 * 8. Validate Cart Summary
 *
 **/

public class RogersCH_Auto_TC122_IgniteNAC_SubscribeToCraveTV_ValidateSignInModal_CxRedirectsToBundlesOffersTest extends BaseTestClass {

    @Test(groups = {"RegressionCH","RogersCartAbandon", "BundlesNAC"})
    public void rogersCH_Auto_TC122_IgniteNAC_SubscribeToCraveTV_ValidateSignInModal_CxRedirectsToBundlesOffers() {
        getDriver().get(System.getProperty("QaUrl")+"/crave");
        reporter.reportLogWithScreenshot("Launched the Crave TV page");
        getRogersHomePage().clkSubscribeNow();
        reporter.reportLogWithScreenshot("Clicked on Subscribe Now");
        reporter.hardAssert(getRogersHomePage().verifyCraveHeader(),"Crave Modal Verified","Crave Modal not verified");
        reporter.hardAssert(getRogersHomePage().verifySignInThroughCraveModal(),"Crave Modal Sign In Verified","Crave Modal Sign In not verified");
        getRogersHomePage().clkShopNowFromCraveModal();
        reporter.reportLogWithScreenshot("Clicked on Shop Now");
        String strAddressLine1 = TestDataHandler.tc04_08_SolarisTVAccount.getAccountDetails().getAddress().get("line1");
        String strAddressLine2 = TestDataHandler.tc04_08_SolarisTVAccount.getAccountDetails().getAddress().get("line2");reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getRogersHomePage().setIgniteAddressLookup(strAddressLine1+","+strAddressLine2);
        reporter.reportLogWithScreenshot("Serviceability check popup has displayed to check the Service availability");
        getRogersHomePage().clkIgniteAddressLookupSubmit();
        reporter.hardAssert(getRogersIgniteTVBuyPage().verifyOffersPage(),"Offers Page has launched","Offers Page has not launched");
        getRogersIgniteTVBuyPage().selectFlex20PackageMonthToMonthTypeOfContract();
        reporter.reportLogWithScreenshot("Selected month-to-month term contract");
        getRogersIgniteTVBuyPage().selectFlex20Package();
        reporter.reportLogWithScreenshot("Added to cart");
        reporter.hardAssert(getRogersIgniteTVBuyPage().verify4KTV(),"Launched the cart summary page","Cart summary page has not Launched");
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


